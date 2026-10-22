package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.StagedAgreement;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class ECDHCStagedAgreement implements StagedAgreement {
    ECPrivateKeyParameters key;

    public ECDHCStagedAgreement() {
    }

    private ECPoint calculateNextPoint(ECPublicKeyParameters r100) {
        ECDomainParameters r101 = this.key.getParameters();
        if (r101.equals(r100.getParameters()) == false) goto L14;
        BigInteger r102 = r101.getH().multiply(this.key.getD()).mod(r101.getN());
        ECPoint r103 = ECAlgorithms.cleanPoint(r101.getCurve(), r100.getQ());
        if (r103.isInfinity() == true) goto L12;
        ECPoint r104 = r103.multiply(r102).normalize();
        if (r104.isInfinity() == true) goto L10;
        return r104;
    L10:
        throw new IllegalStateException("Infinity is not a valid agreement value for ECDHC");
    L12:
        throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
    L14:
        throw new IllegalStateException("ECDHC public key has wrong domain parameters");
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters r100) {
        return calculateNextPoint((ECPublicKeyParameters) r100).getAffineXCoord().toBigInteger();
    }

    @Override // org.bouncycastle.crypto.StagedAgreement
    public AsymmetricKeyParameter calculateStage(CipherParameters r100) {
        return new ECPublicKeyParameters(calculateNextPoint((ECPublicKeyParameters) r100), this.key.getParameters());
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
