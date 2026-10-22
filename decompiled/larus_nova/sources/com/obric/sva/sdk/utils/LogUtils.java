package com.obric.sva.sdk.utils;

import com.obric.sva.sdk.logger.SLogger;
import com.obric.sva.sdk.logger.SpecialCategory;

/* JADX INFO: loaded from: classes6.dex */
public class LogUtils {
    public LogUtils() {
    }

    public static void flushLog() {
        SLogger.INSTANCE.flush();
    }

    private static String getArgsString(Object... r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length == 0) goto L20;
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L14;
        Object r104 = r100[r103];
        if (r104 != null) goto L11;
        r101.append("null");
    L12:
        r101.append(" ");
        r103 = r103 + 1;
        goto L7
    L11:
        r101.append(r104);
        goto L12
    L14:
        return r101.toString();
    L20:
        return "";
    }

    public static void d(String r100, Object... r101) {
        SLogger.INSTANCE.d("", r100 + " " + getArgsString(r101));
    }

    public static void e(String r100, Object... r101) {
        SLogger.INSTANCE.e("", r100 + " " + getArgsString(r101));
    }

    public static void d(String r100, String r101, Object... r102) {
        SLogger.INSTANCE.d(r100, r101 + " " + getArgsString(r102));
    }

    public static void e(String r100, String r101, Object... r102) {
        SLogger.INSTANCE.e(r100, r101 + " " + getArgsString(r102));
    }

    public static void i(String r100, String r101, Object... r102) {
        SLogger.INSTANCE.i(r100, r101 + " " + getArgsString(r102));
    }

    public static void v(String r100, String r101, Object... r102) {
        SLogger.INSTANCE.v(r100, r101 + " " + getArgsString(r102));
    }

    public static void w(String r100, String r101, Object... r102) {
        SLogger.INSTANCE.w(r100, r101 + " " + getArgsString(r102));
    }

    public static void s(String r100, String r101, SpecialCategory r102, Object... r103) {
        SLogger.INSTANCE.s(r100, r101 + " " + getArgsString(r103), r102);
    }
}
