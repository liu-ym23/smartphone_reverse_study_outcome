package swb;

import android.content.Context;

/* JADX INFO: loaded from: classes37.dex */
public final class n {
    public static String a(Context r100) {
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
        com.ss.android.lark.officesdk.utils.di.j.c("VersionInfo", "Exception", e100);
        return r102;
    L13:
        e = move-exception;
        e100 = e;
        r102 = "";
    L17:
        return r101;
    }
}
