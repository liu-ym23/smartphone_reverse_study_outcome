package com.ss.android.ugc.aweme.thread;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes40.dex */
class ThreadPoolProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Factory f454338a;

    public interface Factory {
    }

    public static class Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ThreadPoolProvider f454339a = null;

        static {
            f454339a = new ThreadPoolProvider(0);
        }
    }

    private ThreadPoolProvider() {
        new ThreadPoolStore();
        this.f454338a = new NewInstanceFactory();
    }

    public /* synthetic */ ThreadPoolProvider(int r100) {
        this();
    }

    public final ExecutorService a(ThreadPoolOptions r210) {
        ((NewInstanceFactory) this.f454338a).getClass();
        String.format("create: taskType=%s", new Object[]{r210.f454324a});
        switch(NewInstanceFactory.AnonymousClass4.f454299a[r210.f454324a.ordinal()]) {
            case 1: goto L50;
            case 2: goto L49;
            case 3: goto L48;
            case 4: goto L39;
            case 5: goto L22;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        ExecutorService r100 = NewInstanceFactory.a(r210);
    L51:
        ThreadPoolHelper.f454304a.getClass();
        return r100;
    L5:
        ThreadPoolType r101 = ThreadPoolType.FIXED;
        int r110 = r210.f454326c;
        long r111 = r210.f454329f;
        if (r111 >= 0) goto L9;
        r111 = ThreadPoolHelper.f454308e;
    L9:
        TimeUnit r112 = TimeUnit.SECONDS;
        BlockingQueue r102 = r210.f454327d;
        if (r102 != null) goto L13;
        r102 = new LinkedBlockingQueue();
    L13:
        BlockingQueue r113 = r102;
        String r103 = r210.f454325b;
        if (r103 != null) goto L17;
        r103 = "tp-fixed";
    L17:
        NewInstanceFactory.AnonymousClass3 r104 = new NewInstanceFactory.AnonymousClass3(0, r103, false);
        RejectedExecutionHandler r105 = r210.f454328e;
        if (r105 != null) goto L21;
        r105 = new ThreadPoolExecutor.AbortPolicy();
    L21:
        BaseThreadPoolExecutor r106 = new BaseThreadPoolExecutor(r101, r110, r110, r111, r112, r113, r104, r105);
        r106.allowCoreThreadTimeOut(true);
        r100 = r106;
        goto L51
    L22:
        ThreadPoolType r114 = ThreadPoolType.SERIAL;
        long r107 = r210.f454329f;
        if (r107 < 0) goto L25;
        long r211 = r107;
    L26:
        TimeUnit r212 = TimeUnit.SECONDS;
        BlockingQueue r108 = r210.f454327d;
        if (r108 != null) goto L30;
        r108 = new LinkedBlockingQueue();
    L30:
        BlockingQueue r213 = r108;
        String r109 = r210.f454325b;
        if (r109 != null) goto L34;
        r109 = "tp-serial";
    L34:
        NewInstanceFactory.AnonymousClass3 r115 = new NewInstanceFactory.AnonymousClass3(0, r109, false);
        RejectedExecutionHandler r116 = r210.f454328e;
        if (r116 != null) goto L38;
        r116 = new ThreadPoolExecutor.AbortPolicy();
    L38:
        BaseThreadPoolExecutor r117 = new BaseThreadPoolExecutor(r114, 1, 1, r211, r212, r213, r115, r116);
        r117.allowCoreThreadTimeOut(true);
        r100 = r117;
        goto L51
    L25:
        r211 = ThreadPoolHelper.f454308e;
        goto L26
    L39:
        int r118 = r210.f454326c;
        String r119 = r210.f454325b;
        if (r119 != null) goto L43;
        r119 = "tp-scheduled";
    L43:
        PThreadScheduledThreadPoolExecutor r120 = new PThreadScheduledThreadPoolExecutor(r118, new NewInstanceFactory.AnonymousClass3(0, r119, false));
        long r121 = r210.f454329f;
        if (r121 >= 0) goto L47;
        r121 = ThreadPoolHelper.f454309f;
    L47:
        r120.setKeepAliveTime(r121, TimeUnit.SECONDS);
        r120.allowCoreThreadTimeOut(true);
        r100 = r120;
        goto L51
    L48:
        r100 = new BaseThreadPoolExecutor(ThreadPoolType.BACKGROUND, 0, 3, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new NewInstanceFactory.AnonymousClass3(10, "tp-background", true), NewInstanceFactory.f454293j);
        goto L51
    L49:
        BaseThreadPoolExecutor r122 = new BaseThreadPoolExecutor(ThreadPoolType.DEFAULT, NewInstanceFactory.f454285b, NewInstanceFactory.f454286c, ThreadPoolHelper.f454307d, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new NewInstanceFactory.AnonymousClass3(0, "tp-default", false), NewInstanceFactory.f454293j);
        r122.allowCoreThreadTimeOut(true);
        r100 = r122;
        goto L51
    L50:
        r100 = NewInstanceFactory.a(r210);
        goto L51
    }
}
