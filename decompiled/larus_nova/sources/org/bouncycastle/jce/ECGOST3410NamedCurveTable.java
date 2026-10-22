package org.bouncycastle.jce;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class ECGOST3410NamedCurveTable {
    public ECGOST3410NamedCurveTable() {
    }

    public static Enumeration getNames() {
        return ECGOST3410NamedCurves.getNames();
    }

    public static ECNamedCurveParameterSpec getParameterSpec(String r100) {
        X9ECParameters r101 = ECGOST3410NamedCurves.getByNameX9(r100);
        if (r101 == null) goto L11;
    L7:
        if (r101 != null) goto L10;
        return null;
    L10:
        return new ECNamedCurveParameterSpec(r100, r101.getCurve(), r101.getG(), r101.getN(), r101.getH(), r101.getSeed());
    L11:
        r101 = ECGOST3410NamedCurves.getByOIDX9(new ASN1ObjectIdentifier(r100));     // Catch: IllegalArgumentException -> L6
    L6:
        return null;
    }
}
