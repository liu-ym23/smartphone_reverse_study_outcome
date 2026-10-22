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

/* JADX INFO: loaded from: classes10.dex */
public class NetworkUtil {
    private final int[] netCapabilities;
    private final int[] netTransports;

    public NetworkUtil() {
        this.netCapabilities = new int[]{11, 15, 29, 32};
        this.netTransports = new int[]{5, 1, 4, 6, 3, 0, 2, 8, 9};
    }

    public static boolean checkVPN(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L18
        if (Build.VERSION.SDK_INT < 23) goto L9;
        NetworkCapabilities r102 = r101.getNetworkCapabilities(r101.getActiveNetwork());     // Catch: Throwable -> L18
        if (r102 != null) goto L8;
    L20:
        return false;
    L8:
        return r102.hasTransport(4);
    L9:
        Network[] r103 = r101.getAllNetworks();     // Catch: Throwable -> L18
        int r104 = r103.length;     // Catch: Throwable -> L18
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L20;
        NetworkCapabilities r106 = r101.getNetworkCapabilities(r103[r105]);     // Catch: Throwable -> L18
        if (r106 == null) goto L17;
        if (r106.hasTransport(4) == false) goto L17;
        return true;
    L17:
        r105 = r105 + 1;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public static boolean isMeteredNetworkCapability(Context r100) {
        if (r100 != null) goto L15;
        return false;
    L15:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L12
        if (Build.VERSION.SDK_INT < 23) goto L14;
        NetworkCapabilities r102 = r101.getNetworkCapabilities(r101.getActiveNetwork());     // Catch: Throwable -> L12
        if (r102 == null) goto L14;
        return !r102.hasCapability(11);
    L14:
        return false;
    L12:
        th = move-exception;
        Logger.e("NetworkUtil", "isMeteredNetworkAbility throwable: " + th.getMessage());
        goto L14
    }

    public static boolean isWifiProxy(Context r100) {
        String r101 = System.getProperty("http.proxyHost");     // Catch: Throwable -> L13
        String r102 = System.getProperty("http.proxyPort");     // Catch: Throwable -> L13
        if (r102 != null) goto L7;
        r102 = "-1";
    L7:
        int r103 = CastIntegerProtector.parseInt(r102);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return false;
    L10:
        if (r103 == (-1)) goto L19;
        return true;
    L19:
        return false;
    L13:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public NetworkAbilityEntity getNetworkAbility(Context r100) {
        if (r100 != null) goto L26;
        return null;
    L26:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L23
        if (Build.VERSION.SDK_INT < 23) goto L25;
        NetworkCapabilities r102 = r101.getNetworkCapabilities(r101.getActiveNetwork());     // Catch: Throwable -> L23
        if (r102 == null) goto L25;
        NetworkAbilityEntity r103 = new NetworkAbilityEntity();     // Catch: Throwable -> L23
        int r104 = Math.max(this.netCapabilities.length, this.netTransports.length);     // Catch: Throwable -> L23
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L22;
        int[] r106 = this.netCapabilities;     // Catch: Throwable -> L23
        if (r106.length > r105) goto L14;
    L16:
        int[] r107 = this.netTransports;     // Catch: Throwable -> L23
        if (r107.length <= r105) goto L21;
        if (r102.hasTransport(r107[r105]) == false) goto L21;
        r103.addNetTransport(this.netTransports[r105]);     // Catch: Throwable -> L23
    L21:
        r105 = r105 + 1;
        goto L10
    L14:
        if (r102.hasCapability(r106[r105]) == false) goto L16;
        r103.addNetCapability(this.netCapabilities[r105]);     // Catch: Throwable -> L23
        goto L16
    L22:
        return r103;
    L25:
        return null;
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L25
    }
}
