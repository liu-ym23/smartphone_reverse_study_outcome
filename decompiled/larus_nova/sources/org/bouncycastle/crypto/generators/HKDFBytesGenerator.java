package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.HKDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class HKDFBytesGenerator implements DerivationFunction {
    private byte[] currentT;
    private int generatedBytes;
    private HMac hMacHash;
    private int hashLen;
    private byte[] info;

    public HKDFBytesGenerator(Digest r100) {
        this.hMacHash = new HMac(r100);
        this.hashLen = r100.getDigestSize();
    }

    private void expandNext() throws DataLengthException {
        int r100 = this.generatedBytes;
        int r101 = this.hashLen;
        int r102 = (r100 / r101) + 1;
        if (r102 >= 256) goto L10;
        if (r100 == 0) goto L7;
        this.hMacHash.update(this.currentT, 0, r101);
    L7:
        HMac r103 = this.hMacHash;
        byte[] r104 = this.info;
        r103.update(r104, 0, r104.length);
        this.hMacHash.update((byte) r102);
        this.hMacHash.doFinal(this.currentT, 0);
        return;
    L10:
        throw new DataLengthException("HKDF cannot generate more than 255 blocks of HashLen size");
    }

    private KeyParameter extract(byte[] r100, byte[] r101) {
        if (r100 != null) goto L4;
        this.hMacHash.init(new KeyParameter(new byte[this.hashLen]));
    L5:
        this.hMacHash.update(r101, 0, r101.length);
        byte[] r102 = new byte[this.hashLen];
        this.hMacHash.doFinal(r102, 0);
        return new KeyParameter(r102);
    L4:
        this.hMacHash.init(new KeyParameter(r100));
        goto L5
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] r100, int r101, int r102) throws DataLengthException, IllegalArgumentException {
        int r103 = this.generatedBytes;
        int r104 = r103 + r102;
        int r105 = this.hashLen;
        if (r104 > (r105 * 255)) goto L13;
        if ((r103 % r105) != 0) goto L7;
        expandNext();
    L7:
        int r106 = this.generatedBytes;
        int r107 = this.hashLen;
        int r108 = r106 % r107;
        int r109 = Math.min(r107 - (r106 % r107), r102);
        System.arraycopy(this.currentT, r108, r100, r101, r109);
        this.generatedBytes += r109;
        int r110 = r102 - r109;
    L8:
        r101 = r101 + r109;
        if (r110 <= 0) goto L11;
        expandNext();
        r109 = Math.min(this.hashLen, r110);
        System.arraycopy(this.currentT, 0, r100, r101, r109);
        this.generatedBytes += r109;
        r110 = r110 - r109;
        goto L8
    L11:
        return r102;
    L13:
        throw new DataLengthException("HKDF may only be used for 255 * HashLen bytes of output");
    }

    public Digest getDigest() {
        return this.hMacHash.getUnderlyingDigest();
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters r100) {
        if ((r100 instanceof HKDFParameters) == false) goto L11;
        HKDFParameters r101 = (HKDFParameters) r100;
        if (r101.skipExtract() == false) goto L7;
        HMac r102 = this.hMacHash;
        KeyParameter r103 = new KeyParameter(r101.getIKM());
    L8:
        r102.init(r103);
        this.info = r101.getInfo();
        this.generatedBytes = 0;
        this.currentT = new byte[this.hashLen];
        return;
    L7:
        r102 = this.hMacHash;
        r103 = extract(r101.getSalt(), r101.getIKM());
        goto L8
    L11:
        throw new IllegalArgumentException("HKDF parameters required for HKDFBytesGenerator");
    }
}
