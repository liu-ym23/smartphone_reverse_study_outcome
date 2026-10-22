package com.bytedance.awemeopen.infra.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class h {
    public static boolean a(Context r100) {
        boolean r101 = true;
        if (r100 != null) goto L6;
        return true;
    L6:
        if ((r100 instanceof Activity) == false) goto L23;
        r100 = r100.getApplicationContext();
    L23:
        NetworkInfo[] r102 = ((ConnectivityManager) r100.getSystemService("connectivity")).getAllNetworkInfo();     // Catch: Exception -> L22
        if (r102 == null) goto L19;
        int r103 = r102.length;     // Catch: Exception -> L22
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L19;
        NetworkInfo r105 = r102[r104];     // Catch: Exception -> L22
        if (r105.isAvailable() == false) goto L18;
        if (r105.getState() != NetworkInfo.State.CONNECTED) goto L18;
    L21:
        return r101;
    L18:
        r104 = r104 + 1;
    L19:
        r101 = false;
    L29:
        return false;
    }
}
