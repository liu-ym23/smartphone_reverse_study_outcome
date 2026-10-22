package com.ss.android.ugc.aweme.search.common.bean;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.CommerceBaseResponse;
import com.ss.android.ugc.aweme.ec.search.common.JsonNullToJsonObjectAdapter;
import com.ss.android.ugc.aweme.ec.search.common.LogPbBean;
import com.ss.android.ugc.aweme.ec.search.common.RecommendWordMob;
import com.ss.android.ugc.aweme.ec.search.common.RequestInfoSensitive;
import com.ss.android.ugc.aweme.ec.search.common.RequestLog;
import com.ss.android.ugc.aweme.search.common.result.sug.ECSearchSugPresenter;
import com.ss.android.ugc.aweme.search.common.result.sug.model.SearchSugEntity;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class ECSearchSugResponse extends CommerceBaseResponse implements RequestInfoSensitive {
    public transient String keyword;

    @SerializedName("log_pb")
    private LogPbBean logPb;

    @SerializedName("words_query_record")
    private RecommendWordMob recommendWordMob;

    @SerializedName("rid")
    private String requestId;
    BaseHttpRequestInfo requestInfo;
    public transient ECSearchSugPresenter.RequestTaskWrapper requestTaskWrapper;

    @SerializedName("time_cost")
    @JsonAdapter(JsonNullToJsonObjectAdapter.class)
    public JsonObject serverTimeCost;

    @SerializedName("sug_list")
    private List<SearchSugEntity> sugList;

    @SerializedName("sug_virtual_list")
    private List<SearchSugEntity> sugVirtualList;

    public ECSearchSugResponse() {
        this.requestId = "";
        this.requestInfo = null;
    }

    @Override // com.ss.android.ugc.aweme.ec.search.common.RequestInfoSensitive
    public RequestLog getRequestLog() {
        BaseHttpRequestInfo r100 = getRequestInfo();
        if (r100 != null) goto L6;
        return null;
    L6:
        String r101 = r100.requestLog;
        return (RequestLog) GsonProtectorUtils.fromJson(RequestInfoSensitive.Y1, r101, RequestLog.class);
    }

    public LogPbBean getLogPb() {
        return this.logPb;
    }

    public RecommendWordMob getRecommendWordMob() {
        return this.recommendWordMob;
    }

    public String getRequestId() {
        return this.requestId;
    }

    @Override // com.ss.android.ugc.aweme.ec.search.common.RequestInfoSensitive
    public BaseHttpRequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public List<SearchSugEntity> getSugList() {
        return this.sugList;
    }

    public void setRequestInfo(BaseHttpRequestInfo r100) {
        this.requestInfo = r100;
    }
}
