package com.bytedance.common.jato.boost;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class SweepLargeObjectsOpt {
    public SweepLargeObjectsOpt() {
    }

    private static native boolean nEnable(int r100, long r101, long r102);

    private static native void nShowSweepLargeObjectsTime(int r100, boolean r101);

    static {
        JatoNativeLoader.loadLibrary();
    }
}
