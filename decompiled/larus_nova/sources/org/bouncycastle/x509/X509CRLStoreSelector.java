package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;
import org.bouncycastle.x509.extension.X509ExtensionUtil;

/* JADX INFO: loaded from: classes42.dex */
public class X509CRLStoreSelector extends X509CRLSelector implements Selector {
    private X509AttributeCertificate attrCertChecking;
    private boolean completeCRLEnabled;
    private boolean deltaCRLIndicator;
    private byte[] issuingDistributionPoint;
    private boolean issuingDistributionPointEnabled;
    private BigInteger maxBaseCRLNumber;

    public X509CRLStoreSelector() {
        this.deltaCRLIndicator = false;
        this.completeCRLEnabled = false;
        this.maxBaseCRLNumber = null;
        this.issuingDistributionPoint = null;
        this.issuingDistributionPointEnabled = false;
    }

    public static X509CRLStoreSelector getInstance(X509CRLSelector r100) {
        if (r100 == null) goto L11;
        X509CRLStoreSelector r101 = new X509CRLStoreSelector();
        r101.setCertificateChecking(r100.getCertificateChecking());
        r101.setDateAndTime(r100.getDateAndTime());
        r101.setIssuerNames(r100.getIssuerNames());     // Catch: IOException -> L7
        r101.setIssuers(r100.getIssuers());
        r101.setMaxCRLNumber(r100.getMaxCRL());
        r101.setMinCRLNumber(r100.getMinCRL());
        return r101;
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage());
    L11:
        throw new IllegalArgumentException("cannot create from null selector");
    }

    @Override // java.security.cert.X509CRLSelector, java.security.cert.CRLSelector, org.bouncycastle.util.Selector
    public Object clone() {
        X509CRLStoreSelector r100 = getInstance(this);
        r100.deltaCRLIndicator = this.deltaCRLIndicator;
        r100.completeCRLEnabled = this.completeCRLEnabled;
        r100.maxBaseCRLNumber = this.maxBaseCRLNumber;
        r100.attrCertChecking = this.attrCertChecking;
        r100.issuingDistributionPointEnabled = this.issuingDistributionPointEnabled;
        r100.issuingDistributionPoint = Arrays.clone(this.issuingDistributionPoint);
        return r100;
    }

    public X509AttributeCertificate getAttrCertificateChecking() {
        return this.attrCertChecking;
    }

    public byte[] getIssuingDistributionPoint() {
        return Arrays.clone(this.issuingDistributionPoint);
    }

    public BigInteger getMaxBaseCRLNumber() {
        return this.maxBaseCRLNumber;
    }

    public boolean isCompleteCRLEnabled() {
        return this.completeCRLEnabled;
    }

    public boolean isDeltaCRLIndicatorEnabled() {
        return this.deltaCRLIndicator;
    }

    public boolean isIssuingDistributionPointEnabled() {
        return this.issuingDistributionPointEnabled;
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object r100) {
        if ((r100 instanceof X509CRL) == true) goto L5;
        return false;
    L5:
        X509CRL r101 = (X509CRL) r100;
        byte[] r102 = r101.getExtensionValue(Extension.deltaCRLIndicator.getId());     // Catch: Exception -> L36
        if (r102 == null) goto L10;
        ASN1Integer r103 = ASN1Integer.getInstance(X509ExtensionUtil.fromExtensionValue(r102));     // Catch: Exception -> L36
    L12:
        if (isDeltaCRLIndicatorEnabled() == false) goto L16;
        if (r103 != null) goto L16;
        return false;
    L16:
        if (isCompleteCRLEnabled() == false) goto L19;
        if (r103 == null) goto L19;
        return false;
    L19:
        if (r103 == null) goto L26;
        if (this.maxBaseCRLNumber == null) goto L26;
        if (r103.getPositiveValue().compareTo(this.maxBaseCRLNumber) != 1) goto L26;
        return false;
    L26:
        if (this.issuingDistributionPointEnabled == false) goto L35;
        byte[] r104 = r101.getExtensionValue(Extension.issuingDistributionPoint.getId());
        byte[] r105 = this.issuingDistributionPoint;
        if (r105 != null) goto L32;
        if (r104 == null) goto L35;
        return false;
    L32:
        if (Arrays.areEqual(r104, r105) == true) goto L35;
        return false;
    L35:
        return super.match(r101);
    L10:
        r103 = null;
    L36:
        return false;
    }

    @Override // java.security.cert.X509CRLSelector, java.security.cert.CRLSelector
    public boolean match(CRL r100) {
        return match(r100);
    }

    public void setAttrCertificateChecking(X509AttributeCertificate r100) {
        this.attrCertChecking = r100;
    }

    public void setCompleteCRLEnabled(boolean r100) {
        this.completeCRLEnabled = r100;
    }

    public void setDeltaCRLIndicatorEnabled(boolean r100) {
        this.deltaCRLIndicator = r100;
    }

    public void setIssuingDistributionPoint(byte[] r100) {
        this.issuingDistributionPoint = Arrays.clone(r100);
    }

    public void setIssuingDistributionPointEnabled(boolean r100) {
        this.issuingDistributionPointEnabled = r100;
    }

    public void setMaxBaseCRLNumber(BigInteger r100) {
        this.maxBaseCRLNumber = r100;
    }
}
