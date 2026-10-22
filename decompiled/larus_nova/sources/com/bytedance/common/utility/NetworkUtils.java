package com.bytedance.common.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import f06.b;
import f06.d;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final class NetworkUtils {
    static final boolean DEBUG_MOBILE = false;
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final long INTERVAL = 2000;
    private static final int MAX_24G = 2500;
    private static final int MAX_5G = 5900;
    private static final int MIN_24G = 2400;
    private static final int MIN_5G = 4900;
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final int NR_STATE = 3;
    private static final String PARAMETER_SEPARATOR = "&";
    private static long lastAdjustTime;
    private static boolean sIsReceiverRegisted;
    private static NetworkType sNetworkType;
    private static NetworkTypeInterceptor sNetworkTypeInterceptor;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r100 = new CompressType(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            CompressType r101 = new CompressType("GZIP", 1, 1);
            GZIP = r101;
            CompressType r102 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r102;
            $VALUES = new CompressType[]{r100, r101, r102};
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }

        public static CompressType valueOf(String r100) {
            return (CompressType) a.a(CompressType.class, r100);
        }

        private CompressType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_3G_H = null;
        public static final NetworkType MOBILE_3G_HP = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType MOBILE_5G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;
        public static final NetworkType WIFI_24GHZ = null;
        public static final NetworkType WIFI_5GHZ = null;
        final int nativeInt;

        static {
            NetworkType r100 = new NetworkType("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            NetworkType r101 = new NetworkType(UserProfileEvent.POSITION_NONE, 1, 0);
            NONE = r101;
            NetworkType r102 = new NetworkType("MOBILE", 2, 1);
            MOBILE = r102;
            NetworkType r103 = new NetworkType("MOBILE_2G", 3, 2);
            MOBILE_2G = r103;
            NetworkType r104 = new NetworkType("MOBILE_3G", 4, 3);
            MOBILE_3G = r104;
            NetworkType r105 = new NetworkType("WIFI", 5, 4);
            WIFI = r105;
            NetworkType r110 = new NetworkType("MOBILE_4G", 6, 5);
            MOBILE_4G = r110;
            NetworkType r111 = new NetworkType("MOBILE_5G", 7, 6);
            MOBILE_5G = r111;
            NetworkType r112 = new NetworkType("WIFI_24GHZ", 8, 7);
            WIFI_24GHZ = r112;
            NetworkType r113 = new NetworkType("WIFI_5GHZ", 9, 8);
            WIFI_5GHZ = r113;
            NetworkType r114 = new NetworkType("MOBILE_3G_H", 10, 9);
            MOBILE_3G_H = r114;
            NetworkType r115 = new NetworkType("MOBILE_3G_HP", 11, 10);
            MOBILE_3G_HP = r115;
            $VALUES = new NetworkType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        public boolean is2G() {
            if (this != MOBILE) goto L5;
        L8:
            return true;
        L5:
            if (this == MOBILE_2G) goto L8;
            return false;
        }

        public boolean is3GOrHigher() {
            if (this != MOBILE_3G) goto L5;
        L14:
            return true;
        L5:
            if (this == MOBILE_3G_H) goto L14;
            if (this == MOBILE_3G_HP) goto L14;
            if (this == MOBILE_4G) goto L14;
            if (this == MOBILE_5G) goto L14;
            return false;
        }

        public boolean is4GOrHigher() {
            if (this != MOBILE_4G) goto L5;
        L8:
            return true;
        L5:
            if (this == MOBILE_5G) goto L8;
            return false;
        }

        public boolean isAvailable() {
            if (this != UNKNOWN) goto L5;
        L7:
            return false;
        L5:
            if (this == NONE) goto L7;
            return true;
        }

        public boolean isWifi() {
            if (this != WIFI) goto L5;
            return true;
        L5:
            return false;
        }

        public int getValue() {
            return this.nativeInt;
        }

        public static NetworkType valueOf(String r100) {
            return (NetworkType) a.a(NetworkType.class, r100);
        }

        private NetworkType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public interface NetworkTypeInterceptor {
    }

    public static boolean is24GHz(int r100) {
        if (r100 > MIN_24G) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 2500) goto L7;
        return true;
    }

    public static boolean is5GHz(int r100) {
        if (r100 > MIN_5G) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= MAX_5G) goto L7;
        return true;
    }

    public static void setNetworkTypeInterceptor(NetworkTypeInterceptor r100) {
    }

    static {
        sNetworkType = NetworkType.UNKNOWN;
        sIsReceiverRegisted = false;
        lastAdjustTime = 0;
    }

    private NetworkUtils() {
    }

    private static void adjustNetwork(Context r100) {
        if ((System.currentTimeMillis() - lastAdjustTime) <= 2000) goto L6;
        sNetworkType = getNetworkType(r100);
        lastAdjustTime = System.currentTimeMillis();
        return;
    }

    private static void checkNetworkTypeInit(Context r100) {
        registerReceiver(r100);
        if (sNetworkType != NetworkType.UNKNOWN) goto L6;
        sNetworkType = getNetworkType(r100);
        return;
    }

    private static WifiInfo com_bytedance_common_utility_NetworkUtils_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
        g06.a r101 = ApiHookConfig.f245611b.get(102301);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r110, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (WifiInfo) r106.f474983b;
    L21:
        return r110.getConnectionInfo();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String getNetworkAccessType(NetworkType r100) {
        if (r100 != NetworkType.WIFI) goto L6;
        return "wifi";
    L6:
        if (r100 != NetworkType.WIFI_24GHZ) goto L9;
        return "wifi24ghz";
    L9:
        if (r100 != NetworkType.WIFI_5GHZ) goto L12;
        return "wifi5ghz";
    L12:
        if (r100 != NetworkType.MOBILE_2G) goto L15;
        return CJPayBasicUtils.NETWORK_2G;
    L15:
        if (r100 != NetworkType.MOBILE_3G) goto L18;
        return CJPayBasicUtils.NETWORK_3G;
    L18:
        if (r100 != NetworkType.MOBILE_3G_H) goto L21;
        return "3gh";
    L21:
        if (r100 != NetworkType.MOBILE_3G_HP) goto L24;
        return "3ghp";
    L24:
        if (r100 != NetworkType.MOBILE_4G) goto L27;
        return CJPayBasicUtils.NETWORK_4G;
    L27:
        if (r100 != NetworkType.MOBILE_5G) goto L30;
        return CJPayBasicUtils.NETWORK_MOBILE;
    L30:
        if (r100 != NetworkType.MOBILE) goto L32;
        return "mobile";
    L32:
        return "";
    }

    public static NetworkType getNetworkType(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L34
        if (r101 == null) goto L33;
        if (r101.isAvailable() == false) goto L33;
        int r102 = r101.getType();     // Catch: Throwable -> L34
        if (1 == r102) goto L10;
        if (r102 != 0) goto L31;
        int r103 = ((TelephonyManager) r100.getSystemService("phone")).getNetworkType();     // Catch: Throwable -> L34
        if (r103 == 3) goto L29;
        if (r103 == 20) goto L27;
        if (r103 == 5) goto L29;
        if (r103 == 6) goto L29;
        switch(r103) {
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            default: goto L21;
        };     // Catch: Throwable -> L34
    L21:
        switch(r103) {
            case 12: goto L29;
            case 13: goto L25;
            case 14: goto L29;
            case 15: goto L29;
            default: goto L23;
        };     // Catch: Throwable -> L34
    L23:
        return NetworkType.MOBILE;
    L25:
        return NetworkType.MOBILE_4G;
    L27:
        return NetworkType.MOBILE_5G;
    L29:
        return NetworkType.MOBILE_3G;
    L31:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L33:
        return NetworkType.NONE;
    L35:
        return NetworkType.MOBILE;
    }

    public static String getNetworkTypeDetail(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L62
        if (r101 != null) goto L6;
        return "none";
    L6:
        if (r101.isAvailable() == false) goto L65;
        int r102 = r101.getType();     // Catch: Throwable -> L62
        if (1 == r102) goto L11;
        if (r102 != 0) goto L59;
        TelephonyManager r103 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L62
        switch(r103.getNetworkType()) {
            case 1: goto L55;
            case 2: goto L53;
            case 3: goto L51;
            case 4: goto L49;
            case 5: goto L47;
            case 6: goto L45;
            case 7: goto L43;
            case 8: goto L41;
            case 9: goto L39;
            case 10: goto L37;
            case 11: goto L35;
            case 12: goto L33;
            case 13: goto L31;
            case 14: goto L29;
            case 15: goto L27;
            case 16: goto L25;
            case 17: goto L23;
            case 18: goto L58;
            case 19: goto L21;
            case 20: goto L19;
            default: goto L58;
        };     // Catch: Throwable -> L62
    L19:
        return LocationInfoConst.NR;
    L21:
        return "lte_ca";
    L23:
        return "td_scdma";
    L25:
        return LocationInfoConst.GSM;
    L27:
        return "hspap";
    L29:
        return "ehrpd";
    L31:
        return LocationInfoConst.LTE;
    L33:
        return "evdo_b";
    L35:
        return "iden";
    L37:
        return "hspa";
    L39:
        return "hsupa";
    L41:
        return "hsdpa";
    L43:
        return "1xrtt";
    L45:
        return "evdo_a";
    L47:
        return "evdo_0";
    L49:
        return LocationInfoConst.CDMA;
    L51:
        return "umts";
    L53:
        return "edge";
    L55:
        return "gprs";
    L58:
        return String.valueOf(r103.getNetworkType());
    L59:
        return "unknown";
    L11:
        if (isWifi5GHz(r100) == true) goto L64;
        return "wifi";
    L64:
        return "wifi5g";
    L65:
        return "none";
    L62:
        return "unknown";
    }

    public static NetworkType getNetworkTypeFast(Context r100) {
        checkNetworkTypeInit(r100);
        adjustNetwork(r100);
        return sNetworkType;
    }

    public static boolean is2G(Context r100) {
        NetworkType r101 = getNetworkType(r100);
        if (r101 != NetworkType.MOBILE) goto L5;
    L8:
        return true;
    L5:
        if (r101 == NetworkType.MOBILE_2G) goto L8;
        return false;
    }

    public static boolean is2GFast(Context r100) {
        checkNetworkTypeInit(r100);
        adjustNetwork(r100);
        return sNetworkType.is2G();
    }

    public static boolean isNetworkAvailable(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r101 == null) goto L12;
        if (r101.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean isNetworkAvailableFast(Context r100) {
        checkNetworkTypeInit(r100);
        adjustNetwork(r100);
        return sNetworkType.isAvailable();
    }

    public static boolean isWifi(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.isAvailable() == false) goto L17;
        if (1 != r101.getType()) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L19:
        return false;
    }

    public static boolean isWifi5GHz(Context r100) {
        return is5GHz(com_bytedance_common_utility_NetworkUtils_android_net_wifi_WifiManager_getConnectionInfo((WifiManager) r100.getApplicationContext().getSystemService("wifi")).getFrequency());
    }

    public static boolean isWifiFast(Context r100) {
        checkNetworkTypeInit(r100);
        adjustNetwork(r100);
        return sNetworkType.isWifi();
    }

    private static void registerReceiver(Context r100) {
        if (sIsReceiverRegisted == true) goto L7;
        if (r100 == null) goto L8;
        IntentFilter r101 = new IntentFilter();
        r101.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r101.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r101.addAction("android.net.wifi.STATE_CHANGE");
        INVOKEVIRTUAL_com_bytedance_common_utility_NetworkUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100.getApplicationContext(), new NetworkConnectChangeReceiver(), r101);
        sIsReceiverRegisted = true;
        return;
    L8:
        return;
    }

    public static void setNetworkType(NetworkType r100) {
        sNetworkType = r100;
    }

    public static String getNetworkAccessType(Context r100) {
        return getNetworkAccessType(getNetworkType(r100));
    }

    private static String encode(String r100, String r101) {
        if (r101 != null) goto L10;
        r101 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r100, r101);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String format(List<Pair<String, String>> r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        Iterator<Pair<String, String>> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        Pair<String, String> r104 = r103.next();
        String r105 = encode((String) r104.first, r101);
        String r106 = (String) r104.second;
        if (r106 == null) goto L8;
        String r107 = encode(r106, r101);
    L10:
        if (r102.length() <= 0) goto L12;
        r102.append("&");
    L12:
        r102.append(r105);
        r102.append("=");
        r102.append(r107);
        goto L4
    L8:
        r107 = "";
        goto L10
    L14:
        return r102.toString();
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_common_utility_NetworkUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
