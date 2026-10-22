package i8a;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.LynxThreadPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes32.dex */
public abstract class l {
    private static final String TAG = "LynxLazyInitializer";
    private static final long TIMEOUT = 3;
    private final AtomicBoolean initialized;
    private final com.lynx.tasm.utils.k runnable;

    public static /* synthetic */ void e(l r100) {
        r100.runCatching();
    }

    public abstract boolean doInitialize();

    public boolean ensureInitialized() {
        return ensureInitialized(true);
    }

    private void runCatching() {
        this.initialized.set(doInitialize());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        LLog.e(TAG, "initialize failed: " + th);
    }

    public void initialize() {
        if (this.runnable.f384096b.get() != 0) goto L6;
        LynxThreadPool.a().execute(this.runnable);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [i8a.k] */
    public l() {
        this.runnable = new com.lynx.tasm.utils.k(new k(this));
        this.initialized = new AtomicBoolean(false);
    }

    public boolean ensureInitialized(boolean r100) {
        if (this.runnable.f384096b.get() == 3) goto L5;
        if (r100 == true) goto L8;
        initialize();
    L9:
        com.lynx.tasm.utils.k r101 = this.runnable;
        TimeUnit r102 = TimeUnit.SECONDS;
        r101.getClass();
        boolean r103 = r101.f384098d.await(3, r102);     // Catch: InterruptedException -> L12
    L13:
        if (r103 == true) goto L17;
        LLog.e(TAG, "ensureInitialized timeout");
        return false;
    L17:
        return this.initialized.get();
    L12:
        r103 = false;
        goto L13
    L8:
        this.runnable.run();
        goto L9
    L5:
        return this.initialized.get();
    }
}
