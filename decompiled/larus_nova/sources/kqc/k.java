package kqc;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes41.dex */
public final class k extends FilterInputStream implements DataInput {
    public final g a() {
        return (g) ((FilterInputStream) this).in;
    }

    public final byte b() throws IOException, EOFException {
        int r100 = ((FilterInputStream) this).in.read();
        if ((-1) == r100) goto L7;
        return (byte) r100;
    L7:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public final String readUTF() throws IOException {
        return new DataInputStream(((FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() throws IOException {
        int r100 = ((FilterInputStream) this).in.read();
        if (r100 < 0) goto L6;
        return r100;
    L6:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() throws IOException {
        if (readUnsignedByte() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final char readChar() throws IOException {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        byte r100 = b();
        byte r101 = b();
        byte r102 = b();
        int r103 = b() << 24;
        int r104 = ((r102 & UByte.MAX_VALUE) << 16) | r103;
        int r105 = ((r101 & UByte.MAX_VALUE) << 8) | r104;
        return (r100 & UByte.MAX_VALUE) | r105;
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        byte r100 = b();
        byte r101 = b();
        byte r102 = b();
        byte r103 = b();
        byte r104 = b();
        byte r105 = b();
        byte r106 = b();
        long r110 = (((long) r106) & 255) << 48;
        return ((((((r110 | ((((long) b()) & 255) << 56)) | ((((long) r105) & 255) << 40)) | ((((long) r104) & 255) << 32)) | ((((long) r103) & 255) << 24)) | ((((long) r102) & 255) << 16)) | ((((long) r101) & 255) << 8)) | (((long) r100) & 255);
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        byte r100 = b();
        int r101 = ((b() & UByte.MAX_VALUE) << 8) | 0;
        return (r100 & UByte.MAX_VALUE) | r101;
    }

    public k(g r100) {
        super(r100);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] r100) throws IOException {
        f.a(this, r100, 0, r100.length);
    }

    @Override // java.io.DataInput
    public final int skipBytes(int r100) throws IOException {
        return (int) ((FilterInputStream) this).in.skip(r100);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] r100, int r101, int r102) throws IOException {
        f.a(this, r100, r101, r102);
    }
}
