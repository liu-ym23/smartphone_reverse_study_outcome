package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.heytap.mcssdk.PushService;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    public Utils() {
    }

    public static String getString(int[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r101.append((char) r100[r103]);
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    public static int getVersionCode(Context r100) {
        return r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionCode;
    L5:
        e = move-exception;
        d.b("getVersionCode--Exception:" + e.getMessage());
        return 0;
    }

    public static int getVersionCode(Context r100, String r101) {
        return r100.getPackageManager().getPackageInfo(r101, 0).versionCode;
    L5:
        e = move-exception;
        d.b("getVersionCode--Exception:" + e.getMessage());
        return 0;
    }

    public static String getVersionName(Context r100) {
        return r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionName;
    L4:
        e = move-exception;
        d.b("getVersionName--Exception:" + e.getMessage());
        return "0";
    }

    public static String getVersionName(Context r100, String r101) {
        return r100.getPackageManager().getPackageInfo(r101, 0).versionName;
    L4:
        e = move-exception;
        d.b("getVersionName--Exception:" + e.getMessage());
        return null;
    }

    public static boolean isExistPackage(Context r100, String r101) {
        r100.getPackageManager().getPackageInfo(r101, 1);     // Catch: PackageManager.NameNotFoundException -> L4
        return true;
    L4:
        e = move-exception;
        d.e("isExistPackage NameNotFoundException:" + e.getMessage());
        return false;
    }

    public static boolean isSupportPush(Context r100, String r101, String r102) {
        ApplicationInfo r103 = r100.getPackageManager().getApplicationInfo(r101, 128);     // Catch: PackageManager.NameNotFoundException -> L4
    L7:
        if (r103 != null) goto L9;
        return false;
    L9:
        if (r103.metaData.getBoolean(r102, false) == false) goto L15;
        return true;
    L15:
        return false;
    L4:
        e = move-exception;
        d.e("isSupportPush NameNotFoundException:" + e.getMessage());
        r103 = null;
        goto L7
    }

    public static boolean isSupportPushByClient(Context r100) {
        return PushService.getInstance().isSupportPushByClient(r100);
    }

    public static int parseInt(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
    L8:
        return -1;
    L10:
        return CastIntegerProtector.parseInt(r100);
    L6:
        e = move-exception;
        d.e("parseInt--NumberFormatException" + e.getMessage());
        goto L8
    }
}
