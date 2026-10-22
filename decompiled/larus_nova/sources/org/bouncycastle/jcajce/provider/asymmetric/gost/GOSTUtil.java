package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.math.BigInteger;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Fingerprint;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
class GOSTUtil {
    public GOSTUtil() {
    }

    private static String generateKeyFingerprint(BigInteger r100, GOST3410Parameters r101) {
        return new Fingerprint(Arrays.concatenate(r100.toByteArray(), r101.getP().toByteArray(), r101.getA().toByteArray())).toString();
    }

    public static String privateKeyToString(String r100, BigInteger r101, GOST3410Parameters r102) {
        StringBuffer r103 = new StringBuffer();
        String r104 = Strings.lineSeparator();
        BigInteger r105 = r102.getA().modPow(r101, r102.getP());
        r103.append(r100);
        r103.append(" Private Key [");
        r103.append(generateKeyFingerprint(r105, r102));
        r103.append("]");
        r103.append(r104);
        r103.append("                  Y: ");
        r103.append(r105.toString(16));
        r103.append(r104);
        return r103.toString();
    }

    public static String publicKeyToString(String r100, BigInteger r101, GOST3410Parameters r102) {
        StringBuffer r103 = new StringBuffer();
        String r104 = Strings.lineSeparator();
        r103.append(r100);
        r103.append(" Public Key [");
        r103.append(generateKeyFingerprint(r101, r102));
        r103.append("]");
        r103.append(r104);
        r103.append("                 Y: ");
        r103.append(r101.toString(16));
        r103.append(r104);
        return r103.toString();
    }
}
