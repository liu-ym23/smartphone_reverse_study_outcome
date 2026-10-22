package com.ss.android.ugc.aweme.search.common.saas.autoplay;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/TradeSearchGridCommodityHittingArea;", "Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/SearchGridCommodityHittingArea;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class TradeSearchGridCommodityHittingArea extends SearchGridCommodityHittingArea {
    public TradeSearchGridCommodityHittingArea(FragmentActivity r100, RecyclerView r101, TradeSearchScrollStateManager r102) {
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "manager");
        super(r100, r101);
    }
}
