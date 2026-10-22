package okio;

import com.byted.cast.common.Constants;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class g implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedSink f524013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Cipher f524014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f524015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f524016d;

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f524016d == false) goto L5;
        return;
    L5:
        this.f524016d = true;
        int r100 = this.f524014b.getOutputSize(0);
        Throwable th10 = null;
        if (r100 != 0) goto L9;
    L33:
        this.f524013a.close();     // Catch: Throwable -> L23
    L26:
        if (th10 != null) goto L28;
        return;
    L28:
        throw th10;
    L23:
        th = move-exception;
        if (th10 != null) goto L26;
        th10 = th;
        goto L26
    L9:
        if (r100 > 8192) goto L29;
        Buffer r101 = this.f524013a.getBuffer();
        g0 r102 = r101.writableSegment$okio(r100);
        int r103 = this.f524014b.doFinal(r102.f524017a, r102.f524019c);     // Catch: Throwable -> L17
        r102.f524019c += r103;     // Catch: Throwable -> L17
        r101.setSize$okio(r101.size() + ((long) r103));     // Catch: Throwable -> L17
    L19:
        if (r102.f524018b != r102.f524019c) goto L33;
        r101.head = r102.a();
        h0.a(r102);
    L17:
        th10 = th;
        goto L19
    L29:
        this.f524013a.write(this.f524014b.doFinal());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th10 = th;
        goto L33
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        this.f524013a.flush();
    }

    @Override // okio.Sink
    public final j0 timeout() {
        return this.f524013a.timeout();
    }

    public g(BufferedSink r100, Cipher r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        Intrinsics.checkNotNullParameter(r101, "cipher");
        this.f524013a = r100;
        this.f524014b = r101;
        int r102 = r101.getBlockSize();
        this.f524015c = r102;
        if (r102 <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("Block cipher required " + r101).toString());
    L5:
        r103 = false;
        goto L6
    }

    private final int update(Buffer r110, long r111) {
        g0 r100 = r110.head;
        Intrinsics.checkNotNull(r100);
        int r101 = (int) Math.min(r111, r100.f524019c - r100.f524018b);
        Buffer r102 = this.f524013a.getBuffer();
        int r103 = this.f524014b.getOutputSize(r101);
    L4:
        if (r103 <= 8192) goto L10;
        int r104 = this.f524015c;
        if (r101 <= r104) goto L7;
        r101 = r101 - r104;
        r103 = this.f524014b.getOutputSize(r101);
        goto L4
    L7:
        this.f524013a.write(this.f524014b.update(r110.readByteArray(r111)));
        return (int) r111;
    L10:
        g0 r112 = r102.writableSegment$okio(r103);
        int r113 = this.f524014b.update(r100.f524017a, r100.f524018b, r101, r112.f524017a, r112.f524019c);
        r112.f524019c += r113;
        r102.setSize$okio(r102.size() + ((long) r113));
        if (r112.f524018b != r112.f524019c) goto L13;
        r102.head = r112.a();
        h0.a(r112);
    L13:
        this.f524013a.emitCompleteSegments();
        r110.setSize$okio(r110.size() - ((long) r101));
        int r114 = r100.f524018b + r101;
        r100.f524018b = r114;
        if (r114 != r100.f524019c) goto L16;
        r110.head = r100.a();
        h0.a(r100);
    L16:
        return r101;
    }

    @Override // okio.Sink
    public final void write(Buffer r100, long r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "source");
        b.b(r100.size(), 0, r101);
        if ((!this.f524016d) == false) goto L9;
    L5:
        if (r101 <= 0) goto L7;
        r101 = r101 - ((long) update(r100, r101));
        goto L5
    L7:
        return;
    L9:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    }
}
