package org.bouncycastle.asn1.oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalParameter extends ASN1Object {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ASN1Integer f525050g;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ASN1Integer f525051p;

    public ElGamalParameter(BigInteger r100, BigInteger r101) {
        this.f525051p = new ASN1Integer(r100);
        this.f525050g = new ASN1Integer(r101);
    }

    private ElGamalParameter(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.f525051p = (ASN1Integer) r101.nextElement();
        this.f525050g = (ASN1Integer) r101.nextElement();
    }

    public static ElGamalParameter getInstance(Object r100) {
        if ((r100 instanceof ElGamalParameter) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ElGamalParameter(ASN1Sequence.getInstance(r100));
    L5:
        return (ElGamalParameter) r100;
    }

    public BigInteger getG() {
        return this.f525050g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f525051p.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.f525051p);
        r100.add(this.f525050g);
        return new DERSequence(r100);
    }
}
