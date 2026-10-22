package org.bouncycastle.jcajce;

import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.X509Certificate;
import java.util.Date;

/* JADX INFO: loaded from: classes42.dex */
public class PKIXCertRevocationCheckerParameters {
    private final CertPath certPath;
    private final int index;
    private final PKIXExtendedParameters paramsPKIX;
    private final X509Certificate signingCert;
    private final Date validDate;
    private final PublicKey workingPublicKey;

    public PKIXCertRevocationCheckerParameters(PKIXExtendedParameters r100, Date r101, CertPath r102, int r103, X509Certificate r104, PublicKey r105) {
        this.paramsPKIX = r100;
        this.validDate = r101;
        this.certPath = r102;
        this.index = r103;
        this.signingCert = r104;
        this.workingPublicKey = r105;
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getIndex() {
        return this.index;
    }

    public PKIXExtendedParameters getParamsPKIX() {
        return this.paramsPKIX;
    }

    public X509Certificate getSigningCert() {
        return this.signingCert;
    }

    public Date getValidDate() {
        return new Date(this.validDate.getTime());
    }

    public PublicKey getWorkingPublicKey() {
        return this.workingPublicKey;
    }
}
