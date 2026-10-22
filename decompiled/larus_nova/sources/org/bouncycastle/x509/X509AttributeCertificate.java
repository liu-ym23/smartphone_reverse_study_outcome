package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Extension;
import java.util.Date;

/* JADX INFO: loaded from: classes42.dex */
public interface X509AttributeCertificate extends X509Extension {
    void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException;

    void checkValidity(Date r100) throws CertificateExpiredException, CertificateNotYetValidException;

    X509Attribute[] getAttributes();

    X509Attribute[] getAttributes(String r100);

    byte[] getEncoded() throws IOException;

    AttributeCertificateHolder getHolder();

    AttributeCertificateIssuer getIssuer();

    boolean[] getIssuerUniqueID();

    Date getNotAfter();

    Date getNotBefore();

    BigInteger getSerialNumber();

    byte[] getSignature();

    int getVersion();

    void verify(PublicKey r100, String r101) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;
}
