package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class PackageManagerCompat {
    private static final String TAG = "PackageUtils";
    private static final String VERSION = "8.0.1.304";
    private static String sAppVersion = "";

    public PackageManagerCompat() {
    }

    public static String getAppPackageName(Context r100) {
        if (ContextHolder.getAppContext() == null) goto L6;
        r100 = ContextHolder.getAppContext();
    L6:
        PackageManager r101 = r100.getPackageManager();
        if (r101 != null) goto L13;
        return "";
    L13:
        return r101.getPackageInfo(r100.getPackageName(), 16384).packageName;
    L11:
        Logger.w(TAG, "Failed to get Package managers Package Info");
        return "";
    }

    public static String getAppVersion(Context r100) {
        if (TextUtils.isEmpty(sAppVersion) == true) goto L7;
        return sAppVersion;
    L7:
        if (ContextHolder.getAppContext() == null) goto L10;
        r100 = ContextHolder.getAppContext();
    L10:
        PackageManager r101 = r100.getPackageManager();
        if (r101 == null) goto L13;
        sAppVersion = String.valueOf(r101.getPackageInfo(r100.getPackageName(), 16384).versionCode);     // Catch: Throwable -> L16
    L18:
        return sAppVersion;
    L16:
        Logger.w(TAG, "Failed to get Package managers Package Info");
        goto L18
    L13:
        return sAppVersion;
    }

    private static Bundle getBundleFromApp(Context r100) {
        Bundle r101 = Bundle.EMPTY;
        if (ContextHolder.getAppContext() == null) goto L6;
        r100 = ContextHolder.getAppContext();
    L6:
        if (r100 != null) goto L8;
        return r101;
    L8:
        PackageManager r102 = r100.getPackageManager();
        if (r102 != null) goto L21;
        return r101;
    L21:
        ApplicationInfo r103 = r102.getApplicationInfo(r100.getPackageName(), 128);     // Catch: Throwable -> L16 PackageManager.NameNotFoundException -> L18
        if (r103 == null) goto L23;
        Bundle r104 = r103.metaData;     // Catch: Throwable -> L16 PackageManager.NameNotFoundException -> L18
        if (r104 != null) goto L25;
        return r101;
    L25:
        return r104;
    L23:
        return r101;
    L16:
        e = move-exception;
        Logger.w(TAG, "NameNotFoundException:", e);
        return r101;
    }

    private static Bundle getBundleFromKit(Context r100) {
        if (ContextHolder.getKitContext() == null) goto L7;
        r100 = ContextHolder.getKitContext();
    L7:
        if (r100 != null) goto L11;
        Logger.v(TAG, "the kitContext is null");
        return Bundle.EMPTY;
    L11:
        if (r100.getApplicationInfo() != null) goto L14;
        Logger.v(TAG, "the kit applicationInfo is null");
        return Bundle.EMPTY;
    L14:
        Logger.i(TAG, "kitContext: " + r100.getPackageName());
        Bundle r101 = r100.getApplicationInfo().metaData;
        if (r101 == null) goto L17;
        return r101;
    L17:
        return Bundle.EMPTY;
    }

    private static Bundle getBundleFromKitOrAPP(Context r100) {
        Bundle r101 = getBundleFromKit(r100);
        if (r101 == null) goto L7;
        if (r101.isEmpty() == true) goto L7;
        return r101;
    L7:
        return getBundleFromApp(r100);
    }

    public static Map<String, String> getMetaDataMapFromKitOrApp(Context r100, String r101) {
        HashMap r102 = new HashMap();
        Bundle r103 = getBundleFromKitOrAPP(r100);
        Iterator<String> r104 = r103.keySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L11;
        String r105 = r104.next();
        if (r105.startsWith(r101) == false) goto L4;
        String r106 = r103.getString(r105);
        if (TextUtils.isEmpty(r106) == true) goto L4;
        r102.put(r105.substring(r101.length()), r106);
        goto L4
    L11:
        return r102;
    }

    public static String getMetaDataFromApp(Context r100, String r101, String r102) {
        Bundle r103 = getBundleFromApp(r100);
        if (r103 != null) goto L5;
        return r102;
    L5:
        return r103.getString(r101, r102);
    }

    public static String getMetaDataFromKit(Context r100, String r101, String r102) {
        Bundle r103 = getBundleFromKit(r100);     // Catch: RuntimeException -> L7
        if (r103 != null) goto L5;
        return r102;
    L5:
        return r103.getString(r101, r102);
    L7:
        Logger.v(TAG, "the kit metaData is runtimeException");
        return r102;
    }

    public static String getMetaDataFromKitOrApp(Context r100, String r101, String r102) {
        return getBundleFromKitOrAPP(r100).getString(r101, r102);
    }
}
