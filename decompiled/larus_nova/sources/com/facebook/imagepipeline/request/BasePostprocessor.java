package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BasePostprocessor implements Postprocessor {
    public static final Bitmap.Config FALLBACK_BITMAP_CONFIGURATION = null;

    public BasePostprocessor() {
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "Unknown postprocessor";
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        return null;
    }

    public void process(Bitmap r100) {
    }

    static {
        FALLBACK_BITMAP_CONFIGURATION = Bitmap.Config.ARGB_8888;
    }

    private static void internalCopyBitmap(Bitmap r100, Bitmap r101) {
        if (r100.getConfig() != r101.getConfig()) goto L5;
        Bitmaps.copyBitmap(r100, r101);
        return;
    L5:
        new Canvas(r100).drawBitmap(r101, 0.0f, 0.0f, null);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
        Bitmap.Config r102 = r100.getConfig();
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        if (r102 != null) goto L6;
        r102 = FALLBACK_BITMAP_CONFIGURATION;
    L6:
        CloseableReference<Bitmap> r105 = r101.createBitmapInternal(r103, r104, r102);
        process(r105.get(), r100);     // Catch: Throwable -> L10
        CloseableReference<Bitmap> r106 = CloseableReference.cloneOrNull(r105);     // Catch: Throwable -> L10
        CloseableReference.closeSafely(r105);
        return r106;
    L10:
        th = move-exception;
        CloseableReference.closeSafely(r105);
        throw th;
    }

    public void process(Bitmap r100, Bitmap r101) {
        internalCopyBitmap(r100, r101);
        process(r100);
    }

    public CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101, Map<String, String> r102) {
        return process(r100, r101);
    }
}
