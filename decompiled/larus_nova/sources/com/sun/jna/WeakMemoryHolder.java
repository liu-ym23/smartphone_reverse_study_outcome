package com.sun.jna;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.IdentityHashMap;

/* JADX INFO: loaded from: classes40.dex */
public class WeakMemoryHolder {
    IdentityHashMap<Reference<Object>, Memory> backingMap;
    ReferenceQueue<Object> referenceQueue;

    public synchronized void clean() {
        monitor-enter(this);
        ReferenceQueue<Object> r100 = this.referenceQueue;     // Catch: Throwable -> L10
    L4:
        Reference<? extends Object> r101 = r100.poll();     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        this.backingMap.remove(r101);     // Catch: Throwable -> L10
        r100 = this.referenceQueue;     // Catch: Throwable -> L10
        goto L4
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public WeakMemoryHolder() {
        this.referenceQueue = new ReferenceQueue();
        this.backingMap = new IdentityHashMap();
    }

    public synchronized void put(Object r100, Memory r101) {
        monitor-enter(this);
        clean();     // Catch: Throwable -> L6
        WeakReference r102 = new WeakReference(r100, this.referenceQueue);     // Catch: Throwable -> L6
        this.backingMap.put(r102, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
