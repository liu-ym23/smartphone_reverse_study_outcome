package org.greenrobot.eventbus;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes42.dex */
public final class b implements Runnable, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f525800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EventBus f525801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f525802c;

    public final void b() {
    L27:
        j r100 = this.f525800a.c();     // Catch: Throwable -> L19 InterruptedException -> L21
        if (r100 != null) goto L17;
        monitor-enter(this);     // Catch: Throwable -> L19 InterruptedException -> L21
        r100 = this.f525800a.b();     // Catch: Throwable -> L14
        if (r100 == null) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L17
    L8:
        this.f525802c = false;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        this.f525802c = false;
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19 InterruptedException -> L21
    L17:
        this.f525801b.invokeSubscriber(r100);     // Catch: Throwable -> L19 InterruptedException -> L21
    L21:
        e = move-exception;
        this.f525801b.getLogger().a(Level.WARNING, ThreadMethodProxy.currentThread().getName() + " was interruppted", e);     // Catch: Throwable -> L19
        this.f525802c = false;
        return;
    L19:
        th = move-exception;
        this.f525802c = false;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(EventBus r100) {
        this.f525801b = r100;
        this.f525800a = new k();
    }

    @Override // org.greenrobot.eventbus.l
    public final void a(o r100, Object r101) {
        j r102 = j.a(r100, r101);
        monitor-enter(this);
        this.f525800a.a(r102);     // Catch: Throwable -> L9
        if (this.f525802c == true) goto L7;
        this.f525802c = true;     // Catch: Throwable -> L9
        this.f525801b.getExecutorService().execute(this);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
