package fjc;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f477547a;

    public a() {
    }

    public static Handler a() {
        if (f477547a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f477547a != null) goto L9;
        f477547a = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f477547a;
    }
}
