package org.bouncycastle.asn1.esf;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class OtherRevVals extends ASN1Object {
    private ASN1ObjectIdentifier otherRevValType;
    private ASN1Encodable otherRevVals;

    public OtherRevVals(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.otherRevValType = r100;
        this.otherRevVals = r101;
    }

    private OtherRevVals(ASN1Sequence r100) {
        if (r100.size() != 2) goto L10;
        this.otherRevValType = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        this.otherRevVals = ASN1Primitive.fromByteArray(r100.getObjectAt(1).toASN1Primitive().getEncoded(ASN1Encoding.DER));     // Catch: IOException -> L7
        return;
    L8:
        throw new IllegalStateException();
    L10:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static OtherRevVals getInstance(Object r100) {
        if ((r100 instanceof OtherRevVals) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OtherRevVals(ASN1Sequence.getInstance(r100));
    L5:
        return (OtherRevVals) r100;
    }

    public ASN1ObjectIdentifier getOtherRevValType() {
        return this.otherRevValType;
    }

    public ASN1Encodable getOtherRevVals() {
        return this.otherRevVals;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.otherRevValType);
        r100.add(this.otherRevVals);
        return new DERSequence(r100);
    }
}
