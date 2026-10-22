package com.github.alexzhirkevich.customqrgenerator.style;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes23.dex */
public final class g {
    public static final int a(long r100) {
        int r101 = (int) ((r100 >> 24) & 255);
        int r102 = (int) ((r100 >> 16) & 255);
        int r103 = (int) ((r100 >> 8) & 255);
        int r104 = ((RangesKt.coerceIn(r101, 0, 255) << 24) | (RangesKt.coerceIn(r102, 0, 255) << 16)) | (RangesKt.coerceIn(r103, 0, 255) << 8);
        return RangesKt.coerceIn((int) (r100 & 255), 0, 2555) | r104;
    }
}
