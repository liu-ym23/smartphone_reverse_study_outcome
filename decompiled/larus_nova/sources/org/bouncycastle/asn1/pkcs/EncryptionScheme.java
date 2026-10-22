package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptionScheme extends ASN1Object {
    private AlgorithmIdentifier algId;

    public EncryptionScheme(ASN1ObjectIdentifier r100) {
        this.algId = new AlgorithmIdentifier(r100);
    }

    public EncryptionScheme(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.algId = new AlgorithmIdentifier(r100, r101);
    }

    private EncryptionScheme(ASN1Sequence r100) {
        this.algId = AlgorithmIdentifier.getInstance(r100);
    }

    public static EncryptionScheme getInstance(Object r100) {
        if ((r100 instanceof EncryptionScheme) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EncryptionScheme(ASN1Sequence.getInstance(r100));
    L5:
        return (EncryptionScheme) r100;
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.algId.getAlgorithm();
    }

    public ASN1Encodable getParameters() {
        return this.algId.getParameters();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.algId.toASN1Primitive();
    }
}
