package org.bouncycastle.jcajce.util;

import java.io.IOException;
import java.security.AlgorithmParameters;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class AlgorithmParametersUtils {
    private AlgorithmParametersUtils() {
    }

    public static ASN1Encodable extractParameters(AlgorithmParameters r100) throws IOException {
        return ASN1Primitive.fromByteArray(r100.getEncoded("ASN.1"));
    L5:
        return ASN1Primitive.fromByteArray(r100.getEncoded());
    }

    public static void loadParameters(AlgorithmParameters r100, ASN1Encodable r101) throws IOException {
        r100.init(r101.toASN1Primitive().getEncoded(), "ASN.1");     // Catch: Exception -> L4
        return;
    L4:
        r100.init(r101.toASN1Primitive().getEncoded());
    }
}
