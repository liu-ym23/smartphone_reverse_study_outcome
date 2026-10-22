package org.bouncycastle.x509;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXParameters;
import java.security.cert.X509CertSelector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes42.dex */
public class ExtendedPKIXBuilderParameters extends ExtendedPKIXParameters {
    private Set excludedCerts;
    private int maxPathLength;

    public ExtendedPKIXBuilderParameters(Set r100, Selector r101) throws InvalidAlgorithmParameterException {
        super(r100);
        this.maxPathLength = 5;
        this.excludedCerts = Collections.EMPTY_SET;
        setTargetConstraints(r101);
    }

    public static ExtendedPKIXParameters getInstance(PKIXParameters r100) {
        ExtendedPKIXBuilderParameters r101 = new ExtendedPKIXBuilderParameters(r100.getTrustAnchors(), X509CertStoreSelector.getInstance((X509CertSelector) r100.getTargetCertConstraints()));     // Catch: Exception -> L5
        r101.setParams(r100);
        return r101;
    L5:
        e = move-exception;
        throw new RuntimeException(e.getMessage());
    }

    @Override // org.bouncycastle.x509.ExtendedPKIXParameters, java.security.cert.PKIXParameters, java.security.cert.CertPathParameters
    public Object clone() {
        ExtendedPKIXBuilderParameters r100 = new ExtendedPKIXBuilderParameters(getTrustAnchors(), getTargetConstraints());     // Catch: Exception -> L5
        r100.setParams(this);
        return r100;
    L5:
        e = move-exception;
        throw new RuntimeException(e.getMessage());
    }

    public Set getExcludedCerts() {
        return Collections.unmodifiableSet(this.excludedCerts);
    }

    public int getMaxPathLength() {
        return this.maxPathLength;
    }

    public void setExcludedCerts(Set r100) {
        if (r100 != null) goto L4;
        Set r101 = Collections.EMPTY_SET;
        return;
    L4:
        this.excludedCerts = new HashSet(r100);
    }

    public void setMaxPathLength(int r100) {
        if (r100 < (-1)) goto L7;
        this.maxPathLength = r100;
        return;
    L7:
        throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
    }

    @Override // org.bouncycastle.x509.ExtendedPKIXParameters
    public void setParams(PKIXParameters r100) {
        super.setParams(r100);
        if ((r100 instanceof ExtendedPKIXBuilderParameters) == false) goto L6;
        ExtendedPKIXBuilderParameters r101 = (ExtendedPKIXBuilderParameters) r100;
        this.maxPathLength = r101.maxPathLength;
        this.excludedCerts = new HashSet(r101.excludedCerts);
    L6:
        if ((r100 instanceof PKIXBuilderParameters) == false) goto L9;
        this.maxPathLength = ((PKIXBuilderParameters) r100).getMaxPathLength();
        return;
    }
}
