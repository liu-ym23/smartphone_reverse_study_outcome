package com.huawei.hms.framework.common;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes23.dex */
public class ScheduledThreadPoolExecutorEnhance extends ScheduledThreadPoolExecutor {
    private static final String TAG = "ScheduledThreadPoolExec";

    public ScheduledThreadPoolExecutorEnhance(int r100, ThreadFactory r101) {
        super(r100, r101);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread r100, Runnable r101) {
        if ((r101 instanceof RunnableScheduledFutureEnhance) == false) goto L11;
        String r102 = ((RunnableScheduledFutureEnhance) r101).getParentName();
        int r103 = r102.lastIndexOf(" ->");
        if (r103 == (-1)) goto L7;
        r102 = StringUtils.substring(r102, r103 + 3);
    L7:
        String r104 = r100.getName();
        int r105 = r104.lastIndexOf(" ->");
        if (r105 == (-1)) goto L10;
        r104 = StringUtils.substring(r104, r105 + 3);
    L10:
        r100.setName(r102 + " ->" + r104);
    L11:
        super.beforeExecute(r100, r101);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public <V> RunnableScheduledFuture<V> decorateTask(Runnable r100, RunnableScheduledFuture<V> r101) {
        return new RunnableScheduledFutureEnhance(super.decorateTask(r100, r101));
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public <V> RunnableScheduledFuture<V> decorateTask(Callable<V> r100, RunnableScheduledFuture<V> r101) {
        return new RunnableScheduledFutureEnhance(super.decorateTask(r100, r101));
    }
}
