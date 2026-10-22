package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.GOST3411Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.digests.TigerDigest;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;

/* JADX INFO: loaded from: classes42.dex */
public interface PBE {
    public static final int GOST3411 = 6;
    public static final int MD2 = 5;
    public static final int MD5 = 0;
    public static final int OPENSSL = 3;
    public static final int PKCS12 = 2;
    public static final int PKCS5S1 = 0;
    public static final int PKCS5S1_UTF8 = 4;
    public static final int PKCS5S2 = 1;
    public static final int PKCS5S2_UTF8 = 5;
    public static final int RIPEMD160 = 2;
    public static final int SHA1 = 1;
    public static final int SHA224 = 7;
    public static final int SHA256 = 4;
    public static final int SHA384 = 8;
    public static final int SHA3_224 = 10;
    public static final int SHA3_256 = 11;
    public static final int SHA3_384 = 12;
    public static final int SHA3_512 = 13;
    public static final int SHA512 = 9;
    public static final int SM3 = 14;
    public static final int TIGER = 3;

    public static class Util {
        public Util() {
        }

        private static byte[] convertPassword(int r100, PBEKeySpec r101) {
            if (r100 != 2) goto L6;
            return PBEParametersGenerator.PKCS12PasswordToBytes(r101.getPassword());
        L6:
            if (r100 == 5) goto L12;
            if (r100 == 4) goto L12;
            return PBEParametersGenerator.PKCS5PasswordToBytes(r101.getPassword());
        L12:
            return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(r101.getPassword());
        }

        private static PBEParametersGenerator makePBEGenerator(int r100, int r101) {
            if (r100 != 0) goto L5;
        L44:
            if (r101 == 0) goto L52;
            if (r101 == 1) goto L80;
            if (r101 != 5) goto L49;
            return new PKCS5S1ParametersGenerator(new MD2Digest());
        L49:
            throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
        L80:
            return new PKCS5S1ParametersGenerator(DigestFactory.createSHA1());
        L52:
            return new PKCS5S1ParametersGenerator(DigestFactory.createMD5());
        L5:
            if (r100 == 4) goto L44;
            if (r100 == 1) goto L26;
            if (r100 == 5) goto L26;
            if (r100 != 2) goto L63;
            switch(r101) {
                case 0: goto L62;
                case 1: goto L61;
                case 2: goto L60;
                case 3: goto L59;
                case 4: goto L58;
                case 5: goto L57;
                case 6: goto L56;
                case 7: goto L55;
                case 8: goto L54;
                case 9: goto L53;
                default: goto L14;
            };
        L14:
            throw new IllegalStateException("unknown digest scheme for PBE encryption.");
        L53:
            return new PKCS12ParametersGenerator(DigestFactory.createSHA512());
        L54:
            return new PKCS12ParametersGenerator(DigestFactory.createSHA384());
        L55:
            return new PKCS12ParametersGenerator(DigestFactory.createSHA224());
        L56:
            return new PKCS12ParametersGenerator(new GOST3411Digest());
        L57:
            return new PKCS12ParametersGenerator(new MD2Digest());
        L58:
            return new PKCS12ParametersGenerator(DigestFactory.createSHA256());
        L59:
            return new PKCS12ParametersGenerator(new TigerDigest());
        L60:
            return new PKCS12ParametersGenerator(new RIPEMD160Digest());
        L61:
            return new PKCS12ParametersGenerator(DigestFactory.createSHA1());
        L62:
            return new PKCS12ParametersGenerator(DigestFactory.createMD5());
        L63:
            return new OpenSSLPBEParametersGenerator();
        L26:
            switch(r101) {
                case 0: goto L78;
                case 1: goto L77;
                case 2: goto L76;
                case 3: goto L75;
                case 4: goto L74;
                case 5: goto L73;
                case 6: goto L72;
                case 7: goto L71;
                case 8: goto L70;
                case 9: goto L69;
                case 10: goto L68;
                case 11: goto L67;
                case 12: goto L66;
                case 13: goto L65;
                case 14: goto L64;
                default: goto L28;
            };
        L28:
            throw new IllegalStateException("unknown digest scheme for PBE PKCS5S2 encryption.");
        L64:
            return new PKCS5S2ParametersGenerator(new SM3Digest());
        L65:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_512());
        L66:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_384());
        L67:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_256());
        L68:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_224());
        L69:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA512());
        L70:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA384());
        L71:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA224());
        L72:
            return new PKCS5S2ParametersGenerator(new GOST3411Digest());
        L73:
            return new PKCS5S2ParametersGenerator(new MD2Digest());
        L74:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA256());
        L75:
            return new PKCS5S2ParametersGenerator(new TigerDigest());
        L76:
            return new PKCS5S2ParametersGenerator(new RIPEMD160Digest());
        L77:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA1());
        L78:
            return new PKCS5S2ParametersGenerator(DigestFactory.createMD5());
        }

        public static CipherParameters makePBEMacParameters(SecretKey r100, int r101, int r102, int r103, PBEParameterSpec r104) {
            PBEParametersGenerator r105 = makePBEGenerator(r101, r102);
            byte[] r106 = r100.getEncoded();
            r105.init(r100.getEncoded(), r104.getSalt(), r104.getIterationCount());
            CipherParameters r107 = r105.generateDerivedMacParameters(r103);
            int r108 = 0;
        L4:
            if (r108 == r106.length) goto L6;
            r106[r108] = 0;
            r108 = r108 + 1;
            goto L4
        L6:
            return r107;
        }

        public static CipherParameters makePBEMacParameters(PBEKeySpec r100, int r101, int r102, int r103) {
            PBEParametersGenerator r104 = makePBEGenerator(r101, r102);
            byte[] r105 = convertPassword(r101, r100);
            r104.init(r105, r100.getSalt(), r100.getIterationCount());
            CipherParameters r106 = r104.generateDerivedMacParameters(r103);
            int r107 = 0;
        L4:
            if (r107 == r105.length) goto L6;
            r105[r107] = 0;
            r107 = r107 + 1;
            goto L4
        L6:
            return r106;
        }

        public static CipherParameters makePBEMacParameters(BCPBEKey r100, AlgorithmParameterSpec r101) {
            if (r101 == null) goto L8;
            if ((r101 instanceof PBEParameterSpec) == false) goto L8;
            PBEParameterSpec r102 = (PBEParameterSpec) r101;
            PBEParametersGenerator r103 = makePBEGenerator(r100.getType(), r100.getDigest());
            r103.init(r100.getEncoded(), r102.getSalt(), r102.getIterationCount());
            return r103.generateDerivedMacParameters(r100.getKeySize());
        L8:
            throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
        }

        public static CipherParameters makePBEParameters(PBEKeySpec r100, int r101, int r102, int r103, int r104) {
            PBEParametersGenerator r105 = makePBEGenerator(r101, r102);
            byte[] r106 = convertPassword(r101, r100);
            r105.init(r106, r100.getSalt(), r100.getIterationCount());
            if (r104 == 0) goto L5;
            CipherParameters r107 = r105.generateDerivedParameters(r103, r104);
        L6:
            int r108 = 0;
        L8:
            if (r108 == r106.length) goto L10;
            r106[r108] = 0;
            r108 = r108 + 1;
            goto L8
        L10:
            return r107;
        L5:
            r107 = r105.generateDerivedParameters(r103);
            goto L6
        }

        public static CipherParameters makePBEParameters(BCPBEKey r100, AlgorithmParameterSpec r101, String r102) {
            if (r101 == null) goto L20;
            if ((r101 instanceof PBEParameterSpec) == false) goto L20;
            PBEParameterSpec r103 = (PBEParameterSpec) r101;
            PBEParametersGenerator r104 = makePBEGenerator(r100.getType(), r100.getDigest());
            byte[] r105 = r100.getEncoded();
            if (r100.shouldTryWrongPKCS12() == false) goto L8;
            r105 = new byte[2];
        L8:
            r104.init(r105, r103.getSalt(), r103.getIterationCount());
            if (r100.getIvSize() == 0) goto L11;
            CipherParameters r106 = r104.generateDerivedParameters(r100.getKeySize(), r100.getIvSize());
        L13:
            if (r102.startsWith("DES") == true) goto L15;
        L18:
            return r106;
        L15:
            if ((r106 instanceof ParametersWithIV) == false) goto L17;
            DESParameters.setOddParity(((KeyParameter) ((ParametersWithIV) r106).getParameters()).getKey());
            goto L18
        L17:
            DESParameters.setOddParity(((KeyParameter) r106).getKey());
            goto L18
        L11:
            r106 = r104.generateDerivedParameters(r100.getKeySize());
        L20:
            throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
        }

        public static CipherParameters makePBEParameters(byte[] r100, int r101, int r102, int r103, int r104, AlgorithmParameterSpec r105, String r106) throws InvalidAlgorithmParameterException {
            if (r105 == null) goto L17;
            if ((r105 instanceof PBEParameterSpec) == false) goto L17;
            PBEParameterSpec r107 = (PBEParameterSpec) r105;
            PBEParametersGenerator r108 = makePBEGenerator(r101, r102);
            r108.init(r100, r107.getSalt(), r107.getIterationCount());
            if (r104 == 0) goto L8;
            CipherParameters r109 = r108.generateDerivedParameters(r103, r104);
        L10:
            if (r106.startsWith("DES") == true) goto L12;
        L15:
            return r109;
        L12:
            if ((r109 instanceof ParametersWithIV) == false) goto L14;
            DESParameters.setOddParity(((KeyParameter) ((ParametersWithIV) r109).getParameters()).getKey());
            goto L15
        L14:
            DESParameters.setOddParity(((KeyParameter) r109).getKey());
            goto L15
        L8:
            r109 = r108.generateDerivedParameters(r103);
        L17:
            throw new InvalidAlgorithmParameterException("Need a PBEParameter spec with a PBE key.");
        }
    }
}
