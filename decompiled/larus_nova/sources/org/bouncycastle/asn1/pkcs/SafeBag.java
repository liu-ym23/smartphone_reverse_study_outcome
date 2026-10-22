package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.asn1.DLTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class SafeBag extends ASN1Object {
    private ASN1Set bagAttributes;
    private ASN1ObjectIdentifier bagId;
    private ASN1Encodable bagValue;

    public SafeBag(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.bagId = r100;
        this.bagValue = r101;
        this.bagAttributes = null;
    }

    public SafeBag(ASN1ObjectIdentifier r100, ASN1Encodable r101, ASN1Set r102) {
        this.bagId = r100;
        this.bagValue = r101;
        this.bagAttributes = r102;
    }

    private SafeBag(ASN1Sequence r100) {
        this.bagId = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        this.bagValue = ((ASN1TaggedObject) r100.getObjectAt(1)).getObject();
        if (r100.size() != 3) goto L6;
        this.bagAttributes = (ASN1Set) r100.getObjectAt(2);
        return;
    }

    public static SafeBag getInstance(Object r100) {
        if ((r100 instanceof SafeBag) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SafeBag(ASN1Sequence.getInstance(r100));
    L5:
        return (SafeBag) r100;
    }

    public ASN1Set getBagAttributes() {
        return this.bagAttributes;
    }

    public ASN1ObjectIdentifier getBagId() {
        return this.bagId;
    }

    public ASN1Encodable getBagValue() {
        return this.bagValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.bagId);
        r100.add(new DLTaggedObject(true, 0, this.bagValue));
        ASN1Set r101 = this.bagAttributes;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DLSequence(r100);
    }
}
