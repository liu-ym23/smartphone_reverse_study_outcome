package com.bytedance.realx.video;

import android.opengl.EGL14;
import android.opengl.EGLContext;

/* JADX INFO: loaded from: classes21.dex */
public class EglBaseUtils {
    public EglBaseUtils() {
    }

    public static EGLContext getCurrentContext() {
        return EGL14.eglGetCurrentContext();
    }

    public static int getPreferredEglVersion() {
        return EglBase.EglVersion.getPreferredEglVersion();
    }

    public static EglBase createEGLBase(EGLContext r100) {
        if (r100 == EGL14.EGL_NO_CONTEXT) goto L9;
        if (r100 == null) goto L9;
        return EglBase.CC.createEgl14(r100, EglBase.CC.getEGLConfig(getPreferredEglVersion(), EglBase.Config.CONFIG_PLAIN));
    L9:
        return EglBase.CC.createEgl14(EglBase.CC.getEGLConfig(getPreferredEglVersion(), EglBase.Config.CONFIG_PLAIN));
    }

    public static EglBase.Context getEGLBaseContext(EglBase r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return r100.getEglBaseContext();
    }

    public static long getNativeContextFromEGLBaseContext(EglBase.Context r100) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        return r100.getNativeEglContext();
    }

    public static long getNativeEGLContext(EGLContext r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getNativeHandle();
    }

    public static void releaseEGLBase(EglBase r100) {
        if (r100 == null) goto L5;
        r100.release();
        return;
    }

    public static void setPreferredEglVersion(int r100) {
        EglBase.EglVersion.setPreferredEglVersion(r100);
    }
}
