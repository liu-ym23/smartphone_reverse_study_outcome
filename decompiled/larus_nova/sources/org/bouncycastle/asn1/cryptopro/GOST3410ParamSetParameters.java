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
public class GOST3410ParamSetParameters extends ASN1Object {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ASN1Integer f525041a;
    int keySize;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ASN1Integer f525042p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ASN1Integer f525043q;

    public GOST3410ParamSetParameters(int r100, BigInteger r101, BigInteger r102, BigInteger r103) {
        this.keySize = r100;
        this.f525042p = new ASN1Integer(r101);
        this.f525043q = new ASN1Integer(r102);
        this.f525041a = new ASN1Integer(r103);
    }

    public GOST3410ParamSetParameters(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.keySize = ((ASN1Integer) r101.nextElement()).intValueExact();
        this.f525042p = (ASN1Integer) r101.nextElement();
        this.f525043q = (ASN1Integer) r101.nextElement();
        this.f525041a = (ASN1Integer) r101.nextElement();
    }

    public static GOST3410ParamSetParameters getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof GOST3410ParamSetParameters) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new GOST3410ParamSetParameters((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("Invalid GOST3410Parameter: ".concat(r100.getClass().getName()));
    L13:
        return (GOST3410ParamSetParameters) r100;
    }

    public static GOST3410ParamSetParameters getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public BigInteger getA() {
        return this.f525041a.getPositiveValue();
    }

    public int getKeySize() {
        return this.keySize;
    }

    public int getLKeySize() {
        return this.keySize;
    }

    public BigInteger getP() {
        return this.f525042p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f525043q.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(new ASN1Integer(this.keySize));
        r100.add(this.f525042p);
        r100.add(this.f525043q);
        r100.add(this.f525041a);
        return new DERSequence(r100);
    }
}
