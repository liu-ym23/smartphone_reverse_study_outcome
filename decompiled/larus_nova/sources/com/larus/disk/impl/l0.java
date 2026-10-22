package com.larus.disk.impl;

import java.util.concurrent.TimeUnit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f330752a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f330753b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f330754c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f330755d = 0;

    public static final long a(long r100, long r101) {
        if ((Long.MAX_VALUE - r100) >= r101) goto L6;
        return Long.MAX_VALUE;
    L6:
        return r100 + r101;
    }

    static {
        TimeUnit r100 = TimeUnit.DAYS;
        f330752a = r100.toMillis(7);
        f330753b = r100.toMillis(30);
        f330754c = r100.toMillis(1);
    }

    public static final k0 b(long r110, long r111, long r112, long r113) {
        boolean r100 = false;
        long r101 = 0;
        if (r110 <= 0) goto L5;
        long r102 = RangesKt.coerceAtLeast(r111, 0);
        if (r110 < r113) goto L9;
        r100 = true;
    L9:
        long r103 = RangesKt.coerceAtLeast(r112 - r110, 0);
        if (r100 == true) goto L12;
    L14:
        long r104 = 0;
    L15:
        if (r100 == false) goto L20;
        if (r103 > f330753b) goto L20;
        r101 = r102;
    L20:
        return new k0(r102, r104, r101, 1);
    L12:
        if (r103 > f330752a) goto L14;
        r104 = r102;
        goto L15
    L5:
        return new k0(0);
    }
}
