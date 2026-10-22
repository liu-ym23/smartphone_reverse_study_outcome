package com.ss.videoarch.strategy.strategy.smartStrategy;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import com.ss.videoarch.strategy.dataCenter.strategyData.StrategySQLMonitorLog;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class NetConnectionTypeStrategy extends BaseSmartStrategy {
    private static final String TAG = "NetConnectionType";
    private static volatile NetConnectionTypeStrategy sInstance;
    public StrategySQLMonitorLog mNetConnectionTypeMonitor;
    private JSONObject mNetEffectiveConnectionTypeStrategy;

    public static NetConnectionTypeStrategy inst() {
        if (sInstance != null) goto L15;
        monitor-enter(NetConnectionTypeStrategy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NetConnectionTypeStrategy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetConnectionTypeStrategy.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private NetConnectionTypeStrategy() {
        this.mNetEffectiveConnectionTypeStrategy = null;
        this.mStrategyName = "live_stream_strategy_net_connect_type";
        this.mProjectKey = "2";
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L6;
        r100.mStrategyName = "live_stream_strategy_net_connect_type";
        r100.mDefaultInputFeatureList = new JSONArray().put("NETWORK-NetworkLevel");
        return;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject r100) {
        JSONObject r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r102 = this.mStrategyConfigInfo.mInputSettingsParam;
        if (r102 == null) goto L8;
        this.mNetEffectiveConnectionTypeStrategy = r102.optJSONObject("netEffectiveConnectionTypeStrategy");
    L8:
        Objects.toString(this.mNetEffectiveConnectionTypeStrategy);
        int r103 = r100.optInt("NETWORK-NetworkLevel");
        if (r103 != 1) goto L11;
        r103 = 7;
    L11:
        JSONObject r104 = this.mNetEffectiveConnectionTypeStrategy;
        if (r104 != null) goto L14;
    L19:
        Objects.toString(r101);
        return r101;
    L14:
        if (r104.has(String.valueOf(r103)) == false) goto L19;
        r101 = JSONObjectProtectorUtils.getJSONObject(this.mNetEffectiveConnectionTypeStrategy, String.valueOf(r103));     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }
}
