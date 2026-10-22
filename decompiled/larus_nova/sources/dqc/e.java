package dqc;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f469735a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f469736b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f469737c;

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f469738a;

        public a() {
            this.f469738a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            return new PthreadThreadV2(r100, "zeus-Fast-" + this.f469738a.getAndIncrement());
        }
    }

    static {
        f469735a = PThreadExecutorsUtils.newCachedThreadPool(new a());
        f469736b = new Object();
        f469737c = null;
    }

    public static Handler a() {
        Object r100 = f469736b;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f469737c != null) goto L7;
        f469737c = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L10
    L7:
        Handler r101 = f469737c;     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    }

    public static void b(Runnable r100) {
        f469735a.execute(r100);
    }
}
