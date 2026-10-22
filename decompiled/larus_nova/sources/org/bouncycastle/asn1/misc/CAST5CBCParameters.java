package org.bouncycastle.asn1.misc;

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
public class CAST5CBCParameters extends ASN1Object {

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    ASN1OctetString f525048iv;
    ASN1Integer keyLength;

    private CAST5CBCParameters(ASN1Sequence r100) {
        this.f525048iv = (ASN1OctetString) r100.getObjectAt(0);
        this.keyLength = (ASN1Integer) r100.getObjectAt(1);
    }

    public CAST5CBCParameters(byte[] r100, int r101) {
        this.f525048iv = new DEROctetString(Arrays.clone(r100));
        this.keyLength = new ASN1Integer(r101);
    }

    public static CAST5CBCParameters getInstance(Object r100) {
        if ((r100 instanceof CAST5CBCParameters) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CAST5CBCParameters(ASN1Sequence.getInstance(r100));
    L5:
        return (CAST5CBCParameters) r100;
    }

    public byte[] getIV() {
        return Arrays.clone(this.f525048iv.getOctets());
    }

    public int getKeyLength() {
        return this.keyLength.intValueExact();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.f525048iv);
        r100.add(this.keyLength);
        return new DERSequence(r100);
    }
}
