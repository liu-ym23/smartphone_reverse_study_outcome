package r1;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes39.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile q f535574a;

    public m() {
    }

    public static q a() {
        if (f535574a != null) goto L18;
        if (f535574a == null) goto L7;
    L16:
        q.e r100 = f535574a.f535591a;
        goto L18
    L7:
        monitor-enter(m.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f535574a != null) goto L11;
        f535574a = new q();     // Catch: Throwable -> L13
        ThreadMethodProxy.start(f535574a.f535591a);     // Catch: Throwable -> L13
    L11:
        monitor-exit(m.class);     // Catch: Throwable -> L13
    L18:
        return f535574a;
    }
}
