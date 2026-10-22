package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DLSequence;

/* JADX INFO: loaded from: classes42.dex */
public class AuthenticatedSafe extends ASN1Object {
    private ContentInfo[] info;
    private boolean isBer;

    private AuthenticatedSafe(ASN1Sequence r100) {
        this.isBer = true;
        this.info = new ContentInfo[r100.size()];
        int r101 = 0;
    L3:
        ContentInfo[] r102 = this.info;
        if (r101 == r102.length) goto L6;
        r102[r101] = ContentInfo.getInstance(r100.getObjectAt(r101));
        r101 = r101 + 1;
        goto L3
    L6:
        this.isBer = r100 instanceof BERSequence;
    }

    public AuthenticatedSafe(ContentInfo[] r100) {
        this.isBer = true;
        this.info = copy(r100);
    }

    private ContentInfo[] copy(ContentInfo[] r100) {
        int r101 = r100.length;
        ContentInfo[] r102 = new ContentInfo[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    public static AuthenticatedSafe getInstance(Object r100) {
        if ((r100 instanceof AuthenticatedSafe) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new AuthenticatedSafe(ASN1Sequence.getInstance(r100));
    L5:
        return (AuthenticatedSafe) r100;
    }

    public ContentInfo[] getContentInfo() {
        return copy(this.info);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.isBer == false) goto L7;
        return new BERSequence(this.info);
    L7:
        return new DLSequence(this.info);
    }
}
