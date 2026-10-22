package lx5;

import com.bytedance.retrofit2.client.SsCall;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class c extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f511213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SsCall f511214b;

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        monitor-enter(this);
        InputStream r100 = this.f511213a;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        r100.reset();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        super.reset();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        InputStream r100 = this.f511213a;
        if (r100 == null) goto L7;
        return r100.available();
    L7:
        return super.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream r100 = this.f511213a;     // Catch: Throwable -> L9
        if (r100 == null) goto L5;
        r100.close();     // Catch: Throwable -> L9
    L5:
        SsCall r101 = this.f511214b;     // Catch: Throwable -> L9
        if (r101 == null) goto L11;
        r101.cancel();     // Catch: Throwable -> L9
    L11:
        super.close();
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        InputStream r100 = this.f511213a;
        if (r100 == null) goto L7;
        return r100.markSupported();
    L7:
        return super.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream r100 = this.f511213a;     // Catch: Throwable -> L10 IOException -> L12
        if (r100 == null) goto L6;
        int r101 = r100.read();     // Catch: Throwable -> L10 IOException -> L12
    L7:
        if (r101 != (-1)) goto L9;
        close();
    L9:
        return r101;
    L6:
        r101 = -1;
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L10
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int r100) {
        monitor-enter(this);
        InputStream r101 = this.f511213a;     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        r101.mark(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        super.mark(r100);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public int read(byte[] r100) throws IOException {
        InputStream r101 = this.f511213a;     // Catch: Throwable -> L10 IOException -> L12
        if (r101 == null) goto L5;
        int r102 = r101.read(r100);     // Catch: Throwable -> L10 IOException -> L12
    L7:
        if (r102 != (-1)) goto L9;
        close();
    L9:
        return r102;
    L5:
        r102 = super.read(r100);     // Catch: Throwable -> L10 IOException -> L12
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L10
    }

    @Override // java.io.InputStream
    public final long skip(long r100) throws IOException {
        InputStream r101 = this.f511213a;
        if (r101 == null) goto L7;
        return r101.skip(r100);
    L7:
        return super.skip(r100);
    }

    public c(InputStream r100, SsCall r101) {
        this.f511213a = r100;
        this.f511214b = r101;
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        InputStream r103 = this.f511213a;     // Catch: Throwable -> L10 IOException -> L12
        if (r103 == null) goto L5;
        int r104 = r103.read(r100, r101, r102);     // Catch: Throwable -> L10 IOException -> L12
    L7:
        if (r104 != (-1)) goto L9;
        close();
    L9:
        return r104;
    L5:
        r104 = super.read(r100, r101, r102);     // Catch: Throwable -> L10 IOException -> L12
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L10
    }
}
