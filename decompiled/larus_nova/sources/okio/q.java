package okio;

import com.byted.cast.common.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class q implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f524097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f524098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Inflater f524099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f524100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CRC32 f524101e;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f524100d.close();
    }

    @Override // okio.Source
    public final j0 timeout() {
        return this.f524098b.timeout();
    }

    public q(Source r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        f0 r101 = new f0(r100);
        this.f524098b = r101;
        Inflater r102 = new Inflater(true);
        this.f524099c = r102;
        this.f524100d = new t(r101, r102);
        this.f524101e = new CRC32();
    }

    @Override // okio.Source
    public final long read(Buffer r210, long r211) throws IOException {
        Intrinsics.checkNotNullParameter(r210, Constants.ROLE_SINK);
        if (r211 < 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L74;
        if (r211 != 0) goto L10;
        return 0;
    L10:
        if (this.f524097a != 0) goto L59;
        this.f524098b.require(10);
        byte r110 = this.f524098b.f524010b.getByte(3);
        if (((r110 >> 1) & 1) != 1) goto L14;
        boolean r111 = true;
    L15:
        if (r111 == false) goto L17;
        b(this.f524098b.f524010b, 0, 10);
    L17:
        a("ID1ID2", 8075, this.f524098b.readShort());
        this.f524098b.skip(8);
        if (((r110 >> 2) & 1) != 1) goto L20;
        boolean r101 = true;
    L21:
        if (r101 == false) goto L31;
        this.f524098b.require(2);
        if (r111 == false) goto L25;
        b(this.f524098b.f524010b, 0, 2);
    L25:
        long r102 = this.f524098b.f524010b.readShortLe() & 65535;
        this.f524098b.require(r102);
        if (r111 == false) goto L29;
        b(this.f524098b.f524010b, 0, r102);
    L29:
        this.f524098b.skip(r102);
    L31:
        if (((r110 >> 3) & 1) != 1) goto L33;
        boolean r103 = true;
    L35:
        if (r103 == false) goto L44;
        long r112 = this.f524098b.indexOf((byte) 0);
        if (r112 == (-1)) goto L42;
        if (r111 == false) goto L40;
        b(this.f524098b.f524010b, 0, r112 + 1);
    L40:
        this.f524098b.skip(r112 + 1);
        goto L44
    L42:
        throw new EOFException();
    L44:
        if (((r110 >> 4) & 1) != 1) goto L46;
        boolean r104 = true;
    L47:
        if (r104 == false) goto L55;
        long r113 = this.f524098b.indexOf((byte) 0);
        if (r113 == (-1)) goto L54;
        if (r111 == false) goto L52;
        b(this.f524098b.f524010b, 0, r113 + 1);
    L52:
        this.f524098b.skip(r113 + 1);
        goto L55
    L54:
        throw new EOFException();
    L55:
        if (r111 == false) goto L57;
        a("FHCRC", this.f524098b.readShortLe(), (short) this.f524101e.getValue());
        this.f524101e.reset();
    L57:
        this.f524097a = 1;
        goto L59
    L46:
        r104 = false;
        goto L47
    L33:
        r103 = false;
        goto L35
    L20:
        r101 = false;
        goto L21
    L14:
        r111 = false;
    L59:
        if (this.f524097a != 1) goto L66;
        long r105 = r210.size();
        long r106 = this.f524100d.read(r210, r211);
        if (r106 == (-1)) goto L64;
        b(r210, r105, r106);
        return r106;
    L64:
        this.f524097a = 2;
    L66:
        if (this.f524097a != 2) goto L72;
        a("CRC", this.f524098b.readIntLe(), (int) this.f524101e.getValue());
        a("ISIZE", this.f524098b.readIntLe(), (int) this.f524099c.getBytesWritten());
        this.f524097a = 3;
        if (this.f524098b.exhausted() == true) goto L72;
        throw new IOException("gzip finished without exhausting source");
    L72:
        return -1;
    L74:
        throw new IllegalArgumentException(("byteCount < 0: " + r211).toString());
    L5:
        r100 = false;
        goto L6
    }

    public static void a(String r100, int r101, int r102) {
        if (r102 != r101) goto L5;
        return;
    L5:
        throw new IOException(r100 + ": actual 0x" + StringsKt.padStart(b.f(r102), 8, '0') + " != expected 0x" + StringsKt.padStart(b.f(r101), 8, '0'));
    }

    public final void b(Buffer r100, long r101, long r102) {
        g0 r103 = r100.head;
        Intrinsics.checkNotNull(r103);
    L3:
        int r104 = r103.f524019c;
        int r105 = r103.f524018b;
        if (r101 < (r104 - r105)) goto L7;
        r101 = r101 - ((long) (r104 - r105));
        r103 = r103.f524022f;
        Intrinsics.checkNotNull(r103);
    L7:
        if (r102 <= 0) goto L9;
        int r106 = (int) (((long) r103.f524018b) + r101);
        int r107 = (int) Math.min(r103.f524019c - r106, r102);
        this.f524101e.update(r103.f524017a, r106, r107);
        r102 = r102 - ((long) r107);
        r103 = r103.f524022f;
        Intrinsics.checkNotNull(r103);
        r101 = 0;
        goto L7
    }
}
