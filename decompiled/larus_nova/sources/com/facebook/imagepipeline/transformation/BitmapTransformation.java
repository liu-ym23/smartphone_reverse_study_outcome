package com.facebook.imagepipeline.transformation;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes23.dex */
public interface BitmapTransformation {
    boolean modifiesTransparency();

    void transform(Bitmap r100);
}
