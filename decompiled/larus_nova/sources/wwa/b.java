package wwa;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.z;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.batterymonitor.api.ConditionState;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.o0;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends wwa.a implements Observer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List<xwa.b.a> f561740i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f561741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f561742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScheduledFuture f561743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RunnableC8168b f561744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f561745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f561746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f561747h;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f561748a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f561748a.f(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100) {
            this.f561748a = r100;
        }
    }

    /* JADX INFO: renamed from: wwa.b$b, reason: collision with other inner class name */
    public class RunnableC8168b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f561749a;

        public final void a() {
            b r100 = this.f561749a;
            monitor-enter(r100);
            b.d(this.f561749a);     // Catch: Throwable -> L37
            d r101 = this.f561749a.f561741b;     // Catch: Throwable -> L37
            boolean r102 = false;
            if (r101 != null) goto L8;
        L16:
            long r103 = 600;
            if (r102 == false) goto L26;
            b r104 = this.f561749a;     // Catch: Throwable -> L37
            r104.f561746g = 5;     // Catch: Throwable -> L37
            if (r104.f561745f == true) goto L22;
            r103 = TimeUtils.SECONDS_PER_HOUR;
        L22:
            Log.i("BatteryMonitor", "BatteryMonitorManager current is doze, so add next task after " + r103);     // Catch: Throwable -> L37
            this.f561749a.e(r103);     // Catch: Throwable -> L37
            monitor-exit(r100);     // Catch: Throwable -> L37
            return;
        L26:
            if (zwa.b.a.f573863a.d() == false) goto L30;
            Log.i("BatteryMonitor", "BatteryMonitorManager current is foreground, so not add next task");     // Catch: Throwable -> L37
            monitor-exit(r100);     // Catch: Throwable -> L37
            return;
        L30:
            b r105 = this.f561749a;     // Catch: Throwable -> L37
            if (r105.f561745f == true) goto L33;
            long r106 = r105.f561746g;     // Catch: Throwable -> L37
        L34:
            Log.i("BatteryMonitor", "BatteryMonitorManager current is not doze, so add next task after " + r106);     // Catch: Throwable -> L37
            this.f561749a.e(r106);     // Catch: Throwable -> L37
            monitor-exit(r100);     // Catch: Throwable -> L37
            return;
        L33:
            r106 = Math.min(r105.f561746g * 2, 600);     // Catch: Throwable -> L37
            r105.f561746g = r106;     // Catch: Throwable -> L37
            goto L34
        L8:
            if (CollectionUtils.isEmpty(r101.f561752a) == true) goto L16;
            AbsBatteryStrategy r107 = (AbsBatteryStrategy) ListProtector.get(r101.f561752a, 0);     // Catch: Throwable -> L37
            if (r107 == null) goto L16;
            if (r107.f409788b != 2) goto L16;
            r102 = true;
        L37:
            th = move-exception;
            throw th;
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

        public RunnableC8168b(b r100) {
            this.f561749a = r100;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f561750a = null;

        static {
            f561750a = new b();
        }
    }

    static {
        f561740i = new CopyOnWriteArrayList();
    }

    @Override // wwa.a
    public final void b() {
        Log.i("BatteryMonitor", " BatteryMonitorManager onCreate called.");
        zwa.b r100 = zwa.b.a.f573863a;
        r100.a(getContext());
        r100.addObserver(this);
        axa.a.b.f16644a.a(getContext());
        cxa.a r101 = cxa.a.C5604a.f465748a;
        r101.a(getContext());
        ywa.a r102 = ywa.a.C8395a.f569364a;
        r102.a(getContext());
        if (this.f561745f == false) goto L5;
        r101.addObserver(this);
        r102.addObserver(this);
    L5:
        f(3);
    }

    public b() {
        this.f561744e = new RunnableC8168b(this);
        this.f561745f = false;
        this.f561746g = 5;
        this.f561747h = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(b r100) {
        r100.getClass();
        Log.i("BatteryMonitor", "BatteryMonitorManager execute called.");
        zwa.b r101 = zwa.b.a.f573863a;
        monitor-enter(r101);
        int r102 = r101.f573859c;     // Catch: Throwable -> L34
        if (r102 == 1) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L34
    L13:
        Context r103 = axa.a.b.f16644a.getContext();
        int r104 = 0;
        if (r103 != null) goto L16;
        boolean r105 = 0;
    L17:
        int r106 = !r105;
        int r107 = cxa.a.C5604a.f465748a.e();
        ywa.a r108 = ywa.a.C8395a.f569364a;
        if (Build.VERSION.SDK_INT < 23) goto L28;
        r108.getClass();
    L26:
        e = move-exception;
        Log.e("BatteryMonitor", "get charging state exception!", e);
        r108.f569363b = 1;
        goto L28
    L21:
        if (((BatteryManager) r108.getContext().getSystemService("batterymanager")).isCharging() == true) goto L24;
        r104 = 1;
    L24:
        r108.f569363b = r104;     // Catch: Exception -> L26
    L28:
        int r109 = r108.f569363b;
        d r110 = r100.f561741b;     // Catch: Exception -> L31
        ConditionState.a r111 = new ConditionState.a();     // Catch: Exception -> L31
        r111.f409781a = r102;     // Catch: Exception -> L31
        r111.f409782b = r107;     // Catch: Exception -> L31
        r111.f409783c = r109;     // Catch: Exception -> L31
        r111.f409784d = r106;     // Catch: Exception -> L31
        r110.a(new ConditionState(r111));     // Catch: Exception -> L31
        return;
    L31:
        e = move-exception;
        Log.e("BatteryMonitor", "failed to BatteryStrategyProxy execute, e:" + e);
        return;
    L16:
        r105 = ((WifiManager) r103.getApplicationContext().getSystemService("wifi")).isWifiEnabled();
        goto L17
    L8:
        long r112 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L34
        if ((r112 - r101.f573860d) <= r101.f573858b) goto L11;
        r101.f573859c = 2;     // Catch: Throwable -> L34
        Log.i("BatteryMonitor", zwa.b.class.getSimpleName() + " bgtime is " + (r112 - r101.f573860d) + " ,mBgStateChangeInterval is " + r101.f573858b + " ，set current status is ConditionState.AppState.BACKGROUND_5_MINUTE");     // Catch: Throwable -> L34
    L11:
        r102 = r101.f573859c;     // Catch: Throwable -> L34
        monitor-exit(r101);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    @Override // wwa.a
    public final void a(Context r100) {
        if (this.f561747h == false) goto L6;
        Log.i("BatteryMonitor", " BatteryMonitorManager Create have called.");
        return;
    L6:
        boolean r101 = true;
        this.f561747h = true;
        if (r100 != null) goto L9;
        Log.e("BatteryMonitor", "BatteryMonitorManager create called. context is null.");
    L54:
        r101 = false;
    L56:
        if (r101 == true) goto L58;
        return;
    L58:
        super.a(r100);
        return;
    L9:
        Log.i("BatteryMonitor", "BatteryUtils current process: " + z.b(r100));
        if (o0.a(r100) == true) goto L25;
        String r102 = z.b(r100);
        if (TextUtils.isEmpty(r102) == false) goto L14;
    L18:
        boolean r103 = false;
    L19:
        if (r103 == true) goto L25;
        if (o0.c(r100) == true) goto L25;
        boolean r104 = true;
    L26:
        if (r104 == false) goto L28;
        Log.e("BatteryMonitor", "BatteryMonitorManager create called. current process cannot support battery monitor.");
        goto L54
    L28:
        ScheduledExecutorService r105 = CoreThreadPool.getDefault().getScheduleThreadPool();
        this.f561742c = r105;
        if (r105 != null) goto L31;
        Log.e("BatteryMonitor", "BatteryMonitorManager getScheduledThreadPool failed.");
        goto L54
    L31:
        Log.i("BatteryMonitor", "BatteryStrategyProxy execute called. current process: " + z.b(r100));
        ArrayList r106 = new ArrayList();
        Iterator r107 = ClaymoreServiceLoader.loadAll(AbsBatteryStrategy.class);
    L33:
        if (r107.hasNext() == false) goto L38;
        AbsBatteryStrategy r108 = (AbsBatteryStrategy) r107.next();
        if (r108.b() == false) goto L33;
        r106.add(r108);
        goto L33
    L38:
        if (CollectionUtils.isEmpty(r106) == false) goto L40;
        d r109 = null;
    L51:
        this.f561741b = r109;
        if (r109 != null) goto L55;
        Log.e("BatteryMonitor", "BatteryMonitorManager create batteryStrategyProxy object failed!");
        goto L54
    L55:
        this.f561745f = o0.c(r100);
        goto L56
    L40:
        if (r106.size() > 1) goto L49;
        ArrayList r110 = new ArrayList();
        Iterator r111 = ClaymoreServiceLoader.loadAll(xwa.a.class);
    L43:
        if (r111.hasNext() == false) goto L47;
        xwa.a r112 = (xwa.a) r111.next();
        if (r112.c(r100) == false) goto L43;
        r110.add(r112);
        goto L43
    L47:
        r109 = new d(r106, r110);
        goto L51
    L49:
        throw new RuntimeException("too many process battery strategy");
    L14:
        if (r102.contains(":miniapp") == false) goto L16;
    L17:
        r103 = true;
        goto L19
    L16:
        if (r102.contains(":oryx") == false) goto L18;
    L25:
        r104 = false;
        goto L26
    }

    public final void e(long r100) {
        Log.i("BatteryMonitor", "addScheduleTaskOnce called. delay:" + r100);     // Catch: Exception -> L5
        this.f561743d = this.f561742c.schedule(this.f561744e, r100, TimeUnit.SECONDS);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("BatteryMonitor", "failed to add schedule task. e:" + e);
        this.f561743d = null;
    }

    public final void f(long r100) {
        monitor-enter(this);
        Log.i("BatteryMonitor", "BatteryMonitorManager scheduleExecuteTask called.");     // Catch: Throwable -> L11
        ScheduledFuture r101 = this.f561743d;     // Catch: Throwable -> L11
        if (r101 != null) goto L6;
    L8:
        this.f561746g = 5;     // Catch: Throwable -> L11
        e(r100);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L6:
        if (r101.isDone() == true) goto L8;
        Log.i("BatteryMonitor", "BatteryMonitorManager cancel undo future task ");     // Catch: Throwable -> L11
        this.f561743d.cancel(true);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Observer
    public void update(Observable r100, Object r101) {
        Log.i("BatteryMonitor", " BatteryMonitorManager update called. condition is changed.");
        this.f561742c.execute(new a(this));
    }
}
