package com.ss.android.ugc.bytex.pthread.base.proxy;

import com.bytedance.crash.dumper.Scraps;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IRunnableScheduler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.IRunnableWrapperCreator;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadFactoryProxy;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J6\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J0\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J0\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010!\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\""}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PThreadScheduledThreadPoolExecutor;", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "corePoolSize", "", "(I)V", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(ILjava/util/concurrent/ThreadFactory;)V", "handler", "Ljava/util/concurrent/RejectedExecutionHandler;", "(ILjava/util/concurrent/RejectedExecutionHandler;)V", "(ILjava/util/concurrent/ThreadFactory;Ljava/util/concurrent/RejectedExecutionHandler;)V", "allowCoreThreadTimeOut", "", "value", "", MonitorConstants.SCHEDULE, "Ljava/util/concurrent/ScheduledFuture;", "command", "Ljava/lang/Runnable;", "delay", "", Scraps.INNER_UNIT, "Ljava/util/concurrent/TimeUnit;", "V", "callable", "Ljava/util/concurrent/Callable;", "scheduleAtFixedRate", "initialDelay", "period", "scheduleWithFixedDelay", "setKeepAliveTime", "time", "setThreadFactory", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public class PThreadScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
    public PThreadScheduledThreadPoolExecutor(int r100) {
        super(r100, ThreadFactoryProxy.Companion.proxy(Executors.defaultThreadFactory(), 8));
        SuperThreadPool r101 = SuperThreadPool.INSTANCE;
        if (r101.getEnableBlockFetchTask() == true) goto L7;
        long r102 = r101.getScheduledThreadPoolMaxKeepAliveTime();
        TimeUnit r103 = TimeUnit.MILLISECONDS;
    L5:
        super.setKeepAliveTime(r102, r103);
        super.allowCoreThreadTimeOut(true);
        return;
    L7:
        if (allowsCoreThreadTimeOut() == true) goto L10;
        r103 = TimeUnit.SECONDS;
        r102 = Math.max(30, getKeepAliveTime(r103));
        goto L5
    }

    public PThreadScheduledThreadPoolExecutor(int r100, RejectedExecutionHandler r101) {
        super(r100, ThreadFactoryProxy.Companion.proxy(Executors.defaultThreadFactory(), 8), r101);
        SuperThreadPool r102 = SuperThreadPool.INSTANCE;
        if (r102.getEnableBlockFetchTask() == true) goto L7;
        super.setKeepAliveTime(r102.getScheduledThreadPoolMaxKeepAliveTime(), TimeUnit.MILLISECONDS);
    L5:
        super.allowCoreThreadTimeOut(true);
        return;
    L7:
        if (allowsCoreThreadTimeOut() == true) goto L10;
        TimeUnit r103 = TimeUnit.SECONDS;
        super.setKeepAliveTime(Math.max(30, getKeepAliveTime(r103)), r103);
        goto L5
    }

    public PThreadScheduledThreadPoolExecutor(int r100, ThreadFactory r101) {
        super(r100, ThreadFactoryProxy.Companion.proxy(r101, 8));
        SuperThreadPool r102 = SuperThreadPool.INSTANCE;
        if (r102.getEnableBlockFetchTask() == true) goto L7;
        super.setKeepAliveTime(r102.getScheduledThreadPoolMaxKeepAliveTime(), TimeUnit.MILLISECONDS);
    L5:
        super.allowCoreThreadTimeOut(true);
        return;
    L7:
        if (allowsCoreThreadTimeOut() == true) goto L10;
        TimeUnit r103 = TimeUnit.SECONDS;
        super.setKeepAliveTime(Math.max(30, getKeepAliveTime(r103)), r103);
        goto L5
    }

    public PThreadScheduledThreadPoolExecutor(int r100, ThreadFactory r101, RejectedExecutionHandler r102) {
        super(r100, ThreadFactoryProxy.Companion.proxy(r101, 8), r102);
        SuperThreadPool r103 = SuperThreadPool.INSTANCE;
        if (r103.getEnableBlockFetchTask() == true) goto L7;
        super.setKeepAliveTime(r103.getScheduledThreadPoolMaxKeepAliveTime(), TimeUnit.MILLISECONDS);
    L5:
        super.allowCoreThreadTimeOut(true);
        return;
    L7:
        if (allowsCoreThreadTimeOut() == true) goto L10;
        TimeUnit r104 = TimeUnit.SECONDS;
        super.setKeepAliveTime(Math.max(30, getKeepAliveTime(r104)), r104);
        goto L5
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

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable r100, long r101, TimeUnit r110) {
        SuperThreadPool r102 = SuperThreadPool.INSTANCE;
        IRunnableScheduler r103 = r102.getRunnableScheduler();
        if (r103 == null) goto L7;
        ScheduledFuture<?> r104 = r103.schedule(r100, r101, r110, this);
        if (r104 == null) goto L7;
        return r104;
    L7:
        IRunnableWrapperCreator r105 = r102.getWrapperCreator();
        if (r105 == null) goto L13;
        Runnable r106 = r105.wrap(r100, 8);
        if (r106 == null) goto L13;
        r100 = r106;
    L13:
        return super.schedule(r100, r101, r110);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> r100, long r101, TimeUnit r110) {
        SuperThreadPool r102 = SuperThreadPool.INSTANCE;
        IRunnableScheduler r103 = r102.getRunnableScheduler();
        if (r103 == null) goto L7;
        ScheduledFuture<V> r104 = r103.schedule(r100, r101, r110, this);
        if (r104 == null) goto L7;
        return r104;
    L7:
        IRunnableWrapperCreator r105 = r102.getWrapperCreator();
        if (r105 == null) goto L13;
        Callable<V> r106 = r105.wrap(r100, 8);
        if (r106 == null) goto L13;
        r100 = r106;
    L13:
        return super.schedule(r100, r101, r110);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable r110, long r111, long r112, TimeUnit r113) {
        SuperThreadPool r100 = SuperThreadPool.INSTANCE;
        IRunnableScheduler r101 = r100.getRunnableScheduler();
        if (r101 == null) goto L7;
        ScheduledFuture<?> r102 = r101.scheduleAtFixedRate(r110, r111, r112, r113, this);
        if (r102 == null) goto L7;
        return r102;
    L7:
        IRunnableWrapperCreator r103 = r100.getWrapperCreator();
        if (r103 == null) goto L12;
        Runnable r104 = r103.wrap(r110, 8);
        if (r104 == null) goto L12;
        Runnable r105 = r104;
    L14:
        return super.scheduleAtFixedRate(r105, r111, r112, r113);
    L12:
        r105 = r110;
        goto L14
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable r110, long r111, long r112, TimeUnit r113) {
        SuperThreadPool r100 = SuperThreadPool.INSTANCE;
        IRunnableScheduler r101 = r100.getRunnableScheduler();
        if (r101 == null) goto L7;
        ScheduledFuture<?> r102 = r101.scheduleWithFixedDelay(r110, r111, r112, r113, this);
        if (r102 == null) goto L7;
        return r102;
    L7:
        IRunnableWrapperCreator r103 = r100.getWrapperCreator();
        if (r103 == null) goto L12;
        Runnable r104 = r103.wrap(r110, 8);
        if (r104 == null) goto L12;
        Runnable r105 = r104;
    L14:
        return super.scheduleWithFixedDelay(r105, r111, r112, r113);
    L12:
        r105 = r110;
        goto L14
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long r100, TimeUnit r101) {
        SuperThreadPool r102 = SuperThreadPool.INSTANCE;
        if (r102.getEnableBlockFetchTask() == true) goto L5;
        r100 = r102.getScheduledThreadPoolMaxKeepAliveTime();
        r101 = TimeUnit.MILLISECONDS;
    L5:
        super.setKeepAliveTime(r100, r101);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory r100) {
        super.setThreadFactory(ThreadFactoryProxy.Companion.proxy(r100, 8));
    }
}
