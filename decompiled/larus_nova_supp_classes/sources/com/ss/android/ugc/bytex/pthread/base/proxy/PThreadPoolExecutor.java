package com.ss.android.ugc.bytex.pthread.base.proxy;

import android.util.EventsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IRunnableScheduler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.BlockingQueueProxy;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.IRunnableWrapperCreator;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadFactoryProxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fBE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012BO\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0014J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0006\u0010\u001c\u001a\u00020\u0017J+\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001e\"\u0004\b\u0000\u0010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u0002H\u001fH\u0014¢\u0006\u0002\u0010!J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001e\"\u0004\b\u0000\u0010\u001f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010#H\u0014J\u0012\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010&\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006("}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "corePoolSize", XmlPullParser.NO_NAMESPACE, "maximumPoolSize", "keepAliveTime", XmlPullParser.NO_NAMESPACE, "unit", "Ljava/util/concurrent/TimeUnit;", "workQueue", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V", "handler", "Ljava/util/concurrent/RejectedExecutionHandler;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/RejectedExecutionHandler;)V", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;Ljava/util/concurrent/RejectedExecutionHandler;)V", "allowCoreThreadTimeOut", XmlPullParser.NO_NAMESPACE, "value", XmlPullParser.NO_NAMESPACE, "execute", "command", "finalize", "getQueue", "isWorkQueueEmpty", "newTaskFor", "Ljava/util/concurrent/RunnableFuture;", "T", "runnable", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/RunnableFuture;", "callable", "Ljava/util/concurrent/Callable;", "remove", "task", "setThreadFactory", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public class PThreadPoolExecutor extends ThreadPoolExecutor {
    public static final Companion Companion = null;
    public static final String TAG = "PThreadPoolExecutor";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PThreadPoolExecutor$Companion;", XmlPullParser.NO_NAMESPACE, "()V", "TAG", XmlPullParser.NO_NAMESPACE, "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PThreadPoolExecutor(int r10, int r11, long r12, TimeUnit r14, BlockingQueue<Runnable> r15) {
        super(r10, r11, r12, r14, BlockingQueueProxy.Companion.proxy(r15), ThreadFactoryProxy.Companion.proxy(Executors.defaultThreadFactory(), 2));
        if (allowsCoreThreadTimeOut() == false) goto L5;
        return;
    L5:
        if (SuperThreadPool.INSTANCE.getAllowAllCoreThreadTimeOut() == false) goto L13;
        TimeUnit r13 = TimeUnit.SECONDS;
        setKeepAliveTime(RangesKt.coerceAtLeast(Math.max(30, getKeepAliveTime(r13)), 1), r13);
        allowCoreThreadTimeOut(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public PThreadPoolExecutor(int r11, int r12, long r13, TimeUnit r15, BlockingQueue<Runnable> r16, RejectedExecutionHandler r17) {
        super(r11, r12, r13, r15, BlockingQueueProxy.Companion.proxy(r16), ThreadFactoryProxy.Companion.proxy(Executors.defaultThreadFactory(), 2), r17);
        if (allowsCoreThreadTimeOut() == false) goto L5;
        return;
    L5:
        if (SuperThreadPool.INSTANCE.getAllowAllCoreThreadTimeOut() == false) goto L13;
        TimeUnit r0 = TimeUnit.SECONDS;
        setKeepAliveTime(RangesKt.coerceAtLeast(Math.max(30, getKeepAliveTime(r0)), 1), r0);
        allowCoreThreadTimeOut(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public PThreadPoolExecutor(int r10, int r11, long r12, TimeUnit r14, BlockingQueue<Runnable> r15, ThreadFactory r16) {
        super(r10, r11, r12, r14, BlockingQueueProxy.Companion.proxy(r15), ThreadFactoryProxy.Companion.proxy(r16, 2));
        if (allowsCoreThreadTimeOut() == false) goto L5;
        return;
    L5:
        if (SuperThreadPool.INSTANCE.getAllowAllCoreThreadTimeOut() == false) goto L13;
        TimeUnit r0 = TimeUnit.SECONDS;
        setKeepAliveTime(RangesKt.coerceAtLeast(Math.max(30, getKeepAliveTime(r0)), 1), r0);
        allowCoreThreadTimeOut(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public PThreadPoolExecutor(int r11, int r12, long r13, TimeUnit r15, BlockingQueue<Runnable> r16, ThreadFactory r17, RejectedExecutionHandler r18) {
        super(r11, r12, r13, r15, BlockingQueueProxy.Companion.proxy(r16), ThreadFactoryProxy.Companion.proxy(r17, 2), r18);
        if (allowsCoreThreadTimeOut() == false) goto L5;
        return;
    L5:
        if (SuperThreadPool.INSTANCE.getAllowAllCoreThreadTimeOut() == false) goto L13;
        TimeUnit r0 = TimeUnit.SECONDS;
        setKeepAliveTime(RangesKt.coerceAtLeast(Math.max(30, getKeepAliveTime(r0)), 1), r0);
        allowCoreThreadTimeOut(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean r2) {
        if (SuperThreadPool.INSTANCE.getEnableBlockFetchTask() == false) goto L7;
        if (r2 == true) goto L7;
        boolean r3 = false;
    L8:
        super.allowCoreThreadTimeOut(r3);     // Catch: Throwable -> L10
        return;
    L7:
        r3 = true;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r4) {
        SuperThreadPool r0 = SuperThreadPool.INSTANCE;
        IRunnableScheduler r1 = r0.getRunnableScheduler();
        if (r1 != null) goto L5;
    L6:
        IRunnableWrapperCreator r2 = r0.getWrapperCreator();
        if (r2 == null) goto L11;
        Runnable r3 = r2.wrap(r4, 2);
        if (r3 == null) goto L11;
        r4 = r3;
    L11:
        super.execute(r4);
        return;
    L5:
        if (r1.execute(r4, this) != true) goto L6;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void finalize() {
        super.finalize();
        shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public BlockingQueue<Runnable> getQueue() {
        BlockingQueue<Runnable> r0 = super.getQueue();
        if ((r0 instanceof BlockingQueueProxy) == true) goto L5;
        return r0;
    L5:
        return ((BlockingQueueProxy) r0).getDelegate$threadpool_plugin_base_release();
    }

    public final boolean isWorkQueueEmpty() {
        return getQueue().isEmpty();
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable r2, T r3) {
        IRunnableScheduler r0 = SuperThreadPool.INSTANCE.getRunnableScheduler();
        if (r0 == null) goto L8;
        RunnableFuture<T> r1 = r0.newTaskFor(r2, r3, this);
        if (r1 == null) goto L8;
        return r1;
    L8:
        return super.newTaskFor(r2, r3);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> r2) {
        IRunnableScheduler r0 = SuperThreadPool.INSTANCE.getRunnableScheduler();
        if (r0 == null) goto L8;
        RunnableFuture<T> r1 = r0.newTaskFor(r2, this);
        if (r1 == null) goto L8;
        return r1;
    L8:
        return super.newTaskFor(r2);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean remove(Runnable r2) {
        IRunnableWrapperCreator r0 = SuperThreadPool.INSTANCE.getWrapperCreator();
        if (r0 == null) goto L8;
        Runnable r1 = r0.findWrapper(this, r2);
        if (r1 == null) goto L8;
        r2 = r1;
    L8:
        return super.remove(r2);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory r3) {
        super.setThreadFactory(ThreadFactoryProxy.Companion.proxy(r3, 2));
    }
}
