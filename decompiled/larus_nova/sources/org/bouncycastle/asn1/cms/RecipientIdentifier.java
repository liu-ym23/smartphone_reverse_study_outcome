package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class RecipientIdentifier extends ASN1Object implements ASN1Choice {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private ASN1Encodable f525030id;

    public RecipientIdentifier(ASN1OctetString r100) {
        this.f525030id = new DERTaggedObject(false, 0, r100);
    }

    public RecipientIdentifier(ASN1Primitive r100) {
        this.f525030id = r100;
    }

    public RecipientIdentifier(IssuerAndSerialNumber r100) {
        this.f525030id = r100;
    }

    public static RecipientIdentifier getInstance(Object r100) {
        if (r100 == null) goto L21;
        if ((r100 instanceof RecipientIdentifier) == true) goto L21;
        if ((r100 instanceof IssuerAndSerialNumber) == false) goto L11;
        return new RecipientIdentifier((IssuerAndSerialNumber) r100);
    L11:
        if ((r100 instanceof ASN1OctetString) == false) goto L15;
        return new RecipientIdentifier((ASN1OctetString) r100);
    L15:
        if ((r100 instanceof ASN1Primitive) == false) goto L19;
        return new RecipientIdentifier((ASN1Primitive) r100);
    L19:
        throw new IllegalArgumentException("Illegal object in RecipientIdentifier: ".concat(r100.getClass().getName()));
    L21:
        return (RecipientIdentifier) r100;
    }

    public ASN1Encodable getId() {
        ASN1Encodable r100 = this.f525030id;
        if ((r100 instanceof ASN1TaggedObject) == false) goto L7;
        return ASN1OctetString.getInstance((ASN1TaggedObject) r100, false);
    L7:
        return IssuerAndSerialNumber.getInstance(r100);
    }

    public boolean isTagged() {
        return this.f525030id instanceof ASN1TaggedObject;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f525030id.toASN1Primitive();
    }
}
