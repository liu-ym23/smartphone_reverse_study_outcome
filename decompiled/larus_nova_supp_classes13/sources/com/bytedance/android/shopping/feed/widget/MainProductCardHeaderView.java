package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.widget.RoundedLinearLayout;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.CouponUrgeInfo;
import com.bytedance.android.ec.model.response.anchorv3.InnerFlowCouponExtra;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLampStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper;
import com.bytedance.common.utility.UIUtils;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/MainProductCardHeaderView;", "Lcom/bytedance/android/shopping/feed/widget/BaseCardHeaderView;", "Lcom/bytedance/android/ec/opt/asyncInflate/ICachedAsyncInflater$a;", "", "getLayoutResId", "", "visible", "", "setProductAttentionVisible", "", "factor", "setInfoViewTransitionAlpha", "s", "Z", "getNeedShowProductAttention", "()Z", "setNeedShowProductAttention", "(Z)V", "needShowProductAttention", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainProductCardHeaderView extends BaseCardHeaderView implements ICachedAsyncInflater.a {
    public final int A;
    public final FrameLayout n;
    public List<PromotionLampStruct> o;
    public boolean p;
    public final View q;
    public final View r;
    public boolean s;
    public final RoundedLinearLayout t;
    public final TextView u;
    public int v;
    public final View w;
    public final ECViewFlipper x;
    public final ViewGroup y;
    public n83.j z;

    public MainProductCardHeaderView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MainProductCardHeaderView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardHeaderView
    public int getLayoutResId() {
        return 2131564843;
    }

    public final void recycle() {
        this.p = true;
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardHeaderView
    public final void c() {
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        Context r1 = getContext();
        r0.getClass();
        FeedProductEventTracker.A(r1, "click_inflow_similar_tab", false, "product_image");
    }

    public final void d() {
        int r0 = ld3.c.a;
        if (this.A == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L22;
        ECViewFlipper r2 = this.x;
        if (r2 == null) goto L10;
        r2.stopFlipping();
    L10:
        ECViewFlipper r3 = this.x;
        if (r3 == null) goto L13;
        r3.setVisibility(8);
    L13:
        View r4 = this.w;
        if (r4 == null) goto L16;
        r4.setVisibility(8);
    L16:
        RoundedLinearLayout r5 = this.t;
        if (r5 == null) goto L23;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L24;
        r6.width = -2;
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final boolean getNeedShowProductAttention() {
        return this.s;
    }

    public final void setInfoViewTransitionAlpha(float r3) {
        if (r3 < 0) goto L16;
        float r0 = 1;
        if (r3 > r0) goto L19;
        float r1 = r0 - r3;
        this.n.setAlpha(r1);
        this.y.setAlpha(r1);
        if (this.s == true) goto L17;
        View r4 = this.q;
        if (r4 == null) goto L12;
        r4.setAlpha(r1);
    L12:
        RoundedLinearLayout r5 = this.t;
        if (r5 == null) goto L18;
        r5.setAlpha(r1);
        return;
    L18:
        return;
    L17:
        return;
    L19:
        return;
    }

    public final void setNeedShowProductAttention(boolean r1) {
        this.s = r1;
    }

    public final void setProductAttentionVisible(boolean r2) {
        this.s = r2;
        if (r2 == false) goto L6;
        this.n.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardHeaderView
    public final void a(v r13, final Function3<? super View, ? super String, ? super String, Unit> r14) {
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r14, "detailOnClickListener");
        super.a(r13, r14);
        AnchorV3Param r1 = null;
        if (this.p == false) goto L5;
    L17:
        rd3.a r0 = r13.b;
        if (r0 == null) goto L29;
        Promotion r2 = r0.f();
        if (r2 == null) goto L29;
        PromotionProductStruct r3 = r2.getPromotionInfo();
        if (r3 == null) goto L29;
        if (r3.isApiBack() == true) goto L29;
        RoundedLinearLayout r15 = this.t;
        if (r15 == null) goto L266;
        r15.setVisibility(8);
        return;
    L266:
        return;
    L29:
        this.p = false;
        rd3.a r4 = r13.b;
        if (r4 == null) goto L41;
        Promotion r5 = r4.f();
        if (r5 == null) goto L41;
        PromotionProductStruct r6 = r5.getPromotionInfo();
        if (r6 == null) goto L41;
        PromotionProductExtraStruct r7 = r6.getExtraInfo();
        if (r7 == null) goto L41;
        List r8 = r7.getLamps();
        if (r8 == null) goto L41;
        if (r8.isEmpty() != true) goto L41;
    L47:
        this.n.setVisibility(8);
    L76:
        ProductFeedViewModel r16 = getViewModel();
        if (r16 == null) goto L88;
        AnchorV3Param r17 = r16.m907getAnchorV3Param();
        if (r17 == null) goto L88;
        if (r17.isFullScreen() != true) goto L88;
        View r18 = this.q;
        if (r18 == null) goto L85;
        r18.setVisibility(8);
    L85:
        RoundedLinearLayout r19 = this.t;
        if (r19 == null) goto L153;
        r19.setVisibility(8);
    L153:
        ProductFeedViewModel r110 = getViewModel();
        if (r110 == null) goto L193;
        rd3.a r9 = r13.b;
        if (r9 == null) goto L160;
        Promotion r10 = r9.f();
        if (r10 == null) goto L160;
        PromotionProductStruct r11 = r10.getPromotionInfo();
    L161:
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        InnerFlowPageStyleDTO r12 = r110.getInnerFlowPageStyle();
        if (r12 == null) goto L166;
        PageStyle r20 = r12.getPageStyle();
        if (r20 == null) goto L166;
        Integer r21 = r20.getSameProductSwitch();
    L167:
        if (r21 != null) goto L170;
    L171:
        if (r21 != null) goto L174;
    L176:
        this.r.setVisibility(8);
        goto L193
    L174:
        if (r21.intValue() != 3) goto L176;
    L177:
        this.r.setVisibility(0);
        HashSet<String> r22 = r110.getShowedSimilarEntranceProductId();
        if (r11 == null) goto L182;
        PromotionProductBaseStruct r111 = r11.getBaseInfo();
        if (r111 == null) goto L182;
        String r112 = r111.getProductId();
    L184:
        if (CollectionsKt.contains(r22, r112) == true) goto L192;
        if (r11 == null) goto L191;
        PromotionProductBaseStruct r23 = r11.getBaseInfo();
        if (r23 == null) goto L191;
        String r24 = r23.getProductId();
        if (r24 == null) goto L191;
        r110.getShowedSimilarEntranceProductId().add(r24);
    L191:
        FeedProductEventTracker r25 = FeedProductEventTracker.a;
        Context r113 = getContext();
        r25.getClass();
        FeedProductEventTracker.A(r113, "show_inflow_similar_tab", false, null);
    L192:
        this.r.setOnClickListener(new q(this, r110, r11));
    L182:
        r112 = null;
        goto L184
    L170:
        if (r21.intValue() == 1) goto L177;
    L166:
        r21 = null;
    L160:
        r11 = null;
    L193:
        int r114 = ECSdk.a;
        IEShoppingService r115 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r115 != null) goto L196;
    L244:
        ProductFeedViewModel r116 = getViewModel();
        if (r116 == null) goto L264;
        InnerFlowPageStyleDTO r117 = r116.getInnerFlowPageStyle();
        if (r117 == null) goto L264;
        PageStyle r118 = r117.getPageStyle();
        if (r118 == null) goto L264;
        if (r118.getSearchPdtSwitch() != 1) goto L264;
        ProductFeedViewModel r119 = getViewModel();
        if (r119 == null) goto L264;
        InnerFlowPageStyleDTO r120 = r119.getInnerFlowPageStyle();
        if (r120 == null) goto L264;
        PageStyle r121 = r120.getPageStyle();
        if (r121 == null) goto L264;
        if (r121.getSearchPdtStyle() != 2) goto L264;
        ProductFeedViewModel r122 = getViewModel();
        if (r122 == null) goto L263;
        rd3.a r123 = r13.b;
        Intrinsics.checkNotNullParameter(r122, "viewModel");
        super.b(r122, r123);
        FeedProductEventTracker r124 = FeedProductEventTracker.a;
        Context r125 = getContext();
        r124.getClass();
        FeedProductEventTracker.A(r125, "show_inflow_similar_tab", false, "product_image");
        getNewSameProductEntranceView().setVisibility(0);
        return;
    L263:
        getNewSameProductEntranceView().setVisibility(8);
        return;
    L264:
        getNewSameProductEntranceView().setVisibility(8);
        return;
    L196:
        if (r115.shouldShowSaasCouponUrge() != true) goto L244;
        ProductFeedViewModel r126 = getViewModel();
        if (r126 == null) goto L203;
        AnchorV3Param r127 = r126.m907getAnchorV3Param();
        if (r127 == null) goto L203;
        if (r127.isFullScreen() == true) goto L244;
    L203:
        rd3.a r128 = r13.b;
        if (r128 == null) goto L212;
        Promotion r129 = r128.f();
        if (r129 == null) goto L212;
        PromotionProductStruct r130 = r129.getPromotionInfo();
        if (r130 == null) goto L212;
        PromotionProductPrivilegesStruct r131 = r130.getPrivilegeInfo();
        if (r131 == null) goto L212;
        PromotionProductCouponsStruct r132 = r131.getCoupons();
    L213:
        Context r26 = getContext();
        if (r132 == null) goto L218;
        InnerFlowCouponExtra r27 = r132.getInnerFlowCouponExtra();
        if (r27 == null) goto L218;
        CouponUrgeInfo r28 = r27.getCouponUrgeInfo();
    L219:
        if (r28 == null) goto L243;
        this.y.setVisibility(0);
        if (this.z != null) goto L229;
        IEShoppingService r29 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r29 == null) goto L225;
        n83.j r30 = r29.newCouponUrgeView(r26, 1);
    L226:
        this.z = r30;
        if (r30 == null) goto L229;
        this.y.addView(r30.i(), new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(26)));
        goto L229
    L225:
        r30 = null;
    L229:
        n83.j r31 = this.z;
        if (r31 == null) goto L236;
        ProductFeedViewModel r32 = getViewModel();
        if (r32 == null) goto L234;
        r1 = r32.m907getAnchorV3Param();
    L234:
        r31.a(r132, r1);
    L236:
        if (this.n.getVisibility() != 0) goto L238;
        boolean r133 = true;
    L239:
        if (r133 == false) goto L244;
        this.n.setVisibility(8);
        n83.j r134 = this.z;
        if (r134 == null) goto L244;
        r134.setCountDownFinishCallback(new MainProductCardHeaderView$bindCouponUrge$2(this));
        goto L244
    L238:
        r133 = false;
        goto L239
    L243:
        this.y.setVisibility(8);
    L218:
        r28 = null;
    L212:
        r132 = null;
    L88:
        int r135 = ld3.c.a;
        if (this.A == 0) goto L91;
        boolean r136 = true;
    L92:
        if (r136 == false) goto L147;
        RoundedLinearLayout r137 = this.t;
        if (r137 == null) goto L96;
        r137.setVisibility(0);
    L96:
        View r138 = this.q;
        if (r138 == null) goto L100;
        r138.setVisibility(8);
    L100:
        if (this.A == 2) goto L136;
        rd3.a r139 = r13.b;
        if (r139 == null) goto L110;
        Promotion r140 = r139.f();
        if (r140 == null) goto L110;
        PromotionProductStruct r141 = r140.getPromotionInfo();
        if (r141 == null) goto L110;
        PromotionProductExtraStruct r142 = r141.getExtraInfo();
        if (r142 == null) goto L110;
        List r143 = r142.getLamps();
    L111:
        List r144 = r143;
        if (r144 != null) goto L114;
    L117:
        boolean r145 = true;
    L118:
        if (r145 == true) goto L136;
        if (this.s == true) goto L136;
        View r146 = this.w;
        if (r146 == null) goto L125;
        r146.setVisibility(0);
    L125:
        ECViewFlipper r147 = this.x;
        if (r147 == null) goto L128;
        r147.setVisibility(0);
    L128:
        int r148 = (UIUtils.getScreenWidth(getContext()) - com.bytedance.android.shopping.extensions.b.b(48)) - com.bytedance.android.shopping.extensions.b.b(92);
        RoundedLinearLayout r33 = this.t;
        if (r33 == null) goto L133;
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
        if (r34 == null) goto L133;
        r34.width = Math.min(r148, com.bytedance.android.shopping.extensions.b.b(234));
    L133:
        this.v = 12;
        TextView r35 = this.u;
        if (r35 == null) goto L153;
        r35.setTextSize(1, 12);
        goto L153
    L114:
        if (r144.isEmpty() == true) goto L117;
        r145 = false;
    L110:
        r143 = null;
    L136:
        View r149 = this.w;
        if (r149 == null) goto L139;
        r149.setVisibility(8);
    L139:
        ECViewFlipper r150 = this.x;
        if (r150 == null) goto L142;
        r150.setVisibility(8);
    L142:
        RoundedLinearLayout r151 = this.t;
        if (r151 == null) goto L153;
        ViewGroup.LayoutParams r152 = r151.getLayoutParams();
        if (r152 == null) goto L153;
        r152.width = -2;
        goto L153
    L147:
        View r153 = this.q;
        if (r153 == null) goto L150;
        r153.setVisibility(0);
    L150:
        RoundedLinearLayout r154 = this.t;
        if (r154 == null) goto L153;
        r154.setVisibility(8);
        goto L153
    L91:
        r136 = false;
    L41:
        ProductFeedViewModel r36 = getViewModel();
        if (r36 == null) goto L48;
        AnchorV3Param r37 = r36.m907getAnchorV3Param();
        if (r37 == null) goto L48;
        if (r37.isFullScreen() == true) goto L47;
    L48:
        int r38 = ld3.c.a;
        rd3.a r39 = r13.b;
        if (r39 == null) goto L53;
        Promotion r40 = r39.f();
        if (r40 == null) goto L53;
        final PromotionProductStruct r41 = r40.getPromotionInfo();
    L54:
        if (r41 == null) goto L58;
        PromotionProductExtraStruct r42 = r41.getExtraInfo();
        if (r42 == null) goto L58;
        List<PromotionLampStruct> r43 = r42.getLamps();
    L59:
        this.o = r43;
        if (this.A == 0) goto L62;
        boolean r44 = true;
    L63:
        if (r44 == false) goto L65;
        ECViewFlipper r45 = this.x;
    L66:
        if (r45 == null) goto L68;
        r45.scrollToPosition(0);
    L68:
        if (r45 == null) goto L70;
        r45.setInterval(3000);
    L70:
        if (r45 == null) goto L74;
        RecyclerView.Adapter r46 = r45.getAdapter();
        if (r46 == null) goto L74;
        r46.notifyDataSetChanged();
    L74:
        if (r45 == null) goto L76;
        r45.setOnClickListener(new MainProductCardHeaderView$bindLampViewNew$1(this, r41, r14));
        goto L76
    L65:
        r45 = null;
        goto L66
    L62:
        r44 = false;
    L58:
        r43 = null;
    L53:
        r41 = null;
        goto L54
    L5:
        if (this.o != null) goto L76;
        rd3.a r47 = r13.b;
        if (r47 == null) goto L15;
        Promotion r48 = r47.f();
        if (r48 == null) goto L15;
        PromotionProductStruct r49 = r48.getPromotionInfo();
        if (r49 == null) goto L15;
        PromotionProductExtraStruct r50 = r49.getExtraInfo();
        if (r50 == null) goto L15;
        List r51 = r50.getLamps();
    L16:
        if (r51 == null) goto L76;
    L15:
        r51 = null;
        goto L16
    }

    public MainProductCardHeaderView(final Context r5, final AttributeSet r6, final int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        FrameLayout r0 = (FrameLayout) findViewById(2131392512);
        this.n = r0;
        this.p = true;
        this.q = findViewById(2131383104);
        this.r = findViewById(2131379460);
        this.v = 13;
        this.y = (ViewGroup) findViewById(2131368122);
        RoundedLinearLayout r3 = findViewById(2131380870);
        this.t = r3;
        if (r3 == null) goto L5;
        r3.setRadius(com.bytedance.android.shopping.extensions.b.b(13));
    L5:
        this.w = findViewById(2131380869);
        this.u = (TextView) findViewById(2131380758);
        ECViewFlipper r2 = findViewById(2131380874);
        this.x = r2;
        int r4 = ld3.c.a;
        if (r2 == null) goto L8;
        r2.setInfinity(false);
        r2.setNeedKeepLastView(false);
        r2.setEndCallback(new MainProductCardHeaderView$initNewStyleFlipper$$inlined$apply$lambda$1(this));
    L8:
        if (r2 == null) goto L10;
        r2.setViewFlipperAdapter(new MainProductCardHeaderView$initNewStyleFlipper$2(this, r5, r6, r7));
    L10:
        r0.setVisibility(8);
        this.A = 1;
    }

    public /* synthetic */ MainProductCardHeaderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
