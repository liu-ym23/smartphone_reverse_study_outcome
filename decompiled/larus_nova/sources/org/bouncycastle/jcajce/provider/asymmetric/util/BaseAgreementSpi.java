package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.gnu.GNUObjectIdentifiers;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.agreement.kdf.DHKDFParameters;
import org.bouncycastle.crypto.agreement.kdf.DHKEKGenerator;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public abstract class BaseAgreementSpi extends KeyAgreementSpi {
    private static final Map<String, ASN1ObjectIdentifier> defaultOids = null;
    private static final Hashtable des = null;
    private static final Map<String, Integer> keySizes = null;
    private static final Map<String, String> nameTable = null;
    private static final Hashtable oids = null;
    protected final String kaAlgorithm;
    protected final DerivationFunction kdf;
    protected byte[] ukmParameters;

    static {
        HashMap r100 = new HashMap();
        defaultOids = r100;
        HashMap r101 = new HashMap();
        keySizes = r101;
        HashMap r102 = new HashMap();
        nameTable = r102;
        Hashtable r103 = new Hashtable();
        oids = r103;
        Hashtable r104 = new Hashtable();
        des = r104;
        Integer r105 = Integers.valueOf(64);
        Integer r106 = Integers.valueOf(128);
        Integer r107 = Integers.valueOf(192);
        Integer r108 = Integers.valueOf(256);
        r101.put("DES", r105);
        r101.put("DESEDE", r107);
        r101.put("BLOWFISH", r106);
        r101.put(CryptoConst.ALGORITHM_AES, r108);
        r101.put(NISTObjectIdentifiers.id_aes128_ECB.getId(), r106);
        r101.put(NISTObjectIdentifiers.id_aes192_ECB.getId(), r107);
        r101.put(NISTObjectIdentifiers.id_aes256_ECB.getId(), r108);
        r101.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), r106);
        r101.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), r107);
        ASN1ObjectIdentifier r110 = NISTObjectIdentifiers.id_aes256_CBC;
        r101.put(r110.getId(), r108);
        r101.put(NISTObjectIdentifiers.id_aes128_CFB.getId(), r106);
        r101.put(NISTObjectIdentifiers.id_aes192_CFB.getId(), r107);
        r101.put(NISTObjectIdentifiers.id_aes256_CFB.getId(), r108);
        r101.put(NISTObjectIdentifiers.id_aes128_OFB.getId(), r106);
        r101.put(NISTObjectIdentifiers.id_aes192_OFB.getId(), r107);
        r101.put(NISTObjectIdentifiers.id_aes256_OFB.getId(), r108);
        ASN1ObjectIdentifier r111 = NISTObjectIdentifiers.id_aes128_wrap;
        r101.put(r111.getId(), r106);
        r101.put(NISTObjectIdentifiers.id_aes192_wrap.getId(), r107);
        r101.put(NISTObjectIdentifiers.id_aes256_wrap.getId(), r108);
        ASN1ObjectIdentifier r112 = NISTObjectIdentifiers.id_aes128_CCM;
        r101.put(r112.getId(), r106);
        r101.put(NISTObjectIdentifiers.id_aes192_CCM.getId(), r107);
        r101.put(NISTObjectIdentifiers.id_aes256_CCM.getId(), r108);
        r101.put(NISTObjectIdentifiers.id_aes128_GCM.getId(), r106);
        r101.put(NISTObjectIdentifiers.id_aes192_GCM.getId(), r107);
        r101.put(NISTObjectIdentifiers.id_aes256_GCM.getId(), r108);
        ASN1ObjectIdentifier r113 = NTTObjectIdentifiers.id_camellia128_wrap;
        r101.put(r113.getId(), r106);
        ASN1ObjectIdentifier r109 = NTTObjectIdentifiers.id_camellia192_wrap;
        r101.put(r109.getId(), r107);
        ASN1ObjectIdentifier r114 = NTTObjectIdentifiers.id_camellia256_wrap;
        r101.put(r114.getId(), r108);
        ASN1ObjectIdentifier r115 = KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap;
        r101.put(r115.getId(), r106);
        ASN1ObjectIdentifier r116 = PKCSObjectIdentifiers.id_alg_CMS3DESwrap;
        r101.put(r116.getId(), r107);
        ASN1ObjectIdentifier r117 = PKCSObjectIdentifiers.des_EDE3_CBC;
        r101.put(r117.getId(), r107);
        ASN1ObjectIdentifier r118 = OIWObjectIdentifiers.desCBC;
        r101.put(r118.getId(), r105);
        ASN1ObjectIdentifier r119 = CryptoProObjectIdentifiers.gostR28147_gcfb;
        r101.put(r119.getId(), r108);
        r101.put(CryptoProObjectIdentifiers.id_Gost28147_89_None_KeyWrap.getId(), r108);
        r101.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap.getId(), r108);
        ASN1ObjectIdentifier r120 = PKCSObjectIdentifiers.id_hmacWithSHA1;
        r101.put(r120.getId(), Integers.valueOf(160));
        ASN1ObjectIdentifier r121 = PKCSObjectIdentifiers.id_hmacWithSHA256;
        r101.put(r121.getId(), r108);
        ASN1ObjectIdentifier r122 = PKCSObjectIdentifiers.id_hmacWithSHA384;
        r101.put(r122.getId(), Integers.valueOf(384));
        ASN1ObjectIdentifier r123 = PKCSObjectIdentifiers.id_hmacWithSHA512;
        r101.put(r123.getId(), Integers.valueOf(512));
        r100.put("DESEDE", r117);
        r100.put(CryptoConst.ALGORITHM_AES, r110);
        ASN1ObjectIdentifier r124 = NTTObjectIdentifiers.id_camellia256_cbc;
        r100.put("CAMELLIA", r124);
        ASN1ObjectIdentifier r125 = KISAObjectIdentifiers.id_seedCBC;
        r100.put("SEED", r125);
        r100.put("DES", r118);
        r102.put(MiscObjectIdentifiers.cast5CBC.getId(), "CAST5");
        r102.put(MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC.getId(), "IDEA");
        r102.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_ECB.getId(), "Blowfish");
        r102.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CBC.getId(), "Blowfish");
        r102.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CFB.getId(), "Blowfish");
        r102.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_OFB.getId(), "Blowfish");
        r102.put(OIWObjectIdentifiers.desECB.getId(), "DES");
        r102.put(r118.getId(), "DES");
        r102.put(OIWObjectIdentifiers.desCFB.getId(), "DES");
        r102.put(OIWObjectIdentifiers.desOFB.getId(), "DES");
        r102.put(OIWObjectIdentifiers.desEDE.getId(), "DESede");
        r102.put(r117.getId(), "DESede");
        r102.put(r116.getId(), "DESede");
        r102.put(PKCSObjectIdentifiers.id_alg_CMSRC2wrap.getId(), "RC2");
        r102.put(r120.getId(), "HmacSHA1");
        r102.put(PKCSObjectIdentifiers.id_hmacWithSHA224.getId(), "HmacSHA224");
        r102.put(r121.getId(), "HmacSHA256");
        r102.put(r122.getId(), "HmacSHA384");
        r102.put(r123.getId(), "HmacSHA512");
        r102.put(NTTObjectIdentifiers.id_camellia128_cbc.getId(), "Camellia");
        r102.put(NTTObjectIdentifiers.id_camellia192_cbc.getId(), "Camellia");
        r102.put(r124.getId(), "Camellia");
        r102.put(r113.getId(), "Camellia");
        r102.put(r109.getId(), "Camellia");
        r102.put(r114.getId(), "Camellia");
        r102.put(r115.getId(), "SEED");
        r102.put(r125.getId(), "SEED");
        r102.put(KISAObjectIdentifiers.id_seedMAC.getId(), "SEED");
        r102.put(r119.getId(), "GOST28147");
        r102.put(r111.getId(), CryptoConst.ALGORITHM_AES);
        r102.put(r112.getId(), CryptoConst.ALGORITHM_AES);
        r102.put(r112.getId(), CryptoConst.ALGORITHM_AES);
        r103.put("DESEDE", r117);
        r103.put(CryptoConst.ALGORITHM_AES, r110);
        r103.put("DES", r118);
        r104.put("DES", "DES");
        r104.put("DESEDE", "DES");
        r104.put(r118.getId(), "DES");
        r104.put(r117.getId(), "DES");
        r104.put(r116.getId(), "DES");
    }

    public BaseAgreementSpi(String r100, DerivationFunction r101) {
        this.kaAlgorithm = r100;
        this.kdf = r101;
    }

    public static String getAlgorithm(String r100) {
        if (r100.indexOf(91) <= 0) goto L7;
        return r100.substring(0, r100.indexOf(91));
    L7:
        if (r100.startsWith(NISTObjectIdentifiers.aes.getId()) == false) goto L11;
        return CryptoConst.ALGORITHM_AES;
    L11:
        if (r100.startsWith(GNUObjectIdentifiers.Serpent.getId()) == false) goto L14;
        return "Serpent";
    L14:
        String r101 = nameTable.get(Strings.toUpperCase(r100));
        if (r101 == null) goto L17;
        return r101;
    L17:
        return r100;
    }

    public static int getKeySize(String r100) {
        if (r100.indexOf(91) > 0) goto L5;
        String r101 = Strings.toUpperCase(r100);
        Map<String, Integer> r102 = keySizes;
        if (r102.containsKey(r101) == true) goto L11;
        return -1;
    L11:
        return r102.get(r101).intValue();
    L5:
        return CastIntegerProtector.parseInt(r100.substring(r100.indexOf(91) + 1, r100.indexOf(93)));
    }

    private byte[] getSharedSecretBytes(byte[] r100, String r101, int r102) throws NoSuchAlgorithmException {
        DerivationFunction r103 = this.kdf;
        if (r103 == null) goto L19;
        if (r102 < 0) goto L18;
        int r104 = r102 / 8;
        byte[] r105 = new byte[r104];
        if ((r103 instanceof DHKEKGenerator) == false) goto L14;
        if (r101 == null) goto L13;
        DerivationParameters r106 = new DHKDFParameters(new ASN1ObjectIdentifier(r101), r102, r100, this.ukmParameters);
    L15:
        this.kdf.init(r106);
        this.kdf.generateBytes(r105, 0, r104);
        Arrays.clear(r100);
        return r105;
    L11:
        throw new NoSuchAlgorithmException("no OID for algorithm: ".concat(r101));
    L13:
        throw new NoSuchAlgorithmException("algorithm OID is null");
    L14:
        r106 = new KDFParameters(r100, this.ukmParameters);
        goto L15
    L18:
        throw new NoSuchAlgorithmException("unknown algorithm encountered: " + r101);
    L19:
        if (r102 <= 0) goto L22;
        int r107 = r102 / 8;
        byte[] r108 = new byte[r107];
        System.arraycopy(r100, 0, r108, 0, r107);
        Arrays.clear(r100);
        return r108;
    L22:
        return r100;
    }

    public static byte[] trimZeroes(byte[] r100) {
        if (r100[0] == 0) goto L5;
        return r100;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= r100.length) goto L11;
        if (r100[r101] != 0) goto L11;
        r101 = r101 + 1;
    L11:
        int r102 = r100.length - r101;
        byte[] r103 = new byte[r102];
        System.arraycopy(r100, r101, r103, 0, r102);
        return r103;
    }

    public abstract byte[] calcSecret();

    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] r100, int r101) throws IllegalStateException, ShortBufferException {
        byte[] r102 = engineGenerateSecret();
        if ((r100.length - r101) < r102.length) goto L7;
        System.arraycopy(r102, 0, r100, r101, r102.length);
        return r102.length;
    L7:
        throw new ShortBufferException(this.kaAlgorithm + " key agreement: need " + r102.length + " bytes");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String r100) throws NoSuchAlgorithmException {
        String r101 = Strings.toUpperCase(r100);
        Hashtable r102 = oids;
        if (r102.containsKey(r101) == false) goto L5;
        String r103 = ((ASN1ObjectIdentifier) r102.get(r101)).getId();
    L6:
        int r104 = getKeySize(r103);
        byte[] r105 = getSharedSecretBytes(calcSecret(), r103, r104);
        String r106 = getAlgorithm(r100);
        if (des.containsKey(r106) == false) goto L10;
        DESParameters.setOddParity(r105);
    L10:
        return new SecretKeySpec(r105, r106);
    L5:
        r103 = r100;
        goto L6
    }

    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.kdf == null) goto L11;
        byte[] r100 = calcSecret();
        return getSharedSecretBytes(r100, null, r100.length * 8);
    L7:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());
    L11:
        return calcSecret();
    }
}
