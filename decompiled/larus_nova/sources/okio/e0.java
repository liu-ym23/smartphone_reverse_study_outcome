package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.byted.cast.common.Constants;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class e0 implements BufferedSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sink f524005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Buffer f524006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f524007c;

    /* JADX INFO: loaded from: classes42.dex */
    public static final class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f524008a;

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f524008a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() {
            e0 r100 = this.f524008a;
            if (r100.f524007c == true) goto L6;
            r100.flush();
            return;
        }

        public final String toString() {
            return this.f524008a + ".outputStream()";
        }

        public a(e0 r100) {
            this.f524008a = r100;
        }

        @Override // java.io.OutputStream
        public final void write(int r100) {
            e0 r101 = this.f524008a;
            if (r101.f524007c == true) goto L7;
            r101.f524006b.writeByte((byte) r100);
            this.f524008a.emitCompleteSegments();
            return;
        L7:
            throw new IOException(PTYSocketStateCallback.CLOSED);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "data");
            e0 r103 = this.f524008a;
            if (r103.f524007c == true) goto L7;
            r103.f524006b.write(r100, r101, r102);
            this.f524008a.emitCompleteSegments();
            return;
        L7:
            throw new IOException(PTYSocketStateCallback.CLOSED);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f524007c == false) goto L21;
        return;
    L21:
    L8:
        th = th;
    L19:
        this.f524005a.close();     // Catch: Throwable -> L11
    L14:
        this.f524007c = true;
        if (th == null) goto L23;
        throw th;
    L23:
        return;
    L11:
        th = move-exception;
        if (th != null) goto L14;
        th = th;
        goto L14
    L5:
        if (this.f524006b.size() <= 0) goto L7;
        Sink r100 = this.f524005a;     // Catch: Throwable -> L8
        Buffer r101 = this.f524006b;     // Catch: Throwable -> L8
        r100.write(r101, r101.size());     // Catch: Throwable -> L8
    L7:
        th = null;
        goto L19
    }

    @Override // okio.BufferedSink
    public final BufferedSink emit() {
        if ((!this.f524007c) == false) goto L9;
        long r100 = this.f524006b.size();
        if (r100 <= 0) goto L7;
        this.f524005a.write(this.f524006b, r100);
    L7:
        return this;
    L9:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink emitCompleteSegments() {
        if ((!this.f524007c) == false) goto L9;
        long r100 = this.f524006b.completeSegmentByteCount();
        if (r100 <= 0) goto L7;
        this.f524005a.write(this.f524006b, r100);
    L7:
        return this;
    L9:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
        if ((!this.f524007c) == false) goto L10;
        if (this.f524006b.size() <= 0) goto L7;
        Sink r100 = this.f524005a;
        Buffer r101 = this.f524006b;
        r100.write(r101, r101.size());
    L7:
        this.f524005a.flush();
        return;
    L10:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f524007c;
    }

    @Override // okio.BufferedSink
    public final OutputStream outputStream() {
        return new a(this);
    }

    @Override // okio.Sink
    public final j0 timeout() {
        return this.f524005a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f524005a + ')';
    }

    @Override // okio.BufferedSink
    public final Buffer buffer() {
        return this.f524006b;
    }

    @Override // okio.BufferedSink
    public final Buffer getBuffer() {
        return this.f524006b;
    }

    public e0(Sink r100) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        this.f524005a = r100;
        this.f524006b = new Buffer();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if ((!this.f524007c) == false) goto L7;
        int r101 = this.f524006b.write(r100);
        emitCompleteSegments();
        return r101;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final long writeAll(Source r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        long r101 = 0;
    L3:
        long r102 = r100.read(this.f524006b, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        if (r102 == (-1)) goto L6;
        r101 = r101 + r102;
        emitCompleteSegments();
        goto L3
    L6:
        return r101;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeByte(int r100) {
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeByte(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeDecimalLong(long r100) {
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeDecimalLong(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeHexadecimalUnsignedLong(long r100) {
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeHexadecimalUnsignedLong(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeInt(int r100) {
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeInt(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeIntLe(int r100) {
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeIntLe(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeLong(long r100) {
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeLong(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeLongLe(long r100) {
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeLongLe(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeShort(int r100) {
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeShort(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeShortLe(int r100) {
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeShortLe(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeUtf8(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8CodePoint(int r100) {
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeUtf8CodePoint(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "byteString");
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.write(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.write(r100);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(Source r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
    L4:
        if (r101 <= 0) goto L10;
        long r102 = r100.read(this.f524006b, r101);
        if (r102 == (-1)) goto L9;
        r101 = r101 - r102;
        emitCompleteSegments();
        goto L4
    L9:
        throw new EOFException();
    L10:
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeString(String r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "string");
        Intrinsics.checkNotNullParameter(r101, "charset");
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeString(r100, r101);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.Sink
    public final void write(Buffer r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.write(r100, r101);
        emitCompleteSegments();
        return;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(ByteString r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "byteString");
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.write(r100, r101, r102);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "string");
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeUtf8(r100, r101, r102);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(byte[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.write(r100, r101, r102);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeString(String r100, int r101, int r102, Charset r103) {
        Intrinsics.checkNotNullParameter(r100, "string");
        Intrinsics.checkNotNullParameter(r103, "charset");
        if ((!this.f524007c) == false) goto L7;
        this.f524006b.writeString(r100, r101, r102, r103);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }
}
