package com.bytedance.android.shopping.prepurchase.arch.container;

import android.content.res.Configuration;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.ContainerTrackAbility;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.l;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.n;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.p;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.DataFetchLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.PageCreateLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.RenderLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.StartFlowListenerDispatcher;
import com.bytedance.android.shopping.prepurchase.arch.container.component.ServiceRegistryImpl;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.j;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<STATE extends h, STORE> implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e {
    public com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a a;
    public ServiceRegistryImpl b;
    public d<STATE, STORE> c;
    public final f<STATE, STORE> d;

    public final boolean a() {
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L5:
        List<com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.b> r1 = r0.b;
        if ((r1 instanceof Collection) == true) goto L8;
    L10:
        Iterator r2 = ((ArrayList) r1).iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        if (((com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.b) r2.next()).onBackPressed() == false) goto L12;
        return true;
    L16:
        return false;
    L8:
        if (((ArrayList) r1).isEmpty() == false) goto L10;
        goto L10
    }

    public final void c() {
        f<STATE, STORE> r0 = this.d;
        pg3.c<STATE, STORE> r1 = r0.e;
        String r2 = r0.a.b;
        Map<String, pg3.d> r3 = pg3.b.a;
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        pg3.d r4 = pg3.b.a.remove(r2);
        if (r4 == null) goto L5;
        r4.a();
    L5:
        wg3.a r5 = r1.b();
        f<STATE, STORE> r6 = this.d;
        Intrinsics.checkNotNullParameter(r5, "starterHolder");
        Intrinsics.checkNotNullParameter(r6, "param");
        StartFlowListenerDispatcher r7 = new StartFlowListenerDispatcher(CollectionsKt.plus(CollectionsKt.listOfNotNull(r5), new com.bytedance.android.shopping.prepurchase.arch.container.aware.d(r6)));
        PageCreateLifecycleDispatcher r8 = new PageCreateLifecycleDispatcher(CollectionsKt.listOfNotNull(r7));
        DataFetchLifecycleDispatcher r9 = new DataFetchLifecycleDispatcher(CollectionsKt.listOfNotNull(r7));
        RenderLifecycleDispatcher r10 = new RenderLifecycleDispatcher(CollectionsKt.listOfNotNull(r7));
        r8.b();
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r11 = new com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a(this, this.d.f);
        this.a = r11;
        ContainerTrackAbility r12 = new ContainerTrackAbility(this.d.c, r11);
        n r13 = new n(this.d.b);
        p r14 = new p(this.d.d);
        og3.b r15 = new og3.b(this.d.a, r1.d());
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r16 = this.a;
        if (r16 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L8:
        this.c = new d(r15, r12, r13, r14, r16);
        this.b = new ServiceRegistryImpl();
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r17 = this.a;
        if (r17 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L11:
        r17.c(Lifecycle.Event.ON_CREATE);
        d<STATE, STORE> r18 = this.c;
        if (r18 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L14:
        ServiceRegistryImpl r19 = this.b;
        if (r19 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("abilityRegistry");
    L17:
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r110 = this.a;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L20:
        com.bytedance.android.shopping.prepurchase.arch.container.component.c r20 = new com.bytedance.android.shopping.prepurchase.arch.container.component.c(r18, r19, r110.a);
        r20.d(r1.c(r10));
        d<STATE, STORE> r21 = this.c;
        if (r21 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L23:
        ServiceRegistryImpl r22 = this.b;
        if (r22 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("abilityRegistry");
    L26:
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r23 = r22.getService(l.class);
        Intrinsics.checkNotNull(r23);
        l r24 = (l) r23;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r24, "ability");
        r21.b = r24;
        r20.d(r1.a(r9));
        ServiceRegistryImpl r25 = this.b;
        if (r25 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("abilityRegistry");
    L29:
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r26 = r25.getService(j.class);
        if (r26 == null) goto L46;
        j<STORE> r27 = (j) r26;
        d<STATE, STORE> r28 = this.c;
        if (r28 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L34:
        r28.getClass();
        Intrinsics.checkNotNullParameter(r27, "ability");
        r28.a = r27;
        r20.d(r1.e());
        d<STATE, STORE> r29 = this.c;
        if (r29 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L37:
        ServiceRegistryImpl r30 = this.b;
        if (r30 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("abilityRegistry");
    L40:
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r31 = r30.getService(com.bytedance.android.shopping.prepurchase.arch.container.ability.f.class);
        Intrinsics.checkNotNull(r31);
        com.bytedance.android.shopping.prepurchase.arch.container.ability.f r32 = (com.bytedance.android.shopping.prepurchase.arch.container.ability.f) r31;
        r29.getClass();
        Intrinsics.checkNotNullParameter(r32, "ability");
        r29.c = r32;
        Unit r33 = Unit.INSTANCE;
        PdpRootComponent r34 = r1.f();
        d<STATE, STORE> r35 = this.c;
        if (r35 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L43:
        r20.c(r34, r35.h.getContainerView());
        r8.a();
        return;
    L46:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.prepurchase.arch.container.intf.INetworkAbility<STORE>");
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e
    public final Lifecycle getLifecycle() {
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L6:
        return r0.a;
    }

    public a(f<STATE, STORE> r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        this.d = r2;
    }

    public final void b(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "configuration");
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r1 = this.a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "configuration");
        Iterator r0 = ((ArrayList) r1.c).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((Function1) r0.next()).invoke(r4);
        goto L7
    }
}
