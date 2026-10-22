package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes23.dex */
public abstract class DelegatingAnimatedDrawableBackend implements AnimatedDrawableBackend {
    private final AnimatedDrawableBackend mAnimatedDrawableBackend;

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public void dropCaches() {
        this.mAnimatedDrawableBackend.dropCaches();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedImageResult getAnimatedImageResult() {
        return this.mAnimatedDrawableBackend.getAnimatedImageResult();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMs() {
        return this.mAnimatedDrawableBackend.getDurationMs();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameCount() {
        return this.mAnimatedDrawableBackend.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForPreview() {
        return this.mAnimatedDrawableBackend.getFrameForPreview();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getHeight() {
        return this.mAnimatedDrawableBackend.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getLoopCount() {
        return this.mAnimatedDrawableBackend.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getMemoryUsage() {
        return this.mAnimatedDrawableBackend.getMemoryUsage();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedHeight() {
        return this.mAnimatedDrawableBackend.getRenderedHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedWidth() {
        return this.mAnimatedDrawableBackend.getRenderedWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getWidth() {
        return this.mAnimatedDrawableBackend.getWidth();
    }

    public AnimatedDrawableBackend getDelegate() {
        return this.mAnimatedDrawableBackend;
    }

    public DelegatingAnimatedDrawableBackend(AnimatedDrawableBackend r100) {
        this.mAnimatedDrawableBackend = r100;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMsForFrame(int r100) {
        return this.mAnimatedDrawableBackend.getDurationMsForFrame(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForTimestampMs(int r100) {
        return this.mAnimatedDrawableBackend.getFrameForTimestampMs(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableFrameInfo getFrameInfo(int r100) {
        return this.mAnimatedDrawableBackend.getFrameInfo(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public CloseableReference<Bitmap> getPreDecodedFrame(int r100) {
        return this.mAnimatedDrawableBackend.getPreDecodedFrame(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getTimestampMsForFrame(int r100) {
        return this.mAnimatedDrawableBackend.getTimestampMsForFrame(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public boolean hasPreDecodedFrame(int r100) {
        return this.mAnimatedDrawableBackend.hasPreDecodedFrame(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public void renderFrame(int r100, Canvas r101) {
        this.mAnimatedDrawableBackend.renderFrame(r100, r101);
    }
}
