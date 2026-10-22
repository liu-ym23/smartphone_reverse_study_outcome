package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CommitmentTypeQualifier extends ASN1Object {
    private ASN1ObjectIdentifier commitmentTypeIdentifier;
    private ASN1Encodable qualifier;

    public CommitmentTypeQualifier(ASN1ObjectIdentifier r100) {
        this(r100, null);
    }

    public CommitmentTypeQualifier(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.commitmentTypeIdentifier = r100;
        this.qualifier = r101;
    }

    private CommitmentTypeQualifier(ASN1Sequence r100) {
        this.commitmentTypeIdentifier = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        if (r100.size() <= 1) goto L6;
        this.qualifier = r100.getObjectAt(1);
        return;
    }

    public static CommitmentTypeQualifier getInstance(Object r100) {
        if ((r100 instanceof CommitmentTypeQualifier) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CommitmentTypeQualifier(ASN1Sequence.getInstance(r100));
    L5:
        return (CommitmentTypeQualifier) r100;
    }

    public ASN1ObjectIdentifier getCommitmentTypeIdentifier() {
        return this.commitmentTypeIdentifier;
    }

    public ASN1Encodable getQualifier() {
        return this.qualifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.commitmentTypeIdentifier);
        ASN1Encodable r101 = this.qualifier;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
