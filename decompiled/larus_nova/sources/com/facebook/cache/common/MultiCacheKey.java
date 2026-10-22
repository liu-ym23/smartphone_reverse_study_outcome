package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MultiCacheKey implements CacheKey {
    final List<CacheKey> mCacheKeys;

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.mCacheKeys.get(0).getUriString();
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.mCacheKeys.hashCode();
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return "MultiCacheKey:" + this.mCacheKeys.toString();
    }

    public List<CacheKey> getCacheKeys() {
        return this.mCacheKeys;
    }

    public MultiCacheKey(List<CacheKey> r100) {
        this.mCacheKeys = (List) Preconditions.checkNotNull(r100);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mCacheKeys.size()) goto L10;
        if (this.mCacheKeys.get(r101).containsUri(r100) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof MultiCacheKey) == true) goto L8;
        return false;
    L8:
        return this.mCacheKeys.equals(((MultiCacheKey) r100).mCacheKeys);
    }
}
