package org.bouncycastle.x509;

import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.CertificatePair;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.provider.X509CertificateObject;

/* JADX INFO: loaded from: classes42.dex */
public class X509CertificatePair {
    private final JcaJceHelper bcHelper;
    private X509Certificate forward;
    private X509Certificate reverse;

    public X509CertificatePair(X509Certificate r100, X509Certificate r101) {
        this.bcHelper = new BCJcaJceHelper();
        this.forward = r100;
        this.reverse = r101;
    }

    public X509CertificatePair(CertificatePair r100) throws CertificateParsingException {
        this.bcHelper = new BCJcaJceHelper();
        if (r100.getForward() == null) goto L6;
        this.forward = new X509CertificateObject(r100.getForward());
    L6:
        if (r100.getReverse() == null) goto L9;
        this.reverse = new X509CertificateObject(r100.getReverse());
        return;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof X509CertificatePair) == true) goto L8;
        return false;
    L8:
        X509CertificatePair r101 = (X509CertificatePair) r100;
        X509Certificate r102 = this.forward;
        if (r102 == null) goto L12;
        boolean r103 = r102.equals(r101.forward);
    L15:
        X509Certificate r104 = this.reverse;
        X509Certificate r105 = r101.reverse;
        if (r104 == null) goto L18;
        boolean r106 = r104.equals(r105);
    L21:
        if (r103 == false) goto L25;
        if (r106 == false) goto L26;
        return true;
    L26:
        return false;
    L25:
        return false;
    L18:
        if (r105 == null) goto L20;
        r106 = false;
        goto L21
    L20:
        r106 = true;
        goto L21
    L12:
        if (r101.forward == null) goto L14;
        r103 = false;
        goto L15
    L14:
        r103 = true;
        goto L15
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        Certificate r100 = null;
        if (this.forward == null) goto L9;
        Certificate r101 = Certificate.getInstance(new ASN1InputStream(this.forward.getEncoded()).readObject());     // Catch: IOException -> L19 IllegalArgumentException -> L22
        if (r101 == null) goto L8;
    L11:
        if (this.reverse == null) goto L18;
        r100 = Certificate.getInstance(new ASN1InputStream(this.reverse.getEncoded()).readObject());     // Catch: IOException -> L19 IllegalArgumentException -> L22
        if (r100 != null) goto L18;
        throw new CertificateEncodingException("unable to get encoding for reverse");     // Catch: IOException -> L19 IllegalArgumentException -> L22
    L18:
        return new CertificatePair(r101, r100).getEncoded(ASN1Encoding.DER);
    L8:
        throw new CertificateEncodingException("unable to get encoding for forward");     // Catch: IOException -> L19 IllegalArgumentException -> L22
    L9:
        r101 = null;
    L19:
        e = move-exception;
        throw new ExtCertificateEncodingException(e.toString(), e);
    L22:
        e = move-exception;
        throw new ExtCertificateEncodingException(e.toString(), e);
    }

    public X509Certificate getForward() {
        return this.forward;
    }

    public X509Certificate getReverse() {
        return this.reverse;
    }

    public int hashCode() {
        X509Certificate r100 = this.forward;
        int r101 = -1;
        if (r100 == null) goto L5;
        r101 = (-1) ^ r100.hashCode();
    L5:
        X509Certificate r102 = this.reverse;
        if (r102 != null) goto L8;
        return r101;
    L8:
        return (r101 * 17) ^ r102.hashCode();
    }
}
