package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class SignerIdentifier extends ASN1Object implements ASN1Choice {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private ASN1Encodable f525031id;

    public SignerIdentifier(ASN1OctetString r100) {
        this.f525031id = new DERTaggedObject(false, 0, r100);
    }

    public SignerIdentifier(ASN1Primitive r100) {
        this.f525031id = r100;
    }

    public SignerIdentifier(IssuerAndSerialNumber r100) {
        this.f525031id = r100;
    }

    public static SignerIdentifier getInstance(Object r100) {
        if (r100 == null) goto L21;
        if ((r100 instanceof SignerIdentifier) == true) goto L21;
        if ((r100 instanceof IssuerAndSerialNumber) == false) goto L11;
        return new SignerIdentifier((IssuerAndSerialNumber) r100);
    L11:
        if ((r100 instanceof ASN1OctetString) == false) goto L15;
        return new SignerIdentifier((ASN1OctetString) r100);
    L15:
        if ((r100 instanceof ASN1Primitive) == false) goto L19;
        return new SignerIdentifier((ASN1Primitive) r100);
    L19:
        throw new IllegalArgumentException("Illegal object in SignerIdentifier: ".concat(r100.getClass().getName()));
    L21:
        return (SignerIdentifier) r100;
    }

    public ASN1Encodable getId() {
        ASN1Encodable r100 = this.f525031id;
        if ((r100 instanceof ASN1TaggedObject) == true) goto L5;
        return r100;
    L5:
        return ASN1OctetString.getInstance((ASN1TaggedObject) r100, false);
    }

    public boolean isTagged() {
        return this.f525031id instanceof ASN1TaggedObject;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f525031id.toASN1Primitive();
    }
}
