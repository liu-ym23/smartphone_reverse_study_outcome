package com.bytedance.badger.collect.impl.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import f06.b;
import f06.c;
import f06.d;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes47.dex */
public class NetworkTypeUtils {
    public NetworkTypeUtils() {
    }

    private static String com_bytedance_badger_collect_impl_utils_NetworkTypeUtils_android_telephony_TelephonyManager_getSimOperator(TelephonyManager r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        d r112 = r100.b(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getSimOperator();
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, r113, r111, true);
        return r113;
    }

    public static String getCarrier(Context r110) {
        if (isSimCardReady(r110) == true) goto L7;
        return "sim card not ready";
    L7:
        String r111 = getCarrierType(getMccMnc(r110));     // Catch: Exception -> L46
        int r100 = r111.hashCode();     // Catch: Exception -> L46
        if (r100 == (-1300183871)) goto L31;
        if (r100 == (-278955830)) goto L28;
        if (r100 == (-50643271)) goto L25;
        if (r100 == 0) goto L22;
        if (r100 == 1582678639) goto L19;
    L33:
        byte r112 = -1;
    L34:
        if (r112 == 0) goto L44;
        if (r112 == 1) goto L52;
        if (r112 == 2) goto L51;
        if (r112 == 3) goto L50;
        if (r112 == 4) goto L49;
        return "";
    L49:
        return Constants.NetworkOperator.OTHERS_OPERATOR;
    L50:
        return Constants.NetworkOperator.TELECOM_OPERATOR;
    L51:
        return Constants.NetworkOperator.UNICOM_OPERATOR;
    L52:
        return Constants.NetworkOperator.MOBILE_OPERATOR;
    L44:
        return Constants.NetworkOperator.UNKNOWN_OPERATOR;
    L19:
        if (r111.equals(Constants.NetworkOperator.TELECOM_OPERATOR) == false) goto L33;
        r112 = 3;
        goto L34
    L22:
        if (r111.equals("") == false) goto L33;
        r112 = 0;
        goto L34
    L25:
        if (r111.equals(Constants.NetworkOperator.UNICOM_OPERATOR) == false) goto L33;
        r112 = 2;
        goto L34
    L28:
        if (r111.equals(Constants.NetworkOperator.MOBILE_OPERATOR) == false) goto L33;
        r112 = 1;
        goto L34
    L31:
        if (r111.equals(Constants.NetworkOperator.OTHERS_OPERATOR) == false) goto L33;
        r112 = 4;
        goto L34
    L53:
        return "";
    }

    private static String getCarrierType(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 49679470: goto L46;
            case 49679471: goto L42;
            case 49679472: goto L38;
            case 49679473: goto L34;
            case 49679474: goto L30;
            case 49679475: goto L26;
            case 49679476: goto L22;
            case 49679477: goto L18;
            case 49679478: goto L14;
            case 49679479: goto L10;
            case 49679502: goto L6;
            default: goto L49;
        };
    L49:
        switch(r101) {
            case 0: goto L56;
            case 1: goto L54;
            case 2: goto L56;
            case 3: goto L52;
            case 4: goto L56;
            case 5: goto L52;
            case 6: goto L54;
            case 7: goto L56;
            case 8: goto L56;
            case 9: goto L54;
            case 10: goto L52;
            default: goto L50;
        };
    L50:
        return "";
    L52:
        return Constants.NetworkOperator.TELECOM_OPERATOR;
    L54:
        return Constants.NetworkOperator.UNICOM_OPERATOR;
    L56:
        return Constants.NetworkOperator.MOBILE_OPERATOR;
    L6:
        if (r100.equals("46011") == false) goto L49;
        r101 = 10;
        goto L49
    L10:
        if (r100.equals("46009") == false) goto L49;
        r101 = 9;
        goto L49
    L14:
        if (r100.equals("46008") == false) goto L49;
        r101 = 8;
        goto L49
    L18:
        if (r100.equals("46007") == false) goto L49;
        r101 = 7;
        goto L49
    L22:
        if (r100.equals("46006") == false) goto L49;
        r101 = 6;
        goto L49
    L26:
        if (r100.equals("46005") == false) goto L49;
        r101 = 5;
        goto L49
    L30:
        if (r100.equals("46004") == false) goto L49;
        r101 = 4;
        goto L49
    L34:
        if (r100.equals("46003") == false) goto L49;
        r101 = 3;
        goto L49
    L38:
        if (r100.equals("46002") == false) goto L49;
        r101 = 2;
        goto L49
    L42:
        if (r100.equals("46001") == false) goto L49;
        r101 = 1;
        goto L49
    L46:
        if (r100.equals("46000") == false) goto L49;
        r101 = 0;
        goto L49
    }

    public static String getMccMnc(Context r100) {
        if (r100 != null) goto L11;
        return "";
    L11:
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        return "";
    L8:
        return com_bytedance_badger_collect_impl_utils_NetworkTypeUtils_android_telephony_TelephonyManager_getSimOperator(r101);
    L10:
        return "";
    }

    public static String getNetworkStatus(Context r100) {
        if (r100 != null) goto L5;
        return Constants.NetworkOperator.NETWORK_TYPE_UNKNOWN;
    L5:
        ConnectivityManager r101 = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");
        if (r101 != null) goto L9;
        return Constants.NetworkOperator.NETWORK_TYPE_UNKNOWN;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L22;
        Network r102 = r101.getActiveNetwork();
        if (r102 == null) goto L22;
        NetworkCapabilities r103 = r101.getNetworkCapabilities(r102);
        if (r103 == null) goto L22;
        boolean r104 = r103.hasTransport(0);
        boolean r105 = r103.hasTransport(1);
        if (isDataMobileEnabled(r100, r101) == false) goto L18;
        if (r105 == false) goto L18;
        return Constants.NetworkOperator.NETWORK_TYPE_WIFI_AND_MOBILE;
    L18:
        if (r105 == false) goto L20;
        return Constants.NetworkOperator.NETWORK_TYPE_WIFI;
    L20:
        if (r104 == false) goto L22;
        return Constants.NetworkOperator.NETWORK_TYPE_MOBILE;
    L22:
        NetworkInfo r106 = r101.getActiveNetworkInfo();
        if (r106 != null) goto L25;
    L35:
        return Constants.NetworkOperator.NETWORK_TYPE_NO_NET;
    L25:
        if (r106.isAvailable() == false) goto L35;
        int r107 = r106.getType();
        if (r107 == 1) goto L30;
        if (r107 != 0) goto L35;
        return Constants.NetworkOperator.NETWORK_TYPE_MOBILE;
    L30:
        if (isDataMobileEnabled(r100, r101) == false) goto L32;
        return Constants.NetworkOperator.NETWORK_TYPE_WIFI_AND_MOBILE;
    L32:
        return Constants.NetworkOperator.NETWORK_TYPE_WIFI;
    }

    public static boolean isNetReady(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r101 == null) goto L12;
        if (r101.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    private static boolean isSimCardReady(Context r100) {
        if (r100 == null) goto L15;
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Exception -> L12
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.getSimState() != 5) goto L16;
        return true;
    L16:
        return false;
    L17:
        return false;
    L15:
        return false;
    }

    private static boolean isDataMobileEnabled(Context r100, ConnectivityManager r101) {
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        return false;
    L4:
        if (isSimCardReady(r100) == true) goto L6;
        return false;
    L6:
        Method r102 = r101.getClass().getDeclaredMethod("getMobileDataEnabled", new Class[0]);     // Catch: Exception -> L10
        if (r102 == null) goto L12;
        r102.setAccessible(true);     // Catch: Exception -> L10
        return ((Boolean) r102.invoke(r101, new Object[0])).booleanValue();
    }
}
