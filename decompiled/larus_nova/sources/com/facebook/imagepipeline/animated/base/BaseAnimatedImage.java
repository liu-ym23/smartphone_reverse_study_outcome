package com.facebook.imagepipeline.animated.base;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BaseAnimatedImage implements AnimatedImage {
    protected int mDecodeStatus;

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedImage cloneOrNull() {
        return null;
    }

    public BaseAnimatedImage() {
        this.mDecodeStatus = 0;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getDecodeStatus() {
        return this.mDecodeStatus;
    }

    public void setDecodeStatus(int r100) {
        this.mDecodeStatus = r100;
    }
}
