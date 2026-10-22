package com.bytedance.lighten.loader;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.HashMapMemoryCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;

/* JADX INFO: loaded from: classes20.dex */
public final class o implements ImageCacheStatsTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile o f254776a;

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void onBitmapCacheHit(CacheKey r100) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void onBitmapCacheMiss() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void onBitmapCachePut() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void onDiskCacheGetFail() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void onDiskCacheHit(CacheKey r100) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void onDiskCacheMiss() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void onMemoryCacheHit(CacheKey r100) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void onMemoryCacheMiss() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void onMemoryCachePut() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void onStagingAreaHit(CacheKey r100) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void onStagingAreaMiss() {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void registerBitmapMemoryCache(CountingMemoryCache<?, ?> r100) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void registerEncodedMemoryCache(CountingMemoryCache<?, ?> r100) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public final void registerHashMapMemoryCache(HashMapMemoryCache<?, ?> r100) {
    }

    public o() {
    }
}
