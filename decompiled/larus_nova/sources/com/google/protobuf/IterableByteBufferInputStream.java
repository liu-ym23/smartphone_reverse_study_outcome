package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
class IterableByteBufferInputStream extends InputStream {
    private long currentAddress;
    private byte[] currentArray;
    private int currentArrayOffset;
    private ByteBuffer currentByteBuffer;
    private int currentByteBufferPos;
    private int currentIndex;
    private int dataSize;
    private boolean hasArray;
    private Iterator<ByteBuffer> iterator;

    private boolean getNextByteBuffer() {
        this.currentIndex++;
        if (this.iterator.hasNext() == true) goto L5;
        return false;
    L5:
        ByteBuffer r100 = this.iterator.next();
        this.currentByteBuffer = r100;
        this.currentByteBufferPos = r100.position();
        if (this.currentByteBuffer.hasArray() == false) goto L8;
        this.hasArray = true;
        this.currentArray = this.currentByteBuffer.array();
        this.currentArrayOffset = this.currentByteBuffer.arrayOffset();
    L9:
        return true;
    L8:
        this.hasArray = false;
        this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
        this.currentArray = null;
        goto L9
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.currentIndex != this.dataSize) goto L7;
        return -1;
    L7:
        if (this.hasArray == false) goto L10;
        int r100 = this.currentArray[this.currentByteBufferPos + this.currentArrayOffset] & UByte.MAX_VALUE;
        updateCurrentByteBufferPos(1);
        return r100;
    L10:
        int r101 = UnsafeUtil.getByte(((long) this.currentByteBufferPos) + this.currentAddress) & UByte.MAX_VALUE;
        updateCurrentByteBufferPos(1);
        return r101;
    }

    public IterableByteBufferInputStream(Iterable<ByteBuffer> r100) {
        this.iterator = r100.iterator();
        this.dataSize = 0;
        Iterator<ByteBuffer> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ByteBuffer r102 = r101.next();
        this.dataSize++;
        goto L4
    L6:
        this.currentIndex = -1;
        if (getNextByteBuffer() == true) goto L11;
        this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
        this.currentIndex = 0;
        this.currentByteBufferPos = 0;
        this.currentAddress = 0;
        return;
    }

    private void updateCurrentByteBufferPos(int r100) {
        int r101 = this.currentByteBufferPos + r100;
        this.currentByteBufferPos = r101;
        if (r101 != this.currentByteBuffer.limit()) goto L6;
        getNextByteBuffer();
        return;
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        if (this.currentIndex != this.dataSize) goto L6;
        return -1;
    L6:
        int r103 = this.currentByteBuffer.limit();
        int r104 = this.currentByteBufferPos;
        int r105 = r103 - r104;
        if (r102 <= r105) goto L10;
        r102 = r105;
    L10:
        if (this.hasArray == false) goto L12;
        System.arraycopy(this.currentArray, r104 + this.currentArrayOffset, r100, r101, r102);
        updateCurrentByteBufferPos(r102);
    L13:
        return r102;
    L12:
        int r106 = this.currentByteBuffer.position();
        this.currentByteBuffer.position(this.currentByteBufferPos);
        this.currentByteBuffer.get(r100, r101, r102);
        this.currentByteBuffer.position(r106);
        updateCurrentByteBufferPos(r102);
        goto L13
    }
}
