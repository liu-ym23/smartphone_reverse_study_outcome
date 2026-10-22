package mra;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PThreadScheduledThreadPoolExecutor f515039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f515040b = null;

    public d() {
    }

    static {
        f515040b = new d();
    }

    public final ScheduledExecutorService a() {
        if (f515039a != null) goto L15;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f515039a != null) goto L8;
        f515039a = new PThreadScheduledThreadPoolExecutor(0, new b(com.ss.android.ad.applinksdk.core.c.class.getName().concat("-ScheduledThreadPool")));     // Catch: Throwable -> L11
    L8:
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
    L15:
        return f515039a;
    }

    public static void b(Runnable r100, long r101) {
        ScheduledExecutorService r102 = f515040b.a();     // Catch: Throwable -> L7
        if (r102 == null) goto L12;
        r102.schedule(r100, r101, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }
}
