package androidx.camera.core.impl.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ByteOrderedDataOutputStream extends FilterOutputStream {
    private ByteOrder mByteOrder;
    final OutputStream mOutputStream;

    public void setByteOrder(ByteOrder r1) {
        this.mByteOrder = r1;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r2) throws IOException {
        this.mOutputStream.write(r2);
    }

    public void writeByte(int r2) throws IOException {
        this.mOutputStream.write(r2);
    }

    public void writeInt(int r3) throws IOException {
        ByteOrder r0 = this.mByteOrder;
        if (r0 != ByteOrder.LITTLE_ENDIAN) goto L6;
        this.mOutputStream.write((r3 >>> 0) & 255);
        this.mOutputStream.write((r3 >>> 8) & 255);
        this.mOutputStream.write((r3 >>> 16) & 255);
        this.mOutputStream.write((r3 >>> 24) & 255);
        return;
    L6:
        if (r0 != ByteOrder.BIG_ENDIAN) goto L10;
        this.mOutputStream.write((r3 >>> 24) & 255);
        this.mOutputStream.write((r3 >>> 16) & 255);
        this.mOutputStream.write((r3 >>> 8) & 255);
        this.mOutputStream.write((r3 >>> 0) & 255);
        return;
    }

    public void writeShort(short r3) throws IOException {
        ByteOrder r0 = this.mByteOrder;
        if (r0 != ByteOrder.LITTLE_ENDIAN) goto L6;
        this.mOutputStream.write((r3 >>> 0) & 255);
        this.mOutputStream.write((r3 >>> 8) & 255);
        return;
    L6:
        if (r0 != ByteOrder.BIG_ENDIAN) goto L10;
        this.mOutputStream.write((r3 >>> 8) & 255);
        this.mOutputStream.write((r3 >>> 0) & 255);
        return;
    }

    public void writeUnsignedInt(long r1) throws IOException {
        writeInt((int) r1);
    }

    public void writeUnsignedShort(int r1) throws IOException {
        writeShort((short) r1);
    }

    public ByteOrderedDataOutputStream(OutputStream r1, ByteOrder r2) {
        super(r1);
        this.mOutputStream = r1;
        this.mByteOrder = r2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r2, int r3, int r4) throws IOException {
        this.mOutputStream.write(r2, r3, r4);
    }
}
