package com.ttnet.org.chromium.base.task;

import android.os.Process;
import android.util.Pair;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base")
public class TaskRunnerImpl implements TaskRunner {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Set<TaskRunnerCleaner> sCleaners = null;
    private static final ReferenceQueue<Object> sQueue = null;
    private boolean mDidOneTimeInitialization;
    private volatile long mNativeTaskRunnerAndroid;
    private List<Pair<Runnable, Long>> mPreNativeDelayedTasks;
    private final Object mPreNativeTaskLock;
    private LinkedList<Runnable> mPreNativeTasks;
    protected final Runnable mRunPreNativeTaskClosure;
    private final int mTaskRunnerType;
    private final TaskTraits mTaskTraits;
    private final String mTraceEvent;

    public interface Natives {
        boolean belongsToCurrentThread(long r100);

        void destroy(long r100);

        long init(int r100, int r101, boolean r102, boolean r103, byte r104, byte[] r105);

        void postDelayedTask(long r100, Runnable r101, long r102, String r103);
    }

    public static class TaskRunnerCleaner extends WeakReference<TaskRunnerImpl> {
        final long mNativePtr;

        public void destroy() {
            TaskRunnerImplJni.get().destroy(this.mNativePtr);
        }

        public TaskRunnerCleaner(TaskRunnerImpl r100) {
            super(r100, TaskRunnerImpl.access$000());
            this.mNativePtr = TaskRunnerImpl.access$100(r100);
        }
    }

    static {
        sQueue = new ReferenceQueue();
        sCleaners = new HashSet();
    }

    private static void destroyGarbageCollectedTaskRunners() {
    L2:
        TaskRunnerCleaner r100 = (TaskRunnerCleaner) sQueue.poll();
        if (r100 == null) goto L4;
        r100.destroy();
        Set<TaskRunnerCleaner> r101 = sCleaners;
        monitor-enter(r101);
        r101.remove(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private void oneTimeInitialization() {
        if (this.mDidOneTimeInitialization == false) goto L5;
        return;
    L5:
        this.mDidOneTimeInitialization = true;
        if (PostTask.registerPreNativeTaskRunner(this) == true) goto L8;
        initNativeTaskRunner();
        return;
    L8:
        this.mPreNativeTasks = new LinkedList();
        this.mPreNativeDelayedTasks = new ArrayList();
    }

    public Boolean belongsToCurrentThreadInternal() {
        Object r100 = this.mPreNativeTaskLock;
        monitor-enter(r100);
        oneTimeInitialization();     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        if (this.mNativeTaskRunnerAndroid != 0) goto L11;
        return null;
    L11:
        return Boolean.valueOf(TaskRunnerImplJni.get().belongsToCurrentThread(this.mNativeTaskRunnerAndroid));
    L12:
        th = move-exception;
        throw th;
    }

    public void runPreNativeTask() {
        TraceEvent r100 = TraceEvent.scoped(this.mTraceEvent);
        Object r101 = this.mPreNativeTaskLock;     // Catch: Throwable -> L27
        monitor-enter(r101);     // Catch: Throwable -> L27
        LinkedList<Runnable> r102 = this.mPreNativeTasks;     // Catch: Throwable -> L24
        if (r102 != null) goto L11;
        monitor-exit(r101);     // Catch: Throwable -> L24
        if (r100 == null) goto L38;
        r100.close();
        return;
    L38:
        return;
    L11:
        Runnable r103 = r102.poll();     // Catch: Throwable -> L24
        monitor-exit(r101);     // Catch: Throwable -> L24
        int r104 = this.mTaskTraits.mPriority;     // Catch: Throwable -> L27
        if (r104 != 1) goto L16;
        Process.setThreadPriority(0);     // Catch: Throwable -> L27
    L20:
        r103.run();     // Catch: Throwable -> L27
        if (r100 == null) goto L39;
        r100.close();
        return;
    L39:
        return;
    L16:
        if (r104 == 2) goto L18;
        Process.setThreadPriority(10);     // Catch: Throwable -> L27
        goto L20
    L18:
        Process.setThreadPriority(-1);     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        if (r100 != null) goto L35;
    L33:
        throw th;
    L35:
        r100.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);
        goto L33
    }

    public void initNativeTaskRunner() {
        Natives r100 = TaskRunnerImplJni.get();
        int r101 = this.mTaskRunnerType;
        TaskTraits r102 = this.mTaskTraits;
        long r103 = r100.init(r101, r102.mPriority, r102.mMayBlock, r102.mUseThreadPool, r102.mExtensionId, r102.mExtensionData);
        Object r104 = this.mPreNativeTaskLock;
        monitor-enter(r104);
        LinkedList<Runnable> r105 = this.mPreNativeTasks;     // Catch: Throwable -> L29
        if (r105 == null) goto L11;
        Iterator<Runnable> r106 = r105.iterator();     // Catch: Throwable -> L29
    L8:
        if (r106.hasNext() == false) goto L10;
        Runnable r110 = r106.next();     // Catch: Throwable -> L29
        TaskRunnerImplJni.get().postDelayedTask(r103, r110, 0, r110.getClass().getName());     // Catch: Throwable -> L29
        goto L8
    L10:
        this.mPreNativeTasks = null;     // Catch: Throwable -> L29
    L11:
        List<Pair<Runnable, Long>> r107 = this.mPreNativeDelayedTasks;     // Catch: Throwable -> L29
        if (r107 == null) goto L18;
        Iterator<Pair<Runnable, Long>> r108 = r107.iterator();     // Catch: Throwable -> L29
    L15:
        if (r108.hasNext() == false) goto L17;
        Pair<Runnable, Long> r109 = r108.next();     // Catch: Throwable -> L29
        TaskRunnerImplJni.get().postDelayedTask(r103, (Runnable) r109.first, ((Long) r109.second).longValue(), r109.getClass().getName());     // Catch: Throwable -> L29
        goto L15
    L17:
        this.mPreNativeDelayedTasks = null;     // Catch: Throwable -> L29
    L18:
        this.mNativeTaskRunnerAndroid = r103;     // Catch: Throwable -> L29
        monitor-exit(r104);     // Catch: Throwable -> L29
        Set<TaskRunnerCleaner> r111 = sCleaners;
        monitor-enter(r111);
        r111.add(new TaskRunnerCleaner(this));     // Catch: Throwable -> L26
        monitor-exit(r111);     // Catch: Throwable -> L26
        destroyGarbageCollectedTaskRunners();
        return;
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    }

    public void schedulePreNativeTask() {
        PostTask.getPrenativeThreadPoolExecutor().execute(this.mRunPreNativeTaskClosure);
    }

    public static /* synthetic */ ReferenceQueue access$000() {
        return sQueue;
    }

    public TaskRunnerImpl(TaskTraits r100) {
        this(r100, "TaskRunnerImpl", 0);
        destroyGarbageCollectedTaskRunners();
    }

    public static /* synthetic */ long access$100(TaskRunnerImpl r100) {
        return r100.mNativeTaskRunnerAndroid;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postTask(Runnable r100) {
        postDelayedTask(r100, 0);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postDelayedTask(Runnable r110, long r111) {
        if (this.mNativeTaskRunnerAndroid == 0) goto L6;
        TaskRunnerImplJni.get().postDelayedTask(this.mNativeTaskRunnerAndroid, r110, r111, r110.getClass().getName());
        return;
    L6:
        Object r100 = this.mPreNativeTaskLock;
        monitor-enter(r100);
        oneTimeInitialization();     // Catch: Throwable -> L19
        if (this.mNativeTaskRunnerAndroid == 0) goto L14;
        TaskRunnerImplJni.get().postDelayedTask(this.mNativeTaskRunnerAndroid, r110, r111, r110.getClass().getName());     // Catch: Throwable -> L19
        monitor-exit(r100);     // Catch: Throwable -> L19
        return;
    L14:
        if (r111 != 0) goto L16;
        this.mPreNativeTasks.add(r110);     // Catch: Throwable -> L19
        schedulePreNativeTask();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r100);     // Catch: Throwable -> L19
        return;
    L16:
        Pair<Runnable, Long> r101 = new Pair(r110, Long.valueOf(r111));     // Catch: Throwable -> L19
        this.mPreNativeDelayedTasks.add(r101);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public TaskRunnerImpl(TaskTraits r100, String r101, int r102) {
        this.mRunPreNativeTaskClosure = new f(this);
        this.mPreNativeTaskLock = new Object();
        this.mTaskTraits = r100.withExplicitDestination();
        this.mTraceEvent = r101 + ".PreNativeTask.run";
        this.mTaskRunnerType = r102;
    }
}
