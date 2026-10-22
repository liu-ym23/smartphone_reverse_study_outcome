package androidx.camera.core.impl.utils;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ByteOrderedDataInputStream extends InputStream implements DataInput {
    private static final ByteOrder BIG_ENDIAN = null;
    private static final ByteOrder LITTLE_ENDIAN = null;
    private ByteOrder mByteOrder;
    private final DataInputStream mDataInputStream;
    final int mLength;
    int mPosition;

    static {
        LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.mDataInputStream.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.mPosition++;
        return this.mDataInputStream.read();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        this.mPosition++;
        return this.mDataInputStream.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        int r0 = this.mPosition + 1;
        this.mPosition = r0;
        if (r0 > this.mLength) goto L11;
        int r1 = this.mDataInputStream.read();
        if (r1 < 0) goto L9;
        return (byte) r1;
    L9:
        throw new EOFException();
    L11:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        this.mPosition += 2;
        return this.mDataInputStream.readChar();
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        int r0 = this.mPosition + 4;
        this.mPosition = r0;
        if (r0 > this.mLength) goto L19;
        int r1 = this.mDataInputStream.read();
        int r2 = this.mDataInputStream.read();
        int r3 = this.mDataInputStream.read();
        int r4 = this.mDataInputStream.read();
        if ((((r1 | r2) | r3) | r4) < 0) goto L17;
        ByteOrder r5 = this.mByteOrder;
        if (r5 != LITTLE_ENDIAN) goto L11;
        return (((r4 << 24) + (r3 << 16)) + (r2 << 8)) + r1;
    L11:
        if (r5 != BIG_ENDIAN) goto L15;
        return (((r1 << 24) + (r2 << 16)) + (r3 << 8)) + r4;
    L15:
        throw new IOException("Invalid byte order: " + this.mByteOrder);
    L17:
        throw new EOFException();
    L19:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine() not implemented.");
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        int r1 = this.mPosition + 8;
        this.mPosition = r1;
        if (r1 > this.mLength) goto L19;
        int r2 = this.mDataInputStream.read();
        int r3 = this.mDataInputStream.read();
        int r4 = this.mDataInputStream.read();
        int r5 = this.mDataInputStream.read();
        int r6 = this.mDataInputStream.read();
        int r7 = this.mDataInputStream.read();
        int r8 = this.mDataInputStream.read();
        int r9 = this.mDataInputStream.read();
        if ((((((((r2 | r3) | r4) | r5) | r6) | r7) | r8) | r9) < 0) goto L17;
        ByteOrder r10 = this.mByteOrder;
        if (r10 != LITTLE_ENDIAN) goto L11;
        return (((((((((long) r9) << 56) + (((long) r8) << 48)) + (((long) r7) << 40)) + (((long) r6) << 32)) + (((long) r5) << 24)) + (((long) r4) << 16)) + (((long) r3) << 8)) + ((long) r2);
    L11:
        if (r10 != BIG_ENDIAN) goto L15;
        return (((((((((long) r2) << 56) + (((long) r3) << 48)) + (((long) r4) << 40)) + (((long) r5) << 32)) + (((long) r6) << 24)) + (((long) r7) << 16)) + (((long) r8) << 8)) + ((long) r9);
    L15:
        throw new IOException("Invalid byte order: " + this.mByteOrder);
    L17:
        throw new EOFException();
    L19:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        int r0 = this.mPosition + 2;
        this.mPosition = r0;
        if (r0 > this.mLength) goto L19;
        int r1 = this.mDataInputStream.read();
        int r2 = this.mDataInputStream.read();
        if ((r1 | r2) < 0) goto L17;
        ByteOrder r3 = this.mByteOrder;
        if (r3 != LITTLE_ENDIAN) goto L11;
        return (short) ((r2 << 8) + r1);
    L11:
        if (r3 != BIG_ENDIAN) goto L15;
        return (short) ((r1 << 8) + r2);
    L15:
        throw new IOException("Invalid byte order: " + this.mByteOrder);
    L17:
        throw new EOFException();
    L19:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        this.mPosition += 2;
        return this.mDataInputStream.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        this.mPosition++;
        return this.mDataInputStream.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        int r0 = this.mPosition + 2;
        this.mPosition = r0;
        if (r0 > this.mLength) goto L19;
        int r1 = this.mDataInputStream.read();
        int r2 = this.mDataInputStream.read();
        if ((r1 | r2) < 0) goto L17;
        ByteOrder r3 = this.mByteOrder;
        if (r3 != LITTLE_ENDIAN) goto L11;
        return (r2 << 8) + r1;
    L11:
        if (r3 != BIG_ENDIAN) goto L15;
        return (r1 << 8) + r2;
    L15:
        throw new IOException("Invalid byte order: " + this.mByteOrder);
    L17:
        throw new EOFException();
    L19:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public long readUnsignedInt() throws IOException {
        return ((long) readInt()) & 4294967295L;
    }

    public int getLength() {
        return this.mLength;
    }

    public int peek() {
        return this.mPosition;
    }

    public ByteOrderedDataInputStream(byte[] r2) throws IOException {
        this(new ByteArrayInputStream(r2));
    }

    @Override // java.io.InputStream
    public void mark(int r3) {
        DataInputStream r0 = this.mDataInputStream;
        monitor-enter(r0);
        this.mDataInputStream.mark(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r4) throws IOException {
        int r0 = this.mPosition + r4.length;
        this.mPosition = r0;
        if (r0 > this.mLength) goto L10;
        if (this.mDataInputStream.read(r4, 0, r4.length) != r4.length) goto L8;
        return;
    L8:
        throw new IOException("Couldn't read up to the length of buffer");
    L10:
        throw new EOFException();
    }

    public void seek(long r5) throws IOException {
        int r0 = this.mPosition;
        if (r0 <= r5) goto L5;
        this.mPosition = 0;
        this.mDataInputStream.reset();
        this.mDataInputStream.mark(this.mLength);
    L6:
        int r6 = (int) r5;
        if (skipBytes(r6) != r6) goto L10;
        return;
    L10:
        throw new IOException("Couldn't seek up to the byteCount");
    L5:
        r5 = r5 - ((long) r0);
        goto L6
    }

    public void setByteOrder(ByteOrder r1) {
        this.mByteOrder = r1;
    }

    @Override // java.io.DataInput
    public int skipBytes(int r4) throws IOException {
        int r5 = Math.min(r4, this.mLength - this.mPosition);
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        r0 = r0 + this.mDataInputStream.skipBytes(r5 - r0);
        goto L3
    L5:
        this.mPosition += r0;
        return r0;
    }

    public ByteOrderedDataInputStream(InputStream r2) throws IOException {
        this(r2, ByteOrder.BIG_ENDIAN);
    }

    public ByteOrderedDataInputStream(InputStream r3, ByteOrder r4) throws IOException {
        this.mByteOrder = ByteOrder.BIG_ENDIAN;
        DataInputStream r0 = new DataInputStream(r3);
        this.mDataInputStream = r0;
        int r5 = r0.available();
        this.mLength = r5;
        this.mPosition = 0;
        r0.mark(r5);
        this.mByteOrder = r4;
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) throws IOException {
        int r5 = this.mDataInputStream.read(r2, r3, r4);
        this.mPosition += r5;
        return r5;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r3, int r4, int r5) throws IOException {
        int r0 = this.mPosition + r5;
        this.mPosition = r0;
        if (r0 > this.mLength) goto L10;
        if (this.mDataInputStream.read(r3, r4, r5) != r5) goto L8;
        return;
    L8:
        throw new IOException("Couldn't read up to the length of buffer");
    L10:
        throw new EOFException();
    }
}
