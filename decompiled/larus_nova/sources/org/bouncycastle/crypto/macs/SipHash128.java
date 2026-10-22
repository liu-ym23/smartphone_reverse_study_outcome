package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SipHash128 extends SipHash {
    public SipHash128() {
    }

    public SipHash128(int r100, int r101) {
        super(r100, r101);
    }

    @Override // org.bouncycastle.crypto.macs.SipHash, org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r110) throws DataLengthException, IllegalStateException {
        long r101 = this.f525253m;
        int r102 = this.wordPos;
        this.f525253m = ((r101 >>> ((7 - r102) << 3)) >>> 8) | ((((long) ((this.wordCount << 3) + r102)) & 255) << 56);
        processMessageWord();
        this.f525256v2 ^= 238;
        applySipRounds(this.f525250d);
        long r103 = this.f525254v0;
        long r104 = this.f525255v1;
        long r105 = ((r103 ^ r104) ^ this.f525256v2) ^ this.f525257v3;
        this.f525255v1 = r104 ^ 221;
        applySipRounds(this.f525250d);
        long r106 = ((this.f525254v0 ^ this.f525255v1) ^ this.f525256v2) ^ this.f525257v3;
        reset();
        Pack.longToLittleEndian(r105, r100, r110);
        Pack.longToLittleEndian(r106, r100, r110 + 8);
        return 16;
    }

    @Override // org.bouncycastle.crypto.macs.SipHash
    public long doFinal() throws DataLengthException, IllegalStateException {
        throw new UnsupportedOperationException("doFinal() is not supported");
    }

    @Override // org.bouncycastle.crypto.macs.SipHash, org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "SipHash128-" + this.f525249c + "-" + this.f525250d;
    }

    @Override // org.bouncycastle.crypto.macs.SipHash, org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.macs.SipHash, org.bouncycastle.crypto.Mac
    public void reset() {
        super.reset();
        this.f525255v1 ^= 238;
    }
}
