package com.bytedance.awemeopen.apps.framework.utils;

import java.math.BigDecimal;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public final class n {
    public static String b(long r100) {
        if ((r100 % 100) != 0) goto L7;
        return String.valueOf(r100 / 100);
    L7:
        if ((r100 % 10) != 0) goto L11;
        return String.format(Locale.getDefault(), "%.1f", new Object[]{Double.valueOf(a(r100, 1))});
    L11:
        return String.format(Locale.getDefault(), "%.2f", new Object[]{Double.valueOf(a(r100, 2))});
    }

    public static double a(double r100, int r101) {
        if (r101 < 0) goto L6;
        return new BigDecimal(Double.toString(r100)).divide(new BigDecimal(Double.toString(100.0d)), r101, 4).doubleValue();
    L6:
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
}
