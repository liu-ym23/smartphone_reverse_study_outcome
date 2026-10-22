package ej2;

import android.graphics.Bitmap;
import com.bytedance.android.ui.ec.widget.tools.BlurImage;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements Postprocessor {
    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final String getName() {
        return "blurProcessor";
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey("blur_bitmap_processor");
    }

    public a() {
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        if (r102 < 100) goto L12;
        if (r103 < 100) goto L12;
        if (r102 < 200) goto L11;
        if (r103 < 200) goto L11;
        float r104 = 0.1f;
    L13:
        int r105 = Math.round(r102 * r104);
        int r106 = Math.round(r103 * r104);
        Bitmap r107 = Bitmap.createScaledBitmap(r100, r105, r106, false);
        float r108 = r105;
        if (r106 == 0) goto L16;
        float r109 = r108 / r106;
    L18:
        if (Math.abs(r109 - 5) <= 0.2f) goto L24;
        int r110 = (int) (r108 / 1.0f);
        if (r110 <= r106) goto L22;
        int r111 = (int) (r106 * 1.0f);
        int r112 = r106;
    L23:
        Bitmap r113 = Bitmap.createBitmap(r107, (r105 - r111) >> 1, (r106 - r112) >> 1, r111, r112);
        r107.recycle();
        r107 = r113;
        r105 = r111;
        r106 = r112;
        goto L24
    L22:
        r112 = r110;
        r111 = r105;
    L24:
        CloseableReference<Bitmap> r114 = r101.createBitmap(r105, r106);
        BlurImage.blur(r107, r114.get(), 5);
        r107.recycle();
        return r114;
    L16:
        r109 = r108;
    L11:
        r104 = 0.3f;
    L12:
        r104 = 0.6f;
        goto L13
    }
}
