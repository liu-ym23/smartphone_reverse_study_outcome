package ww7;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f561658d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile a f561659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile PThreadPoolExecutor f561660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f561661c;

    public static class a implements Executor {
        public a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            new Handler(Looper.getMainLooper()).post(r100);
        }
    }

    static {
        f561658d = new h();
    }

    public static PThreadPoolExecutor b() {
        PThreadPoolExecutor r100 = new PThreadPoolExecutor(1, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("r/push/sdk/b1"));
        r100.allowCoreThreadTimeOut(true);
        return r100;
    }

    public h() {
        this.f561661c = new Object();
    }

    public static void a(Runnable r100) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        r100.run();
        return;
    L5:
        h r101 = f561658d;
        if (r101.f561659a != null) goto L17;
        Object r102 = r101.f561661c;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (r101.f561659a != null) goto L12;
        r101.f561659a = new a();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
    L17:
        r101.f561659a.execute(r100);
    }
}
