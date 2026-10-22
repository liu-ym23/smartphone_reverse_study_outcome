package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
public class PKCS5S1ParametersGenerator extends PBEParametersGenerator {
    private Digest digest;

    public PKCS5S1ParametersGenerator(Digest r100) {
        this.digest = r100;
    }

    private byte[] generateDerivedKey() {
        int r100 = this.digest.getDigestSize();
        byte[] r101 = new byte[r100];
        Digest r102 = this.digest;
        byte[] r103 = this.password;
        r102.update(r103, 0, r103.length);
        Digest r104 = this.digest;
        byte[] r105 = this.salt;
        r104.update(r105, 0, r105.length);
        this.digest.doFinal(r101, 0);
        int r106 = 1;
    L4:
        if (r106 >= this.iterationCount) goto L6;
        this.digest.update(r101, 0, r100);
        this.digest.doFinal(r101, 0);
        r106 = r106 + 1;
        goto L4
    L6:
        return r101;
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int r100) {
        return generateDerivedParameters(r100);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r100) {
        int r101 = r100 / 8;
        if (r101 > this.digest.getDigestSize()) goto L7;
        return new KeyParameter(generateDerivedKey(), 0, r101);
    L7:
        throw new IllegalArgumentException("Can't generate a derived key " + r101 + " bytes long.");
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r100, int r101) {
        int r102 = r100 / 8;
        int r103 = r101 / 8;
        int r104 = r102 + r103;
        if (r104 > this.digest.getDigestSize()) goto L7;
        byte[] r105 = generateDerivedKey();
        return new ParametersWithIV(new KeyParameter(r105, 0, r102), r105, r102, r103);
    L7:
        throw new IllegalArgumentException("Can't generate a derived key " + r104 + " bytes long.");
    }
}
