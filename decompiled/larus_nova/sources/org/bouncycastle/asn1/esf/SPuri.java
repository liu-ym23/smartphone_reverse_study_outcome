package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERIA5String;

/* JADX INFO: loaded from: classes42.dex */
public class SPuri {
    private DERIA5String uri;

    public SPuri(DERIA5String r100) {
        this.uri = r100;
    }

    public static SPuri getInstance(Object r100) {
        if ((r100 instanceof SPuri) == false) goto L7;
        return (SPuri) r100;
    L7:
        if ((r100 instanceof DERIA5String) == true) goto L9;
        return null;
    L9:
        return new SPuri(DERIA5String.getInstance(r100));
    }

    public DERIA5String getUri() {
        return this.uri;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.uri.toASN1Primitive();
    }
}
