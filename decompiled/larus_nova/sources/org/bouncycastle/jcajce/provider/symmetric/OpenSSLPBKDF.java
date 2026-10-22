package org.bouncycastle.jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public final class OpenSSLPBKDF {

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = OpenSSLPBKDF.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            r100.addAlgorithm("SecretKeyFactory.PBKDF-OPENSSL", PREFIX + "$PBKDF");
        }
    }

    public static class PBKDF extends BaseSecretKeyFactory {
        public PBKDF() {
            super("PBKDF-OpenSSL", null);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec r100) throws InvalidKeySpecException {
            if ((r100 instanceof PBEKeySpec) == false) goto L23;
            PBEKeySpec r101 = (PBEKeySpec) r100;
            if (r101.getSalt() == null) goto L21;
            if (r101.getIterationCount() <= 0) goto L19;
            if (r101.getKeyLength() <= 0) goto L17;
            if (r101.getPassword().length == 0) goto L15;
            OpenSSLPBEParametersGenerator r102 = new OpenSSLPBEParametersGenerator();
            r102.init(Strings.toUTF8ByteArray(r101.getPassword()), r101.getSalt());
            return new SecretKeySpec(((KeyParameter) r102.generateDerivedParameters(r101.getKeyLength())).getKey(), "OpenSSLPBKDF");
        L15:
            throw new IllegalArgumentException("password empty");
        L17:
            throw new InvalidKeySpecException("positive key length required: " + r101.getKeyLength());
        L19:
            throw new InvalidKeySpecException("positive iteration count required: " + r101.getIterationCount());
        L21:
            throw new InvalidKeySpecException("missing required salt");
        L23:
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    private OpenSSLPBKDF() {
    }
}
