package lx3;

import com.bytedance.applog.log.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ f c;

    public final void a() {
        n r0 = this.c.k.t0;
        List<String> r1 = f.n;
        r0.k(0, r1, "[Task] onExitBg", new Object[0]);
        f r2 = this.c;
        if (r2.c == false) goto L18;
        r2.c = false;
        l.d().f(this.c.m);
        l.d().f(this.c.l);
        this.c.b().removeMessages(1);
        this.c.g.a();
        f r3 = this.c;
        if (r3.a == true) goto L7;
    L16:
        f r4 = this.c;
        r4.a = false;
        ((ArrayList) r4.h).clear();
        r4.i = false;
        return;
    L7:
        if ((this.a - r3.d) > 30000) goto L10;
        r3.k.t0.k(0, r1, "[Task] time diff is less than 30000 , so clear current session", new Object[0]);
        ((ArrayList) this.c.h).clear();
        this.c.e = null;
        goto L16
    L10:
        if (r3.e == null) goto L15;
        r3.k.t0.k(0, r1, "[Task] close current session", new Object[0]);
        if (this.c.b == false) goto L14;
        k r5 = this.c.e;
        String r6 = this.b;
        r5.e = true;
        r5.f = r6;
        r5.h = this.a;
    L14:
        f r7 = this.c;
        r7.g.c(r7.e);
        this.c.e = null;
    L15:
        this.c.m.run();
        goto L16
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

    public i(f r1, long r2, String r4) {
        this.c = r1;
        this.a = r2;
        this.b = r4;
    }
}
