package com.obric.memorydata.sdk.awareness;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.memorydata.sdk.ResultCallback;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h implements ServiceConnection {
    public h() {
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName r100) {
        tka.b r101 = tka.c.f546598a;
        tka.c.c("ContextAwareness", "ContextAwarenessService binding died " + r100);
        e.f397109a.getClass();
        e.c(this, null);
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r100) {
        tka.b r101 = tka.c.f546598a;
        tka.c.d("ContextAwareness", "ContextAwarenessService onNullBinding " + r100);
        e.f397109a.getClass();
        e.c(this, null);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        Intrinsics.checkNotNullParameter(r100, "comp");
        e r101 = e.f397109a;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this == e.f397111c) goto L9;
        monitor-exit(r101);
        return;
    L9:
        e.f397110b = null;     // Catch: Throwable -> L13
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        tka.b r103 = tka.c.f546598a;
        tka.c.c("ContextAwareness", "ContextAwarenessService disconnected " + r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.os.IBinder$DeathRecipient, com.obric.memorydata.sdk.awareness.f] */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r110, final IBinder r111) {
        Intrinsics.checkNotNullParameter(r110, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r111, "binder");
        final ?? r112 = new f(this, r111);
        e r100 = e.f397109a;
        monitor-enter(r100);
    L81:
        th = move-exception;
        throw th;
    L5:
        if (this == e.f397111c) goto L7;
        boolean r101 = false;
    L9:
        monitor-exit(r100);
        if (r101 == true) goto L85;
        return;
    L85:
        r111.linkToDeath(r112, 0);     // Catch: RemoteException -> L78
        monitor-enter(r100);
    L75:
        th = move-exception;
        throw th;
    L15:
        if (this == e.f397111c) goto L17;
    L72:
        pka.b.a(new g(r111, r112));     // Catch: Throwable -> L75
        monitor-exit(r100);
        return;
    L17:
        if (r111 != e.f397112d) goto L72;
        if (r112 != e.f397113e) goto L72;
        e.f397110b = IContextAwarenessService.Stub.asInterface(r111);     // Catch: Throwable -> L75
        List<ResultCallback<Boolean>> r113 = e.f397114f;     // Catch: Throwable -> L75
        List r114 = CollectionsKt.toList(r113);     // Catch: Throwable -> L75
        ((ArrayList) r113).clear();     // Catch: Throwable -> L75
        monitor-exit(r100);
        tka.c.c("ContextAwareness", "ContextAwarenessService connected");
        e.a(r114, 0, "ContextAwarenessService connected");
        Iterator<T> r115 = e.f397117i.keySet().iterator();
    L25:
        if (r115.hasNext() == false) goto L39;
        String r116 = (String) r115.next();
        Set<j<?>> r102 = e.f397117i.get(r116);
        if (r102 == null) goto L25;
        tka.b r103 = tka.c.f546598a;
        tka.c.a("Retry registering feature: " + r116);
        if ((!r102.isEmpty()) == false) goto L25;
        IFeatureChangeListener r104 = e.f397118j.get(r116);
        if (r104 == null) goto L38;
        IContextAwarenessService r105 = e.f397110b;     // Catch: RemoteException -> L36
        if (r105 == null) goto L25;
        r105.registerFeature(r116, r104);     // Catch: RemoteException -> L36
    L36:
        e = move-exception;
        tka.b r106 = tka.c.f546598a;
        tka.c.b("ContextAwareness", "Failed to re-register feature: " + r116, e);
        Unit r117 = Unit.INSTANCE;
        goto L25
    L38:
        tka.c.b("ContextAwareness", "RemoteListener for feature " + r116 + " is null", null);
        goto L25
    L39:
        Iterator<T> r118 = e.f397119k.keySet().iterator();
    L41:
        if (r118.hasNext() == false) goto L55;
        String r119 = (String) r118.next();
        Set<i> r107 = e.f397119k.get(r119);
        if (r107 == null) goto L41;
        tka.b r108 = tka.c.f546598a;
        tka.c.a("Retry registering event: " + r119);
        if ((!r107.isEmpty()) == false) goto L41;
        IEventChangeListener r109 = e.f397120l.get(r119);
        if (r109 == null) goto L54;
        IContextAwarenessService r120 = e.f397110b;     // Catch: RemoteException -> L52
        if (r120 == null) goto L41;
        r120.registerEvent(r119, r109);     // Catch: RemoteException -> L52
    L52:
        e = move-exception;
        tka.b r121 = tka.c.f546598a;
        tka.c.b("ContextAwareness", "Failed to re-register event: " + r119, e);
        Unit r122 = Unit.INSTANCE;
        goto L41
    L54:
        tka.c.b("ContextAwareness", "RemoteListener for event " + r119 + " is null", null);
        goto L41
    L55:
        Iterator<T> r123 = e.f397121m.keySet().iterator();
    L57:
        if (r123.hasNext() == false) goto L71;
        e.b r124 = (e.b) r123.next();
        Set<k> r125 = e.f397121m.get(r124);
        if (r125 == null) goto L57;
        tka.b r126 = tka.c.f546598a;
        tka.c.a("Retry registering duration feature: " + r124);
        if ((!r125.isEmpty()) == false) goto L57;
        IFeatureDurationListener r127 = e.f397122n.get(r124);
        if (r127 == null) goto L70;
        IContextAwarenessService r128 = e.f397110b;     // Catch: RemoteException -> L68
        if (r128 == null) goto L57;
        r124.getClass();     // Catch: RemoteException -> L68
        r128.registerFeatureDuration(null, null, 0, false, r127);     // Catch: RemoteException -> L68
    L68:
        e = move-exception;
        tka.b r129 = tka.c.f546598a;
        tka.c.b("ContextAwareness", "Failed to re-register duration feature: " + r124, e);
        Unit r130 = Unit.INSTANCE;
        goto L57
    L70:
        tka.c.b("ContextAwareness", "Remote duration listener for " + r124 + " is null", null);
        goto L57
    L71:
        return;
    L78:
        e = move-exception;
        tka.b r131 = tka.c.f546598a;
        tka.c.b("ContextAwareness", "linkToDeath failed", e);
        e.f397109a.getClass();
        e.c(this, r111);
        return;
    L7:
        e.f397112d = r111;     // Catch: Throwable -> L81
        e.f397113e = r112;     // Catch: Throwable -> L81
        r101 = true;
        goto L9
    }
}
