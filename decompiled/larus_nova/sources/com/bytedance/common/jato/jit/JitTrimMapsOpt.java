package com.bytedance.common.jato.jit;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class JitTrimMapsOpt {
    public JitTrimMapsOpt() {
    }

    private static native int nEnable(int r100);

    static {
        JatoNativeLoader.loadLibrary();
    }
}
