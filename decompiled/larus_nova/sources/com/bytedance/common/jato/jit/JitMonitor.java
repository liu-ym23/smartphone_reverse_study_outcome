package com.bytedance.common.jato.jit;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class JitMonitor {
    private boolean inited;

    private native String nativeDumpJit();

    private native String[] nativeDumpJitCodeCache();

    private native String[] nativeDumpJitThreadPool();

    private native String nativeDumpProfileSaver();

    private native boolean nativeInit();

    private JitMonitor() {
        boolean r100 = false;
        this.inited = false;
        if (JatoNativeLoader.loadLibrary() == true) goto L5;
    L7:
        this.inited = r100;
        return;
    L5:
        if (nativeInit() == false) goto L7;
        r100 = true;
        goto L7
    }
}
