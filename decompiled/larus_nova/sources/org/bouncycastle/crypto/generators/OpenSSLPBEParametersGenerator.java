package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;

/* JADX INFO: loaded from: classes42.dex */
public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {
    private Digest digest;

    public OpenSSLPBEParametersGenerator() {
        this.digest = DigestFactory.createMD5();
    }

    private byte[] generateDerivedKey(int r100) {
        int r101 = this.digest.getDigestSize();
        byte[] r102 = new byte[r101];
        byte[] r103 = new byte[r100];
        int r104 = 0;
    L3:
        Digest r105 = this.digest;
        byte[] r106 = this.password;
        r105.update(r106, 0, r106.length);
        Digest r107 = this.digest;
        byte[] r108 = this.salt;
        r107.update(r108, 0, r108.length);
        this.digest.doFinal(r102, 0);
        if (r100 <= r101) goto L6;
        int r109 = r101;
    L7:
        System.arraycopy(r102, 0, r103, r104, r109);
        r104 = r104 + r109;
        r100 = r100 - r109;
        if (r100 == 0) goto L9;
        this.digest.reset();
        this.digest.update(r102, 0, r101);
        goto L3
    L9:
        return r103;
    L6:
        r109 = r100;
        goto L7
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int r100) {
        return generateDerivedParameters(r100);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r100) {
        int r101 = r100 / 8;
        return new KeyParameter(generateDerivedKey(r101), 0, r101);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r100, int r101) {
        int r102 = r100 / 8;
        int r103 = r101 / 8;
        byte[] r104 = generateDerivedKey(r102 + r103);
        return new ParametersWithIV(new KeyParameter(r104, 0, r102), r104, r102, r103);
    }

    public void init(byte[] r100, byte[] r101) {
        super.init(r100, r101, 1);
    }
}
