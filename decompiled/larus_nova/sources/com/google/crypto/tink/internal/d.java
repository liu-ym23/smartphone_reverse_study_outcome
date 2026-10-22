package com.google.crypto.tink.internal;

import androidx.compose.ui.spatial.RectListKt;
import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f275752a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f275753b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f275754c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f275755d = null;

    static {
        f275752a = new int[]{0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
        f275753b = new int[]{0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
        f275754c = new int[]{RectListKt.Lower26Bits, 33554431};
        f275755d = new int[]{26, 25};
    }

    public static byte[] a(long[] r110) {
        long[] r100 = Arrays.copyOf(r110, 10);
        int r101 = 0;
        int r102 = 0;
    L3:
        int[] r103 = f275755d;
        int r104 = 2;
        if (r102 >= 2) goto L9;
        int r105 = 0;
    L6:
        if (r105 >= 9) goto L8;
        long r111 = r100[r105];
        int r112 = r103[r105 & 1];
        int r113 = -((int) (((r111 >> 31) & r111) >> r112));
        r100[r105] = r111 + ((long) (r113 << r112));
        r105 = r105 + 1;
        r100[r105] = r100[r105] - ((long) r113);
        goto L6
    L8:
        long r114 = r100[9];
        int r106 = -((int) (((r114 >> 31) & r114) >> 25));
        r100[9] = r114 + ((long) (r106 << 25));
        r100[0] = r100[0] - (((long) r106) * 19);
        r102 = r102 + 1;
        goto L3
    L9:
        long r115 = r100[0];
        int r107 = -((int) (((r115 >> 31) & r115) >> 26));
        r100[0] = r115 + ((long) (r107 << 26));
        r100[1] = r100[1] - ((long) r107);
        int r108 = 0;
    L10:
        int[] r116 = f275754c;
        if (r108 >= r104) goto L16;
        int r117 = 0;
    L13:
        if (r117 >= 9) goto L15;
        long r118 = r100[r117];
        int r119 = r117 & 1;
        int r109 = (int) (r118 >> r103[r119]);
        r100[r117] = ((long) r116[r119]) & r118;
        r117 = r117 + 1;
        r100[r117] = r100[r117] + ((long) r109);
        r116 = r116;
        goto L13
    L15:
        r108 = r108 + 1;
        r104 = 2;
        goto L10
    L16:
        long r120 = r100[9];
        r100[9] = r120 & 33554431;
        long r121 = r100[0] + (((long) ((int) (r120 >> 25))) * 19);
        r100[0] = r121;
        int r122 = ~((((int) r121) - 67108845) >> 31);
        int r123 = 1;
    L17:
        if (r123 >= 10) goto L19;
        int r124 = ~(r116[r123 & 1] ^ ((int) r100[r123]));
        int r125 = r124 & (r124 << 16);
        int r126 = r125 & (r125 << 8);
        int r127 = r126 & (r126 << 4);
        int r128 = r127 & (r127 << 2);
        r122 = r122 & ((r128 & (r128 << 1)) >> 31);
        r123 = r123 + 1;
        goto L17
    L19:
        r100[0] = r100[0] - ((long) (67108845 & r122));
        long r129 = 33554431 & r122;
        r100[1] = r100[1] - r129;
        int r130 = 2;
    L20:
        if (r130 >= 10) goto L22;
        r100[r130] = r100[r130] - ((long) (67108863 & r122));
        int r131 = r130 + 1;
        r100[r131] = r100[r131] - r129;
        r130 = r130 + 2;
        goto L20
    L22:
        int r132 = 0;
    L23:
        if (r132 >= 10) goto L25;
        r100[r132] = r100[r132] << f275753b[r132];
        r132 = r132 + 1;
        goto L23
    L25:
        byte[] r133 = new byte[32];
    L26:
        if (r101 >= 10) goto L28;
        int r134 = f275752a[r101];
        long r135 = r133[r134];
        long r136 = r100[r101];
        r133[r134] = (byte) (r135 | (r136 & 255));
        int r137 = r134 + 1;
        r133[r137] = (byte) (((long) r133[r137]) | ((r136 >> 8) & 255));
        int r138 = r134 + 2;
        r133[r138] = (byte) (((long) r133[r138]) | ((r136 >> 16) & 255));
        int r139 = r134 + 3;
        r133[r139] = (byte) (((long) r133[r139]) | ((r136 >> 24) & 255));
        r101 = r101 + 1;
        goto L26
    L28:
        return r133;
    }

    public static void d(long[] r110) {
        r110[10] = 0;
        int r100 = 0;
    L4:
        if (r100 >= 10) goto L6;
        long r101 = r110[r100];
        long r102 = r101 / 67108864;
        r110[r100] = r101 - (r102 << 26);
        int r103 = r100 + 1;
        long r104 = r110[r103] + r102;
        r110[r103] = r104;
        long r105 = r104 / 33554432;
        r110[r103] = r104 - (r105 << 25);
        r100 = r100 + 2;
        r110[r100] = r110[r100] + r105;
        goto L4
    L6:
        long r106 = r110[0];
        long r111 = r110[10];
        long r107 = r106 + (r111 << 4);
        r110[0] = r107;
        long r108 = r107 + (r111 << 1);
        r110[0] = r108;
        long r109 = r108 + r111;
        r110[0] = r109;
        r110[10] = 0;
        long r112 = r109 / 67108864;
        r110[0] = r109 - (r112 << 26);
        r110[1] = r110[1] + r112;
    }

    public static void e(long[] r100) {
        long r101 = r100[8];
        long r102 = r100[18];
        long r103 = r101 + (r102 << 4);
        r100[8] = r103;
        long r104 = r103 + (r102 << 1);
        r100[8] = r104;
        r100[8] = r104 + r102;
        long r105 = r100[7];
        long r106 = r100[17];
        long r107 = r105 + (r106 << 4);
        r100[7] = r107;
        long r108 = r107 + (r106 << 1);
        r100[7] = r108;
        r100[7] = r108 + r106;
        long r109 = r100[6];
        long r110 = r100[16];
        long r111 = r109 + (r110 << 4);
        r100[6] = r111;
        long r112 = r111 + (r110 << 1);
        r100[6] = r112;
        r100[6] = r112 + r110;
        long r113 = r100[5];
        long r114 = r100[15];
        long r115 = r113 + (r114 << 4);
        r100[5] = r115;
        long r116 = r115 + (r114 << 1);
        r100[5] = r116;
        r100[5] = r116 + r114;
        long r117 = r100[4];
        long r118 = r100[14];
        long r119 = r117 + (r118 << 4);
        r100[4] = r119;
        long r120 = r119 + (r118 << 1);
        r100[4] = r120;
        r100[4] = r120 + r118;
        long r121 = r100[3];
        long r122 = r100[13];
        long r123 = r121 + (r122 << 4);
        r100[3] = r123;
        long r124 = r123 + (r122 << 1);
        r100[3] = r124;
        r100[3] = r124 + r122;
        long r125 = r100[2];
        long r126 = r100[12];
        long r127 = r125 + (r126 << 4);
        r100[2] = r127;
        long r128 = r127 + (r126 << 1);
        r100[2] = r128;
        r100[2] = r128 + r126;
        long r129 = r100[1];
        long r130 = r100[11];
        long r131 = r129 + (r130 << 4);
        r100[1] = r131;
        long r132 = r131 + (r130 << 1);
        r100[1] = r132;
        r100[1] = r132 + r130;
        long r133 = r100[0];
        long r134 = r100[10];
        long r135 = r133 + (r134 << 4);
        r100[0] = r135;
        long r136 = r135 + (r134 << 1);
        r100[0] = r136;
        r100[0] = r136 + r134;
    }

    public static void f(long[] r310, long[] r311) {
        long r100 = r311[0];
        long r101 = r311[0];
        long r102 = r101 * 2;
        long r103 = r311[1];
        long r110 = r311[2];
        long r111 = r311[3];
        long r112 = r311[4];
        long r104 = ((r111 * r111) + (r110 * r112)) + (r311[6] * r101);
        long r210 = r311[5];
        long r113 = r311[6];
        long r211 = (r110 * r113) + (r311[8] * r101);
        long r212 = r311[7];
        long r213 = r311[8];
        long r214 = r311[9];
        long[] r105 = {r100 * r100, r311[1] * r102, ((r103 * r103) + (r311[2] * r101)) * 2, ((r103 * r110) + (r311[3] * r101)) * 2, ((r110 * r110) + ((r103 * 4) * r111)) + (r102 * r311[4]), (((r110 * r111) + (r103 * r112)) + (r311[5] * r101)) * 2, (r104 + ((r103 * 2) * r210)) * 2, ((((r111 * r112) + (r110 * r210)) + (r103 * r113)) + (r311[7] * r101)) * 2, (r112 * r112) + ((r211 + (((r103 * r212) + (r111 * r210)) * 2)) * 2), (((((r112 * r210) + (r111 * r113)) + (r110 * r212)) + (r103 * r213)) + (r101 * r311[9])) * 2, ((((r210 * r210) + (r112 * r113)) + (r110 * r213)) + (((r111 * r212) + (r103 * r214)) * 2)) * 2, ((((r210 * r113) + (r112 * r212)) + (r111 * r213)) + (r110 * r214)) * 2, (r113 * r113) + (((r112 * r213) + (((r210 * r212) + (r111 * r214)) * 2)) * 2), (((r113 * r212) + (r210 * r213)) + (r112 * r214)) * 2, (((r212 * r212) + (r113 * r213)) + ((r210 * 2) * r214)) * 2, ((r212 * r213) + (r113 * r214)) * 2, (r213 * r213) + ((r212 * 4) * r214), (r213 * 2) * r214, (2 * r214) * r214};
        e(r105);
        d(r105);
        System.arraycopy(r105, 0, r310, 0, 10);
    }

    public static void b(long[] r100, long[] r101, long[] r102) {
        long[] r103 = new long[19];
        c(r103, r101, r102);
        e(r103);
        d(r103);
        System.arraycopy(r103, 0, r100, 0, 10);
    }

    public static void c(long[] r410, long[] r411, long[] r412) {
        r410[0] = r411[0] * r412[0];
        long r100 = r411[0];
        long r101 = r412[1] * r100;
        long r102 = r411[1];
        long r103 = r412[0];
        r410[1] = r101 + (r102 * r103);
        long r104 = r411[1];
        long r110 = r412[1];
        r410[2] = (((r104 * 2) * r110) + (r412[2] * r100)) + (r411[2] * r103);
        long r111 = r412[2];
        long r112 = r411[2];
        r410[3] = (((r104 * r111) + (r112 * r110)) + (r412[3] * r100)) + (r411[3] * r103);
        long r113 = r412[3];
        long r210 = r411[3];
        r410[4] = (((r112 * r111) + (((r104 * r113) + (r210 * r110)) * 2)) + (r412[4] * r100)) + (r411[4] * r103);
        long r114 = (r112 * r113) + (r210 * r111);
        long r211 = r412[4];
        long r115 = r114 + (r104 * r211);
        long r212 = r411[4];
        r410[5] = ((r115 + (r212 * r110)) + (r412[5] * r100)) + (r411[5] * r103);
        long r213 = r412[5];
        long r116 = (r210 * r113) + (r104 * r213);
        long r214 = r411[5];
        r410[6] = (((((r116 + (r214 * r110)) * 2) + (r112 * r211)) + (r212 * r111)) + (r412[6] * r100)) + (r411[6] * r103);
        long r117 = (((r210 * r211) + (r212 * r113)) + (r112 * r213)) + (r214 * r111);
        long r310 = r412[6];
        long r118 = r117 + (r104 * r310);
        long r311 = r411[6];
        r410[7] = ((r118 + (r311 * r110)) + (r412[7] * r100)) + (r411[7] * r103);
        long r312 = (r210 * r213) + (r214 * r113);
        long r313 = r412[7];
        long r314 = r312 + (r104 * r313);
        long r315 = r411[7];
        r410[8] = (((((r212 * r211) + ((r314 + (r315 * r110)) * 2)) + (r112 * r310)) + (r311 * r111)) + (r412[8] * r100)) + (r411[8] * r103);
        long r119 = (((((r212 * r213) + (r214 * r211)) + (r210 * r310)) + (r311 * r113)) + (r112 * r313)) + (r315 * r111);
        long r316 = r412[8];
        long r120 = r119 + (r104 * r316);
        long r413 = r411[8];
        r410[9] = ((r120 + (r413 * r110)) + (r100 * r412[9])) + (r411[9] * r103);
        long r105 = ((r214 * r213) + (r210 * r313)) + (r315 * r113);
        long r106 = r412[9];
        long r107 = r411[9];
        r410[10] = ((((((r105 + (r104 * r106)) + (r110 * r107)) * 2) + (r212 * r310)) + (r311 * r211)) + (r112 * r316)) + (r413 * r111);
        r410[11] = (((((((r214 * r310) + (r311 * r213)) + (r212 * r313)) + (r315 * r211)) + (r210 * r316)) + (r413 * r113)) + (r112 * r106)) + (r111 * r107);
        r410[12] = (((r311 * r310) + (((((r214 * r313) + (r315 * r213)) + (r210 * r106)) + (r113 * r107)) * 2)) + (r212 * r316)) + (r413 * r211);
        r410[13] = (((((r311 * r313) + (r315 * r310)) + (r214 * r316)) + (r413 * r213)) + (r212 * r106)) + (r211 * r107);
        r410[14] = (((((r315 * r313) + (r214 * r106)) + (r213 * r107)) * 2) + (r311 * r316)) + (r413 * r310);
        r410[15] = (((r315 * r316) + (r413 * r313)) + (r311 * r106)) + (r310 * r107);
        r410[16] = (r413 * r316) + (((r315 * r106) + (r313 * r107)) * 2);
        r410[17] = (r413 * r106) + (r316 * r107);
        r410[18] = (r107 * 2) * r106;
    }

    public static void g(long[] r100, long[] r101, long[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= 10) goto L6;
        r100[r103] = r101[r103] - r102[r103];
        r103 = r103 + 1;
        goto L4
    }

    public static void h(long[] r100, long[] r101, long[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= 10) goto L6;
        r100[r103] = r101[r103] + r102[r103];
        r103 = r103 + 1;
        goto L4
    }
}
