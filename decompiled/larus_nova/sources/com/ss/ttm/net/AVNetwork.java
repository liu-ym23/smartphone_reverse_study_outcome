package com.ss.ttm.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/* JADX INFO: loaded from: classes40.dex */
public final class AVNetwork {
    public static final int IS_MOBILE_NETWORK = 2;
    public static final int IS_UNKOWN_NETWORK = 0;
    public static final int IS_WIFF_NETWORK = 1;

    public AVNetwork() {
    }

    public static int getNetworkType(Context r100) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        return 0;
    L6:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L22
        if (r101 == null) goto L9;
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Throwable -> L22
    L10:
        if (r102 == null) goto L12;
        int r103 = r102.getType();     // Catch: Throwable -> L22
        if (r103 == 1) goto L16;
        if (r103 != 0) goto L21;
        return 2;
    L16:
        return 1;
    L12:
        return 0;
    L9:
        r102 = null;
    L21:
        return 0;
    }
}
