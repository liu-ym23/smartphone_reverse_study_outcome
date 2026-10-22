package l56;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PThreadScheduledThreadPoolExecutor f507527c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f507528d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f507529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f507530b;

    static {
        f507527c = new PThreadScheduledThreadPoolExecutor(4, new DefaultThreadFactory("d/TaskManager"));
    }

    public static synchronized b a() {
        monitor-enter(b.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f507528d != null) goto L7;
        f507528d = new b();     // Catch: Throwable -> L10
    L7:
        b r100 = f507528d;     // Catch: Throwable -> L10
        monitor-exit(b.class);
        return r100;
    }

    public b() {
        this.f507529a = false;
    }
}
