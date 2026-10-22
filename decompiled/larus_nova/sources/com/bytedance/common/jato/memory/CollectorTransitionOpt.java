package com.bytedance.common.jato.memory;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class CollectorTransitionOpt {
    public CollectorTransitionOpt() {
    }

    public static native synchronized boolean disable();

    public static native synchronized boolean enable();

    static {
        JatoNativeLoader.loadLibrary();
    }
}
