package rb4;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f536926b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PThreadPoolExecutor f536927a;

    public class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "TuringSingleThreadPool$1");
            ThreadMethodProxy.setName(r101, "turing_single");
            ThreadMethodProxy.setPriority(r101, 5);
            return r101;
        }
    }

    public static d b() {
        if (f536926b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f536926b != null) goto L9;
        f536926b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f536926b;
    }

    public d() {
        this.f536927a = new PThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public final void a(Runnable r100) {
        PThreadPoolExecutor r101 = this.f536927a;
        if (r101 == null) goto L6;
        r101.execute(r100);
        return;
    }
}
