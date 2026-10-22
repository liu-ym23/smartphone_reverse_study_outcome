package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicDefaultDiskStorageFactory implements DiskStorageFactory {
    public DynamicDefaultDiskStorageFactory() {
    }

    @Override // com.facebook.imagepipeline.core.DiskStorageFactory
    public DiskStorage get(DiskCacheConfig r100) {
        return new DynamicDefaultDiskStorage(r100.getVersion(), r100.getBaseDirectoryPathSupplier(), r100.getBaseDirectoryName(), r100.getConfigBaseDirectoryPathSupplier(), r100.getConfigBaseDirectoryName(), r100.getCacheErrorLogger());
    }
}
