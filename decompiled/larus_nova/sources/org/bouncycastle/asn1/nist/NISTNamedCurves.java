package org.bouncycastle.asn1.nist;

import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class NISTNamedCurves {
    static final Hashtable names = null;
    static final Hashtable objIds = null;

    static {
        objIds = new Hashtable();
        names = new Hashtable();
        defineCurve("B-571", SECObjectIdentifiers.sect571r1);
        defineCurve("B-409", SECObjectIdentifiers.sect409r1);
        defineCurve("B-283", SECObjectIdentifiers.sect283r1);
        defineCurve("B-233", SECObjectIdentifiers.sect233r1);
        defineCurve("B-163", SECObjectIdentifiers.sect163r2);
        defineCurve("K-571", SECObjectIdentifiers.sect571k1);
        defineCurve("K-409", SECObjectIdentifiers.sect409k1);
        defineCurve("K-283", SECObjectIdentifiers.sect283k1);
        defineCurve("K-233", SECObjectIdentifiers.sect233k1);
        defineCurve("K-163", SECObjectIdentifiers.sect163k1);
        defineCurve("P-521", SECObjectIdentifiers.secp521r1);
        defineCurve("P-384", SECObjectIdentifiers.secp384r1);
        defineCurve("P-256", SECObjectIdentifiers.secp256r1);
        defineCurve("P-224", SECObjectIdentifiers.secp224r1);
        defineCurve("P-192", SECObjectIdentifiers.secp192r1);
    }

    public NISTNamedCurves() {
    }

    public static void defineCurve(String r100, ASN1ObjectIdentifier r101) {
        objIds.put(r100, r101);
        names.put(r101, r100);
    }

    public static X9ECParameters getByName(String r100) {
        ASN1ObjectIdentifier r101 = (ASN1ObjectIdentifier) objIds.get(Strings.toUpperCase(r100));
        if (r101 != null) goto L5;
        return null;
    L5:
        return getByOID(r101);
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier r100) {
        return SECNamedCurves.getByOID(r100);
    }

    public static String getName(ASN1ObjectIdentifier r100) {
        return (String) names.get(r100);
    }

    public static Enumeration getNames() {
        return objIds.keys();
    }

    public static ASN1ObjectIdentifier getOID(String r100) {
        return (ASN1ObjectIdentifier) objIds.get(Strings.toUpperCase(r100));
    }
}
