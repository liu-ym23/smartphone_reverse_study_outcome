package com.bytedance.bdp.bdpbase.ipc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class k extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, MethodInvoker> f201179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Long, Set<String>> f201180c;

    public final void b() {
        HashMap<Long, Set<String>> r100 = this.f201180c;
        monitor-enter(r100);
        this.f201180c.clear();     // Catch: Throwable -> L18
        monitor-exit(r100);     // Catch: Throwable -> L18
        g94.b.e("IPC_ClientInvoker", new Object[]{"binder died, execute all the callback methodInvoker"});
        Iterator<MethodInvoker> r101 = this.f201179b.values().iterator();
    L8:
        if (r101.hasNext() == false) goto L16;
        MethodInvoker r102 = r101.next();
        if (r102.f201110c == false) goto L8;
        r102.a(new Object[]{104, "DeathMonitor receive Binder died!", null}, -1, true, false, "IPCBaseCallback-onResponse");     // Catch: Exception -> L14
    L14:
        e = move-exception;
        g94.b.b("IPC_ClientInvoker", new Object[]{"notify binder died catch Exception", e});
        goto L8
    L16:
        this.f201179b.clear();
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public k() {
        this.f201179b = new ConcurrentHashMap();
        this.f201180c = new HashMap();
    }
}
