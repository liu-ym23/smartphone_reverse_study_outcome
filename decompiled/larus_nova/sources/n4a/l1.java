package n4a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public abstract class l1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m1.a f517458a;

    public l1() {
    }

    public abstract void a();

    public final void b() {
    L22:
        th = move-exception;
        r.f(th, "ThreadTask", "run");
        th.printStackTrace();
        return;
    L3:
        if (Thread.interrupted() == false) goto L5;
        return;
    L5:
        a();     // Catch: Throwable -> L22
        if (Thread.interrupted() == false) goto L8;
        return;
    L8:
        m1.a r100 = this.f517458a;     // Catch: Throwable -> L22
        if (r100 == null) goto L21;
        m1 r101 = r100.f517519a;     // Catch: Throwable -> L22
        monitor-enter(r101);     // Catch: Throwable -> L22
        r101.f517517b.remove(this);     // Catch: Throwable -> L14
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L14:
        th = move-exception;
        r.f(th, "TPool", "removeQueue");     // Catch: Throwable -> L18
        th.printStackTrace();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
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
}
