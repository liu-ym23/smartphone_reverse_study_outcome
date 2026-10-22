package org.bouncycastle.crypto.engines;

/* JADX INFO: loaded from: classes42.dex */
public final class CAST6Engine extends CAST5Engine {
    protected static final int BLOCK_SIZE = 16;
    protected static final int ROUNDS = 12;
    protected int[] _Km;
    protected int[] _Kr;
    protected int[] _Tm;
    protected int[] _Tr;
    private int[] _workingKey;

    public CAST6Engine() {
        this._Kr = new int[48];
        this._Km = new int[48];
        this._Tr = new int[192];
        this._Tm = new int[192];
        this._workingKey = new int[8];
    }

    public final void CAST_Decipher(int r100, int r101, int r110, int r111, int[] r112) {
        int r102 = 0;
    L3:
        int r103 = 6;
        if (r102 >= 6) goto L7;
        int r104 = (11 - r102) * 4;
        r110 = r110 ^ F1(r111, this._Km[r104], this._Kr[r104]);
        int r105 = r104 + 1;
        r101 = r101 ^ F2(r110, this._Km[r105], this._Kr[r105]);
        int r106 = r104 + 2;
        r100 = r100 ^ F3(r101, this._Km[r106], this._Kr[r106]);
        int r107 = r104 + 3;
        r111 = r111 ^ F1(r100, this._Km[r107], this._Kr[r107]);
        r102 = r102 + 1;
    L7:
        if (r103 >= 12) goto L9;
        int r108 = (11 - r103) * 4;
        int r109 = r108 + 3;
        r111 = r111 ^ F1(r100, this._Km[r109], this._Kr[r109]);
        int r113 = r108 + 2;
        r100 = r100 ^ F3(r101, this._Km[r113], this._Kr[r113]);
        int r114 = r108 + 1;
        r101 = r101 ^ F2(r110, this._Km[r114], this._Kr[r114]);
        r110 = r110 ^ F1(r111, this._Km[r108], this._Kr[r108]);
        r103 = r103 + 1;
        goto L7
    L9:
        r112[0] = r100;
        r112[1] = r101;
        r112[2] = r110;
        r112[3] = r111;
    }

    public final void CAST_Encipher(int r100, int r101, int r110, int r111, int[] r112) {
        int r102 = 0;
    L3:
        int r103 = 6;
        if (r102 >= 6) goto L7;
        int r104 = r102 * 4;
        r110 = r110 ^ F1(r111, this._Km[r104], this._Kr[r104]);
        int r105 = r104 + 1;
        r101 = r101 ^ F2(r110, this._Km[r105], this._Kr[r105]);
        int r106 = r104 + 2;
        r100 = r100 ^ F3(r101, this._Km[r106], this._Kr[r106]);
        int r107 = r104 + 3;
        r111 = r111 ^ F1(r100, this._Km[r107], this._Kr[r107]);
        r102 = r102 + 1;
    L7:
        if (r103 >= 12) goto L9;
        int r108 = r103 * 4;
        int r109 = r108 + 3;
        r111 = r111 ^ F1(r100, this._Km[r109], this._Kr[r109]);
        int r113 = r108 + 2;
        r100 = r100 ^ F3(r101, this._Km[r113], this._Kr[r113]);
        int r114 = r108 + 1;
        r101 = r101 ^ F2(r110, this._Km[r114], this._Kr[r114]);
        r110 = r110 ^ F1(r111, this._Km[r108], this._Kr[r108]);
        r103 = r103 + 1;
        goto L7
    L9:
        r112[0] = r100;
        r112[1] = r101;
        r112[2] = r110;
        r112[3] = r111;
    }

    @Override // org.bouncycastle.crypto.engines.CAST5Engine
    public int decryptBlock(byte[] r100, int r101, byte[] r110, int r111) {
        int[] r102 = new int[4];
        CAST_Decipher(BytesTo32bits(r100, r101), BytesTo32bits(r100, r101 + 4), BytesTo32bits(r100, r101 + 8), BytesTo32bits(r100, r101 + 12), r102);
        Bits32ToBytes(r102[0], r110, r111);
        Bits32ToBytes(r102[1], r110, r111 + 4);
        Bits32ToBytes(r102[2], r110, r111 + 8);
        Bits32ToBytes(r102[3], r110, r111 + 12);
        return 16;
    }

    @Override // org.bouncycastle.crypto.engines.CAST5Engine
    public int encryptBlock(byte[] r100, int r101, byte[] r110, int r111) {
        int[] r102 = new int[4];
        CAST_Encipher(BytesTo32bits(r100, r101), BytesTo32bits(r100, r101 + 4), BytesTo32bits(r100, r101 + 8), BytesTo32bits(r100, r101 + 12), r102);
        Bits32ToBytes(r102[0], r110, r111);
        Bits32ToBytes(r102[1], r110, r111 + 4);
        Bits32ToBytes(r102[2], r110, r111 + 8);
        Bits32ToBytes(r102[3], r110, r111 + 12);
        return 16;
    }

    @Override // org.bouncycastle.crypto.engines.CAST5Engine, org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "CAST6";
    }

    @Override // org.bouncycastle.crypto.engines.CAST5Engine, org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.engines.CAST5Engine, org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }

    @Override // org.bouncycastle.crypto.engines.CAST5Engine
    public void setKey(byte[] r110) {
        int r100 = 1518500249;
        int r101 = 19;
        int r102 = 0;
    L4:
        if (r102 >= 24) goto L9;
        int r103 = 0;
    L6:
        if (r103 >= 8) goto L8;
        int r104 = (r102 * 8) + r103;
        this._Tm[r104] = r100;
        r100 = r100 + 1859775393;
        this._Tr[r104] = r101;
        r101 = (r101 + 17) & 31;
        r103 = r103 + 1;
        goto L6
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        byte[] r105 = new byte[64];
        System.arraycopy(r110, 0, r105, 0, r110.length);
        int r106 = 0;
    L10:
        if (r106 >= 8) goto L12;
        this._workingKey[r106] = BytesTo32bits(r105, r106 * 4);
        r106 = r106 + 1;
        goto L10
    L12:
        int r107 = 0;
    L14:
        if (r107 >= 12) goto L16;
        int r108 = r107 * 2;
        int r109 = r108 * 8;
        int[] r111 = this._workingKey;
        r111[6] = r111[6] ^ F1(r111[7], this._Tm[r109], this._Tr[r109]);
        int[] r112 = this._workingKey;
        int r113 = r109 + 1;
        r112[5] = r112[5] ^ F2(r112[6], this._Tm[r113], this._Tr[r113]);
        int[] r114 = this._workingKey;
        int r115 = r109 + 2;
        r114[4] = r114[4] ^ F3(r114[5], this._Tm[r115], this._Tr[r115]);
        int[] r116 = this._workingKey;
        int r117 = r116[3];
        int r118 = r109 + 3;
        r116[3] = F1(r116[4], this._Tm[r118], this._Tr[r118]) ^ r117;
        int[] r119 = this._workingKey;
        int r120 = r119[2];
        int r121 = r109 + 4;
        r119[2] = F2(r119[3], this._Tm[r121], this._Tr[r121]) ^ r120;
        int[] r122 = this._workingKey;
        int r123 = r122[1];
        int r124 = r109 + 5;
        r122[1] = F3(r122[2], this._Tm[r124], this._Tr[r124]) ^ r123;
        int[] r125 = this._workingKey;
        int r126 = r109 + 6;
        r125[0] = r125[0] ^ F1(r125[1], this._Tm[r126], this._Tr[r126]);
        int[] r127 = this._workingKey;
        int r128 = r127[7];
        int r129 = r109 + 7;
        r127[7] = F2(r127[0], this._Tm[r129], this._Tr[r129]) ^ r128;
        int r130 = (r108 + 1) * 8;
        int[] r131 = this._workingKey;
        r131[6] = r131[6] ^ F1(r131[7], this._Tm[r130], this._Tr[r130]);
        int[] r132 = this._workingKey;
        int r133 = r130 + 1;
        r132[5] = r132[5] ^ F2(r132[6], this._Tm[r133], this._Tr[r133]);
        int[] r134 = this._workingKey;
        int r135 = r130 + 2;
        r134[4] = r134[4] ^ F3(r134[5], this._Tm[r135], this._Tr[r135]);
        int[] r136 = this._workingKey;
        int r137 = r136[3];
        int r138 = r130 + 3;
        r136[3] = F1(r136[4], this._Tm[r138], this._Tr[r138]) ^ r137;
        int[] r139 = this._workingKey;
        int r140 = r139[2];
        int r141 = r130 + 4;
        r139[2] = F2(r139[3], this._Tm[r141], this._Tr[r141]) ^ r140;
        int[] r142 = this._workingKey;
        int r143 = r142[1];
        int r144 = r130 + 5;
        r142[1] = F3(r142[2], this._Tm[r144], this._Tr[r144]) ^ r143;
        int[] r145 = this._workingKey;
        int r146 = r130 + 6;
        r145[0] = r145[0] ^ F1(r145[1], this._Tm[r146], this._Tr[r146]);
        int[] r147 = this._workingKey;
        int r148 = r147[7];
        int r149 = r130 + 7;
        r147[7] = F2(r147[0], this._Tm[r149], this._Tr[r149]) ^ r148;
        int[] r150 = this._Kr;
        int r151 = r107 * 4;
        int[] r152 = this._workingKey;
        r150[r151] = r152[0] & 31;
        int r153 = r151 + 1;
        r150[r153] = r152[2] & 31;
        int r154 = r151 + 2;
        r150[r154] = r152[4] & 31;
        int r155 = r151 + 3;
        r150[r155] = r152[6] & 31;
        int[] r156 = this._Km;
        r156[r151] = r152[7];
        r156[r153] = r152[5];
        r156[r154] = r152[3];
        r156[r155] = r152[1];
        r107 = r107 + 1;
        goto L14
    }
}
