package y4a;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f566169a;

    public d() {
    }

    public static Handler a() {
        if (f566169a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f566169a != null) goto L9;
        f566169a = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f566169a;
    }
}
