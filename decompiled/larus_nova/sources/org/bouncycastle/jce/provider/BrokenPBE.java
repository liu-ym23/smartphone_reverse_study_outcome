package org.bouncycastle.jce.provider;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;

/* JADX INFO: loaded from: classes42.dex */
public interface BrokenPBE {
    public static final int MD5 = 0;
    public static final int OLD_PKCS12 = 3;
    public static final int PKCS12 = 2;
    public static final int PKCS5S1 = 0;
    public static final int PKCS5S2 = 1;
    public static final int RIPEMD160 = 2;
    public static final int SHA1 = 1;

    public static class Util {
        public Util() {
        }

        private static PBEParametersGenerator makePBEGenerator(int r100, int r101) {
            if (r100 != 0) goto L10;
            if (r101 == 0) goto L32;
            if (r101 != 1) goto L8;
            return new PKCS5S1ParametersGenerator(new SHA1Digest());
        L8:
            throw new IllegalStateException("PKCS5 scheme 1 only supports only MD5 and SHA1.");
        L32:
            return new PKCS5S1ParametersGenerator(new MD5Digest());
        L10:
            if (r100 != 1) goto L13;
            return new PKCS5S2ParametersGenerator();
        L13:
            if (r100 != 3) goto L22;
            if (r101 == 0) goto L36;
            if (r101 == 1) goto L35;
            if (r101 != 2) goto L19;
            return new OldPKCS12ParametersGenerator(new RIPEMD160Digest());
        L19:
            throw new IllegalStateException("unknown digest scheme for PBE encryption.");
        L35:
            return new OldPKCS12ParametersGenerator(new SHA1Digest());
        L36:
            return new OldPKCS12ParametersGenerator(new MD5Digest());
        L22:
            if (r101 == 0) goto L30;
            if (r101 == 1) goto L38;
            if (r101 != 2) goto L27;
            return new PKCS12ParametersGenerator(new RIPEMD160Digest());
        L27:
            throw new IllegalStateException("unknown digest scheme for PBE encryption.");
        L38:
            return new PKCS12ParametersGenerator(new SHA1Digest());
        L30:
            return new PKCS12ParametersGenerator(new MD5Digest());
        }

        public static CipherParameters makePBEMacParameters(BCPBEKey r100, AlgorithmParameterSpec r101, int r102, int r103, int r104) {
            if (r101 == null) goto L11;
            if ((r101 instanceof PBEParameterSpec) == false) goto L11;
            PBEParameterSpec r105 = (PBEParameterSpec) r101;
            PBEParametersGenerator r106 = makePBEGenerator(r102, r103);
            byte[] r107 = r100.getEncoded();
            r106.init(r107, r105.getSalt(), r105.getIterationCount());
            CipherParameters r108 = r106.generateDerivedMacParameters(r104);
            int r109 = 0;
        L7:
            if (r109 == r107.length) goto L9;
            r107[r109] = 0;
            r109 = r109 + 1;
            goto L7
        L9:
            return r108;
        L11:
            throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
        }

        public static CipherParameters makePBEParameters(BCPBEKey r100, AlgorithmParameterSpec r101, int r102, int r103, String r104, int r105, int r106) {
            if (r101 == null) goto L21;
            if ((r101 instanceof PBEParameterSpec) == false) goto L21;
            PBEParameterSpec r107 = (PBEParameterSpec) r101;
            PBEParametersGenerator r108 = makePBEGenerator(r102, r103);
            byte[] r109 = r100.getEncoded();
            r108.init(r109, r107.getSalt(), r107.getIterationCount());
            if (r106 == 0) goto L8;
            CipherParameters r110 = r108.generateDerivedParameters(r105, r106);
        L10:
            if (r104.startsWith("DES") == true) goto L12;
        L15:
            int r111 = 0;
        L17:
            if (r111 == r109.length) goto L19;
            r109[r111] = 0;
            r111 = r111 + 1;
            goto L17
        L19:
            return r110;
        L12:
            if ((r110 instanceof ParametersWithIV) == false) goto L14;
            setOddParity(((KeyParameter) ((ParametersWithIV) r110).getParameters()).getKey());
            goto L15
        L14:
            setOddParity(((KeyParameter) r110).getKey());
            goto L15
        L8:
            r110 = r108.generateDerivedParameters(r105);
        L21:
            throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
        }

        private static void setOddParity(byte[] r100) {
            int r101 = 0;
        L4:
            if (r101 >= r100.length) goto L6;
            byte r102 = r100[r101];
            int r103 = r102 & 254;
            int r104 = (((((r102 >> 1) ^ (r102 >> 2)) ^ (r102 >> 3)) ^ (r102 >> 4)) ^ (r102 >> 5)) ^ (r102 >> 6);
            r100[r101] = (byte) ((((r102 >> 7) ^ r104) ^ 1) | r103);
            r101 = r101 + 1;
            goto L4
        }
    }
}
