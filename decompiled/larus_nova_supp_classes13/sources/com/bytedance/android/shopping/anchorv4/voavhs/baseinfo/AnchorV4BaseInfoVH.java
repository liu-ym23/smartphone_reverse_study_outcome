package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.response.anchorv3.PromotionSubsidizedActivity;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.business.SkuBaseInfoDataModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.PriceElement;
import com.bytedance.android.shopping.anchorv4.log.VisibleLogManager;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4BaseInfoVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/c;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4BaseInfoVH extends AbsFullSpanVH<c> implements com.bytedance.android.shopping.anchorv4.log.d, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public c m;
    public final Lazy n;
    public SkuProductDetailInfo o;
    public final ViewGroup p;
    public final VisibleLogManager q;
    public final FragmentActivity r;
    public final FragmentManager s;
    public final com.bytedance.android.ec.core.async.b t;
    public final AnchorV4VM u;

    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    public final void onDestroy() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        View r2 = null;
        if ((r0 instanceof AnchorV4BaseInfoView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV4BaseInfoView r1 = (AnchorV4BaseInfoView) r0;
        if (r1 == null) goto L8;
        r2 = r1.a(2131363993);
    L8:
        AnchorV4ActivityLayout r3 = (AnchorV4ActivityLayout) r2;
        if (r3 == null) goto L12;
        r3.d.r(g.class);
        return;
    }

    public final void onScan() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        String r2 = null;
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L8;
        ExtensionsKt.f(r1, new AnonymousClass1(this));
    L8:
        View r3 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r3 instanceof ViewGroup) == true) goto L11;
        r3 = null;
    L11:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 == null) goto L14;
        ExtensionsKt.b(r4, this);
    L14:
        AnchorV4BaseInfoMeta r5 = ((c) getItem()).c;
        if (r5 == null) goto L20;
        AnchorV4BaseInfoBusinessMeta r6 = r5.getBusinessMeta();
        if (r6 == null) goto L20;
        r2 = r6.getTaxDesc();
    L20:
        if (com.bytedance.android.shopping.extensions.k.c(r2) == false) goto L25;
        int r7 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r8 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.u);
        if (r8 == null) goto L26;
        AnchorV4TrackerImpl.b(r8, "tax_information_show", false, null, false, null, 28);
        return;
    L26:
        return;
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public static final /* synthetic */ c c4(AnchorV4BaseInfoVH r0) {
        return (c) r0.getItem();
    }

    public final void a4(Object r4) {
        c r5 = (c) r4;
        Intrinsics.checkNotNullParameter(r5, "item");
        this.m = r5;
        this.q.b(this, r5, 0);
        if (this.o != null) goto L9;
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L8;
        ((AnchorV4BaseInfoView) r0).b(r5, this.r, this.u);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.AnchorV4BaseInfoView");
    L9:
        View r1 = ((RecyclerView.ViewHolder) this).itemView;
        if (r1 == null) goto L18;
        ExtensionsKt.e((ViewGroup) r1, this);
        AnchorV4VM r2 = this.u;
        AnchorV4BaseInfoDisplay r6 = r5.b;
        if (r6 == null) goto L14;
        ActivityVO r7 = r6.getActivityInfo();
    L15:
        r2.pollingDynamicForAuction(r7);
        this.u.registerRefreshDetailInfoListener(new AnchorV4BaseInfoVH$listenDetailInfoChange$1(this));
        return;
    L14:
        r7 = null;
        goto L15
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final void d4(AnchorV4BaseInfoVH r36, SkuBaseInfoDataModel r37) {
        if (r37 == null) goto L60;
        View r4 = ((RecyclerView.ViewHolder) r36).itemView;
        if ((r4 instanceof AnchorV4BaseInfoView) == true) goto L7;
        r4 = null;
    L7:
        AnchorV4BaseInfoView r5 = (AnchorV4BaseInfoView) r4;
        if (r5 == null) goto L21;
        ConstraintLayout r6 = r5.getPriceAndSalesLayout();
        if (r6 == null) goto L21;
        if (r6.getVisibility() != 0) goto L21;
        View r7 = ((RecyclerView.ViewHolder) r36).itemView;
        if ((r7 instanceof AnchorV4BaseInfoView) == true) goto L16;
        r7 = null;
    L16:
        AnchorV4BaseInfoView r8 = (AnchorV4BaseInfoView) r7;
        if (r8 == null) goto L21;
        PriceAndSalesLayout r9 = r8.getPriceAndSalesLayout();
        if (r9 == null) goto L21;
        r9.R5(r37.getEffectivePrice(), r37.getDiscountPrice(), r37.getMarketPrice());
    L21:
        View r10 = ((RecyclerView.ViewHolder) r36).itemView;
        if ((r10 instanceof AnchorV4BaseInfoView) == true) goto L24;
        r10 = null;
    L24:
        AnchorV4BaseInfoView r11 = (AnchorV4BaseInfoView) r10;
        if (r11 == null) goto L27;
        View r12 = r11.a(2131363993);
    L28:
        AnchorV4ActivityLayout r13 = (AnchorV4ActivityLayout) r12;
        if (r13 == null) goto L31;
        Integer r14 = Integer.valueOf(r13.getVisibility());
    L33:
        if (r14.intValue() != 0) goto L131;
        View r15 = ((RecyclerView.ViewHolder) r36).itemView;
        if ((r15 instanceof AnchorV4BaseInfoView) == true) goto L37;
        r15 = null;
    L37:
        AnchorV4BaseInfoView r16 = (AnchorV4BaseInfoView) r15;
        if (r16 == null) goto L40;
        View r3 = r16.a(2131363993);
    L41:
        AnchorV4ActivityLayout r17 = (AnchorV4ActivityLayout) r3;
        if (r17 == null) goto L132;
        c r18 = r36.m;
        if (r18 == null) goto L58;
        AnchorV4BaseInfoDisplay r19 = r18.b;
        if (r19 == null) goto L58;
        ActivityVO r20 = r19.getActivityInfo();
        if (r20 == null) goto L58;
        PriceElement r110 = r37.getEffectivePrice();
        PriceElement r111 = r37.getDiscountPrice();
        PriceElement r112 = r37.getMarketPrice();
        AnchorV4VM r21 = r36.u;
        c r2 = r36.m;
        if (r2 == null) goto L56;
        AnchorV4BaseInfoDisplay r22 = r2.b;
        if (r22 == null) goto L56;
        ActivityVO r23 = r22.getActivityInfo();
        if (r23 == null) goto L56;
        PromotionSubsidizedActivity r24 = r23.getSubsidy();
    L57:
        ActivityVO r25 = ActivityVO.copy$default(r20, null, 0, null, null, null, null, null, r110, r112, r111, null, 0, 0, 0, 0, 0, 0, null, null, null, 0, r21.getNewSubsidyPrice(r24, r37), null, false, 14679167, null);
    L59:
        r17.b(r25, r36.r, r36.u);
        return;
    L56:
        r24 = null;
    L58:
        r25 = null;
        goto L59
    L132:
        return;
    L40:
        r3 = null;
        goto L41
    L131:
        return;
    L31:
        r14 = null;
        goto L33
    L27:
        r12 = null;
        goto L28
    L60:
        View r1 = ((RecyclerView.ViewHolder) r36).itemView;
        if ((r1 instanceof AnchorV4BaseInfoView) == true) goto L63;
        r1 = null;
    L63:
        AnchorV4BaseInfoView r26 = (AnchorV4BaseInfoView) r1;
        if (r26 == null) goto L101;
        ConstraintLayout r27 = r26.getPriceAndSalesLayout();
        if (r27 == null) goto L101;
        if (r27.getVisibility() != 0) goto L101;
        View r28 = ((RecyclerView.ViewHolder) r36).itemView;
        if ((r28 instanceof AnchorV4BaseInfoView) == true) goto L72;
        r28 = null;
    L72:
        AnchorV4BaseInfoView r29 = (AnchorV4BaseInfoView) r28;
        if (r29 == null) goto L101;
        PriceAndSalesLayout r30 = r29.getPriceAndSalesLayout();
        if (r30 == null) goto L101;
        c r31 = r36.m;
        if (r31 == null) goto L83;
        AnchorV4BaseInfoDisplay r32 = r31.b;
        if (r32 == null) goto L83;
        BaseInfoVO r33 = r32.getBaseInfo();
        if (r33 == null) goto L83;
        PriceElement r34 = r33.getPrice();
    L84:
        c r35 = r36.m;
        if (r35 == null) goto L91;
        AnchorV4BaseInfoDisplay r38 = r35.b;
        if (r38 == null) goto L91;
        BaseInfoVO r39 = r38.getBaseInfo();
        if (r39 == null) goto L91;
        PriceElement r40 = r39.getDiscountPrice();
    L92:
        c r41 = r36.m;
        if (r41 == null) goto L99;
        AnchorV4BaseInfoDisplay r42 = r41.b;
        if (r42 == null) goto L99;
        BaseInfoVO r43 = r42.getBaseInfo();
        if (r43 == null) goto L99;
        PriceElement r44 = r43.getMarketPrice();
    L100:
        r30.R5(r34, r40, r44);
    L99:
        r44 = null;
    L91:
        r40 = null;
    L83:
        r34 = null;
    L101:
        View r45 = ((RecyclerView.ViewHolder) r36).itemView;
        if ((r45 instanceof AnchorV4BaseInfoView) == true) goto L104;
        r45 = null;
    L104:
        AnchorV4BaseInfoView r46 = (AnchorV4BaseInfoView) r45;
        if (r46 == null) goto L107;
        View r47 = r46.a(2131363993);
    L108:
        AnchorV4ActivityLayout r48 = (AnchorV4ActivityLayout) r47;
        if (r48 == null) goto L111;
        Integer r49 = Integer.valueOf(r48.getVisibility());
    L113:
        if (r49.intValue() != 0) goto L134;
        View r50 = ((RecyclerView.ViewHolder) r36).itemView;
        if ((r50 instanceof AnchorV4BaseInfoView) == true) goto L117;
        r50 = null;
    L117:
        AnchorV4BaseInfoView r51 = (AnchorV4BaseInfoView) r50;
        if (r51 == null) goto L120;
        View r52 = r51.a(2131363993);
    L121:
        AnchorV4ActivityLayout r53 = (AnchorV4ActivityLayout) r52;
        if (r53 == null) goto L135;
        c r54 = r36.m;
        if (r54 == null) goto L128;
        AnchorV4BaseInfoDisplay r55 = r54.b;
        if (r55 == null) goto L128;
        ActivityVO r56 = r55.getActivityInfo();
    L129:
        r53.b(r56, r36.r, r36.u);
        return;
    L128:
        r56 = null;
        goto L129
    L135:
        return;
    L120:
        r52 = null;
        goto L121
    L134:
        return;
    L111:
        r49 = null;
        goto L113
    L107:
        r47 = null;
        goto L108
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r2, Object r3) {
        ((AnchorV4BaseInfoActionHandler) this.n.getValue()).l0(r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r2, Action r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "action");
        ((AnchorV4BaseInfoActionHandler) this.n.getValue()).O0(r2, r3, r4);
    }

    public AnchorV4BaseInfoVH(ViewGroup r6, VisibleLogManager r7, FragmentActivity r8, FragmentManager r9, com.bytedance.android.ec.core.async.b r10, AnchorV4VM r11) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r10, "disposableScope");
        Intrinsics.checkNotNullParameter(r11, "viewModel");
        super(new AnchorV4BaseInfoView(r6.getContext(), null, 6, 0), false);
        this.p = r6;
        this.q = r7;
        this.r = r8;
        this.s = r9;
        this.t = r10;
        this.u = r11;
        this.n = LazyKt.lazy(new AnchorV4BaseInfoVH$actionHandler$2(this));
    }
}
