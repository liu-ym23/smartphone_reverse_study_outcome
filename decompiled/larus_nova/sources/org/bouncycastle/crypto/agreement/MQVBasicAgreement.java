package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.DHMQVPrivateParameters;
import org.bouncycastle.crypto.params.DHMQVPublicParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;

/* JADX INFO: loaded from: classes42.dex */
public class MQVBasicAgreement implements BasicAgreement {
    private static final BigInteger ONE = null;
    DHMQVPrivateParameters privParams;

    static {
        ONE = BigInteger.valueOf(1);
    }

    public MQVBasicAgreement() {
    }

    private BigInteger calculateDHMQVAgreement(DHParameters r100, DHPrivateKeyParameters r101, DHPublicKeyParameters r102, DHPrivateKeyParameters r103, DHPublicKeyParameters r104, DHPublicKeyParameters r110) {
        BigInteger r105 = r100.getQ();
        int r106 = (r105.bitLength() + 1) / 2;
        BigInteger r107 = BigInteger.valueOf(2).pow(r106);
        BigInteger r108 = r104.getY().mod(r107).add(r107);
        BigInteger r109 = r103.getX().add(r108.multiply(r101.getX())).mod(r105);
        BigInteger r111 = r110.getY().mod(r107).add(r107);
        return r110.getY().multiply(r102.getY().modPow(r111, r100.getP())).modPow(r109, r100.getP());
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters r100) {
        DHMQVPublicParameters r101 = (DHMQVPublicParameters) r100;
        DHPrivateKeyParameters r102 = this.privParams.getStaticPrivateKey();
        if (this.privParams.getStaticPrivateKey().getParameters().equals(r101.getStaticPublicKey().getParameters()) == false) goto L14;
        if (this.privParams.getStaticPrivateKey().getParameters().getQ() == null) goto L12;
        BigInteger r103 = calculateDHMQVAgreement(r102.getParameters(), r102, r101.getStaticPublicKey(), this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), r101.getEphemeralPublicKey());
        if (r103.equals(ONE) == true) goto L10;
        return r103;
    L10:
        throw new IllegalStateException("1 is not a valid agreement value for MQV");
    L12:
        throw new IllegalStateException("MQV key domain parameters do not have Q set");
    L14:
        throw new IllegalStateException("MQV public key components have wrong domain parameters");
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public int getFieldSize() {
        return (this.privParams.getStaticPrivateKey().getParameters().getP().bitLength() + 7) / 8;
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public void init(CipherParameters r100) {
        this.privParams = (DHMQVPrivateParameters) r100;
    }
}
