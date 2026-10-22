package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes23.dex */
public class PackageUtils {
    private static final String TAG = "PackageUtils";

    public PackageUtils() {
    }

    public static String getVersionName(Context r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        PackageManager r101 = r100.getPackageManager();
        return r101.getPackageInfo(r100.getPackageName(), 16384).versionName;
    L8:
        e = move-exception;
        Logger.w(TAG, "", e);
        return "";
    }
}
