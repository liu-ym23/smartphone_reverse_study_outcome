package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductButtonStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductServiceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.shopping.anchorv3.detail.widget.InflowFeedServiceView;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardBuyButton;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardTitleView;
import com.bytedance.android.shopping.utils.k0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR*\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/FlowTinyProductView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "a", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getProductImage", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "productImage", "Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardBuyButton;", "f", "Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardBuyButton;", "getBuyButton", "()Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardBuyButton;", "buyButton", "", "value", "l", "I", "getStyle", "()I", "setStyle", "(I)V", "style", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FlowTinyProductView extends FrameLayout {
    public final ECDraweeView a;
    public final ViewGroup b;
    public final ProductFlowCardTitleView c;
    public final TinyCardPriceView d;
    public final InflowFeedServiceView e;
    public final ProductFlowCardBuyButton f;
    public final SellPointView g;
    public final View h;
    public final TextView i;
    public final TextView j;
    public final ViewGroup k;
    public int l;

    public static final class a {
    }

    static {
    }

    public FlowTinyProductView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowTinyProductView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ProductFlowCardBuyButton getBuyButton() {
        return this.f;
    }

    public final ECDraweeView getProductImage() {
        return this.a;
    }

    public final int getStyle() {
        return this.l;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(PromotionProductStruct r12) {
        Intrinsics.checkNotNullParameter(r12, "promotion");
        ImageExtensionsKt.D(this.a, new com.bytedance.android.ec.core.imagex.r("ec_goods_feed", "ec_goods_feed_tiny"));
        ECDraweeView r0 = this.a;
        PromotionProductBaseStruct r1 = r12.getBaseInfo();
        String r2 = null;
        if (r1 == null) goto L7;
        List r3 = r1.getImages();
        if (r3 == null) goto L7;
        ECUrlModel r4 = (ECUrlModel) CollectionsKt.firstOrNull(r3);
    L8:
        y.a(r0, r4);
        ProductFlowCardTitleView r5 = this.c;
        PromotionProductBaseStruct r6 = r12.getBaseInfo();
        if (r6 == null) goto L11;
        String r7 = r6.getTitle();
    L12:
        PromotionProductPrivilegesStruct r8 = r12.getPrivilegeInfo();
        if (r8 == null) goto L19;
        PromotionProductActivitiesStruct r9 = r8.getActivities();
        if (r9 == null) goto L19;
        PromotionMarketFloor r10 = r9.getPlatformTextActivity();
        if (r10 == null) goto L19;
        ECUrlModel r11 = r10.getIcon();
    L20:
        int r13 = com.bytedance.android.shopping.anchorv3.utils.y.a;
        r5.a(r7, r11, com.bytedance.android.shopping.anchorv3.utils.y.c(r12));
        this.d.a(r12);
        boolean r14 = true;
        if (this.e.getVisibility() != 0) goto L23;
        boolean r15 = true;
    L25:
        if (r15 == false) goto L50;
        PromotionProductPrivilegesStruct r16 = r12.getPrivilegeInfo();
        if (r16 == null) goto L50;
        List r17 = r16.getServices();
        if (r17 == null) goto L50;
        List r18 = r17;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r20 = r18.iterator();
    L32:
        if (r20.hasNext() == false) goto L35;
        r19.add(((PromotionProductServiceStruct) r20.next()).getTitle());
        goto L32
    L35:
        if (this.l != 2) goto L49;
        PromotionProductBaseStruct r21 = r12.getBaseInfo();
        if (r21 == null) goto L49;
        Long r22 = r21.getSales();
        if (r22 == null) goto L49;
        if (r22.longValue() <= 0) goto L43;
        boolean r23 = true;
    L44:
        if (r23 == true) goto L47;
        r22 = null;
    L47:
        if (r22 == null) goto L49;
        ListProtector.add(r19, 0, th.a.h(getContext(), 2131913958, new Object[]{k0.a(r22.longValue())}));
        goto L49
    L43:
        r23 = false;
    L49:
        this.e.b(r19);
    L50:
        int r24 = this.l;
        if (r24 == 6) goto L53;
        if (r24 == 5) goto L53;
    L61:
        if (this.g.getVisibility() != 0) goto L63;
        boolean r25 = true;
    L64:
        if (r25 == false) goto L94;
        int r26 = this.l;
        if (r26 == 6) goto L70;
        if (r26 == 5) goto L70;
        this.g.a(r12);
    L70:
        PromotionProductPrivilegesStruct r27 = r12.getPrivilegeInfo();
        if (r27 == null) goto L93;
        List r28 = r27.getServices();
        if (r28 == null) goto L93;
        List r29 = r28;
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator r31 = r29.iterator();
    L76:
        if (r31.hasNext() == false) goto L78;
        r30.add(((PromotionProductServiceStruct) r31.next()).getTitle());
        goto L76
    L78:
        SellPointView r32 = this.g;
        r32.getClass();
        Intrinsics.checkNotNullParameter(r30, "list");
        r32.removeAllViews();
        Iterator r33 = r30.iterator();
    L80:
        if (r33.hasNext() == false) goto L94;
        String r34 = (String) r33.next();
        if (cg4.a.a("#FE496A") == true) goto L83;
        int r35 = g1.a;
        r32.addView(r32.b(r34, g1.a.a(r32.getContext(), 2131106061), null, false));
        goto L80
    L83:
        Integer r36 = com.bytedance.android.ec.core.utils.s.b("#FE496A");
        if (r36 == null) goto L86;
        int r37 = r36.intValue();
    L87:
        Integer r38 = com.bytedance.android.ec.core.utils.s.b("#57FE496A");
        if (r38 == null) goto L90;
        int r39 = r38.intValue();
    L91:
        r32.addView(r32.b(r34, r37, Integer.valueOf(r39), true));
        goto L80
    L90:
        r39 = 0;
        goto L91
    L86:
        r37 = 0;
    L93:
        this.g.setVisibility(8);
    L94:
        this.i.setText(d63.r.a(r12).p);
        TextView r40 = this.j;
        if (r40 != null) goto L97;
    L109:
        ViewGroup.LayoutParams r110 = this.g.getLayoutParams();
        if (r110 == null) goto L131;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        if (this.g.getChildCount() <= 0) goto L114;
        boolean r41 = true;
    L115:
        if (r41 == true) goto L117;
        r111.topMargin = com.bytedance.android.shopping.extensions.b.b(6);
    L118:
        ViewGroup.LayoutParams r112 = this.g.getLayoutParams();
        if (r112 == null) goto L129;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        if (this.e.getChildCount() > 0) goto L124;
        r14 = false;
    L124:
        if (r14 == true) goto L126;
        r113.topMargin = com.bytedance.android.shopping.extensions.b.b(6);
        return;
    L126:
        r113.topMargin = com.bytedance.android.shopping.extensions.b.b(0);
        return;
    L129:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L117:
        r111.topMargin = com.bytedance.android.shopping.extensions.b.b(0);
        goto L118
    L114:
        r41 = false;
        goto L115
    L131:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L97:
        if (r40.getVisibility() != 0) goto L99;
        boolean r42 = true;
    L100:
        if (r42 != true) goto L109;
        TextView r43 = this.j;
        if (r43 == null) goto L109;
        PromotionProductBaseStruct r114 = r12.getBaseInfo();
        if (r114 == null) goto L108;
        SalesInfoStruct r115 = r114.getSalesInfo();
        if (r115 == null) goto L108;
        r2 = r115.getText();
    L108:
        r43.setText(r2);
        goto L109
    L99:
        r42 = false;
        goto L100
    L63:
        r25 = false;
    L53:
        AppCompatButton r44 = this.f;
        PromotionProductExtraStruct r45 = r12.getExtraInfo();
        if (r45 == null) goto L58;
        PromotionProductButtonStruct r46 = r45.getBuyButton();
        if (r46 == null) goto L58;
        CharSequence r47 = r46.getText();
    L59:
        r44.setText(r47);
    L58:
        r47 = null;
        goto L59
    L23:
        r15 = false;
    L19:
        r11 = null;
        goto L20
    L11:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }

    public final void b(rd3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorInflowFeedItem");
        Promotion r3 = r2.f();
        if (r3 == null) goto L9;
        PromotionProductStruct r4 = r3.getPromotionInfo();
        if (r4 == null) goto L10;
        a(r4);
        return;
    L10:
        return;
    }

    public final void setStyle(int r11) {
        this.l = r11;
        ViewGroup.LayoutParams r1 = null;
        switch(r11) {
            case 1: goto L61;
            case 2: goto L51;
            case 3: goto L41;
            case 4: goto L38;
            case 5: goto L23;
            case 6: goto L23;
            case 7: goto L5;
            default: goto L76;
        };
    L5:
        ViewGroup r12 = this.k;
        if (r12 == null) goto L8;
        r12.setVisibility(0);
    L8:
        ProductFlowCardTitleView r13 = this.c;
        if (r13 == null) goto L11;
        r13.setVisibility(8);
    L11:
        this.d.setVisibility(8);
        InflowFeedServiceView r14 = this.e;
        if (r14 == null) goto L14;
        r14.setVisibility(8);
    L14:
        SellPointView r15 = this.g;
        if (r15 == null) goto L17;
        r15.setVisibility(8);
    L17:
        AppCompatButton r16 = this.f;
        if (r16 == null) goto L20;
        r16.setVisibility(8);
    L20:
        ViewGroup.LayoutParams r17 = this.b.getLayoutParams();
        r17.width = com.bytedance.android.shopping.extensions.b.b(94);
        r17.height = com.bytedance.android.shopping.extensions.b.b(94);
        TextView r18 = this.j;
        if (r18 == null) goto L65;
        r18.setVisibility(8);
        return;
    L65:
        return;
    L23:
        this.c.setMaxLine(1);
        this.d.setNeedShowSuffixButNoSales(true);
        ViewGroup.LayoutParams r19 = this.b.getLayoutParams();
        if (this.l != 6) goto L26;
        int r0 = 110;
    L27:
        r19.width = com.bytedance.android.shopping.extensions.b.b(r0);
        if (this.l != 6) goto L30;
        int r2 = 110;
    L31:
        r19.height = com.bytedance.android.shopping.extensions.b.b(r2);
        this.f.setVisibility(0);
        this.f.setBackgroundResource(2131247911);
        AppCompatButton r110 = this.f;
        float r3 = com.bytedance.android.shopping.extensions.b.b(6);
        float r4 = com.bytedance.android.shopping.extensions.b.b(6);
        float r5 = com.bytedance.android.shopping.extensions.b.b(6);
        float r6 = com.bytedance.android.shopping.extensions.b.b(6);
        Drawable r111 = r110.getBackground().mutate();
        if (r111 == null) goto L37;
        ((GradientDrawable) r111).setCornerRadii(new float[]{r3, r3, r4, r4, r5, r5, r6, r6});
        this.e.setVisibility(8);
        this.g.setVisibility(0);
        this.g.getLayoutParams().height = com.bytedance.android.shopping.extensions.b.b(14);
        ViewGroup.LayoutParams r112 = this.f.getLayoutParams();
        r112.width = com.bytedance.android.shopping.extensions.b.b(54);
        r112.height = com.bytedance.android.shopping.extensions.b.b(28);
        TextView r113 = this.j;
        if (r113 == null) goto L67;
        r113.setVisibility(0);
        return;
    L67:
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L30:
        r2 = 130;
        goto L31
    L26:
        r0 = 130;
        goto L27
    L38:
        this.e.setVisibility(8);
        this.c.setMaxLine(2);
        this.g.setVisibility(8);
        this.d.getNeedShowSalesAndSuffixText();
        this.f.setVisibility(0);
        ViewGroup.LayoutParams r114 = this.b.getLayoutParams();
        r114.width = com.bytedance.android.shopping.extensions.b.b(94);
        r114.height = com.bytedance.android.shopping.extensions.b.b(94);
        ViewGroup.LayoutParams r115 = this.f.getLayoutParams();
        r115.width = com.bytedance.android.shopping.extensions.b.b(64);
        r115.height = com.bytedance.android.shopping.extensions.b.b(24);
        this.h.setVisibility(0);
        TextView r116 = this.j;
        if (r116 == null) goto L69;
        r116.setVisibility(8);
        return;
    L69:
        return;
    L41:
        this.d.setNeedShowSalesAndSuffixText(false);
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        setBackgroundResource(2131234389);
        setPadding(com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8));
        ViewGroup.LayoutParams r117 = this.f.getLayoutParams();
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L45;
        r1 = r117;
    L45:
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r1;
        if (r7 == null) goto L48;
        r7.rightMargin = com.bytedance.android.shopping.extensions.b.b(2);
    L48:
        ViewGroup.LayoutParams r118 = this.b.getLayoutParams();
        r118.width = com.bytedance.android.shopping.extensions.b.b(94);
        r118.height = com.bytedance.android.shopping.extensions.b.b(94);
        this.c.setMaxLine(1);
        wg.a.g(this.f, 12);
        TextView r119 = this.j;
        if (r119 == null) goto L71;
        r119.setVisibility(8);
        return;
    L71:
        return;
    L51:
        this.d.setNeedShowSalesAndSuffixText(false);
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        setBackgroundResource(2131234389);
        setPadding(com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8));
        ViewGroup.LayoutParams r120 = this.f.getLayoutParams();
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == false) goto L55;
        r1 = r120;
    L55:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r1;
        if (r8 == null) goto L58;
        r8.rightMargin = com.bytedance.android.shopping.extensions.b.b(2);
    L58:
        this.c.setMaxLine(2);
        wg.a.g(this.f, 12);
        TextView r121 = this.j;
        if (r121 == null) goto L73;
        r121.setVisibility(8);
        return;
    L73:
        return;
    L61:
        this.d.setNeedShowSalesAndSuffixText(true);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.c.setMaxLine(2);
        TextView r122 = this.j;
        if (r122 == null) goto L75;
        r122.setVisibility(8);
        return;
    L75:
        return;
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [android.widget.Button, android.widget.TextView, com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardBuyButton] */
    public FlowTinyProductView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.l = 1;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r5).aU(2131560716, this, true);
        this.a = findViewById(2131388708);
        this.b = (ViewGroup) findViewById(2131388709);
        ProductFlowCardTitleView r8 = (ProductFlowCardTitleView) findViewById(2131388716);
        this.c = r8;
        TinyCardPriceView r0 = (TinyCardPriceView) findViewById(2131388710);
        this.d = r0;
        this.h = findViewById(2131388714);
        this.i = (TextView) findViewById(2131388715);
        this.k = (ViewGroup) findViewById(2131388717);
        wg.a.g(r0.getMinPriceView(), 18);
        wg.a.g(r0.getSalesTextView(), 11);
        InflowFeedServiceView r1 = findViewById(2131388713);
        this.e = r1;
        r1.setDividerDrawableRes(2131233481);
        r1.setDesiredChildHeight(com.bytedance.android.shopping.extensions.b.b(12));
        r1.setTextSizeDP(10.0f);
        int r2 = g1.a;
        r1.setTextColor(g1.a.a(r5, 2131101176));
        ?? r9 = (ProductFlowCardBuyButton) findViewById(2131388704);
        this.f = r9;
        this.g = (SellPointView) findViewById(2131388712);
        r9.setRadius(com.bytedance.android.shopping.extensions.b.b(4));
        r9.setText(2131895761);
        se3.a.c(r9, 2, 14.0f);
        r8.setTextStyle(false);
        r8.setTextAndIconSizeDP(14.0f);
        r8.setArrowStyleVisible(false);
        r0.setSalesMarginLeft(com.bytedance.android.shopping.extensions.b.b(4));
        this.j = (TextView) findViewById(2131388711);
        setStyle(1);
    }

    public /* synthetic */ FlowTinyProductView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
