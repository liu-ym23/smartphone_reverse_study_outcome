package com.ss.android.ugc.aweme.search.common.topsection;

import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.discover.model.SearchCommodityDynamicPatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ec-search-api_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class MarketBannerApiKt {
    public static final boolean a(SearchAggregateCommodity r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAboutMarketBanner");
        if (Intrinsics.areEqual(r100.getRefId(), "ecom_search_marketing_banner") == false) goto L11;
        SearchCommodityDynamicPatch r101 = r100.getDynamicPatch();
        if (r101 == null) goto L7;
        String r102 = r101.cardTypeName;
    L9:
        if (Intrinsics.areEqual(r102, "ecom_search_marketing_banner") == false) goto L11;
        return true;
    L7:
        r102 = null;
    L11:
        return false;
    }

    public static final boolean b(SearchAggregateCommodity r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isRealStickyMarketBanner");
        if (a(r100) == false) goto L9;
        SearchCommodityDynamicPatch r101 = r100.getDynamicPatch();
        if (r101 == null) goto L9;
        if (r101.getEnableCeiling() != true) goto L9;
        return true;
    L9:
        return false;
    }
}
