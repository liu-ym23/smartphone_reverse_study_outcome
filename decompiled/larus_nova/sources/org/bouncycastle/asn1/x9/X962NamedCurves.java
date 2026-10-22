package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class X962NamedCurves {
    static X9ECParametersHolder c2pnb163v1;
    static X9ECParametersHolder c2pnb163v2;
    static X9ECParametersHolder c2pnb163v3;
    static X9ECParametersHolder c2pnb176w1;
    static X9ECParametersHolder c2pnb208w1;
    static X9ECParametersHolder c2pnb272w1;
    static X9ECParametersHolder c2pnb304w1;
    static X9ECParametersHolder c2pnb368w1;
    static X9ECParametersHolder c2tnb191v1;
    static X9ECParametersHolder c2tnb191v2;
    static X9ECParametersHolder c2tnb191v3;
    static X9ECParametersHolder c2tnb239v1;
    static X9ECParametersHolder c2tnb239v2;
    static X9ECParametersHolder c2tnb239v3;
    static X9ECParametersHolder c2tnb359v1;
    static X9ECParametersHolder c2tnb431r1;
    static final Hashtable curves = null;
    static final Hashtable names = null;
    static final Hashtable objIds = null;
    static X9ECParametersHolder prime192v1;
    static X9ECParametersHolder prime192v2;
    static X9ECParametersHolder prime192v3;
    static X9ECParametersHolder prime239v1;
    static X9ECParametersHolder prime239v2;
    static X9ECParametersHolder prime239v3;
    static X9ECParametersHolder prime256v1;

    static {
        prime192v1 = new AnonymousClass1();
        prime192v2 = new AnonymousClass2();
        prime192v3 = new AnonymousClass3();
        prime239v1 = new AnonymousClass4();
        prime239v2 = new AnonymousClass5();
        prime239v3 = new AnonymousClass6();
        prime256v1 = new AnonymousClass7();
        c2pnb163v1 = new AnonymousClass8();
        c2pnb163v2 = new AnonymousClass9();
        c2pnb163v3 = new AnonymousClass10();
        c2pnb176w1 = new AnonymousClass11();
        c2tnb191v1 = new AnonymousClass12();
        c2tnb191v2 = new AnonymousClass13();
        c2tnb191v3 = new AnonymousClass14();
        c2pnb208w1 = new AnonymousClass15();
        c2tnb239v1 = new AnonymousClass16();
        c2tnb239v2 = new AnonymousClass17();
        c2tnb239v3 = new AnonymousClass18();
        c2pnb272w1 = new AnonymousClass19();
        c2pnb304w1 = new AnonymousClass20();
        c2tnb359v1 = new AnonymousClass21();
        c2pnb368w1 = new AnonymousClass22();
        c2tnb431r1 = new AnonymousClass23();
        objIds = new Hashtable();
        curves = new Hashtable();
        names = new Hashtable();
        defineCurve("prime192v1", X9ObjectIdentifiers.prime192v1, prime192v1);
        defineCurve("prime192v2", X9ObjectIdentifiers.prime192v2, prime192v2);
        defineCurve("prime192v3", X9ObjectIdentifiers.prime192v3, prime192v3);
        defineCurve("prime239v1", X9ObjectIdentifiers.prime239v1, prime239v1);
        defineCurve("prime239v2", X9ObjectIdentifiers.prime239v2, prime239v2);
        defineCurve("prime239v3", X9ObjectIdentifiers.prime239v3, prime239v3);
        defineCurve("prime256v1", X9ObjectIdentifiers.prime256v1, prime256v1);
        defineCurve("c2pnb163v1", X9ObjectIdentifiers.c2pnb163v1, c2pnb163v1);
        defineCurve("c2pnb163v2", X9ObjectIdentifiers.c2pnb163v2, c2pnb163v2);
        defineCurve("c2pnb163v3", X9ObjectIdentifiers.c2pnb163v3, c2pnb163v3);
        defineCurve("c2pnb176w1", X9ObjectIdentifiers.c2pnb176w1, c2pnb176w1);
        defineCurve("c2tnb191v1", X9ObjectIdentifiers.c2tnb191v1, c2tnb191v1);
        defineCurve("c2tnb191v2", X9ObjectIdentifiers.c2tnb191v2, c2tnb191v2);
        defineCurve("c2tnb191v3", X9ObjectIdentifiers.c2tnb191v3, c2tnb191v3);
        defineCurve("c2pnb208w1", X9ObjectIdentifiers.c2pnb208w1, c2pnb208w1);
        defineCurve("c2tnb239v1", X9ObjectIdentifiers.c2tnb239v1, c2tnb239v1);
        defineCurve("c2tnb239v2", X9ObjectIdentifiers.c2tnb239v2, c2tnb239v2);
        defineCurve("c2tnb239v3", X9ObjectIdentifiers.c2tnb239v3, c2tnb239v3);
        defineCurve("c2pnb272w1", X9ObjectIdentifiers.c2pnb272w1, c2pnb272w1);
        defineCurve("c2pnb304w1", X9ObjectIdentifiers.c2pnb304w1, c2pnb304w1);
        defineCurve("c2tnb359v1", X9ObjectIdentifiers.c2tnb359v1, c2tnb359v1);
        defineCurve("c2pnb368w1", X9ObjectIdentifiers.c2pnb368w1, c2pnb368w1);
        defineCurve("c2tnb431r1", X9ObjectIdentifiers.c2tnb431r1, c2tnb431r1);
    }

    public X962NamedCurves() {
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
        objIds.put(r100, r101);
        names.put(r101, r100);
        curves.put(r101, r102);
    }

    private static BigInteger fromHex(String r100) {
        return new BigInteger(1, Hex.decodeStrict(r100));
    }

    public static X9ECParameters getByName(String r100) {
        ASN1ObjectIdentifier r101 = (ASN1ObjectIdentifier) objIds.get(Strings.toLowerCase(r100));
        if (r101 != null) goto L5;
        return null;
    L5:
        return getByOID(r101);
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier r100) {
        X9ECParametersHolder r101 = (X9ECParametersHolder) curves.get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getParameters();
    }

    public static String getName(ASN1ObjectIdentifier r100) {
        return (String) names.get(r100);
    }

    public static Enumeration getNames() {
        return objIds.keys();
    }

    public static ASN1ObjectIdentifier getOID(String r100) {
        return (ASN1ObjectIdentifier) objIds.get(Strings.toLowerCase(r100));
    }
}
