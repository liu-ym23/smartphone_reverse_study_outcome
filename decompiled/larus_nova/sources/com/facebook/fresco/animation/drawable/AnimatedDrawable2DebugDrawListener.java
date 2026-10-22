package com.facebook.fresco.animation.drawable;

import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.frame.FrameScheduler;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedDrawable2DebugDrawListener implements AnimatedDrawable2.DrawListener {
    private static final Class<?> TAG = null;
    private int mDrawCalls;
    private int mDuplicateFrames;
    private int mLastFrameNumber;
    private int mSkippedFrames;

    static {
        TAG = AnimatedDrawable2DebugDrawListener.class;
    }

    public AnimatedDrawable2DebugDrawListener() {
        this.mLastFrameNumber = -1;
    }

    @Override // com.facebook.fresco.animation.drawable.AnimatedDrawable2.DrawListener
    public void onDraw(AnimatedDrawable2 r110, FrameScheduler r111, int r112, boolean r113, boolean r114, long r115, long r116, long r210, long r211, long r212, long r213, long r214) {
        if (r110.getAnimationBackend() != null) goto L5;
        return;
    L5:
        int r100 = r110.getAnimationBackend().getFrameCount();
        long r101 = r116 - r210;
        this.mDrawCalls++;
        int r102 = this.mLastFrameNumber;
        int r103 = (r102 + 1) % r100;
        if (r103 == r112) goto L13;
        if (r102 != r112) goto L9;
        this.mDuplicateFrames++;
        goto L13
    L9:
        int r104 = (r112 - r103) % r100;
        if (r104 >= 0) goto L12;
        r104 = r104 + r100;
    L12:
        this.mSkippedFrames += r104;
    L13:
        this.mLastFrameNumber = r112;
        FLog.d(TAG, "draw: frame: %2d, drawn: %b, delay: %3d ms, rendering: %3d ms, prev: %3d ms ago, duplicates: %3d, skipped: %3d, draw calls: %4d, anim time: %6d ms, next start: %6d ms, next scheduled: %6d ms", new Object[]{Integer.valueOf(r112), Boolean.valueOf(r113), Long.valueOf((r116 % r111.getLoopDurationMs()) - r111.getTargetRenderTimeMs(r112)), Long.valueOf(r212 - r211), Long.valueOf(r101), Integer.valueOf(this.mDuplicateFrames), Integer.valueOf(this.mSkippedFrames), Integer.valueOf(this.mDrawCalls), Long.valueOf(r116), Long.valueOf(r213), Long.valueOf(r214)});
    }
}
