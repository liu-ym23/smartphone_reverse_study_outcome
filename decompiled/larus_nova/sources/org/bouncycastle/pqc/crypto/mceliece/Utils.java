package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
class Utils {
    public Utils() {
    }

    public static Digest getDigest(String r100) {
        if (r100.equals("SHA-1") == false) goto L7;
        return new SHA1Digest();
    L7:
        if (r100.equals(McElieceCCA2KeyGenParameterSpec.SHA224) == false) goto L11;
        return new SHA224Digest();
    L11:
        if (r100.equals("SHA-256") == false) goto L15;
        return new SHA256Digest();
    L15:
        if (r100.equals(McElieceCCA2KeyGenParameterSpec.SHA384) == false) goto L19;
        return new SHA384Digest();
    L19:
        if (r100.equals("SHA-512") == false) goto L23;
        return new SHA512Digest();
    L23:
        throw new IllegalArgumentException("unrecognised digest algorithm: ".concat(r100));
    }
}
