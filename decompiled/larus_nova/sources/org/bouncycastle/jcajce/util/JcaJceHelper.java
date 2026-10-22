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
public interface JcaJceHelper {
    AlgorithmParameterGenerator createAlgorithmParameterGenerator(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    AlgorithmParameters createAlgorithmParameters(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    CertPathBuilder createCertPathBuilder(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    CertPathValidator createCertPathValidator(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    CertStore createCertStore(String r100, CertStoreParameters r101) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException;

    CertificateFactory createCertificateFactory(String r100) throws NoSuchProviderException, CertificateException;

    Cipher createCipher(String r100) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException;

    MessageDigest createDigest(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    ExemptionMechanism createExemptionMechanism(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    KeyAgreement createKeyAgreement(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    KeyFactory createKeyFactory(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    KeyGenerator createKeyGenerator(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    KeyPairGenerator createKeyPairGenerator(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    KeyStore createKeyStore(String r100) throws KeyStoreException, NoSuchProviderException;

    Mac createMac(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    MessageDigest createMessageDigest(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    SecretKeyFactory createSecretKeyFactory(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    SecureRandom createSecureRandom(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;

    Signature createSignature(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;
}
