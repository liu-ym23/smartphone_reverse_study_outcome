package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public abstract class DataInputDelegate implements DataInput {
    protected final DataInput mDelegate;

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return this.mDelegate.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return this.mDelegate.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return this.mDelegate.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return this.mDelegate.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return this.mDelegate.readFloat();
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        return this.mDelegate.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        return this.mDelegate.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        return this.mDelegate.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return this.mDelegate.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return this.mDelegate.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return this.mDelegate.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return this.mDelegate.readUnsignedShort();
    }

    public DataInputDelegate(DataInput r100) {
        this.mDelegate = r100;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r100) throws IOException {
        this.mDelegate.readFully(r100);
    }

    @Override // java.io.DataInput
    public int skipBytes(int r100) throws IOException {
        return this.mDelegate.skipBytes(r100);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r100, int r101, int r102) throws IOException {
        this.mDelegate.readFully(r100, r101, r102);
    }
}
