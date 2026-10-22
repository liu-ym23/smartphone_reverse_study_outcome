package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
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
public class EncryptedData extends ASN1Object {
    ASN1Sequence data;

    public EncryptedData(ASN1ObjectIdentifier r100, AlgorithmIdentifier r101, ASN1Encodable r102) {
        ASN1EncodableVector r103 = new ASN1EncodableVector(3);
        r103.add(r100);
        r103.add(r101.toASN1Primitive());
        r103.add(new BERTaggedObject(false, 0, r102));
        this.data = new BERSequence(r103);
    }

    private EncryptedData(ASN1Sequence r100) {
        if (((ASN1Integer) r100.getObjectAt(0)).intValueExact() != 0) goto L7;
        this.data = ASN1Sequence.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("sequence not version 0");
    }

    public static EncryptedData getInstance(Object r100) {
        if ((r100 instanceof EncryptedData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EncryptedData(ASN1Sequence.getInstance(r100));
    L5:
        return (EncryptedData) r100;
    }

    public ASN1OctetString getContent() {
        if (this.data.size() == 3) goto L5;
        return null;
    L5:
        return ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(this.data.getObjectAt(2)), false);
    }

    public ASN1ObjectIdentifier getContentType() {
        return ASN1ObjectIdentifier.getInstance(this.data.getObjectAt(0));
    }

    public AlgorithmIdentifier getEncryptionAlgorithm() {
        return AlgorithmIdentifier.getInstance(this.data.getObjectAt(1));
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(new ASN1Integer(0));
        r100.add(this.data);
        return new BERSequence(r100);
    }
}
