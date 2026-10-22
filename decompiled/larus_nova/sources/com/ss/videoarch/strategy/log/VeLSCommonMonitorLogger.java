package com.ss.videoarch.strategy.log;

import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseLogInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class VeLSCommonMonitorLogger {
    private static final String TAG = "VeLSCommonMonitorLogger";

    public VeLSCommonMonitorLogger() {
    }

    public static void onSDKStart() {
        JSONObject r100 = new JSONObject();     // Catch: JSONException -> L5
        r100.put("duration", BaseLogInfo.inst().mSDKStartCostTime);     // Catch: JSONException -> L5
    L7:
        StrategyCenterLogger.reportMonitorLog("sdk_start", null, r100, null);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        r100 = null;
        goto L7
    }

    public static void onSettingsUpdate(int r100, int r101, int r102, String r103, String r104) {
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUploadStrategyMonitorLog == 1) goto L16;
        return;
    L16:
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L8
        r105.put("request_cost", r102);     // Catch: JSONException -> L8
    L18:
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L12
        r106.put("request_id", r104).put("code", r101).put("index", r100).put("settings_info", r103);     // Catch: JSONException -> L12
    L14:
        StrategyCenterLogger.reportMonitorLog("settings_update", r106, r105, null);
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        r106 = null;
    L8:
        e = move-exception;
        e.printStackTrace();
        r105 = null;
        goto L18
    }
}
