package com.larksuite.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f285955a = 0;

    static {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static long e() {
        return System.currentTimeMillis() / 1000;
    }

    public static String b(int r100) {
        if (r100 >= 10) goto L6;
        return "0" + r100;
    L6:
        return String.valueOf(r100);
    }

    public static String f(int r100) {
        if (r100 >= 0) goto L6;
        return "";
    L6:
        if (r100 <= 0) goto L9;
        if (r100 >= 1000) goto L9;
        r100 = 1000;
    L9:
        int r101 = r100 / 1000;
        int r102 = r101 % 60;
        int r103 = r101 / 60;
        int r104 = r103 % 60;
        int r105 = r103 / 60;
        StringBuilder r106 = new StringBuilder();
        if (r105 <= 0) goto L12;
        r106.append(b(r105));
        r106.append(":");
    L12:
        r106.append(b(r104));
        r106.append(":");
        r106.append(b(r102));
        return r106.toString();
    }

    public static String g(int r100) {
        if (r100 <= 0) goto L5;
        r100 = r100 + 500;
    L5:
        return f(r100);
    }

    public static boolean h(Date r100) {
        long r101 = r100.getTime();
        f.a r102 = f.f285956a;
        f.b r103 = r102.c(new Object[]{null, null});
        Calendar r104 = r103.f285959b;
        f.d(r104, System.currentTimeMillis());
        int r105 = r104.get(1);
        f.d(r104, r101);
        int r106 = r104.get(1);
        r102.d(r103);
        if (r105 != r106) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == false) goto L8;
        return true;
    L8:
        return false;
    L5:
        r107 = false;
        goto L6
    }

    public static int i(Date r100) {
        long r101 = r100.getTime();
        boolean r102 = false;
        if (r101 < (f.c() + 86400000)) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        return 0;
    L11:
        if (r101 <= f.c()) goto L13;
    L15:
        if (r102 == false) goto L17;
        return 1;
    L17:
        return -1;
    L13:
        if (r101 <= (f.c() - 86400000)) goto L15;
        r102 = true;
        goto L15
    L5:
        if (r101 <= f.c()) goto L7;
        r103 = true;
        goto L8
    }

    public static boolean a(long r100, long r101) {
        TimeZone r102 = TimeZone.getDefault();
        Calendar r103 = Calendar.getInstance(r102);
        r103.setTimeInMillis(r100);
        Calendar r104 = Calendar.getInstance(r102);
        r104.setTimeInMillis(r101);
        if (r103.get(1) == r104.get(1)) goto L5;
    L7:
        return false;
    L5:
        if (r103.get(6) != r104.get(6)) goto L7;
        return true;
    }

    public static String c(Date r100, String r101) {
        return new SimpleDateFormat(r101).format(r100);
    L5:
        return "";
    }

    public static int d(int r100, int r101) {
        if (r101 <= 12) goto L5;
        r100 = r100 + 1;
        r101 = 1;
    L7:
        int[] r102 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((r100 % 4) != 0) goto L12;
        if ((r100 % 100) == 0) goto L12;
    L13:
        r102[1] = 29;
    L20:
        return r102[r101 - 1];
    L17:
        e = move-exception;
        e.getStackTrace();
        return 0;
    L12:
        if ((r100 % 400) != 0) goto L20;
    L5:
        if (r101 >= 1) goto L7;
        r100 = r100 - 1;
        r101 = 12;
        goto L7
    }
}
