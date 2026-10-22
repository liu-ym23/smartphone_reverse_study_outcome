package rj4;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes15.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f538056b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static g f538057c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, e.a> f538058a;

    static {
        f538056b = g.class.getSimpleName();
    }

    public static synchronized g a() {
        monitor-enter(g.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f538057c != null) goto L7;
        final g r100 = new g();     // Catch: Throwable -> L10
        f538057c = r100;     // Catch: Throwable -> L10
        ThreadMethodProxy.start(new PthreadThreadV2(new f(r100), "BWDLSendStrategy"));     // Catch: Throwable -> L10
    L7:
        g r101 = f538057c;     // Catch: Throwable -> L10
        monitor-exit(g.class);
        return r101;
    }

    public g() {
        this.f538058a = new ConcurrentHashMap();
    }

    public final synchronized void c(byte r100) {
        monitor-enter(this);
        this.f538058a.remove(Integer.valueOf(r100 | 3158016));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(byte r100, e.a r101) {
        monitor-enter(this);
        this.f538058a.put(Integer.valueOf(r100 | 3158016), r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
