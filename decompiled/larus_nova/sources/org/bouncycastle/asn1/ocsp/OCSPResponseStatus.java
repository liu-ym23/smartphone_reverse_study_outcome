package org.bouncycastle.asn1.ocsp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class OCSPResponseStatus extends ASN1Object {
    public static final int INTERNAL_ERROR = 2;
    public static final int MALFORMED_REQUEST = 1;
    public static final int SIG_REQUIRED = 5;
    public static final int SUCCESSFUL = 0;
    public static final int TRY_LATER = 3;
    public static final int UNAUTHORIZED = 6;
    private ASN1Enumerated value;

    public OCSPResponseStatus(int r100) {
        this(new ASN1Enumerated(r100));
    }

    private OCSPResponseStatus(ASN1Enumerated r100) {
        this.value = r100;
    }

    public static OCSPResponseStatus getInstance(Object r100) {
        if ((r100 instanceof OCSPResponseStatus) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OCSPResponseStatus(ASN1Enumerated.getInstance(r100));
    L5:
        return (OCSPResponseStatus) r100;
    }

    public int getIntValue() {
        return this.value.intValueExact();
    }

    public BigInteger getValue() {
        return this.value.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }
}
