package com.facebook.fresco.animation.frame;

/* JADX INFO: loaded from: classes23.dex */
public interface FrameScheduler {
    public static final int FRAME_NUMBER_DONE = -1;
    public static final int NO_NEXT_TARGET_RENDER_TIME = -1;

    FrameScheduler forNewFrameScheduler(FrameScheduler r100);

    int getFrameNumberToRender(long r100, long r101);

    long getLoopDurationMs();

    long getTargetRenderTimeForNextFrameMs(long r100);

    long getTargetRenderTimeMs(int r100);

    boolean isInfiniteAnimation();

    void setStartTime(long r100);
}
