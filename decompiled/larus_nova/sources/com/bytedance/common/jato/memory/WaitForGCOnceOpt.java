package com.bytedance.common.jato.memory;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class WaitForGCOnceOpt {
    public WaitForGCOnceOpt() {
    }

    private static native void enableInner(long r100);

    static {
        JatoNativeLoader.loadLibrary();
    }
}
