package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class InputBufferImpl implements InputBuffer {
    private final int mBufferIndex;
    private final ByteBuffer mByteBuffer;
    private boolean mIsEndOfStream;
    private final MediaCodec mMediaCodec;
    private long mPresentationTimeUs;
    private final AtomicBoolean mTerminated;
    private final CallbackToFutureAdapter.Completer<Void> mTerminationCompleter;
    private final ListenableFuture<Void> mTerminationFuture;

    public static /* synthetic */ Object a(AtomicReference r0, CallbackToFutureAdapter.Completer r1) {
        return lambda$new$0(r0, r1);
    }

    private void throwIfTerminated() {
        if (this.mTerminated.get() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("The buffer is submitted or canceled.");
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public boolean cancel() {
        if (this.mTerminated.getAndSet(true) == false) goto L11;
        return false;
    L11:
        this.mMediaCodec.queueInputBuffer(this.mBufferIndex, 0, 0, 0, 0);     // Catch: IllegalStateException -> L8
        this.mTerminationCompleter.set(null);     // Catch: IllegalStateException -> L8
    L10:
        return true;
    L8:
        e = move-exception;
        this.mTerminationCompleter.setException(e);
        goto L10
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public ListenableFuture<Void> getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public boolean submit() {
        if (this.mTerminated.getAndSet(true) == false) goto L14;
        return false;
    L14:
        MediaCodec r3 = this.mMediaCodec;     // Catch: IllegalStateException -> L11
        int r4 = this.mBufferIndex;     // Catch: IllegalStateException -> L11
        int r5 = this.mByteBuffer.position();     // Catch: IllegalStateException -> L11
        int r6 = this.mByteBuffer.limit();     // Catch: IllegalStateException -> L11
        long r7 = this.mPresentationTimeUs;     // Catch: IllegalStateException -> L11
        if (this.mIsEndOfStream == false) goto L8;
        int r9 = 4;
    L9:
        r3.queueInputBuffer(r4, r5, r6, r7, r9);     // Catch: IllegalStateException -> L11
        this.mTerminationCompleter.set(null);     // Catch: IllegalStateException -> L11
        return true;
    L8:
        r9 = 0;
    L11:
        e = move-exception;
        this.mTerminationCompleter.setException(e);
        return false;
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public ByteBuffer getByteBuffer() {
        throwIfTerminated();
        return this.mByteBuffer;
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public void setEndOfStream(boolean r1) {
        throwIfTerminated();
        this.mIsEndOfStream = r1;
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public void setPresentationTimeUs(long r4) {
        throwIfTerminated();
        if (r4 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        this.mPresentationTimeUs = r4;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public InputBufferImpl(MediaCodec r5, int r6) throws MediaCodec.CodecException {
        this.mTerminated = new AtomicBoolean(false);
        this.mPresentationTimeUs = 0;
        this.mIsEndOfStream = false;
        this.mMediaCodec = (MediaCodec) Preconditions.checkNotNull(r5);
        this.mBufferIndex = Preconditions.checkArgumentNonnegative(r6);
        this.mByteBuffer = r5.getInputBuffer(r6);
        final AtomicReference r7 = new AtomicReference();
        this.mTerminationFuture = CallbackToFutureAdapter.getFuture(new q0(r7));
        this.mTerminationCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r7.get());
    }

    private static /* synthetic */ Object lambda$new$0(AtomicReference r0, CallbackToFutureAdapter.Completer r1) throws Exception {
        r0.set(r1);
        return "Terminate InputBuffer";
    }
}
