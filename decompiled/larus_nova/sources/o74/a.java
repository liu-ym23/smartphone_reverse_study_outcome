package o74;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f522258a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C7021a f522259b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f522260c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f522261d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f522262e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f522263f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f522264g = null;

    /* JADX INFO: renamed from: o74.a$a, reason: collision with other inner class name */
    public static class C7021a extends m74.e<Executor> {
        public C7021a() {
        }

        @Override // m74.e
        public final Executor a(Object[] r110) {
            int r100 = a.f522258a;
            return new PThreadPoolExecutor((int) (((double) r100) * 0.5d), r100 * 20, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("xecutorUtil$1"), new ThreadPoolExecutor.DiscardOldestPolicy());
        }
    }

    public static class b extends m74.e<ExecutorService> {
        public b() {
        }

        @Override // m74.e
        public final ExecutorService a(Object[] r110) {
            int r100 = a.f522258a;
            return new PThreadPoolExecutor((int) (((double) r100) * 0.5d), r100 * 20, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("xecutorUtil$2"), new ThreadPoolExecutor.CallerRunsPolicy());
        }
    }

    public static class c extends m74.e<ExecutorService> {
        public c() {
        }

        @Override // m74.e
        public final ExecutorService a(Object[] r110) {
            int r100 = a.f522258a;
            return new PThreadPoolExecutor((int) (((double) r100) * 0.5d), r100 * 10, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("xecutorUtil$3"), new ThreadPoolExecutor.CallerRunsPolicy());
        }
    }

    public static class d extends m74.e<ExecutorService> {
        public d() {
        }

        @Override // m74.e
        public final ExecutorService a(Object[] r110) {
            int r100 = a.f522258a;
            return new PThreadPoolExecutor((int) (((double) r100) * 0.5d), r100 * 10, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("xecutorUtil$4"), new ThreadPoolExecutor.CallerRunsPolicy());
        }
    }

    public static class e extends m74.e<Looper> {
        public e() {
        }

        @Override // m74.e
        public final Looper a(Object[] r100) {
            PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("applog_device_register");     // Catch: Exception -> L4
            ThreadMethodProxy.start(r101);     // Catch: Exception -> L4
            return r101.getLooper();
        L5:
            return Looper.getMainLooper();
        }
    }

    public static class f extends m74.e<Handler> {
        public f() {
        }

        @Override // m74.e
        public final Handler a(Object[] r100) {
            return new Handler(a.f522263f.b(new Object[0]));
        }
    }

    static {
        f522258a = Runtime.getRuntime().availableProcessors();
        f522259b = new C7021a();
        f522260c = new b();
        f522261d = new c();
        f522262e = new d();
        f522263f = new e();
        f522264g = new f();
    }
}
