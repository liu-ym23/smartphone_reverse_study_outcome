package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class CertPolicyId extends ASN1Object {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private ASN1ObjectIdentifier f525079id;

    private CertPolicyId(ASN1ObjectIdentifier r100) {
        this.f525079id = r100;
    }

    public static CertPolicyId getInstance(Object r100) {
        if ((r100 instanceof CertPolicyId) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertPolicyId(ASN1ObjectIdentifier.getInstance(r100));
    L5:
        return (CertPolicyId) r100;
    }

    public String getId() {
        return this.f525079id.getId();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f525079id;
    }
}
