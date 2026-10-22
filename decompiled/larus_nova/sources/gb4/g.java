package gb4;

import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.m;
import com.bytedance.bdp.serviceapi.defaults.log.BdpLogService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class g extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f480714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f480715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f480716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f480717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f480718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f480719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f480720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f480721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InputStream f480722i;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f480716c = true;
        this.f480722i.close();
    }

    public synchronized byte[] a() {
        monitor-enter(this);
        byte[] r100 = this.f480718e;     // Catch: Throwable -> L35
        if (r100 == null) goto L9;
        monitor-exit(this);
        return r100;
    L9:
        if (this.f480716c == false) goto L38;
        d("getRawData fail: close " + this.f480716c + ", finish " + this.f480715b);     // Catch: Throwable -> L35
        byte[] r101 = new byte[0];     // Catch: Throwable -> L35
        monitor-exit(this);
        return r101;
    L38:
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L22
        byte[] r103 = m.a();     // Catch: Throwable -> L22
    L42:
        int r104 = read(r103);     // Catch: Throwable -> L19
        if (r104 == (-1)) goto L18;
        r102.write(r103, 0, r104);     // Catch: Throwable -> L19
    L18:
        m.b(r103);     // Catch: Throwable -> L22
        this.f480718e = r102.toByteArray();     // Catch: Throwable -> L22
    L24:
        e();     // Catch: Throwable -> L35
        if (this.f480718e != null) goto L27;
        this.f480718e = new byte[0];     // Catch: Throwable -> L35
    L27:
        byte[] r105 = this.f480718e;     // Catch: Throwable -> L35
        if (r105 != null) goto L30;
        Intrinsics.throwNpe();     // Catch: Throwable -> L35
    L30:
        monitor-exit(this);
        return r105;
    L19:
        th = move-exception;
        m.b(r103);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        d("getRawData fail: " + th.getMessage() + " close " + this.f480716c + ", finish " + this.f480715b);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        e();     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int r100 = this.f480722i.read();
        if (r100 == (-1)) goto L5;
        this.f480717d++;
    L6:
        return r100;
    L5:
        this.f480715b = true;
        goto L6
    }

    public final String toString() {
        return "BdpResponseBody(contentType='" + this.f480720g + "', contentLength=" + this.f480721h + ", finished=" + this.f480715b + ", closed=" + this.f480716c + ", readLength=" + this.f480717d + ')';
    }

    public void e() {
        close();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d("close failed " + th.getMessage());
    }

    public long b() {
        return this.f480721h;
    }

    public String c() {
        return this.f480720g;
    }

    public final void d(String r100) {
        ((BdpLogService) BdpManager.getInst().getService(BdpLogService.class)).e(this.f480714a, r100);
    }

    public g(String r100, long r101, InputStream r102) {
        this.f480720g = r100;
        this.f480721h = r101;
        this.f480722i = r102;
        this.f480714a = "BdpResponseBody";
    }
}
