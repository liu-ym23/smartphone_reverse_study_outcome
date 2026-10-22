package org.bouncycastle.crypto.engines;

import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class ChaCha7539Engine extends Salsa20Engine {
    public ChaCha7539Engine() {
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void advanceCounter() {
        int[] r100 = this.engineState;
        int r101 = r100[12] + 1;
        r100[12] = r101;
        if (r101 == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("attempt to increase counter past 2^32.");
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void advanceCounter(long r100) {
        int r101 = (int) r100;
        if (((int) (r100 >>> 32)) > 0) goto L12;
        int[] r102 = this.engineState;
        int r103 = r102[12];
        int r104 = r101 + r103;
        r102[12] = r104;
        if (r103 == 0) goto L10;
        if (r104 < r103) goto L9;
        return;
    L9:
        throw new IllegalStateException("attempt to increase counter past 2^32.");
    L10:
        return;
    L12:
        throw new IllegalStateException("attempt to increase counter past 2^32.");
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void generateKeyStream(byte[] r100) {
        ChaChaEngine.chachaCore(this.rounds, this.engineState, this.f525201x);
        Pack.intToLittleEndian(this.f525201x, r100, 0);
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine, org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "ChaCha7539";
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public long getCounter() {
        return ((long) this.engineState[12]) & BodyPartID.bodyIdMax;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public int getNonceSize() {
        return 12;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void resetCounter() {
        this.engineState[12] = 0;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void retreatCounter() {
        int[] r100 = this.engineState;
        int r101 = r100[12];
        if (r101 == 0) goto L7;
        r100[12] = r101 - 1;
        return;
    L7:
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void retreatCounter(long r110) {
        int r111 = (int) r110;
        if (((int) (r110 >>> 32)) != 0) goto L11;
        int[] r100 = this.engineState;
        int r101 = r100[12];
        if ((((long) r101) & BodyPartID.bodyIdMax) < (BodyPartID.bodyIdMax & ((long) r111))) goto L9;
        r100[12] = r101 - r111;
        return;
    L9:
        throw new IllegalStateException("attempt to reduce counter past zero.");
    L11:
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void setKey(byte[] r100, byte[] r101) {
        if (r100 != null) goto L5;
    L9:
        Pack.littleEndianToInt(r101, 0, this.engineState, 13, 3);
        return;
    L5:
        if (r100.length != 32) goto L8;
        packTauOrSigma(r100.length, this.engineState, 0);
        Pack.littleEndianToInt(r100, 0, this.engineState, 4, 8);
        goto L9
    L8:
        throw new IllegalArgumentException(getAlgorithmName() + " requires 256 bit key");
    }
}
