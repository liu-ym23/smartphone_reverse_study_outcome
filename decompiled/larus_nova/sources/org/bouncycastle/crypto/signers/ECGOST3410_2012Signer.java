package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class ECGOST3410_2012Signer implements DSAExt {
    ECKeyParameters key;
    SecureRandom random;

    public ECGOST3410_2012Signer() {
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] r110) {
        BigInteger r100 = new BigInteger(1, Arrays.reverse(r110));
        ECDomainParameters r111 = this.key.getParameters();
        BigInteger r101 = r111.getN();
        BigInteger r102 = ((ECPrivateKeyParameters) this.key).getD();
        ECMultiplier r103 = createBasePointMultiplier();
    L3:
        BigInteger r104 = BigIntegers.createRandomBigInteger(r101.bitLength(), this.random);
        BigInteger r105 = ECConstants.ZERO;
        if (r104.equals(r105) == true) goto L3;
        BigInteger r106 = r103.multiply(r111.getG(), r104).normalize().getAffineXCoord().toBigInteger().mod(r101);
        if (r106.equals(r105) == true) goto L3;
        BigInteger r107 = r104.multiply(r100).add(r102.multiply(r106)).mod(r101);
        if (r107.equals(r105) == true) goto L3;
        return new BigInteger[]{r106, r107};
    }

    @Override // org.bouncycastle.crypto.DSAExt
    public BigInteger getOrder() {
        return this.key.getParameters().getN();
    }

    @Override // org.bouncycastle.crypto.DSA
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == true) goto L4;
        ECKeyParameters r102 = (ECPublicKeyParameters) r101;
    L8:
        this.key = r102;
        return;
    L4:
        if ((r101 instanceof ParametersWithRandom) == false) goto L6;
        ParametersWithRandom r103 = (ParametersWithRandom) r101;
        this.random = r103.getRandom();
        this.key = (ECPrivateKeyParameters) r103.getParameters();
        return;
    L6:
        this.random = CryptoServicesRegistrar.getSecureRandom();
        r102 = (ECPrivateKeyParameters) r101;
        goto L8
    }

    @Override // org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] r100, BigInteger r101, BigInteger r102) {
        BigInteger r103 = new BigInteger(1, Arrays.reverse(r100));
        BigInteger r104 = this.key.getParameters().getN();
        BigInteger r105 = ECConstants.ONE;
        if (r101.compareTo(r105) >= 0) goto L5;
    L17:
        return false;
    L5:
        if (r101.compareTo(r104) >= 0) goto L17;
        if (r102.compareTo(r105) < 0) goto L17;
        if (r102.compareTo(r104) >= 0) goto L17;
        BigInteger r106 = BigIntegers.modOddInverseVar(r104, r103);
        BigInteger r107 = r102.multiply(r106).mod(r104);
        BigInteger r108 = r104.subtract(r101).multiply(r106).mod(r104);
        ECPoint r109 = ECAlgorithms.sumOfTwoMultiplies(this.key.getParameters().getG(), r107, ((ECPublicKeyParameters) this.key).getQ(), r108).normalize();
        if (r109.isInfinity() == false) goto L16;
        return false;
    L16:
        return r109.getAffineXCoord().toBigInteger().mod(r104).equals(r101);
    }
}
