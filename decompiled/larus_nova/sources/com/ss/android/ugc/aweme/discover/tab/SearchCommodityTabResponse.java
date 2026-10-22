package com.ss.android.ugc.aweme.discover.tab;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.commodity.ECSearchApiResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/tab/SearchCommodityTabResponse;", "Lcom/ss/android/ugc/aweme/discover/commodity/ECSearchApiResult;", "()V", "data", "Lcom/ss/android/ugc/aweme/discover/tab/SearchCommodityTabList;", "getData", "()Lcom/ss/android/ugc/aweme/discover/tab/SearchCommodityTabList;", "setData", "(Lcom/ss/android/ugc/aweme/discover/tab/SearchCommodityTabList;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCommodityTabResponse extends ECSearchApiResult {

    @SerializedName("data")
    private SearchCommodityTabList data;

    public SearchCommodityTabResponse() {
    }

    public final SearchCommodityTabList getData() {
        return this.data;
    }

    public final void setData(SearchCommodityTabList r100) {
        this.data = r100;
    }
}
