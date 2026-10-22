package cs1;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f465165b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, WeakReference<b>> f465166a;

    public static c a() {
        if (f465165b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f465165b != null) goto L9;
        f465165b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f465165b;
    }

    public c() {
        this.f465166a = new HashMap();
    }
}
