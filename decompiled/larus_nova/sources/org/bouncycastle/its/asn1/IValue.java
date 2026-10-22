package org.bouncycastle.its.asn1;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class IValue extends ASN1Object {
    private final BigInteger value;

    private IValue(ASN1Integer r100) {
        int r101 = BigIntegers.intValueExact(r100.getValue());
        if (r101 < 0) goto L9;
        if (r101 > 65535) goto L9;
        this.value = r100.getValue();
        return;
    L9:
        throw new IllegalArgumentException("value out of range");
    }

    public static IValue getInstance(Object r100) {
        if ((r100 instanceof IValue) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new IValue(ASN1Integer.getInstance(r100));
    L5:
        return (IValue) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.value);
    }
}
