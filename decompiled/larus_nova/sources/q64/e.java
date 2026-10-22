package q64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes46.dex */
public class e extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f531795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputStream f531796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f531797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f531798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f531799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f531800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f531801h;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f531798e = true;
        this.f531796c.close();
    }

    public byte[] a() {
        byte[] r100 = this.f531800g;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        return r100;
    L7:
        if (isClosed() == true) goto L9;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Throwable -> L16
        byte[] r102 = new byte[4096];     // Catch: Throwable -> L16
    L11:
        int r103 = read(r102);     // Catch: Throwable -> L16
        if (r103 <= 0) goto L14;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L16
        goto L11
    L14:
        this.f531800g = r101.toByteArray();     // Catch: Throwable -> L16
    L15:
        e();
        if (this.f531800g != null) goto L22;
        this.f531800g = new byte[0];
    L22:
        byte[] r104 = this.f531800g;
        Intrinsics.checkNotNull(r104);
        return r104;
    L16:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        e();
        throw th;
    L9:
        return new byte[0];
    }

    public String f() {
        String r100 = this.f531801h;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        return r100;
    L6:
        String r101 = new String(a(), Charsets.UTF_8);
        this.f531801h = r101;
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int r100 = this.f531796c.read();
        if (r100 == (-1)) goto L5;
        this.f531799f++;
    L6:
        return r100;
    L5:
        this.f531797d = true;
        goto L6
    }

    public final String toString() {
        return "BdpResponseBody(contentType='" + this.f531794a + "', contentLength=" + this.f531795b + ", finished=" + this.f531797d + ", closed=" + this.f531798e + ", readLength=" + this.f531799f + ')';
    }

    public boolean e() {
        close();     // Catch: Throwable -> L4
        return true;
    L4:
        th = move-exception;
        th.getMessage();
        return false;
    }

    public long b() {
        return this.f531795b;
    }

    public String c() {
        return this.f531794a;
    }

    public boolean d() {
        return this.f531797d;
    }

    public boolean isClosed() {
        return this.f531798e;
    }

    public e(String r100, long r101, InputStream r102) {
        Intrinsics.checkNotNullParameter(r100, "contentType");
        Intrinsics.checkNotNullParameter(r102, "real");
        this.f531794a = r100;
        this.f531795b = r101;
        this.f531796c = r102;
    }
}
