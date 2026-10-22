package kqc;

import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
public abstract class h implements DataInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f505698a;

    @Override // java.io.DataInput
    public final boolean readBoolean() throws IOException {
        return this.f505698a.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        return (byte) this.f505698a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final char readChar() throws IOException {
        return (char) this.f505698a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final double readDouble() throws IOException {
        return this.f505698a.readDouble();
    }

    @Override // java.io.DataInput
    public final float readFloat() throws IOException {
        return this.f505698a.readFloat();
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        return this.f505698a.readInt();
    }

    @Override // java.io.DataInput
    public final String readLine() throws IOException {
        this.f505698a.readLine();
        throw null;
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        return this.f505698a.readLong();
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        return (short) this.f505698a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final String readUTF() throws IOException {
        return this.f505698a.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() throws IOException {
        return this.f505698a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        return this.f505698a.readUnsignedShort();
    }

    public h(k r100) {
        this.f505698a = r100;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] r100) throws IOException {
        k r101 = this.f505698a;
        r101.getClass();
        f.a(r101, r100, 0, r100.length);
    }

    @Override // java.io.DataInput
    public int skipBytes(int r100) throws IOException {
        return this.f505698a.skipBytes(r100);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] r100, int r101, int r102) throws IOException {
        k r103 = this.f505698a;
        r103.getClass();
        f.a(r103, r100, r101, r102);
    }
}
