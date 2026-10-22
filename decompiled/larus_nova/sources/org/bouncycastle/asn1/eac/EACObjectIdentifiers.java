package org.bouncycastle.asn1.eac;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface EACObjectIdentifiers {
    public static final ASN1ObjectIdentifier bsi_de = null;
    public static final ASN1ObjectIdentifier id_CA = null;
    public static final ASN1ObjectIdentifier id_CA_DH = null;
    public static final ASN1ObjectIdentifier id_CA_DH_3DES_CBC_CBC = null;
    public static final ASN1ObjectIdentifier id_CA_ECDH = null;
    public static final ASN1ObjectIdentifier id_CA_ECDH_3DES_CBC_CBC = null;
    public static final ASN1ObjectIdentifier id_EAC_ePassport = null;
    public static final ASN1ObjectIdentifier id_PK = null;
    public static final ASN1ObjectIdentifier id_PK_DH = null;
    public static final ASN1ObjectIdentifier id_PK_ECDH = null;
    public static final ASN1ObjectIdentifier id_TA = null;
    public static final ASN1ObjectIdentifier id_TA_ECDSA = null;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_1 = null;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_224 = null;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_256 = null;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_384 = null;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_512 = null;
    public static final ASN1ObjectIdentifier id_TA_RSA = null;
    public static final ASN1ObjectIdentifier id_TA_RSA_PSS_SHA_1 = null;
    public static final ASN1ObjectIdentifier id_TA_RSA_PSS_SHA_256 = null;
    public static final ASN1ObjectIdentifier id_TA_RSA_PSS_SHA_512 = null;
    public static final ASN1ObjectIdentifier id_TA_RSA_v1_5_SHA_1 = null;
    public static final ASN1ObjectIdentifier id_TA_RSA_v1_5_SHA_256 = null;
    public static final ASN1ObjectIdentifier id_TA_RSA_v1_5_SHA_512 = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        bsi_de = r100;
        ASN1ObjectIdentifier r101 = r100.branch("2.2.1");
        id_PK = r101;
        id_PK_DH = r101.branch("1");
        id_PK_ECDH = r101.branch("2");
        ASN1ObjectIdentifier r102 = r100.branch("2.2.3");
        id_CA = r102;
        ASN1ObjectIdentifier r103 = r102.branch("1");
        id_CA_DH = r103;
        id_CA_DH_3DES_CBC_CBC = r103.branch("1");
        ASN1ObjectIdentifier r104 = r102.branch("2");
        id_CA_ECDH = r104;
        id_CA_ECDH_3DES_CBC_CBC = r104.branch("1");
        ASN1ObjectIdentifier r105 = r100.branch("2.2.2");
        id_TA = r105;
        ASN1ObjectIdentifier r106 = r105.branch("1");
        id_TA_RSA = r106;
        id_TA_RSA_v1_5_SHA_1 = r106.branch("1");
        id_TA_RSA_v1_5_SHA_256 = r106.branch("2");
        id_TA_RSA_PSS_SHA_1 = r106.branch("3");
        id_TA_RSA_PSS_SHA_256 = r106.branch("4");
        id_TA_RSA_v1_5_SHA_512 = r106.branch("5");
        id_TA_RSA_PSS_SHA_512 = r106.branch("6");
        ASN1ObjectIdentifier r107 = r105.branch("2");
        id_TA_ECDSA = r107;
        id_TA_ECDSA_SHA_1 = r107.branch("1");
        id_TA_ECDSA_SHA_224 = r107.branch("2");
        id_TA_ECDSA_SHA_256 = r107.branch("3");
        id_TA_ECDSA_SHA_384 = r107.branch("4");
        id_TA_ECDSA_SHA_512 = r107.branch("5");
        id_EAC_ePassport = r100.branch("3.1.2.1");
    }
}
