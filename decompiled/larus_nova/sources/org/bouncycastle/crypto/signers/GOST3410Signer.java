package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.params.GOST3410KeyParameters;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410Signer implements DSAExt {
    GOST3410KeyParameters key;
    SecureRandom random;

    public GOST3410Signer() {
    }

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] r100) {
        BigInteger r101 = new BigInteger(1, Arrays.reverse(r100));
        GOST3410Parameters r102 = this.key.getParameters();
    L3:
        BigInteger r103 = BigIntegers.createRandomBigInteger(r102.getQ().bitLength(), this.random);
        if (r103.compareTo(r102.getQ()) >= 0) goto L3;
        BigInteger r104 = r102.getA().modPow(r103, r102.getP()).mod(r102.getQ());
        return new BigInteger[]{r104, r103.multiply(r101).add(((GOST3410PrivateKeyParameters) this.key).getX().multiply(r104)).mod(r102.getQ())};
    }

    @Override // org.bouncycastle.crypto.DSAExt
    public BigInteger getOrder() {
        return this.key.getParameters().getQ();
    }

    @Override // org.bouncycastle.crypto.DSA
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == true) goto L4;
        GOST3410KeyParameters r102 = (GOST3410PublicKeyParameters) r101;
    L8:
        this.key = r102;
        return;
    L4:
        if ((r101 instanceof ParametersWithRandom) == false) goto L6;
        ParametersWithRandom r103 = (ParametersWithRandom) r101;
        this.random = r103.getRandom();
        this.key = (GOST3410PrivateKeyParameters) r103.getParameters();
        return;
    L6:
        this.random = CryptoServicesRegistrar.getSecureRandom();
        r102 = (GOST3410PrivateKeyParameters) r101;
        goto L8
    }

    @Override // org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] r100, BigInteger r101, BigInteger r102) {
        BigInteger r103 = new BigInteger(1, Arrays.reverse(r100));
        GOST3410Parameters r104 = this.key.getParameters();
        BigInteger r105 = BigInteger.valueOf(0);
        if (r105.compareTo(r101) < 0) goto L5;
    L14:
        return false;
    L5:
        if (r104.getQ().compareTo(r101) <= 0) goto L14;
        if (r105.compareTo(r102) >= 0) goto L14;
        if (r104.getQ().compareTo(r102) <= 0) goto L14;
        BigInteger r106 = r103.modPow(r104.getQ().subtract(new BigInteger("2")), r104.getQ());
        BigInteger r107 = r102.multiply(r106).mod(r104.getQ());
        BigInteger r108 = r104.getQ().subtract(r101).multiply(r106).mod(r104.getQ());
        return r104.getA().modPow(r107, r104.getP()).multiply(((GOST3410PublicKeyParameters) this.key).getY().modPow(r108, r104.getP())).mod(r104.getP()).mod(r104.getQ()).equals(r101);
    }
}
