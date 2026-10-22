package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.DHUPrivateParameters;
import org.bouncycastle.crypto.params.DHUPublicParameters;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class DHUnifiedAgreement {
    private DHUPrivateParameters privParams;

    public DHUnifiedAgreement() {
    }

    public byte[] calculateAgreement(CipherParameters r100) {
        DHUPublicParameters r101 = (DHUPublicParameters) r100;
        DHBasicAgreement r102 = new DHBasicAgreement();
        DHBasicAgreement r103 = new DHBasicAgreement();
        r102.init(this.privParams.getStaticPrivateKey());
        BigInteger r104 = r102.calculateAgreement(r101.getStaticPublicKey());
        r103.init(this.privParams.getEphemeralPrivateKey());
        BigInteger r105 = r103.calculateAgreement(r101.getEphemeralPublicKey());
        int r106 = getFieldSize();
        byte[] r107 = new byte[r106 * 2];
        BigIntegers.asUnsignedByteArray(r105, r107, 0, r106);
        BigIntegers.asUnsignedByteArray(r104, r107, r106, r106);
        return r107;
    }

    public int getFieldSize() {
        return (this.privParams.getStaticPrivateKey().getParameters().getP().bitLength() + 7) / 8;
    }

    public void init(CipherParameters r100) {
        this.privParams = (DHUPrivateParameters) r100;
    }
}
