package com.facebook.imagepipeline.drawable;

import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public interface DrawableFactory {
    @Nullable
    Drawable createDrawable(CloseableImage r100);

    @Nullable
    Drawable createDrawable(CloseableImage r100, Drawable r101);

    boolean supportsImageType(CloseableImage r100);
}
