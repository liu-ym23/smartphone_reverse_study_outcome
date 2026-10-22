package iv7;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes23.dex */
public final class l extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f495963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f495964b;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f495964b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f495964b = true;     // Catch: Throwable -> L11
        flush();     // Catch: Throwable -> L11
        this.f495963a.close();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f495963a.getChannel().force(true);
    }

    public final void finalize() throws IOException {
        close();
    }

    @Override // java.io.OutputStream
    public final void write(int r100) throws IOException {
        this.f495963a.write(r100);
    }

    @Override // java.io.OutputStream
    public final void write(@Nonnull byte[] r100) throws IOException {
        write(r100, 0, r100.length);
    }

    public l(File r100, long r101) throws IOException {
        this.f495964b = false;
        RandomAccessFile r102 = new RandomAccessFile(r100, "rw");
        this.f495963a = r102;
        if (r101 < 0) goto L9;
        r102.setLength(r101);
        if (r102.length() != r101) goto L8;
        return;
    L8:
        throw new IOException("Unable to set the file size");
    }

    @Override // java.io.OutputStream
    public final void write(@Nonnull byte[] r100, int r101, int r102) throws IOException {
        this.f495963a.write(r100, r101, r102);
    }
}
