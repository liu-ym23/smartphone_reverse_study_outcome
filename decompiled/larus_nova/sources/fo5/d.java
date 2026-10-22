package fo5;

import com.bytedance.ee.bear.thread.BearExecutors;
import com.larksuite.framework.thread.CoreThreadPool;
import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorScheduler f478129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ExecutorScheduler f478130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ExecutorScheduler f478131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static e f478132d;

    public static Scheduler a() {
        if (f478129a != null) goto L6;
        f478129a = new ExecutorScheduler(CoreThreadPool.getDefault().getFixedThreadPool(), false);
    L6:
        if (f478129a != null) goto L9;
        f478129a = new ExecutorScheduler(BearExecutors.a(), false);
    L9:
        return f478129a;
    }

    public static Scheduler b() {
        if (f478130b != null) goto L6;
        f478130b = new ExecutorScheduler(CoreThreadPool.getDefault().getCachedThreadPool(), false);
    L6:
        if (f478130b != null) goto L9;
        f478130b = new ExecutorScheduler(BearExecutors.b(), false);
    L9:
        return f478130b;
    }

    public static Scheduler c() {
        if (f478130b != null) goto L6;
        f478130b = new ExecutorScheduler(CoreThreadPool.getDefault().getCachedThreadPool(), false);
    L6:
        if (f478130b != null) goto L9;
        f478130b = new ExecutorScheduler(BearExecutors.b(), false);
    L9:
        return f478130b;
    }

    public static Scheduler d() {
        if (f478131c != null) goto L6;
        f478131c = new ExecutorScheduler(CoreThreadPool.getDefault().getUIExecutor(), false);
    L6:
        if (f478131c != null) goto L9;
        f478131c = new ExecutorScheduler(BearExecutors.f(), false);
    L9:
        return f478131c;
    }

    public static Scheduler e() {
        if (f478130b != null) goto L6;
        f478130b = new ExecutorScheduler(CoreThreadPool.getDefault().getCachedThreadPool(), false);
    L6:
        if (f478130b != null) goto L9;
        f478130b = new ExecutorScheduler(BearExecutors.b(), false);
    L9:
        return f478130b;
    }

    public static Scheduler f() {
        if (f478132d != null) goto L6;
        f478132d = new e();
    L6:
        return f478132d;
    }
}
