package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class DHDomainParameters extends ASN1Object {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ASN1Integer f525085g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ASN1Integer f525086j;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ASN1Integer f525087p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ASN1Integer f525088q;
    private DHValidationParms validationParms;

    public DHDomainParameters(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103, DHValidationParms r104) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L11;
        if (r102 == null) goto L9;
        this.f525087p = new ASN1Integer(r100);
        this.f525085g = new ASN1Integer(r101);
        this.f525088q = new ASN1Integer(r102);
        this.f525086j = new ASN1Integer(r103);
        this.validationParms = r104;
        return;
    L9:
        throw new IllegalArgumentException("'q' cannot be null");
    L11:
        throw new IllegalArgumentException("'g' cannot be null");
    L13:
        throw new IllegalArgumentException("'p' cannot be null");
    }

    public DHDomainParameters(ASN1Integer r100, ASN1Integer r101, ASN1Integer r102, ASN1Integer r103, DHValidationParms r104) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L11;
        if (r102 == null) goto L9;
        this.f525087p = r100;
        this.f525085g = r101;
        this.f525088q = r102;
        this.f525086j = r103;
        this.validationParms = r104;
        return;
    L9:
        throw new IllegalArgumentException("'q' cannot be null");
    L11:
        throw new IllegalArgumentException("'g' cannot be null");
    L13:
        throw new IllegalArgumentException("'p' cannot be null");
    }

    private DHDomainParameters(ASN1Sequence r100) {
        if (r100.size() < 3) goto L15;
        if (r100.size() > 5) goto L15;
        Enumeration r101 = r100.getObjects();
        this.f525087p = ASN1Integer.getInstance(r101.nextElement());
        this.f525085g = ASN1Integer.getInstance(r101.nextElement());
        this.f525088q = ASN1Integer.getInstance(r101.nextElement());
        ASN1Encodable r102 = getNext(r101);
        if (r102 != null) goto L9;
    L11:
        if (r102 == null) goto L16;
        this.validationParms = DHValidationParms.getInstance(r102.toASN1Primitive());
        return;
    L16:
        return;
    L9:
        if ((r102 instanceof ASN1Integer) == false) goto L11;
        this.f525086j = ASN1Integer.getInstance(r102);
        r102 = getNext(r101);
    L15:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static DHDomainParameters getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof DHDomainParameters) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new DHDomainParameters((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("Invalid DHDomainParameters: ".concat(r100.getClass().getName()));
    L13:
        return (DHDomainParameters) r100;
    }

    public static DHDomainParameters getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    private static ASN1Encodable getNext(Enumeration r100) {
        if (r100.hasMoreElements() == true) goto L7;
        return null;
    L7:
        return (ASN1Encodable) r100.nextElement();
    }

    public ASN1Integer getG() {
        return this.f525085g;
    }

    public ASN1Integer getJ() {
        return this.f525086j;
    }

    public ASN1Integer getP() {
        return this.f525087p;
    }

    public ASN1Integer getQ() {
        return this.f525088q;
    }

    public DHValidationParms getValidationParms() {
        return this.validationParms;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(5);
        r100.add(this.f525087p);
        r100.add(this.f525085g);
        r100.add(this.f525088q);
        ASN1Integer r101 = this.f525086j;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        DHValidationParms r102 = this.validationParms;
        if (r102 == null) goto L9;
        r100.add(r102);
    L9:
        return new DERSequence(r100);
    }
}
