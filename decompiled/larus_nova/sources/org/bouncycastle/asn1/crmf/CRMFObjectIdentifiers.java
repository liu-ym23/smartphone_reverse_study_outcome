package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public interface CRMFObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_alg = null;
    public static final ASN1ObjectIdentifier id_alg_dh_pop = null;
    public static final ASN1ObjectIdentifier id_ct_encKeyWithID = null;
    public static final ASN1ObjectIdentifier id_dh_sig_hmac_sha1 = null;
    public static final ASN1ObjectIdentifier id_pkip = null;
    public static final ASN1ObjectIdentifier id_pkix = null;
    public static final ASN1ObjectIdentifier id_regCtrl = null;
    public static final ASN1ObjectIdentifier id_regCtrl_authenticator = null;
    public static final ASN1ObjectIdentifier id_regCtrl_pkiArchiveOptions = null;
    public static final ASN1ObjectIdentifier id_regCtrl_pkiPublicationInfo = null;
    public static final ASN1ObjectIdentifier id_regCtrl_regToken = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        id_pkix = r100;
        ASN1ObjectIdentifier r101 = r100.branch("5");
        id_pkip = r101;
        ASN1ObjectIdentifier r102 = r101.branch("1");
        id_regCtrl = r102;
        id_regCtrl_regToken = r102.branch("1");
        id_regCtrl_authenticator = r102.branch("2");
        id_regCtrl_pkiPublicationInfo = r102.branch("3");
        id_regCtrl_pkiArchiveOptions = r102.branch("4");
        id_ct_encKeyWithID = PKCSObjectIdentifiers.id_ct.branch("21");
        ASN1ObjectIdentifier r103 = r100.branch("6");
        id_alg = r103;
        id_dh_sig_hmac_sha1 = r103.branch("3");
        id_alg_dh_pop = r103.branch("4");
    }
}
