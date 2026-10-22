package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class ECVKOAgreement {
    private final Digest digest;
    private ECPrivateKeyParameters key;
    private BigInteger ukm;

    public ECVKOAgreement(Digest r100) {
        this.digest = r100;
    }

    private byte[] fromPoint(ECPoint r100) {
        BigInteger r101 = r100.getAffineXCoord().toBigInteger();
        BigInteger r102 = r100.getAffineYCoord().toBigInteger();
        if (r101.toByteArray().length <= 33) goto L5;
        int r103 = 64;
    L6:
        int r104 = r103 * 2;
        byte[] r105 = new byte[r104];
        byte[] r106 = BigIntegers.asUnsignedByteArray(r103, r101);
        byte[] r107 = BigIntegers.asUnsignedByteArray(r103, r102);
        int r108 = 0;
    L7:
        if (r108 == r103) goto L9;
        r105[r108] = r106[(r103 - r108) - 1];
        r108 = r108 + 1;
        goto L7
    L9:
        int r109 = 0;
    L10:
        if (r109 == r103) goto L12;
        r105[r103 + r109] = r107[(r103 - r109) - 1];
        r109 = r109 + 1;
        goto L10
    L12:
        this.digest.update(r105, 0, r104);
        byte[] r110 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(r110, 0);
        return r110;
    L5:
        r103 = 32;
        goto L6
    }

    private static BigInteger toInteger(byte[] r100) {
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L4:
        if (r103 == r101) goto L7;
        r102[r103] = r100[(r100.length - r103) - 1];
        r103 = r103 + 1;
        goto L4
    L7:
        return new BigInteger(1, r102);
    }

    public byte[] calculateAgreement(CipherParameters r100) {
        ECPublicKeyParameters r101 = (ECPublicKeyParameters) r100;
        ECDomainParameters r102 = this.key.getParameters();
        if (r102.equals(r101.getParameters()) == false) goto L15;
        BigInteger r103 = r102.getH().multiply(this.ukm).multiply(this.key.getD()).mod(r102.getN());
        ECPoint r104 = ECAlgorithms.cleanPoint(r102.getCurve(), r101.getQ());
        if (r104.isInfinity() == true) goto L13;
        ECPoint r105 = r104.multiply(r103).normalize();
        if (r105.isInfinity() == true) goto L11;
        return fromPoint(r105);
    L11:
        throw new IllegalStateException("Infinity is not a valid agreement value for ECVKO");
    L13:
        throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
    L15:
        throw new IllegalStateException("ECVKO public key has wrong domain parameters");
    }

    public int getFieldSize() {
        return (this.key.getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public void init(CipherParameters r100) {
        ParametersWithUKM r101 = (ParametersWithUKM) r100;
        this.key = (ECPrivateKeyParameters) r101.getParameters();
        this.ukm = toInteger(r101.getUKM());
    }
}
