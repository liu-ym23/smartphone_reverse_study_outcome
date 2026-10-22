package com.bytedance.bdp.appbase.base.bdptask;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.bdp.appbase.base.monitor.BdpAppMonitor;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.monitor.BdpEnsureService;
import com.bytedance.crash.dumper.Scraps;
import com.google.gson.Gson;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bN\u0010OJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\"\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\f2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\rH\u0007J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0007J\u001a\u0010\u001a\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J\b\u0010 \u001a\u00020\u001dH\u0007J\u0012\u0010#\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010!H\u0007J\u0010\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0007J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0007J\b\u0010)\u001a\u00020\u0010H\u0007J\b\u0010*\u001a\u00020\u0010H\u0007J\b\u0010+\u001a\u00020\u0010H\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0018H\u0007J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0018H\u0007J\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J*\u0010\u0005\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/2\b\u0010%\u001a\u0004\u0018\u00010$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J$\u0010\u0005\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010,\u001a\u00020\u0018H\u0007J\u0010\u00101\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0018H\u0007J\u0018\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0018H\u0007J(\u00101\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J\"\u00101\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0018H\u0007J\u0016\u00103\u001a\u00020\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J\u0010\u00103\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0018H\u0007J\u0018\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0018H\u0007J(\u00103\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J\"\u00103\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0018H\u0007J\u0010\u00104\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0018H\u0007J\u0010\u00105\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0018H\u0007J\u0016\u00105\u001a\u00020\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J \u00105\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J\u001a\u00105\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010,\u001a\u00020\u0018H\u0007J\u0016\u00106\u001a\u00020\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J\u0010\u00106\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0018H\u0007J\u0010\u00107\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0018H\u0007J\u0016\u00107\u001a\u00020\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J\u0018\u00107\u001a\u00020\u00042\u0006\u0010.\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0018H\u0007J*\u00107\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/2\b\u0010.\u001a\u0004\u0018\u00010$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J$\u00107\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/2\b\u0010.\u001a\u0004\u0018\u00010$2\u0006\u0010,\u001a\u00020\u0018H\u0007J\n\u00108\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u00109\u001a\u00020\u0016H\u0007J\b\u0010:\u001a\u00020\u0016H\u0007J\b\u0010;\u001a\u00020\u0016H\u0007J\b\u0010<\u001a\u00020\u0016H\u0007J\b\u0010=\u001a\u00020\u0016H\u0007J;\u0010F\u001a\u00028\u0000\"\u0004\b\u0000\u0010>2\u0006\u0010@\u001a\u00020?2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A2\f\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000DH\u0007¢\u0006\u0004\bF\u0010GJ+\u0010F\u001a\u00028\u0000\"\u0004\b\u0000\u0010>2\u0006\u0010@\u001a\u00020?2\f\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000DH\u0007¢\u0006\u0004\bF\u0010HJ\u0010\u0010F\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0007J\b\u0010J\u001a\u00020IH\u0007J\u0010\u0010K\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0018H\u0007J\u0016\u0010K\u001a\u00020\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J\u0010\u0010L\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0018H\u0007J\u0016\u0010L\u001a\u00020\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007J\u0010\u0010M\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0018H\u0007J\u0016\u0010M\u001a\u00020\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100-H\u0007¨\u0006P"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/BdpPool;", "", "Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask;", "task", "", "execute", DBDefinition.TASK_ID, "futureGet", "", "timeout", "Ljava/util/concurrent/TimeUnit;", Scraps.INNER_UNIT, ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/ArrayList;", "Ljava/util/concurrent/Future;", "futures", "", "cancelAll", "Lcom/bytedance/bdp/appbase/base/bdptask/j;", "group", "cancelGroup", "groupId", "", "mayInterruptIfRunning", "Ljava/lang/Runnable;", "runnable", "cancelRunnable", "cancelTask", "getGroupTaskCount", "Ljava/lang/Thread$UncaughtExceptionHandler;", "handler", "setUncaughtExceptionHandler", "getUncaughtExceptionHandler", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskExecuteStatusListener;", "listener", "setTaskExecuteStatusListener", "Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$TaskType;", "type", "Lcom/bytedance/bdp/appbase/base/bdptask/PoolStatus;", "getPoolStatus", "getMaxConcurrentAndReset", "preStartPoolThreads", "triggerMainTask", "disableTriggerMainTask", "r", "Lkotlin/Function0;", "taskType", "Landroidx/lifecycle/LifecycleOwner;", "owner", "postLogic", "delayMillis", "postMain", "urgentRunOnMain", "runOnMain", "runOnMainQuickly", "runOnAsyncIfMain", "curThreadTask", "isOnMain", "isOnOWNPool", "isOnIOPool", "isOnCPUPool", "isOnLogic", "V", "", "trace", "Ljava/util/LinkedList;", "Lcom/bytedance/bdp/appbase/base/bdptask/TracePoint;", "prevList", "Ljava/util/concurrent/Callable;", "callable", "directRun", "(Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "Ljava/util/concurrent/ExecutorService;", "getIOExecutor", "executeQuickly", "postLogicQuickly", "postIOQuickly", "<init>", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BdpPoolService f200408a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f200409b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f200410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BdpPool f200411d = null;

    public static final class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f200412a;

        public a(Thread.UncaughtExceptionHandler r100) {
            this.f200412a = r100;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread r110, Throwable r111) {
            JSONObject r100 = new JSONObject();
            JSONObject r101 = new JSONObject();
            r100.put(BdpAppEventConstant.PARAMS_EXC_PLACE, "threadpool-exception");     // Catch: Throwable -> L19
            if (TextUtils.isEmpty(null) == false) goto L6;
        L7:
            Throwable r102 = r111;
        L9:
            if (r102.getCause() == null) goto L12;
            r102 = r102.getCause();     // Catch: Throwable -> L19
            goto L9
        L12:
            if (r102.getStackTrace().length <= 0) goto L16;
            StackTraceElement r103 = r102.getStackTrace()[0];     // Catch: Throwable -> L19
            if (r103 == null) goto L16;
            String r104 = r103.getFileName();     // Catch: Throwable -> L19
            String r105 = r103.getMethodName();     // Catch: Throwable -> L19
        L17:
            r100.put(BdpAppEventConstant.PARAMS_EXC_FILENAME, r104);     // Catch: Throwable -> L19
            r100.put(BdpAppEventConstant.PARAMS_EXC_METHODNAME, r105);     // Catch: Throwable -> L19
            r101.put("exc_msg", Log.getStackTraceString(r111));     // Catch: Throwable -> L19
            BdpAppMonitor.a("mp_exception_catch", r100, null, r101);     // Catch: Throwable -> L19
            com.bytedance.bdp.appbase.base.monitor.d.a(r104, r105);     // Catch: Throwable -> L19
            Map<String, String> r106 = (Map) new Gson().fromJson(r101.toString(), Map.class);     // Catch: Throwable -> L19
            f94.a.c().getClass();     // Catch: Throwable -> L19
            BdpManager.getInst().getSDKInfo().getClass();     // Catch: Throwable -> L19
            r106.put("bdp_version", "13.8.2.1");     // Catch: Throwable -> L19
            ((BdpEnsureService) BdpManager.getInst().getService(BdpEnsureService.class)).ensureNotReachHere(r111, "BdpExceptionMonitor_threadpool-exception", r106);     // Catch: Throwable -> L19
        L21:
            f94.a.c().getClass();
            if (Intrinsics.areEqual("local_test", f94.a.a()) == false) goto L28;
            this.f200412a.uncaughtException(r110, r111);
            return;
        L28:
            return;
        L16:
            r105 = null;
            r104 = null;
            goto L17
        L6:
            if (TextUtils.isEmpty(null) == false) goto L16;
        L19:
            th = move-exception;
            g94.b.b("BdpExceptionMonitor", new Object[]{"reportException", th});
            goto L21
        }
    }

    public static final class b<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f200413a;

        public b(Runnable r100) {
            this.f200413a = r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f200413a.run();
        }
    }

    public static final class c<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdpTask f200414a;

        public c(BdpTask r100) {
            this.f200414a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final int call() {
            return BdpPool.f200408a.s1(this.f200414a);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return Integer.valueOf(call());
        }
    }

    public static final class d<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f200415a;

        public d(Function0 r100) {
            this.f200415a = r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f200415a.invoke();
        }
    }

    public static final class e<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f200416a;

        public e(Function0 r100) {
            this.f200416a = r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f200416a.invoke();
        }
    }

    public static final class f<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f200417a;

        public f(Function0 r100) {
            this.f200417a = r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f200417a.invoke();
        }
    }

    public static final class g<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f200418a;

        public g(Runnable r100) {
            this.f200418a = r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f200418a.run();
        }
    }

    public BdpPool() {
    }

    @JvmStatic
    public static final void disableTriggerMainTask() {
        f200410c = false;
    }

    static {
        f200411d = new BdpPool();
        BdpPoolService r100 = (BdpPoolService) BdpManager.getInst().getService(BdpPoolService.class);
        if (r100 != null) goto L5;
        r100 = new BdpPoolServiceImpl();
    L5:
        f200408a = r100;
        f200409b = LazyKt.lazy(BdpPool$mIOExecutor$2.INSTANCE);
        f200410c = true;
        setUncaughtExceptionHandler(new a(getUncaughtExceptionHandler()));
    }

    @JvmStatic
    public static final BdpTask curThreadTask() {
        return f200408a.j1();
    }

    @JvmStatic
    public static final ExecutorService getIOExecutor() {
        return (com.bytedance.bdp.appbase.base.bdptask.a) f200409b.getValue();
    }

    @JvmStatic
    public static final Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return f200408a.n2();
    }

    @JvmStatic
    public static final boolean isOnCPUPool() {
        BdpTask r100 = f200408a.j1();
        if (r100 == null) goto L5;
        BdpTask.TaskType r101 = r100.taskType;
    L7:
        if (r101 != BdpTask.TaskType.CPU) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    @JvmStatic
    public static final boolean isOnIOPool() {
        BdpTask r100 = f200408a.j1();
        if (r100 == null) goto L5;
        BdpTask.TaskType r101 = r100.taskType;
    L7:
        if (r101 != BdpTask.TaskType.IO) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    @JvmStatic
    public static final boolean isOnOWNPool() {
        BdpTask r100 = f200408a.j1();
        if (r100 == null) goto L5;
        BdpTask.TaskType r101 = r100.taskType;
    L7:
        if (r101 != BdpTask.TaskType.OWN) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    @JvmStatic
    public static final void preStartPoolThreads() {
        f200408a.T();
    }

    @JvmStatic
    public static final void triggerMainTask() {
        if (f200410c == true) goto L5;
        return;
    L5:
        if (isOnMain() == false) goto L9;
        f200408a.d1();
        return;
    }

    @JvmStatic
    public static final boolean isOnLogic() {
        return Intrinsics.areEqual("Bdp-Logic", ThreadMethodProxy.currentThread().getName());
    }

    @JvmStatic
    public static final boolean isOnMain() {
        return Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
    }

    @JvmStatic
    public static final <T> void cancelAll(ArrayList<Future<T>> r100) {
        f200408a.y1(r100);
    }

    @JvmStatic
    public static final void cancelGroup(j r100) {
        cancelGroup(r100.f200513b, true);
    }

    @JvmStatic
    public static final void cancelRunnable(Runnable r100) {
        cancelRunnable(r100, true);
    }

    @JvmStatic
    public static final void cancelTask(int r100) {
        cancelTask(r100, true);
    }

    @JvmStatic
    public static final void directRun(Runnable r100) {
        directRun("", new b(r100));
    }

    @JvmStatic
    public static final int execute(BdpTask r100) {
        if (BdpTrace.a() != null) goto L6;
        return ((Number) directRun("BdpPool.execute", new c(r100))).intValue();
    L6:
        return f200408a.s1(r100);
    }

    @JvmStatic
    public static final void executeQuickly(Runnable r100) {
        execute(new BdpTask.Builder().onCPU().nonCancel().runnable(r100).build());
    }

    @JvmStatic
    public static final Object futureGet(int r100) throws ExecutionException, InterruptedException {
        return f200408a.V1(r100);
    }

    @JvmStatic
    public static final int getGroupTaskCount(int r100) {
        return f200408a.m(r100);
    }

    @JvmStatic
    public static final int getMaxConcurrentAndReset(BdpTask.TaskType r100) {
        return f200408a.m1(r100);
    }

    @JvmStatic
    public static final PoolStatus getPoolStatus(BdpTask.TaskType r100) {
        return f200408a.f1(r100);
    }

    @JvmStatic
    public static final void postIOQuickly(Runnable r100) {
        execute(new BdpTask.Builder().onIO().nonCancel().runnable(r100).build());
    }

    @JvmStatic
    public static final int postLogic(Runnable r100) {
        return postLogic(0, r100);
    }

    @JvmStatic
    public static final void postLogicQuickly(Runnable r100) {
        execute(new BdpTask.Builder().onLogic().nonCancel().runnable(r100).build());
    }

    @JvmStatic
    public static final int postMain(Function0<Unit> r100) {
        return postMain(null, 0, r100);
    }

    @JvmStatic
    public static final int runOnAsyncIfMain(Runnable r100) {
        return runOnAsyncIfMain(null, BdpTask.TaskType.CPU, r100);
    }

    @JvmStatic
    public static final int runOnMain(Runnable r100) {
        return runOnMain(null, r100);
    }

    @JvmStatic
    public static final void runOnMainQuickly(Runnable r100) {
        if (isOnMain() == false) goto L5;
        directRun("", new g(r100));
        return;
    L5:
        execute(new BdpTask.Builder().runnable(r100).onMain().nonCancel().build());
    }

    @JvmStatic
    public static final void setTaskExecuteStatusListener(TaskExecuteStatusListener r100) {
        f200408a.a0(r100);
    }

    @JvmStatic
    public static final void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler r100) {
        f200408a.setUncaughtExceptionHandler(r100);
    }

    @JvmStatic
    public static final int urgentRunOnMain(Runnable r100) {
        if (isOnMain() == false) goto L6;
        directRun(r100);
        return 0;
    L6:
        return execute(new BdpTask.Builder().runnable(r100).onMain().head().nonCancel().priority(Integer.MIN_VALUE).build());
    }

    @JvmStatic
    public static final int execute(Runnable r100) {
        return execute(null, BdpTask.TaskType.CPU, r100);
    }

    @JvmStatic
    public static final void executeQuickly(Function0<Unit> r100) {
        execute(new BdpTask.Builder().onCPU().nonCancel().runnable(r100).build());
    }

    @JvmStatic
    public static final void postIOQuickly(Function0<Unit> r100) {
        execute(new BdpTask.Builder().onIO().nonCancel().runnable(r100).build());
    }

    @JvmStatic
    public static final void postLogicQuickly(Function0<Unit> r100) {
        execute(new BdpTask.Builder().onLogic().nonCancel().runnable(r100).build());
    }

    @JvmStatic
    public static final int postMain(Runnable r100) {
        return postMain(0, r100);
    }

    @JvmStatic
    public static final int runOnAsyncIfMain(Function0<Unit> r100) {
        return runOnAsyncIfMain(null, BdpTask.TaskType.CPU, r100);
    }

    @JvmStatic
    public static final int runOnMain(Function0<Unit> r100) {
        return runOnMain(null, r100);
    }

    @JvmStatic
    public static final void runOnMainQuickly(Function0<Unit> r100) {
        if (isOnMain() == false) goto L5;
        directRun("", new f(r100));
        return;
    L5:
        execute(new BdpTask.Builder().runnable(r100).onMain().nonCancel().build());
    }

    @JvmStatic
    public static final int execute(Function0<Unit> r100) {
        return execute(null, BdpTask.TaskType.CPU, r100);
    }

    @JvmStatic
    public static final void cancelGroup(int r100, boolean r101) {
        f200408a.k0(r100, r101);
    }

    @JvmStatic
    public static final void cancelRunnable(Runnable r100, boolean r101) {
        f200408a.o1(r100, r101);
    }

    @JvmStatic
    public static final void cancelTask(int r100, boolean r101) {
        f200408a.H0(r100, r101);
    }

    @JvmStatic
    public static final <V> V directRun(String r100, Callable<V> r101) {
        return (V) directRun(r100, null, r101);
    }

    @JvmStatic
    public static final int execute(BdpTask.TaskType r100, Runnable r101) {
        return execute(null, r100, r101);
    }

    @JvmStatic
    public static final int postLogic(long r100, Runnable r101) {
        return postLogic(null, r100, r101);
    }

    @JvmStatic
    public static final int postMain(long r100, Runnable r101) {
        return postMain(null, r100, r101);
    }

    @JvmStatic
    public static final int runOnAsyncIfMain(BdpTask.TaskType r100, Runnable r101) {
        return runOnAsyncIfMain(null, r100, r101);
    }

    @JvmStatic
    public static final int runOnMain(LifecycleOwner r100, Function0<Unit> r101) {
        if (isOnMain() == false) goto L6;
        directRun("", new e(r101));
        return 0;
    L6:
        return postMain(r100, 0, r101);
    }

    @JvmStatic
    public static final int execute(BdpTask.TaskType r100, Function0<Unit> r101) {
        return execute(null, r100, r101);
    }

    @JvmStatic
    public static final int runOnMain(LifecycleOwner r100, Runnable r101) {
        if (isOnMain() == false) goto L6;
        directRun(r101);
        return 0;
    L6:
        return postMain(r100, 0, r101);
    }

    @JvmStatic
    public static final <V> V directRun(String r110, LinkedList<TracePoint> r111, Callable<V> r112) {
        if (BdpTrace.ENABLE == true) goto L6;
        triggerMainTask();
        V r113 = r112.call();
        triggerMainTask();
        return r113;
    L6:
        triggerMainTask();
        boolean r100 = false;
        if (r110.length() <= 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        long r102 = System.currentTimeMillis();
    L13:
        LinkedList<TracePoint> r103 = BdpTrace.a();
        if (r111 != null) goto L16;
    L20:
        String r104 = "";
    L21:
        if (r103 == null) goto L25;
        if (r111 != null) goto L25;
        LinkedList<TracePoint> r105 = r103;
    L27:
        if (r111 != null) goto L51;
    L29:
        TracePoint r114 = new TracePoint(r110, r104, 1);     // Catch: Throwable -> L43
        k.d(r114);     // Catch: Throwable -> L43
        if (r110.length() <= 0) goto L32;
        boolean r106 = true;
    L33:
        if (r106 == false) goto L35;
        k.b(r105, r114);     // Catch: Throwable -> L43
    L35:
        V r115 = r112.call();     // Catch: Throwable -> L43
        if (r110.length() <= 0) goto L39;
        r100 = true;
    L39:
        if (r100 == false) goto L41;
        k.b(r105, new TracePoint("FIN(" + (System.currentTimeMillis() - r102) + ") " + r110, "", 4));
    L41:
        k.e();
        k.f200515b.set(r103);
        triggerMainTask();
        return r115;
    L43:
        th = move-exception;
        if (r110.length() <= 0) goto L47;
        r100 = true;
    L47:
        if (r100 == false) goto L49;
        k.b(r105, new TracePoint("FIN(" + (System.currentTimeMillis() - r102) + ") " + r110, "", 4));
    L49:
        k.e();
        k.f200515b.set(r103);
        throw th;
    L32:
        r106 = false;
        goto L33
    L51:
        BdpTrace.b(r111);     // Catch: Throwable -> L43
    L25:
        r105 = new LinkedList();
        k.f200515b.set(r105);
        goto L27
    L16:
        if (r111.size() <= 0) goto L20;
        TracePoint r107 = r111.getFirst();
        if (r107.event != 3) goto L20;
        r104 = r107.getEventKey();
        goto L21
    L12:
        r102 = 0;
        goto L13
    L9:
        r101 = false;
        goto L10
    }

    @JvmStatic
    public static final int execute(LifecycleOwner r100, BdpTask.TaskType r101, Runnable r102) {
        BdpTask.Builder r103 = new BdpTask.Builder().runnable(r102);
        if (r101 != null) goto L6;
        r101 = BdpTask.TaskType.CPU;
    L6:
        return execute(r103.taskType(r101).lifecycleOnlyDestroy(r100).build());
    }

    @JvmStatic
    public static final Object futureGet(int r100, long r101, TimeUnit r102) throws ExecutionException, InterruptedException, TimeoutException {
        return f200408a.U(r100, r101, r102);
    }

    @JvmStatic
    public static final int postLogic(LifecycleOwner r100, long r101, Runnable r102) {
        return execute(new BdpTask.Builder().runnable(r102).delayed(r101, TimeUnit.MILLISECONDS).lifecycleOnlyDestroy(r100).onLogic().build());
    }

    @JvmStatic
    public static final int postMain(LifecycleOwner r100, long r101, Runnable r102) {
        return execute(new BdpTask.Builder().runnable(r102).delayed(r101, TimeUnit.MILLISECONDS).lifecycleOnlyDestroy(r100).onMain().build());
    }

    @JvmStatic
    public static final int runOnAsyncIfMain(LifecycleOwner r100, BdpTask.TaskType r101, Function0<Unit> r102) {
        if (isOnMain() == false) goto L7;
        if (r101 != null) goto L9;
        r101 = BdpTask.TaskType.CPU;
    L9:
        return execute(r100, r101, r102);
    L7:
        directRun("", new d(r102));
        return 0;
    }

    @JvmStatic
    public static final int execute(LifecycleOwner r100, BdpTask.TaskType r101, Function0<Unit> r102) {
        BdpTask.Builder r103 = new BdpTask.Builder().runnable(r102);
        if (r101 != null) goto L6;
        r101 = BdpTask.TaskType.CPU;
    L6:
        return execute(r103.taskType(r101).lifecycleOnlyDestroy(r100).build());
    }

    @JvmStatic
    public static final int postLogic(LifecycleOwner r100, long r101, Function0<Unit> r102) {
        return execute(new BdpTask.Builder().runnable(r102).delayed(r101, TimeUnit.MILLISECONDS).lifecycleOnlyDestroy(r100).onLogic().build());
    }

    @JvmStatic
    public static final int postMain(LifecycleOwner r100, long r101, Function0<Unit> r102) {
        return execute(new BdpTask.Builder().runnable(r102).delayed(r101, TimeUnit.MILLISECONDS).lifecycleOnlyDestroy(r100).onMain().build());
    }

    @JvmStatic
    public static final int runOnAsyncIfMain(LifecycleOwner r100, BdpTask.TaskType r101, Runnable r102) {
        if (isOnMain() == false) goto L7;
        if (r101 != null) goto L9;
        r101 = BdpTask.TaskType.CPU;
    L9:
        return execute(r100, r101, r102);
    L7:
        directRun(r102);
        return 0;
    }
}
