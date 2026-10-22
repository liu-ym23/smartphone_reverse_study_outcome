package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.DERBitString;

/* JADX INFO: loaded from: classes42.dex */
public class ReasonFlags extends DERBitString {
    public static final int AA_COMPROMISE = 32768;
    public static final int AFFILIATION_CHANGED = 16;
    public static final int CA_COMPROMISE = 32;
    public static final int CERTIFICATE_HOLD = 2;
    public static final int CESSATION_OF_OPERATION = 4;
    public static final int KEY_COMPROMISE = 64;
    public static final int PRIVILEGE_WITHDRAWN = 1;
    public static final int SUPERSEDED = 8;
    public static final int UNUSED = 128;
    public static final int aACompromise = 32768;
    public static final int affiliationChanged = 16;
    public static final int cACompromise = 32;
    public static final int certificateHold = 2;
    public static final int cessationOfOperation = 4;
    public static final int keyCompromise = 64;
    public static final int privilegeWithdrawn = 1;
    public static final int superseded = 8;
    public static final int unused = 128;

    public ReasonFlags(int r100) {
        super(ASN1BitString.getBytes(r100), ASN1BitString.getPadBits(r100));
    }

    public ReasonFlags(DERBitString r100) {
        super(r100.getBytes(), r100.getPadBits());
    }
}
