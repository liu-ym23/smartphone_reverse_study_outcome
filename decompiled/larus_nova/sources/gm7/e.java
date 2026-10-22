package gm7;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ug.sdk.luckydog.api.task.taskmanager.ActionTaskManager;
import com.bytedance.ug.sdk.luckydog.task.newTimer.TaskReShowCallback;
import com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.NormalTimerTaskExecutor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ym7.m;
import ym7.n;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends uo7.c implements ym7.b {
    public static final String A = null;
    public static final e B = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f481697a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f481698b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicLong f481699c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f481700d = "luckydog_timer_task_config_pref";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f481701e = "luckydog_task_timer_config";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f481702f = "account_refresh_id_white_list";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f481703g = "account_refresh_switch";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f481704h = "luckydog_has_settings_updated";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f481705i = "default";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicBoolean f481706j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Runnable f481707k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CopyOnWriteArraySet<Runnable> f481708l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Stack<com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a> f481709m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f481710n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f481711o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AtomicInteger f481712p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f481713q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f481714r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static n f481715s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f481716t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ConcurrentHashMap<String, m> f481717u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static ArrayList<String> f481718v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f481719w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f481720x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f481721y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final AtomicBoolean f481722z = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"gm7/e$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "", "luckydog-task_release"}, k = 1, mv = {1, 4, 0})
    public static final class a extends TypeToken<ArrayList<String>> {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<FrameLayout> f481723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<FrameLayout.LayoutParams> f481724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f481725c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f481726d;

        @Override // java.lang.Runnable
        public final void run() {
            FrameLayout r100 = this.f481723a.get();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            e r101 = e.B;     // Catch: Throwable -> L6
            String r102 = this.f481725c;     // Catch: Throwable -> L6
            FrameLayout.LayoutParams r103 = this.f481724b.get();     // Catch: Throwable -> L6
            int r104 = this.f481726d;     // Catch: Throwable -> L6
            r101.getClass();     // Catch: Throwable -> L6
            e.D(r102, r100, r103, r104);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(String r100, FrameLayout r101, FrameLayout.LayoutParams r102, int r103) {
            this.f481725c = r100;
            this.f481726d = r103;
            this.f481723a = new WeakReference(r101);
            this.f481724b = new WeakReference(r102);
        }
    }

    public static final class c implements gm7.a.InterfaceC6036a {
        public c() {
        }

        @Override // gm7.a.InterfaceC6036a
        public final void a(Set r110) {
            e.B.getClass();
            AtomicInteger r100 = e.f481712p;
            if (r100.get() != 30) goto L5;
            r100.set(0);
            e.l();
        L5:
            boolean r101 = true;
            r100.getAndAdd(1);
            Iterator r102 = new HashSet(r110).iterator();
        L7:
            if (r102.hasNext() == false) goto L54;
            String r103 = (String) r102.next();
            Iterator<T> r104 = e.f481709m.iterator();
        L10:
            if (r104.hasNext() == false) goto L7;
            com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a r105 = (com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a) r104.next();
            String r106 = r105.c().f546539a;
            Integer r107 = e.f481710n.get(r106);
            if (r107 != null) goto L15;
            r107 = 0;
        L15:
            int r108 = r107.intValue();
            Iterator r109 = StringsKt.split$default(r105.c().f546546h.optString(InvRouter.SCENES), new String[]{","}, false, 0, 6, null).iterator();
            boolean r111 = true;
        L17:
            if (r109.hasNext() == false) goto L37;
            if (Intrinsics.areEqual((String) r109.next(), r103) == false) goto L17;
            if (r111 == false) goto L17;
            r108 = r108 + 1;
            tk7.a r112 = r105.c();
            if (r112 == null) goto L26;
            JSONObject r113 = r112.f546546h;
            if (r113 == null) goto L26;
            int r114 = r113.optInt("total_report_count");
        L27:
            tk7.a r115 = r105.c();
            if (r115 == null) goto L32;
            JSONObject r116 = r115.f546546h;
            if (r116 == null) goto L32;
            int r117 = r116.optInt("report_interval");
        L33:
            int r118 = r114 * r117;
            if (r118 > r108) goto L36;
            r108 = r118;
        L36:
            r111 = false;
        L32:
            r117 = 0;
        L26:
            r114 = 0;
            goto L27
        L37:
            e.f481710n.put(r106, Integer.valueOf(r108));
            NormalTimerTaskExecutor r119 = (NormalTimerTaskExecutor) r105;
            if (r119.f272238o.get() == true) goto L44;
            r119.f272238o.set(r101);
            int r120 = gm7.c.f481693a;
            gm7.c.c("luckydog_countdown_start_timing", null, r119.c());     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            com.bytedance.ug.sdk.luckydog.api.log.d.c("LuckyTimerTaskEvent", com.bytedance.ug.sdk.luckydog.api.task.taskmanager.d.a("luckyDogCountdownStartTimingEvent", th.getLocalizedMessage()), th);
        L44:
            long r121 = System.currentTimeMillis();
            if (r119.f272225b.get() < r119.c().f546546h.optInt("total_report_count")) goto L47;
            com.bytedance.ug.sdk.luckydog.api.log.d.a("NormalTimerTaskExecutor", "reportProgress currentCount >= totalReportCount currentCount = " + r119.f272225b.get());
        L50:
            boolean r122 = false;
        L51:
            if (r122 == false) goto L53;
            com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "reportProgress call");
            int r123 = r119.c().f546546h.optInt("total_report_count");
            int r124 = (r119.f272226c.get() - (r123 - r119.c().f546546h.optInt("remaining_report_count"))) + (r101 ? 1 : 0);
            r119.f272226c.getAndAdd(r101 ? 1 : 0);
            e r125 = e.B;
            com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.d r126 = new com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.d(r119, r108, r124, r121, r123);
            r125.getClass();
            e.A(r124, r121, r119, r126);
        L53:
            r119.s(r119.o(r108), r108);
            r101 = true;
            goto L10
        L47:
            int r127 = r119.c().f546546h.optInt("report_interval") * (r119.f272226c.get() + (r101 ? 1 : 0));
            com.bytedance.ug.sdk.luckydog.api.log.d.a("NormalTimerTaskExecutor", " nextReportTime = " + r127 + " progress = " + r108);
            if (r108 < r127) goto L50;
            r122 = true;
            goto L51
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f481727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f481728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f481729c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f481730d;

        public d(String r100, FrameLayout r101, FrameLayout.LayoutParams r102, int r103) {
            this.f481727a = r100;
            this.f481728b = r101;
            this.f481729c = r102;
            this.f481730d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "showTimerPendant pending show");     // Catch: Throwable -> L4
            e r100 = e.B;     // Catch: Throwable -> L4
            String r101 = this.f481727a;     // Catch: Throwable -> L4
            FrameLayout r102 = this.f481728b;     // Catch: Throwable -> L4
            FrameLayout.LayoutParams r103 = this.f481729c;     // Catch: Throwable -> L4
            int r104 = this.f481730d;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            e.C(r101, r102, r103, r104);     // Catch: Throwable -> L4
            e.f481707k = null;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: gm7.e$e, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes22.dex */
    public static final class RunnableC6038e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RunnableC6038e f481731a = null;

        static {
            f481731a = new RunnableC6038e();
        }

        public RunnableC6038e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<Runnable> r100 = e.f481708l.iterator();     // Catch: Throwable -> L8
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().run();     // Catch: Throwable -> L8
            goto L4
        L6:
            e.f481708l.clear();     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }
    }

    static {
        e r100 = new e();
        B = r100;
        f481699c = new AtomicLong(86400000);
        f481700d = "luckydog_timer_task_config_pref";
        f481701e = "luckydog_task_timer_config";
        f481702f = "account_refresh_id_white_list";
        f481703g = "account_refresh_switch";
        f481704h = "luckydog_has_settings_updated";
        f481705i = "default";
        f481706j = new AtomicBoolean(false);
        f481708l = new CopyOnWriteArraySet();
        f481709m = new Stack();
        f481710n = new ConcurrentHashMap();
        f481711o = new ConcurrentHashMap();
        f481712p = new AtomicInteger(0);
        f481714r = "";
        f481717u = new ConcurrentHashMap();
        Application r101 = rk7.m.f538347a;
        f481721y = rk7.m.j();
        f481722z = new AtomicBoolean(false);
        A = "key_task_pendant";
        gm7.a.f481676c = new c();
        to7.c.d(r100);
        il7.m r102 = il7.m.b("luckydog_timer_task_config_pref");
        Boolean r103 = Boolean.FALSE;
        f481720x = r102.f("account_refresh_switch", r103);
        f481719w = il7.m.b("luckydog_timer_task_config_pref").f("luckydog_has_settings_updated", r103);
        f481718v = (ArrayList) new Gson().fromJson(il7.m.b("luckydog_timer_task_config_pref").e("account_refresh_id_white_list", ""), new a().getType());     // Catch: Throwable -> L5
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "init onCall, accountRefreshSwitch: " + f481720x + ", accountRefreshIdWhiteList: " + f481718v);
        return;
    L5:
        th = move-exception;
        th.getLocalizedMessage();
        goto L7
    }

    public static void l() {
        Iterator<T> r100 = f481709m.iterator();
    L4:
        if (r100.hasNext() == false) goto L41;
        com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a r101 = (com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a) r100.next();
        e r102 = B;
        r102.getClass();
        if (r101 != null) goto L42;
    L30:
        JSONObject r103 = null;
    L31:
        monitor-enter(r102);
        if (r103 == null) goto L39;
        il7.m.b("timer_task_cached").k("timer_task_progress", r103.toString());     // Catch: Throwable -> L36
        monitor-exit(r102);
    L36:
        th = move-exception;
        throw th;
    L39:
        monitor-exit(r102);
        goto L4
    L42:
        if (r101.c().f546546h.optInt("persistent_type") != 1) goto L30;
        long r104 = r101.c().f546546h.optLong("expire_time");     // Catch: Exception -> L28
        String r105 = r101.c().f546539a;     // Catch: Exception -> L28
        String r106 = "";
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        Integer r107 = f481710n.get(r105);     // Catch: Exception -> L28
        if (r107 != null) goto L19;
        r107 = 0;     // Catch: Exception -> L28
    L19:
        int r108 = r107.intValue();     // Catch: Exception -> L28
        String r109 = f481711o.get(r105);     // Catch: Exception -> L28
        if (r109 == null) goto L22;
        String r110 = r109;
    L23:
        String r111 = r105;
        hm7.f r112 = new hm7.f(r104, r111, Integer.valueOf(r108), r110);     // Catch: Exception -> L28
        String r113 = new Gson().toJson(r112, hm7.f.class);     // Catch: Exception -> L28
        if (r113 == null) goto L26;
        r106 = r113;
    L26:
        r103 = r().put(r105, r106);     // Catch: Exception -> L28
        goto L31
    L22:
        r110 = "";
    L28:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("TimerTaskManager", com.bytedance.ug.sdk.luckydog.api.task.taskmanager.d.a("getCacheDateByExecutor()", e.getLocalizedMessage()), e);
        goto L30
    }

    public final void y() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "tryInit() TimerTaskManager registerPendantExclusionListener called; 触发内部init方法执行");
        wm7.g.b(ym7.d.class, new com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.c());
        ym7.d r100 = (ym7.d) wm7.g.a(ym7.d.class);
        if (r100 == null) goto L5;
        r100.a(this);
    L5:
        f481722z.set(true);
        if (f481716t == false) goto L14;
        Iterator<Map.Entry<String, m>> r101 = f481717u.entrySet().iterator();
    L9:
        if (r101.hasNext() == false) goto L11;
        r101.next().getValue().a();
        goto L9
    L11:
        f481716t = false;
        f481717u.clear();
        return;
    }

    public static JSONObject r() {
        String r100 = il7.m.b("timer_task_cached").e("timer_task_progress", "");     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r100) == false) goto L6;
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L7
    L10:
        return r101;
    L6:
        r101 = new JSONObject(r100);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("TimerTaskManager", com.bytedance.ug.sdk.luckydog.api.task.taskmanager.d.a("getCachedTask()", th.getLocalizedMessage()), th);
        return new JSONObject();
    }

    public static Activity s() {
        Activity[] r100 = to7.c.a();
        int r101 = r100.length - 1;
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Activity r104 = r100[r101 - r103];
        if (r104 == null) goto L9;
        if (r104.isFinishing() == true) goto L9;
        return r104;
    L9:
        r103 = r103 + 1;
        goto L3
    L11:
        return to7.c.b();
    }

    public final void n() {
        JSONObject r100 = r();
        Iterator<String> r101 = r100.keys();
    L4:
        if (r101.hasNext() == false) goto L14;
        String r102 = r101.next();
        String r103 = r100.optString(r102);
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        hm7.f r104 = p(r103);
        if (r104 == null) goto L4;
        if (q() <= r104.a()) goto L4;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "getCacheProgress: task_id = " + r102 + " 过期了,将所有任务相关的数据全部清空");
        z(r102);
        ActionTaskManager.f271681l.getClass();
        o(ActionTaskManager.L(r102));
        goto L4
    }

    public final long q() {
        long r100 = hl7.b.b().a();
        if (r100 == 0) goto L5;
        return r100;
    L5:
        return System.currentTimeMillis();
    }

    public e() {
    }

    @Override // ym7.b
    public final String getTaskKey() {
        return A;
    }

    public static void E(String r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "stopAllTaskProxy called, begin proxy. reason: " + r100 + ", accountRefreshSwitch: " + f481720x + ", accountRefreshIdWhiteList: " + f481718v);
        if (f481720x == true) goto L5;
    L35:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "原逻辑清除所有任务");
        Iterator<com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a> r101 = f481709m.iterator();
    L37:
        if (r101.hasNext() == false) goto L49;
        com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a r102 = r101.next();
        boolean r103 = r102 instanceof com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a;
        if (r103 == false) goto L37;
        if (r103 == true) goto L42;
        com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a r104 = null;
    L43:
        if (r104 == null) goto L45;
        r101.remove();
        f481710n.remove(r104.c().f546539a);
        f481711o.remove(r104.c().f546539a);
    L45:
        NormalTimerTaskExecutor r105 = (NormalTimerTaskExecutor) r102;
        gk7.e r106 = r105.f272232i;
        if (r106 == null) goto L48;
        r106.c(r105.c(), r100);
    L48:
        r105.u();
        r105.n();
        goto L37
    L42:
        r104 = r102;
        goto L43
    L49:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "stopAllTask reason: ".concat(r100));
        return;
    L5:
        if ((!Intrinsics.areEqual(r100, "account_bind")) == true) goto L7;
    L9:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "新逻辑清除所有任务");
        List r107 = f481718v;
        if (r107 != null) goto L13;
        r107 = CollectionsKt.emptyList();
    L13:
        Application r108 = rk7.m.f538347a;
        String r109 = rk7.m.j();
        boolean r110 = !Intrinsics.areEqual(f481721y, r109);
        if (r110 == false) goto L16;
        f481721y = r109;
    L16:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "checkUidChange onCall: hasChange: " + r110);
        Iterator<com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a> r111 = f481709m.iterator();
    L18:
        if (r111.hasNext() == false) goto L67;
        com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a r112 = r111.next();
        boolean r113 = r112 instanceof com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a;
        if (r113 == false) goto L18;
        if (r113 == true) goto L23;
        com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a r114 = null;
    L24:
        if (r114 == null) goto L18;
        if (r107.contains(r114.c().f546541c) == false) goto L28;
    L29:
        if (r110 == true) goto L31;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "豁免删除任务： taskId:" + r114.c().f546541c);
    L31:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "清除任务: " + r114.c().f546541c);
        r111.remove();
        f481710n.remove(r114.c().f546539a);
        f481711o.remove(r114.c().f546539a);
        NormalTimerTaskExecutor r115 = (NormalTimerTaskExecutor) r112;
        gk7.e r116 = r115.f272232i;
        if (r116 == null) goto L34;
        r116.c(r115.c(), r100);
    L34:
        r115.u();
        r115.n();
        goto L18
    L28:
        if (r107.isEmpty() == false) goto L31;
    L23:
        r114 = r112;
        goto L24
    L67:
        return;
    L7:
        if ((!Intrinsics.areEqual(r100, "account_switch")) == false) goto L9;
        goto L9
    }

    public static void F(boolean r100) {
        f481706j.set(false);
        if (r100 == true) goto L6;
        f481707k = null;
        return;
    L6:
        Runnable r101 = f481707k;
        if (r101 == null) goto L9;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "task init finished and show");
        new Handler(Looper.getMainLooper()).post(r101);
    L9:
        new Handler(Looper.getMainLooper()).post(RunnableC6038e.f481731a);
    }

    public static hm7.f p(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl((hm7.f) new Gson().fromJson(r100, hm7.f.class));     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L10;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("TimerTaskManager", "发生JsonSyntaxException: cacheStr: ".concat(r100), r103);
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = null;
    L13:
        return (hm7.f) r102;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static void w(NormalTimerTaskExecutor r100) {
        int r101 = r100.c().f546546h.optInt("persistent_type");
        String r102 = r100.c().f546539a;
        int r103 = r100.c().f546546h.optInt("report_interval");
        int r104 = r100.c().f546546h.optInt("remaining_report_count");
        int r105 = r103 * (r100.c().f546546h.optInt("total_report_count") - r104);
        if (r101 == 1) goto L5;
        f481710n.put(r102, Integer.valueOf(r105));
        return;
    L5:
        ConcurrentHashMap<String, Integer> r106 = f481710n;
        Integer r107 = r106.get(r102);
        if (r107 != null) goto L10;
        r107 = 0;
    L10:
        if (Intrinsics.compare(r105, r107.intValue()) <= 0) goto L14;
        r106.put(r102, Integer.valueOf(r105));
        return;
    }

    @Override // ym7.b
    public final boolean j(String r100) {
        f481713q = true;
        if (Intrinsics.areEqual(r100, "task_pendant") == false) goto L6;
        f481698b = true;
    L6:
        if (f481697a == true) goto L8;
    L10:
        return false;
    L8:
        if (f481698b == false) goto L10;
        return true;
    }

    public final void o(bl7.a r100) {
        ym7.d r101 = (ym7.d) wm7.g.a(ym7.d.class);
        if (r101 == null) goto L5;
        r101.c(this);
    L5:
        f481722z.set(false);
        if ((r100 instanceof com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a) == true) goto L8;
        bl7.a r102 = null;
    L10:
        if (((com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a) r102) == null) goto L13;
        f481709m.remove(r100);
        f481710n.remove(r100.c().f546539a);
        String r103 = f481711o.remove(r100.c().f546539a);
        return;
    L13:
        return;
    L8:
        r102 = r100;
        goto L10
    }

    @Override // uo7.c, uo7.b
    public final void onEnterBackground(Activity r100) {
        super.onEnterBackground(r100);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "退到后台 主动持久化在内存中的任务的进度");
        n();
        l();
    }

    public final void z(String r100) {
        JSONObject r101 = r();
        Iterator<String> r102 = r101.keys();
    L4:
        if (r102.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(r102.next(), r100) == false) goto L4;
        r102.remove();
        monitor-enter(this);
        il7.m.b("timer_task_cached").k("timer_task_progress", r101.toString());     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void t(String r110, FrameLayout r111) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "hideTimerPendent onCall");
        if (r110 == null) goto L16;
        if (r111 == null) goto L16;
        Iterator<T> r100 = f481709m.iterator();
    L8:
        if (r100.hasNext() == false) goto L15;
        com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a r101 = (com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a) r100.next();
        Iterator r102 = StringsKt.split$default(r101.c().f546546h.optString(InvRouter.SCENES), new String[]{","}, false, 0, 6, null).iterator();
    L11:
        if (r102.hasNext() == false) goto L8;
        if (Intrinsics.areEqual((String) r102.next(), r110) == false) goto L11;
        ((NormalTimerTaskExecutor) r101).p(r111);
        goto L11
    L15:
        return;
    L16:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "params error, can not show pendant");
    }

    @Override // ym7.b
    public final void a(String r100, n r101) {
        f481714r = r100;     // Catch: Throwable -> L27
        f481715s = r101;     // Catch: Throwable -> L27
        if (r101 == null) goto L30;
        JSONObject r102 = r101.f568383b;     // Catch: Throwable -> L27
        if (r102 == null) goto L26;
        String r103 = r102.optString("sceneId");     // Catch: Throwable -> L27
        Object r104 = r102.opt(RootDescription.ROOT_ELEMENT);     // Catch: Throwable -> L27
        Object r105 = r102.opt("params");     // Catch: Throwable -> L27
        int r106 = r102.optInt("viewIndex");     // Catch: Throwable -> L27
        String r107 = r102.optString("from", "normal");     // Catch: Throwable -> L27
        if (Intrinsics.areEqual(r107, "normal") == false) goto L17;
        if ((r104 instanceof FrameLayout) == true) goto L12;
        r104 = null;
    L12:
        FrameLayout r108 = (FrameLayout) r104;     // Catch: Throwable -> L27
        if ((r105 instanceof FrameLayout.LayoutParams) == true) goto L15;
        r105 = null;
    L15:
        C(r103, r108, (FrameLayout.LayoutParams) r105, r106);     // Catch: Throwable -> L27
        goto L30
    L17:
        if (Intrinsics.areEqual(r107, "robust") == false) goto L30;
        if ((r104 instanceof FrameLayout) == true) goto L21;
        r104 = null;
    L21:
        FrameLayout r109 = (FrameLayout) r104;     // Catch: Throwable -> L27
        if ((r105 instanceof FrameLayout.LayoutParams) == true) goto L24;
        r105 = null;
    L24:
        D(r103, r109, (FrameLayout.LayoutParams) r105, r106);     // Catch: Throwable -> L27
        goto L30
    L26:
        return;
    L30:
        return;
    L27:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("TimerTaskManager", com.bytedance.ug.sdk.luckydog.api.task.taskmanager.d.a("showPendant()", th.getLocalizedMessage()), th);
    }

    @Override // ym7.b
    public final void f(String r100, n r101) {
        if (r101 == null) goto L7;
        JSONObject r102 = r101.f568383b;
        if (r102 == null) goto L8;
        t(r102.optString("sceneId"), (FrameLayout) r102.opt(RootDescription.ROOT_ELEMENT));
        return;
    L8:
        return;
    }

    public final synchronized void B(String r100, boolean r101, TaskReShowCallback r102) {
        monitor-enter(this);
        if (r102 != null) goto L7;
        f481717u.clear();     // Catch: Throwable -> L5
    L10:
        f481716t = r101;     // Catch: Throwable -> L5
        monitor-exit(this);
        return;
    L7:
        if (r100 != null) goto L9;
        f481717u.put(f481705i, r102);     // Catch: Throwable -> L5
        goto L10
    L9:
        f481717u.put(r100, r102);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    public static void A(int r100, long r101, NormalTimerTaskExecutor r102, gm7.b.InterfaceC6037b r110) {
        String r103 = r102.c().f546542d;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "reportTimerTask taskType = " + r103);
        gm7.b.b(r103, r101, r100, new g(r110), false);
    }

    public static void C(String r100, FrameLayout r101, FrameLayout.LayoutParams r102, int r103) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "showTimerPendant onCall");
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        if (f481706j.get() == false) goto L10;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "showTimerPendant pending, sceneId = ".concat(r100));
        f481707k = new d(r100, r101, r102, r103);
        return;
    L10:
        v(r100, r101, r102, r103);
        return;
    L12:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "params error, can not show pendant");
    }

    public static void D(String r100, FrameLayout r101, FrameLayout.LayoutParams r102, int r103) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "showTimerPendantRobust onCall");
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        if (f481706j.get() == false) goto L10;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "接口还未返回, pending show");
        f481708l.add(new b(r100, r101, r102, r103));
        return;
    L10:
        v(r100, r101, r102, r103);
        return;
    L12:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "params error, can not show pendant");
    }

    public static void v(String r110, FrameLayout r111, FrameLayout.LayoutParams r112, int r113) {
        Iterator<T> r100 = f481709m.iterator();
    L4:
        if (r100.hasNext() == false) goto L31;
        com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a r101 = (com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a) r100.next();
        if (r101.c().f546546h.optInt("need_pendant") != 1) goto L7;
        Iterator r102 = StringsKt.split$default(r101.c().f546546h.optString(InvRouter.SCENES), new String[]{","}, false, 0, 6, null).iterator();
    L12:
        if (r102.hasNext() == false) goto L4;
        if (Intrinsics.areEqual((String) r102.next(), r110) == false) goto L12;
        Integer r114 = f481710n.get(r101.c().f546539a);
        if (r114 != null) goto L19;
        r114 = 0;
    L19:
        NormalTimerTaskExecutor r103 = (NormalTimerTaskExecutor) r101;
        r103.w(r111, r112, r113, r114.intValue());
        return;
    L7:
        NormalTimerTaskExecutor r104 = (NormalTimerTaskExecutor) r101;
        if (r104.f272237n.get() == true) goto L4;
        r104.f272237n.set(true);
        int r105 = gm7.c.f481693a;
        gm7.c.b(r101.c(), "task_without_pendant");
        goto L4
    }
}
