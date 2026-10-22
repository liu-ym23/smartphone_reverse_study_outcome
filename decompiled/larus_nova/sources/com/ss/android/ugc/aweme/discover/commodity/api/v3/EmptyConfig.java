package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.SearchClickLinkConfig;
import com.ss.android.ugc.aweme.discover.model.SearchNilInfo;
import com.ss.android.ugc.aweme.discover.model.SearchNilText;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/EmptyConfig;", "Ljava/io/Serializable;", "()V", "feedbackConfig", "Lcom/ss/android/ugc/aweme/discover/model/SearchClickLinkConfig;", "getFeedbackConfig", "()Lcom/ss/android/ugc/aweme/discover/model/SearchClickLinkConfig;", "setFeedbackConfig", "(Lcom/ss/android/ugc/aweme/discover/model/SearchClickLinkConfig;)V", "noResultConfig", "getNoResultConfig", "setNoResultConfig", "searchNilInfo", "Lcom/ss/android/ugc/aweme/discover/model/SearchNilInfo;", "getSearchNilInfo", "()Lcom/ss/android/ugc/aweme/discover/model/SearchNilInfo;", "setSearchNilInfo", "(Lcom/ss/android/ugc/aweme/discover/model/SearchNilInfo;)V", "searchNilText", "Lcom/ss/android/ugc/aweme/discover/model/SearchNilText;", "getSearchNilText", "()Lcom/ss/android/ugc/aweme/discover/model/SearchNilText;", "setSearchNilText", "(Lcom/ss/android/ugc/aweme/discover/model/SearchNilText;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EmptyConfig implements Serializable {

    @SerializedName("feedback_config")
    private SearchClickLinkConfig feedbackConfig;

    @SerializedName("no_result_config")
    private SearchClickLinkConfig noResultConfig;

    @SerializedName("search_nil_info")
    private SearchNilInfo searchNilInfo;

    @SerializedName("search_nil_text")
    private SearchNilText searchNilText;

    public EmptyConfig() {
    }

    public final SearchClickLinkConfig getFeedbackConfig() {
        return this.feedbackConfig;
    }

    public final SearchClickLinkConfig getNoResultConfig() {
        return this.noResultConfig;
    }

    public final SearchNilInfo getSearchNilInfo() {
        return this.searchNilInfo;
    }

    public final SearchNilText getSearchNilText() {
        return this.searchNilText;
    }

    public final void setFeedbackConfig(SearchClickLinkConfig r100) {
        this.feedbackConfig = r100;
    }

    public final void setNoResultConfig(SearchClickLinkConfig r100) {
        this.noResultConfig = r100;
    }

    public final void setSearchNilInfo(SearchNilInfo r100) {
        this.searchNilInfo = r100;
    }

    public final void setSearchNilText(SearchNilText r100) {
        this.searchNilText = r100;
    }
}
