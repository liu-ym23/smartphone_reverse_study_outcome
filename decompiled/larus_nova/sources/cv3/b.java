package cv3;

import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<AsyncTaskManagerType, b> f465486d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PThreadScheduledThreadPoolExecutor f465487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<cv3.a, ScheduledFuture> f465488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<cv3.a, Runnable> f465489c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cv3.a f465490a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f465490a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            av3.b.c("APM-AsyncTask", "thread " + ThreadMethodProxy.currentThread().getName() + " exception", th);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public a(cv3.a r100) {
            this.f465490a = r100;
        }
    }

    static {
        f465486d = new HashMap();
    }

    public b(String r100) {
        this.f465488b = new ConcurrentHashMap();
        this.f465489c = new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.f465487a = new PThreadScheduledThreadPoolExecutor(1, new c(r100));
    }

    public static synchronized b a(AsyncTaskManagerType r100) {
        monitor-enter(b.class);
        if (r100 == null) goto L13;
        Map<AsyncTaskManagerType, b> r101 = f465486d;     // Catch: Throwable -> L10
        b r102 = (b) ((HashMap) r101).get(r100);     // Catch: Throwable -> L10
        if (r102 != null) goto L8;
        r102 = new b(r100.name());     // Catch: Throwable -> L10
        ((HashMap) r101).put(r100, r102);     // Catch: Throwable -> L10
    L8:
        monitor-exit(b.class);
        return r102;
    L13:
        throw new IllegalArgumentException("AsyncTaskManagerType must be not null!");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final void b(cv3.a r100) {
        Runnable r101 = this.f465489c.remove(r100);     // Catch: Throwable -> L9
        if (r101 == null) goto L5;
        this.f465487a.remove(r101);     // Catch: Throwable -> L9
    L5:
        ScheduledFuture r102 = this.f465488b.remove(r100);     // Catch: Throwable -> L9
        if (r102 == null) goto L14;
        r102.cancel(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        av3.b.c("APM-AsyncTask", "removeTask failed", th);
    }

    public final void c(cv3.a r100) {
        if (r100 != null) goto L13;
        return;
    L13:
        a r101 = new a(r100);     // Catch: Throwable -> L10
        if (r100.f465484b == false) goto L7;
        ScheduledFuture<?> r102 = this.f465487a.scheduleWithFixedDelay(r101, r100.f465483a, r100.f465485c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.f465489c.put(r100, r101);     // Catch: Throwable -> L10
        this.f465488b.put(r100, r102);     // Catch: Throwable -> L10
        return;
    L7:
        r102 = this.f465487a.schedule(r101, r100.f465483a, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        av3.b.c("APM-AsyncTask", "sendTask failed.", th);
    }
}
