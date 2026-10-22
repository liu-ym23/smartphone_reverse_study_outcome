package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.VideoCtrlContainerComponent;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class VideoCoverLayout extends FrameLayout {
    public static final int t = 0;
    public static final int u = 0;
    public boolean a;
    public int b;
    public final Paint c;
    public final RectF d;
    public float e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b k;
    public final VideoProgressTextLayout l;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.e m;
    public final e n;
    public final VideoProgressBar o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final f s;

    public static final class a implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b {
        public final /* synthetic */ VideoCoverLayout a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
        public final void onDragEnd() {
            VideoCoverLayout r0 = this.a;
            r0.s.b();
            if (r0.g == false) goto L5;
        L6:
            ViewExtensionsKt.i(r0.m);
            return;
        L5:
            if (HeadVideoAutoPlayController.f == true) goto L6;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
        public final void onDragStart() {
            VideoCoverLayout r0 = this.a;
            r0.s.c();
            r0.n.run();
            float r1 = r0.o.getDragProgress();
            VideoProgressTextLayout r2 = r0.l;
            int r3 = r0.f;
            r2.a.setText(VideoProgressTextLayout.a((int) (r1 * r3)));
            r2.b.setText(VideoProgressTextLayout.a(r3));
        }

        public a(VideoCoverLayout r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
        public final void a(float r2) {
            this.a.s.a(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
        public final void b(float r4) {
            VideoCoverLayout r0 = this.a;
            VideoProgressTextLayout r1 = r0.l;
            int r2 = r0.f;
            r1.a.setText(VideoProgressTextLayout.a((int) (r4 * r2)));
            r1.b.setText(VideoProgressTextLayout.a(r2));
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
        public final void c(float r2) {
            VideoCoverLayout r0 = this.a;
            r0.e = r2;
            r0.l.setAlpha(r2);
            this.a.invalidate();
        }
    }

    public static final class b {
    }

    public static final class c extends z53.a {
        public final /* synthetic */ List f;
        public final /* synthetic */ Function0 g;

        public c(List r7, Function0 r8, List r9, String r10, Function0 r11) {
            this.f = r7;
            this.g = r8;
            super(r9, r10, r11, false, 8);
        }
    }

    public static final class d implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.a {
        public final /* synthetic */ VideoCoverLayout a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.a
        public final void a() {
            if (this.a.m.getVisibility() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            VideoCoverLayout r1 = this.a;
            r1.s.h(!r1.g);
            return;
        L9:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.a
        public final void b() {
            if (this.a.m.getVisibility() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            VideoCoverLayout r1 = this.a;
            r1.s.k(!r1.h);
            return;
        L9:
            return;
        L5:
            r0 = false;
            goto L6
        }

        public final boolean c() {
            return this.a.s.j();
        }

        public d(VideoCoverLayout r1) {
            this.a = r1;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ VideoCoverLayout a;

        @Override // java.lang.Runnable
        public final void run() {
            ViewExtensionsKt.c(this.a.m, true, 1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(VideoCoverLayout r1) {
            this.a = r1;
        }
    }

    private static /* synthetic */ void getHideButtonAction$annotations() {
    }

    private final ECDraweeView getMCoverImageView() {
        return (ECDraweeView) this.r.getValue();
    }

    private final ECStatusView getMLoadingView() {
        return (ECStatusView) this.p.getValue();
    }

    private final ImageView getMPlayButtonView() {
        return (ImageView) this.q.getValue();
    }

    static {
        t = com.bytedance.android.shopping.extensions.b.a(60);
        u = com.bytedance.android.shopping.extensions.b.a(110);
    }

    public final void g() {
        removeCallbacks(this.n);
        boolean r0 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a;
        if (com.bytedance.android.ec.core.abtest.d.w() == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L11;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.e r2 = this.m;
        r2.setVisibility(0);
        r2.setAlpha(1.0f);
        this.o.setVisibility(0);
        this.l.setVisibility(0);
        ExtensionsKt.gone(getMPlayButtonView());
        getMCoverImageView().setVisibility(4);
    L15:
        setPlayState(true);
        if (this.i == true) goto L19;
        this.i = true;
        this.s.g(this.h);
        this.s.e(this.g);
        return;
    L19:
        return;
    L11:
        if (this.a == true) goto L13;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.e r3 = this.m;
        r3.setVisibility(0);
        r3.setAlpha(1.0f);
        this.o.setVisibility(0);
        this.l.setVisibility(0);
        ExtensionsKt.gone(getMPlayButtonView());
        getMCoverImageView().setVisibility(4);
        goto L15
    L13:
        ExtensionsKt.gone(this.m);
        ExtensionsKt.gone(this.o);
        ExtensionsKt.gone(this.l);
        ExtensionsKt.gone(getMPlayButtonView());
        ExtensionsKt.gone(getMCoverImageView());
        goto L15
    L5:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L7;
        r1 = true;
        goto L9
    }

    public final void d() {
        ExtensionsKt.gone(getMPlayButtonView());
    }

    public final void e() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L5;
    L12:
        setPlayState(false);
        return;
    L5:
        if (ViewCompat.isAttachedToWindow(this) == false) goto L10;
        if (HeadVideoAutoPlayController.f == true) goto L12;
        postDelayed(this.n, 200);
        goto L12
    L10:
        if (HeadVideoAutoPlayController.f == true) goto L12;
        this.n.run();
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.j == false) goto L5;
        return;
    L5:
        if (this.s.i() == false) goto L9;
        this.j = true;
        Lazy r0 = UIUtils.a;
        UIUtils.f(this, AnonymousClass1.INSTANCE);
        return;
    }

    public static final void a(VideoCoverLayout r2) {
        r2.m.setVisibility(0);
        r2.o.setVisibility(0);
        r2.getMPlayButtonView().setVisibility(0);
    }

    public static final void b(VideoCoverLayout r1) {
        ExtensionsKt.gone(r1.m);
        ExtensionsKt.gone(r1.o);
        ExtensionsKt.gone(r1.l);
        ExtensionsKt.gone(r1.getMPlayButtonView());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        int r0 = u;
        int r1 = t;
        float r2 = ((r0 - r1) * this.e) + r1;
        int r3 = com.bytedance.android.ec.hybrid.list.util.c.a;
        float r4 = r2 + com.bytedance.android.ec.hybrid.list.util.c.d(12);
        if (this.d.height() == r4) goto L5;
    L8:
        float r5 = getHeight() + com.bytedance.android.ec.hybrid.list.util.c.d(12);
        this.d.set(0.0f, r5 - r4, getWidth(), r5);
        Paint r6 = this.c;
        RectF r7 = this.d;
        r6.setShader(new LinearGradient(0.0f, r7.top, 0.0f, r7.bottom, 0, 520093696, Shader.TileMode.CLAMP));
    L9:
        r11.drawRect(this.d, this.c);
        super.dispatchDraw(r11);
        return;
    L5:
        if (this.d.width() != getWidth()) goto L8;
        if (this.d.bottom == getBottom()) goto L9;
        goto L8
    }

    public final void f(boolean r2) {
        if (HeadVideoAutoPlayController.f == false) goto L5;
        if (r2 == true) goto L5;
    L6:
        ExtensionsKt.gone(this.o);
        this.o.d(0.0f);
        ExtensionsKt.gone(this.l);
        getMCoverImageView().setVisibility(0);
        setPlayState(false);
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r3 = this.k;
        if (r3 == null) goto L10;
        r3.j0();
        return;
    L10:
        return;
    L5:
        ExtensionsKt.gone(this.m);
        goto L6
    }

    public final void i(boolean r1) {
        if (r1 == false) goto L4;
        getMLoadingView().c();
        return;
    L4:
        getMLoadingView().a();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        if (this.o.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        if (this.o.b(r3) == false) goto L11;
        return true;
    L11:
        return super.onTouchEvent(r3);
    L5:
        r0 = false;
        goto L6
    }

    public final void setAudioState(boolean r2) {
        this.m.setAudioState(r2);
        this.h = r2;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r3 = this.k;
        if (r3 == null) goto L8;
        VideoCtrlContainerComponent r4 = r3.c;
        if (r4 == null) goto L9;
        int r0 = VideoCtrlContainerComponent.g;
        r4.c(0);
        return;
    L9:
        return;
    }

    public final void setPlayState(boolean r2) {
        this.m.setPlayState(r2);
        this.g = r2;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r3 = this.k;
        if (r3 == null) goto L8;
        VideoCtrlContainerComponent r4 = r3.c;
        if (r4 == null) goto L9;
        int r0 = VideoCtrlContainerComponent.g;
        r4.c(0);
        return;
    L9:
        return;
    }

    public final void setProgress(float r5) {
        VideoProgressBar r0 = this.o;
        r0.getClass();
        r0.c = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r5, 1.0f), 0.0f);
        r0.invalidate();
        if (this.g == false) goto L5;
    L7:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r1 = this.k;
        if (r1 == null) goto L11;
        r1.m0(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r5, 1.0f), 0.0f), this.f * 1000.0f);
        return;
    L11:
        return;
    L5:
        if (this.s.isPlaying() == false) goto L7;
        g();
        goto L7
    }

    public final void setTotalDuration(int r1) {
        this.f = r1 / 1000;
    }

    public VideoCoverLayout(final Context r14, f r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "callback");
        super(r14);
        this.s = r15;
        this.b = 2131234767;
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        Unit r2 = Unit.INSTANCE;
        this.c = r0;
        this.d = new RectF();
        this.h = true;
        VideoProgressTextLayout r1 = new VideoProgressTextLayout(r14, null);
        r1.setAlpha(0.0f);
        this.l = r1;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.e r4 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.e(r14, new d(this));
        this.m = r4;
        this.n = new e(this);
        VideoProgressBar r3 = new VideoProgressBar(r14, null);
        int r5 = (int) 3858759679L;
        if (r15.j() == false) goto L5;
        int r11 = (int) 3439329279L;
        int r10 = 1291845631;
    L6:
        VideoProgressBar.a(r3, new a(this), false, null, null, r10, r11, 30);
        this.o = r3;
        this.p = LazyKt.lazy(new VideoCoverLayout$mLoadingView$2(r14));
        this.q = LazyKt.lazy(new VideoCoverLayout$mPlayButtonView$2(this, r14));
        this.r = LazyKt.lazy(new VideoCoverLayout$mCoverImageView$2(this, r14));
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L9;
        addView(getMCoverImageView());
        addView(getMPlayButtonView());
        addView(getMLoadingView());
    L9:
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-2, -2);
        r16.leftMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r16.bottomMargin = com.bytedance.android.shopping.extensions.b.a(8);
        r16.rightMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r16.gravity = 80;
        addView(r3, r16);
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-2, -2);
        r17.gravity = 81;
        r17.bottomMargin = com.bytedance.android.shopping.extensions.b.a(36);
        addView(r1, r17);
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-2, -2);
        if (r15.j() == false) goto L12;
        int r19 = 0;
    L13:
        r18.leftMargin = r19;
        r18.bottomMargin = com.bytedance.android.shopping.extensions.b.a(16);
        r18.gravity = 80;
        addView(r4, r18);
        setClipChildren(false);
        f(true);
        return;
    L12:
        r19 = com.bytedance.android.shopping.extensions.b.a(3);
        goto L13
    L5:
        r11 = r5;
        r10 = 1308622847;
        goto L6
    }

    public static void h(VideoCoverLayout r2, Integer r3) {
        Integer r0 = 2131234767;
        if (r0 == null) goto L5;
        r2.b = r0.intValue();
        r2.getMPlayButtonView().setBackgroundResource(r2.b);
    L5:
        if (r3 == null) goto L8;
        int r4 = r3.intValue();
        ImageView r1 = r2.getMPlayButtonView();
        ViewGroup.LayoutParams r5 = r2.getMPlayButtonView().getLayoutParams();
        r5.width = r4;
        r5.height = r4;
        Unit r6 = Unit.INSTANCE;
        r1.setLayoutParams(r5);
        return;
    }

    public final void c(ECUrlModel r20, final Function0<Unit> r21) {
        List r2 = null;
        if (r20 == null) goto L5;
        List r7 = r20.getUrlList();
    L6:
        if (r7 != null) goto L8;
    L10:
        ECDraweeView r4 = getMCoverImageView();
        if (r20 == null) goto L13;
        r2 = r20.getUrlList();
    L13:
        y.c(r4, r20, -1, -1, new z53.a(r2, ImagePosition.GOODS_HEADER.getValue(), new VideoCoverLayout$bindVideoCoverModel$4(this, r21), false, 24));
        return;
    L8:
        if ((!r7.isEmpty()) != true) goto L10;
        List r6 = r7;
        ImageExtensionsKt.x(getMCoverImageView(), r6, null, null, null, null, null, null, new c(r7, r21, r7, ImagePosition.GOODS_HEADER.getValue(), new VideoCoverLayout$bindVideoCoverModel$2(this, r21)), false, null, VideoCoverLayout$bindVideoCoverModel$3.INSTANCE, null, 7038);
        return;
    L5:
        r7 = null;
        goto L6
    }
}
