package com.ss.android.lark.chameleon.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.ss.android.lark.chameleon.idependency.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes35.dex */
public class AppInfoUtils {
    private static final String TAG = "InfoProviderUtils";
    private static final String UA_MOBILE = "Mobile";
    private static final String UA_NETWORK = "okhttp";
    private static final String UA_NETWORK_VERSION = "3.2";
    private static final String UA_PLATFORM = "platform";
    private static final String UA_PLATFORM_ANDROID = "android";
    private static PackageInfo sInfo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface VERSION_TYPE {
        public static final String VERSION_ALPHA = "alpha";
        public static final String VERSION_BETA = "beta";
        public static final String VERSION_RELEASE = "release";
    }

    public AppInfoUtils() {
    }

    public static String getUaAppName(Context r100) {
        return "Lark";
    }

    private static PackageInfo getPackageInfo(Context r100) {
        if (sInfo != null) goto L9;
        sInfo = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Log.w(TAG, th.toString());
    L9:
        return sInfo;
    }

    public static String getPackageName(Context r100) {
        PackageInfo r101 = getPackageInfo(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101.packageName;
    }

    public static int getVersionCode(Context r100) {
        PackageInfo r101 = getPackageInfo(r100);
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.versionCode;
    }

    public static String getVersionName(Context r100) {
        PackageInfo r101 = getPackageInfo(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101.versionName;
    }

    public static boolean isApkInDebug(Context r100) {
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }
}
