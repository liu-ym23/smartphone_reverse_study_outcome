package ws3;

import com.bytedance.apm.util.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ k c;

    public final void a() {
        k r0 = this.c;
        if (r0.r != null) goto L5;
        r0.r = new HashMap();
    L5:
        long r1 = System.currentTimeMillis();
        this.c.r.put(this.a, new n(Long.valueOf(r1), Long.valueOf(this.c.v.a())));
        k r2 = this.c;
        if (r2.s != null) goto L8;
        r2.s = new HashMap();
    L8:
        this.c.s.put(this.a, new n(Long.valueOf(r1), Long.valueOf(this.c.v.a.e())));
        k r3 = this.c;
        if (r3.t != null) goto L11;
        r3.t = new HashMap();
    L11:
        this.c.t.put(this.a, new n(Long.valueOf(r1), Long.valueOf(this.c.v.a.g())));
        if (this.b == false) goto L18;
        d r4 = d.b.a;
        String r5 = this.a;
        if (r4.k != null) goto L16;
        r4.k = new HashMap();
    L16:
        Map r6 = r4.k;
        HashMap r7 = (HashMap) r6;
        r7.put(r5, new HashMap());
        return;
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

    public i(k r1, String r2, boolean r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
