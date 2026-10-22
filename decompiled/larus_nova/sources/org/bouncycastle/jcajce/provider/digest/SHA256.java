package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

/* JADX INFO: loaded from: classes42.dex */
public class SHA256 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA256Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            Digest r100 = (Digest) super.clone();
            r100.digest = new SHA256Digest((SHA256Digest) this.digest);
            return r100;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new SHA256Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA256", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = SHA256.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = PREFIX;
            r101.append(r102);
            r101.append("$Digest");
            r100.addAlgorithm("MessageDigest.SHA-256", r101.toString());
            r100.addAlgorithm("Alg.Alias.MessageDigest.SHA256", "SHA-256");
            StringBuilder r103 = new StringBuilder("Alg.Alias.MessageDigest.");
            ASN1ObjectIdentifier r104 = NISTObjectIdentifiers.id_sha256;
            r103.append(r104);
            r100.addAlgorithm(r103.toString(), "SHA-256");
            r100.addAlgorithm("SecretKeyFactory.PBEWITHHMACSHA256", r102 + "$PBEWithMacKeyFactory");
            r100.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA-256", "PBEWITHHMACSHA256");
            r100.addAlgorithm("Alg.Alias.SecretKeyFactory." + r104, "PBEWITHHMACSHA256");
            r100.addAlgorithm("Mac.PBEWITHHMACSHA256", r102 + "$HashMac");
            addHMACAlgorithm(r100, "SHA256", r102 + "$HashMac", r102 + "$KeyGenerator");
            addHMACAlias(r100, "SHA256", PKCSObjectIdentifiers.id_hmacWithSHA256);
            addHMACAlias(r100, "SHA256", r104);
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacSHA256", null, false, 2, 4, 256, 0);
        }
    }

    private SHA256() {
    }
}
