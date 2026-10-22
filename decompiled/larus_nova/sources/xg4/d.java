package xg4;

import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.m0;
import com.bytedance.crash.util.ListMap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes15.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f563640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f563641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f563642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xg4.b f563643d;

    public static class a extends d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f563644e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicInteger f563645f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f563646g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f563647h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile boolean f563648i;

        /* JADX INFO: renamed from: xg4.d$a$a, reason: collision with other inner class name */
        public class RunnableC8233a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f563649a;

            @Override // java.lang.Runnable
            public final void run() {
                p.d(this.f563649a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC8233a(a r100) {
                this.f563649a = r100;
            }
        }

        public final void f() {
            if (this.f563645f.decrementAndGet() <= 0) goto L6;
            return;
        L6:
            if (this.f563647h != 0) goto L31;
            i r100 = this.f563640a;
            int r101 = Process.myPid();
            long r102 = this.f563642c;
            File r103 = null;
            if (r100.f563658d.exists() == true) goto L10;
            File[] r104 = null;
        L11:
            if (r104 == null) goto L23;
            int r105 = r104.length;
            int r110 = 0;
        L13:
            if (r110 >= r105) goto L23;
            File r111 = r104[r110];
            if (i.d(r111.getName()) != r101) goto L22;
            if (Math.abs(r102 - i.c(r111.getName())) > 35000) goto L19;
            boolean r112 = true;
        L20:
            if (r112 == false) goto L22;
            r103 = r111;
            goto L23
        L19:
            r112 = false;
        L22:
            r110 = r110 + 1;
        L23:
            monitor-enter(this);
            this.f563647h = c(r103);     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            throw th;
        L10:
            r104 = r100.f563658d.listFiles(new g());
        L31:
            if (this.f563647h == 0) goto L34;
            wh4.b.postDelayed(new RunnableC8233a(this), 120000);
            return;
        L34:
            if (this.f563648i == false) goto L46;
            p.d(this);
            if (this.f563645f.decrementAndGet() >= 0) goto L47;
            com.bytedance.crash.util.g.e(this.f563641b);
            return;
        L47:
            return;
        }

        @Override // xg4.d
        public final boolean b(boolean r100) {
            if (r100 == false) goto L8;
            if (this.f563646g != 0) goto L12;
        L10:
            return false;
        L12:
            return true;
        L8:
            if (this.f563647h == 0) goto L10;
            return true;
        }

        public a(i r100, PolarisFileWrapper r101, long r102, boolean r103) {
            super(r100, r101, r102, r103);
            this.f563645f = new AtomicInteger(0);
            this.f563644e = new c(this);
        }

        @Override // xg4.d
        public final void e(long r100, boolean r101, PolarisFileWrapper r102, int r103, int r104) {
            if (this.f563645f.incrementAndGet() > 0) goto L6;
            boolean r105 = false;
        L23:
            if (r105 == true) goto L25;
            return;
        L25:
            d(r103, r104);
            if (r102 == null) goto L28;
            d.a(r102);
        L28:
            f();
            return;
        L6:
            if (r101 == false) goto L17;
            monitor-enter(this);
            this.f563646g = r100;     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            if (this.f563647h != 0) goto L22;
            wh4.b.postDelayed(this.f563644e, 35000);
        L22:
            r105 = true;
        L13:
            th = move-exception;
            throw th;
        L17:
            if (this.f563646g == 0) goto L19;
            wh4.b.f(this.f563644e);
        L19:
            monitor-enter(this);
            this.f563647h = c(r102);     // Catch: Throwable -> L30
            monitor-exit(this);     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;
        }
    }

    public static class b extends d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f563650e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicInteger f563651f;

        @Override // xg4.d
        public final boolean b(boolean r100) {
            return false;
        }

        public final void f() {
            if (this.f563651f.get() > 0) goto L6;
            d.a(new PolarisFileWrapper(this.f563641b, "anr_info.txt"));
            wh4.b.f(this.f563650e);
            this.f563650e = null;
            p.d(this);
            return;
        }

        public b(i r100, PolarisFileWrapper r101, long r102, boolean r103) {
            super(r100, r101, r102, r103);
            this.f563651f = new AtomicInteger(2);
        }

        @Override // xg4.d
        public final void e(long r100, boolean r101, PolarisFileWrapper r102, int r103, int r104) {
            if (this.f563651f.decrementAndGet() >= 0) goto L6;
            boolean r105 = false;
        L9:
            if (r105 == true) goto L11;
            return;
        L11:
            if (r102 != null) goto L13;
        L15:
            d(r103, r104);
            if (new PolarisFileWrapper(this.f563641b, "anr_info.txt").exists() == false) goto L22;
        L19:
            f();
            return;
        L22:
            com.bytedance.crash.util.h.h(new PolarisFileWrapper(this.f563641b, "anr_info.txt"), "silent anr no anr info", false);     // Catch: Exception -> L21
            goto L19
        L13:
            if (r102.exists() == false) goto L15;
            c(r102);
            goto L15
        L6:
            if (this.f563650e != null) goto L8;
            e r106 = new e(this);
            this.f563650e = r106;
            wh4.b.postDelayed(r106, 120000);
        L8:
            r105 = true;
            goto L9
        }
    }

    public abstract boolean b(boolean r100);

    public abstract void e(long r100, boolean r101, PolarisFileWrapper r102, int r103, int r104);

    public static void a(PolarisFileWrapper r100) {
        String r101 = com.bytedance.crash.util.g.f(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        Iterator<com.bytedance.crash.monitor.d> r102 = com.bytedance.crash.monitor.d.f203274o.iterator();
    L7:
        if (r102.hasNext() == false) goto L22;
        m0 r103 = r102.next().f203291c;
        CrashType r104 = CrashType.ANR;
        ListMap<CrashType, ICrashCallback> r105 = r103.f203242e;
        monitor-enter(r105);
        List<ICrashCallback> r106 = r103.f203242e.getList(r104);     // Catch: Throwable -> L19
        monitor-exit(r105);     // Catch: Throwable -> L19
        Iterator<ICrashCallback> r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L7;
        ICrashCallback r108 = r107.next();
        r108.onCrash(CrashType.ANR, r101, null);     // Catch: Throwable -> L18
    L19:
        th = move-exception;
        throw th;
    }

    public final long c(File r100) {
        if (r100 != null) goto L4;
    L6:
        return 0;
    L4:
        if (r100.exists() == false) goto L6;
        long r101 = i.c(r100.getName());
        r100.renameTo(new PolarisFileWrapper(this.f563641b, "anr_info.txt"));
        return r101;
    }

    public final void d(int r110, int r111) {
        xg4.b r100 = this.f563643d;
        r100.getClass();
        if (p.f563719k == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L200;
        return;
    L200:
    L16:
        th = move-exception;
        ch4.c.a("dumpSummary", th);
    L218:
    L22:
        th = move-exception;
        ch4.c.a("dumpAppVersion", th);
    L216:
    L39:
        th = move-exception;
        ch4.c.a("dumpProfileInfo", th);
    L237:
    L45:
        th = move-exception;
        ch4.c.a("dumpProfileInfo", th);
    L47:
        r100.a(true);
        if (r100.C.compareAndSet(false, true) == false) goto L214;
        com.bytedance.crash.monitor.a r112 = com.bytedance.crash.monitor.j.f203315a;     // Catch: Throwable -> L192
        if (r112 == null) goto L214;
        m0 r113 = r112.f203291c;     // Catch: Throwable -> L192
        CrashType r102 = CrashType.ANR;     // Catch: Throwable -> L192
        ListMap<CrashType, com.bytedance.crash.v> r103 = r113.f203247j;     // Catch: Throwable -> L192
        monitor-enter(r103);     // Catch: Throwable -> L192
        List<com.bytedance.crash.v> r114 = r113.f203247j.getList(r102);     // Catch: Throwable -> L63
        monitor-exit(r103);     // Catch: Throwable -> L63
        Iterator<com.bytedance.crash.v> r115 = r114.iterator();     // Catch: Throwable -> L192
    L59:
        if (r115.hasNext() == false) goto L214;
        com.bytedance.crash.v r104 = r115.next();     // Catch: Throwable -> L192
        CrashType r105 = CrashType.LAUNCH;     // Catch: Throwable -> L191
        r104.a();     // Catch: Throwable -> L191
        goto L59
    L63:
        th = move-exception;
        throw th;     // Catch: Throwable -> L192
    L214:
    L77:
        th = move-exception;
        ch4.c.a("dumpMainStack", th);
    L80:
        if (p.f563718j == false) goto L88;
    L85:
        th = move-exception;
        ch4.c.a("dumpAnrTrace", th);
        goto L88
    L82:
        if (r100.f563624m.compareAndSet(false, true) == false) goto L88;
        NativeBridge.e(new PolarisFileWrapper(r100.f563612a, "trace.txt").getAbsolutePath());     // Catch: Throwable -> L85
    L88:
        if (p.f563718j == false) goto L252;
    L96:
        th = move-exception;
        ch4.c.a("dumpAdj", th);
    L233:
        r100.f563636y.compareAndSet(false, true);     // Catch: Throwable -> L100
    L102:
        r100.a(false);
        if (r100.A == true) goto L204;
        NativeBridge.c(r100.f563615d);
        r100.A = true;
    L204:
    L109:
        th = move-exception;
        ch4.c.a("dumpCommonParams", th);
    L226:
    L115:
        th = move-exception;
        ch4.c.a("dumpMemoryInfo", th);
    L241:
    L121:
        th = move-exception;
        ch4.c.a("dumpLocaleInfo", th);
    L206:
    L127:
        th = move-exception;
        ch4.c.a("dumpCustomFilter", th);
    L228:
    L133:
        th = move-exception;
        ch4.c.a("dumpScraps", th);
    L245:
    L139:
        th = move-exception;
        ch4.c.a("dumpSdkInfo", th);
    L202:
    L145:
        th = move-exception;
        ch4.c.a("dumpActivityLifecycle", th);
    L220:
    L151:
        th = move-exception;
        ch4.c.a("dumpGfxInfo", th);
    L154:
        if (xg4.b.D == true) goto L243;
    L208:
        com.bytedance.crash.monitor.a r116 = com.bytedance.crash.monitor.j.f203315a;     // Catch: Throwable -> L194
        if (r116 == null) goto L222;
        yh4.a r117 = r116.f203300l;     // Catch: Throwable -> L194
        if (r117 == null) goto L222;
        if (r100.B.compareAndSet(false, true) == false) goto L222;
        ((com.bytedance.crash.dumper.j) r117).a(r100.f563612a);     // Catch: Throwable -> L194
    L222:
        if (r100.f563637z.compareAndSet(false, true) == false) goto L235;
        com.bytedance.crash.h.a();     // Catch: Throwable -> L195
    L235:
    L176:
        th = move-exception;
        ch4.c.a("dumpCustomData", th);
    L198:
    L182:
        th = move-exception;
        ch4.c.a("dumpCustomFile", th);
    L212:
    L188:
        th = move-exception;
        ch4.c.a("dumpRepairInfo", th);
        return;
    L185:
        if (r100.f563632u.compareAndSet(false, true) == false) goto L250;
        com.bytedance.crash.dumper.n.a(r100.f563612a);     // Catch: Throwable -> L188
        return;
    L250:
        return;
    L179:
        if (r100.f563635x.compareAndSet(false, true) == false) goto L212;
        com.bytedance.crash.dumper.f.a(r100.f563612a, CrashType.ANR);     // Catch: Throwable -> L182
        goto L212
    L173:
        if (r100.f563634w.compareAndSet(false, true) == false) goto L198;
        com.bytedance.crash.dumper.e.b(r100.f563612a, CrashType.ANR, 0);     // Catch: Throwable -> L176
        goto L198
    L243:
    L159:
        th = move-exception;
        ch4.c.a("dumpViewTree", th);
        goto L208
    L156:
        if (r100.f563633v.compareAndSet(false, true) == false) goto L208;
        com.bytedance.crash.dumper.q.a(r100.f563612a);     // Catch: Throwable -> L159
        goto L208
    L148:
        if (r100.f563631t.compareAndSet(false, true) == false) goto L154;
        com.bytedance.crash.dumper.i.b(r100.f563612a);     // Catch: Throwable -> L151
        goto L154
    L142:
        if (r100.f563630s.compareAndSet(false, true) == false) goto L220;
        bi4.a.b(r100.f563612a);     // Catch: Throwable -> L145
        goto L220
    L136:
        if (r100.f563629r.compareAndSet(false, true) == false) goto L202;
        com.bytedance.crash.dumper.o.a(r100.f563612a);     // Catch: Throwable -> L139
        goto L202
    L130:
        if (r100.f563628q.compareAndSet(false, true) == false) goto L245;
        Scraps.dump(r100.f563612a);     // Catch: Throwable -> L133
        goto L245
    L124:
        if (r100.f563626o.compareAndSet(false, true) == false) goto L228;
        com.bytedance.crash.dumper.g.a(r100.f563612a);     // Catch: Throwable -> L127
        com.bytedance.crash.dumper.g.b(r100.f563612a);     // Catch: Throwable -> L127
        goto L228
    L118:
        if (r100.f563625n.compareAndSet(false, true) == false) goto L206;
        LocaleInfo.dump(r100.f563612a);     // Catch: Throwable -> L121
        goto L206
    L112:
        if (r100.f563627p.compareAndSet(false, true) == false) goto L241;
        MemoryInfo.a(r100.f563612a);     // Catch: Throwable -> L115
        goto L241
    L106:
        if (r100.f563620i.compareAndSet(false, true) == false) goto L226;
        com.bytedance.crash.dumper.d.a(r100.f563612a);     // Catch: Throwable -> L109
    L100:
        th = move-exception;
        ch4.c.a("dumpCustomFile", th);
        goto L102
    L91:
        if (r100.f563617f.compareAndSet(false, true) == false) goto L233;
        if (r110 == Integer.MAX_VALUE) goto L233;
        xg4.b.C8232b.a(r100.f563612a, r110);     // Catch: Throwable -> L96
        goto L233
    L252:
        return;
    L67:
        if (p.f563718j == false) goto L80;
        if (r100.f563618g.compareAndSet(false, true) == false) goto L80;
        File r118 = r100.f563612a;     // Catch: Throwable -> L77
        StackTraceElement[] r106 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getStackTrace();     // Catch: Throwable -> L77
        System.currentTimeMillis();     // Catch: Throwable -> L77
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L77
        int r108 = r106.length;     // Catch: Throwable -> L77
        int r109 = 0;
    L71:
        if (r109 >= r108) goto L239;
        StackTraceElement r119 = r106[r109];     // Catch: Throwable -> L77
        r107.append("  at ");     // Catch: Throwable -> L77
        r107.append(r119.getClassName());     // Catch: Throwable -> L77
        r107.append(".");     // Catch: Throwable -> L77
        r107.append(r119.getMethodName());     // Catch: Throwable -> L77
        r107.append("(");     // Catch: Throwable -> L77
        r107.append(r119.getFileName());     // Catch: Throwable -> L77
        r107.append(":");     // Catch: Throwable -> L77
        r107.append(r119.getLineNumber());     // Catch: Throwable -> L77
        r107.append(")\n");     // Catch: Throwable -> L77
        r109 = r109 + 1;     // Catch: Throwable -> L77
        goto L71
    L239:
        com.bytedance.crash.util.h.h(com.bytedance.crash.util.g.d(r118, "main_stack.txt"), r107.toString(), false);     // Catch: Exception -> L193 Throwable -> L77
    L75:
        CrashType r120 = CrashType.LAUNCH;     // Catch: Throwable -> L77
        goto L80
    L42:
        if (r100.f563622k.compareAndSet(false, true) == false) goto L47;
        com.bytedance.crash.dumper.m.f203179j.c(r100.f563612a);     // Catch: Throwable -> L45
        goto L47
    L25:
        if (r100.f563621j.compareAndSet(false, true) == false) goto L237;
        File r121 = r100.f563612a;     // Catch: Throwable -> L39
        long r122 = r100.f563615d;     // Catch: Throwable -> L39
        p r123 = p.f563716h;     // Catch: Throwable -> L39
        if (r123 != null) goto L29;
    L31:
        boolean r124 = false;
    L32:
        if (r124 == false) goto L237;
        s r125 = r123.f563724d;     // Catch: Throwable -> L39
        if (r125 == null) goto L237;
        long r126 = r125.f563729a;     // Catch: Throwable -> L39
        if (r126 == 0) goto L237;
        NativeBridge.nAnrNativeProfilerDump(r126, r121 + "/anr_profiler.inf", r122);     // Catch: Throwable -> L39
        goto L237
    L29:
        if (r123.f563725e == false) goto L31;
        r124 = true;
        goto L32
    L19:
        if (r100.f563619h.compareAndSet(false, true) == false) goto L216;
        com.bytedance.crash.dumper.a.a(r100.f563612a);     // Catch: Throwable -> L22
        goto L216
    L13:
        if (r100.f563616e.compareAndSet(false, true) == false) goto L218;
        w.b(r100.f563612a, r100.f563613b, r100.f563614c, r111);     // Catch: Throwable -> L16
        goto L218
    L5:
        if (com.bytedance.crash.i.f203219i == true) goto L8;
        r101 = false;
        goto L9
    }

    public d(i r100, PolarisFileWrapper r101, long r102, boolean r103) {
        this.f563640a = r100;
        this.f563642c = r102;
        PolarisFileWrapper r104 = com.bytedance.crash.util.g.b(com.bytedance.crash.util.g.b(r101, com.bytedance.crash.crash.c.a()), String.valueOf(r102));
        this.f563641b = r104;
        this.f563643d = new xg4.b(r104, r102, r103);
    }
}
