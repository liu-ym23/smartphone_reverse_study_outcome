package vqc;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;

/* JADX INFO: loaded from: classes41.dex */
public final class b {
    public static int a() {
        EGLDisplay r100 = EGL14.eglGetDisplay(0);
        int[] r101 = new int[2];
        EGL14.eglInitialize(r100, r101, 0, r101, 1);
        EGLConfig[] r110 = new EGLConfig[1];
        int[] r111 = new int[1];
        EGL14.eglChooseConfig(r100, new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, 0, r110, 0, 1, r111, 0);
        if (r111[0] != 0) goto L5;
        return 0;
    L5:
        EGLConfig r102 = r110[0];
        EGLSurface r103 = EGL14.eglCreatePbufferSurface(r100, r102, new int[]{12375, 64, 12374, 64, 12344}, 0);
        EGLContext r104 = EGL14.EGL_NO_CONTEXT;
        EGLContext r105 = EGL14.eglCreateContext(r100, r102, r104, new int[]{12440, 2, 12344}, 0);
        EGL14.eglMakeCurrent(r100, r103, r103, r105);
        int[] r106 = new int[1];
        GLES20.glGetIntegerv(3379, r106, 0);
        EGLSurface r107 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r100, r107, r107, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(r100, r103);
        EGL14.eglDestroyContext(r100, r105);
        EGL14.eglTerminate(r100);
        return r106[0];
    }
}
