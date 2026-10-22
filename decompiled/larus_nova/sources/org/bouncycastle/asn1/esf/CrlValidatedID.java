package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CrlValidatedID extends ASN1Object {
    private OtherHash crlHash;
    private CrlIdentifier crlIdentifier;

    private CrlValidatedID(ASN1Sequence r100) {
        if (r100.size() < 1) goto L11;
        if (r100.size() > 2) goto L11;
        this.crlHash = OtherHash.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L12;
        this.crlIdentifier = CrlIdentifier.getInstance(r100.getObjectAt(1));
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public CrlValidatedID(OtherHash r100) {
        this(r100, null);
    }

    public CrlValidatedID(OtherHash r100, CrlIdentifier r101) {
        this.crlHash = r100;
        this.crlIdentifier = r101;
    }

    public static CrlValidatedID getInstance(Object r100) {
        if ((r100 instanceof CrlValidatedID) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CrlValidatedID(ASN1Sequence.getInstance(r100));
    L5:
        return (CrlValidatedID) r100;
    }

    public OtherHash getCrlHash() {
        return this.crlHash;
    }

    public CrlIdentifier getCrlIdentifier() {
        return this.crlIdentifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.crlHash.toASN1Primitive());
        CrlIdentifier r101 = this.crlIdentifier;
        if (r101 == null) goto L6;
        r100.add(r101.toASN1Primitive());
    L6:
        return new DERSequence(r100);
    }
}
