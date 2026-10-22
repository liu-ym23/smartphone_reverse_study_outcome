package org.bouncycastle.x509;

import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes42.dex */
public abstract class PKIXAttrCertChecker implements Cloneable {
    public PKIXAttrCertChecker() {
    }

    public abstract void check(X509AttributeCertificate r100, CertPath r101, CertPath r102, Collection r103) throws CertPathValidatorException;

    public abstract Object clone();

    public abstract Set getSupportedExtensions();
}
