package zib;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import z5c.d0;
import z5c.e0;
import z5c.f0;
import z5c.g0;
import z5c.h0;
import z5c.n0;
import z5c.z2;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f572307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f572308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f572309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f572310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f572311e;

    public static final class a extends s5c.g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f572312c = null;

        static {
            f572312c = new a();
        }

        public a() {
            super(LocationMonitorConst.ERR_MSG);
        }
    }

    /* JADX INFO: renamed from: zib.b$b, reason: collision with other inner class name */
    public static final class C8465b extends s5c.g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C8465b f572313c = null;

        static {
            f572313c = new C8465b();
        }

        public C8465b() {
            super("is_single");
        }
    }

    public static final class c extends s5c.g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f572314c = null;

        static {
            f572314c = new c();
        }

        public c() {
            super("is_success");
        }
    }

    public static final class d extends s5c.g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f572315c = null;

        static {
            f572315c = new d();
        }

        public d() {
            super("log_extra");
        }
    }

    public static final class e extends s5c.g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f572316c = null;

        static {
            f572316c = new e();
        }

        public e() {
            super("refresh_interval");
        }
    }

    public static final class f extends s5c.g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f572317c = null;

        static {
            f572317c = new f();
        }

        public f() {
            super("source");
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f572318a = null;

        static {
            f572318a = new g();
        }

        public g() {
        }

        public static void a() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
            s5c.a r101 = e.f572316c.a(String.valueOf(b.f572309c - b.f572308b));     // Catch: Throwable -> L4
            s5c.a r102 = C8465b.f572313c.a(String.valueOf(b.f572310d));     // Catch: Throwable -> L4
            Statistics.sendEvent("forward_select_wrong", s5c.d.b.b(r101, f.f572317c.a(b.f572311e)).plus(r102).toJson());     // Catch: Throwable -> L4
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
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
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f572319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f572320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f572321c;

        public h(boolean r100, long r101, long r102) {
            this.f572319a = r100;
            this.f572320b = r101;
            this.f572321c = r102;
        }

        public final void a() {
            boolean r100 = this.f572319a;
            long r101 = this.f572320b;
            long r102 = this.f572321c;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
            s5c.a r104 = e0.f570188c.a(String.valueOf(r100));     // Catch: Throwable -> L5
            s5c.a r105 = h0.f570212c.a(String.valueOf(r101));     // Catch: Throwable -> L5
            s5c.a r106 = d0.f570181c.a(String.valueOf(r102));     // Catch: Throwable -> L5
            s5c.a r107 = f0.f570198c.a("true");     // Catch: Throwable -> L5
            g0 r108 = g0.f570204c;     // Catch: Throwable -> L5
            Log.i("FGUtils", "FG key: core.forward.common_data: " + com.ss.android.lark.forwardv3.utils.b.a("core.forward.common_data", false));     // Catch: Throwable -> L5
            Statistics.sendEvent("forward_data_time_profiler", s5c.d.b.b(r104, r105).plus(r106).plus(r107).plus(r108.a(String.valueOf(true))).toJson());     // Catch: Throwable -> L5
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
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
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f572322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f572323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f572324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f572325d;

        public i(int r100, String r101, String r102, String r103) {
            this.f572322a = r100;
            this.f572323b = r101;
            this.f572324c = r102;
            this.f572325d = r103;
        }

        public final void a() {
            int r100 = this.f572322a;
            String r101 = this.f572323b;
            String r102 = this.f572324c;
            String r103 = this.f572325d;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
            s5c.a r105 = c.f572314c.a("false");     // Catch: Throwable -> L12
            s5c.a r106 = n0.f570260c.a(String.valueOf(r100));     // Catch: Throwable -> L12
            s5c.a r107 = z2.f570438k.a(r101);     // Catch: Throwable -> L12
            a r108 = a.f572312c;     // Catch: Throwable -> L12
            if (r102 != null) goto L7;
            r102 = "";
        L7:
            s5c.a r109 = r108.a(r102);     // Catch: Throwable -> L12
            d r110 = d.f572315c;     // Catch: Throwable -> L12
            if (r103 != null) goto L10;
            r103 = "";
        L10:
            s5c.a r111 = r110.a(r103);     // Catch: Throwable -> L12
            Statistics.sendEvent("forward_send_result", s5c.d.b.b(r107, r105).plus(r106).plus(r111).plus(r109).toJson());     // Catch: Throwable -> L12
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            Result.Companion r112 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
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
    }

    public b() {
    }

    static {
        f572310d = true;
        f572311e = "";
    }

    public static void b() {
        long r100 = f572307a - f572309c;
        if (1 <= r100) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L11;
    L13:
        Log.i("ForwardDataCostProfiler", "This operation is judged as normal.");
    L14:
        f572307a = 0;
        f572308b = 0;
        f572309c = 0;
        return;
    L11:
        if ((System.currentTimeMillis() - f572307a) >= 1000) goto L13;
        Log.i("ForwardDataCostProfiler", "This operation is judged as a wrong.");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(g.f572318a);
        goto L14
    L5:
        if (r100 >= 300) goto L7;
        r101 = true;
        goto L9
    }

    public static void f() {
        Intrinsics.checkNotNullParameter("default", "forwardScene");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new zib.d("default"));
    }

    public static void a(boolean r100, boolean r101) {
        f572307a = System.currentTimeMillis();
        f572310d = r100;
        if (r101 == false) goto L5;
        String r102 = "recent_forward";
    L6:
        f572311e = r102;
        return;
    L5:
        r102 = "recent_visit";
        goto L6
    }

    public static void e(s5c.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "version");
        Intrinsics.checkNotNullParameter(r101, "scene");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new zib.c(r101, r100));
    }

    public static void c(boolean r100, long r101, long r110) {
        if (r100 == false) goto L4;
        f572308b = System.currentTimeMillis();
    L5:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new h(r100, r101, r110));
        return;
    L4:
        f572309c = System.currentTimeMillis();
        goto L5
    }

    public static void d(String r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "forwardScene");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new i(r101, r100, r102, r103));
    }
}
