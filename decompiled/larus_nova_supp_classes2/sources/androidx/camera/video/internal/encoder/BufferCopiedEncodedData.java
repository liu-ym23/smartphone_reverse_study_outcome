package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class BufferCopiedEncodedData implements EncodedData {
    private final MediaCodec.BufferInfo mBufferInfo;
    private final ByteBuffer mByteBuffer;
    private final CallbackToFutureAdapter.Completer<Void> mClosedCompleter;
    private final ListenableFuture<Void> mClosedFuture;

    public static /* synthetic */ Object a(AtomicReference r0, CallbackToFutureAdapter.Completer r1) {
        return lambda$new$0(r0, r1);
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData, java.lang.AutoCloseable
    public void close() {
        this.mClosedCompleter.set(null);
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
    public MediaCodec.BufferInfo getBufferInfo() {
        return this.mBufferInfo;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public ByteBuffer getByteBuffer() {
        return this.mByteBuffer;
    }

    public BufferCopiedEncodedData(EncodedData r2) {
        this.mBufferInfo = generateCopiedByteInfo(r2);
        this.mByteBuffer = generateCopiedByteBuffer(r2);
        final AtomicReference r3 = new AtomicReference();
        this.mClosedFuture = CallbackToFutureAdapter.getFuture(new a(r3));
        this.mClosedCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r3.get());
    }

    private ByteBuffer generateCopiedByteBuffer(EncodedData r4) {
        ByteBuffer r0 = r4.getByteBuffer();
        MediaCodec.BufferInfo r5 = r4.getBufferInfo();
        r0.position(r5.offset);
        r0.limit(r5.offset + r5.size);
        ByteBuffer r6 = ByteBuffer.allocate(r5.size);
        r6.order(r0.order());
        r6.put(r0);
        r6.flip();
        return r6;
    }

    private MediaCodec.BufferInfo generateCopiedByteInfo(EncodedData r8) {
        MediaCodec.BufferInfo r9 = r8.getBufferInfo();
        MediaCodec.BufferInfo r6 = new MediaCodec.BufferInfo();
        r6.set(0, r9.size, r9.presentationTimeUs, r9.flags);
        return r6;
    }

    private static /* synthetic */ Object lambda$new$0(AtomicReference r0, CallbackToFutureAdapter.Completer r1) throws Exception {
        r0.set(r1);
        return "Data closed";
    }
}
