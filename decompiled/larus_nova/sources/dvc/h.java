package dvc;

import java.io.IOException;
import okio.Buffer;
import okio.Sink;
import okio.n;

/* JADX INFO: loaded from: classes42.dex */
public class h extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f470284b;

    public void a() {
        throw null;
    }

    @Override // okio.n, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f470284b == false) goto L9;
        return;
    L9:
        super.close();     // Catch: IOException -> L7
        return;
    L7:
        this.f470284b = true;
        a();
    }

    @Override // okio.n, okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        if (this.f470284b == false) goto L9;
        return;
    L9:
        super.flush();     // Catch: IOException -> L7
        return;
    L7:
        this.f470284b = true;
        a();
    }

    public h(Sink r100) {
        super(r100);
    }

    @Override // okio.n, okio.Sink
    public final void write(Buffer r100, long r101) throws IOException {
        if (this.f470284b == false) goto L10;
        r100.skip(r101);
        return;
    L10:
        super.write(r100, r101);     // Catch: IOException -> L8
        return;
    L8:
        this.f470284b = true;
        a();
    }
}
