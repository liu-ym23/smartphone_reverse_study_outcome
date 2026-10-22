package dvc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.j0;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f470233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BufferedSource f470234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f470235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BufferedSink f470236d;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f470233a == false) goto L12;
    L10:
        this.f470234b.close();
        return;
    L12:
        boolean r100 = cvc.c.s(this, 100, TimeUnit.MILLISECONDS);     // Catch: IOException -> L7
    L8:
        if (r100 == true) goto L10;
        this.f470233a = true;
        ((Cache.c) this.f470235c).a();
    L7:
        r100 = false;
        goto L8
    }

    @Override // okio.Source
    public final j0 timeout() {
        return this.f470234b.timeout();
    }

    @Override // okio.Source
    public final long read(Buffer r100, long r110) throws IOException {
        long r111 = this.f470234b.read(r100, r110);     // Catch: IOException -> L12
        if (r111 == (-1)) goto L7;
        r100.copyTo(this.f470236d.buffer(), r100.size() - r111, r111);
        this.f470236d.emitCompleteSegments();
        return r111;
    L7:
        if (this.f470233a == true) goto L9;
        this.f470233a = true;
        this.f470236d.close();
    L9:
        return -1;
    L12:
        e = move-exception;
        if (this.f470233a == true) goto L16;
        this.f470233a = true;
        ((Cache.c) this.f470235c).a();
    L16:
        throw e;
    }

    public a(BufferedSource r100, c r101, BufferedSink r102) {
        this.f470234b = r100;
        this.f470235c = r101;
        this.f470236d = r102;
    }
}
