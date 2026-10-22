package com.ss.videoarch.strategy.dataCenter.strategyData;

import com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class StrategySQLMonitorLog extends BaseStrategyMonitor {
    private static volatile StrategySQLMonitorLog sInstance;
    public String mExtraInfo;
    public int mIndex;
    public int mIsCache;
    public long mIsSuccess;
    public long mOperateCost;
    public String mOperateInfo;
    public String mOperateName;
    public String mTableName;

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor
    public JSONObject createCategory() {
        return new JSONObject().put("table_name", this.mTableName).put("operate", this.mOperateName).put("operate_info", this.mOperateInfo).put("index", this.mIndex).put("is_success", this.mIsSuccess).put("extra_info", this.mExtraInfo);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor
    public JSONObject createMetric() {
        return new JSONObject().put("operate_cost", this.mOperateCost);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public StrategySQLMonitorLog() {
        this.mTableName = "none";
        this.mOperateName = "none";
        this.mOperateInfo = "none";
        this.mExtraInfo = "none";
        this.mIndex = 0;
        this.mIsCache = 0;
        this.mOperateCost = -1;
        this.mIsSuccess = -1;
        this.mServiceName = "live_stream_strategy_sqlite_data_monitor";
    }

    public void updateMonitorLogInfo(String r100, String r101, String r102, long r103, long r104, String r105) {
        this.mTableName = r100;
        this.mOperateName = r101;
        this.mOperateInfo = r102;
        this.mIndex++;
        this.mIsSuccess = r103;
        this.mOperateCost = System.currentTimeMillis() - r104;
        this.mExtraInfo = r105;
    }
}
