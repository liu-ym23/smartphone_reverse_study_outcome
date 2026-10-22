package org.bouncycastle.asn1.tsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class Accuracy extends ASN1Object {
    protected static final int MAX_MICROS = 999;
    protected static final int MAX_MILLIS = 999;
    protected static final int MIN_MICROS = 1;
    protected static final int MIN_MILLIS = 1;
    ASN1Integer micros;
    ASN1Integer millis;
    ASN1Integer seconds;

    public Accuracy() {
    }

    public Accuracy(ASN1Integer r100, ASN1Integer r101, ASN1Integer r102) {
        if (r101 == null) goto L10;
        int r103 = r101.intValueExact();
        if (r103 < 1) goto L9;
        if (r103 <= 999) goto L10;
    L9:
        throw new IllegalArgumentException("Invalid millis field : not in (1..999)");
    L10:
        if (r102 == null) goto L17;
        int r104 = r102.intValueExact();
        if (r104 < 1) goto L16;
        if (r104 <= 999) goto L17;
    L16:
        throw new IllegalArgumentException("Invalid micros field : not in (1..999)");
    L17:
        this.seconds = r100;
        this.millis = r101;
        this.micros = r102;
    }

    private Accuracy(ASN1Sequence r100) {
        this.seconds = null;
        this.millis = null;
        this.micros = null;
        int r101 = 0;
    L4:
        if (r101 >= r100.size()) goto L28;
        if ((r100.getObjectAt(r101) instanceof ASN1Integer) == false) goto L9;
        this.seconds = (ASN1Integer) r100.getObjectAt(r101);
    L27:
        r101 = r101 + 1;
        goto L4
    L9:
        if ((r100.getObjectAt(r101) instanceof ASN1TaggedObject) == false) goto L27;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r100.getObjectAt(r101);
        int r103 = r102.getTagNo();
        if (r103 == 0) goto L21;
        if (r103 != 1) goto L20;
        ASN1Integer r104 = ASN1Integer.getInstance(r102, false);
        this.micros = r104;
        int r105 = r104.intValueExact();
        if (r105 < 1) goto L18;
        if (r105 <= 999) goto L27;
    L18:
        throw new IllegalArgumentException("Invalid micros field : not in (1..999)");
    L20:
        throw new IllegalArgumentException("Invalid tag number");
    L21:
        ASN1Integer r106 = ASN1Integer.getInstance(r102, false);
        this.millis = r106;
        int r107 = r106.intValueExact();
        if (r107 < 1) goto L26;
        if (r107 <= 999) goto L27;
    L26:
        throw new IllegalArgumentException("Invalid millis field : not in (1..999)");
    }

    public static Accuracy getInstance(Object r100) {
        if ((r100 instanceof Accuracy) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Accuracy(ASN1Sequence.getInstance(r100));
    L5:
        return (Accuracy) r100;
    }

    public ASN1Integer getMicros() {
        return this.micros;
    }

    public ASN1Integer getMillis() {
        return this.millis;
    }

    public ASN1Integer getSeconds() {
        return this.seconds;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        ASN1Integer r101 = this.seconds;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        ASN1Integer r102 = this.millis;
        if (r102 == null) goto L8;
        r100.add(new DERTaggedObject(false, 0, r102));
    L8:
        ASN1Integer r103 = this.micros;
        if (r103 == null) goto L12;
        r100.add(new DERTaggedObject(false, 1, r103));
    L12:
        return new DERSequence(r100);
    }
}
