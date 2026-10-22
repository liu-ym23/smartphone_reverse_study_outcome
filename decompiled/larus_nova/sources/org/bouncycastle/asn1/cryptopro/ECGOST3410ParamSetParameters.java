package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ECGOST3410ParamSetParameters extends ASN1Object {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ASN1Integer f525034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ASN1Integer f525035b;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ASN1Integer f525036p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ASN1Integer f525037q;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    ASN1Integer f525038x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    ASN1Integer f525039y;

    public ECGOST3410ParamSetParameters(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103, int r104, BigInteger r105) {
        this.f525034a = new ASN1Integer(r100);
        this.f525035b = new ASN1Integer(r101);
        this.f525036p = new ASN1Integer(r102);
        this.f525037q = new ASN1Integer(r103);
        this.f525038x = new ASN1Integer(r104);
        this.f525039y = new ASN1Integer(r105);
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.f525034a = (ASN1Integer) r101.nextElement();
        this.f525035b = (ASN1Integer) r101.nextElement();
        this.f525036p = (ASN1Integer) r101.nextElement();
        this.f525037q = (ASN1Integer) r101.nextElement();
        this.f525038x = (ASN1Integer) r101.nextElement();
        this.f525039y = (ASN1Integer) r101.nextElement();
    }

    public static ECGOST3410ParamSetParameters getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof ECGOST3410ParamSetParameters) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new ECGOST3410ParamSetParameters((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("Invalid GOST3410Parameter: ".concat(r100.getClass().getName()));
    L13:
        return (ECGOST3410ParamSetParameters) r100;
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public BigInteger getA() {
        return this.f525034a.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f525036p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f525037q.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(6);
        r100.add(this.f525034a);
        r100.add(this.f525035b);
        r100.add(this.f525036p);
        r100.add(this.f525037q);
        r100.add(this.f525038x);
        r100.add(this.f525039y);
        return new DERSequence(r100);
    }
}
