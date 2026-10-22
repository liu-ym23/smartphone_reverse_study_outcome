package fo5;

import com.bytedance.ee.bear.thread.BearExecutors;
import com.larksuite.framework.thread.CoreThreadPool;
import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static ExecutorScheduler a;
    public static ExecutorScheduler b;
    public static ExecutorScheduler c;
    public static e d;

    public static Scheduler a() {
        if (a != null) goto L6;
        a = new ExecutorScheduler(CoreThreadPool.getDefault().getFixedThreadPool(), false);
    L6:
        if (a != null) goto L9;
        a = new ExecutorScheduler(BearExecutors.a(), false);
    L9:
        return a;
    }

    public static Scheduler b() {
        if (b != null) goto L6;
        b = new ExecutorScheduler(CoreThreadPool.getDefault().getCachedThreadPool(), false);
    L6:
        if (b != null) goto L9;
        b = new ExecutorScheduler(BearExecutors.b(), false);
    L9:
        return b;
    }

    public static Scheduler c() {
        if (b != null) goto L6;
        b = new ExecutorScheduler(CoreThreadPool.getDefault().getCachedThreadPool(), false);
    L6:
        if (b != null) goto L9;
        b = new ExecutorScheduler(BearExecutors.b(), false);
    L9:
        return b;
    }

    public static Scheduler d() {
        if (c != null) goto L6;
        c = new ExecutorScheduler(CoreThreadPool.getDefault().getUIExecutor(), false);
    L6:
        if (c != null) goto L9;
        c = new ExecutorScheduler(BearExecutors.f(), false);
    L9:
        return c;
    }

    public static Scheduler e() {
        if (b != null) goto L6;
        b = new ExecutorScheduler(CoreThreadPool.getDefault().getCachedThreadPool(), false);
    L6:
        if (b != null) goto L9;
        b = new ExecutorScheduler(BearExecutors.b(), false);
    L9:
        return b;
    }

    public static Scheduler f() {
        if (d != null) goto L6;
        d = new e();
    L6:
        return d;
    }
}
