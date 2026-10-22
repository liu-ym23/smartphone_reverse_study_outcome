package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import android.os.Handler;
import android.view.View;
import com.bytedance.android.shopping.anchorv4.log.GULShowManager;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.l;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.LifecycleOwnerDelegate;
import com.bytedance.android.shopping.prepurchase.arch.exposure.ConfigurationBuilder;
import com.bytedance.android.shopping.prepurchase.arch.exposure.ExposureEngine;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import vg3.m;
import vg3.u;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends b0 implements m {
    public static final /* synthetic */ int m = 0;
    public final VisibleLogManager i;
    public ExposureEngine j;
    public final Lazy k;
    public final Function1<View, com.bytedance.android.shopping.prepurchase.arch.exposure.c> l;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{u.class, w.class});
    }

    @Override // vg3.m
    public final void H0() {
        ((GULShowManager) this.k.getValue()).a();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        VisibleLogManager r0 = this.i;
        l r1 = O1().b();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "prefAbility");
        r0.f = true;
        r1.e1(new g(r0));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, m.class, this, false, 12);
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).a.getNativeParams().getFullMode() == true) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.intf.a r0 = O1().getContainerAbility().i7();
        VisibleLogManager r1 = this.i;
        int r3 = r0.b - r0.c;
        r1.d = r3;
        if (r3 == (-1)) goto L9;
        ((Handler) r1.a.getValue()).post(new i(r1));
    L9:
        if (com.bytedance.android.ec.core.abtest.d.l() == false) goto L20;
        ConfigurationBuilder r2 = new ConfigurationBuilder();
        LifecycleOwnerDelegate r4 = com.bytedance.android.shopping.prepurchase.arch.container.state.f.a(this);
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        r2.a = r4;
        rg3.a r5 = new rg3.a();
        Intrinsics.checkNotNullParameter(r5, "logger");
        r2.b = r5;
        long r6 = com.bytedance.android.ec.core.abtest.d.n();
        if (r6 < 100) goto L14;
        r2.c = r6;
    L14:
        Function1<View, com.bytedance.android.shopping.prepurchase.arch.exposure.c> r7 = this.l;
        Intrinsics.checkNotNullParameter(r7, "algorithm");
        r2.d = r7;
        if (r2.a == null) goto L19;
        this.j = new ExposureEngine(new com.bytedance.android.shopping.prepurchase.arch.exposure.a(r2));
        O1().b().e1(new a(this));
        Ref.IntRef r8 = new Ref.IntRef();
        r8.element = 0;
        Z1(u.class, new ExposureService$initExposureEngine$2(this, r8, null));
        return;
    L19:
        throw new IllegalArgumentException("need lifecycleOwner");
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
        VisibleLogManager r0 = this.i;
        r0.f = false;
        CompositeDisposable r1 = r0.e;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        GULShowManager r2 = (GULShowManager) this.k.getValue();
        r2.a.clear();
        CompositeDisposable r3 = r2.b;
        if (r3 == null) goto L9;
        r3.dispose();
        return;
    }

    @Override // vg3.m
    public final ExposureEngine x0() {
        return this.j;
    }

    public b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "algorithm");
        this.l = r2;
        this.i = new VisibleLogManager();
        this.k = LazyKt.lazy(ExposureService$gulManager$2.INSTANCE);
    }

    @Override // vg3.m
    public final void N0(com.bytedance.android.shopping.anchorv4.log.c r3) {
        Intrinsics.checkNotNullParameter(r3, "watcher");
        GULShowManager r1 = (GULShowManager) this.k.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "watcher");
        r1.a.add(r3);
    }

    @Override // vg3.m
    public final void y(com.bytedance.android.shopping.anchorv4.log.d r6, Object r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "watcher");
        Intrinsics.checkNotNullParameter(r7, "identifier");
        VisibleLogManager r2 = this.i;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "watcher");
        Intrinsics.checkNotNullParameter(r7, "identifier");
        ArrayList r0 = (ArrayList) r2.b;
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.anchorv4.log.e) r3).getIdentifier(), r7) == false) goto L4;
    L9:
        com.bytedance.android.shopping.anchorv4.log.e r4 = (com.bytedance.android.shopping.anchorv4.log.e) r3;
        if (r4 != null) goto L16;
        r4 = new com.bytedance.android.shopping.anchorv4.log.e(r6, r7, r8);
        if (r2.d == (-1)) goto L15;
        ((Handler) r2.a.getValue()).post(new i(r2));
    L15:
        Unit r9 = Unit.INSTANCE;
    L16:
        r0.add(r4);
        return;
    L8:
        r3 = null;
        goto L9
    }
}
