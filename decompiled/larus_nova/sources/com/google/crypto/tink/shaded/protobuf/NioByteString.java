package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
final class NioByteString extends ByteString.LeafByteString {
    private final ByteBuffer buffer;

    public class a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f275829a;

        @Override // java.io.InputStream
        public final boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public final int available() throws IOException {
            return this.f275829a.remaining();
        }

        @Override // java.io.InputStream
        public final int read() throws IOException {
            if (this.f275829a.hasRemaining() == true) goto L7;
            return -1;
        L7:
            return this.f275829a.get() & UByte.MAX_VALUE;
        }

        @Override // java.io.InputStream
        public final void reset() throws IOException {
            this.f275829a.reset();     // Catch: InvalidMarkException -> L4
            return;
        L4:
            e = move-exception;
            throw new IOException(e);
        }

        public a(NioByteString r100) {
            this.f275829a = NioByteString.access$000(r100).slice();
        }

        @Override // java.io.InputStream
        public final void mark(int r100) {
            this.f275829a.mark();
        }

        @Override // java.io.InputStream
        public final int read(byte[] r100, int r101, int r102) throws IOException {
            if (this.f275829a.hasRemaining() == true) goto L6;
            return -1;
        L6:
            int r103 = Math.min(r102, this.f275829a.remaining());
            this.f275829a.get(r100, r101, r103);
            return r103;
        }
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean isValidUtf8() {
        ByteBuffer r100 = this.buffer;
        if (Utf8.f275849a.d(0, r100, r100.position(), r100.remaining()) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public d newCodedInput() {
        ByteBuffer r100 = this.buffer;
        if (r100.hasArray() == false) goto L6;
        return d.a(r100.array(), r100.arrayOffset() + r100.position(), r100.remaining(), true);
    L6:
        if (r100.isDirect() == true) goto L8;
    L10:
        int r101 = r100.remaining();
        byte[] r102 = new byte[r101];
        r100.duplicate().get(r102);
        return d.a(r102, 0, r101, true);
    L8:
        if (i.f275899c == false) goto L10;
        return new d.C3862d(r100);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public InputStream newInput() {
        return new a(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    public NioByteString(ByteBuffer r100) {
        Charset r101 = e.f275885a;
        if (r100 == null) goto L7;
        this.buffer = r100.slice().order(ByteOrder.nativeOrder());
        return;
    L7:
        throw new NullPointerException("buffer");
    }

    public static /* synthetic */ ByteBuffer access$000(NioByteString r100) {
        return r100.buffer;
    }

    private void readObject(ObjectInputStream r100) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte byteAt(int r100) {
        return this.buffer.get(r100);
    L7:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new ArrayIndexOutOfBoundsException(e.getMessage());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void copyTo(ByteBuffer r100) {
        r100.put(this.buffer.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
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

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte internalByteAt(int r100) {
        return byteAt(r100);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
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

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void writeTo(c r100) throws IOException {
        r100.a(this.buffer.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void writeTo(OutputStream r100) throws IOException {
        r100.write(toByteArray());
    }

    public final ByteBuffer d(int r100, int r101) {
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

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteString substring(int r100, int r101) {
        return new NioByteString(d(r100, r101));
    L7:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new ArrayIndexOutOfBoundsException(e.getMessage());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LeafByteString
    public boolean equalsRange(ByteString r100, int r101, int r102) {
        return substring(0, r102).equals(r100.substring(r101, r102 + r101));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
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

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public int partialIsValidUtf8(int r100, int r101, int r102) {
        Utf8.b r103 = Utf8.f275849a;
        return r103.d(r100, this.buffer, r101, r102 + r101);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void writeToInternal(OutputStream r100, int r110, int r111) throws IOException {
        if (this.buffer.hasArray() == false) goto L6;
        r100.write(this.buffer.array(), (this.buffer.arrayOffset() + this.buffer.position()) + r110, r111);
        return;
    L6:
        ByteBuffer r112 = d(r110, r111 + r110);
        ThreadLocal<SoftReference<byte[]>> r113 = b.f275857a;
        int r114 = r112.position();
    L42:
        th = move-exception;
        r112.position(r114);
        throw th;
    L8:
        if (r112.hasArray() == false) goto L10;
        r100.write(r112.array(), r112.arrayOffset() + r112.position(), r112.remaining());     // Catch: Throwable -> L42
    L40:
        r112.position(r114);
        return;
    L10:
        long r101 = b.f275859c;     // Catch: Throwable -> L42
        boolean r102 = true;
        byte[] r103 = null;
        if (r101 >= 0) goto L13;
    L19:
        boolean r104 = false;
    L20:
        if (r104 == true) goto L40;
        int r105 = Math.max(r112.remaining(), 1024);     // Catch: Throwable -> L42
        ThreadLocal<SoftReference<byte[]>> r106 = b.f275857a;     // Catch: Throwable -> L42
        SoftReference<byte[]> r107 = r106.get();     // Catch: Throwable -> L42
        if (r107 == null) goto L25;
        r103 = r107.get();     // Catch: Throwable -> L42
    L25:
        if (r103 == null) goto L33;
        int r108 = r103.length;     // Catch: Throwable -> L42
        if (r108 < r105) goto L29;
    L31:
        r102 = false;
    L32:
        if (r102 == true) goto L33;
    L37:
        if (r112.hasRemaining() == false) goto L40;
        int r109 = Math.min(r112.remaining(), r103.length);     // Catch: Throwable -> L42
        r112.get(r103, 0, r109);     // Catch: Throwable -> L42
        r100.write(r103, 0, r109);     // Catch: Throwable -> L42
        goto L37
    L29:
        if (r108 >= (r105 * 0.5f)) goto L31;
    L33:
        r103 = new byte[r105];     // Catch: Throwable -> L42
        if (r105 > 16384) goto L37;
        r106.set(new SoftReference(r103));     // Catch: Throwable -> L42
        goto L37
    L13:
        if (b.f275858b.isInstance(r100) == false) goto L19;
        WritableByteChannel r115 = (WritableByteChannel) i.f275898b.i(r100, r101);     // Catch: ClassCastException -> L16 Throwable -> L42
    L17:
        if (r115 == null) goto L19;
        r115.write(r112);     // Catch: Throwable -> L42
        r104 = true;
    L16:
        r115 = null;
        goto L17
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void copyToInternal(byte[] r100, int r101, int r102, int r103) {
        ByteBuffer r104 = this.buffer.slice();
        r104.position(r101);
        r104.get(r100, r102, r103);
    }
}
