package org.bouncycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.CertificatePair;
import org.bouncycastle.x509.X509CertificatePair;
import org.bouncycastle.x509.X509StreamParserSpi;
import org.bouncycastle.x509.util.StreamParsingException;

/* JADX INFO: loaded from: classes42.dex */
public class X509CertPairParser extends X509StreamParserSpi {
    private InputStream currentStream;

    public X509CertPairParser() {
        this.currentStream = null;
    }

    private X509CertificatePair readDERCrossCertificatePair(InputStream r100) throws IOException, CertificateParsingException {
        return new X509CertificatePair(CertificatePair.getInstance((ASN1Sequence) new ASN1InputStream(r100).readObject()));
    }

    @Override // org.bouncycastle.x509.X509StreamParserSpi
    public void engineInit(InputStream r100) {
        this.currentStream = r100;
        if (r100.markSupported() == true) goto L6;
        this.currentStream = new BufferedInputStream(this.currentStream);
        return;
    }

    @Override // org.bouncycastle.x509.X509StreamParserSpi
    public Object engineRead() throws StreamParsingException {
        this.currentStream.mark(10);     // Catch: Exception -> L8
        if (this.currentStream.read() != (-1)) goto L6;
        return null;
    L6:
        this.currentStream.reset();     // Catch: Exception -> L8
        return readDERCrossCertificatePair(this.currentStream);
    L8:
        e = move-exception;
        throw new StreamParsingException(e.toString(), e);
    }

    @Override // org.bouncycastle.x509.X509StreamParserSpi
    public Collection engineReadAll() throws StreamParsingException {
        ArrayList r100 = new ArrayList();
    L3:
        X509CertificatePair r101 = (X509CertificatePair) engineRead();
        if (r101 == null) goto L6;
        r100.add(r101);
        goto L3
    L6:
        return r100;
    }
}
