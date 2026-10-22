package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class ECDHCBasicAgreement implements BasicAgreement {
    ECPrivateKeyParameters key;

    public ECDHCBasicAgreement() {
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters r100) {
        ECPublicKeyParameters r101 = (ECPublicKeyParameters) r100;
        ECDomainParameters r102 = this.key.getParameters();
        if (r102.equals(r101.getParameters()) == false) goto L15;
        BigInteger r103 = r102.getH().multiply(this.key.getD()).mod(r102.getN());
        ECPoint r104 = ECAlgorithms.cleanPoint(r102.getCurve(), r101.getQ());
        if (r104.isInfinity() == true) goto L13;
        ECPoint r105 = r104.multiply(r103).normalize();
        if (r105.isInfinity() == true) goto L11;
        return r105.getAffineXCoord().toBigInteger();
    L11:
        throw new IllegalStateException("Infinity is not a valid agreement value for ECDHC");
    L13:
        throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
    L15:
        throw new IllegalStateException("ECDHC public key has wrong domain parameters");
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public int getFieldSize() {
        return (this.key.getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public void init(CipherParameters r100) {
        this.key = (ECPrivateKeyParameters) r100;
    }
}
