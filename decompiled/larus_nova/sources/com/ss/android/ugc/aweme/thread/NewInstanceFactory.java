package com.ss.android.ugc.aweme.thread;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes40.dex */
class NewInstanceFactory implements ThreadPoolProvider.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f454284a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f454285b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f454286c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ExecutorService f454287d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ExecutorService f454288e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f454289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f454290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f454291h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final RejectedExecutionHandler f454292i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final RejectedExecutionHandler f454293j = null;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.thread.NewInstanceFactory$3, reason: invalid class name */
    final class AnonymousClass3 implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f454294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f454295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f454296c;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(final Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(new AnonymousClass1(this, r100), "NewInstanceFactory$3");
            ThreadMethodProxy.setName(r101, this.f454295b + "-" + NewInstanceFactory.f454284a.incrementAndGet());
            r101.setDaemon(this.f454296c);
            return r101;
        }

        public AnonymousClass3(int r100, String r101, boolean r102) {
            this.f454294a = r100;
            this.f454295b = r101;
            this.f454296c = r102;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.thread.NewInstanceFactory$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f454299a = null;

        static {
            int[] r100 = new int[ThreadPoolType.values().length];
            f454299a = r100;
            r100[ThreadPoolType.IO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f454299a[ThreadPoolType.DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f454299a[ThreadPoolType.BACKGROUND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f454299a[ThreadPoolType.SCHEDULED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f454299a[ThreadPoolType.SERIAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f454299a[ThreadPoolType.FIXED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public NewInstanceFactory() {
    }

    static {
        int r100 = Runtime.getRuntime().availableProcessors();
        f454284a = new AtomicInteger(0);
        int r101 = r100 + 1;
        int r102 = r100 - 1;
        int r103 = Math.max(2, Math.min(r102, 6)) * 2;
        int r104 = Math.max(2, Math.min(r102, 4));
        f454285b = r104;
        f454286c = (r104 * 2) + 1;
        f454287d = b(r103, ThreadPoolType.IO, "tp-reject");
        f454288e = b(r101, ThreadPoolType.DEFAULT, "tp-default-reject");
        f454291h = TimeUnit.SECONDS.toMillis(3);
        f454292i = new AnonymousClass1();
        f454293j = new AnonymousClass2();
    }

    public static ExecutorService a(ThreadPoolOptions r110) {
        int r111 = r110.f454330g;
        if (r111 <= 0) goto L6;
        if (r111 > 128) goto L6;
        int r100 = r111;
    L7:
        Arrays.toString(new Exception().getStackTrace());
        return new BaseThreadPoolExecutor(ThreadPoolType.IO, 0, r100, ThreadPoolHelper.f454307d, TimeUnit.SECONDS, new SynchronousQueue(), new AnonymousClass3(0, "tp-io", false), f454292i);
    L6:
        r100 = 128;
        goto L7
    }

    public static ExecutorService b(int r110, ThreadPoolType r111, String r112) {
        BaseThreadPoolExecutor r100 = new BaseThreadPoolExecutor(r111, r110, r110, ThreadPoolHelper.f454307d, TimeUnit.SECONDS, new LinkedBlockingQueue(), new AnonymousClass3(0, r112, false));
        r100.allowCoreThreadTimeOut(true);
        return r100;
    }
}
