package eu5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.larksuite.framework.utils.ApkUtil;

/* JADX INFO: loaded from: classes19.dex */
public final class c {
    public static boolean a() {
        if ((b.f474075a.getApplicationInfo().flags & 2) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public static boolean c() {
        ApplicationInfo r100 = b.f474075a.getApplicationInfo();     // Catch: Exception -> L14
        if ((r100.flags & 2) == 0) goto L6;
        boolean r101 = true;
    L7:
        boolean r102 = r100.packageName.contains("debug");     // Catch: Exception -> L14
        String r103 = ApkUtil.getAppVersionName(b.f474075a).toLowerCase();     // Catch: Exception -> L14
        boolean r104 = r103.contains("alpha");     // Catch: Exception -> L14
        boolean r105 = r103.contains("beta");     // Catch: Exception -> L14
        if (r104 == true) goto L12;
        if (r105 == true) goto L12;
        if (r101 == true) goto L12;
        if (r102 == true) goto L12;
        return false;
    L12:
        return true;
    L6:
        r101 = false;
    L18:
        return false;
    }

    public static boolean d() {
        ApplicationInfo r100 = b.f474075a.getApplicationInfo();     // Catch: Exception -> L13
        boolean r101 = r100.packageName.contains("debug");     // Catch: Exception -> L13
        boolean r102 = TextUtils.equals("com.bytedance.ee.docs.sdk.demo", r100.packageName);     // Catch: Exception -> L13
        if ((r100.flags & 2) == 0) goto L7;
        boolean r103 = true;
    L8:
        if (r101 == true) goto L11;
        if (r102 == true) goto L11;
        if (r103 == true) goto L11;
        return false;
    L11:
        return true;
    L7:
        r103 = false;
    L17:
        return false;
    }

    public static boolean e() {
        ApplicationInfo r100 = b.f474075a.getApplicationInfo();     // Catch: Exception -> L12
        if ((r100.flags & 2) == 0) goto L6;
        boolean r101 = true;
    L7:
        boolean r102 = TextUtils.equals("com.bytedance.ee.docs.sdk.demo", r100.packageName);     // Catch: Exception -> L12
        if (r101 == false) goto L15;
        if (r102 == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L6:
        r101 = false;
    L17:
        return false;
    }

    public static boolean b(Context r100) {
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }
}
