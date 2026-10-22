package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ObjectDigestInfo extends ASN1Object {
    public static final int otherObjectDigest = 2;
    public static final int publicKey = 0;
    public static final int publicKeyCert = 1;
    AlgorithmIdentifier digestAlgorithm;
    ASN1Enumerated digestedObjectType;
    DERBitString objectDigest;
    ASN1ObjectIdentifier otherObjectTypeID;

    public ObjectDigestInfo(int r100, ASN1ObjectIdentifier r101, AlgorithmIdentifier r102, byte[] r103) {
        this.digestedObjectType = new ASN1Enumerated(r100);
        if (r100 != 2) goto L5;
        this.otherObjectTypeID = r101;
    L5:
        this.digestAlgorithm = r102;
        this.objectDigest = new DERBitString(r103);
    }

    private ObjectDigestInfo(ASN1Sequence r100) {
        if (r100.size() > 4) goto L12;
        if (r100.size() < 3) goto L12;
        int r101 = 0;
        this.digestedObjectType = ASN1Enumerated.getInstance(r100.getObjectAt(0));
        if (r100.size() != 4) goto L9;
        r101 = 1;
        this.otherObjectTypeID = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(1));
    L9:
        this.digestAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(r101 + 1));
        this.objectDigest = DERBitString.getInstance(r100.getObjectAt(r101 + 2));
        return;
    L12:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static ObjectDigestInfo getInstance(Object r100) {
        if ((r100 instanceof ObjectDigestInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ObjectDigestInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (ObjectDigestInfo) r100;
    }

    public static ObjectDigestInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public ASN1Enumerated getDigestedObjectType() {
        return this.digestedObjectType;
    }

    public DERBitString getObjectDigest() {
        return this.objectDigest;
    }

    public ASN1ObjectIdentifier getOtherObjectTypeID() {
        return this.otherObjectTypeID;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.digestedObjectType);
        ASN1ObjectIdentifier r101 = this.otherObjectTypeID;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        r100.add(this.digestAlgorithm);
        r100.add(this.objectDigest);
        return new DERSequence(r100);
    }
}
