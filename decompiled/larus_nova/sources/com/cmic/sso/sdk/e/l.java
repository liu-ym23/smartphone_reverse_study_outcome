package com.cmic.sso.sdk.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes22.dex */
public class l {
    public static byte[] a(Context r100, String r101) {
        PackageManager r102 = r100.getPackageManager();
        if (r100.getPackageName().equalsIgnoreCase(r101) == true) goto L12;
    L11:
        return null;
    L12:
        PackageInfo r103 = r102.getPackageInfo(r100.getPackageName(), 64);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r103.packageName.equals(r101) == false) goto L11;
        return r103.signatures[0].toByteArray();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
