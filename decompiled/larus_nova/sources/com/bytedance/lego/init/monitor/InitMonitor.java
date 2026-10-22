package com.bytedance.lego.init.monitor;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import bf6.f;
import bf6.g;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.InitTaskDispatcher;
import com.bytedance.lego.init.n;
import com.bytedance.lego.init.util.c;
import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IEnsure;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bR\u0010SJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\nJ\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\nJ\u001e\u0010)\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0002J\u0016\u0010/\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0002J\u0016\u00103\u001a\u00020\u00062\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020'J\u000e\u0010/\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,J\u0006\u00104\u001a\u00020\u0006R\u0014\u00105\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00106R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R&\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040;0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001d\u0010F\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010HR\u0014\u0010J\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\bJ\u00106R\u0014\u0010K\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\bK\u00106R\u0014\u0010L\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u00106R\u0014\u0010M\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u00106R\u0014\u0010N\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bN\u00106R\u0014\u0010O\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u00106R\u0014\u0010P\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bP\u00106R\u0014\u0010Q\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bQ\u00106R\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010H¨\u0006T"}, d2 = {"Lcom/bytedance/lego/init/monitor/InitMonitor;", "", "", "key", "", "cosTime", "", "addDuration", "Lbf6/f;", "taskInfo", "", "isMainThread", "getTaskTag", "Lbf6/g;", "getPeriodTaskTag", "name", "getMonitorTag", "getTaskStartTag", "getTaskEndTag", "getMonitorStartTag", "getMonitorEndTag", "monitorTaskTimeout", "delay", "sendStartUpTimeAsync", "sendStartUpTimeAsyncInternal", "onAttachBase", "allow", "allowMonitor", "monitorCosTime", "monitorTaskStart", "monitorTaskEnd", "monitorStart", "monitorEnd", "monitor", "needUploadTask", "onFeedFirstShown", "Lcom/bytedance/lego/init/monitor/Category;", "category", "type", "Lorg/json/JSONObject;", "extraLog", "monitorEvent", DBDefinition.TASK_ID, "onTaskTimeout", "", "t", "msg", "ensureNotReachHere", "Lcom/bytedance/lego/init/monitor/LogType;", "logType", "logExtr", "monitorLog", "sendStartUpTimeImmediately", "MONITOR_INIT", "Ljava/lang/String;", "MONITOR_INIT_EXCEPTION", "onAttachBaseTime", "J", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/util/Pair;", "cosTimeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "timeoutTaskList", "Ljava/util/List;", "Lcom/bytedance/services/apm/api/ILaunchTrace;", "launchTraceService$delegate", "Lkotlin/Lazy;", "getLaunchTraceService", "()Lcom/bytedance/services/apm/api/ILaunchTrace;", "launchTraceService", "alreadyFeedShown", "Z", "alreadyUpload", "ALL_FEED_FIRST_SHOWN", "INIT_SCHEDULER", "TASKDISPATCHER_INIT", "WAIT_ASYNC_TASK_INIT", "TASK_START_SUFFIX", "TASK_END_SUFFIX", AccountType.MAIN, BridgeSyncType.ASYNC, "<init>", "()V", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
public final class InitMonitor {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private static final String ALL_FEED_FIRST_SHOWN = "ALLFeedFirstShown";
    public static final String ASYNC = "Async:";
    private static final String INIT_SCHEDULER = "init-scheduler";
    public static final InitMonitor INSTANCE = null;
    public static final String MAIN = "Main:";
    private static final String MONITOR_INIT = "init_task_monitor";
    private static final String MONITOR_INIT_EXCEPTION = "init_task_exception_monitor";
    public static final String TASKDISPATCHER_INIT = "InitTaskDispatcher.init";
    public static final String TASK_END_SUFFIX = "##TASKEND";
    public static final String TASK_START_SUFFIX = "##TASKSTART";
    public static final String WAIT_ASYNC_TASK_INIT = "wait_async_task_init";
    private static boolean allowMonitor;
    private static volatile boolean alreadyFeedShown;
    private static volatile boolean alreadyUpload;
    private static final CopyOnWriteArrayList<Pair<String, Long>> cosTimeList = null;
    private static final Lazy launchTraceService$delegate = null;
    private static long onAttachBaseTime;
    private static final List<String> timeoutTaskList = null;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f254542a = null;

        /* JADX INFO: renamed from: com.bytedance.lego.init.monitor.InitMonitor$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes20.dex */
        public static final class RunnableC3621a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final RunnableC3621a f254543a = null;

            static {
                f254543a = new RunnableC3621a();
            }

            public RunnableC3621a() {
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            public static void a() {
                InitMonitor.access$sendStartUpTimeAsyncInternal(InitMonitor.INSTANCE);     // Catch: Exception -> L4
                return;
            L4:
                e = move-exception;
                InitMonitor r100 = InitMonitor.INSTANCE;
                Category r101 = Category.OTHER_EXCEPTION;
                String r102 = e.getClass().getName();
                JSONObject r103 = new JSONObject();
                JSONObject r104 = new JSONObject();
                r104.put("exception_detail", Log.getStackTraceString(e));
                r103.put("exception_detail", r104);
                r100.monitorEvent(r101, r102, r103);
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

        static {
            f254542a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RunnableC3621a r100 = RunnableC3621a.f254543a;     // Catch: Throwable -> L9
            ThreadPoolExecutor r101 = InitScheduler.INSTANCE.getExecutorServiceOrNull$initscheduler_release();     // Catch: Throwable -> L9
            if (r101 != null) goto L5;
        L7:
            String r102 = InitMonitor.TASKDISPATCHER_INIT;     // Catch: Throwable -> L9
            ThreadMethodProxy.start(new PthreadThreadV2(r100, "InitMonitor$sendStartUpTimeAsync$1"));     // Catch: Throwable -> L9
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
            return;
        L5:
            if (r101.submit(r100) == null) goto L7;
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitMonitor.class), "launchTraceService", "getLaunchTraceService()Lcom/bytedance/services/apm/api/ILaunchTrace;"))};
        INSTANCE = new InitMonitor();
        cosTimeList = new CopyOnWriteArrayList();
        timeoutTaskList = new ArrayList();
        launchTraceService$delegate = LazyKt.lazy(InitMonitor$launchTraceService$2.INSTANCE);
        ALL_FEED_FIRST_SHOWN = "ALLFeedFirstShown";
        INIT_SCHEDULER = "init-scheduler";
        allowMonitor = true;
    }

    private InitMonitor() {
    }

    private final ILaunchTrace getLaunchTraceService() {
        Lazy r100 = launchTraceService$delegate;
        KProperty r101 = $$delegatedProperties[0];
        return (ILaunchTrace) r100.getValue();
    }

    private final boolean monitorTaskTimeout() {
        List<String> r100 = timeoutTaskList;     // Catch: Exception -> L13
        if (r100.isEmpty() == false) goto L6;
        return false;
    L6:
        Iterator<T> r101 = r100.iterator();     // Catch: Exception -> L13
    L8:
        if (r101.hasNext() == false) goto L10;
        String r102 = (String) r101.next();     // Catch: Exception -> L13
        InitMonitor r103 = INSTANCE;     // Catch: Exception -> L13
        Category r104 = Category.TASK_TIMEOUT_EXCEPTION_REAL;     // Catch: Exception -> L13
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L13
        InitScheduler r106 = InitScheduler.INSTANCE;     // Catch: Exception -> L13
        r105.append(r106.getConfig$initscheduler_release().getTimeout());     // Catch: Exception -> L13
        r105.append(':');     // Catch: Exception -> L13
        r105.append(r102);     // Catch: Exception -> L13
        r103.monitorEvent(r104, r105.toString(), new JSONObject());     // Catch: Exception -> L13
        int r107 = c.f254571a;     // Catch: Exception -> L13
        c.b("TaskTimeout: " + r102 + ", " + r106.getConfig$initscheduler_release().getTimeout());     // Catch: Exception -> L13
        goto L8
    L10:
        sendStartUpTimeAsyncInternal();     // Catch: Exception -> L13
        return true;
    L13:
        e = move-exception;
        e.printStackTrace();
        int r108 = c.f254571a;
        Log.getStackTraceString(e);
        return false;
    }

    private final synchronized void sendStartUpTimeAsyncInternal() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (alreadyUpload == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        alreadyUpload = true;     // Catch: Throwable -> L23
        IApmAgent r100 = (IApmAgent) n.f254552b.a(IApmAgent.class);     // Catch: Throwable -> L23
        if (r100 == null) goto L21;
        alreadyFeedShown = true;     // Catch: Throwable -> L23
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L23
        Iterator<T> r102 = cosTimeList.iterator();     // Catch: Exception -> L16 Throwable -> L23
    L13:
        if (r102.hasNext() == false) goto L18;
        Pair r103 = (Pair) r102.next();     // Catch: Exception -> L16 Throwable -> L23
        r101.put((String) r103.first, ((Number) r103.second).longValue());     // Catch: Exception -> L16 Throwable -> L23
    L18:
        int r104 = c.f254571a;     // Catch: Throwable -> L23
        c.a("sendStartUpTimeAsync", r101.toString());     // Catch: Throwable -> L23
        InitTaskDispatcher.f254510o.getClass();     // Catch: Throwable -> L23
        InitTaskDispatcher.f254497b.beforeSendMonitor();     // Catch: Throwable -> L23
        r100.monitorEvent(MONITOR_INIT, new JSONObject(), r101, new JSONObject());     // Catch: Throwable -> L23
        cosTimeList.clear();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
        goto L18
    L21:
        monitor-exit(this);
    }

    public final synchronized void sendStartUpTimeImmediately() {
        monitor-enter(this);
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L11 Exception -> L13
        r100.put("curTime", System.currentTimeMillis() - onAttachBaseTime);     // Catch: Throwable -> L11 Exception -> L13
        Iterator<T> r101 = cosTimeList.iterator();     // Catch: Throwable -> L11 Exception -> L13
    L5:
        if (r101.hasNext() == false) goto L7;
        Pair r102 = (Pair) r101.next();     // Catch: Throwable -> L11 Exception -> L13
        r100.put((String) r102.first, ((Number) r102.second).longValue());     // Catch: Throwable -> L11 Exception -> L13
        goto L5
    L7:
        int r103 = c.f254571a;     // Catch: Throwable -> L11 Exception -> L13
        c.a("sendStartUpTimeImmediately", r100.toString());     // Catch: Throwable -> L11 Exception -> L13
        IApmAgent r104 = (IApmAgent) n.f254552b.a(IApmAgent.class);     // Catch: Throwable -> L11 Exception -> L13
        if (r104 == null) goto L15;
        r104.monitorEvent(MONITOR_INIT, new JSONObject(), r100, new JSONObject());     // Catch: Throwable -> L11 Exception -> L13
    L15:
        monitor-exit(this);
        return;
    L13:
        e = move-exception;
        int r105 = c.f254571a;     // Catch: Throwable -> L11
        c.b(Log.getStackTraceString(e));     // Catch: Throwable -> L11
        Category r106 = Category.OTHER_EXCEPTION;     // Catch: Throwable -> L11
        String r107 = "sendStartUpTimeImmediately" + e.getClass().getName();     // Catch: Throwable -> L11
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L11
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L11
        r109.put("exception_detail", Log.getStackTraceString(e));     // Catch: Throwable -> L11
        r108.put("exception_detail", r109);     // Catch: Throwable -> L11
        monitorEvent(r106, r107, r108);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final void onAttachBase() {
        onAttachBaseTime = System.currentTimeMillis();
        b.f254550c.getClass();
        b.f254548a = System.currentTimeMillis();
        ILaunchTrace r100 = getLaunchTraceService();
        if (r100 == null) goto L6;
        r100.startTrace();
        return;
    }

    public static final /* synthetic */ void access$sendStartUpTimeAsyncInternal(InitMonitor r100) {
        r100.sendStartUpTimeAsyncInternal();
    }

    private final void sendStartUpTimeAsync(long r100) {
        new Handler(Looper.getMainLooper()).postDelayed(a.f254542a, r100);
    }

    public final void allowMonitor(boolean r100) {
        allowMonitor = r100;
    }

    public final void ensureNotReachHere(Throwable r100) {
        IEnsure r101 = (IEnsure) n.f254552b.a(IEnsure.class);
        if (r101 == null) goto L6;
        r101.ensureNotReachHere(r100);
        return;
    }

    public final void monitor(String r100) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(r100, System.currentTimeMillis() - onAttachBaseTime);
    }

    public final void onFeedFirstShown(boolean r100) {
        long r101 = System.currentTimeMillis() - onAttachBaseTime;     // Catch: Exception -> L24
        if (r101 > 30000) goto L6;
        boolean r102 = monitorTaskTimeout();     // Catch: Exception -> L24
    L7:
        if (r100 == true) goto L13;
        ILaunchTrace r103 = getLaunchTraceService();     // Catch: Exception -> L24
        if (r103 == null) goto L11;
        r103.cancelTrace();     // Catch: Exception -> L24
    L11:
        cosTimeList.clear();     // Catch: Exception -> L24
        return;
    L13:
        ILaunchTrace r104 = getLaunchTraceService();     // Catch: Exception -> L24
        if (r104 == null) goto L20;
        Activity r105 = InitScheduler.getMainActivity$initscheduler_release();     // Catch: Exception -> L24
        if (r105 == null) goto L18;
        String r106 = r105.getClass().getName();     // Catch: Exception -> L24
    L19:
        r104.endTrace(2, r106, 20000);     // Catch: Exception -> L24
        goto L20
    L18:
        r106 = null;
    L20:
        addDuration(ALL_FEED_FIRST_SHOWN, r101);     // Catch: Exception -> L24
        int r107 = c.f254571a;     // Catch: Exception -> L24
        c.b("onFeedFirstShown: cos " + r101 + " ms.");     // Catch: Exception -> L24
        if (r102 == true) goto L28;
        sendStartUpTimeAsync(5000);     // Catch: Exception -> L24
        return;
    L28:
        return;
    L6:
        r102 = false;
    L24:
        e = move-exception;
        ensureNotReachHere(e, "ON_FEED_FIRST_SHOW_EXCEPTION");
        Category r108 = Category.OTHER_EXCEPTION;
        String r109 = e.getClass().getName();
        JSONObject r110 = new JSONObject();
        JSONObject r111 = new JSONObject();
        r111.put("exception_detail", Log.getStackTraceString(e));
        r110.put("exception_detail", r111);
        monitorEvent(r108, r109, r110);
    }

    public final void onTaskTimeout(String r100) {
        timeoutTaskList.add(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        int r101 = c.f254571a;
        Log.getStackTraceString(e);
    }

    private final synchronized void addDuration(String r100, long r101) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (alreadyFeedShown == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        cosTimeList.add(new Pair(r100, Long.valueOf(r101)));     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private final String getMonitorEndTag(String r100, boolean r101) {
        if (r101 == false) goto L7;
        return MAIN + r100 + TASK_END_SUFFIX;
    L7:
        return ASYNC + r100 + TASK_END_SUFFIX;
    }

    private final String getMonitorStartTag(String r100, boolean r101) {
        if (r101 == false) goto L7;
        return MAIN + r100 + TASK_START_SUFFIX;
    L7:
        return ASYNC + r100 + TASK_START_SUFFIX;
    }

    private final String getMonitorTag(String r100, boolean r101) {
        if (r101 == false) goto L6;
        return MAIN + r100;
    L6:
        return ASYNC + r100;
    }

    private final String getPeriodTaskTag(g r100, boolean r101) {
        if (r101 == false) goto L5;
        r100.getClass();
        return "Main:null";
    L5:
        r100.getClass();
        return "Async:null";
    }

    private final String getTaskEndTag(f r100, boolean r101) {
        if (r101 == false) goto L7;
        return MAIN + r100.f18824a + TASK_END_SUFFIX;
    L7:
        return ASYNC + r100.f18824a + TASK_END_SUFFIX;
    }

    private final String getTaskStartTag(f r100, boolean r101) {
        if (r101 == false) goto L7;
        return MAIN + r100.f18824a + TASK_START_SUFFIX;
    L7:
        return ASYNC + r100.f18824a + TASK_START_SUFFIX;
    }

    private final String getTaskTag(f r100, boolean r101) {
        if (r101 == false) goto L6;
        return "Main:Task-" + r100.f18824a;
    L6:
        return "Async:Task-" + r100.f18824a;
    }

    public final void ensureNotReachHere(Throwable r100, String r101) {
        n r102 = n.f254552b;
        IEnsure r103 = (IEnsure) r102.a(IEnsure.class);
        if (r103 == null) goto L5;
        r103.ensureNotReachHere(r100, r101);
    L5:
        IApmAgent r104 = (IApmAgent) r102.a(IApmAgent.class);
        if (r104 == null) goto L9;
        JSONObject r105 = new JSONObject();
        r105.put("EnsureNotReachHere", r101);
        JSONObject r106 = new JSONObject();
        JSONObject r107 = new JSONObject();
        r107.put("detail", Log.getStackTraceString(r100));
        r104.monitorEvent(MONITOR_INIT_EXCEPTION, r105, r106, r107);
        return;
    }

    public final void monitorEnd(String r100, boolean r101) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getMonitorEndTag(r100, r101), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r102 = getLaunchTraceService();
        if (r102 == null) goto L9;
        r102.endSpan(INIT_SCHEDULER, r100);
        return;
    }

    public final void monitorLog(LogType r100, JSONObject r101) {
        IApmAgent r102 = (IApmAgent) n.f254552b.a(IApmAgent.class);
        if (r102 == null) goto L6;
        r102.monitorLog(r100.name(), r101);
        int r103 = c.f254571a;
        c.b(r100.name() + " " + r101.toString());
        return;
    }

    public final void monitorStart(String r100, boolean r101) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getMonitorStartTag(r100, r101), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r102 = getLaunchTraceService();
        if (r102 == null) goto L9;
        r102.startSpan(INIT_SCHEDULER, r100);
        return;
    }

    public final void monitorTaskEnd(f r100, boolean r101) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getTaskEndTag(r100, r101), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r102 = getLaunchTraceService();
        if (r102 == null) goto L9;
        r100.getClass();
        r102.endSpan(null, r100.f18824a);
        return;
    }

    public final void monitorTaskStart(f r100, boolean r101) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getTaskStartTag(r100, r101), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r102 = getLaunchTraceService();
        if (r102 == null) goto L9;
        r100.getClass();
        r102.startSpan(null, r100.f18824a);
        return;
    }

    public final void monitorCosTime(f r100, long r101, boolean r102) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getTaskTag(r100, r102), r101);
    }

    public final void monitorEvent(Category r100, String r101, JSONObject r102) {
        IApmAgent r103 = (IApmAgent) n.f254552b.a(IApmAgent.class);
        if (r103 == null) goto L13;
        JSONObject r104 = new JSONObject();
        r104.put(r100.getValue(), r101);     // Catch: Exception -> L7
    L9:
        r102.put("processName", InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName());
        r102.put("isUIThread", Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
        r103.monitorEvent(MONITOR_INIT, r104, new JSONObject(), r102);
        int r105 = c.f254571a;
        c.b(r100.name() + ' ' + r101 + ' ' + r102.toString());
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public final void monitorCosTime(g r100, long r101, boolean r102) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getPeriodTaskTag(r100, r102), r101);
    }

    public final void monitorCosTime(String r100, long r101, boolean r102) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getMonitorTag(r100, r102), r101);
    }
}
