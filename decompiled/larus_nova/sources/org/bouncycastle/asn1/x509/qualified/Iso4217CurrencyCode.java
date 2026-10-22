package org.bouncycastle.asn1.x509.qualified;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERPrintableString;

/* JADX INFO: loaded from: classes42.dex */
public class Iso4217CurrencyCode extends ASN1Object implements ASN1Choice {
    final int ALPHABETIC_MAXSIZE;
    final int NUMERIC_MAXSIZE;
    final int NUMERIC_MINSIZE;
    int numeric;
    ASN1Encodable obj;

    public Iso4217CurrencyCode(int r100) {
        this.ALPHABETIC_MAXSIZE = 3;
        this.NUMERIC_MINSIZE = 1;
        this.NUMERIC_MAXSIZE = 999;
        if (r100 > 999) goto L8;
        if (r100 < 1) goto L8;
        this.obj = new ASN1Integer(r100);
        return;
    L8:
        throw new IllegalArgumentException("wrong size in numeric code : not in (1..999)");
    }

    public Iso4217CurrencyCode(String r100) {
        this.ALPHABETIC_MAXSIZE = 3;
        this.NUMERIC_MINSIZE = 1;
        this.NUMERIC_MAXSIZE = 999;
        if (r100.length() > 3) goto L7;
        this.obj = new DERPrintableString(r100);
        return;
    L7:
        throw new IllegalArgumentException("wrong size in alphabetic code : max size is 3");
    }

    public static Iso4217CurrencyCode getInstance(Object r100) {
        if (r100 == null) goto L17;
        if ((r100 instanceof Iso4217CurrencyCode) == true) goto L17;
        if ((r100 instanceof ASN1Integer) == false) goto L11;
        return new Iso4217CurrencyCode(ASN1Integer.getInstance(r100).intValueExact());
    L11:
        if ((r100 instanceof DERPrintableString) == false) goto L15;
        return new Iso4217CurrencyCode(DERPrintableString.getInstance(r100).getString());
    L15:
        throw new IllegalArgumentException("unknown object in getInstance");
    L17:
        return (Iso4217CurrencyCode) r100;
    }

    public String getAlphabetic() {
        return ((DERPrintableString) this.obj).getString();
    }

    public int getNumeric() {
        return ((ASN1Integer) this.obj).intValueExact();
    }

    public boolean isAlphabetic() {
        return this.obj instanceof DERPrintableString;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.obj.toASN1Primitive();
    }
}
