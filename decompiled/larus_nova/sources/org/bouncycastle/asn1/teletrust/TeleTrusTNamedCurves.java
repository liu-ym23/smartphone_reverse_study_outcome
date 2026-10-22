package org.bouncycastle.asn1.teletrust;

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
public class TeleTrusTNamedCurves {
    static X9ECParametersHolder brainpoolP160r1;
    static X9ECParametersHolder brainpoolP160t1;
    static X9ECParametersHolder brainpoolP192r1;
    static X9ECParametersHolder brainpoolP192t1;
    static X9ECParametersHolder brainpoolP224r1;
    static X9ECParametersHolder brainpoolP224t1;
    static X9ECParametersHolder brainpoolP256r1;
    static X9ECParametersHolder brainpoolP256t1;
    static X9ECParametersHolder brainpoolP320r1;
    static X9ECParametersHolder brainpoolP320t1;
    static X9ECParametersHolder brainpoolP384r1;
    static X9ECParametersHolder brainpoolP384t1;
    static X9ECParametersHolder brainpoolP512r1;
    static X9ECParametersHolder brainpoolP512t1;
    static final Hashtable curves = null;
    static final Hashtable names = null;
    static final Hashtable objIds = null;

    static {
        brainpoolP160r1 = new AnonymousClass1();
        brainpoolP160t1 = new AnonymousClass2();
        brainpoolP192r1 = new AnonymousClass3();
        brainpoolP192t1 = new AnonymousClass4();
        brainpoolP224r1 = new AnonymousClass5();
        brainpoolP224t1 = new AnonymousClass6();
        brainpoolP256r1 = new AnonymousClass7();
        brainpoolP256t1 = new AnonymousClass8();
        brainpoolP320r1 = new AnonymousClass9();
        brainpoolP320t1 = new AnonymousClass10();
        brainpoolP384r1 = new AnonymousClass11();
        brainpoolP384t1 = new AnonymousClass12();
        brainpoolP512r1 = new AnonymousClass13();
        brainpoolP512t1 = new AnonymousClass14();
        objIds = new Hashtable();
        curves = new Hashtable();
        names = new Hashtable();
        defineCurve("brainpoolP160r1", TeleTrusTObjectIdentifiers.brainpoolP160r1, brainpoolP160r1);
        defineCurve("brainpoolP160t1", TeleTrusTObjectIdentifiers.brainpoolP160t1, brainpoolP160t1);
        defineCurve("brainpoolP192r1", TeleTrusTObjectIdentifiers.brainpoolP192r1, brainpoolP192r1);
        defineCurve("brainpoolP192t1", TeleTrusTObjectIdentifiers.brainpoolP192t1, brainpoolP192t1);
        defineCurve("brainpoolP224r1", TeleTrusTObjectIdentifiers.brainpoolP224r1, brainpoolP224r1);
        defineCurve("brainpoolP224t1", TeleTrusTObjectIdentifiers.brainpoolP224t1, brainpoolP224t1);
        defineCurve("brainpoolP256r1", TeleTrusTObjectIdentifiers.brainpoolP256r1, brainpoolP256r1);
        defineCurve("brainpoolP256t1", TeleTrusTObjectIdentifiers.brainpoolP256t1, brainpoolP256t1);
        defineCurve("brainpoolP320r1", TeleTrusTObjectIdentifiers.brainpoolP320r1, brainpoolP320r1);
        defineCurve("brainpoolP320t1", TeleTrusTObjectIdentifiers.brainpoolP320t1, brainpoolP320t1);
        defineCurve("brainpoolP384r1", TeleTrusTObjectIdentifiers.brainpoolP384r1, brainpoolP384r1);
        defineCurve("brainpoolP384t1", TeleTrusTObjectIdentifiers.brainpoolP384t1, brainpoolP384t1);
        defineCurve("brainpoolP512r1", TeleTrusTObjectIdentifiers.brainpoolP512r1, brainpoolP512r1);
        defineCurve("brainpoolP512t1", TeleTrusTObjectIdentifiers.brainpoolP512t1, brainpoolP512t1);
    }

    public TeleTrusTNamedCurves() {
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
        return names.elements();
    }

    public static ASN1ObjectIdentifier getOID(String r100) {
        return (ASN1ObjectIdentifier) objIds.get(Strings.toLowerCase(r100));
    }

    public static ASN1ObjectIdentifier getOID(short r100, boolean r101) {
        StringBuilder r102 = new StringBuilder("brainpoolP");
        r102.append(r100);
        if (r101 == false) goto L5;
        String r103 = "t";
    L6:
        r102.append(r103);
        r102.append("1");
        return getOID(r102.toString());
    L5:
        r103 = "r";
        goto L6
    }
}
