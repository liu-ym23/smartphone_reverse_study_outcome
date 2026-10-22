package com.bytedance.common.jato.memory;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class GcVisitReferenceOpt {
    public GcVisitReferenceOpt() {
    }

    public static native boolean doGcVisitReferenceOpt();

    static {
        JatoNativeLoader.loadLibrary();
    }
}
