package xf7;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque<Runnable> f563481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f563482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f563483c;

    public final void a() {
        monitor-enter(this);
        this.f563482b.set(true);     // Catch: Throwable -> L9
    L5:
        if (((LinkedList) this.f563481a).size() <= 0) goto L7;
        ((Runnable) ((LinkedList) this.f563481a).pop()).run();     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public i() {
        this.f563481a = new LinkedList();
        this.f563482b = new AtomicBoolean(false);
        this.f563483c = 200;
    }

    public final void b(Runnable r100) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f563482b.get() == false) goto L8;
        r100.run();     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L8:
        if (((LinkedList) this.f563481a).size() >= this.f563483c) goto L10;
        ((LinkedList) this.f563481a).add(r100);     // Catch: Throwable -> L13
        goto L11
    L10:
        zf7.b.b("throw task " + r100 + ", because there are too many tasks in queue");     // Catch: Throwable -> L13
        goto L11
    }
}
