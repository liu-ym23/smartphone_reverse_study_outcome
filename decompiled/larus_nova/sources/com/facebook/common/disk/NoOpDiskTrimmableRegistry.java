package com.facebook.common.disk;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class NoOpDiskTrimmableRegistry implements DiskTrimmableRegistry {

    @Nullable
    private static NoOpDiskTrimmableRegistry sInstance;

    @Override // com.facebook.common.disk.DiskTrimmableRegistry
    public void registerDiskTrimmable(DiskTrimmable r100) {
    }

    @Override // com.facebook.common.disk.DiskTrimmableRegistry
    public void unregisterDiskTrimmable(DiskTrimmable r100) {
    }

    public static synchronized NoOpDiskTrimmableRegistry getInstance() {
        monitor-enter(NoOpDiskTrimmableRegistry.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new NoOpDiskTrimmableRegistry();     // Catch: Throwable -> L10
    L7:
        NoOpDiskTrimmableRegistry r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(NoOpDiskTrimmableRegistry.class);
        return r100;
    }

    private NoOpDiskTrimmableRegistry() {
    }
}
