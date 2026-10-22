package org.bouncycastle.jcajce.provider.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class DigestFactory {

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private static Set f525384md5;
    private static Map oids;
    private static Set sha1;
    private static Set sha224;
    private static Set sha256;
    private static Set sha384;
    private static Set sha3_224;
    private static Set sha3_256;
    private static Set sha3_384;
    private static Set sha3_512;
    private static Set sha512;
    private static Set sha512_224;
    private static Set sha512_256;

    static {
        f525384md5 = new HashSet();
        sha1 = new HashSet();
        sha224 = new HashSet();
        sha256 = new HashSet();
        sha384 = new HashSet();
        sha512 = new HashSet();
        sha512_224 = new HashSet();
        sha512_256 = new HashSet();
        sha3_224 = new HashSet();
        sha3_256 = new HashSet();
        sha3_384 = new HashSet();
        sha3_512 = new HashSet();
        oids = new HashMap();
        f525384md5.add("MD5");
        Set r100 = f525384md5;
        ASN1ObjectIdentifier r101 = PKCSObjectIdentifiers.f525058md5;
        r100.add(r101.getId());
        sha1.add("SHA1");
        sha1.add("SHA-1");
        Set r102 = sha1;
        ASN1ObjectIdentifier r103 = OIWObjectIdentifiers.idSHA1;
        r102.add(r103.getId());
        sha224.add("SHA224");
        sha224.add(McElieceCCA2KeyGenParameterSpec.SHA224);
        Set r104 = sha224;
        ASN1ObjectIdentifier r105 = NISTObjectIdentifiers.id_sha224;
        r104.add(r105.getId());
        sha256.add("SHA256");
        sha256.add("SHA-256");
        Set r106 = sha256;
        ASN1ObjectIdentifier r110 = NISTObjectIdentifiers.id_sha256;
        r106.add(r110.getId());
        sha384.add("SHA384");
        sha384.add(McElieceCCA2KeyGenParameterSpec.SHA384);
        Set r107 = sha384;
        ASN1ObjectIdentifier r111 = NISTObjectIdentifiers.id_sha384;
        r107.add(r111.getId());
        sha512.add("SHA512");
        sha512.add("SHA-512");
        Set r108 = sha512;
        ASN1ObjectIdentifier r112 = NISTObjectIdentifiers.id_sha512;
        r108.add(r112.getId());
        sha512_224.add("SHA512(224)");
        sha512_224.add("SHA-512(224)");
        Set r109 = sha512_224;
        ASN1ObjectIdentifier r113 = NISTObjectIdentifiers.id_sha512_224;
        r109.add(r113.getId());
        sha512_256.add("SHA512(256)");
        sha512_256.add("SHA-512(256)");
        Set r114 = sha512_256;
        ASN1ObjectIdentifier r115 = NISTObjectIdentifiers.id_sha512_256;
        r114.add(r115.getId());
        sha3_224.add("SHA3-224");
        Set r116 = sha3_224;
        ASN1ObjectIdentifier r117 = NISTObjectIdentifiers.id_sha3_224;
        r116.add(r117.getId());
        sha3_256.add("SHA3-256");
        Set r118 = sha3_256;
        ASN1ObjectIdentifier r119 = NISTObjectIdentifiers.id_sha3_256;
        r118.add(r119.getId());
        sha3_384.add("SHA3-384");
        Set r120 = sha3_384;
        ASN1ObjectIdentifier r121 = NISTObjectIdentifiers.id_sha3_384;
        r120.add(r121.getId());
        sha3_512.add("SHA3-512");
        Set r122 = sha3_512;
        ASN1ObjectIdentifier r123 = NISTObjectIdentifiers.id_sha3_512;
        r122.add(r123.getId());
        oids.put("MD5", r101);
        oids.put(r101.getId(), r101);
        oids.put("SHA1", r103);
        oids.put("SHA-1", r103);
        oids.put(r103.getId(), r103);
        oids.put("SHA224", r105);
        oids.put(McElieceCCA2KeyGenParameterSpec.SHA224, r105);
        oids.put(r105.getId(), r105);
        oids.put("SHA256", r110);
        oids.put("SHA-256", r110);
        oids.put(r110.getId(), r110);
        oids.put("SHA384", r111);
        oids.put(McElieceCCA2KeyGenParameterSpec.SHA384, r111);
        oids.put(r111.getId(), r111);
        oids.put("SHA512", r112);
        oids.put("SHA-512", r112);
        oids.put(r112.getId(), r112);
        oids.put("SHA512(224)", r113);
        oids.put("SHA-512(224)", r113);
        oids.put(r113.getId(), r113);
        oids.put("SHA512(256)", r115);
        oids.put("SHA-512(256)", r115);
        oids.put(r115.getId(), r115);
        oids.put("SHA3-224", r117);
        oids.put(r117.getId(), r117);
        oids.put("SHA3-256", r119);
        oids.put(r119.getId(), r119);
        oids.put("SHA3-384", r121);
        oids.put(r121.getId(), r121);
        oids.put("SHA3-512", r123);
        oids.put(r123.getId(), r123);
    }

    public DigestFactory() {
    }

    public static Digest getDigest(String r100) {
        String r101 = Strings.toUpperCase(r100);
        if (sha1.contains(r101) == false) goto L7;
        return org.bouncycastle.crypto.util.DigestFactory.createSHA1();
    L7:
        if (f525384md5.contains(r101) == false) goto L11;
        return org.bouncycastle.crypto.util.DigestFactory.createMD5();
    L11:
        if (sha224.contains(r101) == false) goto L15;
        return org.bouncycastle.crypto.util.DigestFactory.createSHA224();
    L15:
        if (sha256.contains(r101) == false) goto L19;
        return org.bouncycastle.crypto.util.DigestFactory.createSHA256();
    L19:
        if (sha384.contains(r101) == false) goto L23;
        return org.bouncycastle.crypto.util.DigestFactory.createSHA384();
    L23:
        if (sha512.contains(r101) == false) goto L27;
        return org.bouncycastle.crypto.util.DigestFactory.createSHA512();
    L27:
        if (sha512_224.contains(r101) == false) goto L31;
        return org.bouncycastle.crypto.util.DigestFactory.createSHA512_224();
    L31:
        if (sha512_256.contains(r101) == false) goto L35;
        return org.bouncycastle.crypto.util.DigestFactory.createSHA512_256();
    L35:
        if (sha3_224.contains(r101) == false) goto L39;
        return org.bouncycastle.crypto.util.DigestFactory.createSHA3_224();
    L39:
        if (sha3_256.contains(r101) == false) goto L43;
        return org.bouncycastle.crypto.util.DigestFactory.createSHA3_256();
    L43:
        if (sha3_384.contains(r101) == false) goto L47;
        return org.bouncycastle.crypto.util.DigestFactory.createSHA3_384();
    L47:
        if (sha3_512.contains(r101) == true) goto L49;
        return null;
    L49:
        return org.bouncycastle.crypto.util.DigestFactory.createSHA3_512();
    }

    public static ASN1ObjectIdentifier getOID(String r100) {
        return (ASN1ObjectIdentifier) oids.get(r100);
    }

    public static boolean isSameDigest(String r100, String r101) {
        if (sha1.contains(r100) == false) goto L7;
        if (sha1.contains(r101) == false) goto L7;
    L50:
        return true;
    L7:
        if (sha224.contains(r100) == false) goto L11;
        if (sha224.contains(r101) == true) goto L50;
    L11:
        if (sha256.contains(r100) == false) goto L15;
        if (sha256.contains(r101) == true) goto L50;
    L15:
        if (sha384.contains(r100) == false) goto L19;
        if (sha384.contains(r101) == true) goto L50;
    L19:
        if (sha512.contains(r100) == false) goto L23;
        if (sha512.contains(r101) == true) goto L50;
    L23:
        if (sha512_224.contains(r100) == false) goto L27;
        if (sha512_224.contains(r101) == true) goto L50;
    L27:
        if (sha512_256.contains(r100) == false) goto L31;
        if (sha512_256.contains(r101) == true) goto L50;
    L31:
        if (sha3_224.contains(r100) == false) goto L35;
        if (sha3_224.contains(r101) == true) goto L50;
    L35:
        if (sha3_256.contains(r100) == false) goto L39;
        if (sha3_256.contains(r101) == true) goto L50;
    L39:
        if (sha3_384.contains(r100) == false) goto L43;
        if (sha3_384.contains(r101) == true) goto L50;
    L43:
        if (sha3_512.contains(r100) == false) goto L47;
        if (sha3_512.contains(r101) == true) goto L50;
    L47:
        if (f525384md5.contains(r100) == true) goto L49;
    L51:
        return false;
    L49:
        if (f525384md5.contains(r101) == false) goto L51;
        goto L50
    }
}
