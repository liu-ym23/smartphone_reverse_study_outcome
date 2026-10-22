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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tiktok.proxy.IVMProxy;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/assem/arch/reused/ReusedAssemProxyV1;", "Lcom/bytedance/tiktok/proxy/IVMProxy;", "Lcom/bytedance/tiktok/proxy/a;", "", "Lcom/bytedance/assem/arch/reused/IResuedAssemProxy;", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public final class ReusedAssemProxyV1 implements IVMProxy<com.bytedance.tiktok.proxy.a, Object>, com.bytedance.tiktok.proxy.a, IResuedAssemProxy {
    public ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> a;
    public KClass<? extends ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a>> b;
    public boolean c;
    public final LifecycleRegistry d;
    public final ViewModelStore e;
    public boolean f;
    public final Lazy g;
    public final List<ReusedAssemProxyV1> h;
    public Object i;
    public Object j;
    public Function0<Integer> k;
    public final Queue<Function0<Unit>> l;
    public final Map<KClass<?>, Object> m;
    public final Map<KClass<?>, AssemViewModel<?>> n;

    public static final class a implements Runnable {
        public final /* synthetic */ ReusedAssemProxyV1 a;

        /* JADX INFO: renamed from: com.bytedance.assem.arch.reused.ReusedAssemProxyV1$a$a, reason: collision with other inner class name */
        public static final class RunnableC0063a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0063a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(ReusedAssemProxyV1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReusedAssemProxyV1 r0 = this.a;     // Catch: Throwable -> L4
            ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r1 = r0.a;     // Catch: Throwable -> L4
            ((Handler) r0.g.getValue()).post(new RunnableC0063a(this));     // Catch: Throwable -> L4
            this.a.f = true;     // Catch: Throwable -> L4
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

    @Override // com.bytedance.assem.arch.reused.IResuedAssemProxy
    public final BehaviorSubject<com.bytedance.assem.arch.reused.a> gl() {
        return null;
    }

    public final void a() {
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r0 = this.a;
        if (r0 == null) goto L9;
        LifecycleRegistry r1 = r0.c;
        if (r1 == null) goto L9;
        Lifecycle.State r2 = r1.getCurrentState();
        if (r2 == null) goto L9;
    L10:
        Lifecycle.State r3 = Lifecycle.State.CREATED;
        if (r2.compareTo(r3) >= 0) goto L14;
        return;
    L14:
        if (this.d.getCurrentState().compareTo(r3) >= 0) goto L16;
        return;
    L16:
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r4 = this.a;
        boolean r5 = r4 instanceof g;
        Object r6 = null;
        boolean r7 = false;
        Object r8 = r4;
        if (r5 == true) goto L19;
        r8 = null;
    L19:
        g r9 = (g) r8;
        if (r9 == null) goto L22;
        r9.a();
    L22:
        Map<KClass<?>, Object> r10 = this.m;
        if (r10 != null) goto L25;
    L28:
        boolean r11 = true;
    L29:
        if (r11 == true) goto L31;
        Iterator r12 = ((LinkedHashMap) this.m).entrySet().iterator();
    L44:
        if (r12.hasNext() == false) goto L57;
        Map.Entry r13 = (Map.Entry) r12.next();
        final AssemViewModel r14 = (AssemViewModel) ((LinkedHashMap) this.n).get(r13.getKey());
        if (r14 == null) goto L44;
        Object r15 = this.i;
        Object r16 = r13.getValue();
        final boolean r17 = r7 ? 1 : 0;
        r14.syncItem2State(r15, null, r16, new ReusedAssemProxyV1$bind$$inlined$forEach$lambda$1(r14, this, r17));
        goto L44
    L57:
        return;
    L31:
        if ((this.a instanceof g) == true) goto L33;
        return;
    L33:
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L35;
        ((Handler) this.g.getValue()).post(new n(this, null));
        return;
    L35:
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r18 = this.a;
        if ((r18 instanceof g) == false) goto L39;
        r6 = r18;
    L39:
        g r19 = (g) r6;
        if (r19 == null) goto L55;
        r19.onBind();
        return;
    L55:
        return;
    L25:
        if (r10.isEmpty() == true) goto L28;
        r11 = false;
    L9:
        r2 = Lifecycle.State.RESUMED;
        goto L10
    }

    public final void f() {
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        if (this.f == true) goto L11;
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r0 = this.a;
        if (r0 == null) goto L9;
        Lifecycle.State r1 = r0.c.getCurrentState();
        Lifecycle.State r2 = Lifecycle.State.CREATED;
        if (r1.compareTo(r2) >= 0) goto L9;
        c(r2, r0);
    L9:
        HostInjector.a().execute(new a(this));
    L11:
        if ((!((ArrayList) this.h).isEmpty()) == false) goto L16;
        Iterator r3 = ((ArrayList) this.h).iterator();
    L14:
        if (r3.hasNext() == false) goto L18;
        ReusedAssemProxyV1 r4 = (ReusedAssemProxyV1) r3.next();
        Lifecycle.State r5 = Lifecycle.State.CREATED;
        r4.getClass();
        e(r5, r4, false);
        goto L14
    L18:
        return;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("Position=");
        Function0<Integer> r1 = this.k;
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

    public ReusedAssemProxyV1() {
        this.c = true;
        this.d = new LifecycleRegistry(this);
        this.e = new ViewModelStore();
        this.g = LazyKt.lazy(ReusedAssemProxyV1$handler$2.INSTANCE);
        this.h = new ArrayList();
        this.l = new LinkedList();
        this.m = new LinkedHashMap();
        this.n = new LinkedHashMap();
    }

    public final Lifecycle getLifecycle() {
        return this.d;
    }

    public final ViewModelStore getViewModelStore() {
        return this.e;
    }

    public final com.bytedance.tiktok.proxy.a oq() {
        return this.a;
    }

    public final boolean rQ() {
        return this.c;
    }

    public final void g(boolean r4) {
        this.c = r4;
        if ((!((ArrayList) this.h).isEmpty()) == false) goto L8;
        Iterator r0 = ((ArrayList) this.h).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ReusedAssemProxyV1 r1 = (ReusedAssemProxyV1) r0.next();
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        r1.getClass();
        e(r2, r1, r4);
    L8:
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    public final void h(boolean r4) {
        this.c = r4;
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if ((!((ArrayList) this.h).isEmpty()) == false) goto L8;
        Iterator r0 = ((ArrayList) this.h).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        ReusedAssemProxyV1 r1 = (ReusedAssemProxyV1) r0.next();
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        r1.getClass();
        e(r2, r1, r4);
        goto L6
    L10:
        return;
    }

    public final void i(boolean r4) {
        this.c = r4;
        if ((!((ArrayList) this.h).isEmpty()) == false) goto L8;
        Iterator r0 = ((ArrayList) this.h).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ReusedAssemProxyV1 r1 = (ReusedAssemProxyV1) r0.next();
        Lifecycle.State r2 = Lifecycle.State.CREATED;
        r1.getClass();
        e(r2, r1, r4);
    L8:
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    @Override // com.bytedance.assem.arch.reused.IResuedAssemProxy
    public final void jz(ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r8) {
        r8.t();
        List<ReusedAssemProxyV1> r0 = this.h;
        if (r0 == null) goto L14;
        Iterator r1 = ((ArrayList) r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r3 = r1.next();
        if (Intrinsics.areEqual(((ReusedAssemProxyV1) r3).b, Reflection.getOrCreateKotlinClass(r8.getClass())) == false) goto L6;
    L11:
        ReusedAssemProxyV1 r4 = (ReusedAssemProxyV1) r3;
        if (r4 == null) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L26;
        Object r5 = this.i;
        Function1 r6 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.j, 1);
        Function0<Integer> r7 = this.k;
        r4.i = r5;
        r4.a = null;
        if (r4.b != null) goto L19;
        r4.b = Reflection.getOrCreateKotlinClass(r8.getClass());
    L19:
        r8.r = r4;
        r4.a = r8;
        if (r8.c.getCurrentState().compareTo(r4.d.getCurrentState()) >= 0) goto L25;
        Lifecycle.State r9 = r4.d.getCurrentState();
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r10 = r4.a;
        if (r10 != null) goto L24;
        Intrinsics.throwNpe();
    L24:
        c(r9, r10);
    L25:
        r4.j = r6;
        r4.k = r7;
        r4.a();
        r4.b(r8, r4, r5, r7);
    L26:
        LifecycleRegistry r11 = this.d;
        if (r11 == null) goto L31;
        Lifecycle.State r12 = r11.getCurrentState();
        if (r12 == null) goto L31;
    L32:
        e(r12, r4, true);
        return;
    L31:
        r12 = Lifecycle.State.INITIALIZED;
        goto L32
    L10:
        r3 = null;
    L14:
        r4 = new ReusedAssemProxyV1();
        ((ArrayList) this.h).add(r4);
        r2 = false;
        goto L15
    }

    public static void c(Lifecycle.State r2, ReusedUIAssem r3) {
        int r4 = m.a[r2.ordinal()];
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

    public static void e(Lifecycle.State r2, ReusedAssemProxyV1 r3, boolean r4) {
        int r5 = m.b[r2.ordinal()];
        if (r5 != 1) goto L5;
        Lifecycle.State r6 = r3.d.getCurrentState();
        Lifecycle.State r0 = Lifecycle.State.CREATED;
        if (r6.compareTo(r0) >= 0) goto L62;
        r3.f();
        return;
    L62:
        if (r3.d.getCurrentState().compareTo(Lifecycle.State.STARTED) <= 0) goto L65;
        r3.g(r4);
    L65:
        if (r3.d.getCurrentState().compareTo(r0) <= 0) goto L81;
        r3.i(r4);
        return;
    L81:
        return;
    L5:
        if (r5 != 2) goto L7;
        Lifecycle.State r7 = r3.d.getCurrentState();
        Lifecycle.State r1 = Lifecycle.State.STARTED;
        if (r7.compareTo(r1) >= 0) goto L56;
        if (r3.d.getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L53;
        r3.f();
    L53:
        if (r3.a == null) goto L76;
        r3.h(r4);
        return;
    L76:
        return;
    L56:
        if (r3.d.getCurrentState().compareTo(r1) <= 0) goto L78;
        r3.g(r4);
        return;
    L78:
        return;
    L7:
        if (r5 == 3) goto L30;
        if (r5 == 4) goto L15;
        if (r5 != 5) goto L82;
        r3.d.markState(Lifecycle.State.INITIALIZED);
        return;
    L82:
        return;
    L15:
        if (r3.d.getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L18;
        r3.g(r4);
    L18:
        if (r3.d.getCurrentState().compareTo(Lifecycle.State.STARTED) < 0) goto L21;
        r3.i(r4);
    L21:
        if (r3.d.getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L23;
        return;
    L23:
        if ((!((ArrayList) r3.h).isEmpty()) == false) goto L28;
        Iterator r8 = ((ArrayList) r3.h).iterator();
    L26:
        if (r8.hasNext() == false) goto L28;
        ReusedAssemProxyV1 r9 = (ReusedAssemProxyV1) r8.next();
        Lifecycle.State r10 = Lifecycle.State.DESTROYED;
        r9.getClass();
        e(r10, r9, false);
    L28:
        r3.d.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        ((LinkedList) r3.l).clear();
        ((LinkedHashMap) r3.m).clear();
        ((LinkedHashMap) r3.n).clear();
        r3.e.clear();
        ((Handler) r3.g.getValue()).removeCallbacksAndMessages(null);
        return;
    L30:
        if (r3.d.getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L32;
        return;
    L32:
        if (r3.d.getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L35;
        r3.f();
    L35:
        if (r3.d.getCurrentState().compareTo(Lifecycle.State.STARTED) >= 0) goto L39;
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r11 = r3.a;
        if (r11 == null) goto L39;
        Objects.toString(r11);
        Objects.toString(r11.c.getCurrentState());
        r3.h(r4);
    L39:
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r12 = r3.a;
        if (r12 == null) goto L74;
        r12.toString();
        Objects.toString(r12.c.getCurrentState());
        r3.c = r4;
        r3.d.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if ((!((ArrayList) r3.h).isEmpty()) == false) goto L75;
        Iterator r13 = ((ArrayList) r3.h).iterator();
    L45:
        if (r13.hasNext() == false) goto L83;
        ReusedAssemProxyV1 r14 = (ReusedAssemProxyV1) r13.next();
        Lifecycle.State r15 = Lifecycle.State.RESUMED;
        r14.getClass();
        e(r15, r14, r4);
        goto L45
    L83:
        return;
    L75:
        return;
    }

    public final void b(ReusedUIAssem r9, ReusedAssemProxyV1 r10, Object r11, Function0 r12) {
        FragmentActivity r0 = AssemExtKt.a(r9);
        if (r0 == null) goto L5;
        AssemSupervisor r13 = ((Assembler) ViewModelProviders.of(r0).get(Assembler.class)).findAssemSupervisor(r9);
    L6:
        if (r13 == null) goto L8;
        CopyOnWriteArrayList<Assem> r14 = r13.b;
    L9:
        if (r14 == null) goto L56;
        Iterator<T> r15 = r14.iterator();
        int r2 = 0;
    L12:
        if (r15.hasNext() == false) goto L61;
        Object r3 = r15.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        Assem r5 = (Assem) r3;
        if (r5 == null) goto L55;
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r6 = (ReusedUIAssem) r5;
        List<ReusedAssemProxyV1> r7 = r10.h;
        boolean r8 = true;
        if (r7 != null) goto L21;
    L24:
        boolean r16 = true;
    L25:
        if (r16 == false) goto L27;
    L33:
        ReusedAssemProxyV1 r17 = new ReusedAssemProxyV1();
        if (r17.b != null) goto L36;
        r17.b = Reflection.getOrCreateKotlinClass(r6.getClass());
    L36:
        r6.r = r17;
        r17.a = r6;
        ListProtector.add(r10.h, r2, r17);
        ReusedAssemProxyV1 r18 = r17;
    L37:
        r6.t();
        r18.i = r11;
        r18.j = this.j;
        r18.k = r12;
        if (r6.c.getCurrentState().compareTo(r18.d.getCurrentState()) >= 0) goto L40;
        c(r18.d.getCurrentState(), r6);
    L40:
        r18.a();
        FragmentActivity r19 = AssemExtKt.a(r6);
        if (r19 == null) goto L43;
        AssemSupervisor r20 = ((Assembler) ViewModelProviders.of(r19).get(Assembler.class)).findAssemSupervisor(r6);
    L44:
        if (r20 == null) goto L50;
        CopyOnWriteArrayList<Assem> r21 = r20.b;
        if (r21 == null) goto L50;
        if (r21.isEmpty() == true) goto L50;
    L51:
        if (r8 == false) goto L53;
        b(r6, r18, r11, r12);
    L53:
        r2 = r4;
    L50:
        r8 = false;
        goto L51
    L43:
        r20 = null;
        goto L44
    L27:
        if (((ArrayList) r10.h).size() <= r2) goto L33;
        r18 = (ReusedAssemProxyV1) ListProtector.get(r10.h, r2);
        if (r18.b != null) goto L32;
        r18.b = Reflection.getOrCreateKotlinClass(r6.getClass());
    L32:
        r6.r = r18;
        r18.a = r6;
        goto L37
    L21:
        if (((ArrayList) r7).isEmpty() == true) goto L24;
        r16 = false;
        goto L25
    L55:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.assem.arch.reused.ReusedUIAssem<out com.bytedance.tiktok.proxy.IVMReceiver>");
    L61:
        return;
    L56:
        return;
    L8:
        r14 = null;
        goto L9
    L5:
        r13 = null;
        goto L6
    }
}
