package com.ss.android.ugc.aweme.search.vision.result.v1.section;

import com.ss.android.ugc.aweme.discover.commodity.api.v3.ECSearchCommodityResponse;
import com.ss.android.ugc.aweme.discover.commodity.api.v3.ResultSectionConfig;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import com.ss.android.ugc.aweme.search.vision.model.repo.OnRequestListener;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/v1/section/ISectionOperation;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISectionOperation {
    String getBtm();

    String getDetection();

    PhotoEnterModel getEnterModel();

    void insertItems(List<SearchAggregateCommodity> r100, int r101);

    void insertItems(List<SearchAggregateCommodity> r100, SearchAggregateCommodity r101);

    void removeItem(SearchAggregateCommodity r100);

    void sectionLoadMore(ResultSectionConfig r100, Integer r101, Integer r102, OnRequestListener<ECSearchCommodityResponse> r103, Map<String, ? extends Object> r104, String r105);
}
