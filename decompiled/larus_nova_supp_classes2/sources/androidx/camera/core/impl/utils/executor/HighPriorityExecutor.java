package androidx.camera.core.impl.utils.executor;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class HighPriorityExecutor implements Executor {
    private static volatile Executor sExecutor;
    private final ExecutorService mHighPriorityService;

    public static Executor getInstance() {
        if (sExecutor == null) goto L7;
        return sExecutor;
    L7:
        monitor-enter(HighPriorityExecutor.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sExecutor != null) goto L11;
        sExecutor = new HighPriorityExecutor();     // Catch: Throwable -> L14
    L11:
        monitor-exit(HighPriorityExecutor.class);     // Catch: Throwable -> L14
        return sExecutor;
    }

    public HighPriorityExecutor() {
        this.mHighPriorityService = PThreadExecutorsUtils.newSingleThreadExecutor(new AnonymousClass1(this));
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r2) {
        this.mHighPriorityService.execute(r2);
    }
}
