package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.Zuc128Engine;
import org.bouncycastle.crypto.engines.Zuc256Engine;
import org.bouncycastle.crypto.macs.Zuc128Mac;
import org.bouncycastle.crypto.macs.Zuc256Mac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

/* JADX INFO: loaded from: classes42.dex */
public class Zuc {

    public static class AlgParams extends IvAlgorithmParameters {
        public AlgParams() {
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Zuc IV";
        }
    }

    public static class KeyGen128 extends BaseKeyGenerator {
        public KeyGen128() {
            super("ZUC128", 128, new CipherKeyGenerator());
        }
    }

    public static class KeyGen256 extends BaseKeyGenerator {
        public KeyGen256() {
            super("ZUC256", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = Zuc.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = PREFIX;
            r101.append(r102);
            r101.append("$Zuc128");
            r100.addAlgorithm("Cipher.ZUC-128", r101.toString());
            r100.addAlgorithm("KeyGenerator.ZUC-128", r102 + "$KeyGen128");
            r100.addAlgorithm("AlgorithmParameters.ZUC-128", r102 + "$AlgParams");
            r100.addAlgorithm("Cipher.ZUC-256", r102 + "$Zuc256");
            r100.addAlgorithm("KeyGenerator.ZUC-256", r102 + "$KeyGen256");
            r100.addAlgorithm("AlgorithmParameters.ZUC-256", r102 + "$AlgParams");
            r100.addAlgorithm("Mac.ZUC-128", r102 + "$ZucMac128");
            r100.addAlgorithm("Mac.ZUC-256", r102 + "$ZucMac256");
            r100.addAlgorithm("Alg.Alias.Mac.ZUC-256-128", "ZUC-256");
            r100.addAlgorithm("Mac.ZUC-256-64", r102 + "$ZucMac256_64");
            r100.addAlgorithm("Mac.ZUC-256-32", r102 + "$ZucMac256_32");
        }
    }

    public static class Zuc128 extends BaseStreamCipher {
        public Zuc128() {
            super(new Zuc128Engine(), 16, 128);
        }
    }

    public static class Zuc256 extends BaseStreamCipher {
        public Zuc256() {
            super(new Zuc256Engine(), 25, 256);
        }
    }

    public static class ZucMac128 extends BaseMac {
        public ZucMac128() {
            super(new Zuc128Mac());
        }
    }

    public static class ZucMac256 extends BaseMac {
        public ZucMac256() {
            super(new Zuc256Mac(128));
        }
    }

    public static class ZucMac256_32 extends BaseMac {
        public ZucMac256_32() {
            super(new Zuc256Mac(32));
        }
    }

    public static class ZucMac256_64 extends BaseMac {
        public ZucMac256_64() {
            super(new Zuc256Mac(64));
        }
    }

    private Zuc() {
    }
}
