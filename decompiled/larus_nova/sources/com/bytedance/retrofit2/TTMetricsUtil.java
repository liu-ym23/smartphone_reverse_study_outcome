package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes3.dex */
public class TTMetricsUtil {
    public TTMetricsUtil() {
    }

    public static long nanoSecondsToMicroSeconds(long r100) {
        if (r100 != (-1)) goto L6;
        return -1;
    L6:
        return r100 / 1000;
    }

    public static long nanoSecondsToMilliSeconds(long r100) {
        if (r100 != (-1)) goto L6;
        return -1;
    L6:
        return r100 / 1000000;
    }

    public static long calculateDurationUs(long r100, long r101) {
        if (r100 != (-1)) goto L5;
    L11:
        return -1;
    L5:
        if (r101 == (-1)) goto L11;
        if (r100 > r101) goto L11;
        return nanoSecondsToMicroSeconds(r101 - r100);
    }

    public static long calculateWallClockTimeMs(long r100, long r101, long r102) {
        if (r100 >= 0) goto L5;
    L14:
        return -1;
    L5:
        if (r101 < 0) goto L14;
        if (r102 < 0) goto L14;
        if (r101 <= r102) goto L13;
        return -1;
    L13:
        return nanoSecondsToMilliSeconds(r102 - r101) + r100;
    }
}
