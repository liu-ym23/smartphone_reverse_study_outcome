package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.ProductPriceInfo;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.business.SkuSpecInfo;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.EventDispatcher;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.HeadLynxAbilityManager;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.y;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.z;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.AnchorV4HeadV2View;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadAdapter;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadAdapter$updateData$action$1;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadRecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.BgDecorLayer;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.HeadVideoAutoPlayController;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/AnchorV4HeadV2VH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/AnchorV4HeadV2VO;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "Lcom/bytedance/android/shopping/anchorv4/vm/h;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "Landroid/content/Context;", "r", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadV2VH extends AbsFullSpanVH<AnchorV4HeadV2VO> implements com.bytedance.android.shopping.anchorv4.log.d, com.bytedance.android.shopping.anchorv4.vm.h, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public static final /* synthetic */ int t = 0;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.e m;
    public final l n;
    public boolean o;
    public final Set<String> p;
    public boolean q;
    public final Context r;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u s;

    public static final class a implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p {
        public String a;
        public final /* synthetic */ AnchorV4HeadV2VH b;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void A(boolean r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void a(boolean r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void c(boolean r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void d(boolean r1, int r2) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void e() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void f(boolean r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void h(boolean r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void i(float r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void j(int r1, ImageInfo r2, boolean r3, int r4) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void m() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void n(int r1, Boolean r2) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void onDestroy() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void onPause() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void onResume() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void s() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void t() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void u() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void v() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void w(int r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void k() {
            this.b.s.a();
        }

        public a(AnchorV4HeadV2VH r1) {
            this.b = r1;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void onPageSelected(int r4) {
            AnchorV4HeadV2VH r0 = this.b;
            int r1 = AnchorV4HeadV2VH.t;
            r0.getClass();
            if (com.bytedance.android.ec.core.opt.ab.c.d() == true) goto L5;
            return;
        L5:
            if (com.bytedance.android.ec.core.abtest.d.r() != 1) goto L36;
            AnchorV4HeadV2VO r2 = r0.m.e;
            if (r2 == null) goto L37;
            List<HeaderContentModel> r3 = r2.getCells();
            if (r3 == null) goto L38;
            HeaderContentModel r5 = (HeaderContentModel) CollectionsKt.getOrNull(r3, r4);
            if (r5 == null) goto L39;
            HeaderMediaModel r6 = r5.getMedia();
            if (r6 != null) goto L15;
            return;
        L15:
            if (r6.getPreviewType() == 1) goto L17;
            return;
        L17:
            if (r0.p.contains(String.valueOf(r4)) == true) goto L42;
            r0.p.add(String.valueOf(r4));
            com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r7 = r0.m.g.f(r4);
            if (r7 == null) goto L21;
            com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b.d(r7);
        L21:
            com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r8 = r0.m.g.f(r4);
            if (r8 == null) goto L24;
            r8.i();
        L24:
            com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r9 = r0.m.g.f(r4);
            if (r9 == null) goto L27;
            r9.g();
        L27:
            CommonMeta r10 = r0.s.r0();
            if (r10 == null) goto L43;
            String r11 = r10.getProductId();
            if (r11 == null) goto L44;
            u83.a r12 = g33.b.b.j();
            if (r12 == null) goto L45;
            r12.d(r11, AnchorV4HeadV2VH$preloadKolIfNeed$1$1$1.INSTANCE);
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L42:
            return;
        L39:
            return;
        L38:
            return;
        L37:
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void p(String r19) {
            if (Intrinsics.areEqual(this.a, r19) == false) goto L5;
            return;
        L5:
            this.a = r19;
            List<SkuSpecInfo> r2 = this.b.s.V().v();
            if (r2 == null) goto L25;
            int r3 = r2.size();
            SkuRestoreState r4 = this.b.s.V().w();
            if (r4 == null) goto L17;
            x r5 = this.b.s.V();
            if (r4.getSelectSkuKeys().length != 0) goto L12;
            boolean r6 = true;
        L14:
            if ((!r6) == false) goto L16;
            r4.getSelectSkuKeys()[0] = r19;
        L16:
            Unit r1 = Unit.INSTANCE;
            r5.q(r4, true);
            goto L25
        L12:
            r6 = false;
            goto L14
        L17:
            x r7 = this.b.s.V();
            SkuRestoreState r8 = new SkuRestoreState(r3);
            if (r8.getSelectSkuKeys().length != 0) goto L20;
            boolean r9 = true;
        L22:
            if ((!r9) == false) goto L24;
            r8.getSelectSkuKeys()[0] = r19;
        L24:
            Unit r10 = Unit.INSTANCE;
            r7.q(r8, true);
            goto L25
        L20:
            r9 = false;
        L25:
            this.b.s.V().l(new SkuProductDetailInfo(null, new ProductPriceInfo(null, null, new PromotionDiscountPrice(null, null, null, null, 15, null), null, null, 24, null), null, null, true, null, false, 108, null));
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void q(AnchorV4HeadV2VO r2) {
            Intrinsics.checkNotNullParameter(r2, "headVo");
            Intrinsics.checkNotNullParameter(r2, "headVo");
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r1, Action r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r2, "action");
    }

    public final void a2(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r1, Object r2) {
    }

    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    public final void Z3() {
        if (this.q == false) goto L5;
        return;
    L5:
        this.q = true;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.e r0 = this.m;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u r1 = this.s;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.a = r1;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u r2 = this.s;
        y r3 = this.m.g;
        r3.getClass();
        r2.p0(new z(r3));
        View r4 = ((RecyclerView.ViewHolder) this).itemView;
        if (r4 == null) goto L18;
        i83.c r5 = (i83.c) r4;
        r5.setHeadAbility(this.m);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u r6 = this.s;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s r7 = r5.getHeadAbility();
        RecyclerView r8 = null;
        if (r7 == null) goto L10;
        RecyclerView r9 = r7.getRecyclerView();
    L12:
        if ((r9 instanceof HeadRecyclerView) == false) goto L15;
        r8 = r9;
    L15:
        r6.X((HeadRecyclerView) r8);
        return;
    L10:
        r9 = null;
        goto L12
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.AnchorV4HeadV2ViewWrapper");
    }

    public final void onCreate() {
        this.s.T(this);
        this.s.V().u(new AnonymousClass1(this));
        HeadLynxAbilityManager r0 = this.m.j;
        r0.getClass();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.j r1 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.j(r0);
        r0.d.rR().Z(r1, false);
        this.m.f.x(new a(this));
    }

    public final void onDestroy() {
        this.m.f.onDestroy();
    }

    public final void onScan() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L7;
        ExtensionsKt.b((ViewGroup) r0, this);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final Context getContext() {
        return this.r;
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void S2(float r2) {
        this.m.f.i(r2);
    }

    public final void a4(Object r10) {
        AnchorV4HeadV2VO r11 = (AnchorV4HeadV2VO) r10;
        Intrinsics.checkNotNullParameter(r11, "item");
        boolean r0 = e.a;
        e.a = r11.getEnableVideoCollection();
        e.b = r11.getEnableAIVideo();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.e r1 = this.m;
        r1.e = r11;
        r1.f.q(r11);
        View r2 = ((RecyclerView.ViewHolder) this).itemView;
        if (r2 == null) goto L144;
        AnchorV4HeadV2View r3 = ((i83.c) r2).getHeadView();
        if (r3 == null) goto L116;
        List<HeaderContentModel> r4 = r11.getCells();
        if (r4 == null) goto L9;
        int r5 = r4.size();
    L11:
        if (r5 <= 0) goto L40;
        List<HeaderContentModel> r6 = r11.getCells();
        if (r6 == null) goto L17;
        HeaderContentModel r7 = (HeaderContentModel) CollectionsKt.getOrNull(r6, 0);
        if (r7 == null) goto L17;
        r r8 = r7.getMultiPreview();
    L18:
        if (r8 == null) goto L40;
        HeaderContentModel r9 = (HeaderContentModel) CollectionsKt.getOrNull(r11.getCells(), 0);
        if (r9 == null) goto L26;
        r r12 = r9.getMultiPreview();
        if (r12 == null) goto L26;
        List<k> r13 = r12.a();
        if (r13 == null) goto L26;
        int r14 = r13.size();
    L27:
        if (r14 != 2) goto L29;
        r3.k.Em(2);
    L44:
        Integer r15 = r3.k.Lz();
        if (r15 == null) goto L50;
        if (r15.intValue() != 0) goto L50;
    L63:
        if (r3.k.rR().S() == true) goto L65;
    L67:
        final HeadAdapter r16 = r3.e;
        final List<HeaderContentModel> r17 = r11.getCells();
        final ScrollContainerFooter r18 = r11.getFooter();
        r16.getClass();
        if (PdpPerfOpt.b().h() == false) goto L70;
        Runnable r19 = new HeadAdapter$updateData$action$1(r16, r17, r18);
    L72:
        if (r16.e.isComputingLayout() == false) goto L74;
        Lazy r20 = UIUtils.a;
        UIUtils.c().post(new i83.d(r16, r19));
    L76:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s.a.b(r3.k, null, 3) == false) goto L78;
    L81:
        BgDecorLayer r21 = r3.i;
        if (r21 == null) goto L84;
        HeadRecyclerView r22 = r3.b;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r21, "layer");
        r22.i = r21;
    L84:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.h r23 = r3.f;
        List<HeaderPendantModel> r24 = r11.getPendants();
        if (r24 == null) goto L98;
        r23.getClass();
        ArrayList r25 = new ArrayList();
        Iterator<T> r26 = r24.iterator();
    L88:
        if (r26.hasNext() == false) goto L99;
        Object r27 = r26.next();
        ConfigMode r28 = ((HeaderPendantModel) r27).getConfig();
        if (r28 != null) goto L92;
    L95:
        boolean r29 = true;
    L96:
        if (r29 == false) goto L88;
        r25.add(r27);
        goto L88
    L92:
        if (r28.getDisableLoad() != true) goto L95;
        r29 = false;
    L99:
        r23.b(r25);
        ViewGroup.LayoutParams r30 = r3.getLayoutParams();
        if ((r30 instanceof ViewGroup.MarginLayoutParams) == true) goto L102;
        r30 = null;
    L102:
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        if (r31 == null) goto L105;
        int r32 = r31.bottomMargin;
    L106:
        if (r32 <= 0) goto L116;
        int r33 = k83.b.a;
        int r34 = k83.b.b(r3.k);
        if (r34 <= 0) goto L116;
        if (r34 == r32) goto L116;
        ViewGroup.LayoutParams r35 = r3.getLayoutParams();
        if ((r35 instanceof ViewGroup.MarginLayoutParams) == true) goto L113;
        r35 = null;
    L113:
        ViewGroup.MarginLayoutParams r36 = (ViewGroup.MarginLayoutParams) r35;
        if (r36 == null) goto L116;
        r36.bottomMargin = r34;
        r3.setLayoutParams(r36);
        goto L116
    L105:
        r32 = 0;
        goto L106
    L98:
        r25 = null;
        goto L99
    L78:
        if (r3.k.Mm() == false) goto L84;
        if (ECSettingKeys.A0().f() != 0) goto L84;
    L74:
        r19.run();
        goto L76
    L70:
        r19 = new i83.e(r16, r17, r18);
        goto L72
    L65:
        if (r3.j == true) goto L67;
        r3.j = true;
        r3.a.c = null;
    L50:
        if (r3.k.Cb() != null) goto L63;
        VideoModel r37 = AnchorV4HeadV2VO.getVideoData$default(r11, 0, null, 2, null);
        if (r37 != null) goto L54;
    L55:
        if (r37 != null) goto L57;
    L61:
        r3.k.tB(Boolean.FALSE);
        goto L63
    L57:
        if (r37.getAutoPlayForBiz() != true) goto L61;
        Lazy r38 = HeadVideoAutoPlayController.a;
        if (HeadVideoAutoPlayController.b(r3.k) == false) goto L61;
    L60:
        r3.k.tB(Boolean.TRUE);
        goto L63
    L54:
        if (r37.getAutoPlay() == true) goto L60;
    L29:
        HeaderContentModel r39 = (HeaderContentModel) CollectionsKt.getOrNull(r11.getCells(), 0);
        if (r39 == null) goto L36;
        r r40 = r39.getMultiPreview();
        if (r40 == null) goto L36;
        List<k> r41 = r40.a();
        if (r41 == null) goto L36;
        int r42 = r41.size();
    L37:
        if (r42 != 3) goto L44;
        r3.k.Em(3);
    L36:
        r42 = 0;
    L26:
        r14 = 0;
    L17:
        r8 = null;
    L40:
        if (r11.getContainerConfig() == null) goto L44;
        if (r11.getContainerConfig().a() != 1) goto L44;
        r3.k.Em(1);
        goto L44
    L9:
        r5 = 0;
    L116:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u r43 = this.s;
        if (r11.getSizeType() != 1) goto L119;
        boolean r44 = true;
    L120:
        r43.c0(r44);
        List<HeaderContentModel> r45 = r11.getCells();
        if (r45 == null) goto L127;
        HeaderContentModel r46 = (HeaderContentModel) CollectionsKt.firstOrNull(r45);
        if (r46 == null) goto L127;
        HeaderMediaModel r47 = r46.getMedia();
        if (r47 == null) goto L127;
        ECUrlModel r48 = HeaderMediaModel.getImageUrl$default(r47, false, 1, null);
    L128:
        if (r48 != null) goto L130;
        Lazy r49 = UIUtils.a;
        UIUtils.c().postDelayed(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.a(this), 300);
    L130:
        this.s.j0().y(this, r11, 0);
        if (this.o == false) goto L150;
        AnchorV4HeadV2VO r110 = this.m.e;
        if (r110 == null) goto L137;
        List<HeaderContentModel> r111 = r110.getCells();
        if (r111 == null) goto L137;
        int r112 = r111.size();
    L138:
        if (r112 <= 0) goto L151;
        this.o = false;
        if (this.m.bz() == this.m.getCurrentPosition()) goto L152;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.e r113 = this.m;
        r113.f.n(r113.bz(), null);
        return;
    L152:
        return;
    L151:
        return;
    L137:
        r112 = 0;
        goto L138
    L150:
        return;
    L127:
        r48 = null;
        goto L128
    L119:
        r44 = false;
        goto L120
    L144:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.AnchorV4HeadV2ViewWrapper");
    }

    public final void b2(boolean r2) {
        this.m.f.A(r2);
    }

    public AnchorV4HeadV2VH(Context r3, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(new i83.c(r3), false);
        this.r = r3;
        this.s = r4;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.e r5 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.e(new EventDispatcher(), r3, ((RecyclerView.ViewHolder) this).itemView);
        this.m = r5;
        this.n = new l(r5);
        this.o = true;
        this.p = new LinkedHashSet();
    }
}
