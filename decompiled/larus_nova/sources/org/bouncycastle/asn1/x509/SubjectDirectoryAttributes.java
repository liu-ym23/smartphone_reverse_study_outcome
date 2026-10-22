package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class SubjectDirectoryAttributes extends ASN1Object {
    private Vector attributes;

    public SubjectDirectoryAttributes(Vector r100) {
        this.attributes = new Vector();
        Enumeration r101 = r100.elements();
    L4:
        if (r101.hasMoreElements() == false) goto L6;
        this.attributes.addElement(r101.nextElement());
        goto L4
    }

    private SubjectDirectoryAttributes(ASN1Sequence r100) {
        this.attributes = new Vector();
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L6;
        ASN1Sequence r102 = ASN1Sequence.getInstance(r101.nextElement());
        this.attributes.addElement(Attribute.getInstance(r102));
        goto L4
    }

    public static SubjectDirectoryAttributes getInstance(Object r100) {
        if ((r100 instanceof SubjectDirectoryAttributes) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SubjectDirectoryAttributes(ASN1Sequence.getInstance(r100));
    L5:
        return (SubjectDirectoryAttributes) r100;
    }

    public Vector getAttributes() {
        return this.attributes;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(this.attributes.size());
        Enumeration r101 = this.attributes.elements();
    L4:
        if (r101.hasMoreElements() == false) goto L7;
        r100.add((Attribute) r101.nextElement());
        goto L4
    L7:
        return new DERSequence(r100);
    }
}
