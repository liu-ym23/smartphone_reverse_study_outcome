package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;

/* JADX INFO: loaded from: classes42.dex */
public class EndEntityType extends ASN1Object {

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    public static final int f525347app = 128;
    public static final int enrol = 64;
    private final ASN1BitString type;

    public EndEntityType(int r100) {
        if (r100 != 128) goto L5;
    L9:
        this.type = new DERBitString(r100);
        return;
    L5:
        if (r100 == 64) goto L9;
        throw new IllegalArgumentException("value out of range");
    }

    private EndEntityType(DERBitString r100) {
        this.type = r100;
    }

    public static EndEntityType getInstance(Object r100) {
        if ((r100 instanceof EndEntityType) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EndEntityType(DERBitString.getInstance(r100));
    L5:
        return (EndEntityType) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.type;
    }
}
