package androidx.camera.core.impl;

import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class DeferrableSurface {
    private static final boolean DEBUG = false;
    public static final Size SIZE_UNDEFINED = null;
    private static final String TAG = "DeferrableSurface";
    private static final AtomicInteger TOTAL_COUNT = null;
    private static final AtomicInteger USED_COUNT = null;
    private CallbackToFutureAdapter.Completer<Void> mCloseCompleter;
    private final ListenableFuture<Void> mCloseFuture;
    private boolean mClosed;
    Class<?> mContainerClass;
    private final Object mLock;
    private final Size mPrescribedSize;
    private final int mPrescribedStreamFormat;
    private CallbackToFutureAdapter.Completer<Void> mTerminationCompleter;
    private final ListenableFuture<Void> mTerminationFuture;
    private int mUseCount;

    public static final class SurfaceClosedException extends Exception {
        DeferrableSurface mDeferrableSurface;

        public DeferrableSurface getDeferrableSurface() {
            return this.mDeferrableSurface;
        }

        public SurfaceClosedException(String r1, DeferrableSurface r2) {
            super(r1);
            this.mDeferrableSurface = r2;
        }
    }

    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(String r1) {
            super(r1);
        }
    }

    public static /* synthetic */ void a(DeferrableSurface r0, String r1) {
        r0.lambda$new$2(r1);
    }

    public static /* synthetic */ Object b(DeferrableSurface r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$new$1(r1);
    }

    public static /* synthetic */ Object c(DeferrableSurface r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$new$0(r1);
    }

    public abstract ListenableFuture<Surface> provideSurface();

    static {
        SIZE_UNDEFINED = new Size(0, 0);
        DEBUG = Logger.isDebugEnabled(TAG);
        USED_COUNT = new AtomicInteger(0);
        TOTAL_COUNT = new AtomicInteger(0);
    }

    public DeferrableSurface() {
        this(SIZE_UNDEFINED, 0);
    }

    public void close() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == true) goto L13;
        this.mClosed = true;     // Catch: Throwable -> L18
        this.mCloseCompleter.set(null);     // Catch: Throwable -> L18
        if (this.mUseCount != 0) goto L9;
        CallbackToFutureAdapter.Completer<Void> r2 = this.mTerminationCompleter;     // Catch: Throwable -> L18
        this.mTerminationCompleter = null;     // Catch: Throwable -> L18
    L11:
        if (Logger.isDebugEnabled(TAG) == false) goto L14;
        Logger.d(TAG, "surface closed,  useCount=" + this.mUseCount + " closed=true " + this);     // Catch: Throwable -> L18
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L18
        if (r2 == null) goto L23;
        r2.set(null);
        return;
    L23:
        return;
    L9:
        r2 = null;
        goto L11
    L13:
        r2 = null;
        goto L14
    }

    public void decrementUseCount() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int r2 = this.mUseCount;     // Catch: Throwable -> L23
        if (r2 == 0) goto L22;
        int r3 = r2 - 1;     // Catch: Throwable -> L23
        this.mUseCount = r3;     // Catch: Throwable -> L23
        if (r3 == 0) goto L9;
    L11:
        CallbackToFutureAdapter.Completer<Void> r4 = null;
    L13:
        if (Logger.isDebugEnabled(TAG) == false) goto L17;
        Logger.d(TAG, "use count-1,  useCount=" + this.mUseCount + " closed=" + this.mClosed + " " + this);     // Catch: Throwable -> L23
        if (this.mUseCount != 0) goto L17;
        printGlobalDebugCounts("Surface no longer in use", TOTAL_COUNT.get(), USED_COUNT.decrementAndGet());     // Catch: Throwable -> L23
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L23
        if (r4 == null) goto L27;
        r4.set(null);
        return;
    L27:
        return;
    L9:
        if (this.mClosed == false) goto L11;
        r4 = this.mTerminationCompleter;     // Catch: Throwable -> L23
        this.mTerminationCompleter = null;     // Catch: Throwable -> L23
        goto L13
    L22:
        throw new IllegalStateException("Decrementing use count occurs more times than incrementing");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public ListenableFuture<Void> getCloseFuture() {
        return Futures.nonCancellationPropagating(this.mCloseFuture);
    }

    public final ListenableFuture<Surface> getSurface() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == false) goto L9;
        ListenableFuture<Surface> r1 = Futures.immediateFailedFuture(new SurfaceClosedException("DeferrableSurface already closed.", this));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L9:
        ListenableFuture<Surface> r2 = provideSurface();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    }

    public ListenableFuture<Void> getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    public int getUseCount() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mUseCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void incrementUseCount() throws SurfaceClosedException {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int r2 = this.mUseCount;     // Catch: Throwable -> L19
        if (r2 == 0) goto L7;
    L11:
        this.mUseCount = r2 + 1;     // Catch: Throwable -> L19
        if (Logger.isDebugEnabled(TAG) == true) goto L14;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return;
    L14:
        if (this.mUseCount != 1) goto L16;
        printGlobalDebugCounts("New surface in use", TOTAL_COUNT.get(), USED_COUNT.incrementAndGet());     // Catch: Throwable -> L19
    L16:
        Logger.d(TAG, "use count+1, useCount=" + this.mUseCount + " " + this);     // Catch: Throwable -> L19
        goto L17
    L7:
        if (this.mClosed == false) goto L11;
        throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public boolean isClosed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mClosed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Class<?> getContainerClass() {
        return this.mContainerClass;
    }

    public Size getPrescribedSize() {
        return this.mPrescribedSize;
    }

    public int getPrescribedStreamFormat() {
        return this.mPrescribedStreamFormat;
    }

    private /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer r2) throws Exception {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTerminationCompleter = r2;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return "DeferrableSurface-termination(" + this + ")";
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ Object lambda$new$1(CallbackToFutureAdapter.Completer r2) throws Exception {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCloseCompleter = r2;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return "DeferrableSurface-close(" + this + ")";
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$2(String r7) {
        this.mTerminationFuture.get();     // Catch: Exception -> L4
        printGlobalDebugCounts("Surface terminated", TOTAL_COUNT.decrementAndGet(), USED_COUNT.get());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "Unexpected surface termination for " + this + "\nStack Trace:\n" + r7);
        monitor-enter(this.mLock);
    L9:
        th = move-exception;
        throw th;
    L8:
        throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", new Object[]{this, Boolean.valueOf(this.mClosed), Integer.valueOf(this.mUseCount)}), e);     // Catch: Throwable -> L9
    }

    public void setContainerClass(Class<?> r1) {
        this.mContainerClass = r1;
    }

    public DeferrableSurface(Size r3, int r4) {
        this.mLock = new Object();
        this.mUseCount = 0;
        this.mClosed = false;
        this.mPrescribedSize = r3;
        this.mPrescribedStreamFormat = r4;
        ListenableFuture<Void> r5 = CallbackToFutureAdapter.getFuture(new j(this));
        this.mTerminationFuture = r5;
        this.mCloseFuture = CallbackToFutureAdapter.getFuture(new k(this));
        if (Logger.isDebugEnabled(TAG) == false) goto L6;
        printGlobalDebugCounts("Surface created", TOTAL_COUNT.incrementAndGet(), USED_COUNT.get());
        final String r6 = Log.getStackTraceString(new Exception());
        r5.addListener(new l(this, r6), CameraXExecutors.directExecutor());
        return;
    }

    private void printGlobalDebugCounts(String r3, int r4, int r5) {
        if (DEBUG == false) goto L5;
    L7:
        Logger.d(TAG, r3 + "[total_surfaces=" + r4 + ", used_surfaces=" + r5 + "](" + this + "}");
        return;
    L5:
        if (Logger.isDebugEnabled(TAG) == false) goto L7;
        Logger.d(TAG, "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        goto L7
    }
}
