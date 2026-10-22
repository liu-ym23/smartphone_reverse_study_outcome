package com.bytedance.bdlocation.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdlocation.entity.NetworkAbilityEntity;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class NetworkUtil {
    private final int[] netCapabilities;
    private final int[] netTransports;

    public NetworkUtil() {
        this.netCapabilities = new int[]{11, 15, 29, 32};
        this.netTransports = new int[]{5, 1, 4, 6, 3, 0, 2, 8, 9};
    }

    public static boolean checkVPN(Context r6) {
        ConnectivityManager r7 = (ConnectivityManager) r6.getSystemService("connectivity");     // Catch: Throwable -> L18
        if (Build.VERSION.SDK_INT < 23) goto L9;
        NetworkCapabilities r8 = r7.getNetworkCapabilities(r7.getActiveNetwork());     // Catch: Throwable -> L18
        if (r8 != null) goto L8;
    L20:
        return false;
    L8:
        return r8.hasTransport(4);
    L9:
        Network[] r1 = r7.getAllNetworks();     // Catch: Throwable -> L18
        int r2 = r1.length;     // Catch: Throwable -> L18
        int r4 = 0;
    L10:
        if (r4 >= r2) goto L20;
        NetworkCapabilities r5 = r7.getNetworkCapabilities(r1[r4]);     // Catch: Throwable -> L18
        if (r5 == null) goto L17;
        if (r5.hasTransport(4) == false) goto L17;
        return true;
    L17:
        r4 = r4 + 1;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public static boolean isMeteredNetworkCapability(Context r3) {
        if (r3 != null) goto L15;
        return false;
    L15:
        ConnectivityManager r4 = (ConnectivityManager) r3.getSystemService("connectivity");     // Catch: Throwable -> L12
        if (Build.VERSION.SDK_INT < 23) goto L14;
        NetworkCapabilities r5 = r4.getNetworkCapabilities(r4.getActiveNetwork());     // Catch: Throwable -> L12
        if (r5 == null) goto L14;
        return !r5.hasCapability(11);
    L14:
        return false;
    L12:
        th = move-exception;
        Logger.e("NetworkUtil", "isMeteredNetworkAbility throwable: " + th.getMessage());
        goto L14
    }

    public static boolean isWifiProxy(Context r2) {
        String r0 = System.getProperty("http.proxyHost");     // Catch: Throwable -> L13
        String r1 = System.getProperty("http.proxyPort");     // Catch: Throwable -> L13
        if (r1 != null) goto L7;
        r1 = "-1";
    L7:
        int r3 = CastIntegerProtector.parseInt(r1);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r0) == false) goto L10;
        return false;
    L10:
        if (r3 == (-1)) goto L19;
        return true;
    L19:
        return false;
    L13:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public NetworkAbilityEntity getNetworkAbility(Context r7) {
        if (r7 != null) goto L26;
        return null;
    L26:
        ConnectivityManager r8 = (ConnectivityManager) r7.getSystemService("connectivity");     // Catch: Throwable -> L23
        if (Build.VERSION.SDK_INT < 23) goto L25;
        NetworkCapabilities r9 = r8.getNetworkCapabilities(r8.getActiveNetwork());     // Catch: Throwable -> L23
        if (r9 == null) goto L25;
        NetworkAbilityEntity r1 = new NetworkAbilityEntity();     // Catch: Throwable -> L23
        int r2 = Math.max(this.netCapabilities.length, this.netTransports.length);     // Catch: Throwable -> L23
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L22;
        int[] r4 = this.netCapabilities;     // Catch: Throwable -> L23
        if (r4.length > r3) goto L14;
    L16:
        int[] r5 = this.netTransports;     // Catch: Throwable -> L23
        if (r5.length <= r3) goto L21;
        if (r9.hasTransport(r5[r3]) == false) goto L21;
        r1.addNetTransport(this.netTransports[r3]);     // Catch: Throwable -> L23
    L21:
        r3 = r3 + 1;
        goto L10
    L14:
        if (r9.hasCapability(r4[r3]) == false) goto L16;
        r1.addNetCapability(this.netCapabilities[r3]);     // Catch: Throwable -> L23
        goto L16
    L22:
        return r1;
    L25:
        return null;
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L25
    }
}
