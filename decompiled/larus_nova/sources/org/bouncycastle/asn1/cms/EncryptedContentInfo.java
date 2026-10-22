package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptedContentInfo extends ASN1Object {
    private AlgorithmIdentifier contentEncryptionAlgorithm;
    private ASN1ObjectIdentifier contentType;
    private ASN1OctetString encryptedContent;

    public EncryptedContentInfo(ASN1ObjectIdentifier r100, AlgorithmIdentifier r101, ASN1OctetString r102) {
        this.contentType = r100;
        this.contentEncryptionAlgorithm = r101;
        this.encryptedContent = r102;
    }

    private EncryptedContentInfo(ASN1Sequence r100) {
        if (r100.size() < 2) goto L9;
        this.contentType = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        this.contentEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        if (r100.size() <= 2) goto L10;
        this.encryptedContent = ASN1OctetString.getInstance((ASN1TaggedObject) r100.getObjectAt(2), false);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Truncated Sequence Found");
    }

    public static EncryptedContentInfo getInstance(Object r100) {
        if ((r100 instanceof EncryptedContentInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EncryptedContentInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (EncryptedContentInfo) r100;
    }

    public AlgorithmIdentifier getContentEncryptionAlgorithm() {
        return this.contentEncryptionAlgorithm;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    public ASN1OctetString getEncryptedContent() {
        return this.encryptedContent;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.contentType);
        r100.add(this.contentEncryptionAlgorithm);
        ASN1OctetString r101 = this.encryptedContent;
        if (r101 == null) goto L6;
        r100.add(new BERTaggedObject(false, 0, r101));
    L6:
        return new BERSequence(r100);
    }
}
