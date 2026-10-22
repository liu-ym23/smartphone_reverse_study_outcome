package wh4;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f559655a;

    public d() {
    }

    public static f a() {
        if (f559655a != null) goto L18;
        if (f559655a == null) goto L7;
    L16:
        f.b r100 = f559655a.f559657a;
        goto L18
    L7:
        monitor-enter(d.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f559655a != null) goto L11;
        f559655a = new f();     // Catch: Throwable -> L13
        ThreadMethodProxy.start(f559655a.f559657a);     // Catch: Throwable -> L13
    L11:
        monitor-exit(d.class);     // Catch: Throwable -> L13
    L18:
        return f559655a;
    }
}
