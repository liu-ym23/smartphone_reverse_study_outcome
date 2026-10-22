package spa;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f542918a;

    public e() {
    }

    public static void a(Runnable r100) {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100.run();
        return;
    L9:
        if (f542918a == null) goto L11;
    L20:
        f542918a.post(r100);
        return;
    L11:
        monitor-enter(e.class);
    L17:
        th = move-exception;
        throw th;
    L13:
        if (f542918a != null) goto L15;
        f542918a = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L17
    L15:
        monitor-exit(e.class);     // Catch: Throwable -> L17
        goto L20
    L5:
        r101 = false;
        goto L6
    }
}
