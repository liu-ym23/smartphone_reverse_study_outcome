package org.bouncycastle.x509;

import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes42.dex */
public class X509CertPairStoreSelector implements Selector {
    private X509CertificatePair certPair;
    private X509CertStoreSelector forwardSelector;
    private X509CertStoreSelector reverseSelector;

    public X509CertPairStoreSelector() {
    }

    @Override // org.bouncycastle.util.Selector
    public Object clone() {
        X509CertPairStoreSelector r100 = new X509CertPairStoreSelector();
        r100.certPair = this.certPair;
        X509CertStoreSelector r101 = this.forwardSelector;
        if (r101 == null) goto L5;
        r100.setForwardSelector((X509CertStoreSelector) r101.clone());
    L5:
        X509CertStoreSelector r102 = this.reverseSelector;
        if (r102 == null) goto L8;
        r100.setReverseSelector((X509CertStoreSelector) r102.clone());
    L8:
        return r100;
    }

    public X509CertificatePair getCertPair() {
        return this.certPair;
    }

    public X509CertStoreSelector getForwardSelector() {
        return this.forwardSelector;
    }

    public X509CertStoreSelector getReverseSelector() {
        return this.reverseSelector;
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object r100) {
    L22:
        return false;
    L4:
        if ((r100 instanceof X509CertificatePair) == true) goto L6;
        return false;
    L6:
        X509CertificatePair r101 = (X509CertificatePair) r100;     // Catch: Exception -> L22
        X509CertStoreSelector r102 = this.forwardSelector;     // Catch: Exception -> L22
        if (r102 != null) goto L9;
    L11:
        X509CertStoreSelector r103 = this.reverseSelector;     // Catch: Exception -> L22
        if (r103 != null) goto L14;
    L16:
        X509CertificatePair r104 = this.certPair;     // Catch: Exception -> L22
        if (r104 == null) goto L20;
        return r104.equals(r100);
    L20:
        return true;
    L14:
        if (r103.match(r101.getReverse()) == true) goto L16;
        return false;
    L9:
        if (r102.match(r101.getForward()) == true) goto L11;
        return false;
    }

    public void setCertPair(X509CertificatePair r100) {
        this.certPair = r100;
    }

    public void setForwardSelector(X509CertStoreSelector r100) {
        this.forwardSelector = r100;
    }

    public void setReverseSelector(X509CertStoreSelector r100) {
        this.reverseSelector = r100;
    }
}
