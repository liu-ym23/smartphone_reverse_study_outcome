package org.bouncycastle.asn1.x509;

import com.bytedance.bdlocation.exception.BDLocationException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface X509ObjectIdentifiers {
    public static final ASN1ObjectIdentifier commonName = null;
    public static final ASN1ObjectIdentifier countryName = null;
    public static final ASN1ObjectIdentifier crlAccessMethod = null;
    public static final ASN1ObjectIdentifier id_SHA1 = null;
    public static final ASN1ObjectIdentifier id_ad = null;
    public static final ASN1ObjectIdentifier id_ad_caIssuers = null;
    public static final ASN1ObjectIdentifier id_ad_ocsp = null;
    public static final ASN1ObjectIdentifier id_at_name = null;
    public static final ASN1ObjectIdentifier id_at_organizationIdentifier = null;
    public static final ASN1ObjectIdentifier id_at_telephoneNumber = null;
    public static final ASN1ObjectIdentifier id_ce = null;
    public static final ASN1ObjectIdentifier id_ea_rsa = null;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake128 = null;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake256 = null;
    public static final ASN1ObjectIdentifier id_pe = null;
    public static final ASN1ObjectIdentifier id_pkix = null;
    public static final ASN1ObjectIdentifier id_rsassa_pss_shake128 = null;
    public static final ASN1ObjectIdentifier id_rsassa_pss_shake256 = null;
    public static final ASN1ObjectIdentifier localityName = null;
    public static final ASN1ObjectIdentifier ocspAccessMethod = null;
    public static final ASN1ObjectIdentifier organization = null;
    public static final ASN1ObjectIdentifier organizationalUnitName = null;
    public static final ASN1ObjectIdentifier ripemd160 = null;
    public static final ASN1ObjectIdentifier ripemd160WithRSAEncryption = null;
    public static final ASN1ObjectIdentifier stateOrProvinceName = null;

    static {
        commonName = new ASN1ObjectIdentifier("2.5.4.3").intern();
        countryName = new ASN1ObjectIdentifier("2.5.4.6").intern();
        localityName = new ASN1ObjectIdentifier("2.5.4.7").intern();
        stateOrProvinceName = new ASN1ObjectIdentifier("2.5.4.8").intern();
        organization = new ASN1ObjectIdentifier("2.5.4.10").intern();
        organizationalUnitName = new ASN1ObjectIdentifier("2.5.4.11").intern();
        id_at_telephoneNumber = new ASN1ObjectIdentifier("2.5.4.20").intern();
        id_at_name = new ASN1ObjectIdentifier("2.5.4.41").intern();
        id_at_organizationIdentifier = new ASN1ObjectIdentifier("2.5.4.97").intern();
        id_SHA1 = new ASN1ObjectIdentifier("1.3.14.3.2.26").intern();
        ripemd160 = new ASN1ObjectIdentifier("1.3.36.3.2.1").intern();
        ripemd160WithRSAEncryption = new ASN1ObjectIdentifier("1.3.36.3.3.1.2").intern();
        id_ea_rsa = new ASN1ObjectIdentifier("2.5.8.1.1").intern();
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        id_pkix = r100;
        id_rsassa_pss_shake128 = r100.branch("6.30");
        id_rsassa_pss_shake256 = r100.branch("6.31");
        id_ecdsa_with_shake128 = r100.branch("6.32");
        id_ecdsa_with_shake256 = r100.branch("6.33");
        id_pe = r100.branch("1");
        id_ce = new ASN1ObjectIdentifier("2.5.29");
        ASN1ObjectIdentifier r101 = r100.branch(BDLocationException.ERROR_BYTE_NO_CHANGE_WIFI_STATE_PERMISSION);
        id_ad = r101;
        ASN1ObjectIdentifier r102 = r101.branch("2").intern();
        id_ad_caIssuers = r102;
        ASN1ObjectIdentifier r103 = r101.branch("1").intern();
        id_ad_ocsp = r103;
        ocspAccessMethod = r103;
        crlAccessMethod = r102;
    }
}
