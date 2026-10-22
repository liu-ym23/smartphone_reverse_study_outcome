package com.bytedance.ug.sdk.luckydog.api.task.taskmanager;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.api.model.TaskCacheClearCase;
import com.google.gson.Gson;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import gk7.l;
import il7.m;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import rk7.u;

/* JADX INFO: loaded from: classes3.dex */
public final class ActionTaskManager extends uo7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f271670a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f271671b = "ActionTaskManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f271672c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f271673d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f271674e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLong f271675f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicLong f271676g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f271677h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap<String, bl7.a> f271678i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Pair<Long, com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a>> f271679j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ActionTaskManager$executeCallback$1 f271680k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ActionTaskManager f271681l = null;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f271682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f271683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f271684c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L20:
            return true;
        L5:
            if ((r100 instanceof a) == false) goto L19;
            a r101 = (a) r100;
            if (this.f271682a != r101.f271682a) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L19;
            if (this.f271683b != r101.f271683b) goto L14;
            boolean r103 = true;
        L15:
            if (r103 == false) goto L19;
            if (Intrinsics.areEqual(this.f271684c, r101.f271684c) == false) goto L19;
        L14:
            r103 = false;
            goto L15
        L9:
            r102 = false;
        L19:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public final int hashCode() {
            boolean r100 = this.f271682a;
            ?? r101 = r100;
            if (r100 == false) goto L5;
            r101 = 1;
        L5:
            int r102 = ((r101 * 31) + this.f271683b) * 31;
            String r103 = this.f271684c;
            if (r103 == null) goto L8;
            int r104 = r103.hashCode();
        L10:
            return r102 + r104;
        L8:
            r104 = 0;
            goto L10
        }

        public final String toString() {
            return "DispatchResult(isSuccess=" + this.f271682a + ", errorCode=" + this.f271683b + ", errorMsg=" + this.f271684c + ")";
        }

        public a(boolean r100, int r101, String r102) {
            this.f271682a = r100;
            this.f271683b = r101;
            this.f271684c = r102;
        }
    }

    static {
        boolean r100 = true;
        f271670a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ActionTaskManager.class), "executorMap", "getExecutorMap()Ljava/util/concurrent/ConcurrentHashMap;"))};
        ActionTaskManager r101 = new ActionTaskManager();
        f271681l = r101;
        f271671b = "ActionTaskManager";
        AtomicBoolean r102 = new AtomicBoolean(true);
        f271672c = r102;
        AtomicBoolean r103 = new AtomicBoolean(true);
        f271673d = r103;
        AtomicBoolean r104 = new AtomicBoolean(true);
        f271674e = r104;
        AtomicLong r105 = new AtomicLong(172800000);
        f271675f = r105;
        AtomicLong r106 = new AtomicLong(10000);
        f271676g = r106;
        to7.c.d(r101);
        int r107 = k.f271716a;
        String r108 = m.b("action_task_prefs_config").e("cached_action_config", "");
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r108) == true) goto L22;
    L20:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(f271671b, "init onCall! coldStartRestoreEnable: " + f271672c.get() + ", enterBackSaveEnable: " + f271673d.get() + ", taskManagerEnable: " + f271674e.get() + ", EXPIRE_INTERVAL: " + f271675f.get() + ", CACHE_INTERVAL: " + f271676g.get());
        f271677h = LazyKt.lazy(ActionTaskManager$executorMap$2.INSTANCE);
        f271678i = new ConcurrentHashMap();
        f271679j = new ConcurrentHashMap();
        f271680k = new ActionTaskManager$executeCallback$1();
        return;
    L22:
        JSONObject r109 = new JSONObject(r108);     // Catch: Throwable -> L18
        if (r109.optInt("cold_start_restore_enable") != 1) goto L7;
        boolean r110 = true;
    L8:
        r102.set(r110);     // Catch: Throwable -> L18
        if (r109.optInt("enter_back_save_enable") != 1) goto L11;
        boolean r111 = true;
    L12:
        r103.set(r111);     // Catch: Throwable -> L18
        if (r109.optInt("task_manager_enable") == 1) goto L16;
        r100 = false;
    L16:
        r104.set(r100);     // Catch: Throwable -> L18
        r105.set(r109.optLong("expire_interval_ms"));     // Catch: Throwable -> L18
        r106.set(r109.optLong("cache_interval_ms"));     // Catch: Throwable -> L18
        goto L20
    L11:
        r111 = false;
        goto L12
    L7:
        r110 = false;
    L18:
        th = move-exception;
        th.getLocalizedMessage();
        goto L20
    }

    public static ConcurrentHashMap w() {
        Lazy r100 = f271677h;
        KProperty r101 = f271670a[0];
        return (ConcurrentHashMap) r100.getValue();
    }

    public static JSONObject v() {
        int r100 = k.f271716a;     // Catch: Throwable -> L7
        String r101 = m.b("action_task_prefs_config").e("cached_action_task", "");     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r101) == false) goto L6;
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L7
    L10:
        return r102;
    L6:
        r102 = new JSONObject(r101);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c(f271671b, d.a("getCachedTask()", th.getLocalizedMessage()), th);
        return new JSONObject();
    }

    public final long z() {
        long r100 = hl7.b.b().a();
        if (r100 == 0) goto L5;
        return r100;
    L5:
        return System.currentTimeMillis();
    }

    public ActionTaskManager() {
    }

    public static bl7.a L(String r100) {
        return f271678i.get(r100);
    }

    public static com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a t(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = new Gson().fromJson(r100, com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a.class);     // Catch: Throwable -> L4
        ((com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a) r102).a().f546549k = "cache";     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl((com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a) r102);     // Catch: Throwable -> L4
    L6:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L10;
        com.bytedance.ug.sdk.luckydog.api.log.d.c(f271671b, "发生JsonSyntaxException: cacheStr: ".concat(r100), r104);
    L10:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = null;
    L13:
        return (com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a) r103;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final synchronized void B(String r100) {
        monitor-enter(this);
        JSONObject r101 = v();     // Catch: Throwable -> L11
        Iterator<String> r102 = r101.keys();     // Catch: Throwable -> L11
    L5:
        if (r102.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r102.next(), r100) == false) goto L5;
        r102.remove();     // Catch: Throwable -> L11
        H(r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void F(String r110) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d(f271671b, "尝试从持久化存储中自动恢复taskType = " + r110 + " 的任务, taskType=null即所有任务");
        JSONObject r100 = v();     // Catch: Throwable -> L35
        Iterator<String> r101 = r100.keys();     // Catch: Throwable -> L35
    L4:
        if (r101.hasNext() == false) goto L59;
        String r102 = r100.optString(r101.next());     // Catch: Throwable -> L35
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a r103 = t(r102);     // Catch: Throwable -> L35
        if (r103 == null) goto L4;
        tk7.a r104 = r103.a();     // Catch: Throwable -> L35
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L35
        Long r106 = r104.f546550l;     // Catch: Throwable -> L35
        if (r110 == null) goto L18;
        if ((!Intrinsics.areEqual(r110, r104.f546540b)) == true) goto L4;
    L18:
        if (TextUtils.isEmpty(r103.getIdentifier()) == false) goto L19;
        bl7.a r107 = y(r104, "cache");     // Catch: Throwable -> L35
        if (r106 != null) goto L23;
    L24:
        if (r106 != null) goto L31;
        if (z() <= r103.b()) goto L31;
    L27:
        if (r106 == null) goto L29;
        r106.longValue();     // Catch: Throwable -> L35
        r104.f546551m = Integer.valueOf(TaskCacheClearCase.CASE_VALID_EXPIRE.getValue());     // Catch: Throwable -> L35
    L30:
        p(r104);     // Catch: Throwable -> L35
        goto L4
    L29:
        r104.f546551m = Integer.valueOf(TaskCacheClearCase.CASE_CACHE_EXPIRE.getValue());     // Catch: Throwable -> L35
    L31:
        C("luckydog_task_manager_begin_open", r104, r105);     // Catch: Throwable -> L35
        if (r107 == null) goto L4;
        ActionTaskManager r108 = f271681l;     // Catch: Throwable -> L35
        String r109 = r104.f546539a;     // Catch: Throwable -> L35
        r108.getClass();     // Catch: Throwable -> L35
        n(r109, r107);     // Catch: Throwable -> L35
        r107.g(r104);     // Catch: Throwable -> L35
        goto L4
    L23:
        if (z() > r106.longValue()) goto L27;
    L19:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(f271671b, "identifier不为空, 不自动恢复");     // Catch: Throwable -> L35
        goto L4
    L59:
        return;
    L35:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c(f271671b, d.a("restoreCacheTask", th.getLocalizedMessage()), th);
    }

    public final synchronized void H(JSONObject r100) {
        monitor-enter(this);
        int r101 = k.f271716a;     // Catch: Throwable -> L5
        m.b("action_task_prefs_config").k("cached_action_task", r100.toString());     // Catch: Throwable -> L5
    L7:
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c(f271671b, d.a("saveCache", th.getLocalizedMessage()), th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final void K(String r100) {
        bl7.a r101 = L(r100);
        if (r101 == null) goto L5;
        r101.h();
    L5:
        B(r100);
        o(r100);
        com.bytedance.ug.sdk.luckydog.api.log.d.d(f271671b, "stop task globalTaskId = " + r100 + " 的任务被动停止了");
    }

    public final void o(String r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d(f271671b, "释放执行类的实例: globalTaskId:" + r100);
        f271678i.remove(r100);
        f271679j.remove(r100);
    }

    @Override // uo7.c, uo7.b
    public final void onEnterBackground(Activity r100) {
        String r101 = f271671b;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r101, "退到后台 主动持久化一波在内存中的任务");
        if (f271673d.get() == true) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r101, "进入后台存储开关关闭 取消持久化");
        return;
    L6:
        ConcurrentHashMap<String, Pair<Long, com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a>> r102 = f271679j;
        if (r102.entrySet().size() != 0) goto L10;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r101, "内存中没有缓存任何任务, 跳过");
        return;
    L10:
        Iterator<Map.Entry<String, Pair<Long, com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a>>> r103 = r102.entrySet().iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<String, Pair<Long, com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a>> r104 = r103.next();
        G(r104.getKey(), r104.getValue().getSecond());
        goto L12
    L14:
        f271679j.clear();
    }

    public final void p(tk7.a r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d(f271671b, "globalTaskId等于" + r100.f546539a + " 的任务过期了 不恢复执行 从存储中删除 当前getTime():" + z());
        JSONObject r101 = new JSONObject();
        B(r100.f546539a);
        r101.put("reason", "task expired");
        C("luckydog_task_manager_failure", r100, r101);
    }

    public final boolean q(final tk7.a r100) {
        final bl7.a r101 = y(r100, "cache");
        final Ref.BooleanRef r102 = new Ref.BooleanRef();
        r102.element = false;
        Function0<Unit> r103 = new ActionTaskManager$doStashPop$1(r100, r101, r102);
        Long r104 = r100.f546550l;
        if (r104 != null) goto L5;
    L7:
        r103.invoke();
    L9:
        return r102.element;
    L5:
        if (z() <= r104.longValue()) goto L7;
        r100.f546551m = Integer.valueOf(TaskCacheClearCase.CASE_VALID_EXPIRE.getValue());
        p(r100);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "use executeTaskNew")
    public final void r(final tk7.a r110) {
        final String r100 = r110.f546540b;
        if (TextUtils.isEmpty(r110.f546552n) == false) goto L5;
        r110.f546552n = r100;
    L5:
        final String r101 = r110.f546552n;
        if (r101 != null) goto L9;
        r101 = r100;
    L9:
        final String r102 = r110.f546539a;
        r110.f546549k = "host";
        r110.f546548j = Long.valueOf(z());
        String r103 = f271671b;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r103, "任务管理器开始执行任务：taskType: " + r100 + ", uniqueType: " + r101 + ", globalTaskId: " + r102);
        final String r104 = null;
        Object[] r105 = 0;
        C("luckydog_task_manager_begin_open", r110, null);
        if (f271674e.get() == true) goto L32;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r103, "taskManagerEnable = false, 任务管理器开关关闭 不执行");
        E("host", "switch_off", r110);
        return;
    L32:
        final bl7.a r106 = y(r110, "host");     // Catch: Throwable -> L29
        if (r106 != null) goto L15;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(r103, "not find executor or globalTaskId conflict happened, globalTaskId = " + r102);     // Catch: Throwable -> L29
        return;
    L15:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r103, "实例化执行类成功");     // Catch: Throwable -> L29
        final Ref.BooleanRef r107 = new Ref.BooleanRef();     // Catch: Throwable -> L29
        boolean r108 = false;
        r107.element = false;     // Catch: Throwable -> L29
        if (r106.e() == false) goto L27;
        Iterator<Map.Entry<String, bl7.a>> r109 = f271678i.entrySet().iterator();     // Catch: Throwable -> L29
    L19:
        if (r109.hasNext() == false) goto L25;
        bl7.a r111 = r109.next().getValue();     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(r111.d(), r100) == false) goto L19;
        if (Intrinsics.areEqual(r111.c().f546552n, r101) == false) goto L19;
        r108 = true;
    L25:
        if (r108 == false) goto L27;
        r106.j();     // Catch: Throwable -> L29
        d.c(true, new ActionTaskManager$executeTask$1(r101));     // Catch: Throwable -> L29
        new ActionTaskManager$executeTask$2(r104, r110, r107, r106);     // Catch: Throwable -> L29
    L27:
        boolean r112 = r107.element;     // Catch: Throwable -> L29
        d.b(r112, new ActionTaskManager$executeTask$3(r106, r110, r100, r102));     // Catch: Throwable -> L29
        final Object[] r113 = r105 == true ? 1 : 0;
        d.c(r112, new ActionTaskManager$executeTask$4(r113));     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c(f271671b, d.a("executeTask", th.getLocalizedMessage()), th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, com.bytedance.ug.sdk.luckydog.api.task.taskmanager.ActionTaskManager$a] */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, com.bytedance.ug.sdk.luckydog.api.task.taskmanager.ActionTaskManager$a] */
    public final void s(final tk7.a r110) {
        String r100 = r110.f546540b;
        if (TextUtils.isEmpty(r110.f546552n) == false) goto L5;
        r110.f546552n = r100;
    L5:
        String r101 = r110.f546552n;
        if (r101 != null) goto L9;
        r101 = r100;
    L9:
        String r102 = r110.f546539a;
        r110.f546548j = Long.valueOf(z());
        com.bytedance.ug.sdk.luckydog.api.log.d.d(f271671b, "任务管理器开始分发任务：taskType: " + r100 + ", uniqueType: " + r101 + ", globalTaskId: " + r102);
        String r103 = r110.f546540b;
        final String r104 = r110.f546539a;
        final Ref.ObjectRef r105 = new Ref.ObjectRef();
        r105.element = new a(true, 1, "");
        final bl7.a r106 = L(r104);
        if (r106 == null) goto L12;
        boolean r107 = r106.i();
        d.b(r107, new ActionTaskManager$getGidConflictJudgeResult$1(r106, r110, r105));
        d.c(r107, new ActionTaskManager$getGidConflictJudgeResult$2(r106, r104));
    L12:
        a r108 = (a) r105.element;
        if (r108.f271682a == false) goto L48;
        if (f271674e.get() == true) goto L19;
        r108 = new a(false, 100001, "switch_off");
        goto L48
    L19:
        if (TextUtils.isEmpty(r110.f546542d) == false) goto L21;
    L46:
        r108 = new a(false, 100002, "params_lack");
        goto L48
    L21:
        if (TextUtils.isEmpty(r103) == true) goto L46;
        if (TextUtils.isEmpty(r104) == true) goto L46;
        if (w().containsKey(r103) == true) goto L28;
        r108 = new a(false, 100003, "not_register");
        goto L48
    L28:
        String r109 = r110.f546540b;
        String r111 = r110.f546552n;
        if (r111 != null) goto L32;
        r111 = r109;
    L32:
        final Ref.ObjectRef r112 = new Ref.ObjectRef();
        r112.element = new a(true, 1, "");
        Iterator<Map.Entry<String, bl7.a>> r113 = f271678i.entrySet().iterator();
    L34:
        if (r113.hasNext() == false) goto L42;
        final bl7.a r114 = r113.next().getValue();
        if (Intrinsics.areEqual(r114.d(), r109) == false) goto L34;
        if (Intrinsics.areEqual(r114.c().f546552n, r111) == false) goto L34;
        if (r114.e() == false) goto L34;
    L43:
        if (r114 == null) goto L45;
        r114.j();
        new ActionTaskManager$getUniqueConflictJudgeResult$1(r114, r110, r112);
        d.c(true, new ActionTaskManager$getUniqueConflictJudgeResult$2(r114));
    L45:
        r108 = (a) r112.element;
        goto L48
    L42:
        r114 = null;
    L48:
        if (r108.f271682a == true) goto L58;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(f271671b, "任务分发失败, errorcode: " + r108.f271683b + ", reason: " + r108.f271684c);
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L52
        JSONObject r116 = new JSONObject();     // Catch: Throwable -> L52
        r116.put("reason", r108.f271684c);     // Catch: Throwable -> L52
        f271681l.getClass();     // Catch: Throwable -> L52
        C("luckydog_task_manager_failure", r110, r116);     // Catch: Throwable -> L52
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L52
    L54:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L57;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(f271671b, r118.getLocalizedMessage());
    L57:
        AtomicBoolean r119 = u.f538372v;
        u.c.f538395a.i(rk7.m.f538361o.e(), r110.f546543e, null);
        return;
    L52:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L54
    L58:
        com.bytedance.ug.sdk.luckydog.api.log.d.b(f271671b, "任务分发成功 开始实例化任务并执行任务逻辑");
        C("luckydog_task_manager_begin_open", r110, null);
        Class r121 = (Class) w().get(r100);     // Catch: Throwable -> L73
        if (r121 == null) goto L62;
        Constructor r122 = r121.getConstructor(new Class[0]);     // Catch: Throwable -> L73
    L63:
        if (r122 == null) goto L65;
        bl7.a r123 = (bl7.a) r122.newInstance(new Object[0]);     // Catch: Throwable -> L73
    L66:
        if (r123 == null) goto L71;
        r123.a(r110);     // Catch: Throwable -> L73
        if ((!Intrinsics.areEqual(r100, "luckydog_task_open")) == false) goto L70;
        AtomicBoolean r124 = u.f538372v;     // Catch: Throwable -> L73
        u.c.f538395a.i(rk7.m.f538361o.e(), r110.f546543e, null);     // Catch: Throwable -> L73
    L70:
        f271681l.getClass();     // Catch: Throwable -> L73
        n(r102, r123);     // Catch: Throwable -> L73
        r123.b(r110, f271680k);     // Catch: Throwable -> L73
        return;
    L71:
        AtomicBoolean r125 = u.f538372v;     // Catch: Throwable -> L73
        u.c.f538395a.i(rk7.m.f538361o.e(), r110.f546543e, null);     // Catch: Throwable -> L73
        return;
    L65:
        r123 = null;
        goto L66
    L62:
        r122 = null;
    L73:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c(f271671b, d.a("executeTask", th.getLocalizedMessage()), th);
    }

    public static final boolean l(ActionTaskManager r100, Object... r101) {
        r100.getClass();
        int r102 = r101.length;     // Catch: Throwable -> L10
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L18;
        if (r101[r103] == null) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.d.c(f271671b, d.a("hasNull", "java null object were assign to notNull kotlin param"), new Throwable(""));     // Catch: Throwable -> L10
        com.bytedance.ug.sdk.luckydog.api.log.e.a("task_manager_monitor_not_null_object_error", new JSONObject(), null);     // Catch: Throwable -> L10
        return true;
    L18:
        return false;
    L10:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(f271671b, th.getLocalizedMessage());
        return false;
    }

    public static void n(String r100, bl7.a r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d(f271671b, "保存执行类的实例: globalTaskId: " + r100 + ", 实例: " + r101.toString());
        f271678i.put(r100, r101);
    }

    public final synchronized void A(final String r100, Class r101) {
        monitor-enter(this);
        String r102 = f271671b;     // Catch: Throwable -> L11
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r102, "主动注册新的 tasktype：" + r100 + ", Clazz:" + r101.getSimpleName() + ", isReplace: false");     // Catch: Throwable -> L11
        if (w().containsKey(r100) == true) goto L7;
        w().put(r100, r101);     // Catch: Throwable -> L11
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r102, "注册 " + r100 + " 成功");     // Catch: Throwable -> L11
        d.b(false, new ActionTaskManager$registerClazz$1(r100));     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L7:
        if (w().containsKey(r100) == true) goto L9;
    L13:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r102, "注册 " + r100 + " 失败");     // Catch: Throwable -> L11
    L18:
        monitor-exit(this);
        return;
    L9:
        if ((!Intrinsics.areEqual((Class) w().get(r100), r101)) == false) goto L13;
        com.bytedance.ug.sdk.luckydog.api.log.e.a("task_manager_monitor_register_different_clazz", new JSONObject(), null);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c(f271671b, d.a("registerClazz", th.getLocalizedMessage()), th);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final synchronized void G(String r100, com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a r101) {
        monitor-enter(this);
        com.bytedance.ug.sdk.luckydog.api.log.d.d(f271671b, "开始持久化存储, globalTaskId: " + r100 + ", 存储结构是: " + r101);     // Catch: Throwable -> L6
        String r102 = new Gson().toJson(r101, com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a.class);     // Catch: Throwable -> L6
        JSONObject r103 = v();     // Catch: Throwable -> L6
        r103.put(r100, r102);     // Catch: Throwable -> L6
        int r104 = k.f271716a;     // Catch: Throwable -> L6
        m.b("action_task_prefs_config").k("cached_action_task", r103.toString());     // Catch: Throwable -> L6
        r101.getClass();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(f271671b, th.getLocalizedMessage());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [T, bl7.a] */
    /* JADX WARN: Type inference failed for: r1v21 */
    @Deprecated(message = "use executeTaskNew instead")
    public final synchronized bl7.a y(final tk7.a r110, final String r111) {
        monitor-enter(this);
        final String r100 = r110.f546540b;     // Catch: Throwable -> L42
        final String r101 = r110.f546539a;     // Catch: Throwable -> L42
        String r102 = f271671b;     // Catch: Throwable -> L42
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r102, "任务管理器开始通过taskType实例化执行类: taskType:" + r100);     // Catch: Throwable -> L42
        bl7.a r112 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L24
        f271681l.getClass();     // Catch: Throwable -> L24
        if (w().containsKey(r100) == false) goto L26;
        Class r104 = (Class) w().get(r100);     // Catch: Throwable -> L24
        if (r104 == null) goto L11;
        Constructor r105 = r104.getConstructor(new Class[0]);     // Catch: Throwable -> L24
    L12:
        final Ref.ObjectRef r113 = new Ref.ObjectRef();     // Catch: Throwable -> L24
        if (r105 == null) goto L15;
        ?? r106 = (bl7.a) r105.newInstance(new Object[0]);     // Catch: Throwable -> L24
    L16:
        r113.element = r106;     // Catch: Throwable -> L24
        if (r106 == 0) goto L19;
        boolean r114 = r106.i();     // Catch: Throwable -> L24
    L20:
        final bl7.a r115 = L(r101);     // Catch: Throwable -> L24
        if (r115 == null) goto L23;
        d.b(r114, new ActionTaskManager$getInstanceByType$$inlined$runCatching$lambda$1(r113, r100, r101, r110, r111));     // Catch: Throwable -> L24
        d.c(r114, new ActionTaskManager$getInstanceByType$$inlined$runCatching$lambda$2(r115, r100, r101, r110, r111));     // Catch: Throwable -> L24
    L23:
        bl7.a r107 = (bl7.a) r113.element;     // Catch: Throwable -> L24
    L27:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L24
    L30:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L42
        if (r109 == null) goto L34;
        com.bytedance.ug.sdk.luckydog.api.log.d.c(f271671b, d.a("getInstanceByType", r109.getLocalizedMessage()), r109);     // Catch: Throwable -> L42
    L34:
        if (Result.m9455isFailureimpl(r108) == false) goto L36;
        r108 = null;
    L36:
        bl7.a r116 = (bl7.a) r108;     // Catch: Throwable -> L42
        if (r116 == null) goto L39;
        r112 = r116;
    L40:
        monitor-exit(this);
        return r112;
    L39:
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogLogger_", "没有找到'" + r100 + "'对应的Class类, 检查是否注册");     // Catch: Throwable -> L42
        goto L40
    L19:
        r114 = false;
        goto L20
    L15:
        r106 = 0;
        goto L16
    L11:
        r105 = null;
        goto L12
    L26:
        com.bytedance.ug.sdk.luckydog.api.log.d.b(r102, "taskType:" + r100 + " 未注册");     // Catch: Throwable -> L24
        E(r111, "not_register", r110);     // Catch: Throwable -> L24
        r107 = null;
    L24:
        th = move-exception;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L42
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }

    public static void C(String r100, tk7.a r101, JSONObject r102) {
        if (r102 == null) goto L48;
    L6:
        String r103 = "";
        if (r101 == null) goto L11;
        String r104 = r101.f546539a;     // Catch: Throwable -> L45
        if (r104 == null) goto L11;
    L12:
        r102.put("global_task_id", r104);     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r102.optString("from")) == false) goto L21;
        if (r101 == null) goto L18;
        String r105 = r101.f546549k;     // Catch: Throwable -> L45
        if (r105 == null) goto L18;
    L19:
        r102.put("from", r105);     // Catch: Throwable -> L45
    L18:
        r105 = "";
    L21:
        if (r101 == null) goto L25;
        String r106 = r101.f546540b;     // Catch: Throwable -> L45
        if (r106 == null) goto L25;
    L26:
        r102.put(AiProactiveTaskViewModel.PARAM_TASK_TYPE, r106);     // Catch: Throwable -> L45
        if (r101 == null) goto L31;
        String r107 = r101.f546552n;     // Catch: Throwable -> L45
        if (r107 == null) goto L31;
    L32:
        r102.put("unique_type", r107);     // Catch: Throwable -> L45
        if (r101 == null) goto L37;
        String r108 = r101.f546544f;     // Catch: Throwable -> L45
        if (r108 == null) goto L37;
    L38:
        r102.put("act_id", r108);     // Catch: Throwable -> L45
        if (r101 == null) goto L43;
        String r109 = r101.f546541c;     // Catch: Throwable -> L45
        if (r109 == null) goto L43;
        r103 = r109;
    L43:
        r102.put("task_id", r103);     // Catch: Throwable -> L45
        j.f(r100, r102, r104);     // Catch: Throwable -> L45
        com.bytedance.ug.sdk.luckydog.api.log.b.a(r100, r102);     // Catch: Throwable -> L45
        return;
    L45:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c(f271671b, d.a("reportTaskManagerMonitor", th.getLocalizedMessage()), th);
        return;
    L37:
        r108 = "";
    L31:
        r107 = "";
    L25:
        r106 = "";
    L11:
        r104 = "";
        goto L12
    L48:
        r102 = new JSONObject();     // Catch: Throwable -> L45
        goto L6
    }

    public static /* synthetic */ void D(ActionTaskManager r100, String r101, tk7.a r102) {
        r100.getClass();
        C(r101, r102, null);
    }

    @Deprecated(message = "method will be deprecated after use executeTaskNew")
    public static void E(String r100, String r101, tk7.a r102) {
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L4
        r103.put("reason", r101);     // Catch: Throwable -> L4
        r103.put("from", r100);     // Catch: Throwable -> L4
        C("luckydog_task_manager_open_fail", r102, r103);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c(f271671b, d.a("reportTaskOpenFail", th.getLocalizedMessage()), th);
    }

    public final void I(final String r100, final String r101, String r102) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d(f271671b, "业务主动恢复 identifier = " + r100 + ", taskType = " + r101 + ", uniqueType = " + r102 + " 的任务");
        JSONObject r103 = v();     // Catch: Throwable -> L29
        Iterator<String> r104 = r103.keys();     // Catch: Throwable -> L29
        boolean r105 = false;
    L5:
        if (r104.hasNext() == false) goto L27;
        String r106 = r103.optString(r104.next());     // Catch: Throwable -> L29
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        com.bytedance.ug.sdk.luckydog.api.task.taskmanager.a r107 = t(r106);     // Catch: Throwable -> L29
        if (r107 == null) goto L5;
        tk7.a r108 = r107.a();     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r107.getIdentifier()) == true) goto L14;
        if (r100 != null) goto L17;
        if (r101 != null) goto L21;
        if (r102 == null) goto L5;
        if (Intrinsics.areEqual(r102, r107.a().f546552n) == false) goto L5;
        r105 = q(r108);     // Catch: Throwable -> L29
        goto L5
    L21:
        if (Intrinsics.areEqual(r107.a().f546540b, r101) == false) goto L5;
        r105 = q(r108);     // Catch: Throwable -> L29
        goto L5
    L17:
        if (Intrinsics.areEqual(r107.getIdentifier(), r100) == false) goto L5;
        r105 = q(r108);     // Catch: Throwable -> L29
        goto L5
    L14:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(f271671b, "identifier为空 只在冷启自动恢复 手动触发略过");     // Catch: Throwable -> L29
        goto L5
    L27:
        final l r109 = null;
        d.b(r105, new ActionTaskManager$stashPopTask$1(r100, r101, r109));     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c(f271671b, d.a("stashPopTask", th.getLocalizedMessage()), th);
    }
}
