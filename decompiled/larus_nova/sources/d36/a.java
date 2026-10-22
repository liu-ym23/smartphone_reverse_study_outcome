package d36;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import bolts.Continuation;
import bolts.Task;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f466716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ScheduledExecutorService> f466717b = null;

    /* JADX INFO: renamed from: d36.a$a, reason: collision with other inner class name */
    public static final class CallableC5623a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d36.c f466718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f466719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f466720c;

        public CallableC5623a(d36.c r100, String r101, String r102) {
            this.f466718a = r100;
            this.f466719b = r101;
            this.f466720c = r102;
        }

        @Override // java.util.concurrent.Callable
        public final Unit call() {
            Long r100 = (Long) ((HashMap) a.b()).get("mem_java_used");
            if (r100 == null) goto L7;
            d36.c r101 = this.f466718a;
            String r102 = this.f466719b;
            String r103 = this.f466720c;
            long r104 = r100.longValue();
            if (r101 == null) goto L7;
            r101.b(r102, r103, r104);
        L7:
            Double r105 = (Double) ((HashMap) a.a()).get("cpu_rate");
            if (r105 == null) goto L13;
            d36.c r106 = this.f466718a;
            String r107 = this.f466719b;
            String r108 = this.f466720c;
            double r109 = r105.doubleValue();
            if (r106 == null) goto L13;
            r106.a(r107, r108, r109);
        L13:
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class b<TTaskResult, TContinuationResult> implements Continuation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BulletContext f466721a;

        public b(BulletContext r100) {
            this.f466721a = r100;
        }

        @Override // bolts.Continuation
        public final Object then(Task r100) {
            BulletContext r101 = this.f466721a;
            if (r101 == null) goto L8;
            AbsBulletMonitorCallback r102 = r101.f246435c;
            if (r102 == null) goto L8;
            r102.o();
        L8:
            return Unit.INSTANCE;
        }
    }

    public static final class c<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d36.c f466722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f466723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f466724c;

        public c(d36.c r100, String r101, String r102) {
            this.f466722a = r100;
            this.f466723b = r101;
            this.f466724c = r102;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            Long r100 = (Long) ((HashMap) a.b()).get("mem_java_used");
            if (r100 == null) goto L7;
            d36.c r101 = this.f466722a;
            String r102 = this.f466724c;
            String r103 = this.f466723b;
            long r104 = r100.longValue();
            if (r101 == null) goto L7;
            r101.b(r102, r103, r104);
        L7:
            d36.c r105 = this.f466722a;
            Object r106 = null;
            if (r105 == null) goto L10;
            Map<String, Long> r107 = r105.f466732d;
        L11:
            Intrinsics.checkNotNull(r107);
            Long r108 = r107.get("initTime");
            Long r109 = r107.get("appCpuStat");
            Long r110 = r107.get("totalCpuStat");
            long r111 = com.bytedance.apm.util.b.a();
            long r112 = com.bytedance.apm.util.b.j();
            double r113 = -1.0d;
            if (r108 != null) goto L14;
        L25:
            double r114 = -1.0d;
        L26:
            HashMap r115 = new HashMap();
            r115.put("cpu_rate", Double.valueOf(r113));
            r115.put("cpu_speed", Double.valueOf(r114));
            Double r116 = (Double) r115.get("cpu_rate");
            if (r116 == null) goto L30;
            this.f466722a.a(this.f466724c, this.f466723b, r116.doubleValue());
        L30:
            if (Intrinsics.areEqual(this.f466723b, "view_page_start") == false) goto L38;
            Application r117 = h.f246501h.f246503b;
            if (r117 == null) goto L34;
            r106 = r117.getSystemService("activity");
        L34:
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.app.ActivityManager");
            HashMap r118 = new HashMap();
            ActivityManager.MemoryInfo r119 = new ActivityManager.MemoryInfo();
            ((ActivityManager) r106).getMemoryInfo(r119);
            long r120 = 1024;
            r118.put("MEM_DEVICE_TOTAL", Long.valueOf(r119.totalMem / r120));
            r118.put(IPerformanceManager.MEM.mem_device_threshold, Long.valueOf(r119.threshold / r120));
            r118.put("mem_device_avail", Long.valueOf(r119.availMem / r120));
            Long r121 = (Long) r118.get("MEM_DEVICE_TOTAL");
            if (r121 == null) goto L39;
            this.f466722a.b(this.f466724c, "device_totalmem", r121.longValue());
            return;
        L39:
            return;
        L38:
            return;
        L14:
            if (r108.longValue() <= 0) goto L25;
            if (r109 == null) goto L25;
            if (r109.longValue() <= 0) goto L25;
            if (r110 == null) goto L25;
            if (r110.longValue() <= 0) goto L25;
            if ((r112 - r110.longValue()) <= 0) goto L24;
            r113 = (r111 - r109.longValue()) / (r112 - r110.longValue());
        L24:
            r114 = (((r111 - r109.longValue()) * ((double) 1000)) / (System.currentTimeMillis() - r108.longValue())) / com.bytedance.apm.util.b.f();
            goto L26
        L10:
            r107 = null;
            goto L11
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    static {
        f466716a = -1;
        f466717b = new ConcurrentHashMap();
    }

    public static Map b() {
        HashMap r100 = new HashMap();
        long r101 = Runtime.getRuntime().totalMemory();
        long r102 = Runtime.getRuntime().freeMemory();
        long r103 = 1024;
        r100.put("mem_java_total", Long.valueOf(r101 / r103));
        r100.put("mem_java_free", Long.valueOf(r102 / r103));
        r100.put("mem_java_used", Long.valueOf((r101 - r102) / r103));
        return r100;
    }

    public static Map a() {
        st3.a.b().getClass();
        ts3.a r100 = st3.a.a();
        HashMap r101 = new HashMap();
        r101.put("cpu_rate", Double.valueOf(r100.f547363a));
        r101.put("cpu_speed", Double.valueOf(r100.f547364b));
        return r101;
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Lazy<BulletContextManager> r101 = BulletContextManager.f246459b;
        BulletContext r102 = BulletContextManager.a.a().getContext(r100);
        String r103 = null;
        if (r102 == null) goto L7;
        com.bytedance.ies.bullet.core.e r104 = r102.f246455w;
        if (r104 == null) goto L7;
        Object r105 = r104.f246482j;
    L9:
        if ((r105 instanceof d36.c) == false) goto L11;
        d36.c r106 = (d36.c) r105;
    L12:
        if (r106 == null) goto L48;
        AtomicBoolean r107 = r106.f466731c;
        if (r107 != null) goto L16;
    L18:
        boolean r108 = false;
    L19:
        if (r108 == true) goto L49;
        Application r109 = h.f246501h.f246503b;
        if (r109 == null) goto L24;
        Object r110 = r109.getSystemService("activity");
    L25:
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.RunningTaskInfo r111 = (ActivityManager.RunningTaskInfo) ListProtector.get(((ActivityManager) r110).getRunningTasks(1), 0);     // Catch: Exception -> L28
    L30:
        long r112 = System.currentTimeMillis();
        if (r111 == null) goto L33;
        ComponentName r113 = r111.baseActivity;
    L34:
        if (r111 == null) goto L36;
        ComponentName r114 = r111.topActivity;
    L37:
        StringBuilder r115 = new StringBuilder();
        r115.append("time:" + r112 + ',');
        StringBuilder r116 = new StringBuilder("Running TaskInfo:topActivity=");
        if (r114 == null) goto L40;
        String r117 = r114.toShortString();
    L41:
        r116.append(r117);
        r116.append(",baseActivity=");
        if (r113 == null) goto L44;
        r103 = r113.toShortString();
    L44:
        r116.append(r103);
        r116.append(',');
        r115.append(r116.toString());
        String r118 = r115.toString();
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r106.f466733e = r118;
        return;
    L40:
        r117 = null;
        goto L41
    L36:
        r114 = null;
        goto L37
    L33:
        r113 = null;
    L28:
        e = move-exception;
        ExecutorService r119 = BulletLogger.f247763a;
        BulletLogger.l(e, "recordActivityInfo exception", "CpuMemoryHelper");
        r111 = null;
        goto L30
    L24:
        r110 = null;
        goto L25
    L49:
        return;
    L16:
        if (r107.get() == true) goto L18;
        r108 = true;
        goto L19
    L48:
        return;
    L11:
        r106 = null;
    L7:
        r105 = null;
        goto L9
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "stepName");
        Lazy<BulletContextManager> r102 = BulletContextManager.f246459b;
        BulletContext r103 = BulletContextManager.a.a().getContext(r100);
        boolean r104 = false;
        if (r103 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L10;
        return;
    L10:
        d36.c r106 = null;
        if (r103 == null) goto L15;
        com.bytedance.ies.bullet.core.e r107 = r103.f246455w;
        if (r107 == null) goto L15;
        Object r108 = r107.f246482j;
    L17:
        if ((r108 instanceof d36.c) == false) goto L19;
        r106 = (d36.c) r108;
    L19:
        if (r106 == null) goto L35;
        AtomicBoolean r109 = r106.f466731c;
        if (r109 != null) goto L23;
    L25:
        if (r104 == true) goto L37;
        long r110 = f466716a;
        if (r110 == (-1)) goto L31;
        r106.b(r100, "memory_warning", r110);
    L31:
        if (Intrinsics.areEqual(r101, "view_load_cancel") == false) goto L33;
        Task.callInBackground(new CallableC5623a(r106, r100, r101)).onSuccess(new b(r103));
        return;
    L33:
        Task.callInBackground(new c(r106, r101, r100));
        return;
    L37:
        return;
    L23:
        if (r109.get() == true) goto L25;
        r104 = true;
        goto L25
    L35:
        return;
    L15:
        r108 = null;
        goto L17
    L5:
        if (r103.B != true) goto L7;
        r105 = true;
        goto L8
    }

    public static boolean e(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "userInterActiveKey");
        boolean r102 = false;
        if (r100 == false) goto L19;
        Iterator<String> r103 = f466717b.keySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L17;
        String r104 = r103.next();
        ConcurrentHashMap<String, ScheduledExecutorService> r105 = f466717b;
        ScheduledExecutorService r106 = r105.get(r101);
        if (r106 != null) goto L10;
    L12:
        boolean r107 = false;
    L13:
        if (r107 == true) goto L6;
        ScheduledExecutorService r108 = r105.get(r104);
        if (r108 == null) goto L6;
        r108.shutdownNow();
        goto L6
    L10:
        if (r106.isShutdown() != true) goto L12;
        r107 = true;
        goto L13
    L17:
        f466717b.clear();
        return true;
    L19:
        ConcurrentHashMap<String, ScheduledExecutorService> r109 = f466717b;
        if (r109.get(r101) != null) goto L22;
        return false;
    L22:
        ScheduledExecutorService r110 = r109.get(r101);
        if (r110 != null) goto L25;
    L27:
        if (r102 == true) goto L33;
        ScheduledExecutorService r111 = r109.get(r101);
        if (r111 == null) goto L32;
        r111.shutdownNow();
    L32:
        r109.remove(r101);
    L33:
        return true;
    L25:
        if (r110.isShutdown() != true) goto L27;
        r102 = true;
        goto L27
    }
}
