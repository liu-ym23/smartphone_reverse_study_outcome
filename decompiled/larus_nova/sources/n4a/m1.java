package n4a;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes32.dex */
public abstract class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PThreadPoolExecutor f517516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<l1, Future<?>> f517517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f517518c;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m1 f517519a;

        public a(m1 r100) {
            this.f517519a = r100;
        }
    }

    public m1() {
        this.f517517b = new ConcurrentHashMap();
        this.f517518c = new a(this);
    }

    public final synchronized void a(l1 r100, Future<?> r101) {
        monitor-enter(this);
        this.f517517b.put(r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        r.f(th, "TPool", "addQueue");     // Catch: Throwable -> L10
        th.printStackTrace();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void b(l1 r100) {
        monitor-enter(this);
        boolean r101 = this.f517517b.containsKey(r100);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);
        if (r101 == false) goto L11;
        return;
    L11:
        PThreadPoolExecutor r102 = this.f517516a;
        if (r102 != null) goto L14;
        return;
    L14:
        if (r102.isShutdown() == true) goto L35;
        r100.f517458a = this.f517518c;
        Future<?> r103 = this.f517516a.submit(r100);     // Catch: RejectedExecutionException -> L22
        if (r103 != null) goto L20;
        return;
    L20:
        a(r100, r103);
        return;
    L22:
        e = move-exception;
        r.f(e, "TPool", "addTask");
        return;
    L35:
        return;
    L5:
        th = move-exception;
        r.f(th, "TPool", LynxVideoManagerLite.CONTAIN);     // Catch: Throwable -> L25
        th.printStackTrace();     // Catch: Throwable -> L25
        r101 = false;
    L25:
        th = move-exception;
        throw th;
    }
}
