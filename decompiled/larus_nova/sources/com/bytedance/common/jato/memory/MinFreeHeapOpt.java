package com.bytedance.common.jato.memory;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class MinFreeHeapOpt {
    public MinFreeHeapOpt() {
    }

    public static native void nativeSetMinFreeHeapPecent(double r100);

    static {
        JatoNativeLoader.loadLibrary();
    }
}
