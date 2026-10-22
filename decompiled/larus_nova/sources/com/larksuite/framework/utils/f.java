package com.larksuite.framework.utils;

import android.text.TextUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f285956a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f285957b;

    public class a extends v<b> {
        public a() {
            super(5);
        }

        @Override // com.larksuite.framework.utils.v
        public final b a(Object[] r100) {
            Locale r101 = null;
            if (r100.length < 1) goto L7;
            Object r102 = r100[0];
            if ((r102 instanceof TimeZone) == false) goto L7;
            TimeZone r103 = (TimeZone) r102;
        L8:
            if (r103 != null) goto L11;
            r103 = TimeZone.getDefault();
        L11:
            if (r100.length < 2) goto L15;
            Object r104 = r100[1];
            if ((r104 instanceof Locale) == false) goto L15;
            r101 = (Locale) r104;
        L15:
            if (r101 != null) goto L18;
            r101 = Locale.getDefault();
        L18:
            return new b(new j.d(new Object[]{r103, r101}), Calendar.getInstance(r103, r101));
        L7:
            r103 = null;
            goto L8
        }

        @Override // com.larksuite.framework.utils.v
        public final boolean b(b r100, Object[] r101) {
            b r102 = r100;
            if (r101[0] != null) goto L6;
            r101[0] = TimeZone.getDefault();
        L6:
            if (r101[1] != null) goto L9;
            r101[1] = Locale.getDefault();
        L9:
            return Arrays.equals(r102.f285958a.f286013a, r101);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j.d f285958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Calendar f285959b;

        public b(j.d r100, Calendar r101) {
            this.f285958a = r100;
            this.f285959b = r101;
        }
    }

    static {
        f285956a = new a();
    }

    public static long c() {
        if (f285957b > 0) goto L5;
    L6:
        a r100 = f285956a;
        b r101 = r100.c(new Object[]{null, null});
        Calendar r102 = r101.f285959b;
        d(r102, System.currentTimeMillis());
        r102.set(11, 0);
        r102.set(12, 0);
        r102.set(13, 0);
        r102.set(14, 0);
        f285957b = r102.getTimeInMillis();
        r100.d(r101);
    L8:
        return f285957b;
    L5:
        if ((System.currentTimeMillis() - f285957b) <= 86400000) goto L8;
        goto L6
    }

    public static int b(long r100, int r101) {
        TimeZone r102 = TimeZone.getDefault();
        a r103 = f285956a;
        b r104 = r103.c(new Object[]{r102, null});
        Calendar r105 = r104.f285959b;
        d(r105, r100);
        if (r101 != 5) goto L5;
        r101 = 5;
    L5:
        int r106 = r105.get(r101);
        if (r101 != 2) goto L9;
        r106 = r106 + 1;
    L9:
        if (r101 != 10) goto L12;
        if (r106 != 0) goto L12;
        r106 = 12;
    L12:
        r103.d(r104);
        return r106;
    }

    public static void d(Calendar r100, long r101) {
        r100.add(14, (int) (r101 - r100.getTimeInMillis()));
        if (r100.getTimeInMillis() == r101) goto L6;
        r100.setTimeInMillis(r101);
        return;
    }

    public static String a(String r100, long r101, TimeZone r102, Locale r103) {
        ConcurrentMap<j.d, j> r104 = j.f286000f;
        if (TextUtils.isEmpty(r100) == true) goto L34;
        if (r102 != null) goto L6;
        r102 = TimeZone.getDefault();
    L6:
        if (r103 != null) goto L8;
        r103 = Locale.getDefault();
    L8:
        int r105 = 0;
        j.d r106 = new j.d(new Object[]{r100, r102, r103});
        j r107 = (j) ((ConcurrentHashMap) j.f286000f).get(r106);
        if (r107 != null) goto L19;
        r107 = new j(r100, r102, r103);
        r107.d();     // Catch: IllegalArgumentException -> L13
    L15:
        j r108 = (j) ((ConcurrentHashMap) j.f286000f).putIfAbsent(r106, r107);
        if (r108 == null) goto L19;
        r107 = r108;
    L13:
        e = move-exception;
        e.printStackTrace();
    L19:
        if (r107.f286005d == null) goto L40;
        TimeZone r109 = r107.f286003b;
        Locale r110 = r107.f286004c;
        b r111 = f285956a.c(new Object[]{r109, r110});
        Calendar r112 = r111.f285959b;
        r112.add(14, (int) (r101 - r112.getTimeInMillis()));
        if (r112.getTimeInMillis() == r101) goto L24;
        r112.setTimeInMillis(r101);
    L24:
        StringBuilder r113 = new StringBuilder(r107.f286006e);
        j.g[] r114 = r107.f286005d;     // Catch: IOException -> L29
        int r115 = r114.length;     // Catch: IOException -> L29
    L26:
        if (r105 >= r115) goto L31;
        r114[r105].appendTo(r113, r112);     // Catch: IOException -> L29
        r105 = r105 + 1;
    L31:
        String r116 = r113.toString();
        f285956a.d(r111);
        return r116;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L40:
        return r107.f286002a;
    L34:
        throw new IllegalArgumentException("date pattern must not be null");
    }
}
