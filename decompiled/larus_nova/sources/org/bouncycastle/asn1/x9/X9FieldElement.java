package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECFieldElement;

/* JADX INFO: loaded from: classes42.dex */
public class X9FieldElement extends ASN1Object {
    private static X9IntegerConverter converter;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected ECFieldElement f525099f;

    static {
        converter = new X9IntegerConverter();
    }

    public X9FieldElement(int r100, int r101, int r110, int r111, ASN1OctetString r112) {
        this(new ECFieldElement.F2m(r100, r101, r110, r111, new BigInteger(1, r112.getOctets())));
    }

    public X9FieldElement(BigInteger r100, ASN1OctetString r101) {
        this(new ECFieldElement.Fp(r100, new BigInteger(1, r101.getOctets())));
    }

    public X9FieldElement(ECFieldElement r100) {
        this.f525099f = r100;
    }

    public ECFieldElement getValue() {
        return this.f525099f;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        int r100 = converter.getByteLength(this.f525099f);
        return new DEROctetString(converter.integerToBytes(this.f525099f.toBigInteger(), r100));
    }
}
