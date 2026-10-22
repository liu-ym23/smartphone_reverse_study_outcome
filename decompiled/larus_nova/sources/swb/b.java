package swb;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f543772a;

    public static boolean b() {
        return LarkAppContext.inst().buildConfig().isOfficeSDK();
    }

    public static String a(Context r100) {
        String r101 = f543772a;
        if (r101 == null) goto L17;
        return r101;
    L17:
        String r102 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 128).versionName;     // Catch: Exception -> L11
        f543772a = r102;     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r102) == false) goto L14;
        return "";
    L14:
        return r102;
    L9:
        Exception e100 = e;
    L13:
        com.ss.android.lark.officesdk.utils.di.j.g("ApkUtil", "get version name exception", e100);
    L11:
        e = move-exception;
        e100 = e;
        r102 = "";
        goto L13
    }
}
