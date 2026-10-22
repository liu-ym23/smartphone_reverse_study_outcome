package com.bytedance.android.window.shop.holder.presenter;

import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.window.shop.repository.tab.entity.ProductVideoVO;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowPlayableProductOptVideoElementPresenter extends com.bytedance.android.window.shop.holder.presenter.b {
    public static final b o = null;
    public static final b p = null;
    public final c g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public ProductVideoVO l;
    public final vp.c m;
    public final boolean n;

    public static final class a {
    }

    public static final class b {
        public final float a;
        public final float b;
        public final String c;

        public b(float r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "constraintDimensionRatio");
            this.b = r2;
            this.c = r3;
            this.a = 1.0f / RangesKt.coerceIn(r2, 0.01f, 100.0f);
        }
    }

    public static final class c implements com.bytedance.android.ec.window.base.utils.playable.impl.video.e {
        public final /* synthetic */ ECWindowPlayableProductOptVideoElementPresenter a;

        public final void e() {
        }

        public final void onStartPlay() {
        }

        public final void onStopPlay() {
        }

        public c(ECWindowPlayableProductOptVideoElementPresenter r1) {
            this.a = r1;
        }

        public final void a(long r2, long r4) {
            ProductVideoVO r5 = this.a.l;
            if (r5 == null) goto L12;
            Long r6 = r5.h;
            if (r6 != null) goto L7;
            return;
        L7:
            if (r2 < r6.longValue()) goto L14;
            this.a.stopPlay();
            tp.b r3 = this.a.m();
            if (r3 == null) goto L15;
            r3.b(this.a.G());
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public final void B() {
        this.m.B();
    }

    public final void C() {
        this.l = null;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.b r1 = G();
        r1.getClass();
        tp.c.a.h(r1);
        ((com.bytedance.android.ec.window.base.utils.playable.impl.video.f) G()).a = null;
        this.m.a = null;
    }

    public final boolean D3() {
        return this.m.D3();
    }

    public final com.bytedance.android.ec.window.base.utils.playable.impl.video.b G() {
        return (com.bytedance.android.ec.window.base.utils.playable.impl.video.b) this.k.getValue();
    }

    public final void R() {
        this.m.R();
    }

    public final boolean g0() {
        return this.m.g0();
    }

    public final boolean isPlaying() {
        return this.m.isPlaying();
    }

    public final tp.b m() {
        return this.m.m();
    }

    public final void o2(tp.b r2) {
        this.m.o2(r2);
    }

    public final Rect r() {
        this.m.getClass();
        return null;
    }

    public final void startPlay() {
        this.m.startPlay();
    }

    public final void stopPlay() {
        this.m.stopPlay();
    }

    public final void v() {
        this.m.v();
    }

    static {
        o = new b(1.0f, "h,1:1");
        p = new b(0.75f, "h,3:4");
    }

    public final b I() {
        if (this.n == true) goto L5;
        ProductVideoVO r0 = this.l;
        if (r0 == null) goto L9;
        double r3 = r0.g;
    L11:
        if (Math.abs(r3 - 1.0d) >= 1.0E-6d) goto L14;
        return o;
    L14:
        return p;
    L9:
        r3 = 1.0d;
        goto L11
    L5:
        return o;
    }

    public final void M() {
        vp.c r0 = this.m;
        r0.getClass();
        tp.c.a.a(r0);
    }

    public final WindowPlayAbleType P() {
        this.m.getClass();
        return WindowPlayAbleType.OTHER;
    }

    public final void U0() {
        vp.c r0 = this.m;
        r0.getClass();
        tp.c.a.b(r0);
    }

    public final void pausePlay() {
        vp.c r0 = this.m;
        r0.getClass();
        tp.c.a.e(r0);
    }

    public final boolean resumePlay() {
        vp.c r0 = this.m;
        r0.getClass();
        return tp.c.a.f(r0);
    }

    public final void x() {
        vp.c r0 = this.m;
        r0.getClass();
        tp.c.a.c(r0);
    }

    public final void z() {
        vp.c r0 = this.m;
        r0.getClass();
        tp.c.a.d(r0);
    }

    @Override // com.bytedance.android.window.shop.holder.presenter.b
    public final long F() {
        G().isPlaying();
        return 0;
    }

    public final void A(QModel r7) {
        Long r1 = null;
        if ((r7 instanceof ProductVideoVO) == true) goto L5;
        r7 = null;
    L5:
        ProductVideoVO r8 = (ProductVideoVO) r7;
        this.l = r8;
        if (r8 == null) goto L16;
        com.bytedance.android.shopping.api.video.e r9 = (com.bytedance.android.shopping.api.video.e) r8.f.getValue();
        if (r9 == null) goto L16;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.b r0 = G();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r9, "source");
        r0.c = r9;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.b r10 = G();
        ProductVideoVO r2 = this.l;
        if (r2 == null) goto L12;
        r1 = r2.h;
    L12:
        if (r1 != null) goto L14;
        boolean r3 = true;
    L15:
        r10.g = r3;
        r10.f.j(r3);
        goto L16
    L14:
        r3 = false;
    L16:
        ProductVideoVO r11 = this.l;
        if (r11 == null) goto L38;
        String r4 = r11.b.getFirstUrl();
        if (r4 == null) goto L22;
        h0.e((SimpleDraweeView) this.j.getValue(), r4, D().getImageCallerContext(), null, null, 120);
    L22:
        View r12 = (View) this.h.getValue();
        ConstraintLayout.LayoutParams r5 = ((View) this.h.getValue()).getLayoutParams();
        if (r5 == null) goto L41;
        ConstraintLayout.LayoutParams r6 = r5;
        r6.dimensionRatio = I().c;
        Unit r13 = Unit.INSTANCE;
        r12.setLayoutParams(r6);
        ECVideoPlayerView r14 = (ECVideoPlayerView) this.i.getValue();
        ProductVideoVO r15 = this.l;
        if (r15 == null) goto L38;
        ECUrlModel r16 = r15.a;
        if (r16 != null) goto L30;
    L32:
        float r17 = RangesKt.coerceAtLeast(r15.b(), 1.0f);
        if (r17 <= I().a) goto L36;
        ((SimpleDraweeView) this.j.getValue()).getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r14.w(ScaleType.CENTER_CROP);
    L36:
        if (r17 >= I().b) goto L38;
        ((SimpleDraweeView) this.j.getValue()).getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r14.w(ScaleType.CENTER_CROP);
        goto L38
    L30:
        if (r16.getHeight() != 0) goto L32;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L38:
        this.m.a = G();
        ((com.bytedance.android.ec.window.base.utils.playable.impl.video.f) G()).a = this.g;
    }

    public final List<tp.c> L(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleArea");
        ProductVideoVO r0 = this.l;
        if (r0 == null) goto L8;
        com.bytedance.android.shopping.api.video.e r1 = (com.bytedance.android.shopping.api.video.e) r0.f.getValue();
        if (r1 == null) goto L8;
        List r2 = r1.d;
        if (r2 == null) goto L8;
    L10:
        if (r2.isEmpty() == true) goto L36;
        List r4 = r2;
        if ((r4 instanceof Collection) == true) goto L14;
    L16:
        Iterator r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L22;
        if (((com.bytedance.android.shopping.api.video.b) r5.next()).e.isEmpty() == false) goto L18;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L36;
        if (isPlaying() == false) goto L28;
        float r7 = 0.5f;
    L30:
        if (tp.e.b((ECVideoPlayerView) this.i.getValue(), r3, r7) == true) goto L34;
        return CollectionsKt.emptyList();
    L34:
        return CollectionsKt.listOf(G());
    L28:
        r7 = 1.0f;
    L22:
        r6 = false;
        goto L23
    L14:
        if (r4.isEmpty() == false) goto L16;
    L36:
        return CollectionsKt.emptyList();
    L8:
        r2 = CollectionsKt.emptyList();
        goto L10
    }

    public ECWindowPlayableProductOptVideoElementPresenter(vp.c r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "playableProxy");
        this.m = r2;
        this.n = r3;
        this.g = new c(this);
        this.h = LazyKt.lazy(new ECWindowPlayableProductOptVideoElementPresenter$videoViewWrapper$2(this));
        this.i = LazyKt.lazy(new ECWindowPlayableProductOptVideoElementPresenter$videoView$2(this));
        this.j = LazyKt.lazy(new ECWindowPlayableProductOptVideoElementPresenter$videoCoverView$2(this));
        this.k = LazyKt.lazy(new ECWindowPlayableProductOptVideoElementPresenter$ecVideoViewPlayable$2(this));
    }
}
