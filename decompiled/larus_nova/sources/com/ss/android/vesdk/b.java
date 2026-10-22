package com.ss.android.vesdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class b<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<E> f455755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f455756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<E> f455757c;

    public final synchronized void b() {
        monitor-enter(this);
        this.f455756b = true;     // Catch: Throwable -> L7
        ((ArrayList) this.f455755a).clear();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized List<E> c() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f455756b == false) goto L10;
        this.f455757c = new ArrayList(((ArrayList) this.f455755a).size());     // Catch: Throwable -> L13
        Iterator<E> r100 = ((ArrayList) this.f455755a).iterator();     // Catch: Throwable -> L13
    L7:
        if (r100.hasNext() == false) goto L9;
        E r101 = r100.next();     // Catch: Throwable -> L13
        this.f455757c.add(r101);     // Catch: Throwable -> L13
        goto L7
    L9:
        this.f455756b = false;     // Catch: Throwable -> L13
    L10:
        List<E> r102 = this.f455757c;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r102;
    }

    public final synchronized boolean d() {
        monitor-enter(this);
        boolean r100 = ((ArrayList) this.f455755a).isEmpty();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f455755a = new ArrayList();
        this.f455756b = false;
        this.f455757c = new ArrayList();
    }

    public final synchronized boolean a(E r100) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (((ArrayList) this.f455755a).contains(r100) == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        this.f455756b = true;     // Catch: Throwable -> L12
        boolean r101 = ((ArrayList) this.f455755a).add(r100);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r101;
    }

    public final synchronized boolean e(E r100) {
        monitor-enter(this);
        this.f455756b = true;     // Catch: Throwable -> L7
        boolean r101 = ((ArrayList) this.f455755a).remove(r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }
}
