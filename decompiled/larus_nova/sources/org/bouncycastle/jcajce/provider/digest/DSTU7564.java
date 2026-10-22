package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.ua.UAObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.DSTU7564Digest;
import org.bouncycastle.crypto.macs.DSTU7564Mac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU7564 {

    public static class Digest256 extends DigestDSTU7564 {
        public Digest256() {
            super(256);
        }
    }

    public static class Digest384 extends DigestDSTU7564 {
        public Digest384() {
            super(384);
        }
    }

    public static class Digest512 extends DigestDSTU7564 {
        public Digest512() {
            super(512);
        }
    }

    public static class DigestDSTU7564 extends BCMessageDigest implements Cloneable {
        public DigestDSTU7564(int r100) {
            super(new DSTU7564Digest(r100));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            BCMessageDigest r100 = (BCMessageDigest) super.clone();
            r100.digest = new DSTU7564Digest((DSTU7564Digest) this.digest);
            return r100;
        }
    }

    public static class HashMac256 extends BaseMac {
        public HashMac256() {
            super(new DSTU7564Mac(256));
        }
    }

    public static class HashMac384 extends BaseMac {
        public HashMac384() {
            super(new DSTU7564Mac(384));
        }
    }

    public static class HashMac512 extends BaseMac {
        public HashMac512() {
            super(new DSTU7564Mac(512));
        }
    }

    public static class KeyGenerator256 extends BaseKeyGenerator {
        public KeyGenerator256() {
            super("HMACDSTU7564-256", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator384 extends BaseKeyGenerator {
        public KeyGenerator384() {
            super("HMACDSTU7564-384", 384, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator512 extends BaseKeyGenerator {
        public KeyGenerator512() {
            super("HMACDSTU7564-512", 512, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = DSTU7564.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = PREFIX;
            r101.append(r102);
            r101.append("$Digest256");
            r100.addAlgorithm("MessageDigest.DSTU7564-256", r101.toString());
            r100.addAlgorithm("MessageDigest.DSTU7564-384", r102 + "$Digest384");
            r100.addAlgorithm("MessageDigest.DSTU7564-512", r102 + "$Digest512");
            r100.addAlgorithm("MessageDigest", UAObjectIdentifiers.dstu7564digest_256, r102 + "$Digest256");
            r100.addAlgorithm("MessageDigest", UAObjectIdentifiers.dstu7564digest_384, r102 + "$Digest384");
            r100.addAlgorithm("MessageDigest", UAObjectIdentifiers.dstu7564digest_512, r102 + "$Digest512");
            addHMACAlgorithm(r100, "DSTU7564-256", r102 + "$HashMac256", r102 + "$KeyGenerator256");
            addHMACAlgorithm(r100, "DSTU7564-384", r102 + "$HashMac384", r102 + "$KeyGenerator384");
            addHMACAlgorithm(r100, "DSTU7564-512", r102 + "$HashMac512", r102 + "$KeyGenerator512");
            addHMACAlias(r100, "DSTU7564-256", UAObjectIdentifiers.dstu7564mac_256);
            addHMACAlias(r100, "DSTU7564-384", UAObjectIdentifiers.dstu7564mac_384);
            addHMACAlias(r100, "DSTU7564-512", UAObjectIdentifiers.dstu7564mac_512);
        }
    }

    private DSTU7564() {
    }
}
