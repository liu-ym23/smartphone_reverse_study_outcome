package esb;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.h;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import com.ss.android.lark.monitor.i;
import com.ss.android.lark.monitor.memory.MemoryInfoUtil;
import com.ss.android.lark.monitor.memory.MemoryMetrics;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends com.ss.android.lark.monitor.e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f473802i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, MemoryMetrics> f473803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<c> f473804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f473805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScheduledFuture<?> f473806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ScheduledFuture<?> f473807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f473808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f473809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f473810h;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f473811a;

        @Override // java.lang.Runnable
        public final void run() {
            b.a(this.f473811a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100) {
            this.f473811a = r100;
        }
    }

    /* JADX INFO: renamed from: esb.b$b, reason: collision with other inner class name */
    public class RunnableC5814b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f473812a;

        @Override // java.lang.Runnable
        public final void run() {
            b.b(this.f473812a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC5814b(b r100) {
            this.f473812a = r100;
        }
    }

    public interface c {
        void a(int r100);
    }

    public final void f() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f473806d == null) goto L8;
        Log.i("MemoryPerfMonitor", "java mem reach top task has already started");     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L8:
        this.f473806d = CoreThreadPool.getDefault().getScheduleThreadPool().scheduleWithFixedDelay(new RunnableC5814b(this), 60, 60, TimeUnit.SECONDS);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public final void g() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f473807e == null) goto L8;
        Log.i("MemoryPerfMonitor", "memory monitor period task has already started");     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L8:
        this.f473807e = CoreThreadPool.getDefault().getScheduleThreadPool().scheduleWithFixedDelay(new a(this), 1, 8, TimeUnit.SECONDS);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public final void h() {
        monitor-enter(this);
        ScheduledFuture<?> r100 = this.f473806d;     // Catch: Throwable -> L11
        if (r100 != null) goto L8;
        Log.i("MemoryPerfMonitor", "java mem reach top task has already stoped");     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L8:
        r100.cancel(true);     // Catch: Throwable -> L11
        this.f473806d = null;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.monitor.e
    public final void pauseScene(String r100) {
    }

    public final boolean e() {
        if (this.f473810h != (-1)) goto L17;
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L7;
    L15:
        this.f473810h = 0;
        goto L17
    L7:
        if (ApmDelegate.g.f190592a.f190575f == true) goto L9;
    L12:
        boolean r100 = true;
    L13:
        if (r100 == false) goto L15;
        this.f473810h = 1;
        goto L17
    L9:
        if (zs3.c.f573475a.getServiceSwitch("scene_memory_info") == true) goto L12;
        r100 = false;
    L17:
        if (this.f473810h != 1) goto L20;
        return true;
    L20:
        return false;
    }

    public b(i r100) {
        super(r100);
        this.f473803a = new ConcurrentHashMap();
        this.f473804b = new ArrayList();
        this.f473805c = (int) (Runtime.getRuntime().maxMemory() / 1048576);
        this.f473808f = 0;
        this.f473809g = Process.myPid();
        this.f473810h = -1;
        f();
        g();
        r100.f432397a.registerComponentCallbacks(new e(this, r100));
        if (iu3.a.f495772a == null) goto L5;
    L14:
        iu3.a r101 = iu3.a.f495772a;
        lu3.a r102 = new esb.a();
        r101.getClass();
        int r103 = iu3.d.f495774h;
        ((CopyOnWriteArrayList) iu3.d.a.f495782a.f495781g).add(r102);
        return;
    L5:
        monitor-enter(iu3.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (iu3.a.f495772a != null) goto L9;
        iu3.a.f495772a = new iu3.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(iu3.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void a(b r100) {
        Object r101 = r100.mMetricsConfig.f432397a.getSystemService("activity");
        if (r101 != null) goto L5;
        Log.w("MemoryPerfMonitor", "context is null");
        return;
    L5:
        List<ActivityManager.RunningAppProcessInfo> r102 = ((ActivityManager) r101).getRunningAppProcesses();
        if (r102 != null) goto L8;
        Log.w("MemoryPerfMonitor", "runningAppProcesses is null");
        r100.d(r100.f473809g, r100.mMetricsConfig.f432401e);
        return;
    L8:
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L21;
        ActivityManager.RunningAppProcessInfo r104 = r103.next();
        if (r104.processName.startsWith(r100.mMetricsConfig.f432397a.getPackageName()) == false) goto L10;
        r100.d(r104.pid, r104.processName);
        goto L10
    }

    public static void b(b r100) {
        monitor-enter(r100);
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L31
        if ((r101 - r100.f473808f) >= 5000) goto L8;
        Log.w("MemoryPerfMonitor", "Less than 5 seconds since last check!");     // Catch: Throwable -> L31
        monitor-exit(r100);     // Catch: Throwable -> L31
        return;
    L8:
        r100.f473808f = r101;     // Catch: Throwable -> L31
        int r102 = MemoryInfoUtil.getUsedJavaHeapMB();     // Catch: Throwable -> L31
        Iterator<c> r103 = r100.f473804b.iterator();     // Catch: Throwable -> L31
    L10:
        if (r103.hasNext() == false) goto L13;
        r103.next().a(r102);     // Catch: Throwable -> L31
        goto L10
    L13:
        float r104 = r102 / r100.f473805c;
        MemoryCallbackManager.getInstance().notifyJavaMemoryUsedRate(r104);     // Catch: Throwable -> L16
    L18:
        double r105 = r104;
        if (r105 < 0.65d) goto L24;
        if (f473802i == true) goto L24;
        f473802i = true;     // Catch: Throwable -> L31
        Intent r106 = new Intent();     // Catch: Throwable -> L31
        r106.setAction("com.ss.android.lark.DUMP_HPROF");     // Catch: Throwable -> L31
        r106.setPackage(r100.mMetricsConfig.f432397a.getPackageName());     // Catch: Throwable -> L31
        r106.putExtra("auto_upload", true);     // Catch: Throwable -> L31
        r100.mMetricsConfig.f432397a.sendBroadcast(r106);     // Catch: Throwable -> L31
        Log.i("MemoryPerfMonitor", "usedJavaMemoryRate:" + r104 + ", auto dump hprof");     // Catch: Throwable -> L31
    L24:
        if (r105 < 0.8d) goto L29;
        MemoryMetrics r107 = r100.f473803a.get(MonitorModule.e().d());     // Catch: Throwable -> L31
        if (r107 == null) goto L28;
        r107.reachTopCount++;     // Catch: Throwable -> L31
    L28:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new g(r100));     // Catch: Throwable -> L31
    L29:
        monitor-exit(r100);     // Catch: Throwable -> L31
        return;
    L16:
        th = move-exception;
        Log.e("MemoryPerfMonitor", "notifyJavaMemoryUsedRate error", th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public static void c(MemoryMetrics r100) {
        r100.javaHeapMB = (int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576);
        r100.nativeHeapMB = (int) (Debug.getNativeHeapSize() / 1048576);
        r100.maxMemMB = (int) (Runtime.getRuntime().maxMemory() / 1048576);
        r100.totalMemMB = r100.javaHeapMB + r100.nativeHeapMB;
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r100.gcCount = CastIntegerProtector.parseInt(Debug.getRuntimeStat("art.gc.gc-count"));
        return;
    }

    @Override // com.ss.android.lark.monitor.d
    public final void onAppFrontStateChanged(boolean r100) {
        if (r100 == false) goto L4;
        f();
        g();
        return;
    L4:
        monitor-enter(this);
        ScheduledFuture<?> r101 = this.f473807e;     // Catch: Throwable -> L14
        if (r101 != null) goto L10;
        Log.i("MemoryPerfMonitor", "memory monitor period task has already stoped");     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L12:
        h();
        return;
    L10:
        r101.cancel(true);     // Catch: Throwable -> L14
        this.f473807e = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.monitor.e
    public final void startScene(String r100) {
        if (this.f473803a.containsKey(r100) == false) goto L5;
        return;
    L5:
        MemoryMetrics r101 = new MemoryMetrics();
        c(r101);
        this.f473803a.put(r100, r101);
    }

    public final void d(int r100, String r101) {
        Context r102 = this.mMetricsConfig.f432397a;
        if (r102 != null) goto L6;
        Log.w("MemoryPerfMonitor", "context is null");
        return;
    L6:
        Debug.MemoryInfo[] r103 = ((ActivityManager) r102.getSystemService("activity")).getProcessMemoryInfo(new int[]{r100});
        if (r103 != null) goto L9;
    L17:
        Log.w("MemoryPerfMonitor", "processMemoryInfo is illegal");
        return;
    L9:
        if (r103.length == 0) goto L17;
        Debug.MemoryInfo r104 = r103[0];
        if (r104 != null) goto L15;
        Log.w("MemoryPerfMonitor", "memoryInfo is null");
        return;
    L15:
        Log.i("ScenePerfMonitor", "process: " + r101 + ",TotalPss:" + (r104.getTotalPss() / 1024) + "(M),NativeMem:" + (r104.nativePss / 1024) + ",JavaMem:" + (r104.dalvikPss / 1024));
    }

    @Override // com.ss.android.lark.monitor.e
    public final void stopScene(String r100, JSONObject r101) {
        String r102 = r100.split("#hash")[0];
        MemoryMetrics r103 = this.f473803a.remove(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        long r104 = System.currentTimeMillis() - r103.createTime;
        if (r104 >= 500) goto L10;
        Log.d("MemoryPerfMonitor", "scene time less than 50ms:" + r102);
        return;
    L10:
        if (DevicePerfUtils.f() == true) goto L12;
        boolean r105 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.android.crash.disable_oppo_android15_explicit_gc_guard");
        int r106 = h.f285996a;
        Intrinsics.checkNotNullParameter("monitor_stop_scene", "reason");
        h.b("monitor_stop_scene", r105, false);
    L12:
        MemoryMetrics r107 = new MemoryMetrics();
        c(r107);
        MemoryMetrics r108 = r107.diff(r103);
        r108.reachTopCount = r103.reachTopCount;
        Log.i("ScenePerfMonitor", "End Scene:" + r102 + ",start Meminfo:" + r103 + ", diff Meminfo: " + r108 + ", spanTime(ms): " + r104);
        if (r108.javaHeapMB >= 20) goto L15;
        return;
    L15:
        if (r108.reachTopCount >= 1) goto L17;
        return;
    L17:
        if (e() == false) goto L31;
        JSONObject r109 = new JSONObject();     // Catch: JSONException -> L24
        r109.put("scene", r102);     // Catch: JSONException -> L24
        r109.put("startJavaMem", r103.javaHeapMB);     // Catch: JSONException -> L24
        r109.put("javaMem", r108.javaHeapMB);     // Catch: JSONException -> L24
        r109.put("startNativeMem", r103.nativeHeapMB);     // Catch: JSONException -> L24
        r109.put("nativeMem", r108.nativeHeapMB);     // Catch: JSONException -> L24
        r109.put("spanTime", r104);     // Catch: JSONException -> L24
        r109.put("reachTopCount", r108.reachTopCount);     // Catch: JSONException -> L24
        if (r104 <= 1000) goto L22;
        r109.put("gcRate", r108.gcCount / (r104 / 1000.0f));     // Catch: JSONException -> L24
    L22:
        r109.put("gcCount", r108.gcCount);     // Catch: JSONException -> L24
        isb.a.a(r109, r101);     // Catch: JSONException -> L24
        isb.a.c("scene_memory_info", r109);     // Catch: JSONException -> L24
        return;
    L24:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
