package oo7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes22.dex */
public final class p {
    public static synchronized String a(Context r100) {
        monitor-enter(p.class);
        int r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).applicationInfo.labelRes;     // Catch: Throwable -> L7 Exception -> L9
        String r102 = r100.getResources().getString(r101);     // Catch: Throwable -> L7 Exception -> L9
        monitor-exit(p.class);
        return r102;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        return null;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean b(String r100) {
        Context r101 = com.bytedance.ug.sdk.share.impl.manager.h.g.f272345a.f272326a;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L19;
        PackageInfo r102 = r101.getPackageManager().getPackageInfo(r100, 0);     // Catch: Exception -> L13
        if (r102 == null) goto L17;
        if (r102.applicationInfo.enabled == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L20:
        return false;
    L19:
        return false;
    }

    public static boolean c(Context r100, Intent r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getPackageManager().resolveActivity(r101, 0) != null) goto L8;
    L15:
        return false;
    L8:
        if ((r100 instanceof Activity) == true) goto L16;
        r101.addFlags(268435456);
    L16:
        r100.startActivity(r101);     // Catch: Exception -> L13
        return true;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
