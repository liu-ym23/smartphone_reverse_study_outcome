package n4a;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes32.dex */
public final class k1 extends m1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k1 f517430d = null;

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread r100, Throwable r101) {
            r.f(r101, "TPool", "ThreadPool");
        }
    }

    static {
        a r100 = new a();
        j1.a r101 = new j1.a();
        r101.f517408a = r100;
        r101.f517409b = "amap-global-threadPool";
        j1 r102 = new j1(r101);
        r101.f517408a = null;
        r101.f517409b = null;
        f517430d = new k1(r102);
    }

    public k1(j1 r110) {
        PThreadPoolExecutor r100 = new PThreadPoolExecutor(r110.f517404e, r110.f517405f, r110.f517407h, TimeUnit.SECONDS, r110.f517406g, r110);     // Catch: Throwable -> L5
        this.f517516a = r100;     // Catch: Throwable -> L5
        r100.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r.f(th, "TPool", "ThreadPool");
        th.printStackTrace();
    }
}
