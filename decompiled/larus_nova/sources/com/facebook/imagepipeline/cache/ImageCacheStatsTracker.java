package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;

/* JADX INFO: loaded from: classes3.dex */
public interface ImageCacheStatsTracker {
    void onBitmapCacheHit(CacheKey r100);

    void onBitmapCacheMiss();

    void onBitmapCachePut();

    void onDiskCacheGetFail();

    void onDiskCacheHit(CacheKey r100);

    void onDiskCacheMiss();

    void onMemoryCacheHit(CacheKey r100);

    void onMemoryCacheMiss();

    void onMemoryCachePut();

    void onStagingAreaHit(CacheKey r100);

    void onStagingAreaMiss();

    void registerBitmapMemoryCache(CountingMemoryCache<?, ?> r100);

    void registerEncodedMemoryCache(CountingMemoryCache<?, ?> r100);

    void registerHashMapMemoryCache(HashMapMemoryCache<?, ?> r100);
}
