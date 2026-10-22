package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ValidationParams extends ASN1Object {
    private ASN1Integer pgenCounter;
    private DERBitString seed;

    private ValidationParams(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.seed = DERBitString.getInstance(r100.getObjectAt(0));
        this.pgenCounter = ASN1Integer.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public ValidationParams(DERBitString r100, ASN1Integer r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L8;
        this.seed = r100;
        this.pgenCounter = r101;
        return;
    L8:
        throw new IllegalArgumentException("'pgenCounter' cannot be null");
    L10:
        throw new IllegalArgumentException("'seed' cannot be null");
    }

    public ValidationParams(byte[] r100, int r101) {
        if (r100 == null) goto L7;
        this.seed = new DERBitString(r100);
        this.pgenCounter = new ASN1Integer(r101);
        return;
    L7:
        throw new IllegalArgumentException("'seed' cannot be null");
    }

    public static ValidationParams getInstance(Object r100) {
        if ((r100 instanceof ValidationParams) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ValidationParams(ASN1Sequence.getInstance(r100));
    L5:
        return (ValidationParams) r100;
    }

    public static ValidationParams getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public BigInteger getPgenCounter() {
        return this.pgenCounter.getPositiveValue();
    }

    public byte[] getSeed() {
        return this.seed.getBytes();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.seed);
        r100.add(this.pgenCounter);
        return new DERSequence(r100);
    }
}
