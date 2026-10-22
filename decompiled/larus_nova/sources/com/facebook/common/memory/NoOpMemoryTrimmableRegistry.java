package com.facebook.common.memory;

/* JADX INFO: loaded from: classes3.dex */
public class NoOpMemoryTrimmableRegistry implements MemoryTrimmableRegistry {
    private static NoOpMemoryTrimmableRegistry sInstance;

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void registerMemoryTrimmable(MemoryTrimmable r100) {
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void unregisterMemoryTrimmable(MemoryTrimmable r100) {
    }

    public static synchronized NoOpMemoryTrimmableRegistry getInstance() {
        monitor-enter(NoOpMemoryTrimmableRegistry.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new NoOpMemoryTrimmableRegistry();     // Catch: Throwable -> L10
    L7:
        NoOpMemoryTrimmableRegistry r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(NoOpMemoryTrimmableRegistry.class);
        return r100;
    }

    public NoOpMemoryTrimmableRegistry() {
    }
}
