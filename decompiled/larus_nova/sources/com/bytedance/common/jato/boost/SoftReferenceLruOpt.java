package com.bytedance.common.jato.boost;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class SoftReferenceLruOpt {
    private static volatile SoftReferenceLruOpt sInstance;

    public static native int nEnable(long r100, int r101);

    public static SoftReferenceLruOpt getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(SoftReferenceLruOpt.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SoftReferenceLruOpt();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SoftReferenceLruOpt.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    static {
        JatoNativeLoader.loadLibrary();
        sInstance = null;
    }

    private SoftReferenceLruOpt() {
    }

    public synchronized void enable(long r100, int r101) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (JatoNativeLoader.loadLibrary() == true) goto L15;
    L9:
        monitor-exit(this);
        return;
    L15:
        nEnable(r100, r101);     // Catch: Exception -> L7 Throwable -> L11
    L7:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L11
        goto L9
    }
}
