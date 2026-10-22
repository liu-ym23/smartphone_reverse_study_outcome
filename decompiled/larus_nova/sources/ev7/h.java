package ev7;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes23.dex */
public final class h extends OutputStream {
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    public final synchronized String toString() {
        monitor-enter(this);
        String r100 = new String(null, 0, 0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int r100) {
        monitor-enter(this);
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }
}
