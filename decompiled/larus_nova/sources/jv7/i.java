package jv7;

import androidx.collection.SieveCacheKt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes23.dex */
public final class i extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f500580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f500581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f500582c;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // jv7.b
    public final ByteBuffer a() throws IOException {
        b r100 = this.f500580a;
        if ((r100 instanceof g) == false) goto L6;
        File r101 = ((g) r100).f500560a;
        long r102 = this.f500581b;
        return e.d(r101, r102, this.f500582c - r102);
    L6:
        ByteBuffer r103 = r100.a();
        if (r103 == null) goto L14;
        long r104 = this.f500582c;
        if (r104 < SieveCacheKt.NodeLinkMask) goto L11;
        return null;
    L11:
        if (this.f500581b >= SieveCacheKt.NodeLinkMask) goto L17;
        r103.limit((int) r104);
        r103.position((int) this.f500581b);
        return r103.slice();
    L17:
        return null;
    L14:
        return null;
    }

    @Override // jv7.b
    public final long b() {
        return this.f500582c - this.f500581b;
    }

    public final long f(long r100) {
        if (r100 >= 0) goto L6;
        return 0;
    L6:
        return Math.min(r100, this.f500580a.b());
    }

    @Override // jv7.b
    public final InputStream d(long r100, long r101) throws IOException {
        long r102 = f(this.f500581b + r100);
        long r103 = f(r101 + r102);
        return this.f500580a.d(r102, r103 - r102);
    }

    @Override // jv7.b
    public final i e(long r100, long r110) {
        long r101 = f(this.f500581b + r100);
        long r102 = f(r110 + r101);
        return new i(this.f500580a, r101, r102 - r101);
    }

    public i(b r100, long r101, long r102) {
        this.f500580a = r100;
        long r103 = f(r101);
        this.f500581b = r103;
        this.f500582c = f(r103 + r102);
    }
}
