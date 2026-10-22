package com.ss.android.lark.officesdk.utils.di;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ntb.w;

/* JADX INFO: loaded from: classes37.dex */
public final class ThreadUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<Handler> f437211a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<ExecutorService> f437212b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<ExecutorService> f437213c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<ExecutorService> f437214d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<ExecutorService> f437215e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<ScheduledExecutorService> f437216f = null;

    public static final class a {
        @JvmStatic
        public static w c() {
            DependencyContainer r100 = DependencyContainer.f433166a;
            return (w) DependencyContainer.a(w.class, null);
        }

        @JvmStatic
        public static void a(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "runnable");
            w r101 = c();
            if (r101 == null) goto L6;
            ExecutorService r102 = r101.S();
            if (r102 == null) goto L6;
        L7:
            if (r102 == null) goto L9;
            r102.execute(r100);
            return;
        L9:
            f(r100);
            return;
        L6:
            r102 = ThreadUtil.f437213c.getValue();
            goto L7
        }

        @JvmStatic
        public static void b(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "runnable");
            w r101 = c();
            if (r101 == null) goto L6;
            ExecutorService r102 = r101.a0();
            if (r102 == null) goto L6;
        L7:
            if (r102 == null) goto L9;
            r102.execute(r100);
            return;
        L9:
            f(r100);
            return;
        L6:
            r102 = ThreadUtil.f437212b.getValue();
            goto L7
        }

        public static void e(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "runnable");
            ThreadUtil.f437211a.getValue().removeCallbacks(r100);
        }

        @JvmStatic
        public static void f(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "runnable");
            w r101 = c();
            if (r101 == null) goto L5;
            r101.E(r100);
            return;
        L5:
            ThreadUtil.f437213c.getValue().execute(r100);
        }

        @JvmStatic
        public static void g(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "runnable");
            w r101 = c();
            if (r101 == null) goto L6;
            r101.c(r100);
            return;
        L6:
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
            r100.run();
            return;
        L8:
            ThreadUtil.f437211a.getValue().post(r100);
        }

        public static void d(Runnable r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "runnable");
            ThreadUtil.f437211a.getValue().postDelayed(r100, r101);
        }
    }

    static {
        f437211a = LazyKt.lazy(ThreadUtil$Companion$mainHandler$2.INSTANCE);
        f437212b = LazyKt.lazy(ThreadUtil$Companion$fixedThreadPool$2.INSTANCE);
        f437213c = LazyKt.lazy(ThreadUtil$Companion$cachedThreadPool$2.INSTANCE);
        f437214d = LazyKt.lazy(ThreadUtil$Companion$ioThreadPool$2.INSTANCE);
        f437215e = LazyKt.lazy(ThreadUtil$Companion$cpuThreadPool$2.INSTANCE);
        f437216f = LazyKt.lazy(ThreadUtil$Companion$scheduledExecutor$2.INSTANCE);
    }
}
