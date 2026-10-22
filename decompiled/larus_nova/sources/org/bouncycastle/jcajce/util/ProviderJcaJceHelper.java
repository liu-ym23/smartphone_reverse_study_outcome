package org.bouncycastle.jcajce.util;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathValidator;
import java.security.cert.CertStore;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.ExemptionMechanism;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;

/* JADX INFO: loaded from: classes42.dex */
public class ProviderJcaJceHelper implements JcaJceHelper {
    protected final Provider provider;

    public ProviderJcaJceHelper(Provider r100) {
        this.provider = r100;
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public AlgorithmParameterGenerator createAlgorithmParameterGenerator(String r100) throws NoSuchAlgorithmException {
        return AlgorithmParameterGenerator.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public AlgorithmParameters createAlgorithmParameters(String r100) throws NoSuchAlgorithmException {
        return AlgorithmParameters.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public CertPathBuilder createCertPathBuilder(String r100) throws NoSuchAlgorithmException {
        return CertPathBuilder.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public CertPathValidator createCertPathValidator(String r100) throws NoSuchAlgorithmException {
        return CertPathValidator.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public CertStore createCertStore(String r100, CertStoreParameters r101) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        return CertStore.getInstance(r100, r101, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public CertificateFactory createCertificateFactory(String r100) throws CertificateException {
        return CertificateFactory.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public Cipher createCipher(String r100) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return Cipher.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public MessageDigest createDigest(String r100) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public ExemptionMechanism createExemptionMechanism(String r100) throws NoSuchAlgorithmException {
        return ExemptionMechanism.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public KeyAgreement createKeyAgreement(String r100) throws NoSuchAlgorithmException {
        return KeyAgreement.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public KeyFactory createKeyFactory(String r100) throws NoSuchAlgorithmException {
        return KeyFactory.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public KeyGenerator createKeyGenerator(String r100) throws NoSuchAlgorithmException {
        return KeyGenerator.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public KeyPairGenerator createKeyPairGenerator(String r100) throws NoSuchAlgorithmException {
        return KeyPairGenerator.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public KeyStore createKeyStore(String r100) throws KeyStoreException {
        return KeyStore.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public Mac createMac(String r100) throws NoSuchAlgorithmException {
        return Mac.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public MessageDigest createMessageDigest(String r100) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public SecretKeyFactory createSecretKeyFactory(String r100) throws NoSuchAlgorithmException {
        return SecretKeyFactory.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public SecureRandom createSecureRandom(String r100) throws NoSuchAlgorithmException {
        return SecureRandom.getInstance(r100, this.provider);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public Signature createSignature(String r100) throws NoSuchAlgorithmException {
        return Signature.getInstance(r100, this.provider);
    }
}
