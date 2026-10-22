package v8b;

import com.ss.android.lark.g;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f553751a;

    public static synchronized a a() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f553751a != null) goto L7;
        f553751a = new a();     // Catch: Throwable -> L10
        g.a r100 = g.f425765a;     // Catch: Throwable -> L10
    L7:
        a r101 = f553751a;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r101;
    }

    public a() {
    }
}
