package jv7;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes23.dex */
public abstract class b implements Closeable {
    public b() {
    }

    public abstract ByteBuffer a() throws IOException;

    public abstract long b();

    public final synchronized InputStream c() throws IOException {
        monitor-enter(this);
        InputStream r100 = d(0, b());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public abstract InputStream d(long r100, long r101) throws IOException;

    public i e(long r100, long r110) {
        return new i(this, r100, Math.min(r110, b()));
    }
}
