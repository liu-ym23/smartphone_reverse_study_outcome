package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.viewholder.CommodityGuideSearchV2FooterViewHolder;
import com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.viewholder.CommodityGuideSearchV2ViewHolder;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.saas.ECSearchSaaSDepsHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/adapter/CommodityGuideSearchV2RycAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommodityGuideSearchV2RycAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public CommodityGuideSearchV2RycAdapter() {
        throw null;
    }

    public final Context getContext() {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof CommodityGuideSearchV2ViewHolder) == true) goto L5;
        return;
    L5:
        Logger.a("GuideSearchOptMob", "onViewAttachedToWindow invoke");
        ((CommodityGuideSearchV2ViewHolder) r100).getClass();
        Intrinsics.throwUninitializedPropertyAccessException("gsWord");
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Logger.a("GuideSearchOpt", "CommodityGuideSearchV2RycAdapter onBindViewHolder: gsWordList == null");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 2) goto L9;
        ECSearchSaaSDepsHelper.f451981a.getClass();
        View r102 = ECSearchSaaSDepsHelper.a(r100, R.layout.search_commodity_gs_item_v2);
        Logger.a("GuideSearchOpt", "create CommodityGuideSearchV2ViewHolder: itemView = " + r102);
        if (r102 != null) goto L8;
        r102 = new View(null);
    L8:
        return new CommodityGuideSearchV2ViewHolder(r102, 0);
    L9:
        ECSearchSaaSDepsHelper.f451981a.getClass();
        View r103 = ECSearchSaaSDepsHelper.a(r100, R.layout.search_guide_search_footer_view);
        Logger.a("GuideSearchOpt", "create CommodityGuideSearchV2FooterViewHolder: itemView = " + r103);
        if (r103 != null) goto L13;
        r103 = new View(null);
    L13:
        return new CommodityGuideSearchV2FooterViewHolder(r103, 0);
    }
}
