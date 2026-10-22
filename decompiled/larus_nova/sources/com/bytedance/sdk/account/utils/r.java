package com.bytedance.sdk.account.utils;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public static String a(long r100) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(new Date(r100));
    }

    public static String c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        if (r100.length() >= 10) goto L9;
        return r100;
    L9:
        return r100.substring(0, 9) + "****" + r100.substring(r100.length() - 10);
    }

    public static String b(String r100, String r101) {
        String[] r102 = null;
        String r103 = (String) ab7.a.c(new Object[]{r100});     // Catch: Throwable -> L5
    L8:
        if (TextUtils.isEmpty(r103) == true) goto L10;
        r102 = r103.split(com.alipay.sdk.m.u.i.f25853b);
    L10:
        if (r102 == null) goto L18;
        int r104 = 0;
    L13:
        if (r104 >= r102.length) goto L18;
        String r105 = r102[r104];
        if (r105 == null) goto L17;
        r102[r104] = r105.trim();
    L17:
        r104 = r104 + 1;
    L18:
        if (r102 != null) goto L20;
    L35:
        return "";
    L20:
        if (r102.length == 0) goto L35;
        int r106 = r102.length;
        int r107 = 0;
    L23:
        if (r107 >= r106) goto L35;
        String r108 = r102[r107];
        if (TextUtils.isEmpty(r108) == true) goto L34;
        String[] r109 = r108.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r109.length < 2) goto L34;
        String r110 = r109[0];
        if (r110 == null) goto L34;
        if (r110.trim().equalsIgnoreCase(r101) == false) goto L34;
        return r109[1];
    L34:
        r107 = r107 + 1;
    L5:
        th = move-exception;
        th.printStackTrace();
        r103 = null;
        goto L8
    }
}
