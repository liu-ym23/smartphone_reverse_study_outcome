package com.facebook.cache.common;

/* JADX INFO: loaded from: classes3.dex */
public class NoOpCacheEventListener implements CacheEventListener {
    private static NoOpCacheEventListener sInstance;

    @Override // com.facebook.cache.common.CacheEventListener
    public void onCleared() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onEviction(CacheEvent r100) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onHit(CacheEvent r100) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onMiss(CacheEvent r100) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onReadException(CacheEvent r100) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteAttempt(CacheEvent r100) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteException(CacheEvent r100) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteSuccess(CacheEvent r100) {
    }

    public static synchronized NoOpCacheEventListener getInstance() {
        monitor-enter(NoOpCacheEventListener.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new NoOpCacheEventListener();     // Catch: Throwable -> L10
    L7:
        NoOpCacheEventListener r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(NoOpCacheEventListener.class);
        return r100;
    }

    private NoOpCacheEventListener() {
    }
}
