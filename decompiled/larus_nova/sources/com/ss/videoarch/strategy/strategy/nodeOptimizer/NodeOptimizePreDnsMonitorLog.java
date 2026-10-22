package com.ss.videoarch.strategy.strategy.nodeOptimizer;

import com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class NodeOptimizePreDnsMonitorLog extends BaseStrategyMonitor {
    public int mEnableTopN;
    public long mPreDnsCost;
    public Set<String> mPreDnsHostSet;

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor
    public JSONObject createCategory() {
        return new JSONObject().put("enable_topn", this.mEnableTopN).put("pre_dns_host", this.mPreDnsHostSet);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor
    public JSONObject createMetric() {
        return new JSONObject().put("pre_dns_cost", this.mPreDnsCost);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public NodeOptimizePreDnsMonitorLog() {
        this.mEnableTopN = -1;
        this.mPreDnsCost = 0;
        this.mPreDnsHostSet = new HashSet();
        this.mServiceName = "live_stream_strategy_node_optimize";
    }
}
