package com.facebook.imagepipeline.animated.factory;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface AnimatedFactory {
    @Nullable
    DrawableFactory getAnimatedDrawableFactory(Context r100);

    @Nullable
    ImageDecoder getGifDecoder(Bitmap.Config r100);

    @Nullable
    ImageDecoder getHeifDecoder(Bitmap.Config r100);

    @Nullable
    ImageDecoder getWebPDecoder(Bitmap.Config r100);
}
