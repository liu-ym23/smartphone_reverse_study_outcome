package com.bytedance.crash.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f203414a = null;

    static {
        f203414a = new String[]{"unknown", "wifi", "mobile", CJPayBasicUtils.NETWORK_2G, CJPayBasicUtils.NETWORK_3G, CJPayBasicUtils.NETWORK_4G, CJPayBasicUtils.NETWORK_MOBILE};
    }

    public static boolean a() {
        Context r100 = com.bytedance.crash.i.getContext();
        if (r100 != null) goto L16;
        return false;
    L16:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L13
        if (r101 == null) goto L15;
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r102 == null) goto L18;
        if (r102.isAvailable() == false) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L15:
        return false;
    L13:
        e = move-exception;
        ch4.c.c(e);
        goto L15
    }
}
