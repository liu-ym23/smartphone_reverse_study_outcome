package org.bouncycastle.asn1.isismtt.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class MonetaryLimit extends ASN1Object {
    ASN1Integer amount;
    DERPrintableString currency;
    ASN1Integer exponent;

    public MonetaryLimit(String r100, int r101, int r102) {
        this.currency = new DERPrintableString(r100, true);
        this.amount = new ASN1Integer(r101);
        this.exponent = new ASN1Integer(r102);
    }

    private MonetaryLimit(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        Enumeration r101 = r100.getObjects();
        this.currency = DERPrintableString.getInstance(r101.nextElement());
        this.amount = ASN1Integer.getInstance(r101.nextElement());
        this.exponent = ASN1Integer.getInstance(r101.nextElement());
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static MonetaryLimit getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof MonetaryLimit) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new MonetaryLimit(ASN1Sequence.getInstance(r100));
    L11:
        throw new IllegalArgumentException("unknown object in getInstance");
    L13:
        return (MonetaryLimit) r100;
    }

    public BigInteger getAmount() {
        return this.amount.getValue();
    }

    public String getCurrency() {
        return this.currency.getString();
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
