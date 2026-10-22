package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.FileCache;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class DiskStorageCacheFactory implements FileCacheFactory {
    private DiskStorageFactory mDiskStorageFactory;

    public DiskStorageCacheFactory(DiskStorageFactory r100) {
        this.mDiskStorageFactory = r100;
    }

    @Override // com.facebook.imagepipeline.core.FileCacheFactory
    public FileCache get(DiskCacheConfig r100) {
        return buildDiskStorageCache(r100, this.mDiskStorageFactory.get(r100));
    }

    public static DiskStorageCache buildDiskStorageCache(DiskCacheConfig r100, DiskStorage r101) {
        return buildDiskStorageCache(r100, r101, PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("DiskStorageCacheFactory")));
    }

    public static DiskStorageCache buildDiskStorageCache(DiskCacheConfig r110, DiskStorage r111, Executor r112) {
        DiskStorageCache.Params r100 = new DiskStorageCache.Params(r110.getMinimumSizeLimit(), r110.getLowDiskSpaceSizeLimit(), r110.getDefaultSizeLimit());
        return new DiskStorageCache(r111, r110.getEntryEvictionComparatorSupplier(), r100, r110.getCacheEventListener(), r110.getCacheErrorLogger(), r110.getDiskTrimmableRegistry(), r110.getContext(), r112, r110.getIndexPopulateAtStartupEnabled(), r110.getEvictRatio());
    }
}
