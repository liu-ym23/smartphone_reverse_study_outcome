package org.bouncycastle.jcajce.provider.digest;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.SkeinDigest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.macs.SkeinMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;

/* JADX INFO: loaded from: classes42.dex */
public class Skein {

    public static class DigestSkein1024 extends BCMessageDigest implements Cloneable {
        public DigestSkein1024(int r100) {
            super(new SkeinDigest(1024, r100));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            BCMessageDigest r100 = (BCMessageDigest) super.clone();
            r100.digest = new SkeinDigest((SkeinDigest) this.digest);
            return r100;
        }
    }

    public static class DigestSkein256 extends BCMessageDigest implements Cloneable {
        public DigestSkein256(int r100) {
            super(new SkeinDigest(256, r100));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            BCMessageDigest r100 = (BCMessageDigest) super.clone();
            r100.digest = new SkeinDigest((SkeinDigest) this.digest);
            return r100;
        }
    }

    public static class DigestSkein512 extends BCMessageDigest implements Cloneable {
        public DigestSkein512(int r100) {
            super(new SkeinDigest(512, r100));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            BCMessageDigest r100 = (BCMessageDigest) super.clone();
            r100.digest = new SkeinDigest((SkeinDigest) this.digest);
            return r100;
        }
    }

    public static class Digest_1024_1024 extends DigestSkein1024 {
        public Digest_1024_1024() {
            super(1024);
        }
    }

    public static class Digest_1024_384 extends DigestSkein1024 {
        public Digest_1024_384() {
            super(384);
        }
    }

    public static class Digest_1024_512 extends DigestSkein1024 {
        public Digest_1024_512() {
            super(512);
        }
    }

    public static class Digest_256_128 extends DigestSkein256 {
        public Digest_256_128() {
            super(128);
        }
    }

    public static class Digest_256_160 extends DigestSkein256 {
        public Digest_256_160() {
            super(160);
        }
    }

    public static class Digest_256_224 extends DigestSkein256 {
        public Digest_256_224() {
            super(224);
        }
    }

    public static class Digest_256_256 extends DigestSkein256 {
        public Digest_256_256() {
            super(256);
        }
    }

    public static class Digest_512_128 extends DigestSkein512 {
        public Digest_512_128() {
            super(128);
        }
    }

    public static class Digest_512_160 extends DigestSkein512 {
        public Digest_512_160() {
            super(160);
        }
    }

    public static class Digest_512_224 extends DigestSkein512 {
        public Digest_512_224() {
            super(224);
        }
    }

    public static class Digest_512_256 extends DigestSkein512 {
        public Digest_512_256() {
            super(256);
        }
    }

    public static class Digest_512_384 extends DigestSkein512 {
        public Digest_512_384() {
            super(384);
        }
    }

    public static class Digest_512_512 extends DigestSkein512 {
        public Digest_512_512() {
            super(512);
        }
    }

    public static class HMacKeyGenerator_1024_1024 extends BaseKeyGenerator {
        public HMacKeyGenerator_1024_1024() {
            super("HMACSkein-1024-1024", 1024, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_1024_384 extends BaseKeyGenerator {
        public HMacKeyGenerator_1024_384() {
            super("HMACSkein-1024-384", 384, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_1024_512 extends BaseKeyGenerator {
        public HMacKeyGenerator_1024_512() {
            super("HMACSkein-1024-512", 512, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_128 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_128() {
            super("HMACSkein-256-128", 128, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_160 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_160() {
            super("HMACSkein-256-160", 160, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_224 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_224() {
            super("HMACSkein-256-224", 224, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_256 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_256() {
            super("HMACSkein-256-256", 256, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_128 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_128() {
            super("HMACSkein-512-128", 128, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_160 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_160() {
            super("HMACSkein-512-160", 160, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_224 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_224() {
            super("HMACSkein-512-224", 224, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_256 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_256() {
            super("HMACSkein-512-256", 256, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_384 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_384() {
            super("HMACSkein-512-384", 384, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_512 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_512() {
            super("HMACSkein-512-512", 512, new CipherKeyGenerator());
        }
    }

    public static class HashMac_1024_1024 extends BaseMac {
        public HashMac_1024_1024() {
            super(new HMac(new SkeinDigest(1024, 1024)));
        }
    }

    public static class HashMac_1024_384 extends BaseMac {
        public HashMac_1024_384() {
            super(new HMac(new SkeinDigest(1024, 384)));
        }
    }

    public static class HashMac_1024_512 extends BaseMac {
        public HashMac_1024_512() {
            super(new HMac(new SkeinDigest(1024, 512)));
        }
    }

    public static class HashMac_256_128 extends BaseMac {
        public HashMac_256_128() {
            super(new HMac(new SkeinDigest(256, 128)));
        }
    }

    public static class HashMac_256_160 extends BaseMac {
        public HashMac_256_160() {
            super(new HMac(new SkeinDigest(256, 160)));
        }
    }

    public static class HashMac_256_224 extends BaseMac {
        public HashMac_256_224() {
            super(new HMac(new SkeinDigest(256, 224)));
        }
    }

    public static class HashMac_256_256 extends BaseMac {
        public HashMac_256_256() {
            super(new HMac(new SkeinDigest(256, 256)));
        }
    }

    public static class HashMac_512_128 extends BaseMac {
        public HashMac_512_128() {
            super(new HMac(new SkeinDigest(512, 128)));
        }
    }

    public static class HashMac_512_160 extends BaseMac {
        public HashMac_512_160() {
            super(new HMac(new SkeinDigest(512, 160)));
        }
    }

    public static class HashMac_512_224 extends BaseMac {
        public HashMac_512_224() {
            super(new HMac(new SkeinDigest(512, 224)));
        }
    }

    public static class HashMac_512_256 extends BaseMac {
        public HashMac_512_256() {
            super(new HMac(new SkeinDigest(512, 256)));
        }
    }

    public static class HashMac_512_384 extends BaseMac {
        public HashMac_512_384() {
            super(new HMac(new SkeinDigest(512, 384)));
        }
    }

    public static class HashMac_512_512 extends BaseMac {
        public HashMac_512_512() {
            super(new HMac(new SkeinDigest(512, 512)));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = Skein.class.getName();
        }

        public Mappings() {
        }

        private void addSkeinMacAlgorithm(ConfigurableProvider r100, int r101, int r102) {
            String r103 = "Skein-MAC-" + r101 + "-" + r102;
            StringBuilder r104 = new StringBuilder();
            String r105 = PREFIX;
            r104.append(r105);
            r104.append("$SkeinMac_");
            r104.append(r101);
            r104.append("_");
            r104.append(r102);
            r100.addAlgorithm("Mac." + r103, r104.toString());
            r100.addAlgorithm("Alg.Alias.Mac.Skein-MAC" + r101 + HTTP.URL_DEFAULT + r102, r103);
            StringBuilder r106 = new StringBuilder("KeyGenerator.");
            r106.append(r103);
            r100.addAlgorithm(r106.toString(), r105 + "$SkeinMacKeyGenerator_" + r101 + "_" + r102);
            r100.addAlgorithm("Alg.Alias.KeyGenerator.Skein-MAC" + r101 + HTTP.URL_DEFAULT + r102, r103);
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = PREFIX;
            r101.append(r102);
            r101.append("$Digest_256_128");
            r100.addAlgorithm("MessageDigest.Skein-256-128", r101.toString());
            r100.addAlgorithm("MessageDigest.Skein-256-160", r102 + "$Digest_256_160");
            r100.addAlgorithm("MessageDigest.Skein-256-224", r102 + "$Digest_256_224");
            r100.addAlgorithm("MessageDigest.Skein-256-256", r102 + "$Digest_256_256");
            r100.addAlgorithm("MessageDigest.Skein-512-128", r102 + "$Digest_512_128");
            r100.addAlgorithm("MessageDigest.Skein-512-160", r102 + "$Digest_512_160");
            r100.addAlgorithm("MessageDigest.Skein-512-224", r102 + "$Digest_512_224");
            r100.addAlgorithm("MessageDigest.Skein-512-256", r102 + "$Digest_512_256");
            r100.addAlgorithm("MessageDigest.Skein-512-384", r102 + "$Digest_512_384");
            r100.addAlgorithm("MessageDigest.Skein-512-512", r102 + "$Digest_512_512");
            r100.addAlgorithm("MessageDigest.Skein-1024-384", r102 + "$Digest_1024_384");
            r100.addAlgorithm("MessageDigest.Skein-1024-512", r102 + "$Digest_1024_512");
            r100.addAlgorithm("MessageDigest.Skein-1024-1024", r102 + "$Digest_1024_1024");
            addHMACAlgorithm(r100, "Skein-256-128", r102 + "$HashMac_256_128", r102 + "$HMacKeyGenerator_256_128");
            addHMACAlgorithm(r100, "Skein-256-160", r102 + "$HashMac_256_160", r102 + "$HMacKeyGenerator_256_160");
            addHMACAlgorithm(r100, "Skein-256-224", r102 + "$HashMac_256_224", r102 + "$HMacKeyGenerator_256_224");
            addHMACAlgorithm(r100, "Skein-256-256", r102 + "$HashMac_256_256", r102 + "$HMacKeyGenerator_256_256");
            addHMACAlgorithm(r100, "Skein-512-128", r102 + "$HashMac_512_128", r102 + "$HMacKeyGenerator_512_128");
            addHMACAlgorithm(r100, "Skein-512-160", r102 + "$HashMac_512_160", r102 + "$HMacKeyGenerator_512_160");
            addHMACAlgorithm(r100, "Skein-512-224", r102 + "$HashMac_512_224", r102 + "$HMacKeyGenerator_512_224");
            addHMACAlgorithm(r100, "Skein-512-256", r102 + "$HashMac_512_256", r102 + "$HMacKeyGenerator_512_256");
            addHMACAlgorithm(r100, "Skein-512-384", r102 + "$HashMac_512_384", r102 + "$HMacKeyGenerator_512_384");
            addHMACAlgorithm(r100, "Skein-512-512", r102 + "$HashMac_512_512", r102 + "$HMacKeyGenerator_512_512");
            addHMACAlgorithm(r100, "Skein-1024-384", r102 + "$HashMac_1024_384", r102 + "$HMacKeyGenerator_1024_384");
            addHMACAlgorithm(r100, "Skein-1024-512", r102 + "$HashMac_1024_512", r102 + "$HMacKeyGenerator_1024_512");
            addHMACAlgorithm(r100, "Skein-1024-1024", r102 + "$HashMac_1024_1024", r102 + "$HMacKeyGenerator_1024_1024");
            addSkeinMacAlgorithm(r100, 256, 128);
            addSkeinMacAlgorithm(r100, 256, 160);
            addSkeinMacAlgorithm(r100, 256, 224);
            addSkeinMacAlgorithm(r100, 256, 256);
            addSkeinMacAlgorithm(r100, 512, 128);
            addSkeinMacAlgorithm(r100, 512, 160);
            addSkeinMacAlgorithm(r100, 512, 224);
            addSkeinMacAlgorithm(r100, 512, 256);
            addSkeinMacAlgorithm(r100, 512, 384);
            addSkeinMacAlgorithm(r100, 512, 512);
            addSkeinMacAlgorithm(r100, 1024, 384);
            addSkeinMacAlgorithm(r100, 1024, 512);
            addSkeinMacAlgorithm(r100, 1024, 1024);
        }
    }

    public static class SkeinMacKeyGenerator_1024_1024 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_1024_1024() {
            super("Skein-MAC-1024-1024", 1024, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_1024_384 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_1024_384() {
            super("Skein-MAC-1024-384", 384, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_1024_512 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_1024_512() {
            super("Skein-MAC-1024-512", 512, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_128 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_128() {
            super("Skein-MAC-256-128", 128, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_160 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_160() {
            super("Skein-MAC-256-160", 160, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_224 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_224() {
            super("Skein-MAC-256-224", 224, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_256 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_256() {
            super("Skein-MAC-256-256", 256, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_128 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_128() {
            super("Skein-MAC-512-128", 128, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_160 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_160() {
            super("Skein-MAC-512-160", 160, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_224 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_224() {
            super("Skein-MAC-512-224", 224, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_256 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_256() {
            super("Skein-MAC-512-256", 256, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_384 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_384() {
            super("Skein-MAC-512-384", 384, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_512 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_512() {
            super("Skein-MAC-512-512", 512, new CipherKeyGenerator());
        }
    }

    public static class SkeinMac_1024_1024 extends BaseMac {
        public SkeinMac_1024_1024() {
            super(new SkeinMac(1024, 1024));
        }
    }

    public static class SkeinMac_1024_384 extends BaseMac {
        public SkeinMac_1024_384() {
            super(new SkeinMac(1024, 384));
        }
    }

    public static class SkeinMac_1024_512 extends BaseMac {
        public SkeinMac_1024_512() {
            super(new SkeinMac(1024, 512));
        }
    }

    public static class SkeinMac_256_128 extends BaseMac {
        public SkeinMac_256_128() {
            super(new SkeinMac(256, 128));
        }
    }

    public static class SkeinMac_256_160 extends BaseMac {
        public SkeinMac_256_160() {
            super(new SkeinMac(256, 160));
        }
    }

    public static class SkeinMac_256_224 extends BaseMac {
        public SkeinMac_256_224() {
            super(new SkeinMac(256, 224));
        }
    }

    public static class SkeinMac_256_256 extends BaseMac {
        public SkeinMac_256_256() {
            super(new SkeinMac(256, 256));
        }
    }

    public static class SkeinMac_512_128 extends BaseMac {
        public SkeinMac_512_128() {
            super(new SkeinMac(512, 128));
        }
    }

    public static class SkeinMac_512_160 extends BaseMac {
        public SkeinMac_512_160() {
            super(new SkeinMac(512, 160));
        }
    }

    public static class SkeinMac_512_224 extends BaseMac {
        public SkeinMac_512_224() {
            super(new SkeinMac(512, 224));
        }
    }

    public static class SkeinMac_512_256 extends BaseMac {
        public SkeinMac_512_256() {
            super(new SkeinMac(512, 256));
        }
    }

    public static class SkeinMac_512_384 extends BaseMac {
        public SkeinMac_512_384() {
            super(new SkeinMac(512, 384));
        }
    }

    public static class SkeinMac_512_512 extends BaseMac {
        public SkeinMac_512_512() {
            super(new SkeinMac(512, 512));
        }
    }

    private Skein() {
    }
}
