package com.bytedance.bdlocation.monitor;

import android.content.Context;
import android.util.Log;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.lynx.tasm.LynxError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LocationMonitorUtil {
    private static final String CONFIG_URL = "https://mon.snssdk.com/monitor/appmonitor/v2/settings";
    private static final String DEFAULT_REPORT_URL = "https://mon.snssdk.com/monitor/collect/";
    private static boolean sIsInit;
    private static volatile SDKMonitor sSDKMonitor;

    public LocationMonitorUtil() {
    }

    private static JSONObject getHeader() {
        JSONObject r100 = new JSONObject();
        JsonUtil.safePutString(r100, "device_id", BDLocationConfig.getDeviceId());
        JsonUtil.safePutString(r100, "host_aid", BDLocationConfig.getAppId());
        JsonUtil.safePutString(r100, "sdk_version", BDLocationConfig.getSdkVersion());
        JsonUtil.safePutString(r100, "channel", BDLocationConfig.getChannel());
        JsonUtil.safePutString(r100, "app_version", BDLocationConfig.getAppVersion());
        JsonUtil.safePutString(r100, "update_version_code", BDLocationConfig.getUpdateVersionCode());
        JsonUtil.safePutString(r100, "package_name", BDLocationConfig.getPackageName());
        return r100;
    }

    public static void init(Context r100) {
        if (sIsInit == true) goto L8;
        if (r100 == null) goto L9;
        SDKMonitorUtils.setConfigUrl(BDLocationConfig.getSlardarAid(), Arrays.asList(new String[]{CONFIG_URL}));
        SDKMonitorUtils.setDefaultReportUrl(BDLocationConfig.getSlardarAid(), Arrays.asList(new String[]{"https://mon.snssdk.com/monitor/collect/"}));
        SDKMonitorUtils.initMonitor(r100, BDLocationConfig.getSlardarAid(), getHeader(), new AnonymousClass1());
        sSDKMonitor = SDKMonitorUtils.getInstance(BDLocationConfig.getSlardarAid());
        sIsInit = true;
        return;
    L9:
        return;
    }

    public static void monitorEvent(String r100) {
        monitorEvent(r100, null, null, null);
    }

    public static void monitorEvent(String r100, JSONObject r101, JSONObject r102) {
        monitorEvent(r100, r101, r102, null);
    }

    public static void monitorException(Throwable r100, String r101, Map<String, String> r102) {
        if (sSDKMonitor != null) goto L12;
        return;
    L12:
        new JSONObject().put("errMsg", r101);     // Catch: Throwable -> L11
        if (r102 != null) goto L8;
        r102 = new HashMap();     // Catch: Throwable -> L11
    L8:
        if (r100 == null) goto L14;
        EnsureManager.ensureNotReachHere(r100, r101, r102);     // Catch: Throwable -> L11
        return;
    L14:
        return;
    }

    public static void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (sSDKMonitor == null) goto L6;
        sSDKMonitor.monitorEvent(r100, r101, r102, r103);
        return;
    }

    public static void monitorEventWithException(String r100, JSONObject r101, JSONObject r102, JSONObject r103, Throwable r104) {
        if (r101 == null) goto L9;
        if (r104 == null) goto L10;
        r101.put(LynxError.LYNX_THROWABLE, Log.getStackTraceString(r104));     // Catch: Throwable -> L6
        monitorEvent(r100, r101, r102, r103);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L10:
        return;
    }
}
