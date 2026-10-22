package com.ss.mediakit.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes40.dex */
public class NetUtils {
    public static final int NETTYPE_UNKNOWN = -1;

    public NetUtils() {
    }

    public static long getNetId(Network r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        return r100.getNetworkHandle();
    L10:
        return CastIntegerProtector.parseInt(r100.toString());
    }

    public static int getNetType(Context r100) {
        NetworkInfo r101 = getNetworkInfo(r100);     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        if (r101.isAvailable() == false) goto L9;
        return r101.getType();
    L9:
        return -1;
    }

    public static NetworkInfo getNetworkInfo(Context r100) {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        return null;
    L8:
        return ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();
    L7:
        return null;
    }
}
