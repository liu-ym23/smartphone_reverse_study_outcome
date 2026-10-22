package com.facebook.imagepipeline.postprocessors;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.filter.IterativeBoxBlurFilter;
import com.facebook.imagepipeline.filter.RenderScriptBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class BlurPostProcessor extends BasePostprocessor {
    private static final int DEFAULT_ITERATIONS = 3;
    private static final boolean canUseRenderScript = false;
    private final int mBlurRadius;
    private CacheKey mCacheKey;
    private final Context mContext;
    private final int mIterations;

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey != null) goto L10;
        if (canUseRenderScript == false) goto L7;
        String r100 = String.format(null, "IntrinsicBlur;%d", new Object[]{Integer.valueOf(this.mBlurRadius)});
    L8:
        this.mCacheKey = new SimpleCacheKey(r100);
        goto L10
    L7:
        r100 = String.format(null, "IterativeBoxBlur;%d;%d", new Object[]{Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius)});
    L10:
        return this.mCacheKey;
    }

    static {
        canUseRenderScript = RenderScriptBlurFilter.canUseRenderScript();
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap r100) {
        IterativeBoxBlurFilter.boxBlurBitmapInPlace(r100, this.mIterations, this.mBlurRadius);
    }

    public BlurPostProcessor(int r100, Context r101) {
        this(r100, r101, 3);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
        if (r100.getConfig().equals(Bitmap.Config.ARGB_8888) == true) goto L5;
        Bitmap r102 = r100.copy(Bitmap.Config.ARGB_8888, true);
    L6:
        CloseableReference<Bitmap> r103 = r101.createBitmapInternal(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        process(r103.get(), r102);     // Catch: Throwable -> L10
        CloseableReference<Bitmap> r104 = CloseableReference.cloneOrNull(r103);     // Catch: Throwable -> L10
        CloseableReference.closeSafely(r103);
        return r104;
    L10:
        th = move-exception;
        CloseableReference.closeSafely(r103);
        throw th;
    L5:
        r102 = r100;
        goto L6
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap r100, Bitmap r101) {
        if (canUseRenderScript == false) goto L5;
        RenderScriptBlurFilter.blurBitmap(r100, r101, this.mContext, this.mBlurRadius);
        return;
    L5:
        super.process(r100, r101);
    }

    public BlurPostProcessor(int r100, Context r101, int r102) {
        boolean r103 = true;
        if (r100 > 0) goto L5;
    L7:
        boolean r104 = false;
    L8:
        Preconditions.checkArgument(r104);
        if (r102 > 0) goto L12;
        r103 = false;
    L12:
        Preconditions.checkArgument(r103);
        Preconditions.checkNotNull(r101);
        this.mIterations = r102;
        this.mBlurRadius = r100;
        this.mContext = r101;
        return;
    L5:
        if (r100 > 25) goto L7;
        r104 = true;
        goto L8
    }
}
