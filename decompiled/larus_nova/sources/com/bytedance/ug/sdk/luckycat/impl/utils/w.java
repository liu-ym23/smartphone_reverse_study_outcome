package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.ug.sdk.luckycat.impl.manager.LuckyCatSettingsManger;

/* JADX INFO: loaded from: classes22.dex */
public final class w {
    public static boolean a(String r100) {
        LuckyCatSettingsManger r101 = LuckyCatSettingsManger.b.f271283a;
        r101.getClass();
        Object r102 = r101.c(new String[]{"container_config", "use_check_app_install_v2"});
        boolean r103 = true;
        if ((r102 instanceof Boolean) == false) goto L5;
        boolean r104 = ((Boolean) r102).booleanValue();
    L6:
        if (r104 == false) goto L32;
        Context r105 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f();
        if (r105 != null) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty(r100) == false) goto L33;
        PackageInfo r106 = null;
    L17:
        String r107 = "";
        if (r106 != null) goto L21;
        r107 = "package name : " + r100 + " is null";     // Catch: Throwable -> L25
        a.c("ToolUtils", r107);     // Catch: Throwable -> L25
    L35:
        goto L26
    L21:
        if (r106.applicationInfo != null) goto L23;
        a.c("ToolUtils", "package name : " + r100 + " is not null applicationInfo is null");     // Catch: Throwable -> L25
        goto L35
    L23:
        a.c("ToolUtils", "package name : " + r100 + " is not null enable : " + r106.applicationInfo.enabled);     // Catch: Throwable -> L25
    L26:
        if (r106 != null) goto L29;
        r103 = false;
    L29:
        com.bytedance.ug.sdk.luckycat.impl.model.d.c(r100, r103, r107);
        return r103;
    L33:
        r106 = r105.getPackageManager().getPackageInfo(r100, 0);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        a.c("ToolUtils", Log.getStackTraceString(e));
        com.bytedance.ug.sdk.luckycat.impl.model.d.c(r100, false, e.getMessage());
        return false;
    L32:
        return b(r100);
    L5:
        r104 = true;
        goto L6
    }

    public static boolean b(String r100) {
        Context r101 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f();
        if (r101 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L16;
        PackageInfo r102 = null;
    L11:
        if (r102 != null) goto L13;
        return false;
    L13:
        if (r102.applicationInfo.enabled == false) goto L19;
        return true;
    L19:
        return false;
    L16:
        r102 = r101.getPackageManager().getPackageInfo(r100, 0);     // Catch: Exception -> L9
    L9:
        return false;
    }
}
