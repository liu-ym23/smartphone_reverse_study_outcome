package com.bytedance.frameworks.baselib.network.http.util;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f244791a = null;

    public h() {
    }

    static {
        f244791a = h.class.getSimpleName();
    }

    public static Date a(String r100) {
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L15
        String r102 = f244791a;
        if (r101 < 24) goto L10;
        if (Logger.debug() == false) goto L8;
        Logger.d(r102, "parse dateTime " + r100 + " sdk version >= N");     // Catch: Throwable -> L15
    L8:
        SimpleDateFormat r103 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault());     // Catch: Throwable -> L15
    L13:
        return r103.parse(r100);
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.d(r102, "parse dateTime " + r100 + " sdk version < N");     // Catch: Throwable -> L15
    L12:
        r103 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.getDefault());     // Catch: Throwable -> L15
    L15:
        return null;
    }

    public static long b(String r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f244791a, "utcTime " + r100);
    L5:
        SimpleDateFormat r101 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        r101.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date r102 = r101.parse(r100);     // Catch: ParseException -> L10
        if (r102 == null) goto L15;
        return r102.getTime();
    L15:
        return 0;
    L10:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static boolean d(String r100, List<Long> r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (r100.contains(Constants.WAVE_SEPARATOR) == true) goto L8;
        return false;
    L8:
        String[] r102 = r100.split(Constants.WAVE_SEPARATOR);
        if (r102.length == 2) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r102[0]) == false) goto L14;
    L25:
        return false;
    L14:
        if (TextUtils.isEmpty(r102[1]) == true) goto L25;
        long r103 = b(r102[0]);
        long r104 = b(r102[1]);
        if (r103 <= 0) goto L25;
        if (r104 <= 0) goto L25;
        if (r103 >= r104) goto L25;
        r101.add(Long.valueOf(r103));
        r101.add(Long.valueOf(r104));
        return true;
    }

    public static boolean c(String r100, String r101, List r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(ContainerUtils.KEY_VALUE_DELIMITER) == true) goto L42;
        String[] r103 = r100.split(r101);
        if (r103 != null) goto L11;
        return false;
    L11:
        int r104 = 0;
    L13:
        if (r104 >= r103.length) goto L30;
        if (TextUtils.isEmpty(r103[r104]) == true) goto L28;
        String[] r105 = r103[r104].trim().split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r105 == null) goto L28;
        if (r105.length != 2) goto L28;
        if (TextUtils.isEmpty(r105[0]) == true) goto L28;
        if (TextUtils.isEmpty(r105[1]) == true) goto L28;
        Pair r106 = new Pair(r105[0].trim(), r105[1].trim());
        ((ArrayList) r102).add(r106);
    L28:
        r104 = r104 + 1;
        goto L13
    L30:
        if (((ArrayList) r102).size() == 0) goto L43;
        return true;
    L43:
        return false;
    L42:
        return false;
    }
}
