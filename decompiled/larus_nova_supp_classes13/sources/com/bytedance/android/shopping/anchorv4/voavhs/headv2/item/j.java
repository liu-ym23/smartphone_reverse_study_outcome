package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.voavhs.blur.BlurImageView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.HeadVideoAutoPlayController;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.VideoCoverLayout;
import com.facebook.imagepipeline.image.ImageInfo;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends FrameLayout implements o<HeaderMediaModel>, com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p, com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.e, fa3.d {
    public final ImageView a;
    public final View b;
    public final ProgressBar c;
    public BlurImageView d;
    public PlayerBlock e;
    public float f;
    public Object g;
    public final Function1<Boolean, Unit> h;
    public final VideoCoverLayout i;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s j;
    public final x k;
    public final /* synthetic */ fa3.b l;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void a(boolean r1) {
    }

    @Override // fa3.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.l.add(r2);
        return r2;
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
    public final void onResume() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void p(String r1) {
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

    private final com.bytedance.android.ec.adapter.api.j getLiveWindowService() {
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getLiveWindowService();
    }

    public final void T() {
        this.k.a();
    }

    public final void U() {
        VideoCoverLayout r0 = this.i;
        if (r0 == null) goto L5;
        r0.g();
    L5:
        this.j.eh().f(true);
        this.j.rR().e().d(true);
        this.k.a();
        this.k.onStartPlay();
    }

    public final void g() {
        VideoCoverLayout r0 = this.i;
        if (r0 == null) goto L6;
        int r1 = VideoCoverLayout.t;
        r0.f(false);
    L6:
        if (HeadVideoAutoPlayController.f == false) goto L11;
        PlayerBlock r2 = this.e;
        if (r2 == null) goto L12;
        r2.a.setVisibility(8);
        return;
    L12:
        return;
    }

    public final View getPreviewStartView() {
        PlayerBlock r0 = this.e;
        if (r0 == null) goto L5;
        ViewParent r1 = r0.getParent();
    L7:
        if (Intrinsics.areEqual(r1, this) == false) goto L12;
        PlayerBlock r2 = this.e;
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getPlayerContainer();
    L12:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onDestroy() {
        Object r0 = this.g;
        if (r0 == null) goto L8;
        com.bytedance.android.ec.adapter.api.j r1 = getLiveWindowService();
        if (r1 == null) goto L7;
        r1.d(r0);
    L7:
        this.g = null;
    L8:
        BlurImageView r2 = this.d;
        if (r2 == null) goto L11;
        r2.f.a();
    L11:
        this.l.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPause() {
        if (this.j.a() == true) goto L7;
        PlayerBlock r0 = this.e;
        if (r0 == null) goto L7;
        r0.C(true);
    L7:
        Lazy r1 = HeadVideoAutoPlayController.a;
        if (HeadVideoAutoPlayController.f == false) goto L25;
        PlayerBlock r2 = this.e;
        if (r2 == null) goto L26;
        Integer r3 = this.j.Sf().e(r2);
        if (r3 == null) goto L27;
        int r4 = r3.intValue();
        if (r4 != 0) goto L28;
        AnchorV4HeadV2VO r5 = this.j.K10();
        if (r5 == null) goto L29;
        VideoModel r6 = AnchorV4HeadV2VO.getVideoData$default(r5, r4, null, 2, null);
        if (r6 == null) goto L30;
        long r7 = 1000;
        if ((r2.s() % r7) != 0) goto L22;
        long r8 = r2.s() / r7;
    L23:
        HeadVideoAutoPlayController.g(r6, this.j, (long) ((r2.getPlayProgress() / 100.0f) * r8));
        return;
    L22:
        r8 = r2.s();
        goto L23
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public final void onPausePlay() {
        VideoCoverLayout r0 = this.i;
        if (r0 == null) goto L6;
        r0.e();
    L6:
        if (HeadVideoAutoPlayController.f == false) goto L10;
        PlayerBlock r1 = this.e;
        if (r1 == null) goto L10;
        r1.a.setVisibility(8);
    L10:
        this.j.eh().f(false);
    }

    public final void r() {
        PlayerBlock r0 = this.e;
        if (r0 == null) goto L5;
        Function0 r1 = r0.getVideoExtraHeightProvider();
    L6:
        if (r1 == null) goto L13;
        PlayerBlock r2 = this.e;
        if (r2 == null) goto L14;
        ViewGroup r3 = r2.getPlayerContainer();
        if (r3 == null) goto L15;
        r3.requestLayout();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void y() {
        if (this.j.isExpanded() == false) goto L5;
    L11:
        VideoCoverLayout r0 = this.i;
        if (r0 == null) goto L17;
        r0.setVisibility(0);
        return;
    L17:
        return;
    L5:
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == false) goto L11;
        if (this.j.s() == true) goto L11;
        VideoCoverLayout r1 = this.i;
        if (r1 == null) goto L15;
        r1.setVisibility(8);
        return;
    }

    public final void S() {
        U();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void s() {
        r();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r1) {
        y();
        r();
    }

    public final void Q(float r3) {
        float r0 = (float) Math.floor(r3);
        ProgressBar r1 = this.c;
        if (r1 == null) goto L5;
        r1.setProgress((int) r0);
    L5:
        VideoCoverLayout r2 = this.i;
        if (r2 == null) goto L9;
        r2.setProgress(r3 / 100);
        return;
    }

    public final void R(boolean r2) {
        View r0 = this.b;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public final void V(boolean r3) {
        ImageView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setSelected(!r3);
    L5:
        VideoCoverLayout r1 = this.i;
        if (r1 == null) goto L9;
        r1.setAudioState(r3);
        return;
    }

    public final void W(boolean r2) {
        VideoCoverLayout r0 = this.i;
        if (r0 == null) goto L6;
        r0.setPlayState(r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.j.Y10() == false) goto L5;
        return;
    L5:
        super.dispatchDraw(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(float r1) {
        r();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPageSelected(int r8) {
        PlayerBlock r0 = this.e;
        if (r0 == null) goto L62;
        Integer r1 = this.j.Sf().e(r0);
        boolean r3 = true;
        boolean r4 = false;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == false) goto L33;
        PlayerBlock r2 = this.e;
        if (r2 == null) goto L15;
        gj.b r6 = r2.f;
        if (r6 == null) goto L11;
        ViewGroup r7 = r6.E();
    L13:
        if (Intrinsics.areEqual(r7, r2.e) != true) goto L15;
        boolean r5 = true;
    L16:
        if (r1 != null) goto L19;
    L31:
        if (r5 == false) goto L67;
        r0.E();
        return;
    L67:
        return;
    L19:
        if (r1.intValue() != r8) goto L31;
        if (this.j.z20() == true) goto L23;
    L25:
        r3 = false;
    L27:
        if (this.j.rR().e().i() == false) goto L63;
        if (r5 == false) goto L64;
        if (r3 == false) goto L65;
        r0.j();
        PlayerBlock.z(r0, false, false, null, 7);
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L23:
        if (this.j.k80() == false) goto L25;
    L11:
        r7 = null;
    L15:
        r5 = false;
        goto L16
    L33:
        if (r1 != null) goto L36;
    L55:
        int r9 = this.j.G7();
        if (r1 != null) goto L59;
        return;
    L59:
        if (r1.intValue() != r9) goto L70;
        int r10 = PlayerBlock.T;
        r0.D(false, false, false);
        return;
    L70:
        return;
    L36:
        if (r1.intValue() != r8) goto L55;
        if (com.bytedance.android.ec.core.abtest.d.p() == false) goto L50;
        if (this.j.a() == false) goto L45;
        if (this.j.z20() == false) goto L53;
    L54:
        r0.D(true, true, r4);
        this.j.Sf().j(r8);
        return;
    L53:
        r4 = true;
        goto L54
    L45:
        if (this.j.z20() == false) goto L53;
        if (this.j.k80() == true) goto L54;
    L50:
        if (this.j.z20() == false) goto L53;
        if (this.j.a() == false) goto L54;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r2) {
        Intrinsics.checkNotNullParameter(r2, "headVo");
        Intrinsics.checkNotNullParameter(r2, "headVo");
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void w(int r5) {
        Integer r0 = this.j.Sf().e(this.e);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r5 != r0.intValue()) goto L35;
        AnchorV4HeadV2VO r1 = this.j.K10();
        if (r1 == null) goto L16;
        List<HeaderContentModel> r2 = r1.getCells();
        if (r2 == null) goto L16;
        HeaderContentModel r3 = (HeaderContentModel) CollectionsKt.getOrNull(r2, r5);
        if (r3 == null) goto L16;
        HeaderMediaModel r4 = r3.getMedia();
        if (r4 == null) goto L16;
        Integer r6 = Integer.valueOf(r4.getPreviewType());
    L24:
        if (r6 != null) goto L27;
    L28:
        PlayerBlock r7 = this.e;
        if (r7 == null) goto L31;
        r7.F(false);
    L31:
        PlayerBlock r8 = this.e;
        if (r8 == null) goto L37;
        r8.x();
        return;
    L37:
        return;
    L27:
        if (r6.intValue() != 0) goto L28;
        return;
    L16:
        AnchorV4HeadV2VO r9 = this.j.K10();
        if (r9 == null) goto L23;
        HeaderContentModel r10 = AnchorV4HeadV2VO.getMultiPreviewCell$default(r9, r5, 0, 2, null);
        if (r10 == null) goto L23;
        HeaderMediaModel r11 = r10.getMedia();
        if (r11 == null) goto L23;
        r6 = Integer.valueOf(r11.getPreviewType());
    L23:
        r6 = null;
        goto L24
    }

    public j(Context r2, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s r3, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.g r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "headAbility");
        Intrinsics.checkNotNullParameter(r4, "callback");
        super(r2);
        this.l = new fa3.b();
        this.j = r3;
        this.k = r4;
        this.h = new HeadVideoView$expandModeChangeListener$1(this);
        if (com.bytedance.android.shopping.anchorv4.video.float.e.b() == true) goto L5;
        View.inflate(r2, 2131560513, this);
        this.a = (ImageView) findViewById(2131376015);
        this.b = findViewById(2131376016);
        this.c = (ProgressBar) findViewById(2131382056);
    L6:
        com.bytedance.android.ec.adapter.api.j r5 = getLiveWindowService();
        if (r5 == null) goto L9;
        Object r6 = r5.f(new f(this));
    L10:
        this.g = r6;
        r3.eh().x(this);
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        VideoCoverLayout r7 = new VideoCoverLayout(r2, new e(this));
        this.i = r7;
        Unit r8 = Unit.INSTANCE;
        addView(r7, new FrameLayout.LayoutParams(-1, -1));
        goto L6
    }

    public final void b(HeaderMediaModel r13, final int r14, Integer r15) {
        Intrinsics.checkNotNullParameter(r13, "data");
        PlayerBlock r0 = this.j.Sf().d(r14);
        boolean r2 = true;
        if ((!Intrinsics.areEqual(this.e, r0)) == false) goto L14;
        PlayerBlock r1 = this.e;
        if (r1 == null) goto L9;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.d r3 = r1.getDetachHandler();
        if (r3 == null) goto L9;
        r3.a(r1);
    L9:
        if (r0 == null) goto L13;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.d r4 = r0.getDetachHandler();
        if (r4 == null) goto L13;
        r4.a(r0);
    L13:
        this.e = r0;
    L14:
        PlayerBlock r5 = this.e;
        if (r5 == null) goto L17;
        r5.setDetachHandler(new h(this));
    L17:
        PlayerBlock r6 = this.e;
        int r7 = 0;
        if (r6 != null) goto L20;
    L24:
        PlayerBlock r8 = this.e;
        if (r8 == null) goto L27;
        r8.i(this);
    L27:
        PlayerBlock r9 = this.e;
        if (r9 == null) goto L30;
        r9.g(this.h);
    L30:
        PlayerBlock r10 = this.e;
        if (r10 == null) goto L33;
        r10.h(this);
    L33:
        PlayerBlock r11 = this.e;
        if (r11 == null) goto L36;
        r11.setAudioInterceptor(new i());
    L36:
        PlayerBlock r12 = this.e;
        if (r12 == null) goto L39;
        r12.i = new HeadVideoView$tryInitPlayerBlock$5(this, r14);
    L39:
        VideoCoverLayout r16 = this.i;
        if (r16 != null) goto L70;
        ImageView r17 = this.a;
        if (r17 == null) goto L51;
        PlayerBlock r18 = this.e;
        if (r18 != null) goto L46;
    L49:
        boolean r19 = true;
    L50:
        r17.setSelected(r19);
        goto L51
    L46:
        if (r18.o != true) goto L49;
        r19 = false;
    L51:
        ImageView r20 = this.a;
        if (r20 == null) goto L54;
        r20.setOnClickListener(new g(this));
    L54:
        PlayerBlock r21 = this.e;
        if (r21 != null) goto L57;
    L58:
        View r22 = this.b;
        if (r22 == null) goto L61;
        r22.setVisibility(8);
    L61:
        View r23 = this.b;
        if (r23 == null) goto L64;
        r23.setPadding(com.bytedance.android.shopping.extensions.b.b(15), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(15), com.bytedance.android.shopping.extensions.b.b(8));
    L64:
        ImageView r24 = this.a;
        if (r24 == null) goto L67;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        r25.width = com.bytedance.android.shopping.extensions.b.b(40);
        r25.height = com.bytedance.android.shopping.extensions.b.b(20);
        Unit r26 = Unit.INSTANCE;
        r24.setLayoutParams(r25);
    L67:
        ImageView r27 = this.a;
        if (r27 == null) goto L77;
        r27.setImageResource(2131233375);
    L77:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r28 = this.j.Sf().f(r14);
        final String r29 = null;
        if (r28 != null) goto L80;
    L144:
        VideoCoverLayout r30 = this.i;
        if (r30 == null) goto L151;
        PlayerBlock r31 = this.e;
        if (r31 == null) goto L149;
        int r32 = (int) r31.s();
    L150:
        r30.setTotalDuration(r32);
        goto L151
    L149:
        r32 = 0;
    L151:
        VideoCoverLayout r33 = this.i;
        if (r33 == null) goto L159;
        boolean r110 = r13.getVideoButtonNewStyle();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.e r34 = r33.m;
        if (r110 == false) goto L157;
        r34.e = -2146035677;
        r34.f = 872415231;
    L157:
        if (r34.g == false) goto L159;
        r34.e = 1712724003;
        r34.f = 0;
    L159:
        y();
        PlayerBlock r111 = this.e;
        if (r111 == null) goto L162;
        r111.setContentDescription("商品视频");
    L162:
        PlayerBlock r112 = this.e;
        boolean r35 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.d;
        if (r35 == false) goto L218;
        AnchorV4HeadV2VO r36 = this.j.K10();
        if (r36 == null) goto L169;
        List<HeaderContentModel> r37 = r36.getCells();
        if (r37 == null) goto L169;
        HeaderContentModel r113 = (HeaderContentModel) CollectionsKt.getOrNull(r37, r14);
    L170:
        if (r113 == null) goto L184;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.r r38 = r113.getMultiPreview();
        if (r38 == null) goto L184;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.k> r39 = r38.a();
        if (r39 == null) goto L184;
        if (r15 == null) goto L177;
        int r114 = r15.intValue();
    L178:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r115 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.k) CollectionsKt.getOrNull(r39, r114);
        if (r115 == null) goto L184;
        HeaderContentModel r116 = r115.a();
        if (r116 == null) goto L184;
        Float r117 = r116.getWHScale(false);
        if (r117 == null) goto L184;
    L187:
        if (r117 == null) goto L189;
        float r118 = r117.floatValue();
    L190:
        if (r112 == null) goto L196;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r119 = r112.getVideoModel();
        if (r119 == null) goto L196;
        Integer r120 = r119.c();
        if (r120 == null) goto L196;
        int r121 = r120.intValue();
    L197:
        if (r112 == null) goto L203;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r40 = r112.getVideoModel();
        if (r40 == null) goto L203;
        Integer r41 = r40.l();
        if (r41 == null) goto L203;
        int r42 = r41.intValue();
    L204:
        if (r42 <= 0) goto L209;
        if (r121 <= 0) goto L209;
        if ((r42 / r121) >= r118) goto L209;
        boolean r122 = true;
    L210:
        if (r112 == null) goto L215;
        if (r122 == false) goto L213;
        Function0<Integer> r123 = new HeadVideoView$configVideoExtraHeight$1(this);
    L214:
        r112.setVideoExtraHeightProvider(r123);
        goto L215
    L213:
        r123 = null;
    L215:
        if (r122 == false) goto L218;
        if (r112 == null) goto L218;
        k83.b.a(r112);
    L209:
        r122 = false;
    L203:
        r42 = 0;
    L196:
        r121 = 0;
        goto L197
    L189:
        r118 = 1.0f;
        goto L190
    L177:
        r114 = -1;
    L184:
        if (r113 == null) goto L186;
        r117 = r113.getWHScale(false);
        goto L187
    L186:
        r117 = null;
    L169:
        r113 = null;
    L218:
        if (r35 == true) goto L287;
        PlayerBlock r124 = this.e;
        if (r124 == null) goto L287;
        Integer r125 = this.j.Sf().e(r124);
        if (r125 == null) goto L226;
        final int r126 = r125.intValue();
    L227:
        if (r126 != 0) goto L251;
        AnchorV4HeadV2VO r127 = this.j.K10();
        if (r127 == null) goto L251;
        List<HeaderContentModel> r128 = r127.getCells();
        if (r128 == null) goto L251;
        HeaderContentModel r129 = (HeaderContentModel) CollectionsKt.getOrNull(r128, 0);
        if (r129 == null) goto L251;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.r r130 = r129.getMultiPreview();
        if (r130 == null) goto L251;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.k> r131 = r130.a();
        if (r131 == null) goto L251;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r132 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.k) CollectionsKt.getOrNull(r131, 0);
        if (r132 == null) goto L251;
        HeaderContentModel r133 = r132.a();
        if (r133 == null) goto L251;
        HeaderMediaModel r134 = r133.getMedia();
        if (r134 == null) goto L251;
        VideoModel r135 = r134.getVideo();
        if (r135 == null) goto L251;
        ImageModel r136 = r135.getPosterImage();
        if (r136 == null) goto L251;
        ECUrlModel r137 = r136.getRemote();
        if (r137 == null) goto L251;
        String r138 = r137.getFirstUrl();
    L252:
        if (r138 != null) goto L268;
        AnchorV4HeadV2VO r139 = this.j.K10();
        if (r139 == null) goto L269;
        List<HeaderContentModel> r140 = r139.getCells();
        if (r140 == null) goto L269;
        HeaderContentModel r141 = (HeaderContentModel) CollectionsKt.getOrNull(r140, r126);
        if (r141 == null) goto L269;
        HeaderMediaModel r142 = r141.getMedia();
        if (r142 == null) goto L269;
        VideoModel r143 = r142.getVideo();
        if (r143 == null) goto L269;
        ImageModel r144 = r143.getPosterImage();
        if (r144 == null) goto L269;
        ECUrlModel r145 = r144.getRemote();
        if (r145 == null) goto L269;
        r29 = r145.getFirstUrl();
    L269:
        if (r29 == null) goto L287;
        if ((r124.getChildAt(0) instanceof BlurImageView) == false) goto L278;
        View r146 = r124.getChildAt(0);
        if (r146 == null) goto L277;
        final BlurImageView r147 = (BlurImageView) r146;
    L282:
        this.d = r147;
        if (r147.b == true) goto L287;
        if (r147.getHasBlurred() == true) goto L287;
        r147.setOnSizeChangedCallback(new HeadVideoView$blurCover$3(r147, r29));
        goto L287
    L277:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.blur.BlurImageView");
    L278:
        BlurImageView r148 = new BlurImageView(getContext(), new HeadVideoView$blurCover$1(this, r126));
        ViewGroup.LayoutParams r149 = r148.getLayoutParams();
        if (r149 != null) goto L281;
        r149 = new ViewGroup.LayoutParams(-2, -2);
    L281:
        r149.width = -1;
        r149.height = -1;
        Unit r43 = Unit.INSTANCE;
        r148.setLayoutParams(r149);
        r148.setScaleType(ImageView.ScaleType.FIT_XY);
        r124.addView(r148, 0);
        r147 = r148;
        goto L282
    L268:
        r29 = r138;
    L251:
        r138 = null;
        goto L252
    L226:
        r126 = -1;
    L287:
        PlayerBlock r150 = this.e;
        if (r150 != null) goto L290;
    L292:
        r2 = false;
    L293:
        BlurImageView r151 = this.d;
        if (r151 == null) goto L299;
        if (r2 == false) goto L297;
        r7 = 8;
    L297:
        r151.setVisibility(r7);
        return;
    L299:
        return;
    L290:
        if (r150.getExpandMode() != true) goto L292;
    L80:
        if (r28.m() == true) goto L82;
        AnchorV4HeadV2VO r44 = this.j.K10();
        if (r44 == null) goto L144;
        VideoModel r45 = AnchorV4HeadV2VO.getVideoData$default(r44, r14, null, 2, null);
        if (r45 == null) goto L144;
        if (r45.getAutoPlayForBiz() != true) goto L144;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == true) goto L104;
        if (r14 == 0) goto L112;
    L116:
        boolean r46 = false;
    L117:
        if (r46 == false) goto L144;
        Lazy r47 = HeadVideoAutoPlayController.a;
        Long r48 = HeadVideoAutoPlayController.c(r13.getVideo(), this.j);
        if (r48 == null) goto L121;
        long r49 = r48.longValue();
    L122:
        VideoModel r50 = r13.getVideo();
        if (r50 == null) goto L125;
        Integer r51 = r50.getDuration();
    L126:
        if (r51 == null) goto L131;
        r51.intValue();
        if (r49 < r51.intValue()) goto L130;
        r28.o(0);
    L133:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == false) goto L135;
        Boolean r52 = null;
    L136:
        PlayerBlock r53 = this.e;
        if (r53 != null) goto L139;
    L143:
        this.j.Gw();
        goto L144
    L139:
        if (r49 <= 0) goto L141;
        boolean r54 = true;
    L142:
        r53.k(Boolean.valueOf(r54), r52);
        goto L143
    L141:
        r54 = false;
        goto L142
    L135:
        r52 = Boolean.TRUE;
        goto L136
    L130:
        r28.o(r49);
        goto L133
    L131:
        r28.o(r49);
        goto L133
    L125:
        r51 = null;
        goto L126
    L121:
        r49 = 0;
        goto L122
    L112:
        if (this.j.Sf().h(r14) == false) goto L116;
        Lazy r55 = HeadVideoAutoPlayController.a;
        if (HeadVideoAutoPlayController.b(this.j) == false) goto L116;
    L115:
        r46 = true;
        goto L117
    L104:
        if (r14 != this.j.getCurrentPosition()) goto L116;
        if (this.j.Sf().h(r14) == false) goto L116;
        Lazy r56 = HeadVideoAutoPlayController.a;
        if (HeadVideoAutoPlayController.b(this.j) == false) goto L116;
    L82:
        if (this.j.Sf().h(r14) == false) goto L144;
        PlayerBlock r57 = this.e;
        if (r57 == null) goto L94;
        r28.p();
        fj.d r58 = r28.b;
        if (r58 == null) goto L88;
        long r59 = r58.o;
    L90:
        if (r59 <= 0) goto L92;
        boolean r60 = true;
    L93:
        r57.k(Boolean.valueOf(r60), Boolean.valueOf(r28.n()));
        goto L94
    L92:
        r60 = false;
        goto L93
    L88:
        r59 = 0;
    L94:
        this.j.Gw();
        goto L144
    L57:
        if (r21.isPlaying() == true) goto L61;
    L70:
        PlayerBlock r61 = this.e;
        if (r61 != null) goto L73;
    L75:
        boolean r62 = false;
    L76:
        r16.setAudioState(r62);
        goto L77
    L73:
        if (r61.o != true) goto L75;
        r62 = true;
        goto L76
    L20:
        if (r6.getExpandMode() == true) goto L24;
        if ((!Intrinsics.areEqual(r6.getParent(), this)) == false) goto L24;
        wg.a.a(r6);
        addView(r6, 0);
        goto L24
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(HeaderMediaModel r1, int r2, Integer r3) {
        b(r1, r2, r3);
    }
}
