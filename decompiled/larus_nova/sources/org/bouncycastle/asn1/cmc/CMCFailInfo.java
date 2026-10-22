package org.bouncycastle.asn1.cmc;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class CMCFailInfo extends ASN1Object {
    public static final CMCFailInfo authDataFail = null;
    public static final CMCFailInfo badAlg = null;
    public static final CMCFailInfo badCertId = null;
    public static final CMCFailInfo badIdentity = null;
    public static final CMCFailInfo badMessageCheck = null;
    public static final CMCFailInfo badRequest = null;
    public static final CMCFailInfo badTime = null;
    public static final CMCFailInfo internalCAError = null;
    public static final CMCFailInfo mustArchiveKeys = null;
    public static final CMCFailInfo noKeyReuse = null;
    public static final CMCFailInfo popFailed = null;
    public static final CMCFailInfo popRequired = null;
    private static Map range;
    public static final CMCFailInfo tryLater = null;
    public static final CMCFailInfo unsupportedExt = null;
    private final ASN1Integer value;

    static {
        CMCFailInfo r100 = new CMCFailInfo(new ASN1Integer(0));
        badAlg = r100;
        CMCFailInfo r101 = new CMCFailInfo(new ASN1Integer(1));
        badMessageCheck = r101;
        CMCFailInfo r102 = new CMCFailInfo(new ASN1Integer(2));
        badRequest = r102;
        CMCFailInfo r103 = new CMCFailInfo(new ASN1Integer(3));
        badTime = r103;
        CMCFailInfo r104 = new CMCFailInfo(new ASN1Integer(4));
        badCertId = r104;
        CMCFailInfo r105 = new CMCFailInfo(new ASN1Integer(5));
        unsupportedExt = r105;
        CMCFailInfo r106 = new CMCFailInfo(new ASN1Integer(6));
        mustArchiveKeys = r106;
        CMCFailInfo r107 = new CMCFailInfo(new ASN1Integer(7));
        badIdentity = r107;
        CMCFailInfo r108 = new CMCFailInfo(new ASN1Integer(8));
        popRequired = r108;
        CMCFailInfo r109 = new CMCFailInfo(new ASN1Integer(9));
        popFailed = r109;
        CMCFailInfo r110 = new CMCFailInfo(new ASN1Integer(10));
        noKeyReuse = r110;
        CMCFailInfo r111 = new CMCFailInfo(new ASN1Integer(11));
        internalCAError = r111;
        CMCFailInfo r112 = new CMCFailInfo(new ASN1Integer(12));
        tryLater = r112;
        CMCFailInfo r113 = new CMCFailInfo(new ASN1Integer(13));
        authDataFail = r113;
        HashMap r114 = new HashMap();
        range = r114;
        r114.put(r100.value, r100);
        range.put(r101.value, r101);
        range.put(r102.value, r102);
        range.put(r103.value, r103);
        range.put(r104.value, r104);
        range.put(r108.value, r108);
        range.put(r105.value, r105);
        range.put(r106.value, r106);
        range.put(r107.value, r107);
        range.put(r108.value, r108);
        range.put(r109.value, r109);
        range.put(r104.value, r104);
        range.put(r108.value, r108);
        range.put(r110.value, r110);
        range.put(r111.value, r111);
        range.put(r112.value, r112);
        range.put(r113.value, r113);
    }

    private CMCFailInfo(ASN1Integer r100) {
        this.value = r100;
    }

    public static CMCFailInfo getInstance(Object r100) {
        if ((r100 instanceof CMCFailInfo) == true) goto L5;
        if (r100 == null) goto L12;
        CMCFailInfo r101 = (CMCFailInfo) range.get(ASN1Integer.getInstance(r100));
        if (r101 == null) goto L11;
        return r101;
    L11:
        throw new IllegalArgumentException("unknown object in getInstance(): ".concat(r100.getClass().getName()));
    L12:
        return null;
    L5:
        return (CMCFailInfo) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }
}
