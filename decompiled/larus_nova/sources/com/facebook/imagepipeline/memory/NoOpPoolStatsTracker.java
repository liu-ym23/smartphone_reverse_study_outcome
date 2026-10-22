package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes3.dex */
public class NoOpPoolStatsTracker implements PoolStatsTracker {
    private static NoOpPoolStatsTracker sInstance;

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void onAlloc(int r100) {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void onFree(int r100) {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void onHardCapReached() {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void onSoftCapReached() {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void onValueRelease(int r100) {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void onValueReuse(int r100) {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void setBasePool(BasePool r100) {
    }

    public static synchronized NoOpPoolStatsTracker getInstance() {
        monitor-enter(NoOpPoolStatsTracker.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new NoOpPoolStatsTracker();     // Catch: Throwable -> L10
    L7:
        NoOpPoolStatsTracker r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(NoOpPoolStatsTracker.class);
        return r100;
    }

    private NoOpPoolStatsTracker() {
    }
}
