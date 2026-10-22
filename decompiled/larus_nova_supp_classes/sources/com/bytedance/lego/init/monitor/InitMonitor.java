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
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IEnsure;
import com.bytedance.services.apm.api.ILaunchTrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bR\u0010SJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\nJ\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\nJ\u001e\u0010)\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0002J\u0016\u0010/\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0002J\u0016\u00103\u001a\u00020\u00062\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020'J\u000e\u0010/\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,J\u0006\u00104\u001a\u00020\u0006R\u0014\u00105\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00106R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R&\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040;0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001d\u0010F\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010HR\u0014\u0010J\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\bJ\u00106R\u0014\u0010K\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\bK\u00106R\u0014\u0010L\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u00106R\u0014\u0010M\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u00106R\u0014\u0010N\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bN\u00106R\u0014\u0010O\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u00106R\u0014\u0010P\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bP\u00106R\u0014\u0010Q\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bQ\u00106R\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010H¨\u0006T"}, d2 = {"Lcom/bytedance/lego/init/monitor/InitMonitor;", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "key", XmlPullParser.NO_NAMESPACE, "cosTime", XmlPullParser.NO_NAMESPACE, "addDuration", "Lbf6/f;", "taskInfo", XmlPullParser.NO_NAMESPACE, "isMainThread", "getTaskTag", "Lbf6/g;", "getPeriodTaskTag", "name", "getMonitorTag", "getTaskStartTag", "getTaskEndTag", "getMonitorStartTag", "getMonitorEndTag", "monitorTaskTimeout", "delay", "sendStartUpTimeAsync", "sendStartUpTimeAsyncInternal", "onAttachBase", "allow", "allowMonitor", "monitorCosTime", "monitorTaskStart", "monitorTaskEnd", "monitorStart", "monitorEnd", "monitor", "needUploadTask", "onFeedFirstShown", "Lcom/bytedance/lego/init/monitor/Category;", "category", "type", "Lorg/json/JSONObject;", "extraLog", "monitorEvent", "taskId", "onTaskTimeout", XmlPullParser.NO_NAMESPACE, "t", "msg", "ensureNotReachHere", "Lcom/bytedance/lego/init/monitor/LogType;", "logType", "logExtr", "monitorLog", "sendStartUpTimeImmediately", "MONITOR_INIT", "Ljava/lang/String;", "MONITOR_INIT_EXCEPTION", "onAttachBaseTime", "J", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/util/Pair;", "cosTimeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", XmlPullParser.NO_NAMESPACE, "timeoutTaskList", "Ljava/util/List;", "Lcom/bytedance/services/apm/api/ILaunchTrace;", "launchTraceService$delegate", "Lkotlin/Lazy;", "getLaunchTraceService", "()Lcom/bytedance/services/apm/api/ILaunchTrace;", "launchTraceService", "alreadyFeedShown", "Z", "alreadyUpload", "ALL_FEED_FIRST_SHOWN", "INIT_SCHEDULER", "TASKDISPATCHER_INIT", "WAIT_ASYNC_TASK_INIT", "TASK_START_SUFFIX", "TASK_END_SUFFIX", "MAIN", "ASYNC", "<init>", "()V", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
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
        Lazy r0 = launchTraceService$delegate;
        KProperty r1 = $$delegatedProperties[0];
        return (ILaunchTrace) r0.getValue();
    }

    private final boolean monitorTaskTimeout() {
        List<String> r1 = timeoutTaskList;     // Catch: Exception -> L13
        if (r1.isEmpty() == false) goto L6;
        return false;
    L6:
        Iterator<T> r2 = r1.iterator();     // Catch: Exception -> L13
    L8:
        if (r2.hasNext() == false) goto L10;
        String r3 = (String) r2.next();     // Catch: Exception -> L13
        InitMonitor r4 = INSTANCE;     // Catch: Exception -> L13
        Category r5 = Category.TASK_TIMEOUT_EXCEPTION_REAL;     // Catch: Exception -> L13
        StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L13
        InitScheduler r7 = InitScheduler.INSTANCE;     // Catch: Exception -> L13
        r6.append(r7.getConfig$initscheduler_release().getTimeout());     // Catch: Exception -> L13
        r6.append(':');     // Catch: Exception -> L13
        r6.append(r3);     // Catch: Exception -> L13
        r4.monitorEvent(r5, r6.toString(), new JSONObject());     // Catch: Exception -> L13
        int r8 = c.a;     // Catch: Exception -> L13
        c.b("TaskTimeout: " + r3 + ", " + r7.getConfig$initscheduler_release().getTimeout());     // Catch: Exception -> L13
        goto L8
    L10:
        sendStartUpTimeAsyncInternal();     // Catch: Exception -> L13
        return true;
    L13:
        e = move-exception;
        e.printStackTrace();
        int r9 = c.a;
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
        IApmAgent r1 = (IApmAgent) n.b.a(IApmAgent.class);     // Catch: Throwable -> L23
        if (r1 == null) goto L21;
        alreadyFeedShown = true;     // Catch: Throwable -> L23
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L23
        Iterator<T> r2 = cosTimeList.iterator();     // Catch: Exception -> L16 Throwable -> L23
    L13:
        if (r2.hasNext() == false) goto L18;
        Pair r3 = (Pair) r2.next();     // Catch: Exception -> L16 Throwable -> L23
        r0.put((String) r3.first, ((Number) r3.second).longValue());     // Catch: Exception -> L16 Throwable -> L23
    L18:
        int r4 = c.a;     // Catch: Throwable -> L23
        c.a("sendStartUpTimeAsync", r0.toString());     // Catch: Throwable -> L23
        InitTaskDispatcher.o.getClass();     // Catch: Throwable -> L23
        InitTaskDispatcher.b.beforeSendMonitor();     // Catch: Throwable -> L23
        r1.monitorEvent(MONITOR_INIT, new JSONObject(), r0, new JSONObject());     // Catch: Throwable -> L23
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
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L11 Exception -> L13
        r0.put("curTime", System.currentTimeMillis() - onAttachBaseTime);     // Catch: Throwable -> L11 Exception -> L13
        Iterator<T> r1 = cosTimeList.iterator();     // Catch: Throwable -> L11 Exception -> L13
    L5:
        if (r1.hasNext() == false) goto L7;
        Pair r2 = (Pair) r1.next();     // Catch: Throwable -> L11 Exception -> L13
        r0.put((String) r2.first, ((Number) r2.second).longValue());     // Catch: Throwable -> L11 Exception -> L13
        goto L5
    L7:
        int r3 = c.a;     // Catch: Throwable -> L11 Exception -> L13
        c.a("sendStartUpTimeImmediately", r0.toString());     // Catch: Throwable -> L11 Exception -> L13
        IApmAgent r4 = (IApmAgent) n.b.a(IApmAgent.class);     // Catch: Throwable -> L11 Exception -> L13
        if (r4 == null) goto L15;
        r4.monitorEvent(MONITOR_INIT, new JSONObject(), r0, new JSONObject());     // Catch: Throwable -> L11 Exception -> L13
    L15:
        monitor-exit(this);
        return;
    L13:
        e = move-exception;
        int r5 = c.a;     // Catch: Throwable -> L11
        c.b(Log.getStackTraceString(e));     // Catch: Throwable -> L11
        Category r6 = Category.OTHER_EXCEPTION;     // Catch: Throwable -> L11
        String r7 = "sendStartUpTimeImmediately" + e.getClass().getName();     // Catch: Throwable -> L11
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L11
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L11
        r9.put("exception_detail", Log.getStackTraceString(e));     // Catch: Throwable -> L11
        r8.put("exception_detail", r9);     // Catch: Throwable -> L11
        monitorEvent(r6, r7, r8);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final void onAttachBase() {
        onAttachBaseTime = System.currentTimeMillis();
        b.c.getClass();
        b.a = System.currentTimeMillis();
        ILaunchTrace r0 = getLaunchTraceService();
        if (r0 == null) goto L6;
        r0.startTrace();
        return;
    }

    public static final /* synthetic */ void access$sendStartUpTimeAsyncInternal(InitMonitor r0) {
        r0.sendStartUpTimeAsyncInternal();
    }

    private final void sendStartUpTimeAsync(long r3) {
        new Handler(Looper.getMainLooper()).postDelayed(a.a, r3);
    }

    public final void allowMonitor(boolean r1) {
        allowMonitor = r1;
    }

    public final void ensureNotReachHere(Throwable r3) {
        IEnsure r0 = (IEnsure) n.b.a(IEnsure.class);
        if (r0 == null) goto L6;
        r0.ensureNotReachHere(r3);
        return;
    }

    public final void monitor(String r5) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(r5, System.currentTimeMillis() - onAttachBaseTime);
    }

    public final void onFeedFirstShown(boolean r9) {
        long r1 = System.currentTimeMillis() - onAttachBaseTime;     // Catch: Exception -> L24
        if (r1 > 30000) goto L6;
        boolean r3 = monitorTaskTimeout();     // Catch: Exception -> L24
    L7:
        if (r9 == true) goto L13;
        ILaunchTrace r10 = getLaunchTraceService();     // Catch: Exception -> L24
        if (r10 == null) goto L11;
        r10.cancelTrace();     // Catch: Exception -> L24
    L11:
        cosTimeList.clear();     // Catch: Exception -> L24
        return;
    L13:
        ILaunchTrace r11 = getLaunchTraceService();     // Catch: Exception -> L24
        if (r11 == null) goto L20;
        Activity r4 = InitScheduler.getMainActivity$initscheduler_release();     // Catch: Exception -> L24
        if (r4 == null) goto L18;
        String r5 = r4.getClass().getName();     // Catch: Exception -> L24
    L19:
        r11.endTrace(2, r5, 20000);     // Catch: Exception -> L24
        goto L20
    L18:
        r5 = null;
    L20:
        addDuration(ALL_FEED_FIRST_SHOWN, r1);     // Catch: Exception -> L24
        int r12 = c.a;     // Catch: Exception -> L24
        c.b("onFeedFirstShown: cos " + r1 + " ms.");     // Catch: Exception -> L24
        if (r3 == true) goto L28;
        sendStartUpTimeAsync(5000);     // Catch: Exception -> L24
        return;
    L28:
        return;
    L6:
        r3 = false;
    L24:
        e = move-exception;
        ensureNotReachHere(e, "ON_FEED_FIRST_SHOW_EXCEPTION");
        Category r0 = Category.OTHER_EXCEPTION;
        String r2 = e.getClass().getName();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        r7.put("exception_detail", Log.getStackTraceString(e));
        r6.put("exception_detail", r7);
        monitorEvent(r0, r2, r6);
    }

    public final void onTaskTimeout(String r2) {
        timeoutTaskList.add(r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        int r0 = c.a;
        Log.getStackTraceString(e);
    }

    private final synchronized void addDuration(String r3, long r4) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (alreadyFeedShown == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        cosTimeList.add(new Pair(r3, Long.valueOf(r4)));     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private final String getMonitorEndTag(String r3, boolean r4) {
        if (r4 == false) goto L7;
        return MAIN + r3 + TASK_END_SUFFIX;
    L7:
        return ASYNC + r3 + TASK_END_SUFFIX;
    }

    private final String getMonitorStartTag(String r3, boolean r4) {
        if (r4 == false) goto L7;
        return MAIN + r3 + TASK_START_SUFFIX;
    L7:
        return ASYNC + r3 + TASK_START_SUFFIX;
    }

    private final String getMonitorTag(String r2, boolean r3) {
        if (r3 == false) goto L6;
        return MAIN + r2;
    L6:
        return ASYNC + r2;
    }

    private final String getPeriodTaskTag(g r1, boolean r2) {
        if (r2 == false) goto L5;
        r1.getClass();
        return "Main:null";
    L5:
        r1.getClass();
        return "Async:null";
    }

    private final String getTaskEndTag(f r3, boolean r4) {
        if (r4 == false) goto L7;
        return MAIN + r3.a + TASK_END_SUFFIX;
    L7:
        return ASYNC + r3.a + TASK_END_SUFFIX;
    }

    private final String getTaskStartTag(f r3, boolean r4) {
        if (r4 == false) goto L7;
        return MAIN + r3.a + TASK_START_SUFFIX;
    L7:
        return ASYNC + r3.a + TASK_START_SUFFIX;
    }

    private final String getTaskTag(f r2, boolean r3) {
        if (r3 == false) goto L6;
        return "Main:Task-" + r2.a;
    L6:
        return "Async:Task-" + r2.a;
    }

    public final void ensureNotReachHere(Throwable r5, String r6) {
        n r0 = n.b;
        IEnsure r1 = (IEnsure) r0.a(IEnsure.class);
        if (r1 == null) goto L5;
        r1.ensureNotReachHere(r5, r6);
    L5:
        IApmAgent r2 = (IApmAgent) r0.a(IApmAgent.class);
        if (r2 == null) goto L9;
        JSONObject r3 = new JSONObject();
        r3.put("EnsureNotReachHere", r6);
        JSONObject r7 = new JSONObject();
        JSONObject r4 = new JSONObject();
        r4.put("detail", Log.getStackTraceString(r5));
        r2.monitorEvent(MONITOR_INIT_EXCEPTION, r3, r7, r4);
        return;
    }

    public final void monitorEnd(String r5, boolean r6) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getMonitorEndTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r7 = getLaunchTraceService();
        if (r7 == null) goto L9;
        r7.endSpan(INIT_SCHEDULER, r5);
        return;
    }

    public final void monitorLog(LogType r3, JSONObject r4) {
        IApmAgent r0 = (IApmAgent) n.b.a(IApmAgent.class);
        if (r0 == null) goto L6;
        r0.monitorLog(r3.name(), r4);
        int r1 = c.a;
        c.b(r3.name() + " " + r4.toString());
        return;
    }

    public final void monitorStart(String r5, boolean r6) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getMonitorStartTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r7 = getLaunchTraceService();
        if (r7 == null) goto L9;
        r7.startSpan(INIT_SCHEDULER, r5);
        return;
    }

    public final void monitorTaskEnd(f r5, boolean r6) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getTaskEndTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r7 = getLaunchTraceService();
        if (r7 == null) goto L9;
        r5.getClass();
        r7.endSpan(null, r5.a);
        return;
    }

    public final void monitorTaskStart(f r5, boolean r6) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getTaskStartTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r7 = getLaunchTraceService();
        if (r7 == null) goto L9;
        r5.getClass();
        r7.startSpan(null, r5.a);
        return;
    }

    public final void monitorCosTime(f r2, long r3, boolean r5) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getTaskTag(r2, r5), r3);
    }

    public final void monitorEvent(Category r5, String r6, JSONObject r7) {
        IApmAgent r0 = (IApmAgent) n.b.a(IApmAgent.class);
        if (r0 == null) goto L13;
        JSONObject r1 = new JSONObject();
        r1.put(r5.getValue(), r6);     // Catch: Exception -> L7
    L9:
        r7.put("processName", InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName());
        r7.put("isUIThread", Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
        r0.monitorEvent(MONITOR_INIT, r1, new JSONObject(), r7);
        int r2 = c.a;
        c.b(r5.name() + ' ' + r6 + ' ' + r7.toString());
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public final void monitorCosTime(g r2, long r3, boolean r5) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getPeriodTaskTag(r2, r5), r3);
    }

    public final void monitorCosTime(String r2, long r3, boolean r5) {
        if (allowMonitor == true) goto L5;
        return;
    L5:
        addDuration(getMonitorTag(r2, r5), r3);
    }
}
