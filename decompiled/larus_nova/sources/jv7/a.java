package jv7;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes23.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f500559a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // jv7.b
    public final ByteBuffer a() {
        ByteBuffer r100 = ByteBuffer.allocateDirect(this.f500559a.length);
        r100.put(this.f500559a);
        r100.flip();
        return r100;
    }

    @Override // jv7.b
    public final long b() {
        return this.f500559a.length;
    }

    public a(byte[] r100) {
        this.f500559a = r100;
    }

    @Override // jv7.b
    public final InputStream d(long r100, long r101) throws IOException {
        return new ByteArrayInputStream(this.f500559a, (int) r100, (int) r101);
    }
}
