package com.ss.videoarch.strategy.log.strategyMonitor;

import com.ss.videoarch.strategy.NativeObject;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.log.StrategyCenterLogger;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class BaseStrategyMonitor extends NativeObject {
    public static String MONITOR_QUERY_OPERATE = "Query";
    public static String MONITOR_UPDATE_OPERATE = "Update";
    private static final String TAG = "BaseStrategyMonitor";
    private JSONObject mCategoryLog;
    private JSONObject mLogExtrLog;
    private JSONObject mMetricLog;
    protected String mServiceName;

    public JSONObject createCategory() {
        return null;
    }

    public JSONObject createLogExtrLog() {
        return null;
    }

    public JSONObject createMetric() {
        return null;
    }

    public int strategyCode() {
        return -1;
    }

    public BaseStrategyMonitor() {
        this.mServiceName = null;
        this.mCategoryLog = null;
        this.mMetricLog = null;
        this.mLogExtrLog = null;
    }

    public void uploadMonitorLog() {
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUploadStrategyMonitorLog == 1) goto L5;
        return;
    L5:
        this.mCategoryLog = createCategory();
        this.mMetricLog = createMetric();
        Objects.toString(this.mCategoryLog);
        Objects.toString(this.mMetricLog);
        Objects.toString(this.mLogExtrLog);
        if (this.mServiceName != null) goto L8;
        return;
    L8:
        if (LSSettings.inst().mEnableReduceReport == 1) goto L12;
        StrategyCenterLogger.reportMonitorLog(this.mServiceName, this.mCategoryLog, this.mMetricLog, this.mLogExtrLog);
        return;
    }
}
