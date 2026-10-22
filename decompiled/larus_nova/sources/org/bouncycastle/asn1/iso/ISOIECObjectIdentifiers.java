package org.bouncycastle.asn1.iso;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface ISOIECObjectIdentifiers {
    public static final ASN1ObjectIdentifier hash_algorithms = null;
    public static final ASN1ObjectIdentifier id_ac_generic_hybrid = null;
    public static final ASN1ObjectIdentifier id_kem_rsa = null;
    public static final ASN1ObjectIdentifier is18033_2 = null;
    public static final ASN1ObjectIdentifier iso_encryption_algorithms = null;
    public static final ASN1ObjectIdentifier ripemd128 = null;
    public static final ASN1ObjectIdentifier ripemd160 = null;
    public static final ASN1ObjectIdentifier whirlpool = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.0.10118");
        iso_encryption_algorithms = r100;
        ASN1ObjectIdentifier r101 = r100.branch("3.0");
        hash_algorithms = r101;
        ripemd160 = r101.branch("49");
        ripemd128 = r101.branch("50");
        whirlpool = r101.branch("55");
        ASN1ObjectIdentifier r102 = new ASN1ObjectIdentifier("1.0.18033.2");
        is18033_2 = r102;
        id_ac_generic_hybrid = r102.branch("1.2");
        id_kem_rsa = r102.branch("2.4");
    }
}
