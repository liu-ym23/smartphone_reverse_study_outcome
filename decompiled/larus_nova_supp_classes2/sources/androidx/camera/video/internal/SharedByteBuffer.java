package androidx.camera.video.internal;

import androidx.camera.core.Logger;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class SharedByteBuffer implements Closeable {
    private static final String TAG = "SharedByteBuffer";
    private final Object mCloseLock;
    private boolean mClosed;
    private final Pair<Executor, Runnable> mFinalCloseAction;
    private final int mShareId;
    private final ByteBuffer mSharedByteBuffer;
    private final AtomicInteger mSharedRefCount;

    private boolean closeInternal() {
        Object r0 = this.mCloseLock;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L25
        return false;
    L8:
        this.mClosed = true;     // Catch: Throwable -> L25
        int r3 = this.mSharedRefCount.decrementAndGet();     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        if (Logger.isDebugEnabled(TAG) == false) goto L16;
        if (r3 < 0) goto L15;
        Logger.d(TAG, String.format(Locale.US, "Ref count decremented: %d [%s]", new Object[]{Integer.valueOf(r3), toString()}));
        goto L16
    L15:
        throw new AssertionError("Invalid ref count. close() should never produce a ref count below 0");
    L16:
        if (r3 == 0) goto L18;
    L24:
        return true;
    L18:
        if (Logger.isDebugEnabled(TAG) == false) goto L28;
        Logger.d(TAG, String.format(Locale.US, "Final reference released. Running final close action. [%s]", new Object[]{toString()}));
    L28:
        ((Executor) Preconditions.checkNotNull((Executor) this.mFinalCloseAction.first)).execute((Runnable) Preconditions.checkNotNull((Runnable) this.mFinalCloseAction.second));     // Catch: RejectedExecutionException -> L22
    L22:
        e = move-exception;
        Logger.e(TAG, String.format(Locale.US, "Unable to execute final close action. [%s]", new Object[]{toString()}), e);
        goto L24
    }

    public ByteBuffer get() {
        Object r0 = this.mCloseLock;
        monitor-enter(r0);
        checkNotClosed("get()");     // Catch: Throwable -> L7
        ByteBuffer r1 = this.mSharedByteBuffer;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public SharedByteBuffer share() {
        Object r0 = this.mCloseLock;
        monitor-enter(r0);
        checkNotClosed("share()");     // Catch: Throwable -> L15
        int r1 = this.mSharedRefCount.incrementAndGet();     // Catch: Throwable -> L15
        AtomicInteger r2 = this.mSharedRefCount;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        if (Logger.isDebugEnabled(TAG) == false) goto L14;
        if (r1 <= 1) goto L12;
        Logger.d(TAG, String.format(Locale.US, "Ref count incremented: %d [%s]", new Object[]{Integer.valueOf(r1), toString()}));
        goto L14
    L12:
        throw new AssertionError("Invalid ref count. share() should always produce a ref count of 2 or more.");
    L14:
        return new SharedByteBuffer(this.mSharedByteBuffer.asReadOnlyBuffer(), r2, this.mFinalCloseAction, this.mShareId);
    L15:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return String.format(Locale.US, "SharedByteBuffer[buf: %s, shareId: 0x%x, instanceId:0x%x]", new Object[]{this.mSharedByteBuffer, Integer.valueOf(this.mShareId), Integer.valueOf(System.identityHashCode(this))});
    }

    public void finalize() throws Throwable {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (closeInternal() == false) goto L5;
        Logger.w(TAG, String.format(Locale.US, "SharedByteBuffer closed by finalizer, but should have been closed manually with SharedByteBuffer.close() [%s]", new Object[]{toString()}));     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeInternal();
    }

    private void checkNotClosed(String r4) {
        if (this.mClosed == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot call " + r4 + " on a closed SharedByteBuffer.");
    }

    public static SharedByteBuffer newSharedInstance(ByteBuffer r4, Executor r5, Runnable r6) {
        AtomicInteger r0 = new AtomicInteger(1);
        int r1 = System.identityHashCode(r4);
        return new SharedByteBuffer(((ByteBuffer) Preconditions.checkNotNull(r4)).asReadOnlyBuffer(), r0, new Pair((Executor) Preconditions.checkNotNull(r5), (Runnable) Preconditions.checkNotNull(r6)), r1);
    }

    private SharedByteBuffer(ByteBuffer r3, AtomicInteger r4, Pair<Executor, Runnable> r5, int r6) {
        this.mCloseLock = new Object();
        this.mClosed = false;
        this.mSharedByteBuffer = r3;
        this.mSharedRefCount = r4;
        this.mFinalCloseAction = r5;
        this.mShareId = r6;
        if (Logger.isDebugEnabled(TAG) == false) goto L9;
        int r7 = r4.get();
        if (r7 < 1) goto L8;
        return;
    L8:
        throw new AssertionError(String.format(Locale.US, "Cannot create new instance of SharedByteBuffer with invalid ref count %d. Ref count must be >= 1. [%s]", new Object[]{Integer.valueOf(r7), toString()}));
    }
}
