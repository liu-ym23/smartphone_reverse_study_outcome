package dqc;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class e {
    public static final Executor a = null;
    public static final Object b = null;
    public static Handler c;

    public static class a implements ThreadFactory {
        public final AtomicInteger a;

        public a() {
            this.a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r4) {
            return new PthreadThreadV2(r4, "zeus-Fast-" + this.a.getAndIncrement());
        }
    }

    static {
        a = PThreadExecutorsUtils.newCachedThreadPool(new a());
        b = new Object();
        c = null;
    }

    public static Handler a() {
        Object r0 = b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (c != null) goto L7;
        c = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L10
    L7:
        Handler r1 = c;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    }

    public static void b(Runnable r1) {
        a.execute(r1);
    }
}
