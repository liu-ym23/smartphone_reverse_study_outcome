package org.bouncycastle.asn1.anssi;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class ANSSINamedCurves {
    static X9ECParametersHolder FRP256v1;
    static final Hashtable curves = null;
    static final Hashtable names = null;
    static final Hashtable objIds = null;

    static {
        FRP256v1 = new AnonymousClass1();
        objIds = new Hashtable();
        curves = new Hashtable();
        names = new Hashtable();
        defineCurve("FRP256v1", ANSSIObjectIdentifiers.FRP256v1, FRP256v1);
    }

    public ANSSINamedCurves() {
    }

    public static /* synthetic */ BigInteger access$000(String r100) {
        return fromHex(r100);
    }

    public static /* synthetic */ ECCurve access$100(ECCurve r100) {
        return configureCurve(r100);
    }

    public static /* synthetic */ X9ECPoint access$200(ECCurve r100, String r101) {
        return configureBasepoint(r100, r101);
    }

    private static X9ECPoint configureBasepoint(ECCurve r100, String r101) {
        X9ECPoint r102 = new X9ECPoint(r100, Hex.decodeStrict(r101));
        WNafUtil.configureBasepoint(r102.getPoint());
        return r102;
    }

    private static ECCurve configureCurve(ECCurve r100) {
        return r100;
    }

    public static void defineCurve(String r100, ASN1ObjectIdentifier r101, X9ECParametersHolder r102) {
        objIds.put(Strings.toLowerCase(r100), r101);
        names.put(r101, r100);
        curves.put(r101, r102);
    }

    private static BigInteger fromHex(String r100) {
        return new BigInteger(1, Hex.decodeStrict(r100));
    }

    public static X9ECParameters getByName(String r100) {
        ASN1ObjectIdentifier r101 = getOID(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return getByOID(r101);
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier r100) {
        X9ECParametersHolder r101 = (X9ECParametersHolder) curves.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.getParameters();
    }

    public static String getName(ASN1ObjectIdentifier r100) {
        return (String) names.get(r100);
    }

    public static Enumeration getNames() {
        return names.elements();
    }

    public static ASN1ObjectIdentifier getOID(String r100) {
        return (ASN1ObjectIdentifier) objIds.get(Strings.toLowerCase(r100));
    }
}
