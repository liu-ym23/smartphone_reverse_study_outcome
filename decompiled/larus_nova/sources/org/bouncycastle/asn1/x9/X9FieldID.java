package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class X9FieldID extends ASN1Object implements X9ObjectIdentifiers {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private ASN1ObjectIdentifier f525100id;
    private ASN1Primitive parameters;

    public X9FieldID(int r100, int r101) {
        this(r100, r101, 0, 0);
    }

    public X9FieldID(int r100, int r101, int r102, int r103) {
        this.f525100id = X9ObjectIdentifiers.characteristic_two_field;
        ASN1EncodableVector r104 = new ASN1EncodableVector(3);
        r104.add(new ASN1Integer(r100));
        if (r102 != 0) goto L8;
        if (r103 != 0) goto L7;
        r104.add(X9ObjectIdentifiers.tpBasis);
        r104.add(new ASN1Integer(r101));
    L11:
        this.parameters = new DERSequence(r104);
        return;
    L7:
        throw new IllegalArgumentException("inconsistent k values");
    L8:
        if (r102 <= r101) goto L14;
        if (r103 <= r102) goto L14;
        r104.add(X9ObjectIdentifiers.ppBasis);
        ASN1EncodableVector r105 = new ASN1EncodableVector(3);
        r105.add(new ASN1Integer(r101));
        r105.add(new ASN1Integer(r102));
        r105.add(new ASN1Integer(r103));
        r104.add(new DERSequence(r105));
    L14:
        throw new IllegalArgumentException("inconsistent k values");
    }

    public X9FieldID(BigInteger r100) {
        this.f525100id = X9ObjectIdentifiers.prime_field;
        this.parameters = new ASN1Integer(r100);
    }

    private X9FieldID(ASN1Sequence r100) {
        this.f525100id = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.parameters = r100.getObjectAt(1).toASN1Primitive();
    }

    public static X9FieldID getInstance(Object r100) {
        if ((r100 instanceof X9FieldID) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new X9FieldID(ASN1Sequence.getInstance(r100));
    L5:
        return (X9FieldID) r100;
    }

    public ASN1ObjectIdentifier getIdentifier() {
        return this.f525100id;
    }

    public ASN1Primitive getParameters() {
        return this.parameters;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.f525100id);
        r100.add(this.parameters);
        return new DERSequence(r100);
    }
}
