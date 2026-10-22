package com.bytedance.android.shopping.feed.productcard.doublefeedproductcard.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.utils.ProductFeedActionHelper;
import com.bytedance.android.shopping.feed.utils.g0;
import com.bytedance.android.shopping.feed.widget.TinyCardPriceView;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardTitleView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/productcard/doublefeedproductcard/view/DoubleFeedFlowProductCardView;", "Lcom/bytedance/android/shopping/feed/productcard/doublefeedproductcard/view/BaseDoubleFeedProductCardView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoubleFeedFlowProductCardView extends BaseDoubleFeedProductCardView {
    public static final /* synthetic */ int k = 0;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DoubleFeedFlowProductCardView a;
        public final /* synthetic */ rd3.a b;

        public a(DoubleFeedFlowProductCardView r1, rd3.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r19) {
            rd3.a r3 = this.b;
            if (r3 == null) goto L5;
            FeedProductEventTracker.u(FeedProductEventTracker.a, this.a.getContext(), r3, "pic", null, false, null, 120);
        L5:
            FeedProductEventTracker.m(FeedProductEventTracker.a, this.b, "pic", null, null, null, null, null, 124);
            ProductFeedActionHelper.f(this.a.getContext(), this.b, "click", "click");
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DoubleFeedFlowProductCardView a;
        public final /* synthetic */ rd3.a b;

        public b(DoubleFeedFlowProductCardView r1, rd3.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r19) {
            rd3.a r3 = this.b;
            if (r3 == null) goto L5;
            FeedProductEventTracker.u(FeedProductEventTracker.a, this.a.getContext(), r3, "blank", null, false, null, 120);
        L5:
            FeedProductEventTracker.m(FeedProductEventTracker.a, this.b, "blank", null, null, null, null, null, 124);
            ProductFeedActionHelper.f(this.a.getContext(), this.b, "click", "click");
        }
    }

    public DoubleFeedFlowProductCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DoubleFeedFlowProductCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.productcard.doublefeedproductcard.view.BaseDoubleFeedProductCardView
    public final void a(final rd3.a r3) {
        super.a(r3);
        Promotion r0 = r3.f();
        if (r0 == null) goto L9;
        PromotionProductStruct r1 = r0.getPromotionInfo();
        if (r1 == null) goto L9;
        TinyCardPriceView r2 = getPriceView();
        if (r2 == null) goto L9;
        r2.a(r1);
    L9:
        TextView r4 = getBuyButtonView();
        if (r4 == null) goto L12;
        r4.setOnClickListener(new DoubleFeedFlowProductCardView$bind$2(this, r3));
    L12:
        ECDraweeView r5 = getProductImage();
        if (r5 == null) goto L15;
        r5.setOnClickListener(new a(this, r3));
    L15:
        View r6 = getProductCardRootView();
        if (r6 == null) goto L19;
        r6.setOnClickListener(new b(this, r3));
        return;
    }

    public DoubleFeedFlowProductCardView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        ProductFlowCardTitleView r9 = getProductTitle();
        if (r9 == null) goto L6;
        r9.setMaxLine(2);
    L6:
        if (ECAppInfoService.e.f() == false) goto L10;
        TinyCardPriceView r10 = getPriceView();
        if (r10 == null) goto L13;
        r10.setNeedShowSalesAndSuffixText(false);
    L13:
        ProductFlowCardTitleView r11 = getProductTitle();
        if (r11 == null) goto L28;
        int r12 = getImageSize();
        int r0 = g0.a;
        TextView r13 = r11.getTextview();
        String r1 = getTestText();
        int r2 = getImageSize();
        Resources r3 = Resources.getSystem();
        int r14 = r12 + g0.a(r13, r1, r2 - MathKt.roundToInt(TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()))));
        Resources r4 = Resources.getSystem();
        int r15 = r14 + MathKt.roundToInt(TypedValue.applyDimension(1, 74, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics())));
        View r16 = getProductCardRootView();
        ViewGroup.LayoutParams r17 = null;
        if (r16 == null) goto L18;
        ViewGroup.LayoutParams r18 = r16.getLayoutParams();
    L20:
        if ((r18 instanceof ViewGroup.LayoutParams) == false) goto L23;
        r17 = r18;
    L23:
        if (r17 == null) goto L29;
        r17.height = r15;
        View r19 = getProductCardRootView();
        if (r19 == null) goto L30;
        r19.setLayoutParams(r17);
        return;
    L30:
        return;
    L29:
        return;
    L18:
        r18 = null;
        goto L20
    L28:
        return;
    L10:
        TinyCardPriceView r20 = getPriceView();
        if (r20 == null) goto L13;
        r20.setNeedShowSalesTextWhenSuffixGone(true);
        goto L13
    }

    public /* synthetic */ DoubleFeedFlowProductCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
