package com.bytedance.android.shopping.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(int r5) {
        int r0 = r5 / 60;
        int r6 = r5 - (r0 * 60);
        StringBuilder r1 = new StringBuilder();
        if (r0 >= 10) goto L5;
        String r2 = "0" + r0;
    L6:
        r1.append(r2);
        r1.append(':');
        if (r6 >= 10) goto L9;
        String r7 = "0" + r6;
    L10:
        r1.append(r7);
        return r1.toString();
    L9:
        r7 = String.valueOf(r6);
        goto L10
    L5:
        r2 = String.valueOf(r0);
        goto L6
    }

    public static String c(long r7) {
        long r0 = 60;
        long r2 = r7 / r0;
        long r8 = r7 - (r0 * r2);
        StringBuilder r1 = new StringBuilder();
        long r4 = 10;
        if (r2 >= r4) goto L5;
        String r3 = "0" + r2;
    L6:
        r1.append(r3);
        r1.append(':');
        if (r8 >= r4) goto L9;
        String r9 = "0" + r8;
    L10:
        r1.append(r9);
        return r1.toString();
    L9:
        r9 = String.valueOf(r8);
        goto L10
    L5:
        r3 = String.valueOf(r2);
        goto L6
    }

    public static String d(long r8) {
        long r1 = 100;
        if ((r8 % r1) != 0) goto L6;
        return String.valueOf(r8 / r1);
    L6:
        if ((r8 % ((long) 10)) != 0) goto L8;
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(a(r8, 100, 1))}, 1));
    L8:
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(a(r8, 100, 2))}, 1));
    }

    public static double a(double r1, double r3, int r5) {
        if (r5 < 0) goto L6;
        return new BigDecimal(String.valueOf(r1)).divide(new BigDecimal(String.valueOf(r3)), r5, 4).doubleValue();
    L6:
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
}
