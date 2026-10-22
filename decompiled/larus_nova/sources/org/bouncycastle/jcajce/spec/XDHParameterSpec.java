package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public class XDHParameterSpec implements AlgorithmParameterSpec {
    public static final String X25519 = "X25519";
    public static final String X448 = "X448";
    private final String curveName;

    public XDHParameterSpec(String r100) {
        if (r100.equalsIgnoreCase(X25519) == false) goto L6;
    L4:
        this.curveName = X25519;
        return;
    L6:
        if (r100.equalsIgnoreCase(X448) == false) goto L9;
    L7:
        this.curveName = X448;
        return;
    L9:
        if (r100.equals(EdECObjectIdentifiers.id_X25519.getId()) == true) goto L4;
        if (r100.equals(EdECObjectIdentifiers.id_X448.getId()) == true) goto L7;
        throw new IllegalArgumentException("unrecognized curve name: ".concat(r100));
    }

    public String getCurveName() {
        return this.curveName;
    }
}
