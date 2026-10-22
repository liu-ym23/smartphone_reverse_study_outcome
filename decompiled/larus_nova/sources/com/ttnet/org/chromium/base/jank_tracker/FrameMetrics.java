package com.ttnet.org.chromium.base.jank_tracker;

/* JADX INFO: loaded from: classes41.dex */
class FrameMetrics {
    public final Long[] durationsNs;
    public final Integer[] skippedFrames;
    public final Long[] timestampsNs;

    public FrameMetrics() {
        this.timestampsNs = new Long[0];
        this.durationsNs = new Long[0];
        this.skippedFrames = new Integer[0];
    }

    public FrameMetrics(Long[] r100, Long[] r101, Integer[] r102) {
        this.timestampsNs = r100;
        this.durationsNs = r101;
        this.skippedFrames = r102;
    }
}
