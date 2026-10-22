package com.ttnet.org.chromium.base.metrics;

import androidx.collection.SieveCacheKt;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes41.dex */
@MainDex
public class RecordHistogram {
    public RecordHistogram() {
    }

    private static int clampToInt(long r100) {
        if (r100 <= SieveCacheKt.NodeLinkMask) goto L7;
        return Integer.MAX_VALUE;
    L7:
        if (r100 >= SieveCacheKt.NodeMetaAndPreviousMask) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) r100;
    }

    public static int getHistogramTotalCountForTesting(String r100) {
        return UmaRecorderHolder.get().getHistogramTotalCountForTesting(r100);
    }

    public static int getHistogramValueCountForTesting(String r100, int r101) {
        return UmaRecorderHolder.get().getHistogramValueCountForTesting(r100, r101);
    }

    public static void recordBooleanHistogram(String r100, boolean r101) {
        UmaRecorderHolder.get().recordBooleanHistogram(r100, r101);
    }

    public static void recordCount100000Histogram(String r100, int r101) {
        UmaRecorderHolder.get().recordExponentialHistogram(r100, r101, 1, 100000, 50);
    }

    public static void recordCount1000Histogram(String r100, int r101) {
        UmaRecorderHolder.get().recordExponentialHistogram(r100, r101, 1, 1000, 50);
    }

    public static void recordCount100Histogram(String r100, int r101) {
        UmaRecorderHolder.get().recordExponentialHistogram(r100, r101, 1, 100, 50);
    }

    public static void recordCount1MHistogram(String r100, int r101) {
        UmaRecorderHolder.get().recordExponentialHistogram(r100, r101, 1, 1000000, 50);
    }

    public static void recordLongTimesHistogram(String r100, long r101) {
        recordCustomTimesHistogramMilliseconds(r100, r101, 1, 3600000, 50);
    }

    public static void recordLongTimesHistogram100(String r100, long r101) {
        recordCustomTimesHistogramMilliseconds(r100, r101, 1, 3600000, 100);
    }

    public static void recordMediumTimesHistogram(String r100, long r101) {
        recordCustomTimesHistogramMilliseconds(r100, r101, 10, 180000, 50);
    }

    public static void recordMemoryKBHistogram(String r100, int r101) {
        UmaRecorderHolder.get().recordExponentialHistogram(r100, r101, 1000, 500000, 50);
    }

    public static void recordPercentageHistogram(String r100, int r101) {
        recordExactLinearHistogram(r100, r101, 101);
    }

    public static void recordSparseHistogram(String r100, int r101) {
        UmaRecorderHolder.get().recordSparseHistogram(r100, r101);
    }

    public static void recordTimesHistogram(String r100, long r101) {
        recordCustomTimesHistogramMilliseconds(r100, r101, 1, 10000, 50);
    }

    public static void recordEnumeratedHistogram(String r100, int r101, int r102) {
        recordExactLinearHistogram(r100, r101, r102);
    }

    public static void recordExactLinearHistogram(String r100, int r101, int r102) {
        UmaRecorder r103 = UmaRecorderHolder.get();
        r103.recordLinearHistogram(r100, r101, 1, r102, r102 + 1);
    }

    public static void recordCustomCountHistogram(String r100, int r101, int r102, int r103, int r110) {
        UmaRecorderHolder.get().recordExponentialHistogram(r100, r101, r102, r103, r110);
    }

    public static void recordCustomTimesHistogram(String r100, long r101, long r102, long r103, int r104) {
        recordCustomTimesHistogramMilliseconds(r100, r101, r102, r103, r104);
    }

    private static void recordCustomTimesHistogramMilliseconds(String r100, long r101, long r102, long r103, int r104) {
        UmaRecorderHolder.get().recordExponentialHistogram(r100, clampToInt(r101), clampToInt(r102), clampToInt(r103), r104);
    }

    public static void recordLinearCountHistogram(String r100, int r101, int r102, int r103, int r110) {
        UmaRecorderHolder.get().recordLinearHistogram(r100, r101, r102, r103, r110);
    }
}
