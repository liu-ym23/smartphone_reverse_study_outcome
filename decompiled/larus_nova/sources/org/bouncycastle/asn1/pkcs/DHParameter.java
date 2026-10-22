package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class DHParameter extends ASN1Object {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ASN1Integer f525052g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ASN1Integer f525053l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ASN1Integer f525054p;

    public DHParameter(BigInteger r100, BigInteger r101, int r102) {
        this.f525054p = new ASN1Integer(r100);
        this.f525052g = new ASN1Integer(r101);
        if (r102 == 0) goto L5;
        ASN1Integer r103 = new ASN1Integer(r102);
    L6:
        this.f525053l = r103;
        return;
    L5:
        r103 = null;
        goto L6
    }

    private DHParameter(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.f525054p = ASN1Integer.getInstance(r101.nextElement());
        this.f525052g = ASN1Integer.getInstance(r101.nextElement());
        if (r101.hasMoreElements() == false) goto L5;
        ASN1Integer r102 = (ASN1Integer) r101.nextElement();
    L6:
        this.f525053l = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static DHParameter getInstance(Object r100) {
        if ((r100 instanceof DHParameter) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DHParameter(ASN1Sequence.getInstance(r100));
    L5:
        return (DHParameter) r100;
    }

    public BigInteger getG() {
        return this.f525052g.getPositiveValue();
    }

    public BigInteger getL() {
        ASN1Integer r100 = this.f525053l;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f525054p.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.f525054p);
        r100.add(this.f525052g);
        if (getL() == null) goto L6;
        r100.add(this.f525053l);
    L6:
        return new DERSequence(r100);
    }
}
