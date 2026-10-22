package org.bouncycastle.jcajce.provider.asymmetric;

import com.alipay.sdk.m.n.d;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

/* JADX INFO: loaded from: classes42.dex */
public class RSA {
    private static final String PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.rsa.";
    private static final Map<String, String> generalRsaAttributes = null;

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public Mappings() {
        }

        private void addDigestSignature(ConfigurableProvider r100, String r110, String r111, ASN1ObjectIdentifier r112) {
            String r101 = r110 + "WITHRSA";
            String r102 = r110 + "withRSA";
            String r103 = r110 + "WithRSA";
            String r104 = r110 + "/RSA";
            String r105 = r110 + "WITHRSAENCRYPTION";
            String r106 = r110 + "withRSAEncryption";
            r100.addAlgorithm("Signature." + r101, r111);
            r100.addAlgorithm("Alg.Alias.Signature." + r102, r101);
            r100.addAlgorithm("Alg.Alias.Signature." + r103, r101);
            r100.addAlgorithm("Alg.Alias.Signature." + r105, r101);
            r100.addAlgorithm("Alg.Alias.Signature." + r106, r101);
            r100.addAlgorithm("Alg.Alias.Signature." + (r110 + "WithRSAEncryption"), r101);
            r100.addAlgorithm("Alg.Alias.Signature." + r104, r101);
            if (r112 == null) goto L6;
            r100.addAlgorithm("Alg.Alias.Signature." + r112, r101);
            r100.addAlgorithm("Alg.Alias.Signature.OID." + r112, r101);
            return;
        }

        private void addISO9796Signature(ConfigurableProvider r100, String r101, String r102) {
            r100.addAlgorithm("Alg.Alias.Signature." + r101 + "withRSA/ISO9796-2", r101 + "WITHRSA/ISO9796-2");
            r100.addAlgorithm("Alg.Alias.Signature." + r101 + "WithRSA/ISO9796-2", r101 + "WITHRSA/ISO9796-2");
            r100.addAlgorithm("Signature." + r101 + "WITHRSA/ISO9796-2", r102);
        }

        private void addPSSSignature(ConfigurableProvider r100, String r101, String r102) {
            r100.addAlgorithm("Alg.Alias.Signature." + r101 + "withRSA/PSS", r101 + "WITHRSAANDMGF1");
            r100.addAlgorithm("Alg.Alias.Signature." + r101 + "WithRSA/PSS", r101 + "WITHRSAANDMGF1");
            r100.addAlgorithm("Alg.Alias.Signature." + r101 + "withRSAandMGF1", r101 + "WITHRSAANDMGF1");
            r100.addAlgorithm("Alg.Alias.Signature." + r101 + "WithRSAAndMGF1", r101 + "WITHRSAANDMGF1");
            r100.addAlgorithm("Alg.Alias.Signature." + r101 + "withRSASSA-PSS", r101 + "WITHRSAANDMGF1");
            r100.addAlgorithm("Alg.Alias.Signature." + r101 + "WithRSASSA-PSS", r101 + "WITHRSAANDMGF1");
            r100.addAlgorithm("Alg.Alias.Signature." + r101 + "WITHRSASSA-PSS", r101 + "WITHRSAANDMGF1");
            r100.addAlgorithm("Signature." + r101 + "WITHRSAANDMGF1", r102);
        }

        private void addX931Signature(ConfigurableProvider r100, String r101, String r102) {
            r100.addAlgorithm("Alg.Alias.Signature." + r101 + "withRSA/X9.31", r101 + "WITHRSA/X9.31");
            r100.addAlgorithm("Alg.Alias.Signature." + r101 + "WithRSA/X9.31", r101 + "WITHRSA/X9.31");
            r100.addAlgorithm("Signature." + r101 + "WITHRSA/X9.31", r102);
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r110) {
            r110.addAlgorithm("AlgorithmParameters.OAEP", "org.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$OAEP");
            r110.addAlgorithm("AlgorithmParameters.PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.RSAPSS", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.RSASSA-PSS", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA224withRSA/PSS", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA256withRSA/PSS", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA384withRSA/PSS", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA512withRSA/PSS", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA224WITHRSAANDMGF1", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA256WITHRSAANDMGF1", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA384WITHRSAANDMGF1", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA512WITHRSAANDMGF1", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA3-224WITHRSAANDMGF1", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA3-256WITHRSAANDMGF1", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA3-384WITHRSAANDMGF1", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA3-512WITHRSAANDMGF1", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.RAWRSAPSS", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.NONEWITHRSAPSS", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.NONEWITHRSASSA-PSS", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.NONEWITHRSAANDMGF1", "PSS");
            r110.addAttributes("Cipher.RSA", RSA.access$000());
            r110.addAlgorithm("Cipher.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            r110.addAlgorithm("Cipher.RSA/RAW", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            r110.addAlgorithm("Cipher.RSA/PKCS1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            ASN1ObjectIdentifier r100 = PKCSObjectIdentifiers.rsaEncryption;
            r110.addAlgorithm("Cipher", r100, "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            ASN1ObjectIdentifier r101 = X509ObjectIdentifiers.id_ea_rsa;
            r110.addAlgorithm("Cipher", r101, "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            r110.addAlgorithm("Cipher.RSA/1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PrivateOnly");
            r110.addAlgorithm("Cipher.RSA/2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PublicOnly");
            r110.addAlgorithm("Cipher.RSA/OAEP", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            ASN1ObjectIdentifier r102 = PKCSObjectIdentifiers.id_RSAES_OAEP;
            r110.addAlgorithm("Cipher", r102, "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            r110.addAlgorithm("Cipher.RSA/ISO9796-1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$ISO9796d1Padding");
            r110.addAlgorithm("Alg.Alias.Cipher.RSA//RAW", d.f25615a);
            r110.addAlgorithm("Alg.Alias.Cipher.RSA//NOPADDING", d.f25615a);
            r110.addAlgorithm("Alg.Alias.Cipher.RSA//PKCS1PADDING", "RSA/PKCS1");
            r110.addAlgorithm("Alg.Alias.Cipher.RSA//OAEPPADDING", "RSA/OAEP");
            r110.addAlgorithm("Alg.Alias.Cipher.RSA//ISO9796-1PADDING", "RSA/ISO9796-1");
            r110.addAlgorithm("KeyFactory.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi");
            r110.addAlgorithm("KeyPairGenerator.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyPairGeneratorSpi");
            r110.addAlgorithm("KeyFactory.RSASSA-PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi");
            r110.addAlgorithm("KeyPairGenerator.RSASSA-PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyPairGeneratorSpi$PSS");
            KeyFactorySpi r103 = new KeyFactorySpi();
            registerOid(r110, r100, d.f25615a, r103);
            registerOid(r110, r101, d.f25615a, r103);
            registerOid(r110, r102, d.f25615a, r103);
            ASN1ObjectIdentifier r104 = PKCSObjectIdentifiers.id_RSASSA_PSS;
            registerOid(r110, r104, d.f25615a, r103);
            registerOidAlgorithmParameters(r110, r100, d.f25615a);
            registerOidAlgorithmParameters(r110, r101, d.f25615a);
            registerOidAlgorithmParameters(r110, r102, "OAEP");
            registerOidAlgorithmParameters(r110, r104, "PSS");
            r110.addAlgorithm("Signature.RSASSA-PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            r110.addAlgorithm("Signature." + r104, "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            r110.addAlgorithm("Signature.OID." + r104, "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            r110.addAlgorithm("Signature.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$noneRSA");
            r110.addAlgorithm("Signature.RAWRSASSA-PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$nonePSS");
            r110.addAlgorithm("Alg.Alias.Signature.RAWRSA", d.f25615a);
            r110.addAlgorithm("Alg.Alias.Signature.NONEWITHRSA", d.f25615a);
            r110.addAlgorithm("Alg.Alias.Signature.RAWRSAPSS", "RAWRSASSA-PSS");
            r110.addAlgorithm("Alg.Alias.Signature.NONEWITHRSAPSS", "RAWRSASSA-PSS");
            r110.addAlgorithm("Alg.Alias.Signature.NONEWITHRSASSA-PSS", "RAWRSASSA-PSS");
            r110.addAlgorithm("Alg.Alias.Signature.NONEWITHRSAANDMGF1", "RAWRSASSA-PSS");
            r110.addAlgorithm("Alg.Alias.Signature.RSAPSS", "RSASSA-PSS");
            addPSSSignature(r110, "SHA224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA224withRSA");
            addPSSSignature(r110, "SHA256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA256withRSA");
            addPSSSignature(r110, "SHA384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA384withRSA");
            addPSSSignature(r110, "SHA512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512withRSA");
            addPSSSignature(r110, "SHA512(224)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_224withRSA");
            addPSSSignature(r110, "SHA512(256)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_256withRSA");
            addPSSSignature(r110, "SHA3-224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_224withRSA");
            addPSSSignature(r110, "SHA3-256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_256withRSA");
            addPSSSignature(r110, "SHA3-384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_384withRSA");
            addPSSSignature(r110, "SHA3-512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_512withRSA");
            if (r110.hasAlgorithm("MessageDigest", "MD2") == false) goto L6;
            addDigestSignature(r110, "MD2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD2", PKCSObjectIdentifiers.md2WithRSAEncryption);
        L6:
            if (r110.hasAlgorithm("MessageDigest", "MD4") == false) goto L9;
            addDigestSignature(r110, "MD4", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD4", PKCSObjectIdentifiers.md4WithRSAEncryption);
        L9:
            if (r110.hasAlgorithm("MessageDigest", "MD5") == false) goto L12;
            addDigestSignature(r110, "MD5", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD5", PKCSObjectIdentifiers.md5WithRSAEncryption);
            addISO9796Signature(r110, "MD5", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$MD5WithRSAEncryption");
        L12:
            if (r110.hasAlgorithm("MessageDigest", "SHA1") == false) goto L14;
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA1withRSA/PSS", "PSS");
            r110.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA1WITHRSAANDMGF1", "PSS");
            addPSSSignature(r110, "SHA1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA1withRSA");
            addDigestSignature(r110, "SHA1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA1", PKCSObjectIdentifiers.sha1WithRSAEncryption);
            addISO9796Signature(r110, "SHA1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA1WithRSAEncryption");
            StringBuilder r105 = new StringBuilder("Alg.Alias.Signature.");
            ASN1ObjectIdentifier r106 = OIWObjectIdentifiers.sha1WithRSA;
            r105.append(r106);
            r110.addAlgorithm(r105.toString(), "SHA1WITHRSA");
            r110.addAlgorithm("Alg.Alias.Signature.OID." + r106, "SHA1WITHRSA");
            addX931Signature(r110, "SHA1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA1WithRSAEncryption");
        L14:
            addDigestSignature(r110, "SHA224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA224", PKCSObjectIdentifiers.sha224WithRSAEncryption);
            addDigestSignature(r110, "SHA256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA256", PKCSObjectIdentifiers.sha256WithRSAEncryption);
            addDigestSignature(r110, "SHA384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA384", PKCSObjectIdentifiers.sha384WithRSAEncryption);
            addDigestSignature(r110, "SHA512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512", PKCSObjectIdentifiers.sha512WithRSAEncryption);
            addDigestSignature(r110, "SHA512(224)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_224", PKCSObjectIdentifiers.sha512_224WithRSAEncryption);
            addDigestSignature(r110, "SHA512(256)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_256", PKCSObjectIdentifiers.sha512_256WithRSAEncryption);
            addDigestSignature(r110, "SHA3-224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_224", NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_224);
            addDigestSignature(r110, "SHA3-256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_256", NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_256);
            addDigestSignature(r110, "SHA3-384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_384", NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_384);
            addDigestSignature(r110, "SHA3-512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_512", NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_512);
            addISO9796Signature(r110, "SHA224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA224WithRSAEncryption");
            addISO9796Signature(r110, "SHA256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA256WithRSAEncryption");
            addISO9796Signature(r110, "SHA384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA384WithRSAEncryption");
            addISO9796Signature(r110, "SHA512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512WithRSAEncryption");
            addISO9796Signature(r110, "SHA512(224)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_224WithRSAEncryption");
            addISO9796Signature(r110, "SHA512(256)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_256WithRSAEncryption");
            addX931Signature(r110, "SHA224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA224WithRSAEncryption");
            addX931Signature(r110, "SHA256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA256WithRSAEncryption");
            addX931Signature(r110, "SHA384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA384WithRSAEncryption");
            addX931Signature(r110, "SHA512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512WithRSAEncryption");
            addX931Signature(r110, "SHA512(224)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_224WithRSAEncryption");
            addX931Signature(r110, "SHA512(256)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_256WithRSAEncryption");
            if (r110.hasAlgorithm("MessageDigest", "RIPEMD128") == false) goto L18;
            addDigestSignature(r110, "RIPEMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128);
            addDigestSignature(r110, "RMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", null);
            addX931Signature(r110, "RMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption");
            addX931Signature(r110, "RIPEMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption");
        L18:
            if (r110.hasAlgorithm("MessageDigest", "RIPEMD160") == false) goto L21;
            addDigestSignature(r110, "RIPEMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160);
            addDigestSignature(r110, "RMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", null);
            r110.addAlgorithm("Alg.Alias.Signature.RIPEMD160WithRSA/ISO9796-2", "RIPEMD160withRSA/ISO9796-2");
            r110.addAlgorithm("Signature.RIPEMD160withRSA/ISO9796-2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$RIPEMD160WithRSAEncryption");
            addX931Signature(r110, "RMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption");
            addX931Signature(r110, "RIPEMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption");
        L21:
            if (r110.hasAlgorithm("MessageDigest", "RIPEMD256") == false) goto L24;
            addDigestSignature(r110, "RIPEMD256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256);
            addDigestSignature(r110, "RMD256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", null);
        L24:
            if (r110.hasAlgorithm("MessageDigest", "WHIRLPOOL") == false) goto L27;
            addISO9796Signature(r110, "Whirlpool", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption");
            addISO9796Signature(r110, "WHIRLPOOL", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption");
            addX931Signature(r110, "Whirlpool", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption");
            addX931Signature(r110, "WHIRLPOOL", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption");
            return;
        }
    }

    static {
        HashMap r100 = new HashMap();
        generalRsaAttributes = r100;
        r100.put("SupportedKeyClasses", "javax.crypto.interfaces.RSAPublicKey|javax.crypto.interfaces.RSAPrivateKey");
        r100.put("SupportedKeyFormats", "PKCS#8|X.509");
    }

    public RSA() {
    }

    public static /* synthetic */ Map access$000() {
        return generalRsaAttributes;
    }
}
