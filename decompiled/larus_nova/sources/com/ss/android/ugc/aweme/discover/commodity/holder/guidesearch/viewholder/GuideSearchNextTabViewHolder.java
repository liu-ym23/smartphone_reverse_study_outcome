package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/viewholder/GuideSearchNextTabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuideSearchNextTabViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DmtTextView f450226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f450227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f450228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f450229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f450230e;

    public GuideSearchNextTabViewHolder(ViewGroup r100, final View r101, int r102, GuideSearchVerticalVHInfoProvider r103) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r103, "guideSearchVerticalVHInfoProvider");
        super(r101);
        this.f450230e = r100;
        this.f450226a = (DmtTextView) r101.findViewById(R.id.slideTipsView);
        this.f450227b = LazyKt.lazy(new GuideSearchNextTabViewHolder$icon$2(r101));
        this.f450228c = LazyKt.lazy(new GuideSearchNextTabViewHolder$contentContainer$2(r101));
        new GuideSearchNextTabViewHolder$thresholdListener$1(this);
    }
}
