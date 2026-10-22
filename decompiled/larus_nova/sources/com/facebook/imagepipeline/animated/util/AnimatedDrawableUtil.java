package com.facebook.imagepipeline.animated.util;

import android.graphics.Bitmap;
import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedDrawableUtil {
    private static final int FRAME_DURATION_MS_FOR_MIN = 100;
    private static final int MIN_FRAME_DURATION_MS = 11;

    public AnimatedDrawableUtil() {
    }

    public static boolean isOutsideRange(int r100, int r101, int r102) {
        if (r100 == (-1)) goto L14;
        if (r101 != (-1)) goto L7;
        return true;
    L7:
        if (r100 > r101) goto L12;
        if (r102 < r100) goto L15;
        if (r102 > r101) goto L19;
    L11:
        return false;
    L19:
        return true;
    L15:
        return true;
    L12:
        if (r102 >= r100) goto L11;
        if (r102 <= r101) goto L11;
        return true;
    L14:
        return true;
    }

    public void fixFrameDurations(int[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L9;
        if (r100[r101] >= 11) goto L8;
        r100[r101] = 100;
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public int[] getFrameTimeStampsFromDurations(int[] r100) {
        int[] r101 = new int[r100.length];
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = r103;
        r103 = r103 + r100[r102];
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public int getSizeOfBitmap(Bitmap r100) {
        return r100.getAllocationByteCount();
    }

    public int getTotalDurationFromFrameDurations(int[] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        r102 = r102 + r100[r101];
        r101 = r101 + 1;
        goto L4
    L6:
        return r102;
    }

    public int getFrameForTimestampMs(int[] r100, int r101) {
        int r102 = Arrays.binarySearch(r100, r101);
        if (r102 < 0) goto L5;
        return r102;
    L5:
        return ((-r102) - 1) - 1;
    }
}
