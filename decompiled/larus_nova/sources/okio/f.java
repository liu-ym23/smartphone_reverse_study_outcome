package okio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class f implements Sink {
    public f() {
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
    }

    @Override // okio.Sink
    public final j0 timeout() {
        return j0.f524073d;
    }

    @Override // okio.Sink
    public final void write(Buffer r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        r100.skip(r101);
    }
}
