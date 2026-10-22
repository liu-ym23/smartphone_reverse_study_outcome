package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class RSABlindedEngine implements AsymmetricBlockCipher {
    private static final BigInteger ONE = null;
    private RSACoreEngine core;
    private RSAKeyParameters key;
    private SecureRandom random;

    static {
        ONE = BigInteger.valueOf(1);
    }

    public RSABlindedEngine() {
        this.core = new RSACoreEngine();
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        return this.core.getInputBlockSize();
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        return this.core.getOutputBlockSize();
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public void init(boolean r100, CipherParameters r101) {
        this.core.init(r100, r101);
        if ((r101 instanceof ParametersWithRandom) == false) goto L7;
        ParametersWithRandom r102 = (ParametersWithRandom) r101;
        RSAKeyParameters r103 = (RSAKeyParameters) r102.getParameters();
        this.key = r103;
        if ((r103 instanceof RSAPrivateCrtKeyParameters) == false) goto L11;
        SecureRandom r104 = r102.getRandom();
    L10:
        this.random = r104;
        return;
    L11:
        this.random = null;
        return;
    L7:
        RSAKeyParameters r105 = (RSAKeyParameters) r101;
        this.key = r105;
        if ((r105 instanceof RSAPrivateCrtKeyParameters) == false) goto L11;
        r104 = CryptoServicesRegistrar.getSecureRandom();
        goto L10
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] r100, int r101, int r102) {
        if (this.key == null) goto L17;
        BigInteger r103 = this.core.convertInput(r100, r101, r102);
        RSAKeyParameters r104 = this.key;
        if ((r104 instanceof RSAPrivateCrtKeyParameters) == false) goto L13;
        RSAPrivateCrtKeyParameters r105 = (RSAPrivateCrtKeyParameters) r104;
        BigInteger r106 = r105.getPublicExponent();
        if (r106 == null) goto L13;
        BigInteger r107 = r105.getModulus();
        BigInteger r108 = ONE;
        BigInteger r109 = BigIntegers.createRandomInRange(r108, r107.subtract(r108), this.random);
        BigInteger r110 = r109.modPow(r106, r107).multiply(r103).mod(r107);
        BigInteger r111 = this.core.processBlock(r110).multiply(BigIntegers.modOddInverse(r107, r109)).mod(r107);
        if (r103.equals(r111.modPow(r106, r107)) == true) goto L15;
        throw new IllegalStateException("RSA engine faulty decryption/signing detected");
    L15:
        return this.core.convertOutput(r111);
    L13:
        r111 = this.core.processBlock(r103);
        goto L15
    L17:
        throw new IllegalStateException("RSA engine not initialised");
    }
}
