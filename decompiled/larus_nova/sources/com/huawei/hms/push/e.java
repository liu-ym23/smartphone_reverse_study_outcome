package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class e {
    public static boolean d() {
        return true;
    }

    private static boolean b() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean c() {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        return true;
    L5:
        return false;
    }

    public static int a() {
        if (b() == false) goto L6;
        return 67108864;
    L6:
        return AMapEngineUtils.HALF_MAX_P20_WIDTH;
    }

    public static boolean a(Context r100) {
        return "com.huawei.hwid".equals(r100.getPackageName());
    }

    public static String a(Context r100, String r101) {
        PackageManager r102 = r100.getPackageManager();     // Catch: Throwable -> L4
        return r102.getApplicationLabel(r102.getApplicationInfo(r101, 128)).toString();
    L4:
        HMSLog.i("PushSelfShowLog", "get the app name of package:" + r101 + " failed.");
        return null;
    }

    public static Intent b(Context r100, String r101) {
        return r100.getPackageManager().getLaunchIntentForPackage(r101);
    L5:
        HMSLog.w("PushSelfShowLog", r101 + " not have launch activity");
        return null;
    }

    public static boolean c(Context r100, String r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        if ("".equals(r101) == true) goto L14;
        if (r100.getPackageManager().getApplicationInfo(r101, 8192) != null) goto L11;
        return false;
    L11:
        HMSLog.d("PushSelfShowLog", r101.concat(" is installed"));     // Catch: Exception -> L15
        return true;
    L14:
        return false;
    }

    public static Boolean a(Context r100, String r101, Intent r102) {
        int r103 = 0;
        List<ResolveInfo> r104 = r100.getPackageManager().queryIntentActivities(r102, 0);     // Catch: Exception -> L15
        if (r104 == null) goto L18;
        if (r104.size() <= 0) goto L18;
        int r105 = r104.size();     // Catch: Exception -> L15
    L7:
        if (r103 >= r105) goto L18;
        if (((ResolveInfo) ListProtector.get(r104, r103)).activityInfo == null) goto L14;
        if (r101.equals(((ResolveInfo) ListProtector.get(r104, r103)).activityInfo.applicationInfo.packageName) == false) goto L14;
        return Boolean.TRUE;
    L14:
        r103 = r103 + 1;
    L18:
        return Boolean.FALSE;
    L15:
        e = move-exception;
        HMSLog.e("PushSelfShowLog", e.toString(), e);
        goto L18
    }
}
