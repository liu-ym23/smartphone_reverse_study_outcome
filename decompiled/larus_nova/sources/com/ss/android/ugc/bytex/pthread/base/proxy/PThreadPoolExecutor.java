package com.ss.android.ugc.bytex.pthread.base.proxy;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.dumper.Scraps;
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

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fBE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012BO\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0014J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0006\u0010\u001c\u001a\u00020\u0017J+\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001e\"\u0004\b\u0000\u0010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u0002H\u001fH\u0014¢\u0006\u0002\u0010!J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001e\"\u0004\b\u0000\u0010\u001f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010#H\u0014J\u0012\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010&\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006("}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "corePoolSize", "", "maximumPoolSize", "keepAliveTime", "", Scraps.INNER_UNIT, "Ljava/util/concurrent/TimeUnit;", "workQueue", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V", "handler", "Ljava/util/concurrent/RejectedExecutionHandler;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/RejectedExecutionHandler;)V", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;Ljava/util/concurrent/RejectedExecutionHandler;)V", "allowCoreThreadTimeOut", "", "value", "", "execute", "command", "finalize", "getQueue", "isWorkQueueEmpty", "newTaskFor", "Ljava/util/concurrent/RunnableFuture;", ExifInterface.GPS_DIRECTION_TRUE, "runnable", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/RunnableFuture;", "callable", "Ljava/util/concurrent/Callable;", "remove", "task", "setThreadFactory", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public class PThreadPoolExecutor extends ThreadPoolExecutor {
    public static final Companion Companion = null;
    public static final String TAG = "PThreadPoolExecutor";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PThreadPoolExecutor$Companion;", "", "()V", "TAG", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PThreadPoolExecutor(int r110, int r111, long r112, TimeUnit r113, BlockingQueue<Runnable> r114) {
        super(r110, r111, r112, r113, BlockingQueueProxy.Companion.proxy(r114), ThreadFactoryProxy.Companion.proxy(Executors.defaultThreadFactory(), 2));
        if (allowsCoreThreadTimeOut() == false) goto L5;
        return;
    L5:
        if (SuperThreadPool.INSTANCE.getAllowAllCoreThreadTimeOut() == false) goto L13;
        TimeUnit r115 = TimeUnit.SECONDS;
        setKeepAliveTime(RangesKt.coerceAtLeast(Math.max(30, getKeepAliveTime(r115)), 1), r115);
        allowCoreThreadTimeOut(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public PThreadPoolExecutor(int r110, int r111, long r112, TimeUnit r113, BlockingQueue<Runnable> r114, RejectedExecutionHandler r115) {
        super(r110, r111, r112, r113, BlockingQueueProxy.Companion.proxy(r114), ThreadFactoryProxy.Companion.proxy(Executors.defaultThreadFactory(), 2), r115);
        if (allowsCoreThreadTimeOut() == false) goto L5;
        return;
    L5:
        if (SuperThreadPool.INSTANCE.getAllowAllCoreThreadTimeOut() == false) goto L13;
        TimeUnit r100 = TimeUnit.SECONDS;
        setKeepAliveTime(RangesKt.coerceAtLeast(Math.max(30, getKeepAliveTime(r100)), 1), r100);
        allowCoreThreadTimeOut(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public PThreadPoolExecutor(int r110, int r111, long r112, TimeUnit r113, BlockingQueue<Runnable> r114, ThreadFactory r115) {
        super(r110, r111, r112, r113, BlockingQueueProxy.Companion.proxy(r114), ThreadFactoryProxy.Companion.proxy(r115, 2));
        if (allowsCoreThreadTimeOut() == false) goto L5;
        return;
    L5:
        if (SuperThreadPool.INSTANCE.getAllowAllCoreThreadTimeOut() == false) goto L13;
        TimeUnit r100 = TimeUnit.SECONDS;
        setKeepAliveTime(RangesKt.coerceAtLeast(Math.max(30, getKeepAliveTime(r100)), 1), r100);
        allowCoreThreadTimeOut(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public PThreadPoolExecutor(int r110, int r111, long r112, TimeUnit r113, BlockingQueue<Runnable> r114, ThreadFactory r115, RejectedExecutionHandler r116) {
        super(r110, r111, r112, r113, BlockingQueueProxy.Companion.proxy(r114), ThreadFactoryProxy.Companion.proxy(r115, 2), r116);
        if (allowsCoreThreadTimeOut() == false) goto L5;
        return;
    L5:
        if (SuperThreadPool.INSTANCE.getAllowAllCoreThreadTimeOut() == false) goto L13;
        TimeUnit r100 = TimeUnit.SECONDS;
        setKeepAliveTime(RangesKt.coerceAtLeast(Math.max(30, getKeepAliveTime(r100)), 1), r100);
        allowCoreThreadTimeOut(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean r100) {
        if (SuperThreadPool.INSTANCE.getEnableBlockFetchTask() == false) goto L7;
        if (r100 == true) goto L7;
        boolean r101 = false;
    L8:
        super.allowCoreThreadTimeOut(r101);     // Catch: Throwable -> L10
        return;
    L7:
        r101 = true;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r100) {
        SuperThreadPool r101 = SuperThreadPool.INSTANCE;
        IRunnableScheduler r102 = r101.getRunnableScheduler();
        if (r102 != null) goto L5;
    L6:
        IRunnableWrapperCreator r103 = r101.getWrapperCreator();
        if (r103 == null) goto L11;
        Runnable r104 = r103.wrap(r100, 2);
        if (r104 == null) goto L11;
        r100 = r104;
    L11:
        super.execute(r100);
        return;
    L5:
        if (r102.execute(r100, this) != true) goto L6;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void finalize() {
        super.finalize();
        shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public BlockingQueue<Runnable> getQueue() {
        BlockingQueue<Runnable> r100 = super.getQueue();
        if ((r100 instanceof BlockingQueueProxy) == true) goto L5;
        return r100;
    L5:
        return ((BlockingQueueProxy) r100).getDelegate$threadpool_plugin_base_release();
    }

    public final boolean isWorkQueueEmpty() {
        return getQueue().isEmpty();
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable r100, T r101) {
        IRunnableScheduler r102 = SuperThreadPool.INSTANCE.getRunnableScheduler();
        if (r102 == null) goto L8;
        RunnableFuture<T> r103 = r102.newTaskFor(r100, r101, this);
        if (r103 == null) goto L8;
        return r103;
    L8:
        return super.newTaskFor(r100, r101);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> r100) {
        IRunnableScheduler r101 = SuperThreadPool.INSTANCE.getRunnableScheduler();
        if (r101 == null) goto L8;
        RunnableFuture<T> r102 = r101.newTaskFor(r100, this);
        if (r102 == null) goto L8;
        return r102;
    L8:
        return super.newTaskFor(r100);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean remove(Runnable r100) {
        IRunnableWrapperCreator r101 = SuperThreadPool.INSTANCE.getWrapperCreator();
        if (r101 == null) goto L8;
        Runnable r102 = r101.findWrapper(this, r100);
        if (r102 == null) goto L8;
        r100 = r102;
    L8:
        return super.remove(r100);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory r100) {
        super.setThreadFactory(ThreadFactoryProxy.Companion.proxy(r100, 2));
    }
}
