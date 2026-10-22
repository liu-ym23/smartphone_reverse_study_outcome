package com.ss.android.ugc.aweme.search.common.result.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.discover.model.CardProtocolType;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.search.common.ICommonSearchViewHolder;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchMobParam;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/viewholder/ECSearchBlankViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/ugc/aweme/search/common/ICommonSearchViewHolder;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchBlankViewHolder extends RecyclerView.ViewHolder implements ICommonSearchViewHolder {
    @Override // com.ss.android.ugc.aweme.search.common.ICommonSearchViewHolder
    public final void D2() {
    }

    @Override // com.ss.android.ugc.aweme.search.common.IECSearchMob
    public final void O3(ECSearchMobParam r100, ECSearchParam r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
    }

    @Override // com.ss.android.ugc.aweme.search.common.ICommonSearchViewHolder
    public final void c1(int r100, SearchAggregateCommodity r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, CardProtocolType.COMMODITY);
        Intrinsics.checkNotNullParameter(r102, "layoutType");
    }

    @Override // com.ss.android.ugc.aweme.search.common.ICommonSearchViewHolder
    public final boolean k2() {
        Intrinsics.checkNotNullParameter("", "layoutType");
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.common.IViewHolderAttach
    public final void onViewAttachedToWindow() {
    }

    @Override // com.ss.android.ugc.aweme.search.common.IViewHolderAttach
    public final void onViewDetachedFromWindow() {
    }

    public ECSearchBlankViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }
}
