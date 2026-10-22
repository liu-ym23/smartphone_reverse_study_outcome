package com.xiaomi.push;

import java.io.InputStream;
import java.util.Vector;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f463163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final InputStream f259a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final byte[] f260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f463164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f463165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f463166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f463167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f463168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f463169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f463170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f463171i;

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public long m8843c() {
        int r100 = 0;
        long r101 = 0;
    L4:
        if (r100 >= 64) goto L10;
        byte r102 = a();
        r101 = r101 | (((long) (r102 & ByteCompanionObject.MAX_VALUE)) << r100);
        if ((r102 & ByteCompanionObject.MIN_VALUE) == 0) goto L7;
        r100 = r100 + 7;
        goto L4
    L7:
        return r101;
    L10:
        throw d.c();
    }

    private void b() {
        int r100 = this.f463163a + this.f463164b;
        this.f463163a = r100;
        int r101 = this.f463167e + r100;
        int r102 = this.f463168f;
        if (r101 <= r102) goto L5;
        int r103 = r101 - r102;
        this.f463164b = r103;
        this.f463163a = r100 - r103;
        return;
    L5:
        this.f463164b = 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m8834a() {
        int r100 = d();
        int r101 = this.f463163a;
        int r102 = this.f463165c;
        if (r100 > (r101 - r102)) goto L8;
        if (r100 <= 0) goto L8;
        String r103 = new String(this.f260a, r102, r100, "UTF-8");
        this.f463165c += r100;
        return r103;
    L8:
        return new String(m8839a(r100), "UTF-8");
    }

    public int d() {
        byte r100 = a();
        if (r100 < 0) goto L5;
        return r100;
    L5:
        int r101 = r100 & ByteCompanionObject.MAX_VALUE;
        byte r102 = a();
        if (r102 < 0) goto L9;
        int r103 = r102 << 7;
    L26:
        return r101 | r103;
    L9:
        r101 = r101 | ((r102 & ByteCompanionObject.MAX_VALUE) << 7);
        byte r104 = a();
        if (r104 < 0) goto L12;
        r103 = r104 << 14;
        goto L26
    L12:
        r101 = r101 | ((r104 & ByteCompanionObject.MAX_VALUE) << 14);
        byte r105 = a();
        if (r105 < 0) goto L15;
        r103 = r105 << 21;
        goto L26
    L15:
        int r106 = r101 | ((r105 & ByteCompanionObject.MAX_VALUE) << 21);
        byte r107 = a();
        int r108 = r106 | (r107 << 28);
        if (r107 >= 0) goto L29;
        int r109 = 0;
    L19:
        if (r109 >= 5) goto L25;
        if (a() >= 0) goto L22;
        r109 = r109 + 1;
        goto L19
    L22:
        return r108;
    L25:
        throw d.c();
    L29:
        return r108;
    }

    public int e() {
        byte r100 = a();
        byte r101 = a();
        byte r102 = a();
        byte r103 = a();
        return (((r100 & UByte.MAX_VALUE) | ((r101 & UByte.MAX_VALUE) << 8)) | ((r102 & UByte.MAX_VALUE) << 16)) | ((r103 & UByte.MAX_VALUE) << 24);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public a m8833a() {
        int r100 = d();
        int r101 = this.f463163a;
        int r102 = this.f463165c;
        if (r100 > (r101 - r102)) goto L8;
        if (r100 <= 0) goto L8;
        a r103 = a.a(this.f260a, r102, r100);
        this.f463165c += r100;
        return r103;
    L8:
        return a.a(m8839a(r100));
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m8842b() {
        if (this.f463165c == this.f463163a) goto L5;
        return false;
    L5:
        if (a(false) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public int c() {
        return d();
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public long m8844d() {
        byte r100 = a();
        byte r101 = a();
        byte r102 = a();
        byte r103 = a();
        byte r104 = a();
        byte r105 = a();
        byte r106 = a();
        long r107 = ((long) r100) & 255;
        return ((((((((((long) r101) & 255) << 8) | r107) | ((((long) r102) & 255) << 16)) | ((((long) r103) & 255) << 24)) | ((((long) r104) & 255) << 32)) | ((((long) r105) & 255) << 40)) | ((((long) r106) & 255) << 48)) | ((((long) a()) & 255) << 56);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m8831a() {
        if (m8842b() == false) goto L6;
        this.f463166d = 0;
        return 0;
    L6:
        int r100 = d();
        this.f463166d = r100;
        if (r100 == 0) goto L10;
        return r100;
    L10:
        throw d.d();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public int m8840b() {
        return d();
    }

    public byte a() {
        if (this.f463165c != this.f463163a) goto L5;
        a(true);
    L5:
        byte[] r100 = this.f260a;
        int r101 = this.f463165c;
        this.f463165c = r101 + 1;
        return r100[r101];
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public long m8841b() {
        return m8843c();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8835a() {
    L2:
        int r100 = m8831a();
        if (r100 == 0) goto L6;
        if (m8838a(r100) == true) goto L2;
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8837a() {
        if (d() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m8832a() {
        return m8843c();
    }

    private b(InputStream r100) {
        this.f463168f = Integer.MAX_VALUE;
        this.f463170h = 64;
        this.f463171i = 67108864;
        this.f260a = new byte[4096];
        this.f463163a = 0;
        this.f463165c = 0;
        this.f259a = r100;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m8839a(int r110) {
        if (r110 < 0) goto L38;
        int r100 = this.f463167e;
        int r101 = this.f463165c;
        int r102 = (r100 + r101) + r110;
        int r103 = this.f463168f;
        if (r102 > r103) goto L35;
        int r104 = this.f463163a;
        if (r110 > (r104 - r101)) goto L10;
        byte[] r105 = new byte[r110];
        System.arraycopy(this.f260a, r101, r105, 0, r110);
        this.f463165c += r110;
        return r105;
    L10:
        if (r110 >= 4096) goto L17;
        byte[] r106 = new byte[r110];
        int r107 = r104 - r101;
        System.arraycopy(this.f260a, r101, r106, 0, r107);
        this.f463165c = this.f463163a;
        a(true);
    L12:
        int r108 = r110 - r107;
        int r109 = this.f463163a;
        if (r108 <= r109) goto L15;
        System.arraycopy(this.f260a, 0, r106, r107, r109);
        int r111 = this.f463163a;
        r107 = r107 + r111;
        this.f463165c = r111;
        a(true);
        goto L12
    L15:
        System.arraycopy(this.f260a, 0, r106, r107, r108);
        this.f463165c = r108;
        return r106;
    L17:
        this.f463167e = r100 + r104;
        this.f463165c = 0;
        this.f463163a = 0;
        int r112 = r104 - r101;
        int r113 = r110 - r112;
        Vector r114 = new Vector();
    L18:
        if (r113 <= 0) goto L30;
        int r115 = Math.min(r113, 4096);
        byte[] r116 = new byte[r115];
        int r117 = 0;
    L20:
        if (r117 >= r115) goto L29;
        InputStream r118 = this.f259a;
        if (r118 != null) goto L24;
        int r119 = -1;
    L25:
        if (r119 == (-1)) goto L28;
        this.f463167e += r119;
        r117 = r117 + r119;
        goto L20
    L28:
        throw d.a();
    L24:
        r119 = r118.read(r116, r117, r115 - r117);
        goto L25
    L29:
        r113 = r113 - r115;
        r114.addElement(r116);
        goto L18
    L30:
        byte[] r120 = new byte[r110];
        System.arraycopy(this.f260a, r101, r120, 0, r112);
        int r121 = 0;
    L32:
        if (r121 >= r114.size()) goto L34;
        byte[] r122 = (byte[]) r114.elementAt(r121);
        System.arraycopy(r122, 0, r120, r112, r122.length);
        r112 = r112 + r122.length;
        r121 = r121 + 1;
        goto L32
    L34:
        return r120;
    L35:
        c((r103 - r100) - r101);
        throw d.a();
    L38:
        throw d.b();
    }

    public void b(int r100) {
        this.f463168f = r100;
        b();
    }

    public void c(int r100) {
        if (r100 < 0) goto L22;
        int r101 = this.f463167e;
        int r102 = this.f463165c;
        int r103 = (r101 + r102) + r100;
        int r104 = this.f463168f;
        if (r103 > r104) goto L19;
        int r105 = this.f463163a;
        if (r100 > (r105 - r102)) goto L8;
        this.f463165c = r102 + r100;
        return;
    L8:
        int r106 = r105 - r102;
        this.f463167e = r101 + r105;
        this.f463165c = 0;
        this.f463163a = 0;
    L9:
        if (r106 >= r100) goto L25;
        InputStream r107 = this.f259a;
        if (r107 != null) goto L13;
        int r108 = -1;
    L14:
        if (r108 <= 0) goto L17;
        r106 = r106 + r108;
        this.f463167e += r108;
        goto L9
    L17:
        throw d.a();
    L13:
        r108 = (int) r107.skip(r100 - r106);
        goto L14
    L25:
        return;
    L19:
        c((r104 - r101) - r102);
        throw d.a();
    L22:
        throw d.b();
    }

    private boolean a(boolean r100) {
        int r101 = this.f463165c;
        int r102 = this.f463163a;
        if (r101 < r102) goto L33;
        int r103 = this.f463167e;
        if ((r103 + r102) != this.f463168f) goto L10;
        if (r100 == true) goto L9;
        return false;
    L9:
        throw d.a();
    L10:
        this.f463167e = r103 + r102;
        this.f463165c = 0;
        InputStream r104 = this.f259a;
        if (r104 != null) goto L13;
        int r105 = -1;
    L14:
        this.f463163a = r105;
        if (r105 == 0) goto L31;
        if (r105 < (-1)) goto L31;
        if (r105 != (-1)) goto L23;
        this.f463163a = 0;
        if (r100 == true) goto L22;
        return false;
    L22:
        throw d.a();
    L23:
        b();
        int r106 = (this.f463167e + this.f463163a) + this.f463164b;
        if (r106 > this.f463171i) goto L29;
        if (r106 < 0) goto L29;
        return true;
    L29:
        throw d.h();
    L31:
        throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f463163a + "\nThe InputStream implementation is buggy.");
    L13:
        r105 = r104.read(this.f260a);
        goto L14
    L33:
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8838a(int r100) {
        int r101 = f.a(r100);
        if (r101 == 0) goto L24;
        if (r101 != 1) goto L6;
        m8844d();
        return true;
    L6:
        if (r101 != 2) goto L8;
        c(d());
        return true;
    L8:
        if (r101 == 3) goto L18;
        if (r101 != 4) goto L11;
        return false;
    L11:
        if (r101 != 5) goto L15;
        e();
        return true;
    L15:
        throw d.f();
    L18:
        m8835a();
        m8836a(f.a(f.b(r100), 4));
        return true;
    L24:
        m8840b();
        return true;
    }

    public void a(e r100) {
        int r101 = d();
        if (this.f463169g >= this.f463170h) goto L7;
        int r102 = a(r101);
        this.f463169g++;
        r100.a(this);
        m8836a(0);
        this.f463169g--;
        b(r102);
        return;
    L7:
        throw d.g();
    }

    public int a(int r100) {
        if (r100 < 0) goto L10;
        int r101 = r100 + (this.f463167e + this.f463165c);
        int r102 = this.f463168f;
        if (r101 > r102) goto L8;
        this.f463168f = r101;
        b();
        return r102;
    L8:
        throw d.a();
    L10:
        throw d.b();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8836a(int r100) {
        if (this.f463166d != r100) goto L6;
        return;
    L6:
        throw d.e();
    }

    public static b a(InputStream r100) {
        return new b(r100);
    }

    private b(byte[] r100, int r101, int r102) {
        this.f463168f = Integer.MAX_VALUE;
        this.f463170h = 64;
        this.f463171i = 67108864;
        this.f260a = r100;
        this.f463163a = r102 + r101;
        this.f463165c = r101;
        this.f259a = null;
    }

    public static b a(byte[] r100, int r101, int r102) {
        return new b(r100, r101, r102);
    }
}
