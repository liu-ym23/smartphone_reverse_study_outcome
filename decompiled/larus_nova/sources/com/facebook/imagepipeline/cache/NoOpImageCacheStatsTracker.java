package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;

/* JADX INFO: loaded from: classes3.dex */
public class NoOpImageCacheStatsTracker implements ImageCacheStatsTracker {
    private static NoOpImageCacheStatsTracker sInstance;

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onBitmapCacheHit(CacheKey r100) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onBitmapCacheMiss() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onBitmapCachePut() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onDiskCacheGetFail() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onDiskCacheHit(CacheKey r100) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onDiskCacheMiss() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onMemoryCacheHit(CacheKey r100) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onMemoryCacheMiss() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onMemoryCachePut() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onStagingAreaHit(CacheKey r100) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onStagingAreaMiss() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void registerBitmapMemoryCache(CountingMemoryCache<?, ?> r100) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void registerEncodedMemoryCache(CountingMemoryCache<?, ?> r100) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void registerHashMapMemoryCache(HashMapMemoryCache<?, ?> r100) {
    }

    public static synchronized NoOpImageCacheStatsTracker getInstance() {
        monitor-enter(NoOpImageCacheStatsTracker.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new NoOpImageCacheStatsTracker();     // Catch: Throwable -> L10
    L7:
        NoOpImageCacheStatsTracker r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(NoOpImageCacheStatsTracker.class);
        return r100;
    }

    private NoOpImageCacheStatsTracker() {
    }
}
