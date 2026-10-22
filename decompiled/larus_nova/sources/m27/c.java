package m27;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile c f511673d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f511674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f511675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Exception> f511676c;

    public static c a() {
        if (f511673d != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f511673d != null) goto L9;
        f511673d = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f511673d;
    }

    public c() {
        this.f511674a = false;
        this.f511675b = false;
        this.f511676c = new HashMap();
    }
}
