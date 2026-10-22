package fu3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$b extends cv3.a {
    public final /* synthetic */ b d;

    public final void run() {
        b.a(this.d, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b$b(b r1, long r2, long r4) {
        this.d = r1;
        super(r2, r4);
    }
}
