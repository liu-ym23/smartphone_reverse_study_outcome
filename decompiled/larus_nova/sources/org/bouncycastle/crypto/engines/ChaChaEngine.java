package org.bouncycastle.crypto.engines;

import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class ChaChaEngine extends Salsa20Engine {
    public ChaChaEngine() {
    }

    public ChaChaEngine(int r100) {
        super(r100);
    }

    public static void chachaCore(int r310, int[] r311, int[] r312) {
        int r100 = 16;
        if (r311.length != 16) goto L18;
        if (r312.length != 16) goto L16;
        if ((r310 % 2) != 0) goto L14;
        char r101 = 0;
        int r102 = r311[0];
        int r103 = r311[1];
        int r104 = r311[2];
        int r110 = r311[3];
        int r111 = r311[4];
        int r112 = r311[5];
        int r113 = r311[6];
        int r114 = 7;
        int r115 = r311[7];
        int r116 = 8;
        int r117 = r311[8];
        int r210 = r311[9];
        int r211 = r311[10];
        int r212 = r311[11];
        int r118 = 12;
        int r213 = r311[12];
        int r214 = r311[13];
        int r215 = r311[14];
        int r313 = r311[15];
        int r314 = r215;
        int r216 = r214;
        int r217 = r213;
        int r218 = r212;
        int r219 = r211;
        int r220 = r210;
        int r221 = r117;
        int r119 = r115;
        int r120 = r113;
        int r121 = r112;
        int r122 = r111;
        int r123 = r110;
        int r124 = r104;
        int r105 = r103;
        int r106 = r102;
        int r107 = r310;
    L9:
        if (r107 <= 0) goto L11;
        int r108 = r106 + r122;
        int r109 = Integers.rotateLeft(r217 ^ r108, r100);
        int r222 = r221 + r109;
        int r125 = Integers.rotateLeft(r122 ^ r222, r118);
        int r126 = r108 + r125;
        int r127 = Integers.rotateLeft(r109 ^ r126, r116);
        int r223 = r222 + r127;
        int r128 = Integers.rotateLeft(r125 ^ r223, r114);
        int r129 = r105 + r121;
        int r130 = Integers.rotateLeft(r216 ^ r129, r100);
        int r224 = r220 + r130;
        int r131 = Integers.rotateLeft(r121 ^ r224, r118);
        int r132 = r129 + r131;
        int r133 = Integers.rotateLeft(r130 ^ r132, r116);
        int r225 = r224 + r133;
        int r134 = Integers.rotateLeft(r131 ^ r225, r114);
        int r135 = r124 + r120;
        int r136 = Integers.rotateLeft(r314 ^ r135, r100);
        int r226 = r219 + r136;
        int r137 = Integers.rotateLeft(r120 ^ r226, r118);
        int r138 = r135 + r137;
        int r139 = Integers.rotateLeft(r136 ^ r138, r116);
        int r227 = r226 + r139;
        int r140 = Integers.rotateLeft(r137 ^ r227, r114);
        int r141 = r123 + r119;
        int r142 = Integers.rotateLeft(r313 ^ r141, 16);
        int r228 = r218 + r142;
        int r143 = Integers.rotateLeft(r119 ^ r228, r118);
        int r144 = r141 + r143;
        int r145 = Integers.rotateLeft(r142 ^ r144, 8);
        int r229 = r228 + r145;
        int r146 = Integers.rotateLeft(r143 ^ r229, 7);
        int r147 = r126 + r134;
        int r148 = Integers.rotateLeft(r145 ^ r147, 16);
        int r230 = r227 + r148;
        int r149 = Integers.rotateLeft(r134 ^ r230, 12);
        r106 = r147 + r149;
        r313 = Integers.rotateLeft(r148 ^ r106, 8);
        r219 = r230 + r313;
        r121 = Integers.rotateLeft(r149 ^ r219, 7);
        int r150 = r132 + r140;
        int r151 = Integers.rotateLeft(r127 ^ r150, 16);
        int r231 = r229 + r151;
        int r152 = Integers.rotateLeft(r140 ^ r231, 12);
        r105 = r150 + r152;
        r217 = Integers.rotateLeft(r151 ^ r105, 8);
        r218 = r231 + r217;
        r120 = Integers.rotateLeft(r152 ^ r218, 7);
        int r153 = r138 + r146;
        int r154 = Integers.rotateLeft(r133 ^ r153, 16);
        int r232 = r223 + r154;
        int r155 = Integers.rotateLeft(r146 ^ r232, 12);
        r124 = r153 + r155;
        r216 = Integers.rotateLeft(r154 ^ r124, 8);
        r221 = r232 + r216;
        r119 = Integers.rotateLeft(r155 ^ r221, 7);
        int r156 = r144 + r128;
        r100 = 16;
        int r157 = Integers.rotateLeft(r139 ^ r156, 16);
        int r233 = r225 + r157;
        int r158 = Integers.rotateLeft(r128 ^ r233, 12);
        r123 = r156 + r158;
        r314 = Integers.rotateLeft(r157 ^ r123, 8);
        r220 = r233 + r314;
        r122 = Integers.rotateLeft(r158 ^ r220, 7);
        r107 = r107 - 2;
        r101 = 0;
        r118 = 12;
        r116 = 8;
        r114 = 7;
        goto L9
    L11:
        r312[r101] = r106 + r311[r101];
        r312[1] = r105 + r311[1];
        r312[2] = r124 + r311[2];
        r312[3] = r123 + r311[3];
        r312[4] = r122 + r311[4];
        r312[5] = r121 + r311[5];
        r312[6] = r120 + r311[6];
        r312[7] = r119 + r311[7];
        r312[8] = r221 + r311[8];
        r312[9] = r220 + r311[9];
        r312[10] = r219 + r311[10];
        r312[11] = r218 + r311[11];
        r312[12] = r217 + r311[12];
        r312[13] = r216 + r311[13];
        r312[14] = r314 + r311[14];
        r312[15] = r313 + r311[15];
        return;
    L14:
        throw new IllegalArgumentException("Number of rounds must be even");
    L16:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalArgumentException();
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void advanceCounter() {
        int[] r100 = this.engineState;
        int r101 = r100[12] + 1;
        r100[12] = r101;
        if (r101 != 0) goto L6;
        r100[13] = r100[13] + 1;
        return;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void advanceCounter(long r100) {
        int r101 = (int) (r100 >>> 32);
        int r102 = (int) r100;
        if (r101 <= 0) goto L5;
        int[] r103 = this.engineState;
        r103[13] = r103[13] + r101;
    L5:
        int[] r104 = this.engineState;
        int r105 = r104[12];
        int r106 = r102 + r105;
        r104[12] = r106;
        if (r105 == 0) goto L10;
        if (r106 >= r105) goto L11;
        r104[13] = r104[13] + 1;
        return;
    L11:
        return;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void generateKeyStream(byte[] r100) {
        chachaCore(this.rounds, this.engineState, this.f525201x);
        Pack.intToLittleEndian(this.f525201x, r100, 0);
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine, org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "ChaCha" + this.rounds;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public long getCounter() {
        int[] r100 = this.engineState;
        return (((long) r100[13]) << 32) | (((long) r100[12]) & BodyPartID.bodyIdMax);
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void resetCounter() {
        int[] r100 = this.engineState;
        r100[13] = 0;
        r100[12] = 0;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void retreatCounter() {
        int[] r100 = this.engineState;
        int r101 = r100[12];
        if (r101 == 0) goto L5;
    L9:
        int r102 = r101 - 1;
        r100[12] = r102;
        if (r102 != (-1)) goto L13;
        r100[13] = r100[13] - 1;
        return;
    L13:
        return;
    L5:
        if (r100[13] != 0) goto L9;
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void retreatCounter(long r110) {
        int r100 = (int) (r110 >>> 32);
        int r111 = (int) r110;
        if (r100 == 0) goto L9;
        int[] r101 = this.engineState;
        int r102 = r101[13];
        if ((((long) r102) & BodyPartID.bodyIdMax) < (((long) r100) & BodyPartID.bodyIdMax)) goto L8;
        r101[13] = r102 - r100;
        goto L9
    L8:
        throw new IllegalStateException("attempt to reduce counter past zero.");
    L9:
        int[] r103 = this.engineState;
        int r104 = r103[12];
        if ((((long) r104) & BodyPartID.bodyIdMax) < (BodyPartID.bodyIdMax & ((long) r111))) goto L12;
        r103[12] = r104 - r111;
        return;
    L12:
        int r105 = r103[13];
        if (r105 == 0) goto L17;
        r103[13] = r105 - 1;
        r103[12] = r104 - r111;
        return;
    L17:
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void setKey(byte[] r100, byte[] r101) {
        if (r100 != null) goto L5;
    L12:
        Pack.littleEndianToInt(r101, 0, this.engineState, 14, 2);
        return;
    L5:
        if (r100.length != 16) goto L7;
    L11:
        packTauOrSigma(r100.length, this.engineState, 0);
        Pack.littleEndianToInt(r100, 0, this.engineState, 4, 4);
        Pack.littleEndianToInt(r100, r100.length - 16, this.engineState, 8, 4);
        goto L12
    L7:
        if (r100.length == 32) goto L11;
        throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
    }
}
