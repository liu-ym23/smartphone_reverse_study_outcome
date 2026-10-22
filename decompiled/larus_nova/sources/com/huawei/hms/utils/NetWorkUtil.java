package com.huawei.hms.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes23.dex */
public abstract class NetWorkUtil {

    public static final class NetType {
        public static final int NET = -2;
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_5G = 5;
        public static final int TYPE_ETHERNET = 9;
        public static final int TYPE_NEED_INIT = -1;
        public static final int TYPE_OTHER = 6;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
        public static final int WAP = -3;

        public NetType() {
        }
    }

    public NetWorkUtil() {
    }

    private static int a(NetworkInfo r100) {
        if (r100 != null) goto L4;
    L21:
        return 0;
    L4:
        if (r100.isConnected() == false) goto L21;
        if (r100.getType() != 1) goto L9;
        return 1;
    L9:
        if (r100.getType() != 0) goto L19;
        int r101 = r100.getSubtype();
        if (r101 == 20) goto L17;
        switch(r101) {
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L15;
            case 7: goto L15;
            case 8: goto L15;
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L15;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L14;
            case 15: goto L15;
            default: goto L13;
        };
    L13:
        return 6;
    L14:
        return 4;
    L15:
        return 3;
    L16:
        return 2;
    L17:
        return 5;
    L19:
        if (9 != r100.getType()) goto L21;
        return 9;
    }

    public static int getNetworkType(Context r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return a(a(r100));
    }

    private static NetworkInfo a(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getActiveNetworkInfo();
    }
}
