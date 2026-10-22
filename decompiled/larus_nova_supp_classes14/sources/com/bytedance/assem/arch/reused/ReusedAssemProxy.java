package com.bytedance.assem.arch.reused;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.assem.arch.core.Assem;
import com.bytedance.assem.arch.core.AssemSupervisor;
import com.bytedance.assem.arch.core.Assembler;
import com.bytedance.assem.arch.extensions.AssemExtKt;
import com.bytedance.assem.arch.extensions.HostInjector;
import com.bytedance.assem.arch.viewModel.AssemViewModel;
import com.bytedance.tiktok.proxy.IVMProxy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/assem/arch/reused/ReusedAssemProxy;", "Lcom/bytedance/tiktok/proxy/IVMProxy;", "Lcom/bytedance/tiktok/proxy/a;", "", "Lcom/bytedance/assem/arch/reused/IResuedAssemProxy;", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public final class ReusedAssemProxy implements IVMProxy<com.bytedance.tiktok.proxy.a, Object>, com.bytedance.tiktok.proxy.a, IResuedAssemProxy {
    public ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> a;
    public KClass<? extends ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a>> b;
    public boolean c;
    public final LifecycleRegistry d;
    public final ViewModelStore e;
    public boolean f;
    public final Lazy g;
    public final CopyOnWriteArrayList<ReusedAssemProxy> h;
    public Object i;
    public i j;
    public ProxyStage k;
    public Object l;
    public Function0<Integer> m;
    public final BehaviorSubject<com.bytedance.assem.arch.reused.a> n;
    public boolean o;
    public final ConcurrentHashMap<KClass<?>, Object> p;
    public final ConcurrentHashMap<KClass<?>, AssemViewModel<?>> q;

    public static final class a<T> implements Consumer<com.bytedance.assem.arch.reused.a> {
        public final /* synthetic */ ReusedAssemProxy a;

        public a(ReusedAssemProxy r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            com.bytedance.assem.arch.reused.a r11 = (com.bytedance.assem.arch.reused.a) r10;
            final ReusedAssemProxy r0 = this.a;
            KClass<? extends ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a>> r1 = r0.b;
            Lazy r2 = HostInjector.a;
            g r3 = null;
            Intrinsics.areEqual(r1, null);
            FireCase r4 = r11.a;
            FireCase r5 = FireCase.HostBind;
            if (r4 != r5) goto L5;
        L8:
            boolean r6 = true;
        L10:
            if ((!Intrinsics.areEqual(r11.b, r0.a)) == false) goto L13;
            if (r6 == true) goto L13;
            return;
        L13:
            if (r6 == false) goto L15;
            r0.o = true;
        L15:
            ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r7 = r0.a;
            if (r7 == null) goto L20;
            LifecycleRegistry r8 = r7.c;
            if (r8 == null) goto L20;
            Lifecycle.State r9 = r8.getCurrentState();
        L22:
            if (r9 != Lifecycle.State.RESUMED) goto L28;
            ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r12 = r0.a;
            if (r12 == null) goto L28;
            if (r12.k != true) goto L28;
            boolean r13 = true;
        L29:
            if (r4 != r5) goto L33;
            if (r13 == false) goto L32;
            r4 = FireCase.HostResume;
            goto L33
        L32:
            r4 = FireCase.HostStop;
        L33:
            i r14 = r0.j.a(r4);
            r0.j = r14;
            ProxyStage r15 = r0.k;
            if (Intrinsics.areEqual(r14, k.a) == false) goto L40;
            ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r16 = r0.a;
            if (r16 == null) goto L40;
            if (r16.l != true) goto L40;
            ProxyStage r17 = ProxyStage.Active;
        L41:
            if (r15 == r17) goto L43;
        L45:
            r0.k = r17;
            ProxyStage r18 = ProxyStage.Active;
            if (r17 != r18) goto L83;
            Intrinsics.areEqual(r0.b, null);
            if (r11.a != FireCase.HostResume) goto L56;
            ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r19 = r0.a;
            if (r19 == null) goto L54;
            if (r19.m == true) goto L56;
        L54:
            if (r0.o == true) goto L56;
            boolean r110 = true;
        L57:
            r0.c = r110;
            final ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r20 = r0.a;
            if (r20 == null) goto L60;
            r20.m = false;
        L60:
            r0.o = false;
            if (r20 != null) goto L63;
            return;
        L63:
            if ((r20 instanceof g) == true) goto L65;
            Object r21 = null;
        L66:
            final g r22 = (g) r21;
            if (r22 != null) goto L69;
        L81:
            r0.e(new ReusedAssemProxy$handleOnResume$3(r0));
            return;
        L69:
            if ((!r110) == true) goto L72;
            r22 = null;
        L72:
            if (r22 == null) goto L81;
            if ((r22 instanceof f) == false) goto L77;
            r3 = r22;
        L77:
            f r23 = (f) r3;
            if (r23 == null) goto L80;
            r23.b();
            goto L81
        L80:
            ((Handler) r0.g.getValue()).post(new l(new ReusedAssemProxy$handleOnResume$$inlined$apply$lambda$1(r22, r0, r20)));
            goto L81
        L65:
            r21 = r20;
        L56:
            r110 = false;
            goto L57
        L83:
            if (r17 != ProxyStage.Silent) goto L89;
            if (r15 != r18) goto L90;
            r0.e(new ReusedAssemProxy$handleOnStop$1(r0));
            return;
        L90:
            return;
        L89:
            return;
        L43:
            if (r17 == ProxyStage.Active) goto L45;
            return;
        L40:
            r17 = ProxyStage.Silent;
        L28:
            r13 = false;
        L20:
            r9 = null;
            goto L22
        L5:
            if (r4 == FireCase.HostDetach) goto L8;
            r6 = false;
            goto L10
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ReusedAssemProxy a;

        public b(ReusedAssemProxy r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReusedAssemProxy r0 = this.a;     // Catch: Throwable -> L4
            ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r1 = r0.a;     // Catch: Throwable -> L4
            r0.f = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
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

    public final LifecycleOwner aM() {
        return this;
    }

    public final void a() {
        final ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r0 = this.a;
        if (r0 == null) goto L18;
        final List r2 = null;
        if ((r0 instanceof g) == true) goto L7;
        Object r1 = null;
    L8:
        final g r3 = (g) r1;
        c();
        Function0<Unit> r4 = new ReusedAssemProxy$bind$runnable$1(this, r0, r3, r2);
        Lazy r5 = HostInjector.a;
        r4.invoke();
        if (r3 == null) goto L16;
        boolean r6 = r3.isActive();
        r0.l = r6;
        if (r6 == true) goto L16;
        Function0<Unit> r7 = new ReusedAssemProxy$bind$$inlined$let$lambda$1(this, r0);
        if (r0.k == false) goto L15;
        r7.invoke();
        goto L16
    L15:
        r0.v.add(r7);
    L16:
        this.n.onNext(new com.bytedance.assem.arch.reused.a(FireCase.HostBind, r0));
        Intrinsics.areEqual(this.b, null);
        return;
    L7:
        r1 = r0;
        goto L8
    }

    public final void c() {
        if (this.d.getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        return;
    L5:
        e(new ReusedAssemProxy$handleOnCreate$1(this));
        if (this.f == true) goto L12;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L10;
        HostInjector.a().execute(new b(this));
        goto L12
    L10:
        this.f = true;
    L12:
        if ((!this.h.isEmpty()) == false) goto L17;
        Iterator<ReusedAssemProxy> r0 = this.h.iterator();
    L15:
        if (r0.hasNext() == false) goto L19;
        r0.next().c();
        goto L15
    L19:
        return;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("Position=");
        Function0<Integer> r1 = this.m;
        String r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = (Integer) r1.invoke();
    L6:
        r0.append(r3);
        r0.append(", Proxy@");
        r0.append(Integer.toHexString(hashCode()));
        r0.append("(host@");
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r4 = this.a;
        if (r4 == null) goto L9;
        r2 = Integer.toHexString(r4.hashCode());
    L9:
        r0.append(r2);
        r0.append(",state:");
        r0.append(this.d.getCurrentState());
        r0.append(')');
        return r0.toString();
    L5:
        r3 = null;
        goto L6
    }

    public ReusedAssemProxy() {
        this.c = true;
        this.d = new LifecycleRegistry(this);
        this.e = new ViewModelStore();
        this.g = LazyKt.lazy(ReusedAssemProxy$handler$2.INSTANCE);
        this.h = new CopyOnWriteArrayList();
        this.j = u.a;
        this.k = ProxyStage.Silent;
        new LinkedList();
        BehaviorSubject<com.bytedance.assem.arch.reused.a> r1 = BehaviorSubject.createDefault(new com.bytedance.assem.arch.reused.a(FireCase.Default, null));
        this.n = r1;
        r1.hide().subscribe(new a(this));
        this.o = true;
        this.p = new ConcurrentHashMap();
        this.q = new ConcurrentHashMap();
    }

    public final Lifecycle getLifecycle() {
        return this.d;
    }

    public final ViewModelStore getViewModelStore() {
        return this.e;
    }

    @Override // com.bytedance.assem.arch.reused.IResuedAssemProxy
    public final BehaviorSubject<com.bytedance.assem.arch.reused.a> gl() {
        return this.n;
    }

    public final com.bytedance.tiktok.proxy.a oq() {
        return this.a;
    }

    public final boolean rQ() {
        return this.c;
    }

    public final void e(Function0<Unit> r3) {
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
        r3.invoke();
        return;
    L5:
        ((Handler) this.g.getValue()).post(new c(r3));
    }

    @Override // com.bytedance.assem.arch.reused.IResuedAssemProxy
    public final void jz(ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r6) {
        Iterator<ReusedAssemProxy> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ReusedAssemProxy r1 = r0.next();
        if (Intrinsics.areEqual(r1.b, Reflection.getOrCreateKotlinClass(r6.getClass())) == false) goto L4;
    L9:
        ReusedAssemProxy r2 = r1;
        if (r2 != null) goto L13;
        r2 = new ReusedAssemProxy();
        this.h.add(r2);
        Lazy r3 = HostInjector.a;
    L13:
        Object r4 = this.i;
        Function1 r5 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.l, 1);
        Function0<Integer> r7 = this.m;
        r2.i = r4;
        r2.a = null;
        if (r2.b != null) goto L16;
        r2.b = Reflection.getOrCreateKotlinClass(r6.getClass());
    L16:
        r6.r = r2;
        r2.a = r6;
        r2.l = r5;
        r2.m = r7;
        r2.a();
        r2.b(r6, r2, r4, r7);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void b(ReusedUIAssem r7, ReusedAssemProxy r8, Object r9, Function0 r10) {
        FragmentActivity r0 = AssemExtKt.a(r7);
        if (r0 == null) goto L5;
        AssemSupervisor r11 = ((Assembler) ViewModelProviders.of(r0).get(Assembler.class)).findAssemSupervisor(r7);
    L6:
        if (r11 == null) goto L8;
        CopyOnWriteArrayList<Assem> r12 = r11.b;
    L9:
        if (r12 == null) goto L41;
        Iterator<T> r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L51;
        Assem r1 = (Assem) r13.next();
        if (r1 == null) goto L40;
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r2 = (ReusedUIAssem) r1;
        Iterator<ReusedAssemProxy> r3 = r8.h.iterator();
    L17:
        if (r3.hasNext() == false) goto L21;
        ReusedAssemProxy r4 = r3.next();
        if (Intrinsics.areEqual(r4.b, Reflection.getOrCreateKotlinClass(r2.getClass())) == false) goto L17;
    L22:
        ReusedAssemProxy r5 = r4;
        if (r5 != null) goto L26;
        r5 = new ReusedAssemProxy();
        r5.b = Reflection.getOrCreateKotlinClass(r2.getClass());
        r8.h.add(r5);
    L26:
        r2.r = r5;
        r5.a = r2;
        r5.i = r9;
        r5.l = this.l;
        r5.m = r10;
        r5.a();
        FragmentActivity r6 = AssemExtKt.a(r2);
        if (r6 == null) goto L29;
        AssemSupervisor r14 = ((Assembler) ViewModelProviders.of(r6).get(Assembler.class)).findAssemSupervisor(r2);
    L30:
        if (r14 == null) goto L36;
        CopyOnWriteArrayList<Assem> r15 = r14.b;
        if (r15 == null) goto L36;
        if (r15.isEmpty() == true) goto L36;
        boolean r16 = true;
    L37:
        if (r16 == false) goto L12;
        b(r2, r5, r9, r10);
    L36:
        r16 = false;
        goto L37
    L29:
        r14 = null;
        goto L30
    L21:
        r4 = null;
        goto L22
    L40:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.assem.arch.reused.ReusedUIAssem<out com.bytedance.tiktok.proxy.IVMReceiver>");
    L51:
        return;
    L41:
        return;
    L8:
        r12 = null;
        goto L9
    L5:
        r11 = null;
        goto L6
    }
}
