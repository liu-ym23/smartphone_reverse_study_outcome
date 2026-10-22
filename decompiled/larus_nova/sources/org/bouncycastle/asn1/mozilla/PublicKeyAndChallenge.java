package org.bouncycastle.asn1.mozilla;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

/* JADX INFO: loaded from: classes42.dex */
public class PublicKeyAndChallenge extends ASN1Object {
    private DERIA5String challenge;
    private ASN1Sequence pkacSeq;
    private SubjectPublicKeyInfo spki;

    private PublicKeyAndChallenge(ASN1Sequence r100) {
        this.pkacSeq = r100;
        this.spki = SubjectPublicKeyInfo.getInstance(r100.getObjectAt(0));
        this.challenge = DERIA5String.getInstance(r100.getObjectAt(1));
    }

    public static PublicKeyAndChallenge getInstance(Object r100) {
        if ((r100 instanceof PublicKeyAndChallenge) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PublicKeyAndChallenge(ASN1Sequence.getInstance(r100));
    L5:
        return (PublicKeyAndChallenge) r100;
    }

    public DERIA5String getChallenge() {
        return this.challenge;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.spki;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.pkacSeq;
    }
}
