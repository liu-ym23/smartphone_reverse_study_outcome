package com.bytedance.android.window.shop.holder.presenter;

import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.bytedance.android.ec.window.base.view.ECWindowRemoteVideoView;
import com.bytedance.android.ec.window.base.view.ECWindowVideoView;
import com.bytedance.android.window.shop.repository.tab.entity.ProductVideoVO;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowPlayableProductVideoElementPresenter extends com.bytedance.android.window.shop.holder.presenter.b {
    public static final b m = null;
    public static final b n = null;
    public final c g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public ProductVideoVO k;
    public final vp.c l;

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
        public final /* synthetic */ ECWindowPlayableProductVideoElementPresenter a;

        public final void e() {
        }

        public final void onStartPlay() {
        }

        public final void onStopPlay() {
        }

        public c(ECWindowPlayableProductVideoElementPresenter r1) {
            this.a = r1;
        }

        public final void a(long r2, long r4) {
            ProductVideoVO r5 = this.a.k;
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
        this.l.B();
    }

    public final void C() {
        this.k = null;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.d r1 = G();
        r1.getClass();
        tp.c.a.h(r1);
        ((com.bytedance.android.ec.window.base.utils.playable.impl.video.f) G()).a = null;
        this.l.a = null;
    }

    public final boolean D3() {
        return this.l.D3();
    }

    public final com.bytedance.android.ec.window.base.utils.playable.impl.video.d G() {
        return (com.bytedance.android.ec.window.base.utils.playable.impl.video.d) this.j.getValue();
    }

    public final void R() {
        this.l.R();
    }

    public final boolean g0() {
        return this.l.g0();
    }

    public final boolean isPlaying() {
        return this.l.isPlaying();
    }

    public final tp.b m() {
        return this.l.m();
    }

    public final void o2(tp.b r2) {
        this.l.o2(r2);
    }

    public final Rect r() {
        this.l.getClass();
        return null;
    }

    public final void startPlay() {
        this.l.startPlay();
    }

    public final void stopPlay() {
        this.l.stopPlay();
    }

    public final void v() {
        this.l.v();
    }

    static {
        m = new b(1.0f, "h,1:1");
        n = new b(0.75f, "h,3:4");
    }

    public final b I() {
        ProductVideoVO r0 = this.k;
        if (r0 == null) goto L5;
        double r3 = r0.g;
    L7:
        if (Math.abs(r3 - 1.0d) >= 1.0E-6d) goto L10;
        return m;
    L10:
        return n;
    L5:
        r3 = 1.0d;
        goto L7
    }

    public final void M() {
        vp.c r0 = this.l;
        r0.getClass();
        tp.c.a.a(r0);
    }

    public final WindowPlayAbleType P() {
        this.l.getClass();
        return WindowPlayAbleType.OTHER;
    }

    public final void U0() {
        vp.c r0 = this.l;
        r0.getClass();
        tp.c.a.b(r0);
    }

    public final void pausePlay() {
        vp.c r0 = this.l;
        r0.getClass();
        tp.c.a.e(r0);
    }

    public final boolean resumePlay() {
        vp.c r0 = this.l;
        r0.getClass();
        return tp.c.a.f(r0);
    }

    public final void x() {
        vp.c r0 = this.l;
        r0.getClass();
        tp.c.a.c(r0);
    }

    public final void z() {
        vp.c r0 = this.l;
        r0.getClass();
        tp.c.a.d(r0);
    }

    @Override // com.bytedance.android.window.shop.holder.presenter.b
    public final long F() {
        com.bytedance.android.ec.window.base.utils.playable.impl.video.d r0 = G();
        if (r0.isPlaying() == false) goto L8;
        Long r1 = r0.d;
        if (r1 == null) goto L8;
        return r1.longValue();
    L8:
        return 0;
    }

    public ECWindowPlayableProductVideoElementPresenter(vp.c r2) {
        Intrinsics.checkNotNullParameter(r2, "playableProxy");
        this.l = r2;
        this.g = new c(this);
        this.h = LazyKt.lazy(new ECWindowPlayableProductVideoElementPresenter$videoViewWrapper$2(this));
        this.i = LazyKt.lazy(new ECWindowPlayableProductVideoElementPresenter$videoView$2(this));
        this.j = LazyKt.lazy(new ECWindowPlayableProductVideoElementPresenter$ecVideoViewPlayable$2(this));
    }

    public final void A(QModel r4) {
        Long r1 = null;
        if ((r4 instanceof ProductVideoVO) == true) goto L5;
        r4 = null;
    L5:
        ProductVideoVO r5 = (ProductVideoVO) r4;
        this.k = r5;
        if (r5 == null) goto L18;
        ECUrlModel r6 = r5.a;
        if (r6 == null) goto L18;
        String r7 = r6.getFirstUrl();
        if (r7 == null) goto L18;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.d r0 = G();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "source");
        r0.c = r7;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.d r8 = G();
        ProductVideoVO r2 = this.k;
        if (r2 == null) goto L14;
        r1 = r2.h;
    L14:
        if (r1 != null) goto L16;
        boolean r3 = true;
    L17:
        r8.i = r3;
        r8.a().n(r3);
        goto L18
    L16:
        r3 = false;
    L18:
        ProductVideoVO r9 = this.k;
        if (r9 == null) goto L40;
        String r10 = r9.b.getFirstUrl();
        if (r10 == null) goto L24;
        ((ECWindowRemoteVideoView) this.i.getValue()).setCoverUrl(r10);
    L24:
        View r11 = (View) this.h.getValue();
        ConstraintLayout.LayoutParams r12 = ((View) this.h.getValue()).getLayoutParams();
        if (r12 == null) goto L43;
        ConstraintLayout.LayoutParams r13 = r12;
        r13.dimensionRatio = I().c;
        Unit r14 = Unit.INSTANCE;
        r11.setLayoutParams(r13);
        ECWindowRemoteVideoView r15 = (ECWindowRemoteVideoView) this.i.getValue();
        ProductVideoVO r16 = this.k;
        if (r16 == null) goto L40;
        ECUrlModel r17 = r16.a;
        if (r17 != null) goto L32;
    L34:
        float r18 = RangesKt.coerceAtLeast(r16.b(), 1.0f);
        if (r18 <= I().a) goto L38;
        r15.setScaleType(ECWindowVideoView.ScaleType.FIT_CENTER);
    L38:
        if (r18 >= I().b) goto L40;
        r15.setScaleType(ECWindowVideoView.ScaleType.CENTER_CROP);
        goto L40
    L32:
        if (r17.getHeight() != 0) goto L34;
    L43:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L40:
        this.l.a = G();
        ((com.bytedance.android.ec.window.base.utils.playable.impl.video.f) G()).a = this.g;
    }

    public final List<tp.c> L(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleArea");
        if (isPlaying() == false) goto L5;
        float r0 = 0.5f;
    L7:
        if (tp.e.b((ECWindowRemoteVideoView) this.i.getValue(), r3, r0) == true) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.listOf(G());
    L5:
        r0 = 1.0f;
        goto L7
    }
}
