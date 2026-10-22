package com.ss.android.ugc.bytex.pthread.base.proxy;

import android.util.EventsUtils;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J6\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J0\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J0\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010!\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\""}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PThreadScheduledThreadPoolExecutor;", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "corePoolSize", XmlPullParser.NO_NAMESPACE, "(I)V", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(ILjava/util/concurrent/ThreadFactory;)V", "handler", "Ljava/util/concurrent/RejectedExecutionHandler;", "(ILjava/util/concurrent/RejectedExecutionHandler;)V", "(ILjava/util/concurrent/ThreadFactory;Ljava/util/concurrent/RejectedExecutionHandler;)V", "allowCoreThreadTimeOut", XmlPullParser.NO_NAMESPACE, "value", XmlPullParser.NO_NAMESPACE, "schedule", "Ljava/util/concurrent/ScheduledFuture;", "command", "Ljava/lang/Runnable;", "delay", XmlPullParser.NO_NAMESPACE, "unit", "Ljava/util/concurrent/TimeUnit;", "V", "callable", "Ljava/util/concurrent/Callable;", "scheduleAtFixedRate", "initialDelay", "period", "scheduleWithFixedDelay", "setKeepAliveTime", "time", "setThreadFactory", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public class PThreadScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
    public PThreadScheduledThreadPoolExecutor(int r7) {
        super(r7, ThreadFactoryProxy.Companion.proxy(Executors.defaultThreadFactory(), 8));
        SuperThreadPool r8 = SuperThreadPool.INSTANCE;
        if (r8.getEnableBlockFetchTask() == true) goto L7;
        long r2 = r8.getScheduledThreadPoolMaxKeepAliveTime();
        TimeUnit r9 = TimeUnit.MILLISECONDS;
    L5:
        super.setKeepAliveTime(r2, r9);
        super.allowCoreThreadTimeOut(true);
        return;
    L7:
        if (allowsCoreThreadTimeOut() == true) goto L10;
        r9 = TimeUnit.SECONDS;
        r2 = Math.max(30, getKeepAliveTime(r9));
        goto L5
    }

    public PThreadScheduledThreadPoolExecutor(int r6, RejectedExecutionHandler r7) {
        super(r6, ThreadFactoryProxy.Companion.proxy(Executors.defaultThreadFactory(), 8), r7);
        SuperThreadPool r8 = SuperThreadPool.INSTANCE;
        if (r8.getEnableBlockFetchTask() == true) goto L7;
        super.setKeepAliveTime(r8.getScheduledThreadPoolMaxKeepAliveTime(), TimeUnit.MILLISECONDS);
    L5:
        super.allowCoreThreadTimeOut(true);
        return;
    L7:
        if (allowsCoreThreadTimeOut() == true) goto L10;
        TimeUnit r9 = TimeUnit.SECONDS;
        super.setKeepAliveTime(Math.max(30, getKeepAliveTime(r9)), r9);
        goto L5
    }

    public PThreadScheduledThreadPoolExecutor(int r6, ThreadFactory r7) {
        super(r6, ThreadFactoryProxy.Companion.proxy(r7, 8));
        SuperThreadPool r8 = SuperThreadPool.INSTANCE;
        if (r8.getEnableBlockFetchTask() == true) goto L7;
        super.setKeepAliveTime(r8.getScheduledThreadPoolMaxKeepAliveTime(), TimeUnit.MILLISECONDS);
    L5:
        super.allowCoreThreadTimeOut(true);
        return;
    L7:
        if (allowsCoreThreadTimeOut() == true) goto L10;
        TimeUnit r9 = TimeUnit.SECONDS;
        super.setKeepAliveTime(Math.max(30, getKeepAliveTime(r9)), r9);
        goto L5
    }

    public PThreadScheduledThreadPoolExecutor(int r5, ThreadFactory r6, RejectedExecutionHandler r7) {
        super(r5, ThreadFactoryProxy.Companion.proxy(r6, 8), r7);
        SuperThreadPool r8 = SuperThreadPool.INSTANCE;
        if (r8.getEnableBlockFetchTask() == true) goto L7;
        super.setKeepAliveTime(r8.getScheduledThreadPoolMaxKeepAliveTime(), TimeUnit.MILLISECONDS);
    L5:
        super.allowCoreThreadTimeOut(true);
        return;
    L7:
        if (allowsCoreThreadTimeOut() == true) goto L10;
        TimeUnit r9 = TimeUnit.SECONDS;
        super.setKeepAliveTime(Math.max(30, getKeepAliveTime(r9)), r9);
        goto L5
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

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable r8, long r9, TimeUnit r11) {
        SuperThreadPool r0 = SuperThreadPool.INSTANCE;
        IRunnableScheduler r1 = r0.getRunnableScheduler();
        if (r1 == null) goto L7;
        ScheduledFuture<?> r2 = r1.schedule(r8, r9, r11, this);
        if (r2 == null) goto L7;
        return r2;
    L7:
        IRunnableWrapperCreator r3 = r0.getWrapperCreator();
        if (r3 == null) goto L13;
        Runnable r4 = r3.wrap(r8, 8);
        if (r4 == null) goto L13;
        r8 = r4;
    L13:
        return super.schedule(r8, r9, r11);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> r8, long r9, TimeUnit r11) {
        SuperThreadPool r0 = SuperThreadPool.INSTANCE;
        IRunnableScheduler r1 = r0.getRunnableScheduler();
        if (r1 == null) goto L7;
        ScheduledFuture<V> r2 = r1.schedule(r8, r9, r11, this);
        if (r2 == null) goto L7;
        return r2;
    L7:
        IRunnableWrapperCreator r3 = r0.getWrapperCreator();
        if (r3 == null) goto L13;
        Callable<V> r4 = r3.wrap(r8, 8);
        if (r4 == null) goto L13;
        r8 = r4;
    L13:
        return super.schedule(r8, r9, r11);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable r10, long r11, long r13, TimeUnit r15) {
        SuperThreadPool r0 = SuperThreadPool.INSTANCE;
        IRunnableScheduler r1 = r0.getRunnableScheduler();
        if (r1 == null) goto L7;
        ScheduledFuture<?> r2 = r1.scheduleAtFixedRate(r10, r11, r13, r15, this);
        if (r2 == null) goto L7;
        return r2;
    L7:
        IRunnableWrapperCreator r3 = r0.getWrapperCreator();
        if (r3 == null) goto L12;
        Runnable r4 = r3.wrap(r10, 8);
        if (r4 == null) goto L12;
        Runnable r5 = r4;
    L14:
        return super.scheduleAtFixedRate(r5, r11, r13, r15);
    L12:
        r5 = r10;
        goto L14
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable r10, long r11, long r13, TimeUnit r15) {
        SuperThreadPool r0 = SuperThreadPool.INSTANCE;
        IRunnableScheduler r1 = r0.getRunnableScheduler();
        if (r1 == null) goto L7;
        ScheduledFuture<?> r2 = r1.scheduleWithFixedDelay(r10, r11, r13, r15, this);
        if (r2 == null) goto L7;
        return r2;
    L7:
        IRunnableWrapperCreator r3 = r0.getWrapperCreator();
        if (r3 == null) goto L12;
        Runnable r4 = r3.wrap(r10, 8);
        if (r4 == null) goto L12;
        Runnable r5 = r4;
    L14:
        return super.scheduleWithFixedDelay(r5, r11, r13, r15);
    L12:
        r5 = r10;
        goto L14
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long r3, TimeUnit r5) {
        SuperThreadPool r0 = SuperThreadPool.INSTANCE;
        if (r0.getEnableBlockFetchTask() == true) goto L5;
        r3 = r0.getScheduledThreadPoolMaxKeepAliveTime();
        r5 = TimeUnit.MILLISECONDS;
    L5:
        super.setKeepAliveTime(r3, r5);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory r3) {
        super.setThreadFactory(ThreadFactoryProxy.Companion.proxy(r3, 8));
    }
}
