package com.bytedance.ttnet.retrofit;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes22.dex */
public class RequestDelayHelper {
    private static final String TAG = "RequestDelayHelper";
    private static final String ZERO_TIME_STRING = "00:00:00";

    public RequestDelayHelper() {
    }

    public static int getRandomDelayTime(int r100) {
        return new Random(UUID.randomUUID().hashCode()).nextInt(r100);
    }

    public static boolean isInDelayAPIList(String r100, Set<String> r101) {
        if (StringUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (r101 == null) goto L18;
        Iterator<String> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L8;
        if (r100.startsWith(r103) == false) goto L8;
        if (Logger.debug() == false) goto L25;
        Logger.d(TAG, "app delay, matched, rule is " + r103 + " request path is " + r100);
        return true;
    L25:
        return true;
    L18:
        return false;
    }

    public static boolean isInDelayTimeRange(String r100, String r101) {
        if (StringUtils.isEmpty(r100) == false) goto L5;
    L28:
        return false;
    L5:
        if (StringUtils.isEmpty(r101) == true) goto L28;
        SimpleDateFormat r102 = new SimpleDateFormat("HH:mm:ss");     // Catch: Throwable -> L26
        Date r103 = r102.parse(r100);     // Catch: Throwable -> L26
        Date r104 = r102.parse(r101);     // Catch: Throwable -> L26
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L26
        Date r106 = new Date(r105);     // Catch: Throwable -> L26
        r104.setDate(r106.getDate());     // Catch: Throwable -> L26
        r104.setMonth(r106.getMonth());     // Catch: Throwable -> L26
        r104.setYear(r106.getYear());     // Catch: Throwable -> L26
        r103.setDate(r106.getDate());     // Catch: Throwable -> L26
        r103.setMonth(r106.getMonth());     // Catch: Throwable -> L26
        r103.setYear(r106.getYear());     // Catch: Throwable -> L26
        if (r103.before(r104) == true) goto L10;
        Date r107 = r102.parse(ZERO_TIME_STRING);     // Catch: Throwable -> L26
        Date r108 = r102.parse(ZERO_TIME_STRING);     // Catch: Throwable -> L26
        r108.setDate(r106.getDate());     // Catch: Throwable -> L26
        r108.setMonth(r106.getMonth());     // Catch: Throwable -> L26
        r108.setYear(r106.getYear());     // Catch: Throwable -> L26
        Calendar r109 = Calendar.getInstance();     // Catch: Throwable -> L26
        r109.setTime(r106);     // Catch: Throwable -> L26
        r109.add(5, 1);     // Catch: Throwable -> L26
        Date r110 = r109.getTime();     // Catch: Throwable -> L26
        r107.setDate(r110.getDate());     // Catch: Throwable -> L26
        r107.setMonth(r110.getMonth());     // Catch: Throwable -> L26
        r107.setYear(r110.getYear());     // Catch: Throwable -> L26
        if (r105 < r108.getTime()) goto L20;
        if (r105 > r104.getTime()) goto L20;
    L24:
        return true;
    L20:
        if (r105 >= r103.getTime()) goto L23;
        return false;
    L23:
        if (r105 < r107.getTime()) goto L24;
        return false;
    L10:
        if (r105 >= r103.getTime()) goto L12;
        return false;
    L12:
        if (r105 > r104.getTime()) goto L31;
        return true;
    L31:
        return false;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }
}
