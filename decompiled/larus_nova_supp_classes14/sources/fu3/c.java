package fu3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends cv3.a {
    public final /* synthetic */ b d;

    public final void run() {
        b r0 = this.d;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L4
        r0.f(new h("command_report_data", r1 - r0.k));     // Catch: Throwable -> L4
        r0.k = r1;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(b r1, long r2, long r4) {
        this.d = r1;
        super(r2, r4);
    }
}
