package com.bytedance.assem.arch.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.assem.arch.extensions.HostInjector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/assem/arch/core/AssemSupervisor;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroid/content/Context;", "h", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "a", "assem_release"}, k = 1, mv = {1, 4, 0})
public final class AssemSupervisor implements LifecycleEventObserver {
    public static final /* synthetic */ int k = 0;
    public volatile boolean a;
    public final CopyOnWriteArrayList<Assem> b;
    public final Map<KClass<? extends Assem>, Assem> c;
    public final Map<KClass<? extends Assem>, h> d;
    public final Lazy e;
    public View f;
    public final LifecycleOwner g;
    public final Context h;
    public final com.bytedance.assem.arch.core.b i;
    public final d j;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final Lifecycle b() {
        return this.g.getLifecycle();
    }

    public final void e() {
        Iterator<Assem> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Assem r1 = r0.next();
        c(Lifecycle.State.DESTROYED, r1);
        goto L4
    L6:
        ((LinkedHashMap) this.i.a).clear();
        d r2 = this.j;
        ((LinkedHashMap) r2.a).clear();
        ((LinkedHashMap) r2.b).clear();
        this.b.clear();
        ((LinkedHashMap) this.c).clear();
        ((LinkedHashMap) this.d).clear();
        b().removeObserver(this);
        f(null);
    }

    public final Context getContext() {
        return this.h;
    }

    public final void a(final Assem r3) {
        Function0<Unit> r0 = new AssemSupervisor$attachToParentLifecycle$runnable$1(this, r3);
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
        r0.invoke();
        return;
    L5:
        ((Handler) this.e.getValue()).post(new b(r0));
    }

    public final void d(final Assem r6) {
        if (b().getCurrentState().compareTo(Lifecycle.State.DESTROYED) > 0) goto L6;
        return;
    L6:
        if ((!this.b.contains(r6)) == false) goto L13;
        this.b.add(r6);
        r6.d = this;
        r6.f.setValue(r6, Assem.g[0], this.g);
        this.c.put(Reflection.getOrCreateKotlinClass(r6.getClass()), r6);
        if (r6.b == true) goto L10;
        new AssemSupervisor$loadAssem$2(this, r6);
        return;
    L10:
        r6.a = true;
        return;
    L13:
        throw new IllegalStateException("This assem has already existed.".toString());
    }

    public final void f(View r2) {
        if (r2 != null) goto L5;
        r2 = null;
    L9:
        this.f = r2;
        return;
    L5:
        if (this.f != null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L9;
        throw new IllegalArgumentException("Duplicate attach the assems to root view on the same layer.".toString());
    L7:
        r0 = false;
        goto L8
    }

    public static void c(Lifecycle.State r2, Assem r3) {
        int r4 = e.a[r2.ordinal()];
        if (r4 != 1) goto L5;
        Lifecycle.State r5 = r3.c.getCurrentState();
        Lifecycle.State r0 = Lifecycle.State.CREATED;
        if (r5.compareTo(r0) >= 0) goto L42;
        r3.k();
        return;
    L42:
        if (r3.c.getCurrentState().compareTo(Lifecycle.State.STARTED) <= 0) goto L45;
        r3.l();
    L45:
        if (r3.c.getCurrentState().compareTo(r0) <= 0) goto L56;
        r3.c.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        r3.onStop();
        return;
    L56:
        return;
    L5:
        if (r4 != 2) goto L7;
        Lifecycle.State r6 = r3.c.getCurrentState();
        Lifecycle.State r1 = Lifecycle.State.STARTED;
        if (r6.compareTo(r1) >= 0) goto L36;
        if (r3.c.getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L34;
        r3.k();
    L34:
        r3.onStart();
        r3.c.handleLifecycleEvent(Lifecycle.Event.ON_START);
        return;
    L36:
        if (r3.c.getCurrentState().compareTo(r1) <= 0) goto L53;
        r3.l();
        return;
    L53:
        return;
    L7:
        if (r4 == 3) goto L21;
        if (r4 == 4) goto L12;
        return;
    L12:
        if (r3.c.getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L15;
        r3.l();
    L15:
        if (r3.c.getCurrentState().compareTo(Lifecycle.State.STARTED) < 0) goto L18;
        r3.c.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        r3.onStop();
    L18:
        if (r3.c.getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L48;
        r3.c.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        r3.e.clear();
        r3.onDestroy();
        return;
    L48:
        return;
    L21:
        if (r3.c.getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L23;
        return;
    L23:
        if (r3.c.getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L26;
        r3.k();
    L26:
        if (r3.c.getCurrentState().compareTo(Lifecycle.State.STARTED) >= 0) goto L28;
        r3.onStart();
        r3.c.handleLifecycleEvent(Lifecycle.Event.ON_START);
    L28:
        r3.m();
    }

    public final void onStateChanged(LifecycleOwner r6, Lifecycle.Event r7) {
        switch(e.b[r7.ordinal()]) {
            case 1: goto L66;
            case 2: goto L51;
            case 3: goto L36;
            case 4: goto L21;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L107;
        };
    L5:
        e();
        return;
    L6:
        Lazy r8 = HostInjector.a;
        CopyOnWriteArrayList<Assem> r9 = this.b;
        ArrayList r1 = new ArrayList();
        Iterator<Assem> r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L17;
        Assem r2 = r10.next();
        Assem r3 = r2;
        if (r3.b == true) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L8;
        r1.add(r2);
        goto L8
    L12:
        if (r3.a == true) goto L14;
        r4 = true;
        goto L15
    L17:
        Iterator r11 = r1.iterator();
    L19:
        if (r11.hasNext() == false) goto L108;
        Assem r12 = (Assem) r11.next();
        c(Lifecycle.State.CREATED, r12);
        goto L19
    L108:
        return;
    L21:
        Lazy r13 = HostInjector.a;
        CopyOnWriteArrayList<Assem> r14 = this.b;
        ArrayList r5 = new ArrayList();
        Iterator<Assem> r15 = r14.iterator();
    L23:
        if (r15.hasNext() == false) goto L32;
        Assem r16 = r15.next();
        Assem r17 = r16;
        if (r17.b == true) goto L27;
    L29:
        boolean r18 = false;
    L30:
        if (r18 == true) goto L23;
        r5.add(r16);
        goto L23
    L27:
        if (r17.a == true) goto L29;
        r18 = true;
        goto L30
    L32:
        Iterator r19 = r5.iterator();
    L34:
        if (r19.hasNext() == false) goto L109;
        Assem r20 = (Assem) r19.next();
        c(Lifecycle.State.STARTED, r20);
        goto L34
    L109:
        return;
    L36:
        Lazy r21 = HostInjector.a;
        CopyOnWriteArrayList<Assem> r22 = this.b;
        ArrayList r23 = new ArrayList();
        Iterator<Assem> r24 = r22.iterator();
    L38:
        if (r24.hasNext() == false) goto L47;
        Assem r25 = r24.next();
        Assem r26 = r25;
        if (r26.b == true) goto L42;
    L44:
        boolean r27 = false;
    L45:
        if (r27 == true) goto L38;
        r23.add(r25);
        goto L38
    L42:
        if (r26.a == true) goto L44;
        r27 = true;
        goto L45
    L47:
        Iterator r28 = r23.iterator();
    L49:
        if (r28.hasNext() == false) goto L110;
        Assem r29 = (Assem) r28.next();
        c(Lifecycle.State.RESUMED, r29);
        goto L49
    L110:
        return;
    L51:
        Lazy r30 = HostInjector.a;
        CopyOnWriteArrayList<Assem> r31 = this.b;
        ArrayList r32 = new ArrayList();
        Iterator<Assem> r33 = r31.iterator();
    L53:
        if (r33.hasNext() == false) goto L62;
        Assem r34 = r33.next();
        Assem r35 = r34;
        if (r35.b == true) goto L57;
    L59:
        boolean r36 = false;
    L60:
        if (r36 == true) goto L53;
        r32.add(r34);
        goto L53
    L57:
        if (r35.a == true) goto L59;
        r36 = true;
        goto L60
    L62:
        Iterator r37 = r32.iterator();
    L64:
        if (r37.hasNext() == false) goto L111;
        Assem r38 = (Assem) r37.next();
        c(Lifecycle.State.STARTED, r38);
        goto L64
    L111:
        return;
    L66:
        Lazy r39 = HostInjector.a;
        CopyOnWriteArrayList<Assem> r40 = this.b;
        ArrayList r41 = new ArrayList();
        Iterator<Assem> r42 = r40.iterator();
    L68:
        if (r42.hasNext() == false) goto L72;
        Assem r0 = r42.next();
        if (r0.b == true) goto L68;
        r41.add(r0);
        goto L68
    L72:
        Iterator r43 = r41.iterator();
    L74:
        if (r43.hasNext() == false) goto L112;
        Assem r44 = (Assem) r43.next();
        c(Lifecycle.State.CREATED, r44);
        goto L74
    L112:
        return;
    }

    public AssemSupervisor(LifecycleOwner r1, FragmentActivity r2, com.bytedance.assem.arch.core.b r3, d r4) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.b = new CopyOnWriteArrayList();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = LazyKt.lazy(AssemSupervisor$handler$2.INSTANCE);
    }
}
