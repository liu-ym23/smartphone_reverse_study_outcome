package com.bytedance.common.jato.boost;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class GCMadviseOpt {
    public GCMadviseOpt() {
    }

    public static native synchronized void disable();

    public static native synchronized void enable();

    static {
        JatoNativeLoader.loadLibrary();
    }
}
