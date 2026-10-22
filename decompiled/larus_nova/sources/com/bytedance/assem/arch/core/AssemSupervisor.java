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
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/assem/arch/core/AssemSupervisor;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroid/content/Context;", "h", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "assem_release"}, k = 1, mv = {1, 4, 0})
public final class AssemSupervisor implements LifecycleEventObserver {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f192869k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f192870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<Assem> f192871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<KClass<? extends Assem>, Assem> f192872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<KClass<? extends Assem>, h> f192873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f192874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f192875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LifecycleOwner f192876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f192877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.assem.arch.core.b f192878i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f192879j;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f192880a;

        public b(Function0 r100) {
            this.f192880a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f192880a.invoke();     // Catch: Throwable -> L4
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
        return this.f192876g.getLifecycle();
    }

    public final void e() {
        Iterator<Assem> r100 = this.f192871b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Assem r101 = r100.next();
        c(Lifecycle.State.DESTROYED, r101);
        goto L4
    L6:
        ((LinkedHashMap) this.f192878i.f192886a).clear();
        d r102 = this.f192879j;
        ((LinkedHashMap) r102.f192888a).clear();
        ((LinkedHashMap) r102.f192889b).clear();
        this.f192871b.clear();
        ((LinkedHashMap) this.f192872c).clear();
        ((LinkedHashMap) this.f192873d).clear();
        b().removeObserver(this);
        f(null);
    }

    public final Context getContext() {
        return this.f192877h;
    }

    public final void a(final Assem r100) {
        Function0<Unit> r101 = new AssemSupervisor$attachToParentLifecycle$runnable$1(this, r100);
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
        r101.invoke();
        return;
    L5:
        ((Handler) this.f192874e.getValue()).post(new b(r101));
    }

    public final void d(final Assem r100) {
        if (b().getCurrentState().compareTo(Lifecycle.State.DESTROYED) > 0) goto L6;
        return;
    L6:
        if ((!this.f192871b.contains(r100)) == false) goto L13;
        this.f192871b.add(r100);
        r100.f192855d = this;
        r100.f192857f.setValue(r100, Assem.f192851g[0], this.f192876g);
        this.f192872c.put(Reflection.getOrCreateKotlinClass(r100.getClass()), r100);
        if (r100.f192853b == true) goto L10;
        new AssemSupervisor$loadAssem$2(this, r100);
        return;
    L10:
        r100.f192852a = true;
        return;
    L13:
        throw new IllegalStateException("This assem has already existed.".toString());
    }

    public final void f(View r100) {
        if (r100 != null) goto L5;
        r100 = null;
    L9:
        this.f192875f = r100;
        return;
    L5:
        if (this.f192875f != null) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L9;
        throw new IllegalArgumentException("Duplicate attach the assems to root view on the same layer.".toString());
    L7:
        r101 = false;
        goto L8
    }

    public static void c(Lifecycle.State r100, Assem r101) {
        int r102 = e.f192891a[r100.ordinal()];
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

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        switch(e.f192892b[r101.ordinal()]) {
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
        Lazy r102 = HostInjector.f192919a;
        CopyOnWriteArrayList<Assem> r103 = this.f192871b;
        ArrayList r104 = new ArrayList();
        Iterator<Assem> r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L17;
        Assem r106 = r105.next();
        Assem r107 = r106;
        if (r107.f192853b == true) goto L12;
    L14:
        boolean r108 = false;
    L15:
        if (r108 == true) goto L8;
        r104.add(r106);
        goto L8
    L12:
        if (r107.f192852a == true) goto L14;
        r108 = true;
        goto L15
    L17:
        Iterator r109 = r104.iterator();
    L19:
        if (r109.hasNext() == false) goto L108;
        Assem r110 = (Assem) r109.next();
        c(Lifecycle.State.CREATED, r110);
        goto L19
    L108:
        return;
    L21:
        Lazy r111 = HostInjector.f192919a;
        CopyOnWriteArrayList<Assem> r112 = this.f192871b;
        ArrayList r113 = new ArrayList();
        Iterator<Assem> r114 = r112.iterator();
    L23:
        if (r114.hasNext() == false) goto L32;
        Assem r115 = r114.next();
        Assem r116 = r115;
        if (r116.f192853b == true) goto L27;
    L29:
        boolean r117 = false;
    L30:
        if (r117 == true) goto L23;
        r113.add(r115);
        goto L23
    L27:
        if (r116.f192852a == true) goto L29;
        r117 = true;
        goto L30
    L32:
        Iterator r118 = r113.iterator();
    L34:
        if (r118.hasNext() == false) goto L109;
        Assem r119 = (Assem) r118.next();
        c(Lifecycle.State.STARTED, r119);
        goto L34
    L109:
        return;
    L36:
        Lazy r120 = HostInjector.f192919a;
        CopyOnWriteArrayList<Assem> r121 = this.f192871b;
        ArrayList r122 = new ArrayList();
        Iterator<Assem> r123 = r121.iterator();
    L38:
        if (r123.hasNext() == false) goto L47;
        Assem r124 = r123.next();
        Assem r125 = r124;
        if (r125.f192853b == true) goto L42;
    L44:
        boolean r126 = false;
    L45:
        if (r126 == true) goto L38;
        r122.add(r124);
        goto L38
    L42:
        if (r125.f192852a == true) goto L44;
        r126 = true;
        goto L45
    L47:
        Iterator r127 = r122.iterator();
    L49:
        if (r127.hasNext() == false) goto L110;
        Assem r128 = (Assem) r127.next();
        c(Lifecycle.State.RESUMED, r128);
        goto L49
    L110:
        return;
    L51:
        Lazy r129 = HostInjector.f192919a;
        CopyOnWriteArrayList<Assem> r130 = this.f192871b;
        ArrayList r131 = new ArrayList();
        Iterator<Assem> r132 = r130.iterator();
    L53:
        if (r132.hasNext() == false) goto L62;
        Assem r133 = r132.next();
        Assem r134 = r133;
        if (r134.f192853b == true) goto L57;
    L59:
        boolean r135 = false;
    L60:
        if (r135 == true) goto L53;
        r131.add(r133);
        goto L53
    L57:
        if (r134.f192852a == true) goto L59;
        r135 = true;
        goto L60
    L62:
        Iterator r136 = r131.iterator();
    L64:
        if (r136.hasNext() == false) goto L111;
        Assem r137 = (Assem) r136.next();
        c(Lifecycle.State.STARTED, r137);
        goto L64
    L111:
        return;
    L66:
        Lazy r138 = HostInjector.f192919a;
        CopyOnWriteArrayList<Assem> r139 = this.f192871b;
        ArrayList r140 = new ArrayList();
        Iterator<Assem> r141 = r139.iterator();
    L68:
        if (r141.hasNext() == false) goto L72;
        Assem r142 = r141.next();
        if (r142.f192853b == true) goto L68;
        r140.add(r142);
        goto L68
    L72:
        Iterator r143 = r140.iterator();
    L74:
        if (r143.hasNext() == false) goto L112;
        Assem r144 = (Assem) r143.next();
        c(Lifecycle.State.CREATED, r144);
        goto L74
    L112:
        return;
    }

    public AssemSupervisor(LifecycleOwner r100, FragmentActivity r101, com.bytedance.assem.arch.core.b r102, d r103) {
        this.f192876g = r100;
        this.f192877h = r101;
        this.f192878i = r102;
        this.f192879j = r103;
        this.f192871b = new CopyOnWriteArrayList();
        this.f192872c = new LinkedHashMap();
        this.f192873d = new LinkedHashMap();
        this.f192874e = LazyKt.lazy(AssemSupervisor$handler$2.INSTANCE);
    }
}
