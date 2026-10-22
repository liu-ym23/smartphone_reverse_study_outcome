package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class KeccakDigest implements ExtendedDigest {
    private static long[] KeccakRoundConstants;
    protected int bitsInQueue;
    protected byte[] dataQueue;
    protected int fixedOutputLength;
    protected int rate;
    protected boolean squeezing;
    protected long[] state;

    static {
        KeccakRoundConstants = new long[]{1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};
    }

    public KeccakDigest() {
        this(288);
    }

    public KeccakDigest(int r100) {
        this.state = new long[25];
        this.dataQueue = new byte[192];
        init(r100);
    }

    public KeccakDigest(KeccakDigest r100) {
        long[] r101 = new long[25];
        this.state = r101;
        this.dataQueue = new byte[192];
        long[] r102 = r100.state;
        System.arraycopy(r102, 0, r101, 0, r102.length);
        byte[] r103 = r100.dataQueue;
        System.arraycopy(r103, 0, this.dataQueue, 0, r103.length);
        this.rate = r100.rate;
        this.bitsInQueue = r100.bitsInQueue;
        this.fixedOutputLength = r100.fixedOutputLength;
        this.squeezing = r100.squeezing;
    }

    private void KeccakAbsorb(byte[] r100, int r101) {
        int r102 = this.rate >>> 6;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        long[] r104 = this.state;
        r104[r103] = r104[r103] ^ Pack.littleEndianToLong(r100, r101);
        r101 = r101 + 8;
        r103 = r103 + 1;
        goto L3
    L5:
        Hex.toHexString(dumpState()).toLowerCase();
        KeccakPermutation();
    }

    private void KeccakExtract() {
        KeccakPermutation();
        dumpState();
        Pack.longToLittleEndian(this.state, 0, this.rate >>> 6, this.dataQueue, 0);
        this.bitsInQueue = this.rate;
    }

    private void KeccakPermutation() {
        long[] r100 = this.state;
        int r101 = 0;
        long r102 = r100[0];
        char r103 = 1;
        long r104 = r100[1];
        long r105 = r100[2];
        char r110 = 3;
        long r111 = r100[3];
        long r112 = r100[4];
        long r113 = r100[5];
        long r210 = r100[6];
        long r211 = r100[7];
        long r212 = r100[8];
        long r310 = r100[9];
        long r311 = r100[10];
        long r312 = r100[11];
        long r313 = r100[12];
        long r410 = r100[13];
        long r411 = r100[14];
        long r412 = r100[15];
        long r413 = r100[16];
        long r510 = r100[17];
        long r511 = r100[18];
        long r512 = r100[19];
        long r610 = r100[20];
        long r611 = r100[21];
        long r612 = r100[22];
        long r613 = r100[23];
        int r114 = 24;
        long r710 = r100[24];
    L3:
        if (r101 >= r114) goto L5;
        long r711 = (((r102 ^ r113) ^ r311) ^ r412) ^ r610;
        long r712 = (((r104 ^ r210) ^ r312) ^ r413) ^ r611;
        long r713 = (((r105 ^ r211) ^ r313) ^ r510) ^ r612;
        long r714 = (((r111 ^ r212) ^ r410) ^ r511) ^ r613;
        long r810 = (((r112 ^ r310) ^ r411) ^ r512) ^ r710;
        long r811 = ((r712 << r103) | (r712 >>> (-1))) ^ r810;
        long r812 = ((r713 << r103) | (r713 >>> (-1))) ^ r711;
        long r715 = ((r714 << r103) | (r714 >>> (-1))) ^ r712;
        long r716 = ((r810 << r103) | (r810 >>> (-1))) ^ r713;
        long r717 = ((r711 << r103) | (r711 >>> (-1))) ^ r714;
        long r106 = r102 ^ r811;
        long r115 = r113 ^ r811;
        long r314 = r311 ^ r811;
        long r414 = r412 ^ r811;
        long r614 = r610 ^ r811;
        long r107 = r104 ^ r812;
        long r213 = r210 ^ r812;
        long r315 = r312 ^ r812;
        long r415 = r413 ^ r812;
        long r615 = r611 ^ r812;
        long r108 = r105 ^ r715;
        long r214 = r211 ^ r715;
        long r316 = r313 ^ r715;
        long r513 = r510 ^ r715;
        long r616 = r612 ^ r715;
        long r116 = r111 ^ r716;
        long r215 = r212 ^ r716;
        long r416 = r410 ^ r716;
        long r514 = r511 ^ r716;
        long r617 = r613 ^ r716;
        long r117 = r112 ^ r717;
        long r317 = r310 ^ r717;
        long r417 = r411 ^ r717;
        long r515 = r512 ^ r717;
        long r718 = r710 ^ r717;
        long r109 = (r107 << r103) | (r107 >>> 63);
        long r118 = (r213 << 44) | (r213 >>> 20);
        long r119 = (r317 << 20) | (r317 >>> 44);
        long r120 = (r616 << 61) | (r616 >>> r110);
        long r121 = (r417 << 39) | (r417 >>> 25);
        long r122 = (r614 << 18) | (r614 >>> 46);
        long r123 = (r108 << 62) | (r108 >>> 2);
        long r124 = (r316 << 43) | (r316 >>> 21);
        long r125 = (r416 << 25) | (r416 >>> 39);
        long r126 = (r515 << 8) | (r515 >>> 56);
        long r127 = (r617 << 56) | (r617 >>> 8);
        long r128 = (r414 << 41) | (r414 >>> 23);
        long r129 = (r117 << 27) | (r117 >>> 37);
        long r130 = (r718 << 14) | (r718 >>> 50);
        long r131 = (r615 << 2) | (r615 >>> 62);
        long r132 = (r215 << 55) | (r215 >>> 9);
        long r133 = (r415 << 45) | (r415 >>> 19);
        long r134 = (r115 << 36) | (r115 >>> 28);
        long r135 = (r116 << 28) | (r116 >>> 36);
        long r136 = (r514 << 21) | (r514 >>> 43);
        long r137 = (r513 << 15) | (r513 >>> 49);
        long r138 = (r315 << 10) | (r315 >>> 54);
        long r139 = (r214 << 6) | (r214 >>> 58);
        long r140 = (r314 << 3) | (r314 >>> 61);
        long r141 = ((~r118) & r124) ^ r106;
        long r142 = ((~r124) & r136) ^ r118;
        r105 = r124 ^ ((~r136) & r130);
        r111 = r136 ^ ((~r130) & r106);
        long r143 = r130 ^ ((~r106) & r118);
        long r144 = r135 ^ ((~r119) & r140);
        long r145 = ((~r140) & r133) ^ r119;
        long r146 = ((~r133) & r120) ^ r140;
        long r147 = r133 ^ ((~r120) & r135);
        long r148 = ((~r135) & r119) ^ r120;
        r311 = r109 ^ ((~r139) & r125);
        long r149 = ((~r125) & r126) ^ r139;
        long r150 = ((~r126) & r122) ^ r125;
        long r151 = r126 ^ ((~r122) & r109);
        long r152 = ((~r109) & r139) ^ r122;
        long r153 = r129 ^ ((~r134) & r138);
        long r154 = ((~r138) & r137) ^ r134;
        long r155 = r138 ^ ((~r137) & r127);
        long r156 = ((~r127) & r129) ^ r137;
        long r157 = ((~r129) & r134) ^ r127;
        long r158 = r123 ^ ((~r132) & r121);
        long r159 = ((~r121) & r128) ^ r132;
        r610 = r158;
        long r160 = r121 ^ ((~r128) & r131);
        long r161 = ((~r131) & r123) ^ r128;
        long r162 = ((~r123) & r132) ^ r131;
        long r163 = r141 ^ KeccakRoundConstants[r101];
        r101 = r101 + 1;
        r210 = r145;
        r313 = r150;
        r312 = r149;
        r410 = r151;
        r611 = r159;
        r110 = 3;
        r613 = r161;
        r612 = r160;
        r310 = r148;
        r100 = r100;
        r512 = r157;
        r411 = r152;
        r211 = r146;
        r212 = r147;
        r510 = r155;
        r412 = r153;
        r112 = r143;
        r113 = r144;
        r114 = 24;
        r511 = r156;
        r413 = r154;
        r103 = 1;
        r104 = r142;
        r710 = r162;
        r102 = r163;
        goto L3
    L5:
        long[] r813 = r100;
        r813[0] = r102;
        r813[1] = r104;
        r813[2] = r105;
        r813[3] = r111;
        r813[4] = r112;
        r813[5] = r113;
        r813[6] = r210;
        r813[7] = r211;
        r813[8] = r212;
        r813[9] = r310;
        r813[10] = r311;
        r813[11] = r312;
        r813[12] = r313;
        r813[13] = r410;
        r813[14] = r411;
        r813[15] = r412;
        r813[16] = r413;
        r813[17] = r510;
        r813[18] = r511;
        r813[19] = r512;
        r813[20] = r610;
        r813[21] = r611;
        r813[22] = r612;
        r813[23] = r613;
        r813[24] = r710;
    }

    private void init(int r100) {
        if (r100 != 128) goto L5;
    L17:
        initSponge(1600 - (r100 << 1));
        return;
    L5:
        if (r100 == 224) goto L17;
        if (r100 == 256) goto L17;
        if (r100 == 288) goto L17;
        if (r100 == 384) goto L17;
        if (r100 == 512) goto L17;
        throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
    }

    private void initSponge(int r100) {
        if (r100 <= 0) goto L14;
        if (r100 >= 1600) goto L14;
        if ((r100 % 64) != 0) goto L14;
        this.rate = r100;
        int r101 = 0;
    L8:
        long[] r102 = this.state;
        if (r101 >= r102.length) goto L11;
        r102[r101] = 0;
        r101 = r101 + 1;
        goto L8
    L11:
        Arrays.fill(this.dataQueue, (byte) 0);
        this.bitsInQueue = 0;
        this.squeezing = false;
        this.fixedOutputLength = (1600 - r100) / 2;
        return;
    L14:
        throw new IllegalStateException("invalid rate value");
    }

    private void padAndSwitchToSqueezingPhase() {
        byte[] r100 = this.dataQueue;
        int r101 = this.bitsInQueue;
        int r102 = r101 >>> 3;
        r100[r102] = (byte) (r100[r102] | ((byte) (1 << (r101 & 7))));
        int r103 = r101 + 1;
        this.bitsInQueue = r103;
        if (r103 != this.rate) goto L5;
        KeccakAbsorb(r100, 0);
    L11:
        long[] r104 = this.state;
        int r105 = (this.rate - 1) >>> 6;
        r104[r105] = r104[r105] ^ Long.MIN_VALUE;
        this.bitsInQueue = 0;
        this.squeezing = true;
        return;
    L5:
        int r106 = r103 >>> 6;
        int r107 = r103 & 63;
        int r108 = 0;
        int r109 = 0;
    L6:
        if (r108 >= r106) goto L8;
        long[] r110 = this.state;
        r110[r108] = r110[r108] ^ Pack.littleEndianToLong(this.dataQueue, r109);
        r109 = r109 + 8;
        r108 = r108 + 1;
        goto L6
    L8:
        dumpState();
        if (r107 <= 0) goto L11;
        long[] r111 = this.state;
        long r112 = r111[r106];
        r111[r106] = (((1 << r107) - 1) & Pack.littleEndianToLong(this.dataQueue, r109)) ^ r112;
        goto L11
    }

    public void absorb(byte r100) {
        int r101 = this.bitsInQueue;
        if ((r101 % 8) != 0) goto L13;
        if (this.squeezing == true) goto L11;
        byte[] r102 = this.dataQueue;
        r102[r101 >>> 3] = r100;
        int r103 = r101 + 8;
        this.bitsInQueue = r103;
        if (r103 != this.rate) goto L14;
        KeccakAbsorb(r102, 0);
        this.bitsInQueue = 0;
        return;
    L14:
        return;
    L11:
        throw new IllegalStateException("attempt to absorb while squeezing");
    L13:
        throw new IllegalStateException("attempt to absorb with odd length queue");
    }

    public void absorb(byte[] r100, int r101, int r102) {
        int r103 = this.bitsInQueue;
        if ((r103 % 8) != 0) goto L22;
        if (this.squeezing == true) goto L20;
        int r104 = r103 >>> 3;
        int r105 = this.rate >>> 3;
        int r106 = r105 - r104;
        if (r102 >= r106) goto L12;
        System.arraycopy(r100, r101, this.dataQueue, r104, r102);
        int r107 = this.bitsInQueue + (r102 << 3);
    L9:
        this.bitsInQueue = r107;
        return;
    L12:
        if (r104 <= 0) goto L14;
        System.arraycopy(r100, r101, this.dataQueue, r104, r106);
        int r108 = r106 + 0;
        KeccakAbsorb(this.dataQueue, 0);
    L15:
        int r109 = r102 - r108;
        if (r109 < r105) goto L18;
        KeccakAbsorb(r100, r101 + r108);
        r108 = r108 + r105;
        goto L15
    L18:
        System.arraycopy(r100, r101 + r108, this.dataQueue, 0, r109);
        r107 = r109 << 3;
        goto L9
    L14:
        r108 = 0;
        goto L15
    L20:
        throw new IllegalStateException("attempt to absorb while squeezing");
    L22:
        throw new IllegalStateException("attempt to absorb with odd length queue");
    }

    public void absorbBits(int r100, int r101) {
        if (r101 < 1) goto L17;
        if (r101 > 7) goto L17;
        int r102 = this.bitsInQueue;
        if ((r102 % 8) != 0) goto L15;
        if (this.squeezing == true) goto L13;
        this.dataQueue[r102 >>> 3] = (byte) (r100 & ((1 << r101) - 1));
        this.bitsInQueue = r102 + r101;
        return;
    L13:
        throw new IllegalStateException("attempt to absorb while squeezing");
    L15:
        throw new IllegalStateException("attempt to absorb with odd length queue");
    L17:
        throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        squeeze(r100, r101, this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    public int doFinal(byte[] r100, int r101, byte r102, int r103) {
        if (r103 <= 0) goto L4;
        absorbBits(r102, r103);
    L4:
        squeeze(r100, r101, this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    public byte[] dumpState() {
        byte[] r100 = new byte[this.state.length * 8];
        int r101 = 0;
        int r102 = 0;
    L3:
        long[] r103 = this.state;
        if (r101 == r103.length) goto L6;
        Pack.longToLittleEndian(r103[r101], r100, r102);
        r102 = r102 + 8;
        r101 = r101 + 1;
        goto L3
    L6:
        return r100;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "Keccak-" + this.fixedOutputLength;
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.rate / 8;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.fixedOutputLength / 8;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        init(this.fixedOutputLength);
    }

    public void squeeze(byte[] r110, int r111, long r112) {
        if (this.squeezing == true) goto L5;
        padAndSwitchToSqueezingPhase();
    L5:
        dumpState();
        long r100 = 0;
        if ((r112 % 8) != 0) goto L16;
    L8:
        if (r100 >= r112) goto L13;
        if (this.bitsInQueue != 0) goto L12;
        KeccakExtract();
    L12:
        int r101 = (int) Math.min(this.bitsInQueue, r112 - r100);
        System.arraycopy(this.dataQueue, (this.rate - this.bitsInQueue) / 8, r110, ((int) (r100 / 8)) + r111, r101 / 8);
        this.bitsInQueue -= r101;
        r100 = r100 + ((long) r101);
        goto L8
    L13:
        dumpState();
        return;
    L16:
        throw new IllegalStateException("outputLength not a multiple of 8");
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        absorb(r100);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
        absorb(r100, r101, r102);
    }
}
