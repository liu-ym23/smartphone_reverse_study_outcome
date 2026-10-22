package com.xiaomi.push.service;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f464211a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f1043a = "";

    public static String a() {
        if (TextUtils.isEmpty(f1043a) == false) goto L5;
        f1043a = com.xiaomi.push.ba.a(4);
    L5:
        StringBuilder r100 = new StringBuilder();
        r100.append(f1043a);
        long r101 = f464211a;
        f464211a = 1 + r101;
        r100.append(r101);
        return r100.toString();
    }

    public static String b() {
        return com.xiaomi.push.ba.a(32);
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (r100.length() < 32) goto L15;
        return "BlockId_" + r100.substring(8);
    L9:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("Exception occurred when filtering registration packet id for log. " + e);
        return "UnexpectedId";
    L15:
        return r100;
    }
}
