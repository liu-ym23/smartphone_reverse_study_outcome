package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001f\u001a\u00020 R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;", "Ljava/io/Serializable;", "()V", "isECSearch", "", "()Z", "setECSearch", "(Z)V", "regressionConfig", "getRegressionConfig", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;", "setRegressionConfig", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;)V", "searchHeaderBackgroundConfig", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchHeaderBackgroundConfig;", "getSearchHeaderBackgroundConfig", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchHeaderBackgroundConfig;", "setSearchHeaderBackgroundConfig", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchHeaderBackgroundConfig;)V", "searchResultBackgroundConfig", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchResultBackgroundConfig;", "getSearchResultBackgroundConfig", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchResultBackgroundConfig;", "setSearchResultBackgroundConfig", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchResultBackgroundConfig;)V", "searchResultHeaderBackgroundConfig", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchResultHeaderBackgroundConfig;", "getSearchResultHeaderBackgroundConfig", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchResultHeaderBackgroundConfig;", "setSearchResultHeaderBackgroundConfig", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchResultHeaderBackgroundConfig;)V", BasicTestActionHandler.TEST_ACTION_RESET, "", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SearchBackgroundConfig implements Serializable {
    private boolean isECSearch;
    private SearchBackgroundConfig regressionConfig;

    @SerializedName("search_header_background_config")
    private SearchHeaderBackgroundConfig searchHeaderBackgroundConfig;

    @SerializedName("search_result_background_config")
    private SearchResultBackgroundConfig searchResultBackgroundConfig;

    @SerializedName("search_result_header_background_config")
    private SearchResultHeaderBackgroundConfig searchResultHeaderBackgroundConfig;

    public SearchBackgroundConfig() {
    }

    public final void reset() {
        SearchHeaderBackgroundConfig r100 = this.searchHeaderBackgroundConfig;
        if (r100 == null) goto L6;
        r100.reset();
        return;
    }

    public final SearchBackgroundConfig getRegressionConfig() {
        return this.regressionConfig;
    }

    public final SearchHeaderBackgroundConfig getSearchHeaderBackgroundConfig() {
        return this.searchHeaderBackgroundConfig;
    }

    public final SearchResultBackgroundConfig getSearchResultBackgroundConfig() {
        return this.searchResultBackgroundConfig;
    }

    public final SearchResultHeaderBackgroundConfig getSearchResultHeaderBackgroundConfig() {
        return this.searchResultHeaderBackgroundConfig;
    }

    public final boolean isECSearch() {
        return this.isECSearch;
    }

    public final void setECSearch(boolean r100) {
        this.isECSearch = r100;
    }

    public final void setRegressionConfig(SearchBackgroundConfig r100) {
        this.regressionConfig = r100;
    }

    public final void setSearchHeaderBackgroundConfig(SearchHeaderBackgroundConfig r100) {
        this.searchHeaderBackgroundConfig = r100;
    }

    public final void setSearchResultBackgroundConfig(SearchResultBackgroundConfig r100) {
        this.searchResultBackgroundConfig = r100;
    }

    public final void setSearchResultHeaderBackgroundConfig(SearchResultHeaderBackgroundConfig r100) {
        this.searchResultHeaderBackgroundConfig = r100;
    }
}
