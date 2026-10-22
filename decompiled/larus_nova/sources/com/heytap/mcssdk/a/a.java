package com.heytap.mcssdk.a;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.math.BigInteger;
import kotlin.io.encoding.Base64;
import org.apache.commons.codec.binary.StringUtils;

/* JADX INFO: loaded from: classes23.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f276266a = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f276267m = 6;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f276268n = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f276269o = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final byte[] f276270p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final byte[] f276271q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final byte[] f276272r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f276273s = 63;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final byte[] f276274t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final byte[] f276275u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final byte[] f276276v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f276277w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f276278x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f276279y;

    static {
        f276266a = new byte[]{HTTP.CR, 10};
        f276270p = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f276271q = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        f276272r = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    }

    public a() {
        this(0);
    }

    public a(int r100) {
        this(r100, f276266a);
    }

    public a(int r100, byte[] r101) {
        this(r100, r101, false);
    }

    public a(int r100, byte[] r101, boolean r102) {
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        super(3, 4, r100, r103);
        this.f276275u = f276272r;
        if (r101 != null) goto L9;
    L14:
        this.f276278x = 4;
        this.f276276v = null;
    L15:
        this.f276277w = this.f276278x - 1;
        if (r102 == false) goto L18;
        byte[] r104 = f276271q;
    L19:
        this.f276274t = r104;
        return;
    L18:
        r104 = f276270p;
        goto L19
    L9:
        if (l(r101) == true) goto L13;
        if (r100 <= 0) goto L14;
        this.f276278x = r101.length + 4;
        byte[] r105 = new byte[r101.length];
        this.f276276v = r105;
        System.arraycopy(r101, 0, r105, 0, r101.length);
        goto L15
    L13:
        throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + StringUtils.newStringUtf8(r101) + "]");
    L5:
        r103 = r101.length;
        goto L6
    }

    public a(boolean r100) {
        this(76, f276266a, r100);
    }

    public static boolean a(byte r100) {
        if (r100 == 61) goto L11;
        if (r100 < 0) goto L10;
        byte[] r101 = f276272r;
        if (r100 >= r101.length) goto L10;
        if (r101[r100] != (-1)) goto L11;
    L10:
        return false;
    L11:
        return true;
    }

    public static boolean a(String r100) {
        return b(StringUtils.getBytesUtf8(r100));
    }

    public static boolean a(byte[] r100) {
        return b(r100);
    }

    public static byte[] a(BigInteger r100) {
        if (r100 == null) goto L6;
        return a(b(r100), false);
    L6:
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    public static byte[] a(byte[] r100, boolean r101) {
        return a(r100, r101, false);
    }

    public static byte[] a(byte[] r100, boolean r101, boolean r102) {
        return a(r100, r101, r102, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] r100, boolean r101, boolean r102, int r103) {
        if (r100 != null) goto L4;
    L15:
        return r100;
    L4:
        if (r100.length == 0) goto L15;
        if (r101 == false) goto L8;
        a r104 = new a(r102);
    L9:
        long r105 = r104.m(r100);
        if (r105 > r103) goto L14;
        return r104.encode(r100);
    L14:
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + r105 + ") than the specified maximum size of " + r103);
    L8:
        r104 = new a(0, f276266a, r102);
        goto L9
    }

    public static boolean b(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L11;
        if (a(r100[r101]) == true) goto L10;
        if (b.c(r100[r101]) == true) goto L10;
        return false;
    L10:
        r101 = r101 + 1;
        goto L4
    L11:
        return true;
    }

    public static byte[] b(String r100) {
        return new a().c(r100);
    }

    public static byte[] b(BigInteger r100) {
        int r101 = ((r100.bitLength() + 7) >> 3) << 3;
        byte[] r102 = r100.toByteArray();
        int r103 = 1;
        if ((r100.bitLength() % 8) != 0) goto L5;
    L7:
        int r104 = r102.length;
        if ((r100.bitLength() % 8) != 0) goto L10;
        r104 = r104 - 1;
    L11:
        int r105 = r101 / 8;
        int r106 = r105 - r104;
        byte[] r107 = new byte[r105];
        System.arraycopy(r102, r103, r107, r106, r104);
        return r107;
    L10:
        r103 = 0;
        goto L11
    L5:
        if (((r100.bitLength() / 8) + 1) != (r101 / 8)) goto L7;
        return r102;
    }

    public static byte[] c(byte[] r100) {
        return a(r100, false);
    }

    public static String d(byte[] r100) {
        return StringUtils.newStringUtf8(a(r100, false));
    }

    public static byte[] e(byte[] r100) {
        return a(r100, false, true);
    }

    public static String f(byte[] r100) {
        return StringUtils.newStringUtf8(a(r100, false, true));
    }

    public static byte[] g(byte[] r100) {
        return a(r100, true);
    }

    public static byte[] h(byte[] r100) {
        return new a().decode(r100);
    }

    public static BigInteger i(byte[] r100) {
        return new BigInteger(1, h(r100));
    }

    @Override // com.heytap.mcssdk.a.b
    public void a(byte[] r110, int r111, int r112) {
        if (this.f276290j == false) goto L6;
        return;
    L6:
        if (r112 >= 0) goto L27;
        this.f276290j = true;
        if (this.f276292l == 0) goto L10;
    L12:
        a(this.f276278x);
        int r113 = this.f276289i;
        int r114 = this.f276292l;
        if (r114 != 1) goto L15;
        byte[] r115 = this.f276288h;
        int r100 = r113 + 1;
        byte[] r101 = this.f276274t;
        int r102 = this.f276279y;
        r115[r113] = r101[(r102 >> 2) & 63];
        int r103 = r100 + 1;
        this.f276289i = r103;
        r115[r100] = r101[(r102 << 4) & 63];
        if (r101 != f276270p) goto L23;
        int r104 = r103 + 1;
        r115[r103] = Base64.padSymbol;
        this.f276289i = r104 + 1;
        r115[r104] = Base64.padSymbol;
    L23:
        int r116 = this.f276291k;
        int r117 = this.f276289i;
        int r118 = r116 + (r117 - r113);
        this.f276291k = r118;
        if (this.f276287g <= 0) goto L39;
        if (r118 <= 0) goto L45;
        byte[] r119 = this.f276276v;
        System.arraycopy(r119, 0, this.f276288h, r117, r119.length);
        this.f276289i += this.f276276v.length;
        return;
    L45:
        return;
    L39:
        return;
    L15:
        if (r114 != 2) goto L23;
        byte[] r120 = this.f276288h;
        int r105 = r113 + 1;
        byte[] r106 = this.f276274t;
        int r107 = this.f276279y;
        r120[r113] = r106[(r107 >> 10) & 63];
        int r108 = r105 + 1;
        r120[r105] = r106[(r107 >> 4) & 63];
        int r109 = r108 + 1;
        this.f276289i = r109;
        r120[r108] = r106[(r107 << 2) & 63];
        if (r106 != f276270p) goto L23;
        this.f276289i = r109 + 1;
        r120[r109] = Base64.padSymbol;
        goto L23
    L10:
        if (this.f276287g != 0) goto L12;
        return;
    L27:
        int r121 = 0;
    L28:
        if (r121 >= r112) goto L47;
        a(this.f276278x);
        int r122 = (this.f276292l + 1) % 3;
        this.f276292l = r122;
        int r123 = r111 + 1;
        int r124 = r110[r111];
        if (r124 >= 0) goto L32;
        r124 = r124 + 256;
    L32:
        int r125 = (this.f276279y << 8) + r124;
        this.f276279y = r125;
        if (r122 != 0) goto L38;
        byte[] r126 = this.f276288h;
        int r127 = this.f276289i;
        int r128 = r127 + 1;
        byte[] r129 = this.f276274t;
        r126[r127] = r129[(r125 >> 18) & 63];
        int r130 = r128 + 1;
        r126[r128] = r129[(r125 >> 12) & 63];
        int r131 = r130 + 1;
        r126[r130] = r129[(r125 >> 6) & 63];
        int r132 = r131 + 1;
        this.f276289i = r132;
        r126[r131] = r129[r125 & 63];
        int r133 = this.f276291k + 4;
        this.f276291k = r133;
        int r134 = this.f276287g;
        if (r134 <= 0) goto L38;
        if (r134 > r133) goto L38;
        byte[] r135 = this.f276276v;
        System.arraycopy(r135, 0, r126, r132, r135.length);
        this.f276289i += this.f276276v.length;
        this.f276291k = 0;
    L38:
        r121 = r121 + 1;
        r111 = r123;
        goto L28
    }

    public boolean a() {
        if (this.f276274t != f276271q) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.heytap.mcssdk.a.b
    public void b(byte[] r100, int r101, int r110) {
        if (this.f276290j == false) goto L6;
        return;
    L6:
        if (r110 >= 0) goto L8;
        this.f276290j = true;
    L8:
        int r102 = 0;
    L9:
        if (r102 >= r110) goto L23;
        a(this.f276277w);
        int r103 = r101 + 1;
        byte r104 = r100[r101];
        if (r104 == 61) goto L12;
        if (r104 < 0) goto L21;
        byte[] r105 = f276272r;
        if (r104 >= r105.length) goto L21;
        byte r106 = r105[r104];
        if (r106 < 0) goto L21;
        int r107 = (this.f276292l + 1) % 4;
        this.f276292l = r107;
        int r108 = (this.f276279y << 6) + r106;
        this.f276279y = r108;
        if (r107 != 0) goto L21;
        byte[] r109 = this.f276288h;
        int r111 = this.f276289i;
        int r112 = r111 + 1;
        r109[r111] = (byte) ((r108 >> 16) & 255);
        int r113 = r112 + 1;
        r109[r112] = (byte) ((r108 >> 8) & 255);
        this.f276289i = r113 + 1;
        r109[r113] = (byte) (r108 & 255);
    L21:
        r102 = r102 + 1;
        r101 = r103;
        goto L9
    L12:
        this.f276290j = true;
    L23:
        if (this.f276290j == true) goto L25;
        return;
    L25:
        if (this.f276292l == 0) goto L42;
        a(this.f276277w);
        int r114 = this.f276292l;
        if (r114 != 2) goto L29;
        int r115 = this.f276279y >> 4;
        this.f276279y = r115;
        byte[] r116 = this.f276288h;
        int r117 = this.f276289i;
        this.f276289i = r117 + 1;
        r116[r117] = (byte) (r115 & 255);
        return;
    L29:
        if (r114 != 3) goto L44;
        int r118 = this.f276279y >> 2;
        this.f276279y = r118;
        byte[] r119 = this.f276288h;
        int r120 = this.f276289i;
        int r121 = r120 + 1;
        r119[r120] = (byte) ((r118 >> 8) & 255);
        this.f276289i = r121 + 1;
        r119[r121] = (byte) (r118 & 255);
        return;
    L44:
        return;
    }

    @Override // com.heytap.mcssdk.a.b
    public boolean b(byte r100) {
        if (r100 < 0) goto L8;
        byte[] r101 = this.f276275u;
        if (r100 >= r101.length) goto L8;
        if (r101[r100] == (-1)) goto L8;
        return true;
    L8:
        return false;
    }
}
