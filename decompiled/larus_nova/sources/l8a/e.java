package l8a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.executors.HandlerExecutorServiceImpl;

/* JADX INFO: loaded from: classes32.dex */
public final class e extends HandlerExecutorServiceImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e f508074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f508075b;

    public static e a() {
        if (f508074a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f508074a != null) goto L9;
        Handler r100 = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
        f508075b = r100;     // Catch: Throwable -> L11
        f508074a = new e(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f508074a;
    }

    public e(Handler r100) {
        super(r100);
    }

    @Override // com.facebook.common.executors.HandlerExecutorServiceImpl, java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        if (isHandlerThread() == false) goto L5;
        r100.run();
        return;
    L5:
        Handler r101 = f508075b;
        if (r101 == null) goto L13;
        Message r102 = Message.obtain(r101, r100);
        if (Build.VERSION.SDK_INT < 22) goto L10;
        r102.setAsynchronous(true);
    L10:
        f508075b.sendMessageAtFrontOfQueue(r102);
        return;
    }
}
