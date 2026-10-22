package nr5;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import cvc.c;
import cvc.d;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f520179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f520181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f520182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Deque<b.C6965b> f520183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Deque<b.C6965b> f520184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Deque<b> f520185g;

    public final synchronized ExecutorService c() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f520182d != null) goto L6;
        TimeUnit r100 = TimeUnit.SECONDS;     // Catch: Throwable -> L9
        SynchronousQueue r101 = new SynchronousQueue();     // Catch: Throwable -> L9
        byte[] r102 = c.f465513a;     // Catch: Throwable -> L9
        this.f520182d = new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, r100, r101, new d("eenet__RustNet Dispatcher", false));     // Catch: Throwable -> L9
    L6:
        ExecutorService r103 = this.f520182d;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r103;
    }

    public final synchronized int g() {
        monitor-enter(this);
        int r100 = ((ArrayDeque) this.f520184f).size() + ((ArrayDeque) this.f520185g).size();
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f() {
        if (((ArrayDeque) this.f520184f).size() < this.f520179a) goto L6;
        return;
    L6:
        if (((ArrayDeque) this.f520183e).isEmpty() == false) goto L8;
        return;
    L8:
        Iterator r100 = ((ArrayDeque) this.f520183e).iterator();
    L10:
        if (r100.hasNext() == false) goto L16;
        b.C6965b r101 = (b.C6965b) r100.next();
        if (h(r101) >= this.f520180b) goto L15;
        r100.remove();
        ((ArrayDeque) this.f520184f).add(r101);
        c().execute(r101);
    L15:
        if (((ArrayDeque) this.f520184f).size() < this.f520179a) goto L10;
        return;
    }

    public a(ExecutorService r100) {
        this.f520179a = 64;
        this.f520180b = 5;
        this.f520183e = new ArrayDeque();
        this.f520184f = new ArrayDeque();
        this.f520185g = new ArrayDeque();
        this.f520182d = r100;
    }

    public final synchronized void a(b.C6965b r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (((ArrayDeque) this.f520184f).size() < this.f520179a) goto L6;
    L8:
        ((ArrayDeque) this.f520183e).add(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L6:
        if (h(r100) >= this.f520180b) goto L8;
        ((ArrayDeque) this.f520184f).add(r100);     // Catch: Throwable -> L11
        c().execute(r100);     // Catch: Throwable -> L11
        goto L9
    }

    public final synchronized void b(b r100) {
        monitor-enter(this);
        ((ArrayDeque) this.f520185g).add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void e(b.C6965b r100) {
        d(this.f520184f, r100, true);
    }

    public final int h(b.C6965b r100) {
        Iterator r101 = ((ArrayDeque) this.f520184f).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L11;
        b r103 = ((b.C6965b) r101.next()).f520199c;
        if (r103.f520193h == true) goto L4;
        if (r103.f520192g.url().host().equals(r100.f520199c.f520192g.url().host()) == false) goto L4;
        r102 = r102 + 1;
        goto L4
    L11:
        return r102;
    }

    public final synchronized void i(Runnable r100) {
        monitor-enter(this);
        this.f520181c = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void j(int r100) {
        monitor-enter(this);
        if (r100 < 1) goto L12;
        this.f520180b = r100;     // Catch: Throwable -> L9
        f();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L12:
        throw new IllegalArgumentException("max < 1: " + r100);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final <T> void d(Deque<T> r100, T r101, boolean r102) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (((ArrayDeque) r100).remove(r101) == false) goto L14;
        if (r102 == false) goto L7;
        f();     // Catch: Throwable -> L17
    L7:
        int r103 = g();     // Catch: Throwable -> L17
        Runnable r104 = this.f520181c;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        if (r103 != 0) goto L20;
        if (r104 == null) goto L21;
        r104.run();
        return;
    L21:
        return;
    L20:
        return;
    L14:
        throw new AssertionError("Call wasn't in-flight!");     // Catch: Throwable -> L17
    }
}
