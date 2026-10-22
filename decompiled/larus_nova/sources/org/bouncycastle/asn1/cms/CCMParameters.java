package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class CCMParameters extends ASN1Object {
    private int icvLen;
    private byte[] nonce;

    private CCMParameters(ASN1Sequence r100) {
        this.nonce = ASN1OctetString.getInstance(r100.getObjectAt(0)).getOctets();
        if (r100.size() != 2) goto L5;
        int r101 = ASN1Integer.getInstance(r100.getObjectAt(1)).intValueExact();
    L6:
        this.icvLen = r101;
        return;
    L5:
        r101 = 12;
        goto L6
    }

    public CCMParameters(byte[] r100, int r101) {
        this.nonce = Arrays.clone(r100);
        this.icvLen = r101;
    }

    public static CCMParameters getInstance(Object r100) {
        if ((r100 instanceof CCMParameters) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CCMParameters(ASN1Sequence.getInstance(r100));
    L5:
        return (CCMParameters) r100;
    }

    public int getIcvLen() {
        return this.icvLen;
    }

    public byte[] getNonce() {
        return Arrays.clone(this.nonce);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(new DEROctetString(this.nonce));
        int r101 = this.icvLen;
        if (r101 == 12) goto L6;
        r100.add(new ASN1Integer(r101));
    L6:
        return new DERSequence(r100);
    }
}
