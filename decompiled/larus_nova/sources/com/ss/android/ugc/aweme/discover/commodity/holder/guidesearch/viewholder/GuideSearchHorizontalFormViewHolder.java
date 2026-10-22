package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.viewholder;

import android.view.View;
import android.widget.Space;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.bytedance.lighten.loader.SmartImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/viewholder/GuideSearchHorizontalFormViewHolder;", "Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/viewholder/GuideSearchRecyclerViewHolder;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuideSearchHorizontalFormViewHolder extends GuideSearchRecyclerViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SmartImageView f450223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f450224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f450225c;

    public GuideSearchHorizontalFormViewHolder(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        DmtTextView r102 = (DmtTextView) r100.findViewById(R.id.gsTagTextView);
        SmartImageView r103 = (SmartImageView) r100.findViewById(R.id.gsTagIconView);
        DmtTextView r104 = (DmtTextView) r100.findViewById(R.id.gsLabelView);
        DmtTextView r105 = (DmtTextView) r100.findViewById(R.id.gsWordView);
        DmtTextView r106 = (DmtTextView) r100.findViewById(R.id.attachWordView);
        this.f450223a = (SmartImageView) r100.findViewById(R.id.itemImageView);
        Space r107 = (Space) r100.findViewById(R.id.attachWordPaddingView);
        this.f450224b = r100.findViewById(R.id.itemCoverView);
        this.f450225c = r100.findViewById(R.id.itemImageBgView);
    }
}
