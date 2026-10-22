package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class MainThreadExecutor {
    private static volatile ScheduledExecutorService sInstance;

    public static ScheduledExecutorService getInstance() {
        if (sInstance == null) goto L7;
        return sInstance;
    L7:
        monitor-enter(MainThreadExecutor.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sInstance != null) goto L11;
        sInstance = new HandlerScheduledExecutorService(new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L14
    L11:
        monitor-exit(MainThreadExecutor.class);     // Catch: Throwable -> L14
        return sInstance;
    }

    private MainThreadExecutor() {
    }
}
