package com.bytedance.common.jato.threads;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class ThreadSuspendTimeout {
    public ThreadSuspendTimeout() {
    }

    public static native void setSuspendTimeoutInSeconds(long r100);

    static {
        JatoNativeLoader.loadLibrary();
    }
}
