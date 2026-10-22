package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes41.dex */
public class hv extends hz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ie f464085a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected int f944a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected boolean f945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f464086b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private byte[] f947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f464087c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private byte[] f948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f464088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f464089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f464090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f464091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f464092h;

    public static class a implements ib {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f464093a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected boolean f949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected boolean f464094b;

        public a() {
            this(false, true);
        }

        @Override // com.xiaomi.push.ib
        public hz a(ij r100) {
            hv r101 = new hv(r100, this.f949a, this.f464094b);
            int r102 = this.f464093a;
            if (r102 == 0) goto L5;
            r101.b(r102);
        L5:
            return r101;
        }

        public a(boolean r100, boolean r101) {
            this(r100, r101, 0);
        }

        public a(boolean r100, boolean r101, int r102) {
            this.f949a = r100;
            this.f464094b = r101;
            this.f464093a = r102;
        }
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo9279a() {
    }

    @Override // com.xiaomi.push.hz
    public void a(ie r100) {
    }

    @Override // com.xiaomi.push.hz
    public void b() {
    }

    @Override // com.xiaomi.push.hz
    public void c() {
        a((byte) 0);
    }

    @Override // com.xiaomi.push.hz
    public void d() {
    }

    @Override // com.xiaomi.push.hz
    public void e() {
    }

    @Override // com.xiaomi.push.hz
    public void f() {
    }

    @Override // com.xiaomi.push.hz
    public void g() {
    }

    @Override // com.xiaomi.push.hz
    public void h() {
    }

    @Override // com.xiaomi.push.hz
    public void i() {
    }

    @Override // com.xiaomi.push.hz
    public void j() {
    }

    static {
        f464085a = new ie();
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long mo9270a() {
        byte[] r100 = this.f464092h;
        if (this.f464099a.b() < 8) goto L5;
        r100 = this.f464099a.a();
        int r101 = this.f464099a.a_();
        this.f464099a.a(8);
    L6:
        long r102 = ((((((((long) (r100[r101] & UByte.MAX_VALUE)) << 56) | (((long) (r100[r101 + 1] & UByte.MAX_VALUE)) << 48)) | (((long) (r100[r101 + 2] & UByte.MAX_VALUE)) << 40)) | (((long) (r100[r101 + 3] & UByte.MAX_VALUE)) << 32)) | (((long) (r100[r101 + 4] & UByte.MAX_VALUE)) << 24)) | (((long) (r100[r101 + 5] & UByte.MAX_VALUE)) << 16)) | (((long) (r100[r101 + 6] & UByte.MAX_VALUE)) << 8);
        return ((long) (r100[r101 + 7] & UByte.MAX_VALUE)) | r102;
    L5:
        a(this.f464092h, 0, 8);
        r101 = 0;
        goto L6
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int mo9269a() {
        byte[] r100 = this.f464091g;
        if (this.f464099a.b() < 4) goto L5;
        r100 = this.f464099a.a();
        int r101 = this.f464099a.a_();
        this.f464099a.a(4);
    L6:
        int r102 = (((r100[r101] & UByte.MAX_VALUE) << 24) | ((r100[r101 + 1] & UByte.MAX_VALUE) << 16)) | ((r100[r101 + 2] & UByte.MAX_VALUE) << 8);
        return (r100[r101 + 3] & UByte.MAX_VALUE) | r102;
    L5:
        a(this.f464091g, 0, 4);
        r101 = 0;
        goto L6
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public short mo9278a() {
        byte[] r100 = this.f464090f;
        if (this.f464099a.b() < 2) goto L5;
        r100 = this.f464099a.a();
        int r101 = this.f464099a.a_();
        this.f464099a.a(2);
    L6:
        int r102 = (r100[r101] & UByte.MAX_VALUE) << 8;
        return (short) ((r100[r101 + 1] & UByte.MAX_VALUE) | r102);
    L5:
        a(this.f464090f, 0, 2);
        r101 = 0;
        goto L6
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo9276a() {
        int r100 = mo9269a();
        if (this.f464099a.b() < r100) goto L9;
        String r101 = new String(this.f464099a.a(), this.f464099a.a_(), r100, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
        this.f464099a.a(r100);     // Catch: UnsupportedEncodingException -> L6
        return r101;
    L7:
        throw new ht("JVM DOES NOT SUPPORT UTF-8");
    L9:
        return a(r100);
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo9277a() {
        int r100 = mo9269a();
        c(r100);
        if (this.f464099a.b() < r100) goto L6;
        ByteBuffer r101 = ByteBuffer.wrap(this.f464099a.a(), this.f464099a.a_(), r100);
        this.f464099a.a(r100);
        return r101;
    L6:
        byte[] r102 = new byte[r100];
        this.f464099a.b(r102, 0, r100);
        return ByteBuffer.wrap(r102);
    }

    @Override // com.xiaomi.push.hz
    public byte a() {
        if (this.f464099a.b() < 1) goto L6;
        byte r100 = this.f464099a.a()[this.f464099a.a_()];
        this.f464099a.a(1);
        return r100;
    L6:
        a(this.f464089e, 0, 1);
        return this.f464089e[0];
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hw mo9271a() {
        byte r100 = a();
        if (r100 != 0) goto L5;
        short r101 = 0;
    L7:
        return new hw("", r100, r101);
    L5:
        r101 = mo9278a();
        goto L7
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hy mo9273a() {
        return new hy(a(), a(), mo9269a());
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hx mo9272a() {
        return new hx(a(), mo9269a());
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public id mo9274a() {
        return new id(a(), mo9269a());
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo9281a() {
        if (a() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public double mo9268a() {
        return Double.longBitsToDouble(mo9270a());
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ie mo9275a() {
        return f464085a;
    }

    @Override // com.xiaomi.push.hz
    public void a(long r100) {
        byte[] r101 = this.f464088d;
        r101[0] = (byte) ((r100 >> 56) & 255);
        r101[1] = (byte) ((r100 >> 48) & 255);
        r101[2] = (byte) ((r100 >> 40) & 255);
        r101[3] = (byte) ((r100 >> 32) & 255);
        r101[4] = (byte) ((r100 >> 24) & 255);
        r101[5] = (byte) ((r100 >> 16) & 255);
        r101[6] = (byte) ((r100 >> 8) & 255);
        r101[7] = (byte) (r100 & 255);
        this.f464099a.mo9290a(r101, 0, 8);
    }

    public void b(int r100) {
        this.f944a = r100;
        this.f464087c = true;
    }

    public void c(int r100) {
        if (r100 < 0) goto L12;
        if (this.f464087c == false) goto L10;
        int r101 = this.f944a - r100;
        this.f944a = r101;
        if (r101 < 0) goto L9;
        return;
    L9:
        throw new ht("Message length exceeded: " + r100);
    L10:
        return;
    L12:
        throw new ht("Negative length: " + r100);
    }

    @Override // com.xiaomi.push.hz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo9280a(int r100) {
        byte[] r101 = this.f948c;
        r101[0] = (byte) ((r100 >> 24) & 255);
        r101[1] = (byte) ((r100 >> 16) & 255);
        r101[2] = (byte) ((r100 >> 8) & 255);
        r101[3] = (byte) (r100 & 255);
        this.f464099a.mo9290a(r101, 0, 4);
    }

    @Override // com.xiaomi.push.hz
    public void a(ByteBuffer r100) {
        int r101 = (r100.limit() - r100.position()) - r100.arrayOffset();
        mo9280a(r101);
        this.f464099a.mo9290a(r100.array(), r100.position() + r100.arrayOffset(), r101);
    }

    public String a(int r100) {
        c(r100);     // Catch: UnsupportedEncodingException -> L4
        byte[] r101 = new byte[r100];     // Catch: UnsupportedEncodingException -> L4
        this.f464099a.b(r101, 0, r100);     // Catch: UnsupportedEncodingException -> L4
        return new String(r101, "UTF-8");
    L5:
        throw new ht("JVM DOES NOT SUPPORT UTF-8");
    }

    @Override // com.xiaomi.push.hz
    public void a(String r100) {
        byte[] r101 = r100.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L4
        mo9280a(r101.length);     // Catch: UnsupportedEncodingException -> L4
        this.f464099a.mo9290a(r101, 0, r101.length);     // Catch: UnsupportedEncodingException -> L4
        return;
    L5:
        throw new ht("JVM DOES NOT SUPPORT UTF-8");
    }

    @Override // com.xiaomi.push.hz
    public void a(short r100) {
        byte[] r101 = this.f947b;
        r101[0] = (byte) ((r100 >> 8) & 255);
        r101[1] = (byte) (r100 & 255);
        this.f464099a.mo9290a(r101, 0, 2);
    }

    @Override // com.xiaomi.push.hz
    public void a(hy r100) {
        a(r100.f464097a);
        a(r100.f464098b);
        mo9280a(r100.f953a);
    }

    @Override // com.xiaomi.push.hz
    public void a(byte r100) {
        byte[] r101 = this.f946a;
        r101[0] = r100;
        this.f464099a.mo9290a(r101, 0, 1);
    }

    @Override // com.xiaomi.push.hz
    public void a(hw r100) {
        a(r100.f464095a);
        a(r100.f951a);
    }

    @Override // com.xiaomi.push.hz
    public void a(hx r100) {
        a(r100.f464096a);
        mo9280a(r100.f952a);
    }

    @Override // com.xiaomi.push.hz
    public void a(boolean r100) {
        a(r100 ? 1 : 0);
    }

    public hv(ij r100, boolean r101, boolean r102) {
        super(r100);
        this.f464087c = false;
        this.f946a = new byte[1];
        this.f947b = new byte[2];
        this.f948c = new byte[4];
        this.f464088d = new byte[8];
        this.f464089e = new byte[1];
        this.f464090f = new byte[2];
        this.f464091g = new byte[4];
        this.f464092h = new byte[8];
        this.f945a = r101;
        this.f464086b = r102;
    }

    private int a(byte[] r100, int r101, int r102) {
        c(r102);
        return this.f464099a.b(r100, r101, r102);
    }
}
