package rj4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f538006h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f538007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f538008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f538009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte f538010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte f538011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte f538012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ByteBuffer f538013g;

    public final synchronized byte b() {
        monitor-enter(this);
        byte r100 = this.f538012f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int c() {
        monitor-enter(this);
        int r100 = (((this.f538011e << 24) | (this.f538010d << 16)) | (this.f538012f << 8)) | this.f538008b.c();
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized byte d() {
        monitor-enter(this);
        byte r100 = this.f538011e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int e() {
        monitor-enter(this);
        short r100 = this.f538008b.f();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized byte f() {
        monitor-enter(this);
        byte r100 = this.f538010d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int g() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f538008b.j() == false) goto L6;
        int r100 = this.f538008b.h();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = this.f538008b.e();     // Catch: Throwable -> L9
        goto L7
    }

    public final synchronized boolean h() {
        monitor-enter(this);
        boolean r100 = this.f538008b.i();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean i() {
        monitor-enter(this);
        boolean r100 = this.f538008b.j();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean j() {
        monitor-enter(this);
        boolean r100 = this.f538008b.k();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean k() {
        monitor-enter(this);
        boolean r100 = this.f538008b.f538036u;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void l() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.f538009c == false) goto L9;
        qj4.a.b(f538006h, "send is not for recv packet");     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L9:
        if (this.f538013g.hasRemaining() == false) goto L17;
        ByteBuffer r100 = ByteBuffer.allocate(800);     // Catch: Throwable -> L19
        r100.order(ByteOrder.BIG_ENDIAN);     // Catch: Throwable -> L19
        this.f538008b.a(r100, (short) this.f538013g.position());     // Catch: Throwable -> L19
        if (this.f538013g.remaining() <= r100.remaining()) goto L14;
        byte[] r101 = new byte[r100.remaining()];     // Catch: Throwable -> L19
    L13:
        byte[] r102 = r101;
        this.f538013g.get(r102);     // Catch: Throwable -> L19
        qj4.a.c(f538006h, "#RTC send payload: [" + r102.length + "]" + pk4.d.a(r102));     // Catch: Throwable -> L19
        r100.put(r102);     // Catch: Throwable -> L19
        this.f538008b.n((short) r100.position(), r100);     // Catch: Throwable -> L19
        this.f538007a.b(this.f538011e, this.f538010d, this.f538012f, r102, (short) r102.length);     // Catch: Throwable -> L19
        goto L9
    L14:
        r101 = new byte[this.f538013g.remaining()];     // Catch: Throwable -> L19
        this.f538008b.m(r100);     // Catch: Throwable -> L19
        goto L13
    L17:
        monitor-exit(this);
    }

    static {
        f538006h = a.class.getSimpleName();
    }

    public final synchronized void a(ByteBuffer r100) {
        monitor-enter(this);
        r100.put(this.f538013g);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public a(byte[] r100, short r101) {
        this.f538007a = e.a();
        this.f538009c = false;
        this.f538009c = true;
        ByteBuffer r102 = ByteBuffer.wrap(r100, 0, r101);
        this.f538013g = r102;
        r102.order(ByteOrder.BIG_ENDIAN);
        b r103 = new b(r102);
        this.f538008b = r103;
        monitor-enter(r103);
        byte r104 = r103.f538019d;     // Catch: Throwable -> L8
        monitor-exit(r103);
        this.f538011e = r104;
        this.f538010d = r103.g();
        this.f538012f = r103.b();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public a(byte[] r100, short r101, byte r110) {
        this.f538007a = e.a();
        this.f538009c = false;
        this.f538013g = ByteBuffer.wrap(r100);
        this.f538010d = 48;
        this.f538011e = 48;
        this.f538012f = r110;
        b r102 = new b(r101, r110);
        this.f538008b = r102;
        monitor-enter(a.class);
        int r103 = 0;
        int r104 = 65535;
    L5:
        if (r103 >= r101) goto L18;
        r104 = r104 ^ (r100[r103] & UByte.MAX_VALUE);
        int r105 = 0;
    L9:
        if (r105 >= 8) goto L14;
        int r106 = r104 & 1;
        int r107 = r104 >> 1;
        if (r106 == 0) goto L13;
        r107 = r107 ^ 40961;
    L13:
        r104 = r107 & 65535;
        r105 = r105 + 1;
        goto L9
    L14:
        r103 = r103 + 1;
    L15:
        th = move-exception;
        throw th;
    L18:
        monitor-exit(a.class);
        r102.l((short) r104);
    }
}
