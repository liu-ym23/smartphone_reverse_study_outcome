package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.push.av;

/* JADX INFO: loaded from: classes41.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f463068a = -1;

    private static boolean a() {
        String r100 = (String) av.a("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, new Object[]{"ro.build.hw_emui_api_level", ""});     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (CastIntegerProtector.parseInt(r100) < 9) goto L11;
        return true;
    L11:
        return false;
    L9:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L11
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m8771a(Context r100) {
        if (r100.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) == null) goto L9;
        if (a() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean b(Context r100) {
        Object r101 = av.a(av.a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", new Object[]{r100});
        Object r102 = av.a("com.google.android.gms.common.ConnectionResult", "SUCCESS");
        if (r102 != null) goto L5;
    L24:
        com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
        f463068a = 0;
        return false;
    L5:
        if ((r102 instanceof Integer) == false) goto L24;
        int r103 = ((Integer) Integer.class.cast(r102)).intValue();
        if (r101 != null) goto L9;
    L16:
        StringBuilder r104 = new StringBuilder("is google service can be used");
        if (f463068a <= 0) goto L19;
        boolean r105 = true;
    L20:
        r104.append(r105);
        com.xiaomi.channel.commonutils.logger.b.c(r104.toString());
        if (f463068a <= 0) goto L26;
        return true;
    L26:
        return false;
    L19:
        r105 = false;
        goto L20
    L9:
        if ((r101 instanceof Integer) == true) goto L11;
        f463068a = 0;
        com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
        goto L16
    L11:
        if (((Integer) Integer.class.cast(r101)).intValue() != r103) goto L13;
        int r106 = 1;
    L14:
        f463068a = r106;
        goto L16
    L13:
        r106 = 0;
        goto L14
    }

    public static boolean c(Context r100) {
        boolean r101 = false;
        Object r102 = av.a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", new Object[]{r100});
        if (r102 != null) goto L5;
    L7:
        com.xiaomi.channel.commonutils.logger.b.c("color os push  is avaliable ? :" + r101);
        return r101;
    L5:
        if ((r102 instanceof Boolean) == false) goto L7;
        r101 = ((Boolean) Boolean.class.cast(r102)).booleanValue();
        goto L7
    }

    public static boolean d(Context r100) {
        boolean r101 = false;
        Object r102 = av.a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", new Object[]{r100});
        if (r102 != null) goto L5;
    L7:
        com.xiaomi.channel.commonutils.logger.b.c("fun touch os push  is avaliable ? :" + r101);
        return r101;
    L5:
        if ((r102 instanceof Boolean) == false) goto L7;
        r101 = ((Boolean) Boolean.class.cast(r102)).booleanValue();
        goto L7
    }

    public static q a(Context r100) {
        if (m8771a(r100) == false) goto L7;
        return q.f463077a;
    L7:
        if (c(r100) == false) goto L11;
        return q.f463080d;
    L11:
        if (d(r100) == false) goto L15;
        return q.f463081e;
    L15:
        return q.f463082f;
    }
}
