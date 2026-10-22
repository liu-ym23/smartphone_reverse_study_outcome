package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class RecipientKeyIdentifier extends ASN1Object {
    private ASN1GeneralizedTime date;
    private OtherKeyAttribute other;
    private ASN1OctetString subjectKeyIdentifier;

    public RecipientKeyIdentifier(ASN1OctetString r100, ASN1GeneralizedTime r101, OtherKeyAttribute r102) {
        this.subjectKeyIdentifier = r100;
        this.date = r101;
        this.other = r102;
    }

    public RecipientKeyIdentifier(ASN1Sequence r100) {
        this.subjectKeyIdentifier = ASN1OctetString.getInstance(r100.getObjectAt(0));
        int r101 = r100.size();
        if (r101 != 1) goto L5;
        return;
    L5:
        if (r101 == 2) goto L13;
        if (r101 != 3) goto L11;
        this.date = ASN1GeneralizedTime.getInstance(r100.getObjectAt(1));
    L9:
        this.other = OtherKeyAttribute.getInstance(r100.getObjectAt(2));
        return;
    L11:
        throw new IllegalArgumentException("Invalid RecipientKeyIdentifier");
    L13:
        if ((r100.getObjectAt(1) instanceof ASN1GeneralizedTime) == false) goto L9;
        this.date = ASN1GeneralizedTime.getInstance(r100.getObjectAt(1));
    }

    public RecipientKeyIdentifier(byte[] r100) {
        this(r100, null, null);
    }

    public RecipientKeyIdentifier(byte[] r100, ASN1GeneralizedTime r101, OtherKeyAttribute r102) {
        this.subjectKeyIdentifier = new DEROctetString(r100);
        this.date = r101;
        this.other = r102;
    }

    public static RecipientKeyIdentifier getInstance(Object r100) {
        if ((r100 instanceof RecipientKeyIdentifier) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RecipientKeyIdentifier(ASN1Sequence.getInstance(r100));
    L5:
        return (RecipientKeyIdentifier) r100;
    }

    public static RecipientKeyIdentifier getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1GeneralizedTime getDate() {
        return this.date;
    }

    public OtherKeyAttribute getOtherKeyAttribute() {
        return this.other;
    }

    public ASN1OctetString getSubjectKeyIdentifier() {
        return this.subjectKeyIdentifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.subjectKeyIdentifier);
        ASN1GeneralizedTime r101 = this.date;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        OtherKeyAttribute r102 = this.other;
        if (r102 == null) goto L9;
        r100.add(r102);
    L9:
        return new DERSequence(r100);
    }
}
