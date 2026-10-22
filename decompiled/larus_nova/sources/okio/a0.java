package okio;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a0 implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f523970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f523971b;

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f523970a.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        this.f523970a.flush();
    }

    public final String toString() {
        return "sink(" + this.f523970a + ')';
    }

    @Override // okio.Sink
    public final j0 timeout() {
        return this.f523971b;
    }

    public a0(OutputStream r100, j0 r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Intrinsics.checkNotNullParameter(r101, "timeout");
        this.f523970a = r100;
        this.f523971b = r101;
    }

    @Override // okio.Sink
    public final void write(Buffer r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        b.b(r100.size(), 0, r101);
    L4:
        if (r101 <= 0) goto L8;
        this.f523971b.g();
        g0 r102 = r100.head;
        Intrinsics.checkNotNull(r102);
        int r103 = (int) Math.min(r101, r102.f524019c - r102.f524018b);
        this.f523970a.write(r102.f524017a, r102.f524018b, r103);
        r102.f524018b += r103;
        long r104 = r103;
        r101 = r101 - r104;
        r100.setSize$okio(r100.size() - r104);
        if (r102.f524018b != r102.f524019c) goto L4;
        r100.head = r102.a();
        h0.a(r102);
        goto L4
    }
}
