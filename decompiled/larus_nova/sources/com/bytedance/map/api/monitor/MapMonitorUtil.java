package com.bytedance.map.api.monitor;

import android.content.Context;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.map.api.utils.JsonUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class MapMonitorUtil {
    private static final String SDK_VERSION = "1.11.3";
    private static final String SLARDAR_AID = "366174";
    private static String sBizName;
    private static boolean sIsInit;
    private static SDKMonitor sSDKMonitor;

    public MapMonitorUtil() {
    }

    public static String getBizName() {
        return sBizName;
    }

    private static JSONObject getHeader(IMonitorDepend r100) {
        JSONObject r101 = new JSONObject();
        JsonUtil.safePutString(r101, "sdk_version", "1.11.3");
        JsonUtil.safePutString(r101, "host_aid", r100.getAppId());
        JsonUtil.safePutString(r101, "device_id", r100.getDeviceId());
        JsonUtil.safePutString(r101, "package_name", r100.getPackageName());
        JsonUtil.safePutString(r101, "channel", r100.getChannel());
        JsonUtil.safePutString(r101, "app_version", r100.getAppVersion());
        JsonUtil.safePutString(r101, "update_version_code", r100.getUpdateVersion());
        return r101;
    }

    public static void monitorEvent(String r100) {
        monitorEvent(r100, null, null, null);
    }

    public static void setBizName(String r100) {
        sBizName = r100;
    }

    public static void init(Context r100, final IMonitorDepend r101) {
        if (sIsInit == true) goto L9;
        if (r100 == null) goto L10;
        if (r101 == null) goto L11;
        SDKMonitorUtils.setConfigUrl(SLARDAR_AID, r101.getConfigUrls());
        SDKMonitorUtils.setDefaultReportUrl(SLARDAR_AID, r101.getReportUrls());
        SDKMonitorUtils.initMonitor(r100, SLARDAR_AID, getHeader(r101), new AnonymousClass1(r101));
        sSDKMonitor = SDKMonitorUtils.getInstance(SLARDAR_AID);
        sIsInit = true;
        return;
    L11:
        return;
    L10:
        return;
    }

    public static void monitorEvent(String r100, JSONObject r101, JSONObject r102) {
        monitorEvent(r100, r101, r102, null);
    }

    public static void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (sSDKMonitor == null) goto L13;
        if (r101 != null) goto L6;
        r101 = new JSONObject();
    L6:
        String r104 = sBizName;
        if (r104 != null) goto L9;
    L11:
        sSDKMonitor.monitorEvent(r100, r101, r102, r103);
        return;
    L9:
        if (r104.isEmpty() == true) goto L11;
        JsonUtil.safePutString(r101, MapMonitorConst.BIZ_NAME, sBizName);
        goto L11
    }
}
