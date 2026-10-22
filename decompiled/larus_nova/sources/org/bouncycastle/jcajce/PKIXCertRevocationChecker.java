package org.bouncycastle.jcajce;

import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes42.dex */
public interface PKIXCertRevocationChecker {
    void check(Certificate r100) throws CertPathValidatorException;

    void initialize(PKIXCertRevocationCheckerParameters r100) throws CertPathValidatorException;

    void setParameter(String r100, Object r101);
}
