package com.bytedance.common.jato.threads;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class ThreadPriorInversionOpt {
    public ThreadPriorInversionOpt() {
    }

    public static native void start(int r100);

    public static native void stop();

    static {
        JatoNativeLoader.loadLibrary();
    }
}
