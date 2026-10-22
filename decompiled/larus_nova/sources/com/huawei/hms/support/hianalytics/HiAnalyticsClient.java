package com.huawei.hms.support.hianalytics;

import android.content.Context;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class HiAnalyticsClient extends HiAnalyticsBase {
    private static final String TAG = "HiAnalyticsClient";

    public HiAnalyticsClient() {
    }

    public static String reportEntry(Context r100, String r101) {
        if (r100 != null) goto L6;
        HMSLog.e(TAG, "<reportEntry 2 param> context is null.");
        return "";
    L6:
        return reportEntry(r100, r101, Util.getAppId(r100), 0);
    }

    public static String reportEntry(Context r100, String r101, int r102) {
        if (r100 != null) goto L6;
        HMSLog.e(TAG, "<reportEntry 3 param> context is null.");
        return "";
    L6:
        return reportEntry(r100, r101, Util.getAppId(r100), r102);
    }

    public static String reportEntry(Context r100, String r101, String r102, int r103) {
        if (r100 != null) goto L6;
        HMSLog.e(TAG, "<reportEntry 4 param> context is null.");
        return "";
    L6:
        String r104 = TransactionIdCreater.getId(r102, r101);
        Map<String, String> r105 = HiAnalyticsBase.getMapForBi(r100, r101);
        r105.put("appid", r102);
        r105.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, r104);
        r105.put("direction", HiAnalyticsConstant.Direction.REQUEST);
        r105.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(r103)));
        r105.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(r100, HiAnalyticsConstant.HMS_SDK_KIT_API_CALLED, r105);
        return r104;
    }

    public static void reportExit(Context r100, String r101, String r102, int r110, int r111) {
        if (r100 != null) goto L5;
        HMSLog.e(TAG, "<reportExit 5 param> context is null.");
        return;
    L5:
        reportExit(r100, r101, r102, Util.getAppId(r100), r110, r111, 0);
    }

    public static void reportExit(Context r100, String r101, String r102, int r110, int r111, int r112) {
        if (r100 != null) goto L5;
        HMSLog.e(TAG, "<reportExit 6 param> context is null.");
        return;
    L5:
        reportExit(r100, r101, r102, Util.getAppId(r100), r110, r111, r112);
    }

    public static void reportExit(Context r100, String r101, String r102, String r103, int r104, int r105, int r106) {
        if (r100 != null) goto L5;
        HMSLog.e(TAG, "<reportExit 7 param> context is null.");
        return;
    L5:
        Map<String, String> r107 = HiAnalyticsBase.getMapForBi(r100, r101);
        r107.put("appid", r103);
        r107.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, r102);
        r107.put("direction", HiAnalyticsConstant.Direction.RESPONSE);
        r107.put("statusCode", String.valueOf(r104));
        r107.put("result", String.valueOf(r105));
        r107.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(r106)));
        r107.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(r100, HiAnalyticsConstant.HMS_SDK_KIT_API_CALLED, r107);
    }
}
