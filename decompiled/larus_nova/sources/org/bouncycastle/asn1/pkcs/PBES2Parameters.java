package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PBES2Parameters extends ASN1Object implements PKCSObjectIdentifiers {
    private KeyDerivationFunc func;
    private EncryptionScheme scheme;

    private PBES2Parameters(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        ASN1Sequence r102 = ASN1Sequence.getInstance(((ASN1Encodable) r101.nextElement()).toASN1Primitive());
        ASN1Encodable r103 = r102.getObjectAt(0);
        ASN1ObjectIdentifier r104 = PKCSObjectIdentifiers.id_PBKDF2;
        if (r103.equals(r104) == false) goto L5;
        this.func = new KeyDerivationFunc(r104, PBKDF2Params.getInstance(r102.getObjectAt(1)));
    L6:
        this.scheme = EncryptionScheme.getInstance(r101.nextElement());
        return;
    L5:
        this.func = KeyDerivationFunc.getInstance(r102);
        goto L6
    }

    public PBES2Parameters(KeyDerivationFunc r100, EncryptionScheme r101) {
        this.func = r100;
        this.scheme = r101;
    }

    public static PBES2Parameters getInstance(Object r100) {
        if ((r100 instanceof PBES2Parameters) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PBES2Parameters(ASN1Sequence.getInstance(r100));
    L5:
        return (PBES2Parameters) r100;
    }

    public EncryptionScheme getEncryptionScheme() {
        return this.scheme;
    }

    public KeyDerivationFunc getKeyDerivationFunc() {
        return this.func;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.func);
        r100.add(this.scheme);
        return new DERSequence(r100);
    }
}
