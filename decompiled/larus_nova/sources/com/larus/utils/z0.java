package com.larus.utils;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class z0 {
    public static final long c(boolean r100) {
        if (r100 == false) goto L4;
        return 1;
    L4:
        return 0;
    }

    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Application r101 = AppHost.f326268a.getApplication();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L26;
        PackageInfo r102 = r101.getPackageManager().getPackageInfo(r100, 0);     // Catch: Exception -> L20
        if (r102 == null) goto L24;
        ApplicationInfo r103 = r102.applicationInfo;     // Catch: Exception -> L20
        if (r103 == null) goto L12;
        Boolean r104 = Boolean.valueOf(r103.enabled);     // Catch: Exception -> L20
    L13:
        if (r104 == null) goto L16;
        boolean r105 = r104.booleanValue();     // Catch: Exception -> L20
    L17:
        if (r105 == false) goto L25;
        return true;
    L25:
        return false;
    L16:
        r105 = false;
        goto L17
    L12:
        r104 = null;
        goto L13
    L24:
        return false;
    L27:
        return false;
    L26:
        return false;
    }

    public static Bitmap.Config b(Bitmap.Config r100) {
        Bitmap.Config r101 = Bitmap.Config.ARGB_8888;
        Intrinsics.checkNotNullParameter(r101, "defaultConfig");
        if (r100 == null) goto L5;
        return r100;
    L5:
        return r101;
    }
}
