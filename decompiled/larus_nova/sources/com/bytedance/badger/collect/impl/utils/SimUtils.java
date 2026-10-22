package com.bytedance.badger.collect.impl.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.telephony.SubscriptionManagerCompat;
import com.bytedance.badger.collect.impl.api.BadgerCollectApi;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.interfaces.ISimCardCompliance;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public class SimUtils {
    public static final int SIM_TYPE_MOBILE = 1;
    public static final int SIM_TYPE_TELECOM = 2;
    public static final int SIM_TYPE_UNICOM = 3;
    public static final int SIM_TYPE_UNKNOWN = 0;

    public SimUtils() {
    }

    public static int getSimCardSlotId() {
        int r100 = Build.VERSION.SDK_INT;     // Catch: Exception -> L9
        if (r100 < 24) goto L7;
        int r101 = SubscriptionManager.getDefaultDataSubscriptionId();     // Catch: Exception -> L9
        int r102 = SubscriptionManagerCompat.getSlotIndex(r101);     // Catch: Exception -> L9
        KLog.i(Constants.TAGS.WORKER, "默认数据网络的ID=" + r101 + ", 物理卡槽slotIndex=" + r102);     // Catch: Exception -> L9
        return r102;
    L7:
        KLog.w(Constants.TAGS.WORKER, "当前Android版本过低，无法获取,版本=" + r100);     // Catch: Exception -> L9
        return Constants.StatusCode.ERROR_SDK_VERSION_LOW.intValue();
    L9:
        e = move-exception;
        KLog.e(Constants.TAGS.WORKER, e);
        return Constants.StatusCode.FAILED.intValue();
    }

    private static int com_bytedance_badger_collect_impl_utils_SimUtils_android_telephony_SubscriptionInfo_getSubscriptionId(SubscriptionInfo r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
        a r101 = ApiHookConfig.f245611b.get(102134);
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
        d r106 = r105.preInvoke(102134, "android/telephony/SubscriptionInfo", "getSubscriptionId", r110, r111, "int", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Integer) r106.f474983b).intValue();
    L21:
        return r110.getSubscriptionId();
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

    public static String getSimIccId(Context r100) {
    L28:
        e = move-exception;
        KLog.e(Constants.TAGS.INIT, e);
        return "";
    L4:
        if (CommonUtils.hasPermission(r100, "android.permission.READ_PHONE_STATE") == true) goto L6;
        return "";
    L6:
        ISimCardCompliance r101 = BadgerCollectApi.getSimCardCompliance();     // Catch: Exception -> L28
        if (r101 != null) goto L10;
        return "";
    L10:
        if (Build.VERSION.SDK_INT < 24) goto L27;
        SubscriptionManager r102 = (SubscriptionManager) r100.getApplicationContext().getSystemService("telephony_subscription_service");     // Catch: Exception -> L28
        if (r102 == null) goto L27;
        int r103 = SubscriptionManager.getDefaultDataSubscriptionId();     // Catch: Exception -> L28
        List<SubscriptionInfo> r104 = r101.getActiveSubscriptionInfoList(r102);     // Catch: Exception -> L28
        if (r104 == null) goto L27;
        if (r104.size() <= 0) goto L27;
        Iterator<SubscriptionInfo> r105 = r104.iterator();     // Catch: Exception -> L28
    L19:
        if (r105.hasNext() == false) goto L27;
        SubscriptionInfo r106 = r105.next();     // Catch: Exception -> L28
        if (r106 == null) goto L19;
        if (com_bytedance_badger_collect_impl_utils_SimUtils_android_telephony_SubscriptionInfo_getSubscriptionId(r106) != r103) goto L19;
        return r101.getIccId(r106);
    L27:
        return r101.getSimSerialNumber((TelephonyManager) r100.getApplicationContext().getSystemService("phone"));
    }

    public static String getSimOperator(Context r100) {
        if (r100 != null) goto L17;
        KLog.e(Constants.TAGS.INIT, "getSimOperator:context == null");
        return "";
    L17:
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Exception -> L14
        if (r101 == null) goto L16;
        ISimCardCompliance r102 = BadgerCollectApi.getSimCardCompliance();     // Catch: Exception -> L14
        if (r102 != null) goto L13;
        KLog.e(Constants.TAGS.INIT, "sim error");     // Catch: Exception -> L14
        return "";
    L13:
        return r102.getSimOperator(r101);
    L16:
        return "";
    L14:
        e = move-exception;
        KLog.e(Constants.TAGS.INIT, e);
        goto L16
    }

    public static String getSimOperatorName(Context r100) {
        int r101 = getSimType(r100);
        if (r101 != 1) goto L5;
        return "中国移动";
    L5:
        if (r101 != 2) goto L7;
        return "中国电信";
    L7:
        if (r101 == 3) goto L10;
        return "UN_KNOW";
    L10:
        return "中国联通";
    }

    public static int getSimType(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return 0;
    L5:
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 49679470: goto L49;
            case 49679471: goto L45;
            case 49679472: goto L41;
            case 49679473: goto L37;
            case 49679474: goto L33;
            case 49679475: goto L29;
            case 49679476: goto L25;
            case 49679477: goto L21;
            case 49679478: goto L17;
            case 49679479: goto L13;
            case 49679502: goto L9;
            default: goto L52;
        };
    L52:
        switch(r101) {
            case 0: goto L56;
            case 1: goto L55;
            case 2: goto L56;
            case 3: goto L54;
            case 4: goto L56;
            case 5: goto L54;
            case 6: goto L55;
            case 7: goto L56;
            case 8: goto L56;
            case 9: goto L55;
            case 10: goto L54;
            default: goto L53;
        };
    L53:
        return 0;
    L54:
        return 2;
    L55:
        return 3;
    L56:
        return 1;
    L9:
        if (r100.equals("46011") == false) goto L52;
        r101 = 10;
        goto L52
    L13:
        if (r100.equals("46009") == false) goto L52;
        r101 = 9;
        goto L52
    L17:
        if (r100.equals("46008") == false) goto L52;
        r101 = 8;
        goto L52
    L21:
        if (r100.equals("46007") == false) goto L52;
        r101 = 7;
        goto L52
    L25:
        if (r100.equals("46006") == false) goto L52;
        r101 = 6;
        goto L52
    L29:
        if (r100.equals("46005") == false) goto L52;
        r101 = 5;
        goto L52
    L33:
        if (r100.equals("46004") == false) goto L52;
        r101 = 4;
        goto L52
    L37:
        if (r100.equals("46003") == false) goto L52;
        r101 = 3;
        goto L52
    L41:
        if (r100.equals("46002") == false) goto L52;
        r101 = 2;
        goto L52
    L45:
        if (r100.equals("46001") == false) goto L52;
        r101 = 1;
        goto L52
    L49:
        if (r100.equals("46000") == false) goto L52;
        r101 = 0;
        goto L52
    }

    public static int getSimType(Context r100) {
        return getSimType(getSimOperator(r100));
    }
}
