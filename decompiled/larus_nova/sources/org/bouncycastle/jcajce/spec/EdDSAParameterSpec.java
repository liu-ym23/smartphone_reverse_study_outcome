package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public class EdDSAParameterSpec implements AlgorithmParameterSpec {
    public static final String Ed25519 = "Ed25519";
    public static final String Ed448 = "Ed448";
    private final String curveName;

    public EdDSAParameterSpec(String r100) {
        if (r100.equalsIgnoreCase(Ed25519) == false) goto L6;
    L4:
        this.curveName = Ed25519;
        return;
    L6:
        if (r100.equalsIgnoreCase(Ed448) == false) goto L9;
    L7:
        this.curveName = Ed448;
        return;
    L9:
        if (r100.equals(EdECObjectIdentifiers.id_Ed25519.getId()) == true) goto L4;
        if (r100.equals(EdECObjectIdentifiers.id_Ed448.getId()) == true) goto L7;
        throw new IllegalArgumentException("unrecognized curve name: ".concat(r100));
    }

    public String getCurveName() {
        return this.curveName;
    }
}
