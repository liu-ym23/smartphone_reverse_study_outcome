package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.filter.InPlaceRoundFilter;
import com.facebook.imagepipeline.filter.XferRoundFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class RoundPostprocessor extends BasePostprocessor {
    private static final boolean ENABLE_ANTI_ALIASING = true;
    private static final boolean canUseXferRoundFilter = false;

    @Nullable
    private CacheKey mCacheKey;
    private final boolean mEnableAntiAliasing;

    public RoundPostprocessor() {
        this(true);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey != null) goto L9;
        if (canUseXferRoundFilter == false) goto L7;
        this.mCacheKey = new SimpleCacheKey("XferRoundFilter");
        goto L9
    L7:
        this.mCacheKey = new SimpleCacheKey("InPlaceRoundFilter");
    L9:
        return this.mCacheKey;
    }

    static {
        canUseXferRoundFilter = XferRoundFilter.canUseXferRoundFilter();
    }

    public RoundPostprocessor(boolean r100) {
        this.mEnableAntiAliasing = r100;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap r100) {
        InPlaceRoundFilter.roundBitmapInPlace(r100);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap r100, Bitmap r101) {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        if (canUseXferRoundFilter == false) goto L5;
        XferRoundFilter.xferRoundBitmap(r100, r101, this.mEnableAntiAliasing);
        return;
    L5:
        super.process(r100, r101);
    }
}
