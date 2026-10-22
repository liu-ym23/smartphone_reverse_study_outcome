package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface PlatformDecoder {
    CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage r100, Bitmap.Config r101, @Nullable Rect r102);

    CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage r100, Bitmap.Config r101, @Nullable Rect r102, boolean r103);

    CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage r100, Bitmap.Config r101, @Nullable Rect r102, int r103);

    CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage r100, Bitmap.Config r101, @Nullable Rect r102, int r103, boolean r104);
}
