package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.params.DSAKeyParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class DSASigner implements DSAExt {
    private final DSAKCalculator kCalculator;
    private DSAKeyParameters key;
    private SecureRandom random;

    public DSASigner() {
        this.kCalculator = new RandomDSAKCalculator();
    }

    public DSASigner(DSAKCalculator r100) {
        this.kCalculator = r100;
    }

    private BigInteger calculateE(BigInteger r100, byte[] r101) {
        if (r100.bitLength() >= (r101.length * 8)) goto L5;
        int r102 = r100.bitLength() / 8;
        byte[] r103 = new byte[r102];
        System.arraycopy(r101, 0, r103, 0, r102);
        return new BigInteger(1, r103);
    L5:
        return new BigInteger(1, r101);
    }

    private BigInteger getRandomizer(BigInteger r100, SecureRandom r101) {
        return BigIntegers.createRandomBigInteger(7, CryptoServicesRegistrar.getSecureRandom(r101)).add(BigInteger.valueOf(128)).multiply(r100);
    }

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] r100) {
        DSAParameters r101 = this.key.getParameters();
        BigInteger r102 = r101.getQ();
        BigInteger r103 = calculateE(r102, r100);
        BigInteger r104 = ((DSAPrivateKeyParameters) this.key).getX();
        if (this.kCalculator.isDeterministic() == false) goto L5;
        this.kCalculator.init(r102, r104, r100);
    L6:
        BigInteger r105 = this.kCalculator.nextK();
        BigInteger r106 = r101.getG().modPow(r105.add(getRandomizer(r102, this.random)), r101.getP()).mod(r102);
        return new BigInteger[]{r106, BigIntegers.modOddInverse(r102, r105).multiply(r103.add(r104.multiply(r106))).mod(r102)};
    L5:
        this.kCalculator.init(r102, this.random);
        goto L6
    }

    @Override // org.bouncycastle.crypto.DSAExt
    public BigInteger getOrder() {
        return this.key.getParameters().getQ();
    }

    @Override // org.bouncycastle.crypto.DSA
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == true) goto L4;
        DSAKeyParameters r102 = (DSAPublicKeyParameters) r101;
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
        this.key = (DSAPrivateKeyParameters) r105.getParameters();
        r103 = r105.getRandom();
        goto L9
    L6:
        r102 = (DSAPrivateKeyParameters) r101;
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
        DSAParameters r103 = this.key.getParameters();
        BigInteger r104 = r103.getQ();
        BigInteger r105 = calculateE(r104, r100);
        BigInteger r106 = BigInteger.valueOf(0);
        if (r106.compareTo(r101) < 0) goto L5;
    L14:
        return false;
    L5:
        if (r104.compareTo(r101) <= 0) goto L14;
        if (r106.compareTo(r102) >= 0) goto L14;
        if (r104.compareTo(r102) <= 0) goto L14;
        BigInteger r107 = BigIntegers.modOddInverseVar(r104, r102);
        BigInteger r108 = r105.multiply(r107).mod(r104);
        BigInteger r109 = r101.multiply(r107).mod(r104);
        BigInteger r110 = r103.getP();
        return r103.getG().modPow(r108, r110).multiply(((DSAPublicKeyParameters) this.key).getY().modPow(r109, r110)).mod(r110).mod(r104).equals(r101);
    }
}
