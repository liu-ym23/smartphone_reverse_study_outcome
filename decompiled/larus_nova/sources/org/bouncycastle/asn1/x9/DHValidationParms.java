package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class DHValidationParms extends ASN1Object {
    private ASN1Integer pgenCounter;
    private DERBitString seed;

    private DHValidationParms(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.seed = DERBitString.getInstance(r100.getObjectAt(0));
        this.pgenCounter = ASN1Integer.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public DHValidationParms(DERBitString r100, ASN1Integer r101) {
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

    public static DHValidationParms getInstance(Object r100) {
        if ((r100 instanceof DHValidationParms) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DHValidationParms(ASN1Sequence.getInstance(r100));
    L5:
        return (DHValidationParms) r100;
    }

    public static DHValidationParms getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1Integer getPgenCounter() {
        return this.pgenCounter;
    }

    public DERBitString getSeed() {
        return this.seed;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.seed);
        r100.add(this.pgenCounter);
        return new DERSequence(r100);
    }
}
