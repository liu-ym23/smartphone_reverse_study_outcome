package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class ECDHBasicAgreement implements BasicAgreement {
    private ECPrivateKeyParameters key;

    public ECDHBasicAgreement() {
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters r100) {
        ECPublicKeyParameters r101 = (ECPublicKeyParameters) r100;
        ECDomainParameters r102 = this.key.getParameters();
        if (r102.equals(r101.getParameters()) == false) goto L18;
        BigInteger r103 = this.key.getD();
        ECPoint r104 = ECAlgorithms.cleanPoint(r102.getCurve(), r101.getQ());
        if (r104.isInfinity() == true) goto L16;
        BigInteger r105 = r102.getH();
        if (r105.equals(ECConstants.ONE) == true) goto L9;
        r103 = r102.getHInv().multiply(r103).mod(r102.getN());
        r104 = ECAlgorithms.referenceMultiply(r104, r105);
    L9:
        ECPoint r106 = r104.multiply(r103).normalize();
        if (r106.isInfinity() == true) goto L14;
        return r106.getAffineXCoord().toBigInteger();
    L14:
        throw new IllegalStateException("Infinity is not a valid agreement value for ECDH");
    L16:
        throw new IllegalStateException("Infinity is not a valid public key for ECDH");
    L18:
        throw new IllegalStateException("ECDH public key has wrong domain parameters");
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
