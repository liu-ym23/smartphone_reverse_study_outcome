package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public interface AnimatedDrawableBackend {
    void dropCaches();

    AnimatedDrawableBackend forNewBounds(Rect r100);

    AnimatedImageResult getAnimatedImageResult();

    int getDurationMs();

    int getDurationMsForFrame(int r100);

    int getFrameCount();

    int getFrameForPreview();

    int getFrameForTimestampMs(int r100);

    AnimatedDrawableFrameInfo getFrameInfo(int r100);

    int getHeight();

    int getLoopCount();

    int getMemoryUsage();

    @Nullable
    CloseableReference<Bitmap> getPreDecodedFrame(int r100);

    int getRenderedHeight();

    int getRenderedWidth();

    int getTimestampMsForFrame(int r100);

    int getWidth();

    boolean hasPreDecodedFrame(int r100);

    boolean isAnimatedHeifIndividualCacheEnabled();

    void renderFrame(int r100, Canvas r101);
}
