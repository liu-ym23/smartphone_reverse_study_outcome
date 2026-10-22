package rw2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.bytedance.android.live.core.log.ALogger;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements Postprocessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539591a;

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final String getName() {
        return "ContentCirclePostprocessor";
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey(this.f539591a);
    }

    public a() {
        this.f539591a = "content_circle_10";
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference<Bitmap> process(Bitmap r110, PlatformBitmapFactory r111) {
        Intrinsics.checkNotNullParameter(r110, "sourceBitmap");
        Intrinsics.checkNotNullParameter(r111, "bitmapFactory");
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        int r102 = -1;
        int r103 = r100;
        int r104 = r101;
        int r105 = -1;
        int r106 = 0;
    L3:
        if (r106 >= r101) goto L13;
        int r112 = 0;
    L5:
        if (r112 >= r100) goto L11;
        if (Color.alpha(r110.getPixel(r112, r106)) <= 10) goto L10;
        double r113 = r112;
        r103 = (int) Math.min(r103, r113);
        double r107 = r106;
        r104 = (int) Math.min(r104, r107);
        r102 = (int) Math.max(r102, r113);
        r105 = (int) Math.max(r105, r107);
    L10:
        r112 = r112 + 1;
        goto L5
    L11:
        r106 = r106 + 1;
        goto L3
    L13:
        if (r102 < r103) goto L16;
        if (r105 < r104) goto L16;
        Rect r108 = new Rect(r103, r104, r102 + 1, r105 + 1);
    L18:
        if (r108.isEmpty() == false) goto L30;
        CloseableReference<Bitmap> r109 = r111.createBitmap(1, 1);
        r109.get().eraseColor(0);     // Catch: Throwable -> L23 Exception -> L25
        CloseableReference<Bitmap> r114 = CloseableReference.cloneOrNull(r109);     // Catch: Throwable -> L23 Exception -> L25
        CloseableReference.closeSafely(r109);
        return r114;
    L23:
        th = move-exception;
        CloseableReference.closeSafely(r109);
        throw th;
    L25:
        e = move-exception;
        ALogger.e("ContentCirclePostprocessor", "EXCEPTION IS " + e.getMessage());     // Catch: Throwable -> L23
        CloseableReference.closeSafely(r109);
    L30:
        int r115 = Math.max(r108.width(), r108.height());
        CloseableReference<Bitmap> r116 = r111.createBitmap(r115, r115);
        Canvas r117 = new Canvas(r116.get());     // Catch: Throwable -> L34
        r117.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L34
        float r118 = r115;
        float r119 = (float) Math.min(r118 / r108.width(), r118 / r108.height());     // Catch: Throwable -> L34
        float r120 = (r118 - (r108.width() * r119)) / 2.0f;     // Catch: Throwable -> L34
        float r121 = (r118 - (r108.height() * r119)) / 2.0f;     // Catch: Throwable -> L34
        Matrix r122 = new Matrix();     // Catch: Throwable -> L34
        r122.setScale(r119, r119);     // Catch: Throwable -> L34
        r122.postTranslate(r120 - (r108.left * r119), r121 - (r108.top * r119));     // Catch: Throwable -> L34
        r117.drawBitmap(r110, r122, new Paint(3));     // Catch: Throwable -> L34
        CloseableReference<Bitmap> r123 = CloseableReference.cloneOrNull(r116);     // Catch: Throwable -> L34
        CloseableReference.closeSafely(r116);
        return r123;
    L34:
        th = move-exception;
        CloseableReference.closeSafely(r116);
        throw th;
    L16:
        r108 = new Rect();
        goto L18
    }
}
