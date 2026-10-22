package com.bytedance.common.utility.concurrent;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class TTExecutors {
    public static final int AVAILABLEPROCESSORS = 0;
    public static final int CORE_POOL_SIZE_CPU = 0;
    public static final int CORE_POOL_SIZE_NORMAL = 0;
    public static final int CORE_POOL_SIZE_SCHEDULED = 3;
    public static final int CPU_COUNT = 0;
    public static final int DOWNLOAD_THREAD_COUNT = 2;
    public static final int KEEP_ALIVE_SECONDS = 30;
    public static final int MAXIMUM_POOL_SIZE_CPU = 0;
    public static final int MAXIMUM_POOL_SIZE_NORMAL = 0;
    public static final int MAX_POOL_SIZE = 3;
    private static final BackgroundThreadFactory S_BACKGROUND_THREAD_FACTORY = null;
    private static final DefaultThreadFactory S_CPU_THREAD_FACTORY = null;
    private static final DefaultThreadFactory S_DEFAULT_THREAD_FACTORY = null;
    private static final DefaultThreadFactory S_DOWNLOAD_THREAD_FACTORY = null;
    private static final RejectedExecutionHandler S_HANDLER = null;
    private static final BlockingQueue<Runnable> S_POOLWORK_QUEUE = null;
    private static final BlockingQueue<Runnable> S_POOLWORK_QUEUE_CPU = null;
    private static final BlockingQueue<Runnable> S_POOLWORK_QUEUE_DOWNLOAD = null;
    private static final DefaultThreadFactory S_SCHEDULED_THREAD_FACTORY = null;
    private static final DefaultThreadFactory S_SERIAL_THREAD_FACTORY = null;
    private static ExecutorService sBackgroundThreadPool;
    private static ExecutorService sCPUThreadPool;
    private static ExecutorService sIOThreadPool;
    private static ExecutorService sNormalThreadPool;
    private static ScheduledExecutorService sScheduledThreadPool;
    private static ExecutorService sSerialThreadPool;

    public static class BackgroundThreadFactory implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = null;
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber;

        static {
            POOL_NUMBER = new AtomicInteger(1);
        }

        public BackgroundThreadFactory(String r100) {
            this.threadNumber = new AtomicInteger(1);
            SecurityManager r101 = System.getSecurityManager();
            if (r101 == null) goto L5;
            ThreadGroup r102 = r101.getThreadGroup();
        L6:
            this.group = r102;
            this.namePrefix = r100 + "-" + POOL_NUMBER.getAndIncrement() + "-Thread-";
            return;
        L5:
            r102 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r100) {
            final ThreadGroup r101 = this.group;
            final String r102 = this.namePrefix + this.threadNumber.getAndIncrement();
            final long r103 = 0;
            PthreadThreadV2 r104 = new AnonymousClass1(this, r101, r100, r102, r103);
            if (r104.isDaemon() == false) goto L5;
            r104.setDaemon(false);
        L5:
            return r104;
        }
    }

    public static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = null;
        private final ThreadGroup threadGroup;
        private final String threadNamePre;
        private final AtomicInteger threadNumber;

        static {
            POOL_NUMBER = new AtomicInteger(1);
        }

        public DefaultThreadFactory(String r100) {
            this.threadNumber = new AtomicInteger(1);
            SecurityManager r101 = System.getSecurityManager();
            if (r101 == null) goto L5;
            this.threadGroup = r101.getThreadGroup();
        L6:
            this.threadNamePre = r100 + "-" + POOL_NUMBER.getAndIncrement() + "-Thread-";
            return;
        L5:
            this.threadGroup = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(this.threadGroup, r100, this.threadNamePre + this.threadNumber.getAndIncrement(), 0);
            if (r101.isDaemon() == false) goto L6;
            r101.setDaemon(false);
        L6:
            if (r101.getPriority() == 5) goto L8;
            ThreadMethodProxy.setPriority(r101, 5);
        L8:
            return r101;
        }
    }

    public TTExecutors() {
    }

    static {
        int r100 = Runtime.getRuntime().availableProcessors();
        AVAILABLEPROCESSORS = r100;
        if (r100 > 0) goto L6;
        r100 = 1;
    L6:
        CPU_COUNT = r100;
        int r101 = Math.max(2, Math.min(r100 - 1, 6)) * 2;
        CORE_POOL_SIZE_NORMAL = r101;
        int r102 = (r101 * 2) + 1;
        MAXIMUM_POOL_SIZE_NORMAL = r102;
        int r110 = Math.max(2, Math.min(r100 - 1, 3));
        CORE_POOL_SIZE_CPU = r110;
        int r111 = (r100 * 2) + 1;
        MAXIMUM_POOL_SIZE_CPU = r111;
        DefaultThreadFactory r112 = new DefaultThreadFactory("TTDefaultExecutors");
        S_DEFAULT_THREAD_FACTORY = r112;
        DefaultThreadFactory r103 = new DefaultThreadFactory("TTCpuExecutors");
        S_CPU_THREAD_FACTORY = r103;
        DefaultThreadFactory r104 = new DefaultThreadFactory("TTScheduledExecutors");
        S_SCHEDULED_THREAD_FACTORY = r104;
        DefaultThreadFactory r105 = new DefaultThreadFactory("TTDownLoadExecutors");
        S_DOWNLOAD_THREAD_FACTORY = r105;
        DefaultThreadFactory r113 = new DefaultThreadFactory("TTSerialExecutors");
        S_SERIAL_THREAD_FACTORY = r113;
        BackgroundThreadFactory r114 = new BackgroundThreadFactory("TTBackgroundExecutors");
        S_BACKGROUND_THREAD_FACTORY = r114;
        LinkedBlockingQueue r115 = new LinkedBlockingQueue();
        S_POOLWORK_QUEUE = r115;
        LinkedBlockingQueue r210 = new LinkedBlockingQueue();
        S_POOLWORK_QUEUE_CPU = r210;
        LinkedBlockingQueue r211 = new LinkedBlockingQueue();
        S_POOLWORK_QUEUE_DOWNLOAD = r211;
        RejectedExecutionHandler r212 = new AnonymousClass1();
        S_HANDLER = r212;
        TimeUnit r213 = TimeUnit.SECONDS;
        TTThreadPoolExecutor r106 = new TTThreadPoolExecutor(r101, r102, 30, r213, r115, r112, r212);
        sNormalThreadPool = r106;
        r106.allowCoreThreadTimeOut(true);
        TTThreadPoolExecutor r107 = new TTThreadPoolExecutor(r110, r111, 30, r213, r210, r103, r212);
        sCPUThreadPool = r107;
        r107.allowCoreThreadTimeOut(true);
        sScheduledThreadPool = PThreadExecutorsUtils.newScheduledThreadPool(3, r104);
        TTThreadPoolExecutor r108 = new TTThreadPoolExecutor(2, 2, 30, r213, r211, r105, r212);
        sIOThreadPool = r108;
        r108.allowCoreThreadTimeOut(true);
        TTThreadPoolExecutor r109 = new TTThreadPoolExecutor(1, 1, 30, r213, new LinkedBlockingQueue(), r113);
        sSerialThreadPool = r109;
        r109.allowCoreThreadTimeOut(true);
        TTThreadPoolExecutor r116 = new TTThreadPoolExecutor(0, 3, 30, r213, new LinkedBlockingQueue(), r114);
        sBackgroundThreadPool = r116;
        r116.allowCoreThreadTimeOut(true);
    }

    public static ExecutorService getBackgroundThreadPool() {
        return sBackgroundThreadPool;
    }

    public static ExecutorService getCPUThreadPool() {
        return sCPUThreadPool;
    }

    public static ExecutorService getDownLoadThreadPool() {
        return sIOThreadPool;
    }

    public static ExecutorService getIOThreadPool() {
        return sIOThreadPool;
    }

    public static ExecutorService getNormalExecutor() {
        return sNormalThreadPool;
    }

    public static ScheduledExecutorService getScheduledThreadPool() {
        return sScheduledThreadPool;
    }

    public static ExecutorService getSerialThreadPool() {
        return sSerialThreadPool;
    }

    public static void setBackgroundThreadPool(ExecutorService r100) {
        sBackgroundThreadPool = r100;
    }

    public static void setCPUThreadPool(ExecutorService r100) {
        sCPUThreadPool = r100;
    }

    public static void setIOThreadPool(ExecutorService r100) {
        sIOThreadPool = r100;
    }

    public static void setNormalThreadPool(ExecutorService r100) {
        sNormalThreadPool = r100;
    }

    public static void setScheduledThreadPool(ScheduledExecutorService r100) {
        sScheduledThreadPool = r100;
    }

    public static void setSerialThreadPool(ExecutorService r100) {
        sSerialThreadPool = r100;
    }
}
