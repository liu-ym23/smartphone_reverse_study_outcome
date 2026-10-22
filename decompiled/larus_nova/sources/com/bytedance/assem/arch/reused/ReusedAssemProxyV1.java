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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/assem/arch/reused/ReusedAssemProxyV1;", "Lcom/bytedance/tiktok/proxy/IVMProxy;", "Lcom/bytedance/tiktok/proxy/a;", "", "Lcom/bytedance/assem/arch/reused/IResuedAssemProxy;", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public final class ReusedAssemProxyV1 implements IVMProxy<com.bytedance.tiktok.proxy.a, Object>, com.bytedance.tiktok.proxy.a, IResuedAssemProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> f192967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KClass<? extends ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a>> f192968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f192969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleRegistry f192970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewModelStore f192971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f192972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f192973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<ReusedAssemProxyV1> f192974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f192975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f192976j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Integer> f192977k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Queue<Function0<Unit>> f192978l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<KClass<?>, Object> f192979m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<KClass<?>, AssemViewModel<?>> f192980n;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReusedAssemProxyV1 f192981a;

        /* JADX INFO: renamed from: com.bytedance.assem.arch.reused.ReusedAssemProxyV1$a$a, reason: collision with other inner class name */
        public static final class RunnableC2790a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f192982a;

            public RunnableC2790a(a r100) {
                this.f192982a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f192982a.f192981a.a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(ReusedAssemProxyV1 r100) {
            this.f192981a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReusedAssemProxyV1 r100 = this.f192981a;     // Catch: Throwable -> L4
            ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r101 = r100.f192967a;     // Catch: Throwable -> L4
            ((Handler) r100.f192973g.getValue()).post(new RunnableC2790a(this));     // Catch: Throwable -> L4
            this.f192981a.f192972f = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.tiktok.proxy.b
    public final LifecycleOwner aM() {
        return this;
    }

    @Override // com.bytedance.assem.arch.reused.IResuedAssemProxy
    public final BehaviorSubject<com.bytedance.assem.arch.reused.a> gl() {
        return null;
    }

    public final void a() {
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r100 = this.f192967a;
        if (r100 == null) goto L9;
        LifecycleRegistry r101 = r100.f192854c;
        if (r101 == null) goto L9;
        Lifecycle.State r102 = r101.getCurrentState();
        if (r102 == null) goto L9;
    L10:
        Lifecycle.State r103 = Lifecycle.State.CREATED;
        if (r102.compareTo(r103) >= 0) goto L14;
        return;
    L14:
        if (this.f192970d.getCurrentState().compareTo(r103) >= 0) goto L16;
        return;
    L16:
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r104 = this.f192967a;
        boolean r105 = r104 instanceof g;
        Object r106 = null;
        boolean r107 = false;
        Object r108 = r104;
        if (r105 == true) goto L19;
        r108 = null;
    L19:
        g r109 = (g) r108;
        if (r109 == null) goto L22;
        r109.a();
    L22:
        Map<KClass<?>, Object> r110 = this.f192979m;
        if (r110 != null) goto L25;
    L28:
        boolean r111 = true;
    L29:
        if (r111 == true) goto L31;
        Iterator r112 = ((LinkedHashMap) this.f192979m).entrySet().iterator();
    L44:
        if (r112.hasNext() == false) goto L57;
        Map.Entry r113 = (Map.Entry) r112.next();
        final AssemViewModel r114 = (AssemViewModel) ((LinkedHashMap) this.f192980n).get(r113.getKey());
        if (r114 == null) goto L44;
        Object r115 = this.f192975i;
        Object r116 = r113.getValue();
        final boolean r117 = r107 ? 1 : 0;
        r114.syncItem2State(r115, null, r116, new ReusedAssemProxyV1$bind$$inlined$forEach$lambda$1(r114, this, r117));
        goto L44
    L57:
        return;
    L31:
        if ((this.f192967a instanceof g) == true) goto L33;
        return;
    L33:
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L35;
        ((Handler) this.f192973g.getValue()).post(new n(this, null));
        return;
    L35:
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r118 = this.f192967a;
        if ((r118 instanceof g) == false) goto L39;
        r106 = r118;
    L39:
        g r119 = (g) r106;
        if (r119 == null) goto L55;
        r119.onBind();
        return;
    L55:
        return;
    L25:
        if (r110.isEmpty() == true) goto L28;
        r111 = false;
    L9:
        r102 = Lifecycle.State.RESUMED;
        goto L10
    }

    public final void f() {
        this.f192970d.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        if (this.f192972f == true) goto L11;
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r100 = this.f192967a;
        if (r100 == null) goto L9;
        Lifecycle.State r101 = r100.f192854c.getCurrentState();
        Lifecycle.State r102 = Lifecycle.State.CREATED;
        if (r101.compareTo(r102) >= 0) goto L9;
        c(r102, r100);
    L9:
        HostInjector.a().execute(new a(this));
    L11:
        if ((!((ArrayList) this.f192974h).isEmpty()) == false) goto L16;
        Iterator r103 = ((ArrayList) this.f192974h).iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        ReusedAssemProxyV1 r104 = (ReusedAssemProxyV1) r103.next();
        Lifecycle.State r105 = Lifecycle.State.CREATED;
        r104.getClass();
        e(r105, r104, false);
        goto L14
    L18:
        return;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("Position=");
        Function0<Integer> r101 = this.f192977k;
        String r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = r101.invoke();
    L6:
        r100.append(r103);
        r100.append(", Proxy@");
        r100.append(Integer.toHexString(hashCode()));
        r100.append("(host@");
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r104 = this.f192967a;
        if (r104 == null) goto L9;
        r102 = Integer.toHexString(r104.hashCode());
    L9:
        r100.append(r102);
        r100.append(",state:");
        r100.append(this.f192970d.getCurrentState());
        r100.append(')');
        return r100.toString();
    L5:
        r103 = null;
        goto L6
    }

    public ReusedAssemProxyV1() {
        this.f192969c = true;
        this.f192970d = new LifecycleRegistry(this);
        this.f192971e = new ViewModelStore();
        this.f192973g = LazyKt.lazy(ReusedAssemProxyV1$handler$2.INSTANCE);
        this.f192974h = new ArrayList();
        this.f192978l = new LinkedList();
        this.f192979m = new LinkedHashMap();
        this.f192980n = new LinkedHashMap();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f192970d;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return this.f192971e;
    }

    @Override // com.bytedance.tiktok.proxy.c
    public final com.bytedance.tiktok.proxy.a oq() {
        return this.f192967a;
    }

    @Override // com.bytedance.tiktok.proxy.NestedLifecycleOwner
    public final boolean rQ() {
        return this.f192969c;
    }

    public final void g(boolean r100) {
        this.f192969c = r100;
        if ((!((ArrayList) this.f192974h).isEmpty()) == false) goto L8;
        Iterator r101 = ((ArrayList) this.f192974h).iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ReusedAssemProxyV1 r102 = (ReusedAssemProxyV1) r101.next();
        Lifecycle.State r103 = Lifecycle.State.STARTED;
        r102.getClass();
        e(r103, r102, r100);
    L8:
        this.f192970d.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    public final void h(boolean r100) {
        this.f192969c = r100;
        this.f192970d.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if ((!((ArrayList) this.f192974h).isEmpty()) == false) goto L8;
        Iterator r101 = ((ArrayList) this.f192974h).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ReusedAssemProxyV1 r102 = (ReusedAssemProxyV1) r101.next();
        Lifecycle.State r103 = Lifecycle.State.STARTED;
        r102.getClass();
        e(r103, r102, r100);
        goto L6
    L10:
        return;
    }

    public final void i(boolean r100) {
        this.f192969c = r100;
        if ((!((ArrayList) this.f192974h).isEmpty()) == false) goto L8;
        Iterator r101 = ((ArrayList) this.f192974h).iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ReusedAssemProxyV1 r102 = (ReusedAssemProxyV1) r101.next();
        Lifecycle.State r103 = Lifecycle.State.CREATED;
        r102.getClass();
        e(r103, r102, r100);
    L8:
        this.f192970d.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    @Override // com.bytedance.assem.arch.reused.IResuedAssemProxy
    public final void jz(ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r100) {
        r100.t();
        List<ReusedAssemProxyV1> r101 = this.f192974h;
        if (r101 == null) goto L14;
        Iterator r102 = ((ArrayList) r101).iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((ReusedAssemProxyV1) r103).f192968b, Reflection.getOrCreateKotlinClass(r100.getClass())) == false) goto L6;
    L11:
        ReusedAssemProxyV1 r104 = (ReusedAssemProxyV1) r103;
        if (r104 == null) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == true) goto L26;
        Object r106 = this.f192975i;
        Function1 r107 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.f192976j, 1);
        Function0<Integer> r108 = this.f192977k;
        r104.f192975i = r106;
        r104.f192967a = null;
        if (r104.f192968b != null) goto L19;
        r104.f192968b = Reflection.getOrCreateKotlinClass(r100.getClass());
    L19:
        r100.f192994r = r104;
        r104.f192967a = r100;
        if (r100.f192854c.getCurrentState().compareTo(r104.f192970d.getCurrentState()) >= 0) goto L25;
        Lifecycle.State r109 = r104.f192970d.getCurrentState();
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r110 = r104.f192967a;
        if (r110 != null) goto L24;
        Intrinsics.throwNpe();
    L24:
        c(r109, r110);
    L25:
        r104.f192976j = r107;
        r104.f192977k = r108;
        r104.a();
        r104.b(r100, r104, r106, r108);
    L26:
        LifecycleRegistry r111 = this.f192970d;
        if (r111 == null) goto L31;
        Lifecycle.State r112 = r111.getCurrentState();
        if (r112 == null) goto L31;
    L32:
        e(r112, r104, true);
        return;
    L31:
        r112 = Lifecycle.State.INITIALIZED;
        goto L32
    L10:
        r103 = null;
    L14:
        r104 = new ReusedAssemProxyV1();
        ((ArrayList) this.f192974h).add(r104);
        r105 = false;
        goto L15
    }

    public static void c(Lifecycle.State r100, ReusedUIAssem r101) {
        int r102 = m.f193027a[r100.ordinal()];
        if (r102 != 1) goto L5;
        Lifecycle.State r103 = r101.f192854c.getCurrentState();
        Lifecycle.State r104 = Lifecycle.State.CREATED;
        if (r103.compareTo(r104) >= 0) goto L42;
        r101.k();
        return;
    L42:
        if (r101.f192854c.getCurrentState().compareTo(Lifecycle.State.STARTED) <= 0) goto L45;
        r101.l();
    L45:
        if (r101.f192854c.getCurrentState().compareTo(r104) <= 0) goto L56;
        r101.f192854c.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        r101.onStop();
        return;
    L56:
        return;
    L5:
        if (r102 != 2) goto L7;
        Lifecycle.State r105 = r101.f192854c.getCurrentState();
        Lifecycle.State r106 = Lifecycle.State.STARTED;
        if (r105.compareTo(r106) >= 0) goto L36;
        if (r101.f192854c.getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L34;
        r101.k();
    L34:
        r101.onStart();
        r101.f192854c.handleLifecycleEvent(Lifecycle.Event.ON_START);
        return;
    L36:
        if (r101.f192854c.getCurrentState().compareTo(r106) <= 0) goto L53;
        r101.l();
        return;
    L53:
        return;
    L7:
        if (r102 == 3) goto L21;
        if (r102 == 4) goto L12;
        return;
    L12:
        if (r101.f192854c.getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L15;
        r101.l();
    L15:
        if (r101.f192854c.getCurrentState().compareTo(Lifecycle.State.STARTED) < 0) goto L18;
        r101.f192854c.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        r101.onStop();
    L18:
        if (r101.f192854c.getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L48;
        r101.f192854c.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        r101.f192856e.clear();
        r101.onDestroy();
        return;
    L48:
        return;
    L21:
        if (r101.f192854c.getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L23;
        return;
    L23:
        if (r101.f192854c.getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L26;
        r101.k();
    L26:
        if (r101.f192854c.getCurrentState().compareTo(Lifecycle.State.STARTED) >= 0) goto L28;
        r101.onStart();
        r101.f192854c.handleLifecycleEvent(Lifecycle.Event.ON_START);
    L28:
        r101.m();
    }

    public static void e(Lifecycle.State r100, ReusedAssemProxyV1 r101, boolean r102) {
        int r103 = m.f193028b[r100.ordinal()];
        if (r103 != 1) goto L5;
        Lifecycle.State r104 = r101.f192970d.getCurrentState();
        Lifecycle.State r105 = Lifecycle.State.CREATED;
        if (r104.compareTo(r105) >= 0) goto L62;
        r101.f();
        return;
    L62:
        if (r101.f192970d.getCurrentState().compareTo(Lifecycle.State.STARTED) <= 0) goto L65;
        r101.g(r102);
    L65:
        if (r101.f192970d.getCurrentState().compareTo(r105) <= 0) goto L81;
        r101.i(r102);
        return;
    L81:
        return;
    L5:
        if (r103 != 2) goto L7;
        Lifecycle.State r106 = r101.f192970d.getCurrentState();
        Lifecycle.State r107 = Lifecycle.State.STARTED;
        if (r106.compareTo(r107) >= 0) goto L56;
        if (r101.f192970d.getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L53;
        r101.f();
    L53:
        if (r101.f192967a == null) goto L76;
        r101.h(r102);
        return;
    L76:
        return;
    L56:
        if (r101.f192970d.getCurrentState().compareTo(r107) <= 0) goto L78;
        r101.g(r102);
        return;
    L78:
        return;
    L7:
        if (r103 == 3) goto L30;
        if (r103 == 4) goto L15;
        if (r103 != 5) goto L82;
        r101.f192970d.markState(Lifecycle.State.INITIALIZED);
        return;
    L82:
        return;
    L15:
        if (r101.f192970d.getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L18;
        r101.g(r102);
    L18:
        if (r101.f192970d.getCurrentState().compareTo(Lifecycle.State.STARTED) < 0) goto L21;
        r101.i(r102);
    L21:
        if (r101.f192970d.getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L23;
        return;
    L23:
        if ((!((ArrayList) r101.f192974h).isEmpty()) == false) goto L28;
        Iterator r108 = ((ArrayList) r101.f192974h).iterator();
    L26:
        if (r108.hasNext() == false) goto L28;
        ReusedAssemProxyV1 r109 = (ReusedAssemProxyV1) r108.next();
        Lifecycle.State r110 = Lifecycle.State.DESTROYED;
        r109.getClass();
        e(r110, r109, false);
    L28:
        r101.f192970d.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        ((LinkedList) r101.f192978l).clear();
        ((LinkedHashMap) r101.f192979m).clear();
        ((LinkedHashMap) r101.f192980n).clear();
        r101.f192971e.clear();
        ((Handler) r101.f192973g.getValue()).removeCallbacksAndMessages(null);
        return;
    L30:
        if (r101.f192970d.getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L32;
        return;
    L32:
        if (r101.f192970d.getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L35;
        r101.f();
    L35:
        if (r101.f192970d.getCurrentState().compareTo(Lifecycle.State.STARTED) >= 0) goto L39;
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r111 = r101.f192967a;
        if (r111 == null) goto L39;
        Objects.toString(r111);
        Objects.toString(r111.f192854c.getCurrentState());
        r101.h(r102);
    L39:
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r112 = r101.f192967a;
        if (r112 == null) goto L74;
        r112.toString();
        Objects.toString(r112.f192854c.getCurrentState());
        r101.f192969c = r102;
        r101.f192970d.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if ((!((ArrayList) r101.f192974h).isEmpty()) == false) goto L75;
        Iterator r113 = ((ArrayList) r101.f192974h).iterator();
    L45:
        if (r113.hasNext() == false) goto L83;
        ReusedAssemProxyV1 r114 = (ReusedAssemProxyV1) r113.next();
        Lifecycle.State r115 = Lifecycle.State.RESUMED;
        r114.getClass();
        e(r115, r114, r102);
        goto L45
    L83:
        return;
    L75:
        return;
    }

    public final void b(ReusedUIAssem r100, ReusedAssemProxyV1 r110, Object r111, Function0 r112) {
        FragmentActivity r101 = AssemExtKt.a(r100);
        if (r101 == null) goto L5;
        AssemSupervisor r102 = ((Assembler) ViewModelProviders.of(r101).get(Assembler.class)).findAssemSupervisor(r100);
    L6:
        if (r102 == null) goto L8;
        CopyOnWriteArrayList<Assem> r103 = r102.f192871b;
    L9:
        if (r103 == null) goto L56;
        Iterator<T> r104 = r103.iterator();
        int r105 = 0;
    L12:
        if (r104.hasNext() == false) goto L61;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        Assem r108 = (Assem) r106;
        if (r108 == null) goto L55;
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r109 = (ReusedUIAssem) r108;
        List<ReusedAssemProxyV1> r113 = r110.f192974h;
        boolean r114 = true;
        if (r113 != null) goto L21;
    L24:
        boolean r115 = true;
    L25:
        if (r115 == false) goto L27;
    L33:
        ReusedAssemProxyV1 r116 = new ReusedAssemProxyV1();
        if (r116.f192968b != null) goto L36;
        r116.f192968b = Reflection.getOrCreateKotlinClass(r109.getClass());
    L36:
        r109.f192994r = r116;
        r116.f192967a = r109;
        ListProtector.add(r110.f192974h, r105, r116);
        ReusedAssemProxyV1 r117 = r116;
    L37:
        r109.t();
        r117.f192975i = r111;
        r117.f192976j = this.f192976j;
        r117.f192977k = r112;
        if (r109.f192854c.getCurrentState().compareTo(r117.f192970d.getCurrentState()) >= 0) goto L40;
        c(r117.f192970d.getCurrentState(), r109);
    L40:
        r117.a();
        FragmentActivity r118 = AssemExtKt.a(r109);
        if (r118 == null) goto L43;
        AssemSupervisor r119 = ((Assembler) ViewModelProviders.of(r118).get(Assembler.class)).findAssemSupervisor(r109);
    L44:
        if (r119 == null) goto L50;
        CopyOnWriteArrayList<Assem> r120 = r119.f192871b;
        if (r120 == null) goto L50;
        if (r120.isEmpty() == true) goto L50;
    L51:
        if (r114 == false) goto L53;
        b(r109, r117, r111, r112);
    L53:
        r105 = r107;
    L50:
        r114 = false;
        goto L51
    L43:
        r119 = null;
        goto L44
    L27:
        if (((ArrayList) r110.f192974h).size() <= r105) goto L33;
        r117 = (ReusedAssemProxyV1) ListProtector.get(r110.f192974h, r105);
        if (r117.f192968b != null) goto L32;
        r117.f192968b = Reflection.getOrCreateKotlinClass(r109.getClass());
    L32:
        r109.f192994r = r117;
        r117.f192967a = r109;
        goto L37
    L21:
        if (((ArrayList) r113).isEmpty() == true) goto L24;
        r115 = false;
        goto L25
    L55:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.assem.arch.reused.ReusedUIAssem<out com.bytedance.tiktok.proxy.IVMReceiver>");
    L61:
        return;
    L56:
        return;
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }
}
