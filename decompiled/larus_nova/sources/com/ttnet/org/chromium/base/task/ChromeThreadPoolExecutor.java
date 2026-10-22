package com.ttnet.org.chromium.base.task;

import android.os.Process;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
class ChromeThreadPoolExecutor extends PThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = 0;
    private static final int CPU_COUNT = 0;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE = 0;
    private static final int RUNNABLE_WARNING_COUNT = 32;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = null;
    private static final ThreadFactory sThreadFactory = null;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.task.ChromeThreadPoolExecutor$1, reason: invalid class name */
    public class AnonymousClass1 implements ThreadFactory {
        private final AtomicInteger mCount;

        public static /* synthetic */ void a(Runnable r100) {
            lambda$newThread$0(r100);
        }

        public AnonymousClass1() {
            this.mCount = new AtomicInteger(1);
        }

        private static /* synthetic */ void lambda$newThread$0(Runnable r100) {
            Process.setThreadPriority(10);
            r100.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r100) {
            return new PthreadThreadV2(new d(r100), "CrAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    public ChromeThreadPoolExecutor() {
        this(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    }

    private Map<String, Integer> getNumberOfClassNameOccurrencesInQueue() {
        HashMap r100 = new HashMap();
        Runnable[] r101 = (Runnable[]) getQueue().toArray(new Runnable[0]);
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        String r104 = getClassName(r101[r103]);
        if (r100.containsKey(r104) == false) goto L7;
        int r105 = ((Integer) r100.get(r104)).intValue();
    L8:
        r100.put(r104, Integer.valueOf(r105 + 1));
        r103 = r103 + 1;
        goto L3
    L7:
        r105 = 0;
        goto L8
    L9:
        return r100;
    }

    static {
        int r100 = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = r100;
        CORE_POOL_SIZE = Math.max(2, Math.min(r100 - 1, 4));
        MAXIMUM_POOL_SIZE = (r100 * 2) + 1;
        sThreadFactory = new AnonymousClass1();
        sPoolWorkQueue = new ArrayBlockingQueue(128);
    }

    private String findClassNamesWithTooManyRunnables(Map<String, Integer> r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator<Map.Entry<String, Integer>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, Integer> r103 = r102.next();
        if (r103.getValue().intValue() <= 32) goto L4;
        r101.append(r103.getKey());
        r101.append(' ');
        goto L4
    L9:
        if (r101.length() != 0) goto L13;
        return "NO CLASSES FOUND";
    L13:
        return r101.toString();
    }

    private static String getClassName(Runnable r100) {
        Class r101 = r100.getClass();
        if (r101 != AsyncTask.NamedFutureTask.class) goto L8;
        Class r102 = ((AsyncTask.NamedFutureTask) r100).getBlamedClass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
    L6:
        r101 = r102;
    L21:
        return r101.getName();
    L8:
        if (r101.getEnclosingClass() != android.os.AsyncTask.class) goto L21;
        Field r103 = r101.getDeclaredField("this$0");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
        r103.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
        r102 = r103.get(r100).getClass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
    L11:
        e = move-exception;
        if (BuildConfig.ENABLE_ASSERTS == false) goto L21;
        throw new RuntimeException(e);
    L17:
        e = move-exception;
        if (BuildConfig.ENABLE_ASSERTS == false) goto L21;
        throw new RuntimeException(e);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r100) {
        super.execute(r100);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        throw new RejectedExecutionException("Prominent classes in AsyncTask: " + findClassNamesWithTooManyRunnables(getNumberOfClassNameOccurrencesInQueue()), e);
    }

    public ChromeThreadPoolExecutor(int r100, int r101, long r102, TimeUnit r103, BlockingQueue<Runnable> r104, ThreadFactory r105) {
        super(r100, r101, r102, r103, r104, r105);
        allowCoreThreadTimeOut(true);
    }
}
