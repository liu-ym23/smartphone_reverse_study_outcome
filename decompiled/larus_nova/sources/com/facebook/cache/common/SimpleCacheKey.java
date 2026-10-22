package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleCacheKey implements CacheKey {
    final String mKey;

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.mKey.hashCode();
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.mKey;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return this.mKey;
    }

    public SimpleCacheKey(String r100) {
        this.mKey = (String) Preconditions.checkNotNull(r100);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri r100) {
        return this.mKey.contains(r100.toString());
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SimpleCacheKey) == true) goto L8;
        return false;
    L8:
        return this.mKey.equals(((SimpleCacheKey) r100).mKey);
    }
}
