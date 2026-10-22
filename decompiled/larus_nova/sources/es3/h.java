package es3;

import android.app.Activity;
import android.os.Build;
import android.os.Looper;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.Window;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements gs3.c {
    public static boolean A;
    public static com.bytedance.apm.block.a B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final h f473717z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f473718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f473719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f473720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.apm.block.a> f473721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f473722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f473723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f473724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f473725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f473726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object[] f473727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f473728k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Method f473729l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Choreographer f473730m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f473731n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final bt3.e f473732o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public j.a f473733p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final bt3.f f473734q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HashMap<String, Window.OnFrameMetricsAvailableListener> f473735r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f473736s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f473737t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f473738u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f473739v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f473740w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f473741x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile long f473742y;

    public class a extends b27.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h f473743d;

        @Override // b27.a
        public final void a() {
            this.f17030a = false;
            h r100 = this.f473743d;
            boolean r110 = r100.f473724g;
            if (r100.f473723f == true) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == false) goto L52;
            if (r110 == false) goto L52;
            r100.c(r100.f473733p);
            r100.f473724g = false;
            long r102 = b27.a.f17028b;
            long r103 = r100.f473736s;
            if (r100.f473728k == null) goto L50;
            com.bytedance.monitor.collector.b r104 = com.bytedance.monitor.collector.c.e().f265651i;
            com.bytedance.monitor.collector.a r105 = null;
            if (r104 != null) goto L15;
            com.bytedance.monitor.collector.a r106 = null;
        L16:
            if (r106 == null) goto L37;
            com.bytedance.monitor.collector.b r107 = com.bytedance.monitor.collector.c.e().f265651i;
            if (r107 == null) goto L21;
            r105 = r107.f265587e;
        L21:
            long[] r108 = r100.f473728k;
            com.bytedance.monitor.collector.b r109 = r105.f265586a;
            if (r109.f265600r == false) goto L37;
            com.bytedance.monitor.collector.b.f r111 = r109.f265592j;
            if (r111 == null) goto L37;
            com.bytedance.monitor.collector.b.e r112 = r111.b();
            if (r112 == null) goto L37;
            if (r112.f265626d != 8) goto L37;
            com.bytedance.monitor.collector.b.d r113 = new com.bytedance.monitor.collector.b.d();
            if (r108 == null) goto L35;
            r113.f265618a = r108[1];
            r113.f265619b = r108[5];
            r113.f265620c = r108[6];
            r113.f265621d = r108[7];
            r113.f265622e = r108[8];
        L35:
            r112.f265636n = r113;
        L37:
            if (f.f473715a == null) goto L39;
        L48:
            f.f473715a.getClass();
            goto L50
        L39:
            monitor-enter(f.class);
        L45:
            th = move-exception;
            throw th;
        L41:
            if (f.f473715a != null) goto L43;
            f.f473715a = new f();     // Catch: Throwable -> L45
        L43:
            monitor-exit(f.class);     // Catch: Throwable -> L45
            goto L48
        L15:
            r106 = r104.f265587e;
        L50:
            if (Build.VERSION.SDK_INT >= 24) goto L52;
            r100.f473732o.a(new i(r100, r103, r102));
        L52:
            long[] r114 = r100.f473720c;
            r114[1] = b27.a.f17028b;
            r114[3] = b27.a.f17029c;
            CopyOnWriteArrayList r115 = (CopyOnWriteArrayList) r100.f473721d;
            int r116 = r115.size();
            int r117 = 0;
        L54:
            if (r117 >= r116) goto L60;
            com.bytedance.apm.block.a r118 = (com.bytedance.apm.block.a) ListProtector.get(r115, r117);
            if (r118.f190316a == false) goto L58;
            long[] r119 = r100.f473720c;
            boolean r210 = r110;
            r118.d(r119[0], r119[2], r119[1], r119[3], r210);
        L59:
            r117 = r117 + 1;
            r110 = r210;
            goto L54
        L58:
            r210 = r110;
            goto L59
        L60:
            long[] r120 = r100.f473719b.f473716a;
            r120[0] = 0;
            r120[1] = 0;
            r120[2] = Long.MAX_VALUE;
            r120[3] = 0;
            r100.f473725h = false;
            return;
        L5:
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            r101 = true;
            goto L8
        }

        @Override // b27.a
        public final boolean c() {
            return this.f473743d.f473718a;
        }

        public a(h r100) {
            this.f473743d = r100;
        }

        @Override // b27.a
        public final void b(String r100) {
            this.f17030a = true;
            h r101 = this.f473743d;
            r101.f473725h = true;
            long[] r102 = r101.f473720c;
            int r103 = 0;
            r102[0] = b27.a.f17028b;
            r102[2] = b27.a.f17029c;
            CopyOnWriteArrayList r104 = (CopyOnWriteArrayList) r101.f473721d;
            int r105 = r104.size();
        L3:
            if (r103 >= r105) goto L8;
            com.bytedance.apm.block.a r106 = (com.bytedance.apm.block.a) ListProtector.get(r104, r103);
            if (r106.f190316a == true) goto L7;
            r106.c(r100);
        L7:
            r103 = r103 + 1;
            goto L3
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class b implements Window.OnFrameMetricsAvailableListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f473744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f473745b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f473746a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f473747b;

            public final void a() {
                com.bytedance.apm.block.a r100 = h.B;
                if (r100 == null) goto L7;
                b r101 = this.f473747b;
                if (r101.f473745b.f473740w == false) goto L7;
                r100.f(r101.f473744a, this.f473746a);
                return;
            L7:
                Iterator r102 = ((CopyOnWriteArrayList) this.f473747b.f473745b.f473721d).iterator();
            L9:
                if (r102.hasNext() == false) goto L13;
                ((com.bytedance.apm.block.a) r102.next()).f(this.f473747b.f473744a, this.f473746a);
                goto L9
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

            public a(b r100, long r101, int r102) {
                this.f473747b = r100;
                this.f473746a = r101;
            }
        }

        /* JADX INFO: renamed from: es3.h$b$b, reason: collision with other inner class name */
        public class RunnableC5811b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FrameMetrics f473748a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f473749b;

            public final void a() {
                com.bytedance.apm.block.a r100 = h.B;
                if (r100 == null) goto L7;
                b r101 = this.f473749b;
                if (r101.f473745b.f473740w == false) goto L7;
                r100.g(r101.f473744a, this.f473748a);
                return;
            L7:
                Iterator r102 = ((CopyOnWriteArrayList) this.f473749b.f473745b.f473721d).iterator();
            L9:
                if (r102.hasNext() == false) goto L13;
                ((com.bytedance.apm.block.a) r102.next()).g(this.f473749b.f473744a, this.f473748a);
                goto L9
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

            public RunnableC5811b(b r100, FrameMetrics r101, int r102) {
                this.f473749b = r100;
                this.f473748a = r101;
            }
        }

        public b(h r100, String r101) {
            this.f473745b = r100;
            this.f473744a = r101;
        }

        @Override // android.view.Window.OnFrameMetricsAvailableListener
        public final void onFrameMetricsAvailable(Window r110, FrameMetrics r111, int r210) {
            if (Build.VERSION.SDK_INT < 36) goto L9;
            long r100 = r111.getMetric(11);
            if (r100 != this.f473745b.f473742y) goto L7;
            return;
        L7:
            this.f473745b.f473742y = r100;
        L9:
            if (this.f473745b.f473738u == false) goto L17;
            long r101 = (((((r111.getMetric(0) + r111.getMetric(1)) + r111.getMetric(2)) + r111.getMetric(3)) + r111.getMetric(4)) + r111.getMetric(5)) / 1000000;
            if (r111.getMetric(9) != 0) goto L25;
            h r102 = this.f473745b;
            long r103 = r102.f473741x;
            if (r103 > 0) goto L15;
        L16:
            r102.f473732o.a(new a(this, r101, r210));
            return;
        L15:
            if (r101 > r103) goto L16;
            return;
        L25:
            return;
        L17:
            FrameMetrics r104 = new FrameMetrics(r111);
            if (r104.getMetric(9) != 0) goto L28;
            long r112 = (((((r104.getMetric(0) + r104.getMetric(1)) + r104.getMetric(2)) + r104.getMetric(3)) + r104.getMetric(4)) + r104.getMetric(5)) / 1000000;
            h r105 = this.f473745b;
            long r106 = r105.f473741x;
            if (r106 > 0) goto L22;
        L23:
            r105.f473732o.a(new RunnableC5811b(this, r104, r210));
            return;
        L22:
            if (r112 > r106) goto L23;
            return;
        }
    }

    public final void e() {
        int r100 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L16
        if (r100 <= 22) goto L12;
        long[] r101 = this.f473728k;     // Catch: Throwable -> L16
        if (r101 != null) goto L9;
        this.f473736s = b27.a.f17028b;     // Catch: Throwable -> L16
    L13:
        this.f473724g = true;     // Catch: Throwable -> L16
        this.f473731n = false;
        return;
    L9:
        if (r100 < 31) goto L11;
        this.f473736s = r101[2] / 1000000;     // Catch: Throwable -> L16
        goto L13
    L11:
        this.f473736s = r101[1] / 1000000;     // Catch: Throwable -> L16
        goto L13
    L12:
        this.f473736s = b27.a.f17028b;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.f473731n = false;
        throw th;
    }

    @Override // gs3.c
    public final void onBackground() {
    }

    static {
        f473717z = new h();
    }

    public final int f() {
        int r100 = ((CopyOnWriteArrayList) this.f473721d).size();
        boolean r101 = zs3.c.b("block_monitor");
        if (A == false) goto L7;
        if (r101 == false) goto L6;
        return r100;
    L6:
        return r100 - 1;
    L7:
        return r100;
    }

    public final void g() {
        if (this.f473737t == false) goto L6;
        return;
    L6:
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L10;
        ActivityLifeObserver.getInstance().register(this);
        b27.e.e();
        b27.e.f17038e = new a(this);
        this.f473737t = true;
        return;
    L10:
        throw new AssertionError("must be init in main thread!");
    }

    @Override // gs3.c
    public final void onFront() {
        if (this.f473730m == null) goto L6;
        return;
    L6:
        if (this.f473723f == true) goto L8;
    L10:
        boolean r100 = false;
    L11:
        if (r100 == false) goto L18;
        this.f473730m = Choreographer.getInstance();     // Catch: Exception -> L15
    L13:
        bt3.b.d.f20539a.e(new j(this));
        return;
    L18:
        return;
    L8:
        if (Build.VERSION.SDK_INT >= 24) goto L10;
        r100 = true;
        goto L11
    }

    public h() {
        this.f473719b = new g();
        this.f473720c = new long[4];
        this.f473721d = new CopyOnWriteArrayList();
        this.f473722e = false;
        this.f473723f = false;
        this.f473724g = false;
        this.f473725h = false;
        this.f473731n = false;
        this.f473732o = new bt3.e();
        this.f473734q = new bt3.f("looper_monitor");
        this.f473735r = new HashMap();
        this.f473736s = -1;
        this.f473741x = 0;
        this.f473742y = 0;
    }

    public final synchronized void c(Runnable r100) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f473718a == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f473731n == false) goto L31;
        monitor-exit(this);
        return;
    L31:
        Object r101 = this.f473726i;     // Catch: Exception -> L26 Throwable -> L23
        monitor-enter(r101);     // Catch: Exception -> L26 Throwable -> L23
        Method r102 = this.f473729l;     // Catch: Throwable -> L18
        if (r102 == null) goto L16;
        r102.invoke(this.f473727j[0], new Object[]{-1L, r100, null});     // Catch: Throwable -> L18
        this.f473731n = true;     // Catch: Throwable -> L18
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Exception -> L26 Throwable -> L23
    L21:
        monitor-exit(this);
    }

    public final void d(com.bytedance.apm.block.a r100) {
        if (this.f473718a == true) goto L30;
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L6:
        if (com.bytedance.apm.d.l() == true) goto L10;
        monitor-exit(this);
        goto L30
    L10:
        if (this.f473737t == false) goto L25;
        boolean r101 = true;
        if (this.f473718a == true) goto L15;
        this.f473718a = true;     // Catch: Throwable -> L26
    L15:
        if (this.f473723f == true) goto L17;
    L19:
        r101 = false;
    L20:
        if (r101 == false) goto L22;
        c(this.f473733p);     // Catch: Throwable -> L26
    L22:
        monitor-exit(this);
        goto L30
    L17:
        if (Build.VERSION.SDK_INT >= 24) goto L19;
    L25:
        throw new RuntimeException("never init!");     // Catch: Throwable -> L26
    L30:
        if (((CopyOnWriteArrayList) this.f473721d).contains(r100) == true) goto L36;
        ((CopyOnWriteArrayList) this.f473721d).add(r100);
        if (this.f473740w == false) goto L37;
        b27.e.g();
        return;
    L37:
        return;
    }

    @Override // gs3.c
    public final void onActivityCreated(Activity r100) {
        Window r101 = r100.getWindow();     // Catch: Exception -> L31
        int r102 = Build.VERSION.SDK_INT;     // Catch: Exception -> L31
        if (r102 < 23) goto L5;
        r101.setCallback(new k(this, r101.getCallback()));     // Catch: Exception -> L31
    L5:
        String r103 = r100.getClass().getName();     // Catch: Exception -> L31
        String r104 = r100.toString();     // Catch: Exception -> L31
        if (b27.e.f17034a == false) goto L18;
        if (b27.e.f17043j == true) goto L18;
        h r105 = f473717z;     // Catch: Exception -> L31
        if (r105.f473740w == false) goto L18;
        int r106 = r105.f();     // Catch: Exception -> L31
        if (b27.e.f17037d.isEmpty() == false) goto L18;
        if (r106 != 0) goto L18;
        b27.e.b();     // Catch: Exception -> L31
    L18:
        if (this.f473722e == false) goto L21;
        return;
    L21:
        if (r102 >= 24) goto L23;
        return;
    L23:
        if (this.f473734q.f20550d == null) goto L25;
        boolean r107 = true;
    L26:
        if (r107 == false) goto L35;
        l r108 = new l(this, r103);     // Catch: Exception -> L31
        this.f473735r.put(r104, r108);     // Catch: Exception -> L31
        if (this.f473739v == true) goto L36;
        r101.addOnFrameMetricsAvailableListener(r108, this.f473734q.f20550d);     // Catch: Exception -> L31
        return;
    L36:
        return;
    L35:
        return;
    L25:
        r107 = false;
    }

    @Override // gs3.c
    public final void onActivityDestroyed(Activity r100) {
        if (Build.VERSION.SDK_INT < 24) goto L11;
        Window.OnFrameMetricsAvailableListener r101 = this.f473735r.remove(r100.toString());     // Catch: Exception -> L8
        if (r101 == null) goto L12;
        r100.getWindow().removeOnFrameMetricsAvailableListener(r101);     // Catch: Exception -> L8
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // gs3.c
    public final void onActivityResumed(Activity r100) {
        if (this.f473722e == true) goto L22;
        return;
    L22:
        if (Build.VERSION.SDK_INT < 24) goto L24;
        Window r101 = r100.getWindow();     // Catch: Exception -> L21
        String r102 = r100.getClass().getName();     // Catch: Exception -> L21
        String r103 = r100.toString();     // Catch: Exception -> L21
        HashMap<String, Window.OnFrameMetricsAvailableListener> r104 = this.f473735r;     // Catch: Exception -> L21
        if (r104 == null) goto L13;
        if (r104.containsKey(r103) == false) goto L13;
        return;
    L13:
        if (this.f473734q.f20550d == null) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L25;
        b r106 = new b(this, r102);     // Catch: Exception -> L21
        this.f473735r.put(r103, r106);     // Catch: Exception -> L21
        if (this.f473739v == true) goto L26;
        r101.addOnFrameMetricsAvailableListener(r106, this.f473734q.f20550d);     // Catch: Exception -> L21
        return;
    L26:
        return;
    L25:
        return;
    L15:
        r105 = false;
        goto L16
    L24:
        return;
    }

    public static Method h(Class r100, Class... r101) {
        Method r102 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r100, new Object[]{BdpAppEventConstant.PARAMS_OUTPUT, r101});     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        return r102;
    L5:
        return null;
    }

    public static Object a(h r100, Object r101, String r102) {
        r100.getClass();
        Field r103 = r101.getClass().getDeclaredField(r102);     // Catch: Exception -> L5
        r103.setAccessible(true);     // Catch: Exception -> L5
        return r103.get(r101);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Object b(h r100, Object r101, String r102) {
        r100.getClass();
        Field r103 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r101.getClass(), new Object[]{r102});     // Catch: Exception -> L5
        r103.setAccessible(true);     // Catch: Exception -> L5
        return r103.get(r101);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
