package com.bytedance.realx.base;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;

/* JADX INFO: loaded from: classes21.dex */
public class GPUUtil {
    private static String glRenderer = "unknown";
    private static String glVendor = "unknown";
    private static boolean initialized;

    public GPUUtil() {
    }

    private static void Initialize() {
        initialized = true;
        boolean r100 = false;
        EGLContext r101 = EGL14.eglGetCurrentContext();     // Catch: Throwable -> L88 Exception -> L90
        if (r101 != null) goto L126;
    L15:
        r100 = true;
    L16:
        if (r100 == true) goto L131;
        EGLSurface r102 = null;
        EGLDisplay r103 = null;
    L133:
    L86:
        e = e;
        EGLContext r210 = r101;
        EGLSurface r104 = r102;
        r100 = r100;
        r101 = r210;
    L124:
        e.toString();     // Catch: Throwable -> L108
        if (r100 == false) goto L139;
        EGLSurface r105 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r103, r105, r105, EGL14.EGL_NO_CONTEXT);
        if (r104 != null) goto L97;
    L99:
        if (r101 != null) goto L101;
    L103:
        if (r103 != null) goto L105;
        return;
    L105:
        if (r103 == EGL14.EGL_NO_DISPLAY) goto L141;
    L106:
        EGL14.eglTerminate(r103);
        return;
    L141:
        return;
    L101:
        if (r101 == EGL14.EGL_NO_CONTEXT) goto L103;
        EGL14.eglDestroyContext(r103, r101);
        goto L103
    L97:
        if (r104 == EGL14.EGL_NO_SURFACE) goto L99;
        EGL14.eglDestroySurface(r103, r104);
        goto L99
    L139:
        return;
    L108:
        th = th;
    L109:
        if (r100 == false) goto L123;
        EGLSurface r106 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r103, r106, r106, EGL14.EGL_NO_CONTEXT);
        if (r104 != null) goto L113;
    L115:
        if (r101 != null) goto L117;
    L119:
        if (r103 == null) goto L123;
        if (r103 == EGL14.EGL_NO_DISPLAY) goto L123;
        EGL14.eglTerminate(r103);
        goto L123
    L117:
        if (r101 == EGL14.EGL_NO_CONTEXT) goto L119;
        EGL14.eglDestroyContext(r103, r101);
        goto L119
    L113:
        if (r104 == EGL14.EGL_NO_SURFACE) goto L115;
        EGL14.eglDestroySurface(r103, r104);
    L123:
        throw th;
    L84:
        th = th;
        EGLContext r211 = r101;
        r104 = r102;
        r100 = r100;
        r101 = r211;
        goto L109
    L68:
        if (Build.VERSION.SDK_INT <= 22) goto L70;
        glVendor = GLES20.glGetString(7936);     // Catch: Throwable -> L84 Exception -> L86
        glRenderer = GLES20.glGetString(7937);     // Catch: Throwable -> L84 Exception -> L86
    L70:
        if (r100 == false) goto L136;
        EGLSurface r107 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r103, r107, r107, EGL14.EGL_NO_CONTEXT);
        if (r102 != null) goto L74;
    L76:
        if (r101 != null) goto L78;
    L80:
        if (r103 != null) goto L82;
        return;
    L82:
        if (r103 != EGL14.EGL_NO_DISPLAY) goto L106;
        return;
    L78:
        if (r101 == EGL14.EGL_NO_CONTEXT) goto L80;
        EGL14.eglDestroyContext(r103, r101);
        goto L80
    L74:
        if (r102 == EGL14.EGL_NO_SURFACE) goto L76;
        EGL14.eglDestroySurface(r103, r102);
        goto L76
    L136:
        return;
    L131:
        EGLDisplay r110 = EGL14.eglGetDisplay(0);     // Catch: Throwable -> L60 Exception -> L63
        if (r110 == null) goto L55;
    L58:
        e = e;
        r103 = r110;
    L14:
        r104 = null;
    L56:
        th = th;
        r103 = r110;
    L11:
        r104 = null;
        goto L109
    L20:
        if (r110 == EGL14.EGL_NO_DISPLAY) goto L55;
        int[] r108 = new int[2];     // Catch: Throwable -> L56 Exception -> L58
        if (EGL14.eglInitialize(r110, r108, 0, r108, 1) == false) goto L53;
        int[] r111 = new int[1];     // Catch: Throwable -> L56 Exception -> L58
        EGLConfig[] r112 = new EGLConfig[1];     // Catch: Throwable -> L56 Exception -> L58
        if (EGL14.eglChooseConfig(r110, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, 0, r112, 0, 1, r111, 0) == false) goto L51;
        if (r111[0] <= 0) goto L49;
        EGLConfig r109 = r112[0];     // Catch: Throwable -> L56 Exception -> L58
        r101 = EGL14.eglCreateContext(r110, r109, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);     // Catch: Throwable -> L56 Exception -> L58
        if (r101 == null) goto L47;
        if (r101 == EGL14.EGL_NO_CONTEXT) goto L47;
        EGLSurface r113 = EGL14.eglCreatePbufferSurface(r110, r109, new int[]{12375, 1, 12374, 1, 12344}, 0);     // Catch: Throwable -> L56 Exception -> L58
        if (r113 == null) goto L41;
    L44:
        e = e;
        r100 = r100;
        r101 = r101;
        r104 = r113;
        r103 = r110;
    L42:
        th = th;
        r100 = r100;
        r101 = r101;
        r104 = r113;
        r103 = r110;
        goto L109
    L34:
        if (r113 == EGL14.EGL_NO_SURFACE) goto L41;
        if (EGL14.eglMakeCurrent(r110, r113, r113, r101) == false) goto L39;
        r102 = r113;
        r103 = r110;
        goto L133
    L39:
        throw new Exception("eglMakeCurrent error");     // Catch: Throwable -> L42 Exception -> L44
    L41:
        throw new Exception("eglCreatePbufferSurface error");     // Catch: Throwable -> L42 Exception -> L44
    L47:
        throw new Exception("eglCreateContext error");     // Catch: Throwable -> L56 Exception -> L58
    L49:
        throw new Exception("no egl config chosen");     // Catch: Throwable -> L56 Exception -> L58
    L51:
        throw new Exception("eglChooseConfig error");     // Catch: Throwable -> L56 Exception -> L58
    L53:
        throw new Exception("eglInitialize error");     // Catch: Throwable -> L56 Exception -> L58
    L55:
        throw new Exception("eglGetDisplay error");     // Catch: Throwable -> L56 Exception -> L58
    L63:
        e = e;
        r103 = null;
    L60:
        th = th;
        r103 = null;
        goto L11
    L126:
        if (r101 == EGL14.EGL_NO_CONTEXT) goto L15;
        r100 = false;
        goto L16
    L12:
        e = e;
        r103 = null;
    L9:
        th = th;
        r103 = null;
        goto L11
    L90:
        e = e;
        r103 = null;
        r104 = null;
        r101 = null;
    L88:
        th = th;
        r103 = null;
        r104 = null;
        r101 = null;
        goto L109
    }

    public static String getGPURenderer() {
        if (initialized == true) goto L6;
        Initialize();
    L6:
        return glRenderer;
    }

    public static String getGPURendererFallback() {
        return glRenderer;
    }
}
