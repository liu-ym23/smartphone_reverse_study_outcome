package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410PublicKeyAlgParameters extends ASN1Object {
    private ASN1ObjectIdentifier digestParamSet;
    private ASN1ObjectIdentifier encryptionParamSet;
    private ASN1ObjectIdentifier publicKeyParamSet;

    public GOST3410PublicKeyAlgParameters(ASN1ObjectIdentifier r100, ASN1ObjectIdentifier r101) {
        this.publicKeyParamSet = r100;
        this.digestParamSet = r101;
        this.encryptionParamSet = null;
    }

    public GOST3410PublicKeyAlgParameters(ASN1ObjectIdentifier r100, ASN1ObjectIdentifier r101, ASN1ObjectIdentifier r102) {
        this.publicKeyParamSet = r100;
        this.digestParamSet = r101;
        this.encryptionParamSet = r102;
    }

    private GOST3410PublicKeyAlgParameters(ASN1Sequence r100) {
        this.publicKeyParamSet = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        this.digestParamSet = (ASN1ObjectIdentifier) r100.getObjectAt(1);
        if (r100.size() <= 2) goto L6;
        this.encryptionParamSet = (ASN1ObjectIdentifier) r100.getObjectAt(2);
        return;
    }

    public static GOST3410PublicKeyAlgParameters getInstance(Object r100) {
        if ((r100 instanceof GOST3410PublicKeyAlgParameters) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GOST3410PublicKeyAlgParameters(ASN1Sequence.getInstance(r100));
    L5:
        return (GOST3410PublicKeyAlgParameters) r100;
    }

    public static GOST3410PublicKeyAlgParameters getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1ObjectIdentifier getDigestParamSet() {
        return this.digestParamSet;
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.encryptionParamSet;
    }

    public ASN1ObjectIdentifier getPublicKeyParamSet() {
        return this.publicKeyParamSet;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.publicKeyParamSet);
        r100.add(this.digestParamSet);
        ASN1ObjectIdentifier r101 = this.encryptionParamSet;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
