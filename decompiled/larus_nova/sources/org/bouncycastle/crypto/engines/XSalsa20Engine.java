package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class XSalsa20Engine extends Salsa20Engine {
    public XSalsa20Engine() {
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine, org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "XSalsa20";
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public int getNonceSize() {
        return 24;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void setKey(byte[] r100, byte[] r101) {
        if (r100 == null) goto L10;
        if (r100.length != 32) goto L8;
        super.setKey(r100, r101);
        Pack.littleEndianToInt(r101, 8, this.engineState, 8, 2);
        int[] r102 = this.engineState;
        int[] r103 = new int[r102.length];
        Salsa20Engine.salsaCore(20, r102, r103);
        int[] r104 = this.engineState;
        r104[1] = r103[0] - r104[0];
        r104[2] = r103[5] - r104[5];
        r104[3] = r103[10] - r104[10];
        r104[4] = r103[15] - r104[15];
        r104[11] = r103[6] - r104[6];
        r104[12] = r103[7] - r104[7];
        r104[13] = r103[8] - r104[8];
        r104[14] = r103[9] - r104[9];
        Pack.littleEndianToInt(r101, 16, r104, 6, 2);
        return;
    L8:
        throw new IllegalArgumentException(getAlgorithmName() + " requires a 256 bit key");
    L10:
        throw new IllegalArgumentException(getAlgorithmName() + " doesn't support re-init with null key");
    }
}
