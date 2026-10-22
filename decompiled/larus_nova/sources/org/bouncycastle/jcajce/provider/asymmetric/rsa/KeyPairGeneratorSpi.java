package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.alipay.sdk.m.n.d;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;

/* JADX INFO: loaded from: classes42.dex */
public class KeyPairGeneratorSpi extends KeyPairGenerator {
    private static final AlgorithmIdentifier PKCS_ALGID = null;
    private static final AlgorithmIdentifier PSS_ALGID = null;
    static final BigInteger defaultPublicExponent = null;
    AlgorithmIdentifier algId;
    RSAKeyPairGenerator engine;
    RSAKeyGenerationParameters param;

    public static class PSS extends KeyPairGeneratorSpi {
        public PSS() {
            super("RSASSA-PSS", KeyPairGeneratorSpi.access$000());
        }
    }

    static {
        PKCS_ALGID = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE);
        PSS_ALGID = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_RSASSA_PSS);
        defaultPublicExponent = BigInteger.valueOf(65537);
    }

    public KeyPairGeneratorSpi() {
        this(d.f25615a, PKCS_ALGID);
    }

    public KeyPairGeneratorSpi(String r100, AlgorithmIdentifier r101) {
        super(r100);
        this.algId = r101;
        this.engine = new RSAKeyPairGenerator();
        RSAKeyGenerationParameters r102 = new RSAKeyGenerationParameters(defaultPublicExponent, CryptoServicesRegistrar.getSecureRandom(), 2048, PrimeCertaintyCalculator.getDefaultCertainty(2048));
        this.param = r102;
        this.engine.init(r102);
    }

    public static /* synthetic */ AlgorithmIdentifier access$000() {
        return PSS_ALGID;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        AsymmetricCipherKeyPair r100 = this.engine.generateKeyPair();
        RSAKeyParameters r101 = (RSAKeyParameters) r100.getPublic();
        RSAPrivateCrtKeyParameters r102 = (RSAPrivateCrtKeyParameters) r100.getPrivate();
        return new KeyPair(new BCRSAPublicKey(this.algId, r101), new BCRSAPrivateCrtKey(this.algId, r102));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int r100, SecureRandom r101) {
        RSAKeyGenerationParameters r102 = new RSAKeyGenerationParameters(defaultPublicExponent, r101, r100, PrimeCertaintyCalculator.getDefaultCertainty(r100));
        this.param = r102;
        this.engine.init(r102);
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        if ((r100 instanceof RSAKeyGenParameterSpec) == false) goto L7;
        RSAKeyGenParameterSpec r102 = (RSAKeyGenParameterSpec) r100;
        RSAKeyGenerationParameters r103 = new RSAKeyGenerationParameters(r102.getPublicExponent(), r101, r102.getKeysize(), PrimeCertaintyCalculator.getDefaultCertainty(2048));
        this.param = r103;
        this.engine.init(r103);
        return;
    L7:
        throw new InvalidAlgorithmParameterException("parameter object not a RSAKeyGenParameterSpec");
    }
}
