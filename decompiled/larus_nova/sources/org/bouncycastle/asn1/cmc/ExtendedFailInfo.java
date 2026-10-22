package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ExtendedFailInfo extends ASN1Object {
    private final ASN1ObjectIdentifier failInfoOID;
    private final ASN1Encodable failInfoValue;

    public ExtendedFailInfo(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.failInfoOID = r100;
        this.failInfoValue = r101;
    }

    private ExtendedFailInfo(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.failInfoOID = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.failInfoValue = r100.getObjectAt(1);
        return;
    L7:
        throw new IllegalArgumentException("Sequence must be 2 elements.");
    }

    public static ExtendedFailInfo getInstance(Object r100) {
        if ((r100 instanceof ExtendedFailInfo) == false) goto L7;
        return (ExtendedFailInfo) r100;
    L7:
        if ((r100 instanceof ASN1Encodable) == false) goto L13;
        ASN1Primitive r101 = ((ASN1Encodable) r100).toASN1Primitive();
        if ((r101 instanceof ASN1Sequence) == true) goto L11;
        return null;
    L11:
        return new ExtendedFailInfo((ASN1Sequence) r101);
    L13:
        if ((r100 instanceof byte[]) == true) goto L15;
        return null;
    L15:
        return getInstance(ASN1Sequence.getInstance(r100));
    }

    public ASN1ObjectIdentifier getFailInfoOID() {
        return this.failInfoOID;
    }

    public ASN1Encodable getFailInfoValue() {
        return this.failInfoValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.failInfoOID, this.failInfoValue});
    }
}
