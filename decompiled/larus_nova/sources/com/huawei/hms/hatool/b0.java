package com.huawei.hms.hatool;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b0 f277296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b0 f277297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b0 f277298d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f277299a;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Runnable f277300a;

        public a(Runnable r100) {
            this.f277300a = r100;
        }

        public void com_huawei_hms_hatool_b0$a__run$___twin___() {
            Runnable r100 = this.f277300a;
            if (r100 == null) goto L10;
            r100.run();     // Catch: Exception -> L6
            return;
        L6:
            v.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_hatool_b0$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_hatool_b0$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hms_hatool_b0$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final AtomicInteger f277301d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadGroup f277302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f277303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f277304c;

        static {
            f277301d = new AtomicInteger(1);
        }

        public b() {
            this.f277303b = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.f277302a = r101;
            this.f277304c = "FormalHASDK-base-" + f277301d.getAndIncrement();
            return;
        L5:
            r101 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r100) {
            return new Thread(this.f277302a, r100, this.f277304c + this.f277303b.getAndIncrement(), 0);
        }
    }

    static {
        new b0();
        new b0();
        f277296b = new b0();
        f277297c = new b0();
        f277298d = new b0();
    }

    private b0() {
        LinkedBlockingQueue r100 = new LinkedBlockingQueue(5000);
        this.f277299a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, r100, new b());
    }

    public static b0 a() {
        return f277298d;
    }

    public static b0 b() {
        return f277297c;
    }

    public static b0 c() {
        return f277296b;
    }

    public void a(g r100) {
        this.f277299a.execute(new a(r100));     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        v.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
    }
}
