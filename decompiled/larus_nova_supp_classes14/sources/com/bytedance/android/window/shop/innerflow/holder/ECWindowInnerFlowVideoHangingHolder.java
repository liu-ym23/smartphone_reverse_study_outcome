package com.bytedance.android.window.shop.innerflow.holder;

import android.graphics.Rect;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vp3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/ECWindowInnerFlowVideoHangingHolder;", "Lcom/bytedance/android/window/shop/innerflow/holder/ECShopInnerFlowItemHolder;", "Lvp3/c;", "Ltp/c;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowVideoHangingHolder extends ECShopInnerFlowItemHolder<c> implements tp.c {
    public final /* synthetic */ vp.c b;

    public final void B() {
        this.b.B();
    }

    public final boolean D3() {
        return this.b.D3();
    }

    public final List<tp.c> L(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "visibleArea");
        return this.b.L(r2);
    }

    public final void R() {
        this.b.R();
    }

    public final boolean g0() {
        return this.b.g0();
    }

    public final boolean isPlaying() {
        return this.b.isPlaying();
    }

    public final tp.b m() {
        return this.b.m();
    }

    public final void o2(tp.b r2) {
        this.b.o2(r2);
    }

    public final Rect r() {
        this.b.getClass();
        return null;
    }

    public final void startPlay() {
        this.b.startPlay();
    }

    public final void stopPlay() {
        this.b.stopPlay();
    }

    public final void v() {
        this.b.v();
    }

    public final void M() {
        vp.c r0 = this.b;
        r0.getClass();
        tp.c.a.a(r0);
    }

    public final WindowPlayAbleType P() {
        this.b.getClass();
        return WindowPlayAbleType.OTHER;
    }

    public final void U0() {
        vp.c r0 = this.b;
        r0.getClass();
        tp.c.a.b(r0);
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.ECShopInnerFlowItemHolder
    public final void U3() {
        QUIManager r0 = this.a;
        if (r0 == null) goto L6;
        r0.r(bq3.a.class);
        return;
    }

    public final void pausePlay() {
        vp.c r0 = this.b;
        r0.getClass();
        tp.c.a.e(r0);
    }

    public final boolean resumePlay() {
        vp.c r0 = this.b;
        r0.getClass();
        return tp.c.a.f(r0);
    }

    public final void x() {
        vp.c r0 = this.b;
        r0.getClass();
        tp.c.a.c(r0);
    }

    public final void z() {
        vp.c r0 = this.b;
        r0.getClass();
        tp.c.a.d(r0);
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.ECShopInnerFlowItemHolder
    public final void T3(vp3.b r3) {
        c r4 = (c) r3;
        Intrinsics.checkNotNullParameter(r4, "vo");
        QUIManager r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(bq3.a.class, r4);
        return;
    }

    public ECWindowInnerFlowVideoHangingHolder(QUIManager r2, vp.c r3) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "playProxy");
        super(r2, r2.p());
        this.b = r3;
    }
}
