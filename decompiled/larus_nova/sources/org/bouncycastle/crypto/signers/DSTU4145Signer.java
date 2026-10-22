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
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU4145Signer implements DSAExt {
    private static final BigInteger ONE = null;
    private ECKeyParameters key;
    private SecureRandom random;

    static {
        ONE = BigInteger.valueOf(1);
    }

    public DSTU4145Signer() {
    }

    private static BigInteger fieldElement2Integer(BigInteger r100, ECFieldElement r101) {
        return truncate(r101.toBigInteger(), r100.bitLength() - 1);
    }

    private static BigInteger generateRandomInteger(BigInteger r100, SecureRandom r101) {
        return BigIntegers.createRandomBigInteger(r100.bitLength() - 1, r101);
    }

    private static ECFieldElement hash2FieldElement(ECCurve r100, byte[] r101) {
        return r100.fromBigInteger(truncate(new BigInteger(1, Arrays.reverse(r101)), r100.getFieldSize()));
    }

    private static BigInteger truncate(BigInteger r100, int r101) {
        if (r100.bitLength() > r101) goto L5;
        return r100;
    L5:
        return r100.mod(ONE.shiftLeft(r101));
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] r100) {
        ECDomainParameters r101 = this.key.getParameters();
        ECCurve r102 = r101.getCurve();
        ECFieldElement r103 = hash2FieldElement(r102, r100);
        if (r103.isZero() == false) goto L5;
        r103 = r102.fromBigInteger(ONE);
    L5:
        BigInteger r104 = r101.getN();
        BigInteger r105 = ((ECPrivateKeyParameters) this.key).getD();
        ECMultiplier r106 = createBasePointMultiplier();
    L6:
        BigInteger r107 = generateRandomInteger(r104, this.random);
        ECFieldElement r108 = r106.multiply(r101.getG(), r107).normalize().getAffineXCoord();
        if (r108.isZero() == true) goto L6;
        BigInteger r109 = fieldElement2Integer(r104, r103.multiply(r108));
        if (r109.signum() == 0) goto L6;
        BigInteger r110 = r109.multiply(r105).add(r107).mod(r104);
        if (r110.signum() == 0) goto L6;
        return new BigInteger[]{r109, r110};
    }

    @Override // org.bouncycastle.crypto.DSAExt
    public BigInteger getOrder() {
        return this.key.getParameters().getN();
    }

    @Override // org.bouncycastle.crypto.DSA
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == true) goto L4;
        ECKeyParameters r102 = (ECPublicKeyParameters) r101;
    L9:
        this.key = r102;
        return;
    L4:
        if ((r101 instanceof ParametersWithRandom) == false) goto L6;
        ParametersWithRandom r103 = (ParametersWithRandom) r101;
        this.random = r103.getRandom();
        r101 = r103.getParameters();
    L7:
        r102 = (ECPrivateKeyParameters) r101;
        goto L9
    L6:
        this.random = CryptoServicesRegistrar.getSecureRandom();
        goto L7
    }

    @Override // org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] r100, BigInteger r101, BigInteger r102) {
        if (r101.signum() > 0) goto L5;
        return false;
    L5:
        if (r102.signum() <= 0) goto L25;
        ECDomainParameters r103 = this.key.getParameters();
        BigInteger r104 = r103.getN();
        if (r101.compareTo(r104) < 0) goto L10;
        return false;
    L10:
        if (r102.compareTo(r104) >= 0) goto L26;
        ECCurve r105 = r103.getCurve();
        ECFieldElement r106 = hash2FieldElement(r105, r100);
        if (r106.isZero() == false) goto L15;
        r106 = r105.fromBigInteger(ONE);
    L15:
        ECPoint r107 = ECAlgorithms.sumOfTwoMultiplies(r103.getG(), r102, ((ECPublicKeyParameters) this.key).getQ(), r101).normalize();
        if (r107.isInfinity() == false) goto L19;
        return false;
    L19:
        if (fieldElement2Integer(r104, r106.multiply(r107.getAffineXCoord())).compareTo(r101) != 0) goto L24;
        return true;
    L24:
        return false;
    L26:
        return false;
    L25:
        return false;
    }
}
