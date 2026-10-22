package com.ss.android.ugc.aweme.search.common.result.request.chunk;

import com.ss.android.ugc.aweme.discover.commodity.api.SearchCommodityAggregateResponse;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/request/chunk/IECSearchChunkListener;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECSearchChunkListener {
    void handleChunkAsync(SearchCommodityAggregateResponse r100);

    void handleChunkException(Throwable r100, SearchResultParam r101);

    void handleChunkFedAfterData(SearchCommodityAggregateResponse r100);

    void handleChunkFilterMix(SearchCommodityAggregateResponse r100);

    void handleChunkFullData(SearchCommodityAggregateResponse r100);

    void handleChunkMonitor(String r100, SearchCommodityAggregateResponse r101, String r102);

    void handleChunkPatchData(SearchCommodityAggregateResponse r100, String r101);

    void handleChunkShowResult(SearchCommodityAggregateResponse r100, SearchResultParam r101);
}
