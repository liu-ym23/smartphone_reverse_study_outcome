package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.Target;
import org.bouncycastle.asn1.x509.TargetInformation;
import org.bouncycastle.asn1.x509.Targets;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes42.dex */
public class X509AttributeCertStoreSelector implements Selector {
    private X509AttributeCertificate attributeCert;
    private Date attributeCertificateValid;
    private AttributeCertificateHolder holder;
    private AttributeCertificateIssuer issuer;
    private BigInteger serialNumber;
    private Collection targetGroups;
    private Collection targetNames;

    public X509AttributeCertStoreSelector() {
        this.targetNames = new HashSet();
        this.targetGroups = new HashSet();
    }

    private Set extractGeneralNames(Collection r100) throws IOException {
        if (r100 == null) goto L16;
        if (r100.isEmpty() == true) goto L16;
        HashSet r101 = new HashSet();
        Iterator r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        Object r103 = r102.next();
        if ((r103 instanceof GeneralName) == true) goto L13;
        r103 = GeneralName.getInstance(ASN1Primitive.fromByteArray((byte[]) r103));
    L13:
        r101.add(r103);
        goto L8
    L14:
        return r101;
    L16:
        return new HashSet();
    }

    public void addTargetGroup(GeneralName r100) {
        this.targetGroups.add(r100);
    }

    public void addTargetGroup(byte[] r100) throws IOException {
        addTargetGroup(GeneralName.getInstance(ASN1Primitive.fromByteArray(r100)));
    }

    public void addTargetName(GeneralName r100) {
        this.targetNames.add(r100);
    }

    public void addTargetName(byte[] r100) throws IOException {
        addTargetName(GeneralName.getInstance(ASN1Primitive.fromByteArray(r100)));
    }

    @Override // org.bouncycastle.util.Selector
    public Object clone() {
        X509AttributeCertStoreSelector r100 = new X509AttributeCertStoreSelector();
        r100.attributeCert = this.attributeCert;
        r100.attributeCertificateValid = getAttributeCertificateValid();
        r100.holder = this.holder;
        r100.issuer = this.issuer;
        r100.serialNumber = this.serialNumber;
        r100.targetGroups = getTargetGroups();
        r100.targetNames = getTargetNames();
        return r100;
    }

    public X509AttributeCertificate getAttributeCert() {
        return this.attributeCert;
    }

    public Date getAttributeCertificateValid() {
        if (this.attributeCertificateValid != null) goto L5;
        return null;
    L5:
        return new Date(this.attributeCertificateValid.getTime());
    }

    public AttributeCertificateHolder getHolder() {
        return this.holder;
    }

    public AttributeCertificateIssuer getIssuer() {
        return this.issuer;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public Collection getTargetGroups() {
        return Collections.unmodifiableCollection(this.targetGroups);
    }

    public Collection getTargetNames() {
        return Collections.unmodifiableCollection(this.targetNames);
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object r100) {
        if ((r100 instanceof X509AttributeCertificate) == true) goto L5;
        return false;
    L5:
        X509AttributeCertificate r101 = (X509AttributeCertificate) r100;
        X509AttributeCertificate r102 = this.attributeCert;
        if (r102 == null) goto L11;
        if (r102.equals(r101) == true) goto L11;
        return false;
    L11:
        if (this.serialNumber == null) goto L16;
        if (r101.getSerialNumber().equals(this.serialNumber) == true) goto L16;
        return false;
    L16:
        if (this.holder == null) goto L21;
        if (r101.getHolder().equals(this.holder) == true) goto L21;
        return false;
    L21:
        if (this.issuer != null) goto L23;
    L25:
        Date r103 = this.attributeCertificateValid;
        if (r103 == null) goto L31;
        r101.checkValidity(r103);     // Catch: Throwable -> L29
    L29:
        return false;
    L31:
        if (this.targetNames.isEmpty() == true) goto L33;
    L34:
        byte[] r104 = r101.getExtensionValue(Extension.targetInformation.getId());
        if (r104 != null) goto L69;
    L67:
        return true;
    L69:
        Targets[] r105 = TargetInformation.getInstance(new ASN1InputStream(((DEROctetString) ASN1Primitive.fromByteArray(r104)).getOctets()).readObject()).getTargetsObjects();
        if (this.targetNames.isEmpty() == true) goto L53;
        int r106 = 0;
        boolean r107 = false;
    L41:
        if (r106 >= r105.length) goto L50;
        Target[] r108 = r105[r106].getTargets();
        int r109 = 0;
    L44:
        if (r109 >= r108.length) goto L49;
        if (this.targetNames.contains(GeneralName.getInstance(r108[r109].getTargetName())) == true) goto L47;
        r109 = r109 + 1;
        goto L44
    L47:
        r107 = true;
    L49:
        r106 = r106 + 1;
        goto L41
    L50:
        if (r107 == true) goto L53;
        return false;
    L53:
        if (this.targetGroups.isEmpty() == true) goto L67;
        int r110 = 0;
        boolean r111 = false;
    L56:
        if (r110 >= r105.length) goto L65;
        Target[] r112 = r105[r110].getTargets();
        int r113 = 0;
    L59:
        if (r113 >= r112.length) goto L64;
        if (this.targetGroups.contains(GeneralName.getInstance(r112[r113].getTargetGroup())) == true) goto L62;
        r113 = r113 + 1;
        goto L59
    L62:
        r111 = true;
    L64:
        r110 = r110 + 1;
        goto L56
    L65:
        if (r111 == true) goto L67;
    L66:
        return false;
    L33:
        if (this.targetGroups.isEmpty() == true) goto L67;
    L23:
        if (r101.getIssuer().equals(this.issuer) == true) goto L25;
        return false;
    }

    public void setAttributeCert(X509AttributeCertificate r100) {
        this.attributeCert = r100;
    }

    public void setAttributeCertificateValid(Date r100) {
        if (r100 == null) goto L4;
        this.attributeCertificateValid = new Date(r100.getTime());
        return;
    L4:
        this.attributeCertificateValid = null;
    }

    public void setHolder(AttributeCertificateHolder r100) {
        this.holder = r100;
    }

    public void setIssuer(AttributeCertificateIssuer r100) {
        this.issuer = r100;
    }

    public void setSerialNumber(BigInteger r100) {
        this.serialNumber = r100;
    }

    public void setTargetGroups(Collection r100) throws IOException {
        this.targetGroups = extractGeneralNames(r100);
    }

    public void setTargetNames(Collection r100) throws IOException {
        this.targetNames = extractGeneralNames(r100);
    }
}
