package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes38.dex */
public final class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
    private int fromBytes(byte r100, byte r101, byte r102, byte r103) {
        return (((r100 << 24) | ((r101 & UByte.MAX_VALUE) << 16)) | ((r102 & UByte.MAX_VALUE) << 8)) | (r103 & UByte.MAX_VALUE);
    }

    private byte readAndCheckByte() throws IOException, EOFException {
        int r100 = ((FilterInputStream) this).in.read();
        if ((-1) == r100) goto L7;
        return (byte) r100;
    L7:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return new DataInputStream(((FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        int r100 = ((FilterInputStream) this).in.read();
        if (r100 < 0) goto L6;
        return r100;
    L6:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        if (readUnsignedByte() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        byte r100 = readAndCheckByte();
        byte r101 = readAndCheckByte();
        byte r102 = readAndCheckByte();
        return fromBytes(readAndCheckByte(), r102, r101, r100);
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        byte r100 = readAndCheckByte();
        byte r101 = readAndCheckByte();
        byte r102 = readAndCheckByte();
        byte r103 = readAndCheckByte();
        byte r104 = readAndCheckByte();
        byte r105 = readAndCheckByte();
        byte r106 = readAndCheckByte();
        long r107 = (((long) r100) & 255) << 56;
        return ((((((((((long) r101) & 255) << 48) | r107) | ((((long) r102) & 255) << 40)) | ((((long) r103) & 255) << 32)) | ((((long) r104) & 255) << 24)) | ((((long) r105) & 255) << 16)) | ((((long) r106) & 255) << 8)) | (((long) readAndCheckByte()) & 255);
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        byte r100 = readAndCheckByte();
        return fromBytes((byte) 0, (byte) 0, readAndCheckByte(), r100);
    }

    public LittleEndianDataInputStream(InputStream r100) {
        super(r100);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r100) throws IOException {
        readFully(this, r100, 0, r100.length);
    }

    @Override // java.io.DataInput
    public int skipBytes(int r100) throws IOException {
        return (int) ((FilterInputStream) this).in.skip(r100);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r100, int r101, int r102) throws IOException {
        readFully(this, r100, r101, r102);
    }

    private int read(InputStream r100, byte[] r101, int r102, int r103) throws IOException {
        int r104 = 0;
        if (r103 < 0) goto L11;
    L4:
        if (r104 >= r103) goto L9;
        int r105 = r100.read(r101, r102 + r104, r103 - r104);
        if (r105 == (-1)) goto L9;
        r104 = r104 + r105;
    L9:
        return r104;
    L11:
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", new Object[]{Integer.valueOf(r103)}));
    }

    private void readFully(InputStream r100, byte[] r101, int r102, int r103) throws IOException {
        int r104 = read(r100, r101, r102, r103);
        if (r104 != r103) goto L6;
        return;
    L6:
        throw new EOFException("reached end of stream after reading " + r104 + " bytes; " + r103 + " bytes expected");
    }
}
