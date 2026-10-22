package org.bouncycastle.x509;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.security.auth.x500.X500Principal;
import me.ele.lancet.base.annotations.Skip;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
class X509Util {
    private static Hashtable algorithms;
    private static Set noParams;
    private static Hashtable params;

    public static class Implementation {
        Object engine;
        Provider provider;

        public Implementation(Object r100, Provider r101) {
            this.engine = r100;
            this.provider = r101;
        }

        public Object getEngine() {
            return this.engine;
        }

        public Provider getProvider() {
            return this.provider;
        }
    }

    static {
        algorithms = new Hashtable();
        params = new Hashtable();
        noParams = new HashSet();
        Hashtable r100 = algorithms;
        ASN1ObjectIdentifier r101 = PKCSObjectIdentifiers.md2WithRSAEncryption;
        r100.put("MD2WITHRSAENCRYPTION", r101);
        algorithms.put("MD2WITHRSA", r101);
        Hashtable r102 = algorithms;
        ASN1ObjectIdentifier r103 = PKCSObjectIdentifiers.md5WithRSAEncryption;
        r102.put("MD5WITHRSAENCRYPTION", r103);
        algorithms.put("MD5WITHRSA", r103);
        Hashtable r104 = algorithms;
        ASN1ObjectIdentifier r105 = PKCSObjectIdentifiers.sha1WithRSAEncryption;
        r104.put("SHA1WITHRSAENCRYPTION", r105);
        algorithms.put("SHA1WITHRSA", r105);
        Hashtable r106 = algorithms;
        ASN1ObjectIdentifier r107 = PKCSObjectIdentifiers.sha224WithRSAEncryption;
        r106.put("SHA224WITHRSAENCRYPTION", r107);
        algorithms.put("SHA224WITHRSA", r107);
        Hashtable r108 = algorithms;
        ASN1ObjectIdentifier r109 = PKCSObjectIdentifiers.sha256WithRSAEncryption;
        r108.put("SHA256WITHRSAENCRYPTION", r109);
        algorithms.put("SHA256WITHRSA", r109);
        Hashtable r110 = algorithms;
        ASN1ObjectIdentifier r111 = PKCSObjectIdentifiers.sha384WithRSAEncryption;
        r110.put("SHA384WITHRSAENCRYPTION", r111);
        algorithms.put("SHA384WITHRSA", r111);
        Hashtable r112 = algorithms;
        ASN1ObjectIdentifier r113 = PKCSObjectIdentifiers.sha512WithRSAEncryption;
        r112.put("SHA512WITHRSAENCRYPTION", r113);
        algorithms.put("SHA512WITHRSA", r113);
        Hashtable r114 = algorithms;
        ASN1ObjectIdentifier r115 = PKCSObjectIdentifiers.id_RSASSA_PSS;
        r114.put("SHA1WITHRSAANDMGF1", r115);
        algorithms.put("SHA224WITHRSAANDMGF1", r115);
        algorithms.put("SHA256WITHRSAANDMGF1", r115);
        algorithms.put("SHA384WITHRSAANDMGF1", r115);
        algorithms.put("SHA512WITHRSAANDMGF1", r115);
        Hashtable r116 = algorithms;
        ASN1ObjectIdentifier r117 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160;
        r116.put("RIPEMD160WITHRSAENCRYPTION", r117);
        algorithms.put("RIPEMD160WITHRSA", r117);
        Hashtable r118 = algorithms;
        ASN1ObjectIdentifier r119 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128;
        r118.put("RIPEMD128WITHRSAENCRYPTION", r119);
        algorithms.put("RIPEMD128WITHRSA", r119);
        Hashtable r120 = algorithms;
        ASN1ObjectIdentifier r121 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256;
        r120.put("RIPEMD256WITHRSAENCRYPTION", r121);
        algorithms.put("RIPEMD256WITHRSA", r121);
        Hashtable r122 = algorithms;
        ASN1ObjectIdentifier r123 = X9ObjectIdentifiers.id_dsa_with_sha1;
        r122.put("SHA1WITHDSA", r123);
        algorithms.put("DSAWITHSHA1", r123);
        Hashtable r124 = algorithms;
        ASN1ObjectIdentifier r125 = NISTObjectIdentifiers.dsa_with_sha224;
        r124.put("SHA224WITHDSA", r125);
        Hashtable r126 = algorithms;
        ASN1ObjectIdentifier r127 = NISTObjectIdentifiers.dsa_with_sha256;
        r126.put("SHA256WITHDSA", r127);
        Hashtable r128 = algorithms;
        ASN1ObjectIdentifier r129 = NISTObjectIdentifiers.dsa_with_sha384;
        r128.put("SHA384WITHDSA", r129);
        Hashtable r130 = algorithms;
        ASN1ObjectIdentifier r131 = NISTObjectIdentifiers.dsa_with_sha512;
        r130.put("SHA512WITHDSA", r131);
        Hashtable r132 = algorithms;
        ASN1ObjectIdentifier r133 = X9ObjectIdentifiers.ecdsa_with_SHA1;
        r132.put("SHA1WITHECDSA", r133);
        algorithms.put("ECDSAWITHSHA1", r133);
        Hashtable r134 = algorithms;
        ASN1ObjectIdentifier r135 = X9ObjectIdentifiers.ecdsa_with_SHA224;
        r134.put("SHA224WITHECDSA", r135);
        Hashtable r136 = algorithms;
        ASN1ObjectIdentifier r137 = X9ObjectIdentifiers.ecdsa_with_SHA256;
        r136.put("SHA256WITHECDSA", r137);
        Hashtable r138 = algorithms;
        ASN1ObjectIdentifier r139 = X9ObjectIdentifiers.ecdsa_with_SHA384;
        r138.put("SHA384WITHECDSA", r139);
        Hashtable r140 = algorithms;
        ASN1ObjectIdentifier r141 = X9ObjectIdentifiers.ecdsa_with_SHA512;
        r140.put("SHA512WITHECDSA", r141);
        Hashtable r142 = algorithms;
        ASN1ObjectIdentifier r143 = CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94;
        r142.put("GOST3411WITHGOST3410", r143);
        algorithms.put("GOST3411WITHGOST3410-94", r143);
        Hashtable r144 = algorithms;
        ASN1ObjectIdentifier r145 = CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001;
        r144.put("GOST3411WITHECGOST3410", r145);
        algorithms.put("GOST3411WITHECGOST3410-2001", r145);
        algorithms.put("GOST3411WITHGOST3410-2001", r145);
        noParams.add(r133);
        noParams.add(r135);
        noParams.add(r137);
        noParams.add(r139);
        noParams.add(r141);
        noParams.add(r123);
        noParams.add(OIWObjectIdentifiers.dsaWithSHA1);
        noParams.add(r125);
        noParams.add(r127);
        noParams.add(r129);
        noParams.add(r131);
        noParams.add(r143);
        noParams.add(r145);
        ASN1ObjectIdentifier r146 = OIWObjectIdentifiers.idSHA1;
        DERNull r147 = DERNull.INSTANCE;
        AlgorithmIdentifier r148 = new AlgorithmIdentifier(r146, r147);
        params.put("SHA1WITHRSAANDMGF1", creatPSSParams(r148, 20));
        AlgorithmIdentifier r149 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, r147);
        params.put("SHA224WITHRSAANDMGF1", creatPSSParams(r149, 28));
        AlgorithmIdentifier r150 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, r147);
        params.put("SHA256WITHRSAANDMGF1", creatPSSParams(r150, 32));
        AlgorithmIdentifier r151 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, r147);
        params.put("SHA384WITHRSAANDMGF1", creatPSSParams(r151, 48));
        AlgorithmIdentifier r152 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, r147);
        params.put("SHA512WITHRSAANDMGF1", creatPSSParams(r152, 64));
    }

    public X509Util() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static byte[] calculateSignature(ASN1ObjectIdentifier r100, String r101, String r102, PrivateKey r103, SecureRandom r104, ASN1Encodable r105) throws IOException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        if (r100 == null) goto L10;
        Signature r106 = getSignatureInstance(r101, r102);
        if (r104 == null) goto L6;
        r106.initSign(r103, r104);
    L7:
        r106.update(r105.toASN1Primitive().getEncoded(ASN1Encoding.DER));
        return r106.sign();
    L6:
        r106.initSign(r103);
        goto L7
    L10:
        throw new IllegalStateException("no signature algorithm specified");
    }

    public static byte[] calculateSignature(ASN1ObjectIdentifier r100, String r101, PrivateKey r102, SecureRandom r103, ASN1Encodable r104) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        if (r100 == null) goto L10;
        Signature r105 = getSignatureInstance(r101);
        if (r103 == null) goto L6;
        r105.initSign(r102, r103);
    L7:
        r105.update(r104.toASN1Primitive().getEncoded(ASN1Encoding.DER));
        return r105.sign();
    L6:
        r105.initSign(r102);
        goto L7
    L10:
        throw new IllegalStateException("no signature algorithm specified");
    }

    public static X509Principal convertPrincipal(X500Principal r100) {
        return new X509Principal(r100.getEncoded());
    L5:
        throw new IllegalArgumentException("cannot convert principal");
    }

    private static RSASSAPSSparams creatPSSParams(AlgorithmIdentifier r100, int r101) {
        return new RSASSAPSSparams(r100, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, r100), new ASN1Integer(r101), new ASN1Integer(1));
    }

    public static Iterator getAlgNames() {
        Enumeration r100 = algorithms.keys();
        ArrayList r101 = new ArrayList();
    L4:
        if (r100.hasMoreElements() == false) goto L7;
        r101.add(r100.nextElement());
        goto L4
    L7:
        return r101.iterator();
    }

    public static ASN1ObjectIdentifier getAlgorithmOID(String r100) {
        String r101 = Strings.toUpperCase(r100);
        if (algorithms.containsKey(r101) == false) goto L7;
        return (ASN1ObjectIdentifier) algorithms.get(r101);
    L7:
        return new ASN1ObjectIdentifier(r101);
    }

    public static Implementation getImplementation(String r100, String r101) throws NoSuchAlgorithmException {
        Provider[] r102 = Security.getProviders();
        int r103 = 0;
    L4:
        if (r103 == r102.length) goto L11;
        Implementation r104 = getImplementation(r100, Strings.toUpperCase(r101), r102[r103]);
        if (r104 != null) goto L7;
        getImplementation(r100, r101, r102[r103]);     // Catch: NoSuchAlgorithmException -> L12
    L9:
        r103 = r103 + 1;
        goto L4
    L7:
        return r104;
    L11:
        throw new NoSuchAlgorithmException("cannot find implementation " + r101);
    }

    public static Implementation getImplementation(String r100, String r101, Provider r102) throws NoSuchAlgorithmException {
        String r103 = Strings.toUpperCase(r101);
    L3:
        String r104 = r102.getProperty("Alg.Alias." + r100 + "." + r103);
        if (r104 == null) goto L6;
        r103 = r104;
        goto L3
    L6:
        String r105 = r102.getProperty(r100 + "." + r103);
        if (r105 == null) goto L19;
        ClassLoader r106 = r102.getClass().getClassLoader();     // Catch: Exception -> L14 ClassNotFoundException -> L16
        if (r106 == null) goto L11;
        Class r107 = INVOKEVIRTUAL_org_bouncycastle_x509_X509Util_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r106, r105);     // Catch: Exception -> L14 ClassNotFoundException -> L16
    L12:
        return new Implementation(r107.newInstance(), r102);
    L11:
        r107 = INVOKESTATIC_org_bouncycastle_x509_X509Util_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r105);     // Catch: Exception -> L14 ClassNotFoundException -> L16
    L17:
        throw new IllegalStateException("algorithm " + r103 + " in provider " + r102.getName() + " but no class \"" + r105 + "\" found!");
    L15:
        throw new IllegalStateException("algorithm " + r103 + " in provider " + r102.getName() + " but class \"" + r105 + "\" inaccessible!");
    L19:
        throw new NoSuchAlgorithmException("cannot find implementation " + r103 + " for provider " + r102.getName());
    }

    public static Provider getProvider(String r100) throws NoSuchProviderException {
        Provider r101 = Security.getProvider(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new NoSuchProviderException("Provider " + r100 + " not found");
    }

    public static AlgorithmIdentifier getSigAlgID(ASN1ObjectIdentifier r100, String r101) {
        if (noParams.contains(r100) == true) goto L5;
        String r102 = Strings.toUpperCase(r101);
        if (params.containsKey(r102) == false) goto L11;
        return new AlgorithmIdentifier(r100, (ASN1Encodable) params.get(r102));
    L11:
        return new AlgorithmIdentifier(r100, DERNull.INSTANCE);
    L5:
        return new AlgorithmIdentifier(r100);
    }

    public static Signature getSignatureInstance(String r100) throws NoSuchAlgorithmException {
        return Signature.getInstance(r100);
    }

    public static Signature getSignatureInstance(String r100, String r101) throws NoSuchProviderException, NoSuchAlgorithmException {
        if (r101 == null) goto L6;
        return Signature.getInstance(r100, r101);
    L6:
        return Signature.getInstance(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_org_bouncycastle_x509_X509Util_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_org_bouncycastle_x509_X509Util_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }
}
