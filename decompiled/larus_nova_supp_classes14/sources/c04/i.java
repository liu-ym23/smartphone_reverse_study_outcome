package c04;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public static ExecutorService a;
    public static Handler b;

    public static void b() {
        ExecutorService r0 = a;
        if (r0 != null) goto L5;
    L8:
        a = (ExecutorService) AsyncTask.THREAD_POOL_EXECUTOR;
        b = new Handler(Looper.getMainLooper());
        return;
    L5:
        if (r0.isTerminated() == true) goto L8;
        if (b == null) goto L8;
    }

    public static void a(Runnable r1) {
        b();
        b.removeCallbacks(r1);
    }
}
