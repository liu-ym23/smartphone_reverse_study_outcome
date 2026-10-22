package com.bytedance.realx.video;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes21.dex */
public class GlShader {
    private static final String TAG = "GlShader";
    private int program;

    public void release() {
        int r100 = this.program;
        if (r100 == (-1)) goto L6;
        GLES20.glDeleteProgram(r100);
        this.program = -1;
        return;
    }

    public void useProgram() {
        int r100 = this.program;
        if (r100 == (-1)) goto L7;
        GLES20.glUseProgram(r100);
        GlUtil.checkNoGLES2Error("glUseProgram");
        return;
    L7:
        throw new RuntimeException("The program has been released");
    }

    public int getAttribLocation(String r100) {
        int r101 = this.program;
        if (r101 == (-1)) goto L10;
        int r102 = GLES20.glGetAttribLocation(r101, r100);
        if (r102 < 0) goto L8;
        return r102;
    L8:
        throw new RuntimeException("Could not locate '" + r100 + "' in program");
    L10:
        throw new RuntimeException("The program has been released");
    }

    public int getUniformLocation(String r100) {
        int r101 = this.program;
        if (r101 == (-1)) goto L10;
        int r102 = GLES20.glGetUniformLocation(r101, r100);
        if (r102 < 0) goto L8;
        return r102;
    L8:
        throw new RuntimeException("Could not locate uniform '" + r100 + "' in program");
    L10:
        throw new RuntimeException("The program has been released");
    }

    public GlShader(String r100, String r101) {
        int r102 = compileShader(35633, r100);
        int r103 = compileShader(35632, r101);
        int r104 = GLES20.glCreateProgram();
        this.program = r104;
        if (r104 == 0) goto L11;
        GLES20.glAttachShader(r104, r102);
        GLES20.glAttachShader(this.program, r103);
        GLES20.glLinkProgram(this.program);
        int[] r105 = {0};
        GLES20.glGetProgramiv(this.program, 35714, r105, 0);
        if (r105[0] != 1) goto L8;
        GLES20.glDeleteShader(r102);
        GLES20.glDeleteShader(r103);
        GlUtil.checkNoGLES2Error("Creating GlShader");
        return;
    L8:
        GLES20.glGetProgramInfoLog(this.program);
        throw new RuntimeException(GLES20.glGetProgramInfoLog(this.program));
    L11:
        throw new RuntimeException("glCreateProgram() failed. GLES20 error: " + GLES20.glGetError());
    }

    private static int compileShader(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        if (r102 == 0) goto L11;
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        int[] r103 = {0};
        GLES20.glGetShaderiv(r102, 35713, r103, 0);
        if (r103[0] != 1) goto L8;
        GlUtil.checkNoGLES2Error("compileShader");
        return r102;
    L8:
        GLES20.glGetShaderInfoLog(r102);
        throw new RuntimeException(GLES20.glGetShaderInfoLog(r102));
    L11:
        throw new RuntimeException("glCreateShader() failed. GLES20 error: " + GLES20.glGetError());
    }

    public void setVertexAttribArray(String r100, int r101, FloatBuffer r102) {
        setVertexAttribArray(r100, r101, 0, r102);
    }

    public void setVertexAttribArray(String r100, int r110, int r111, FloatBuffer r112) {
        if (this.program == (-1)) goto L7;
        int r101 = getAttribLocation(r100);
        GLES20.glEnableVertexAttribArray(r101);
        GLES20.glVertexAttribPointer(r101, r110, 5126, false, r111, r112);
        GlUtil.checkNoGLES2Error("setVertexAttribArray");
        return;
    L7:
        throw new RuntimeException("The program has been released");
    }
}
