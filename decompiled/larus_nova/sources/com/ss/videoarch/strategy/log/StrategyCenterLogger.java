package com.ss.videoarch.strategy.log;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseLogInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class StrategyCenterLogger {
    public static final String SLARDAR_FETCH_CONFIG_API_PATH = "/monitor/appmonitor/v2/settings";
    public static final String SLARDAR_REPORT_LOG_API_PATH = "/monitor/collect/";
    public static final String TAG = "StrategyCenterLogger";
    private static boolean mInitSlardar;

    public StrategyCenterLogger() {
    }

    public static void reportFeatureData(JSONObject r100) {
        AppLogNewUtils.onEventV3("live_stream_strategy_feature_data", r100);
    }

    public static void init(Context r100, JSONObject r110) {
        String r101 = (String) LSSettings.inst().getAppInfoForKey("live_stream_strategy_slardar_host", "");
        if (r110 == null) goto L23;
        if (r100 == null) goto L23;
        if (TextUtils.isEmpty(r101) == true) goto L23;
        final HashMap r102 = new HashMap();
        if (r110.has("oversea") == true) goto L11;
    L25:
        BaseLogInfo.inst();     // Catch: JSONException -> L15
        r110.put("sdk_version", "1.10.258.3");     // Catch: JSONException -> L15
    L18:
        if (r110.has("app_session_id") == false) goto L20;
        final String r103 = r110.optString("app_session_id");
    L21:
        List r104 = Arrays.asList(new String[]{"https://" + r101 + SLARDAR_FETCH_CONFIG_API_PATH});
        List r105 = Arrays.asList(new String[]{"https://" + r101 + SLARDAR_REPORT_LOG_API_PATH});
        BaseLogInfo.inst();
        SDKMonitorUtils.setConfigUrl(BaseLogInfo.REAL_SDK_APP_ID, r104);
        BaseLogInfo.inst();
        SDKMonitorUtils.setDefaultReportUrl(BaseLogInfo.REAL_SDK_APP_ID, r105);
        BaseLogInfo.inst();
        BaseLogInfo.inst();
        Objects.toString(r104);
        Objects.toString(r105);
        Context r106 = r100.getApplicationContext();
        BaseLogInfo.inst();
        SDKMonitorUtils.initMonitor(r106, BaseLogInfo.REAL_SDK_APP_ID, r110, new AnonymousClass1(r103, r102));
        mInitSlardar = true;
        return;
    L20:
        r103 = null;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L11:
        if (r110.optInt("oversea") != 1) goto L25;
        r102.put("oversea", "1");
    L23:
        Objects.toString(r110);
        Objects.toString(r100);
    }

    public static void reportMonitorLog(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (mInitSlardar == false) goto L7;
        BaseLogInfo.inst();
        Objects.toString(r101);
        Objects.toString(r102);
        BaseLogInfo.inst();
        SDKMonitorUtils.getInstance(BaseLogInfo.REAL_SDK_APP_ID).monitorEvent(r100, r101, r102, r103);
        return;
    }
}
