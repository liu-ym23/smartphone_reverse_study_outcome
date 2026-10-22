package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.utils.ViewExtensionsKt;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.AnchorV4PlaybackAreaV2;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import vg3.c0;
import vg3.d0;
import vg3.f0;
import vg3.p;
import vg3.r;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LivingIconComponent extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m implements c0 {
    public static final /* synthetic */ int p = 0;
    public AnchorV4PlaybackAreaV2 m;
    public final Function0<Boolean> n;
    public boolean o;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ LivingIconComponent a;

        public a(LivingIconComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r6) {
            PlayBackEntryVO r7 = (PlayBackEntryVO) r6;
            if (r7 != null) goto L5;
            return;
        L5:
            if (r7.isFromCache() == true) goto L36;
            com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this.a, "playBackEntryVO cache = " + r7.isFromCache());
            LivingIconComponent r0 = this.a;
            boolean r2 = false;
            if (((Boolean) r0.n.invoke()).booleanValue() == false) goto L16;
            Integer r1 = r7.getInitState();
            if (r1 == null) goto L16;
            if (r1.intValue() != 2) goto L16;
            r7.setInitState(0);
        L16:
            if (r0.g2().getNativeParams().getFromLive() != true) goto L18;
            r2 = true;
        L18:
            r7.setFromLive(r2);
            final LivingIconComponent r3 = this.a;
            r3.getClass();
            r3.h2(r7);     // Catch: Exception -> L23
            n r4 = new n(r7, r3.m, new LivingIconComponent$bindPlayBackEntry$1(r3));     // Catch: Exception -> L23
            r3.getClass();     // Catch: Exception -> L23
            AnchorV4PlaybackAreaV2 r5 = r3.m;     // Catch: Exception -> L23
            if (r5 == null) goto L25;
            r5.b(r7, r4, new d(r3));     // Catch: Exception -> L23
        L25:
            LivingIconComponent r8 = this.a;
            if (r8.o == false) goto L28;
            return;
        L28:
            if (r8.m == null) goto L37;
            r8.o = true;
            com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r8.O1())).b.c, r8, new c(r8));
            r8.Z1(d0.class, new LivingIconComponent$bindEventOnce$2(r8, null));
            return;
        L37:
            return;
        L23:
            e = move-exception;
            r3.O1().c().ensureNotReachHere(e);
            goto L25
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{w.class, vg3.l.class, vg3.a.class, d0.class, f0.class, r.class, p.class});
    }

    @Override // vg3.c0
    public final void v1() {
    }

    @Override // vg3.c0
    public final void T0() {
        CardView r0 = this.m;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    @Override // vg3.c0
    public final boolean isVisible() {
        CardView r0 = this.m;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = false;
        goto L8
    }

    @Override // vg3.c0
    public final void w() {
        CardView r0 = this.m;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }

    public LivingIconComponent() {
        this.n = new LivingIconComponent$queryHasSmallWindow$1(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().m.getValue(), this, new a(this));
        AbsComponent.Y1(this, c0.class, this, false, 12);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        CardView r0 = this.m;
        if (r0 == null) goto L5;
        ViewExtensionsKt.a(r0);
    L5:
        this.m = null;
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [android.view.View, com.bytedance.android.shopping.prepurchase.business.pdp.view.AnchorV4PlaybackAreaV2] */
    public final void h2(PlayBackEntryVO r6) {
        if (this.m == null) goto L5;
        return;
    L5:
        View r0 = e2();
        if (r0 == null) goto L18;
        ViewGroup r1 = (ViewGroup) r0;
        if (r6.enablePlayBackEntryDraggable(Boolean.valueOf(g2().getNativeParams().getFullMode())) == false) goto L11;
        r1.addView(th.a.d(r1.getContext(), 2131564603, null, 6), 0);
        this.m = (AnchorV4PlaybackAreaV2) f2(2131382421);
        return;
    L11:
        if (this.m != null) goto L13;
        ?? r7 = new AnchorV4PlaybackAreaV2(r1.getContext(), null, 6, 0);
        r7.setVisibility(8);
        Unit r2 = Unit.INSTANCE;
        this.m = r7;
    L13:
        CardView r8 = this.m;
        if (r8 == null) goto L20;
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = 8388613;
        Unit r4 = Unit.INSTANCE;
        r1.addView(r8, r3);
        return;
    L20:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
