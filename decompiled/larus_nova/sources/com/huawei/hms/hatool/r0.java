package com.huawei.hms.hatool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f277432a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f277433b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Integer, String> f277434c = null;

    public static class a extends HashMap<Integer, String> {
        public a() {
            put(1, "2G");
            put(2, "2G");
            put(4, "2G");
            put(7, "2G");
            put(11, "2G");
            put(3, "3G");
            put(8, "3G");
            put(9, "3G");
            put(10, "3G");
            put(15, "3G");
            put(5, "3G");
            put(6, "3G");
            put(12, "3G");
            put(14, "3G");
            put(13, "4G");
            if (Build.VERSION.SDK_INT < 29) goto L6;
            put(20, "5G");
            return;
        }
    }

    static {
        f277432a = new int[]{1, 6, 7, 9};
        f277433b = new int[]{0, 2, 3, 4, 5};
        f277434c = new a();
    }

    private static NetworkInfo a(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L6
        if (r101 == null) goto L12;
        return r101.getActiveNetworkInfo();
    L12:
        return null;
    L6:
        th = move-exception;
        v.b("hmsSdk", "cannot get network state, ensure permission android.permission.ACCESS_NETWORK_STATE in the manifest: " + th.getMessage());
        return null;
    }

    private static String a(int r100) {
        Map<Integer, String> r101 = f277434c;
        if (r101.containsKey(Integer.valueOf(r100)) == false) goto L5;
        String r102 = r101.get(Integer.valueOf(r100));
    L7:
        if ("unknown".equals(r102) == false) goto L18;
        if (Build.VERSION.SDK_INT < 25) goto L18;
        if (r100 != 16) goto L13;
        return "2G";
    L13:
        if (r100 != 17) goto L21;
        return "3G";
    L21:
        return "unknown";
    L18:
        return r102;
    L5:
        r102 = "unknown";
        goto L7
    }

    private static boolean a(NetworkInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Arrays.binarySearch(f277433b, r100.getType()) == (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    public static String b(Context r100) {
        if (r100 != null) goto L20;
        return "unknown";
    L20:
        NetworkInfo r101 = a(r100);     // Catch: Throwable -> L19
        if (b(r101) == true) goto L11;
        return "none";
    L11:
        if (c(r101) == false) goto L15;
        return "WIFI";
    L15:
        if (a(r101) == false) goto L18;
        return a(r101.getSubtype());
    L18:
        return "unknown";
    }

    private static boolean b(NetworkInfo r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.isConnected() == false) goto L6;
        return true;
    }

    private static boolean c(NetworkInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Arrays.binarySearch(f277432a, r100.getType()) == (-1)) goto L9;
        return true;
    L9:
        return false;
    }
}
