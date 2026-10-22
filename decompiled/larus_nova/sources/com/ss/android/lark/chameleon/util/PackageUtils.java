package com.ss.android.lark.chameleon.util;

import android.content.Context;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: classes35.dex */
public class PackageUtils {
    private static final String TAG = "PackageUtils";

    public PackageUtils() {
    }

    public static String getAppVersionName(Context r100) {
        String r101 = "";
        if (r100 == null) goto L17;
        String r102 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionName;     // Catch: Exception -> L13
        if (r102 != null) goto L18;
    L12:
        return "";
    L18:
        if (r102.length() <= 0) goto L12;
        r101 = r102;
    L10:
        Exception e100 = e;
    L15:
        Log.e("VersionInfo", "Exception", e100);
        return r102;
    L13:
        e = move-exception;
        e100 = e;
        r102 = "";
    L17:
        return r101;
    }
}
