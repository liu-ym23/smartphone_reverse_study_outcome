package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameters;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
class SpecUtil {
    public SpecUtil() {
    }

    public static AlgorithmParameterSpec extractSpec(AlgorithmParameters r100, Class[] r101) {
        return r100.getParameterSpec(AlgorithmParameterSpec.class);
    L4:
        int r102 = 0;
    L6:
        if (r102 == r101.length) goto L13;
        Class r103 = r101[r102];
        if (r103 == null) goto L12;
        return r100.getParameterSpec(r103);
    L12:
        r102 = r102 + 1;
        goto L6
    L13:
        return null;
    }
}
