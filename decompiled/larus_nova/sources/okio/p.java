package okio;

import com.byted.cast.common.Constants;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class p implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f524092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deflater f524093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f524094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f524095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CRC32 f524096e;

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f524095d == false) goto L24;
        return;
    L24:
        i r100 = this.f524094c;     // Catch: Throwable -> L7
        r100.f524034b.finish();     // Catch: Throwable -> L7
        r100.a(false);     // Catch: Throwable -> L7
        this.f524092a.writeIntLe((int) this.f524096e.getValue());     // Catch: Throwable -> L7
        this.f524092a.writeIntLe((int) this.f524093b.getBytesRead());     // Catch: Throwable -> L7
        th = null;
    L22:
        this.f524093b.end();     // Catch: Throwable -> L10
    L26:
        this.f524092a.close();     // Catch: Throwable -> L15
    L18:
        this.f524095d = true;
        if (th != null) goto L21;
        return;
    L21:
        throw th;
    L15:
        th = move-exception;
        if (th != null) goto L18;
        th = th;
    L10:
        th = move-exception;
        if (th != null) goto L26;
        th = th;
    L7:
        th = th;
        goto L22
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        this.f524094c.flush();
    }

    @Override // okio.Sink
    public final j0 timeout() {
        return this.f524092a.timeout();
    }

    public p(Sink r100) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        e0 r101 = new e0(r100);
        this.f524092a = r101;
        Deflater r102 = new Deflater(-1, true);
        this.f524093b = r102;
        this.f524094c = new i(r101, r102);
        this.f524096e = new CRC32();
        Buffer r103 = r101.f524006b;
        r103.writeShort(8075);
        r103.writeByte(8);
        r103.writeByte(0);
        r103.writeInt(0);
        r103.writeByte(0);
        r103.writeByte(0);
    }

    @Override // okio.Sink
    public final void write(Buffer r110, long r111) throws IOException {
        Intrinsics.checkNotNullParameter(r110, "source");
        if (r111 < 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L16;
        if (r111 != 0) goto L9;
        return;
    L9:
        g0 r101 = r110.head;
        Intrinsics.checkNotNull(r101);
        long r102 = r111;
    L11:
        if (r102 <= 0) goto L13;
        int r103 = (int) Math.min(r102, r101.f524019c - r101.f524018b);
        this.f524096e.update(r101.f524017a, r101.f524018b, r103);
        r102 = r102 - ((long) r103);
        r101 = r101.f524022f;
        Intrinsics.checkNotNull(r101);
        goto L11
    L13:
        this.f524094c.write(r110, r111);
        return;
    L16:
        throw new IllegalArgumentException(("byteCount < 0: " + r111).toString());
    L5:
        r100 = false;
        goto L6
    }
}
