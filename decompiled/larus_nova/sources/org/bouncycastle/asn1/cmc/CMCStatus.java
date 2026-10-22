package org.bouncycastle.asn1.cmc;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class CMCStatus extends ASN1Object {
    public static final CMCStatus confirmRequired = null;
    public static final CMCStatus failed = null;
    public static final CMCStatus noSupport = null;
    public static final CMCStatus partial = null;
    public static final CMCStatus pending = null;
    public static final CMCStatus popRequired = null;
    private static Map range;
    public static final CMCStatus success = null;
    private final ASN1Integer value;

    static {
        CMCStatus r100 = new CMCStatus(new ASN1Integer(0));
        success = r100;
        CMCStatus r101 = new CMCStatus(new ASN1Integer(2));
        failed = r101;
        CMCStatus r102 = new CMCStatus(new ASN1Integer(3));
        pending = r102;
        CMCStatus r103 = new CMCStatus(new ASN1Integer(4));
        noSupport = r103;
        CMCStatus r104 = new CMCStatus(new ASN1Integer(5));
        confirmRequired = r104;
        CMCStatus r105 = new CMCStatus(new ASN1Integer(6));
        popRequired = r105;
        CMCStatus r106 = new CMCStatus(new ASN1Integer(7));
        partial = r106;
        HashMap r107 = new HashMap();
        range = r107;
        r107.put(r100.value, r100);
        range.put(r101.value, r101);
        range.put(r102.value, r102);
        range.put(r103.value, r103);
        range.put(r104.value, r104);
        range.put(r105.value, r105);
        range.put(r106.value, r106);
    }

    private CMCStatus(ASN1Integer r100) {
        this.value = r100;
    }

    public static CMCStatus getInstance(Object r100) {
        if ((r100 instanceof CMCStatus) == true) goto L5;
        if (r100 == null) goto L12;
        CMCStatus r101 = (CMCStatus) range.get(ASN1Integer.getInstance(r100));
        if (r101 == null) goto L11;
        return r101;
    L11:
        throw new IllegalArgumentException("unknown object in getInstance(): ".concat(r100.getClass().getName()));
    L12:
        return null;
    L5:
        return (CMCStatus) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }
}
