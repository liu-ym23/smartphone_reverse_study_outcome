package com.bytedance.awemeopen.apps.framework.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes14.dex */
public final class t {
    public static String a(long r100) {
        if (r100 >= 0) goto L6;
        return String.valueOf(0);
    L6:
        if (r100 >= 10000) goto L9;
        return String.valueOf(r100);
    L9:
        if (r100 >= 100000000) goto L15;
        String r101 = b(r100, 10000, "");
        if (r101.equals("10000.0") == false) goto L19;
        return "1.0亿";
    L19:
        return r101.concat("万");
    L15:
        return b(r100, 100000000, "亿");
    }

    public static String b(long r100, long r101, String r102) {
        return new BigDecimal(r100).divide(new BigDecimal(r101), 1, RoundingMode.HALF_UP).toString() + r102;
    }
}
