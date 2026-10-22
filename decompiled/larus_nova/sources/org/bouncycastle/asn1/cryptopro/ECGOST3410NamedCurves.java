package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WNafUtil;

/* JADX INFO: loaded from: classes42.dex */
public class ECGOST3410NamedCurves {
    static final Hashtable names = null;
    static final Hashtable objIds = null;
    static final Hashtable params = null;

    static {
        Hashtable r100 = new Hashtable();
        objIds = r100;
        Hashtable r101 = new Hashtable();
        params = r101;
        Hashtable r102 = new Hashtable();
        names = r102;
        BigInteger r103 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger r110 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        BigInteger r104 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316");
        BigInteger r105 = new BigInteger("166");
        BigInteger r111 = ECConstants.ONE;
        ECCurve r106 = configureCurve(new ECCurve.Fp(r103, r104, r105, r110, r111));
        ECDomainParameters r107 = new ECDomainParameters(r106, configureBasepoint(r106, new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612")), r110, r111);
        ASN1ObjectIdentifier r108 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A;
        r101.put(r108, r107);
        BigInteger r109 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger r112 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        ECCurve r113 = configureCurve(new ECCurve.Fp(r109, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"), r112, r111));
        ECDomainParameters r114 = new ECDomainParameters(r113, configureBasepoint(r113, new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612")), r112, r111);
        ASN1ObjectIdentifier r115 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA;
        r101.put(r115, r114);
        BigInteger r116 = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823193");
        BigInteger r117 = new BigInteger("57896044618658097711785492504343953927102133160255826820068844496087732066703");
        ECCurve r118 = configureCurve(new ECCurve.Fp(r116, new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823190"), new BigInteger("28091019353058090096996979000309560759124368558014865957655842872397301267595"), r117, r111));
        ECDomainParameters r119 = new ECDomainParameters(r118, configureBasepoint(r118, new BigInteger("1"), new BigInteger("28792665814854611296992347458380284135028636778229113005756334730996303888124")), r117, r111);
        ASN1ObjectIdentifier r120 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B;
        r101.put(r120, r119);
        BigInteger r121 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        BigInteger r122 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        ECCurve r123 = configureCurve(new ECCurve.Fp(r121, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), r122, r111));
        ECDomainParameters r124 = new ECDomainParameters(r123, configureBasepoint(r123, new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247")), r122, r111);
        ASN1ObjectIdentifier r125 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB;
        r101.put(r125, r124);
        BigInteger r126 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        BigInteger r127 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        ECCurve r128 = configureCurve(new ECCurve.Fp(r126, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), r127, r111));
        ECDomainParameters r129 = new ECDomainParameters(r128, configureBasepoint(r128, new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247")), r127, r111);
        ASN1ObjectIdentifier r130 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C;
        r101.put(r130, r129);
        BigInteger r131 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD97", 16);
        BigInteger r132 = new BigInteger("400000000000000000000000000000000FD8CDDFC87B6635C115AF556C360C67", 16);
        BigInteger r133 = new BigInteger("C2173F1513981673AF4892C23035A27CE25E2013BF95AA33B22C656F277E7335", 16);
        BigInteger r134 = new BigInteger("295F9BAE7428ED9CCC20E7C359A9D41A22FCCD9108E17BF7BA9337A6F8AE9513", 16);
        BigInteger r135 = ECConstants.FOUR;
        ECCurve r136 = configureCurve(new ECCurve.Fp(r131, r133, r134, r132, r135));
        ECDomainParameters r137 = new ECDomainParameters(r136, configureBasepoint(r136, new BigInteger("91E38443A5E82C0D880923425712B2BB658B9196932E02C78B2582FE742DAA28", 16), new BigInteger("32879423AB1A0375895786C4BB46E9565FDE0B5344766740AF268ADB32322E5C", 16)), r132, r135);
        ASN1ObjectIdentifier r138 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetA;
        r101.put(r138, r137);
        BigInteger r139 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC7", 16);
        BigInteger r140 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF27E69532F48D89116FF22B8D4E0560609B4B38ABFAD2B85DCACDB1411F10B275", 16);
        ECCurve r141 = configureCurve(new ECCurve.Fp(r139, new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC4", 16), new BigInteger("E8C2505DEDFC86DDC1BD0B2B6667F1DA34B82574761CB0E879BD081CFD0B6265EE3CB090F30D27614CB4574010DA90DD862EF9D4EBEE4761503190785A71C760", 16), r140, r111));
        ECDomainParameters r142 = new ECDomainParameters(r141, configureBasepoint(r141, new BigInteger("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003"), new BigInteger("7503CFE87A836AE3A61B8816E25450E6CE5E1C93ACF1ABC1778064FDCBEFA921DF1626BE4FD036E93D75E6A50E3A41E98028FE5FC235F5B889A589CB5215F2A4", 16)), r140, r111);
        ASN1ObjectIdentifier r143 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetA;
        r101.put(r143, r142);
        BigInteger r144 = new BigInteger("8000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006F", 16);
        BigInteger r145 = new BigInteger("800000000000000000000000000000000000000000000000000000000000000149A1EC142565A545ACFDB77BD9D40CFA8B996712101BEA0EC6346C54374F25BD", 16);
        ECCurve r146 = configureCurve(new ECCurve.Fp(r144, new BigInteger("8000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006C", 16), new BigInteger("687D1B459DC841457E3E06CF6F5E2517B97C7D614AF138BCBF85DC806C4B289F3E965D2DB1416D217F8B276FAD1AB69C50F78BEE1FA3106EFB8CCBC7C5140116", 16), r145, r111));
        ECDomainParameters r147 = new ECDomainParameters(r146, configureBasepoint(r146, new BigInteger("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002"), new BigInteger("1A8F7EDA389B094C2C071E3647A8940F3C123B697578C213BE6DD9E6C8EC7335DCB228FD1EDF4A39152CBCAAF8C0398828041055F94CEEEC7E21340780FE41BD", 16)), r145, r111);
        ASN1ObjectIdentifier r148 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetB;
        r101.put(r148, r147);
        BigInteger r149 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC7", 16);
        BigInteger r150 = new BigInteger("3FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC98CDBA46506AB004C33A9FF5147502CC8EDA9E7A769A12694623CEF47F023ED", 16);
        ECCurve r151 = configureCurve(new ECCurve.Fp(r149, new BigInteger("DC9203E514A721875485A529D2C722FB187BC8980EB866644DE41C68E143064546E861C0E2C9EDD92ADE71F46FCF50FF2AD97F951FDA9F2A2EB6546F39689BD3", 16), new BigInteger("B4C4EE28CEBC6C2C8AC12952CF37F16AC7EFB6A9F69F4B57FFDA2E4F0DE5ADE038CBC2FFF719D2C18DE0284B8BFEF3B52B8CC7A5F5BF0A3C8D2319A5312557E1", 16), r150, r135));
        ECDomainParameters r152 = new ECDomainParameters(r151, configureBasepoint(r151, new BigInteger("E2E31EDFC23DE7BDEBE241CE593EF5DE2295B7A9CBAEF021D385F7074CEA043AA27272A7AE602BF2A7B9033DB9ED3610C6FB85487EAE97AAC5BC7928C1950148", 16), new BigInteger("F5CE40D95B5EB899ABBCCFF5911CB8577939804D6527378B8C108C3D2090FF9BE18E2D33E3021ED2EF32D85822423B6304F726AA854BAE07D0396E9A9ADDC40F", 16)), r150, r135);
        ASN1ObjectIdentifier r153 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetC;
        r101.put(r153, r152);
        r100.put("GostR3410-2001-CryptoPro-A", r108);
        r100.put("GostR3410-2001-CryptoPro-B", r120);
        r100.put("GostR3410-2001-CryptoPro-C", r130);
        r100.put("GostR3410-2001-CryptoPro-XchA", r115);
        r100.put("GostR3410-2001-CryptoPro-XchB", r125);
        r100.put("Tc26-Gost-3410-12-256-paramSetA", r138);
        r100.put("Tc26-Gost-3410-12-512-paramSetA", r143);
        r100.put("Tc26-Gost-3410-12-512-paramSetB", r148);
        r100.put("Tc26-Gost-3410-12-512-paramSetC", r153);
        r102.put(r108, "GostR3410-2001-CryptoPro-A");
        r102.put(r120, "GostR3410-2001-CryptoPro-B");
        r102.put(r130, "GostR3410-2001-CryptoPro-C");
        r102.put(r115, "GostR3410-2001-CryptoPro-XchA");
        r102.put(r125, "GostR3410-2001-CryptoPro-XchB");
        r102.put(r138, "Tc26-Gost-3410-12-256-paramSetA");
        r102.put(r143, "Tc26-Gost-3410-12-512-paramSetA");
        r102.put(r148, "Tc26-Gost-3410-12-512-paramSetB");
        r102.put(r153, "Tc26-Gost-3410-12-512-paramSetC");
    }

    public ECGOST3410NamedCurves() {
    }

    private static ECPoint configureBasepoint(ECCurve r100, BigInteger r101, BigInteger r102) {
        ECPoint r103 = r100.createPoint(r101, r102);
        WNafUtil.configureBasepoint(r103);
        return r103;
    }

    private static ECCurve configureCurve(ECCurve r100) {
        return r100;
    }

    public static ECDomainParameters getByName(String r100) {
        ASN1ObjectIdentifier r101 = (ASN1ObjectIdentifier) objIds.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return (ECDomainParameters) params.get(r101);
    }

    public static X9ECParameters getByNameX9(String r100) {
        ASN1ObjectIdentifier r101 = (ASN1ObjectIdentifier) objIds.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return getByOIDX9(r101);
    }

    public static ECDomainParameters getByOID(ASN1ObjectIdentifier r100) {
        return (ECDomainParameters) params.get(r100);
    }

    public static X9ECParameters getByOIDX9(ASN1ObjectIdentifier r100) {
        ECDomainParameters r101 = (ECDomainParameters) params.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new X9ECParameters(r101.getCurve(), new X9ECPoint(r101.getG(), false), r101.getN(), r101.getH(), r101.getSeed());
    }

    public static String getName(ASN1ObjectIdentifier r100) {
        return (String) names.get(r100);
    }

    public static Enumeration getNames() {
        return names.elements();
    }

    public static ASN1ObjectIdentifier getOID(String r100) {
        return (ASN1ObjectIdentifier) objIds.get(r100);
    }
}
