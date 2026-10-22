package org.bouncycastle.asn1.x509;

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
public class DSAParameter extends ASN1Object {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ASN1Integer f525080g;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ASN1Integer f525081p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ASN1Integer f525082q;

    public DSAParameter(BigInteger r100, BigInteger r101, BigInteger r102) {
        this.f525081p = new ASN1Integer(r100);
        this.f525082q = new ASN1Integer(r101);
        this.f525080g = new ASN1Integer(r102);
    }

    private DSAParameter(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        Enumeration r101 = r100.getObjects();
        this.f525081p = ASN1Integer.getInstance(r101.nextElement());
        this.f525082q = ASN1Integer.getInstance(r101.nextElement());
        this.f525080g = ASN1Integer.getInstance(r101.nextElement());
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static DSAParameter getInstance(Object r100) {
        if ((r100 instanceof DSAParameter) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DSAParameter(ASN1Sequence.getInstance(r100));
    L5:
        return (DSAParameter) r100;
    }

    public static DSAParameter getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public BigInteger getG() {
        return this.f525080g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f525081p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f525082q.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.f525081p);
        r100.add(this.f525082q);
        r100.add(this.f525080g);
        return new DERSequence(r100);
    }
}
