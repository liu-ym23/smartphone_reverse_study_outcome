package com.ss.android.ugc.aweme.search.ecommerce.api.srp;

import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.search.common.saas.result.ECSearchResultListSaaSPresenter$initData$1;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/SearchPageHostStateProvider;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface SearchPageHostStateProvider {
    void R7();

    boolean a();

    void b(Fragment r100, ECSearchResultListSaaSPresenter$initData$1 r101);

    void c();

    void d(SearchResultParam r100);

    void updateSearchParams(JSONObject r100);
}
