package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class OtherHashAlgAndValue extends ASN1Object {
    private AlgorithmIdentifier hashAlgorithm;
    private ASN1OctetString hashValue;

    private OtherHashAlgAndValue(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.hashValue = ASN1OctetString.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public OtherHashAlgAndValue(AlgorithmIdentifier r100, ASN1OctetString r101) {
        this.hashAlgorithm = r100;
        this.hashValue = r101;
    }

    public static OtherHashAlgAndValue getInstance(Object r100) {
        if ((r100 instanceof OtherHashAlgAndValue) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OtherHashAlgAndValue(ASN1Sequence.getInstance(r100));
    L5:
        return (OtherHashAlgAndValue) r100;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public ASN1OctetString getHashValue() {
        return this.hashValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.hashAlgorithm);
        r100.add(this.hashValue);
        return new DERSequence(r100);
    }
}
