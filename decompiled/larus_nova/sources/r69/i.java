package r69;

import com.larus.utils.t0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes27.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f536382a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference<u19.f> f536383b = null;

    public i() {
    }

    static {
        f536382a = new i();
        f536383b = new AtomicReference(null);
    }

    public final synchronized void a(final a r100) {
        monitor-enter(this);
        t0.e(new h(r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
