package org.bouncycastle.asn1.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class PKIStatus extends ASN1Object {
    public static final int GRANTED = 0;
    public static final int GRANTED_WITH_MODS = 1;
    public static final int KEY_UPDATE_WARNING = 6;
    public static final int REJECTION = 2;
    public static final int REVOCATION_NOTIFICATION = 5;
    public static final int REVOCATION_WARNING = 4;
    public static final int WAITING = 3;
    public static final PKIStatus granted = null;
    public static final PKIStatus grantedWithMods = null;
    public static final PKIStatus keyUpdateWaiting = null;
    public static final PKIStatus rejection = null;
    public static final PKIStatus revocationNotification = null;
    public static final PKIStatus revocationWarning = null;
    public static final PKIStatus waiting = null;
    private ASN1Integer value;

    static {
        granted = new PKIStatus(0);
        grantedWithMods = new PKIStatus(1);
        rejection = new PKIStatus(2);
        waiting = new PKIStatus(3);
        revocationWarning = new PKIStatus(4);
        revocationNotification = new PKIStatus(5);
        keyUpdateWaiting = new PKIStatus(6);
    }

    private PKIStatus(int r100) {
        this(new ASN1Integer(r100));
    }

    private PKIStatus(ASN1Integer r100) {
        this.value = r100;
    }

    public static PKIStatus getInstance(Object r100) {
        if ((r100 instanceof PKIStatus) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PKIStatus(ASN1Integer.getInstance(r100));
    L5:
        return (PKIStatus) r100;
    }

    public BigInteger getValue() {
        return this.value.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }
}
