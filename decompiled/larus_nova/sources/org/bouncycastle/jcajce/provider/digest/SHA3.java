package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;

/* JADX INFO: loaded from: classes42.dex */
public class SHA3 {

    public static class Digest224 extends DigestSHA3 {
        public Digest224() {
            super(224);
        }
    }

    public static class Digest256 extends DigestSHA3 {
        public Digest256() {
            super(256);
        }
    }

    public static class Digest384 extends DigestSHA3 {
        public Digest384() {
            super(384);
        }
    }

    public static class Digest512 extends DigestSHA3 {
        public Digest512() {
            super(512);
        }
    }

    public static class DigestSHA3 extends BCMessageDigest implements Cloneable {
        public DigestSHA3(int r100) {
            super(new SHA3Digest(r100));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            BCMessageDigest r100 = (BCMessageDigest) super.clone();
            r100.digest = new SHA3Digest((SHA3Digest) this.digest);
            return r100;
        }
    }

    public static class DigestSHAKE extends BCMessageDigest implements Cloneable {
        public DigestSHAKE(int r100, int r101) {
            super(new SHAKEDigest(r100), r101);
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            BCMessageDigest r100 = (BCMessageDigest) super.clone();
            r100.digest = new SHAKEDigest((SHAKEDigest) this.digest);
            return r100;
        }

        @Override // org.bouncycastle.jcajce.provider.digest.BCMessageDigest, java.security.MessageDigestSpi
        public byte[] engineDigest() {
            int r100 = this.digestSize;
            byte[] r101 = new byte[r100];
            ((Xof) this.digest).doFinal(r101, 0, r100);
            return r101;
        }
    }

    public static class DigestShake128_256 extends DigestSHAKE {
        public DigestShake128_256() {
            super(128, 256);
        }
    }

    public static class DigestShake256_512 extends DigestSHAKE {
        public DigestShake256_512() {
            super(256, 512);
        }
    }

    public static class HashMac224 extends HashMacSHA3 {
        public HashMac224() {
            super(224);
        }
    }

    public static class HashMac256 extends HashMacSHA3 {
        public HashMac256() {
            super(256);
        }
    }

    public static class HashMac384 extends HashMacSHA3 {
        public HashMac384() {
            super(384);
        }
    }

    public static class HashMac512 extends HashMacSHA3 {
        public HashMac512() {
            super(512);
        }
    }

    public static class HashMacSHA3 extends BaseMac {
        public HashMacSHA3(int r100) {
            super(new HMac(new SHA3Digest(r100)));
        }
    }

    public static class KeyGenerator224 extends KeyGeneratorSHA3 {
        public KeyGenerator224() {
            super(224);
        }
    }

    public static class KeyGenerator256 extends KeyGeneratorSHA3 {
        public KeyGenerator256() {
            super(256);
        }
    }

    public static class KeyGenerator384 extends KeyGeneratorSHA3 {
        public KeyGenerator384() {
            super(384);
        }
    }

    public static class KeyGenerator512 extends KeyGeneratorSHA3 {
        public KeyGenerator512() {
            super(512);
        }
    }

    public static class KeyGeneratorSHA3 extends BaseKeyGenerator {
        public KeyGeneratorSHA3(int r100) {
            super("HMACSHA3-" + r100, r100, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = SHA3.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = PREFIX;
            r101.append(r102);
            r101.append("$Digest224");
            r100.addAlgorithm("MessageDigest.SHA3-224", r101.toString());
            r100.addAlgorithm("MessageDigest.SHA3-256", r102 + "$Digest256");
            r100.addAlgorithm("MessageDigest.SHA3-384", r102 + "$Digest384");
            r100.addAlgorithm("MessageDigest.SHA3-512", r102 + "$Digest512");
            r100.addAlgorithm("MessageDigest", NISTObjectIdentifiers.id_sha3_224, r102 + "$Digest224");
            r100.addAlgorithm("MessageDigest", NISTObjectIdentifiers.id_sha3_256, r102 + "$Digest256");
            r100.addAlgorithm("MessageDigest", NISTObjectIdentifiers.id_sha3_384, r102 + "$Digest384");
            r100.addAlgorithm("MessageDigest", NISTObjectIdentifiers.id_sha3_512, r102 + "$Digest512");
            r100.addAlgorithm("MessageDigest.SHAKE256-512", r102 + "$DigestShake256_512");
            r100.addAlgorithm("MessageDigest.SHAKE128-256", r102 + "$DigestShake128_256");
            r100.addAlgorithm("MessageDigest", NISTObjectIdentifiers.id_shake256, r102 + "$DigestShake256_512");
            r100.addAlgorithm("MessageDigest", NISTObjectIdentifiers.id_shake128, r102 + "$DigestShake128_256");
            r100.addAlgorithm("Alg.Alias.MessageDigest.SHAKE256", "SHAKE256-512");
            r100.addAlgorithm("Alg.Alias.MessageDigest.SHAKE128", "SHAKE128-256");
            addHMACAlgorithm(r100, "SHA3-224", r102 + "$HashMac224", r102 + "$KeyGenerator224");
            addHMACAlias(r100, "SHA3-224", NISTObjectIdentifiers.id_hmacWithSHA3_224);
            addHMACAlgorithm(r100, "SHA3-256", r102 + "$HashMac256", r102 + "$KeyGenerator256");
            addHMACAlias(r100, "SHA3-256", NISTObjectIdentifiers.id_hmacWithSHA3_256);
            addHMACAlgorithm(r100, "SHA3-384", r102 + "$HashMac384", r102 + "$KeyGenerator384");
            addHMACAlias(r100, "SHA3-384", NISTObjectIdentifiers.id_hmacWithSHA3_384);
            addHMACAlgorithm(r100, "SHA3-512", r102 + "$HashMac512", r102 + "$KeyGenerator512");
            addHMACAlias(r100, "SHA3-512", NISTObjectIdentifiers.id_hmacWithSHA3_512);
        }
    }

    private SHA3() {
    }
}
