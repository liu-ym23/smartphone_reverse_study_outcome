package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

/* JADX INFO: loaded from: classes42.dex */
public class PKIFreeText extends ASN1Object {
    ASN1Sequence strings;

    public PKIFreeText(String r100) {
        this(new DERUTF8String(r100));
    }

    private PKIFreeText(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L10;
        if ((r101.nextElement() instanceof DERUTF8String) == true) goto L4;
        throw new IllegalArgumentException("attempt to insert non UTF8 STRING into PKIFreeText");
    L10:
        this.strings = r100;
    }

    public PKIFreeText(DERUTF8String r100) {
        this.strings = new DERSequence(r100);
    }

    public PKIFreeText(String[] r100) {
        ASN1EncodableVector r101 = new ASN1EncodableVector(r100.length);
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101.add(new DERUTF8String(r100[r102]));
        r102 = r102 + 1;
        goto L4
    L6:
        this.strings = new DERSequence(r101);
    }

    public PKIFreeText(DERUTF8String[] r100) {
        this.strings = new DERSequence(r100);
    }

    public static PKIFreeText getInstance(Object r100) {
        if ((r100 instanceof PKIFreeText) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PKIFreeText(ASN1Sequence.getInstance(r100));
    L5:
        return (PKIFreeText) r100;
    }

    public static PKIFreeText getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public DERUTF8String getStringAt(int r100) {
        return (DERUTF8String) this.strings.getObjectAt(r100);
    }

    public int size() {
        return this.strings.size();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.strings;
    }
}
