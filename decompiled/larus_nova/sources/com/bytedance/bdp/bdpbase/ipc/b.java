package com.bytedance.bdp.bdpbase.ipc;

import android.os.RemoteException;
import android.util.Pair;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReferenceQueue<Object> f201133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<PhantomReference<Object>, Pair<ICallback, Long>> f201134b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f201135a = null;

        static {
            f201135a = new b();
        }
    }

    public b() {
        this.f201133a = new ReferenceQueue();
        this.f201134b = new ConcurrentHashMap();
    }

    public final void a(ICallback r110, Object r111, long r112) {
        ReferenceQueue<Object> r100 = this.f201133a;
        monitor-enter(r100);
        HashMap r101 = new HashMap();     // Catch: Throwable -> L36
    L5:
        PhantomReference r102 = (PhantomReference) this.f201133a.poll();     // Catch: Throwable -> L36
        if (r102 == null) goto L13;
        Pair<ICallback, Long> r103 = this.f201134b.remove(r102);     // Catch: Throwable -> L36
        if (r103 == null) goto L5;
        ArrayList r104 = (ArrayList) r101.get(r103.first);     // Catch: Throwable -> L36
        if (r104 != null) goto L12;
        r104 = new ArrayList();     // Catch: Throwable -> L36
        r101.put((ICallback) r103.first, r104);     // Catch: Throwable -> L36
    L12:
        r104.add((Long) r103.second);     // Catch: Throwable -> L36
        goto L5
    L13:
        Iterator r105 = r101.entrySet().iterator();     // Catch: Throwable -> L36
    L15:
        if (r105.hasNext() == false) goto L33;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Throwable -> L36
        ICallback r107 = (ICallback) r106.getKey();     // Catch: Throwable -> L36
        if (r107 == null) goto L15;
        ArrayList r108 = (ArrayList) r106.getValue();     // Catch: Throwable -> L36
        if (r108.isEmpty() == true) goto L15;
        int r109 = r108.size();     // Catch: Throwable -> L36
        int r113 = 0;
    L21:
        if (r113 >= r109) goto L15;
        int r114 = r113 + 1024;     // Catch: Throwable -> L36
        if (r114 <= r109) goto L25;
        int r115 = r109 - r113;     // Catch: Throwable -> L36
    L41:
        r107.gc(r108.subList(r113, r115 + r113));     // Catch: RemoteException -> L29 Throwable -> L36
    L32:
        r113 = r114;
    L29:
        e = move-exception;
        g94.b.b("IPC_BdpCallbackGc", new Object[]{"iCallback.gc catch exception, process exist=" + r107.asBinder().isBinderAlive(), e});     // Catch: Throwable -> L36
        goto L32
    L25:
        r115 = 1024;
        goto L41
    L33:
        monitor-exit(r100);     // Catch: Throwable -> L36
        this.f201134b.put(new PhantomReference(r111, this.f201133a), Pair.create(r110, Long.valueOf(r112)));
        return;
    L36:
        th = move-exception;
        throw th;
    }
}
