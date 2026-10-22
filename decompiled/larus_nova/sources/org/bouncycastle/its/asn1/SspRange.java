package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;

/* JADX INFO: loaded from: classes42.dex */
public class SspRange extends ASN1Object {
    private final BitmapSspRange bitmapSspRange;
    private final boolean isAll;
    private final SequenceOfOctetString opaque;

    private SspRange() {
        this.isAll = true;
        this.opaque = null;
        this.bitmapSspRange = null;
    }

    public SspRange(BitmapSspRange r100) {
        this.isAll = false;
        this.bitmapSspRange = r100;
        this.opaque = null;
    }

    private SspRange(SequenceOfOctetString r100) {
        this.isAll = false;
        BitmapSspRange r101 = null;
        if (r100.size() == 2) goto L6;
        this.opaque = r100;
    L5:
        this.bitmapSspRange = r101;
        return;
    L6:
        this.opaque = SequenceOfOctetString.getInstance(r100);
        r101 = BitmapSspRange.getInstance(r100);     // Catch: IllegalArgumentException -> L10
        goto L5
    }

    public static SspRange getInstance(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof SspRange) == false) goto L10;
        return (SspRange) r100;
    L10:
        if ((r100 instanceof ASN1Null) == false) goto L14;
        return new SspRange();
    L14:
        if ((r100 instanceof ASN1Sequence) == false) goto L18;
        return new SspRange(SequenceOfOctetString.getInstance(r100));
    L18:
        if ((r100 instanceof byte[]) == false) goto L24;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L22:
        throw new IllegalArgumentException("unable to parse encoded general name");
    L24:
        throw new IllegalArgumentException("unknown object in getInstance: ".concat(r100.getClass().getName()));
    }

    public BitmapSspRange getBitmapSspRange() {
        return this.bitmapSspRange;
    }

    public SequenceOfOctetString getOpaque() {
        return this.opaque;
    }

    public boolean isAll() {
        return this.isAll;
    }

    public boolean maybeOpaque() {
        if (this.opaque == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.isAll == true) goto L5;
        BitmapSspRange r100 = this.bitmapSspRange;
        if (r100 == null) goto L11;
        return r100.toASN1Primitive();
    L11:
        return this.opaque.toASN1Primitive();
    L5:
        return DERNull.INSTANCE;
    }
}
