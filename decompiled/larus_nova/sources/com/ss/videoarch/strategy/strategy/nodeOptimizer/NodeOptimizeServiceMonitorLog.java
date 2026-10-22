package com.ss.videoarch.strategy.strategy.nodeOptimizer;

import com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class NodeOptimizeServiceMonitorLog extends BaseStrategyMonitor {
    public int mCallIndex;
    public int mCallerID;
    public List<String> mForceLocalDnsList;
    public int mHasGetDomainInfos;
    public int mHasLocalDnsResult;
    public int mHasResetDns;
    public String mHitType;
    public int mHostContained;
    public int mIsHit;
    public int mIsRetryFailStopSchedule;
    public String mLookUpDomain;
    public String mReturnIP;
    public long mSDKStartCost;
    public String mStreamSessionVVId;

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor
    public JSONObject createCategory() {
        return new JSONObject().put("is_hit", this.mIsHit).put("hit_type", this.mHitType).put("index", this.mCallIndex).put("caller", this.mCallerID).put("domain", this.mLookUpDomain).put("return_ip", this.mReturnIP).put("has_domain_list", this.mHasGetDomainInfos).put("host_in_domain_list", this.mHostContained).put("host_has_local_dns_result", this.mHasLocalDnsResult).put("has_reset", this.mHasResetDns).put("retry_failed", this.mIsRetryFailStopSchedule).put("stream_session_vv_id", this.mStreamSessionVVId).put("force_dns_host", this.mForceLocalDnsList);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor
    public JSONObject createMetric() {
        return new JSONObject().put("sdk_start_cost", this.mSDKStartCost);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public NodeOptimizeServiceMonitorLog() {
        this.mIsHit = -1;
        this.mCallIndex = -1;
        this.mCallerID = -1;
        this.mSDKStartCost = -1;
        this.mHasGetDomainInfos = -1;
        this.mHostContained = -1;
        this.mHasLocalDnsResult = -1;
        this.mHasResetDns = -1;
        this.mIsRetryFailStopSchedule = -1;
        this.mForceLocalDnsList = new ArrayList();
        this.mHitType = "none";
        this.mLookUpDomain = "none";
        this.mReturnIP = "none";
        this.mStreamSessionVVId = "none";
        this.mServiceName = "live_stream_strategy_node_optimize_service_monitor";
    }
}
