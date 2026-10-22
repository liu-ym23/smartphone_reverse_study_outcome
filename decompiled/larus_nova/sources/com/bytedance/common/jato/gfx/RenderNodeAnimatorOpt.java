package com.bytedance.common.jato.gfx;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class RenderNodeAnimatorOpt {
    private static int reflectInited;

    public RenderNodeAnimatorOpt() {
    }

    private static native float nGetValue(long r100, long r101);

    private static native int nOpt(boolean r100);

    private static native void nSetStartValue(long r100, float r101);

    private static native void nSetValue(long r100, long r101, float r102);

    static {
        JatoNativeLoader.loadLibrary();
        reflectInited = -1;
    }
}
