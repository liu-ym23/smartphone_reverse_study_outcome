package com.ss.bytertc.engine.utils;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.GLES20;

/* JADX INFO: loaded from: classes40.dex */
public class GLUtils {
    private static int[] ctxAttr;
    private static int[] defaultEGLConfAttr;

    public GLUtils() {
    }

    public static EGLDisplay getEglDisplay() {
        EGLDisplay r100 = EGL14.eglGetDisplay(0);
        if (r100 == EGL14.EGL_NO_DISPLAY) goto L10;
        int[] r101 = new int[2];
        if (EGL14.eglInitialize(r100, r101, 0, r101, 1) == false) goto L8;
        return r100;
    L8:
        throw new RuntimeException("Unable to initialize EGL14: 0x" + Integer.toHexString(EGL14.eglGetError()));
    L10:
        throw new RuntimeException("Unable to get EGL14 display: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    static {
        defaultEGLConfAttr = new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344};
        ctxAttr = new int[]{12440, 2, 12344};
    }

    public static EGLConfig getEglConfig(EGLDisplay r100) {
        return getEglConfig(r100, defaultEGLConfAttr);
    }

    public static EGLConfig getEglConfig(EGLDisplay r110, int[] r111) {
        EGLConfig[] r100 = new EGLConfig[1];
        int[] r101 = new int[1];
        if (EGL14.eglChooseConfig(r110, r111, 0, r100, 0, 1, r101, 0) == false) goto L14;
        if (r101[0] <= 0) goto L12;
        EGLConfig r112 = r100[0];
        if (r112 == null) goto L10;
        return r112;
    L10:
        throw new RuntimeException("eglChooseConfig returned null");
    L12:
        throw new RuntimeException("Unable to find any matching EGL config");
    L14:
        throw new RuntimeException("eglChooseConfig failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    public static int loadShader(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        if (r102 == 0) goto L8;
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        int[] r103 = new int[1];
        GLES20.glGetShaderiv(r102, 35713, r103, 0);
        if (r103[0] != 0) goto L9;
        GLES20.glDeleteShader(r102);
        return 0;
    L9:
        return r102;
    L8:
        return r102;
    }

    public static EGLContext createEglContext(EGLDisplay r100, EGLConfig r101, EGLContext r102) {
        return EGL14.eglCreateContext(r100, r101, r102, ctxAttr, 0);
    }
}
