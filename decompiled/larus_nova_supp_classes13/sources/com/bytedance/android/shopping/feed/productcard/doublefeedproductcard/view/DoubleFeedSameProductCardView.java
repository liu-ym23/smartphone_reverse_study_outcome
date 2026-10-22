package com.bytedance.android.shopping.feed.productcard.doublefeedproductcard.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.d;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductServiceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.utils.g0;
import com.bytedance.android.shopping.feed.widget.SellPointView;
import com.bytedance.android.shopping.feed.widget.TinyCardPriceView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardTitleView;
import com.bytedance.android.shopping.utils.k0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017JU\u0010\r\u001a\u00020\u000b2M\u0010\f\u001aI\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0002J@\u0010\u0010\u001a\u00020\u000b28\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/feed/productcard/doublefeedproductcard/view/DoubleFeedSameProductCardView;", "Lcom/bytedance/android/shopping/feed/productcard/doublefeedproductcard/view/BaseDoubleFeedProductCardView;", "Lkotlin/Function3;", "Lrd3/a;", "Lkotlin/ParameterName;", "name", "itemFeedProductAnchor", "", "position", "Landroid/view/View;", FreqActions.ACTION_VIEW, "", "buyButtonOnClickListener", "setBuyButtonClickListener", "Lkotlin/Function2;", "detailOnClickListener", "setEnterProductDetailListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoubleFeedSameProductCardView extends BaseDoubleFeedProductCardView {
    public Function2<? super Integer, ? super View, Unit> k;
    public Function3<? super rd3.a, ? super Integer, ? super View, Unit> l;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DoubleFeedSameProductCardView a;

        public a(DoubleFeedSameProductCardView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            DoubleFeedSameProductCardView r0 = this.a;
            Function3<? super rd3.a, ? super Integer, ? super View, Unit> r1 = r0.l;
            if (r1 == null) goto L10;
            rd3.a r2 = r0.getAnchorInflowFeedItem();
            rd3.a r3 = this.a.getAnchorInflowFeedItem();
            if (r3 == null) goto L7;
            int r5 = r3.f;
        L8:
            Unit r6 = (Unit) r1.invoke(r2, Integer.valueOf(r5), r4);
            return;
        L7:
            r5 = 0;
            goto L8
        }
    }

    public static final class b extends d {
        public final /* synthetic */ DoubleFeedSameProductCardView g;

        public b(DoubleFeedSameProductCardView r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            DoubleFeedSameProductCardView r0 = this.g;
            Function2<? super Integer, ? super View, Unit> r1 = r0.k;
            if (r1 == null) goto L10;
            rd3.a r2 = r0.getAnchorInflowFeedItem();
            if (r2 == null) goto L7;
            int r4 = r2.f;
        L8:
            Unit r5 = (Unit) r1.invoke(Integer.valueOf(r4), r3);
            return;
        L7:
            r4 = 0;
            goto L8
        }
    }

    public DoubleFeedSameProductCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DoubleFeedSameProductCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.productcard.doublefeedproductcard.view.BaseDoubleFeedProductCardView
    public final void a(rd3.a r10) {
        super.a(r10);
        Long r0 = null;
        if (r10 == null) goto L7;
        Promotion r11 = r10.f();
        if (r11 == null) goto L7;
        PromotionProductStruct r12 = r11.getPromotionInfo();
    L8:
        if (r12 == null) goto L12;
        TinyCardPriceView r1 = getPriceView();
        if (r1 == null) goto L12;
        r1.a(r12);
    L12:
        rd3.a r13 = getAnchorInflowFeedItem();
        if (r13 == null) goto L17;
        Promotion r14 = r13.f();
        if (r14 == null) goto L17;
        PromotionProductStruct r15 = r14.getPromotionInfo();
    L19:
        if (r15 == null) goto L41;
        PromotionProductPrivilegesStruct r3 = r15.getPrivilegeInfo();
        if (r3 == null) goto L41;
        List r4 = r3.getServices();
        if (r4 == null) goto L41;
        List r5 = r4;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L26:
        if (r7.hasNext() == false) goto L28;
        r6.add(((PromotionProductServiceStruct) r7.next()).getTitle());
        goto L26
    L28:
        PromotionProductBaseStruct r16 = r15.getBaseInfo();
        if (r16 == null) goto L40;
        Long r17 = r16.getSales();
        if (r17 == null) goto L40;
        if (r17.longValue() <= 0) goto L35;
        boolean r8 = true;
    L36:
        if (r8 == false) goto L38;
        r0 = r17;
    L38:
        if (r0 == null) goto L40;
        ListProtector.add(r6, 0, th.a.h(getContext(), 2131913958, new Object[]{k0.a(r0.longValue())}));
        goto L40
    L35:
        r8 = false;
    L40:
        getServiceView().b(r6);
    L41:
        SellPointView r18 = getSellPointView();
        if (r18 != null) goto L44;
    L51:
        ProductFlowCardTitleView r19 = getProductTitle();
        if (r19 == null) goto L54;
        r19.setMaxLine(1);
    L54:
        SellPointView r110 = getSellPointView();
        if (r110 != null) goto L57;
    L64:
        SellPointView r111 = getSellPointView();
        if (r111 == null) goto L71;
        r111.setVisibility(8);
        return;
    L71:
        return;
    L57:
        if (r110.getChildCount() <= 0) goto L59;
        boolean r112 = true;
    L60:
        if (r112 != true) goto L64;
        SellPointView r113 = getSellPointView();
        if (r113 == null) goto L69;
        r113.setVisibility(0);
        return;
    L69:
        return;
    L59:
        r112 = false;
        goto L60
    L44:
        if (r18.getChildCount() != 0) goto L46;
        boolean r114 = true;
    L47:
        if (r114 != true) goto L51;
        ProductFlowCardTitleView r115 = getProductTitle();
        if (r115 == null) goto L54;
        r115.setMaxLine(2);
        goto L54
    L46:
        r114 = false;
    L17:
        r15 = null;
    L7:
        r12 = null;
        goto L8
    }

    public final void setBuyButtonClickListener(Function3<? super rd3.a, ? super Integer, ? super View, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "buyButtonOnClickListener");
        this.l = r2;
    }

    public final void setEnterProductDetailListener(Function2<? super Integer, ? super View, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "detailOnClickListener");
        this.k = r2;
    }

    public DoubleFeedSameProductCardView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        TextView r8 = getBuyButtonView();
        if (r8 == null) goto L5;
        r8.setOnClickListener(new a(this));
    L5:
        View r9 = getProductCardRootView();
        if (r9 == null) goto L8;
        r9.setOnClickListener(new b(this));
    L8:
        getServiceView().setVisibility(0);
        getServiceView().setDividerDrawableRes(2131233481);
        ProductFlowCardTitleView r10 = getProductTitle();
        if (r10 == null) goto L23;
        int r11 = getImageSize();
        int r12 = g0.a;
        TextView r13 = r10.getTextview();
        String r14 = getTestText();
        int r0 = getImageSize();
        Resources r2 = Resources.getSystem();
        int r15 = r11 + g0.a(r13, r14, r0 - MathKt.roundToInt(TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()))));
        Resources r16 = Resources.getSystem();
        int r17 = r15 + MathKt.roundToInt(TypedValue.applyDimension(1, 74, WindowDisplayMetricsOverride.apply(r16, r16.getDisplayMetrics())));
        View r18 = getProductCardRootView();
        ViewGroup.LayoutParams r19 = null;
        if (r18 == null) goto L13;
        ViewGroup.LayoutParams r20 = r18.getLayoutParams();
    L15:
        if ((r20 instanceof ViewGroup.LayoutParams) == false) goto L18;
        r19 = r20;
    L18:
        if (r19 == null) goto L24;
        r19.height = r17;
        View r21 = getProductCardRootView();
        if (r21 == null) goto L25;
        r21.setLayoutParams(r19);
        return;
    L25:
        return;
    L24:
        return;
    L13:
        r20 = null;
        goto L15
    }

    public /* synthetic */ DoubleFeedSameProductCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
