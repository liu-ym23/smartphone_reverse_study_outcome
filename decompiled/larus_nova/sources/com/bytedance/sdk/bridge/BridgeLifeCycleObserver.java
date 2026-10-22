package com.bytedance.sdk.bridge;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007J\u000f\u0010\t\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\u0002H\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/bridge/BridgeLifeCycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", "onDestory$bridge_release", "()V", "onDestory", "onAny", "", EventConstant.Key.MODULE, "Landroidx/lifecycle/Lifecycle;", NewBroadcastMonitor.STAGE.LIFECYCLE, "<init>", "(Ljava/lang/Object;Landroid/arch/lifecycle/Lifecycle;)V", "bridge_release"}, k = 1, mv = {1, 4, 0})
public final class BridgeLifeCycleObserver implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f269559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lifecycle f269560b;

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public final void onAny() {
        Object r100 = this.f269559a;
        if ((r100 instanceof a) == false) goto L6;
        ((a) r100).getClass();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestory$bridge_release() {
        Object r100 = this.f269559a;
        if ((r100 instanceof a) == false) goto L5;
        ((a) r100).getClass();
    L5:
        ConcurrentHashMap<String, CopyOnWriteArrayList<ed7.a>> r101 = e.f269587a;
        Object r102 = this.f269559a;
        Lifecycle r103 = this.f269560b;
        i r104 = tc7.a.b(r102.getClass());
        if (r104 == null) goto L25;
        Iterator<BridgeMethodInfo> r105 = r104.a().iterator();
    L9:
        if (r105.hasNext() == false) goto L25;
        String r106 = r105.next().getBridgeMethodName();
        CopyOnWriteArrayList<ed7.a> r107 = e.f269587a.get(r106);
        if (r107 == null) goto L9;
        monitor-enter(r107);
        Iterator<T> r108 = r107.iterator();     // Catch: Throwable -> L22
    L15:
        if (r108.hasNext() == false) goto L19;
        ed7.a r109 = (ed7.a) r108.next();     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(r109.f472226d, r103) == false) goto L15;
        r107.remove(r109);     // Catch: Throwable -> L22
        Logger r110 = Logger.f269563c;     // Catch: Throwable -> L22
        Objects.toString(r103);     // Catch: Throwable -> L22
        r110.getClass();     // Catch: Throwable -> L22
        Logger.a();     // Catch: Throwable -> L22
        goto L15
    L19:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r107);
    L22:
        th = move-exception;
        throw th;
    L25:
        CopyOnWriteArrayList<ed7.b> r112 = e.f269589c;
        monitor-enter(r112);
        Iterator<ed7.b> r113 = r112.iterator();     // Catch: Throwable -> L39
    L29:
        if (r113.hasNext() == false) goto L33;
        ed7.b r114 = r113.next();     // Catch: Throwable -> L39
        if (Intrinsics.areEqual(r102, r114.f472227a) == false) goto L29;
        e.f269589c.remove(r114);     // Catch: Throwable -> L39
        goto L29
    L33:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L39
        monitor-exit(r112);
        if ((r102 instanceof a) == false) goto L61;
        a r116 = (a) r102;
        return;
    L61:
        return;
    L39:
        th = move-exception;
        throw th;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        Object r100 = this.f269559a;
        if ((r100 instanceof a) == false) goto L5;
        ((a) r100).getClass();
    L5:
        ConcurrentHashMap<String, CopyOnWriteArrayList<ed7.a>> r101 = e.f269587a;
        Object r102 = this.f269559a;
        Lifecycle r103 = this.f269560b;
        Logger r104 = Logger.f269563c;
        " disableBridgeMethods ".concat(r102.getClass().getSimpleName());
        r104.getClass();
        Logger.a();
        i r105 = tc7.a.b(r102.getClass());
        if (r105 == null) goto L15;
        Iterator<BridgeMethodInfo> r106 = r105.a().iterator();
    L9:
        if (r106.hasNext() == false) goto L15;
        String r107 = r106.next().getBridgeMethodName();
        ed7.a r108 = e.b(e.f269587a.get(r107), r103);
        if (r108 == null) goto L13;
        r108.f472225c = false;
    L13:
        Logger.f269563c.getClass();
        Logger.a();
    L15:
        if ((r102 instanceof a) == false) goto L21;
        a r109 = (a) r102;
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        Object r100 = this.f269559a;
        if ((r100 instanceof a) == false) goto L5;
        ((a) r100).getClass();
    L5:
        ConcurrentHashMap<String, CopyOnWriteArrayList<ed7.a>> r101 = e.f269587a;
        Object r102 = this.f269559a;
        Lifecycle r103 = this.f269560b;
        Logger r104 = Logger.f269563c;
        " enableBridgeMethods ".concat(r102.getClass().getSimpleName());
        r104.getClass();
        Logger.a();
        i r105 = tc7.a.b(r102.getClass());
        if (r105 == null) goto L15;
        Iterator<BridgeMethodInfo> r106 = r105.a().iterator();
    L9:
        if (r106.hasNext() == false) goto L15;
        String r107 = r106.next().getBridgeMethodName();
        ed7.a r108 = e.b(e.f269587a.get(r107), r103);
        if (r108 == null) goto L13;
        r108.f472225c = true;
    L13:
        Logger.f269563c.getClass();
        Logger.a();
    L15:
        if ((r102 instanceof a) == false) goto L21;
        a r109 = (a) r102;
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        Object r100 = this.f269559a;
        if ((r100 instanceof a) == false) goto L6;
        ((a) r100).getClass();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        Object r100 = this.f269559a;
        if ((r100 instanceof a) == false) goto L6;
        ((a) r100).getClass();
        return;
    }

    public BridgeLifeCycleObserver(Object r100, Lifecycle r101) {
        this.f269559a = r100;
        this.f269560b = r101;
    }
}
