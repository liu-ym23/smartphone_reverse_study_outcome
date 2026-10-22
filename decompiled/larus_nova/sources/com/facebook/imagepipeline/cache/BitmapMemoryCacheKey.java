package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class BitmapMemoryCacheKey implements CacheKey {
    private final long mCacheTime;
    private final Object mCallerContext;
    private final int mHash;
    private final ImageDecodeOptions mImageDecodeOptions;
    private final boolean mLoadThumbnailOnly;

    @Nullable
    private final CacheKey mPostprocessorCacheKey;

    @Nullable
    private final String mPostprocessorName;

    @Nullable
    private final ResizeOptions mResizeOptions;
    private final RotationOptions mRotationOptions;
    private final String mSourceString;

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        if (MemoryCacheUtil.isOptReuseBitmapCache() == false) goto L7;
        return HashCodeUtil.hashCode(Integer.valueOf(this.mHash), this.mResizeOptions);
    L7:
        return this.mHash;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        if (MemoryCacheUtil.isOptReuseBitmapCache() == false) goto L10;
        Object[] r100 = new Object[7];
        r100[0] = this.mSourceString + "_uri_end";
        r100[1] = this.mRotationOptions;
        if (FrescoCacheMonitorUtil.isOptBitmapCacheKey() == false) goto L7;
        Object r101 = this.mImageDecodeOptions.toOptKeyString();
    L8:
        r100[2] = r101;
        r100[3] = this.mPostprocessorCacheKey;
        r100[4] = this.mPostprocessorName;
        r100[5] = Integer.valueOf(this.mHash);
        r100[6] = "resizeOption:" + this.mResizeOptions;
        return String.format(null, "%s_%s_%s_%s_%s_%d_%s", r100);
    L7:
        r101 = this.mImageDecodeOptions;
        goto L8
    L10:
        Object[] r102 = new Object[7];
        r102[0] = this.mSourceString;
        r102[1] = this.mResizeOptions;
        r102[2] = this.mRotationOptions;
        if (FrescoCacheMonitorUtil.isOptBitmapCacheKey() == false) goto L13;
        Object r103 = this.mImageDecodeOptions.toOptKeyString();
    L14:
        r102[3] = r103;
        r102[4] = this.mPostprocessorCacheKey;
        r102[5] = this.mPostprocessorName;
        r102[6] = Integer.valueOf(this.mHash);
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", r102);
    L13:
        r103 = this.mImageDecodeOptions;
        goto L14
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public long getInBitmapCacheSince() {
        return this.mCacheTime;
    }

    @Nullable
    public String getPostprocessorName() {
        return this.mPostprocessorName;
    }

    public ResizeOptions getResizeOptions() {
        return this.mResizeOptions;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.mSourceString;
    }

    public static CacheKey getReuseOptCacheKey(CacheKey r110) {
        ResizeOptions r100 = BitmapCacheUtil.getOptReuseResizeOption(r110);
        if ((r110 instanceof BitmapMemoryCacheKey) == false) goto L10;
        if (r100 == null) goto L10;
        if (r100 != BitmapCacheUtil.REUSE_ORIGIN_RESIZE_OPTION) goto L8;
        r100 = null;
    L8:
        BitmapMemoryCacheKey r111 = (BitmapMemoryCacheKey) r110;
        String r101 = r111.mSourceString;
        boolean r102 = r111.mLoadThumbnailOnly;
        return new BitmapMemoryCacheKey(r101, r102, r100, r111.mRotationOptions, r111.mImageDecodeOptions, r111.mPostprocessorCacheKey, r111.mPostprocessorName, r111.mCallerContext);
    L10:
        return r110;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri r100) {
        return getUriString().contains(r100.toString());
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object r100) {
        if ((r100 instanceof BitmapMemoryCacheKey) == true) goto L5;
        return false;
    L5:
        BitmapMemoryCacheKey r101 = (BitmapMemoryCacheKey) r100;
        if (this.mHash != r101.mHash) goto L17;
        if (this.mSourceString.equals(r101.mSourceString) == false) goto L17;
        if (Objects.equal(this.mResizeOptions, r101.mResizeOptions) == false) goto L17;
        if (Objects.equal(this.mRotationOptions, r101.mRotationOptions) == false) goto L17;
        if (FrescoCacheMonitorUtil.isOptBitmapCacheKey() == false) goto L17;
        return Objects.equal(this.mImageDecodeOptions.toOptKeyString(), r101.mImageDecodeOptions.toOptKeyString());
    L17:
        if (Objects.equal(this.mImageDecodeOptions, r101.mImageDecodeOptions) == true) goto L19;
        return false;
    L19:
        if (Objects.equal(this.mPostprocessorCacheKey, r101.mPostprocessorCacheKey) == true) goto L21;
        return false;
    L21:
        if (Objects.equal(this.mPostprocessorName, r101.mPostprocessorName) == false) goto L27;
        return true;
    L27:
        return false;
    }

    public static void checkKeyNotDownsample(ImageRequest r100, CacheKey r101) {
        if (r100 == null) goto L11;
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r101 instanceof BitmapMemoryCacheKey) == true) goto L8;
        return;
    L8:
        if (((BitmapMemoryCacheKey) r101).mResizeOptions != null) goto L13;
        r100.setAutoDownsampleDisabled(true);
        return;
    L13:
        return;
    }

    public static CacheKey getAutoDownsampleStoreCacheKey(ImageRequest r110, CacheKey r111) {
        if (FrescoCacheMonitorUtil.isAutoDownsampleKeyOpt() == true) goto L5;
    L20:
        return r111;
    L5:
        if (r110.getResizeOptions() != null) goto L20;
        if (r110.isAutoDownsampleDisabled() == false) goto L15;
        if ((r111 instanceof BitmapMemoryCacheKey) == false) goto L20;
        BitmapMemoryCacheKey r112 = (BitmapMemoryCacheKey) r111;
        if (r112.mResizeOptions == null) goto L20;
        return new BitmapMemoryCacheKey(r112.mSourceString, r112.mLoadThumbnailOnly, null, r112.mRotationOptions, r112.mImageDecodeOptions, r112.mPostprocessorCacheKey, r112.mPostprocessorName, r112.mCallerContext);
    L15:
        if (r110.getCacheKeyResizeOptions() == null) goto L20;
        if ((r111 instanceof BitmapMemoryCacheKey) == false) goto L20;
        BitmapMemoryCacheKey r113 = (BitmapMemoryCacheKey) r111;
        return new BitmapMemoryCacheKey(r113.mSourceString, r113.mLoadThumbnailOnly, r110.getCacheKeyResizeOptions(), r113.mRotationOptions, r113.mImageDecodeOptions, r113.mPostprocessorCacheKey, r113.mPostprocessorName, r113.mCallerContext);
    }

    public BitmapMemoryCacheKey(String r110, @Nullable ResizeOptions r111, RotationOptions r112, ImageDecodeOptions r113, @Nullable CacheKey r114, @Nullable String r115, Object r116) {
        this(r110, false, r111, r112, r113, r114, r115, r116);
    }

    public BitmapMemoryCacheKey(String r100, boolean r101, @Nullable ResizeOptions r102, RotationOptions r110, ImageDecodeOptions r111, @Nullable CacheKey r112, @Nullable String r113, Object r114) {
        this.mSourceString = (String) Preconditions.checkNotNull(r100);
        this.mLoadThumbnailOnly = r101;
        this.mResizeOptions = r102;
        this.mRotationOptions = r110;
        this.mImageDecodeOptions = r111;
        this.mPostprocessorCacheKey = r112;
        this.mPostprocessorName = r113;
        Integer r103 = Integer.valueOf(r100.hashCode());
        int r104 = 0;
        if (r102 != null) goto L5;
    L7:
        int r105 = 0;
    L8:
        Integer r106 = Integer.valueOf(r105);
        if (r110 == null) goto L11;
        r104 = r110.hashCode();
    L11:
        Integer r107 = Integer.valueOf(r104);
        ImageDecodeOptions r115 = r111;
        if (FrescoCacheMonitorUtil.isOptBitmapCacheKey() == false) goto L14;
        r115 = r111.toOptKeyString();
    L14:
        this.mHash = HashCodeUtil.hashCode(r103, r106, r107, r115, r112, r113);
        this.mCallerContext = r114;
        this.mCacheTime = RealtimeSinceBootClock.get().now();
        return;
    L5:
        if (MemoryCacheUtil.isOptReuseBitmapCache() == true) goto L7;
        r105 = r102.hashCode();
        goto L8
    }
}
