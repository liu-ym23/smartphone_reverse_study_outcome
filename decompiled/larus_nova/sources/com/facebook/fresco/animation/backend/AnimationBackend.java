package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.imageformat.ImageFormat;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public interface AnimationBackend extends AnimationInformation, AnimationSourceInfo {
    public static final int INTRINSIC_DIMENSION_UNSET = -1;

    void clear();

    boolean drawFrame(Drawable r100, Canvas r101, int r102);

    @Override // com.facebook.fresco.animation.backend.AnimationSourceInfo
    ImageFormat getImageFormat();

    int getIntrinsicHeight();

    int getIntrinsicWidth();

    int getSizeInBytes();

    boolean hasCacheFrame(int r100);

    boolean isAnimatedHeifIndividualCacheEnabled();

    void setAlpha(int r100);

    void setBounds(Rect r100);

    void setColorFilter(@Nullable ColorFilter r100);
}
