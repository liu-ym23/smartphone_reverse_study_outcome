package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;

/* JADX INFO: loaded from: classes42.dex */
public class ResponderID extends ASN1Object implements ASN1Choice {
    private ASN1Encodable value;

    public ResponderID(ASN1OctetString r100) {
        this.value = r100;
    }

    public ResponderID(X500Name r100) {
        this.value = r100;
    }

    public static ResponderID getInstance(Object r100) {
        if ((r100 instanceof ResponderID) == false) goto L7;
        return (ResponderID) r100;
    L7:
        if ((r100 instanceof DEROctetString) == false) goto L11;
        return new ResponderID((DEROctetString) r100);
    L11:
        if ((r100 instanceof ASN1TaggedObject) == false) goto L19;
        ASN1TaggedObject r101 = (ASN1TaggedObject) r100;
        if (r101.getTagNo() != 1) goto L17;
        return new ResponderID(X500Name.getInstance(r101, true));
    L17:
        return new ResponderID(ASN1OctetString.getInstance(r101, true));
    L19:
        return new ResponderID(X500Name.getInstance(r100));
    }

    public static ResponderID getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(r100.getObject());
    }

    public byte[] getKeyHash() {
        ASN1Encodable r100 = this.value;
        if ((r100 instanceof ASN1OctetString) == true) goto L5;
        return null;
    L5:
        return ((ASN1OctetString) r100).getOctets();
    }

    public X500Name getName() {
        ASN1Encodable r100 = this.value;
        if ((r100 instanceof ASN1OctetString) == false) goto L7;
        return null;
    L7:
        return X500Name.getInstance(r100);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1Encodable r100 = this.value;
        if ((r100 instanceof ASN1OctetString) == false) goto L7;
        return new DERTaggedObject(true, 2, r100);
    L7:
        return new DERTaggedObject(true, 1, r100);
    }
}
