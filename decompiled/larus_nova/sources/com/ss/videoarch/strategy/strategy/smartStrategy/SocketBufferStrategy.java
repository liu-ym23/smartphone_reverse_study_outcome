package com.ss.videoarch.strategy.strategy.smartStrategy;

import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import com.ss.videoarch.strategy.dataCenter.strategyData.StrategySQLMonitorLog;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class SocketBufferStrategy extends BaseSmartStrategy {
    private static final String TAG = "SocketBufferStrategy";
    private static volatile SocketBufferStrategy sInstance;
    public StrategySQLMonitorLog mSocketBufferStrategyMonitor;

    public static SocketBufferStrategy inst() {
        if (sInstance != null) goto L15;
        monitor-enter(SocketBufferStrategy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SocketBufferStrategy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SocketBufferStrategy.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private SocketBufferStrategy() {
        this.mStrategyName = "live_stream_strategy_socket_buffer";
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L5;
        r100.mStrategyName = "live_stream_strategy_socket_buffer";
    L5:
        this.mProjectKey = "2";
        this.mSocketBufferStrategyMonitor = new StrategySQLMonitorLog();
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject r100) {
        Objects.toString(r100);
        if (r100 == null) goto L13;
        StrategyConfigInfo r101 = this.mStrategyConfigInfo;
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.mInputSettingsParam == null) goto L17;
        JSONObject r102 = new JSONObject();
        int r103 = r100.optInt("NETWORK-NetworkLevel", 0);
        if (this.mStrategyConfigInfo.mInputSettingsParam.has(String.valueOf(r103)) == true) goto L12;
        return r102;
    L12:
        return this.mStrategyConfigInfo.mInputSettingsParam.optJSONObject(String.valueOf(r103));
    L17:
        return null;
    L13:
        return null;
    }
}
