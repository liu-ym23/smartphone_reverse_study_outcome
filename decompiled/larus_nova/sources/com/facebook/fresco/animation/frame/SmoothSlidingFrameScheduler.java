package com.facebook.fresco.animation.frame;

import com.facebook.fresco.animation.backend.AnimationBackend;

/* JADX INFO: loaded from: classes23.dex */
public class SmoothSlidingFrameScheduler implements FrameScheduler {
    private static final String TAG = "FrameScheduler";
    private static final int UNSET = -1;
    private final AnimationBackend mAnimationBackend;
    private int mDecodeStatus;
    private int mFrameNumber;
    private long mLastDrawTimeMs;
    private int mLoopCount;
    private long mLoopDurationMs;
    private long mNowAnimationTimeMs;

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
        int r101 = this.mAnimationBackend.getFrameCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L9;
        this.mLoopDurationMs += (long) this.mAnimationBackend.getFrameDurationMs(r102);
        r102 = r102 + 1;
        goto L6
    L9:
        return this.mLoopDurationMs;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public boolean isInfiniteAnimation() {
        if (this.mAnimationBackend.getLoopCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public SmoothSlidingFrameScheduler(AnimationBackend r100) {
        this(r100, 0);
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public FrameScheduler forNewFrameScheduler(FrameScheduler r100) {
        if ((r100 instanceof SmoothSlidingFrameScheduler) == false) goto L6;
        SmoothSlidingFrameScheduler r101 = (SmoothSlidingFrameScheduler) r100;
        SmoothSlidingFrameScheduler r102 = new SmoothSlidingFrameScheduler(r101.mAnimationBackend, r101.mDecodeStatus);
        r102.mFrameNumber = this.mFrameNumber;
        r102.mLastDrawTimeMs = this.mLastDrawTimeMs;
        r102.mLoopCount = this.mLoopCount;
        r102.mNowAnimationTimeMs = this.mNowAnimationTimeMs;
        return r102;
    L6:
        return null;
    }

    public int getFrameNumberWithinLoop(long r100) {
        int r101 = 0;
        long r102 = 0;
    L3:
        r102 = r102 + ((long) this.mAnimationBackend.getFrameDurationMs(r101));
        r101 = r101 + 1;
        if (r100 >= r102) goto L3;
        return r101 - 1;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeForNextFrameMs(long r100) {
        if (getLoopDurationMs() != 0) goto L6;
        return -1;
    L6:
        if (isInfiniteAnimation() == false) goto L8;
    L10:
        long r101 = this.mAnimationBackend.getFrameDurationMs(this.mFrameNumber);
        long r102 = this.mNowAnimationTimeMs + r101;
        if (r102 < r100) goto L14;
        return r102;
    L14:
        return r100 + r101;
    L8:
        if (this.mLoopCount < this.mAnimationBackend.getLoopCount()) goto L10;
        return -1;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeMs(int r100) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101 = r101 + ((long) this.mAnimationBackend.getFrameDurationMs(r100));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public SmoothSlidingFrameScheduler(AnimationBackend r100, int r101) {
        this.mLoopDurationMs = -1;
        this.mLoopCount = 0;
        this.mFrameNumber = -1;
        this.mNowAnimationTimeMs = -1;
        this.mLastDrawTimeMs = -1;
        this.mAnimationBackend = r100;
        this.mDecodeStatus = r101;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public int getFrameNumberToRender(long r100, long r110) {
        long r101 = getLoopDurationMs();
        if (r101 != 0) goto L6;
        return -1;
    L6:
        if (isInfiniteAnimation() == false) goto L8;
    L10:
        int r102 = getFrameNumberWithinLoop(r100 % r101);
        int r103 = this.mFrameNumber;
        int r104 = 0;
        if (r103 != (-1)) goto L13;
    L35:
        this.mNowAnimationTimeMs = r100;
        this.mLastDrawTimeMs = r100;
        this.mFrameNumber = r102;
        this.mLoopCount = 0;
        return r102;
    L13:
        if (r110 != this.mLastDrawTimeMs) goto L35;
        this.mLastDrawTimeMs = r100;
        if ((this.mNowAnimationTimeMs + this.mAnimationBackend.getFrameDurationMs(r103)) > r100) goto L18;
        this.mNowAnimationTimeMs = r100;
        int r105 = this.mFrameNumber + 1;
        if (r105 < this.mAnimationBackend.getFrameCount()) goto L28;
        int r111 = this.mDecodeStatus;
        if (r111 != 0) goto L24;
    L27:
        this.mLoopCount++;
    L30:
        if (this.mAnimationBackend.hasCacheFrame(r104) == false) goto L34;
        this.mFrameNumber = r104;
        return r104;
    L34:
        return this.mFrameNumber;
    L24:
        if (r111 == 3) goto L27;
        r104 = r105 - 1;
        goto L30
    L28:
        r104 = r105;
        goto L30
    L18:
        return this.mFrameNumber;
    L8:
        if ((r100 / r101) < this.mAnimationBackend.getLoopCount()) goto L10;
        return -1;
    }
}
