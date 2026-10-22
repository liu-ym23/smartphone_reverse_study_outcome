package org.bouncycastle.asn1.x500.style;

import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;

/* JADX INFO: loaded from: classes42.dex */
public class BCStrictStyle extends BCStyle {
    public static final X500NameStyle INSTANCE = null;

    static {
        INSTANCE = new BCStrictStyle();
    }

    public BCStrictStyle() {
    }

    @Override // org.bouncycastle.asn1.x500.style.AbstractX500NameStyle, org.bouncycastle.asn1.x500.X500NameStyle
    public boolean areEqual(X500Name r100, X500Name r101) {
        RDN[] r102 = r100.getRDNs();
        RDN[] r103 = r101.getRDNs();
        if (r102.length == r103.length) goto L5;
        return false;
    L5:
        int r104 = 0;
    L7:
        if (r104 == r102.length) goto L12;
        if (rdnAreEqual(r102[r104], r103[r104]) == false) goto L10;
        r104 = r104 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }
}
