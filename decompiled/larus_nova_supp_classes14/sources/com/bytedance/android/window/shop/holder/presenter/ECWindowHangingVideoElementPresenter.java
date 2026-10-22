package com.bytedance.android.window.shop.holder.presenter;

import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.bytedance.android.ec.window.base.view.ECWindowRemoteVideoView;
import com.bytedance.android.ec.window.base.view.ECWindowVideoView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowHangingVideoElementPresenter extends ECWindowHolderBasePresenter implements tp.c {
    public static final b o = null;
    public static final b p = null;
    public final b g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final c l;
    public com.bytedance.android.window.shop.repository.tab.entity.e m;
    public final vp.c n;

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
            this.a = 1.0f / RangesKt.coerceIn(r2, 0.01f, 0.99f);
        }
    }

    public static final class c implements com.bytedance.android.ec.window.base.utils.playable.impl.video.e {
        public final /* synthetic */ ECWindowHangingVideoElementPresenter a;

        public final void e() {
        }

        public final void onStartPlay() {
        }

        public final void onStopPlay() {
        }

        public c(ECWindowHangingVideoElementPresenter r1) {
            this.a = r1;
        }

        public final void a(long r3, long r5) {
            TextView r0 = (TextView) this.a.h.getValue();
            this.a.getClass();
            r0.setText(ECWindowHangingVideoElementPresenter.F(r5 - r3));
        }
    }

    public final void B() {
        this.n.B();
    }

    public final void C() {
        this.m = null;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.d r1 = G();
        r1.getClass();
        tp.c.a.h(r1);
        ((com.bytedance.android.ec.window.base.utils.playable.impl.video.f) G()).a = null;
        this.n.a = null;
    }

    public final boolean D3() {
        return this.n.D3();
    }

    public final com.bytedance.android.ec.window.base.utils.playable.impl.video.d G() {
        return (com.bytedance.android.ec.window.base.utils.playable.impl.video.d) this.k.getValue();
    }

    public final void R() {
        this.n.R();
    }

    public final boolean g0() {
        return this.n.g0();
    }

    public final boolean isPlaying() {
        return this.n.isPlaying();
    }

    public final tp.b m() {
        return this.n.m();
    }

    public final void o2(tp.b r2) {
        this.n.o2(r2);
    }

    public final Rect r() {
        this.n.getClass();
        return null;
    }

    public final void startPlay() {
        this.n.startPlay();
    }

    public final void stopPlay() {
        this.n.stopPlay();
    }

    public final void v() {
        this.n.v();
    }

    static {
        o = new b(1.0f, "h,1:1");
        p = new b(0.75f, "h,3:4");
    }

    public final void I() {
        TextView r0 = (TextView) this.h.getValue();
        com.bytedance.android.window.shop.repository.tab.entity.e r1 = this.m;
        if (r1 == null) goto L5;
        long r2 = RangesKt.coerceIn(r1.c, 0, 3599000);
    L6:
        r0.setText(F(r2));
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final void M() {
        vp.c r0 = this.n;
        r0.getClass();
        tp.c.a.a(r0);
    }

    public final WindowPlayAbleType P() {
        this.n.getClass();
        return WindowPlayAbleType.OTHER;
    }

    public final void U0() {
        vp.c r0 = this.n;
        r0.getClass();
        tp.c.a.b(r0);
    }

    public final void pausePlay() {
        vp.c r0 = this.n;
        r0.getClass();
        tp.c.a.e(r0);
    }

    public final boolean resumePlay() {
        vp.c r0 = this.n;
        r0.getClass();
        return tp.c.a.f(r0);
    }

    public final void x() {
        vp.c r0 = this.n;
        r0.getClass();
        tp.c.a.c(r0);
    }

    public final void z() {
        vp.c r0 = this.n;
        r0.getClass();
        tp.c.a.d(r0);
    }

    public static String F(long r6) {
        long r7 = RangesKt.coerceIn(r6, 0, 3599000) / 1000;
        long r0 = 60;
        long r2 = r7 / r0;
        long r8 = r7 % r0;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        return String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r2), Long.valueOf(r8)}, 2));
    }

    public final void A(QModel r3) {
        if ((r3 instanceof com.bytedance.android.window.shop.repository.tab.entity.e) == true) goto L5;
        r3 = null;
    L5:
        com.bytedance.android.window.shop.repository.tab.entity.e r4 = (com.bytedance.android.window.shop.repository.tab.entity.e) r3;
        this.m = r4;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.d r0 = G();
        ((com.bytedance.android.ec.window.base.utils.playable.impl.video.f) r0).a = this.l;
        if (r4 == null) goto L12;
        ECUrlModel r5 = r4.a;
        if (r5 == null) goto L12;
        String r6 = r5.getFirstUrl();
        if (r6 == null) goto L12;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.d r1 = G();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "source");
        r1.c = r6;
    L12:
        com.bytedance.android.window.shop.repository.tab.entity.e r7 = this.m;
        if (r7 == null) goto L34;
        String r8 = r7.b.getFirstUrl();
        if (r8 == null) goto L18;
        ((ECWindowRemoteVideoView) this.j.getValue()).setCoverUrl(r8);
    L18:
        View r9 = (View) this.i.getValue();
        ConstraintLayout.LayoutParams r2 = ((View) this.i.getValue()).getLayoutParams();
        if (r2 == null) goto L37;
        ConstraintLayout.LayoutParams r10 = r2;
        r10.dimensionRatio = this.g.c;
        Unit r11 = Unit.INSTANCE;
        r9.setLayoutParams(r10);
        ECWindowRemoteVideoView r12 = (ECWindowRemoteVideoView) this.j.getValue();
        com.bytedance.android.window.shop.repository.tab.entity.e r13 = this.m;
        if (r13 == null) goto L34;
        ECUrlModel r14 = r13.a;
        if (r14 != null) goto L26;
    L28:
        float r15 = RangesKt.coerceAtLeast(r13.b(), 1.0f);
        if (r15 <= this.g.a) goto L32;
        r12.setScaleType(ECWindowVideoView.ScaleType.FIT_CENTER);
    L32:
        if (r15 >= this.g.b) goto L34;
        r12.setScaleType(ECWindowVideoView.ScaleType.CENTER_CROP);
        goto L34
    L26:
        if (r14.getHeight() != 0) goto L28;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L34:
        I();
        vp.c r16 = this.n;
        r16.a = G();
    }

    public final List<tp.c> L(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleArea");
        if (isPlaying() == false) goto L5;
        float r0 = 0.5f;
    L7:
        if (tp.e.b((ECWindowRemoteVideoView) this.j.getValue(), r3, r0) == true) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.listOf(G());
    L5:
        r0 = 1.0f;
        goto L7
    }

    public ECWindowHangingVideoElementPresenter(vp.c r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "playableProxy");
        this.n = r2;
        if (r3 == false) goto L5;
        b r4 = o;
    L6:
        this.g = r4;
        this.h = LazyKt.lazy(new ECWindowHangingVideoElementPresenter$videoDurationView$2(this));
        this.i = LazyKt.lazy(new ECWindowHangingVideoElementPresenter$videoViewWrapper$2(this));
        this.j = LazyKt.lazy(new ECWindowHangingVideoElementPresenter$videoView$2(this));
        this.k = LazyKt.lazy(new ECWindowHangingVideoElementPresenter$ecVideoViewPlayable$2(this));
        this.l = new c(this);
        return;
    L5:
        r4 = p;
        goto L6
    }
}
