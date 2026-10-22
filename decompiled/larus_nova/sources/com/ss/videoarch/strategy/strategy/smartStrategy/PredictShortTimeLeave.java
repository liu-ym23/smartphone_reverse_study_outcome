package com.ss.videoarch.strategy.strategy.smartStrategy;

import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import com.ss.videoarch.strategy.dataCenter.strategyData.StrategySQLMonitorLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class PredictShortTimeLeave extends BaseSmartStrategy {
    public static final int N = 10;
    private static final String TAG = "PredictShortTimeLeave";
    private static volatile PredictShortTimeLeave sInstance;
    public StrategySQLMonitorLog mPredictLeaveMonitor;

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject r100) {
        return null;
    }

    public static PredictShortTimeLeave inst() {
        if (sInstance != null) goto L15;
        monitor-enter(PredictShortTimeLeave.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new PredictShortTimeLeave();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PredictShortTimeLeave.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private PredictShortTimeLeave() {
        this.mStrategyName = "live_stream_strategy_short_time_leave_predict";
        this.mProjectKey = "2";
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L6;
        r100.mStrategyName = "live_stream_strategy_short_time_leave_predict";
        r100.mDefaultInputFeatureList = new JSONArray().put("USER-FeaturesBundle").put("PLAY-HistoryDuration");
        return;
    }

    public void saveData(long r100) {
        if (getEnableStrategy(this.mStrategyName, 0) == 1) goto L6;
        return;
    L6:
        if (r100 == (-1)) goto L15;
        JSONObject r101 = new JSONObject().put("result", r100);     // Catch: JSONException -> L9
    L11:
        uploadGroundTruth(r101);
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L11
    }
}
