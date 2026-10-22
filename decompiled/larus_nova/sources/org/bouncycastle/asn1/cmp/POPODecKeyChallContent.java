package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

/* JADX INFO: loaded from: classes42.dex */
public class POPODecKeyChallContent extends ASN1Object {
    private ASN1Sequence content;

    private POPODecKeyChallContent(ASN1Sequence r100) {
        this.content = r100;
    }

    public static POPODecKeyChallContent getInstance(Object r100) {
        if ((r100 instanceof POPODecKeyChallContent) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new POPODecKeyChallContent(ASN1Sequence.getInstance(r100));
    L5:
        return (POPODecKeyChallContent) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }

    public Challenge[] toChallengeArray() {
        int r100 = this.content.size();
        Challenge[] r101 = new Challenge[r100];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = Challenge.getInstance(this.content.getObjectAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }
}
