package n4a;

import kotlin.UByte;

/* JADX INFO: loaded from: classes32.dex */
public final class g0 {
    public static byte[] a(byte[] r110, byte[] r111) {
        if (r110.length != 0) goto L5;
        return r110;
    L5:
        int r100 = r110.length;
        int r101 = 4 - (r100 % 4);
        int r102 = ((r100 / 4) + 1) * 4;
        byte[] r103 = new byte[r102];
        int r104 = 0;
        System.arraycopy(r110, 0, r103, 0, r110.length);
    L6:
        if (r100 >= r102) goto L8;
        r103[r100] = (byte) r101;
        r100 = r100 + 1;
        goto L6
    L8:
        int[] r112 = b(r103);
        int[] r113 = b(r111);
        int r105 = r112.length - 1;
        if (r105 > 0) goto L11;
    L20:
        int r114 = r112.length << 2;
        byte[] r106 = new byte[r114];
    L21:
        if (r104 >= r114) goto L23;
        r106[r104] = (byte) ((r112[r104 >>> 2] >>> ((r104 & 3) << 3)) & 255);
        r104 = r104 + 1;
        goto L21
    L23:
        return r106;
    L11:
        if (r113.length >= 4) goto L13;
        int[] r107 = new int[4];
        System.arraycopy(r113, 0, r107, 0, r113.length);
        r113 = r107;
    L13:
        int r108 = r112[r105];
        int r109 = (52 / (r105 + 1)) + 6;
        int r115 = 0;
    L14:
        int r116 = r109 - 1;
        if (r109 <= 0) goto L20;
        r115 = r115 - 1640531527;
        int r117 = (r115 >>> 2) & 3;
        int r118 = 0;
    L17:
        if (r118 >= r105) goto L19;
        int r119 = r118 + 1;
        int r120 = r112[r119];
        r108 = ((((r108 >>> 5) ^ (r120 << 2)) + ((r120 >>> 3) ^ (r108 << 4))) ^ ((r120 ^ r115) + (r108 ^ r113[(r118 & 3) ^ r117]))) + r112[r118];
        r112[r118] = r108;
        r118 = r119;
        goto L17
    L19:
        int r121 = r112[0];
        r108 = ((((r108 >>> 5) ^ (r121 << 2)) + ((r121 >>> 3) ^ (r108 << 4))) ^ ((r121 ^ r115) + (r108 ^ r113[r117 ^ (r118 & 3)]))) + r112[r105];
        r112[r105] = r108;
        r109 = r116;
        goto L14
    }

    public static int[] b(byte[] r100) {
        int[] r101 = new int[r100.length >>> 2];
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        int r104 = r103 >>> 2;
        r101[r104] = r101[r104] | ((r100[r103] & UByte.MAX_VALUE) << ((r103 & 3) << 3));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }
}
