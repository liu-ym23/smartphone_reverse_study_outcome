package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PBEParameter extends ASN1Object {
    ASN1Integer iterations;
    ASN1OctetString salt;

    private PBEParameter(ASN1Sequence r100) {
        this.salt = (ASN1OctetString) r100.getObjectAt(0);
        this.iterations = (ASN1Integer) r100.getObjectAt(1);
    }

    public PBEParameter(byte[] r100, int r101) {
        if (r100.length != 8) goto L7;
        this.salt = new DEROctetString(r100);
        this.iterations = new ASN1Integer(r101);
        return;
    L7:
        throw new IllegalArgumentException("salt length must be 8");
    }

    public static PBEParameter getInstance(Object r100) {
        if ((r100 instanceof PBEParameter) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PBEParameter(ASN1Sequence.getInstance(r100));
    L5:
        return (PBEParameter) r100;
    }

    public BigInteger getIterationCount() {
        return this.iterations.getValue();
    }

    public byte[] getSalt() {
        return this.salt.getOctets();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.salt);
        r100.add(this.iterations);
        return new DERSequence(r100);
    }
}
