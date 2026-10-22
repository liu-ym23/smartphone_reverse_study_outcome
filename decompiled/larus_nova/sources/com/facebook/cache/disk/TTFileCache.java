package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;

/* JADX INFO: loaded from: classes22.dex */
public interface TTFileCache extends FileCache {
    BinaryResource getTempResource(CacheKey r100);
}
