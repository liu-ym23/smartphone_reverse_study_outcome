package com.ss.texturerender;

import android.opengl.GLES20;
import android.opengl.GLUtils;

/* JADX INFO: loaded from: classes40.dex */
public class ShaderHelper {
    private static final String TAG = "ShaderHelper";

    public ShaderHelper() {
    }

    public static int compileShader(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        if (r102 == 0) goto L7;
        int[] r103 = new int[1];
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        GLES20.glGetShaderiv(r102, 35713, r103, 0);
        if (r103[0] != 0) goto L7;
        TextureRenderLog.e(-1, TAG, "Fail to compile shader" + GLES20.glGetShaderInfoLog(r102));
        GLES20.glDeleteShader(r102);
        r102 = 0;
    L7:
        if (r102 != 0) goto L9;
        TextureRenderLog.e(-1, TAG, "EGL Error: " + GLUtils.getEGLErrorString(GLES20.glGetError()));
    L9:
        return r102;
    }

    public static int createAndLinkProgram(int r100, int r101, String[] r102) {
        int r103 = GLES20.glCreateProgram();
        if (r103 == 0) goto L15;
        int[] r104 = new int[1];
        GLES20.glAttachShader(r103, r101);
        GLES20.glAttachShader(r103, r100);
        if (r102 == null) goto L10;
        int r105 = 0;
    L8:
        if (r105 >= r102.length) goto L10;
        GLES20.glBindAttribLocation(r103, r105, r102[r105]);
        r105 = r105 + 1;
    L10:
        GLES20.glLinkProgram(r103);
        GLES20.glGetProgramiv(r103, 35714, r104, 0);
        if (r104[0] != 0) goto L16;
        TextureRenderLog.e(-1, TAG, "Failed to compile program: " + GLES20.glGetProgramInfoLog(r103));
        GLES20.glDeleteProgram(r103);
        return 0;
    L16:
        return r103;
    L15:
        return r103;
    }
}
