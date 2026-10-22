package com.ss.android.ugc.aweme.search.ecommerce.api.srp;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/SrpProtocolViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "searchPageHostStateProvider", "Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/SearchPageHostStateProvider;", "getSearchPageHostStateProvider", "()Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/SearchPageHostStateProvider;", "setSearchPageHostStateProvider", "(Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/SearchPageHostStateProvider;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SrpProtocolViewModel extends ViewModel {
    private SearchPageHostStateProvider searchPageHostStateProvider;

    public SrpProtocolViewModel() {
    }

    public final SearchPageHostStateProvider getSearchPageHostStateProvider() {
        return this.searchPageHostStateProvider;
    }

    public final void setSearchPageHostStateProvider(SearchPageHostStateProvider r100) {
        this.searchPageHostStateProvider = r100;
    }
}
