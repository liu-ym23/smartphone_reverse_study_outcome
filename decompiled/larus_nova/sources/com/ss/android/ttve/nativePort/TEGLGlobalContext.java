package com.ss.android.ttve.nativePort;

/* JADX INFO: loaded from: classes38.dex */
public class TEGLGlobalContext {
    public TEGLGlobalContext() {
    }

    public static native void nativeSetGLVersion(int r100);

    public static native void nativeSetMaxRenderSize(int r100, int r101);

    static {
        TECodecNativeLibsLoader.d();
    }
}
