package com.bytedance.ies.bullet.service.preload;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends BasePostprocessor {
    public d() {
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceBitmap");
        Intrinsics.checkNotNullParameter(r101, "bitmapFactory");
        CloseableReference<Bitmap> r102 = r101.createBitmapInternal(r100.getWidth(), r100.getHeight(), Bitmap.Config.RGB_565);     // Catch: Throwable -> L9
        new Canvas(r102.get()).drawBitmap(r100, 0.0f, 0.0f, null);     // Catch: Throwable -> L7
        CloseableReference<Bitmap> r103 = CloseableReference.cloneOrNull(r102);     // Catch: Throwable -> L7
        CloseableReference.closeSafely(r102);
        return r103;
    L7:
        Throwable th10 = th;
    L21:
        th10.getMessage();     // Catch: Throwable -> L14
        CloseableReference.closeSafely(r102);
        return super.process(r100, r101);
    L14:
        th = move-exception;
        CloseableReference.closeSafely(r102);
        throw th;
    L9:
        th = move-exception;
        r102 = null;
        th10 = th;
        goto L21
    }
}
