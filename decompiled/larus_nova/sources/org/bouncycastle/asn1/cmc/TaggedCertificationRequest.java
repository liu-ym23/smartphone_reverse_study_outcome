package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class TaggedCertificationRequest extends ASN1Object {
    private final BodyPartID bodyPartID;
    private final CertificationRequest certificationRequest;

    private TaggedCertificationRequest(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.bodyPartID = BodyPartID.getInstance(r100.getObjectAt(0));
        this.certificationRequest = CertificationRequest.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public TaggedCertificationRequest(BodyPartID r100, CertificationRequest r101) {
        this.bodyPartID = r100;
        this.certificationRequest = r101;
    }

    public static TaggedCertificationRequest getInstance(Object r100) {
        if ((r100 instanceof TaggedCertificationRequest) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new TaggedCertificationRequest(ASN1Sequence.getInstance(r100));
    L5:
        return (TaggedCertificationRequest) r100;
    }

    public static TaggedCertificationRequest getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.bodyPartID);
        r100.add(this.certificationRequest);
        return new DERSequence(r100);
    }
}
