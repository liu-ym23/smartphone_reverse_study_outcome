package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class CMSAlgorithmProtection extends ASN1Object {
    public static final int MAC = 2;
    public static final int SIGNATURE = 1;
    private final AlgorithmIdentifier digestAlgorithm;
    private final AlgorithmIdentifier macAlgorithm;
    private final AlgorithmIdentifier signatureAlgorithm;

    private CMSAlgorithmProtection(ASN1Sequence r100) {
        if (r100.size() != 2) goto L14;
        this.digestAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        ASN1TaggedObject r101 = ASN1TaggedObject.getInstance(r100.getObjectAt(1));
        if (r101.getTagNo() != 1) goto L8;
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(r101, false);
        this.macAlgorithm = null;
        return;
    L8:
        if (r101.getTagNo() != 2) goto L12;
        this.signatureAlgorithm = null;
        this.macAlgorithm = AlgorithmIdentifier.getInstance(r101, false);
        return;
    L12:
        throw new IllegalArgumentException("Unknown tag found: " + r101.getTagNo());
    L14:
        throw new IllegalArgumentException("Sequence wrong size: One of signatureAlgorithm or macAlgorithm must be present");
    }

    public CMSAlgorithmProtection(AlgorithmIdentifier r100, int r101, AlgorithmIdentifier r102) {
        if (r100 == null) goto L15;
        if (r102 == null) goto L15;
        this.digestAlgorithm = r100;
        if (r101 != 1) goto L9;
        this.signatureAlgorithm = r102;
        this.macAlgorithm = null;
        return;
    L9:
        if (r101 != 2) goto L13;
        this.signatureAlgorithm = null;
        this.macAlgorithm = r102;
        return;
    L13:
        throw new IllegalArgumentException("Unknown type: " + r101);
    L15:
        throw new NullPointerException("AlgorithmIdentifiers cannot be null");
    }

    public static CMSAlgorithmProtection getInstance(Object r100) {
        if ((r100 instanceof CMSAlgorithmProtection) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CMSAlgorithmProtection(ASN1Sequence.getInstance(r100));
    L5:
        return (CMSAlgorithmProtection) r100;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.digestAlgorithm);
        AlgorithmIdentifier r101 = this.signatureAlgorithm;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 1, r101));
    L5:
        AlgorithmIdentifier r102 = this.macAlgorithm;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(false, 2, r102));
    L9:
        return new DERSequence(r100);
    }
}
