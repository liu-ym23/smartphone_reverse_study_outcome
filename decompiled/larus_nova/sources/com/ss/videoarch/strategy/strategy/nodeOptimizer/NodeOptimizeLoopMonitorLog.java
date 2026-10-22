package com.ss.videoarch.strategy.strategy.nodeOptimizer;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class NodeOptimizeLoopMonitorLog extends BaseStrategyMonitor {
    public int mCurNeedResolveTotalDomainCnt;
    public String mCurRequestId;
    public int mCurResolvedDomainCnt;
    public long mCurTotalDnsCost;
    public Set<String> mDoLocalDnsHostSet;
    public int mEnableForceRefresh;
    public int mEnableHttpDNS;
    public int mEnableLocalDnsTimeout;
    public int mEnableTopn;
    public int mHttpDNSType;
    public int mIndex;
    public int mIsTimeout;
    public List<String> mTimeOutDomainList;

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor
    public JSONObject createCategory() {
        return new JSONObject().put("enable_force_refresh", this.mEnableForceRefresh).put("enable_localDNS_timeout", this.mEnableLocalDnsTimeout).put("enable_httpdns", this.mEnableHttpDNS).put("enable_topn", this.mEnableTopn).put("httpdns_type", this.mHttpDNSType).put("index", this.mIndex).put("request_id", this.mCurRequestId).put(LocationMonitorConst.IS_TIMEOUT, this.mIsTimeout).put("localdns_host", this.mDoLocalDnsHostSet);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor
    public JSONObject createMetric() {
        return new JSONObject().put("cur_total_dns_cost", this.mCurTotalDnsCost).put("cur_need_dns_total_domain_cnt", this.mCurNeedResolveTotalDomainCnt).put("cur_domain_cnt", this.mCurResolvedDomainCnt);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public NodeOptimizeLoopMonitorLog() {
        this.mCurTotalDnsCost = -1;
        this.mCurNeedResolveTotalDomainCnt = -1;
        this.mCurResolvedDomainCnt = -1;
        this.mEnableForceRefresh = -1;
        this.mEnableLocalDnsTimeout = -1;
        this.mEnableHttpDNS = -1;
        this.mHttpDNSType = -1;
        this.mIndex = -1;
        this.mIsTimeout = -1;
        this.mEnableTopn = -1;
        this.mCurRequestId = "none";
        this.mTimeOutDomainList = new ArrayList();
        this.mDoLocalDnsHostSet = new HashSet();
        this.mServiceName = "live_stream_strategy_node_optimize";
    }
}
