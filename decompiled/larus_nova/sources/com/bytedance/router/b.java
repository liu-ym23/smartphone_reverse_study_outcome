package com.bytedance.router;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<q97.a> f267526a;

    public b() {
        this.f267526a = null;
    }

    public final synchronized void a(q97.a r100) {
        monitor-enter(this);
        if (r100 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f267526a != null) goto L9;
        this.f267526a = new LinkedList();     // Catch: Throwable -> L12
    L9:
        ((LinkedList) this.f267526a).add(r100);     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public final synchronized boolean b(Context r100, c r101) {
        monitor-enter(this);
        if (r101 != null) goto L28;
        monitor-exit(this);
        return true;
    L28:
        List<q97.a> r102 = this.f267526a;     // Catch: Throwable -> L25
        if (r102 != null) goto L10;
    L23:
        monitor-exit(this);
        return false;
    L10:
        if (((LinkedList) r102).size() == 0) goto L23;
        Iterator<q97.a> r103 = this.f267526a.iterator();     // Catch: Throwable -> L25
    L14:
        if (r103.hasNext() == false) goto L21;
        q97.a r104 = r103.next();     // Catch: Throwable -> L25
        if (r104.b(r101) == false) goto L14;
        if (r104.a(r100, r101) == false) goto L14;
        monitor-exit(this);
        return true;
    L21:
        monitor-exit(this);
        return false;
    L25:
        th = move-exception;
        throw th;
    }
}
