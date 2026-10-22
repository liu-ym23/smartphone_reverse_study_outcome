package com.bytedance.fresco.sr;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* JADX INFO: loaded from: classes19.dex */
interface ISuperResolution {
    void destroy();

    String getSRType();

    String getScaleType();

    CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) throws Exception;

    CloseableReference<Bitmap> processMultiScaleBitmap(int r100, Bitmap r101, PlatformBitmapFactory r102, int r103) throws Exception;

    CloseableReference<Bitmap> processMultiScaleBitmap(boolean r100, Bitmap r101, PlatformBitmapFactory r102, int r103, int r104) throws Exception;
}
