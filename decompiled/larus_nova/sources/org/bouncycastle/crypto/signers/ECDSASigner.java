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
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class ECDSASigner implements ECConstants, DSAExt {
    private final DSAKCalculator kCalculator;
    private ECKeyParameters key;
    private SecureRandom random;

    public ECDSASigner() {
        this.kCalculator = new RandomDSAKCalculator();
    }

    public ECDSASigner(DSAKCalculator r100) {
        this.kCalculator = r100;
    }

    public BigInteger calculateE(BigInteger r100, byte[] r101) {
        int r102 = r100.bitLength();
        int r103 = r101.length * 8;
        BigInteger r104 = new BigInteger(1, r101);
        if (r102 < r103) goto L5;
        return r104;
    L5:
        return r104.shiftRight(r103 - r102);
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] r100) {
        ECDomainParameters r101 = this.key.getParameters();
        BigInteger r102 = r101.getN();
        BigInteger r103 = calculateE(r102, r100);
        BigInteger r104 = ((ECPrivateKeyParameters) this.key).getD();
        if (this.kCalculator.isDeterministic() == false) goto L5;
        this.kCalculator.init(r102, r104, r100);
    L6:
        ECMultiplier r105 = createBasePointMultiplier();
    L7:
        BigInteger r106 = this.kCalculator.nextK();
        BigInteger r107 = r105.multiply(r101.getG(), r106).normalize().getAffineXCoord().toBigInteger().mod(r102);
        BigInteger r108 = ECConstants.ZERO;
        if (r107.equals(r108) == true) goto L7;
        BigInteger r109 = BigIntegers.modOddInverse(r102, r106).multiply(r103.add(r104.multiply(r107))).mod(r102);
        if (r109.equals(r108) == true) goto L7;
        return new BigInteger[]{r107, r109};
    L5:
        this.kCalculator.init(r102, this.random);
        goto L6
    }

    public ECFieldElement getDenominator(int r100, ECPoint r101) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L17;
        if (r100 == 4) goto L17;
        if (r100 == 6) goto L19;
        if (r100 == 7) goto L19;
        return null;
    L17:
        return r101.getZCoord(0).square();
    L19:
        return r101.getZCoord(0);
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
        SecureRandom r103 = null;
    L9:
        if (r100 == true) goto L11;
    L13:
        boolean r104 = false;
    L14:
        this.random = initSecureRandom(r104, r103);
        return;
    L11:
        if (this.kCalculator.isDeterministic() == true) goto L13;
        r104 = true;
        goto L14
    L4:
        if ((r101 instanceof ParametersWithRandom) == false) goto L6;
        ParametersWithRandom r105 = (ParametersWithRandom) r101;
        this.key = (ECPrivateKeyParameters) r105.getParameters();
        r103 = r105.getRandom();
        goto L9
    L6:
        r102 = (ECPrivateKeyParameters) r101;
        goto L8
    }

    public SecureRandom initSecureRandom(boolean r100, SecureRandom r101) {
        if (r100 == true) goto L6;
        return null;
    L6:
        return CryptoServicesRegistrar.getSecureRandom(r101);
    }

    @Override // org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] r100, BigInteger r101, BigInteger r102) {
        ECDomainParameters r103 = this.key.getParameters();
        BigInteger r104 = r103.getN();
        BigInteger r105 = calculateE(r104, r100);
        BigInteger r106 = ECConstants.ONE;
        if (r101.compareTo(r106) >= 0) goto L5;
    L36:
        return false;
    L5:
        if (r101.compareTo(r104) >= 0) goto L36;
        if (r102.compareTo(r106) < 0) goto L36;
        if (r102.compareTo(r104) >= 0) goto L36;
        BigInteger r107 = BigIntegers.modOddInverseVar(r104, r102);
        BigInteger r108 = r105.multiply(r107).mod(r104);
        BigInteger r109 = r101.multiply(r107).mod(r104);
        ECPoint r110 = ECAlgorithms.sumOfTwoMultiplies(r103.getG(), r108, ((ECPublicKeyParameters) this.key).getQ(), r109);
        if (r110.isInfinity() == false) goto L15;
        return false;
    L15:
        ECCurve r111 = r110.getCurve();
        if (r111 == null) goto L35;
        BigInteger r112 = r111.getCofactor();
        if (r112 == null) goto L35;
        if (r112.compareTo(ECConstants.EIGHT) > 0) goto L35;
        ECFieldElement r113 = getDenominator(r111.getCoordinateSystem(), r110);
        if (r113 == null) goto L35;
        if (r113.isZero() == true) goto L35;
        ECFieldElement r114 = r110.getXCoord();
    L27:
        if (r111.isValidFieldElement(r101) == false) goto L33;
        if (r111.fromBigInteger(r101).multiply(r113).equals(r114) == true) goto L30;
        r101 = r101.add(r104);
        goto L27
    L30:
        return true;
    L33:
        return false;
    L35:
        return r110.normalize().getAffineXCoord().toBigInteger().mod(r104).equals(r101);
    }
}
