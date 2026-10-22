package com.bytedance.common.jato.interpreter;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class NterpOpt {
    public NterpOpt() {
    }

    public static native void eraserCanMethodUseNterp();

    static {
        JatoNativeLoader.loadLibrary();
    }
}
