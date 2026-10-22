package dva;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f470228a;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.f470228a.available();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f470228a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return this.f470228a.read();
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        this.f470228a.reset();
    }

    public d(InputStream r100) {
        Intrinsics.checkNotNullParameter(r100, "inputStream");
        this.f470228a = r100;
    }

    @Override // java.io.InputStream
    public final void mark(int r100) {
        this.f470228a.mark(r100);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100) throws IOException {
        return this.f470228a.read(r100);
    }

    @Override // java.io.InputStream
    public final long skip(long r100) throws IOException {
        return this.f470228a.skip(r100);
    }

    @Override // java.io.InputStream
    public final int readNBytes(byte[] r100, int r101, int r102) throws IOException {
        return this.f470228a.readNBytes(r100, r101, r102);
    }
}
