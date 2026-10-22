package org.bouncycastle.x509;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AttCertIssuer;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.V2Form;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes42.dex */
public class AttributeCertificateIssuer implements CertSelector, Selector {
    final ASN1Encodable form;

    public AttributeCertificateIssuer(X500Principal r100) throws IOException {
        this(new X509Principal(r100.getEncoded()));
    }

    public AttributeCertificateIssuer(AttCertIssuer r100) {
        this.form = r100.getIssuer();
    }

    public AttributeCertificateIssuer(X509Principal r100) {
        this.form = new V2Form(GeneralNames.getInstance(new DERSequence(new GeneralName(r100))));
    }

    private Object[] getNames() {
        ASN1Encodable r100 = this.form;
        if ((r100 instanceof V2Form) == false) goto L5;
        GeneralNames r101 = ((V2Form) r100).getIssuerName();
    L6:
        GeneralName[] r102 = r101.getNames();
        ArrayList r103 = new ArrayList(r102.length);
        int r104 = 0;
    L8:
        if (r104 == r102.length) goto L17;
        if (r102[r104].getTagNo() != 4) goto L15;
        r103.add(new X500Principal(r102[r104].getName().toASN1Primitive().getEncoded()));     // Catch: IOException -> L13
    L14:
        throw new RuntimeException("badly formed Name object");
    L15:
        r104 = r104 + 1;
        goto L8
    L17:
        return r103.toArray(new Object[r103.size()]);
    L5:
        r101 = (GeneralNames) r100;
        goto L6
    }

    private boolean matchesDN(X500Principal r100, GeneralNames r101) {
        GeneralName[] r102 = r101.getNames();
        int r103 = 0;
    L4:
        if (r103 == r102.length) goto L12;
        GeneralName r104 = r102[r103];
        if (r104.getTagNo() != 4) goto L11;
        if (new X500Principal(r104.getName().toASN1Primitive().getEncoded()).equals(r100) == false) goto L11;
        return true;
    L11:
        r103 = r103 + 1;
        goto L4
    L12:
        return false;
    }

    @Override // java.security.cert.CertSelector, org.bouncycastle.util.Selector
    public Object clone() {
        return new AttributeCertificateIssuer(AttCertIssuer.getInstance(this.form));
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof AttributeCertificateIssuer) == true) goto L10;
        return false;
    L10:
        return this.form.equals(((AttributeCertificateIssuer) r100).form);
    }

    public Principal[] getPrincipals() {
        Object[] r100 = getNames();
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L4:
        if (r102 == r100.length) goto L10;
        Object r103 = r100[r102];
        if ((r103 instanceof Principal) == false) goto L8;
        r101.add(r103);
    L8:
        r102 = r102 + 1;
        goto L4
    L10:
        return (Principal[]) r101.toArray(new Principal[r101.size()]);
    }

    public int hashCode() {
        return this.form.hashCode();
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object r100) {
        if ((r100 instanceof X509Certificate) == true) goto L7;
        return false;
    L7:
        return match((Certificate) r100);
    }

    @Override // java.security.cert.CertSelector
    public boolean match(Certificate r100) {
        if ((r100 instanceof X509Certificate) == true) goto L5;
        return false;
    L5:
        X509Certificate r101 = (X509Certificate) r100;
        ASN1Encodable r102 = this.form;
        if ((r102 instanceof V2Form) == false) goto L18;
        V2Form r103 = (V2Form) r102;
        if (r103.getBaseCertificateID() != null) goto L10;
        GeneralNames r104 = r103.getIssuerName();
        if (matchesDN(r101.getSubjectX500Principal(), r104) == false) goto L21;
        return true;
    L21:
        return false;
    L10:
        if (r103.getBaseCertificateID().getSerial().hasValue(r101.getSerialNumber()) == true) goto L12;
        return false;
    L12:
        if (matchesDN(r101.getIssuerX500Principal(), r103.getBaseCertificateID().getIssuer()) == false) goto L23;
        return true;
    L23:
        return false;
    L18:
        X500Principal r105 = r101.getSubjectX500Principal();
        if (matchesDN(r105, (GeneralNames) r102) == false) goto L21;
        return true;
    }
}
