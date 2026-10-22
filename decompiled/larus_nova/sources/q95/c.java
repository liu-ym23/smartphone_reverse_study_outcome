package q95;

import com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Queue<c> f532102c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f532103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IOException f532104b;

    public final void b() {
        this.f532104b = null;
        this.f532103a = null;
        Queue<c> r100 = f532102c;
        monitor-enter(r100);
        ((ArrayDeque) r100).offer(this);     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        monitor-enter(this);
        this.f532103a.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        int r100 = f.f532111a;
        f532102c = new ArrayDeque(0);
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.f532103a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f532103a.close();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f532103a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return this.f532103a.read();
    L4:
        e = move-exception;
        this.f532104b = e;
        return -1;
    }

    public c() {
    }

    public static c a(RecyclableBufferedInputStream r100) {
        Queue<c> r101 = f532102c;
        monitor-enter(r101);
        c r102 = (c) ((ArrayDeque) r101).poll();     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        if (r102 != null) goto L8;
        r102 = new c();
    L8:
        r102.f532103a = r100;
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final void mark(int r100) {
        this.f532103a.mark(r100);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100) throws IOException {
        return this.f532103a.read(r100);
    L4:
        e = move-exception;
        this.f532104b = e;
        return -1;
    }

    @Override // java.io.InputStream
    public final long skip(long r100) throws IOException {
        return this.f532103a.skip(r100);
    L4:
        e = move-exception;
        this.f532104b = e;
        return 0;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        return this.f532103a.read(r100, r101, r102);
    L4:
        e = move-exception;
        this.f532104b = e;
        return -1;
    }
}
