package okio;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public abstract class n implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sink f524090a;

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f524090a.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.f524090a.flush();
    }

    @Override // okio.Sink
    public final j0 timeout() {
        return this.f524090a.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f524090a + ')';
    }

    public n(Sink r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f524090a = r100;
    }

    @Override // okio.Sink
    public void write(Buffer r100, long r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f524090a.write(r100, r101);
    }
}
