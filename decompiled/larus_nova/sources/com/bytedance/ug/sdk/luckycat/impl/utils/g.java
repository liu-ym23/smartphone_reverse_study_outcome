package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    public static class a {

        @SerializedName("function_name")
        String function_name;

        @SerializedName("status")
        int status;

        public a(String r100, int r101) {
            this.function_name = r100;
            this.status = r101;
        }
    }

    public static boolean b(Context r100) {
        LocationManager r101 = (LocationManager) r100.getSystemService("location");
        if (r101 != null) goto L5;
        return false;
    L5:
        boolean r102 = r101.isProviderEnabled(GeocodeSearch.GPS);
        boolean r103 = r101.isProviderEnabled("network");
        if (r102 == false) goto L10;
        if (r103 == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean c(Context r110) {
        WifiManager r100 = (WifiManager) r110.getSystemService("wifi");
        if (r100 != null) goto L5;
        return false;
    L5:
        ArrayList r111 = new ArrayList();
        Object[] r112 = new Object[0];
        f06.b r113 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102301);
        if (r101 == null) goto L8;
        f06.a[] r102 = r101.f479473i;
    L9:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L18;
        f06.a r106 = r103[r105];
        int r114 = r105;
        int r115 = r104;
        f06.a[] r116 = r103;
        f06.d r107 = r106.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r100, r112, "android.net.wifi.WifiInfo", r113);     // Catch: Exception -> L34
        if (r107.f474982a == true) goto L20;
        r111.add(r106);     // Catch: Exception -> L34
    L20:
        if (r107.f474982a == false) goto L22;
        WifiInfo r108 = (WifiInfo) r107.f474983b;
    L23:
        if (r108 != null) goto L25;
        int r109 = 0;
    L27:
        if (r100.isWifiEnabled() == true) goto L32;
        if (r109 != 0) goto L40;
        return false;
    L40:
        return true;
    L32:
        return true;
    L25:
        r109 = r108.getIpAddress();
        goto L27
    L22:
        r108 = r100.getConnectionInfo();
    L17:
        r105 = r114 + 1;
        r104 = r115;
        r103 = r116;
        goto L11
    L18:
        r107 = new f06.d(false, null);
        goto L20
    L8:
        r102 = ApiHookConfig.f245613d;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    public static List<a> a(Context r100, List<String> r101) {
        ArrayList r102 = (ArrayList) r101;
        if (r102.size() > 0) goto L6;
        return null;
    L6:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L36;
        String r105 = (String) r104.next();
        String r106 = r105.toLowerCase();
        r106.getClass();
        int r107 = 0;
        r107 = 0;
        r107 = 0;
        byte r108 = -1;
        switch(r106.hashCode()) {
            case 102570: goto L21;
            case 3649301: goto L17;
            case 1968882350: goto L13;
            default: goto L24;
        };
    L24:
        switch(r108) {
            case 0: goto L34;
            case 1: goto L33;
            case 2: goto L37;
            default: goto L35;
        };
    L33:
        r107 = c(r100);
        goto L35
    L34:
        r107 = b(r100);
        goto L35
    L37:
        BluetoothAdapter r109 = BluetoothAdapter.getDefaultAdapter();     // Catch: Throwable -> L31
        if (r109 == null) goto L35;
        r107 = r109.isEnabled();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.getLocalizedMessage();
    L35:
        r103.add(new a(r105, r107));
        goto L8
    L13:
        if (r106.equals("bluetooth") == false) goto L24;
        r108 = 2;
        goto L24
    L17:
        if (r106.equals("wifi") == false) goto L24;
        r108 = 1;
        goto L24
    L21:
        if (r106.equals(GeocodeSearch.GPS) == false) goto L24;
        r108 = 0;
        goto L24
    L36:
        return r103;
    }
}
