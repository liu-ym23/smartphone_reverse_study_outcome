package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

/* JADX INFO: loaded from: classes42.dex */
public class POPOSigningKeyInput extends ASN1Object {
    private SubjectPublicKeyInfo publicKey;
    private PKMACValue publicKeyMAC;
    private GeneralName sender;

    private POPOSigningKeyInput(ASN1Sequence r100) {
        ASN1Encodable r101 = r100.getObjectAt(0);
        if ((r101 instanceof ASN1TaggedObject) == false) goto L9;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r101;
        if (r102.getTagNo() != 0) goto L8;
        this.sender = GeneralName.getInstance(r102.getObject());
    L10:
        this.publicKey = SubjectPublicKeyInfo.getInstance(r100.getObjectAt(1));
        return;
    L8:
        throw new IllegalArgumentException("Unknown authInfo tag: " + r102.getTagNo());
    L9:
        this.publicKeyMAC = PKMACValue.getInstance(r101);
        goto L10
    }

    public POPOSigningKeyInput(PKMACValue r100, SubjectPublicKeyInfo r101) {
        this.publicKeyMAC = r100;
        this.publicKey = r101;
    }

    public POPOSigningKeyInput(GeneralName r100, SubjectPublicKeyInfo r101) {
        this.sender = r100;
        this.publicKey = r101;
    }

    public static POPOSigningKeyInput getInstance(Object r100) {
        if ((r100 instanceof POPOSigningKeyInput) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new POPOSigningKeyInput(ASN1Sequence.getInstance(r100));
    L5:
        return (POPOSigningKeyInput) r100;
    }

    public SubjectPublicKeyInfo getPublicKey() {
        return this.publicKey;
    }

    public PKMACValue getPublicKeyMAC() {
        return this.publicKeyMAC;
    }

    public GeneralName getSender() {
        return this.sender;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        GeneralName r101 = this.sender;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, r101));
    L6:
        r100.add(this.publicKey);
        return new DERSequence(r100);
    L5:
        r100.add(this.publicKeyMAC);
        goto L6
    }
}
