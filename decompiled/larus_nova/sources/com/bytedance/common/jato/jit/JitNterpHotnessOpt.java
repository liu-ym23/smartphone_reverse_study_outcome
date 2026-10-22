package com.bytedance.common.jato.jit;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class JitNterpHotnessOpt {
    public JitNterpHotnessOpt() {
    }

    public static native void setJitHotness(int r100);

    static {
        JatoNativeLoader.loadLibrary();
    }
}
