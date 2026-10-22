package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraXExecutors {
    public static Executor audioExecutor() {
        return AudioExecutor.getInstance();
    }

    public static Executor directExecutor() {
        return DirectExecutor.getInstance();
    }

    public static Executor highPriorityExecutor() {
        return HighPriorityExecutor.getInstance();
    }

    public static Executor ioExecutor() {
        return IoExecutor.getInstance();
    }

    public static ScheduledExecutorService mainThreadExecutor() {
        return MainThreadExecutor.getInstance();
    }

    public static ScheduledExecutorService myLooperExecutor() {
        return HandlerScheduledExecutorService.currentThreadExecutor();
    }

    private CameraXExecutors() {
    }

    public static boolean isSequentialExecutor(Executor r0) {
        return r0 instanceof SequentialExecutor;
    }

    public static ScheduledExecutorService newHandlerExecutor(Handler r1) {
        return new HandlerScheduledExecutorService(r1);
    }

    public static Executor newSequentialExecutor(Executor r1) {
        return new SequentialExecutor(r1);
    }
}
