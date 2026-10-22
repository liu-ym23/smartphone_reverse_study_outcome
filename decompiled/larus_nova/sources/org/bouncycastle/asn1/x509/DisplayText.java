package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.DERVisibleString;

/* JADX INFO: loaded from: classes42.dex */
public class DisplayText extends ASN1Object implements ASN1Choice {
    public static final int CONTENT_TYPE_BMPSTRING = 1;
    public static final int CONTENT_TYPE_IA5STRING = 0;
    public static final int CONTENT_TYPE_UTF8STRING = 2;
    public static final int CONTENT_TYPE_VISIBLESTRING = 3;
    public static final int DISPLAY_TEXT_MAXIMUM_SIZE = 200;
    int contentType;
    ASN1String contents;

    public DisplayText(int r100, String r101) {
        if (r101.length() <= 200) goto L5;
        r101 = r101.substring(0, 200);
    L5:
        this.contentType = r100;
        if (r100 != 0) goto L8;
        ASN1String r102 = new DERIA5String(r101);
    L18:
        this.contents = r102;
        return;
    L8:
        if (r100 != 1) goto L10;
        r102 = new DERBMPString(r101);
        goto L18
    L10:
        if (r100 != 2) goto L12;
        r102 = new DERUTF8String(r101);
        goto L18
    L12:
        if (r100 == 3) goto L14;
        r102 = new DERUTF8String(r101);
        goto L18
    L14:
        r102 = new DERVisibleString(r101);
        goto L18
    }

    public DisplayText(String r100) {
        if (r100.length() <= 200) goto L5;
        r100 = r100.substring(0, 200);
    L5:
        this.contentType = 2;
        this.contents = new DERUTF8String(r100);
    }

    private DisplayText(ASN1String r100) {
        this.contents = r100;
        if ((r100 instanceof DERUTF8String) == false) goto L7;
        int r101 = 2;
    L5:
        this.contentType = r101;
        return;
    L7:
        if ((r100 instanceof DERBMPString) == false) goto L10;
        r101 = 1;
        goto L5
    L10:
        if ((r100 instanceof DERIA5String) == false) goto L13;
        r101 = 0;
        goto L5
    L13:
        if ((r100 instanceof DERVisibleString) == false) goto L17;
        r101 = 3;
        goto L5
    L17:
        throw new IllegalArgumentException("unknown STRING type in DisplayText");
    }

    public static DisplayText getInstance(Object r100) {
        if ((r100 instanceof ASN1String) == true) goto L5;
        if (r100 == null) goto L13;
        if ((r100 instanceof DisplayText) == true) goto L13;
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L13:
        return (DisplayText) r100;
    L5:
        return new DisplayText((ASN1String) r100);
    }

    public static DisplayText getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(r100.getObject());
    }

    public String getString() {
        return this.contents.getString();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return (ASN1Primitive) this.contents;
    }
}
