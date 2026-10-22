package com.bytedance.android.shopping.prepurchase.arch.container.component;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.LifecycleRegistry;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import vg3.d0;
import vg3.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class AbsComponent<STATE extends com.bytedance.android.shopping.prepurchase.arch.container.state.h, STORE> implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {
    public static final Lazy h = null;
    public final Lazy a;
    public final Lazy b;
    public boolean c;
    public com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> d;
    public j e;
    public final Set<com.bytedance.android.shopping.prepurchase.arch.container.ability.a> f;
    public final List<f> g;

    public static final class a {
    }

    public final LifecycleRegistry P1() {
        return (LifecycleRegistry) this.a.getValue();
    }

    public final CoroutineScope Q1() {
        return (CoroutineScope) this.b.getValue();
    }

    public void T1() {
        this.c = false;
        P1().f(Lifecycle.Event.ON_CREATE);
    }

    public void U1() {
        this.c = true;
        P1().f(Lifecycle.Event.ON_DESTROY);
    }

    static {
        h = LazyKt.lazy(AbsComponent$Companion$AUTO_UNREGISTER$2.INSTANCE);
    }

    public List<Class<?>> M1() {
        return CollectionsKt.listOf(d0.class);
    }

    public final com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> O1() {
        com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        return r0;
    }

    public final j R1() {
        j r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L5:
        return r0;
    }

    public AbsComponent() {
        this.a = LazyKt.lazy(new AbsComponent$lifecycleRegistry$2(this));
        this.b = LazyKt.lazy(new AbsComponent$lifecycleScope$2(this));
        this.f = new LinkedHashSet();
        this.g = new ArrayList();
    }

    public void S1() {
        P1().f(Lifecycle.Event.ON_RESUME);
    }

    public void V1() {
        P1().f(Lifecycle.Event.ON_PAUSE);
    }

    public void W1() {
        P1().f(Lifecycle.Event.ON_START);
    }

    public void X1() {
        P1().f(Lifecycle.Event.ON_STOP);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e
    public final Lifecycle getLifecycle() {
        return P1();
    }

    public void K1() {
        T1();
    }

    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> T N1(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "service");
        j r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L6:
        return (T) r0.getService(r3);
    }

    public final void J1(s r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$addAbilityUnregisterListener");
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) this.g).add(r3);
        j r4 = this.e;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L5:
        r4.c(r3);
    }

    public final void L1(com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "serviceRegistry");
        this.d = r2;
        this.e = r3.d(getClass().getSimpleName(), new AbsComponent$attachContext$1(this));
    }

    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void Z1(Class<T> r8, Function3<? super CoroutineScope, ? super T, ? super Continuation<? super Unit>, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r8, "service");
        Intrinsics.checkNotNullParameter(r9, "block");
        BuildersKt.launch$default(Q1(), null, null, new AbsComponent$whenAbilityAvailable$1(this, r9, r8, null), 3, null);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
    public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r4, Lifecycle.Event r5) {
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r5, "event");
        switch(com.bytedance.android.shopping.prepurchase.arch.container.component.a.a[r5.ordinal()]) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L5;
            default: goto L49;
        };
    L5:
        U1();
        Set<com.bytedance.android.shopping.prepurchase.arch.container.ability.a> r6 = this.f;
        monitor-enter(r6);
    L27:
        th = move-exception;
        throw th;
    L8:
        if ((!this.f.isEmpty()) == false) goto L17;
        Iterator<T> r7 = this.f.iterator();     // Catch: Throwable -> L27
    L11:
        if (r7.hasNext() == false) goto L16;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r0 = (com.bytedance.android.shopping.prepurchase.arch.container.ability.a) r7.next();     // Catch: Throwable -> L27
        j r1 = this.e;     // Catch: Throwable -> L27
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");     // Catch: Throwable -> L27
    L15:
        r1.b(r0);     // Catch: Throwable -> L27
        goto L11
    L16:
        this.f.clear();     // Catch: Throwable -> L27
    L17:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r6);
        Iterator r9 = ((ArrayList) this.g).iterator();
    L21:
        if (r9.hasNext() == false) goto L26;
        f r10 = (f) r9.next();
        j r2 = this.e;
        if (r2 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L25:
        r2.a(r10);
        goto L21
    L26:
        ((ArrayList) this.g).clear();
        return;
    L30:
        X1();
        return;
    L31:
        V1();
        return;
    L32:
        S1();
        return;
    L33:
        W1();
        return;
    L34:
        K1();
        return;
    }

    public static void Y1(AbsComponent r2, Class r3, com.bytedance.android.shopping.prepurchase.arch.container.ability.a r4, boolean r5, int r6) {
        if ((r6 & 4) == 0) goto L5;
        boolean r0 = ((Boolean) h.getValue()).booleanValue();
    L7:
        if ((r6 & 8) == 0) goto L9;
        r5 = false;
    L9:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "inst");
        if (r0 == false) goto L19;
        Set<com.bytedance.android.shopping.prepurchase.arch.container.ability.a> r7 = r2.f;
        monitor-enter(r7);
        r2.f.add(r4);     // Catch: Throwable -> L16
        monitor-exit(r7);
    L16:
        th = move-exception;
        throw th;
    L19:
        j r8 = r2.e;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L22:
        r8.f(r3, r4, r5);
        return;
    L5:
        r0 = false;
        goto L7
    }
}
