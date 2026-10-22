package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CMCUnsignedData extends ASN1Object {
    private final BodyPartPath bodyPartPath;
    private final ASN1Encodable content;
    private final ASN1ObjectIdentifier identifier;

    private CMCUnsignedData(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        this.bodyPartPath = BodyPartPath.getInstance(r100.getObjectAt(0));
        this.identifier = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(1));
        this.content = r100.getObjectAt(2);
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public CMCUnsignedData(BodyPartPath r100, ASN1ObjectIdentifier r101, ASN1Encodable r102) {
        this.bodyPartPath = r100;
        this.identifier = r101;
        this.content = r102;
    }

    public static CMCUnsignedData getInstance(Object r100) {
        if ((r100 instanceof CMCUnsignedData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CMCUnsignedData(ASN1Sequence.getInstance(r100));
    L5:
        return (CMCUnsignedData) r100;
    }

    public BodyPartPath getBodyPartPath() {
        return this.bodyPartPath;
    }

    public ASN1Encodable getContent() {
        return this.content;
    }

    public ASN1ObjectIdentifier getIdentifier() {
        return this.identifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.bodyPartPath);
        r100.add(this.identifier);
        r100.add(this.content);
        return new DERSequence(r100);
    }
}
