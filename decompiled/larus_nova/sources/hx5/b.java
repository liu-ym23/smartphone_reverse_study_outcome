package hx5;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f487497e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<NetworkAsyncTaskType, b> f487498f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<hx5.a, ScheduledFuture> f487499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<hx5.a, Runnable> f487500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NetworkAsyncTaskType f487501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PThreadScheduledThreadPoolExecutor f487502d;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hx5.a f487503a;

        public final void a() {
            long r100 = System.currentTimeMillis();     // Catch: Throwable -> L7
            this.f487503a.run();     // Catch: Throwable -> L7
            if (Logger.debug() == false) goto L10;
            Logger.d(b.f487497e, "Task execute time: " + (System.currentTimeMillis() - r100));     // Catch: Throwable -> L7
        L10:
            if (this.f487503a.isLoop() == true) goto L17;
            b.a(this.f487503a.getTaskType()).f487500b.remove(this.f487503a);
            b r101 = b.a(this.f487503a.getTaskType());
        L12:
            r101.f487499a.remove(this.f487503a);
            return;
        L17:
            return;
        L7:
            th = move-exception;
            Logger.e(b.f487497e, "thread " + ThreadMethodProxy.currentThread().getName() + " exception", th);     // Catch: Throwable -> L18
            if (this.f487503a.isLoop() == true) goto L28;
            b.a(this.f487503a.getTaskType()).f487500b.remove(this.f487503a);
            r101 = b.a(this.f487503a.getTaskType());
            goto L12
        L28:
            return;
        L18:
            th = move-exception;
            if (this.f487503a.isLoop() == true) goto L22;
            b.a(this.f487503a.getTaskType()).f487500b.remove(this.f487503a);
            b.a(this.f487503a.getTaskType()).f487499a.remove(this.f487503a);
        L22:
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(hx5.a r100) {
            this.f487503a = r100;
        }
    }

    static {
        f487497e = b.class.getSimpleName();
        f487498f = new ConcurrentHashMap();
    }

    public b(NetworkAsyncTaskType r100) {
        this.f487499a = new ConcurrentHashMap();
        this.f487500b = new ConcurrentHashMap();
        this.f487501c = r100;
        this.f487502d = new PThreadScheduledThreadPoolExecutor(1, new d(r100.name()));
    }

    public static b a(NetworkAsyncTaskType r100) {
        if (r100 == null) goto L18;
        ConcurrentHashMap<NetworkAsyncTaskType, b> r101 = f487498f;
        if (r101.get(r100) != null) goto L16;
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r101.get(r100) != null) goto L10;
        r101.put(r100, new b(r100));     // Catch: Throwable -> L12
    L10:
        monitor-exit(b.class);     // Catch: Throwable -> L12
    L16:
        return r101.get(r100);
    L18:
        throw new IllegalArgumentException("unsupported async task type");
    }

    public final void b(hx5.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setTaskType(this.f487501c);
        a r101 = new a(r100);     // Catch: Throwable -> L11
        if (r100.isLoop() == false) goto L8;
        ScheduledFuture<?> r102 = this.f487502d.scheduleWithFixedDelay(r101, r100.getInitialDelay(), r100.getLoopInterval(), r100.getTimeUnit());     // Catch: Throwable -> L11
    L9:
        this.f487500b.put(r100, r101);     // Catch: Throwable -> L11
        this.f487499a.put(r100, r102);     // Catch: Throwable -> L11
        return;
    L8:
        r102 = this.f487502d.schedule(r101, r100.getInitialDelay(), r100.getTimeUnit());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    }
}
