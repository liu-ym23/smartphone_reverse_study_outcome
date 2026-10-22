package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Route> f523896a;

    public e() {
        this.f523896a = new LinkedHashSet();
    }

    public final synchronized void a(Route r100) {
        monitor-enter(this);
        this.f523896a.remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
