package org.bouncycastle.asn1.x500;

import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.style.BCStyle;

/* JADX INFO: loaded from: classes42.dex */
public class X500NameBuilder {
    private Vector rdns;
    private X500NameStyle template;

    public X500NameBuilder() {
        this(BCStyle.INSTANCE);
    }

    public X500NameBuilder(X500NameStyle r100) {
        this.rdns = new Vector();
        this.template = r100;
    }

    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] r100, String[] r101) {
        int r102 = r101.length;
        ASN1Encodable[] r103 = new ASN1Encodable[r102];
        int r104 = 0;
    L3:
        if (r104 == r102) goto L6;
        r103[r104] = this.template.stringToValue(r100[r104], r101[r104]);
        r104 = r104 + 1;
        goto L3
    L6:
        return addMultiValuedRDN(r100, r103);
    }

    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] r100, ASN1Encodable[] r101) {
        AttributeTypeAndValue[] r102 = new AttributeTypeAndValue[r100.length];
        int r103 = 0;
    L4:
        if (r103 == r100.length) goto L7;
        r102[r103] = new AttributeTypeAndValue(r100[r103], r101[r103]);
        r103 = r103 + 1;
        goto L4
    L7:
        return addMultiValuedRDN(r102);
    }

    public X500NameBuilder addMultiValuedRDN(AttributeTypeAndValue[] r100) {
        this.rdns.addElement(new RDN(r100));
        return this;
    }

    public X500NameBuilder addRDN(ASN1ObjectIdentifier r100, String r101) {
        addRDN(r100, this.template.stringToValue(r100, r101));
        return this;
    }

    public X500NameBuilder addRDN(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.rdns.addElement(new RDN(r100, r101));
        return this;
    }

    public X500NameBuilder addRDN(AttributeTypeAndValue r100) {
        this.rdns.addElement(new RDN(r100));
        return this;
    }

    public X500Name build() {
        int r100 = this.rdns.size();
        RDN[] r101 = new RDN[r100];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L6;
        r101[r102] = (RDN) this.rdns.elementAt(r102);
        r102 = r102 + 1;
        goto L3
    L6:
        return new X500Name(this.template, r101);
    }
}
