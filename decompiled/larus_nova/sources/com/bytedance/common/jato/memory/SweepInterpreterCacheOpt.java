package com.bytedance.common.jato.memory;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class SweepInterpreterCacheOpt {
    public SweepInterpreterCacheOpt() {
    }

    public static native void disable();

    public static native void enable();

    static {
        JatoNativeLoader.loadLibrary();
    }
}
