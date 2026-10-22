package okio;

import com.byted.cast.common.Constants;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class i implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedSink f524033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deflater f524034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f524035c;

    @Override // okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        a(true);
        this.f524033a.flush();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f524035c == false) goto L22;
        return;
    L22:
        this.f524034b.finish();     // Catch: Throwable -> L7
        a(false);     // Catch: Throwable -> L7
        th = null;
    L26:
        this.f524034b.end();     // Catch: Throwable -> L10
    L24:
        this.f524033a.close();     // Catch: Throwable -> L15
    L18:
        this.f524035c = true;
        if (th != null) goto L21;
        return;
    L21:
        throw th;
    L15:
        th = move-exception;
        if (th != null) goto L18;
        th = th;
    L10:
        th = move-exception;
        if (th != null) goto L24;
        th = th;
    L7:
        th = th;
        goto L26
    }

    @Override // okio.Sink
    public final j0 timeout() {
        return this.f524033a.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f524033a + ')';
    }

    public final void a(boolean r100) {
        Buffer r101 = this.f524033a.getBuffer();
    L3:
        g0 r102 = r101.writableSegment$okio(1);
        if (r100 == true) goto L18;
        Deflater r103 = this.f524034b;     // Catch: NullPointerException -> L15
        byte[] r104 = r102.f524017a;     // Catch: NullPointerException -> L15
        int r105 = r102.f524019c;     // Catch: NullPointerException -> L15
        int r106 = r103.deflate(r104, r105, 8192 - r105);     // Catch: NullPointerException -> L15
    L7:
        if (r106 > 0) goto L8;
        if (this.f524034b.needsInput() == false) goto L3;
        if (r102.f524018b != r102.f524019c) goto L26;
        r101.head = r102.a();
        h0.a(r102);
        return;
    L26:
        return;
    L8:
        r102.f524019c += r106;
        r101.setSize$okio(r101.size() + ((long) r106));
        this.f524033a.emitCompleteSegments();
        goto L3
    L18:
        Deflater r107 = this.f524034b;     // Catch: NullPointerException -> L15
        byte[] r108 = r102.f524017a;     // Catch: NullPointerException -> L15
        int r109 = r102.f524019c;     // Catch: NullPointerException -> L15
        r106 = r107.deflate(r108, r109, 8192 - r109, 2);     // Catch: NullPointerException -> L15
    L15:
        e = move-exception;
        throw new IOException("Deflater already closed", e);
    }

    public i(e0 r100, Deflater r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        Intrinsics.checkNotNullParameter(r101, "deflater");
        this.f524033a = r100;
        this.f524034b = r101;
    }

    @Override // okio.Sink
    public final void write(Buffer r100, long r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "source");
        b.b(r100.size(), 0, r101);
    L4:
        if (r101 <= 0) goto L9;
        g0 r102 = r100.head;
        Intrinsics.checkNotNull(r102);
        int r103 = (int) Math.min(r101, r102.f524019c - r102.f524018b);
        this.f524034b.setInput(r102.f524017a, r102.f524018b, r103);
        a(false);
        long r104 = r103;
        r100.setSize$okio(r100.size() - r104);
        int r105 = r102.f524018b + r103;
        r102.f524018b = r105;
        if (r105 != r102.f524019c) goto L8;
        r100.head = r102.a();
        h0.a(r102);
    L8:
        r101 = r101 - r104;
        goto L4
    }
}
