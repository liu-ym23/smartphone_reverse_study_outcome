package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.iana.IANAObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

/* JADX INFO: loaded from: classes42.dex */
public class SHA1 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA1Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            Digest r100 = (Digest) super.clone();
            r100.digest = new SHA1Digest((SHA1Digest) this.digest);
            return r100;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new SHA1Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA1", 160, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = SHA1.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = PREFIX;
            r101.append(r102);
            r101.append("$Digest");
            r100.addAlgorithm("MessageDigest.SHA-1", r101.toString());
            r100.addAlgorithm("Alg.Alias.MessageDigest.SHA1", "SHA-1");
            r100.addAlgorithm("Alg.Alias.MessageDigest.SHA", "SHA-1");
            StringBuilder r103 = new StringBuilder("Alg.Alias.MessageDigest.");
            ASN1ObjectIdentifier r104 = OIWObjectIdentifiers.idSHA1;
            r103.append(r104);
            r100.addAlgorithm(r103.toString(), "SHA-1");
            addHMACAlgorithm(r100, "SHA1", r102 + "$HashMac", r102 + "$KeyGenerator");
            addHMACAlias(r100, "SHA1", PKCSObjectIdentifiers.id_hmacWithSHA1);
            addHMACAlias(r100, "SHA1", IANAObjectIdentifiers.hmacSHA1);
            r100.addAlgorithm("Mac.PBEWITHHMACSHA", r102 + "$SHA1Mac");
            r100.addAlgorithm("Mac.PBEWITHHMACSHA1", r102 + "$SHA1Mac");
            r100.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA", "PBEWITHHMACSHA1");
            r100.addAlgorithm("Alg.Alias.SecretKeyFactory." + r104, "PBEWITHHMACSHA1");
            r100.addAlgorithm("Alg.Alias.Mac." + r104, "PBEWITHHMACSHA");
            r100.addAlgorithm("SecretKeyFactory.PBEWITHHMACSHA1", r102 + "$PBEWithMacKeyFactory");
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacSHA", null, false, 2, 1, 160, 0);
        }
    }

    public static class SHA1Mac extends BaseMac {
        public SHA1Mac() {
            super(new HMac(new SHA1Digest()));
        }
    }

    private SHA1() {
    }
}
