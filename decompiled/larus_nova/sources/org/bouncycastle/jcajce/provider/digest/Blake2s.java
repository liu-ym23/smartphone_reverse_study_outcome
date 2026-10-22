package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.crypto.digests.Blake2sDigest;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;

/* JADX INFO: loaded from: classes42.dex */
public class Blake2s {

    public static class Blake2s128 extends BCMessageDigest implements Cloneable {
        public Blake2s128() {
            super(new Blake2sDigest(128));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            Blake2s128 r100 = (Blake2s128) super.clone();
            r100.digest = new Blake2sDigest((Blake2sDigest) this.digest);
            return r100;
        }
    }

    public static class Blake2s160 extends BCMessageDigest implements Cloneable {
        public Blake2s160() {
            super(new Blake2sDigest(160));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            Blake2s160 r100 = (Blake2s160) super.clone();
            r100.digest = new Blake2sDigest((Blake2sDigest) this.digest);
            return r100;
        }
    }

    public static class Blake2s224 extends BCMessageDigest implements Cloneable {
        public Blake2s224() {
            super(new Blake2sDigest(224));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            Blake2s224 r100 = (Blake2s224) super.clone();
            r100.digest = new Blake2sDigest((Blake2sDigest) this.digest);
            return r100;
        }
    }

    public static class Blake2s256 extends BCMessageDigest implements Cloneable {
        public Blake2s256() {
            super(new Blake2sDigest(256));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            Blake2s256 r100 = (Blake2s256) super.clone();
            r100.digest = new Blake2sDigest((Blake2sDigest) this.digest);
            return r100;
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = Blake2s.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = PREFIX;
            r101.append(r102);
            r101.append("$Blake2s256");
            r100.addAlgorithm("MessageDigest.BLAKE2S-256", r101.toString());
            r100.addAlgorithm("Alg.Alias.MessageDigest." + MiscObjectIdentifiers.id_blake2s256, "BLAKE2S-256");
            r100.addAlgorithm("MessageDigest.BLAKE2S-224", r102 + "$Blake2s224");
            StringBuilder r103 = new StringBuilder("Alg.Alias.MessageDigest.");
            r103.append(MiscObjectIdentifiers.id_blake2s224);
            r100.addAlgorithm(r103.toString(), "BLAKE2S-224");
            r100.addAlgorithm("MessageDigest.BLAKE2S-160", r102 + "$Blake2s160");
            StringBuilder r104 = new StringBuilder("Alg.Alias.MessageDigest.");
            r104.append(MiscObjectIdentifiers.id_blake2s160);
            r100.addAlgorithm(r104.toString(), "BLAKE2S-160");
            r100.addAlgorithm("MessageDigest.BLAKE2S-128", r102 + "$Blake2s128");
            StringBuilder r105 = new StringBuilder("Alg.Alias.MessageDigest.");
            r105.append(MiscObjectIdentifiers.id_blake2s128);
            r100.addAlgorithm(r105.toString(), "BLAKE2S-128");
        }
    }

    private Blake2s() {
    }
}
