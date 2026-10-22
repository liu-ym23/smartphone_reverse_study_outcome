package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k0 {
    public static final SimpleDateFormat a = null;
    public static final SimpleDateFormat b = null;
    public static final SimpleDateFormat c = null;
    public static final SimpleDateFormat d = null;
    public static final SimpleDateFormat e = null;

    static {
        Locale r0 = Locale.getDefault();
        a = new SimpleDateFormat("yyyy-MM-dd", r0);
        new SimpleDateFormat("yyyy-MM-dd");
        b = new SimpleDateFormat("HH:mm", r0);
        c = new SimpleDateFormat("yyyy年M月d日", r0);
        d = new SimpleDateFormat("M月d日", r0);
        e = new SimpleDateFormat("MM-dd", r0);
    }

    public static String a(Context r13, long r14) {
        long r0 = Calendar.getInstance().getTimeInMillis() - r14;
        if (r0 >= 60000) goto L7;
        return r13.getString(2131894212);
    L7:
        if (r0 < 3600000) goto L9;
        Calendar r2 = Calendar.getInstance();
        r2.set(11, 0);
        r2.set(12, 0);
        r2.set(13, 0);
        long r10 = r2.getTimeInMillis();
        if (r14 >= r10) goto L13;
        r2.add(6, -1);
        long r4 = r2.getTimeInMillis();
        Calendar r1 = Calendar.getInstance();
        r1.setTimeInMillis(r14);
        if (r14 >= r4) goto L17;
        r2.add(6, -2);
        if (r14 >= r2.getTimeInMillis()) goto L21;
        Calendar r15 = Calendar.getInstance();
        r15.set(6, 0);
        r15.set(11, 0);
        r15.set(12, 0);
        r15.set(13, 0);
        if (r14 < r15.getTimeInMillis()) goto L27;
        return e.format(r1.getTime());
    L27:
        return a.format(r1.getTime());
    L21:
        return r13.getString(2131894184, new Object[]{Long.valueOf(((r10 - r14) / 86400000) + 1)});
    L17:
        return r13.getString(2131894305) + b.format(r1.getTime());
    L13:
        return r13.getString(2131894210, new Object[]{Long.valueOf(r0 / 3600000)});
    L9:
        return r13.getString(2131894228, new Object[]{Long.valueOf(r0 / 60000)});
    }

    public static String b(Context r9, long r10) {
        long r0 = Calendar.getInstance().getTimeInMillis() - r10;
        if (r0 >= 60000) goto L7;
        return r9.getString(2131894212);
    L7:
        if (r0 >= 3600000) goto L11;
        return r9.getString(2131914310, new Object[]{Long.valueOf(r0 / 60000)});
    L11:
        if (r0 >= 86400000) goto L15;
        return r9.getString(2131914308, new Object[]{Long.valueOf(r0 / 3600000)});
    L15:
        if (r0 < 604800000) goto L17;
        Calendar r11 = Calendar.getInstance();
        r11.setTimeInMillis(r10);
        Calendar r1 = Calendar.getInstance();
        r1.set(6, 0);
        r1.set(11, 0);
        r1.set(12, 0);
        r1.set(13, 0);
        if (r10 < (r1.getTimeInMillis() + 86400000)) goto L28;
        SimpleDateFormat r12 = d;
        monitor-enter(r12);
        String r13 = r12.format(r11.getTime());     // Catch: Throwable -> L25
        monitor-exit(r12);     // Catch: Throwable -> L25
        return r13;
    L25:
        th = move-exception;
        throw th;
    L28:
        SimpleDateFormat r14 = c;
        monitor-enter(r14);
        String r15 = r14.format(r11.getTime());     // Catch: Throwable -> L33
        monitor-exit(r14);     // Catch: Throwable -> L33
        return r15;
    L33:
        th = move-exception;
        throw th;
    L17:
        return r9.getString(2131914306, new Object[]{Long.valueOf(r0 / 86400000)});
    }

    public static boolean c(long r4, long r6) {
        Date r0 = new Date(r4);
        Date r5 = new Date(r6);
        Calendar r7 = Calendar.getInstance();
        r7.setTime(r0);
        Calendar r8 = Calendar.getInstance();
        r8.setTime(r5);
        int r9 = r7.get(1);
        int r1 = r7.get(2);
        int r10 = r7.get(5);
        int r3 = r8.get(1);
        int r2 = r8.get(2);
        int r11 = r8.get(5);
        if (r9 != r3) goto L7;
        if (r1 != r2) goto L7;
        if (r10 != r11) goto L7;
        return true;
    L7:
        return false;
    }
}
