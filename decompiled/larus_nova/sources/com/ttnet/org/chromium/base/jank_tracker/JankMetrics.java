package com.ttnet.org.chromium.base.jank_tracker;

/* JADX INFO: loaded from: classes41.dex */
class JankMetrics {
    public final long[] durationsNs;
    public final long[] jankBurstsNs;
    public final int skippedFrames;
    public final long[] timestampsNs;

    public JankMetrics(long[] r100, long[] r101, long[] r102, int r103) {
        this.timestampsNs = r100;
        this.durationsNs = r101;
        this.jankBurstsNs = r102;
        this.skippedFrames = r103;
    }
}
