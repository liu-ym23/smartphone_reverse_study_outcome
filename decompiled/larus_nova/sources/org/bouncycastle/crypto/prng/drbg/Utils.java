package org.bouncycastle.crypto.prng.drbg;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.Hashtable;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
class Utils {
    static final Hashtable maxSecurityStrengths = null;

    static {
        Hashtable r100 = new Hashtable();
        maxSecurityStrengths = r100;
        r100.put("SHA-1", Integers.valueOf(128));
        r100.put(McElieceCCA2KeyGenParameterSpec.SHA224, Integers.valueOf(192));
        r100.put("SHA-256", Integers.valueOf(256));
        r100.put(McElieceCCA2KeyGenParameterSpec.SHA384, Integers.valueOf(256));
        r100.put("SHA-512", Integers.valueOf(256));
        r100.put("SHA-512/224", Integers.valueOf(192));
        r100.put(SPHINCSKeyParameters.SHA512_256, Integers.valueOf(256));
    }

    public Utils() {
    }

    public static int getMaxSecurityStrength(Digest r100) {
        return ((Integer) maxSecurityStrengths.get(r100.getAlgorithmName())).intValue();
    }

    public static int getMaxSecurityStrength(Mac r100) {
        String r101 = r100.getAlgorithmName();
        return ((Integer) maxSecurityStrengths.get(r101.substring(0, r101.indexOf(HTTP.URL_DEFAULT)))).intValue();
    }

    public static byte[] hash_df(Digest r110, byte[] r111, int r112) {
        int r100 = (r112 + 7) / 8;
        byte[] r101 = new byte[r100];
        int r102 = r100 / r110.getDigestSize();
        int r103 = r110.getDigestSize();
        byte[] r104 = new byte[r103];
        int r105 = 1;
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r107 > r102) goto L8;
        r110.update((byte) r105);
        r110.update((byte) (r112 >> 24));
        r110.update((byte) (r112 >> 16));
        r110.update((byte) (r112 >> 8));
        r110.update((byte) r112);
        r110.update(r111, 0, r111.length);
        r110.doFinal(r104, 0);
        int r108 = r107 * r103;
        int r109 = r100 - r108;
        if (r109 <= r103) goto L7;
        r109 = r103;
    L7:
        System.arraycopy(r104, 0, r101, r108, r109);
        r105 = r105 + 1;
        r107 = r107 + 1;
        goto L3
    L8:
        int r113 = r112 % 8;
        if (r113 == 0) goto L13;
        int r114 = 8 - r113;
        int r115 = 0;
    L11:
        if (r106 == r100) goto L13;
        int r116 = r101[r106] & 255;
        int r117 = r115 << (8 - r114);
        r101[r106] = (byte) (r117 | (r116 >>> r114));
        r106 = r106 + 1;
        r115 = r116;
    L13:
        return r101;
    }

    public static boolean isTooLarge(byte[] r100, int r101) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length <= r101) goto L6;
        return true;
    }
}
