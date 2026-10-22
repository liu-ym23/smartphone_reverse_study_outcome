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
public class EncodedDataImpl implements EncodedData {
    private final int mBufferIndex;
    private final MediaCodec.BufferInfo mBufferInfo;
    private final ByteBuffer mByteBuffer;
    private final AtomicBoolean mClosed;
    private final CallbackToFutureAdapter.Completer<Void> mClosedCompleter;
    private final ListenableFuture<Void> mClosedFuture;
    private final MediaCodec mMediaCodec;

    public static /* synthetic */ Object a(AtomicReference r0, CallbackToFutureAdapter.Completer r1) {
        return lambda$new$0(r0, r1);
    }

    private void throwIfClosed() {
        if (this.mClosed.get() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("encoded data is closed.");
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData, java.lang.AutoCloseable
    public void close() {
        if (this.mClosed.getAndSet(true) == false) goto L11;
        return;
    L11:
        this.mMediaCodec.releaseOutputBuffer(this.mBufferIndex, false);     // Catch: IllegalStateException -> L8
        this.mClosedCompleter.set(null);
        return;
    L8:
        e = move-exception;
        this.mClosedCompleter.setException(e);
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public ListenableFuture<Void> getClosedFuture() {
        return Futures.nonCancellationPropagating(this.mClosedFuture);
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public long getPresentationTimeUs() {
        return this.mBufferInfo.presentationTimeUs;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public boolean isKeyFrame() {
        if ((this.mBufferInfo.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public long size() {
        return this.mBufferInfo.size;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public ByteBuffer getByteBuffer() {
        throwIfClosed();
        this.mByteBuffer.position(this.mBufferInfo.offset);
        ByteBuffer r0 = this.mByteBuffer;
        MediaCodec.BufferInfo r1 = this.mBufferInfo;
        r0.limit(r1.offset + r1.size);
        return this.mByteBuffer;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public MediaCodec.BufferInfo getBufferInfo() {
        return this.mBufferInfo;
    }

    private static /* synthetic */ Object lambda$new$0(AtomicReference r0, CallbackToFutureAdapter.Completer r1) throws Exception {
        r0.set(r1);
        return "Data closed";
    }

    public EncodedDataImpl(MediaCodec r3, int r4, MediaCodec.BufferInfo r5) throws MediaCodec.CodecException {
        this.mClosed = new AtomicBoolean(false);
        this.mMediaCodec = (MediaCodec) Preconditions.checkNotNull(r3);
        this.mBufferIndex = r4;
        this.mByteBuffer = r3.getOutputBuffer(r4);
        this.mBufferInfo = (MediaCodec.BufferInfo) Preconditions.checkNotNull(r5);
        final AtomicReference r6 = new AtomicReference();
        this.mClosedFuture = CallbackToFutureAdapter.getFuture(new b(r6));
        this.mClosedCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r6.get());
    }
}
