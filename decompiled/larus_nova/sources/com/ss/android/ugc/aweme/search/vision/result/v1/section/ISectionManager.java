package com.ss.android.ugc.aweme.search.vision.result.v1.section;

import com.ss.android.ugc.aweme.discover.commodity.api.v3.ECSearchCommodityResponse;
import com.ss.android.ugc.aweme.discover.commodity.api.v3.ResultSectionConfig;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/v1/section/ISectionManager;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISectionManager {
    void a();

    int b();

    boolean c();

    boolean d(String r100);

    void destroy();

    void e(ISectionOperation r100, ECSearchCommodityResponse r101, List<ResultSectionConfig> r102);

    List<SearchAggregateCommodity> f();

    List<SearchAggregateCommodity> g();
}
