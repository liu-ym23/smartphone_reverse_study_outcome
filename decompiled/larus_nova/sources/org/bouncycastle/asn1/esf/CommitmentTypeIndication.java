package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CommitmentTypeIndication extends ASN1Object {
    private ASN1ObjectIdentifier commitmentTypeId;
    private ASN1Sequence commitmentTypeQualifier;

    public CommitmentTypeIndication(ASN1ObjectIdentifier r100) {
        this.commitmentTypeId = r100;
    }

    public CommitmentTypeIndication(ASN1ObjectIdentifier r100, ASN1Sequence r101) {
        this.commitmentTypeId = r100;
        this.commitmentTypeQualifier = r101;
    }

    private CommitmentTypeIndication(ASN1Sequence r100) {
        this.commitmentTypeId = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        if (r100.size() <= 1) goto L6;
        this.commitmentTypeQualifier = (ASN1Sequence) r100.getObjectAt(1);
        return;
    }

    public static CommitmentTypeIndication getInstance(Object r100) {
        if (r100 == null) goto L9;
        if ((r100 instanceof CommitmentTypeIndication) == true) goto L9;
        return new CommitmentTypeIndication(ASN1Sequence.getInstance(r100));
    L9:
        return (CommitmentTypeIndication) r100;
    }

    public ASN1ObjectIdentifier getCommitmentTypeId() {
        return this.commitmentTypeId;
    }

    public ASN1Sequence getCommitmentTypeQualifier() {
        return this.commitmentTypeQualifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.commitmentTypeId);
        ASN1Sequence r101 = this.commitmentTypeQualifier;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
