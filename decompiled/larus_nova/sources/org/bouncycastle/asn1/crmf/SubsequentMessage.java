package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Integer;

/* JADX INFO: loaded from: classes42.dex */
public class SubsequentMessage extends ASN1Integer {
    public static final SubsequentMessage challengeResp = null;
    public static final SubsequentMessage encrCert = null;

    static {
        encrCert = new SubsequentMessage(0);
        challengeResp = new SubsequentMessage(1);
    }

    private SubsequentMessage(int r100) {
        super(r100);
    }

    public static SubsequentMessage valueOf(int r100) {
        if (r100 != 0) goto L6;
        return encrCert;
    L6:
        if (r100 != 1) goto L10;
        return challengeResp;
    L10:
        throw new IllegalArgumentException("unknown value: " + r100);
    }
}
