package com.facebook.cache.common;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class NoOpCacheErrorLogger implements CacheErrorLogger {
    private static NoOpCacheErrorLogger sInstance;

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void logError(CacheErrorLogger.CacheErrorCategory r100, Class<?> r101, String r102, @Nullable Throwable r103) {
    }

    public static synchronized NoOpCacheErrorLogger getInstance() {
        monitor-enter(NoOpCacheErrorLogger.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new NoOpCacheErrorLogger();     // Catch: Throwable -> L10
    L7:
        NoOpCacheErrorLogger r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(NoOpCacheErrorLogger.class);
        return r100;
    }

    private NoOpCacheErrorLogger() {
    }
}
