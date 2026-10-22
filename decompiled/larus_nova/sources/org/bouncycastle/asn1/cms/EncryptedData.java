package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptedData extends ASN1Object {
    private EncryptedContentInfo encryptedContentInfo;
    private ASN1Set unprotectedAttrs;
    private ASN1Integer version;

    private EncryptedData(ASN1Sequence r100) {
        this.version = ASN1Integer.getInstance(r100.getObjectAt(0));
        this.encryptedContentInfo = EncryptedContentInfo.getInstance(r100.getObjectAt(1));
        if (r100.size() != 3) goto L6;
        this.unprotectedAttrs = ASN1Set.getInstance((ASN1TaggedObject) r100.getObjectAt(2), false);
        return;
    }

    public EncryptedData(EncryptedContentInfo r100) {
        this(r100, null);
    }

    public EncryptedData(EncryptedContentInfo r100, ASN1Set r101) {
        if (r101 != null) goto L5;
        long r102 = 0;
    L6:
        this.version = new ASN1Integer(r102);
        this.encryptedContentInfo = r100;
        this.unprotectedAttrs = r101;
        return;
    L5:
        r102 = 2;
        goto L6
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

    public EncryptedContentInfo getEncryptedContentInfo() {
        return this.encryptedContentInfo;
    }

    public ASN1Set getUnprotectedAttrs() {
        return this.unprotectedAttrs;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.version);
        r100.add(this.encryptedContentInfo);
        ASN1Set r101 = this.unprotectedAttrs;
        if (r101 == null) goto L6;
        r100.add(new BERTaggedObject(false, 1, r101));
    L6:
        return new BERSequence(r100);
    }
}
