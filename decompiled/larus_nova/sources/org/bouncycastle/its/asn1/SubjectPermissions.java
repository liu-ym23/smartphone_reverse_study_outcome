package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class SubjectPermissions extends ASN1Object implements ASN1Choice {
    public SubjectPermissions() {
    }

    public static SubjectPermissions getInstance(Object r100) {
        if ((r100 instanceof SubjectPermissions) == true) goto L5;
        return null;
    L5:
        return (SubjectPermissions) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return null;
    }
}
