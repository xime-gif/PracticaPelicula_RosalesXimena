package com.example.practicapelicula_rosalesximena

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar variables de entrada
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)

        // Configurar evento al presionar el botón
        btnEntrar.setOnClickListener {
            // Obtener email y contraseña
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Validar que se ingresen email y contraseña
            if (email.isEmpty()) {
                etEmail.error = "Ingresa un correo"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Ingresa una contraseña"
                return@setOnClickListener
            }

            // Abrir siguiente activity si se pasan las validaciones
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()
        }


    }
}