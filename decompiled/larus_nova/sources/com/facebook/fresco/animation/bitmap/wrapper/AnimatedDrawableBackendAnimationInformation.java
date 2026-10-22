package com.facebook.fresco.animation.bitmap.wrapper;

import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedDrawableBackendAnimationInformation implements AnimationInformation {
    private final AnimatedDrawableBackend mAnimatedDrawableBackend;

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.mAnimatedDrawableBackend.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.mAnimatedDrawableBackend.getLoopCount();
    }

    public AnimatedDrawableBackend getAnimatedDrawableBackend() {
        return this.mAnimatedDrawableBackend;
    }

    public AnimatedDrawableBackendAnimationInformation(AnimatedDrawableBackend r100) {
        this.mAnimatedDrawableBackend = r100;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int r100) {
        return this.mAnimatedDrawableBackend.getDurationMsForFrame(r100);
    }
}
