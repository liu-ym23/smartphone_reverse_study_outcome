package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.bytedance.lighten.loader.SmartImageView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.discover.commodity.helper.ECSearchResourceHelper;
import com.ss.android.ugc.aweme.search.utils.DimensUtilKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/viewholder/GuideSearchVerticalFormViewHolder;", "Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/viewholder/GuideSearchRecyclerViewHolder;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuideSearchVerticalFormViewHolder extends GuideSearchRecyclerViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f450232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f450233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f450234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SmartImageView f450235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f450236e;

    public GuideSearchVerticalFormViewHolder(View r100, int r101, GuideSearchVerticalVHInfoProvider r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r102, "guideSearchVerticalVHInfoProvider");
        super(r100);
        this.f450232a = LazyKt.lazy(GuideSearchVerticalFormViewHolder$mainPictureBackGroundLight$2.INSTANCE);
        this.f450233b = LazyKt.lazy(GuideSearchVerticalFormViewHolder$whiteBgBellowMainPicture$2.INSTANCE);
        this.f450234c = LazyKt.lazy(GuideSearchVerticalFormViewHolder$gsLabelBackGround$2.INSTANCE);
        LinearLayout r103 = (LinearLayout) r100.findViewById(R.id.gsContentLayout);
        DmtTextView r104 = (DmtTextView) r100.findViewById(R.id.gsTagTextView);
        SmartImageView r105 = (SmartImageView) r100.findViewById(R.id.gsTagIconView);
        DmtTextView r106 = (DmtTextView) r100.findViewById(R.id.gsLabelView);
        DmtTextView r107 = (DmtTextView) r100.findViewById(R.id.gsWordView);
        this.f450235d = (SmartImageView) r100.findViewById(R.id.itemImageView);
        DmtTextView r108 = (DmtTextView) r100.findViewById(R.id.attachWordView);
        Space r109 = (Space) r100.findViewById(R.id.attachWordPaddingView);
        this.f450236e = r100.findViewById(R.id.itemCoverView);
        ECSearchResourceHelper r110 = ECSearchResourceHelper.f450039b;
        r110.getClass();
        DimensUtilKt.a(Float.valueOf(ECSearchResourceHelper.b(r110, ECSearchResourceHelper.ECSearchTokenKey.ECSearchElementRadius200Token)));
    }
}
