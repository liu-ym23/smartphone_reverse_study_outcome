package lx3;

import com.bytedance.applog.log.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ f b;

    public final void a() {
        if (this.b.b == false) goto L32;
        n r0 = this.b.k.t0;
        List<String> r1 = f.n;
        boolean r2 = false;
        r0.k(0, r1, "[Task] onTaskPause", new Object[0]);
        this.b.b = false;
        f r3 = this.b;
        if (r3.c == true) goto L7;
        return;
    L7:
        if (r3.e == null) goto L30;
        r3.k.t0.k(0, r1, "[Task] wait 15000 to close current session", new Object[0]);
        f r4 = this.b;
        r4.e.h = this.a;
        if (r4.j == null) goto L16;
        JSONObject r5 = new JSONObject();
        this.b.j.a("__bg_session", r5);
        if (r5.length() <= 0) goto L16;
        k r6 = this.b.e;
        JSONObject r7 = r6.g;
        if (r7 != null) goto L15;
        r6.g = r5;
        goto L16
    L15:
        nx3.f.b(r5, r7);
    L16:
        l r8 = l.d();
        f.a r9 = this.b.l;
        if (r9 == null) goto L19;
        r8.f(r9);
        r8.e().postDelayed(r9, 15000);
    L20:
        f r10 = this.b;
        r10.g.d(r10.e);
        this.b.b().removeMessages(1);
        if (this.b.k.F == false) goto L34;
        f r11 = this.b;
        d r12 = r11.g;
        k r13 = r11.e;
        if (r13 != null) goto L25;
        r12.getClass();
    L28:
        if (r2 == false) goto L35;
        l.d().f(this.b.l);
        this.b.e = null;
        return;
    L35:
        return;
    L25:
        r12.d.t0.k(0, d.e, "[Task] start to report session : {}", new Object[]{r13});
        if (r12.c(r13) == false) goto L28;
        r12.a();
        r12.d.N();
        r2 = true;
        goto L28
    L34:
        return;
    L19:
        r8.getClass();
        goto L20
    L30:
        r3.k.t0.f(0, r1, "[Task] onTaskPause when bg, but no session available", new Object[0]);
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

    public h(f r1, long r2) {
        this.b = r1;
        this.a = r2;
    }
}
