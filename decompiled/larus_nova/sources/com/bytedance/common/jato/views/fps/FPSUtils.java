package com.bytedance.common.jato.views.fps;

/* JADX INFO: loaded from: classes15.dex */
public class FPSUtils {
    private long[] mFpsBuffer;
    private int mFrameSize;
    private int mIdx;

    public float getFPS() {
        long[] r100 = this.mFpsBuffer;
        int r101 = this.mIdx;
        int r102 = this.mFrameSize;
        return 1000.0f / ((r100[((r101 + r102) - 1) % r102] - r100[r101]) / (r102 - 1));
    }

    public int getIndex() {
        return this.mIdx;
    }

    public FPSUtils(int r100) {
        this.mIdx = 0;
        this.mFrameSize = r100;
        this.mFpsBuffer = new long[r100];
    }

    public void addFrame(long r100) {
        long[] r101 = this.mFpsBuffer;
        int r102 = this.mIdx;
        r101[r102] = r100;
        this.mIdx = (r102 + 1) % this.mFrameSize;
    }
}
