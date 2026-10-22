package com.facebook.cache.disk;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class DiskWrapperCacheKey implements CacheKey {
    private final CacheKey cacheKey;
    private final Map<String, String> extraInfo;

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.cacheKey.getUriString();
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.cacheKey.hashCode();
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return this.cacheKey.toString();
    }

    public Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public CacheKey getInnerCacheKey() {
        return this.cacheKey;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri r100) {
        return this.cacheKey.containsUri(r100);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object r100) {
        return this.cacheKey.equals(r100);
    }

    public DiskWrapperCacheKey(CacheKey r100, Map<String, String> r101) {
        this.cacheKey = r100;
        this.extraInfo = r101;
    }
}
