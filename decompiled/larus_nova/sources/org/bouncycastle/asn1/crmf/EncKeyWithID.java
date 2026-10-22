package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: loaded from: classes42.dex */
public class EncKeyWithID extends ASN1Object {
    private final ASN1Encodable identifier;
    private final PrivateKeyInfo privKeyInfo;

    private EncKeyWithID(ASN1Sequence r100) {
        this.privKeyInfo = PrivateKeyInfo.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L7;
        boolean r101 = r100.getObjectAt(1) instanceof DERUTF8String;
        ASN1Encodable r102 = r100.getObjectAt(1);
        if (r101 == true) goto L8;
        r102 = GeneralName.getInstance(r102);
    L8:
        this.identifier = r102;
        return;
    L7:
        r102 = null;
        goto L8
    }

    public EncKeyWithID(PrivateKeyInfo r100) {
        this.privKeyInfo = r100;
        this.identifier = null;
    }

    public EncKeyWithID(PrivateKeyInfo r100, DERUTF8String r101) {
        this.privKeyInfo = r100;
        this.identifier = r101;
    }

    public EncKeyWithID(PrivateKeyInfo r100, GeneralName r101) {
        this.privKeyInfo = r100;
        this.identifier = r101;
    }

    public static EncKeyWithID getInstance(Object r100) {
        if ((r100 instanceof EncKeyWithID) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EncKeyWithID(ASN1Sequence.getInstance(r100));
    L5:
        return (EncKeyWithID) r100;
    }

    public ASN1Encodable getIdentifier() {
        return this.identifier;
    }

    public PrivateKeyInfo getPrivateKey() {
        return this.privKeyInfo;
    }

    public boolean hasIdentifier() {
        if (this.identifier == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isIdentifierUTF8String() {
        return this.identifier instanceof DERUTF8String;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.privKeyInfo);
        ASN1Encodable r101 = this.identifier;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
