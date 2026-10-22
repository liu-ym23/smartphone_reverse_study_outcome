package org.bouncycastle.asn1.x509.qualified;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface ETSIQCObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_etsi_qcs_LimiteValue = null;
    public static final ASN1ObjectIdentifier id_etsi_qcs_QcCompliance = null;
    public static final ASN1ObjectIdentifier id_etsi_qcs_QcPds = null;
    public static final ASN1ObjectIdentifier id_etsi_qcs_QcSSCD = null;
    public static final ASN1ObjectIdentifier id_etsi_qcs_QcType = null;
    public static final ASN1ObjectIdentifier id_etsi_qcs_RetentionPeriod = null;
    public static final ASN1ObjectIdentifier id_etsi_qct_eseal = null;
    public static final ASN1ObjectIdentifier id_etsi_qct_esign = null;
    public static final ASN1ObjectIdentifier id_etsi_qct_web = null;

    static {
        id_etsi_qcs_QcCompliance = new ASN1ObjectIdentifier("0.4.0.1862.1.1");
        id_etsi_qcs_LimiteValue = new ASN1ObjectIdentifier("0.4.0.1862.1.2");
        id_etsi_qcs_RetentionPeriod = new ASN1ObjectIdentifier("0.4.0.1862.1.3");
        id_etsi_qcs_QcSSCD = new ASN1ObjectIdentifier("0.4.0.1862.1.4");
        id_etsi_qcs_QcPds = new ASN1ObjectIdentifier("0.4.0.1862.1.5");
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("0.4.0.1862.1.6");
        id_etsi_qcs_QcType = r100;
        id_etsi_qct_esign = r100.branch("1");
        id_etsi_qct_eseal = r100.branch("2");
        id_etsi_qct_web = r100.branch("3");
    }
}
