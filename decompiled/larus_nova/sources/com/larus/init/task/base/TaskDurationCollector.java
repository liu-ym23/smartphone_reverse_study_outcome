package com.larus.init.task.base;

import bg9.j;
import com.larus.apm.api.IApmTrace;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.init.task.firstframe.c;
import com.larus.init.task.firstframe.f;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class TaskDurationCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TaskDurationCollector f351177a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Long> f351178b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Long> f351179c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Long> f351180d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Long> f351181e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f351182f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f351183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f351184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f351185i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/init/task/base/TaskDurationCollector$AppInitStage;", "", "stage", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStage", "()Ljava/lang/String;", "FIRST_FRAME", "FIRST_FEED", FlowDoraWifiScene.OTHER, "DEFAULT", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AppInitStage extends Enum<AppInitStage> {
        public static final AppInitStage DEFAULT = null;
        public static final AppInitStage FIRST_FEED = null;
        public static final AppInitStage FIRST_FRAME = null;
        public static final AppInitStage OTHER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AppInitStage[] f351186a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f351187b = null;
        private final String stage;

        public static EnumEntries<AppInitStage> getEntries() {
            return f351187b;
        }

        static {
            AppInitStage r100 = new AppInitStage("FIRST_FRAME", 0, "FIRST_FRAME");
            FIRST_FRAME = r100;
            AppInitStage r101 = new AppInitStage("FIRST_FEED", 1, "FIRST_FEED");
            FIRST_FEED = r101;
            AppInitStage r102 = new AppInitStage(FlowDoraWifiScene.OTHER, 2, FlowDoraWifiScene.OTHER);
            OTHER = r102;
            AppInitStage r103 = new AppInitStage("DEFAULT", 3, "DEFAULT");
            DEFAULT = r103;
            AppInitStage[] r104 = {r100, r101, r102, r103};
            f351186a = r104;
            f351187b = EnumEntriesKt.enumEntries(r104);
        }

        public static AppInitStage[] values() {
            return (AppInitStage[]) f351186a.clone();
        }

        public final String getStage() {
            return this.stage;
        }

        public static AppInitStage valueOf(String r100) {
            return (AppInitStage) r27.a.a(AppInitStage.class, r100);
        }

        public AppInitStage(String r100, int r101, String r102) {
            super(r100, r101);
            this.stage = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f351188a = null;

        static {
            int[] r100 = new int[AppInitStage.values().length];
            r100[AppInitStage.FIRST_FRAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[AppInitStage.FIRST_FEED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[AppInitStage.OTHER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[AppInitStage.DEFAULT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f351188a = r100;
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class b extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            TaskDurationCollector r100 = TaskDurationCollector.f351177a;     // Catch: Throwable -> L15
            monitor-enter(r100);     // Catch: Throwable -> L15
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L5:
            if (TaskDurationCollector.f351183g == false) goto L9;
            monitor-exit(r100);     // Catch: Throwable -> L15
            return;
        L9:
            TaskDurationCollector.f351183g = true;     // Catch: Throwable -> L12
            Lazy r101 = f.f351297a;     // Catch: Throwable -> L12
            Function0 r102 = new j();     // Catch: Throwable -> L12
            Intrinsics.checkNotNullParameter(r102, "runnable");     // Catch: Throwable -> L12
            ((ThreadPoolExecutor) f.f351297a.getValue()).execute(new c(r102));     // Catch: Throwable -> L12
            monitor-exit(r100);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L23;
            throw th;
        }

        public b() {
        }
    }

    public TaskDurationCollector() {
    }

    static {
        f351177a = new TaskDurationCollector();
        f351178b = new ConcurrentHashMap();
        f351179c = new ConcurrentHashMap();
        f351180d = new ConcurrentHashMap();
        f351181e = new ConcurrentHashMap();
        f351182f = Collections.synchronizedSet(new HashSet());
    }

    public final synchronized void c(long r100) {
        monitor-enter(this);
        new PthreadTimer("TaskDurationCollector").schedule(new b(), r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void b(String r100, Map r101) {
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        if (r102.isEmpty() == false) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        Iterator r104 = r102.entrySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.put((String) r105.getKey(), ((Number) r105.getValue()).longValue());
        goto L7
    L9:
        IApmTrace.Companion r106 = IApmTrace.f286937a;
        r106.c(r100, r103);
        r106.f(r100, new JSONObject(), r103, null);
        if (AppHost.f326268a.isDebug() == false) goto L14;
        FLogger.f375446a.d("TaskDurationCollector", "key: " + r100 + ", data: " + r103);
        return;
    }

    public final synchronized void a(String r100, boolean r101, AppInitStage r102, String r103, long r110) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "scene");     // Catch: Throwable -> L57
        Intrinsics.checkNotNullParameter(r102, "stage");     // Catch: Throwable -> L57
        if (r101 == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (StringsKt.isBlank(r100) == false) goto L11;
    L54:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L57
        r104.put("task", r103);     // Catch: Throwable -> L57
        IApmTrace.Companion r105 = IApmTrace.f286937a;     // Catch: Throwable -> L57
        r105.c("app_init_duration_differentiated_services_error", r104);     // Catch: Throwable -> L57
        r105.f("app_init_duration_differentiated_services_error", r104, null, null);     // Catch: Throwable -> L57
        monitor-exit(this);
        return;
    L11:
        if (StringsKt.isBlank(r103) == false) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == true) goto L54;
        if (r110 <= 20000) goto L21;
        monitor-exit(this);
        return;
    L21:
        if (f351182f.add(r103) == false) goto L52;
        long r107 = 0;
        if (f351185i == true) goto L29;
        Map<String, Long> r108 = f351181e;     // Catch: Throwable -> L57
        Long r109 = (Long) ((ConcurrentHashMap) r108).get(r100);     // Catch: Throwable -> L57
        if (r109 == null) goto L27;
        long r111 = r109.longValue();     // Catch: Throwable -> L57
    L28:
        ((ConcurrentHashMap) r108).put(r100, Long.valueOf(r111 + r110));     // Catch: Throwable -> L57
        goto L29
    L27:
        r111 = 0;
    L29:
        int r112 = a.f351188a[r102.ordinal()];     // Catch: Throwable -> L57
        if (r112 != 1) goto L32;
        Map<String, Long> r113 = f351178b;     // Catch: Throwable -> L57
        Long r114 = (Long) ((ConcurrentHashMap) r113).get(r100);     // Catch: Throwable -> L57
        if (r114 == null) goto L51;
        r107 = r114.longValue();     // Catch: Throwable -> L57
    L51:
        ((ConcurrentHashMap) r113).put(r100, Long.valueOf(r107 + r110));     // Catch: Throwable -> L57
        goto L52
    L32:
        if (r112 != 2) goto L34;
        Map<String, Long> r115 = f351179c;     // Catch: Throwable -> L57
        Long r116 = (Long) ((ConcurrentHashMap) r115).get(r100);     // Catch: Throwable -> L57
        if (r116 == null) goto L47;
        r107 = r116.longValue();     // Catch: Throwable -> L57
    L47:
        ((ConcurrentHashMap) r115).put(r100, Long.valueOf(r107 + r110));     // Catch: Throwable -> L57
        goto L52
    L34:
        if (r112 != 3) goto L36;
    L40:
        Map<String, Long> r117 = f351180d;     // Catch: Throwable -> L57
        Long r118 = (Long) ((ConcurrentHashMap) r117).get(r100);     // Catch: Throwable -> L57
        if (r118 == null) goto L43;
        r107 = r118.longValue();     // Catch: Throwable -> L57
    L43:
        ((ConcurrentHashMap) r117).put(r100, Long.valueOf(r107 + r110));     // Catch: Throwable -> L57
        goto L52
    L36:
        if (r112 == 4) goto L40;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L57
    L52:
        monitor-exit(this);
        return;
    L13:
        r106 = false;
    L57:
        th = move-exception;
        throw th;
    }
}
