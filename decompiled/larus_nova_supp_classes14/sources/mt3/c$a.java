package mt3;

import com.larus.apm.impl.protector.RunnableProtector;
import cv3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class c$a extends a {
    public final /* synthetic */ c d;

    public final void run() {
        c.c(this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c$a(c r1, long r2, long r4) {
        this.d = r1;
        super(r2, r4);
    }
}
