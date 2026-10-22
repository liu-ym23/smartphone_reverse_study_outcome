package com.bytedance.platform.thread;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends PThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Runnable, Object> f266631a;

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        int r101 = v57.a.f553274a;
        super.execute(r100);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable r100, Throwable r101) {
        super.afterExecute(r100, r101);
        int r102 = v57.a.f553274a;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread r100, Runnable r101) {
        super.beforeExecute(r100, r101);
        int r102 = v57.a.f553274a;
    }

    public c(TimeUnit r110, BlockingQueue r111, a r112, d.a r113) {
        super(0, 128, 30, r110, r111, r112, r113);
        new ThreadLocal();
        this.f266631a = new ConcurrentHashMap();
    }
}
