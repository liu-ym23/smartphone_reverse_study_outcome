package com.heytap.msp.push.encrypt;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;

/* JADX INFO: loaded from: classes23.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f276449a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f276450b = 76;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f276451c = 64;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final int f276452d = 255;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final byte f276453e = 61;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f276454m = 8192;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final byte f276455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final int f276456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected byte[] f276457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f276458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f276459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f276460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f276461l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f276462n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f276463o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f276464p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f276465q;

    public b(int r100, int r101, int r102, int r103) {
        this.f276455f = 61;
        this.f276462n = r100;
        this.f276463o = r101;
        if (r102 <= 0) goto L6;
        if (r103 <= 0) goto L6;
        int r104 = (r102 / r101) * r101;
    L7:
        this.f276456g = r104;
        this.f276464p = r103;
        return;
    L6:
        r104 = 0;
        goto L7
    }

    private void a() {
        byte[] r100 = this.f276457h;
        if (r100 != null) goto L5;
        this.f276457h = new byte[d()];
        this.f276458i = 0;
        this.f276465q = 0;
        return;
    L5:
        byte[] r101 = new byte[r100.length * 2];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        this.f276457h = r101;
    }

    public static boolean c(byte r100) {
        if (r100 != 9) goto L5;
        return true;
    L5:
        if (r100 != 10) goto L7;
        return true;
    L7:
        if (r100 != 13) goto L9;
        return true;
    L9:
        if (r100 == 32) goto L16;
        return false;
    L16:
        return true;
    }

    private void e() {
        this.f276457h = null;
        this.f276458i = 0;
        this.f276465q = 0;
        this.f276460k = 0;
        this.f276461l = 0;
        this.f276459j = false;
    }

    public void a(int r100) {
        byte[] r101 = this.f276457h;
        if (r101 != null) goto L5;
    L6:
        a();
        return;
    L5:
        if (r101.length < (this.f276458i + r100)) goto L6;
    }

    public abstract void a(byte[] r100, int r101, int r102);

    public abstract void b(byte[] r100, int r101, int r102);

    public boolean b() {
        if (this.f276457h == null) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract boolean b(byte r100);

    public boolean b(byte[] r100, boolean r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L14;
        if (b(r100[r102]) == true) goto L13;
        if (r101 == false) goto L12;
        byte r103 = r100[r102];
        if (r103 == 61) goto L13;
        if (c(r103) == true) goto L13;
    L12:
        return false;
    L13:
        r102 = r102 + 1;
        goto L4
    L14:
        return true;
    }

    public int c() {
        if (this.f276457h != null) goto L7;
        return 0;
    L7:
        return this.f276458i - this.f276465q;
    }

    public int c(byte[] r100, int r101, int r102) {
        if (this.f276457h == null) goto L9;
        int r103 = Math.min(c(), r102);
        System.arraycopy(this.f276457h, this.f276465q, r100, r101, r103);
        int r104 = this.f276465q + r103;
        this.f276465q = r104;
        if (r104 < this.f276458i) goto L7;
        this.f276457h = null;
    L7:
        return r103;
    L9:
        if (this.f276459j == false) goto L11;
        return -1;
    L11:
        return 0;
    }

    public byte[] c(String r100) {
        return decode(StringUtils.getBytesUtf8(r100));
    }

    public int d() {
        return 8192;
    }

    public boolean d(String r100) {
        return b(StringUtils.getBytesUtf8(r100), true);
    }

    public Object decode(Object r100) {
        if ((r100 instanceof byte[]) == false) goto L7;
        return decode((byte[]) r100);
    L7:
        if ((r100 instanceof String) == false) goto L11;
        return c((String) r100);
    L11:
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    public byte[] decode(byte[] r100) {
        e();
        if (r100 != null) goto L5;
    L9:
        return r100;
    L5:
        if (r100.length == 0) goto L9;
        b(r100, 0, r100.length);
        b(r100, 0, -1);
        int r101 = this.f276458i;
        byte[] r102 = new byte[r101];
        c(r102, 0, r101);
        return r102;
    }

    public Object encode(Object r100) {
        if ((r100 instanceof byte[]) == false) goto L7;
        return encode((byte[]) r100);
    L7:
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    public byte[] encode(byte[] r100) {
        e();
        if (r100 != null) goto L5;
    L9:
        return r100;
    L5:
        if (r100.length == 0) goto L9;
        a(r100, 0, r100.length);
        a(r100, 0, -1);
        int r101 = this.f276458i - this.f276465q;
        byte[] r102 = new byte[r101];
        c(r102, 0, r101);
        return r102;
    }

    public String j(byte[] r100) {
        return StringUtils.newStringUtf8(encode(r100));
    }

    public String k(byte[] r100) {
        return StringUtils.newStringUtf8(encode(r100));
    }

    public boolean l(byte[] r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L15;
        byte r103 = r100[r102];
        if (61 == r103) goto L13;
        if (b(r103) == true) goto L19;
        r102 = r102 + 1;
        goto L6
    L19:
        return true;
    L13:
        return true;
    L15:
        return false;
    }

    public long m(byte[] r100) {
        int r101 = r100.length;
        int r102 = this.f276462n;
        long r103 = ((long) (((r101 + r102) - 1) / r102)) * ((long) this.f276463o);
        int r104 = this.f276456g;
        if (r104 > 0) goto L5;
        return r103;
    L5:
        return r103 + ((((((long) r104) + r103) - 1) / ((long) r104)) * ((long) this.f276464p));
    }
}
