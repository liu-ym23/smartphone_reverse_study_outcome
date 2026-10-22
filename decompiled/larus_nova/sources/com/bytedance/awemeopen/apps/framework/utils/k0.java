package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import com.larus.nova.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f197720a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f197721b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f197722c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SimpleDateFormat f197723d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SimpleDateFormat f197724e = null;

    static {
        Locale r100 = Locale.getDefault();
        f197720a = new SimpleDateFormat("yyyy-MM-dd", r100);
        new SimpleDateFormat("yyyy-MM-dd");
        f197721b = new SimpleDateFormat("HH:mm", r100);
        f197722c = new SimpleDateFormat("yyyy年M月d日", r100);
        f197723d = new SimpleDateFormat("M月d日", r100);
        f197724e = new SimpleDateFormat("MM-dd", r100);
    }

    public static String a(Context r110, long r111) {
        long r100 = Calendar.getInstance().getTimeInMillis() - r111;
        if (r100 >= 60000) goto L7;
        return r110.getString(R.string.aos_just_now);
    L7:
        if (r100 < 3600000) goto L9;
        Calendar r101 = Calendar.getInstance();
        r101.set(11, 0);
        r101.set(12, 0);
        r101.set(13, 0);
        long r112 = r101.getTimeInMillis();
        if (r111 >= r112) goto L13;
        r101.add(6, -1);
        long r102 = r101.getTimeInMillis();
        Calendar r103 = Calendar.getInstance();
        r103.setTimeInMillis(r111);
        if (r111 >= r102) goto L17;
        r101.add(6, -2);
        if (r111 >= r101.getTimeInMillis()) goto L21;
        Calendar r113 = Calendar.getInstance();
        r113.set(6, 0);
        r113.set(11, 0);
        r113.set(12, 0);
        r113.set(13, 0);
        if (r111 < r113.getTimeInMillis()) goto L27;
        return f197724e.format(r103.getTime());
    L27:
        return f197720a.format(r103.getTime());
    L21:
        return r110.getString(R.string.aos_days_ago, new Object[]{Long.valueOf(((r112 - r111) / 86400000) + 1)});
    L17:
        return r110.getString(R.string.aos_yesterday) + f197721b.format(r103.getTime());
    L13:
        return r110.getString(R.string.aos_hours_ago, new Object[]{Long.valueOf(r100 / 3600000)});
    L9:
        return r110.getString(R.string.aos_minutes_ago, new Object[]{Long.valueOf(r100 / 60000)});
    }

    public static String b(Context r100, long r110) {
        long r101 = Calendar.getInstance().getTimeInMillis() - r110;
        if (r101 >= 60000) goto L7;
        return r100.getString(R.string.aos_just_now);
    L7:
        if (r101 >= 3600000) goto L11;
        return r100.getString(R.string.time_abbreviation_minute2, new Object[]{Long.valueOf(r101 / 60000)});
    L11:
        if (r101 >= 86400000) goto L15;
        return r100.getString(R.string.time_abbreviation_hour2, new Object[]{Long.valueOf(r101 / 3600000)});
    L15:
        if (r101 < 604800000) goto L17;
        Calendar r102 = Calendar.getInstance();
        r102.setTimeInMillis(r110);
        Calendar r103 = Calendar.getInstance();
        r103.set(6, 0);
        r103.set(11, 0);
        r103.set(12, 0);
        r103.set(13, 0);
        if (r110 < (r103.getTimeInMillis() + 86400000)) goto L28;
        SimpleDateFormat r111 = f197723d;
        monitor-enter(r111);
        String r104 = r111.format(r102.getTime());     // Catch: Throwable -> L25
        monitor-exit(r111);     // Catch: Throwable -> L25
        return r104;
    L25:
        th = move-exception;
        throw th;
    L28:
        SimpleDateFormat r112 = f197722c;
        monitor-enter(r112);
        String r105 = r112.format(r102.getTime());     // Catch: Throwable -> L33
        monitor-exit(r112);     // Catch: Throwable -> L33
        return r105;
    L33:
        th = move-exception;
        throw th;
    L17:
        return r100.getString(R.string.time_abbreviation_day2, new Object[]{Long.valueOf(r101 / 86400000)});
    }

    public static boolean c(long r100, long r101) {
        Date r102 = new Date(r100);
        Date r103 = new Date(r101);
        Calendar r104 = Calendar.getInstance();
        r104.setTime(r102);
        Calendar r105 = Calendar.getInstance();
        r105.setTime(r103);
        int r106 = r104.get(1);
        int r107 = r104.get(2);
        int r108 = r104.get(5);
        int r109 = r105.get(1);
        int r110 = r105.get(2);
        int r111 = r105.get(5);
        if (r106 != r109) goto L7;
        if (r107 != r110) goto L7;
        if (r108 != r111) goto L7;
        return true;
    L7:
        return false;
    }
}
