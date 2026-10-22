package androidx.camera.core.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ByteBufferOutputStream extends OutputStream {
    private final ByteBuffer mByteBuffer;

    public ByteBufferOutputStream(ByteBuffer r1) {
        this.mByteBuffer = r1;
    }

    @Override // java.io.OutputStream
    public void write(int r2) throws IOException {
        if (this.mByteBuffer.hasRemaining() == false) goto L7;
        this.mByteBuffer.put((byte) r2);
        return;
    L7:
        throw new EOFException("Output ByteBuffer has no bytes remaining.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3, int r4, int r5) throws IOException {
        if (r3 == null) goto L21;
        if (r4 < 0) goto L19;
        if (r4 > r3.length) goto L19;
        if (r5 < 0) goto L19;
        int r0 = r4 + r5;
        if (r0 > r3.length) goto L19;
        if (r0 < 0) goto L19;
        if (r5 != 0) goto L13;
        return;
    L13:
        if (this.mByteBuffer.remaining() < r5) goto L17;
        this.mByteBuffer.put(r3, r4, r5);
        return;
    L17:
        throw new EOFException("Output ByteBuffer has insufficient bytes remaining.");
    L19:
        throw new IndexOutOfBoundsException();
    L21:
        throw null;
    }
}
