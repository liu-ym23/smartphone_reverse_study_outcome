package ir7;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f495489b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f495490a;

    public static d a() {
        if (f495489b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f495489b != null) goto L9;
        f495489b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f495489b;
    }

    public d() {
    }
}
