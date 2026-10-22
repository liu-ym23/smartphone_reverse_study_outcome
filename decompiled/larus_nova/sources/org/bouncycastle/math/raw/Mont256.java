package org.bouncycastle.math.raw;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Mont256 {
    private static final long M = 4294967295L;

    public Mont256() {
    }

    public static int inverse32(int r100) {
        int r101 = (2 - (r100 * r100)) * r100;
        int r102 = r101 * (2 - (r100 * r101));
        int r103 = r102 * (2 - (r100 * r102));
        return r103 * (2 - (r100 * r103));
    }

    public static void multAdd(int[] r210, int[] r211, int[] r212, int[] r310, int r311) {
        char r100 = 0;
        long r101 = ((long) r211[0]) & 4294967295L;
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= 8) goto L10;
        long r110 = ((long) r212[r100]) & 4294967295L;
        long r111 = ((long) r210[r102]) & 4294967295L;
        long r112 = r111 * r101;
        long r113 = (r112 & 4294967295L) + r110;
        long r114 = r101;
        long r104 = ((long) (((int) r113) * r311)) & 4294967295L;
        int r115 = r102;
        int r213 = r103;
        long r105 = (((long) r310[r100]) & 4294967295L) * r104;
        long r116 = (((r113 + (r105 & 4294967295L)) >>> 32) + (r112 >>> 32)) + (r105 >>> 32);
        int r106 = 1;
        int r107 = 8;
    L6:
        if (r106 >= r107) goto L8;
        long r117 = (((long) r211[r106]) & 4294967295L) * r111;
        long r108 = (((long) r310[r106]) & 4294967295L) * r104;
        long r118 = r116 + (((r117 & 4294967295L) + (r108 & 4294967295L)) + (((long) r212[r106]) & 4294967295L));
        r212[r106 - 1] = (int) r118;
        r116 = ((r118 >>> 32) + (r117 >>> 32)) + (r108 >>> 32);
        r106 = r106 + 1;
        r104 = r104;
        r107 = 8;
        goto L6
    L8:
        long r119 = r116 + (((long) r213) & 4294967295L);
        r212[7] = (int) r119;
        r103 = (int) (r119 >>> 32);
        r102 = r115 + 1;
        r101 = r114;
        r100 = 0;
        goto L4
    L10:
        if (r103 == 0) goto L12;
    L13:
        Nat256.sub(r212, r310, r212);
        return;
    L12:
        if (Nat256.gte(r212, r310) == true) goto L13;
    }

    public static void multAddXF(int[] r210, int[] r211, int[] r212, int[] r213) {
        char r100 = 0;
        long r101 = ((long) r211[0]) & 4294967295L;
        int r102 = 0;
        int r103 = 0;
    L3:
        int r104 = 8;
        if (r102 >= 8) goto L9;
        long r110 = ((long) r210[r102]) & 4294967295L;
        long r111 = (r110 * r101) + (((long) r212[r100]) & 4294967295L);
        long r112 = r111 & 4294967295L;
        long r113 = (r111 >>> 32) + r112;
        int r105 = 1;
    L6:
        if (r105 >= r104) goto L8;
        long r114 = r101;
        long r106 = (((long) r211[r105]) & 4294967295L) * r110;
        long r107 = (((long) r213[r105]) & 4294967295L) * r112;
        long r115 = r113 + (((r106 & 4294967295L) + (r107 & 4294967295L)) + (((long) r212[r105]) & 4294967295L));
        r212[r105 - 1] = (int) r115;
        r113 = ((r115 >>> 32) + (r106 >>> 32)) + (r107 >>> 32);
        r105 = r105 + 1;
        r101 = r114;
        r110 = r110;
        r112 = r112;
        r104 = 8;
        goto L6
    L8:
        long r116 = r113 + (((long) r103) & 4294967295L);
        r212[7] = (int) r116;
        r103 = (int) (r116 >>> 32);
        r102 = r102 + 1;
        r101 = r101;
        r100 = 0;
        goto L3
    L9:
        if (r103 == 0) goto L11;
    L12:
        Nat256.sub(r212, r213, r212);
        return;
    L11:
        if (Nat256.gte(r212, r213) == true) goto L12;
    }

    public static void reduce(int[] r110, int[] r111, int r112) {
        char r100 = 0;
        int r101 = 0;
    L4:
        if (r101 >= 8) goto L10;
        int r102 = r110[r100];
        long r103 = ((long) (r102 * r112)) & 4294967295L;
        long r113 = (((((long) r111[r100]) & 4294967295L) * r103) + (((long) r102) & 4294967295L)) >>> 32;
        int r114 = 1;
    L6:
        if (r114 >= 8) goto L8;
        long r115 = r113 + (((((long) r111[r114]) & 4294967295L) * r103) + (((long) r110[r114]) & 4294967295L));
        r110[r114 - 1] = (int) r115;
        r113 = r115 >>> 32;
        r114 = r114 + 1;
        r101 = r101;
        goto L6
    L8:
        r110[7] = (int) r113;
        r101 = r101 + 1;
        r100 = 0;
        goto L4
    L10:
        if (Nat256.gte(r110, r111) == false) goto L15;
        Nat256.sub(r110, r111, r110);
        return;
    }

    public static void reduceXF(int[] r110, int[] r111) {
        int r100 = 0;
    L4:
        if (r100 >= 8) goto L10;
        long r101 = ((long) r110[0]) & 4294967295L;
        int r102 = 1;
        long r103 = r101;
    L6:
        if (r102 >= 8) goto L8;
        long r104 = r103 + (((((long) r111[r102]) & 4294967295L) * r101) + (((long) r110[r102]) & 4294967295L));
        r110[r102 - 1] = (int) r104;
        r103 = r104 >>> 32;
        r102 = r102 + 1;
        goto L6
    L8:
        r110[7] = (int) r103;
        r100 = r100 + 1;
        goto L4
    L10:
        if (Nat256.gte(r110, r111) == false) goto L15;
        Nat256.sub(r110, r111, r110);
        return;
    }
}
