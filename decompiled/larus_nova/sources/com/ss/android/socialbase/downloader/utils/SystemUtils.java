package com.ss.android.socialbase.downloader.utils;

import android.content.Context;
import android.content.pm.ServiceInfo;

/* JADX INFO: loaded from: classes38.dex */
public class SystemUtils {
    public SystemUtils() {
    }

    public static boolean checkServiceExists(Context r100, String r101, String r102) {
        ServiceInfo[] r103 = r100.getPackageManager().getPackageInfo(r101, 4).services;     // Catch: Throwable -> L16
        int r104 = r103.length;     // Catch: Throwable -> L16
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L18;
        ServiceInfo r106 = r103[r105];     // Catch: Throwable -> L16
        if (r106.exported == false) goto L15;
        if (r106.enabled == false) goto L15;
        if (r106.permission != null) goto L15;
        if (r106.name.equals(r102) == false) goto L15;
        return true;
    L15:
        r105 = r105 + 1;
    L18:
        return false;
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }
}
