package org.bouncycastle.its.asn1;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

/* JADX INFO: loaded from: classes42.dex */
public class PsidGroupPermissions extends ASN1Object {
    private final BigInteger chainLengthRange;
    private final Object eeType;
    private final BigInteger minChainLength;
    private final SubjectPermissions subjectPermissions;

    private PsidGroupPermissions(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.subjectPermissions = SubjectPermissions.getInstance(r100.getObjectAt(0));
        this.minChainLength = ASN1Integer.getInstance(r100.getObjectAt(1)).getValue();
        this.chainLengthRange = ASN1Integer.getInstance(r100.getObjectAt(2)).getValue();
        this.eeType = EndEntityType.getInstance(r100.getObjectAt(3));
        return;
    L7:
        throw new IllegalArgumentException("sequence not length 2");
    }

    public static PsidGroupPermissions getInstance(Object r100) {
        if ((r100 instanceof PsidGroupPermissions) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PsidGroupPermissions(ASN1Sequence.getInstance(r100));
    L5:
        return (PsidGroupPermissions) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return null;
    }
}
