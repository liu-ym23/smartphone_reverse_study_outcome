package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base")
public class PostTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static volatile boolean sNativeInitialized;
    private static final Object sPreNativeTaskRunnerLock = null;
    private static List<TaskRunnerImpl> sPreNativeTaskRunners;
    private static final Executor sPrenativeThreadPoolExecutor = null;
    private static volatile Executor sPrenativeThreadPoolExecutorOverride;
    private static AtomicReferenceArray<TaskExecutor> sTaskExecutors;

    public interface Natives {
        void postDelayedTask(int r100, boolean r101, boolean r102, byte r103, byte[] r104, Runnable r105, long r106, String r107);
    }

    public PostTask() {
    }

    private static void onNativeSchedulerReady() {
        sNativeInitialized = true;
        Object r100 = sPreNativeTaskRunnerLock;
        monitor-enter(r100);
        List<TaskRunnerImpl> r101 = sPreNativeTaskRunners;     // Catch: Throwable -> L11
        sPreNativeTaskRunners = null;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        Iterator<TaskRunnerImpl> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r102.next().initNativeTaskRunner();
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void resetPrenativeThreadPoolExecutorForTesting() {
        sPrenativeThreadPoolExecutorOverride = null;
    }

    static {
        sPreNativeTaskRunnerLock = new Object();
        sPreNativeTaskRunners = new ArrayList();
        sPrenativeThreadPoolExecutor = new ChromeThreadPoolExecutor();
        sTaskExecutors = getInitialTaskExecutors();
    }

    private static AtomicReferenceArray<TaskExecutor> getInitialTaskExecutors() {
        AtomicReferenceArray<TaskExecutor> r100 = new AtomicReferenceArray(5);
        r100.set(0, new DefaultTaskExecutor());
        return r100;
    }

    public static Executor getPrenativeThreadPoolExecutor() {
        if (sPrenativeThreadPoolExecutorOverride == null) goto L7;
        return sPrenativeThreadPoolExecutorOverride;
    L7:
        return sPrenativeThreadPoolExecutor;
    }

    private static void onNativeSchedulerShutdownForTesting() {
        Object r100 = sPreNativeTaskRunnerLock;
        monitor-enter(r100);
        sPreNativeTaskRunners = new ArrayList();     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        sNativeInitialized = false;
        sTaskExecutors.set(0, new DefaultTaskExecutor());
        int r101 = 1;
    L8:
        if (r101 >= sTaskExecutors.length()) goto L10;
        sTaskExecutors.set(r101, null);
        r101 = r101 + 1;
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean canRunTaskImmediately(TaskTraits r100) {
        return getTaskExecutorForTraits(r100).canRunTaskImmediately(r100);
    }

    public static SequencedTaskRunner createSequencedTaskRunner(TaskTraits r100) {
        return getTaskExecutorForTraits(r100).createSequencedTaskRunner(r100);
    }

    public static SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r100) {
        return getTaskExecutorForTraits(r100).createSingleThreadTaskRunner(r100);
    }

    public static TaskRunner createTaskRunner(TaskTraits r100) {
        return getTaskExecutorForTraits(r100).createTaskRunner(r100);
    }

    private static TaskExecutor getTaskExecutorForTraits(TaskTraits r100) {
        return sTaskExecutors.get(r100.mExtensionId);
    }

    public static boolean registerPreNativeTaskRunner(TaskRunnerImpl r100) {
        Object r101 = sPreNativeTaskRunnerLock;
        monitor-enter(r101);
        List<TaskRunnerImpl> r102 = sPreNativeTaskRunners;     // Catch: Throwable -> L13
        if (r102 != null) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L13
        return false;
    L9:
        r102.add(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    public static void setPrenativeThreadPoolExecutorForTesting(Executor r100) {
        sPrenativeThreadPoolExecutorOverride = r100;
    }

    public static void postTask(TaskTraits r100, Runnable r101) {
        postDelayedTask(r100, r101, 0);
    }

    public static void registerTaskExecutor(int r100, TaskExecutor r101) {
        sTaskExecutors.set(r100, r101);
    }

    public static void runOrPostTask(TaskTraits r100, Runnable r101) {
        if (getTaskExecutorForTraits(r100).canRunTaskImmediately(r100) == false) goto L5;
        r101.run();
        return;
    L5:
        postTask(r100, r101);
    }

    public static <T> T runSynchronously(TaskTraits r100, Callable<T> r101) {
        return (T) runSynchronouslyInternal(r100, new FutureTask(r101));
    }

    private static <T> T runSynchronouslyInternal(TaskTraits r100, FutureTask<T> r101) {
        runOrPostTask(r100, r101);
        return r101.get();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void runSynchronously(TaskTraits r100, Runnable r101) {
        runSynchronouslyInternal(r100, new FutureTask(r101, null));
    }

    public static void postDelayedTask(TaskTraits r110, Runnable r111, long r112) {
        if (sNativeInitialized == true) goto L5;
    L8:
        getTaskExecutorForTraits(r110).postDelayedTask(r110, r111, r112);
        return;
    L5:
        if (r110.mIsChoreographerFrame == true) goto L8;
        TaskTraits r113 = r110.withExplicitDestination();
        PostTaskJni.get().postDelayedTask(r113.mPriority, r113.mMayBlock, r113.mUseThreadPool, r113.mExtensionId, r113.mExtensionData, r111, r112, r111.getClass().getName());
    }
}
