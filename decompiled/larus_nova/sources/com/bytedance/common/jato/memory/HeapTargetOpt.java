package com.bytedance.common.jato.memory;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class HeapTargetOpt {
    private static final boolean sIsLoaded = false;

    public HeapTargetOpt() {
    }

    private static native boolean collectGarbageNative(boolean r100);

    private static native boolean resetTargetFootprintNative();

    private static native boolean setTargetFootprintNative(long r100);

    static {
        sIsLoaded = JatoNativeLoader.loadLibrary();
    }
}
