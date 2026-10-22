package cxc;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static int a(Context r100) {
        PackageManager r101 = r100.getPackageManager();
        c.a(r100).getClass();     // Catch: Exception -> L5 PackageManager.NameNotFoundException -> L6
        int r102 = r101.getPackageInfo("com.hihonor.id", 0).versionCode;     // Catch: Exception -> L5 PackageManager.NameNotFoundException -> L6
        exc.e.c("SDKUtil", "versionCode " + r102);     // Catch: Exception -> L5 PackageManager.NameNotFoundException -> L6
        return r102;
    L6:
        exc.e.b("SDKUtil", "NameNotFoundException error");
    L7:
        return 0;
    L5:
        exc.e.b("SDKUtil", "Exception error");
        goto L7
    }

    public static boolean b(Context r100, int r101) {
        if (a(r100) > r101) goto L6;
        return true;
    L6:
        return false;
    }
}
