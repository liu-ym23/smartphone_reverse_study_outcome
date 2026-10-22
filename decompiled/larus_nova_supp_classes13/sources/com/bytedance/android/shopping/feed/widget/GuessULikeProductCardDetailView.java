package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv3.repository.dto.FeedCardStyle;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/GuessULikeProductCardDetailView;", "Lcom/bytedance/android/shopping/feed/widget/BaseCardDetailView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuessULikeProductCardDetailView extends BaseCardDetailView {
    public static final /* synthetic */ int Q = 0;

    public static final class a {
    }

    static {
    }

    public GuessULikeProductCardDetailView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GuessULikeProductCardDetailView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardDetailView
    public final void e() {
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        Context r1 = getContext();
        r0.getClass();
        FeedProductEventTracker.A(r1, "click_inflow_similar_tab", true, null);
    }

    public static DisplayMetrics i(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardDetailView
    public final void b(Function3<? super View, ? super String, ? super String, Unit> r7, rd3.a r8) {
        Intrinsics.checkNotNullParameter(r7, "detailOnClickListener");
        super.b(r7, r8);
        if (r8 == null) goto L53;
        ProductFeedViewModel r9 = r8.c;
        if (r9 != null) goto L8;
        return;
    L8:
        if (this.B == true) goto L38;
        InnerFlowPageStyleDTO r10 = r9.getInnerFlowPageStyle();
        ViewGroup.LayoutParams r2 = null;
        if (r10 == null) goto L14;
        FeedCardStyle r11 = r10.getFeedCardStyle();
        if (r11 == null) goto L14;
        Integer r12 = r11.getCardSpacing();
    L15:
        if (r12 == null) goto L38;
        if (r12.intValue() != 1) goto L38;
        ViewGroup.LayoutParams r13 = getPriceAndSalesView().getLayoutParams();
        if ((r13 instanceof LinearLayout.LayoutParams) == true) goto L22;
        r13 = null;
    L22:
        LinearLayout.LayoutParams r14 = (LinearLayout.LayoutParams) r13;
        if (r14 == null) goto L25;
        r14.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 12, i(Resources.getSystem())));
    L25:
        ViewGroup.LayoutParams r15 = getProductTitleView().getLayoutParams();
        if ((r15 instanceof LinearLayout.LayoutParams) == true) goto L28;
        r15 = null;
    L28:
        LinearLayout.LayoutParams r16 = (LinearLayout.LayoutParams) r15;
        if (r16 == null) goto L31;
        r16.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 8, i(Resources.getSystem())));
    L31:
        ViewGroup.LayoutParams r17 = getBottomBarView().getLayoutParams();
        if ((r17 instanceof LinearLayout.LayoutParams) == false) goto L35;
        r2 = r17;
    L35:
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2;
        if (r3 == null) goto L38;
        float r18 = 12;
        r3.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r18, i(Resources.getSystem())));
        r3.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r18, i(Resources.getSystem())));
    L14:
        r12 = null;
    L38:
        InnerFlowPageStyleDTO r19 = r9.getInnerFlowPageStyle();
        if (r19 == null) goto L51;
        PageStyle r20 = r19.getPageStyle();
        if (r20 == null) goto L51;
        if (r20.isGuessULikeShowSearchPdt() != true) goto L51;
        InnerFlowPageStyleDTO r21 = r9.getInnerFlowPageStyle();
        if (r21 == null) goto L51;
        PageStyle r22 = r21.getPageStyle();
        if (r22 == null) goto L51;
        if (r22.getSearchPdtStyle() != 1) goto L51;
        Intrinsics.checkNotNullParameter(r9, "viewModel");
        this.h.setOnClickListener(new com.bytedance.android.shopping.feed.widget.a(this));
        getSameProductEntrance().setVisibility(0);
        getProductTitleDivider().setVisibility(0);
        return;
    L51:
        getSameProductEntrance().setVisibility(8);
        getProductTitleDivider().setVisibility(8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuessULikeProductCardDetailView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        ViewGroup.LayoutParams r1 = null;
        setCardHeaderView(new GuessULikeProductCardHeaderView(r4, 0 == true ? 1 : 0, 6, 0));
        getHeaderViewContainer().addView(getCardHeaderView(), new FrameLayout.LayoutParams(-1, -2));
        if (this.B == true) goto L36;
        ProductFeedViewModel r7 = getViewModel();
        if (r7 == null) goto L11;
        InnerFlowPageStyleDTO r8 = r7.getInnerFlowPageStyle();
        if (r8 == null) goto L11;
        FeedCardStyle r9 = r8.getFeedCardStyle();
        if (r9 == null) goto L11;
        Integer r10 = r9.getCardSpacing();
    L12:
        if (r10 != null) goto L15;
        return;
    L15:
        if (r10.intValue() != 1) goto L37;
        ViewGroup.LayoutParams r11 = getPriceAndSalesView().getLayoutParams();
        if ((r11 instanceof LinearLayout.LayoutParams) == true) goto L19;
        r11 = null;
    L19:
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) r11;
        if (r12 == null) goto L22;
        r12.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 12, i(Resources.getSystem())));
    L22:
        ViewGroup.LayoutParams r13 = getProductTitleView().getLayoutParams();
        if ((r13 instanceof LinearLayout.LayoutParams) == true) goto L25;
        r13 = null;
    L25:
        LinearLayout.LayoutParams r14 = (LinearLayout.LayoutParams) r13;
        if (r14 == null) goto L28;
        r14.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 8, i(Resources.getSystem())));
    L28:
        ViewGroup.LayoutParams r15 = getBottomBarView().getLayoutParams();
        if ((r15 instanceof LinearLayout.LayoutParams) == false) goto L32;
        r1 = r15;
    L32:
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) r1;
        if (r2 == null) goto L38;
        float r16 = 12;
        r2.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r16, i(Resources.getSystem())));
        r2.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r16, i(Resources.getSystem())));
        return;
    L38:
        return;
    L37:
        return;
    L11:
        r10 = null;
        goto L12
    }

    public /* synthetic */ GuessULikeProductCardDetailView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
