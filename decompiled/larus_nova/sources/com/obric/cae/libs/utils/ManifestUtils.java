package com.obric.cae.libs.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.ServiceInfo;

/* JADX INFO: loaded from: classes33.dex */
public final class ManifestUtils {
    public ManifestUtils() {
    }

    public static boolean isServiceSingleUser(Context r100, Class<?> r101) {
        ServiceInfo r102 = r100.getPackageManager().getServiceInfo(new ComponentName(r100, r101), 0);     // Catch: Throwable -> L13
        int r103 = ServiceInfo.class.getField("FLAG_SINGLE_USER").getInt(null);     // Catch: NoSuchFieldException -> L7 Throwable -> L13 Throwable -> L13
    L8:
        if ((r102.flags & r103) == 0) goto L18;
        return true;
    L18:
        return false;
    L7:
        r103 = ComponentInfo.class.getField("FLAG_SINGLE_USER").getInt(null);     // Catch: Throwable -> L13 Throwable -> L13
    L19:
        return false;
    }
}
