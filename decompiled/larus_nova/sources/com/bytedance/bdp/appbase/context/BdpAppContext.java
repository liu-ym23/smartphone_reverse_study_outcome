package com.bytedance.bdp.appbase.context;

import android.app.Application;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.ILifecycleObserver;
import com.bytedance.bdp.appbase.base.utils.BdpMethodOptAB;
import com.bytedance.bdp.appbase.context.service.ContextService;
import com.bytedance.bdp.appbase.core.a;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public abstract class BdpAppContext implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f200761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f200762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f200763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Application f200764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f200765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f200766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Class<?>, ContextService<?>> f200767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<Class<?>, Object> f200768h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f200769i;

    public abstract a b();

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return (LifecycleRegistry) this.f200761a.getValue();
    }

    public BdpAppContext() {
        System.currentTimeMillis();
        ILifecycleObserver r100 = new BdpAppContext$mLifecycleObserver$1(this);
        this.f200761a = LazyKt.lazy(new BdpAppContext$mLifecycle$2(this));
        a(r100);
        final Lifecycle.Event r101 = Lifecycle.Event.ON_CREATE;
        boolean r102 = true;
        if (getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L5;
        boolean r103 = false;
    L6:
        if (r103 == true) goto L9;
        BdpPool.runOnMainQuickly(new BdpAppContext$dispatchLifecycleEvent$1(this, r101));
    L9:
        String r104 = UUID.randomUUID().toString().substring(0, 6) + System.currentTimeMillis();
        this.f200762b = r104;
        if (r104.length() <= 6) goto L13;
        r104.substring(0, 6);
    L13:
        this.f200764d = ((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication();
        this.f200765e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new BdpAppContext$registeredAppBaseModules$2(this));
        if (((((Number) BdpMethodOptAB.f200652a.getValue()).intValue() >> 0) & 1) == 1) goto L17;
        r102 = false;
    L17:
        this.f200766f = r102;
        if (r102 == false) goto L20;
        Map<Class<?>, ContextService<?>> r105 = new ConcurrentHashMap();
    L21:
        this.f200767g = r105;
        this.f200768h = new HashMap();
        this.f200769i = new Object();
        return;
    L20:
        r105 = new HashMap();
        goto L21
    L5:
        r103 = true;
        goto L6
    }

    public final void a(final LifecycleObserver r100) {
        BdpPool.runOnMainQuickly(new BdpAppContext$addLifeObserver$1(this, r100));
    }

    public final <T extends ContextService<?>> T c(Class<T> r100) {
        if (this.f200763c == true) goto L16;
        Object r101 = this.f200769i;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f200763c == true) goto L9;
        this.f200763c = true;     // Catch: Throwable -> L12
    L9:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
    L16:
        if (this.f200766f == false) goto L20;
        return (T) f(r100);
    L20:
        return (T) e(r100);
    }

    public final <T extends ContextService<?>> T e(Class<T> r100) {
        Map<Class<?>, ContextService<?>> r101 = this.f200767g;
        monitor-enter(r101);
        T r102 = (T) this.f200767g.get(r100);     // Catch: Throwable -> L36
        monitor-exit(r101);
        if (r102 == null) goto L8;
        return r102;
    L8:
        Object r103 = g(r100);
        monitor-enter(r103);
        T r104 = (T) this.f200767g.get(r100);     // Catch: Throwable -> L33
        if (r104 == null) goto L14;
        monitor-exit(r103);
        return r104;
    L14:
        Iterator r105 = ((CopyOnWriteArrayList) this.f200765e.getValue()).iterator();     // Catch: Throwable -> L33
    L16:
        if (r105.hasNext() == false) goto L29;
        T r106 = (T) ((k94.a) r105.next()).getContextServiceFetcher().a(this, r100);
        if (r106 == null) goto L16;
        Map<Class<?>, ContextService<?>> r107 = this.f200767g;     // Catch: Throwable -> L33
        monitor-enter(r107);     // Catch: Throwable -> L33
        this.f200767g.put((Class<?>) r100, r106);     // Catch: Throwable -> L26
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r107);     // Catch: Throwable -> L33
        monitor-exit(r103);
        return r106;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L29:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r103);
        throw new IllegalArgumentException("can not found contextServiceClass:" + r100);
    L33:
        th = move-exception;
        throw th;
    L36:
        th = move-exception;
        throw th;
    }

    public final <T extends ContextService<?>> T f(Class<T> r100) {
        Map<Class<?>, ContextService<?>> r101 = this.f200767g;
        T r102 = (T) r101.get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        Object r103 = g(r100);
        monitor-enter(r103);
        T r104 = (T) r101.get(r100);     // Catch: Throwable -> L24
        if (r104 == null) goto L11;
        monitor-exit(r103);
        return r104;
    L11:
        Iterator r105 = ((CopyOnWriteArrayList) this.f200765e.getValue()).iterator();     // Catch: Throwable -> L24
    L13:
        if (r105.hasNext() == false) goto L20;
        T r106 = (T) ((k94.a) r105.next()).getContextServiceFetcher().a(this, r100);
        if (r106 == null) goto L13;
        r101.put((Class<?>) r100, r106);     // Catch: Throwable -> L24
        monitor-exit(r103);
        return r106;
    L20:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r103);
        throw new IllegalArgumentException("can not found contextServiceClass:" + r100);
    L24:
        th = move-exception;
        throw th;
    }

    public final Object g(Class<?> r100) {
        HashMap<Class<?>, Object> r101 = this.f200768h;
        monitor-enter(r101);
        Object r102 = this.f200768h.get(r100);     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        r102 = new Object();     // Catch: Throwable -> L9
        this.f200768h.put(r100, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);
        return r102;
    L9:
        th = move-exception;
        throw th;
    }
}
