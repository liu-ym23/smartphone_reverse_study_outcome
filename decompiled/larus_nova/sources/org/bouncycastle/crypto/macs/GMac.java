package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
public class GMac implements Mac {
    private final GCMBlockCipher cipher;
    private final int macSizeBits;

    public GMac(GCMBlockCipher r100) {
        this.cipher = r100;
        this.macSizeBits = 128;
    }

    public GMac(GCMBlockCipher r100, int r101) {
        this.cipher = r100;
        this.macSizeBits = r101;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r101) throws DataLengthException, IllegalStateException {
        return this.cipher.doFinal(r100, r101);
    L4:
        e = move-exception;
        throw new IllegalStateException(e.toString());
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.cipher.getUnderlyingCipher().getAlgorithmName() + "-GMAC";
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.macSizeBits / 8;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) throws IllegalArgumentException {
        if ((r100 instanceof ParametersWithIV) == false) goto L7;
        ParametersWithIV r101 = (ParametersWithIV) r100;
        byte[] r102 = r101.getIV();
        KeyParameter r103 = (KeyParameter) r101.getParameters();
        this.cipher.init(true, new AEADParameters(r103, this.macSizeBits, r102));
        return;
    L7:
        throw new IllegalArgumentException("GMAC requires ParametersWithIV");
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        this.cipher.reset();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r100) throws IllegalStateException {
        this.cipher.processAADByte(r100);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r100, int r101, int r102) throws DataLengthException, IllegalStateException {
        this.cipher.processAADBytes(r100, r101, r102);
    }
}
