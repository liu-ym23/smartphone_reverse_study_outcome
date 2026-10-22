package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.bytedance.lighten.loader.SmartImageView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.discover.commodity.helper.ECSearchResourceHelper;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/viewholder/CommodityGuideSearchV3ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommodityGuideSearchV3ViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SmartImageView f450221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f450222b;

    public CommodityGuideSearchV3ViewHolder(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        DmtTextView r102 = (DmtTextView) r100.findViewById(R.id.gsTagTextView);
        SmartImageView r103 = (SmartImageView) r100.findViewById(R.id.gsTagIconView);
        DmtTextView r104 = (DmtTextView) r100.findViewById(R.id.gsLabelView);
        DmtTextView r105 = (DmtTextView) r100.findViewById(R.id.gsWordView);
        SmartImageView r106 = (SmartImageView) r100.findViewById(R.id.itemBgView);
        SmartImageView r107 = (SmartImageView) r100.findViewById(R.id.itemCoverView);
        this.f450221a = (SmartImageView) r100.findViewById(R.id.itemImageView);
        this.f450222b = (ViewGroup) r100.findViewById(R.id.itemLayout);
        LinearLayout r108 = (LinearLayout) r100.findViewById(R.id.attachWordLayout);
        Space r109 = (Space) r100.findViewById(R.id.topPaddingView);
        Space r110 = (Space) r100.findViewById(R.id.gsLabelTranslationView);
        Space r111 = (Space) r100.findViewById(R.id.gsWordPaddingView);
        Space r112 = (Space) r100.findViewById(R.id.attachWordPaddingView);
        Space r113 = (Space) r100.findViewById(R.id.bottomPaddingView);
        ECSearchResourceHelper r114 = ECSearchResourceHelper.f450039b;
        DimenExtensionsKt.b(Float.valueOf(r114.a()));
        DimenExtensionsKt.b(Float.valueOf(ECSearchResourceHelper.b(r114, ECSearchResourceHelper.ECSearchTokenKey.ECSearch2xGridPaddingToken)));
        DimenExtensionsKt.b(Float.valueOf(ECSearchResourceHelper.b(r114, ECSearchResourceHelper.ECSearchTokenKey.ECSearchLimitedPaddingToken)));
        DimenExtensionsKt.b(Float.valueOf(ECSearchResourceHelper.b(r114, ECSearchResourceHelper.ECSearchTokenKey.ECSearch1XHalfPaddingToken)));
    }
}
