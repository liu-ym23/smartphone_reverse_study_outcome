package q95;

import com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends InputStream {
    public static final Queue<c> c = null;
    public InputStream a;
    public IOException b;

    public final void b() {
        this.b = null;
        this.a = null;
        Queue<c> r0 = c;
        monitor-enter(r0);
        ((ArrayDeque) r0).offer(this);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        monitor-enter(this);
        this.a.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        int r0 = f.a;
        c = new ArrayDeque(0);
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return this.a.read();
    L4:
        e = move-exception;
        this.b = e;
        return -1;
    }

    public c() {
    }

    public static c a(RecyclableBufferedInputStream r2) {
        Queue<c> r0 = c;
        monitor-enter(r0);
        c r1 = (c) ((ArrayDeque) r0).poll();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = new c();
    L8:
        r1.a = r2;
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final void mark(int r2) {
        this.a.mark(r2);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r2) throws IOException {
        return this.a.read(r2);
    L4:
        e = move-exception;
        this.b = e;
        return -1;
    }

    @Override // java.io.InputStream
    public final long skip(long r2) throws IOException {
        return this.a.skip(r2);
    L4:
        e = move-exception;
        this.b = e;
        return 0;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r2, int r3, int r4) throws IOException {
        return this.a.read(r2, r3, r4);
    L4:
        e = move-exception;
        this.b = e;
        return -1;
    }
}
