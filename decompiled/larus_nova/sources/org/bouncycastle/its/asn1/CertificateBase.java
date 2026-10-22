package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CertificateBase extends ASN1Object {
    private CertificateType type;
    private byte[] version;

    public CertificateBase(ASN1Sequence r100) {
    }

    public static CertificateBase getInstance(Object r100) {
        if ((r100 instanceof ImplicitCertificate) == false) goto L7;
        return (ImplicitCertificate) r100;
    L7:
        if ((r100 instanceof ExplicitCertificate) == true) goto L9;
        if (r100 == null) goto L21;
        ASN1Sequence r101 = ASN1Sequence.getInstance(r100);
        if (r101.getObjectAt(1).equals(CertificateType.Implicit) == false) goto L16;
        return getInstance(r101);
    L16:
        if (r101.getObjectAt(1).equals(CertificateType.Explicit) == false) goto L20;
        return getInstance(r101);
    L20:
        throw new IllegalArgumentException("unknown certificate type");
    L21:
        return null;
    L9:
        return (ExplicitCertificate) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1EncodableVector());
    }
}
