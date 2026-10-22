package com.ss.ttm.vcshared;

/* JADX INFO: loaded from: classes40.dex */
public class VCBaseKitLoader {
    public static synchronized boolean loadLibrary() {
        monitor-enter(VCBaseKitLoader.class);
        boolean r100 = com.ss.vcbkit.VCBaseKitLoader.loadLibrary();     // Catch: Throwable -> L7
        monitor-exit(VCBaseKitLoader.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    private VCBaseKitLoader() {
    }
}
