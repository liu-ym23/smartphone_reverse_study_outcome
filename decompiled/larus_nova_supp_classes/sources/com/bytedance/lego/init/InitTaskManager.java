package com.bytedance.lego.init;

import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007J\u001b\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0012J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00152\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0012R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00060\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001cj\b\u0012\u0004\u0012\u00020\u0006`\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/lego/init/InitTaskManager;", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "hasNonUiTask", XmlPullParser.NO_NAMESPACE, "initReadyQueue", "Lbf6/f;", "taskInfo", "letTaskReady", "init", XmlPullParser.NO_NAMESPACE, "timeout", "takeUiTaskIfExist", "takeNonUiTaskIfExist", "(Ljava/lang/Long;)Lbf6/f;", "task", "onTaskComplete", "beforeSendMonitor", XmlPullParser.NO_NAMESPACE, "taskId", "getInitTaskInfoById", XmlPullParser.NO_NAMESPACE, "getTaskDependencyById", XmlPullParser.NO_NAMESPACE, "getPriorityByTaskId", XmlPullParser.NO_NAMESPACE, "taskIndex", "Ljava/util/Map;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "unDispatchTask", "Ljava/util/ArrayList;", "Ljava/util/concurrent/PriorityBlockingQueue;", "uiReadyQueue", "Ljava/util/concurrent/PriorityBlockingQueue;", "nonUiReadyQueue", "readWriteLock", "Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicInteger;", "completedTaskCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "TAG", "Ljava/lang/String;", "<init>", "()V", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
public final class InitTaskManager {
    private final String TAG;
    private AtomicInteger completedTaskCount;
    private final PriorityBlockingQueue<bf6.f> nonUiReadyQueue;
    private final Object readWriteLock;
    private Map<String, bf6.f> taskIndex;
    private final PriorityBlockingQueue<bf6.f> uiReadyQueue;
    private final ArrayList<bf6.f> unDispatchTask;

    private final boolean hasNonUiTask() {
        Object r0 = this.readWriteLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L6:
        if ((!this.nonUiReadyQueue.isEmpty()) == false) goto L9;
        monitor-exit(r0);
        return true;
    L9:
        Iterator<T> r1 = this.unDispatchTask.iterator();     // Catch: Throwable -> L19
    L11:
        if (r1.hasNext() == false) goto L16;
        if (((bf6.f) r1.next()).d == true) goto L11;
        monitor-exit(r0);
        return true;
    L16:
        monitor-exit(r0);
        return false;
    }

    private final void initReadyQueue() {
        Collection<bf6.f> r0 = this.taskIndex.values();
        if (r0 == null) goto L12;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L19;
        bf6.f r2 = (bf6.f) r1.next();
        List<String> r3 = r2.j;
        if (r3 == null) goto L11;
        if (r3.isEmpty() == false) goto L6;
    L11:
        letTaskReady(r2);
        goto L6
    L19:
        return;
    }

    public final void beforeSendMonitor() {
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.completedTaskCount.get() == this.taskIndex.size()) goto L16;
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L10
        r0.put("count", this.completedTaskCount.get() - this.taskIndex.size());     // Catch: Exception -> L10
        r0.put("undispatchCount", this.unDispatchTask.size());     // Catch: Exception -> L10
        Iterator<T> r1 = this.unDispatchTask.iterator();     // Catch: Exception -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        r0.put(((bf6.f) r1.next()).a, "task");     // Catch: Exception -> L10
        goto L6
    L8:
        InitMonitor r2 = InitMonitor.INSTANCE;     // Catch: Exception -> L10
        Category r3 = Category.TASK_COUNT_EXCEPTION;     // Catch: Exception -> L10
        String r4 = String.valueOf(this.completedTaskCount.get() - this.taskIndex.size());     // Catch: Exception -> L10
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L10
        r5.put("task_count_exception", r0);     // Catch: Exception -> L10
        r2.monitorEvent(r3, r4, r5);     // Catch: Exception -> L10
        return;
    }

    public InitTaskManager() {
        this.taskIndex = new LinkedHashMap();
        this.unDispatchTask = new ArrayList();
        this.uiReadyQueue = new PriorityBlockingQueue();
        this.nonUiReadyQueue = new PriorityBlockingQueue();
        this.readWriteLock = new Object();
        this.completedTaskCount = new AtomicInteger(0);
        this.TAG = "InitTaskManager";
    }

    public final void init() {
        long r0 = System.currentTimeMillis();
        Map<String, bf6.f> r2 = o.g;
        if (((HashMap) r2).isEmpty() == false) goto L5;
        o.b();
    L5:
        this.taskIndex = r2;
        int r3 = c.a;
        c.b("collect cos: " + (System.currentTimeMillis() - r0) + "ms  size: " + this.taskIndex.size());
        InitMonitor r4 = InitMonitor.INSTANCE;
        r4.monitorCosTime("InitTaskManager.CollectTasks", System.currentTimeMillis() - r0, false);
        this.unDispatchTask.addAll(this.taskIndex.values());
        initReadyQueue();
        InitTaskDispatcher r5 = InitTaskDispatcher.o;
        boolean r6 = this.taskIndex.isEmpty();
        r5.getClass();
        InitTaskDispatcher.l = r6;
        r4.monitorCosTime("InitTaskManager.init", System.currentTimeMillis() - r0, false);
    }

    private final void letTaskReady(bf6.f r4) {
        int r0 = c.a;
        c.a(this.TAG, "letTaskReady: " + r4.a);
        if (r4.d == false) goto L5;
        this.uiReadyQueue.add(r4);
    L6:
        this.unDispatchTask.remove(r4);
        return;
    L5:
        this.nonUiReadyQueue.add(r4);
        goto L6
    }

    public final bf6.f getInitTaskInfoById(String r2) {
        return this.taskIndex.get(r2);
    }

    public final float getPriorityByTaskId(String r2) {
        bf6.f r3 = this.taskIndex.get(r2);
        if (r3 != null) goto L7;
        return -1.0f;
    L7:
        return r3.g;
    }

    public final List<String> getTaskDependencyById(String r4) {
        ArrayList r0 = new ArrayList();
        Object r1 = this.readWriteLock;
        monitor-enter(r1);
        bf6.f r5 = this.taskIndex.get(r4);     // Catch: Throwable -> L9
        if (r5 == null) goto L7;
        r0.addAll(r5.j);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r1);
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    public final void onTaskComplete(bf6.f r6) {
        Object r0 = this.readWriteLock;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (r6.m == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        r6.m = true;     // Catch: Throwable -> L30
        this.completedTaskCount.getAndIncrement();     // Catch: Throwable -> L30
        List<String> r1 = r6.h;     // Catch: Throwable -> L30
        if (r1 == null) goto L28;
        Iterator<T> r2 = r1.iterator();     // Catch: Throwable -> L30
    L13:
        if (r2.hasNext() == false) goto L27;
        String r3 = (String) r2.next();     // Catch: Throwable -> L30
        bf6.f r4 = this.taskIndex.get(r3);     // Catch: Throwable -> L30
        if (r4 == null) goto L13;
        if (this.unDispatchTask.contains(r4) == false) goto L13;
        List<String> r5 = r4.j;     // Catch: Throwable -> L30
        if (r5 == null) goto L22;
        r5.remove(r6.a);     // Catch: Throwable -> L30
    L22:
        List<String> r7 = r4.j;     // Catch: Throwable -> L30
        if (r7 == null) goto L26;
        if (r7.isEmpty() == false) goto L13;
    L26:
        letTaskReady(r4);     // Catch: Throwable -> L30
        goto L13
    L27:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L28:
        monitor-exit(r0);
    }

    public final bf6.f takeNonUiTaskIfExist(Long r4) {
        if (hasNonUiTask() == true) goto L6;
        return null;
    L6:
        if (r4 == null) goto L10;
        return this.nonUiReadyQueue.poll(r4.longValue(), TimeUnit.MILLISECONDS);
    L10:
        return this.nonUiReadyQueue.take();
    }

    public final bf6.f takeUiTaskIfExist(long r3) {
        return this.uiReadyQueue.poll(r3, TimeUnit.MILLISECONDS);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static /* synthetic */ bf6.f takeNonUiTaskIfExist$default(InitTaskManager r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.takeNonUiTaskIfExist(r1);
    }

    public static /* synthetic */ bf6.f takeUiTaskIfExist$default(InitTaskManager r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 5;
    L6:
        return r0.takeUiTaskIfExist(r1);
    }
}
