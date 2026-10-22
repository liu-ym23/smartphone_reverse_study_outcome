package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.generators.DHKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;

/* JADX INFO: loaded from: classes42.dex */
public class DHAgreement {
    private static final BigInteger ONE = null;
    private DHParameters dhParams;
    private DHPrivateKeyParameters key;
    private BigInteger privateValue;
    private SecureRandom random;

    static {
        ONE = BigInteger.valueOf(1);
    }

    public DHAgreement() {
    }

    public BigInteger calculateAgreement(DHPublicKeyParameters r100, BigInteger r101) {
        if (r100.getParameters().equals(this.dhParams) == false) goto L19;
        BigInteger r102 = this.dhParams.getP();
        BigInteger r103 = r100.getY();
        if (r103 == null) goto L17;
        BigInteger r104 = ONE;
        if (r103.compareTo(r104) <= 0) goto L17;
        if (r103.compareTo(r102.subtract(r104)) >= 0) goto L17;
        BigInteger r105 = r103.modPow(this.privateValue, r102);
        if (r105.equals(r104) == true) goto L15;
        return r101.modPow(this.key.getX(), r102).multiply(r105).mod(r102);
    L15:
        throw new IllegalStateException("Shared key can't be 1");
    L17:
        throw new IllegalArgumentException("Diffie-Hellman public key is weak");
    L19:
        throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
    }

    public BigInteger calculateMessage() {
        DHKeyPairGenerator r100 = new DHKeyPairGenerator();
        r100.init(new DHKeyGenerationParameters(this.random, this.dhParams));
        AsymmetricCipherKeyPair r101 = r100.generateKeyPair();
        this.privateValue = ((DHPrivateKeyParameters) r101.getPrivate()).getX();
        return ((DHPublicKeyParameters) r101.getPublic()).getY();
    }

    public void init(CipherParameters r100) {
        if ((r100 instanceof ParametersWithRandom) == false) goto L5;
        ParametersWithRandom r101 = (ParametersWithRandom) r100;
        this.random = r101.getRandom();
        r100 = r101.getParameters();
    L6:
        AsymmetricKeyParameter r102 = (AsymmetricKeyParameter) r100;
        if ((r102 instanceof DHPrivateKeyParameters) == false) goto L11;
        DHPrivateKeyParameters r103 = (DHPrivateKeyParameters) r102;
        this.key = r103;
        this.dhParams = r103.getParameters();
        return;
    L11:
        throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
    L5:
        this.random = CryptoServicesRegistrar.getSecureRandom();
        goto L6
    }
}
