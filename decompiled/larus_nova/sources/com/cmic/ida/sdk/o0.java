package com.cmic.ida.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.autonavi.amap.mapcore.AMapEngineUtils;

/* JADX INFO: loaded from: classes22.dex */
public class o0 {
    public static byte[] a(Context r100) {
        PackageManager r101 = r100.getPackageManager();     // Catch: Exception -> L20
        if (Build.VERSION.SDK_INT < 28) goto L14;
        SigningInfo r102 = r101.getPackageInfo(r100.getPackageName(), AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo;     // Catch: Exception -> L20
        if (r102 == null) goto L8;
        Signature[] r103 = r102.getApkContentsSigners();     // Catch: Exception -> L20
    L9:
        if (r103 == null) goto L14;
        if (r103.length <= 0) goto L14;
        return r103[0].toByteArray();
    L8:
        r103 = null;
    L14:
        Signature[] r104 = r101.getPackageInfo(r100.getPackageName(), 64).signatures;     // Catch: Exception -> L20
        if (r104 != null) goto L17;
    L22:
        return null;
    L17:
        if (r104.length <= 0) goto L22;
        return r104[0].toByteArray();
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

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
