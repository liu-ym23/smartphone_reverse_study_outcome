package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.Extension;

/* JADX INFO: loaded from: classes42.dex */
public class ExtensionReq extends ASN1Object {
    private final Extension[] extensions;

    private ExtensionReq(ASN1Sequence r100) {
        this.extensions = new Extension[r100.size()];
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L6;
        this.extensions[r101] = Extension.getInstance(r100.getObjectAt(r101));
        r101 = r101 + 1;
        goto L4
    }

    public ExtensionReq(Extension r100) {
        this.extensions = new Extension[]{r100};
    }

    public ExtensionReq(Extension[] r100) {
        this.extensions = Utils.clone(r100);
    }

    public static ExtensionReq getInstance(Object r100) {
        if ((r100 instanceof ExtensionReq) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ExtensionReq(ASN1Sequence.getInstance(r100));
    L5:
        return (ExtensionReq) r100;
    }

    public static ExtensionReq getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public Extension[] getExtensions() {
        return Utils.clone(this.extensions);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.extensions);
    }
}
