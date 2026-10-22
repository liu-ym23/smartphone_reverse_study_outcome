package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/* JADX INFO: loaded from: classes42.dex */
public abstract class BaseAlgorithmParameters extends AlgorithmParametersSpi {
    public BaseAlgorithmParameters() {
    }

    @Override // java.security.AlgorithmParametersSpi
    public AlgorithmParameterSpec engineGetParameterSpec(Class r100) throws InvalidParameterSpecException {
        if (r100 == null) goto L6;
        return localEngineGetParameterSpec(r100);
    L6:
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }

    public boolean isASN1FormatString(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.equals("ASN.1") == true) goto L7;
        return false;
    }

    public abstract AlgorithmParameterSpec localEngineGetParameterSpec(Class r100) throws InvalidParameterSpecException;
}
