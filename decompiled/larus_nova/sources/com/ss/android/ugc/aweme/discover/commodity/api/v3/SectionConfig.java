package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.feed.model.LogPbBean;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/SectionConfig;", "Ljava/io/Serializable;", "()V", "loadMoreConfig", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/LoadMoreConfig;", "getLoadMoreConfig", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/LoadMoreConfig;", "setLoadMoreConfig", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/LoadMoreConfig;)V", "logPb", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "getLogPb", "()Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "setLogPb", "(Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SectionConfig implements Serializable {

    @SerializedName("load_more_config")
    private LoadMoreConfig loadMoreConfig;

    @SerializedName("log_pb")
    private LogPbBean logPb;

    public SectionConfig() {
    }

    public final LoadMoreConfig getLoadMoreConfig() {
        return this.loadMoreConfig;
    }

    public final LogPbBean getLogPb() {
        return this.logPb;
    }

    public final void setLoadMoreConfig(LoadMoreConfig r100) {
        this.loadMoreConfig = r100;
    }

    public final void setLogPb(LogPbBean r100) {
        this.logPb = r100;
    }
}
