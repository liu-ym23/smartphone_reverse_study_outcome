package com.bytedance.android.shopping.feed.resourcecard.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.o1;
import com.bytedance.android.shopping.feed.resourcecard.view.coupon_divert.CouponNodeViewStyleCouponDivert;
import com.bytedance.android.shopping.feed.resourcecard.view.coupon_divert.HeaderNodeViewStyleCouponDivert;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.track.TrackerProvider;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import org.json.JSONObject;
import yd3.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0010\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/ResourceCardView;", "Landroid/widget/FrameLayout;", "Lrd3/a;", "a", "Lrd3/a;", "getAnchorInflowFeedItem", "()Lrd3/a;", "setAnchorInflowFeedItem", "(Lrd3/a;)V", "anchorInflowFeedItem", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "d", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getBackgroundSDV", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "backgroundSDV", "com/bytedance/android/shopping/feed/resourcecard/view/ResourceCardView$lynxClickEventSubscriber$2$a", "e", "Lkotlin/Lazy;", "getLynxClickEventSubscriber", "()Lcom/bytedance/android/shopping/feed/resourcecard/view/ResourceCardView$lynxClickEventSubscriber$2$a;", "lynxClickEventSubscriber", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResourceCardView extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public rd3.a a;
    public boolean b;
    public final LinearLayout c;
    public final ECDraweeView d;
    public final Lazy e;

    public ResourceCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ResourceCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final ResourceCardView$lynxClickEventSubscriber$2.a getLynxClickEventSubscriber() {
        return (ResourceCardView$lynxClickEventSubscriber$2.a) this.e.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b == false) goto L6;
        ECLiveHybridUtil.n("click_ecom_inflow_card", getLynxClickEventSubscriber());
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b == false) goto L6;
        ECLiveHybridUtil.p("click_ecom_inflow_card", getLynxClickEventSubscriber());
        return;
    }

    public final rd3.a getAnchorInflowFeedItem() {
        return this.a;
    }

    public final ECDraweeView getBackgroundSDV() {
        return this.d;
    }

    public static DisplayMetrics a(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public final void d(final rd3.a r31) {
        Intrinsics.checkNotNullParameter(r31, "anchorInflowFeedItem");
        this.a = r31;
        yd3.p r3 = r31.i();
        if (r3 == null) goto L5;
        yd3.k r4 = r3.k();
    L7:
        if (r4 != null) goto L326;
        this.b = false;
        this.d.setVisibility(0);
        final yd3.p r5 = r31.i();
        if (r5 == null) goto L407;
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = null;
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = null;
        yd3.p r12 = r31.i();
        if (r12 == null) goto L16;
        yd3.f r13 = r12.h();
        if (r13 == null) goto L16;
        Integer r14 = Integer.valueOf(r13.b());
    L18:
        if (r5.getType() != 9) goto L21;
        this.c.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, 5, a(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, 0, a(Resources.getSystem()))));
        LinearLayout r7 = this.c;
        int r15 = g1.a;
        r7.setDividerDrawable(g1.a.b(getContext(), 2131233545));
    L43:
        y.a(this.d, r5.e());
        this.c.removeAllViews();
        if (r14 != null) goto L47;
    L48:
        if (r14 != null) goto L51;
    L53:
        setBackgroundColor(ag4.a.b(2131106784));
        ViewExtensionsKt.g(this, 12.0f, 12.0f, 12.0f, 12.0f);
    L55:
        ECDraweeView r6 = this.d;
        if (r14 == null) goto L63;
        int r16 = r14.intValue();
        if (r16 != 4) goto L60;
    L62:
        r6.setLayoutParams(new FrameLayout.LayoutParams(-1, r6.getDp(99)));
        r6.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_START);
        goto L63
    L60:
        if (r16 == 5) goto L62;
        r6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r6.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r6.setCornerRadius(r6.getDp(8));
    L63:
        yd3.l r8 = r5.b();
        if (r8 == null) goto L84;
        int r17 = ButtonNodeView.f;
        Context r18 = getContext();
        Intrinsics.checkNotNullParameter(r18, "context");
        if (ld3.b.a() == false) goto L68;
        Map r19 = ShoppingAsyncCacheInflater.d;
        ButtonNodeView r9 = (ButtonNodeView) ShoppingAsyncCacheInflater.a.a(r18).b("ec_button_node_view", new a());
        int r110 = 6;
    L69:
        Intrinsics.checkNotNullParameter(r31, "anchorInflowFeedItem");
        yd3.p r20 = r31.i();
        if (r20 != null) goto L72;
    L74:
        r9.d.setImageResource(2131234694);
        TextView r21 = r9.b;
        int r111 = g1.a;
        r21.setTextColor(g1.a.a(r9.getContext(), 2131105908));
        r9.e.setBackgroundResource(2131234466);
    L75:
        r9.c = r31;
        yd3.p r22 = r31.i();
        if (r22 == null) goto L78;
        yd3.a r23 = r22.b();
    L79:
        r9.a = r23;
        TextView r112 = r9.b;
        if (r23 == null) goto L82;
        String r24 = r23.d();
    L83:
        r112.setText(r24);
        Unit r25 = Unit.INSTANCE;
        c(r9, r8);
        goto L84
    L82:
        r24 = null;
        goto L83
    L78:
        r23 = null;
        goto L79
    L72:
        if (r20.getType() != r110) goto L74;
        r9.d.setImageResource(2131233446);
        r9.b.setTextColor(-1);
        r9.e.setBackgroundResource(2131234467);
        goto L75
    L68:
        r110 = 6;
        r9 = new ButtonNodeView(r18, null, 6, 0);
    L84:
        yd3.l r26 = r5.p();
        if (r26 == null) goto L150;
        int r27 = ShopNodeView.k;
        Context r28 = getContext();
        Intrinsics.checkNotNullParameter(r28, "context");
        if (ld3.b.a() == true) goto L387;
        ShopNodeView r113 = new ShopNodeView(r28, null, 6, 0);
    L97:
        Intrinsics.checkNotNullParameter(r31, "anchorInflowFeedItem");
        r113.j = r31;
        yd3.p r29 = r31.i();
        if (r29 == null) goto L100;
        yd3.r r30 = r29.p();
    L101:
        r113.a = r30;
        ImageExtensionsKt.D(r113.c, new com.bytedance.android.ec.core.imagex.r("ec_goods_feed", "ec_goods_feed_shop"));
        ECDraweeView r32 = r113.c;
        yd3.r r114 = r113.a;
        if (r114 == null) goto L104;
        ECUrlModel r115 = r114.f();
    L105:
        y.a(r32, r115);
        ECDraweeView r33 = r113.h.getBrandIconDV();
        yd3.r r116 = r113.a;
        if (r116 == null) goto L108;
        ECUrlModel r117 = r116.c();
    L109:
        y.a(r33, r117);
        yd3.r r34 = r113.a;
        if (r34 == null) goto L112;
        Boolean r35 = r34.i();
    L113:
        Boolean r118 = Boolean.TRUE;
        if (Intrinsics.areEqual(r35, r118) == false) goto L120;
        r113.d.setVisibility(0);
        r113.f.setVisibility(0);
        ECDraweeView r36 = r113.d;
        yd3.r r119 = r113.a;
        if (r119 == null) goto L118;
        ECUrlModel r120 = r119.e();
    L119:
        y.a(r36, r120);
    L121:
        yd3.r r37 = r113.a;
        if (r37 == null) goto L126;
        List<String> r38 = r37.h();
        if (r38 == null) goto L126;
        String r39 = (String) CollectionsKt.firstOrNull(r38);
    L127:
        if (r39 != null) goto L129;
        r113.e.setVisibility(8);
    L130:
        if (r39 == null) goto L138;
        yd3.r r40 = r113.a;
        if (r40 == null) goto L134;
        Boolean r41 = r40.i();
    L136:
        if (Intrinsics.areEqual(r41, r118) == false) goto L138;
        r113.g.setVisibility(0);
    L139:
        TextView r42 = r113.h.getShopNameTV();
        yd3.r r43 = r113.a;
        if (r43 == null) goto L142;
        String r44 = r43.g();
    L143:
        r42.setText(r44);
        c(r113, r26);
        if (r26.a() != 1) goto L150;
        ViewGroup.LayoutParams r45 = r113.getLayoutParams();
        if (r45 == null) goto L149;
        Integer r46 = 4;
        ((ViewGroup.MarginLayoutParams) r45).topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r46.floatValue(), a(Resources.getSystem())));
        goto L150
    L149:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L142:
        r44 = null;
        goto L143
    L134:
        r41 = null;
    L138:
        r113.g.setVisibility(8);
        goto L139
    L129:
        r113.e.setVisibility(0);
        r113.e.setText(r39);
    L126:
        r39 = null;
        goto L127
    L118:
        r120 = null;
        goto L119
    L120:
        r113.f.setVisibility(8);
        r113.d.setVisibility(8);
        goto L121
    L112:
        r35 = null;
        goto L113
    L108:
        r117 = null;
        goto L109
    L104:
        r115 = null;
        goto L105
    L100:
        r30 = null;
        goto L101
    L387:
        Map r121 = ShoppingAsyncCacheInflater.d;     // Catch: Exception -> L95
        View r122 = ShoppingAsyncCacheInflater.a.a(r28).b("ec_inflow_feed_shop_node", null);     // Catch: Exception -> L95
        if ((r122 instanceof ShopNodeView) == true) goto L91;
        r122 = null;
    L91:
        r113 = (ShopNodeView) r122;     // Catch: Exception -> L95
        if (r113 != null) goto L97;
        r113 = new ShopNodeView(r28, null, 6, 0);     // Catch: Exception -> L95
    L95:
        r113 = new ShopNodeView(r28, null, 6, 0);
    L150:
        yd3.l r47 = r5.h();
        if (r47 == null) goto L174;
        int r48 = r47.b();
        if (r48 == 1) goto L168;
        switch(r48) {
            case 4: goto L163;
            case 5: goto L163;
            case 6: goto L159;
            case 7: goto L159;
            case 8: goto L158;
            default: goto L155;
        };
    L155:
        int r49 = HeaderNodeViewStyle2.i;
        Context r50 = getContext();
        Intrinsics.checkNotNullParameter(r50, "context");
        if (ld3.b.a() == false) goto L167;
        Map r51 = ShoppingAsyncCacheInflater.d;
        HeaderNodeView r52 = (HeaderNodeViewStyle2) ShoppingAsyncCacheInflater.a.a(r50).b("ec_commerce_header_node_view_style_2", new c());
    L173:
        r10.element = r52;
        r52.a(r31);
        Unit r53 = Unit.INSTANCE;
        c(r52, r47);
        goto L174
    L167:
        HeaderNodeView r54 = new HeaderNodeViewStyle2(r50, null, 6, 0);
    L172:
        r52 = r54;
        goto L173
    L158:
        r52 = new HeaderNodeViewStyleCouponDivert(getContext(), null, 6, 0);
        goto L173
    L159:
        int r55 = HeaderNodeViewStyle67.e;
        Context r56 = getContext();
        Intrinsics.checkNotNullParameter(r56, "context");
        if (ld3.b.a() == false) goto L162;
        Map r57 = ShoppingAsyncCacheInflater.d;
        r52 = (HeaderNodeViewStyle67) ShoppingAsyncCacheInflater.a.a(r56).b("ec_commerce_header_node_view_style_67", new e());
        goto L173
    L162:
        r54 = new HeaderNodeViewStyle67(r56, null, 6, 0);
        goto L172
    L163:
        int r58 = HeaderNodeViewStyle4.e;
        Context r59 = getContext();
        Intrinsics.checkNotNullParameter(r59, "context");
        if (ld3.b.a() == false) goto L166;
        Map r60 = ShoppingAsyncCacheInflater.d;
        r52 = (HeaderNodeViewStyle4) ShoppingAsyncCacheInflater.a.a(r59).b("ec_commerce_header_node_view_style_4", new d());
        goto L173
    L166:
        r54 = new HeaderNodeViewStyle4(r59, null, 6, 0);
        goto L172
    L168:
        int r61 = HeaderNodeViewStyle1.g;
        Context r62 = getContext();
        Intrinsics.checkNotNullParameter(r62, "context");
        if (ld3.b.a() == false) goto L171;
        Map r63 = ShoppingAsyncCacheInflater.d;
        r52 = (HeaderNodeViewStyle1) ShoppingAsyncCacheInflater.a.a(r62).b("ec_commerce_header_node_view_style_1", new b());
        goto L173
    L171:
        r54 = new HeaderNodeViewStyle1(r62, null, 6, 0);
    L174:
        yd3.l r64 = r5.d();
        if (r64 == null) goto L233;
        int r65 = r64.b();
        if (r65 != 4) goto L179;
        int r66 = CouponNodeViewStyle4.g;
        Context r67 = getContext();
        Intrinsics.checkNotNullParameter(r67, "context");
        Map r68 = ShoppingAsyncCacheInflater.d;     // Catch: Exception -> L219
        View r69 = ShoppingAsyncCacheInflater.a.a(r67).b("ec_commerce_coupon_node_view", null);     // Catch: Exception -> L219
        if ((r69 instanceof CouponNodeViewStyle4) == true) goto L215;
        r69 = null;
    L215:
        Object r70 = (CouponNodeViewStyle4) r69;     // Catch: Exception -> L219
        if (r70 != null) goto L220;
        r70 = new CouponNodeViewStyle4(r67, null, 6, 0);     // Catch: Exception -> L219
    L220:
        r11.element = r70;
        if ((r70 instanceof CouponNodeViewStyle4) == false) goto L230;
        HeaderNodeView r71 = (HeaderNodeView) r10.element;
        if ((r71 instanceof HeaderNodeViewStyle4) == true) goto L225;
        r71 = null;
    L225:
        HeaderNodeViewStyle4 r72 = (HeaderNodeViewStyle4) r71;
        if (r72 == null) goto L230;
        ViewGroup r73 = r72.getMoreContainer();
        if (r73 == null) goto L230;
        r73.setOnClickListener(new i(this, r11, r5, r31));
    L230:
        CouponNodeView r74 = (CouponNodeView) r11.element;
        if (r74 == null) goto L233;
        r74.a(r31);
        c(r74, r64);
    L219:
        r70 = new CouponNodeViewStyle4(r67, null, 6, 0);
        goto L220
    L179:
        if (r65 != 6) goto L181;
    L202:
        int r75 = CouponNodeViewStyle67.i;
        Context r76 = getContext();
        Intrinsics.checkNotNullParameter(r76, "context");
        Map r77 = ShoppingAsyncCacheInflater.d;     // Catch: Exception -> L210
        View r78 = ShoppingAsyncCacheInflater.a.a(r76).b("ec_commerce_coupon_node_view_style67", null);     // Catch: Exception -> L210
        if ((r78 instanceof CouponNodeViewStyle67) == true) goto L206;
        r78 = null;
    L206:
        r70 = (CouponNodeViewStyle67) r78;     // Catch: Exception -> L210
        if (r70 != null) goto L220;
        r70 = new CouponNodeViewStyle67(r76, null, 6, 0);     // Catch: Exception -> L210
    L210:
        r70 = new CouponNodeViewStyle67(r76, null, 6, 0);
        goto L220
    L181:
        if (r65 == 7) goto L202;
        if (r65 == 8) goto L193;
        int r79 = CouponNodeViewStyle5.e;
        Context r80 = getContext();
        Intrinsics.checkNotNullParameter(r80, "context");
        Map r81 = ShoppingAsyncCacheInflater.d;     // Catch: Exception -> L192
        View r82 = ShoppingAsyncCacheInflater.a.a(r80).b("ec_commerce_coupon_node_view_style5", null);     // Catch: Exception -> L192
        if ((r82 instanceof CouponNodeViewStyle5) == true) goto L188;
        r82 = null;
    L188:
        r70 = (CouponNodeViewStyle5) r82;     // Catch: Exception -> L192
        if (r70 != null) goto L220;
        r70 = new CouponNodeViewStyle5(r80, null, 6, 0);     // Catch: Exception -> L192
    L192:
        r70 = new CouponNodeViewStyle5(r80, null, 6, 0);
        goto L220
    L193:
        int r84 = CouponNodeViewStyleCouponDivert.d;
        Context r85 = getContext();
        Intrinsics.checkNotNullParameter(r85, "context");
        Map r86 = ShoppingAsyncCacheInflater.d;     // Catch: Exception -> L201
        View r87 = ShoppingAsyncCacheInflater.a.a(r85).b("ec_commerce_coupon_node_view_style_coupon_divert", null);     // Catch: Exception -> L201
        if ((r87 instanceof CouponNodeViewStyleCouponDivert) == true) goto L197;
        r87 = null;
    L197:
        r70 = (CouponNodeViewStyleCouponDivert) r87;     // Catch: Exception -> L201
        if (r70 != null) goto L220;
        r70 = new CouponNodeViewStyleCouponDivert(r85, null, 6, 0);     // Catch: Exception -> L201
    L201:
        r70 = new CouponNodeViewStyleCouponDivert(r85, null, 6, 0);
    L233:
        yd3.l r88 = r5.l();
        if (r88 == null) goto L249;
        int r89 = PanelsNodeView.s;
        Context r90 = getContext();
        Intrinsics.checkNotNullParameter(r90, "context");
        if (ld3.b.a() == true) goto L389;
        PanelsNodeView r91 = new PanelsNodeView(r90, null, 6, 0);
    L246:
        r91.c(r31, new ResourceCardView$bindNativeCard$$inlined$let$lambda$2(this, r31, r11, r5));
        Unit r92 = Unit.INSTANCE;
        c(r91, r88);
        if (r5.getType() != 9) goto L249;
        Integer r94 = 10;
        this.c.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, 5, a(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r94.floatValue(), a(Resources.getSystem()))));
        goto L249
    L389:
        Map r95 = ShoppingAsyncCacheInflater.d;     // Catch: Exception -> L244
        View r96 = ShoppingAsyncCacheInflater.a.a(r90).b("ec_commerce_panels_node_view", null);     // Catch: Exception -> L244
        if ((r96 instanceof PanelsNodeView) == true) goto L240;
        r96 = null;
    L240:
        r91 = (PanelsNodeView) r96;     // Catch: Exception -> L244
        if (r91 != null) goto L246;
        r91 = new PanelsNodeView(r90, null, 6, 0);     // Catch: Exception -> L244
    L244:
        r91 = new PanelsNodeView(r90, null, 6, 0);
    L249:
        yd3.l r97 = r5.r();
        if (r97 == null) goto L322;
        int r98 = WindowNodeView.l;
        Context r99 = getContext();
        Intrinsics.checkNotNullParameter(r99, "context");
        if (ld3.b.a() == false) goto L254;
        Map r100 = ShoppingAsyncCacheInflater.d;
        WindowNodeView r101 = (WindowNodeView) ShoppingAsyncCacheInflater.a.a(r99).b("ec_window_node_view", new n());
    L255:
        Intrinsics.checkNotNullParameter(r31, "anchorInflowFeedItem");
        r101.c = r31;
        yd3.p r2 = r31.i();
        if (r2 == null) goto L258;
        u r102 = r2.r();
    L259:
        r101.a = r102;
        TextView r103 = r101.d;
        StringBuilder r104 = new StringBuilder();
        u r123 = r101.a;
        if (r123 == null) goto L262;
        String r124 = r123.d();
    L263:
        r104.append(r124);
        r104.append("的橱窗");
        r103.setText(r104.toString());
        ECDraweeView r105 = r101.b;
        u r106 = r101.a;
        if (r106 == null) goto L266;
        ECUrlModel r125 = r106.c();
    L267:
        h0.d(r105, r125, new com.bytedance.android.ec.core.imagex.r("ec_goods_feed", "ec_goods_feed_shop_goods"), null, null, null, null, 120);
        r101.b.setAdjustMode(2000);
        u r107 = r101.a;
        if (r107 != null) goto L270;
    L272:
        r101.e.setVisibility(8);
    L273:
        TextView r108 = r101.f;
        u r109 = r101.a;
        if (r109 == null) goto L276;
        String r126 = r109.g();
    L277:
        r108.setText(r126);
        u r127 = r101.a;
        if (r127 == null) goto L321;
        List<Promotion> r128 = r127.f();
        if (r128 == null) goto L321;
        Iterator<T> r129 = r128.iterator();
        int r130 = 0;
    L283:
        if (r129.hasNext() == false) goto L321;
        Object r131 = r129.next();
        int r132 = r130 + 1;
        if (r130 >= 0) goto L287;
        CollectionsKt.throwIndexOverflow();
    L287:
        Promotion r133 = (Promotion) r131;
        if (r130 >= 3) goto L320;
        if (r130 == 0) goto L296;
        if (r130 != 1) goto L292;
        ImageWithPrice r134 = r101.j;
    L297:
        if (r134 == null) goto L299;
        r134.setVisibility(0);
    L299:
        if (r134 == null) goto L318;
        ECDraweeView r135 = r134.a;
        if (r133 == null) goto L309;
        PromotionProductStruct r136 = r133.getPromotionInfo();
        if (r136 == null) goto L309;
        PromotionProductBaseStruct r137 = r136.getBaseInfo();
        if (r137 == null) goto L309;
        List r138 = r137.getImages();
        if (r138 == null) goto L309;
        ECUrlModel r139 = (ECUrlModel) CollectionsKt.firstOrNull(r138);
    L310:
        h0.d(r135, r139, new com.bytedance.android.ec.core.imagex.r("ec_goods_feed", "ec_goods_feed_shop_goods"), null, null, null, null, 120);
        if (r133 == null) goto L318;
        PromotionProductStruct r140 = r133.getPromotionInfo();
        if (r140 == null) goto L318;
        PromotionProductPriceStruct r141 = r140.getProductPrice();
        if (r141 == null) goto L318;
        PanelPriceView.a(r134.b, r141.getPreferentialPrice(), null, null, null, 14);
    L309:
        r139 = null;
    L318:
        if (r134 == null) goto L320;
        r134.setOnClickListener(new s(r130, r133, r101));
        goto L320
    L292:
        if (r130 == 2) goto L294;
        r134 = null;
        goto L297
    L294:
        r134 = r101.k;
        goto L297
    L296:
        r134 = r101.i;
    L320:
        r130 = r132;
    L321:
        r101.g.setOnClickListener(new o(r101, r31));
        r101.d.setOnClickListener(new p(r101, r31));
        r101.b.setOnClickListener(new q(r101, r31));
        r101.h.setOnClickListener(new r(r101, r31));
        FeedProductEventTracker r142 = FeedProductEventTracker.a;
        Context r143 = r101.getContext();
        r142.getClass();
        FeedProductEventTracker.S(r31, r143, null, "product_flow_under", "window");
        Unit r144 = Unit.INSTANCE;
        c(r101, r97);
        goto L322
    L276:
        r126 = null;
        goto L277
    L270:
        if (r107.e() != true) goto L272;
        r101.e.setVisibility(0);
        goto L273
    L266:
        r125 = null;
        goto L267
    L262:
        r124 = null;
        goto L263
    L258:
        r102 = null;
        goto L259
    L254:
        r101 = new WindowNodeView(r99, null, 6, 0);
    L322:
        String r145 = r5.n();
        if (r145 == null) goto L325;
        this.c.setOnClickListener(new j(this, r5, r31, r145));
        return;
    L325:
        this.c.setOnClickListener(new k(r5));
        return;
    L51:
        if (r14.intValue() != 5) goto L53;
    L54:
        setBackgroundColor(ag4.a.b(2131109391));
        ViewExtensionsKt.g(this, 12.0f, 12.0f, 12.0f, 12.0f);
        goto L55
    L47:
        if (r14.intValue() == 4) goto L54;
    L21:
        if (r5.getType() != 7) goto L24;
        this.c.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, 5, a(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, 2, a(Resources.getSystem()))));
        LinearLayout r146 = this.c;
        int r147 = g1.a;
        r146.setDividerDrawable(g1.a.b(getContext(), 2131233543));
        goto L43
    L24:
        if (r5.getType() != 6) goto L37;
        if (r14 != null) goto L28;
    L29:
        if (r14 != null) goto L32;
    L34:
        float r148 = 11;
        this.c.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, r148, a(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r148, a(Resources.getSystem()))));
        LinearLayout r149 = this.c;
        int r150 = g1.a;
        r149.setDividerDrawable(g1.a.b(getContext(), 2131233544));
        goto L43
    L32:
        if (r14.intValue() != 7) goto L34;
    L35:
        this.c.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, 3, a(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, 12, a(Resources.getSystem()))));
        this.c.setShowDividers(0);
        goto L43
    L28:
        if (r14.intValue() == 6) goto L35;
    L37:
        if (r5.getType() != 11) goto L40;
        this.c.setDividerDrawable(null);
        goto L43
    L40:
        if (r5.getType() != 12) goto L42;
        this.c.setDividerDrawable(null);
        this.d.setAdjustMode(2);
        goto L43
    L42:
        float r151 = 16;
        this.c.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, r151, a(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r151, a(Resources.getSystem()))));
        LinearLayout r152 = this.c;
        int r153 = g1.a;
        r152.setDividerDrawable(g1.a.b(getContext(), 2131233544));
    L16:
        r14 = null;
        goto L18
    L407:
        return;
    L326:
        this.b = true;
        this.d.setVisibility(8);
        this.c.removeAllViews();
        this.c.setPadding(0, 0, 0, 0);
        yd3.p r154 = r31.i();
        if (r154 == null) goto L408;
        yd3.l r155 = r154.k();
        if (r155 == null) goto L405;
        LynxNodeView r156 = new LynxNodeView(getContext(), null, 6, 0);
        c(r156, r155);
        Intrinsics.checkNotNullParameter(r31, "anchorInflowFeedItem");
        yd3.p r157 = r31.i();
        if (r157 == null) goto L334;
        yd3.k r158 = r157.k();
    L336:
        if ((!Intrinsics.areEqual(r156.a, r158)) == false) goto L406;
        r156.a = r158;
        ti.l r159 = r156.b;
        if (r159 == null) goto L340;
        r159.release();
    L340:
        r156.removeAllViews();
        HashMap r160 = new HashMap();
        yd3.p r161 = r31.i();
        if (r161 != null) goto L343;
    L373:
        r160.put(SimilarProductParam.ENTER_FROM, "product_flow_page_coupon");
    L374:
        Context r162 = r156.getContext();
        yd3.k r1 = r156.a;
        if (r1 == null) goto L380;
        String r163 = r1.e();
        if (r163 == null) goto L380;
        String r164 = r163;
    L381:
        Pair[] r165 = new Pair[2];
        yd3.k r166 = r156.a;
        if (r166 == null) goto L384;
        String r167 = r166.c();
    L385:
        r165[0] = TuplesKt.to("metaInfo", r167);
        r165[1] = TuplesKt.to("trackerData", r160);
        r156.b = ECLiveHybridUtil.b(r162, r164, MapsKt.mapOf(r165), r156, r156, null, null, false, null, null, false, 4064);
        return;
    L384:
        r167 = null;
    L380:
        r164 = "";
        goto L381
    L343:
        if (r161.getType() != 8) goto L373;
        ProductFeedViewModel r168 = r31.c;
        if (r168 == null) goto L355;
        MutableLiveData<AnchorV3Param> r169 = r168.getAnchorV3Param();
        if (r169 == null) goto L355;
        AnchorV3Param r170 = (AnchorV3Param) r169.getValue();
        if (r170 == null) goto L355;
        String r171 = r170.getEntranceInfo();
        if (r171 == null) goto L355;
        JSONObject r172 = z1.g(r171);
        if (r172 == null) goto L355;
        r172.optString("product_source_page", "");
    L355:
        TrackerProvider.a r173 = TrackerProvider.Companion;
        Context r174 = r156.getContext();
        if (r174 == null) goto L363;
        Activity r175 = d0.a.getActivity(r174);
        if ((r175 instanceof FragmentActivity) == true) goto L361;
        r175 = null;
    L361:
        FragmentActivity r176 = (FragmentActivity) r175;
        if (r176 == null) goto L363;
        Object r177 = ViewModelProviders.of(r176).get(TrackerProvider.class).getTracker();
        if ((r177 instanceof o1) == true) goto L367;
        r177 = null;
    L367:
        o1 r178 = (o1) r177;
    L368:
        if (r178 == null) goto L372;
        HashMap<String, String> r179 = r178.a;
        if (r179 == null) goto L372;
        r160.putAll(r179);
    L372:
        r160.put(SimilarProductParam.ENTER_FROM, "product_flow_page_inflow_card");
        r160.put("enter_from_second", "product_flow_page_inflow_card");
        r160.put("inflow_list_type", "spu");
        r160.put("display_rank", String.valueOf(r31.f));
        r160.put(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page");
        r160.put("entrance_position", "short_video_inflow");
    L363:
        r178 = null;
        goto L368
    L406:
        return;
    L334:
        r158 = null;
        goto L336
    L405:
        return;
    L408:
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void setAnchorInflowFeedItem(rd3.a r1) {
        this.a = r1;
    }

    public final void c(View r4, yd3.l r5) {
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (r5.a() >= this.c.getChildCount()) goto L5;
        this.c.addView(r4, r5.a());
        return;
    L5:
        this.c.addView(r4);
    }

    public ResourceCardView(final Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        LinearLayout r11 = new LinearLayout(r8);
        r11.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r11.setOrientation(1);
        int r12 = g1.a;
        r11.setDividerDrawable(g1.a.b(r8, 2131233544));
        r11.setShowDividers(2);
        Unit r13 = Unit.INSTANCE;
        this.c = r11;
        ECDraweeView r14 = new ECDraweeView(r8, null, 0, 6, null);
        r14.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r14.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r14.setCornerRadius(r14.getDp(8));
        this.d = r14;
        this.e = LazyKt.lazy(new ResourceCardView$lynxClickEventSubscriber$2(this, r8));
        setBackgroundDrawable(null);
        addView(r14);
        addView(r11);
    }

    public static final String b(ResourceCardView r3, rd3.a r4, JSONObject r5) {
        r3.getClass();
        if (r4 == null) goto L7;
        yd3.p r6 = r4.i();
        if (r6 == null) goto L7;
        Integer r7 = Integer.valueOf(r6.getType());
    L8:
        if (r7 != null) goto L11;
    L13:
        if (r7 != null) goto L16;
    L18:
        String r8 = null;
    L19:
        if (r8 != null) goto L23;
        if (r5 == null) goto L22;
        r8 = r5.optString("btm");
        goto L23
    L22:
        r8 = null;
    L23:
        if (r8 != null) goto L25;
        return null;
    L25:
        if (r8.length() != 0) goto L27;
        boolean r9 = true;
    L28:
        if (r9 == false) goto L31;
        return null;
    L31:
        return BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r8, Boolean.FALSE).withView(r3).build());
    L27:
        r9 = false;
        goto L28
    L16:
        if (r7.intValue() != 9) goto L18;
    L17:
        r8 = "a1.b7365.c2695.d3104";
        goto L19
    L11:
        if (r7.intValue() != 7) goto L13;
    L7:
        r7 = null;
        goto L8
    }

    public /* synthetic */ ResourceCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
