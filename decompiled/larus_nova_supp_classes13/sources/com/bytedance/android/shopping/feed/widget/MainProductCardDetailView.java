package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/MainProductCardDetailView;", "Lcom/bytedance/android/shopping/feed/widget/BaseCardDetailView;", "", "factor", "", "setHeaderInfoViewAlpha", "", "visible", "setProductAttentionVisible", "Landroid/view/ViewGroup;", "Q", "Landroid/view/ViewGroup;", "getSkeletonView", "()Landroid/view/ViewGroup;", "setSkeletonView", "(Landroid/view/ViewGroup;)V", "skeletonView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainProductCardDetailView extends BaseCardDetailView {
    public static final /* synthetic */ int R = 0;
    public ViewGroup Q;

    public static final class a {
    }

    static {
    }

    public MainProductCardDetailView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MainProductCardDetailView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardDetailView
    public final void e() {
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        Context r1 = getContext();
        r0.getClass();
        FeedProductEventTracker.A(r1, "click_inflow_similar_tab", true, "product_info");
    }

    public final ViewGroup getSkeletonView() {
        return this.Q;
    }

    public final void setHeaderInfoViewAlpha(float r2) {
        BaseCardHeaderView r0 = getCardHeaderView();
        if (r0 == null) goto L7;
        ((MainProductCardHeaderView) r0).setInfoViewTransitionAlpha(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.widget.MainProductCardHeaderView");
    }

    public final void setProductAttentionVisible(boolean r2) {
        BaseCardHeaderView r0 = getCardHeaderView();
        if (r0 == null) goto L7;
        ((MainProductCardHeaderView) r0).setProductAttentionVisible(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.widget.MainProductCardHeaderView");
    }

    public final void setSkeletonView(ViewGroup r1) {
        this.Q = r1;
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardDetailView
    public final void b(Function3<? super View, ? super String, ? super String, Unit> r4, rd3.a r5) {
        Intrinsics.checkNotNullParameter(r4, "detailOnClickListener");
        getPriceAndSalesView().setVisibility(0);
        getPriceContainer().setVisibility(0);
        getBarContainer().setVisibility(0);
        getExtraInfoContainer().setVisibility(0);
        getDiscountInfoContainer().setVisibility(0);
        getProductTitleView().setVisibility(0);
        getBottomBarView().setVisibility(0);
        ViewGroup r0 = this.Q;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        super.b(r4, r5);
        ProductFeedViewModel r6 = getViewModel();
        if (r6 == null) goto L25;
        InnerFlowPageStyleDTO r7 = r6.getInnerFlowPageStyle();
        if (r7 == null) goto L25;
        PageStyle r8 = r7.getPageStyle();
        if (r8 == null) goto L25;
        if (r8.getSearchPdtSwitch() != 1) goto L25;
        ProductFeedViewModel r9 = getViewModel();
        if (r9 == null) goto L25;
        InnerFlowPageStyleDTO r10 = r9.getInnerFlowPageStyle();
        if (r10 == null) goto L25;
        PageStyle r11 = r10.getPageStyle();
        if (r11 == null) goto L25;
        if (r11.getSearchPdtStyle() != 1) goto L25;
        ProductFeedViewModel r12 = getViewModel();
        if (r12 == null) goto L24;
        Intrinsics.checkNotNullParameter(r12, "viewModel");
        this.h.setOnClickListener(new com.bytedance.android.shopping.feed.widget.a(this));
        getSameProductEntrance().setVisibility(0);
        getProductTitleDivider().setVisibility(0);
    L26:
        p r13 = new p(this);
        if (ld3.d.e(ld3.d.b()) == false) goto L32;
        ViewTreeObserver r14 = getViewTreeObserver();
        if (r14 == null) goto L33;
        r14.addOnGlobalLayoutListener(r13);
        return;
    L33:
        return;
    L32:
        return;
    L24:
        getSameProductEntrance().setVisibility(8);
        getProductTitleDivider().setVisibility(8);
    L25:
        getSameProductEntrance().setVisibility(8);
        getProductTitleDivider().setVisibility(8);
        goto L26
    }

    public MainProductCardDetailView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        AttributeSet r1 = null;
        setCardHeaderView(new MainProductCardHeaderView(r3, r1, 6, 0));
        getHeaderViewContainer().addView(getCardHeaderView(), new FrameLayout.LayoutParams(-1, -2));
    }

    public /* synthetic */ MainProductCardDetailView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
