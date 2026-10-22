package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class OriginatorIdentifierOrKey extends ASN1Object implements ASN1Choice {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private ASN1Encodable f525029id;

    public OriginatorIdentifierOrKey(ASN1OctetString r100) {
        this(new SubjectKeyIdentifier(r100.getOctets()));
    }

    public OriginatorIdentifierOrKey(ASN1Primitive r100) {
        this.f525029id = r100;
    }

    public OriginatorIdentifierOrKey(IssuerAndSerialNumber r100) {
        this.f525029id = r100;
    }

    public OriginatorIdentifierOrKey(OriginatorPublicKey r100) {
        this.f525029id = new DERTaggedObject(false, 1, r100);
    }

    public OriginatorIdentifierOrKey(SubjectKeyIdentifier r100) {
        this.f525029id = new DERTaggedObject(false, 0, r100);
    }

    public static OriginatorIdentifierOrKey getInstance(Object r100) {
        if (r100 == null) goto L26;
        if ((r100 instanceof OriginatorIdentifierOrKey) == true) goto L26;
        if ((r100 instanceof IssuerAndSerialNumber) == true) goto L24;
        if ((r100 instanceof ASN1Sequence) == true) goto L24;
        if ((r100 instanceof ASN1TaggedObject) == false) goto L22;
        ASN1TaggedObject r101 = (ASN1TaggedObject) r100;
        if (r101.getTagNo() != 0) goto L18;
        return new OriginatorIdentifierOrKey(SubjectKeyIdentifier.getInstance(r101, false));
    L18:
        if (r101.getTagNo() != 1) goto L22;
        return new OriginatorIdentifierOrKey(OriginatorPublicKey.getInstance(r101, false));
    L22:
        throw new IllegalArgumentException("Invalid OriginatorIdentifierOrKey: ".concat(r100.getClass().getName()));
    L24:
        return new OriginatorIdentifierOrKey(IssuerAndSerialNumber.getInstance(r100));
    L26:
        return (OriginatorIdentifierOrKey) r100;
    }

    public static OriginatorIdentifierOrKey getInstance(ASN1TaggedObject r100, boolean r101) {
        if (r101 == false) goto L6;
        return getInstance(r100.getObject());
    L6:
        throw new IllegalArgumentException("Can't implicitly tag OriginatorIdentifierOrKey");
    }

    public ASN1Encodable getId() {
        return this.f525029id;
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        ASN1Encodable r100 = this.f525029id;
        if ((r100 instanceof IssuerAndSerialNumber) == true) goto L5;
        return null;
    L5:
        return (IssuerAndSerialNumber) r100;
    }

    public OriginatorPublicKey getOriginatorKey() {
        ASN1Encodable r100 = this.f525029id;
        if ((r100 instanceof ASN1TaggedObject) == true) goto L5;
        return null;
    L5:
        if (((ASN1TaggedObject) r100).getTagNo() == 1) goto L7;
        return null;
    L7:
        return OriginatorPublicKey.getInstance((ASN1TaggedObject) this.f525029id, false);
    }

    public SubjectKeyIdentifier getSubjectKeyIdentifier() {
        ASN1Encodable r100 = this.f525029id;
        if ((r100 instanceof ASN1TaggedObject) == true) goto L5;
        return null;
    L5:
        if (((ASN1TaggedObject) r100).getTagNo() == 0) goto L7;
        return null;
    L7:
        return SubjectKeyIdentifier.getInstance((ASN1TaggedObject) this.f525029id, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f525029id.toASN1Primitive();
    }
}
