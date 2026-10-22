package okio;

import com.byted.cast.common.Constants;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class t implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedSource f524107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Inflater f524108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f524109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f524110d;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f524110d == false) goto L5;
        return;
    L5:
        this.f524108b.end();
        this.f524110d = true;
        this.f524107a.close();
    }

    @Override // okio.Source
    public final j0 timeout() {
        return this.f524107a.timeout();
    }

    public t(f0 r100, Inflater r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "inflater");
        this.f524107a = r100;
        this.f524108b = r101;
    }

    @Override // okio.Source
    public final long read(Buffer r110, long r111) throws IOException {
        Intrinsics.checkNotNullParameter(r110, Constants.ROLE_SINK);
    L3:
        Intrinsics.checkNotNullParameter(r110, Constants.ROLE_SINK);
        if (r111 < 0) goto L6;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L50;
        if ((!this.f524110d) == false) goto L48;
        if (r111 != 0) goto L51;
    L11:
        long r101 = 0;
    L30:
        if (r101 > 0) goto L31;
        if (this.f524108b.finished() == true) goto L42;
        if (this.f524108b.needsDictionary() == true) goto L60;
        if (this.f524107a.exhausted() == false) goto L3;
        throw new EOFException("source exhausted prematurely");
    L60:
        return -1;
    L42:
        return -1;
    L31:
        return r101;
    L51:
        g0 r102 = r110.writableSegment$okio(1);     // Catch: DataFormatException -> L44
        int r103 = (int) Math.min(r111, 8192 - r102.f524019c);     // Catch: DataFormatException -> L44
        if (this.f524108b.needsInput() == true) goto L16;
    L19:
        int r104 = this.f524108b.inflate(r102.f524017a, r102.f524019c, r103);     // Catch: DataFormatException -> L44
        int r105 = this.f524109c;     // Catch: DataFormatException -> L44
        if (r105 == 0) goto L23;
        int r106 = r105 - this.f524108b.getRemaining();     // Catch: DataFormatException -> L44
        this.f524109c -= r106;     // Catch: DataFormatException -> L44
        this.f524107a.skip(r106);     // Catch: DataFormatException -> L44
    L23:
        if (r104 <= 0) goto L26;
        r102.f524019c += r104;     // Catch: DataFormatException -> L44
        r101 = r104;
        r110.setSize$okio(r110.size() + r101);     // Catch: DataFormatException -> L44
        goto L30
    L26:
        if (r102.f524018b != r102.f524019c) goto L11;
        r110.head = r102.a();     // Catch: DataFormatException -> L44
        h0.a(r102);     // Catch: DataFormatException -> L44
        goto L11
    L16:
        if (this.f524107a.exhausted() == true) goto L19;
        g0 r107 = this.f524107a.getBuffer().head;     // Catch: DataFormatException -> L44
        Intrinsics.checkNotNull(r107);     // Catch: DataFormatException -> L44
        int r108 = r107.f524019c;     // Catch: DataFormatException -> L44
        int r109 = r107.f524018b;     // Catch: DataFormatException -> L44
        int r112 = r108 - r109;     // Catch: DataFormatException -> L44
        this.f524109c = r112;     // Catch: DataFormatException -> L44
        this.f524108b.setInput(r107.f524017a, r109, r112);     // Catch: DataFormatException -> L44
    L44:
        e = move-exception;
        throw new IOException(e);
    L48:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    L50:
        throw new IllegalArgumentException(("byteCount < 0: " + r111).toString());
    L6:
        r100 = false;
        goto L7
    }
}
