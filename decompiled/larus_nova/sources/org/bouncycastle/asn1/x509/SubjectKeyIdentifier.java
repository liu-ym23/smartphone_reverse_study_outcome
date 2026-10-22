package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class SubjectKeyIdentifier extends ASN1Object {
    private byte[] keyidentifier;

    public SubjectKeyIdentifier(ASN1OctetString r100) {
        this(r100.getOctets());
    }

    public SubjectKeyIdentifier(byte[] r100) {
        this.keyidentifier = Arrays.clone(r100);
    }

    public static SubjectKeyIdentifier fromExtensions(Extensions r100) {
        return getInstance(Extensions.getExtensionParsedValue(r100, Extension.subjectKeyIdentifier));
    }

    public static SubjectKeyIdentifier getInstance(Object r100) {
        if ((r100 instanceof SubjectKeyIdentifier) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SubjectKeyIdentifier(ASN1OctetString.getInstance(r100));
    L5:
        return (SubjectKeyIdentifier) r100;
    }

    public static SubjectKeyIdentifier getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1OctetString.getInstance(r100, r101));
    }

    public byte[] getKeyIdentifier() {
        return Arrays.clone(this.keyidentifier);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(getKeyIdentifier());
    }
}
