package com.ss.android.ugc.route_monitor.impl.route_out.control;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes40.dex */
public final class a extends com.ss.android.ugc.route_monitor.utils.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<c> f454610a = null;

    static {
        f454610a = new ArrayList();
    }

    public static void t(c r100) {
        List<c> r101 = f454610a;
        monitor-enter(r101);
        ((ArrayList) r101).add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(final Activity r100) {
        mhc.b r101 = j.f454635a;
        e r102 = j.f454637c;
        monitor-enter(r102);
        CollectionsKt.removeAll(r102, new RouteOutControlManager$removeCertIdWhenBindActivityDestroyed$$inlined$synchronized$lambda$1(r100));     // Catch: Throwable -> L7
        CollectionsKt.removeAll(j.f454638d, new RouteOutControlManager$removeCertIdWhenBindActivityDestroyed$$inlined$synchronized$lambda$2(r100));     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity r100, Bundle r101) {
        super.onActivityPreCreated(r100, r101);
        List<c> r102 = f454610a;
        monitor-enter(r102);
        Iterator r103 = ((ArrayList) r102).iterator();     // Catch: Throwable -> L13
    L6:
        if (r103.hasNext() == false) goto L10;
        c r104 = (c) r103.next();     // Catch: Throwable -> L13
        r104.getClass();     // Catch: Throwable -> L13
        r104.f454613a = r100.hashCode();     // Catch: Throwable -> L13
        if (r104.f454617e <= 0) goto L6;
        Handler r105 = com.ss.android.ugc.route_monitor.utils.r.f454781a;     // Catch: Throwable -> L13
        b r106 = r104.f454614b;     // Catch: Throwable -> L13
        com.ss.android.ugc.route_monitor.utils.r.f454781a.removeCallbacks(r106);     // Catch: Throwable -> L13
        goto L6
    L10:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r102);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
