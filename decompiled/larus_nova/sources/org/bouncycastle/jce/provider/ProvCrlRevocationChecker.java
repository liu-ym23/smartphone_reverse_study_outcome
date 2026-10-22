package org.bouncycastle.jce.provider;

import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.bouncycastle.jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.jcajce.util.JcaJceHelper;

/* JADX INFO: loaded from: classes42.dex */
class ProvCrlRevocationChecker implements PKIXCertRevocationChecker {
    private Date currentDate;
    private final JcaJceHelper helper;
    private PKIXCertRevocationCheckerParameters params;

    public ProvCrlRevocationChecker(JcaJceHelper r100) {
        this.currentDate = null;
        this.helper = r100;
    }

    @Override // org.bouncycastle.jcajce.PKIXCertRevocationChecker
    public void check(Certificate r110) throws CertPathValidatorException {
        PKIXCertRevocationCheckerParameters r100 = this.params;     // Catch: AnnotatedException -> L4
        RFC3280CertPathUtilities.checkCRLs(r100, r100.getParamsPKIX(), this.currentDate, this.params.getValidDate(), (X509Certificate) r110, this.params.getSigningCert(), this.params.getWorkingPublicKey(), this.params.getCertPath().getCertificates(), this.helper);     // Catch: AnnotatedException -> L4
        return;
    L4:
        e = move-exception;
        if (e.getCause() == null) goto L8;
        Throwable r101 = e.getCause();
    L10:
        throw new CertPathValidatorException(e.getMessage(), r101, this.params.getCertPath(), this.params.getIndex());
    L8:
        r101 = e;
        goto L10
    }

    public void init(boolean r100) throws CertPathValidatorException {
        if (r100 == true) goto L6;
        this.params = null;
        this.currentDate = new Date();
        return;
    L6:
        throw new CertPathValidatorException("forward checking not supported");
    }

    @Override // org.bouncycastle.jcajce.PKIXCertRevocationChecker
    public void initialize(PKIXCertRevocationCheckerParameters r100) {
        this.params = r100;
        this.currentDate = new Date();
    }

    @Override // org.bouncycastle.jcajce.PKIXCertRevocationChecker
    public void setParameter(String r100, Object r101) {
    }
}
