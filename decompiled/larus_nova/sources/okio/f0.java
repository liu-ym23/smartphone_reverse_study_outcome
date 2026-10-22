package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.byted.cast.common.Constants;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class f0 implements BufferedSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Source f524009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Buffer f524010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f524011c;

    /* JADX INFO: loaded from: classes42.dex */
    public static final class a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f524012a;

        @Override // java.io.InputStream
        public final int available() {
            f0 r100 = this.f524012a;
            if (r100.f524011c == true) goto L7;
            return (int) Math.min(r100.f524010b.size(), Integer.MAX_VALUE);
        L7:
            throw new IOException(PTYSocketStateCallback.CLOSED);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f524012a.close();
        }

        @Override // java.io.InputStream
        public final int read() {
            f0 r100 = this.f524012a;
            if (r100.f524011c == true) goto L13;
            if (r100.f524010b.size() != 0) goto L11;
            f0 r101 = this.f524012a;
            if (r101.f524009a.read(r101.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L11;
            return -1;
        L11:
            return this.f524012a.f524010b.readByte() & UByte.MAX_VALUE;
        L13:
            throw new IOException(PTYSocketStateCallback.CLOSED);
        }

        public final String toString() {
            return this.f524012a + ".inputStream()";
        }

        public a(f0 r100) {
            this.f524012a = r100;
        }

        @Override // java.io.InputStream
        public final int read(byte[] r100, int r101, int r110) {
            Intrinsics.checkNotNullParameter(r100, "data");
            if (this.f524012a.f524011c == true) goto L13;
            b.b(r100.length, r101, r110);
            if (this.f524012a.f524010b.size() != 0) goto L11;
            f0 r102 = this.f524012a;
            if (r102.f524009a.read(r102.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L11;
            return -1;
        L11:
            return this.f524012a.f524010b.read(r100, r101, r110);
        L13:
            throw new IOException(PTYSocketStateCallback.CLOSED);
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f524011c == true) goto L6;
        this.f524011c = true;
        this.f524009a.close();
        this.f524010b.clear();
        return;
    }

    @Override // okio.BufferedSource
    public final boolean exhausted() {
        if ((!this.f524011c) == false) goto L12;
        if (this.f524010b.exhausted() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.f524009a.read(this.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L9;
        return true;
    L12:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSource
    public final InputStream inputStream() {
        return new a(this);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f524011c;
    }

    @Override // okio.BufferedSource
    public final BufferedSource peek() {
        return Okio.buffer(new c0(this));
    }

    @Override // okio.BufferedSource
    public final byte readByte() {
        require(1);
        return this.f524010b.readByte();
    }

    @Override // okio.BufferedSource
    public final byte[] readByteArray() {
        this.f524010b.writeAll(this.f524009a);
        return this.f524010b.readByteArray();
    }

    @Override // okio.BufferedSource
    public final ByteString readByteString() {
        this.f524010b.writeAll(this.f524009a);
        return this.f524010b.readByteString();
    }

    @Override // okio.BufferedSource
    public final long readDecimalLong() {
        require(1);
        long r100 = 0;
    L3:
        long r101 = r100 + 1;
        if (request(r101) == false) goto L20;
        byte r102 = this.f524010b.getByte(r100);
        if (r102 < 48) goto L10;
        if (r102 > 57) goto L10;
    L14:
        r100 = r101;
    L10:
        if (r100 != 0) goto L15;
        if (r102 == 45) goto L14;
    L15:
        if (r100 != 0) goto L20;
        throw new NumberFormatException("Expected a digit or '-' but was 0x" + Integer.toString(r102, CharsKt.checkRadix(16)));
    L20:
        return this.f524010b.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public final long readHexadecimalUnsignedLong() {
        require(1);
        int r100 = 0;
    L3:
        int r101 = r100 + 1;
        if (request(r101) == false) goto L24;
        byte r102 = this.f524010b.getByte(r100);
        if (r102 < 48) goto L10;
        if (r102 > 57) goto L10;
    L18:
        r100 = r101;
    L10:
        if (r102 < 97) goto L14;
        if (r102 <= 102) goto L18;
    L14:
        if (r102 < 65) goto L19;
        if (r102 <= 70) goto L18;
    L19:
        if (r100 != 0) goto L24;
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toString(r102, CharsKt.checkRadix(16)));
    L24:
        return this.f524010b.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public final int readInt() {
        require(4);
        return this.f524010b.readInt();
    }

    @Override // okio.BufferedSource
    public final int readIntLe() {
        require(4);
        return this.f524010b.readIntLe();
    }

    @Override // okio.BufferedSource
    public final long readLong() {
        require(8);
        return this.f524010b.readLong();
    }

    @Override // okio.BufferedSource
    public final long readLongLe() {
        require(8);
        return this.f524010b.readLongLe();
    }

    @Override // okio.BufferedSource
    public final short readShort() {
        require(2);
        return this.f524010b.readShort();
    }

    @Override // okio.BufferedSource
    public final short readShortLe() {
        require(2);
        return this.f524010b.readShortLe();
    }

    @Override // okio.BufferedSource
    public final String readUtf8() {
        this.f524010b.writeAll(this.f524009a);
        return this.f524010b.readUtf8();
    }

    @Override // okio.BufferedSource
    public final int readUtf8CodePoint() {
        require(1);
        byte r100 = this.f524010b.getByte(0);
        if ((r100 & 224) != 192) goto L6;
        require(2);
    L12:
        return this.f524010b.readUtf8CodePoint();
    L6:
        if ((r100 & 240) != 224) goto L9;
        require(3);
        goto L12
    L9:
        if ((r100 & 248) != 240) goto L12;
        require(4);
        goto L12
    }

    @Override // okio.BufferedSource
    public final String readUtf8Line() {
        long r100 = indexOf((byte) 10);
        if (r100 != (-1)) goto L9;
        if (this.f524010b.size() != 0) goto L10;
        return null;
    L10:
        return readUtf8(this.f524010b.size());
    L9:
        return okio.internal.a.b(this.f524010b, r100);
    }

    @Override // okio.Source
    public final j0 timeout() {
        return this.f524009a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f524009a + ')';
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public final Buffer buffer() {
        return this.f524010b;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public final Buffer getBuffer() {
        return this.f524010b;
    }

    public f0(Source r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f524009a = r100;
        this.f524010b = new Buffer();
    }

    @Override // okio.BufferedSource
    public final long indexOf(byte r100) {
        return indexOf(r100, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public final long indexOfElement(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "targetBytes");
        return indexOfElement(r100, 0);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        if (this.f524010b.size() != 0) goto L9;
        if (this.f524009a.read(this.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L9;
        return -1;
    L9:
        return this.f524010b.read(r100);
    }

    @Override // okio.BufferedSource
    public final long readAll(Sink r110) {
        Intrinsics.checkNotNullParameter(r110, Constants.ROLE_SINK);
        long r100 = 0;
    L4:
        if (this.f524009a.read(this.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == (-1)) goto L9;
        long r101 = this.f524010b.completeSegmentByteCount();
        if (r101 <= 0) goto L4;
        r100 = r100 + r101;
        r110.write(this.f524010b, r101);
        goto L4
    L9:
        if (this.f524010b.size() <= 0) goto L17;
        long r102 = r100 + this.f524010b.size();
        Buffer r103 = this.f524010b;
        r110.write(r103, r103.size());
        return r102;
    L17:
        return r100;
    }

    @Override // okio.BufferedSource
    public final byte[] readByteArray(long r100) {
        require(r100);
        return this.f524010b.readByteArray(r100);
    }

    @Override // okio.BufferedSource
    public final ByteString readByteString(long r100) {
        require(r100);
        return this.f524010b.readByteString(r100);
    }

    @Override // okio.BufferedSource
    public final void readFully(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        require(r100.length);     // Catch: EOFException -> L6
        this.f524010b.readFully(r100);
        return;
    L6:
        e = move-exception;
        int r101 = 0;
    L9:
        if (this.f524010b.size() <= 0) goto L15;
        Buffer r102 = this.f524010b;
        int r103 = r102.read(r100, r101, (int) r102.size());
        if (r103 == (-1)) goto L14;
        r101 = r101 + r103;
        goto L9
    L14:
        throw new AssertionError();
    L15:
        throw e;
    }

    @Override // okio.BufferedSource
    public final String readString(Charset r100) {
        Intrinsics.checkNotNullParameter(r100, "charset");
        this.f524010b.writeAll(this.f524009a);
        return this.f524010b.readString(r100);
    }

    @Override // okio.BufferedSource
    public final String readUtf8(long r100) {
        require(r100);
        return this.f524010b.readUtf8(r100);
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict(long r110) {
        if (r110 < 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L29;
        if (r110 != Long.MAX_VALUE) goto L10;
        long r101 = Long.MAX_VALUE;
    L11:
        long r102 = indexOf((byte) 10, 0, r101);
        if (r102 == (-1)) goto L15;
        return okio.internal.a.b(this.f524010b, r102);
    L15:
        if (r101 < Long.MAX_VALUE) goto L17;
    L26:
        Buffer r103 = new Buffer();
        Buffer r104 = this.f524010b;
        r104.copyTo(r103, 0, Math.min(32, r104.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f524010b.size(), r110) + " content=" + r103.readByteString().hex() + 8230);
    L17:
        if (request(r101) == false) goto L26;
        if (this.f524010b.getByte(r101 - 1) != 13) goto L26;
        if (request(1 + r101) == false) goto L26;
        if (this.f524010b.getByte(r101) != 10) goto L26;
        return okio.internal.a.b(this.f524010b, r101);
    L10:
        r101 = r110 + 1;
        goto L11
    L29:
        throw new IllegalArgumentException(("limit < 0: " + r110).toString());
    L5:
        r100 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public final boolean request(long r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L19;
        if ((!this.f524011c) == false) goto L17;
    L10:
        if (this.f524010b.size() >= r100) goto L14;
        if (this.f524009a.read(this.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L10;
        return false;
    L14:
        return true;
    L17:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    L19:
        throw new IllegalArgumentException(("byteCount < 0: " + r100).toString());
    L5:
        r101 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public final void require(long r100) {
        if (request(r100) == false) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public final int select(z r100) {
        Intrinsics.checkNotNullParameter(null, "options");
        if ((!this.f524011c) == false) goto L12;
    L4:
        Buffer r101 = this.f524010b;
        byte[] r102 = okio.internal.a.f524037a;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(null, "options");
        if (r101.head != null) goto L10;
        if (this.f524009a.read(this.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L4;
        return -1;
    L10:
        throw null;
    L12:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSource
    public final void skip(long r100) {
        if ((!this.f524011c) == false) goto L16;
    L5:
        if (r100 <= 0) goto L14;
        if (this.f524010b.size() != 0) goto L13;
        if (this.f524009a.read(this.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L13;
        throw new EOFException();
    L13:
        long r101 = Math.min(r100, this.f524010b.size());
        this.f524010b.skip(r101);
        r100 = r100 - r101;
        goto L5
    L14:
        return;
    L16:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSource
    public final long indexOf(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        return indexOf(r100, 0);
    }

    @Override // okio.BufferedSource
    public final int read(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        return read(r100, 0, r100.length);
    }

    @Override // okio.BufferedSource
    public final <T> T select(k0<T> r100) {
        Intrinsics.checkNotNullParameter(null, "options");
        throw null;
    }

    @Override // okio.BufferedSource
    public final long indexOf(ByteString r100, long r110) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        if ((!this.f524011c) == false) goto L13;
    L4:
        long r101 = this.f524010b.indexOf(r100, r110);
        if (r101 != (-1)) goto L16;
        long r102 = this.f524010b.size();
        if (this.f524009a.read(this.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == (-1)) goto L10;
        r110 = Math.max(r110, (r102 - ((long) r100.size())) + 1);
        goto L4
    L10:
        return -1;
    L16:
        return r101;
    L13:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSource
    public final long indexOfElement(ByteString r100, long r110) {
        Intrinsics.checkNotNullParameter(r100, "targetBytes");
        if ((!this.f524011c) == false) goto L13;
    L4:
        long r101 = this.f524010b.indexOfElement(r100, r110);
        if (r101 != (-1)) goto L16;
        long r102 = this.f524010b.size();
        if (this.f524009a.read(this.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == (-1)) goto L10;
        r110 = Math.max(r110, r102);
        goto L4
    L10:
        return -1;
    L16:
        return r101;
    L13:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSource
    public final boolean rangeEquals(long r100, ByteString r110) {
        Intrinsics.checkNotNullParameter(r110, HTTP.CONTENT_RANGE_BYTES);
        return rangeEquals(r100, r110, 0, r110.size());
    }

    @Override // okio.Source
    public final long read(Buffer r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        if (r101 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L19;
        if ((true ^ this.f524011c) == false) goto L17;
        if (this.f524010b.size() != 0) goto L15;
        if (this.f524009a.read(this.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L15;
        return -1;
    L15:
        return this.f524010b.read(r100, Math.min(r101, this.f524010b.size()));
    L17:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    L19:
        throw new IllegalArgumentException(("byteCount < 0: " + r101).toString());
    L5:
        r102 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public final void readFully(Buffer r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        require(r101);     // Catch: EOFException -> L6
        this.f524010b.readFully(r100, r101);
        return;
    L6:
        e = move-exception;
        r100.writeAll(this.f524010b);
        throw e;
    }

    @Override // okio.BufferedSource
    public final String readString(long r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r101, "charset");
        require(r100);
        return this.f524010b.readString(r100, r101);
    }

    @Override // okio.BufferedSource
    public final long indexOf(byte r100, long r101) {
        return indexOf(r100, r101, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public final long indexOf(byte r100, long r110, long r111) {
        boolean r101 = true;
        if ((!this.f524011c) == false) goto L26;
        if (0 <= r110) goto L7;
    L9:
        r101 = false;
    L10:
        if (r101 == false) goto L24;
    L12:
        if (r110 >= r111) goto L33;
        long r102 = this.f524010b.indexOf(r100, r110, r111);
        if (r102 != (-1)) goto L22;
        long r103 = this.f524010b.size();
        if (r103 >= r111) goto L31;
        if (this.f524009a.read(this.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == (-1)) goto L32;
        r110 = Math.max(r110, r103);
        goto L12
    L32:
        return -1;
    L31:
        return -1;
    L22:
        return r102;
    L33:
        return -1;
    L24:
        throw new IllegalArgumentException(("fromIndex=" + r110 + " toIndex=" + r111).toString());
    L7:
        if (r110 > r111) goto L9;
    L26:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSource
    public final int read(byte[] r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, Constants.ROLE_SINK);
        long r100 = r112;
        b.b(r110.length, r111, r100);
        if (this.f524010b.size() != 0) goto L8;
        if (this.f524009a.read(this.f524010b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L8;
        return -1;
    L8:
        return this.f524010b.read(r110, r111, (int) Math.min(r100, this.f524010b.size()));
    }

    @Override // okio.BufferedSource
    public final boolean rangeEquals(long r100, ByteString r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, HTTP.CONTENT_RANGE_BYTES);
        if ((!this.f524011c) == false) goto L23;
        if (r100 < 0) goto L20;
        if (r111 < 0) goto L20;
        if (r112 < 0) goto L20;
        if ((r110.size() - r111) < r112) goto L20;
        int r101 = 0;
    L12:
        if (r101 >= r112) goto L27;
        long r102 = ((long) r101) + r100;
        if (request(1 + r102) == false) goto L20;
        if (this.f524010b.getByte(r102) != r110.getByte(r111 + r101)) goto L20;
        r101 = r101 + 1;
        goto L12
    L27:
        return true;
    L20:
        return false;
    L23:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }
}
