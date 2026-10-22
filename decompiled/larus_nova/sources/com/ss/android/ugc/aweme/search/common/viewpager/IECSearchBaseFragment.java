package com.ss.android.ugc.aweme.search.common.viewpager;

import com.ss.android.ugc.aweme.discover.commodity.provider.IECSearchResultDataProvider;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.ecommerce.api.srp.SrpBizDiffConfig;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/viewpager/IECSearchBaseFragment;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECSearchBaseFragment {
    SrpBizDiffConfig D00();

    IECSearchResultDataProvider IN();

    String PO();

    void R7();

    void TT(int r100);

    void cR(ECSearchParam r100);

    String getTabType();

    void l7(ECSearchParam r100);

    void updateSearchParams(JSONObject r100);
}
