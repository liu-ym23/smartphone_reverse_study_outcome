package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
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
public class KEKIdentifier extends ASN1Object {
    private ASN1GeneralizedTime date;
    private ASN1OctetString keyIdentifier;
    private OtherKeyAttribute other;

    private KEKIdentifier(ASN1Sequence r100) {
        this.keyIdentifier = (ASN1OctetString) r100.getObjectAt(0);
        int r101 = r100.size();
        if (r101 != 1) goto L5;
        return;
    L5:
        if (r101 != 2) goto L7;
        boolean r102 = r100.getObjectAt(1) instanceof ASN1GeneralizedTime;
        ASN1Encodable r103 = r100.getObjectAt(1);
        if (r102 == true) goto L14;
    L9:
        this.other = OtherKeyAttribute.getInstance(r103);
        return;
    L14:
        this.date = (ASN1GeneralizedTime) r103;
        return;
    L7:
        if (r101 != 3) goto L11;
        this.date = (ASN1GeneralizedTime) r100.getObjectAt(1);
        r103 = r100.getObjectAt(2);
        goto L9
    L11:
        throw new IllegalArgumentException("Invalid KEKIdentifier");
    }

    public KEKIdentifier(byte[] r100, ASN1GeneralizedTime r101, OtherKeyAttribute r102) {
        this.keyIdentifier = new DEROctetString(r100);
        this.date = r101;
        this.other = r102;
    }

    public static KEKIdentifier getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof KEKIdentifier) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new KEKIdentifier((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("Invalid KEKIdentifier: ".concat(r100.getClass().getName()));
    L13:
        return (KEKIdentifier) r100;
    }

    public static KEKIdentifier getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1GeneralizedTime getDate() {
        return this.date;
    }

    public ASN1OctetString getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public OtherKeyAttribute getOther() {
        return this.other;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.keyIdentifier);
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
