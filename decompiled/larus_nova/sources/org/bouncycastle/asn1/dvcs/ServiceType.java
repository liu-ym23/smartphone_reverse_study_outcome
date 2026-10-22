package org.bouncycastle.asn1.dvcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class ServiceType extends ASN1Object {
    public static final ServiceType CCPD = null;
    public static final ServiceType CPD = null;
    public static final ServiceType VPKC = null;
    public static final ServiceType VSD = null;
    private ASN1Enumerated value;

    static {
        CPD = new ServiceType(1);
        VSD = new ServiceType(2);
        VPKC = new ServiceType(3);
        CCPD = new ServiceType(4);
    }

    public ServiceType(int r100) {
        this.value = new ASN1Enumerated(r100);
    }

    private ServiceType(ASN1Enumerated r100) {
        this.value = r100;
    }

    public static ServiceType getInstance(Object r100) {
        if ((r100 instanceof ServiceType) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ServiceType(ASN1Enumerated.getInstance(r100));
    L5:
        return (ServiceType) r100;
    }

    public static ServiceType getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Enumerated.getInstance(r100, r101));
    }

    public BigInteger getValue() {
        return this.value.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }

    public String toString() {
        int r100 = this.value.intValueExact();
        StringBuilder r101 = new StringBuilder("");
        r101.append(r100);
        if (r100 != CPD.value.intValueExact()) goto L6;
        String r102 = "(CPD)";
    L15:
        r101.append(r102);
        return r101.toString();
    L6:
        if (r100 != VSD.value.intValueExact()) goto L9;
        r102 = "(VSD)";
        goto L15
    L9:
        if (r100 != VPKC.value.intValueExact()) goto L12;
        r102 = "(VPKC)";
        goto L15
    L12:
        if (r100 != CCPD.value.intValueExact()) goto L14;
        r102 = "(CCPD)";
        goto L15
    L14:
        r102 = "?";
        goto L15
    }
}
