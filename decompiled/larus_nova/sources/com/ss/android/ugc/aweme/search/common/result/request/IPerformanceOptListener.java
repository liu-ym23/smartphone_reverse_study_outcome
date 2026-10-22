package com.ss.android.ugc.aweme.search.common.result.request;

import com.ss.android.ugc.aweme.discover.commodity.api.SearchCommodityAggregateResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/request/IPerformanceOptListener;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPerformanceOptListener {
    void a(SearchCommodityAggregateResponse r100);

    void b(SearchCommodityAggregateResponse r100, String r101);

    void c(SearchCommodityAggregateResponse r100);

    void d(String r100, SearchCommodityAggregateResponse r101, String r102);

    void e(SearchCommodityAggregateResponse r100);

    void f(SearchCommodityAggregateResponse r100);
}
