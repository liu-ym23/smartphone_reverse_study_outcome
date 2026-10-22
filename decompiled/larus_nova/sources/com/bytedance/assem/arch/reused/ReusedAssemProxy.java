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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/assem/arch/reused/ReusedAssemProxy;", "Lcom/bytedance/tiktok/proxy/IVMProxy;", "Lcom/bytedance/tiktok/proxy/a;", "", "Lcom/bytedance/assem/arch/reused/IResuedAssemProxy;", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public final class ReusedAssemProxy implements IVMProxy<com.bytedance.tiktok.proxy.a, Object>, com.bytedance.tiktok.proxy.a, IResuedAssemProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> f192947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KClass<? extends ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a>> f192948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f192949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleRegistry f192950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewModelStore f192951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f192952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f192953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList<ReusedAssemProxy> f192954h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f192955i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i f192956j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ProxyStage f192957k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Object f192958l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<Integer> f192959m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final BehaviorSubject<com.bytedance.assem.arch.reused.a> f192960n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f192961o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ConcurrentHashMap<KClass<?>, Object> f192962p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap<KClass<?>, AssemViewModel<?>> f192963q;

    public static final class a<T> implements Consumer<com.bytedance.assem.arch.reused.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReusedAssemProxy f192964a;

        public a(ReusedAssemProxy r100) {
            this.f192964a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(com.bytedance.assem.arch.reused.a r110) {
            com.bytedance.assem.arch.reused.a r111 = r110;
            final ReusedAssemProxy r100 = this.f192964a;
            KClass<? extends ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a>> r101 = r100.f192948b;
            Lazy r102 = HostInjector.f192919a;
            g r103 = null;
            Intrinsics.areEqual(r101, null);
            FireCase r104 = r111.f193018a;
            FireCase r105 = FireCase.HostBind;
            if (r104 != r105) goto L5;
        L8:
            boolean r106 = true;
        L10:
            if ((!Intrinsics.areEqual(r111.f193019b, r100.f192947a)) == false) goto L13;
            if (r106 == true) goto L13;
            return;
        L13:
            if (r106 == false) goto L15;
            r100.f192961o = true;
        L15:
            ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r107 = r100.f192947a;
            if (r107 == null) goto L20;
            LifecycleRegistry r108 = r107.f192854c;
            if (r108 == null) goto L20;
            Lifecycle.State r109 = r108.getCurrentState();
        L22:
            if (r109 != Lifecycle.State.RESUMED) goto L28;
            ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r112 = r100.f192947a;
            if (r112 == null) goto L28;
            if (r112.f192987k != true) goto L28;
            boolean r113 = true;
        L29:
            if (r104 != r105) goto L33;
            if (r113 == false) goto L32;
            r104 = FireCase.HostResume;
            goto L33
        L32:
            r104 = FireCase.HostStop;
        L33:
            i r114 = r100.f192956j.a(r104);
            r100.f192956j = r114;
            ProxyStage r115 = r100.f192957k;
            if (Intrinsics.areEqual(r114, k.f193025a) == false) goto L40;
            ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r116 = r100.f192947a;
            if (r116 == null) goto L40;
            if (r116.f192988l != true) goto L40;
            ProxyStage r117 = ProxyStage.Active;
        L41:
            if (r115 == r117) goto L43;
        L45:
            r100.f192957k = r117;
            ProxyStage r118 = ProxyStage.Active;
            if (r117 != r118) goto L83;
            Intrinsics.areEqual(r100.f192948b, null);
            if (r111.f193018a != FireCase.HostResume) goto L56;
            ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r119 = r100.f192947a;
            if (r119 == null) goto L54;
            if (r119.f192989m == true) goto L56;
        L54:
            if (r100.f192961o == true) goto L56;
            boolean r120 = true;
        L57:
            r100.f192949c = r120;
            final ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r121 = r100.f192947a;
            if (r121 == null) goto L60;
            r121.f192989m = false;
        L60:
            r100.f192961o = false;
            if (r121 != null) goto L63;
            return;
        L63:
            if ((r121 instanceof g) == true) goto L65;
            Object r122 = null;
        L66:
            final g r123 = (g) r122;
            if (r123 != null) goto L69;
        L81:
            r100.e(new ReusedAssemProxy$handleOnResume$3(r100));
            return;
        L69:
            if ((!r120) == true) goto L72;
            r123 = null;
        L72:
            if (r123 == null) goto L81;
            if ((r123 instanceof f) == false) goto L77;
            r103 = r123;
        L77:
            f r124 = (f) r103;
            if (r124 == null) goto L80;
            r124.b();
            goto L81
        L80:
            ((Handler) r100.f192953g.getValue()).post(new l(new ReusedAssemProxy$handleOnResume$$inlined$apply$lambda$1(r123, r100, r121)));
            goto L81
        L65:
            r122 = r121;
        L56:
            r120 = false;
            goto L57
        L83:
            if (r117 != ProxyStage.Silent) goto L89;
            if (r115 != r118) goto L90;
            r100.e(new ReusedAssemProxy$handleOnStop$1(r100));
            return;
        L90:
            return;
        L89:
            return;
        L43:
            if (r117 == ProxyStage.Active) goto L45;
            return;
        L40:
            r117 = ProxyStage.Silent;
        L28:
            r113 = false;
        L20:
            r109 = null;
            goto L22
        L5:
            if (r104 == FireCase.HostDetach) goto L8;
            r106 = false;
            goto L10
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReusedAssemProxy f192965a;

        public b(ReusedAssemProxy r100) {
            this.f192965a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReusedAssemProxy r100 = this.f192965a;     // Catch: Throwable -> L4
            ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r101 = r100.f192947a;     // Catch: Throwable -> L4
            r100.f192952f = true;     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f192966a;

        public c(Function0 r100) {
            this.f192966a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f192966a.invoke();     // Catch: Throwable -> L4
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

    public final void a() {
        final ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r100 = this.f192947a;
        if (r100 == null) goto L18;
        final List r101 = null;
        if ((r100 instanceof g) == true) goto L7;
        Object r102 = null;
    L8:
        final g r103 = (g) r102;
        c();
        Function0<Unit> r104 = new ReusedAssemProxy$bind$runnable$1(this, r100, r103, r101);
        Lazy r105 = HostInjector.f192919a;
        r104.invoke();
        if (r103 == null) goto L16;
        boolean r106 = r103.isActive();
        r100.f192988l = r106;
        if (r106 == true) goto L16;
        Function0<Unit> r107 = new ReusedAssemProxy$bind$$inlined$let$lambda$1(this, r100);
        if (r100.f192987k == false) goto L15;
        r107.invoke();
        goto L16
    L15:
        r100.f192998v.add(r107);
    L16:
        this.f192960n.onNext(new com.bytedance.assem.arch.reused.a(FireCase.HostBind, r100));
        Intrinsics.areEqual(this.f192948b, null);
        return;
    L7:
        r102 = r100;
        goto L8
    }

    public final void c() {
        if (this.f192950d.getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        return;
    L5:
        e(new ReusedAssemProxy$handleOnCreate$1(this));
        if (this.f192952f == true) goto L12;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L10;
        HostInjector.a().execute(new b(this));
        goto L12
    L10:
        this.f192952f = true;
    L12:
        if ((!this.f192954h.isEmpty()) == false) goto L17;
        Iterator<ReusedAssemProxy> r100 = this.f192954h.iterator();
    L15:
        if (r100.hasNext() == false) goto L19;
        r100.next().c();
        goto L15
    L19:
        return;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("Position=");
        Function0<Integer> r101 = this.f192959m;
        String r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = r101.invoke();
    L6:
        r100.append(r103);
        r100.append(", Proxy@");
        r100.append(Integer.toHexString(hashCode()));
        r100.append("(host@");
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r104 = this.f192947a;
        if (r104 == null) goto L9;
        r102 = Integer.toHexString(r104.hashCode());
    L9:
        r100.append(r102);
        r100.append(",state:");
        r100.append(this.f192950d.getCurrentState());
        r100.append(')');
        return r100.toString();
    L5:
        r103 = null;
        goto L6
    }

    public ReusedAssemProxy() {
        this.f192949c = true;
        this.f192950d = new LifecycleRegistry(this);
        this.f192951e = new ViewModelStore();
        this.f192953g = LazyKt.lazy(ReusedAssemProxy$handler$2.INSTANCE);
        this.f192954h = new CopyOnWriteArrayList();
        this.f192956j = u.f193042a;
        this.f192957k = ProxyStage.Silent;
        new LinkedList();
        BehaviorSubject<com.bytedance.assem.arch.reused.a> r100 = BehaviorSubject.createDefault(new com.bytedance.assem.arch.reused.a(FireCase.Default, null));
        this.f192960n = r100;
        r100.hide().subscribe(new a(this));
        this.f192961o = true;
        this.f192962p = new ConcurrentHashMap();
        this.f192963q = new ConcurrentHashMap();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f192950d;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return this.f192951e;
    }

    @Override // com.bytedance.assem.arch.reused.IResuedAssemProxy
    public final BehaviorSubject<com.bytedance.assem.arch.reused.a> gl() {
        return this.f192960n;
    }

    @Override // com.bytedance.tiktok.proxy.c
    public final com.bytedance.tiktok.proxy.a oq() {
        return this.f192947a;
    }

    @Override // com.bytedance.tiktok.proxy.NestedLifecycleOwner
    public final boolean rQ() {
        return this.f192949c;
    }

    public final void e(Function0<Unit> r100) {
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
        r100.invoke();
        return;
    L5:
        ((Handler) this.f192953g.getValue()).post(new c(r100));
    }

    @Override // com.bytedance.assem.arch.reused.IResuedAssemProxy
    public final void jz(ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r100) {
        Iterator<ReusedAssemProxy> r101 = this.f192954h.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        ReusedAssemProxy r102 = r101.next();
        if (Intrinsics.areEqual(r102.f192948b, Reflection.getOrCreateKotlinClass(r100.getClass())) == false) goto L4;
    L9:
        ReusedAssemProxy r103 = r102;
        if (r103 != null) goto L13;
        r103 = new ReusedAssemProxy();
        this.f192954h.add(r103);
        Lazy r104 = HostInjector.f192919a;
    L13:
        Object r105 = this.f192955i;
        Function1 r106 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.f192958l, 1);
        Function0<Integer> r107 = this.f192959m;
        r103.f192955i = r105;
        r103.f192947a = null;
        if (r103.f192948b != null) goto L16;
        r103.f192948b = Reflection.getOrCreateKotlinClass(r100.getClass());
    L16:
        r100.f192994r = r103;
        r103.f192947a = r100;
        r103.f192958l = r106;
        r103.f192959m = r107;
        r103.a();
        r103.b(r100, r103, r105, r107);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final void b(ReusedUIAssem r100, ReusedAssemProxy r101, Object r102, Function0 r110) {
        FragmentActivity r103 = AssemExtKt.a(r100);
        if (r103 == null) goto L5;
        AssemSupervisor r104 = ((Assembler) ViewModelProviders.of(r103).get(Assembler.class)).findAssemSupervisor(r100);
    L6:
        if (r104 == null) goto L8;
        CopyOnWriteArrayList<Assem> r105 = r104.f192871b;
    L9:
        if (r105 == null) goto L41;
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L51;
        Assem r107 = (Assem) r106.next();
        if (r107 == null) goto L40;
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r108 = (ReusedUIAssem) r107;
        Iterator<ReusedAssemProxy> r109 = r101.f192954h.iterator();
    L17:
        if (r109.hasNext() == false) goto L21;
        ReusedAssemProxy r111 = r109.next();
        if (Intrinsics.areEqual(r111.f192948b, Reflection.getOrCreateKotlinClass(r108.getClass())) == false) goto L17;
    L22:
        ReusedAssemProxy r112 = r111;
        if (r112 != null) goto L26;
        r112 = new ReusedAssemProxy();
        r112.f192948b = Reflection.getOrCreateKotlinClass(r108.getClass());
        r101.f192954h.add(r112);
    L26:
        r108.f192994r = r112;
        r112.f192947a = r108;
        r112.f192955i = r102;
        r112.f192958l = this.f192958l;
        r112.f192959m = r110;
        r112.a();
        FragmentActivity r113 = AssemExtKt.a(r108);
        if (r113 == null) goto L29;
        AssemSupervisor r114 = ((Assembler) ViewModelProviders.of(r113).get(Assembler.class)).findAssemSupervisor(r108);
    L30:
        if (r114 == null) goto L36;
        CopyOnWriteArrayList<Assem> r115 = r114.f192871b;
        if (r115 == null) goto L36;
        if (r115.isEmpty() == true) goto L36;
        boolean r116 = true;
    L37:
        if (r116 == false) goto L12;
        b(r108, r112, r102, r110);
    L36:
        r116 = false;
        goto L37
    L29:
        r114 = null;
        goto L30
    L21:
        r111 = null;
        goto L22
    L40:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.assem.arch.reused.ReusedUIAssem<out com.bytedance.tiktok.proxy.IVMReceiver>");
    L51:
        return;
    L41:
        return;
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }
}
