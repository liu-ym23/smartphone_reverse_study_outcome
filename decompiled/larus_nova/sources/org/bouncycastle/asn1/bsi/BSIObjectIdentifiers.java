package org.bouncycastle.asn1.bsi;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface BSIObjectIdentifiers {
    public static final ASN1ObjectIdentifier algorithm = null;
    public static final ASN1ObjectIdentifier bsi_de = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_RIPEMD160 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA1 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA224 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA256 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA384 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA512 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_signatures = null;
    public static final ASN1ObjectIdentifier ecka_eg = null;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF = null;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_3DES = null;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES128 = null;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES192 = null;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES256 = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_RIPEMD160 = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA1 = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA224 = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA256 = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA384 = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA512 = null;
    public static final ASN1ObjectIdentifier id_ecc = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        bsi_de = r100;
        ASN1ObjectIdentifier r101 = r100.branch("1.1");
        id_ecc = r101;
        ASN1ObjectIdentifier r102 = r101.branch("4.1");
        ecdsa_plain_signatures = r102;
        ecdsa_plain_SHA1 = r102.branch("1");
        ecdsa_plain_SHA224 = r102.branch("2");
        ecdsa_plain_SHA256 = r102.branch("3");
        ecdsa_plain_SHA384 = r102.branch("4");
        ecdsa_plain_SHA512 = r102.branch("5");
        ecdsa_plain_RIPEMD160 = r102.branch("6");
        algorithm = r100.branch("1");
        ASN1ObjectIdentifier r103 = r101.branch("5.1");
        ecka_eg = r103;
        ASN1ObjectIdentifier r104 = r103.branch("1");
        ecka_eg_X963kdf = r104;
        ecka_eg_X963kdf_SHA1 = r104.branch("1");
        ecka_eg_X963kdf_SHA224 = r104.branch("2");
        ecka_eg_X963kdf_SHA256 = r104.branch("3");
        ecka_eg_X963kdf_SHA384 = r104.branch("4");
        ecka_eg_X963kdf_SHA512 = r104.branch("5");
        ecka_eg_X963kdf_RIPEMD160 = r104.branch("6");
        ASN1ObjectIdentifier r105 = r103.branch("2");
        ecka_eg_SessionKDF = r105;
        ecka_eg_SessionKDF_3DES = r105.branch("1");
        ecka_eg_SessionKDF_AES128 = r105.branch("2");
        ecka_eg_SessionKDF_AES192 = r105.branch("3");
        ecka_eg_SessionKDF_AES256 = r105.branch("4");
    }
}
