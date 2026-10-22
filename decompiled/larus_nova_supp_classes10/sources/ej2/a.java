package ej2;

import android.graphics.Bitmap;
import com.bytedance.android.ui.ec.widget.tools.BlurImage;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements Postprocessor {
    public final String getName() {
        return "blurProcessor";
    }

    public final CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey("blur_bitmap_processor");
    }

    public a() {
    }

    public final CloseableReference<Bitmap> process(Bitmap r7, PlatformBitmapFactory r8) {
        int r0 = r7.getWidth();
        int r1 = r7.getHeight();
        if (r0 < 100) goto L12;
        if (r1 < 100) goto L12;
        if (r0 < 200) goto L11;
        if (r1 < 200) goto L11;
        float r2 = 0.1f;
    L13:
        int r3 = Math.round(r0 * r2);
        int r4 = Math.round(r1 * r2);
        Bitmap r9 = Bitmap.createScaledBitmap(r7, r3, r4, false);
        float r5 = r3;
        if (r4 == 0) goto L16;
        float r6 = r5 / r4;
    L18:
        if (Math.abs(r6 - 5) <= 0.2f) goto L24;
        int r10 = (int) (r5 / 1.0f);
        if (r10 <= r4) goto L22;
        int r11 = (int) (r4 * 1.0f);
        int r12 = r4;
    L23:
        Bitmap r13 = Bitmap.createBitmap(r9, (r3 - r11) >> 1, (r4 - r12) >> 1, r11, r12);
        r9.recycle();
        r9 = r13;
        r3 = r11;
        r4 = r12;
        goto L24
    L22:
        r12 = r10;
        r11 = r3;
    L24:
        CloseableReference<Bitmap> r14 = r8.createBitmap(r3, r4);
        BlurImage.blur(r9, (Bitmap) r14.get(), 5);
        r9.recycle();
        return r14;
    L16:
        r6 = r5;
    L11:
        r2 = 0.3f;
    L12:
        r2 = 0.6f;
        goto L13
    }
}
