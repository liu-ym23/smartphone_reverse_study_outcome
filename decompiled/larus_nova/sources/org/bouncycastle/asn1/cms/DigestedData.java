package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class DigestedData extends ASN1Object {
    private ASN1OctetString digest;
    private AlgorithmIdentifier digestAlgorithm;
    private ContentInfo encapContentInfo;
    private ASN1Integer version;

    private DigestedData(ASN1Sequence r100) {
        this.version = (ASN1Integer) r100.getObjectAt(0);
        this.digestAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.encapContentInfo = ContentInfo.getInstance(r100.getObjectAt(2));
        this.digest = ASN1OctetString.getInstance(r100.getObjectAt(3));
    }

    public DigestedData(AlgorithmIdentifier r100, ContentInfo r101, byte[] r102) {
        this.version = new ASN1Integer(0);
        this.digestAlgorithm = r100;
        this.encapContentInfo = r101;
        this.digest = new DEROctetString(r102);
    }

    public static DigestedData getInstance(Object r100) {
        if ((r100 instanceof DigestedData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DigestedData(ASN1Sequence.getInstance(r100));
    L5:
        return (DigestedData) r100;
    }

    public static DigestedData getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public byte[] getDigest() {
        return this.digest.getOctets();
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public ContentInfo getEncapContentInfo() {
        return this.encapContentInfo;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.version);
        r100.add(this.digestAlgorithm);
        r100.add(this.encapContentInfo);
        r100.add(this.digest);
        return new BERSequence(r100);
    }
}
