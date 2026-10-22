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
import java.security.NoSuchProviderException;
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
public class NamedJcaJceHelper implements JcaJceHelper {
    protected final String providerName;

    public NamedJcaJceHelper(String r100) {
        this.providerName = r100;
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public AlgorithmParameterGenerator createAlgorithmParameterGenerator(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return AlgorithmParameterGenerator.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public AlgorithmParameters createAlgorithmParameters(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return AlgorithmParameters.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public CertPathBuilder createCertPathBuilder(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return CertPathBuilder.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public CertPathValidator createCertPathValidator(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return CertPathValidator.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public CertStore createCertStore(String r100, CertStoreParameters r101) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException {
        return CertStore.getInstance(r100, r101, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public CertificateFactory createCertificateFactory(String r100) throws CertificateException, NoSuchProviderException {
        return CertificateFactory.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public Cipher createCipher(String r100) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
        return Cipher.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public MessageDigest createDigest(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return MessageDigest.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public ExemptionMechanism createExemptionMechanism(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return ExemptionMechanism.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public KeyAgreement createKeyAgreement(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyAgreement.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public KeyFactory createKeyFactory(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyFactory.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public KeyGenerator createKeyGenerator(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyGenerator.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public KeyPairGenerator createKeyPairGenerator(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyPairGenerator.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public KeyStore createKeyStore(String r100) throws KeyStoreException, NoSuchProviderException {
        return KeyStore.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public Mac createMac(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return Mac.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public MessageDigest createMessageDigest(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return MessageDigest.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public SecretKeyFactory createSecretKeyFactory(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return SecretKeyFactory.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public SecureRandom createSecureRandom(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return SecureRandom.getInstance(r100, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.util.JcaJceHelper
    public Signature createSignature(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return Signature.getInstance(r100, this.providerName);
    }
}
