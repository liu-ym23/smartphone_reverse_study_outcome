package org.bouncycastle.jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.crypto.PasswordConverter;
import org.bouncycastle.crypto.generators.SCrypt;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.spec.ScryptKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class SCRYPT {

    public static class BasePBKDF2 extends BaseSecretKeyFactory {
        private int scheme;

        public BasePBKDF2(String r100, int r101) {
            super(r100, MiscObjectIdentifiers.id_scrypt);
            this.scheme = r101;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec r110) throws InvalidKeySpecException {
            if ((r110 instanceof ScryptKeySpec) == false) goto L23;
            ScryptKeySpec r111 = (ScryptKeySpec) r110;
            if (r111.getSalt() == null) goto L21;
            if (r111.getCostParameter() <= 1) goto L19;
            if (r111.getKeyLength() <= 0) goto L17;
            if (r111.getPassword().length == 0) goto L15;
            return new BCPBEKey(this.algName, new KeyParameter(SCrypt.generate(PasswordConverter.UTF8.convert(r111.getPassword()), r111.getSalt(), r111.getCostParameter(), r111.getBlockSize(), r111.getParallelizationParameter(), r111.getKeyLength() / 8)));
        L15:
            throw new IllegalArgumentException("password empty");
        L17:
            throw new InvalidKeySpecException("positive key length required: " + r111.getKeyLength());
        L19:
            throw new IllegalArgumentException("Cost parameter N must be > 1.");
        L21:
            throw new IllegalArgumentException("Salt S must be provided.");
        L23:
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = SCRYPT.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = PREFIX;
            r101.append(r102);
            r101.append("$ScryptWithUTF8");
            r100.addAlgorithm("SecretKeyFactory.SCRYPT", r101.toString());
            r100.addAlgorithm("SecretKeyFactory", MiscObjectIdentifiers.id_scrypt, r102 + "$ScryptWithUTF8");
        }
    }

    public static class ScryptWithUTF8 extends BasePBKDF2 {
        public ScryptWithUTF8() {
            super("SCRYPT", 5);
        }
    }

    private SCRYPT() {
    }
}
