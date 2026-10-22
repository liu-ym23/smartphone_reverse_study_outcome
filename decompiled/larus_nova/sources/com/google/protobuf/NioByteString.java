package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
final class NioByteString extends ByteString.LeafByteString {
    private final ByteBuffer buffer;

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        return Utf8.isValidUtf8(this.buffer);
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer, true);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    public NioByteString(ByteBuffer r100) {
        Internal.checkNotNull(r100, "buffer");
        this.buffer = r100.slice().order(ByteOrder.nativeOrder());
    }

    public static /* synthetic */ ByteBuffer access$000(NioByteString r100) {
        return r100.buffer;
    }

    private void readObject(ObjectInputStream r100) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int r100) {
        return this.buffer.get(r100);
    L7:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new ArrayIndexOutOfBoundsException(e.getMessage());
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer r100) {
        r100.put(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ByteString) == true) goto L8;
        return false;
    L8:
        ByteString r101 = (ByteString) r100;
        if (size() == r101.size()) goto L12;
        return false;
    L12:
        if (size() != 0) goto L15;
        return true;
    L15:
        if ((r100 instanceof NioByteString) == false) goto L19;
        return this.buffer.equals(((NioByteString) r100).buffer);
    L19:
        if ((r100 instanceof RopeByteString) == false) goto L23;
        return r100.equals(this);
    L23:
        return this.buffer.equals(r101.asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString
    public String toStringInternal(Charset r100) {
        if (this.buffer.hasArray() == false) goto L5;
        byte[] r101 = this.buffer.array();
        int r102 = this.buffer.arrayOffset() + this.buffer.position();
        int r103 = this.buffer.remaining();
    L7:
        return new String(r101, r102, r103, r100);
    L5:
        r101 = toByteArray();
        r103 = r101.length;
        r102 = 0;
        goto L7
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(ByteOutput r100) throws IOException {
        r100.writeLazy(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream r100) throws IOException {
        r100.write(toByteArray());
    }

    private ByteBuffer slice(int r100, int r101) {
        if (r100 < this.buffer.position()) goto L10;
        if (r101 > this.buffer.limit()) goto L10;
        if (r100 > r101) goto L10;
        ByteBuffer r102 = this.buffer.slice();
        r102.position(r100 - this.buffer.position());
        r102.limit(r101 - this.buffer.position());
        return r102;
    L10:
        throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)}));
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int r100, int r101) {
        return new NioByteString(slice(r100, r101));
    L7:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new ArrayIndexOutOfBoundsException(e.getMessage());
    }

    @Override // com.google.protobuf.ByteString.LeafByteString
    public boolean equalsRange(ByteString r100, int r101, int r102) {
        return substring(0, r102).equals(r100.substring(r101, r102 + r101));
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int r100, int r101, int r102) {
        int r103 = r101;
    L4:
        if (r103 >= (r101 + r102)) goto L6;
        r100 = (r100 * 31) + this.buffer.get(r103);
        r103 = r103 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int r100, int r101, int r102) {
        return Utf8.partialIsValidUtf8(r100, this.buffer, r101, r102 + r101);
    }

    @Override // com.google.protobuf.ByteString
    public void writeToInternal(OutputStream r100, int r101, int r102) throws IOException {
        if (this.buffer.hasArray() == false) goto L6;
        int r103 = (this.buffer.arrayOffset() + this.buffer.position()) + r101;
        r100.write(this.buffer.array(), r103, r102);
        return;
    L6:
        ByteBufferWriter.write(slice(r101, r102 + r101), r100);
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] r100, int r101, int r102, int r103) {
        ByteBuffer r104 = this.buffer.slice();
        r104.position(r101);
        r104.get(r100, r102, r103);
    }
}
