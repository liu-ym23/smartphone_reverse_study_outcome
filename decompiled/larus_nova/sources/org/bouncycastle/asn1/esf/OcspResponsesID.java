package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class OcspResponsesID extends ASN1Object {
    private OcspIdentifier ocspIdentifier;
    private OtherHash ocspRepHash;

    private OcspResponsesID(ASN1Sequence r100) {
        if (r100.size() < 1) goto L11;
        if (r100.size() > 2) goto L11;
        this.ocspIdentifier = OcspIdentifier.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L12;
        this.ocspRepHash = OtherHash.getInstance(r100.getObjectAt(1));
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public OcspResponsesID(OcspIdentifier r100) {
        this(r100, null);
    }

    public OcspResponsesID(OcspIdentifier r100, OtherHash r101) {
        this.ocspIdentifier = r100;
        this.ocspRepHash = r101;
    }

    public static OcspResponsesID getInstance(Object r100) {
        if ((r100 instanceof OcspResponsesID) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OcspResponsesID(ASN1Sequence.getInstance(r100));
    L5:
        return (OcspResponsesID) r100;
    }

    public OcspIdentifier getOcspIdentifier() {
        return this.ocspIdentifier;
    }

    public OtherHash getOcspRepHash() {
        return this.ocspRepHash;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.ocspIdentifier);
        OtherHash r101 = this.ocspRepHash;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
