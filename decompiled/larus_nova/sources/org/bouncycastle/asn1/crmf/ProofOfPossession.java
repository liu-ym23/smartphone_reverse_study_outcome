package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class ProofOfPossession extends ASN1Object implements ASN1Choice {
    public static final int TYPE_KEY_AGREEMENT = 3;
    public static final int TYPE_KEY_ENCIPHERMENT = 2;
    public static final int TYPE_RA_VERIFIED = 0;
    public static final int TYPE_SIGNING_KEY = 1;
    private ASN1Encodable obj;
    private int tagNo;

    public ProofOfPossession() {
        this.tagNo = 0;
        this.obj = DERNull.INSTANCE;
    }

    public ProofOfPossession(int r100, POPOPrivKey r101) {
        this.tagNo = r100;
        this.obj = r101;
    }

    private ProofOfPossession(ASN1TaggedObject r100) {
        int r101 = r100.getTagNo();
        this.tagNo = r101;
        if (r101 != 0) goto L5;
        ASN1Encodable r102 = DERNull.INSTANCE;
    L16:
        this.obj = r102;
        return;
    L5:
        if (r101 != 1) goto L7;
        r102 = POPOSigningKey.getInstance(r100, false);
        goto L16
    L7:
        if (r101 != 2) goto L9;
    L13:
        r102 = POPOPrivKey.getInstance(r100, true);
        goto L16
    L9:
        if (r101 == 3) goto L13;
        throw new IllegalArgumentException("unknown tag: " + this.tagNo);
    }

    public ProofOfPossession(POPOSigningKey r100) {
        this.tagNo = 1;
        this.obj = r100;
    }

    public static ProofOfPossession getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof ProofOfPossession) == true) goto L13;
        if ((r100 instanceof ASN1TaggedObject) == false) goto L11;
        return new ProofOfPossession((ASN1TaggedObject) r100);
    L11:
        throw new IllegalArgumentException("Invalid object: ".concat(r100.getClass().getName()));
    L13:
        return (ProofOfPossession) r100;
    }

    public ASN1Encodable getObject() {
        return this.obj;
    }

    public int getType() {
        return this.tagNo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, this.obj);
    }
}
