package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;

/* JADX INFO: loaded from: classes23.dex */
public interface AnimatedImageFactory {
    CloseableImage decodeGif(EncodedImage r100, ImageDecodeOptions r101, Bitmap.Config r102);

    CloseableImage decodeHeif(EncodedImage r100, ImageDecodeOptions r101, Bitmap.Config r102);

    CloseableImage decodeWebP(EncodedImage r100, ImageDecodeOptions r101, Bitmap.Config r102);
}
