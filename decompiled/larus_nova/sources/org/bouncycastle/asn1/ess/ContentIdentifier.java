package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;

/* JADX INFO: loaded from: classes42.dex */
public class ContentIdentifier extends ASN1Object {
    ASN1OctetString value;

    private ContentIdentifier(ASN1OctetString r100) {
        this.value = r100;
    }

    public ContentIdentifier(byte[] r100) {
        this(new DEROctetString(r100));
    }

    public static ContentIdentifier getInstance(Object r100) {
        if ((r100 instanceof ContentIdentifier) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ContentIdentifier(ASN1OctetString.getInstance(r100));
    L5:
        return (ContentIdentifier) r100;
    }

    public ASN1OctetString getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }
}
