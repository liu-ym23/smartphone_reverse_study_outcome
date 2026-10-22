package pp7;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends BufferedInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f530213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f530214b;

    public final synchronized a a() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f530213a == true) goto L15;
        if (this.f530214b == true) goto L11;
        this.f530213a = true;     // Catch: Throwable -> L12
        int r100 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;     // Catch: Throwable -> L12
        byte[] r101 = new byte[r100];     // Catch: Throwable -> L12
        System.arraycopy(((BufferedInputStream) this).buf, ((BufferedInputStream) this).pos, r101, 0, r100);     // Catch: Throwable -> L12
        ((BufferedInputStream) this).pos = 0;     // Catch: Throwable -> L12
        ((BufferedInputStream) this).count = 0;     // Catch: Throwable -> L12
        a r102 = new a(new InputStream[]{new ByteArrayInputStream(r101), ((BufferedInputStream) this).in});     // Catch: Throwable -> L12
        monitor-exit(this);
        return r102;
    L11:
        throw new IllegalStateException();     // Catch: Throwable -> L12
    L15:
        throw new IllegalStateException();     // Catch: Throwable -> L12
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f530213a == true) goto L11;
        this.f530214b = false;     // Catch: Throwable -> L8
        super.reset();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException();     // Catch: Throwable -> L8
    }

    public b(InputStream r100) {
        super(r100, 1024);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f530213a == true) goto L11;
        this.f530214b = true;     // Catch: Throwable -> L8
        super.mark(r100);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException();     // Catch: Throwable -> L8
    }
}
