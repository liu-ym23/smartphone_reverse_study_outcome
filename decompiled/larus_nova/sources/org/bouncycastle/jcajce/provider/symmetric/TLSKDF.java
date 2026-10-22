package org.bouncycastle.jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.spec.TLSKeyMaterialSpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class TLSKDF {

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = TLSKDF.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = PREFIX;
            r101.append(r102);
            r101.append("$TLS10");
            r100.addAlgorithm("SecretKeyFactory.TLS10KDF", r101.toString());
            r100.addAlgorithm("SecretKeyFactory.TLS11KDF", r102 + "$TLS11");
            r100.addAlgorithm("SecretKeyFactory.TLS12WITHSHA256KDF", r102 + "$TLS12withSHA256");
            r100.addAlgorithm("SecretKeyFactory.TLS12WITHSHA384KDF", r102 + "$TLS12withSHA384");
            r100.addAlgorithm("SecretKeyFactory.TLS12WITHSHA512KDF", r102 + "$TLS12withSHA512");
        }
    }

    public static final class TLS10 extends TLSKeyMaterialFactory {
        public TLS10() {
            super("TLS10KDF");
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec r100) throws InvalidKeySpecException {
            if ((r100 instanceof TLSKeyMaterialSpec) == false) goto L7;
            return new SecretKeySpec(TLSKDF.access$000((TLSKeyMaterialSpec) r100), this.algName);
        L7:
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static final class TLS11 extends TLSKeyMaterialFactory {
        public TLS11() {
            super("TLS11KDF");
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec r100) throws InvalidKeySpecException {
            if ((r100 instanceof TLSKeyMaterialSpec) == false) goto L7;
            return new SecretKeySpec(TLSKDF.access$000((TLSKeyMaterialSpec) r100), this.algName);
        L7:
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static class TLS12 extends TLSKeyMaterialFactory {
        private final Mac prf;

        public TLS12(String r100, Mac r101) {
            super(r100);
            this.prf = r101;
        }

        private byte[] PRF(TLSKeyMaterialSpec r100, Mac r101) {
            byte[] r102 = Arrays.concatenate(Strings.toByteArray(r100.getLabel()), r100.getSeed());
            byte[] r103 = r100.getSecret();
            byte[] r104 = new byte[r100.getLength()];
            TLSKDF.access$100(r101, r103, r102, r104);
            return r104;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec r100) throws InvalidKeySpecException {
            if ((r100 instanceof TLSKeyMaterialSpec) == false) goto L7;
            return new SecretKeySpec(PRF((TLSKeyMaterialSpec) r100, this.prf), this.algName);
        L7:
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static final class TLS12withSHA256 extends TLS12 {
        public TLS12withSHA256() {
            super("TLS12withSHA256KDF", new HMac(new SHA256Digest()));
        }
    }

    public static final class TLS12withSHA384 extends TLS12 {
        public TLS12withSHA384() {
            super("TLS12withSHA384KDF", new HMac(new SHA384Digest()));
        }
    }

    public static final class TLS12withSHA512 extends TLS12 {
        public TLS12withSHA512() {
            super("TLS12withSHA512KDF", new HMac(new SHA512Digest()));
        }
    }

    public static class TLSKeyMaterialFactory extends BaseSecretKeyFactory {
        public TLSKeyMaterialFactory(String r100) {
            super(r100, null);
        }
    }

    public TLSKDF() {
    }

    private static byte[] PRF_legacy(TLSKeyMaterialSpec r100) {
        HMac r101 = new HMac(DigestFactory.createMD5());
        HMac r102 = new HMac(DigestFactory.createSHA1());
        byte[] r103 = Arrays.concatenate(Strings.toByteArray(r100.getLabel()), r100.getSeed());
        byte[] r104 = r100.getSecret();
        int r105 = (r104.length + 1) / 2;
        byte[] r106 = new byte[r105];
        byte[] r107 = new byte[r105];
        int r108 = 0;
        System.arraycopy(r104, 0, r106, 0, r105);
        System.arraycopy(r104, r104.length - r105, r107, 0, r105);
        int r109 = r100.getLength();
        byte[] r110 = new byte[r109];
        byte[] r111 = new byte[r109];
        hmac_hash(r101, r106, r103, r110);
        hmac_hash(r102, r107, r103, r111);
    L3:
        if (r108 >= r109) goto L5;
        r110[r108] = (byte) (r110[r108] ^ r111[r108]);
        r108 = r108 + 1;
        goto L3
    L5:
        return r110;
    }

    public static /* synthetic */ byte[] access$000(TLSKeyMaterialSpec r100) {
        return PRF_legacy(r100);
    }

    public static /* synthetic */ void access$100(Mac r100, byte[] r101, byte[] r102, byte[] r103) {
        hmac_hash(r100, r101, r102, r103);
    }

    private static void hmac_hash(Mac r100, byte[] r101, byte[] r110, byte[] r111) {
        r100.init(new KeyParameter(r101));
        int r102 = r100.getMacSize();
        int r103 = ((r111.length + r102) - 1) / r102;
        int r104 = r100.getMacSize();
        byte[] r105 = new byte[r104];
        byte[] r106 = new byte[r100.getMacSize()];
        byte[] r107 = r110;
        int r108 = 0;
    L3:
        if (r108 >= r103) goto L5;
        r100.update(r107, 0, r107.length);
        r100.doFinal(r105, 0);
        r100.update(r105, 0, r104);
        r100.update(r110, 0, r110.length);
        r100.doFinal(r106, 0);
        int r109 = r102 * r108;
        System.arraycopy(r106, 0, r111, r109, Math.min(r102, r111.length - r109));
        r108 = r108 + 1;
        r107 = r105;
        goto L3
    }
}
