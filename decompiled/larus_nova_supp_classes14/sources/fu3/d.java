package fu3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements Runnable {
    public final /* synthetic */ b a;

    @Override // java.lang.Runnable
    public final void run() {
    L13:
        b.b(this.a);     // Catch: Throwable -> L4
    L4:
        com.bytedance.apm.d.j();     // Catch: Throwable -> L8
        b r0 = this.a;     // Catch: Throwable -> L8
        int r1 = r0.o + 1;     // Catch: Throwable -> L8
        r0.o = r1;     // Catch: Throwable -> L8
        if (r1 < 5) goto L13;
        r0.j();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }

    public d(b r1) {
        this.a = r1;
    }
}
