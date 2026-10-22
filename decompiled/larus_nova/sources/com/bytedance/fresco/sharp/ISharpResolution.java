package com.bytedance.fresco.sharp;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* JADX INFO: loaded from: classes19.dex */
interface ISharpResolution {
    void destroy(int r100);

    CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101, int r102, float r103, float r104, float r105, boolean r106, float r107, float r108) throws Exception;
}
