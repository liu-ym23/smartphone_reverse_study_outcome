package com.huawei.hms.framework.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public class ExecutorsUtils {
    private static final String THREADNAME_HEADER = "NK_";

    public ExecutorsUtils() {
    }

    public static ThreadFactory createThreadFactory(final String r100) {
        if (r100 == null) goto L8;
        if (r100.trim().isEmpty() == true) goto L8;
        return new AnonymousClass1(r100);
    L8:
        throw new NullPointerException("ThreadName is empty");
    }

    public static ExecutorService newCachedThreadPool(String r100) {
        ThreadFactory r101 = createThreadFactory(r100);
        ThreadPoolExcutorEnhance r102 = new ThreadPoolExcutorEnhance(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), r101);
        r102.allowCoreThreadTimeOut(true);
        return r102;
    }

    public static ExecutorService newSingleThreadExecutor(String r100) {
        return ExecutorsEnhance.newSingleThreadExecutor(createThreadFactory(r100));
    }

    public static ExecutorService newFixedThreadPool(int r100, String r101) {
        ThreadFactory r102 = createThreadFactory(r101);
        ThreadPoolExcutorEnhance r103 = new ThreadPoolExcutorEnhance(r100, r100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r102);
        r103.allowCoreThreadTimeOut(true);
        return r103;
    }

    public static ScheduledExecutorService newScheduledThreadPool(int r100, String r101) {
        return new ScheduledThreadPoolExecutorEnhance(r100, createThreadFactory(r101));
    }

    public static Thread newThread(Runnable r100, String r101) {
        return new Thread(r100, THREADNAME_HEADER + r101);
    }
}
