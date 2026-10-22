package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class RoundAsCirclePostprocessor extends BasePostprocessor {
    private static final boolean ENABLE_ANTI_ALIASING = true;

    @Nullable
    private CacheKey mCacheKey;
    private final boolean mEnableAntiAliasing;

    public RoundAsCirclePostprocessor() {
        this(true);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey != null) goto L9;
        if (this.mEnableAntiAliasing == false) goto L7;
        this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor#AntiAliased");
        goto L9
    L7:
        this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor");
    L9:
        return this.mCacheKey;
    }

    public RoundAsCirclePostprocessor(boolean r100) {
        this.mEnableAntiAliasing = r100;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap r100) {
        NativeRoundingFilter.toCircle(r100, this.mEnableAntiAliasing);
    }
}
