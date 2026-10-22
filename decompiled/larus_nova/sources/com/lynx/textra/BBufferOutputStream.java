package com.lynx.textra;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes32.dex */
public class BBufferOutputStream {
    private final ByteBuffer byteBuffer;

    public byte[] getByteArray() {
        return this.byteBuffer.array();
    }

    public BBufferOutputStream(int r100) {
        ByteBuffer r101 = ByteBuffer.allocate(r100);
        this.byteBuffer = r101;
        r101.order(ByteOrder.LITTLE_ENDIAN);
    }

    public BBufferOutputStream writeByte(byte r100) {
        this.byteBuffer.put(r100);
        return this;
    }

    public BBufferOutputStream writeFloat(float r100) {
        this.byteBuffer.putFloat(r100);
        return this;
    }

    public BBufferOutputStream writeInt(int r100) {
        this.byteBuffer.putInt(r100);
        return this;
    }

    public BBufferOutputStream writeLong(long r100) {
        this.byteBuffer.putLong(r100);
        return this;
    }

    public BBufferOutputStream writeShort(short r100) {
        this.byteBuffer.putShort(r100);
        return this;
    }
}
