package com.huawei.hms.framework.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public class ThreadPoolExcutorEnhance extends ThreadPoolExecutor {
    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r100) {
        super.execute(new RunnableEnhance(r100));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread r100, Runnable r101) {
        if ((r101 instanceof RunnableEnhance) == false) goto L11;
        String r102 = ((RunnableEnhance) r101).getParentName();
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

    public ThreadPoolExcutorEnhance(int r100, int r101, long r102, TimeUnit r103, BlockingQueue<Runnable> r104, ThreadFactory r105) {
        super(r100, r101, r102, r103, r104, r105);
    }

    public ThreadPoolExcutorEnhance(int r110, int r111, int r112, TimeUnit r113, LinkedBlockingQueue<Runnable> r114, ThreadFactory r115, RejectedExecutionHandler r116) {
        super(r110, r111, r112, r113, r114, r115, r116);
    }
}
