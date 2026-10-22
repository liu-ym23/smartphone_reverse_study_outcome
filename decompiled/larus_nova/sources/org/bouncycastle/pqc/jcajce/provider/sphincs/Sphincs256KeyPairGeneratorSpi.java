package org.bouncycastle.pqc.jcajce.provider.sphincs;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHA512tDigest;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCS256KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCS256KeyPairGenerator;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.SPHINCS256KeyGenParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class Sphincs256KeyPairGeneratorSpi extends KeyPairGenerator {
    SPHINCS256KeyPairGenerator engine;
    boolean initialised;
    SPHINCS256KeyGenerationParameters param;
    SecureRandom random;
    ASN1ObjectIdentifier treeDigest;

    public Sphincs256KeyPairGeneratorSpi() {
        super("SPHINCS256");
        this.treeDigest = NISTObjectIdentifiers.id_sha512_256;
        this.engine = new SPHINCS256KeyPairGenerator();
        this.random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.initialised == true) goto L5;
        SPHINCS256KeyGenerationParameters r100 = new SPHINCS256KeyGenerationParameters(this.random, new SHA512tDigest(256));
        this.param = r100;
        this.engine.init(r100);
        this.initialised = true;
    L5:
        AsymmetricCipherKeyPair r101 = this.engine.generateKeyPair();
        SPHINCSPublicKeyParameters r102 = (SPHINCSPublicKeyParameters) r101.getPublic();
        SPHINCSPrivateKeyParameters r103 = (SPHINCSPrivateKeyParameters) r101.getPrivate();
        return new KeyPair(new BCSphincs256PublicKey(this.treeDigest, r102), new BCSphincs256PrivateKey(this.treeDigest, r103));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int r100, SecureRandom r101) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        if ((r100 instanceof SPHINCS256KeyGenParameterSpec) == false) goto L14;
        SPHINCS256KeyGenParameterSpec r102 = (SPHINCS256KeyGenParameterSpec) r100;
        if (r102.getTreeDigest().equals(SPHINCS256KeyGenParameterSpec.SHA512_256) == false) goto L9;
        this.treeDigest = NISTObjectIdentifiers.id_sha512_256;
        SPHINCS256KeyGenerationParameters r103 = new SPHINCS256KeyGenerationParameters(r101, new SHA512tDigest(256));
    L7:
        this.param = r103;
    L11:
        this.engine.init(this.param);
        this.initialised = true;
        return;
    L9:
        if (r102.getTreeDigest().equals("SHA3-256") == false) goto L11;
        this.treeDigest = NISTObjectIdentifiers.id_sha3_256;
        r103 = new SPHINCS256KeyGenerationParameters(r101, new SHA3Digest(256));
        goto L7
    L14:
        throw new InvalidAlgorithmParameterException("parameter object not a SPHINCS256KeyGenParameterSpec");
    }
}
