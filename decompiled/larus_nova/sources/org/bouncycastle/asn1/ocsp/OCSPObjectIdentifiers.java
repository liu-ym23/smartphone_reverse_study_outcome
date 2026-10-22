package org.bouncycastle.asn1.ocsp;

import com.tencent.connect.common.Constants;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface OCSPObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_pkix_ocsp = null;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_archive_cutoff = null;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_basic = null;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_crl = null;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_extended_revoke = null;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_nocheck = null;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_nonce = null;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_pref_sig_algs = null;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_response = null;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_service_locator = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1");
        id_pkix_ocsp = r100;
        id_pkix_ocsp_basic = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1.1");
        id_pkix_ocsp_nonce = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1.2");
        id_pkix_ocsp_crl = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1.3");
        id_pkix_ocsp_response = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1.4");
        id_pkix_ocsp_nocheck = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1.5");
        id_pkix_ocsp_archive_cutoff = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1.6");
        id_pkix_ocsp_service_locator = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1.7");
        id_pkix_ocsp_pref_sig_algs = r100.branch("8");
        id_pkix_ocsp_extended_revoke = r100.branch(Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
    }
}
