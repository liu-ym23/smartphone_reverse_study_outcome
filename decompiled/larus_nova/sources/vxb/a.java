package vxb;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements fs5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f557513a;

    public final void a() {
        monitor-enter(a.class);
        ((ConcurrentHashMap) this.f557513a).clear();     // Catch: Throwable -> L7
        monitor-exit(a.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public a() {
        this.f557513a = new ConcurrentHashMap();
    }
}
