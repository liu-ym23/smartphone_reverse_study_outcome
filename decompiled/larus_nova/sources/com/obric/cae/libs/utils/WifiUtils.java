package com.obric.cae.libs.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
import f06.b;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes33.dex */
public class WifiUtils {
    public static final int WIFI_BAND_24_GHZ = 1;
    public static final int WIFI_BAND_5_GHZ = 2;
    public static final int WIFI_BAND_6_GHZ = 8;

    public WifiUtils() {
    }

    public static int convertChannelToFrequencyMhz(int r100, int r101) {
        if (r101 != 1) goto L14;
        if (r100 != 14) goto L8;
        return ChannelsEnvironment.BAND_24_GHZ_END_FREQ_MHZ;
    L8:
        if (r100 < 1) goto L12;
        if (r100 > 14) goto L12;
        return ((r100 - 1) * 5) + ChannelsEnvironment.BAND_24_GHZ_START_FREQ_MHZ;
    L12:
        return -1;
    L14:
        if (r101 != 2) goto L23;
        if (r100 >= 32) goto L18;
    L21:
        return -1;
    L18:
        if (r100 > 173) goto L21;
        return ((r100 - 32) * 5) + ChannelsEnvironment.BAND_5_GHZ_START_FREQ_MHZ;
    L23:
        if (r101 != 8) goto L29;
        if (r100 < 1) goto L29;
        if (r100 > 233) goto L29;
        return ((r100 - 1) * 5) + ChannelsEnvironment.BAND_6_GHZ_START_FREQ_MHZ;
    L29:
        return -1;
    }

    public static boolean is24GHz(int r100) {
        if (r100 >= 2412) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 2484) goto L7;
        return true;
    }

    public static boolean is5GHz(int r100) {
        if (r100 >= 5160) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 5865) goto L7;
        return true;
    }

    public static boolean is6GHz(int r100) {
        if (r100 >= 5945) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 7105) goto L7;
        return true;
    }

    private static List com_obric_cae_libs_utils_WifiUtils_android_net_wifi_WifiManager_getScanResults(WifiManager r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        d r112 = r100.b(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, "java.util.List", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, null, r111, false);
        return (List) r112.f474983b;
    L6:
        List<ScanResult> r113 = r110.getScanResults();
        r100.a(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, r113, r111, true);
        return r113;
    }

    public static int convertFrequencyMhzToChannel(int r100) {
        if (r100 != 2484) goto L7;
        return 14;
    L7:
        if (is24GHz(r100) == false) goto L11;
        return ((r100 - 2412) / 5) + 1;
    L11:
        if (is5GHz(r100) == false) goto L15;
        return ((r100 - 5160) / 5) + 32;
    L15:
        if (is6GHz(r100) == true) goto L17;
        return -1;
    L17:
        return ((r100 - 5945) / 5) + 1;
    }

    public static boolean isWifiConnected(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (((WifiManager) r100.getSystemService("wifi")) == null) goto L31;
        if (r101 == null) goto L34;
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 23) goto L13;
        if (com_obric_cae_libs_utils_WifiUtils_android_content_Context_checkSelfPermission(r100, "android.permission.ACCESS_NETWORK_STATE") == 0) goto L13;
        LogUtil.e("WifiUtils", "isWifiConnected: ACCESS_NETWORK_STATE permission not granted");
        return false;
    L13:
        if (r102 < 23) goto L23;
        Network r103 = r101.getActiveNetwork();
        if (r103 != null) goto L17;
        return false;
    L17:
        NetworkCapabilities r104 = r101.getNetworkCapabilities(r103);
        if (r104 != null) goto L20;
        return false;
    L20:
        if (r104.hasTransport(1) == false) goto L30;
        return true;
    L30:
        return false;
    L23:
        NetworkInfo r105 = r101.getNetworkInfo(1);
        if (r105 != null) goto L26;
        return false;
    L26:
        if (r105.isConnected() == false) goto L33;
        return true;
    L33:
        return false;
    L34:
        return false;
    L31:
        return false;
    }

    public static String maskMacAddress(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        String[] r101 = r100.split(":");
        if (r101.length == 6) goto L10;
        return r100;
    L10:
        return r101[0] + ":" + r101[1] + ":" + r101[2] + ":**:**:" + r101[5];
    }

    public static String removeDoubleQuotes(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        int r101 = r100.length();
        if (r101 > 1) goto L9;
        return r100;
    L9:
        if (r100.charAt(0) != '\"') goto L15;
        int r102 = r101 - 1;
        if (r100.charAt(r102) == '\"') goto L13;
        return r100;
    L13:
        return r100.substring(1, r102);
    L15:
        return r100;
    }

    public static String ssidHide(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        StringBuilder r101 = new StringBuilder(r100);
        int r102 = r100.length() / 3;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L10;
        r101.setCharAt(r103, '*');
        r103 = r103 + 1;
        goto L7
    L10:
        return r101.toString();
    }

    private static int com_obric_cae_libs_utils_WifiUtils_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        b r112 = new b("auto_cert_com_obric_cae_libs_utils_WifiUtils_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static List<ScanResult> getWifiScanResults(Context r100, WifiManager r101) {
        if (r101 == null) goto L4;
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 33) goto L12;
        if (com_obric_cae_libs_utils_WifiUtils_android_content_Context_checkSelfPermission(r100, "android.permission.NEARBY_WIFI_DEVICES") == 0) goto L18;
        LogUtil.e("WifiUtils", "getWifiScanResults: NEARBY_WIFI_DEVICES permission not granted");
        return Collections.emptyList();
    L18:
        return com_obric_cae_libs_utils_WifiUtils_android_net_wifi_WifiManager_getScanResults(r101);
    L12:
        if (r102 < 23) goto L18;
        if (com_obric_cae_libs_utils_WifiUtils_android_content_Context_checkSelfPermission(r100, "android.permission.ACCESS_FINE_LOCATION") == 0) goto L18;
        LogUtil.e("WifiUtils", "getWifiScanResults: ACCESS_FINE_LOCATION permission not granted");
        return Collections.emptyList();
    L4:
        return Collections.emptyList();
    }
}
