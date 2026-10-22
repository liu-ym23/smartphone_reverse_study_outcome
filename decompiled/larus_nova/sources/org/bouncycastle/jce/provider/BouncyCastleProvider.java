package org.bouncycastle.jce.provider;

import com.alipay.sdk.m.n.d;
import com.bytedance.crypto.utils.CryptoConst;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.symmetric.util.ClassUtil;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.jcajce.provider.lms.LMSKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.newhope.NHKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.qtesla.QTESLAKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.xmss.XMSSKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTKeyFactorySpi;

/* JADX INFO: loaded from: classes42.dex */
public final class BouncyCastleProvider extends Provider implements ConfigurableProvider {
    private static final String[] ASYMMETRIC_CIPHERS = null;
    private static final String[] ASYMMETRIC_GENERIC = null;
    private static final String ASYMMETRIC_PACKAGE = "org.bouncycastle.jcajce.provider.asymmetric.";
    public static final ProviderConfiguration CONFIGURATION = null;
    private static final String[] DIGESTS = null;
    private static final String DIGEST_PACKAGE = "org.bouncycastle.jcajce.provider.digest.";
    private static final String[] KEYSTORES = null;
    private static final String KEYSTORE_PACKAGE = "org.bouncycastle.jcajce.provider.keystore.";
    public static final String PROVIDER_NAME = "BC";
    private static final String[] SECURE_RANDOMS = null;
    private static final String SECURE_RANDOM_PACKAGE = "org.bouncycastle.jcajce.provider.drbg.";
    private static final String[] SYMMETRIC_CIPHERS = null;
    private static final String[] SYMMETRIC_GENERIC = null;
    private static final String[] SYMMETRIC_MACS = null;
    private static final String SYMMETRIC_PACKAGE = "org.bouncycastle.jcajce.provider.symmetric.";
    private static String info = "BouncyCastle Security Provider v1.68";
    private static final Map keyInfoConverters = null;
    private static final Class revChkClass = null;

    static {
        CONFIGURATION = new BouncyCastleProviderConfiguration();
        keyInfoConverters = new HashMap();
        revChkClass = ClassUtil.loadClass(BouncyCastleProvider.class, "java.security.cert.PKIXRevocationChecker");
        SYMMETRIC_GENERIC = new String[]{"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT"};
        SYMMETRIC_MACS = new String[]{"SipHash", "SipHash128", "Poly1305"};
        SYMMETRIC_CIPHERS = new String[]{CryptoConst.ALGORITHM_AES, "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624", "GOST3412_2015", "Zuc"};
        ASYMMETRIC_GENERIC = new String[]{"X509", "IES", "COMPOSITE"};
        ASYMMETRIC_CIPHERS = new String[]{"DSA", "DH", CryptoConst.ALGORITHM_EC, d.f25615a, "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC"};
        DIGESTS = new String[]{"GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564", "Haraka"};
        KEYSTORES = new String[]{"BC", "BCFKS", "PKCS12"};
        SECURE_RANDOMS = new String[]{"DRBG"};
    }

    public BouncyCastleProvider() {
        super("BC", 1.68d, info);
        AccessController.doPrivileged(new AnonymousClass1(this));
    }

    public static /* synthetic */ void access$000(BouncyCastleProvider r100) {
        r100.setup();
    }

    private static AsymmetricKeyInfoConverter getAsymmetricKeyInfoConverter(ASN1ObjectIdentifier r100) {
        Map r101 = keyInfoConverters;
        monitor-enter(r101);
        AsymmetricKeyInfoConverter r102 = (AsymmetricKeyInfoConverter) r101.get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static PrivateKey getPrivateKey(PrivateKeyInfo r100) throws IOException {
        AsymmetricKeyInfoConverter r101 = getAsymmetricKeyInfoConverter(r100.getPrivateKeyAlgorithm().getAlgorithm());
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.generatePrivate(r100);
    }

    public static PublicKey getPublicKey(SubjectPublicKeyInfo r100) throws IOException {
        AsymmetricKeyInfoConverter r101 = getAsymmetricKeyInfoConverter(r100.getAlgorithm().getAlgorithm());
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.generatePublic(r100);
    }

    private void loadAlgorithms(String r100, String[] r101) {
        int r102 = 0;
    L4:
        if (r102 == r101.length) goto L13;
        Class r103 = ClassUtil.loadClass(BouncyCastleProvider.class, r100 + r101[r102] + "$Mappings");
        if (r103 == null) goto L12;
        ((AlgorithmProvider) r103.newInstance()).configure(this);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        throw new InternalError("cannot create instance of " + r100 + r101[r102] + "$Mappings : " + e);
    L12:
        r102 = r102 + 1;
        goto L4
    }

    private void loadPQCKeys() {
        addKeyInfoConverter(PQCObjectIdentifiers.sphincs256, new Sphincs256KeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.newHope, new NHKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.xmss, new XMSSKeyFactorySpi());
        addKeyInfoConverter(IsaraObjectIdentifiers.id_alg_xmss, new XMSSKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.xmss_mt, new XMSSMTKeyFactorySpi());
        addKeyInfoConverter(IsaraObjectIdentifiers.id_alg_xmssmt, new XMSSMTKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.mcEliece, new McElieceKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.mcElieceCca2, new McElieceCCA2KeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.rainbow, new RainbowKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.qTESLA_p_I, new QTESLAKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.qTESLA_p_III, new QTESLAKeyFactorySpi());
        addKeyInfoConverter(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig, new LMSKeyFactorySpi());
    }

    private void setup() {
        loadAlgorithms(DIGEST_PACKAGE, DIGESTS);
        loadAlgorithms(SYMMETRIC_PACKAGE, SYMMETRIC_GENERIC);
        loadAlgorithms(SYMMETRIC_PACKAGE, SYMMETRIC_MACS);
        loadAlgorithms(SYMMETRIC_PACKAGE, SYMMETRIC_CIPHERS);
        loadAlgorithms(ASYMMETRIC_PACKAGE, ASYMMETRIC_GENERIC);
        loadAlgorithms(ASYMMETRIC_PACKAGE, ASYMMETRIC_CIPHERS);
        loadAlgorithms(KEYSTORE_PACKAGE, KEYSTORES);
        loadAlgorithms(SECURE_RANDOM_PACKAGE, SECURE_RANDOMS);
        loadPQCKeys();
        put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
        put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
        put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
        put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
        put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
        put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
        put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
        put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
        put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
        put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
        put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
        put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
        put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        Class r100 = revChkClass;
        put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        if (r100 == null) goto L5;
        String r101 = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8";
        put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8");
        String r102 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi_8";
    L6:
        put("CertPathBuilder.RFC3280", r102);
        put("CertPathValidator.PKIX", r101);
        put("CertPathBuilder.PKIX", r102);
        put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
        put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
        put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
        put("Alg.Alias.CertStore.X509LDAP", "LDAP");
        return;
    L5:
        r101 = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi";
        put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
        r102 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi";
        goto L6
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addAlgorithm(String r100, String r101) {
        if (containsKey(r100) == true) goto L7;
        put(r100, r101);
        return;
    L7:
        throw new IllegalStateException("duplicate provider key (" + r100 + ") found");
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addAlgorithm(String r100, ASN1ObjectIdentifier r101, String r102) {
        addAlgorithm(r100 + "." + r101, r102);
        addAlgorithm(r100 + ".OID." + r101, r102);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addAttributes(String r100, Map<String, String> r101) {
        Iterator<String> r102 = r101.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        String r104 = r100 + " " + r103;
        if (containsKey(r104) == true) goto L9;
        put(r104, r101.get(r103));
        goto L4
    L9:
        throw new IllegalStateException("duplicate provider attribute key (" + r104 + ") found");
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addKeyInfoConverter(ASN1ObjectIdentifier r100, AsymmetricKeyInfoConverter r101) {
        Map r102 = keyInfoConverters;
        monitor-enter(r102);
        r102.put(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public AsymmetricKeyInfoConverter getKeyInfoConverter(ASN1ObjectIdentifier r100) {
        return (AsymmetricKeyInfoConverter) keyInfoConverters.get(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public boolean hasAlgorithm(String r100, String r101) {
        if (containsKey(r100 + "." + r101) == false) goto L5;
    L8:
        return true;
    L5:
        if (containsKey("Alg.Alias." + r100 + "." + r101) == true) goto L8;
        return false;
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void setParameter(String r100, Object r101) {
        ProviderConfiguration r102 = CONFIGURATION;
        monitor-enter(r102);
        ((BouncyCastleProviderConfiguration) r102).setParameter(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
