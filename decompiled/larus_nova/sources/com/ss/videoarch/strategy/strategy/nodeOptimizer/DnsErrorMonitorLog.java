package com.ss.videoarch.strategy.strategy.nodeOptimizer;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class DnsErrorMonitorLog extends BaseStrategyMonitor {
    public int mCurIndex;
    public String mCurRequestId;
    public int mEnableForceRefresh;
    public int mEnableHttpDNS;
    public int mEnableLocalDnsTimeout;
    public String mErrorDomain;
    public String mErrorInfo;
    public int mHttpDNSType;

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor
    public JSONObject createCategory() {
        return new JSONObject().put("enable_force_refresh", this.mEnableForceRefresh).put("enable_localDNS_timeout", this.mEnableLocalDnsTimeout).put("enable_httpdns", this.mEnableHttpDNS).put("httpdns_type", this.mHttpDNSType).put(BdpAppEventConstant.PARAMS_ERROR_DOMAIN, this.mErrorDomain).put("index", this.mCurIndex).put(MapMonitorConst.ERROR_INFO, this.mErrorInfo).put("request_id", this.mCurRequestId);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public DnsErrorMonitorLog() {
        this.mEnableForceRefresh = -1;
        this.mEnableLocalDnsTimeout = -1;
        this.mEnableHttpDNS = -1;
        this.mHttpDNSType = -1;
        this.mErrorDomain = "none";
        this.mCurRequestId = "none";
        this.mErrorInfo = "none";
        this.mServiceName = "live_stream_strategy_dns_error_monitor";
    }
}
