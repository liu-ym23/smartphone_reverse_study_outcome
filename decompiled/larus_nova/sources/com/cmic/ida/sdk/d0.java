package com.cmic.ida.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes22.dex */
public class d0 {
    public static String a(Context r100) {
        String r101 = null;
        PackageManager r102 = r100.getPackageManager();     // Catch: Exception -> L13
        String r103 = (String) r102.getApplicationLabel(r102.getApplicationInfo(c(r100), 0));     // Catch: Exception -> L13
        if (r103 == null) goto L18;
        return r103;
    L18:
        PackageInfo r104 = b(r100);     // Catch: Exception -> L11
        if (r104 != null) goto L9;
        return null;
    L9:
        int r105 = r104.applicationInfo.labelRes;     // Catch: Exception -> L11
        return r100.getResources().getString(r105);
    L11:
        e = e;
        r101 = r103;
    L14:
        e.printStackTrace();
        return r101;
    L13:
        e = e;
        goto L14
    }

    private static PackageInfo b(Context r100) {
        return r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static String c(Context r100) {
        PackageInfo r101 = b(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101.packageName;
    }

    public static String d(Context r100) {
        PackageInfo r101 = b(r100);     // Catch: Exception -> L6
        if (r101 == null) goto L12;
        return c(r100) + "&" + r101.versionName;
    L12:
        return "";
    L6:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
