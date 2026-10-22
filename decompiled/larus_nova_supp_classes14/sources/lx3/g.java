package lx3;

import com.bytedance.applog.log.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ f b;

    public final void a() {
        if (this.b.b == true) goto L24;
        n r0 = this.b.k.t0;
        List<String> r1 = f.n;
        r0.k(0, r1, "[Task] onTaskResume", new Object[0]);
        this.b.b = true;
        f r2 = this.b;
        if (r2.c == false) goto L25;
        r2.a = true;
        k r3 = r2.e;
        if (r3 != null) goto L9;
        r2.k.t0.k(0, r1, "[Task] pure bg launch , so create a new task session", new Object[0]);
        f r4 = this.b;
        r4.e = new k(this.a, r4.k.Q1());
        this.b.g.a();
        f r5 = this.b;
        f.a(r5, r5.e.b);
    L13:
        f r6 = this.b;
        if (r6.e != null) goto L16;
        return;
    L16:
        if (r6.j == null) goto L27;
        JSONObject r7 = new JSONObject();
        this.b.j.b("__bg_session", r7);
        if (r7.length() <= 0) goto L28;
        k r8 = this.b.e;
        JSONObject r9 = r8.g;
        if (r9 != null) goto L22;
        r8.g = r7;
        return;
    L22:
        nx3.f.b(r7, r9);
        return;
    L28:
        return;
    L27:
        return;
    L9:
        long r10 = this.a - r3.h;
        if (r10 > 15000) goto L12;
        r2.k.t0.k(0, r1, "[Task] task time diff " + r10 + " , is less than 15000 so , merge in previous session", new Object[0]);
        l.d().f(this.b.l);
        f r11 = this.b;
        k r12 = r11.e;
        r12.i += r10;
        r12.h = this.a;
        r11.g.d(r12);
        f r13 = this.b;
        f.a(r13, r13.e.b);
        goto L13
    L12:
        r2.k.t0.k(0, r1, "[Task] task time diff " + r10 + " , is bigger than 15000 so close current session and create new session", new Object[0]);
        l.d().f(this.b.l);
        this.b.l.run();
        f r14 = this.b;
        r14.e = new k(this.a, r14.k.Q1());
        this.b.g.a();
        f r15 = this.b;
        f.a(r15, r15.e.b);
        goto L13
    L25:
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

    public g(f r1, long r2) {
        this.b = r1;
        this.a = r2;
    }
}
