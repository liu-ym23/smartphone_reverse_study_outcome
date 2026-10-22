package bs3;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import cs3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a<T extends cs3.b> extends c<T> {
    public static final Object j = null;
    public volatile int f;
    public volatile long g;
    public long h;
    public int i;

    /* JADX INFO: renamed from: bs3.a$a, reason: collision with other inner class name */
    public class RunnableC0005a implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ a c;

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = this.c;     // Catch: Throwable -> L4
            long r7 = this.a;     // Catch: Throwable -> L4
            boolean r2 = this.b;     // Catch: Throwable -> L4
            Object r1 = vr3.b.C;     // Catch: Throwable -> L4
            String r9 = vr3.b.e.a.u;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            ms3.a r10 = new ms3.a(r2, System.currentTimeMillis(), r0.getType(), r0.d, r7, r9);     // Catch: Throwable -> L4
            as3.b.a.a.g(r10);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0005a(a r1, long r2, boolean r4) {
            this.c = r1;
            this.a = r2;
            this.b = r4;
        }
    }

    public abstract void o(double r1, double r3);

    public abstract void p(T r1, long r2);

    static {
        j = new Object();
    }

    public final void l() {
        Object r0 = j;
        monitor-enter(r0);
        getType();     // Catch: Throwable -> L9
        this.f++;     // Catch: Throwable -> L9
        if (this.f != 1) goto L7;
        this.g = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void n() {
        Object r0 = j;
        monitor-enter(r0);
        getType();     // Catch: Throwable -> L13
        if (this.f != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        this.f--;     // Catch: Throwable -> L13
        if (this.f != 0) goto L11;
        boolean r1 = this.c;     // Catch: Throwable -> L13
        bt3.b.d.a.e(new RunnableC0005a(this, SystemClock.elapsedRealtime() - this.g, r1));     // Catch: Throwable -> L13
        this.g = -1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public a(String r1) {
        super(r1);
        this.f = 0;
    }

    @Override // bs3.l
    public final void d(boolean r1) {
        m(r1);
    }

    @Override // bs3.c, bs3.l
    public final void f(boolean r1) {
        m(r1);
        this.c = false;
    }

    @Override // bs3.c, bs3.l
    public final void h(boolean r1) {
        m(r1);
        this.c = true;
    }

    @Override // bs3.l
    public final void i(boolean r1) {
        m(r1);
    }

    public final void m(boolean r15) {
        Object r0 = j;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f > 0) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.g <= 0) goto L12;
        long r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        if (r15 == false) goto L11;
        long r11 = r1 - this.g;     // Catch: Throwable -> L14
        boolean r6 = this.c;     // Catch: Throwable -> L14
        Object r16 = vr3.b.C;     // Catch: Throwable -> L14
        String r13 = vr3.b.e.a.u;     // Catch: Throwable -> L14
        ms3.a r17 = new ms3.a(r6, System.currentTimeMillis(), getType(), this.d, r11, r13);     // Catch: Throwable -> L14
        as3.b.a.a.g(r17);     // Catch: Throwable -> L14
    L11:
        this.g = r1;     // Catch: Throwable -> L14
        goto L12
    }

    @Override // bs3.l
    public final void c(boolean r1, boolean r2) {
        m(r2);
        this.d = r1;
    }

    @Override // bs3.c
    public final void j(T r8, long r9, long r11) {
        this.i++;
        long r0 = r8.a;
        if (r0 < r9) goto L6;
        r9 = r0;
    L6:
        long r2 = r8.b;
        if (r2 > 0) goto L9;
    L12:
        p(r8, r11 - r0);
        long r12 = r11 - r9;
        if (r12 <= 0) goto L16;
        this.h += r12;
        return;
    L16:
        return;
    L9:
        if (r11 < r2) goto L12;
        r11 = r2;
        goto L12
    }

    @Override // bs3.c
    public final void k(long r9, long r11, boolean r13) {
        this.i = 0;
        this.h = 0;
        m(r13);
        super.k(r9, r11, r13);
        long r10 = System.currentTimeMillis();
        o(((this.h / (r10 - this.b)) * 60000.0d) * 10.0d, ((((double) this.i) / (r10 - this.b)) * 60000.0d) * 10.0d);
    }
}
