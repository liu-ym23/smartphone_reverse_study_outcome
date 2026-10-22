package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.bytedance.android.chunkstreamprediction.network.c;
import com.bytedance.android.chunkstreamprediction.network.d;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.app.api.RequestInfoSensitive;
import com.ss.android.ugc.aweme.app.api.RequestLog;
import com.ss.android.ugc.aweme.discover.commodity.api.ChunkInfo;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.ec.search.common.CommerceBaseResponse;
import com.ss.android.ugc.aweme.feed.model.LogPbBean;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00032\u00020\u00042\u00020\u0003B\u0007¢\u0006\u0004\b0\u00101J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0017J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0017J\u0016\u0010\u0010\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eH\u0017J\u000e\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eH\u0017J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0017J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010.R\u001c\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010/¨\u00062"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ECSearchCommodityResponse;", "Lcom/ss/android/ugc/aweme/ec/search/common/CommerceBaseResponse;", "Lcom/bytedance/android/chunkstreamprediction/network/d;", "", "Lcom/ss/android/ugc/aweme/app/api/RequestInfoSensitive;", "Lcom/bytedance/android/chunkstreamprediction/network/c;", "o", "", "setChunkReadingReport", "getChunkReadingReport", "", "getRequestId", "requestId", "setRequestId", "Lcom/bytedance/frameworks/baselib/network/http/BaseHttpRequestInfo;", "requestInfo", "setRequestInfo", "getRequestInfo", "Lcom/ss/android/ugc/aweme/app/api/RequestLog;", "getRequestLog", "", "getListCount", "", "hasMore", "getChunkType", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/PageData;", "pageData", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/PageData;", "getPageData", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/PageData;", "setPageData", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/PageData;)V", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/BizData;", RuleConditionBean.BIZ_DATA_KEY, "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/BizData;", "getBizData", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/BizData;", "setBizData", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/BizData;)V", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "logPb", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "getLogPb", "()Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "setLogPb", "(Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;)V", "Ljava/lang/String;", "Lcom/bytedance/frameworks/baselib/network/http/BaseHttpRequestInfo;", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchCommodityResponse extends CommerceBaseResponse implements d, RequestInfoSensitive {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient c f450035a;

    @SerializedName("biz_data")
    private BizData bizData;

    @SerializedName("log_pb")
    private LogPbBean logPb;

    @SerializedName("page_data")
    private PageData pageData;
    private String requestId;
    private BaseHttpRequestInfo<?> requestInfo;

    public String getChunkType() {
        BizData r100 = this.bizData;
        if (r100 == null) goto L10;
        ExtraInfo r101 = r100.getExtraInfo();
        if (r101 == null) goto L10;
        ChunkInfo r102 = r101.getChunkInfo();
        if (r102 == null) goto L10;
        String r103 = r102.getChunkName();
        if (r103 == null) goto L10;
        return r103;
    L10:
        return "";
    }

    public int getListCount() {
        PageData r100 = this.pageData;
        int r101 = 0;
        if (r100 == null) goto L19;
        FeedLayer r102 = r100.getFeedLayer();
        if (r102 == null) goto L19;
        List<FeedSection> r103 = r102.getFeedSections();
        if (r103 == null) goto L19;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L19;
        List<SearchAggregateCommodity> r105 = ((FeedSection) r104.next()).getItems();
        if (r105 == null) goto L10;
        Iterator<T> r106 = r105.iterator();
    L15:
        if (r106.hasNext() == false) goto L10;
        if (((SearchAggregateCommodity) r106.next()).getIgnoreRank() == true) goto L15;
        r101 = r101 + 1;
    L19:
        return r101;
    }

    public boolean hasMore() {
        BizData r100 = this.bizData;
        if (r100 == null) goto L7;
        LoadMoreConfig r101 = r100.getLoadMoreConfig();
        if (r101 == null) goto L7;
        return r101.getHasMore();
    L7:
        return false;
    }

    public ECSearchCommodityResponse() {
        this.requestId = "";
    }

    @AllowImpl
    public RequestLog getRequestLog() {
        BaseHttpRequestInfo<?> r100 = getRequestInfo();
        if (r100 == null) goto L5;
        String r101 = r100.requestLog;
    L6:
        if (r101 != null) goto L11;
        return null;
    L11:
        return (RequestLog) RequestInfoSensitive.X1.fromJson(r100.requestLog, RequestLog.class);
    L10:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    public final BizData getBizData() {
        return this.bizData;
    }

    public c getChunkReadingReport() {
        return this.f450035a;
    }

    public final LogPbBean getLogPb() {
        return this.logPb;
    }

    public final PageData getPageData() {
        return this.pageData;
    }

    @AllowImpl
    public String getRequestId() {
        return this.requestId;
    }

    @Override // com.ss.android.ugc.aweme.app.api.RequestInfoSensitive
    @AllowImpl
    public BaseHttpRequestInfo<?> getRequestInfo() {
        return this.requestInfo;
    }

    public final void setBizData(BizData r100) {
        this.bizData = r100;
    }

    @Override // com.bytedance.android.chunkstreamprediction.network.d
    public void setChunkReadingReport(c r100) {
        Intrinsics.checkNotNullParameter(r100, "o");
        r100.getClass();
        monitor-enter(r100);
        List<c.a> r101 = r100.f42525a;     // Catch: Throwable -> L8
        monitor-exit(r100);
        this.f450035a = new c(r101, r100.f42526b);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void setLogPb(LogPbBean r100) {
        this.logPb = r100;
    }

    public final void setPageData(PageData r100) {
        this.pageData = r100;
    }

    @AllowImpl
    public void setRequestId(String r100) {
        Intrinsics.checkNotNull(r100);
        this.requestId = r100;
    }

    @Override // com.ss.android.ugc.aweme.app.api.RequestInfoSensitive
    @AllowImpl
    public void setRequestInfo(BaseHttpRequestInfo<?> r100) {
        this.requestInfo = r100;
    }
}
