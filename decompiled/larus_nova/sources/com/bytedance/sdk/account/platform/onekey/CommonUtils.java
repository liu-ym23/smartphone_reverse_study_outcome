package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import f06.b;
import f06.d;
import java.util.ArrayList;
import tb7.a;

/* JADX INFO: loaded from: classes3.dex */
public class CommonUtils {
    private static volatile String carrierOperator = "";
    private static volatile int simCardReady;
    private static TelephonyManager telephonyManager;

    private CommonUtils() {
    }

    public static void cleanSimCache() {
        simCardReady = 0;
        carrierOperator = "";
        NetworkTypeHelper.carrierType = "";
        NetworkTypeHelper.subscriptionId = -1;
        CarrierCacheInfoHelper.INSTANCE.cleanCarrierCacheInfo(-1);
    }

    public static String getNetStatusName(int r100) {
        if (r100 == (-1)) goto L16;
        if (r100 != 0) goto L6;
        return "no_network";
    L6:
        if (r100 != 1) goto L8;
        return OnekeyLoginConstants.NETWORK_TYPE_MOBILE_STR;
    L8:
        if (r100 != 2) goto L10;
        return "wifi";
    L10:
        if (r100 == 3) goto L12;
        return "";
    L12:
        return OnekeyLoginConstants.NETWORK_TYPE_WIFI_AND_MOBILE_STR;
    L16:
        return "error";
    }

    public static String getCarrierOperator(Context r100) {
        if (TextUtils.isEmpty(carrierOperator) == false) goto L6;
        carrierOperator = getCarrierOperatorInner(r100);
    L6:
        return carrierOperator;
    }

    public static String getCarrierOperatorInner(Context r100) {
        Logger.d("TimeValueData", "call getCarrierOperatorInner");
        if (r100 != null) goto L11;
        return null;
    L11:
        return (String) BpeaManager.invokeDeviceInfoApi(r100, "phone", BpeaManager.getSimOperator, new Object[0]);
    L8:
        th = move-exception;
        a.e("CommonUtils", "getCarrierOperator: " + th);
        return null;
    }

    public static String getCarrierType(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L59;
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 49679470: goto L48;
            case 49679471: goto L44;
            case 49679472: goto L40;
            case 49679473: goto L36;
            case 49679474: goto L32;
            case 49679475: goto L28;
            case 49679476: goto L24;
            case 49679477: goto L20;
            case 49679478: goto L16;
            case 49679479: goto L12;
            case 49679502: goto L8;
            default: goto L51;
        };
    L51:
        switch(r101) {
            case 0: goto L57;
            case 1: goto L55;
            case 2: goto L57;
            case 3: goto L53;
            case 4: goto L57;
            case 5: goto L53;
            case 6: goto L55;
            case 7: goto L57;
            case 8: goto L57;
            case 9: goto L55;
            case 10: goto L53;
            default: goto L61;
        };
    L53:
        return "3";
    L55:
        return "2";
    L57:
        return "1";
    L61:
        return null;
    L8:
        if (r100.equals("46011") == false) goto L51;
        r101 = 10;
        goto L51
    L12:
        if (r100.equals("46009") == false) goto L51;
        r101 = 9;
        goto L51
    L16:
        if (r100.equals("46008") == false) goto L51;
        r101 = 8;
        goto L51
    L20:
        if (r100.equals("46007") == false) goto L51;
        r101 = 7;
        goto L51
    L24:
        if (r100.equals("46006") == false) goto L51;
        r101 = 6;
        goto L51
    L28:
        if (r100.equals("46005") == false) goto L51;
        r101 = 5;
        goto L51
    L32:
        if (r100.equals("46004") == false) goto L51;
        r101 = 4;
        goto L51
    L36:
        if (r100.equals("46003") == false) goto L51;
        r101 = 3;
        goto L51
    L40:
        if (r100.equals("46002") == false) goto L51;
        r101 = 2;
        goto L51
    L44:
        if (r100.equals("46001") == false) goto L51;
        r101 = 1;
        goto L51
    L48:
        if (r100.equals("46000") == false) goto L51;
        r101 = 0;
        goto L51
    L59:
        return null;
    }

    public static TelephonyManager getTelephonyManager(Context r100) {
        if (telephonyManager != null) goto L6;
        telephonyManager = (TelephonyManager) r100.getSystemService("phone");
    L6:
        return telephonyManager;
    }

    public static boolean isSimCardReady(Context r100) {
        return isSimCardReady(r100, false);
    }

    private static boolean isSimCardReadyInner(Context r100) {
        Logger.d("TimeValueData", "call isSimCardReadyInner");     // Catch: Exception -> L15
        if (r100 != null) goto L6;
        return true;
    L6:
        TelephonyManager r101 = getTelephonyManager(r100);     // Catch: Exception -> L15
        if (r101 != null) goto L9;
        return true;
    L9:
        int r102 = r101.getSimState();     // Catch: Exception -> L15
        NetworkTypeHelper.monitorSimStateResult(r100, r102);     // Catch: Exception -> L15
        if (r102 == 5) goto L20;
        return false;
    L20:
        return true;
    L15:
        e = move-exception;
        a.e("CommonUtils", "isSimCardReady: " + e);
        return true;
    }

    private static int com_bytedance_sdk_account_platform_onekey_CommonUtils_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        b r112 = new b("auto_cert_com_bytedance_sdk_account_platform_onekey_CommonUtils_android_content_Context_checkSelfPermission");
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

    public static boolean hasPermission(Context r100, String r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
    L14:
        return false;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        if (com_bytedance_sdk_account_platform_onekey_CommonUtils_android_content_Context_checkSelfPermission(r100, r101) == 0) goto L16;
        return false;
    L16:
        return true;
    }

    public static boolean isSimCardReady(Context r100, boolean r101) {
        int r102 = -1;
        if (OnekeySettingManager.instance().isEnableGetCarrierTypeOpt() == false) goto L20;
        int r103 = simCardReady;
        if (r101 == true) goto L8;
        if (r103 == 0) goto L8;
    L12:
        if (r103 == simCardReady) goto L16;
        a.d("CommonUtils", "simCardReady changed by other thread, tempSimCardReady=" + r103 + ", simCardReady=" + simCardReady);
        NetworkTypeHelper.monitorEnsureNotReachHere("simCardReady changed by other thread", r103 + "," + simCardReady);
        if (simCardReady == 0) goto L16;
        r103 = simCardReady;
    L16:
        if (r103 <= 0) goto L29;
        return true;
    L29:
        return false;
    L8:
        if (isSimCardReadyInner(r100) == false) goto L10;
        r102 = 1;
    L10:
        simCardReady = r102;
        r103 = r102;
        goto L12
    L20:
        if (simCardReady != 0) goto L26;
        if (isSimCardReadyInner(r100) == false) goto L24;
        r102 = 1;
    L24:
        simCardReady = r102;
    L26:
        if (simCardReady <= 0) goto L30;
        return true;
    L30:
        return false;
    }
}
