package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;

/* JADX INFO: loaded from: classes42.dex */
public class Blake2b {

    public static class Blake2b160 extends BCMessageDigest implements Cloneable {
        public Blake2b160() {
            super(new Blake2bDigest(160));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            Blake2b160 r100 = (Blake2b160) super.clone();
            r100.digest = new Blake2bDigest((Blake2bDigest) this.digest);
            return r100;
        }
    }

    public static class Blake2b256 extends BCMessageDigest implements Cloneable {
        public Blake2b256() {
            super(new Blake2bDigest(256));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            Blake2b256 r100 = (Blake2b256) super.clone();
            r100.digest = new Blake2bDigest((Blake2bDigest) this.digest);
            return r100;
        }
    }

    public static class Blake2b384 extends BCMessageDigest implements Cloneable {
        public Blake2b384() {
            super(new Blake2bDigest(384));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            Blake2b384 r100 = (Blake2b384) super.clone();
            r100.digest = new Blake2bDigest((Blake2bDigest) this.digest);
            return r100;
        }
    }

    public static class Blake2b512 extends BCMessageDigest implements Cloneable {
        public Blake2b512() {
            super(new Blake2bDigest(512));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            Blake2b512 r100 = (Blake2b512) super.clone();
            r100.digest = new Blake2bDigest((Blake2bDigest) this.digest);
            return r100;
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = Blake2b.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = PREFIX;
            r101.append(r102);
            r101.append("$Blake2b512");
            r100.addAlgorithm("MessageDigest.BLAKE2B-512", r101.toString());
            r100.addAlgorithm("Alg.Alias.MessageDigest." + MiscObjectIdentifiers.id_blake2b512, "BLAKE2B-512");
            r100.addAlgorithm("MessageDigest.BLAKE2B-384", r102 + "$Blake2b384");
            StringBuilder r103 = new StringBuilder("Alg.Alias.MessageDigest.");
            r103.append(MiscObjectIdentifiers.id_blake2b384);
            r100.addAlgorithm(r103.toString(), "BLAKE2B-384");
            r100.addAlgorithm("MessageDigest.BLAKE2B-256", r102 + "$Blake2b256");
            StringBuilder r104 = new StringBuilder("Alg.Alias.MessageDigest.");
            r104.append(MiscObjectIdentifiers.id_blake2b256);
            r100.addAlgorithm(r104.toString(), "BLAKE2B-256");
            r100.addAlgorithm("MessageDigest.BLAKE2B-160", r102 + "$Blake2b160");
            StringBuilder r105 = new StringBuilder("Alg.Alias.MessageDigest.");
            r105.append(MiscObjectIdentifiers.id_blake2b160);
            r100.addAlgorithm(r105.toString(), "BLAKE2B-160");
        }
    }

    private Blake2b() {
    }
}
