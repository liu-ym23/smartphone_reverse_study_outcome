package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.base.log.a;
import com.huawei.hms.base.log.b;

/* JADX INFO: loaded from: classes3.dex */
public class HMSLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f277816a = null;

    public HMSLog() {
    }

    static {
        f277816a = new b();
    }

    public static boolean isErrorEnable() {
        return f277816a.a(6);
    }

    public static boolean isInfoEnable() {
        return f277816a.a(4);
    }

    public static boolean isWarnEnable() {
        return f277816a.a(5);
    }

    private static String a(Context r100) {
        PackageManager r101 = r100.getPackageManager();
        if (r101 != null) goto L8;
    L6:
        return "HMS-[unknown-version]";
    L8:
        PackageInfo r102 = r101.getPackageInfo(r100.getPackageName(), 16384);     // Catch: Throwable -> L7
        return "HMS-" + r102.versionName + "(" + r102.versionCode + ")";
    }

    public static void d(String r100, String r101) {
        f277816a.a(3, r100, r101);
    }

    public static void e(String r100, String r101) {
        f277816a.a(6, r100, r101);
    }

    public static void i(String r100, String r101) {
        f277816a.a(4, r100, r101);
    }

    public static void setExtLogger(HMSExtLogger r100, boolean r101) throws IllegalArgumentException {
        if (r100 == null) goto L9;
        a r102 = new a(r100);
        if (r101 == false) goto L6;
        f277816a.a(r102);
        return;
    L6:
        f277816a.a().a(r102);
        return;
    L9:
        throw new IllegalArgumentException("extLogger is not able to be null");
    }

    public static void w(String r100, String r101) {
        f277816a.a(5, r100, r101);
    }

    public static void e(String r100, long r101, String r102) {
        f277816a.a(6, r100, "[" + r101 + "] " + r102);
    }

    public static void init(Context r100, int r101, String r102) {
        b r103 = f277816a;
        r103.a(r100, r101, r102);
        r103.a(r102, "============================================================================\n====== " + a(r100) + "\n============================================================================");
    }

    public static void e(String r100, String r101, Throwable r102) {
        f277816a.b(6, r100, r101, r102);
    }

    public static void e(String r100, long r101, String r102, Throwable r103) {
        f277816a.b(6, r100, "[" + r101 + "] " + r102, r103);
    }
}
