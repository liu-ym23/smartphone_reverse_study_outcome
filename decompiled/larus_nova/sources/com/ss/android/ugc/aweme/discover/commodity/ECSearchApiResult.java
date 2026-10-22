package com.ss.android.ugc.aweme.discover.commodity;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.app.api.RequestInfoSensitive;
import com.ss.android.ugc.aweme.app.api.RequestLog;

/* JADX INFO: loaded from: classes40.dex */
public class ECSearchApiResult extends ECSearchBaseResponse implements RequestInfoSensitive {

    @SerializedName("feed_disable_scroll")
    private Boolean feedDisableScroll;
    String requestId;
    BaseHttpRequestInfo requestInfo;

    public ECSearchApiResult() {
        this.requestId = "";
        this.requestInfo = null;
    }

    @AllowImpl
    public RequestLog getRequestLog() {
        BaseHttpRequestInfo r100 = getRequestInfo();
        if (r100 != null) goto L8;
        return null;
    L8:
        String r101 = r100.requestLog;     // Catch: Throwable -> L7
        return (RequestLog) RequestInfoSensitive.X1.fromJson(r101, RequestLog.class);
    L7:
        return null;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.ECSearchBaseResponse
    public Boolean getDisableFeedScroll() {
        return this.feedDisableScroll;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.ECSearchBaseResponse
    @AllowImpl
    public String getRequestId() {
        return this.requestId;
    }

    @Override // com.ss.android.ugc.aweme.app.api.RequestInfoSensitive
    @AllowImpl
    public BaseHttpRequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.ECSearchBaseResponse
    @AllowImpl
    public void setRequestId(String r100) {
        this.requestId = r100;
    }

    @Override // com.ss.android.ugc.aweme.app.api.RequestInfoSensitive
    @AllowImpl
    public void setRequestInfo(BaseHttpRequestInfo r100) {
        this.requestInfo = r100;
    }
}
