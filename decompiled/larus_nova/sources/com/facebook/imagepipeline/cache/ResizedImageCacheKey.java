package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import java.io.File;

/* JADX INFO: loaded from: classes23.dex */
public class ResizedImageCacheKey implements CacheKey {
    private final String mFileSignature;
    private final int mHash;
    private final ResizeOptions mResizeOptions;
    private final String mSourceUriString;

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return String.format(null, "%s_%s_%s_%d", new Object[]{this.mSourceUriString, this.mResizeOptions, this.mFileSignature, Integer.valueOf(this.mHash)});
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return toString();
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.mHash;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri r100) {
        return this.mSourceUriString.contains(r100.toString());
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResizedImageCacheKey) == false) goto L18;
        ResizedImageCacheKey r101 = (ResizedImageCacheKey) r100;
        if (this.mHash == r101.mHash) goto L10;
    L16:
        return false;
    L10:
        if (this.mSourceUriString.equals(r101.mSourceUriString) == false) goto L16;
        if (this.mResizeOptions.equals(r101.mResizeOptions) == false) goto L16;
        if (this.mFileSignature.equals(r101.mFileSignature) == false) goto L16;
        return true;
    L18:
        return false;
    }

    public ResizedImageCacheKey(String r100, ResizeOptions r101, File r102) {
        String r103 = (String) Preconditions.checkNotNull(r100);
        this.mSourceUriString = r103;
        this.mResizeOptions = (ResizeOptions) Preconditions.checkNotNull(r101);
        this.mFileSignature = Long.toString(((File) Preconditions.checkNotNull(r102)).lastModified()) + Long.toString(r102.length());
        this.mHash = HashCodeUtil.hashCode(r103.hashCode(), r101.hashCode(), r103.hashCode());
    }
}
