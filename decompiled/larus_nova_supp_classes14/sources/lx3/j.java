package lx3;

import com.bytedance.applog.log.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ f c;

    public final void a() {
        n r0 = this.c.k.t0;
        List<String> r1 = f.n;
        r0.k(0, r1, "[Task] onEnterBg", new Object[0]);
        f r2 = this.c;
        if (r2.c == true) goto L15;
        r2.a = false;
        ((ArrayList) r2.h).clear();
        r2.i = false;
        l r3 = l.d();
        f.b r4 = this.c.m;
        if (r4 == null) goto L7;
        r3.f(r4);
        r3.e().postDelayed(r4, 30010);
    L8:
        f r5 = this.c;
        r5.d = this.a;
        r5.c = true;
        if (r5.b == false) goto L16;
        f r6 = this.c;
        r6.a = true;
        if (r6.e == null) goto L13;
        r6.k.t0.f(0, r1, "[Task] enter bg , bug there is already a bg task is running", new Object[0]);
    L13:
        this.c.k.t0.k(0, r1, "[Task] task is running , so create a new task session", new Object[0]);
        f r7 = this.c;
        r7.e = new k(this.a, r7.k.Q1());
        f r8 = this.c;
        k r9 = r8.e;
        String r10 = this.b;
        r9.c = true;
        r9.d = r10;
        f.a(r8, r9.b);
        return;
    L16:
        return;
    L7:
        r3.getClass();
        goto L8
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

    public j(f r1, long r2, String r4) {
        this.c = r1;
        this.a = r2;
        this.b = r4;
    }
}
