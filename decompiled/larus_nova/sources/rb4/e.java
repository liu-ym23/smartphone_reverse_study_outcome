package rb4;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f536928b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PThreadPoolExecutor f536929a;

    public class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "TuringThreadPool$1");
            ThreadMethodProxy.setName(r101, "turing");
            ThreadMethodProxy.setPriority(r101, 5);
            return r101;
        }
    }

    public static e a() {
        if (f536928b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f536928b != null) goto L9;
        f536928b = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f536928b;
    }

    public e() {
        this.f536929a = new PThreadPoolExecutor(2, 3, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new a(), new ThreadPoolExecutor.DiscardOldestPolicy());
    }
}
