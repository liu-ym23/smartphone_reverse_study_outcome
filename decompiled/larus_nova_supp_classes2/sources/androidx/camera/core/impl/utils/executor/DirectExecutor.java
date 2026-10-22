package androidx.camera.core.impl.utils.executor;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class DirectExecutor implements Executor {
    private static volatile DirectExecutor sDirectExecutor;

    public DirectExecutor() {
    }

    public static Executor getInstance() {
        if (sDirectExecutor == null) goto L7;
        return sDirectExecutor;
    L7:
        monitor-enter(DirectExecutor.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sDirectExecutor != null) goto L11;
        sDirectExecutor = new DirectExecutor();     // Catch: Throwable -> L14
    L11:
        monitor-exit(DirectExecutor.class);     // Catch: Throwable -> L14
        return sDirectExecutor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r1) {
        r1.run();
    }
}
