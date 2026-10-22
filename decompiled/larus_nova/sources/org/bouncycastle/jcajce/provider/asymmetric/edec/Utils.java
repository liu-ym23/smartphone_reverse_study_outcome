package org.bouncycastle.jcajce.provider.asymmetric.edec;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.params.Ed448PublicKeyParameters;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.crypto.params.X448PublicKeyParameters;
import org.bouncycastle.util.Fingerprint;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
class Utils {
    public Utils() {
    }

    private static String generateKeyFingerprint(byte[] r100) {
        return new Fingerprint(r100).toString();
    }

    public static boolean isValidPrefix(byte[] r100, byte[] r101) {
        if (r101.length < r100.length) goto L5;
        int r102 = 0;
        int r103 = 0;
    L8:
        if (r102 == r100.length) goto L10;
        r103 = r103 | (r100[r102] ^ r101[r102]);
        r102 = r102 + 1;
        goto L8
    L10:
        if (r103 == 0) goto L15;
        return false;
    L15:
        return true;
    L5:
        return !isValidPrefix(r100, r100);
    }

    public static String keyToString(String r100, String r101, AsymmetricKeyParameter r102) {
        StringBuffer r103 = new StringBuffer();
        String r104 = Strings.lineSeparator();
        if ((r102 instanceof X448PublicKeyParameters) == false) goto L6;
        byte[] r105 = ((X448PublicKeyParameters) r102).getEncoded();
    L12:
        r103.append(r101);
        r103.append(" ");
        r103.append(r100);
        r103.append(" [");
        r103.append(generateKeyFingerprint(r105));
        r103.append("]");
        r103.append(r104);
        r103.append("    public data: ");
        r103.append(Hex.toHexString(r105));
        r103.append(r104);
        return r103.toString();
    L6:
        if ((r102 instanceof Ed448PublicKeyParameters) == false) goto L9;
        r105 = ((Ed448PublicKeyParameters) r102).getEncoded();
        goto L12
    L9:
        if ((r102 instanceof X25519PublicKeyParameters) == false) goto L11;
        r105 = ((X25519PublicKeyParameters) r102).getEncoded();
        goto L12
    L11:
        r105 = ((Ed25519PublicKeyParameters) r102).getEncoded();
        goto L12
    }
}
