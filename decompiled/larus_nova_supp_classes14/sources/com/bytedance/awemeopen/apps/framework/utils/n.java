package com.bytedance.awemeopen.apps.framework.utils;

import java.math.BigDecimal;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n {
    public static String b(long r7) {
        if ((r7 % 100) != 0) goto L7;
        return String.valueOf(r7 / 100);
    L7:
        if ((r7 % 10) != 0) goto L11;
        return String.format(Locale.getDefault(), "%.1f", new Object[]{Double.valueOf(a(r7, 1))});
    L11:
        return String.format(Locale.getDefault(), "%.2f", new Object[]{Double.valueOf(a(r7, 2))});
    }

    public static double a(double r3, int r5) {
        if (r5 < 0) goto L6;
        return new BigDecimal(Double.toString(r3)).divide(new BigDecimal(Double.toString(100.0d)), r5, 4).doubleValue();
    L6:
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
}
