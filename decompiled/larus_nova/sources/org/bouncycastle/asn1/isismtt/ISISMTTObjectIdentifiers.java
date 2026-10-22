package org.bouncycastle.asn1.isismtt;

import com.tencent.connect.common.Constants;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface ISISMTTObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_isismtt = null;
    public static final ASN1ObjectIdentifier id_isismtt_at = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_PKReference = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_additionalInformation = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_admission = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_certHash = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_certInDirSince = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_dateOfCertGen = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_declarationOfMajority = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_iCCSN = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_liabilityLimitationFlag = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_monetaryLimit = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_nameAtBirth = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_namingAuthorities = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_procuration = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_requestedCertificate = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_restriction = null;
    public static final ASN1ObjectIdentifier id_isismtt_at_retrieveIfAllowed = null;
    public static final ASN1ObjectIdentifier id_isismtt_cp = null;
    public static final ASN1ObjectIdentifier id_isismtt_cp_accredited = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.36.8");
        id_isismtt = r100;
        ASN1ObjectIdentifier r101 = r100.branch("1");
        id_isismtt_cp = r101;
        id_isismtt_cp_accredited = r101.branch("1");
        ASN1ObjectIdentifier r102 = r100.branch("3");
        id_isismtt_at = r102;
        id_isismtt_at_dateOfCertGen = r102.branch("1");
        id_isismtt_at_procuration = r102.branch("2");
        id_isismtt_at_admission = r102.branch("3");
        id_isismtt_at_monetaryLimit = r102.branch("4");
        id_isismtt_at_declarationOfMajority = r102.branch("5");
        id_isismtt_at_iCCSN = r102.branch("6");
        id_isismtt_at_PKReference = r102.branch("7");
        id_isismtt_at_restriction = r102.branch("8");
        id_isismtt_at_retrieveIfAllowed = r102.branch(Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
        id_isismtt_at_requestedCertificate = r102.branch(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        id_isismtt_at_namingAuthorities = r102.branch("11");
        id_isismtt_at_certInDirSince = r102.branch("12");
        id_isismtt_at_certHash = r102.branch("13");
        id_isismtt_at_nameAtBirth = r102.branch(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
        id_isismtt_at_additionalInformation = r102.branch(Constants.VIA_REPORT_TYPE_WPA_STATE);
        id_isismtt_at_liabilityLimitationFlag = new ASN1ObjectIdentifier("0.2.262.1.10.12.0");
    }
}
