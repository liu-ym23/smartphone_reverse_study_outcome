package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class CompressedData extends ASN1Object {
    private AlgorithmIdentifier compressionAlgorithm;
    private ContentInfo encapContentInfo;
    private ASN1Integer version;

    private CompressedData(ASN1Sequence r100) {
        this.version = (ASN1Integer) r100.getObjectAt(0);
        this.compressionAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.encapContentInfo = ContentInfo.getInstance(r100.getObjectAt(2));
    }

    public CompressedData(AlgorithmIdentifier r100, ContentInfo r101) {
        this.version = new ASN1Integer(0);
        this.compressionAlgorithm = r100;
        this.encapContentInfo = r101;
    }

    public static CompressedData getInstance(Object r100) {
        if ((r100 instanceof CompressedData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CompressedData(ASN1Sequence.getInstance(r100));
    L5:
        return (CompressedData) r100;
    }

    public static CompressedData getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public AlgorithmIdentifier getCompressionAlgorithmIdentifier() {
        return this.compressionAlgorithm;
    }

    public ContentInfo getEncapContentInfo() {
        return this.encapContentInfo;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.version);
        r100.add(this.compressionAlgorithm);
        r100.add(this.encapContentInfo);
        return new BERSequence(r100);
    }
}
