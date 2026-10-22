package com.xiaomi.push.service;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.RejectedExecutionException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f464314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f464315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f464316c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final a f1111a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final c f1112a;

    /* JADX INFO: renamed from: com.xiaomi.push.service.n$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f464317a;

        public void finalize() {
            c r100 = this.f464317a;     // Catch: Throwable -> L11
            monitor-enter(r100);     // Catch: Throwable -> L11
            c.a(this.f464317a, true);     // Catch: Throwable -> L8
            this.f464317a.notify();     // Catch: Throwable -> L8
            monitor-exit(r100);     // Catch: Throwable -> L8
            super.finalize();
            return;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            super.finalize();
            throw th;
        }

        public a(c r100) {
            this.f464317a = r100;
        }
    }

    public static abstract class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f464318a;

        public b(int r100) {
            this.f464318a = r100;
        }
    }

    public static final class c extends PthreadThreadV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile long f464319a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private a f1113a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private volatile boolean f1114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f464320b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f1115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f464321c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f464322a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            private d[] f1116a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f464323b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f464324c;

            public void b() {
                int r100 = 0;
            L4:
                if (r100 >= this.f464323b) goto L9;
                if (this.f1116a[r100].f1120a == false) goto L8;
                this.f464324c++;
                b(r100);
                r100 = r100 - 1;
            L8:
                r100 = r100 + 1;
                goto L4
            }

            private void c() {
                int r100 = this.f464323b - 1;
                int r101 = (r100 - 1) / 2;
            L3:
                d[] r102 = this.f1116a;
                d r103 = r102[r100];
                long r104 = r103.f1117a;
                d r105 = r102[r101];
                if (r104 >= r105.f1117a) goto L6;
                r102[r100] = r105;
                r102[r101] = r103;
                int r110 = r101;
                r101 = (r101 - 1) / 2;
                r100 = r110;
                goto L3
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public void m9404a() {
                this.f1116a = new d[this.f464322a];
                this.f464323b = 0;
            }

            private a() {
                this.f464322a = 256;
                this.f1116a = new d[256];
                this.f464323b = 0;
                this.f464324c = 0;
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public boolean m9406a() {
                if (this.f464323b != 0) goto L5;
                return true;
            L5:
                return false;
            }

            public d a() {
                return this.f1116a[0];
            }

            public /* synthetic */ a(AnonymousClass1 r100) {
                this();
            }

            private void c(int r110) {
                int r100 = (r110 * 2) + 1;
            L3:
                int r101 = this.f464323b;
                if (r100 >= r101) goto L15;
                if (r101 <= 0) goto L19;
                int r102 = r100 + 1;
                if (r102 >= r101) goto L11;
                d[] r103 = this.f1116a;
                if (r103[r102].f1117a >= r103[r100].f1117a) goto L11;
                r100 = r102;
            L11:
                d[] r104 = this.f1116a;
                d r105 = r104[r110];
                long r106 = r105.f1117a;
                d r107 = r104[r100];
                if (r106 < r107.f1117a) goto L20;
                r104[r110] = r107;
                r104[r100] = r105;
                int r108 = r100;
                r100 = (r100 * 2) + 1;
                r110 = r108;
                goto L3
            L20:
                return;
            L19:
                return;
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public void m9405a(d r100) {
                d[] r101 = this.f1116a;
                int r102 = r101.length;
                int r103 = this.f464323b;
                if (r102 != r103) goto L5;
                d[] r104 = new d[r103 * 2];
                System.arraycopy(r101, 0, r104, 0, r103);
                this.f1116a = r104;
            L5:
                d[] r105 = this.f1116a;
                int r106 = this.f464323b;
                this.f464323b = r106 + 1;
                r105[r106] = r100;
                c();
            }

            public void b(int r100) {
                if (r100 < 0) goto L7;
                int r101 = this.f464323b;
                if (r100 >= r101) goto L8;
                d[] r102 = this.f1116a;
                int r103 = r101 - 1;
                this.f464323b = r103;
                r102[r100] = r102[r103];
                r102[r103] = null;
                c(r100);
                return;
            L8:
                return;
            }

            public void a(int r100) {
                int r101 = 0;
            L4:
                if (r101 >= this.f464323b) goto L9;
                d r102 = this.f1116a[r101];
                if (r102.f464325a != r100) goto L8;
                r102.a();
            L8:
                r101 = r101 + 1;
                goto L4
            L9:
                b();
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public boolean m9407a(int r100) {
                int r101 = 0;
            L4:
                if (r101 >= this.f464323b) goto L10;
                if (this.f1116a[r101].f464325a == r100) goto L7;
                r101 = r101 + 1;
                goto L4
            L7:
                return true;
            L10:
                return false;
            }

            private int a(d r100) {
                int r101 = 0;
            L3:
                d[] r102 = this.f1116a;
                if (r101 >= r102.length) goto L9;
                if (r102[r101] == r100) goto L7;
                r101 = r101 + 1;
                goto L3
            L7:
                return r101;
            L9:
                return -1;
            }

            public void a(int r100, b r101) {
                int r102 = 0;
            L4:
                if (r102 >= this.f464323b) goto L9;
                d r103 = this.f1116a[r102];
                if (r103.f1118a != r101) goto L8;
                r103.a();
            L8:
                r102 = r102 + 1;
                goto L4
            L9:
                b();
            }

            public static /* synthetic */ int a(a r100, d r101) {
                return r100.a(r101);
            }
        }

        public void com_xiaomi_push_service_n$c__run$___twin___() {
        L2:
            monitor-enter(this);
        L69:
            th = move-exception;
            throw th;
        L4:
            if (this.f1115b == true) goto L5;
            if (this.f1113a.m9406a() == true) goto L10;
            long r100 = n.a();     // Catch: Throwable -> L69
            d r101 = this.f1113a.a();     // Catch: Throwable -> L69
            Object r102 = r101.f1119a;     // Catch: Throwable -> L69
            monitor-enter(r102);     // Catch: Throwable -> L69
            if (r101.f1120a == true) goto L20;
            long r103 = r101.f1117a - r100;     // Catch: Throwable -> L66
            monitor-exit(r102);     // Catch: Throwable -> L66
            if (r103 > 0) goto L28;
            this.f464320b = 50;     // Catch: Throwable -> L69
            Object r104 = r101.f1119a;     // Catch: Throwable -> L69
            monitor-enter(r104);     // Catch: Throwable -> L69
            if (this.f1113a.a().f1117a == r101.f1117a) goto L42;
            int r105 = a.a(this.f1113a, r101);     // Catch: Throwable -> L63
        L44:
            if (r101.f1120a == true) goto L45;
            r101.a(r101.f1117a);     // Catch: Throwable -> L63
            this.f1113a.b(r105);     // Catch: Throwable -> L63
            r101.f1117a = 0;     // Catch: Throwable -> L63
            monitor-exit(r104);     // Catch: Throwable -> L63
            monitor-exit(this);     // Catch: Throwable -> L69
            this.f464319a = SystemClock.uptimeMillis();     // Catch: Throwable -> L55
            this.f1114a = true;     // Catch: Throwable -> L55
            r101.f1118a.run();     // Catch: Throwable -> L55
            this.f1114a = false;     // Catch: Throwable -> L55
        L55:
            th = move-exception;
            monitor-enter(this);
            this.f1115b = true;     // Catch: Throwable -> L60
            throw th;
        L60:
            th = move-exception;
            throw th;
        L45:
            a r106 = this.f1113a;     // Catch: Throwable -> L63
            r106.b(a.a(r106, r101));     // Catch: Throwable -> L63
            monitor-exit(r104);     // Catch: Throwable -> L63
            monitor-exit(this);     // Catch: Throwable -> L69
            goto L2
        L42:
            r105 = 0;
            goto L44
        L63:
            th = move-exception;
            throw th;     // Catch: Throwable -> L69
        L28:
            long r107 = this.f464320b;     // Catch: Throwable -> L69
            if (r103 <= r107) goto L31;
            r103 = r107;
        L31:
            long r108 = r107 + 50;     // Catch: Throwable -> L69
            this.f464320b = r108;     // Catch: Throwable -> L69
            if (r108 <= 500) goto L74;
            this.f464320b = 500;     // Catch: Throwable -> L69
        L74:
            wait(r103);     // Catch: InterruptedException -> L73 Throwable -> L69
        L35:
            monitor-exit(this);     // Catch: Throwable -> L69
            goto L2
        L20:
            this.f1113a.b(0);     // Catch: Throwable -> L66
            monitor-exit(r102);     // Catch: Throwable -> L66
            monitor-exit(this);     // Catch: Throwable -> L69
            goto L2
        L66:
            th = move-exception;
            throw th;     // Catch: Throwable -> L69
        L10:
            if (this.f464321c == true) goto L11;
            wait();     // Catch: InterruptedException -> L72 Throwable -> L69
        L14:
            monitor-exit(this);     // Catch: Throwable -> L69
            goto L2
        L11:
            monitor-exit(this);     // Catch: Throwable -> L69
            return;
        L5:
            monitor-exit(this);     // Catch: Throwable -> L69
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public void run() {
            com_xiaomi_push_service_n$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m9403a() {
            if (this.f1114a == true) goto L5;
        L7:
            return false;
        L5:
            if ((SystemClock.uptimeMillis() - this.f464319a) <= 600000) goto L7;
            return true;
        }

        public synchronized void a() {
            monitor-enter(this);
            this.f1115b = true;     // Catch: Throwable -> L7
            this.f1113a.m9404a();     // Catch: Throwable -> L7
            notify();     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void a(d r100) {
            this.f1113a.m9405a(r100);
            notify();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_xiaomi_push_service_n$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.com_xiaomi_push_service_n$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public static /* synthetic */ a a(c r100) {
            return r100.f1113a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public static /* synthetic */ boolean m9402a(c r100) {
            return r100.f1115b;
        }

        public c(String r100, boolean r101) {
            super("h/service/n$c");
            this.f464319a = 0;
            this.f1114a = false;
            this.f464320b = 50;
            this.f1113a = new a(null);
            ThreadMethodProxy.setName(this, r100);
            setDaemon(r101);
            ThreadMethodProxy.start(this);
        }

        public static /* synthetic */ void a(c r100, d r101) {
            r100.a(r101);
        }

        public static /* synthetic */ boolean a(c r100, boolean r101) {
            r100.f464321c = r101;
            return r101;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f464325a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        long f1117a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        b f1118a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final Object f1119a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f1120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f464326b;

        public boolean a() {
            Object r100 = this.f1119a;
            monitor-enter(r100);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.f1120a == false) goto L7;
        L9:
            boolean r101 = false;
        L10:
            this.f1120a = true;     // Catch: Throwable -> L13
            monitor-exit(r100);     // Catch: Throwable -> L13
            return r101;
        L7:
            if (this.f1117a <= 0) goto L9;
            r101 = true;
            goto L10
        }

        public d() {
            this.f1119a = new Object();
        }

        public void a(long r100) {
            Object r101 = this.f1119a;
            monitor-enter(r101);
            this.f464326b = r100;     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public n() {
        this(false);
    }

    public static synchronized long a() {
        monitor-enter(n.class);
        long r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L10
        long r101 = f464315b;     // Catch: Throwable -> L10
        if (r100 <= r101) goto L7;
        f464314a += r100 - r101;     // Catch: Throwable -> L10
    L7:
        f464315b = r100;     // Catch: Throwable -> L10
        long r102 = f464314a;     // Catch: Throwable -> L10
        monitor-exit(n.class);
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m9401b() {
        c r100 = this.f1112a;
        monitor-enter(r100);
        c.a(this.f1112a).m9404a();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static {
        long r100 = 0;
        if (SystemClock.elapsedRealtime() <= 0) goto L5;
        r100 = SystemClock.elapsedRealtime();
    L5:
        f464314a = r100;
        f464315b = r100;
    }

    private static synchronized long b() {
        monitor-enter(n.class);
        long r100 = f464316c;     // Catch: Throwable -> L7
        f464316c = 1 + r100;     // Catch: Throwable -> L7
        monitor-exit(n.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9398a() {
        com.xiaomi.channel.commonutils.logger.b.m8718a("quit. finalizer:" + this.f1111a);
        this.f1112a.a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9399a() {
        return this.f1112a.m9403a();
    }

    public n(boolean r100) {
        this("Timer-" + b(), r100);
    }

    public void a(b r100) {
        if (com.xiaomi.channel.commonutils.logger.b.a() < 1) goto L5;
    L9:
        r100.run();
        return;
    L5:
        if (ThreadMethodProxy.currentThread() == this.f1112a) goto L9;
        com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
        throw new RejectedExecutionException("Run job outside job thread");
    }

    public n(String r100) {
        this(r100, false);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9400a(int r100) {
        c r101 = this.f1112a;
        monitor-enter(r101);
        boolean r102 = c.a(this.f1112a).m9407a(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(int r100) {
        c r101 = this.f1112a;
        monitor-enter(r101);
        c.a(this.f1112a).a(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public n(String r100, boolean r101) {
        if (r100 == null) goto L7;
        c r102 = new c(r100, r101);
        this.f1112a = r102;
        this.f1111a = new a(r102);
        return;
    L7:
        throw new NullPointerException("name == null");
    }

    private void b(b r100, long r101) {
        c r102 = this.f1112a;
        monitor-enter(r102);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (c.m9402a(this.f1112a) == true) goto L14;
        long r103 = r101 + a();     // Catch: Throwable -> L15
        if (r103 < 0) goto L12;
        d r104 = new d();     // Catch: Throwable -> L15
        r104.f464325a = r100.f464318a;     // Catch: Throwable -> L15
        r104.f1118a = r100;     // Catch: Throwable -> L15
        r104.f1117a = r103;     // Catch: Throwable -> L15
        c.a(this.f1112a, r104);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        return;
    L12:
        throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + r103);     // Catch: Throwable -> L15
    L14:
        throw new IllegalStateException("Timer was canceled");     // Catch: Throwable -> L15
    }

    public void a(b r100, long r101) {
        if (r101 < 0) goto L7;
        b(r100, r101);
        return;
    L7:
        throw new IllegalArgumentException("delay < 0: " + r101);
    }

    public void a(int r100, b r101) {
        c r102 = this.f1112a;
        monitor-enter(r102);
        c.a(this.f1112a).a(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
