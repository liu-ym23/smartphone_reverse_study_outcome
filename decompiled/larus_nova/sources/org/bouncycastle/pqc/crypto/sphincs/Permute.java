package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
class Permute {
    private static final int CHACHA_ROUNDS = 12;

    public Permute() {
    }

    public static void permute(int r310, int[] r311) {
        int r100 = 16;
        if (r311.length != 16) goto L14;
        if ((r310 % 2) != 0) goto L12;
        char r101 = 0;
        int r102 = r311[0];
        int r103 = r311[1];
        int r104 = r311[2];
        int r105 = r311[3];
        int r110 = r311[4];
        int r111 = r311[5];
        int r112 = r311[6];
        int r113 = 7;
        int r114 = r311[7];
        int r115 = 8;
        int r116 = r311[8];
        int r117 = r311[9];
        int r210 = r311[10];
        int r211 = r311[11];
        int r212 = r311[12];
        int r213 = r311[13];
        int r214 = r311[14];
        int r312 = r311[15];
        int r313 = r214;
        int r215 = r213;
        int r216 = r212;
        int r217 = r211;
        int r218 = r210;
        int r219 = r117;
        int r118 = r116;
        int r119 = r114;
        int r120 = r112;
        int r121 = r111;
        int r122 = r110;
        int r123 = r105;
        int r106 = r104;
        int r107 = r103;
        int r108 = r102;
        int r109 = r310;
    L7:
        if (r109 <= 0) goto L9;
        int r124 = r108 + r122;
        int r125 = rotl(r216 ^ r124, r100);
        int r126 = r118 + r125;
        int r127 = rotl(r122 ^ r126, 12);
        int r128 = r124 + r127;
        int r129 = rotl(r125 ^ r128, r115);
        int r130 = r126 + r129;
        int r131 = rotl(r127 ^ r130, r113);
        int r132 = r107 + r121;
        int r133 = rotl(r215 ^ r132, r100);
        int r220 = r219 + r133;
        int r134 = rotl(r121 ^ r220, 12);
        int r135 = r132 + r134;
        int r136 = rotl(r133 ^ r135, r115);
        int r221 = r220 + r136;
        int r137 = rotl(r134 ^ r221, r113);
        int r138 = r106 + r120;
        int r139 = rotl(r313 ^ r138, r100);
        int r222 = r218 + r139;
        int r140 = rotl(r120 ^ r222, 12);
        int r141 = r138 + r140;
        int r142 = rotl(r139 ^ r141, r115);
        int r223 = r222 + r142;
        int r143 = rotl(r140 ^ r223, r113);
        int r144 = r123 + r119;
        int r145 = rotl(r312 ^ r144, r100);
        int r224 = r217 + r145;
        int r146 = rotl(r119 ^ r224, 12);
        int r147 = r144 + r146;
        int r148 = rotl(r145 ^ r147, r115);
        int r225 = r224 + r148;
        int r149 = rotl(r146 ^ r225, 7);
        int r150 = r128 + r137;
        int r151 = rotl(r148 ^ r150, 16);
        int r226 = r223 + r151;
        int r152 = rotl(r137 ^ r226, 12);
        r108 = r150 + r152;
        r312 = rotl(r151 ^ r108, 8);
        r218 = r226 + r312;
        r121 = rotl(r152 ^ r218, 7);
        int r153 = r135 + r143;
        int r154 = rotl(r129 ^ r153, 16);
        int r227 = r225 + r154;
        int r155 = rotl(r143 ^ r227, 12);
        r107 = r153 + r155;
        r216 = rotl(r154 ^ r107, 8);
        r217 = r227 + r216;
        r120 = rotl(r155 ^ r217, 7);
        int r156 = r141 + r149;
        int r157 = rotl(r136 ^ r156, 16);
        int r158 = r130 + r157;
        int r159 = rotl(r149 ^ r158, 12);
        r106 = r156 + r159;
        r215 = rotl(r157 ^ r106, 8);
        r118 = r158 + r215;
        r119 = rotl(r159 ^ r118, 7);
        int r160 = r147 + r131;
        r100 = 16;
        int r161 = rotl(r142 ^ r160, 16);
        int r228 = r221 + r161;
        int r162 = rotl(r131 ^ r228, 12);
        r123 = r160 + r162;
        r313 = rotl(r161 ^ r123, 8);
        r219 = r228 + r313;
        r122 = rotl(r162 ^ r219, 7);
        r109 = r109 - 2;
        r101 = 0;
        r115 = 8;
        r113 = 7;
        goto L7
    L9:
        r311[r101] = r108;
        r311[1] = r107;
        r311[2] = r106;
        r311[3] = r123;
        r311[4] = r122;
        r311[5] = r121;
        r311[6] = r120;
        r311[7] = r119;
        r311[8] = r118;
        r311[9] = r219;
        r311[10] = r218;
        r311[11] = r217;
        r311[12] = r216;
        r311[13] = r215;
        r311[14] = r313;
        r311[15] = r312;
        return;
    L12:
        throw new IllegalArgumentException("Number of rounds must be even");
    L14:
        throw new IllegalArgumentException();
    }

    public static int rotl(int r100, int r101) {
        int r102 = r100 << r101;
        return (r100 >>> (-r101)) | r102;
    }

    public void chacha_permute(byte[] r100, byte[] r101) {
        int[] r102 = new int[16];
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= 16) goto L5;
        r102[r104] = Pack.littleEndianToInt(r101, r104 * 4);
        r104 = r104 + 1;
        goto L3
    L5:
        permute(12, r102);
    L6:
        if (r103 >= 16) goto L8;
        Pack.intToLittleEndian(r102[r103], r100, r103 * 4);
        r103 = r103 + 1;
        goto L6
    }
}
