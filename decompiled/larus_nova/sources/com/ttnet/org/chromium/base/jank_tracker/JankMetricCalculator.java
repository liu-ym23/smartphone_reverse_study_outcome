package com.ttnet.org.chromium.base.jank_tracker;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
class JankMetricCalculator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long JANK_BURST_CONSECUTIVE_FRAME_THRESHOLD_NS = 50000000;
    private static final long JANK_THRESHOLD_NS = 16000000;
    private static final long NANOSECONDS_PER_MILLISECOND = 1000000;

    public JankMetricCalculator() {
    }

    static {
    }

    public static JankMetrics calculateJankMetrics(FrameMetrics r100) {
        long[] r101 = longArrayToPrimitiveArray(r100.timestampsNs);
        long[] r102 = longArrayToPrimitiveArray(r100.durationsNs);
        int r103 = sumArray(r100.skippedFrames);
        return new JankMetrics(r101, r102, calculateJankBurstDurationsNs(r101, r102), r103);
    }

    private static long[] longArrayToPrimitiveArray(Long[] r100) {
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = r100[r102].longValue();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    private static int sumArray(Integer[] r100) {
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r103 = r103 + r100[r102].intValue();
        r102 = r102 + 1;
        goto L3
    L5:
        return r103;
    }

    private static long[] calculateJankBurstDurationsNs(long[] r110, long[] r111) {
        ArrayList r100 = new ArrayList();
        int r101 = 0;
        long r102 = 0;
    L4:
        if (r101 >= r110.length) goto L26;
        if (r101 > 0) goto L7;
    L11:
        long r103 = r111[r101];
        if (isFrameJanky(r101, r111) == false) goto L15;
    L13:
        r102 = r102 + r103;
    L24:
        r101 = r101 + 1;
        goto L4
    L15:
        if (r102 <= 0) goto L24;
        if (areFramesConsecutive(r101 - 1, r101, r110, r111) == false) goto L23;
        int r104 = r101 + 1;
        if (areFramesConsecutive(r101, r104, r110, r111) == false) goto L23;
        if (isFrameJanky(r104, r111) == true) goto L13;
    L23:
        r100.add(Long.valueOf(r102));
        r102 = 0;
        goto L24
    L7:
        if (r102 <= 0) goto L11;
        if (areFramesConsecutive(r101 - 1, r101, r110, r111) == true) goto L11;
        r100.add(Long.valueOf(r102));
        r102 = 0;
        goto L11
    L26:
        if (r102 <= 0) goto L29;
        r100.add(Long.valueOf(r102));
    L29:
        return longArrayToPrimitiveArray((Long[]) r100.toArray(new Long[r100.size()]));
    }

    private static boolean isFrameJanky(int r100, long[] r101) {
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if (r100 < r101.length) goto L8;
        return false;
    L8:
        if (r101[r100] <= JANK_THRESHOLD_NS) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean areFramesConsecutive(int r100, int r101, long[] r102, long[] r103) {
        if (r100 < 0) goto L15;
        if (r101 >= 0) goto L7;
        return false;
    L7:
        if (r100 < r102.length) goto L9;
        return false;
    L9:
        if (r101 >= r102.length) goto L19;
        long r104 = r102[r100];
        if (((r102[r101] - r103[r101]) - r104) >= JANK_BURST_CONSECUTIVE_FRAME_THRESHOLD_NS) goto L17;
        return true;
    L17:
        return false;
    L19:
        return false;
    L15:
        return false;
    }
}
