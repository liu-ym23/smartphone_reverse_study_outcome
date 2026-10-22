package org.bouncycastle.asn1.isismtt.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x500.DirectoryString;

/* JADX INFO: loaded from: classes42.dex */
public class Restriction extends ASN1Object {
    private DirectoryString restriction;

    public Restriction(String r100) {
        this.restriction = new DirectoryString(r100);
    }

    private Restriction(DirectoryString r100) {
        this.restriction = r100;
    }

    public static Restriction getInstance(Object r100) {
        if ((r100 instanceof Restriction) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Restriction(DirectoryString.getInstance(r100));
    L5:
        return (Restriction) r100;
    }

    public DirectoryString getRestriction() {
        return this.restriction;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.restriction.toASN1Primitive();
    }
}
