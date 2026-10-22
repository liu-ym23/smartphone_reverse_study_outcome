package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class ECNRSigner implements DSAExt {
    private boolean forSigning;
    private ECKeyParameters key;
    private SecureRandom random;

    public ECNRSigner() {
    }

    private BigInteger extractT(ECPublicKeyParameters r100, BigInteger r101, BigInteger r102) {
        BigInteger r103 = r100.getParameters().getN();
        if (r101.compareTo(ECConstants.ONE) >= 0) goto L5;
    L17:
        return null;
    L5:
        if (r101.compareTo(r103) >= 0) goto L17;
        if (r102.compareTo(ECConstants.ZERO) < 0) goto L17;
        if (r102.compareTo(r103) >= 0) goto L17;
        ECPoint r104 = ECAlgorithms.sumOfTwoMultiplies(r100.getParameters().getG(), r102, r100.getQ(), r101).normalize();
        if (r104.isInfinity() == false) goto L16;
        return null;
    L16:
        return r101.subtract(r104.getAffineXCoord().toBigInteger()).mod(r103);
    }

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] r100) {
        if (this.forSigning == false) goto L13;
        BigInteger r101 = getOrder();
        BigInteger r102 = new BigInteger(1, r100);
        ECPrivateKeyParameters r103 = (ECPrivateKeyParameters) this.key;
        if (r102.compareTo(r101) >= 0) goto L11;
    L6:
        ECKeyPairGenerator r104 = new ECKeyPairGenerator();
        r104.init(new ECKeyGenerationParameters(r103.getParameters(), this.random));
        AsymmetricCipherKeyPair r105 = r104.generateKeyPair();
        BigInteger r106 = ((ECPublicKeyParameters) r105.getPublic()).getQ().getAffineXCoord().toBigInteger().add(r102).mod(r101);
        if (r106.equals(ECConstants.ZERO) == true) goto L6;
        return new BigInteger[]{r106, ((ECPrivateKeyParameters) r105.getPrivate()).getD().subtract(r106.multiply(r103.getD())).mod(r101)};
    L11:
        throw new DataLengthException("input too large for ECNR key");
    L13:
        throw new IllegalStateException("not initialised for signing");
    }

    @Override // org.bouncycastle.crypto.DSAExt
    public BigInteger getOrder() {
        return this.key.getParameters().getN();
    }

    public byte[] getRecoveredMessage(BigInteger r100, BigInteger r101) {
        if (this.forSigning == true) goto L11;
        BigInteger r102 = extractT((ECPublicKeyParameters) this.key, r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return BigIntegers.asUnsignedByteArray(r102);
    L11:
        throw new IllegalStateException("not initialised for verifying/recovery");
    }

    @Override // org.bouncycastle.crypto.DSA
    public void init(boolean r100, CipherParameters r101) {
        this.forSigning = r100;
        if (r100 == true) goto L5;
        ECKeyParameters r102 = (ECPublicKeyParameters) r101;
    L9:
        this.key = r102;
        return;
    L5:
        if ((r101 instanceof ParametersWithRandom) == false) goto L7;
        ParametersWithRandom r103 = (ParametersWithRandom) r101;
        this.random = r103.getRandom();
        this.key = (ECPrivateKeyParameters) r103.getParameters();
        return;
    L7:
        this.random = CryptoServicesRegistrar.getSecureRandom();
        r102 = (ECPrivateKeyParameters) r101;
        goto L9
    }

    @Override // org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] r100, BigInteger r101, BigInteger r102) {
        if (this.forSigning == true) goto L16;
        ECPublicKeyParameters r103 = (ECPublicKeyParameters) this.key;
        BigInteger r104 = r103.getParameters().getN();
        int r105 = r104.bitLength();
        BigInteger r106 = new BigInteger(1, r100);
        if (r106.bitLength() > r105) goto L14;
        BigInteger r107 = extractT(r103, r101, r102);
        if (r107 != null) goto L9;
    L11:
        return false;
    L9:
        if (r107.equals(r106.mod(r104)) == false) goto L11;
        return true;
    L14:
        throw new DataLengthException("input too large for ECNR key.");
    L16:
        throw new IllegalStateException("not initialised for verifying");
    }
}
