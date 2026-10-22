package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.MQVPrivateParameters;
import org.bouncycastle.crypto.params.MQVPublicParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes42.dex */
public class ECMQVBasicAgreement implements BasicAgreement {
    MQVPrivateParameters privParams;

    public ECMQVBasicAgreement() {
    }

    private ECPoint calculateMqvAgreement(ECDomainParameters r100, ECPrivateKeyParameters r101, ECPrivateKeyParameters r102, ECPublicKeyParameters r103, ECPublicKeyParameters r104, ECPublicKeyParameters r110) {
        BigInteger r105 = r100.getN();
        int r106 = (r105.bitLength() + 1) / 2;
        BigInteger r107 = ECConstants.ONE.shiftLeft(r106);
        ECCurve r108 = r100.getCurve();
        ECPoint r109 = ECAlgorithms.cleanPoint(r108, r103.getQ());
        ECPoint r111 = ECAlgorithms.cleanPoint(r108, r104.getQ());
        ECPoint r112 = ECAlgorithms.cleanPoint(r108, r110.getQ());
        BigInteger r113 = r109.getAffineXCoord().toBigInteger().mod(r107).setBit(r106);
        BigInteger r114 = r101.getD().multiply(r113).add(r102.getD()).mod(r105);
        BigInteger r115 = r112.getAffineXCoord().toBigInteger().mod(r107).setBit(r106);
        BigInteger r116 = r100.getH().multiply(r114).mod(r105);
        return ECAlgorithms.sumOfTwoMultiplies(r111, r115.multiply(r116).mod(r105), r112, r116);
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters r100) {
        if (Properties.isOverrideSet("org.bouncycastle.ec.disable_mqv") == true) goto L15;
        MQVPublicParameters r101 = (MQVPublicParameters) r100;
        ECPrivateKeyParameters r102 = this.privParams.getStaticPrivateKey();
        ECDomainParameters r103 = r102.getParameters();
        if (r103.equals(r101.getStaticPublicKey().getParameters()) == false) goto L13;
        ECPoint r104 = calculateMqvAgreement(r103, r102, this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), r101.getStaticPublicKey(), r101.getEphemeralPublicKey()).normalize();
        if (r104.isInfinity() == true) goto L11;
        return r104.getAffineXCoord().toBigInteger();
    L11:
        throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
    L13:
        throw new IllegalStateException("ECMQV public key components have wrong domain parameters");
    L15:
        throw new IllegalStateException("ECMQV explicitly disabled");
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public int getFieldSize() {
        return (this.privParams.getStaticPrivateKey().getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public void init(CipherParameters r100) {
        this.privParams = (MQVPrivateParameters) r100;
    }
}
