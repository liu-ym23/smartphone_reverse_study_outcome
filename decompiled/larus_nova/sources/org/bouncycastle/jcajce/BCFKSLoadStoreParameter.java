package org.bouncycastle.jcajce;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import org.bouncycastle.crypto.util.PBKDF2Config;
import org.bouncycastle.crypto.util.PBKDFConfig;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public class BCFKSLoadStoreParameter extends BCLoadStoreParameter {
    private final X509Certificate[] certificates;
    private final EncryptionAlgorithm encAlg;
    private final MacAlgorithm macAlg;
    private final SignatureAlgorithm sigAlg;
    private final Key sigKey;
    private final PBKDFConfig storeConfig;
    private final CertChainValidator validator;

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.BCFKSLoadStoreParameter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private X509Certificate[] certs;
        private EncryptionAlgorithm encAlg;

        /* JADX INFO: renamed from: in, reason: collision with root package name */
        private final InputStream f525348in;
        private MacAlgorithm macAlg;
        private final OutputStream out;
        private final KeyStore.ProtectionParameter protectionParameter;
        private SignatureAlgorithm sigAlg;
        private final Key sigKey;
        private PBKDFConfig storeConfig;
        private CertChainValidator validator;

        public Builder() {
            this(null, null);
        }

        public Builder(InputStream r100, KeyStore.ProtectionParameter r101) {
            this.storeConfig = new PBKDF2Config.Builder().withIterationCount(16384).withSaltLength(64).withPRF(PBKDF2Config.PRF_SHA512).build();
            this.encAlg = EncryptionAlgorithm.AES256_CCM;
            this.macAlg = MacAlgorithm.HmacSHA512;
            this.sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.certs = null;
            this.f525348in = r100;
            this.out = null;
            this.protectionParameter = r101;
            this.sigKey = null;
        }

        public Builder(InputStream r100, PublicKey r101) {
            this.storeConfig = new PBKDF2Config.Builder().withIterationCount(16384).withSaltLength(64).withPRF(PBKDF2Config.PRF_SHA512).build();
            this.encAlg = EncryptionAlgorithm.AES256_CCM;
            this.macAlg = MacAlgorithm.HmacSHA512;
            this.sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.certs = null;
            this.f525348in = r100;
            this.out = null;
            this.protectionParameter = null;
            this.sigKey = r101;
        }

        public Builder(InputStream r100, CertChainValidator r101) {
            this.storeConfig = new PBKDF2Config.Builder().withIterationCount(16384).withSaltLength(64).withPRF(PBKDF2Config.PRF_SHA512).build();
            this.encAlg = EncryptionAlgorithm.AES256_CCM;
            this.macAlg = MacAlgorithm.HmacSHA512;
            this.sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.certs = null;
            this.f525348in = r100;
            this.out = null;
            this.protectionParameter = null;
            this.validator = r101;
            this.sigKey = null;
        }

        public Builder(InputStream r100, char[] r101) {
            this(r100, new KeyStore.PasswordProtection(r101));
        }

        public Builder(OutputStream r100, KeyStore.ProtectionParameter r101) {
            this.storeConfig = new PBKDF2Config.Builder().withIterationCount(16384).withSaltLength(64).withPRF(PBKDF2Config.PRF_SHA512).build();
            this.encAlg = EncryptionAlgorithm.AES256_CCM;
            this.macAlg = MacAlgorithm.HmacSHA512;
            this.sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.certs = null;
            this.f525348in = null;
            this.out = r100;
            this.protectionParameter = r101;
            this.sigKey = null;
        }

        public Builder(OutputStream r100, PrivateKey r101) {
            this.storeConfig = new PBKDF2Config.Builder().withIterationCount(16384).withSaltLength(64).withPRF(PBKDF2Config.PRF_SHA512).build();
            this.encAlg = EncryptionAlgorithm.AES256_CCM;
            this.macAlg = MacAlgorithm.HmacSHA512;
            this.sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.certs = null;
            this.f525348in = null;
            this.out = r100;
            this.protectionParameter = null;
            this.sigKey = r101;
        }

        public Builder(OutputStream r100, char[] r101) {
            this(r100, new KeyStore.PasswordProtection(r101));
        }

        public static /* synthetic */ InputStream access$100(Builder r100) {
            return r100.f525348in;
        }

        public static /* synthetic */ CertChainValidator access$1000(Builder r100) {
            return r100.validator;
        }

        public static /* synthetic */ OutputStream access$200(Builder r100) {
            return r100.out;
        }

        public static /* synthetic */ KeyStore.ProtectionParameter access$300(Builder r100) {
            return r100.protectionParameter;
        }

        public static /* synthetic */ PBKDFConfig access$400(Builder r100) {
            return r100.storeConfig;
        }

        public static /* synthetic */ EncryptionAlgorithm access$500(Builder r100) {
            return r100.encAlg;
        }

        public static /* synthetic */ MacAlgorithm access$600(Builder r100) {
            return r100.macAlg;
        }

        public static /* synthetic */ SignatureAlgorithm access$700(Builder r100) {
            return r100.sigAlg;
        }

        public static /* synthetic */ Key access$800(Builder r100) {
            return r100.sigKey;
        }

        public static /* synthetic */ X509Certificate[] access$900(Builder r100) {
            return r100.certs;
        }

        public BCFKSLoadStoreParameter build() {
            return new BCFKSLoadStoreParameter(this, null);
        }

        public Builder withCertificates(X509Certificate[] r100) {
            int r101 = r100.length;
            X509Certificate[] r102 = new X509Certificate[r101];
            System.arraycopy(r100, 0, r102, 0, r101);
            this.certs = r102;
            return this;
        }

        public Builder withStoreEncryptionAlgorithm(EncryptionAlgorithm r100) {
            this.encAlg = r100;
            return this;
        }

        public Builder withStoreMacAlgorithm(MacAlgorithm r100) {
            this.macAlg = r100;
            return this;
        }

        public Builder withStorePBKDFConfig(PBKDFConfig r100) {
            this.storeConfig = r100;
            return this;
        }

        public Builder withStoreSignatureAlgorithm(SignatureAlgorithm r100) {
            this.sigAlg = r100;
            return this;
        }
    }

    public interface CertChainValidator {
        boolean isValid(X509Certificate[] r100);
    }

    public static final enum EncryptionAlgorithm extends Enum<EncryptionAlgorithm> {
        private static final /* synthetic */ EncryptionAlgorithm[] $VALUES = null;
        public static final EncryptionAlgorithm AES256_CCM = null;
        public static final EncryptionAlgorithm AES256_KWP = null;

        static {
            EncryptionAlgorithm r100 = new EncryptionAlgorithm("AES256_CCM", 0);
            AES256_CCM = r100;
            EncryptionAlgorithm r101 = new EncryptionAlgorithm("AES256_KWP", 1);
            AES256_KWP = r101;
            $VALUES = new EncryptionAlgorithm[]{r100, r101};
        }

        private EncryptionAlgorithm(String r100, int r101) {
            super(r100, r101);
        }

        public static EncryptionAlgorithm valueOf(String r100) {
            return (EncryptionAlgorithm) a.a(EncryptionAlgorithm.class, r100);
        }

        public static EncryptionAlgorithm[] values() {
            return (EncryptionAlgorithm[]) $VALUES.clone();
        }
    }

    public static final enum MacAlgorithm extends Enum<MacAlgorithm> {
        private static final /* synthetic */ MacAlgorithm[] $VALUES = null;
        public static final MacAlgorithm HmacSHA3_512 = null;
        public static final MacAlgorithm HmacSHA512 = null;

        static {
            MacAlgorithm r100 = new MacAlgorithm("HmacSHA512", 0);
            HmacSHA512 = r100;
            MacAlgorithm r101 = new MacAlgorithm("HmacSHA3_512", 1);
            HmacSHA3_512 = r101;
            $VALUES = new MacAlgorithm[]{r100, r101};
        }

        private MacAlgorithm(String r100, int r101) {
            super(r100, r101);
        }

        public static MacAlgorithm valueOf(String r100) {
            return (MacAlgorithm) a.a(MacAlgorithm.class, r100);
        }

        public static MacAlgorithm[] values() {
            return (MacAlgorithm[]) $VALUES.clone();
        }
    }

    public static final enum SignatureAlgorithm extends Enum<SignatureAlgorithm> {
        private static final /* synthetic */ SignatureAlgorithm[] $VALUES = null;
        public static final SignatureAlgorithm SHA3_512withDSA = null;
        public static final SignatureAlgorithm SHA3_512withECDSA = null;
        public static final SignatureAlgorithm SHA3_512withRSA = null;
        public static final SignatureAlgorithm SHA512withDSA = null;
        public static final SignatureAlgorithm SHA512withECDSA = null;
        public static final SignatureAlgorithm SHA512withRSA = null;

        static {
            SignatureAlgorithm r100 = new SignatureAlgorithm("SHA512withDSA", 0);
            SHA512withDSA = r100;
            SignatureAlgorithm r101 = new SignatureAlgorithm("SHA3_512withDSA", 1);
            SHA3_512withDSA = r101;
            SignatureAlgorithm r102 = new SignatureAlgorithm("SHA512withECDSA", 2);
            SHA512withECDSA = r102;
            SignatureAlgorithm r103 = new SignatureAlgorithm("SHA3_512withECDSA", 3);
            SHA3_512withECDSA = r103;
            SignatureAlgorithm r104 = new SignatureAlgorithm("SHA512withRSA", 4);
            SHA512withRSA = r104;
            SignatureAlgorithm r105 = new SignatureAlgorithm("SHA3_512withRSA", 5);
            SHA3_512withRSA = r105;
            $VALUES = new SignatureAlgorithm[]{r100, r101, r102, r103, r104, r105};
        }

        private SignatureAlgorithm(String r100, int r101) {
            super(r100, r101);
        }

        public static SignatureAlgorithm valueOf(String r100) {
            return (SignatureAlgorithm) a.a(SignatureAlgorithm.class, r100);
        }

        public static SignatureAlgorithm[] values() {
            return (SignatureAlgorithm[]) $VALUES.clone();
        }
    }

    private BCFKSLoadStoreParameter(Builder r100) {
        super(Builder.access$100(r100), Builder.access$200(r100), Builder.access$300(r100));
        this.storeConfig = Builder.access$400(r100);
        this.encAlg = Builder.access$500(r100);
        this.macAlg = Builder.access$600(r100);
        this.sigAlg = Builder.access$700(r100);
        this.sigKey = Builder.access$800(r100);
        this.certificates = Builder.access$900(r100);
        this.validator = Builder.access$1000(r100);
    }

    public /* synthetic */ BCFKSLoadStoreParameter(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public CertChainValidator getCertChainValidator() {
        return this.validator;
    }

    public X509Certificate[] getStoreCertificates() {
        return this.certificates;
    }

    public EncryptionAlgorithm getStoreEncryptionAlgorithm() {
        return this.encAlg;
    }

    public MacAlgorithm getStoreMacAlgorithm() {
        return this.macAlg;
    }

    public PBKDFConfig getStorePBKDFConfig() {
        return this.storeConfig;
    }

    public SignatureAlgorithm getStoreSignatureAlgorithm() {
        return this.sigAlg;
    }

    public Key getStoreSignatureKey() {
        return this.sigKey;
    }
}
