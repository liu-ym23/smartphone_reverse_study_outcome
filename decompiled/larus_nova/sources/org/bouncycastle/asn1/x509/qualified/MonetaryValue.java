package org.bouncycastle.asn1.x509.qualified;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class MonetaryValue extends ASN1Object {
    private ASN1Integer amount;
    private Iso4217CurrencyCode currency;
    private ASN1Integer exponent;

    private MonetaryValue(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.currency = Iso4217CurrencyCode.getInstance(r101.nextElement());
        this.amount = ASN1Integer.getInstance(r101.nextElement());
        this.exponent = ASN1Integer.getInstance(r101.nextElement());
    }

    public MonetaryValue(Iso4217CurrencyCode r100, int r101, int r102) {
        this.currency = r100;
        this.amount = new ASN1Integer(r101);
        this.exponent = new ASN1Integer(r102);
    }

    public static MonetaryValue getInstance(Object r100) {
        if ((r100 instanceof MonetaryValue) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new MonetaryValue(ASN1Sequence.getInstance(r100));
    L5:
        return (MonetaryValue) r100;
    }

    public BigInteger getAmount() {
        return this.amount.getValue();
    }

    public Iso4217CurrencyCode getCurrency() {
        return this.currency;
    }

    public BigInteger getExponent() {
        return this.exponent.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.currency);
        r100.add(this.amount);
        r100.add(this.exponent);
        return new DERSequence(r100);
    }
}
