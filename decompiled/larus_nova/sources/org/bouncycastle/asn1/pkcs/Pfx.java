package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.BERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class Pfx extends ASN1Object implements PKCSObjectIdentifiers {
    private ContentInfo contentInfo;
    private MacData macData;

    private Pfx(ASN1Sequence r100) {
        this.macData = null;
        if (ASN1Integer.getInstance(r100.getObjectAt(0)).intValueExact() != 3) goto L9;
        this.contentInfo = ContentInfo.getInstance(r100.getObjectAt(1));
        if (r100.size() != 3) goto L10;
        this.macData = MacData.getInstance(r100.getObjectAt(2));
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("wrong version for PFX PDU");
    }

    public Pfx(ContentInfo r100, MacData r101) {
        this.contentInfo = r100;
        this.macData = r101;
    }

    public static Pfx getInstance(Object r100) {
        if ((r100 instanceof Pfx) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Pfx(ASN1Sequence.getInstance(r100));
    L5:
        return (Pfx) r100;
    }

    public ContentInfo getAuthSafe() {
        return this.contentInfo;
    }

    public MacData getMacData() {
        return this.macData;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(new ASN1Integer(3));
        r100.add(this.contentInfo);
        MacData r101 = this.macData;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new BERSequence(r100);
    }
}
