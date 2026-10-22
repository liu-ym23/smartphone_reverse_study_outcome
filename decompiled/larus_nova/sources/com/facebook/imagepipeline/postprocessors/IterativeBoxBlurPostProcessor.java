package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class IterativeBoxBlurPostProcessor extends BasePostprocessor {
    private static final int DEFAULT_ITERATIONS = 3;
    private final int mBlurRadius;
    private CacheKey mCacheKey;
    private final int mIterations;

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "IterativeBoxBlurPostProcessor";
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey != null) goto L6;
        this.mCacheKey = new SimpleCacheKey(String.format(null, "i%dr%d", new Object[]{Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius)}));
    L6:
        return this.mCacheKey;
    }

    public IterativeBoxBlurPostProcessor(int r100) {
        this(3, r100);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap r100) {
        NativeBlurFilter.iterativeBoxBlur(r100, this.mIterations, this.mBlurRadius);
    }

    public IterativeBoxBlurPostProcessor(int r100, int r101) {
        boolean r102 = true;
        if (r100 <= 0) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103);
        if (r101 > 0) goto L10;
        r102 = false;
    L10:
        Preconditions.checkArgument(r102);
        this.mIterations = r100;
        this.mBlurRadius = r101;
        return;
    L5:
        r103 = false;
        goto L6
    }
}
