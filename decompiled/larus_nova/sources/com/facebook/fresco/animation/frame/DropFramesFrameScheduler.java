package com.facebook.fresco.animation.frame;

import com.facebook.fresco.animation.backend.AnimationInformation;

/* JADX INFO: loaded from: classes23.dex */
public class DropFramesFrameScheduler implements FrameScheduler {
    private static final int UNSET = -1;
    private final AnimationInformation mAnimationInformation;
    private long mLoopDurationMs;

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public FrameScheduler forNewFrameScheduler(FrameScheduler r100) {
        return null;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public void setStartTime(long r100) {
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getLoopDurationMs() {
        long r100 = this.mLoopDurationMs;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        this.mLoopDurationMs = 0;
        int r101 = this.mAnimationInformation.getFrameCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L9;
        this.mLoopDurationMs += (long) this.mAnimationInformation.getFrameDurationMs(r102);
        r102 = r102 + 1;
        goto L6
    L9:
        return this.mLoopDurationMs;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public boolean isInfiniteAnimation() {
        if (this.mAnimationInformation.getLoopCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public DropFramesFrameScheduler(AnimationInformation r100) {
        this.mLoopDurationMs = -1;
        this.mAnimationInformation = r100;
    }

    public int getFrameNumberWithinLoop(long r100) {
        int r101 = 0;
        long r102 = 0;
    L3:
        r102 = r102 + ((long) this.mAnimationInformation.getFrameDurationMs(r101));
        r101 = r101 + 1;
        if (r100 >= r102) goto L3;
        return r101 - 1;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeForNextFrameMs(long r110) {
        long r100 = getLoopDurationMs();
        long r101 = 0;
        if (r100 != 0) goto L6;
        return -1;
    L6:
        if (isInfiniteAnimation() == false) goto L8;
    L10:
        long r102 = r110 % r100;
        int r103 = this.mAnimationInformation.getFrameCount();
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L16;
        if (r101 > r102) goto L16;
        r101 = r101 + ((long) this.mAnimationInformation.getFrameDurationMs(r104));
        r104 = r104 + 1;
    L16:
        return r110 + (r101 - r102);
    L8:
        if ((r110 / getLoopDurationMs()) < this.mAnimationInformation.getLoopCount()) goto L10;
        return -1;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeMs(int r100) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101 = r101 + ((long) this.mAnimationInformation.getFrameDurationMs(r100));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public int getFrameNumberToRender(long r100, long r101) {
        if (isInfiniteAnimation() == true) goto L9;
        if ((r100 / getLoopDurationMs()) < this.mAnimationInformation.getLoopCount()) goto L9;
        return -1;
    L9:
        return getFrameNumberWithinLoop(r100 % getLoopDurationMs());
    }
}
