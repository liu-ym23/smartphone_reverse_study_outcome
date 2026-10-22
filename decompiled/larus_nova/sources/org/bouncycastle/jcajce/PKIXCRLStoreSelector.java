package org.bouncycastle.jcajce;

import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.util.Collection;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes42.dex */
public class PKIXCRLStoreSelector<T extends CRL> implements Selector<T> {
    private final CRLSelector baseSelector;
    private final boolean completeCRLEnabled;
    private final boolean deltaCRLIndicator;
    private final byte[] issuingDistributionPoint;
    private final boolean issuingDistributionPointEnabled;
    private final BigInteger maxBaseCRLNumber;

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.PKIXCRLStoreSelector$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final CRLSelector baseSelector;
        private boolean completeCRLEnabled;
        private boolean deltaCRLIndicator;
        private byte[] issuingDistributionPoint;
        private boolean issuingDistributionPointEnabled;
        private BigInteger maxBaseCRLNumber;

        public Builder(CRLSelector r100) {
            this.deltaCRLIndicator = false;
            this.completeCRLEnabled = false;
            this.maxBaseCRLNumber = null;
            this.issuingDistributionPoint = null;
            this.issuingDistributionPointEnabled = false;
            this.baseSelector = (CRLSelector) r100.clone();
        }

        public static /* synthetic */ CRLSelector access$100(Builder r100) {
            return r100.baseSelector;
        }

        public static /* synthetic */ boolean access$200(Builder r100) {
            return r100.deltaCRLIndicator;
        }

        public static /* synthetic */ boolean access$300(Builder r100) {
            return r100.completeCRLEnabled;
        }

        public static /* synthetic */ BigInteger access$400(Builder r100) {
            return r100.maxBaseCRLNumber;
        }

        public static /* synthetic */ byte[] access$500(Builder r100) {
            return r100.issuingDistributionPoint;
        }

        public static /* synthetic */ boolean access$600(Builder r100) {
            return r100.issuingDistributionPointEnabled;
        }

        public PKIXCRLStoreSelector<? extends CRL> build() {
            return new PKIXCRLStoreSelector(this, null);
        }

        public Builder setCompleteCRLEnabled(boolean r100) {
            this.completeCRLEnabled = r100;
            return this;
        }

        public Builder setDeltaCRLIndicatorEnabled(boolean r100) {
            this.deltaCRLIndicator = r100;
            return this;
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

    public static class SelectorClone extends X509CRLSelector {
        private final PKIXCRLStoreSelector selector;

        public SelectorClone(PKIXCRLStoreSelector r100) {
            this.selector = r100;
            if ((PKIXCRLStoreSelector.access$700(r100) instanceof X509CRLSelector) == false) goto L6;
            X509CRLSelector r101 = (X509CRLSelector) PKIXCRLStoreSelector.access$700(r100);
            setCertificateChecking(r101.getCertificateChecking());
            setDateAndTime(r101.getDateAndTime());
            setIssuers(r101.getIssuers());
            setMinCRLNumber(r101.getMinCRL());
            setMaxCRLNumber(r101.getMaxCRL());
            return;
        }

        @Override // java.security.cert.X509CRLSelector, java.security.cert.CRLSelector
        public boolean match(CRL r100) {
            PKIXCRLStoreSelector r101 = this.selector;
            if (r101 != null) goto L8;
            if (r100 == null) goto L6;
            return true;
        L6:
            return false;
        L8:
            return r101.match(r100);
        }
    }

    private PKIXCRLStoreSelector(Builder r100) {
        this.baseSelector = Builder.access$100(r100);
        this.deltaCRLIndicator = Builder.access$200(r100);
        this.completeCRLEnabled = Builder.access$300(r100);
        this.maxBaseCRLNumber = Builder.access$400(r100);
        this.issuingDistributionPoint = Builder.access$500(r100);
        this.issuingDistributionPointEnabled = Builder.access$600(r100);
    }

    public /* synthetic */ PKIXCRLStoreSelector(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ CRLSelector access$700(PKIXCRLStoreSelector r100) {
        return r100.baseSelector;
    }

    public static Collection<? extends CRL> getCRLs(PKIXCRLStoreSelector r100, CertStore r101) throws CertStoreException {
        return r101.getCRLs(new SelectorClone(r100));
    }

    @Override // org.bouncycastle.util.Selector
    public Object clone() {
        return this;
    }

    public X509Certificate getCertificateChecking() {
        CRLSelector r100 = this.baseSelector;
        if ((r100 instanceof X509CRLSelector) == true) goto L5;
        return null;
    L5:
        return ((X509CRLSelector) r100).getCertificateChecking();
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
    public /* bridge */ /* synthetic */ boolean match(Object r100) {
        return match((CRL) r100);
    }

    public boolean match(CRL r100) {
        if ((r100 instanceof X509CRL) == false) goto L5;
        X509CRL r101 = (X509CRL) r100;
        byte[] r102 = r101.getExtensionValue(Extension.deltaCRLIndicator.getId());     // Catch: Exception -> L35
        if (r102 == null) goto L11;
        ASN1Integer r103 = ASN1Integer.getInstance(ASN1OctetString.getInstance(r102).getOctets());     // Catch: Exception -> L35
    L13:
        if (isDeltaCRLIndicatorEnabled() == false) goto L17;
        if (r103 != null) goto L17;
        return false;
    L17:
        if (isCompleteCRLEnabled() == false) goto L20;
        if (r103 == null) goto L20;
        return false;
    L20:
        if (r103 == null) goto L27;
        if (this.maxBaseCRLNumber == null) goto L27;
        if (r103.getPositiveValue().compareTo(this.maxBaseCRLNumber) != 1) goto L27;
        return false;
    L27:
        if (this.issuingDistributionPointEnabled == false) goto L5;
        byte[] r104 = r101.getExtensionValue(Extension.issuingDistributionPoint.getId());
        byte[] r105 = this.issuingDistributionPoint;
        if (r105 != null) goto L33;
        if (r104 == null) goto L5;
        return false;
    L33:
        if (Arrays.areEqual(r104, r105) == true) goto L5;
    L11:
        r103 = null;
    L34:
        return false;
    L5:
        return this.baseSelector.match(r100);
    }
}
