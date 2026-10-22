package com.bytedance.common.utility.concurrent;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class TTThreadPoolExecutor extends PThreadPoolExecutor {
    private static final RejectedExecutionHandler DEFAULT_HANDLER = null;

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    static {
        DEFAULT_HANDLER = new ThreadPoolExecutor.AbortPolicy();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return new ArrayList();
    }

    public TTThreadPoolExecutor(int r110, int r111, long r112, TimeUnit r113, BlockingQueue<Runnable> r114, ThreadFactory r115) {
        super(r110, r111, r112, r113, r114, r115, DEFAULT_HANDLER);
    }

    public TTThreadPoolExecutor(int r100, int r101, long r102, TimeUnit r103, BlockingQueue<Runnable> r104, ThreadFactory r105, RejectedExecutionHandler r106) {
        super(r100, r101, r102, r103, r104, r105, r106);
    }
}
