package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class GeneralSubtree extends ASN1Object {
    private static final BigInteger ZERO = null;
    private GeneralName base;
    private ASN1Integer maximum;
    private ASN1Integer minimum;

    static {
        ZERO = BigInteger.valueOf(0);
    }

    private GeneralSubtree(ASN1Sequence r100) {
        this.base = GeneralName.getInstance(r100.getObjectAt(0));
        int r101 = r100.size();
        if (r101 != 1) goto L5;
        return;
    L5:
        if (r101 != 2) goto L7;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r100.getObjectAt(1));
        int r103 = r102.getTagNo();
        if (r103 == 0) goto L25;
        if (r103 != 1) goto L24;
    L22:
        this.maximum = ASN1Integer.getInstance(r102, false);
        return;
    L24:
        throw new IllegalArgumentException("Bad tag number: " + r102.getTagNo());
    L25:
        this.minimum = ASN1Integer.getInstance(r102, false);
        return;
    L7:
        if (r101 != 3) goto L18;
        ASN1TaggedObject r104 = ASN1TaggedObject.getInstance(r100.getObjectAt(1));
        if (r104.getTagNo() != 0) goto L16;
        this.minimum = ASN1Integer.getInstance(r104, false);
        r102 = ASN1TaggedObject.getInstance(r100.getObjectAt(2));
        if (r102.getTagNo() == 1) goto L22;
        throw new IllegalArgumentException("Bad tag number for 'maximum': " + r102.getTagNo());
    L16:
        throw new IllegalArgumentException("Bad tag number for 'minimum': " + r104.getTagNo());
    L18:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public GeneralSubtree(GeneralName r100) {
        this(r100, null, null);
    }

    public GeneralSubtree(GeneralName r100, BigInteger r101, BigInteger r102) {
        this.base = r100;
        if (r102 == null) goto L5;
        this.maximum = new ASN1Integer(r102);
    L5:
        if (r101 != null) goto L7;
        ASN1Integer r103 = null;
    L8:
        this.minimum = r103;
        return;
    L7:
        r103 = new ASN1Integer(r101);
        goto L8
    }

    public static GeneralSubtree getInstance(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof GeneralSubtree) == false) goto L10;
        return (GeneralSubtree) r100;
    L10:
        return new GeneralSubtree(ASN1Sequence.getInstance(r100));
    }

    public static GeneralSubtree getInstance(ASN1TaggedObject r100, boolean r101) {
        return new GeneralSubtree(ASN1Sequence.getInstance(r100, r101));
    }

    public GeneralName getBase() {
        return this.base;
    }

    public BigInteger getMaximum() {
        ASN1Integer r100 = this.maximum;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    public BigInteger getMinimum() {
        ASN1Integer r100 = this.minimum;
        if (r100 != null) goto L7;
        return ZERO;
    L7:
        return r100.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.base);
        ASN1Integer r101 = this.minimum;
        if (r101 != null) goto L5;
    L7:
        ASN1Integer r102 = this.maximum;
        if (r102 == null) goto L11;
        r100.add(new DERTaggedObject(false, 1, r102));
    L11:
        return new DERSequence(r100);
    L5:
        if (r101.hasValue(ZERO) == true) goto L7;
        r100.add(new DERTaggedObject(false, 0, this.minimum));
        goto L7
    }
}
