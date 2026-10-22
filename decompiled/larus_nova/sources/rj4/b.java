package rj4;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f538014v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final AtomicInteger f538015w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f538016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f538017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f538018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte f538019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte f538020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte f538021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public short f538022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte f538023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte f538024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public short f538025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public short f538026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public short f538027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final short f538028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final byte f538029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final byte f538030o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final byte f538031p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final byte f538032q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final byte f538033r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final byte[] f538034s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f538035t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f538036u;

    public final synchronized byte b() {
        monitor-enter(this);
        byte r100 = this.f538021f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized byte c() {
        monitor-enter(this);
        byte r100 = (byte) (this.f538024i & ByteCompanionObject.MAX_VALUE);
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized short d() {
        monitor-enter(this);
        short r100 = this.f538025j;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int e() {
        monitor-enter(this);
        int r100 = this.f538016a - this.f538035t;
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized short f() {
        monitor-enter(this);
        short r100 = this.f538022g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized byte g() {
        monitor-enter(this);
        byte r100 = this.f538020e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized short h() {
        monitor-enter(this);
        short r100 = this.f538028m;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean i() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (j() == false) goto L9;
        boolean r100 = true;
        if (this.f538025j != 1) goto L9;
    L10:
        monitor-exit(this);
        return r100;
    L9:
        r100 = false;
        goto L10
    }

    public final synchronized boolean j() {
        monitor-enter(this);
        boolean r100 = true;
        if ((this.f538018c & 1) != 0) goto L8;
        r100 = false;
    L8:
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean k() {
        monitor-enter(this);
        if ((this.f538024i & ByteCompanionObject.MIN_VALUE) == 0) goto L7;
        boolean r100 = true;
    L8:
        monitor-exit(this);
        return r100;
    L7:
        r100 = false;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        f538014v = b.class.getSimpleName();
        f538015w = new AtomicInteger(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(ByteBuffer r100) {
        this.f538017b = 2;
        boolean r101 = false;
        this.f538035t = 0;
        this.f538036u = true;
        short r102 = r100.getShort();
        String r103 = f538014v;
        if (r102 == 23130) goto L6;
        qj4.a.b(r103, "BWDLPacketHeader sof " + r102 + " is not valid");
        this.f538036u = false;
        return;
    L6:
        short r104 = r100.getShort();
        this.f538016a = r104;
        if (r104 <= 800) goto L10;
        qj4.a.b(r103, "BWDLPacketHeader length " + this.f538016a + " is not valid");
        this.f538036u = false;
        return;
    L10:
        this.f538017b = r100.get();
        this.f538018c = r100.get();
        this.f538019d = r100.get();
        this.f538020e = r100.get();
        this.f538021f = r100.get();
        this.f538022g = r100.getShort();
        this.f538023h = r100.get();
        if (j() == false) goto L16;
        this.f538024i = r100.get();
        this.f538025j = r100.getShort();
        this.f538026k = r100.getShort();
        if (this.f538025j != 1) goto L16;
        this.f538027l = r100.getShort();
        this.f538028m = r100.getShort();
    L16:
        if ((this.f538018c & 4) == 0) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L22;
        this.f538029n = r100.get();
    L22:
        if ((this.f538018c & 8) == 0) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == false) goto L28;
        this.f538030o = r100.get();
    L28:
        if ((this.f538018c & ByteCompanionObject.MIN_VALUE) == 0) goto L30;
        r101 = true;
    L30:
        if (r101 == false) goto L32;
        this.f538031p = r100.get();
        this.f538032q = r100.get();
        int r107 = r100.get();
        this.f538033r = r107;
        byte[] r108 = new byte[r107];
        this.f538034s = r108;
        r100.get(r108);
    L32:
        this.f538035t = r100.position();
        return;
    L24:
        r106 = false;
        goto L25
    L18:
        r105 = false;
        goto L19
    }

    public final synchronized void l(short r100) {
        monitor-enter(this);
        this.f538027l = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void m(ByteBuffer r100) {
        monitor-enter(this);
        byte r101 = (byte) (((byte) (this.f538024i & ByteCompanionObject.MAX_VALUE)) | ByteCompanionObject.MIN_VALUE);     // Catch: Throwable -> L6
        this.f538024i = r101;     // Catch: Throwable -> L6
        r100.put(12, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public b(short r100, byte r101) {
        this.f538017b = 2;
        this.f538035t = 0;
        this.f538036u = true;
        this.f538028m = r100;
        if (r100 != 0) goto L5;
        this.f538018c = (byte) (this.f538018c | 8);
    L5:
        this.f538019d = 48;
        this.f538020e = 48;
        this.f538021f = r101;
        this.f538024i = (byte) (((byte) (f538015w.getAndIncrement() & 127)) & ByteCompanionObject.MAX_VALUE);
    }

    public final synchronized void a(ByteBuffer r100, short r101) {
        monitor-enter(this);
        this.f538026k = r101;     // Catch: Throwable -> L43
        byte r102 = this.f538018c;     // Catch: Throwable -> L43
        boolean r103 = false;
        if ((r102 & 4) == 0) goto L6;
        int r104 = 1;
    L7:
        int r105 = r104 + 12;     // Catch: Throwable -> L43
        if ((r102 & 8) == 0) goto L10;
        int r106 = 1;
    L11:
        int r107 = r105 + r106;     // Catch: Throwable -> L43
        if ((r102 & ByteCompanionObject.MIN_VALUE) == 0) goto L14;
        int r108 = 1;
    L15:
        int r109 = r107 + r108;     // Catch: Throwable -> L43
        if (this.f538028m <= (800 - r109)) goto L18;
        this.f538018c = (byte) (r102 | 1);     // Catch: Throwable -> L43
    L18:
        r100.putShort(23130);     // Catch: Throwable -> L43
        r100.putShort(this.f538016a);     // Catch: Throwable -> L43
        r100.put(this.f538017b);     // Catch: Throwable -> L43
        r100.put(this.f538018c);     // Catch: Throwable -> L43
        r100.put(this.f538019d);     // Catch: Throwable -> L43
        r100.put(this.f538020e);     // Catch: Throwable -> L43
        r100.put(this.f538021f);     // Catch: Throwable -> L43
        r100.putShort(this.f538022g);     // Catch: Throwable -> L43
        this.f538022g = (short) (this.f538022g + 1);     // Catch: Throwable -> L43
        r100.put(this.f538023h);     // Catch: Throwable -> L43
        if (j() == false) goto L24;
        this.f538025j = (short) (this.f538025j + 1);     // Catch: Throwable -> L43
        r100.put(this.f538024i);     // Catch: Throwable -> L43
        r100.putShort(this.f538025j);     // Catch: Throwable -> L43
        r100.putShort(this.f538026k);     // Catch: Throwable -> L43
        if (this.f538025j != 1) goto L24;
        r100.putShort(this.f538027l);     // Catch: Throwable -> L43
        r100.putShort(this.f538028m);     // Catch: Throwable -> L43
    L24:
        if ((this.f538018c & 4) == 0) goto L26;
        boolean r110 = true;
    L27:
        if (r110 == false) goto L30;
        r100.put(this.f538029n);     // Catch: Throwable -> L43
    L30:
        if ((this.f538018c & 8) == 0) goto L32;
        boolean r111 = true;
    L33:
        if (r111 == false) goto L36;
        r100.put(this.f538030o);     // Catch: Throwable -> L43
    L36:
        if ((this.f538018c & ByteCompanionObject.MIN_VALUE) == 0) goto L38;
        r103 = true;
    L38:
        if (r103 == false) goto L40;
        r100.put(this.f538031p);     // Catch: Throwable -> L43
        r100.put(this.f538032q);     // Catch: Throwable -> L43
        r100.put(this.f538033r);     // Catch: Throwable -> L43
        r100.put(this.f538034s);     // Catch: Throwable -> L43
    L40:
        this.f538035t = r100.position();     // Catch: Throwable -> L43
        monitor-exit(this);
        return;
    L32:
        r111 = false;
        goto L33
    L26:
        r110 = false;
        goto L27
    L14:
        r108 = 0;
        goto L15
    L10:
        r106 = 0;
        goto L11
    L6:
        r104 = 0;
    L43:
        th = move-exception;
        throw th;
    }

    public final synchronized void n(short r100, ByteBuffer r101) {
        monitor-enter(this);
        this.f538016a = r100;     // Catch: Throwable -> L6
        r101.putShort(2, r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
