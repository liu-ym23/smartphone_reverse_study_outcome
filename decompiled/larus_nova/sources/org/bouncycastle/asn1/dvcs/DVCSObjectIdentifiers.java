package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface DVCSObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_aa_dvcs_dvc = null;
    public static final ASN1ObjectIdentifier id_ad_dvcs = null;
    public static final ASN1ObjectIdentifier id_ct_DVCSRequestData = null;
    public static final ASN1ObjectIdentifier id_ct_DVCSResponseData = null;
    public static final ASN1ObjectIdentifier id_kp_dvcs = null;
    public static final ASN1ObjectIdentifier id_pkix = null;
    public static final ASN1ObjectIdentifier id_smime = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        id_pkix = r100;
        ASN1ObjectIdentifier r101 = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16");
        id_smime = r101;
        id_ad_dvcs = r100.branch("48.4");
        id_kp_dvcs = r100.branch("3.10");
        id_ct_DVCSRequestData = r101.branch("1.7");
        id_ct_DVCSResponseData = r101.branch("1.8");
        id_aa_dvcs_dvc = r101.branch("2.29");
    }
}
