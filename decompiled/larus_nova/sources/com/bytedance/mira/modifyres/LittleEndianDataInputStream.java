package com.bytedance.mira.modifyres;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public final class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
    public static int fromBytes(byte r100, byte r101, byte r102, byte r103) {
        return (((r100 << 24) | ((r101 & UByte.MAX_VALUE) << 16)) | ((r102 & UByte.MAX_VALUE) << 8)) | (r103 & UByte.MAX_VALUE);
    }

    public static long fromBytes(byte r100, byte r101, byte r102, byte r103, byte r104, byte r110, byte r111, byte r112) {
        long r105 = (((long) r100) & 255) << 56;
        return ((((((((((long) r101) & 255) << 48) | r105) | ((((long) r102) & 255) << 40)) | ((((long) r103) & 255) << 32)) | ((((long) r104) & 255) << 24)) | ((((long) r110) & 255) << 16)) | ((((long) r111) & 255) << 8)) | (((long) r112) & 255);
    }

    private byte readAndCheckByte() throws IOException, EOFException {
        int r100 = ((FilterInputStream) this).in.read();
        if ((-1) == r100) goto L7;
        return (byte) r100;
    L7:
        throw new EOFException();
    }

    public CountingInputStream getInputStream() {
        return (CountingInputStream) ((FilterInputStream) this).in;
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
        return fromBytes(readAndCheckByte(), r106, r105, r104, r103, r102, r101, r100);
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

    public LittleEndianDataInputStream(CountingInputStream r100) {
        super(r100);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r100) throws IOException {
        ByteStreams.readFully(this, r100);
    }

    @Override // java.io.DataInput
    public int skipBytes(int r100) throws IOException {
        return (int) ((FilterInputStream) this).in.skip(r100);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r100, int r101, int r102) throws IOException {
        ByteStreams.readFully(this, r100, r101, r102);
    }
}
