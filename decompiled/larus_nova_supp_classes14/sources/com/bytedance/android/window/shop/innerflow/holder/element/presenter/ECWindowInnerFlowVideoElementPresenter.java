package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.view.ECWindowRemoteVideoView;
import com.bytedance.android.ec.window.base.view.ECWindowVideoView;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.window.shop.innerflow.widget.ControllerState;
import com.bytedance.android.window.shop.innerflow.widget.ControllerType;
import com.bytedance.android.window.shop.innerflow.widget.ECControllerViewGroup;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowInnerFlowVideoElementPresenter extends d<wp3.g> {
    public static final Map<ControllerState, Integer> r = null;
    public static final Map<ControllerState, Integer> s = null;
    public static final a t = null;
    public wp3.g g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final b n;
    public final c o;
    public final vp.c p;
    public final vp.c q;

    public static final class a {
        public a() {
        }

        public static ControllerState a(ControllerState r1) {
            Intrinsics.checkNotNullParameter(r1, "oldState");
            int r2 = h.a[r1.ordinal()];
            if (r2 == 1) goto L10;
            if (r2 != 2) goto L8;
            return ControllerState.ENABLED;
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return ControllerState.DISABLED;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECWindowInnerFlowVideoElementPresenter a;

        public b(ECWindowInnerFlowVideoElementPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ControllerState r4 = (ControllerState) r3;
            Intrinsics.checkNotNullParameter(r4, "newState");
            this.a.F().c(ControllerType.BARRAGE, r4);
            this.a.I(r4);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECWindowInnerFlowVideoElementPresenter a;

        public c(ECWindowInnerFlowVideoElementPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ControllerState r4 = (ControllerState) r3;
            Intrinsics.checkNotNullParameter(r4, "newState");
            this.a.F().c(ControllerType.VOLUME, r4);
            this.a.K(r4);
        }
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void E() {
        this.g = null;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.d r0 = G();
        r0.getClass();
        r0.B();
        r0.z();
        ((QLiveData) this.i.getValue()).f(this.o);
        ((QLiveData) this.j.getValue()).f(this.n);
    }

    public final ECControllerViewGroup F() {
        return (ECControllerViewGroup) this.k.getValue();
    }

    public final com.bytedance.android.ec.window.base.utils.playable.impl.video.d G() {
        return (com.bytedance.android.ec.window.base.utils.playable.impl.video.d) this.m.getValue();
    }

    static {
        t = new a();
        ControllerState r2 = ControllerState.ENABLED;
        ControllerState r3 = ControllerState.DISABLED;
        r = MapsKt.mapOf(new Pair[]{TuplesKt.to(r2, 2131234723), TuplesKt.to(r3, 2131234722)});
        s = MapsKt.mapOf(new Pair[]{TuplesKt.to(r2, 2131234708), TuplesKt.to(r3, 2131234707)});
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void D(wp3.g r10) {
        wp3.g r11 = r10;
        this.p.a = G();
        this.g = r11;
        ControllerState r0 = (ControllerState) ((QLiveData) this.i.getValue()).a();
        if (r0 != null) goto L5;
        r0 = ControllerState.ENABLED;
    L5:
        K(r0);
        ECControllerViewGroup r1 = F();
        ControllerType r2 = ControllerType.VOLUME;
        r1.c(r2, r0);
        if (r11 == null) goto L10;
        String r12 = r11.b;
        if (r12 == null) goto L10;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.d r3 = G();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r12, "source");
        r3.c = r12;
    L10:
        List<? extends ControllerType> r4 = CollectionsKt.mutableListOf(new ControllerType[]{r2});
        wp3.g r5 = this.g;
        if (r5 == null) goto L16;
        if (r5.a != true) goto L16;
        r4.add(ControllerType.BARRAGE);
    L16:
        if (F().b(r4) == true) goto L26;
        F().removeAllViews();
        Iterator<T> r6 = r4.iterator();
    L19:
        if (r6.hasNext() == false) goto L26;
        ControllerType r7 = (ControllerType) r6.next();
        if (r7 != ControllerType.VOLUME) goto L24;
        F().a(r7, r, ControllerState.ENABLED, new ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$1(t), new ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$2(this), new ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$3(this));
    L24:
        if (r7 != ControllerType.BARRAGE) goto L19;
        F().a(r7, s, ControllerState.ENABLED, new ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$4(t), new ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$5(this), new ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$6(this));
    L26:
        ((QLiveData) this.i.getValue()).c(ECQuickUtilKt.a(u()), this.o, true);
        ((QLiveData) this.j.getValue()).c(ECQuickUtilKt.a(u()), this.n, true);
        wp3.g r13 = this.g;
        if (r13 == null) goto L56;
        String r8 = r13.c;
        if (r8 == null) goto L31;
        ((ECWindowRemoteVideoView) this.l.getValue()).setCoverUrl(r8);
    L31:
        ECWindowRemoteVideoView r9 = (ECWindowRemoteVideoView) this.l.getValue();
        ConstraintLayout.LayoutParams r14 = ((ECWindowRemoteVideoView) this.l.getValue()).getLayoutParams();
        if (r14 == null) goto L55;
        ConstraintLayout.LayoutParams r15 = r14;
        int r16 = r13.d;
        int r17 = r13.e;
        if (r16 <= 0) goto L43;
        if (r17 <= 0) goto L40;
        float r18 = r16 / r17;
        if (r18 > 1.3333334f) goto L40;
        if (r18 < 0.75f) goto L43;
        String r19 = "H," + r16 + ':' + r17;
    L45:
        r15.dimensionRatio = r19;
        Unit r110 = Unit.INSTANCE;
        r9.setLayoutParams(r15);
        ECWindowRemoteVideoView r111 = (ECWindowRemoteVideoView) this.l.getValue();
        wp3.g r20 = this.g;
        if (r20 == null) goto L64;
        float r21 = r20.d / r20.e;
        if (r21 <= 1.3333334f) goto L52;
        r111.setScaleType(ECWindowVideoView.ScaleType.FIT_CENTER);
    L52:
        if (r21 >= 0.75f) goto L62;
        r111.setScaleType(ECWindowVideoView.ScaleType.CENTER_CROP);
        return;
    L62:
        return;
    L64:
        return;
    L40:
        r19 = "H,4:3";
    L43:
        r19 = "H,3:4";
        goto L45
    L55:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void I(ControllerState r2) {
        if (r2 != ControllerState.DISABLED) goto L8;
        vp.c r3 = this.q;
        if (r3 == null) goto L13;
        r3.stopPlay();
        return;
    L13:
        return;
    L8:
        if (G().isPlaying() == false) goto L15;
        vp.c r4 = this.q;
        if (r4 == null) goto L16;
        r4.startPlay();
        return;
    L16:
        return;
    }

    public final void K(ControllerState r3) {
        int r4 = i.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        ECVideoPlayer r5 = G().b();
        if (r5 == null) goto L16;
        r5.o(false);
        return;
    L16:
        return;
    L5:
        if (r4 != 2) goto L17;
        ECVideoPlayer r6 = G().b();
        if (r6 == null) goto L14;
        r6.o(true);
        return;
    L14:
        return;
    }

    public ECWindowInnerFlowVideoElementPresenter(vp.c r2, vp.c r3) {
        Intrinsics.checkNotNullParameter(r2, "videoPlayerProxy");
        super(yp3.h.a);
        this.p = r2;
        this.q = r3;
        this.h = LazyKt.lazy(new ECWindowInnerFlowVideoElementPresenter$viewModel$2(this));
        this.i = LazyKt.lazy(new ECWindowInnerFlowVideoElementPresenter$volumeState$2(this));
        this.j = LazyKt.lazy(new ECWindowInnerFlowVideoElementPresenter$barrageState$2(this));
        this.k = LazyKt.lazy(new ECWindowInnerFlowVideoElementPresenter$controllerGroup$2(this));
        this.l = LazyKt.lazy(new ECWindowInnerFlowVideoElementPresenter$videoView$2(this));
        this.m = LazyKt.lazy(new ECWindowInnerFlowVideoElementPresenter$ecVideoViewPlayable$2(this));
        this.n = new b(this);
        this.o = new c(this);
    }
}
