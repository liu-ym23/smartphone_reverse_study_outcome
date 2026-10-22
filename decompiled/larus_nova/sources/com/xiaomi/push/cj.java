package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class cj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f463250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final List<String> f322a = null;

    public static void a(String r100, String r101) {
    }

    static {
        f322a = Arrays.asList(new String[]{AdBaseConstants.InfoErrorCode.WEB_URL_NULL, "002", "003", "004", "005"});
        f463250a = null;
    }

    public static boolean a(Context r100) {
        if (f463250a != null) goto L18;
    L15:
        th = move-exception;
        f463250a = Boolean.FALSE;
        com.xiaomi.channel.commonutils.logger.b.c("Push-ConnectionQualityStatsHelper", "Determine sampling switch error: " + th);
        goto L18
    L5:
        if (j.m9295a(r100) == true) goto L7;
        f463250a = Boolean.FALSE;     // Catch: Throwable -> L15
    L7:
        String r101 = com.xiaomi.push.service.q.m9410a(r100);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r101) == false) goto L10;
    L12:
        f463250a = Boolean.FALSE;     // Catch: Throwable -> L15
    L13:
        a("Sampling statistical connection quality: " + f463250a);     // Catch: Throwable -> L15
        goto L18
    L10:
        if (r101.length() < 3) goto L12;
        f463250a = Boolean.valueOf(f322a.contains(r101.substring(r101.length() - 3)));     // Catch: Throwable -> L15
    L18:
        return f463250a.booleanValue();
    }

    public static void a(String r100) {
        a("Push-ConnectionQualityStatsHelper", r100);
    }
}
