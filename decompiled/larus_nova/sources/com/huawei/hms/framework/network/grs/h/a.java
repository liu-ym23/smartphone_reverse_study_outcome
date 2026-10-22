package com.huawei.hms.framework.network.grs.h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public class a {
    public static String a() {
        return "8.0.1.304";
    }

    public static String a(Context r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (ContextHolder.getAppContext() == null) goto L9;
        r100 = ContextHolder.getAppContext();
    L9:
        PackageManager r101 = r100.getPackageManager();
        return r101.getPackageInfo(r100.getPackageName(), 16384).versionName;
    L12:
        e = move-exception;
        Logger.w("AgentUtil", "", e);
        return "";
    }

    public static String a(Context r100, String r101, String r110) {
        if (r100 != null) goto L7;
        return String.format(Locale.ROOT, r101 + "/%s", new Object[]{a()});
    L7:
        if (ContextHolder.getAppContext() != null) goto L9;
        Context r102 = r100;
    L10:
        String r103 = r102.getPackageName();
        String r104 = a(r100);
        String r105 = Build.VERSION.RELEASE;
        String r106 = Build.MODEL;
        Locale r107 = Locale.ROOT;
        String r108 = "%s/%s (Linux; Android %s; %s) " + r101 + "/%s %s";
        Object[] r109 = new Object[6];
        r109[0] = r103;
        r109[1] = r104;
        r109[2] = r105;
        r109[3] = r106;
        r109[4] = a();
        if (TextUtils.isEmpty(r110) == false) goto L13;
        r110 = "no_service_name";
    L13:
        r109[5] = r110;
        return String.format(r107, r108, r109);
    L9:
        r102 = ContextHolder.getAppContext();
        goto L10
    }

    public static String b(Context r100, String r101, String r102) {
        return a(r100, r101, r102);
    }
}
