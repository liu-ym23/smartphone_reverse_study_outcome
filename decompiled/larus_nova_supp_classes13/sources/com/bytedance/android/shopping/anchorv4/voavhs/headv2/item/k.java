package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base.VideoComponentScene;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.HeadVideoController;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.HeadVideoAutoPlayController;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.VideoCoverLayout;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.image.ImageInfo;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends FrameLayout implements o<HeaderMediaModel>, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p, com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c, fa3.d {
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l a;
    public float b;
    public HeadVideoController c;
    public VideoCoverLayout d;
    public int e;
    public boolean f;
    public final Function1<Boolean, Unit> g;
    public Function0<Integer> h;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s i;
    public final x j;
    public final /* synthetic */ fa3.b k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ k a;
        public final /* synthetic */ int b;

        public b(k r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            HeadVideoController r10 = this.a.c;
            boolean r0 = true;
            if (r10 != null) goto L5;
        L7:
            boolean r11 = false;
        L8:
            if (r11 == false) goto L53;
            k r12 = this.a;
            int r2 = this.b;
            AnchorV4HeadV2VO r3 = r12.i.K10();
            Object r4 = null;
            if (r3 == null) goto L17;
            List<HeaderContentModel> r5 = r3.getCells();
            if (r5 == null) goto L17;
            HeaderContentModel r6 = (HeaderContentModel) ListProtector.get(r5, r2);
            if (r6 == null) goto L17;
            IAction r7 = r6.getClickAction();
            if (r7 == null) goto L17;
        L23:
            if (r7 == null) goto L25;
            String r8 = r7.getType();
        L27:
            if (Intrinsics.areEqual(r8, "Group") == true) goto L29;
            if (r7 == null) goto L47;
            r4 = r7.getType();
        L47:
            r0 = true ^ Intrinsics.areEqual(r4, "HeadPreview");
        L48:
            if (r0 == false) goto L52;
            HeadVideoController r1 = r12.c;
            if (r1 == null) goto L52;
            r1.e(false);
        L52:
            r12.i.TB(r2, false);
            return;
        L29:
            if ((r7 instanceof SlcCommonAction) == true) goto L31;
            r7 = null;
        L31:
            SlcCommonAction r13 = (SlcCommonAction) r7;
            if (r13 == null) goto L42;
            List r14 = r13.getActions();
            if (r14 == null) goto L42;
            Iterator r15 = r14.iterator();
        L37:
            if (r15.hasNext() == false) goto L41;
            Object r16 = r15.next();
            if (Intrinsics.areEqual(((IAction) r16).getType(), "HeadPreview") == false) goto L37;
            r4 = r16;
        L41:
            r4 = (IAction) r4;
        L42:
            if (r4 == null) goto L48;
            r0 = false;
            goto L48
        L25:
            r8 = null;
        L17:
            AnchorV4HeadV2VO r17 = r12.i.K10();
            if (r17 == null) goto L22;
            HeaderContentModel r18 = AnchorV4HeadV2VO.getMultiPreviewCell$default(r17, r2, 0, 2, null);
            if (r18 == null) goto L22;
            r7 = r18.getClickAction();
        L22:
            r7 = null;
            goto L23
        L53:
            HeadVideoController r19 = this.a.c;
            if (r19 == null) goto L61;
            r19.g();
            return;
        L61:
            return;
        L5:
            if (r10.d() != true) goto L7;
            r11 = true;
            goto L8
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void a(boolean r1) {
    }

    @Override // fa3.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.k.add(r2);
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

    private final int getDurationMs() {
        HeadVideoController r0 = this.c;
        if (r0 == null) goto L8;
        BasePdpVideoView r1 = r0.d;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getVideoDuration();
    L8:
        return 0;
    }

    public final void E3() {
        VideoCoverLayout r0 = this.d;
        if (r0 == null) goto L5;
        int r2 = VideoCoverLayout.t;
        r0.f(false);
    L5:
        HeadVideoController r1 = this.c;
        if (r1 == null) goto L11;
        BasePdpVideoView r3 = r1.d;
        if (r3 == null) goto L12;
        ExtensionsKt.showIf(r3, false);
        return;
    L12:
        return;
    }

    public final void S() {
        VideoCoverLayout r0 = this.d;
        if (r0 == null) goto L5;
        r0.g();
    L5:
        this.j.a();
        this.j.onStartPlay();
        HeadVideoController r1 = this.c;
        if (r1 == null) goto L12;
        b83.a r2 = r1.b();
        if (r2 == null) goto L10;
        r2.a = SystemClock.elapsedRealtime();
    L10:
        r1.e.eh().f(true);
        r1.e.rR().e().d(true);
        return;
    }

    public final View getPreviewStartView() {
        return g(this.a);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onDestroy() {
        HeadVideoController r0 = this.c;
        if (r0 == null) goto L24;
        Object r1 = r0.a;
        if (r1 == null) goto L13;
        int r3 = ECSdk.a;
        IAdapterService r4 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r4 == null) goto L9;
        com.bytedance.android.ec.adapter.api.j r5 = r4.getLiveWindowService();
    L10:
        if (r5 == null) goto L12;
        r5.d(r1);
    L12:
        r0.a = null;
        goto L13
    L9:
        r5 = null;
    L13:
        b83.a r2 = r0.b();
        if (r2 != null) goto L16;
    L21:
        b83.a r6 = r0.b();
        if (r6 == null) goto L24;
        r6.a = -1;
        r6.b = null;
        goto L24
    L16:
        if (r2.a < 0) goto L21;
        long r7 = SystemClock.elapsedRealtime();
        long r8 = r7 - r2.a;
        c63.c r9 = r2.c;
        if (r9 == null) goto L20;
        r9.E(r8, "main_picture");
    L20:
        r2.a = r7;
    L24:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l r10 = this.a;
        if (r10 == null) goto L29;
        x73.a r11 = r10.e;
        if (r11 == null) goto L29;
        r11.g(this);
    L29:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l r12 = this.a;
        if (r12 == null) goto L34;
        x73.a r13 = r12.e;
        if (r13 == null) goto L34;
        r13.release();
    L34:
        this.k.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPause() {
        if (this.i.a() == true) goto L7;
        HeadVideoController r0 = this.c;
        if (r0 == null) goto L7;
        r0.e(true);
    L7:
        Lazy r1 = HeadVideoAutoPlayController.a;
        if (HeadVideoAutoPlayController.f == false) goto L37;
        HeadVideoController r2 = this.c;
        if (r2 == null) goto L38;
        int r3 = this.e;
        if (r3 != 0) goto L39;
        AnchorV4HeadV2VO r4 = r2.e.K10();
        if (r4 == null) goto L40;
        VideoModel r5 = AnchorV4HeadV2VO.getVideoData$default(r4, r3, null, 2, null);
        if (r5 == null) goto L41;
        BasePdpVideoView r6 = r2.d;
        int r7 = 0;
        if (r6 == null) goto L20;
        int r8 = r6.getVideoDuration();
    L22:
        if ((r8 % 1000) != 0) goto L28;
        BasePdpVideoView r9 = r2.d;
        if (r9 == null) goto L26;
        int r10 = r9.getVideoDuration();
    L27:
        int r11 = r10 / 1000;
    L32:
        BasePdpVideoView r12 = r2.d;
        if (r12 == null) goto L35;
        r7 = r12.getCurrentPosition();
    L35:
        HeadVideoAutoPlayController.g(r5, r2.e, (((long) r7) / 100) * ((long) r11));
        return;
    L26:
        r10 = 0;
        goto L27
    L28:
        BasePdpVideoView r13 = r2.d;
        if (r13 == null) goto L31;
        r11 = r13.getVideoDuration();
        goto L32
    L31:
        r11 = 0;
        goto L32
    L20:
        r8 = 0;
        goto L22
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void s() {
        BasePdpVideoView r0 = g(this.a);
        if (r0 == null) goto L6;
        r0.requestLayout();
        return;
    }

    public final void B() {
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == true) goto L5;
    L9:
        VideoCoverLayout r0 = this.d;
        if (r0 == null) goto L15;
        r0.setVisibility(0);
        return;
    L15:
        return;
    L5:
        if (this.i.s() == true) goto L9;
        VideoCoverLayout r1 = this.d;
        if (r1 == null) goto L13;
        r1.setVisibility(8);
        return;
    }

    public static BasePdpVideoView g(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l r2) {
        x73.a r0 = null;
        if (r2 == null) goto L5;
        x73.a r3 = r2.e;
    L7:
        if ((r3 instanceof BasePdpVideoView) == false) goto L11;
        r0 = r3;
    L11:
        return (BasePdpVideoView) r0;
    L5:
        r3 = null;
        goto L7
    }

    private final void setVideoExtraHeightProvider(Function0<Integer> r1) {
        this.h = r1;
        requestLayout();
    }

    private final void setupVideoViewListeners(int r3) {
        BasePdpVideoView r0 = g(this.a);
        if (r0 == null) goto L6;
        r0.c(this);
        r0.setOnClickListener(new b(this, r3));
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r1) {
        B();
        BasePdpVideoView r2 = g(this.a);
        if (r2 == null) goto L6;
        r2.requestLayout();
        return;
    }

    public final void P1(boolean r3) {
        VideoCoverLayout r0 = this.d;
        if (r0 == null) goto L5;
        r0.setAudioState(r3);
    L5:
        HeadVideoController r1 = this.c;
        if (r1 == null) goto L11;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.k r2 = r1.g;
        if (r2 == null) goto L12;
        r2.n(r3, true);
        return;
    L12:
        return;
    }

    public final void b(float r3) {
        float r4 = (float) Math.floor(r3);
        VideoCoverLayout r0 = this.d;
        if (r0 == null) goto L6;
        r0.setProgress(r4 / 100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.i.Y10() == false) goto L5;
        return;
    L5:
        super.dispatchDraw(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(float r1) {
        BasePdpVideoView r2 = g(this.a);
        if (r2 == null) goto L6;
        r2.requestLayout();
        return;
    }

    public final void i2(boolean r8) {
        HeadVideoController r0 = this.c;
        if (r0 == null) goto L21;
        if (r8 == false) goto L11;
        b83.a r1 = r0.b();
        if (r1 == null) goto L8;
        r1.a = SystemClock.elapsedRealtime();
    L8:
        BasePdpVideoView r2 = r0.d;
        if (r2 == null) goto L11;
        ExtensionsKt.showIf(r2, true);
    L11:
        r0.e.eh().f(r8);
        if (r8 == true) goto L21;
        b83.a r3 = r0.b();
        if (r3 == null) goto L21;
        if (r3.a < 0) goto L21;
        long r4 = SystemClock.elapsedRealtime();
        long r5 = r4 - r3.a;
        c63.c r6 = r3.c;
        if (r6 == null) goto L20;
        r6.E(r5, "main_picture");
    L20:
        r3.a = r4;
    L21:
        if (r8 == false) goto L26;
        VideoCoverLayout r9 = this.d;
        if (r9 == null) goto L25;
        r9.g();
    L25:
        this.j.a();
        return;
    L26:
        VideoCoverLayout r10 = this.d;
        if (r10 == null) goto L31;
        r10.e();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPageSelected(int r6) {
        HeadVideoController r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r6 != this.e) goto L7;
        boolean r7 = true;
    L9:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == false) goto L24;
        if (r7 == true) goto L12;
        r0.e(false);
        return;
    L12:
        if (r0.e.z20() == true) goto L14;
    L16:
        boolean r8 = false;
    L18:
        if (r0.e.rR().e().i() == false) goto L38;
        if (r8 == false) goto L39;
        r0.g();
        b83.a r9 = r0.b();
        if (r9 == null) goto L40;
        b83.a.a(r9, false, true, 5);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L14:
        if (r0.e.k80() == false) goto L16;
        r8 = true;
        goto L18
    L24:
        if (r7 == true) goto L26;
        return;
    L26:
        if (r0.e.z20() == true) goto L28;
    L31:
        boolean r10 = true;
    L32:
        if (r10 == true) goto L44;
        r0.g();
        b83.a r11 = r0.b();
        if (r11 == null) goto L45;
        b83.a.a(r11, false, true, 5);
        return;
    L45:
        return;
    L44:
        return;
    L28:
        if (r0.e.a() == true) goto L31;
        r10 = false;
        goto L32
    L7:
        r7 = false;
        goto L9
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r2) {
        Intrinsics.checkNotNullParameter(r2, "headVo");
        Intrinsics.checkNotNullParameter(r2, "headVo");
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void w(int r5) {
        if (r5 != this.e) goto L29;
        AnchorV4HeadV2VO r0 = this.i.K10();
        if (r0 == null) goto L13;
        List<HeaderContentModel> r1 = r0.getCells();
        if (r1 == null) goto L13;
        HeaderContentModel r2 = (HeaderContentModel) CollectionsKt.getOrNull(r1, r5);
        if (r2 == null) goto L13;
        HeaderMediaModel r3 = r2.getMedia();
        if (r3 == null) goto L13;
        Integer r6 = Integer.valueOf(r3.getPreviewType());
    L21:
        if (r6 != null) goto L24;
    L25:
        HeadVideoController r7 = this.c;
        if (r7 == null) goto L31;
        r7.e(false);
        return;
    L31:
        return;
    L24:
        if (r6.intValue() != 0) goto L25;
        return;
    L13:
        AnchorV4HeadV2VO r4 = this.i.K10();
        if (r4 == null) goto L20;
        HeaderContentModel r8 = AnchorV4HeadV2VO.getMultiPreviewCell$default(r4, r5, 0, 2, null);
        if (r8 == null) goto L20;
        HeaderMediaModel r9 = r8.getMedia();
        if (r9 == null) goto L20;
        r6 = Integer.valueOf(r9.getPreviewType());
    L20:
        r6 = null;
        goto L21
    }

    public final void y(boolean r2) {
        VideoCoverLayout r0 = this.d;
        if (r0 == null) goto L6;
        r0.i(r2);
        return;
    }

    public final void y3(String r4) {
        HeadVideoController r0 = this.c;
        if (r0 == null) goto L9;
        b83.a r1 = r0.b();
        if (r1 == null) goto L9;
        c63.c r2 = r1.c;
        if (r2 == null) goto L9;
        r2.c(r1.b, r4);
    L9:
        com.bytedance.android.ec.sdk.helper.i.a.e(getContext(), com.bytedance.android.shopping.extensions.j.c(2131913946), false, false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        Function0<Integer> r0 = this.h;
        if (r0 == null) goto L16;
        Integer r1 = (Integer) r0.invoke();
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        int r3 = View.MeasureSpec.getSize(r7);
        int r4 = View.MeasureSpec.getSize(r6);
        BasePdpVideoView r5 = g(this.a);
        if (r5 == null) goto L21;
        r5.getLayoutParams().width = r4;
        int r8 = r3 + r2;
        r5.getLayoutParams().height = r8;
        ViewGroup.LayoutParams r9 = r5.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r9 = null;
    L13:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        if (r10 == null) goto L21;
        r10.topMargin = -r2;
    L21:
        super.onMeasure(r6, r7);
        return;
    L7:
        r2 = 0;
        goto L8
    L16:
        BasePdpVideoView r11 = g(this.a);
        if (r11 == null) goto L21;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L21;
        r12.width = -1;
        r12.height = -1;
        goto L21
    }

    public k(Context r3, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s r4, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.f r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "headAbility");
        Intrinsics.checkNotNullParameter(r5, "callback");
        super(r3);
        this.k = new fa3.b();
        this.i = r4;
        this.j = r5;
        this.e = -1;
        this.g = new HeadVideoViewV2$expandModeChangeListener$1(this);
        VideoCoverLayout r6 = new VideoCoverLayout(getContext(), new m(this));
        addView(r6, new FrameLayout.LayoutParams(-1, -1));
        Unit r7 = Unit.INSTANCE;
        this.d = r6;
        r4.eh().x(this);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(HeaderMediaModel r1, int r2, Integer r3) {
        r(r1, r2, r3);
    }

    public final void r(HeaderMediaModel r18, int r19, Integer r20) {
        Intrinsics.checkNotNullParameter(r18, "data");
        VideoCoverLayout r3 = this.d;
        if (r3 == null) goto L5;
        r3.setProgress(0.0f);
    L5:
        this.b = 0.0f;
        BasePdpVideoView r4 = g(this.a);
        if (r4 == null) goto L8;
        r4.setTranslationY(0.0f);
    L8:
        this.e = r19;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l r5 = this.i.Sf().c(r19);
        boolean r6 = true;
        if ((!Intrinsics.areEqual(this.a, r5)) == false) goto L20;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l r7 = this.a;
        if (r7 == null) goto L15;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.m r8 = r7.a;
        if (r8 == null) goto L15;
        r8.a(r7);
    L15:
        if (r5 == null) goto L19;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.m r9 = r5.a;
        if (r9 == null) goto L19;
        r9.a(r5);
    L19:
        this.a = r5;
    L20:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l r10 = this.a;
        if (r10 == null) goto L23;
        r10.a = new l(this);
    L23:
        String r11 = null;
        if (r10 != null) goto L26;
    L42:
        setupVideoViewListeners(r19);
        AnchorV4HeadV2VO r12 = this.i.K10();
        if (r12 == null) goto L47;
        List<HeaderContentModel> r13 = r12.getCells();
        if (r13 == null) goto L47;
        HeaderContentModel r14 = (HeaderContentModel) CollectionsKt.getOrNull(r13, r19);
    L48:
        if (r14 == null) goto L62;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.r r15 = r14.getMultiPreview();
        if (r15 == null) goto L62;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.k> r16 = r15.a();
        if (r16 == null) goto L62;
        if (r20 == null) goto L55;
        int r17 = r20.intValue();
    L56:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r21 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.k) CollectionsKt.getOrNull(r16, r17);
        if (r21 == null) goto L62;
        HeaderContentModel r22 = r21.a();
        if (r22 == null) goto L62;
        Float r23 = r22.getWHScale(false);
        if (r23 == null) goto L62;
    L65:
        if (r23 == null) goto L67;
        float r24 = r23.floatValue();
    L68:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l r25 = this.a;
        if (r25 == null) goto L75;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r26 = r25.f;
        if (r26 == null) goto L75;
        Integer r27 = r26.c();
        if (r27 == null) goto L75;
        int r28 = r27.intValue();
    L76:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l r29 = this.a;
        if (r29 == null) goto L83;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r30 = r29.f;
        if (r30 == null) goto L83;
        Integer r31 = r30.l();
        if (r31 == null) goto L83;
        int r32 = r31.intValue();
    L84:
        if (r32 <= 0) goto L89;
        if (r28 <= 0) goto L89;
        if ((r32 / r28) >= r24) goto L89;
        boolean r33 = true;
    L90:
        if (r33 == false) goto L92;
        Function0<Integer> r34 = new HeadVideoViewV2$configVideoExtraHeight$1(this);
    L93:
        setVideoExtraHeightProvider(r34);
        if (r33 == false) goto L99;
        BasePdpVideoView r35 = g(this.a);
        if (r35 == null) goto L99;
        k83.b.a(r35);
    L99:
        if (this.c != null) goto L158;
        HeadVideoController r36 = new HeadVideoController(new com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.b(this.a, this.i, r18));
        Function1<Boolean, Unit> r37 = this.g;
        Intrinsics.checkNotNullParameter(r37, "listener");
        BasePdpVideoView r110 = r36.d;
        if (r110 == null) goto L105;
        Intrinsics.checkNotNullParameter(r37, "listener");
        y73.a r38 = r110.c;
        if (r38 == null) goto L105;
        r38.l(r37);
    L105:
        r36.b = r19;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r39 = r36.e.Sf().f(r19);
        if (r39 != null) goto L108;
    L157:
        Unit r2 = Unit.INSTANCE;
        this.c = r36;
        goto L158
    L108:
        if (r39.m() == true) goto L110;
        AnchorV4HeadV2VO r40 = r36.e.K10();
        if (r40 == null) goto L157;
        VideoModel r41 = AnchorV4HeadV2VO.getVideoData$default(r40, r19, null, 2, null);
        if (r41 == null) goto L157;
        if (r41.getAutoPlayForBiz() != true) goto L157;
        HeaderMediaModel r42 = r36.f;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == true) goto L124;
        if (r19 == 0) goto L132;
    L136:
        boolean r111 = false;
    L137:
        dm.a.b r112 = dm.a.a("HeadVideoController");
        StringBuilder r113 = new StringBuilder("处理业务自动播放: autoPlay=");
        r113.append(r111);
        r113.append(", position=");
        r113.append(r19);
        r113.append(", headAbility.getCurrentPosition()=");
        r113.append(r36.e.getCurrentPosition());
        r113.append(", headAbility.playerAbility.isFirstBind(position)=");
        r113.append(r36.e.Sf().h(r19));
        r113.append(", canAutoPlay(headAbility)=");
        Lazy r43 = HeadVideoAutoPlayController.a;
        r113.append(HeadVideoAutoPlayController.b(r36.e));
        r112.b(r113.toString(), null);
        if (r111 == false) goto L157;
        Long r44 = HeadVideoAutoPlayController.c(r42.getVideo(), r36.e);
        long r114 = 0;
        if (r44 == null) goto L142;
        long r115 = r44.longValue();
    L143:
        VideoModel r45 = r42.getVideo();
        if (r45 == null) goto L146;
        Integer r46 = r45.getDuration();
    L147:
        if (r46 != null) goto L149;
    L151:
        r114 = r115;
    L152:
        r39.o(r114);
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == false) goto L155;
        Boolean r47 = null;
    L156:
        r36.a(r47);
        r36.e.Gw();
        goto L157
    L155:
        r47 = Boolean.TRUE;
        goto L156
    L149:
        if (r115 < r46.intValue()) goto L151;
    L146:
        r46 = null;
        goto L147
    L142:
        r115 = 0;
        goto L143
    L132:
        if (r36.e.Sf().h(r19) == false) goto L136;
        Lazy r116 = HeadVideoAutoPlayController.a;
        if (HeadVideoAutoPlayController.b(r36.e) == false) goto L136;
    L135:
        r111 = true;
        goto L137
    L124:
        if (r19 != r36.e.getCurrentPosition()) goto L136;
        if (r36.e.Sf().h(r19) == false) goto L136;
        Lazy r117 = HeadVideoAutoPlayController.a;
        if (HeadVideoAutoPlayController.b(r36.e) == false) goto L136;
    L110:
        if (r36.e.Sf().h(r19) == false) goto L157;
        if (r39.n() == false) goto L114;
        r36.a(Boolean.valueOf(r39.n()));
    L114:
        r36.e.Gw();
    L158:
        dm.a.b r48 = dm.a.a("HeadVideoViewV2");
        StringBuilder r49 = new StringBuilder("updateVideoUI, duration = ");
        VideoModel r50 = r18.getVideo();
        if (r50 == null) goto L161;
        String r51 = r50.getVid();
    L162:
        r49.append(r51);
        r48.a(r49.toString());
        VideoCoverLayout r52 = this.d;
        if (r52 == null) goto L207;
        r52.setTotalDuration(getDurationMs());
        boolean r53 = r18.getVideoButtonNewStyle();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.e r54 = r52.m;
        if (r53 == false) goto L168;
        r54.e = -2146035677;
        r54.f = 872415231;
    L168:
        if (r54.g == false) goto L170;
        r54.e = 1712724003;
        r54.f = 0;
    L170:
        HeadVideoController r55 = this.c;
        if (r55 == null) goto L187;
        int r56 = this.e;
        float r118 = com.bytedance.android.ec.core.utils.q.a(79);
        int r119 = r55.e.XU();
        float r120 = k83.a.a(r119, 0);
        if (r119 == 1) goto L175;
    L177:
        if (r119 < 2) goto L183;
        if (r56 != 0) goto L183;
        if (r55.e.wq() == true) goto L183;
    L181:
        r118 = r118 * r120;
    L183:
        if (r118 <= 0) goto L185;
        int r57 = (int) r118;
    L186:
        Integer r58 = Integer.valueOf(r57);
    L188:
        VideoCoverLayout.h(r52, r58);
        boolean r59 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a;
        if (com.bytedance.android.ec.core.abtest.d.w() == true) goto L191;
    L193:
        boolean r60 = false;
    L194:
        if (r60 == false) goto L205;
        String r61 = this.i.rR().getSessionId();
        boolean r121 = this.f;
        VideoModel r62 = r18.getVideo();
        if (r62 == null) goto L198;
        r11 = r62.getVid();
    L198:
        k73.b r63 = new k73.b(r61, r11, getDurationMs(), r18.getVideoInteractor(), VideoComponentScene.HEAD_VIDEO.getScene(), null, new n(this), r121, 32);
        Intrinsics.checkNotNullParameter(r63, "videoComponentInfo");
        dm.a.a("VideoCoverLayout").i("initVideoCtrlContainerComponent videoComponentInfo=" + r63);
        if (r52.k != null) goto L201;
        r52.k = new com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b(r52.getContext(), r52, r63, new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.g(r52));
    L201:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r1 = r52.k;
        if (r1 == null) goto L205;
        r1.i0(r63);
    L205:
        if (this.f == false) goto L207;
        r52.d();
        goto L207
    L191:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L193;
        r60 = true;
        goto L194
    L185:
        r57 = com.bytedance.android.shopping.extensions.b.b(79);
        goto L186
    L175:
        if (r55.e.wq() == true) goto L177;
    L187:
        r58 = null;
    L207:
        VideoCoverLayout r64 = this.d;
        if (r64 == null) goto L219;
        HeadVideoController r65 = this.c;
        if (r65 == null) goto L217;
        BasePdpVideoView r66 = r65.d;
        if (r66 == null) goto L214;
        boolean r67 = r66.isMute();
    L215:
        if (r67 != true) goto L217;
    L218:
        r64.setAudioState(r6);
        goto L219
    L214:
        r67 = false;
    L217:
        r6 = false;
    L219:
        B();
        return;
    L161:
        r51 = null;
        goto L162
    L92:
        r34 = null;
    L89:
        r33 = false;
    L83:
        r32 = 0;
    L75:
        r28 = 0;
        goto L76
    L67:
        r24 = 1.0f;
        goto L68
    L55:
        r17 = -1;
    L62:
        if (r14 == null) goto L64;
        r23 = r14.getWHScale(false);
        goto L65
    L64:
        r23 = null;
    L47:
        r14 = null;
        goto L48
    L26:
        if ((!Intrinsics.areEqual(r10.e.getParentView(), this)) == false) goto L42;
        ViewParent r68 = r10.e.getParentView();
        if ((r68 instanceof ViewGroup) == true) goto L30;
        r68 = null;
    L30:
        ViewGroup r69 = (ViewGroup) r68;
        if (r69 == null) goto L33;
        r69.removeView(g(r10));
    L33:
        addView(g(r10), 0);
        VideoCoverLayout r70 = this.d;
        if (r70 == null) goto L42;
        VideoModel r71 = r10.g;
        if (r71 == null) goto L40;
        ImageModel r72 = r71.getPosterImage();
        if (r72 == null) goto L40;
        ECUrlModel r73 = r72.getRemote();
    L41:
        r70.c(r73, new HeadVideoViewV2$initializeBasePdVideoView$$inlined$let$lambda$1(this));
    L40:
        r73 = null;
        goto L41
    }
}
