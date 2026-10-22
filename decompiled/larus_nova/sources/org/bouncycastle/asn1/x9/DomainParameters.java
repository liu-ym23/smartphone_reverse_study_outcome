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
public class DomainParameters extends ASN1Object {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ASN1Integer f525090g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ASN1Integer f525091j;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ASN1Integer f525092p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ASN1Integer f525093q;
    private final ValidationParams validationParams;

    public DomainParameters(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103, ValidationParams r104) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L15;
        if (r102 == null) goto L13;
        this.f525092p = new ASN1Integer(r100);
        this.f525090g = new ASN1Integer(r101);
        this.f525093q = new ASN1Integer(r102);
        if (r103 == null) goto L9;
        ASN1Integer r105 = new ASN1Integer(r103);
    L10:
        this.f525091j = r105;
        this.validationParams = r104;
        return;
    L9:
        r105 = null;
        goto L10
    L13:
        throw new IllegalArgumentException("'q' cannot be null");
    L15:
        throw new IllegalArgumentException("'g' cannot be null");
    L17:
        throw new IllegalArgumentException("'p' cannot be null");
    }

    private DomainParameters(ASN1Sequence r100) {
        if (r100.size() < 3) goto L17;
        if (r100.size() > 5) goto L17;
        Enumeration r101 = r100.getObjects();
        this.f525092p = ASN1Integer.getInstance(r101.nextElement());
        this.f525090g = ASN1Integer.getInstance(r101.nextElement());
        this.f525093q = ASN1Integer.getInstance(r101.nextElement());
        ASN1Encodable r102 = getNext(r101);
        if (r102 != null) goto L9;
    L11:
        this.f525091j = null;
    L12:
        if (r102 == null) goto L14;
        this.validationParams = ValidationParams.getInstance(r102.toASN1Primitive());
        return;
    L14:
        this.validationParams = null;
        return;
    L9:
        if ((r102 instanceof ASN1Integer) == false) goto L11;
        this.f525091j = ASN1Integer.getInstance(r102);
        r102 = getNext(r101);
    L17:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static DomainParameters getInstance(Object r100) {
        if ((r100 instanceof DomainParameters) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DomainParameters(ASN1Sequence.getInstance(r100));
    L5:
        return (DomainParameters) r100;
    }

    public static DomainParameters getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    private static ASN1Encodable getNext(Enumeration r100) {
        if (r100.hasMoreElements() == true) goto L7;
        return null;
    L7:
        return (ASN1Encodable) r100.nextElement();
    }

    public BigInteger getG() {
        return this.f525090g.getPositiveValue();
    }

    public BigInteger getJ() {
        ASN1Integer r100 = this.f525091j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f525092p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f525093q.getPositiveValue();
    }

    public ValidationParams getValidationParams() {
        return this.validationParams;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(5);
        r100.add(this.f525092p);
        r100.add(this.f525090g);
        r100.add(this.f525093q);
        ASN1Integer r101 = this.f525091j;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        ValidationParams r102 = this.validationParams;
        if (r102 == null) goto L9;
        r100.add(r102);
    L9:
        return new DERSequence(r100);
    }
}
