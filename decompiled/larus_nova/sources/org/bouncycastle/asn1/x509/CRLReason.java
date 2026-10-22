package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class CRLReason extends ASN1Object {
    public static final int AA_COMPROMISE = 10;
    public static final int AFFILIATION_CHANGED = 3;
    public static final int CA_COMPROMISE = 2;
    public static final int CERTIFICATE_HOLD = 6;
    public static final int CESSATION_OF_OPERATION = 5;
    public static final int KEY_COMPROMISE = 1;
    public static final int PRIVILEGE_WITHDRAWN = 9;
    public static final int REMOVE_FROM_CRL = 8;
    public static final int SUPERSEDED = 4;
    public static final int UNSPECIFIED = 0;
    public static final int aACompromise = 10;
    public static final int affiliationChanged = 3;
    public static final int cACompromise = 2;
    public static final int certificateHold = 6;
    public static final int cessationOfOperation = 5;
    public static final int keyCompromise = 1;
    public static final int privilegeWithdrawn = 9;
    private static final String[] reasonString = null;
    public static final int removeFromCRL = 8;
    public static final int superseded = 4;
    private static final Hashtable table = null;
    public static final int unspecified = 0;
    private ASN1Enumerated value;

    static {
        reasonString = new String[]{"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};
        table = new Hashtable();
    }

    private CRLReason(int r100) {
        this.value = new ASN1Enumerated(r100);
    }

    public static CRLReason getInstance(Object r100) {
        if ((r100 instanceof CRLReason) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return lookup(ASN1Enumerated.getInstance(r100).intValueExact());
    L5:
        return (CRLReason) r100;
    }

    public static CRLReason lookup(int r100) {
        Integer r101 = Integers.valueOf(r100);
        Hashtable r102 = table;
        if (r102.containsKey(r101) == true) goto L6;
        r102.put(r101, new CRLReason(r100));
    L6:
        return (CRLReason) r102.get(r101);
    }

    public BigInteger getValue() {
        return this.value.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }

    public String toString() {
        int r100 = getValue().intValue();
        if (r100 >= 0) goto L5;
    L8:
        String r101 = "invalid";
    L10:
        return "CRLReason: " + r101;
    L5:
        if (r100 > 10) goto L8;
        r101 = reasonString[r100];
        goto L10
    }
}
