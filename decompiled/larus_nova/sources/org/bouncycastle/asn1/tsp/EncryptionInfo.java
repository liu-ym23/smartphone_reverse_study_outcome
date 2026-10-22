package org.bouncycastle.asn1.tsp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DLSequence;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptionInfo extends ASN1Object {
    private ASN1ObjectIdentifier encryptionInfoType;
    private ASN1Encodable encryptionInfoValue;

    public EncryptionInfo(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.encryptionInfoType = r100;
        this.encryptionInfoValue = r101;
    }

    private EncryptionInfo(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.encryptionInfoType = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.encryptionInfoValue = r100.getObjectAt(1);
        return;
    L7:
        throw new IllegalArgumentException("wrong sequence size in constructor: " + r100.size());
    }

    public static EncryptionInfo getInstance(ASN1Object r100) {
        if ((r100 instanceof EncryptionInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EncryptionInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (EncryptionInfo) r100;
    }

    public static EncryptionInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.encryptionInfoType);
        r100.add(this.encryptionInfoValue);
        return new DLSequence(r100);
    }
}
