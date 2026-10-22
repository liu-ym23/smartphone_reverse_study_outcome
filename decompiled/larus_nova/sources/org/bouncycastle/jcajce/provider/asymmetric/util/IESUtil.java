package org.bouncycastle.jcajce.provider.asymmetric.util;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.jce.spec.IESParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class IESUtil {
    public IESUtil() {
    }

    public static IESParameterSpec guessParameterSpec(BufferedBlockCipher r110, byte[] r111) {
        if (r110 == null) goto L4;
        BlockCipher r112 = r110.getUnderlyingCipher();
        if (r112.getAlgorithmName().equals("DES") == true) goto L25;
        if (r112.getAlgorithmName().equals("RC2") == true) goto L25;
        if (r112.getAlgorithmName().equals("RC5-32") == true) goto L25;
        if (r112.getAlgorithmName().equals("RC5-64") == true) goto L25;
        if (r112.getAlgorithmName().equals("SKIPJACK") == false) goto L19;
        return new IESParameterSpec(null, null, 80, 80, r111);
    L19:
        if (r112.getAlgorithmName().equals("GOST28147") == false) goto L23;
        return new IESParameterSpec(null, null, 256, 256, r111);
    L23:
        return new IESParameterSpec(null, null, 128, 128, r111);
    L25:
        return new IESParameterSpec(null, null, 64, 64, r111);
    L4:
        return new IESParameterSpec(null, null, 128);
    }
}
