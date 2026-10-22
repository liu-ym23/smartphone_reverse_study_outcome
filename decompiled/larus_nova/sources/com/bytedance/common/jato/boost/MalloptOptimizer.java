package com.bytedance.common.jato.boost;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class MalloptOptimizer {
    public MalloptOptimizer() {
    }

    private static native boolean nMalloptOptimize(int r100);

    static {
        JatoNativeLoader.loadLibrary();
    }
}
