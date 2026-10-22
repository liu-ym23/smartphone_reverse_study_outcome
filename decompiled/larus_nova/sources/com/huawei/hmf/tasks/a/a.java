package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f276768b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f276769c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f276770d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f276771e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f276772a;

    /* JADX INFO: renamed from: com.huawei.hmf.tasks.a.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C3870a {
    }

    public static class b implements Executor {
        public b() {
        }

        public /* synthetic */ b(C3870a r100) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            new Handler(Looper.getMainLooper()).post(r100);
        }
    }

    static {
        f276768b = new a();
        int r100 = Runtime.getRuntime().availableProcessors();
        f276769c = r100;
        f276770d = r100 + 1;
        f276771e = (r100 * 2) + 1;
    }

    public a() {
        this.f276772a = new b(null);
    }

    public static ExecutorService a() {
        ThreadPoolExecutor r100 = new ThreadPoolExecutor(f276770d, f276771e, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        r100.allowCoreThreadTimeOut(true);
        return r100;
    }

    public static Executor b() {
        return f276768b.f276772a;
    }
}
