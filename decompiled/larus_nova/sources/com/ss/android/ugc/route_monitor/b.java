package com.ss.android.ugc.route_monitor;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.route_monitor.impl.route_in.i;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f454390a;

    public b(String r100) {
        this.f454390a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RouteMonitorManager r100 = RouteMonitorManager.f454384g;     // Catch: Throwable -> L11
        r100.getClass();     // Catch: Throwable -> L11
        i r101 = (i) RouteMonitorManager.f454382e.getValue(r100, RouteMonitorManager.f454378a[2]);     // Catch: Throwable -> L11
        if (r101 == null) goto L14;
        String r102 = this.f454390a;     // Catch: Throwable -> L11
        Iterator<Map.Entry<Integer, String>> r103 = r101.f454523e.entrySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r103.hasNext() == false) goto L23;
        if (Intrinsics.areEqual(r103.next().getValue(), r102) == false) goto L6;
        r103.remove();     // Catch: Throwable -> L11
        return;
    L23:
        return;
    L14:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }
}
