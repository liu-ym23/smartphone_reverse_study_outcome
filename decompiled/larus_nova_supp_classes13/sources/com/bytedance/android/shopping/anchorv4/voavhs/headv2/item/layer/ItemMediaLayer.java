package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.voavhs.blur.BlurImageView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.k;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ItemMediaLayer extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.a<HeaderMediaModel> implements p {
    public Integer a;
    public final ViewGroup b;
    public final ECDraweeView c;
    public int d;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j e;
    public k f;
    public BlurImageView g;
    public ECDraweeView h;
    public j i;
    public Integer j;
    public final s k;
    public final boolean l;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ ItemMediaLayer a;

        public a(ItemMediaLayer r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            this.a.k.eh().x(this.a);
            this.a.E();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            this.a.k.eh().z(this.a);
        }
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
    public final void j(int r1, ImageInfo r2, boolean r3, int r4) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void k() {
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
    public final void onPageSelected(int r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onResume() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void p(String r1) {
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

    public final void E() {
        int r1 = 0;
        boolean r2 = true;
        if (this.d == 1) goto L6;
        r2 = false;
    L6:
        if (r2 == false) goto L23;
        int r0 = this.k.FB();
        Object r3 = this.b.getParent();
        ViewGroup.LayoutParams r5 = null;
        if ((r3 instanceof View) == true) goto L10;
        r3 = null;
    L10:
        View r4 = (View) r3;
        if (r4 == null) goto L13;
        ViewGroup.LayoutParams r6 = r4.getLayoutParams();
    L15:
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r5 = r6;
    L18:
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r5;
        if (r7 == null) goto L21;
        int r8 = r7.topMargin;
    L22:
        int r9 = r0 + r8;
    L24:
        if (r2 == false) goto L26;
        int r10 = k83.b.a;
        r1 = k83.b.b(this.k);
    L26:
        D(this.c, r9, r1);
        ECDraweeView r11 = this.h;
        if (r11 == null) goto L30;
        D(r11, r9, r1);
        return;
    L30:
        return;
    L21:
        r8 = 0;
        goto L22
    L13:
        r6 = null;
        goto L15
    L23:
        r9 = 0;
        goto L24
    }

    public final void y() {
        com.bytedance.android.shopping.anchorv4.perf.monitor.c r0 = this.k.rR().d0();
        if (r0 == null) goto L15;
        int r1 = r0.g;
        if (r1 != 1) goto L10;
        com.bytedance.android.shopping.anchorv4.perf.monitor.i r2 = r0.a;
        if (r2.u != null) goto L16;
        r2.u = Long.valueOf(System.currentTimeMillis());
        return;
    L16:
        return;
    L10:
        if (r1 != 2) goto L18;
        com.bytedance.android.shopping.anchorv4.perf.monitor.i r3 = r0.a;
        if (r3.v != null) goto L19;
        r3.v = Long.valueOf(System.currentTimeMillis());
        return;
    L19:
        return;
    L18:
        return;
    }

    public final View r() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L9;
        k r0 = this.f;
        if (r0 == null) goto L16;
        View r1 = r0.getPreviewStartView();
        if (r1 == null) goto L16;
        return r1;
    L16:
        return this.c;
    L9:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j r2 = this.e;
        if (r2 == null) goto L14;
        View r3 = r2.getPreviewStartView();
        if (r3 == null) goto L14;
        return r3;
    L14:
        return this.c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r1) {
        E();
    }

    public final void C(boolean r2) {
        if (r2 == false) goto L4;
        float r3 = 1.0f;
    L5:
        this.c.setAlpha(r3);
        ECDraweeView r0 = this.h;
        if (r0 == null) goto L9;
        r0.setAlpha(r3);
        return;
    L9:
        return;
    L4:
        r3 = 0.0f;
        goto L5
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(float r1) {
        E();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r2) {
        Intrinsics.checkNotNullParameter(r2, "headVo");
        E();
    }

    public ItemMediaLayer(s r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "headAbility");
        this.k = r9;
        this.l = r10;
        FrameLayout r11 = new FrameLayout(r9.getContext());
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ECDraweeView r0 = new ECDraweeView(r11.getContext(), null, 0, 6, null);
        this.c = r0;
        if (r9.XU() < 2) goto L7;
        GenericDraweeHierarchy r12 = r0.getHierarchy();
        if (r12 == null) goto L10;
        r12.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    L10:
        Unit r13 = Unit.INSTANCE;
        r11.addView(r0, -1, -1);
        this.b = r11;
        r11.addOnAttachStateChangeListener(new a(this));
        Lazy r14 = PdpAB.a;
        if (PdpAB.c != 1) goto L14;
        r11.addOnAttachStateChangeListener(new AnonymousClass3());
        return;
    L14:
        return;
    L7:
        GenericDraweeHierarchy r15 = r0.getHierarchy();
        if (r15 == null) goto L10;
        r15.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        goto L10
    }

    public static void D(ECDraweeView r3, int r4, int r5) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        int r6 = -r4;
        int r7 = -r5;
        if (r1.topMargin == r6) goto L11;
    L17:
        r1.width = -1;
        r1.height = -1;
        r1.topMargin = r6;
        r1.bottomMargin = r7;
        r3.setLayoutParams(r1);
        return;
    L11:
        if (r1.bottomMargin != r7) goto L17;
        if (r1.width != (-1)) goto L17;
        if (r1.height != (-1)) goto L17;
    }

    public final void B(HeaderMediaModel r46, final int r47, final Integer r48) {
        Intrinsics.checkNotNullParameter(r46, "data");
        this.a = Integer.valueOf(r47);
        this.d = r46.getFillMode();
        E();
        this.c.setVisibility(8);
        String r0 = r46.getImageScaleType();
        Bitmap r16 = null;
        if (r0 == null) goto L21;
        int r2 = r0.hashCode();
        if (r2 == (-2021672893)) goto L19;
        if (r2 == (-1274273297)) goto L16;
        if (r2 != 1671566394) goto L21;
        if (r0.equals("center_crop") == false) goto L21;
        ScalingUtils.ScaleType r1 = ScalingUtils.ScaleType.CENTER_CROP;
    L22:
        if (r1 == null) goto L24;
    L27:
        GenericDraweeHierarchy r3 = this.c.getHierarchy();
        if (r3 == null) goto L31;
        r3.setActualImageScaleType(r1);
    L31:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L35;
        k r4 = this.f;
        if (r4 == null) goto L38;
        r4.setVisibility(8);
    L38:
        C(true);
        if (r48 != null) goto L41;
    L43:
        boolean r5 = false;
    L44:
        final ECUrlModel r9 = r46.getImageUrl(r5);
        if (r9 == null) goto L92;
        final ECDraweeView r8 = this.c;
        final Function0<Unit> r6 = new ItemMediaLayer$onBind$$inlined$let$lambda$1(r9, this, r47, r48);
        r8.setVisibility(0);
        if (PdpPerfOpt.a().c() == true) goto L49;
        y.c(r8, r9, -1, -1, new z53.a(r9.getUrlList(), ImagePosition.GOODS_HEADER.getValue(), r6, !PdpPerfOpt.c(), 8));
        goto L92
    L49:
        Function0<Unit> r7 = new ItemMediaLayer$bindBackgroundImage$onSuccessCB$1(this, r6);
        Function0<Unit> r10 = new ItemMediaLayer$bindBackgroundImage$onIntermediateSuccessCB$1(this);
        List r17 = r9.getUrlList();
        ImagePosition r18 = ImagePosition.GOODS_HEADER;
        final d r11 = new d(this, r47, r8, r9, r48, r7, r10, r17, r18.getValue(), r7, r10, !PdpPerfOpt.c());
        if (r9.getUri() != null) goto L52;
    L54:
        boolean r12 = false;
    L55:
        if (r12 == false) goto L62;
        Integer r13 = this.j;
        if (r13 == null) goto L62;
        if (r47 != r13.intValue()) goto L62;
        boolean r14 = false;
    L94:
        if (PdpPerfOpt.a().c() == true) goto L96;
    L100:
        boolean r15 = false;
    L101:
        if (r15 == true) goto L103;
        b(r46, r47, r48);
    L103:
        this.j = Integer.valueOf(r47);
        return;
    L96:
        if (r46.getVideo() == null) goto L100;
        if (this.k.rR().n() == true) goto L100;
        this.k.rR().Z(new e(this, r47, r48, r46), r14);
        r15 = true;
    L62:
        ImageExtensionsKt.D(r8, new r("ec_detail", "ec_product_header_image"));
        if (this.l == true) goto L65;
    L88:
        r14 = false;
    L89:
        final String r19 = r9.getFirstUrl();
        if (r19 == null) goto L94;
        ImageExtensionsKt.w(r8, r19, null, null, null, null, null, null, r11, false, null, new ItemMediaLayer$bindBackgroundImage$$inlined$let$lambda$1(r19, this, r8, r11), 2940);
        goto L94
    L65:
        if (this.k.BY() == true) goto L88;
        String r20 = this.k.rR().U();
        if (r47 != 0) goto L88;
        if (r20 == null) goto L88;
        if (this.h != null) goto L88;
        ECDraweeView r21 = new ECDraweeView(this.k.getContext(), null, 0, 6, null);
        r21.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r14 = false;
        this.b.addView(r21, 0);
        E();
        Unit r22 = Unit.INSTANCE;
        this.h = r21;
        GenericDraweeHierarchy r23 = r21.getHierarchy();
        if (r23 == null) goto L74;
        r23.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    L74:
        CloseableReference<Bitmap> r24 = this.k.rR().h0();
        if (r24 == null) goto L77;
        r16 = (Bitmap) r24.get();
    L77:
        if (r16 == null) goto L85;
        ECDraweeView r25 = this.h;
        if (r25 == null) goto L81;
        r25.setImageBitmap((Bitmap) r24.get());
    L81:
        ECDraweeView r26 = this.h;
        if (r26 == null) goto L84;
        r26.setScaleType(ImageView.ScaleType.FIT_CENTER);
    L84:
        y();
        CloseableStaticBitmap r27 = new CloseableStaticBitmap(r24, ImmutableQualityInfo.FULL_QUALITY, 0);
        g(this, r47, r27, true, 0, 8);
        r27.close();
        goto L89
    L85:
        r r28 = new r("ec_detail", "ec_product_header_image");
        ECDraweeView r29 = this.h;
        if (r29 == null) goto L89;
        ImageExtensionsKt.x(r29, CollectionsKt.emptyList(), ImageExtensionsKt.G(r20, r28, Boolean.TRUE), r28, null, null, null, null, new h(this, r47, CollectionsKt.listOf(r20), r18.getValue()), false, null, ItemMediaLayer$setupPlaceHolderAsNeed$3.INSTANCE, null, 7032);
        goto L89
    L52:
        if (Intrinsics.areEqual(r9.getUri(), r8.getTag()) == false) goto L54;
        r12 = true;
    L92:
        r14 = false;
        goto L94
    L41:
        if (r48.intValue() <= 0) goto L43;
        r5 = true;
        goto L44
    L35:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j r30 = this.e;
        if (r30 == null) goto L38;
        r30.setVisibility(8);
        goto L38
    L24:
        if (this.k.XU() < 2) goto L26;
        r1 = ScalingUtils.ScaleType.CENTER_CROP;
        goto L27
    L26:
        r1 = ScalingUtils.ScaleType.FIT_CENTER;
        goto L27
    L16:
        if (r0.equals("fit_xy") == false) goto L21;
        r1 = ScalingUtils.ScaleType.FIT_XY;
        goto L22
    L19:
        if (r0.equals("fit_center") == false) goto L21;
        r1 = ScalingUtils.ScaleType.FIT_CENTER;
    L21:
        r1 = null;
        goto L22
    }

    public final void b(HeaderMediaModel r6, int r7, Integer r8) {
        if (r6.getVideo() != null) goto L5;
        return;
    L5:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L10;
        if (this.f != null) goto L13;
        k r0 = new k(this.k.getContext(), this.k, new f(this, r7));
        this.f = r0;
        this.b.addView(r0, -1, -1);
    L13:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L17;
        k r1 = this.f;
        if (r1 == null) goto L21;
        r1.setVisibility(0);
    L21:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L30;
        l r2 = this.k.Sf().c(r7);
        if (r2 == null) goto L25;
        r2.b = new ItemMediaLayer$bindVideoInner$1(this);
    L25:
        k r3 = this.f;
        if (r3 == null) goto L28;
        r3.f = false;
    L28:
        if (r3 == null) goto L38;
        r3.r(r6, r7, r8);
        return;
    L38:
        return;
    L30:
        PlayerBlock r4 = this.k.Sf().d(r7);
        if (r4 == null) goto L33;
        r4.setClick2PlayInterceptor(new ItemMediaLayer$bindVideoInner$2(this));
    L33:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j r5 = this.e;
        if (r5 == null) goto L40;
        r5.b(r6, r7, r8);
        return;
    L40:
        return;
    L17:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j r9 = this.e;
        if (r9 == null) goto L21;
        r9.setVisibility(0);
        goto L21
    L10:
        if (this.e != null) goto L13;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j r10 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j(this.k.getContext(), this.k, new g(this, r7));
        this.e = r10;
        this.b.addView(r10, -1, -1);
        goto L13
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(Object r1, int r2, Integer r3) {
        B((HeaderMediaModel) r1, r2, r3);
    }

    public static void g(ItemMediaLayer r1, int r2, ImageInfo r3, boolean r4, int r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = -1;
    L8:
        r1.k.eh().j(r2, r3, r4, r5);
    }
}
