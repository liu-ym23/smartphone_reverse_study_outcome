package com.xiaomi.push;

import kotlin.UByte;

/* JADX INFO: loaded from: classes41.dex */
public class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f463162a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static byte[] f257a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static char[] f258a;

    static {
        f463162a = System.getProperty("line.separator");
        f258a = new char[64];
        int r100 = 0;
        char r101 = 'A';
        int r102 = 0;
    L4:
        if (r101 > 'Z') goto L6;
        f258a[r102] = r101;
        r101 = (char) (r101 + 1);
        r102 = r102 + 1;
        goto L4
    L6:
        char r103 = 'a';
    L8:
        if (r103 > 'z') goto L10;
        f258a[r102] = r103;
        r103 = (char) (r103 + 1);
        r102 = r102 + 1;
        goto L8
    L10:
        char r104 = '0';
    L12:
        if (r104 > '9') goto L14;
        f258a[r102] = r104;
        r104 = (char) (r104 + 1);
        r102 = r102 + 1;
        goto L12
    L14:
        char[] r105 = f258a;
        r105[r102] = '+';
        r105[r102 + 1] = '/';
        f257a = new byte[128];
        int r106 = 0;
    L15:
        byte[] r107 = f257a;
        if (r106 >= r107.length) goto L18;
        r107[r106] = -1;
        r106 = r106 + 1;
    L18:
        if (r100 >= 64) goto L20;
        f257a[f258a[r100]] = (byte) r100;
        r100 = r100 + 1;
        goto L18
    }

    public static String a(String r100) {
        return new String(a(r100.getBytes()));
    }

    public static String b(String r100) {
        return new String(m8829a(r100));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m8829a(String r100) {
        return a(r100.toCharArray());
    }

    public static byte[] a(char[] r100) {
        return a(r100, 0, r100.length);
    }

    public static char[] a(byte[] r100) {
        return a(r100, 0, r100.length);
    }

    public static byte[] a(char[] r100, int r110, int r111) {
        if ((r111 % 4) != 0) goto L40;
    L4:
        if (r111 <= 0) goto L8;
        if (r100[(r110 + r111) - 1] != '=') goto L8;
        r111 = r111 - 1;
    L8:
        int r101 = (r111 * 3) / 4;
        byte[] r102 = new byte[r101];
        int r112 = r111 + r110;
        int r103 = 0;
    L9:
        if (r110 >= r112) goto L38;
        int r104 = r110 + 1;
        char r113 = r100[r110];
        int r105 = r104 + 1;
        char r106 = r100[r104];
        if (r105 >= r112) goto L13;
        int r107 = r105 + 1;
        char r108 = r100[r105];
    L14:
        if (r107 >= r112) goto L16;
        int r109 = r107 + 1;
        char r114 = r100[r107];
    L18:
        if (r113 > 127) goto L37;
        if (r106 > 127) goto L37;
        if (r108 > 127) goto L37;
        if (r114 > 127) goto L37;
        byte[] r115 = f257a;
        byte r116 = r115[r113];
        byte r117 = r115[r106];
        byte r118 = r115[r108];
        byte r119 = r115[r114];
        if (r116 < 0) goto L35;
        if (r117 < 0) goto L35;
        if (r118 < 0) goto L35;
        if (r119 < 0) goto L35;
        int r120 = (r116 << 2) | (r117 >>> 4);
        int r121 = ((r117 & 15) << 4) | (r118 >>> 2);
        int r122 = ((r118 & 3) << 6) | r119;
        int r123 = r103 + 1;
        r102[r103] = (byte) r120;
        if (r123 >= r101) goto L30;
        r102[r123] = (byte) r121;
        r123 = r123 + 1;
    L30:
        if (r123 >= r101) goto L32;
        r102[r123] = (byte) r122;
        r103 = r123 + 1;
    L33:
        r110 = r109;
        goto L9
    L32:
        r103 = r123;
    L35:
        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
    L37:
        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
    L16:
        r109 = r107;
        r114 = 'A';
        goto L18
    L13:
        r107 = r105;
        r108 = 'A';
        goto L14
    L38:
        return r102;
    L40:
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    public static char[] a(byte[] r110, int r111, int r112) {
        int r100 = ((r112 * 4) + 2) / 3;
        char[] r101 = new char[((r112 + 2) / 3) * 4];
        int r113 = r112 + r111;
        int r102 = 0;
    L3:
        if (r111 >= r113) goto L19;
        int r103 = r111 + 1;
        int r114 = r110[r111] & UByte.MAX_VALUE;
        if (r103 >= r113) goto L7;
        int r104 = r103 + 1;
        int r105 = r110[r103] & UByte.MAX_VALUE;
    L8:
        if (r104 >= r113) goto L10;
        int r106 = r104 + 1;
        int r107 = r110[r104] & UByte.MAX_VALUE;
        r104 = r106;
    L11:
        int r108 = r114 >>> 2;
        int r115 = ((r114 & 3) << 4) | (r105 >>> 4);
        int r109 = ((r105 & 15) << 2) | (r107 >>> 6);
        int r116 = r107 & 63;
        int r117 = r102 + 1;
        char[] r118 = f258a;
        r101[r102] = r118[r108];
        int r119 = r117 + 1;
        r101[r117] = r118[r115];
        char r120 = com.alipay.sdk.m.n.a.f25612h;
        if (r119 >= r100) goto L14;
        char r121 = r118[r109];
    L15:
        r101[r119] = r121;
        int r122 = r119 + 1;
        if (r122 >= r100) goto L18;
        r120 = r118[r116];
    L18:
        r101[r122] = r120;
        r102 = r122 + 1;
        r111 = r104;
        goto L3
    L14:
        r121 = com.alipay.sdk.m.n.a.f25612h;
        goto L15
    L10:
        r107 = 0;
        goto L11
    L7:
        r104 = r103;
        r105 = 0;
        goto L8
    L19:
        return r101;
    }
}
