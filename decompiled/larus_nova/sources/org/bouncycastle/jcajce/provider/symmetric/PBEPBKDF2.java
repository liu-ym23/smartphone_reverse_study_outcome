package org.bouncycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.PasswordConverter;
import org.bouncycastle.jcajce.PBKDF2Key;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.bouncycastle.jcajce.provider.symmetric.util.PBE;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.spec.PBKDF2KeySpec;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class PBEPBKDF2 {
    private static final Map prfCodes = null;

    public static class AlgParams extends BaseAlgorithmParameters {
        PBKDF2Params params;

        public AlgParams() {
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() {
            return this.params.getEncoded(ASN1Encoding.DER);
        L4:
            e = move-exception;
            throw new RuntimeException("Oooops! " + e.toString());
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String r100) {
            if (isASN1FormatString(r100) == true) goto L5;
            return null;
        L5:
            return engineGetEncoded();
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec r100) throws InvalidParameterSpecException {
            if ((r100 instanceof PBEParameterSpec) == false) goto L7;
            PBEParameterSpec r101 = (PBEParameterSpec) r100;
            this.params = new PBKDF2Params(r101.getSalt(), r101.getIterationCount());
            return;
        L7:
            throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PBKDF2 PBE parameters algorithm parameters object");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] r100) throws IOException {
            this.params = PBKDF2Params.getInstance(ASN1Primitive.fromByteArray(r100));
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] r100, String r101) throws IOException {
            if (isASN1FormatString(r101) == false) goto L7;
            engineInit(r100);
            return;
        L7:
            throw new IOException("Unknown parameters format in PBKDF2 parameters object");
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "PBKDF2 Parameters";
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class r100) throws InvalidParameterSpecException {
            if (r100 == PBEParameterSpec.class) goto L10;
            if (r100 == AlgorithmParameterSpec.class) goto L10;
            throw new InvalidParameterSpecException("unknown parameter spec passed to PBKDF2 PBE parameters object.");
        L10:
            return new PBEParameterSpec(this.params.getSalt(), this.params.getIterationCount().intValue());
        }
    }

    public static class BasePBKDF2 extends BaseSecretKeyFactory {
        private int defaultDigest;
        private int scheme;

        public BasePBKDF2(String r100, int r101) {
            this(r100, r101, 1);
        }

        public BasePBKDF2(String r100, int r101, int r102) {
            super(r100, PKCSObjectIdentifiers.id_PBKDF2);
            this.scheme = r101;
            this.defaultDigest = r102;
        }

        private int getDigestCode(ASN1ObjectIdentifier r100) throws InvalidKeySpecException {
            Integer r101 = (Integer) PBEPBKDF2.access$000().get(r100);
            if (r101 == null) goto L7;
            return r101.intValue();
        L7:
            throw new InvalidKeySpecException("Invalid KeySpec: unknown PRF algorithm " + r100);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec r110) throws InvalidKeySpecException {
            if ((r110 instanceof PBEKeySpec) == false) goto L31;
            PBEKeySpec r100 = (PBEKeySpec) r110;
            if (r100.getSalt() != null) goto L13;
            char[] r101 = r100.getPassword();
            if (this.scheme != 1) goto L9;
            PasswordConverter r102 = PasswordConverter.ASCII;
        L11:
            return new PBKDF2Key(r101, r102);
        L9:
            r102 = PasswordConverter.UTF8;
            goto L11
        L13:
            if (r100.getIterationCount() <= 0) goto L29;
            if (r100.getKeyLength() <= 0) goto L27;
            if (r100.getPassword().length == 0) goto L25;
            if ((r100 instanceof PBKDF2KeySpec) == false) goto L22;
            int r103 = getDigestCode(((PBKDF2KeySpec) r100).getPrf().getAlgorithm());
            int r104 = r100.getKeyLength();
            return new BCPBEKey(this.algName, this.algOid, this.scheme, r103, r104, -1, r100, PBE.Util.makePBEMacParameters(r100, this.scheme, r103, r104));
        L22:
            int r105 = this.defaultDigest;
            int r106 = r100.getKeyLength();
            return new BCPBEKey(this.algName, this.algOid, this.scheme, r105, r106, -1, r100, PBE.Util.makePBEMacParameters(r100, this.scheme, r105, r106));
        L25:
            throw new IllegalArgumentException("password empty");
        L27:
            throw new InvalidKeySpecException("positive key length required: " + r100.getKeyLength());
        L29:
            throw new InvalidKeySpecException("positive iteration count required: " + r100.getIterationCount());
        L31:
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = PBEPBKDF2.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = PREFIX;
            r101.append(r102);
            r101.append("$AlgParams");
            r100.addAlgorithm("AlgorithmParameters.PBKDF2", r101.toString());
            StringBuilder r103 = new StringBuilder("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier r104 = PKCSObjectIdentifiers.id_PBKDF2;
            r103.append(r104);
            r100.addAlgorithm(r103.toString(), "PBKDF2");
            r100.addAlgorithm("SecretKeyFactory.PBKDF2", r102 + "$PBKDF2withUTF8");
            r100.addAlgorithm("Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1", "PBKDF2");
            r100.addAlgorithm("Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1ANDUTF8", "PBKDF2");
            r100.addAlgorithm("Alg.Alias.SecretKeyFactory." + r104, "PBKDF2");
            r100.addAlgorithm("SecretKeyFactory.PBKDF2WITHASCII", r102 + "$PBKDF2with8BIT");
            r100.addAlgorithm("Alg.Alias.SecretKeyFactory.PBKDF2WITH8BIT", "PBKDF2WITHASCII");
            r100.addAlgorithm("Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1AND8BIT", "PBKDF2WITHASCII");
            r100.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSHA224", r102 + "$PBKDF2withSHA224");
            r100.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSHA256", r102 + "$PBKDF2withSHA256");
            r100.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSHA384", r102 + "$PBKDF2withSHA384");
            r100.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSHA512", r102 + "$PBKDF2withSHA512");
            r100.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSHA3-224", r102 + "$PBKDF2withSHA3_224");
            r100.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSHA3-256", r102 + "$PBKDF2withSHA3_256");
            r100.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSHA3-384", r102 + "$PBKDF2withSHA3_384");
            r100.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSHA3-512", r102 + "$PBKDF2withSHA3_512");
            r100.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACGOST3411", r102 + "$PBKDF2withGOST3411");
            r100.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSM3", r102 + "$PBKDF2withSM3");
        }
    }

    public static class PBKDF2with8BIT extends BasePBKDF2 {
        public PBKDF2with8BIT() {
            super("PBKDF2", 1);
        }
    }

    public static class PBKDF2withGOST3411 extends BasePBKDF2 {
        public PBKDF2withGOST3411() {
            super("PBKDF2", 5, 6);
        }
    }

    public static class PBKDF2withSHA224 extends BasePBKDF2 {
        public PBKDF2withSHA224() {
            super("PBKDF2", 5, 7);
        }
    }

    public static class PBKDF2withSHA256 extends BasePBKDF2 {
        public PBKDF2withSHA256() {
            super("PBKDF2", 5, 4);
        }
    }

    public static class PBKDF2withSHA384 extends BasePBKDF2 {
        public PBKDF2withSHA384() {
            super("PBKDF2", 5, 8);
        }
    }

    public static class PBKDF2withSHA3_224 extends BasePBKDF2 {
        public PBKDF2withSHA3_224() {
            super("PBKDF2", 5, 10);
        }
    }

    public static class PBKDF2withSHA3_256 extends BasePBKDF2 {
        public PBKDF2withSHA3_256() {
            super("PBKDF2", 5, 11);
        }
    }

    public static class PBKDF2withSHA3_384 extends BasePBKDF2 {
        public PBKDF2withSHA3_384() {
            super("PBKDF2", 5, 12);
        }
    }

    public static class PBKDF2withSHA3_512 extends BasePBKDF2 {
        public PBKDF2withSHA3_512() {
            super("PBKDF2", 5, 13);
        }
    }

    public static class PBKDF2withSHA512 extends BasePBKDF2 {
        public PBKDF2withSHA512() {
            super("PBKDF2", 5, 9);
        }
    }

    public static class PBKDF2withSM3 extends BasePBKDF2 {
        public PBKDF2withSM3() {
            super("PBKDF2", 5, 14);
        }
    }

    public static class PBKDF2withUTF8 extends BasePBKDF2 {
        public PBKDF2withUTF8() {
            super("PBKDF2", 5);
        }
    }

    static {
        HashMap r100 = new HashMap();
        prfCodes = r100;
        r100.put(CryptoProObjectIdentifiers.gostR3411Hmac, Integers.valueOf(6));
        r100.put(PKCSObjectIdentifiers.id_hmacWithSHA1, Integers.valueOf(1));
        r100.put(PKCSObjectIdentifiers.id_hmacWithSHA256, Integers.valueOf(4));
        r100.put(PKCSObjectIdentifiers.id_hmacWithSHA224, Integers.valueOf(7));
        r100.put(PKCSObjectIdentifiers.id_hmacWithSHA384, Integers.valueOf(8));
        r100.put(PKCSObjectIdentifiers.id_hmacWithSHA512, Integers.valueOf(9));
        r100.put(NISTObjectIdentifiers.id_hmacWithSHA3_256, Integers.valueOf(11));
        r100.put(NISTObjectIdentifiers.id_hmacWithSHA3_224, Integers.valueOf(10));
        r100.put(NISTObjectIdentifiers.id_hmacWithSHA3_384, Integers.valueOf(12));
        r100.put(NISTObjectIdentifiers.id_hmacWithSHA3_512, Integers.valueOf(13));
        r100.put(GMObjectIdentifiers.hmac_sm3, Integers.valueOf(14));
    }

    private PBEPBKDF2() {
    }

    public static /* synthetic */ Map access$000() {
        return prfCodes;
    }
}
