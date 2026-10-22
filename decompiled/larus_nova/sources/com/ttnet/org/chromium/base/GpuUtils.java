package com.ttnet.org.chromium.base;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;

/* JADX INFO: loaded from: classes41.dex */
public class GpuUtils {
    private static String TAG;
    private static String sGlRenderer;
    private static String sGlVendor;
    private static final Object sGpuInfoLock = null;
    private static boolean sInitialized;

    public GpuUtils() {
    }

    static {
        TAG = "GpuUtils";
        sGlVendor = "unknown";
        sGlRenderer = "unknown";
        sGpuInfoLock = new Object();
    }

    public static String getGPUModel() {
        Object r100 = sGpuInfoLock;
        monitor-enter(r100);
        String r101 = sGlRenderer;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static String getGPUVendor() {
        Object r100 = sGpuInfoLock;
        monitor-enter(r100);
        String r101 = sGlVendor;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean initialize() {
        if (sInitialized == false) goto L5;
        return true;
    L5:
        EGLDisplay r100 = null;
        boolean r101 = false;
        EGLContext r102 = EGL14.eglGetCurrentContext();     // Catch: Throwable -> L90 Exception -> L92
        if (r102 != null) goto L144;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == true) goto L146;
        r102 = r102;
        EGLSurface r104 = null;
    L130:
        Object r105 = sGpuInfoLock;     // Catch: Exception -> L88 Throwable -> L110
        monitor-enter(r105);     // Catch: Exception -> L88 Throwable -> L110
        sGlVendor = GLES20.glGetString(7936);     // Catch: Throwable -> L85
        sGlRenderer = GLES20.glGetString(7937);     // Catch: Throwable -> L85
        monitor-exit(r105);     // Catch: Throwable -> L85
        if (r103 == true) goto L139;
    L83:
        sInitialized = true;
        return true;
    L139:
        EGLSurface r106 = EGL14.EGL_NO_SURFACE;     // Catch: Exception -> L127
        EGL14.eglMakeCurrent(r100, r106, r106, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L127
        if (r104 != null) goto L73;
    L75:
        if (r102 != null) goto L77;
    L79:
        if (r100 == null) goto L83;
        if (r100.equals(EGL14.EGL_NO_DISPLAY) == true) goto L83;
        EGL14.eglTerminate(r100);     // Catch: Exception -> L127
        goto L83
    L77:
        if (r102.equals(EGL14.EGL_NO_CONTEXT) == true) goto L79;
        EGL14.eglDestroyContext(r100, r102);     // Catch: Exception -> L127
        goto L79
    L73:
        if (r104.equals(EGL14.EGL_NO_SURFACE) == true) goto L75;
        EGL14.eglDestroySurface(r100, r104);     // Catch: Exception -> L127
    L85:
        th = move-exception;
        throw th;     // Catch: Exception -> L88 Throwable -> L110
    L88:
        e = e;
    L94:
        e.printStackTrace();     // Catch: Throwable -> L110
        if (r103 == true) goto L137;
    L109:
        return false;
    L137:
        EGLSurface r107 = EGL14.EGL_NO_SURFACE;     // Catch: Exception -> L128
        EGL14.eglMakeCurrent(r100, r107, r107, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L128
        if (r104 != null) goto L99;
    L101:
        if (r102 != null) goto L103;
    L105:
        if (r100 == null) goto L109;
        if (r100.equals(EGL14.EGL_NO_DISPLAY) == true) goto L109;
        EGL14.eglTerminate(r100);     // Catch: Exception -> L128
        goto L109
    L103:
        if (r102.equals(EGL14.EGL_NO_CONTEXT) == true) goto L105;
        EGL14.eglDestroyContext(r100, r102);     // Catch: Exception -> L128
        goto L105
    L99:
        if (r104.equals(EGL14.EGL_NO_SURFACE) == true) goto L101;
        EGL14.eglDestroySurface(r100, r104);     // Catch: Exception -> L128
    L110:
        th = th;
        r101 = r103;
    L112:
        if (r101 == true) goto L135;
    L126:
        throw th;
    L135:
        EGLSurface r108 = EGL14.EGL_NO_SURFACE;     // Catch: Exception -> L129
        EGL14.eglMakeCurrent(r100, r108, r108, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L129
        if (r104 != null) goto L116;
    L118:
        if (r102 != null) goto L120;
    L122:
        if (r100 == null) goto L126;
        if (r100.equals(EGL14.EGL_NO_DISPLAY) == true) goto L126;
        EGL14.eglTerminate(r100);     // Catch: Exception -> L129
        goto L126
    L120:
        if (r102.equals(EGL14.EGL_NO_CONTEXT) == true) goto L122;
        EGL14.eglDestroyContext(r100, r102);     // Catch: Exception -> L129
        goto L122
    L116:
        if (r104.equals(EGL14.EGL_NO_SURFACE) == true) goto L118;
        EGL14.eglDestroySurface(r100, r104);     // Catch: Exception -> L129
        goto L118
    L146:
        EGLDisplay r110 = EGL14.eglGetDisplay(0);     // Catch: Throwable -> L59 Exception -> L61
        if (r110 == null) goto L54;
    L57:
        e = e;
        r102 = r102;
        r104 = null;
        r100 = r110;
    L55:
        th = th;
        r102 = r102;
        r101 = r103;
        r104 = null;
        r100 = r110;
        goto L112
    L23:
        if (r110.equals(EGL14.EGL_NO_DISPLAY) == true) goto L54;
        int[] r109 = new int[2];     // Catch: Throwable -> L55 Exception -> L57
        if (EGL14.eglInitialize(r110, r109, 0, r109, 1) == false) goto L52;
        int[] r111 = new int[1];     // Catch: Throwable -> L55 Exception -> L57
        EGLConfig[] r112 = new EGLConfig[1];     // Catch: Throwable -> L55 Exception -> L57
        if (EGL14.eglChooseConfig(r110, new int[]{12344}, 0, r112, 0, 1, r111, 0) == false) goto L50;
        if (r111[0] <= 0) goto L48;
        EGLConfig r113 = r112[0];     // Catch: Throwable -> L55 Exception -> L57
        EGLContext r114 = EGL14.eglCreateContext(r110, r113, EGL14.EGL_NO_CONTEXT, new int[]{12344}, 0);     // Catch: Throwable -> L55 Exception -> L57
        if (r114 == null) goto L46;
        if (r114.equals(EGL14.EGL_NO_CONTEXT) == true) goto L46;
        EGLSurface r115 = EGL14.eglCreatePbufferSurface(r110, r113, new int[]{12344}, 0);     // Catch: Throwable -> L55 Exception -> L57
        if (r115 == null) goto L44;
        if (r115.equals(EGL14.EGL_NO_SURFACE) == true) goto L44;
        if (EGL14.eglMakeCurrent(r110, r115, r115, r114) == false) goto L42;
        r102 = r114;
        r104 = r115;
        r100 = r110;
        goto L130
    L42:
        throw new Exception("eglMakeCurrent error");     // Catch: Throwable -> L55 Exception -> L57
    L44:
        throw new Exception("eglCreatePbufferSurface error");     // Catch: Throwable -> L55 Exception -> L57
    L46:
        throw new Exception("eglCreateContext error");     // Catch: Throwable -> L55 Exception -> L57
    L48:
        throw new Exception("no egl config chosen");     // Catch: Throwable -> L55 Exception -> L57
    L50:
        throw new Exception("eglChooseConfig error");     // Catch: Throwable -> L55 Exception -> L57
    L52:
        throw new Exception("eglInitialize error");     // Catch: Throwable -> L55 Exception -> L57
    L54:
        throw new Exception("eglGetDisplay error");     // Catch: Throwable -> L55 Exception -> L57
    L61:
        e = e;
    L17:
        r104 = null;
    L59:
        th = th;
        r101 = r103;
    L14:
        r104 = null;
        goto L112
    L144:
        if (r102.equals(EGL14.EGL_NO_CONTEXT) == true) goto L18;
        r103 = false;
        goto L19
    L15:
        e = e;
        r103 = false;
    L12:
        th = th;
        goto L14
    L92:
        e = e;
        r104 = null;
        r102 = null;
        r103 = false;
    L90:
        th = th;
        r104 = null;
        r102 = null;
        goto L112
    }
}
