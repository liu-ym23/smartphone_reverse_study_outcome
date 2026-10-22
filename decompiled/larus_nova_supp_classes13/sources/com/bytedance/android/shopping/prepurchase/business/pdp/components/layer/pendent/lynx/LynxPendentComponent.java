package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.LynxElementVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.o;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ti.l;
import vg3.a0;
import vg3.i0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LynxPendentComponent extends m implements a0 {
    public static final /* synthetic */ int o = 0;
    public com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c m;
    public final a n;

    public static final class a implements com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.b {
        public final /* synthetic */ LynxPendentComponent a;

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.b
        public final e b() {
            vg3.e r0 = (vg3.e) this.a.N1(vg3.e.class);
            if (r0 == null) goto L5;
            int r1 = r0.d1();
        L7:
            return new e(r1);
        L5:
            r1 = 0;
            goto L7
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.p
        public final Boolean d() {
            return Boolean.valueOf(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.O1())).b.a);
        }

        public a(LynxPendentComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.b
        public final i c(String r3) {
            Intrinsics.checkNotNullParameter(r3, "sliceKey");
            vg3.e r0 = (vg3.e) this.a.N1(vg3.e.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.H(r3);
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.b
        public final i e(String r3) {
            Intrinsics.checkNotNullParameter(r3, "sliceKey");
            i0 r0 = (i0) this.a.N1(i0.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.H(r3);
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.b
        public final l a(Context r10, String r11, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c.b r12) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "url");
            Intrinsics.checkNotNullParameter(r12, "callback");
            o r0 = new o(r10, r11, null, null, true, r12, 12);
            return this.a.O1().e().D0().p(r0);
        }
    }

    public static final class b<T> implements g {
        public final /* synthetic */ LynxPendentComponent a;

        public b(LynxPendentComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r4) {
            PendantContainerVO r5 = (PendantContainerVO) r4;
            if (r5 == null) goto L50;
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c r0 = LynxPendentComponent.h2(this.a);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r5, "vo");
            r0.f.removeAllViews();
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L37
            PendantContainerVO r2 = r0.a;     // Catch: Throwable -> L37
            if (r2 == null) goto L10;
            PendantContainerVO r3 = r2.merge(r5);     // Catch: Throwable -> L37
            if (r3 == null) goto L10;
        L11:
            r0.a = r3;     // Catch: Throwable -> L37
            List r6 = r5.getLeftBottom();     // Catch: Throwable -> L37
            if (r6 == null) goto L17;
            Iterator<T> r7 = r6.iterator();     // Catch: Throwable -> L37
        L15:
            if (r7.hasNext() == false) goto L17;
            r0.b((LynxElementVO) r7.next());     // Catch: Throwable -> L37
        L17:
            List r8 = r5.getTopRight();     // Catch: Throwable -> L37
            if (r8 == null) goto L23;
            Iterator<T> r9 = r8.iterator();     // Catch: Throwable -> L37
        L21:
            if (r9.hasNext() == false) goto L23;
            r0.b((LynxElementVO) r9.next());     // Catch: Throwable -> L37
        L23:
            List r10 = r5.getTopLeft();     // Catch: Throwable -> L37
            if (r10 == null) goto L29;
            Iterator<T> r11 = r10.iterator();     // Catch: Throwable -> L37
        L27:
            if (r11.hasNext() == false) goto L29;
            r0.b((LynxElementVO) r11.next());     // Catch: Throwable -> L37
        L29:
            List r12 = r5.getRightBottom();     // Catch: Throwable -> L37
            if (r12 == null) goto L35;
            Iterator<T> r13 = r12.iterator();     // Catch: Throwable -> L37
        L33:
            if (r13.hasNext() == false) goto L35;
            r0.b((LynxElementVO) r13.next());     // Catch: Throwable -> L37
        L35:
            r0.e();     // Catch: Throwable -> L37
            Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
        L39:
            Throwable r15 = Result.exceptionOrNull-impl(r14);
            if (r15 == null) goto L49;
            ECExceptionMonitor.e(r15);
            return;
        L49:
            return;
        L10:
            r3 = r5;
        L37:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L39
        }
    }

    public static final class c<T> implements g {
        public final /* synthetic */ LynxPendentComponent a;

        public c(LynxPendentComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r4) {
            float r0 = (-((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.O1())).b.b) * RangesKt.coerceAtMost(((Number) r4).floatValue(), 0.0f);
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c r5 = LynxPendentComponent.h2(this.a);
            if (r5.c == r0) goto L17;
            r5.c = r0;
            Iterator<T> r1 = r5.b.values().iterator();
        L7:
            if (r1.hasNext() == false) goto L27;
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r2 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r1.next();
            if (r2 == null) goto L7;
            LynxElementVO r3 = r2.f;
            if (r3 == null) goto L7;
            View r6 = r2.a;
            if (r6 == null) goto L7;
            r5.a(r3, r6);
            goto L7
        L27:
            return;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{i0.class, vg3.e.class, a0.class});
    }

    public LynxPendentComponent() {
        this.n = new a(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(O1().e(), "pdp_async_event_send", true, new LynxPendentComponent$registerJsEvent$1(this));
        String r1 = g2().getSessionId();
        View r2 = e2();
        if (r2 == null) goto L10;
        this.m = new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c(r1, (FrameLayout) r2, this.n);
        Z1(vg3.e.class, new LynxPendentComponent$onAttach$1(this, null));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().o.getValue(), this, new b(this));
        if (ECSettingKeys.z0() == false) goto L7;
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.c, this, new c(this));
    L7:
        Z1(i0.class, new LynxPendentComponent$onAttach$4(this, null));
        O1().getContainerAbility().b(new LynxPendentComponent$onAttach$5(this));
        AbsComponent.Y1(this, a0.class, this, false, 12);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("helper");
    L5:
        Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r1 = r0.b.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r2 = r1.next().getValue();
        if (r2 == null) goto L7;
        l r3 = r2.b;
        if (r3 == null) goto L7;
        r3.release();
        goto L7
    L13:
        r0.b.clear();
        r0.f.removeAllViews();
    }

    public static final /* synthetic */ com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c h2(LynxPendentComponent r1) {
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c r2 = r1.m;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("helper");
    L5:
        return r2;
    }

    @Override // vg3.a0
    public final View L(String r5) {
        Intrinsics.checkNotNullParameter(r5, "pendentId");
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("helper");
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "pendantId");
        Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r1 = r0.b.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L22;
        Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r2 = r1.next();
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r3 = r2.getValue();
        if (r3 == null) goto L11;
        String r4 = r3.c;
    L13:
        if (Intrinsics.areEqual(r4, r5) == false) goto L7;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r6 = r2.getValue();
        if (r6 != null) goto L17;
        return null;
    L17:
        return r6.a;
    L11:
        r4 = null;
        goto L13
    L22:
        return null;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "container");
        FrameLayout r4 = new FrameLayout(r2.getContext());
        r4.setId(2131379299);
        return r4;
    }
}
