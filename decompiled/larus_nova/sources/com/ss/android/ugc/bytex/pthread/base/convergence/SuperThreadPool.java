package com.ss.android.ugc.bytex.pthread.base.convergence;

import com.bytedance.pia.core.metrics.ErrorType;
import com.ss.android.ugc.bytex.pthread.base.convergence.executor.IThreadNameTransformer;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IRunnableScheduler;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadWorker;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.ThreadLifecycleObserver;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.IRunnableWrapperCreator;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.DirectScheduler;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityRunnable;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.Scheduler;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0007J\u0016\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0004J\u000e\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u0004J\u000e\u0010L\u001a\u00020E2\u0006\u0010M\u001a\u00020\u0004J\u0010\u0010N\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0007J\u000e\u0010Q\u001a\u00020E2\u0006\u0010R\u001a\u00020\u0004J\u000e\u0010S\u001a\u00020E2\u0006\u0010*\u001a\u00020+R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u000e\u0010\u001d\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006T"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/SuperThreadPool;", "", "()V", "ENABLE_HANDLER_THREAD", "", "ENABLE_SCHEDULED_THREAD", "ENABLE_THREAD", "ENABLE_THREAD_POOL", "allowAllCoreThreadTimeOut", "", "getAllowAllCoreThreadTimeOut", "()Z", "setAllowAllCoreThreadTimeOut", "(Z)V", "enableBlockFetchTask", "getEnableBlockFetchTask", "setEnableBlockFetchTask", "enableHandlerThreadReuse", "getEnableHandlerThreadReuse", "setEnableHandlerThreadReuse", "enablePriority", "getEnablePriority", "setEnablePriority", "enableThreadGroupOpt", "getEnableThreadGroupOpt", "setEnableThreadGroupOpt", "enableThreadToStringOpt", "getEnableThreadToStringOpt", "setEnableThreadToStringOpt", "mEnable", "runnableScheduler", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IRunnableScheduler;", "getRunnableScheduler", "()Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IRunnableScheduler;", "setRunnableScheduler", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IRunnableScheduler;)V", "scheduledThreadPoolMaxKeepAliveTime", "", "getScheduledThreadPoolMaxKeepAliveTime", "()J", "setScheduledThreadPoolMaxKeepAliveTime", "(J)V", "scheduler", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/Scheduler;", "threadLifecycleObserver", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/ThreadLifecycleObserver;", "getThreadLifecycleObserver", "()Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/ThreadLifecycleObserver;", "setThreadLifecycleObserver", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/ThreadLifecycleObserver;)V", "threadMonitor", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadMonitor;", "getThreadMonitor", "()Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadMonitor;", "setThreadMonitor", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadMonitor;)V", "threadNameTransformer", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IThreadNameTransformer;", "getThreadNameTransformer", "()Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IThreadNameTransformer;", "setThreadNameTransformer", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IThreadNameTransformer;)V", "wrapperCreator", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IRunnableWrapperCreator;", "getWrapperCreator", "()Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IRunnableWrapperCreator;", "setWrapperCreator", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IRunnableWrapperCreator;)V", "execute", "", ErrorType.WORKER, "Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadWorker;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityRunnable;", "type", "isEnable", "enableType", "setEnableType", "enable", "setExecutor", "executor", "Ljava/util/concurrent/Executor;", "setMaxAsyncTaskThreadCount", "count", "setScheduler", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class SuperThreadPool {
    public static final int ENABLE_HANDLER_THREAD = 4;
    public static final int ENABLE_SCHEDULED_THREAD = 8;
    public static final int ENABLE_THREAD = 1;
    public static final int ENABLE_THREAD_POOL = 2;
    public static final SuperThreadPool INSTANCE = null;
    private static boolean allowAllCoreThreadTimeOut;
    private static boolean enableBlockFetchTask;
    private static boolean enableHandlerThreadReuse;
    private static boolean enablePriority;
    private static boolean enableThreadGroupOpt;
    private static boolean enableThreadToStringOpt;
    private static volatile int mEnable;
    private static IRunnableScheduler runnableScheduler;
    private static long scheduledThreadPoolMaxKeepAliveTime;
    private static volatile Scheduler scheduler;
    private static ThreadLifecycleObserver threadLifecycleObserver;
    private static volatile IThreadMonitor threadMonitor;
    private static IThreadNameTransformer threadNameTransformer;
    private static volatile IRunnableWrapperCreator wrapperCreator;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        INSTANCE = new SuperThreadPool();
        enableBlockFetchTask = true;
        allowAllCoreThreadTimeOut = true;
        enablePriority = true;
        scheduledThreadPoolMaxKeepAliveTime = 1000;
        Executor r100 = null;
        scheduler = new DirectScheduler(r100, 1, 0 == true ? 1 : 0);
    }

    private SuperThreadPool() {
    }

    @Deprecated(message = "recommend use execute(worker: PriorityRunnable, type: Int)")
    public final void execute(IThreadWorker r100) {
        scheduler.scheduling(0, r100);
    }

    public final void execute(PriorityRunnable r100, int r101) {
        scheduler.scheduling(r101, r100);
    }

    public final boolean getAllowAllCoreThreadTimeOut() {
        return allowAllCoreThreadTimeOut;
    }

    public final boolean getEnableBlockFetchTask() {
        return enableBlockFetchTask;
    }

    public final boolean getEnableHandlerThreadReuse() {
        return enableHandlerThreadReuse;
    }

    public final boolean getEnablePriority() {
        return enablePriority;
    }

    public final boolean getEnableThreadGroupOpt() {
        return enableThreadGroupOpt;
    }

    public final boolean getEnableThreadToStringOpt() {
        return enableThreadToStringOpt;
    }

    public final IRunnableScheduler getRunnableScheduler() {
        return runnableScheduler;
    }

    public final long getScheduledThreadPoolMaxKeepAliveTime() {
        return scheduledThreadPoolMaxKeepAliveTime;
    }

    public final ThreadLifecycleObserver getThreadLifecycleObserver() {
        return threadLifecycleObserver;
    }

    public final IThreadMonitor getThreadMonitor() {
        return threadMonitor;
    }

    public final IThreadNameTransformer getThreadNameTransformer() {
        return threadNameTransformer;
    }

    public final IRunnableWrapperCreator getWrapperCreator() {
        return wrapperCreator;
    }

    public final boolean isEnable(int r100) {
        if ((mEnable & r100) != r100) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setAllowAllCoreThreadTimeOut(boolean r100) {
        allowAllCoreThreadTimeOut = r100;
    }

    public final void setEnableBlockFetchTask(boolean r100) {
        enableBlockFetchTask = r100;
    }

    public final void setEnableHandlerThreadReuse(boolean r100) {
        enableHandlerThreadReuse = r100;
    }

    public final void setEnablePriority(boolean r100) {
        enablePriority = r100;
    }

    public final void setEnableThreadGroupOpt(boolean r100) {
        enableThreadGroupOpt = r100;
    }

    public final void setEnableThreadToStringOpt(boolean r100) {
        enableThreadToStringOpt = r100;
    }

    public final void setEnableType(int r100) {
        mEnable = r100;
    }

    @Deprecated(message = "recommend use setScheduler", replaceWith = @ReplaceWith(expression = "setScheduler", imports = {}))
    public final void setExecutor(Executor r100) {
        setScheduler(new DirectScheduler(r100));
    }

    public final void setMaxAsyncTaskThreadCount(int r100) {
        PthreadAsyncTask.setMaxAsyncTaskThreadCount(r100);
    }

    public final void setRunnableScheduler(IRunnableScheduler r100) {
        runnableScheduler = r100;
    }

    public final void setScheduledThreadPoolMaxKeepAliveTime(long r100) {
        scheduledThreadPoolMaxKeepAliveTime = r100;
    }

    public final void setScheduler(Scheduler r100) {
        scheduler = r100;
    }

    public final void setThreadLifecycleObserver(ThreadLifecycleObserver r100) {
        threadLifecycleObserver = r100;
    }

    public final void setThreadMonitor(IThreadMonitor r100) {
        threadMonitor = r100;
    }

    public final void setThreadNameTransformer(IThreadNameTransformer r100) {
        threadNameTransformer = r100;
    }

    public final void setWrapperCreator(IRunnableWrapperCreator r100) {
        wrapperCreator = r100;
    }
}
