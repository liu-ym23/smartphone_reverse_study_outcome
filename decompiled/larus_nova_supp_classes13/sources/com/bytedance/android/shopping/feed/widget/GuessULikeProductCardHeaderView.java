package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.ProductTopicInfo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.TopicItemInfo;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.f1;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/GuessULikeProductCardHeaderView;", "Lcom/bytedance/android/shopping/feed/widget/BaseCardHeaderView;", "", "getLayoutResId", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuessULikeProductCardHeaderView extends BaseCardHeaderView {
    public final View n;
    public boolean o;

    public GuessULikeProductCardHeaderView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GuessULikeProductCardHeaderView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardHeaderView
    public int getLayoutResId() {
        return 2131564841;
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardHeaderView
    public final void c() {
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        Context r1 = getContext();
        r0.getClass();
        FeedProductEventTracker.A(r1, "click_inflow_similar_tab", true, "product_image");
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardHeaderView
    public final void a(v r12, Function3<? super View, ? super String, ? super String, Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r13, "detailOnClickListener");
        super.a(r12, r13);
        rd3.a r14 = r12.b;
        if (r14 == null) goto L13;
        Promotion r15 = r14.f();
        if (r15 == null) goto L13;
        PromotionProductStruct r16 = r15.getPromotionInfo();
        if (r16 == null) goto L13;
        PromotionProductExtraStruct r17 = r16.getExtraInfo();
        if (r17 == null) goto L13;
        ProductTopicInfo r18 = r17.getTopicInfo();
        if (r18 == null) goto L13;
        List r19 = r18.getTopicItemList();
    L15:
        if (r19 != null) goto L17;
    L24:
        getTagInfoView().setVisibility(8);
    L25:
        ProductFeedViewModel r110 = getViewModel();
        if (r110 == null) goto L65;
        rd3.a r7 = r12.b;
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        if (r7 == null) goto L32;
        Promotion r8 = r7.f();
        if (r8 == null) goto L32;
        PromotionProductStruct r9 = r8.getPromotionInfo();
    L33:
        InnerFlowPageStyleDTO r10 = r110.getInnerFlowPageStyle();
        if (r10 == null) goto L38;
        PageStyle r11 = r10.getPageStyle();
        if (r11 == null) goto L38;
        Integer r20 = r11.getSameProductSwitch();
    L39:
        if (r20 != null) goto L42;
    L43:
        if (r20 != null) goto L46;
    L48:
        this.n.setVisibility(8);
        goto L65
    L46:
        if (r20.intValue() != 3) goto L48;
    L49:
        this.n.setVisibility(0);
        HashSet<String> r21 = r110.getShowedSimilarEntranceProductId();
        if (r9 == null) goto L54;
        PromotionProductBaseStruct r111 = r9.getBaseInfo();
        if (r111 == null) goto L54;
        String r112 = r111.getProductId();
    L56:
        if (CollectionsKt.contains(r21, r112) == true) goto L64;
        if (r9 == null) goto L63;
        PromotionProductBaseStruct r22 = r9.getBaseInfo();
        if (r22 == null) goto L63;
        String r23 = r22.getProductId();
        if (r23 == null) goto L63;
        r110.getShowedSimilarEntranceProductId().add(r23);
    L63:
        FeedProductEventTracker r24 = FeedProductEventTracker.a;
        Context r113 = getContext();
        r24.getClass();
        FeedProductEventTracker.A(r113, "show_inflow_similar_tab", true, null);
    L64:
        this.n.setOnClickListener(new g(this, r110, r9, r7));
    L54:
        r112 = null;
        goto L56
    L42:
        if (r20.intValue() == 2) goto L49;
    L38:
        r20 = null;
    L32:
        r9 = null;
    L65:
        ProductFeedViewModel r114 = getViewModel();
        if (r114 == null) goto L89;
        InnerFlowPageStyleDTO r115 = r114.getInnerFlowPageStyle();
        if (r115 == null) goto L89;
        PageStyle r116 = r115.getPageStyle();
        if (r116 == null) goto L89;
        if (r116.isGuessULikeShowSearchPdt() != true) goto L89;
        ProductFeedViewModel r117 = getViewModel();
        if (r117 == null) goto L89;
        InnerFlowPageStyleDTO r118 = r117.getInnerFlowPageStyle();
        if (r118 == null) goto L89;
        PageStyle r119 = r118.getPageStyle();
        if (r119 == null) goto L89;
        if (r119.getSearchPdtStyle() != 2) goto L89;
        ProductFeedViewModel r120 = getViewModel();
        if (r120 == null) goto L88;
        f1 r3 = new f1();
        r3.a = "same_product";
        r3.b = "GuessULikeProductCardHeaderView";
        rd3.a r5 = r12.b;
        if (r5 == null) goto L86;
        String r6 = r5.d;
    L87:
        r3.c = r6;
        r3.post(null, null);
        rd3.a r121 = r12.b;
        Intrinsics.checkNotNullParameter(r120, "viewModel");
        super.b(r120, r121);
        FeedProductEventTracker r122 = FeedProductEventTracker.a;
        Context r123 = getContext();
        r122.getClass();
        FeedProductEventTracker.A(r123, "show_inflow_similar_tab", true, "product_image");
        getNewSameProductEntranceView().setVisibility(0);
        return;
    L86:
        r6 = null;
        goto L87
    L88:
        getNewSameProductEntranceView().setVisibility(8);
        return;
    L89:
        getNewSameProductEntranceView().setVisibility(8);
        return;
    L17:
        if ((!r19.isEmpty()) != true) goto L24;
        TopicItemInfo r124 = (TopicItemInfo) CollectionsKt.firstOrNull(r19);
        if (r124 != null) goto L21;
        getTagInfoView().setVisibility(8);
        goto L25
    L21:
        getTagInfoView().setVisibility(0);
        getTvTagText().setText(r124.getName());
        y.a(getDvTagIconView(), r124.getIcon());
        ArrayList r4 = new ArrayList();
        r124.setSelected("1");
        r4.add(r124);
        getTagInfoView().setOnClickListener(new h(this, r124, r4));
        if (this.o == true) goto L25;
        getTagInfoView().setAlpha(0.0f);
    L13:
        r19 = null;
        goto L15
    }

    public GuessULikeProductCardHeaderView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.n = findViewById(2131374050);
    }

    public /* synthetic */ GuessULikeProductCardHeaderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
