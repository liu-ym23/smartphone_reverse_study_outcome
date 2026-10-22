package com.lynx.textra;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import kotlin.UByte;

/* JADX INFO: loaded from: classes32.dex */
public class BBufferInputStream {
    private final byte[] buffer;
    private final ByteBuffer byteBuffer;

    public char ReadChar() {
        return this.byteBuffer.getChar();
    }

    public int ReadVarInt32() throws IOException {
        int r100 = this.byteBuffer.get() & UByte.MAX_VALUE;
        int r101 = r100 & 127;
        int r102 = 7;
    L4:
        if (r100 <= 127) goto L6;
        r100 = this.byteBuffer.get() & UByte.MAX_VALUE;
        r101 = r101 | ((r100 & 127) << r102);
        r102 = r102 + 7;
        goto L4
    L6:
        return r101;
    }

    public int available() {
        return this.byteBuffer.limit() - this.byteBuffer.position();
    }

    public byte readByte() {
        return this.byteBuffer.get();
    }

    public float readFloat() {
        return this.byteBuffer.getFloat();
    }

    public int readInt() {
        return this.byteBuffer.getInt();
    }

    public long readLong() {
        return this.byteBuffer.getLong();
    }

    public short readShort() {
        return this.byteBuffer.getShort();
    }

    public String ReadCString() throws IOException {
        int r100 = readInt();
        if (r100 != 0) goto L6;
        return "";
    L6:
        int r101 = this.byteBuffer.position();
        this.byteBuffer.position(r101 + r100);
        return new String(this.buffer, r101, r100, Charset.defaultCharset());
    }

    public BBufferInputStream(byte[] r100) {
        ByteBuffer r101 = ByteBuffer.wrap(r100);
        this.byteBuffer = r101;
        r101.order(ByteOrder.LITTLE_ENDIAN);
        this.buffer = r100;
    }

    public void read(byte[] r100, int r101, int r102) {
        this.byteBuffer.get(r100, r101, r102);
    }
}
