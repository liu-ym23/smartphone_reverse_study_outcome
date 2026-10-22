package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class AlgorithmIdentifier extends ASN1Object {
    private ASN1ObjectIdentifier algorithm;
    private ASN1Encodable parameters;

    public AlgorithmIdentifier(ASN1ObjectIdentifier r100) {
        this.algorithm = r100;
    }

    public AlgorithmIdentifier(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.algorithm = r100;
        this.parameters = r101;
    }

    private AlgorithmIdentifier(ASN1Sequence r100) {
        if (r100.size() < 1) goto L13;
        if (r100.size() > 2) goto L13;
        this.algorithm = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        if (r100.size() != 2) goto L9;
        ASN1Encodable r101 = r100.getObjectAt(1);
    L10:
        this.parameters = r101;
        return;
    L9:
        r101 = null;
    L13:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static AlgorithmIdentifier getInstance(Object r100) {
        if ((r100 instanceof AlgorithmIdentifier) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new AlgorithmIdentifier(ASN1Sequence.getInstance(r100));
    L5:
        return (AlgorithmIdentifier) r100;
    }

    public static AlgorithmIdentifier getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public ASN1Encodable getParameters() {
        return this.parameters;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.algorithm);
        ASN1Encodable r101 = this.parameters;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
