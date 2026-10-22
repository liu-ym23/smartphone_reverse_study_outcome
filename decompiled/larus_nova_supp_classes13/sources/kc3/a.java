package kc3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ b b;

    public final void a() {
        Object r0 = this.b.a;
        monitor-enter(r0);
        Object r1 = this.b.f;     // Catch: Throwable -> L8
        this.b.f = b.j;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        b r2 = this.b;
        boolean r3 = this.a;
        c r4 = (c) r2;
        r4.getClass();
        b.a("setValue");
        r4.g++;
        r4.e = r1;
        r4.c(null, r3);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(b r1, boolean r2) {
        this.b = r1;
        this.a = r2;
    }
}
