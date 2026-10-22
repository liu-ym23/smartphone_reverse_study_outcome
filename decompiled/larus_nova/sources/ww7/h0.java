package ww7;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h0 f561662c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f561663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PThreadPoolExecutor f561664b;

    static {
        f561662c = new h0();
    }

    public h0() {
        h r100 = h.f561658d;
        if (r100.f561659a != null) goto L14;
        Object r101 = r100.f561661c;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (r100.f561659a != null) goto L9;
        r100.f561659a = new h.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L14:
        this.f561663a = r100.f561659a;
        r100.getClass();
        this.f561664b = h.b();
    }
}
