package jv7;

import iv7.k;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public final class h<T extends InputStream> extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f500577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public Runnable f500578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f500579c;

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        monitor-enter(this);
        a();     // Catch: Throwable -> L6
        this.f500577a.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a() throws IOException {
        if (this.f500579c == false) goto L6;
        return;
    L6:
        throw new IOException("InputStream is closed.");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f500579c == false) goto L8;
        this.f500579c = false;
        Runnable r100 = this.f500578b;
        if (r100 == null) goto L9;
        r100.run();
        this.f500578b = null;
        return;
    L9:
        return;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f500577a.markSupported();
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        a();
        return this.f500577a.available();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        a();
        return this.f500577a.read();
    }

    public final void finalize() throws Throwable {
        close();
    }

    public h(k r100) {
        this.f500578b = null;
        this.f500579c = true;
        this.f500577a = r100;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int r100) {
        monitor-enter(this);
        this.f500577a.mark(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final int read(@Nonnull byte[] r100) throws IOException {
        a();
        return this.f500577a.read(r100);
    }

    @Override // java.io.InputStream
    public final long skip(long r100) throws IOException {
        a();
        return this.f500577a.skip(r100);
    }

    @Override // java.io.InputStream
    public final int read(@Nonnull byte[] r100, int r101, int r102) throws IOException {
        a();
        return this.f500577a.read(r100, r101, r102);
    }
}
