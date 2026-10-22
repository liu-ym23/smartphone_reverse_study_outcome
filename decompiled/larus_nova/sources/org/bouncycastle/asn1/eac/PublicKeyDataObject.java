package org.bouncycastle.asn1.eac;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;

/* JADX INFO: loaded from: classes42.dex */
public abstract class PublicKeyDataObject extends ASN1Object {
    public PublicKeyDataObject() {
    }

    public static PublicKeyDataObject getInstance(Object r100) {
        if ((r100 instanceof PublicKeyDataObject) == true) goto L5;
        if (r100 == null) goto L13;
        ASN1Sequence r101 = ASN1Sequence.getInstance(r100);
        if (ASN1ObjectIdentifier.getInstance(r101.getObjectAt(0)).on(EACObjectIdentifiers.id_TA_ECDSA) == false) goto L12;
        return new ECDSAPublicKey(r101);
    L12:
        return new RSAPublicKey(r101);
    L13:
        return null;
    L5:
        return (PublicKeyDataObject) r100;
    }

    public abstract ASN1ObjectIdentifier getUsage();
}
