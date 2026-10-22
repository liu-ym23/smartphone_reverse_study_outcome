package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class ObjectStoreIntegrityCheck extends ASN1Object implements ASN1Choice {
    public static final int PBKD_MAC_CHECK = 0;
    public static final int SIG_CHECK = 1;
    private final ASN1Object integrityCheck;
    private final int type;

    private ObjectStoreIntegrityCheck(ASN1Encodable r100) {
        if ((r100 instanceof ASN1Sequence) == false) goto L5;
    L12:
        this.type = 0;
        ASN1Object r101 = PbkdMacIntegrityCheck.getInstance(r100);
    L13:
        this.integrityCheck = r101;
        return;
    L5:
        if ((r100 instanceof PbkdMacIntegrityCheck) == true) goto L12;
        if ((r100 instanceof ASN1TaggedObject) == false) goto L11;
        this.type = 1;
        r101 = SignatureCheck.getInstance(((ASN1TaggedObject) r100).getObject());
        goto L13
    L11:
        throw new IllegalArgumentException("Unknown check object in integrity check.");
    }

    public ObjectStoreIntegrityCheck(PbkdMacIntegrityCheck r100) {
        this(r100);
    }

    public ObjectStoreIntegrityCheck(SignatureCheck r100) {
        this(new DERTaggedObject(0, r100));
    }

    public static ObjectStoreIntegrityCheck getInstance(Object r100) {
        if ((r100 instanceof ObjectStoreIntegrityCheck) == false) goto L7;
        return (ObjectStoreIntegrityCheck) r100;
    L7:
        if ((r100 instanceof byte[]) == true) goto L17;
        if (r100 != null) goto L14;
        return null;
    L14:
        return new ObjectStoreIntegrityCheck((ASN1Encodable) r100);
    L17:
        return new ObjectStoreIntegrityCheck(ASN1Primitive.fromByteArray((byte[]) r100));
    L11:
        throw new IllegalArgumentException("Unable to parse integrity check details.");
    }

    public ASN1Object getIntegrityCheck() {
        return this.integrityCheck;
    }

    public int getType() {
        return this.type;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1Object r100 = this.integrityCheck;
        if ((r100 instanceof SignatureCheck) == false) goto L7;
        return new DERTaggedObject(0, r100);
    L7:
        return r100.toASN1Primitive();
    }
}
