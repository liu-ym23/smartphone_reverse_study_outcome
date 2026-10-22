package ly2;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f511296b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Set<String>> f511297a;

    public static d a() {
        if (f511296b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f511296b != null) goto L9;
        f511296b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f511296b;
    }

    public d() {
        this.f511297a = new ConcurrentHashMap();
    }
}
