package duc;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlinx.coroutines.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class j extends g {
    public final Runnable c;

    @Override // java.lang.Runnable
    public final void run() {
        this.c.run();     // Catch: Throwable -> L4
        this.b.a();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L4:
        th = move-exception;
        this.b.a();     // Catch: Throwable -> L7
        throw th;     // Catch: Throwable -> L7
    }

    public final String toString() {
        return "Task[" + this.c.getClass().getSimpleName() + '@' + b0.a(this.c) + ", " + this.a + ", " + this.b + ']';
    }

    public j(Runnable r1, long r2, h r4) {
        super(r2, r4);
        this.c = r1;
    }
}
